"""Ordered code transformation rules: each is fn(relpath, text) -> text."""
import os
import re

SKIP = set()
RULES = []


HEADER_RE = re.compile(r'\A(?:\s*/\*.*?\*/|\s*//[^\n]*\n|\s*(?:package|import)\b[^\n]*\n|\s*\n)*', re.S)


def split_header(text):
    m = HEADER_RE.match(text)
    return text[:m.end()], text[m.end():]


def sub(pattern, repl, flags=0):
    rx = re.compile(pattern, flags)

    def rule(path, text):
        head, body = split_header(text)
        return head + rx.sub(repl, body)
    RULES.append(rule)


def find_block(text, start):
    """Index just past the '}' matching the first '{' at/after start (string/char literals aware)."""
    i = text.index('{', start)
    depth = 0
    in_str = None
    while True:
        c = text[i]
        if in_str:
            if c == '\\':
                i += 1
            elif c == in_str:
                in_str = None
        elif c == '/' and text.startswith('//', i):
            i = text.find('\n', i)
            continue
        elif c == '/' and text.startswith('/*', i):
            i = text.find('*/', i) + 2
            continue
        elif c in '"\'':
            in_str = c
        elif c == '{':
            depth += 1
        elif c == '}':
            depth -= 1
            if depth == 0:
                return i + 1
        i += 1


def scan_chain(text, i):
    """From i, skip a chain of .method(...) calls with balanced parentheses; returns the index after the chain."""
    while True:
        k = i
        while text[k] in ' \t\n':
            k += 1
        if text[k] != '.':
            return i
        i = k
        j = text.index('(', i)
        depth = 0
        while True:
            c = text[j]
            if c == '(':
                depth += 1
            elif c == ')':
                depth -= 1
                if depth == 0:
                    break
            elif c == '"':
                j = text.index('"', j + 1)
            j += 1
        i = j + 1


ELEMENT_RE = re.compile(r'public static class \w+ extends NarutoShippudenModElements\.ModElement \{')


def for_each_element(text, fn):
    out = []
    pos = 0
    for m in ELEMENT_RE.finditer(text):
        if m.start() < pos:
            continue
        end = find_block(text, m.start())
        out.append(text[pos:m.start()])
        out.append(fn(text[m.start():end]))
        pos = end
    out.append(text[pos:])
    return ''.join(out)


def func(f):
    def rule(path, text):
        head, body = split_header(text)
        return head + f(path, body)
    RULES.append(rule)
    return f


# ---------------------------------------------------------------- text / identifiers
sub(r'\.setCustomClientFactory\([\w:]+\)', '')
sub(r'new Component\(', 'Component.literal(')
sub(r'new TranslatableComponent\(', 'Component.translatable(')
sub(r'new Identifier\(("[^"]*")\)', r'Identifier.parse(\1)')
sub(r'new Identifier\(([^,()]+(?:\([^()]*\))?), ([^()]+?)\)', r'Identifier.fromNamespaceAndPath(\1, \2)')
sub(r'new Identifier\(', 'Identifier.parse(')

# ---------------------------------------------------------------- Entity fields that became methods
# .level (field) -> .level(), but keep Minecraft.getInstance().level / mc.level (ClientLevel field)
sub(r'(?<!getInstance\(\))(?<!\bmc)(?<!\bminecraft)\.level\b(?!\s*\()(?!\s*=[^=])', '.level()')
sub(r'\.isClientSide\b(?!\()', '.isClientSide()')
sub(r'(\b[\w.()]+?)\.yRot\s*=\s*([^;]+);', r'\1.setYRot(\2);')
sub(r'(\b[\w.()]+?)\.xRot\s*=\s*([^;]+);', r'\1.setXRot(\2);')
sub(r'(?<![\w])(\w+(?:\.\w+\(\))*)\.yRot\b(?!\s*=)', lambda m: m.group(1) + ('.getYRot()' if not m.group(1).startswith('this.') or '(' in m.group(1) else '.yRot'))
sub(r'(?<![\w])(\w+(?:\.\w+\(\))*)\.xRot\b(?!\s*=)', lambda m: m.group(1) + ('.getXRot()' if not m.group(1).startswith('this.') or '(' in m.group(1) else '.xRot'))
sub(r'\.inventory\b(?!\()', '.getInventory()')
sub(r'\.moveTo\(', '.snapTo(')
sub(r'\.setSecondsOnFire\(', '.igniteForSeconds(')
sub(r'\.getTileData\(\)', '.getPersistentData()')
sub(r'\.remove\(\)', '.discard()')
sub(r'\.getSharedSpawnPos\(\)', '.getRespawnData().pos()')

# ---------------------------------------------------------------- NBT getters return Optional now
for t, d in [('Double', '0'), ('Boolean', 'false'), ('String', '""'), ('Int', '0'), ('Float', '0'), ('Long', '0'), ('Short', '(short) 0'),
             ('Byte', '(byte) 0')]:
    sub(r'\.get%s\(("[^"]*"|[^(),]+)\)' % t, lambda m, t=t, d=d: '.get%sOr(%s, %s)' % (t, m.group(1), d))
sub(r'\.getCompound\(', '.getCompoundOrEmpty(')

# ---------------------------------------------------------------- randomness
sub(r'new Random\(\)', 'RandomSource.create()')
sub(r'\bimport java\.util\.Random;', 'import net.minecraft.util.RandomSource;')

# ---------------------------------------------------------------- cooldowns take ItemStacks
sub(r'getCooldowns\(\)\.addCooldown\(([\w.]+), ', r'getCooldowns().addCooldown(new ItemStack(\1), ')
sub(r'getCooldowns\(\)\.isOnCooldown\(([\w.]+)\)', r'getCooldowns().isOnCooldown(new ItemStack(\1))')

# ---------------------------------------------------------------- effects
EFFECTS = {'MOVEMENT_SLOWDOWN': 'SLOWNESS', 'MOVEMENT_SPEED': 'SPEED', 'DAMAGE_BOOST': 'STRENGTH', 'DAMAGE_RESISTANCE': 'RESISTANCE',
           'JUMP': 'JUMP_BOOST', 'CONFUSION': 'NAUSEA', 'DIG_SPEED': 'HASTE', 'DIG_SLOWDOWN': 'MINING_FATIGUE', 'HEAL': 'INSTANT_HEALTH',
           'HARM': 'INSTANT_DAMAGE'}
sub(r'MobEffects\.(' + '|'.join(EFFECTS) + r')\b', lambda m: 'MobEffects.' + EFFECTS[m.group(1)])

# ---------------------------------------------------------------- damage sources
DAMAGE = {'GENERIC': 'generic', 'FALL': 'fall', 'LIGHTNING_BOLT': 'lightningBolt', 'WITHER': 'wither', 'DROWN': 'drown',
          'CACTUS': 'cactus', 'DRAGON_BREATH': 'dragonBreath', 'ANVIL': 'fallingBlock(null)', 'MAGIC': 'magic', 'IN_FIRE': 'inFire',
          'ON_FIRE': 'onFire', 'LAVA': 'lava', 'STARVE': 'starve', 'OUT_OF_WORLD': 'fellOutOfWorld', 'FLY_INTO_WALL': 'flyIntoWall',
          'SWEET_BERRY_BUSH': 'sweetBerryBush', 'HOT_FLOOR': 'hotFloor', 'IN_WALL': 'inWall', 'CRAMMING': 'cramming', 'FREEZE': 'freeze'}


@func
def damage_sources(path, text):
    def repl(m):
        call = DAMAGE[m.group(1)]
        return 'Compat.damage().' + (call if '(' in call else call + '()')
    return re.sub(r'\bDamageSource\.(' + '|'.join(DAMAGE) + r')\b', repl, text)


# ---------------------------------------------------------------- registries
REG = {'SOUND_EVENTS': 'SOUND_EVENT', 'ITEMS': 'ITEM', 'BLOCKS': 'BLOCK', 'ENTITIES': 'ENTITY_TYPE', 'POTIONS': 'MOB_EFFECT',
       'PARTICLE_TYPES': 'PARTICLE_TYPE', 'ENCHANTMENTS': 'ENCHANTMENT', 'POTION_TYPES': 'POTION', 'ATTRIBUTES': 'ATTRIBUTE',
       'CONTAINERS': 'MENU'}
sub(r'BuiltInRegistries\.(' + '|'.join(REG) + r')\b', lambda m: 'BuiltInRegistries.' + REG[m.group(1)])

# ---------------------------------------------------------------- misc
sub(r'\bItemHandlerHelper\.giveItemToPlayer\(', 'Compat.giveItemToPlayer(')
sub(r'InteractionResult\.sidedSuccess\(([^()]+)\)', r'InteractionResult.SUCCESS')



# ---------------------------------------------------------------- batch 2
# chat vs action-bar messages
sub(r'\.displayClientMessage\(((?:"(?:[^"\\]|\\.)*"|[^;"])+?),\s*\(?true\)?\);', r'.sendOverlayMessage(\1);', re.S)
sub(r'\.displayClientMessage\(((?:"(?:[^"\\]|\\.)*"|[^;"])+?),\s*\(?false\)?\);', r'.sendSystemMessage(\1);', re.S)
# commands
sub(r'(\b[\w.()]+?)\.level\(\)\.getServer\(\)\.getCommands\(\)\.performCommand\(\s*\1\.createCommandSourceStack\(\)\.withSuppressedOutput\(\)\.withPermission\(4\),\s*', r'Compat.runCommand(\1, ')
sub(r'(\b[\w.()]+?)\.getServer\(\)\.getCommands\(\)\.performCommand\(\s*new CommandSourceStack\(CommandSource\.NULL, new Vec3\(([^()]*)\), Vec2\.ZERO, \(ServerLevel\) \w+, 4, "",\s*Component\.literal\(""\), \w+\.getServer\(\), null\)\.withSuppressedOutput\(\),\s*', r'Compat.runCommandAt(\1, \2, ')
# player fields
sub(r'\.abilities\b(?!\()', '.getAbilities()')
sub(r'\.getAbilities\(\)\.flying\b', '.getAbilities().flying')
# tags: X.getAllTags().getTagOrEmpty(id).contains(v)
sub(r'BlockTags\.getAllTags\(\)\.getTagOrEmpty\(([^()]*\([^()]*\))\)\.contains\(([^()]*(?:\([^()]*\))*)\)', r'Compat.blockHasTag(\2, \1)')
sub(r'ItemTags\.getAllTags\(\)\.getTagOrEmpty\(([^()]*\([^()]*\))\)\.contains\(([^()]*(?:\([^()]*\))*)\)', r'Compat.itemHasTag(\2, \1)')
sub(r'EntityTypeTags\.getAllTags\(\)\.getTagOrEmpty\(([^()]*\([^()]*\))\)\.contains\(([^()]*(?:\([^()]*\))*)\)', r'Compat.entityHasTag(\2, \1)')
# dimensions
sub(r'Registry\.DIMENSION_REGISTRY', 'Registries.DIMENSION')
sub(r'Registry\.ITEM_REGISTRY', 'Registries.ITEM')
sub(r'Registry\.BLOCK_REGISTRY', 'Registries.BLOCK')
sub(r'Registry\.ENTITY_TYPE_REGISTRY', 'Registries.ENTITY_TYPE')
sub(r'Registry\.BIOME_REGISTRY', 'Registries.BIOME')
# damage source checks
sub(r'(\w+)\.isExplosion\(\)', r'\1.is(net.minecraft.tags.DamageTypeTags.IS_EXPLOSION)')
sub(r'(\w+)\.isFire\(\)', r'\1.is(net.minecraft.tags.DamageTypeTags.IS_FIRE)')
sub(r'(\w+)\.isProjectile\(\)', r'\1.is(net.minecraft.tags.DamageTypeTags.IS_PROJECTILE)')
sub(r'(\w+)\.isMagic\(\)', r'\1.is(net.minecraft.tags.DamageTypeTags.WITCH_RESISTANT_TO)')
sub(r'(\w+)\.getMsgId\(\)', r'\1.getMsgId()')
# item stack custom data
def receiver_start(text, end):
    """Start index of the expression whose member access ends at `end` (the index of the '.')."""
    i = end
    while True:
        k = i
        while k > 0 and text[k - 1] in ' \t\n':
            k -= 1
        if k > 0 and text[k - 1] == ')':
            depth = 0
            j = k - 1
            while True:
                c = text[j]
                if c == ')':
                    depth += 1
                elif c == '(':
                    depth -= 1
                    if depth == 0:
                        break
                j -= 1
            i = j
            if j > 0 and (text[j - 1].isalnum() or text[j - 1] == '_'):
                continue
            k2 = j
            while k2 > 0 and text[k2 - 1] in ' \t\n':
                k2 -= 1
            if k2 > 0 and text[k2 - 1] == '.':
                i = k2 - 1
                continue
            return i
        elif k > 0 and (text[k - 1].isalnum() or text[k - 1] == '_'):
            j = k
            while j > 0 and (text[j - 1].isalnum() or text[j - 1] == '_'):
                j -= 1
            i = j
            k2 = j
            while k2 > 0 and text[k2 - 1] in ' \t\n':
                k2 -= 1
            if k2 > 0 and text[k2 - 1] == '.':
                i = k2 - 1
                continue
            if text[max(0, i - 4):i] == 'new ':
                i -= 4
            return i
        else:
            return i


@func
def stack_tags(path, text):
    rx = re.compile(r'\s*\.(?:getOrCreateTag|getTag)\(\)')
    while True:
        m = rx.search(text)
        if not m:
            return text
        st = receiver_start(text, m.start())
        text = text[:st] + 'StackTag.of(' + text[st:m.start()] + ')' + text[m.end():]
# inventory removal: clearOrCountMatchingItems(pred, count, craftingInventory)
sub(r'\.clearOrCountMatchingItems\(([^;]*?), \(int\) ([^,;]+?), \(\(Player\) \w+\)\.inventoryMenu\.getCraftSlots\(\)\)', r'.clearOrCountMatchingItems(\1, (int) \2, ((Player) entity).inventoryMenu.getCraftSlots())')
# position helpers
sub(r'new BlockPos\((\w+)\.blockPosition\(\)\)', r'\1.blockPosition()')
sub(r'new BlockPos\(\(int\) ([^,]+?), \(int\) ([^,]+?), \(int\) ([^()]+?)\)', r'BlockPos.containing(\1, \2, \3)')
sub(r'new BlockPos\(([^()]*?(?:\([^()]*\))?[^()]*?), ([^()]*?(?:\([^()]*\))?[^()]*?), ([^()]*?(?:\([^()]*\))?[^()]*?)\)', r'BlockPos.containing(\1, \2, \3)')
# walk animation (mobs animating their own legs)
sub(r'this\.animationSpeedOld = this\.animationSpeed;', '')
sub(r'this\.animationSpeed \+= \(([^;]+?) - this\.animationSpeed\) \* 0\.4F;', r'this.walkAnimation.update(\1, 0.4F, 1.0F);')
sub(r'this\.animationPosition \+= this\.animationSpeed;', '')
sub(r'this\.flyingSpeed = ([^;]+);', r'// flying speed now comes from the movement attribute: \1')
sub(r'this\.maxUpStep = ([^;]+);', r'// step height is the STEP_HEIGHT attribute now: \1')


# ---------------------------------------------------------------- tick events
sub(r'TickEvent\.ServerTickEvent event\)', 'ServerTickEvent.Post event)')
sub(r'TickEvent\.PlayerTickEvent event\)', 'PlayerTickEvent.Post event)')
sub(r'TickEvent\.ClientTickEvent event\)', 'ClientTickEvent.Post event)')
sub(r'TickEvent\.WorldTickEvent event\)', 'LevelTickEvent.Post event)')
sub(r'event\.phase == TickEvent\.Phase\.END', 'true')
sub(r'event\.phase != TickEvent\.Phase\.END', 'false')
sub(r'\bevent\.player\b', 'event.getEntity()')
sub(r'\bevent\.world\b', 'event.getLevel()')


# ---------------------------------------------------------------- registration: @ObjectHolder fields -> Registration.holder
HOLDER_REGISTRY = {'Item': 'ITEM', 'Block': 'BLOCK', 'EntityType': 'ENTITY_TYPE', 'BlockEntityType': 'BLOCK_ENTITY_TYPE',
                   'MobEffect': 'MOB_EFFECT', 'SimpleParticleType': 'PARTICLE_TYPE', 'ParticleType': 'PARTICLE_TYPE', 'MenuType': 'MENU',
                   'SoundEvent': 'SOUND_EVENT', 'Enchantment': 'ENCHANTMENT'}


@func
def object_holders(path, text):
    def repl(m):
        ind, name, typ, field = m.group(2), m.group(1), m.group(3), m.group(4)
        reg = HOLDER_REGISTRY.get(typ.split('<')[0], 'ITEM')
        return '%spublic static %s %s;\n%sstatic {\n%s\tRegistration.holder(Registries.%s, "%s", v -> %s = (%s) v);\n%s}' % (
            ind, typ, field, ind, ind, reg, name, field, typ, ind)
    return re.sub(r'@ObjectHolder\("naruto_shippuden:(\w+)"\)\s*\n(\s*)public static final ([\w.]+(?:<[^>]*>)?) (\w+) = null;', repl, text)


def props_call(name, chain):
    """Registration.itemProps(name, tab) + remaining builder chain without .tab(...)."""
    tab = re.search(r'\.tab\(([\w.]+)\)', chain)
    tabname = 'null'
    if tab and tab.group(1) != 'null':
        tabname = '"%s"' % tab.group(1).split('.')[0]
    chain = re.sub(r'\.tab\([\w.]+\)', '', chain)
    return 'Registration.itemProps("%s", %s)%s' % (name, tabname, chain)


# item classes: super(new Item.Properties()...); setRegistryName("x");
sub(r'super\(new Item\.Properties\(\)((?:(?!\);).)*?)\);\s*setRegistryName\("(\w+)"\);',
    lambda m: 'super(%s);' % props_call(m.group(2), m.group(1)), re.S)

# swords: new SwordItem(new ToolMaterial() {...}, dmg, speed, new Item.Properties()...) {...}.setRegistryName("x")
@func
def swords(path, text):
    out = []
    pos = 0
    for m in re.finditer(r'new SwordItem\(new ToolMaterial\(\) \{', text):
        if m.start() < pos:
            continue
        mat_end = find_block(text, m.start() + len('new SwordItem(new ToolMaterial() '))
        mat = text[m.end():mat_end]
        def val(method):
            mm = re.search(r'%s\(\) \{\s*return ([^;]+);' % method, mat)
            return mm.group(1) if mm else '0'
        rest = re.match(r', ([-\d.f]+), ([-\d.f]+), new Item\.Properties\(\)', text[mat_end:])
        dmg, speed = rest.groups()
        chain_start = mat_end + rest.end()
        chain_end = scan_chain(text, chain_start)
        chain = text[chain_start:chain_end]
        assert text[chain_end] == ')', text[chain_start:chain_end + 20]
        body_start = chain_end + 1
        if text[body_start:body_start + 2] == ' {':
            body_end = find_block(text, body_start)
        else:
            body_end = body_start
        tail = re.match(r'\s*\.setRegistryName\("(\w+)"\)', text[body_end:])
        name = tail.group(1)
        material = 'new ToolMaterial(net.minecraft.tags.BlockTags.INCORRECT_FOR_WOODEN_TOOL, %s, %s, %s, %s, net.minecraft.tags.ItemTags.WOODEN_TOOL_MATERIALS)' % (
            val('getUses'), val('getSpeed'), val('getAttackDamageBonus'),
            # 26.3 rejects an enchantability of 0
            '1' if val('getEnchantmentValue').strip() in ('0', '(int) 0') else val('getEnchantmentValue'))
        props = props_call(name, '.sword(%s, %s, %s)' % (material, dmg, speed) + chain)
        out.append(text[pos:m.start()])
        out.append('new Item(%s)%s' % (props, text[body_start:body_end]))
        pos = body_end + tail.end()
    out.append(text[pos:])
    return ''.join(out)


# block items / spawn eggs: parse the property chain with balanced parentheses
def rewrite_props(text, prefix_re, make):
    out = []
    pos = 0
    for m in re.finditer(prefix_re, text):
        if m.start() < pos:
            continue
        chain_start = m.end()
        chain_end = scan_chain(text, chain_start)
        res = make(m, text[chain_start:chain_end], text, chain_end)
        if res is None:
            continue
        repl, consumed_to = res
        out.append(text[pos:m.start()])
        out.append(repl)
        pos = consumed_to
    out.append(text[pos:])
    return ''.join(out)


@func
def block_items(path, text):
    def per_element(block):
        holder = re.search(r'Registration\.holder\((?:Registries\.\w+, )?"(\w+)"', block)
        if not holder:
            return block
        name = holder.group(1)

        def make(m, chain, t, i):
            tail = re.match(r'\)\)?\.setRegistryName\(block\.getRegistryName\(\)\)', t[i:])
            if not tail:
                return None
            return 'new BlockItem(block, %s.useBlockDescriptionPrefix())' % props_call(name, chain), i + tail.end()
        return rewrite_props(block, r'new BlockItem\(block, new Item\.Properties\(\)', make)
    return for_each_element(text, per_element)


@func
def spawn_eggs(path, text):
    def make(m, chain, t, i):
        tail = re.match(r'\)\s*\)?\s*\.setRegistryName\("(\w+)"\)', t[i:])
        if not tail:
            return None
        return 'new SpawnEggItem(%s.spawnEgg(%s))' % (props_call(tail.group(1), chain), m.group(1)), i + tail.end()
    return rewrite_props(text, r'new SpawnEggItem\((\w+), -?\d+, -?\d+, new Item\.Properties\(\)', make)


# ---------------------------------------------------------------- Item method signatures
def method_blocks(text, signature_re, fn):
    """Apply fn(header_match, body_text) -> replacement for each method whose header matches signature_re."""
    out = []
    pos = 0
    for m in re.finditer(signature_re, text):
        if m.start() < pos:
            continue
        end = find_block(text, m.start())
        out.append(text[pos:m.start()])
        out.append(fn(m, text[m.end():end]))
        pos = end
    out.append(text[pos:])
    return ''.join(out)


sub(r'InteractionResult<ItemStack>', 'InteractionResult')
sub(r'\bar\.getObject\(\)', 'entity.getItemInHand(hand)')
sub(r'new InteractionResult\(InteractionResult\.(\w+), [^;()]*\)', r'InteractionResult.\1')
sub(r'InteractionResult\.success\([^;()]*\)', 'InteractionResult.SUCCESS')
sub(r'InteractionResult\.fail\([^;()]*\)', 'InteractionResult.FAIL')
sub(r'InteractionResult\.pass\([^;()]*\)', 'InteractionResult.PASS')
sub(r'InteractionResult\.consume\([^;()]*\)', 'InteractionResult.CONSUME')


@func
def item_methods(path, text):
    def hover(m, body):
        body = body.replace('super.appendHoverText(%s, %s, %s, %s);' % m.groups(), 'super.appendHoverText(%s, %s, display, %s, %s);' % m.groups())
        body = re.sub(r'\b%s\.add\(' % m.group(3), '%s.accept(' % m.group(3), body)
        return ('public void appendHoverText(ItemStack %s, Item.TooltipContext %s, net.minecraft.world.item.component.TooltipDisplay display, '
                'java.util.function.Consumer<Component> %s, TooltipFlag %s) {' % m.groups()) + body
    text = method_blocks(text, r'public void appendHoverText\(ItemStack (\w+), Level (\w+), List<Component> (\w+), TooltipFlag (\w+)\)\s*\{', hover)

    def tick(m, body):
        stack, world, ent, slot, sel = m.groups()
        body = body.replace('super.inventoryTick(%s, %s, %s, %s, %s);' % m.groups(), 'super.inventoryTick(%s, %s, %s, equipmentSlot);' % (stack, world, ent))
        return ('public void inventoryTick(ItemStack %s, ServerLevel %s, Entity %s, net.minecraft.world.entity.EquipmentSlot equipmentSlot) {\n'
                '\t\t\t\tint %s = 0;\n\t\t\t\tboolean %s = equipmentSlot == net.minecraft.world.entity.EquipmentSlot.MAINHAND;' % (stack, world, ent, slot, sel)) + body
    text = method_blocks(text, r'public void inventoryTick\(ItemStack (\w+), Level (\w+), Entity (\w+), int (\w+), boolean (\w+)\)\s*\{', tick)

    def hurt_enemy(m, body):
        body = re.sub(r'boolean retval = super\.hurtEnemy\(([^;]*)\);', r'super.hurtEnemy(\1);', body)
        body = re.sub(r'return retval;', 'return;', body)
        return 'public void hurtEnemy(ItemStack %s, LivingEntity %s, LivingEntity %s) {' % m.groups() + body
    text = method_blocks(text, r'public boolean hurtEnemy\(ItemStack (\w+), LivingEntity (\w+), LivingEntity (\w+)\)\s*\{', hurt_enemy)

    def release(m, body):
        body = re.sub(r'\breturn;', 'return true;', body)
        body = body[:body.rindex('}')] + '\treturn true;\n\t\t\t}'
        return 'public boolean releaseUsing(ItemStack %s, Level %s, LivingEntity %s, int %s) {' % m.groups() + body
    text = method_blocks(text, r'public void releaseUsing\(ItemStack (\w+), Level (\w+), LivingEntity (\w+), int (\w+)\)\s*\{', release)

    text = re.sub(r'public boolean onEntitySwing\(ItemStack (\w+), LivingEntity (\w+)\)', r'public boolean onEntitySwing(ItemStack \1, LivingEntity \2, InteractionHand hand)', text)
    text = re.sub(r'super\.onEntitySwing\((\w+), (\w+)\)', r'super.onEntitySwing(\1, \2, hand)', text)
    text = re.sub(r'public int getUseDuration\(ItemStack (\w+)\)', r'public int getUseDuration(ItemStack \1, LivingEntity user)', text)
    # enchantability is a property now
    text = re.sub(r'\n\s*@Override\s*\n\s*public int getEnchantmentValue\(\) \{\s*return \d+;\s*\}', '', text)
    return text


# ---------------------------------------------------------------- entities
DAMAGE_TYPES = {'fall()': 'FALL', 'cactus()': 'CACTUS', 'drown()': 'DROWN', 'lightningBolt()': 'LIGHTNING_BOLT', 'fallingBlock(null)': 'FALLING_ANVIL',
                'dragonBreath()': 'DRAGON_BREATH', 'wither()': 'WITHER', 'generic()': 'GENERIC', 'magic()': 'MAGIC', 'inFire()': 'IN_FIRE',
                'onFire()': 'ON_FIRE', 'lava()': 'LAVA', 'starve()': 'STARVE', 'fellOutOfWorld()': 'FELL_OUT_OF_WORLD', 'flyIntoWall()': 'FLY_INTO_WALL',
                'sweetBerryBush()': 'SWEET_BERRY_BUSH', 'hotFloor()': 'HOT_FLOOR', 'inWall()': 'IN_WALL', 'cramming()': 'CRAMMING', 'freeze()': 'FREEZE'}
sub(r'(\w+) == Compat\.damage\(\)\.(\w+\((?:null)?\))', lambda m: '%s.is(net.minecraft.world.damagesource.DamageTypes.%s)' % (m.group(1), DAMAGE_TYPES[m.group(2)]))
sub(r'(\w+) != Compat\.damage\(\)\.(\w+\((?:null)?\))', lambda m: '!%s.is(net.minecraft.world.damagesource.DamageTypes.%s)' % (m.group(1), DAMAGE_TYPES[m.group(2)]))


@func
def entity_types(path, text):
    """Static EntityType fields built at class-init time -> built inside registration with a registry key."""
    def per_element(block):
        for m in list(re.finditer(r'public static (?:final )?EntityType (\w+) = \((EntityType\.Builder\.<(\w+)>of\(.*?)\)\s*\.build\("(\w+)"\)\s*\.setRegistryName\("\w+"\);', block, re.S)):
            field, builder, cls, name = m.groups()
            builder = re.sub(r'\.setCustomClientFactory\([^()]*\)', '', builder)
            block = block.replace(m.group(0), 'public static EntityType<%s> %s;' % (cls, field))
            block = block.replace('elements.entities.add(() -> %s);' % field,
                                  'elements.entities.add(() -> %s = (%s).build(Registration.entityKey("%s")));' % (field, ' '.join(builder.split()), name))
        return block
    return for_each_element(text, per_element)


sub(r'\n\s*FMLJavaModLoadingContext\.get\(\)\.getModEventBus\(\)\.register\(new \w+Renderer\.ModelRegisterHandler\(\)\);', '')
sub(r'FMLJavaModLoadingContext\.get\(\)\.getModEventBus\(\)', 'NarutoShippudenMod.MOD_BUS')
sub(r'private static class (\w+(?:Handler|RegisterHandler))\b', r'public static class \1')
sub(r'\n\s*public (\w+)\(FMLPlayMessages\.SpawnEntity packet, Level world\) \{\s*this\(\w+, world\);\s*\}', '')
sub(r'\n\s*@Override\s*\n\s*public Packet<\?> getAddEntityPacket\(\) \{\s*return NetworkHooks\.getEntitySpawningPacket\(this\);\s*\}', '')
sub(r'\n\s*@Override\s*\n\s*public CreatureAttribute getMobType\(\) \{\s*return CreatureAttribute\.\w+;\s*\}', '')
sub(r'new AbstractMap\.SimpleEntry<>\("world", level\)', 'new AbstractMap.SimpleEntry<>("world", level())')
sub(r'\(\"world\", this\.level\)', '("world", this.level())')


@func
def entity_hurt(path, text):
    def hurt(m, body):
        body = body.replace('super.hurt(%s, %s)' % (m.group(1), m.group(2)), 'super.hurtServer(level, %s, %s)' % (m.group(1), m.group(2)))
        return 'public boolean hurtServer(ServerLevel level, DamageSource %s, float %s) {' % m.groups() + body
    return method_blocks(text, r'public boolean hurt\(DamageSource (\w+), float (\w+)\)\s*\{', hurt)


sub(r'public SpawnGroupData finalizeSpawn\(ServerLevelAccessor (\w+), DifficultyInstance (\w+), EntitySpawnReason (\w+),\s*(?:@Nullable )?SpawnGroupData (\w+),\s*(?:@Nullable )?CompoundTag \w+\)',
    r'public SpawnGroupData finalizeSpawn(ServerLevelAccessor \1, DifficultyInstance \2, EntitySpawnReason \3, SpawnGroupData \4)')
sub(r'super\.finalizeSpawn\((\w+), (\w+), (\w+), (\w+), \w+\)', r'super.finalizeSpawn(\1, \2, \3, \4)')
sub(r'\.finalizeSpawn\((\w+), ([^;]*?), EntitySpawnReason\.(\w+), \(SpawnGroupData\) null, \(CompoundTag\) null\)', r'.finalizeSpawn(\1, \2, EntitySpawnReason.\3, (SpawnGroupData) null)')
sub(r'(\w+)\.getCurrentDifficultyAt\(', r'\1.getCurrentDifficultyAt(')


# ---------------------------------------------------------------- projectiles
sub(r'@OnlyIn\(value = Dist\.CLIENT, _interface = ItemSupplier\.class\)\s*\n\s*', '')
sub(r'extends AbstractArrow implements ItemSupplier', 'extends ModArrow implements ItemSupplier')
sub(r'extends AbstractArrow \{', 'extends ModArrow {')
sub(r'\n\s*public ArrowCustomEntity\(FMLPlayMessages\.SpawnEntity packet, Level world\) \{\s*super\(\w+, world\);\s*\}', '')
sub(r'AbstractArrow entityToSpawn = new (\w+)\.ArrowCustomEntity', r'ModArrow entityToSpawn = new \1.ArrowCustomEntity')
sub(r'(\w+)\.setKnockback\(', r'Compat.setKnockback(\1, ')
sub(r'this\.inGround\b', 'this.isInGround()')
sub(r'\.stacksTo\(0\)', '.stacksTo(1)')
sub(r'\bshoot\(world, entity, random, ', 'shoot(world, entity, world.getRandom(), ')
sub(r'\bRandom random\b', 'RandomSource random')
sub(r'\.hurtAndBreak\((\w+), (\w+), \w+ -> \w+\.broadcastBreakEvent\(([^;]*?)\)\)', r'.hurtAndBreak(\1, \2, \3)')
sub(r'new InteractionResult\(InteractionResult\.(\w+), [^;]*\)(?=;)', r'InteractionResult.\1')
sub(r'\(net\.minecraft\.sounds\.SoundEvent\) BuiltInRegistries\.SOUND_EVENT\.getValue\(Identifier\.parse\(("[^"]*")\)\)', r'Compat.sound(\1)')
sub(r'BuiltInRegistries\.SOUND_EVENT\.getValue\(Identifier\.parse\(("[^"]*")\)\)', r'Compat.sound(\1)')

sub(r'new SoundEvent\(Identifier\.parse\(("[^"]*")\)\)', r'Compat.sound(\1)')

sub(r'GLFW\.GLFW_KEY_(\w+)', r'InputConstants.KEY_\1')
sub(r'GLFW\.GLFW_(PRESS|RELEASE|REPEAT)\b', r'InputConstants.\1')

sub(r'Minecraft\.getInstance\(\)\.screen\b', 'Minecraft.getInstance().gui.screen()')
sub(r'Minecraft\.getInstance\(\)\.setScreen\(', 'Minecraft.getInstance().gui.setScreen(')

# model swaps (Kleiders replacement) need the model layer; the render event only carries a render state
sub(r'ModelSwapRenderers\.(renderPlayerAs|renderMobAs)\((\w+), ("[^"]*"), ([\w.]+)::new\)', r'ModelSwapRenderers.\1(\2, \3, \4.LAYER, \4::new)')
sub(r'(RenderLivingEvent event\) \{\s*Entity entity = )event\.getEntity\(\);', r'\1ModelSwapRenderers.entity(event);\n\t\t\tif (entity == null)\n\t\t\t\treturn;')

# ---------------------------------------------------------------- opening GUIs
sub(r'NetworkHooks\.openGui\(\(ServerPlayer\) (\w+), ', r'((ServerPlayer) \1).openMenu(')
sub(r'\}, (_bpos|\w+Pos)\);', r'}, _buf -> _buf.writeBlockPos(\1));')


# ---------------------------------------------------------------- long tail batch
sub(r'(?<![\w).])world\.getCurrentDifficultyAt\(', '((ServerLevel) world).getCurrentDifficultyAt(')
sub(r'BlockTags\.getAllTags\(\)\.getTagOrEmpty\((Identifier\.parse\("[^"]*"\))\)\s*\.contains\(', r'Compat.blockHasTag(\1, ')
sub(r'ItemTags\.getAllTags\(\)\.getTagOrEmpty\((Identifier\.parse\("[^"]*"\))\)\s*\.contains\(', r'Compat.itemHasTag(\1, ')
sub(r'EntityTypeTags\.getAllTags\(\)\.getTagOrEmpty\((Identifier\.parse\("[^"]*"\))\)\s*\.contains\(', r'Compat.entityHasTag(\1, ')
sub(r'InteractionResult\.sidedSuccess\((?:[^()]|\([^()]*\))*\)', 'InteractionResult.SUCCESS')
sub(r'\bBlocks\.GRASS\b', 'Blocks.SHORT_GRASS')
sub(r'\.getGameProfile\(\)\.getId\(\)', '.getGameProfile().id()')
sub(r'\.getGameProfile\(\)\.getName\(\)', '.getGameProfile().name()')
sub(r'AttributeModifier\.Operation\.ADDITION\b', 'AttributeModifier.Operation.ADD_VALUE')
sub(r'AttributeModifier\.Operation\.MULTIPLY_BASE\b', 'AttributeModifier.Operation.ADD_MULTIPLIED_BASE')
sub(r'AttributeModifier\.Operation\.MULTIPLY_TOTAL\b', 'AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL')
sub(r'\bBASE_ATTACK_DAMAGE_UUID\b', 'BASE_ATTACK_DAMAGE_ID')
sub(r'\bBASE_ATTACK_SPEED_UUID\b', 'BASE_ATTACK_SPEED_ID')
sub(r'(\w+)\.setGlowing\(', r'\1.setGlowingTag(')
sub(r'\(([\w.()]+)\)\.setHoverName\(', r'Compat.setName(\1, ')
sub(r'([\w.]+)\.setHoverName\(', r'Compat.setName(\1, ')
sub(r'\(([\w.()]+)\)\.setTag\(', r'Compat.setCustomData(\1, ')
sub(r'(\w+)\.isEdible\(\)', r'\1.components().has(net.minecraft.core.component.DataComponents.FOOD)')
sub(r'Minecraft\.getInstance\(\)\.gameRenderer\.loadEffect\(', 'ClientPostEffects.set(')
sub(r'Minecraft\.getInstance\(\)\.gameRenderer\.shutdownEffect\(\)', 'ClientPostEffects.clear()')
sub(r'Minecraft\.getInstance\(\)\.gameRenderer\.currentEffect\(\)', 'ClientPostEffects.current()')
sub(r'Minecraft\.getInstance\(\)\.gameRenderer\.displayItemActivation\(', 'Minecraft.getInstance().player.displayItemActivation(')
sub(r'GameRules\.RULE_KEEPINVENTORY\b', 'net.minecraft.world.level.gamerules.GameRules.KEEP_INVENTORY')
sub(r'GameRules\.RULE_FALL_DAMAGE\b', 'net.minecraft.world.level.gamerules.GameRules.FALL_DAMAGE')
sub(r'(\w+)\.getLevelData\(\)\.getGameRules\(\)\.getBoolean\(([\w.]+)\)', r'((ServerLevel) \1).getGameRules().get(\2)')
sub(r'(\w+)\.getGameRules\(\)\.getBoolean\(([\w.]+)\)', r'\1.getGameRules().get(\2)')
sub(r'@Mod\.EventBusSubscriber\(bus = Mod\.EventBusSubscriber\.Bus\.MOD\)', '@EventBusSubscriber(modid = "naruto_shippuden")')
sub(r'@Mod\.EventBusSubscriber(\(\))?(?!\()', '@EventBusSubscriber(modid = "naruto_shippuden")')


# ---------------------------------------------------------------- entities batch 2
sub(r'this\.usePlayerItem\((\w+), (\w+)\);', r'this.usePlayerItem((Player) \1, hand, \2);')
sub(r'Mth\.sqrt\(', '(float) Math.sqrt(')
sub(r'(\w+)\.getFoodProperties\(\)\.getNutrition\(\)', r'itemstack.get(net.minecraft.core.component.DataComponents.FOOD).nutrition()')
sub(r'\((\w+)\) (\w+)\.create\((\w+)\);', r'(\1) \2.create(\3, EntitySpawnReason.BREEDING);')
sub(r'(\w+)\.awardKillScore\((\w+), (\w+), (\w+)\);', r'\1.awardKillScore(\2, \4);')
sub(r'public void awardKillScore\(Entity (\w+), int (\w+), DamageSource (\w+)\)', r'public void awardKillScore(Entity \1, DamageSource \3)')
sub(r'new FollowOwnerGoal\(this, ([^,]+), ([^,]+), ([^,]+), (?:true|false)\)', r'new FollowOwnerGoal(this, \1, \2, \3)')
sub(r'public boolean causeFallDamage\(float (\w+), float (\w+)\)', r'public boolean causeFallDamage(double \1, float \2, DamageSource damageSource)')
sub(r'super\.causeFallDamage\((\w+), (\w+)\)', r'super.causeFallDamage(\1, \2, damageSource)')
sub(r'public boolean canChangeDimensions\(\)', 'public boolean canUsePortal(boolean allowPassengers)')
sub(r'public void customServerAiStep\(\)', 'protected void customServerAiStep(ServerLevel level)')
sub(r'super\.customServerAiStep\(\);', 'super.customServerAiStep(level);')
sub(r'protected double getAttackReachSqr\(LivingEntity (\w+)\) \{\s*return ([^;]+);\s*\}',
    r'protected boolean canPerformAttack(LivingEntity \1) {\n\t\t\t\t\t\treturn this.isTimeToAttack() && this.mob.distanceToSqr(\1) <= (\2) && this.mob.getSensing().hasLineOfSight(\1);\n\t\t\t\t\t}')
# the attribute-map overrides built a map but returned the parent's result, so they never did anything
sub(r'\n\s*@Override\s*\n\s*public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers\(EquipmentSlot slot\) \{.*?\n\t\t\t\treturn super\.getDefaultAttributeModifiers\(slot\);\s*\n\t\t\t\}', '', re.S)
sub(r'\n\s*@Override\s*\n\s*public net\.minecraft\.sounds\.SoundEvent getEatingSound\(\) \{[^}]*\}', '')
sub(r'\n\s*@Override\s*\n\s*public boolean hasCraftingRemainingItem\(\) \{[^}]*\}', '')
sub(r'\n\s*@Override\s*\n\s*public ItemStack getContainerItem\(ItemStack \w+\) \{[^}]*\}', '')
sub(r'\.getMaterial\(\) == Material\.(\w+)', r'.is(Compat.materialTag("\1"))')
sub(r'SpawnPlacements\.Type\.(\w+)', r'net.minecraft.world.entity.SpawnPlacementTypes.\1')


@func
def spawn_rules(path, text):
    """Natural spawns -> data (biome modifiers), spawn placement -> RegisterSpawnPlacementsEvent via Compat."""
    def per_element(block):
        key = re.search(r'Registration\.entityKey\("(\w+)"\)', block)
        m = re.search(r'\n\s*@SubscribeEvent\s*\n\s*public void addFeatureToBiomes\(BiomeLoadingEvent event\) \{', block)
        if m and key:
            end = find_block(block, m.start())
            body = block[m.end():end]
            biomes = re.findall(r'Identifier\.parse\("([\w:/]+)"\)\.equals\(event\.getName\(\)\)', body)
            spawn = re.search(r'getSpawner\(MobCategory\.(\w+)\)\.add\(new MobSpawnSettings\.SpawnerData\(\w+, (\d+), (\d+), (\d+)\)\)', body)
            if spawn:
                SPAWNS.append((key.group(1), spawn.group(1), int(spawn.group(2)), int(spawn.group(3)), int(spawn.group(4)), biomes))
            block = block[:m.start()] + block[end:]
        sp = re.search(r'SpawnPlacements\.register\((\w+), (.*?)\);\n', block, re.S)
        if sp:
            block = block.replace(sp.group(0), '')
            block = block.replace('public void initElements() {', 'public void initElements() {\n\t\t\tCompat.spawnPlacement(() -> %s, %s);' % (sp.group(1), sp.group(2)), 1)
        return block
    return for_each_element(text, per_element)


SPAWNS = []

# ---------------------------------------------------------------- procedures batch
# spawning mobs: finalizeSpawn lost the NBT argument
sub(r'(finalizeSpawn\([^;]*?),\s*\(SpawnGroupData\) null,\s*\(CompoundTag\) null\)', r'\1, (SpawnGroupData) null)')
sub(r'(finalizeSpawn\([^;]*?),\s*(\w+|\(SpawnGroupData\) null|null),\s*(?:\(CompoundTag\) )?null\)', r'\1, \2)')
sub(r'public SpawnGroupData finalizeSpawn\(ServerLevelAccessor (\w+), DifficultyInstance (\w+), EntitySpawnReason (\w+),\s*(?:@Nullable )?SpawnGroupData (\w+),\s*(?:@Nullable )?CompoundTag \w+\)',
    r'public SpawnGroupData finalizeSpawn(ServerLevelAccessor \1, DifficultyInstance \2, EntitySpawnReason \3, SpawnGroupData \4)')
sub(r'super\.finalizeSpawn\((\w+), (\w+), (\w+), (\w+), \w+\)', r'super.finalizeSpawn(\1, \2, \3, \4)')
# inventory removal gained a "counting only" flag
sub(r'\.clearOrCountMatchingItems\(([^;]*?), \(int\) ', r'.clearOrCountMatchingItems(\1, false, (int) ')
# dropping items: server-side prediction
sub(r'\.drop\(([^;]*?), (true|false), (true|false)\);', r'.drop(\1, \2, net.minecraft.util.Prediction.SERVER_ONLY);')
sub(r'\b(player|_player|_player_|\(\(Player\) \w+\))\.drop\(([^;,]*?), (true|false)\);', r'\1.drop(\2, \3, net.minecraft.util.Prediction.SERVER_ONLY);')
# running commands as a position
sub(r'\(\((?:Level|ServerLevel)\) (\w+)\)\.getServer\(\)\.getCommands\(\)\.performCommand\(\s*new CommandSourceStack\(CommandSource\.NULL, new Vec3\(((?:[^()]|\([^()]*\))*)\), Vec2\.ZERO, \(ServerLevel\) \w+, 4,\s*"",\s*Component\.literal\(""\),\s*\(\((?:Level|ServerLevel)\) \w+\)\.getServer\(\), null\)\.withSuppressedOutput\(\),\s*',
    r'Compat.runCommandAt(\1, \2, ')
sub(r'(\w+)\.getServer\(\)\.getCommands\(\)\.performCommand\(\s*new CommandSourceStack\(CommandSource\.NULL, new Vec3\(([^()]*)\), Vec2\.ZERO, \(ServerLevel\) \w+, 4, "",\s*Component\.literal\(""\), \w+\.getServer\(\), null\)\.withSuppressedOutput\(\),\s*',
    r'Compat.runCommandAt(\1, \2, ')
# cooldowns are per stack (group) now
sub(r'\.getCooldowns\(\)\.addCooldown\(([^;]*?)\.getItem\(\),(\s*)', r'.getCooldowns().addCooldown(\1,\2')
sub(r'\.getCooldowns\(\)\.addCooldown\(([\w.]+)\.block,(\s*)', r'.getCooldowns().addCooldown(new ItemStack(\1.block),\2')
sub(r'\.getCooldowns\(\)\.isOnCooldown\(([^;]*?)\.getItem\(\)\)', r'.getCooldowns().isOnCooldown(\1)')
sub(r'\.getCooldowns\(\)\.isOnCooldown\(([\w.]+)\.block\)', r'.getCooldowns().isOnCooldown(new ItemStack(\1.block))')
sub(r'\.getCooldowns\(\)\.removeCooldown\(([^;]*?)\.getItem\(\)\)', r'.getCooldowns().removeCooldown(\1.getItem().builtInRegistryHolder().key().identifier())')
# changing dimension
sub(r'\(\(ServerPlayer\) (\w+)\)\.teleportTo\((\w+), ([^;]*?), (\w+)\.getYRot\(\), (\w+)\.getXRot\(\)\);',
    r'((ServerPlayer) \1).teleportTo(\2, \3, java.util.Set.of(), \4.getYRot(), \5.getXRot(), true);')
sub(r'new ClientboundUpdateMobEffectPacket\(([^;]*?), (\w+)\)\)', r'new ClientboundUpdateMobEffectPacket(\1, \2, false))')
sub(r'(\b_ent|\bentity)\.getServer\(\)', r'\1.level().getServer()')
sub(r'\(\(ServerPlayer\) (\w+)\)\.server\b', r'((ServerPlayer) \1).level().getServer()')
sub(r'\.getAdvancements\(\)\s*\.getAdvancement\(', '.getAdvancements().get(')
sub(r'\.connection\.teleport\(([^;]*?),\s*Collections\.emptySet\(\)\);', r'.connection.teleport(\1);')
sub(r'\.getRespawnData\(\)\.pos\(\)', '.getRespawnData().pos()')
# hands and taming
sub(r'\.swing\((InteractionHand\.\w+|\w+), true\);', r'.swing(\1, net.minecraft.world.item.component.SwingAnimation.DEFAULT, true);')
sub(r'\.swing\((InteractionHand\.\w+|hand)\);', r'.swing(\1, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);')
sub(r'\.setTame\(\((true|false)\)\);', r'.setTame(\1, true);')
sub(r'\.setTame\((true|false)\);', r'.setTame(\1, true);')
sub(r'net\.minecraftforge\.event\.ForgeEventFactory\.onAnimalTame\(', 'net.neoforged.neoforge.event.EventHooks.onAnimalTame(')
# explosions
sub(r'Explosion\.BlockInteraction\.NONE', 'Level.ExplosionInteraction.NONE')
sub(r'Explosion\.BlockInteraction\.(BREAK|DESTROY)', 'Level.ExplosionInteraction.TNT')
sub(r'\.explode\(null, \(int\) ([^,]+), \(int\) ([^,]+), \(int\) ([^,]+), ', r'.explode(null, \1, \2, \3, ')
# misc entity API
sub(r'(\w+)\.setInvulnerable\(', r'\1.setPermanentlyInvulnerable(')
sub(r'\(\(ServerLevel\) (\w+)\)\.setDayTime\(\(int\) ([^;]+)\);', r'Compat.runCommandAt(\1, 0, 0, 0, "time set " + (int) (\2));')
sub(r'\(\(Level\) (\w+)\)\.getGameRules\(\)\.getRule\(([\w.]+)\)\.set\(\(?(true|false)\)?, [^;]+\);', r'((ServerLevel) \1).getGameRules().set(\2, \3, ((ServerLevel) \1).getServer());')
sub(r'\.getRule\(([\w.]+)\)\.get\(\)', r'.get(\1)')
sub(r'EntityType\.LIGHTNING_BOLT\.create\(\(Level\) (\w+)\)', r'EntityType.LIGHTNING_BOLT.create((Level) \1, EntitySpawnReason.TRIGGERED)')
sub(r'(\w+)\.create\(\(Level\) (\w+)\)', r'\1.create((Level) \2, EntitySpawnReason.TRIGGERED)')
sub(r'\)\.yRot\b', r').getYRot()')
sub(r'\)\.xRot\b', r').getXRot()')
sub(r'\bParticleTypes\.FLASH\b', 'ColorParticleOption.create(ParticleTypes.FLASH, -1)')
sub(r'CompoundTag (\w+) = \(StackTag\.of\(([^;]*)\)\);', r'CompoundTag \1 = StackTag.of(\2).copy();')
sub(r'CompoundTag (\w+) = StackTag\.of\(([^;]*)\);', r'CompoundTag \1 = StackTag.of(\2).copy();')
# events
sub(r'if \((\w+)\.isCancelable\(\)\)\s*\n(\s*)\1\.setCanceled\(true\);', r'if (\1 instanceof net.neoforged.bus.api.ICancellableEvent _cancellable)\n\2_cancellable.setCanceled(true);')
sub(r'(\w+)\.isCancelable\(\)', r'(\1 instanceof net.neoforged.bus.api.ICancellableEvent)')
sub(r'\bevent\.getPlayer\(\)', 'event.getEntity()')
# items
sub(r'InteractionResult (\w+) = super\.use\((\w+), (\w+), (\w+)\);\s*\n(\s*)ItemStack itemstack = \1\.getObject\(\);',
    r'InteractionResult \1 = super.use(\2, \3, \4);\n\5ItemStack itemstack = \3.getItemInHand(\4);')
sub(r'\.saturationMod\(', '.saturationModifier(')
sub(r'new DamageSource\("[^"]*"\)(?:\.\w+\(\))*', r'Compat.damage().genericKill()')
# worn armour: slots 0-3 are feet..head
sub(r'\(\(Player\) (\w+)\)\.getInventory\(\)\.armor\.set\(\(int\) (\d),', lambda m: '((Player) %s).setItemSlot(EquipmentSlot.%s,' % (m.group(1), ['FEET', 'LEGS', 'CHEST', 'HEAD'][int(m.group(2))]))
sub(r'\(\(Player\) (\w+)\)\.getInventory\(\)\.armor\.get\(\(int\) (\d)\)', lambda m: '((Player) %s).getItemBySlot(EquipmentSlot.%s)' % (m.group(1), ['FEET', 'LEGS', 'CHEST', 'HEAD'][int(m.group(2))]))
# boss bars
sub(r'new ServerBossEvent\(this\.getDisplayName\(\)', 'new ServerBossEvent(java.util.UUID.randomUUID(), this.getDisplayName()')
sub(r'\.bossInfo\.setPercent\(', '.bossInfo.setProgress(')
sub(r'(\w+)\.this\.doHurtTarget\((\w+)\)', r'\1.this.doHurtTarget((ServerLevel) \1.this.level(), \2)')
sub(r'this\.doHurtTarget\((\w+)\)', r'this.doHurtTarget((ServerLevel) this.level(), \1)')

sub(r'\bNeoAttributes\.ENTITY_INTERACTION_RANGE\b', 'Attributes.ENTITY_INTERACTION_RANGE')
sub(r'\.alwaysEat\(\)', '.alwaysEdible()')
sub(r'\s*\.meat\(\)', '')
sub(r'LivingEvent\.LivingUpdateEvent\b', 'EntityTickEvent.Pre')
sub(r'\bevent\.getEntityLiving\(\)', 'event.getEntity()')
sub(r'(\w+)\.getLevelData\(\)\.getDayTime\(\)', r'((Level) \1).getDefaultClockTime()')
sub(r'(\w+)\.getDayTime\(\)', r'((Level) \1).getDefaultClockTime()')
sub(r'\bevent\.getWorld\(\)', 'event.getLevel()')
sub(r'EntityType\.([A-Z][A-Z_0-9]+)\b', r'net.minecraft.world.entity.EntityTypes.\1')
sub(r'if \((\w+) instanceof ([\w.]+)\) \{\s*\n(\s*)\1\.setCanceled\(true\);', r'if (\1 instanceof \2 _cancelable) {\n\3_cancelable.setCanceled(true);')
sub(r'\(\(ServerPlayer\) (\w+)\)\.teleportTo\((\w+), ((?:[^;]|\n)*?),\s*(\w+)\.getYRot\(\),\s*(\w+)\.getXRot\(\)\);',
    r'((ServerPlayer) \1).teleportTo(\2, \3, java.util.Set.of(), \4.getYRot(), \5.getXRot(), true);')



@func
def block_pos_containing(path, text):
    """new BlockPos(x, y, z) took doubles in 1.16 (floored); 26.3 wants ints, BlockPos.containing floors doubles."""
    out = []
    pos = 0
    for m in re.finditer(r'new BlockPos\(', text):
        if m.start() < pos:
            continue
        i = m.end()
        depth = 1
        commas = 0
        while depth:
            c = text[i]
            if c in '([':
                depth += 1
            elif c in ')]':
                depth -= 1
            elif c == ',' and depth == 1:
                commas += 1
            elif c == '"':
                i += 1
                while text[i] != '"':
                    i += 2 if text[i] == '\\' else 1
            i += 1
        if commas == 2:
            out.append(text[pos:m.start()] + 'BlockPos.containing(')
            pos = m.end()
    out.append(text[pos:])
    return ''.join(out)
sub(r'\bNeoForge\.EVENT_BUS\.register\(this\);', 'Registration.listen(NeoForge.EVENT_BUS, this);')
sub(r'\bNarutoShippudenMod\.MOD_BUS\.register\((new EntityAttributesRegisterHandler\(\))\);', r'Registration.listen(NarutoShippudenMod.MOD_BUS, \1);')


CLIENT_EVENTS = sorted(f[:-5] for f in os.listdir('/home/user/mcsrc/net/neoforged/neoforge/client/event') if f.endswith('Event.java')) if os.path.isdir('/home/user/mcsrc/net/neoforged/neoforge/client/event') else []
CLIENT_EVENTS = CLIENT_EVENTS or ['RenderLivingEvent', 'RenderPlayerEvent', 'RenderGuiEvent', 'RenderGuiLayerEvent', 'InputEvent', 'ClientTickEvent',
                                  'ViewportEvent', 'ScreenEvent', 'RenderHandEvent', 'RenderLevelStageEvent', 'ComputeFovModifierEvent', 'RenderNameTagEvent',
                                  'MovementInputUpdateEvent', 'ClientChatEvent', 'ClientPlayerNetworkEvent']


@func
def client_subscribers(path, text):
    """Kleiders render events fired for both phases of the abstract event; NeoForge needs a concrete one (Pre, where the
    swap cancels the normal render). Subscribers to client events must not be loaded on a dedicated server."""
    text = re.sub(r'public static void (\w+)\(RenderLivingEvent event\)', r'public static void \1(RenderLivingEvent.Pre event)', text)
    ev = '|'.join(CLIENT_EVENTS)
    def fix(m):
        start = m.end()
        nxt = text.find('@EventBusSubscriber', start)
        seg = text[start:nxt if nxt != -1 else len(text)]
        if re.search(r'@SubscribeEvent\s*\n\s*public (?:static )?void \w+\((?:%s)\b' % ev, seg):
            return '@EventBusSubscriber(modid = "naruto_shippuden", value = net.neoforged.api.distmarker.Dist.CLIENT)'
        return m.group(0)
    return re.sub(r'@EventBusSubscriber\(modid = "naruto_shippuden"\)', fix, text)


@func
def box_order(path, text):
    """MCreator's rotated shapes swap min and max (tolerated in 1.16, rejected by 26.3's Shapes.box)."""
    num = r'(-?\d+(?:\.\d+)?)'

    def fix(m):
        v = [float(x) for x in m.groups()]
        lo = [min(v[i], v[i + 3]) for i in range(3)]
        hi = [max(v[i], v[i + 3]) for i in range(3)]
        return 'box(%s)' % ', '.join('%g' % x for x in lo + hi)
    return re.sub(r'(?<![\w.])box\(%s\)' % ', '.join([num] * 6), fix, text)


MULTIPART = {'KuramaEntity': 'kurama'}


@func
def multipart_hitboxes(path, text):
    """Big bosses get ender-dragon style part hitboxes (core/MultipartHitbox) instead of one huge box."""
    for element, layout in MULTIPART.items():
        m = re.search(r'public static class %s extends NarutoShippudenModElements\.ModElement \{' % element, text)
        if not m:
            continue
        c = re.compile(r'public CustomEntity\(EntityType<CustomEntity> type, Level world\) \{').search(text, m.end())
        if not c or 'MultipartHitbox' in text[m.end():c.start()]:
            continue
        code = ('private final net.mcreator.narutoshippudenmod.core.MultipartHitbox hitbox = net.mcreator.narutoshippudenmod.core.MultipartHitbox.%s(this);\n\n'
                '\t\t\t@Override\n\t\t\tpublic boolean isMultipartEntity() {\n\t\t\t\treturn true;\n\t\t\t}\n\n'
                '\t\t\t@Override\n\t\t\tpublic net.neoforged.neoforge.entity.PartEntity<?>[] getParts() {\n\t\t\t\treturn hitbox.parts();\n\t\t\t}\n\n'
                '\t\t\t@Override\n\t\t\tpublic boolean isPickable() {\n\t\t\t\treturn false;\n\t\t\t}\n\n'
                '\t\t\t@Override\n\t\t\tpublic void recreateFromPacket(net.minecraft.network.protocol.game.ClientboundAddEntityPacket packet) {\n'
                '\t\t\t\tsuper.recreateFromPacket(packet);\n\t\t\t\thitbox.syncIds(packet.getId());\n\t\t\t}\n\n'
                '\t\t\t@Override\n\t\t\tpublic void aiStep() {\n\t\t\t\tsuper.aiStep();\n\t\t\t\thitbox.update();\n\t\t\t}\n\n\t\t\t') % layout
        text = text[:c.start()] + code + text[c.start():]
    return text


@func
def drop_old_cheat_command(path, text):
    """/narutoshippudencheat is replaced by /naruto cheat (command/NarutoCommand)."""
    m = re.search(r'\t@EventBusSubscriber\(modid = "naruto_shippuden"\)\n\tpublic static class NarutoShippudenCheatCommand \{', text)
    if not m:
        return text
    end = find_block(text, m.end() - 1)
    return text[:m.start()] + text[end:].lstrip('\n')


KURAMA_ROAR_EVENT = 100


@func
def kurama_animation(path, text):
    """Kurama: procedural animation (client/KuramaAnimation) and a roar event sent when it fires a tailed beast bomb."""
    m = re.search(r'public static class Modelkurama extends EntityModel<EntityRenderState> \{', text)
    if m:
        s = text.find('private void setupAnimCompat(EntityRenderState state) {', m.end())
        head = text.find('this.Head.yRot = ', s)
        end = find_block(text, s) - 1
        if s != -1 and head != -1 and head < end:
            text = text[:head] + 'net.mcreator.narutoshippudenmod.client.KuramaAnimation.animate(this, state);\n\t\t' + text[end:]
    m = re.search(r'public static class KuramaEntity extends NarutoShippudenModElements\.ModElement \{', text)
    if m and 'ROAR_TICKS' not in text:
        text = text[:m.end()] + '\n\t\tpublic static final int ROAR_TICKS = 30;' + text[m.end():]
        shoot = text.find('TailedBeastBombItem.shoot(this, target);', m.end())
        text = text[:shoot] + 'this.level().broadcastEntityEvent(this, (byte) %d);\n\t\t\t\t' % KURAMA_ROAR_EVENT + text[shoot:]
        c = text.find('public CustomEntity(EntityType<CustomEntity> type, Level world) {', m.end())
        text = text[:c] + ('/** Client side: the tick count when the last roar started (see client/KuramaAnimation). */\n'
                           '\t\t\tpublic int roarTick = -1000;\n\n'
                           '\t\t\t@Override\n\t\t\tpublic void handleEntityEvent(byte id) {\n'
                           '\t\t\t\tif (id == %d)\n\t\t\t\t\troarTick = tickCount;\n\t\t\t\telse\n\t\t\t\t\tsuper.handleEntityEvent(id);\n\t\t\t}\n\n\t\t\t'
                           % KURAMA_ROAR_EVENT) + text[c:]
    return text


@func
def attribute_modifier_events(path, text):
    """ItemAttributeModifierEvent: no slot getter any more, the slot group is given with each modifier."""
    rx = re.compile(r'dependencies\.get\("event"\) instanceof ItemAttributeModifierEvent\s*&& \(\(ItemAttributeModifierEvent\) dependencies\.get\("event"\)\)\.getSlotType\(\) == EquipmentSlot\.(\w+)\) \{')
    while True:
        m = rx.search(text)
        if not m:
            break
        end = find_block(text, m.end() - 1)
        block = re.sub(r'_event\.addModifier\(([^;]*?), (\w+)\);', r'_event.addModifier(\1, \2, net.minecraft.world.entity.EquipmentSlotGroup.%s);' % m.group(1), text[m.end():end])
        text = text[:m.start()] + 'dependencies.get("event") instanceof ItemAttributeModifierEvent) {' + block + text[end:]
    text = re.sub(r'new AttributeModifier\(UUID\.fromString\("[^"]*"\),\s*"naruto_shippuden\." \+ "(\w+)",\s*',
                  lambda m: 'new AttributeModifier(Identifier.fromNamespaceAndPath("naruto_shippuden", "%s"), ' % re.sub(r'(?<!^)(?=[A-Z])', '_', m.group(1)).lower(), text)
    text = re.sub(r'\b[\w.]*\bREACH_DISTANCE\b(?:\.get\(\))?|\bNeoAttributes\.ENTITY_INTERACTION_RANGE\b', 'Attributes.ENTITY_INTERACTION_RANGE', text)
    text = re.sub(r'_event\.addModifier\(net\.minecraft\.world\.entity\.ai\.attributes\.Attributes\.', '_event.addModifier(Attributes.', text)
    return text


# ---------------------------------------------------------------- player variables writes
sub(r'(\b[\w.]+(?:\(\))?)\.getCapability\(NarutoShippudenModVariables\.PLAYER_VARIABLES_CAPABILITY, null\)\s*\.ifPresent\(', r'NarutoShippudenModVariables.ifPresent(\1, ')

# ---------------------------------------------------------------- final: add imports for names the rules introduced
ENSURE = {
    'Compat': 'net.mcreator.narutoshippudenmod.compat.Compat',
    'RandomSource': 'net.minecraft.util.RandomSource',
    'ItemStack': 'net.minecraft.world.item.ItemStack',
    'Identifier': 'net.minecraft.resources.Identifier',
    'Component': 'net.minecraft.network.chat.Component',
    'BuiltInRegistries': 'net.minecraft.core.registries.BuiltInRegistries',
    'Registries': 'net.minecraft.core.registries.Registries',
    'TagKey': 'net.minecraft.tags.TagKey',
    'BlockPos': 'net.minecraft.core.BlockPos',
    'Registration': 'net.mcreator.narutoshippudenmod.compat.Registration',
    'ToolMaterial': 'net.minecraft.world.item.ToolMaterial',
    'LivingEntity': 'net.minecraft.world.entity.LivingEntity',
    'InteractionHand': 'net.minecraft.world.InteractionHand',
    'Item': 'net.minecraft.world.item.Item',
    'NarutoShippudenMod': 'net.mcreator.narutoshippudenmod.NarutoShippudenMod',
    'ModArrow': 'net.mcreator.narutoshippudenmod.compat.ModArrow',
    'InputConstants': 'com.mojang.blaze3d.platform.InputConstants',
    'ModelSwapRenderers': 'net.mcreator.narutoshippudenmod.core.ModelSwapRenderers',
    'ClientPostEffects': 'net.mcreator.narutoshippudenmod.client.ClientPostEffects',
    'EntitySpawnReason': 'net.minecraft.world.entity.EntitySpawnReason',
    'Player': 'net.minecraft.world.entity.player.Player',
    'StackTag': 'net.mcreator.narutoshippudenmod.compat.StackTag',
    'ServerLevel': 'net.minecraft.server.level.ServerLevel',
    'Entity': 'net.minecraft.world.entity.Entity',
    'ResourceKey': 'net.minecraft.resources.ResourceKey',
    'PlayerTickEvent': 'net.neoforged.neoforge.event.tick.PlayerTickEvent',
    'ServerTickEvent': 'net.neoforged.neoforge.event.tick.ServerTickEvent',
    'LevelTickEvent': 'net.neoforged.neoforge.event.tick.LevelTickEvent',
    'EntityTickEvent': 'net.neoforged.neoforge.event.tick.EntityTickEvent',
    'ClientTickEvent': 'net.neoforged.neoforge.client.event.ClientTickEvent',
    'EventBusSubscriber': 'net.neoforged.fml.common.EventBusSubscriber',
    'NeoForge': 'net.neoforged.neoforge.common.NeoForge',
    'EquipmentSlot': 'net.minecraft.world.entity.EquipmentSlot',
    'Level': 'net.minecraft.world.level.Level',
    'ColorParticleOption': 'net.minecraft.core.particles.ColorParticleOption',
    'ParticleTypes': 'net.minecraft.core.particles.ParticleTypes',
    'Attributes': 'net.minecraft.world.entity.ai.attributes.Attributes',
}


def ensure_imports(path, text):
    head, body = split_header(text)
    head = re.sub(r'^import org\.lwjgl\.glfw\.GLFW;\n', '', head, flags=re.M)
    head = re.sub(r'^import net\.minecraftforge\.[\w.]+;\n', '', head, flags=re.M)
    have = set(re.findall(r'^import [\w.]+\.(\w+);', head, re.M))
    pkg = re.search(r'^package ([\w.]+);', head, re.M).group(1)
    add = []
    for simple, fqn in ENSURE.items():
        if simple in have or fqn.rsplit('.', 1)[0] == pkg:
            continue
        if re.search(r'(?<![\w.])%s\b' % simple, body) and not re.search(r'\bclass %s\b' % simple, body):
            add.append('import %s;\n' % fqn)
    if add:
        head = re.sub(r'(^package [\w.]+;\n)', lambda m: m.group(1) + '\n' + ''.join(add), head, count=1, flags=re.M)
    return head + body


RULES.append(ensure_imports)


@func
def entity_selector_not_null(path, text):
    """26.3 getEntitiesOfClass needs a predicate; MCreator passed null."""
    rx = re.compile(r'(\.getEntitiesOfClass\(\w+\.class,\s*new AABB\((?:[^()]|\([^()]*(?:\([^()]*\))*[^()]*\))*\)),\s*null\)')
    return rx.sub(r'\1, e -> true)', text)


@func
def drop_item_hover_text(path, text):
    """Item descriptions come from client/ItemDescriptions (one vanilla-style table), so drop MCreator's appendHoverText."""
    if '/item/' not in path.replace('\\', '/') and not path.replace('\\', '/').startswith('item/'):
        return text
    rx = re.compile(r'\n[ \t]*(?:@Override\s*)?public void appendHoverText\(')
    while True:
        m = rx.search(text)
        if not m:
            return text
        text = text[:m.start()] + text[find_block(text, m.end()):]


@func
def golem_renderers(path, text):
    """The Earth Golem and Wood Human are drawn by client/jutsu/GolemRenderer (the remade model)."""
    return re.sub(r'\n\t*ModRenderers\.mob\(event, (?:EarthGolemEntity|WoodGolemEntity)\.entity,[^\n]*', '\n\t\t\t// drawn by client.jutsu.GolemRenderer', text)


CLAN_MODES = ('tenromode', 'izunochakramode', 'izunocat', 'HumanBulletTank', 'SpikedHumanBulletTank', 'ButterflyMode', 'PassingFang')


@func
def clan_mode_ticks(path, text):
    """core/jutsu/ClanJutsu runs the clan transformations (effects, damage, timing); switch off the old per-tick blocks, which drained
    chakra every tick, gave Speed 20 and hurt everything near without credit. The render swaps that test the same flags stay."""
    if not path.replace('\\', '/').endswith('PlayerProcedures.java'):
        return text
    rx = re.compile(r'if \((NarutoShippudenModVariables\.get\(entity\)\.(?:%s) == true)\) \{(?=\s*\n\s*(?:if \(NarutoShippudenModVariables\.get\(entity\)\.(?:ninjutsu|ChakraAmount)|\{\s*\n\s*List<Entity> _entfound))'
                    % '|'.join(CLAN_MODES))
    return rx.sub(r'if (false && \1) {', text)


@func
def clan_item_hooks(path, text):
    """The clan technique items' hit and swing hooks belong to the old jutsu (Lee's gates, the Death God seal, the Gentle Fist)."""
    return re.sub(r'\b(?:Hyuga|Lee|Uzumaki)ReleaseTechniqueLivingEntityIsHitWithItemProcedure\.executeProcedure\(|\b(?:AkimichiReleaseTechnique|IsshikiDojutsuReleaseTechnique)EntitySwingsItemProcedure\.executeProcedure\(',
                  'net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(', text)


@func
def magnet_coat_ticks(path, text):
    """KekkeiGenkaiJutsu times the iron sand coat and wings itself; the old tick drained chakra and forced flight on and off."""
    if not path.replace('\\', '/').endswith('PlayerProcedures.java'):
        return text
    rx = re.compile(r'\((NarutoShippudenModVariables\.get\(entity\)\.magnet_coat == \d\)) \{(?=\s*\n\s*if \(NarutoShippudenModVariables\.get\(entity\)\.ChakraAmount)')
    return rx.sub(r'(false && \1 {', text)


# ---------------------------------------------------------------- the YouTuber dojutsu (Voltic Mode, Furamingogan) are removed
YT_CLASSES = ['FuramingoganTechniqueItem', 'FuramingoganReleaseItem', 'FuramingoganBeamItem', 'VolticModeTechniqueItem', 'VolticModeReleaseItem',
              'FuramingoganBeamProjectileHitsLivingEntityProcedure', 'FuramingoganReleaseRightclickedProcedure',
              'FuramingoganTechniqueRightclickedProcedure', 'VolticModeReleaseRightclickedProcedure', 'VolticModeTechniqueRightclickedProcedure',
              'FuramingoganBeamRenderer', 'FuramingoganParticleParticle', 'VolticParticleParticle', 'CustomDojutsuOnKeyPressedProcedure',
              'CustomDojutsuKeyBinding'] + ['Display%s2x%dPupils%dx1Procedure' % (who, a, b) for who in ('Voltic', 'Marcus') for a in (1, 2) for b in (1, 2)]
YT_VARS = ['BoxDeity', 'TheSirMarcus', 'TheSirMarcusDojutsuSelect', 'VolticMode', 'VolticThomasCannonDamage', 'Furamingogan', 'furamingogan_jump',
           'furamingogan_technique', 'furamingoganlearn', 'furamingoganrelease', 'voltic_technique', 'volticlearn', 'volticrelease']


def remove_class(text, name):
    m = re.search(r'\n[ \t]*(?:@[\w.]+(?:\([^)]*\))?\s*)*(?:public |private |protected )?(?:static )?(?:final )?class %s\b' % name, text)
    if not m:
        return text
    return text[:m.start()] + text[find_block(text, m.end()):]


def remove_if_blocks(text, cond):
    """Removes each `if (cond) {...}` (cond is a regex matching the whole condition), fixing up else-if chains."""
    rx = re.compile(r'(\}\s*else\s+)?if \((%s)\) \{' % cond)
    while True:
        m = rx.search(text)
        if not m:
            return text
        end = find_block(text, m.end() - 1)
        rest = text[end:]
        if m.group(1):
            # "} else if (cond) {...}" -> "}"
            text = text[:m.start()] + '}' + rest
        else:
            tail = re.match(r'\s*else\s+(if \(|\{)', rest)
            if tail:
                # "if (cond) {...} else if (x) {" -> "if (x) {";  "if (cond) {...} else {" -> "{"
                text = text[:m.start()] + tail.group(1) + rest[tail.end():]
            else:
                text = text[:m.start()] + rest
    return text


@func
def remove_youtuber_dojutsu(path, text):
    """Voltic Mode and the Furamingogan were made for two YouTubers (given by player name); they and Custom Dojutsu are gone."""
    if not re.search(r'Voltic|Furamingogan|BoxDeity|TheSirMarcus|CustomDojutsu|CUSTOMDOJUTSU|DisplayMarcus', text):
        return text
    for name in YT_CLASSES:
        text = remove_class(text, name)
    v = r'NarutoShippudenModVariables\.get\(entity\)\.'
    text = remove_if_blocks(text, r'\(entity\.getDisplayName\(\)\.getString\(\)\)\.equals\("(?:BoxDeity|TheSirMarcus)"\)')
    text = remove_if_blocks(text, v + r'(?:BoxDeity|TheSirMarcus|VolticThomasCannonDamage|furamingogan_jump|VolticMode|Furamingogan) == true')
    text = re.sub(v + r'BoxDeity == false\s*&&\s*' + v + r'TheSirMarcus == false', 'true', text)
    # statements, list entries and imports that name what was removed
    names = '|'.join(YT_CLASSES + ['CUSTOMDOJUTSUKEYBINDING', 'onCustomDojutsuKeyBinding'])
    text = re.sub(r'\n[^\n]*\b(?:%s)\b[^\n]*(?:;|\),)(?=\n)' % names, '', text)
    m = re.search(r'\n\tprivate static void onCustomDojutsuKeyBinding\(', text)
    if m:
        text = text[:m.start()] + text[find_block(text, m.end()):]
    if path.replace('\\', '/').endswith('NarutoShippudenModVariables.java'):
        text = re.sub(r'\n[^\n]*\b(?:%s)\b[^\n]*(?=\n)' % '|'.join(YT_VARS), '', text)
    return text


EYE_KEYS = ['Byakugan', 'IsshikiDojutsu', 'Ketsuryugan', 'MangekyouSharingan', 'Rinnegan', 'Sharingan', 'Susano', 'Tenseigan']


@func
def eye_keys(path, text):
    """One Dojutsu key and a hold-to-grow Susanoo key (client/EyeKeys) replace the eight eye keys; every key moves to the mod's
    own Controls section."""
    if not path.replace('\\', '/').endswith('ModKeyMappings.java'):
        return text
    for name in EYE_KEYS:
        text = re.sub(r'\n[^\n]*\b%sKEYBINDING\b[^\n]*;(?=\n)' % name.upper(), '', text)
        text = re.sub(r'\n[^\n]*\bon%sKeyBinding\(event\);(?=\n)' % name, '', text)
        m = re.search(r'\n\tprivate static void on%sKeyBinding\(' % name, text)
        if m:
            text = text[:m.start()] + text[find_block(text, m.end()):]
    return text.replace('KeyMapping.Category.MISC', 'EyeKeys.CATEGORY')


# ---------------------------------------------------------------- clans the user removed (their logo textures stay in the assets)
GONE_CLANS = ['Izuno', 'Kurama', 'Shimura', 'Namikaze', 'Kazekage', 'Hatake', 'Otsutsuki', 'Senju', 'Tenro', 'Yuki', 'Hoshigaki', 'Kaguya']
GONE_CLAN_CLASSES = [c + suffix for c in GONE_CLANS for suffix in ('ReleaseItem', 'ReleaseRightclickedProcedure', 'ReleaseTechniqueItem',
                                                                   'ReleaseTechniqueRightclickedProcedure', 'InfoProcedure', 'SelectProcedure')]
GONE_CLAN_CLASSES += ['Diplay%sSelectProcedure' % c for c in GONE_CLANS] + ['Display%sInfoProcedure' % c for c in GONE_CLANS] \
    + ['Display%sSelectProcedure' % c for c in GONE_CLANS]
GONE_CLAN_LOGIC = [c.lower() + 'releaselogic' for c in GONE_CLANS]


def clan_paper(text):
    """The clan paper rolls 1..N, one branch per clan: drop the removed clans' branches and number the rest again."""
    m = re.search(r'clanpaperrandom = \(Mth\.nextInt\(RandomSource\.create\(\), 1, (\d+)\)\);', text)
    if not m:
        return text
    rx = re.compile(r'(?:\}\s*else\s+)?if \(clanpaperrandom == (\d+)\) \{')
    branches, pos = [], m.end()
    while True:
        b = rx.search(text, pos)
        if not b:
            break
        end = find_block(text, b.end() - 1)
        branches.append((b.start(), end, text[b.start():end]))
        pos = end
    if not branches:
        return text
    kept = [body for _, _, body in branches if not any(logic in body for logic in GONE_CLAN_LOGIC)]
    chain = ''
    for i, body in enumerate(kept):
        body = re.sub(r'^(?:\}\s*else\s+)?if \(clanpaperrandom == \d+\) \{', ('if' if i == 0 else ' else if') + ' (clanpaperrandom == %d) {' % (i + 1), body)
        chain += body
    text = text[:branches[0][0]] + chain + text[branches[-1][1]:]
    return text.replace(m.group(0), 'clanpaperrandom = (Mth.nextInt(RandomSource.create(), 1, %d));' % len(kept))


# the clan-select screen's numbers (0..25) for the clans that stay, renumbered 0..13 in the same order
CLAN_SELECT = {0: 0, 1: 1, 2: 2, 3: 3, 6: 4, 7: 5, 9: 6, 10: 7, 11: 8, 12: 9, 13: 10, 21: 11, 22: 12, 24: 13}


def clan_select(path, text):
    v = r'NarutoShippudenModVariables\.get\(entity\)\.selectclanrelease'
    if path.replace('\\', '/').endswith('GuiProcedures.java'):
        # the chain that applies the chosen clan: drop the removed clans, number the rest again
        rx = re.compile(r'(?:\}\s*else\s+)?if \(%s == (\d+)\) \{' % v)
        first = rx.search(text)
        while first and 'releaselogic' not in text[first.end():find_block(text, first.end() - 1)]:
            first = rx.search(text, find_block(text, first.end() - 1))
        if first:
            branches, pos = [], first.start()
            while True:
                b = rx.match(text, pos) if pos == first.start() else re.compile(r'\s*\}?\s*else\s+if \(%s == (\d+)\) \{' % v).match(text, pos - 1)
                if not b:
                    break
                end = find_block(text, b.end() - 1)
                branches.append((int(b.group(1)), text[b.start():end]))
                pos = end
            chain = ''
            for n, body in branches:
                if n not in CLAN_SELECT:
                    continue
                body = re.sub(r'^\s*\}?\s*(?:else\s+)?if \(%s == \d+\) \{' % v,
                              ('if' if not chain else ' else if') + ' (NarutoShippudenModVariables.get(entity).selectclanrelease == %d) {' % CLAN_SELECT[n], body)
                chain += body
            text = text[:first.start()] + chain + text[pos:]
        # the arrows wrap at the last clan
        top = max(CLAN_SELECT.values())
        text = text.replace(v.replace('\\', '') + ' == 25', v.replace('\\', '') + ' == %d' % top)
        m = re.search(r'class ClanReleaseMinusProcedure', text)
        if m:
            text = text[:m.end()] + text[m.end():].replace('double _setval = 25;', 'double _setval = %d;' % top, 1)
    elif path.replace('\\', '/').endswith('GuiDisplayProcedures.java'):
        text = re.sub(r'(%s == )(\d+)\)' % v, lambda m: m.group(1) + str(CLAN_SELECT.get(int(m.group(2)), 99)) + ')', text)
    return text


@func
def remove_clans(path, text):
    """Izuno, Kurama, Shimura (its Sharingan stays), Namikaze, Kazekage, Hatake, Otsutsuki, Senju, Tenro, Yuki, Hoshigaki and Kaguya
    are no longer clans: no scroll, techniques, clan paper roll or info card entry. Their weapons and eyes stay."""
    if not re.search('|'.join(GONE_CLANS), text):
        return text
    for name in GONE_CLAN_CLASSES:
        text = remove_class(text, name)
    text = clan_paper(text)
    text = clan_select(path, text)
    # the Tenro beast and Izuno cat modes: their per-tick blocks and player model swaps
    v = r'(?:false && )?NarutoShippudenModVariables\.get\(entity\)\.'
    text = remove_if_blocks(text, v + r'(?:tenromode|izunochakramode|izunocat|hoshigakireleaselogic) == true')
    names = '|'.join(GONE_CLAN_CLASSES)
    # the last entry of an array: keep its closing brace
    while True:
        cut = re.sub(r',(\s*\n[^\n]*\b(?:%s)\b[^\n]*\))\s*\};' % names, '};', text)
        if cut == text:
            break
        text = cut
    text = re.sub(r'\n[^\n]*\b(?:%s)\b[^\n]*(?:;|\),)(?=\n)' % names, '', text)
    return text


AKAMARU_GOALS = '''protected void registerGoals() {
				// a tamed wolf's mind: sits when told, follows, leaps and bites, defends its owner
				this.goalSelector.addGoal(1, new FloatGoal(this));
				this.goalSelector.addGoal(2, new net.minecraft.world.entity.ai.goal.SitWhenOrderedToGoal(this));
				this.goalSelector.addGoal(3, new net.minecraft.world.entity.ai.goal.LeapAtTargetGoal(this, 0.4F));
				this.goalSelector.addGoal(4, new MeleeAttackGoal(this, 1.2, true));
				this.goalSelector.addGoal(5, new FollowOwnerGoal(this, 1.1, 8F, 3F));
				this.goalSelector.addGoal(7, new net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal(this, 1));
				this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8F));
				this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
				this.targetSelector.addGoal(1, new OwnerHurtByTargetGoal(this));
				this.targetSelector.addGoal(2, new OwnerHurtTargetGoal(this));
				this.targetSelector.addGoal(3, new net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal(this));
			}'''

# Akamaru's form, seen by the client: 0 himself, 1 the Man Beast Clone (the owner's double), 2 a spinning fang (Fang Over Fang)
AKAMARU_FORM = '''public static final net.minecraft.network.syncher.EntityDataAccessor<Integer> FORM = net.minecraft.network.syncher.SynchedEntityData
					.defineId(CustomEntity.class, net.minecraft.network.syncher.EntityDataSerializers.INT);

			@Override
			protected void defineSynchedData(net.minecraft.network.syncher.SynchedEntityData.Builder builder) {
				super.defineSynchedData(builder);
				builder.define(FORM, 0);
			}

			public int form() {
				return this.entityData.get(FORM);
			}

			public void setForm(int form) {
				this.entityData.set(FORM, form);
			}

			'''

AKAMARU_INTERACT = '''public InteractionResult mobInteract(Player player, InteractionHand hand) {
				ItemStack stack = player.getItemInHand(hand);
				if (!this.isTame() || !this.isOwnedBy(player))
					return super.mobInteract(player, hand);
				if (this.isFood(stack) && this.getHealth() < this.getMaxHealth()) {
					if (!this.level().isClientSide()) {
						this.usePlayerItem(player, hand, stack);
						this.heal(8);
						this.level().broadcastEntityEvent(this, (byte) 7);
					}
					return InteractionResult.SUCCESS;
				}
				// right-click: sit / stand
				if (!this.level().isClientSide()) {
					this.setOrderedToSit(!this.isOrderedToSit());
					this.jumping = false;
					this.navigation.stop();
					this.setTarget(null);
				}
				return InteractionResult.SUCCESS;
			}'''


@func
def akamaru(path, text):
    """Akamaru thinks like a tamed wolf (client/jutsu/AkamaruRenderer animates his own model to match)."""
    if 'SummonEntities.java' in path:
        start = text.find('public static class AkamaruEntity')
        if start < 0:
            return text
        end = find_block(text, start)
        cls = text[start:end]
        for head, new in (('protected void registerGoals()', AKAMARU_GOALS), ('public InteractionResult mobInteract(', AKAMARU_INTERACT)):
            i = cls.find(head)
            if i >= 0:
                cls = cls[:i] + new + cls[find_block(cls, i):]
        cls = re.sub(r'public boolean isFood\(ItemStack stack\) \{.*?\n\t\t\t\}', 'public boolean isFood(ItemStack stack) {\n\t\t\t\treturn stack != null && stack.is(net.minecraft.tags.ItemTags.MEAT);\n\t\t\t}', cls, flags=re.S)
        if 'EntityDataAccessor<Integer> FORM' not in cls:
            i = cls.rfind('@Override', 0, cls.find('protected void registerGoals()'))
            cls = cls[:i] + AKAMARU_FORM + cls[i:]
        cls = re.sub(r'\n\t*AkamaruOnInitialEntitySpawnProcedure\.executeProcedure\([^;]*;', '', cls)
        text = text[:start] + cls + text[end:]
    if 'SummonRenderers.java' in path:
        text = re.sub(r'\n\t*ModRenderers\.mob\(event, AkamaruEntity\.entity,[^\n]*', '\n\t\t\t// drawn by client.jutsu.AkamaruRenderer', text)
    return text


@func
def kamui_phasing_tick(path, text):
    """core/jutsu/DojutsuJutsu phases the player through walls itself (client-side, where the player moves); the old tick flew the
    player along their look on the server and turned collisions back on every tick."""
    if not path.replace('\\', '/').endswith('PlayerProcedures.java'):
        return text
    text = text.replace('if (NarutoShippudenModVariables.get(entity).KamuiPhantomPhase == true) {', 'if (false) {')
    return text.replace('} else if (NarutoShippudenModVariables.get(entity).KamuiPhantomPhase == false) {', '} else if (false) {')


@func
def kokugan_name(path, text):
    """Isshiki's dojutsu is called by its real name, the Kokugan (the ids keep "isshiki_dojutsu")."""
    return text.replace("Isshiki's Dojutsu", 'Kokugan').replace('Isshiki Dojutsu', 'Kokugan')


@func
def akimichi_swaps(path, text):
    """client/jutsu/AkimichiRenderer draws the Human Bullet Tanks and Butterfly Mode's wings; drop the old player model swaps."""
    if not path.replace('\\', '/').endswith('PlayerProcedures.java'):
        return text
    return remove_if_blocks(text, r'NarutoShippudenModVariables\.get\(entity\)\.(?:HumanBulletTank|SpikedHumanBulletTank|ButterflyMode) == true')


WEAPON_RENDERERS = ['ShurikenBullet', 'ShurikenClan', 'FumaShurikenBullet', 'FumaShurikenClan', 'ToroiUniqueFumaShurikenBullet', 'ToroiUniqueFumaShurikenClan',
                    'KunaiBullet', 'PoisonKunaiBullet', 'ExplosiveKunaiBullet', 'FlyingThunderGodKunaiBullet']


@func
def weapon_renderers(path, text):
    """Thrown shuriken and kunai are drawn by client/jutsu/WeaponRenderer (steel models like the Fuma shuriken jutsu)."""
    if not path.replace('\\', '/').endswith('ModClient.java'):
        return text
    return re.sub(r'\n\t*ProjectileRenderers\.(?:%s)Renderer\.registerRenderers\(event\);' % '|'.join(WEAPON_RENDERERS), '', text)


# the Shurikenjutsu each thrown weapon needs: the basic shuriken and kunai need none (a new ninja starts at 0)
WEAPON_SKILL = {'ShurikenRightclickedProcedure': 0, 'KunaiRightclickedProcedure': 0, 'PoisonKunaiRightclickedProcedure': 5,
                'ExplosiveKunaiRightclickedProcedure': 10, 'FumaShurikenRightclickedProcedure': 15}


@func
def weapon_skill(path, text):
    """Lower the Shurikenjutsu needed to throw the basic weapons."""
    if not path.replace('\\', '/').endswith('WeaponProcedures.java'):
        return text
    for name, need in WEAPON_SKILL.items():
        m = re.search(r'public static class %s\b' % name, text)
        if not m:
            continue
        end = find_block(text, m.end())
        body = text[m.start():end]
        body = re.sub(r'shurikenjutsu >= \d+\)', 'shurikenjutsu >= %d)' % need, body)
        body = re.sub(r'shurikenjutsu <= \d+\)', 'shurikenjutsu <= %d)' % (need - 1), body)
        text = text[:m.start()] + body + text[end:]
    return text


# ---------------------------------------------------------------- chakra control, dashes and jutsu power (core/ChakraControl)
OLD_KEYS = ['BackDash', 'ForwardDash', 'LeftDash', 'RightDash', 'UpDash', 'ChakraControl', 'JutsuPower']


@func
def old_keys(path, text):
    """The five double-tap dash keys (bound over WASD and Space), the old Chakra Control key and the Jutsu Power key go: client/EyeKeys
    has Chakra Control and one Dash key, and jutsu power follows Ninjutsu."""
    if not path.replace('\\', '/').endswith('ModKeyMappings.java'):
        return text
    for name in OLD_KEYS:
        text = re.sub(r'\n[^\n]*\b%sKEYBINDING\b[^\n]*;(?=\n)' % name.upper(), '', text)
        text = re.sub(r'\n[^\n]*\b%sKeyBinding_lastpress\b[^\n]*;(?=\n)' % name, '', text)
        text = re.sub(r'\n[^\n]*\bon%sKeyBinding\(event\);(?=\n)' % name, '', text)
        m = re.search(r'\n\tprivate static void on%sKeyBinding\(' % name, text)
        if m:
            text = text[:m.start()] + text[find_block(text, m.end()):]
    return text


@func
def chakra_control_tick(path, text):
    """core/ChakraControl does the water and wall walking; the old tick switched gravity off on water and flew the player up walls."""
    if not path.replace('\\', '/').endswith('PlayerProcedures.java'):
        return text
    return re.sub(r'if \(NarutoShippudenModVariables\.get\(entity\)\.Chakra_Control == true\) \{(?=\s*\n\s*if \(NarutoShippudenModVariables\.get\(entity\)\.WallClimb == false\))',
                  'if (false) {', text)


@func
def jutsu_power(path, text):
    """The old jutsu read a chosen power tier (0-9, raised with its own stat and key); it now follows Ninjutsu."""
    return re.sub(r'NarutoShippudenModVariables\.get\((\w+)\)\.jutsupower\b', r'net.mcreator.narutoshippudenmod.core.jutsu.engine.Techniques.jutsuPower(\1)', text)


# ---------------------------------------------------------------- the Inuzuka wolf transformations are gone (Inuzuka has new jutsu)
WOLF_CLASSES = ['TwoHeadAkamaruEntity', 'ThreeHeadAkamaruEntity', 'TwoHeadAkamaruRenderer', 'ThreeHeadAkamaruRenderer']


@func
def inuzuka_wolves(path, text):
    """Remove the Double- and Three-Headed Wolf mobs, their models and the player model swaps."""
    if not re.search(r'TwoHeadAkamaru|ThreeHeadAkamaru', text):
        return text
    for name in WOLF_CLASSES:
        text = remove_class(text, name)
    text = re.sub(r'\n[^\n]*\b(?:%s)\b[^\n]*;(?=\n)' % '|'.join(WOLF_CLASSES), '', text)
    return remove_if_blocks(text, r'NarutoShippudenModVariables\.get\(entity\)\.inuzuka_mode == [12]')


# ---------------------------------------------------------------- messages the vanilla way
# short feedback goes above the hotbar (like "You can sleep only at night"), in plain sentence case; story, quests and letters stay in chat
FEEDBACK = re.compile(r"^(?:Not Enough|[-+]\d+ |You(?: haven't| have to| already| can only| can use| failed| succesfully|'ve already)|.* implanted |.*: (?:On|Off)$"
                      r"|Activate|Deactivate|(?:The )?(?:Sharingan|Byakugan|Rinnegan|Tenseigan|Ketsuryugan|Kokugan|Mangekyou Sharingan)!$|Wait For Newer"
                      r"|Find Flat|Check price|Press Learn|Take your custom|Name your jutsu|Chakra Control|Selected)")
DOJUTSU_NAMES = {'sharingan': 'the Sharingan', 'byakugan': 'the Byakugan', 'tenseigan': 'the Tenseigan', 'ketsuryugan': 'the Ketsuryugan',
                 'isshiki dojutsu': 'the Kokugan', 'rinnegan': 'the Rinnegan'}


def vanilla_text(t):
    t = re.sub(r'\\u00A7.', '', t)
    t = re.sub(r'^Not Enough (\w+) \((\d+) Required\)$', r'Not enough \1 (\2 needed)', t)
    t = re.sub(r'^Not Enough ', 'Not enough ', t).replace('Not enough Chakra', 'Not enough chakra')
    t = re.sub(r'^(.+): On$', r'\1 on', t)
    t = re.sub(r'^(.+): Off$', r'\1 off', t)
    t = re.sub(r'^(\w+ Release) implanted succesfully$', r'\1 implanted', t)
    t = re.sub(r'^(\w+ Release) implanted failed$', r'Implanting \1 failed', t)
    t = re.sub(r'^Activate Gate Of (\w+)$', r'Open the Gate of \1 first', t)
    t = re.sub(r"^You've already unlocked (.+?)\.?$", lambda m: "You've already unlocked " + DOJUTSU_NAMES.get(m.group(1), m.group(1)), t)
    t = t.replace('succesfully', 'successfully').replace('LvL XP', 'XP').replace('Susano"', 'Susanoo"')
    # a jutsu or eye chosen shows just its name, like the held item's name above the hotbar
    t = re.sub(r'^Selected: ', '', t)
    t = re.sub(r'^(?:The )?(Sharingan|Byakugan|Rinnegan|Tenseigan|Ketsuryugan|Kokugan|Mangekyou Sharingan)!$', r'\1 activated', t)
    t = {'Wait For Newer Updates': 'Not available yet', 'Find Flat Place': 'Find a flat place', 'Susano': 'Susanoo',
         'You haven\'t unlocked Susano': 'You haven\'t unlocked Susanoo'}.get(t, t)
    if t.endswith('.') and not t.endswith('..'):
        t = t[:-1]
    return t


@func
def vanilla_messages(path, text):
    def system(m):
        t = m.group(1)
        plain = re.sub(r'\\u00A7.', '', t)
        if not FEEDBACK.match(plain) or 'awakened' in plain:
            return m.group(0)
        return 'sendOverlayMessage(Component.literal("%s")' % vanilla_text(t)

    text = re.sub(r'sendSystemMessage\(Component\.literal\("([^"\\]*(?:\\.[^"\\]*)*)"\)', system, text)
    return re.sub(r'sendOverlayMessage\(Component\.literal\("([^"\\]*(?:\\.[^"\\]*)*)"\)', lambda m: 'sendOverlayMessage(Component.literal("%s")' % vanilla_text(m.group(1)), text)


@func
def sneak_charge(path, text):
    """Sneaking no longer charges chakra with a cloud of blue particles: Chakra Control's focus (sneak and stand still) does that."""
    if not path.replace('\\', '/').endswith('PlayerProcedures.java'):
        return text
    text = re.sub(r'\n\t*ChakraChargingParticlesProcedure\.executeProcedure\(Stream[^;]*;', '', text)
    return text.replace('double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount + 0.5);',
                        'double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount + 0.25);')


# ---------------------------------------------------------------- the separate Drunken Fist item (the jutsu is the first on the Lee wheel)
@func
def drunken_fist_item(path, text):
    """Remove Lee Release: Drunken Fist, the item: Drunken Fist is cast from the Lee technique like the Eight Gates."""
    if 'LeeReleaseDrunkenFist' not in text:
        return text
    text = remove_class(text, 'LeeReleaseDrunkenFistItem')
    text = remove_class(text, 'LeeReleaseDrunkenFistRightclickedProcedure')
    return text.replace('new ItemStack(LeeReleaseDrunkenFistItem.block)', 'ItemStack.EMPTY')


# ---------------------------------------------------------------- shadow clones (core/jutsu/ShadowClones, client/jutsu/ShadowCloneRenderer)
@func
def shadow_clones(path, text):
    """The Shadow Clone Technique casts core/jutsu/ShadowClones (outside the story mode's exam), and clones wear their maker's skin."""
    p = path.replace('\\\\', '/')
    if p.endswith('ModClient.java'):
        return re.sub(r'\n\t*JutsuRenderers\.ShadowCloneRenderer\.registerRenderers\(event\);', '', text)
    if not p.endswith('ClanProcedures.java'):
        return text
    m = re.search(r'public static class ShadowCloneTechniqueRightclickedProcedure\b', text)
    if not m:
        return text
    end = find_block(text, m.end())
    body = text[m.start():end]
    body = re.sub(r'if \(!\(NarutoShippudenModVariables\.get\(entity\)\.storymode == 14\)\s*&& !\(NarutoShippudenModVariables\.get\(entity\)\.storymode == 5\)\) \{',
                  'if (!(NarutoShippudenModVariables.get(entity).storymode == 14) && !(NarutoShippudenModVariables.get(entity).storymode == 5)) {\n'
                  '\t\t\t\t\t\tnet.mcreator.narutoshippudenmod.core.jutsu.ShadowClones.cast(entity);\n\t\t\t\t\t} else if (false) {', body, count=1)
    return text[:m.start()] + body + text[end:]


# ---------------------------------------------------------------- the old story mode (removed: a new story replaces it)
STORY_VARS = r'(?:storymode|StorymodeCooldown|StoryModeGeninFight|directionstorymode)'


@func
def remove_story(path, text):
    """The old Story Mode is gone: its item and 22 steps (dead_classes.txt), the steps' branches in the Shadow Clone exam, the
    Genin fight and Iruka's tick, the item given on first join, and every write of its variables."""
    if not re.search(r'\b%s\b|StoryModeItem' % STORY_VARS, text):
        return text
    get = r'NarutoShippudenModVariables\.get\(\w+\)\.'
    # Shadow Clone: outside the exam steps it always casts (see shadow_clones); the exam branches go
    text = re.sub(r'if \(!\(%sstorymode == 14\)\s*&& !\(%sstorymode == 5\)\) \{' % (get, get), 'if (true) {', text)
    text = remove_if_blocks(text, r'%sstorymode == \d+' % get)
    text = remove_if_blocks(text, r'false')
    # writes: { double _setval = ...; NarutoShippudenModVariables.ifPresent(e, capability -> { if (!equals(capability.storymode ...
    rx = re.compile(r'\{\s*(?:double|String) _setval = [^;]*;\s*NarutoShippudenModVariables\.ifPresent\(\w+, capability -> \{\s*'
                    r'if \(!java\.util\.Objects\.equals\(capability\.%s, _setval\)\)' % STORY_VARS)
    while (m := rx.search(text)):
        text = text[:m.start()].rstrip(' \t') + text[find_block(text, m.start()):]
    # the Story Mode item given on first join
    rx = re.compile(r'if \(entity instanceof Player\) \{\s*ItemStack _setstack = new ItemStack\(StoryModeItem\.block\);')
    while (m := rx.search(text)):
        text = text[:m.start()].rstrip(' \t') + text[find_block(text, m.start()):]
    text = re.sub(r'if \(true\) \{\s*(net\.mcreator\.narutoshippudenmod\.core\.jutsu\.ShadowClones\.cast\(entity\);)\s*\}', r'\1', text)
    text = re.sub(r'\n\t*double storyrandomclones = 0;', '', text)
    # the lines the removed blocks leave empty
    return re.sub(r'(\{|;)\n(?:[ \t]*\n)+(?=\t*\})', r'\1\n', re.sub(r'\{\n[ \t]+\n', '{\n', text))


# ---------------------------------------------------------------- Flying Raijin (core/jutsu/FlyingRaijin)
@func
def flying_raijin(path, text):
    """The Flying Thunder God kunai becomes Flying Raijin, a technique with a wheel (core/jutsu/FlyingRaijin); the thrown kunai's landing leaves a formula."""
    # right-click casts from the kunai's wheel (core/jutsu/Jutsus); left-click is a plain attack
    for hook in ('FlyingThunderGodKunaiRightclickedProcedure.executeProcedure(', 'FlyingThunderGodKunaiEntitySwingsItemProcedure.executeProcedure(',
                 'net.mcreator.narutoshippudenmod.core.jutsu.FlyingRaijin.use(', 'net.mcreator.narutoshippudenmod.core.jutsu.FlyingRaijin.swing('):
        text = text.replace(hook, 'net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(')
    return text.replace('FlyingThunderGodKunaiBulletProjectileHitsBlockProcedure.executeProcedure(', 'net.mcreator.narutoshippudenmod.core.jutsu.FlyingRaijin.landed(this, ')


# the highest each stat can be raised to with SP (the check fires one above it)
STAT_CAPS = {'shurikenjutsu': 40}


@func
def stat_caps(path, text):
    """Shurikenjutsu goes to 40 (it stopped at 25, which every weapon needed, leaving nothing to grow into)."""
    if not path.replace('\\', '/').endswith('PlayerProcedures.java'):
        return text
    for stat, cap in STAT_CAPS.items():
        text = re.sub(r'NarutoShippudenModVariables\.get\(entity\)\.%s >= \d+\) \{' % stat,
                      'NarutoShippudenModVariables.get(entity).%s >= %d) {' % (stat, cap + 1), text, count=1)
    return text


# ---------------------------------------------------------------- items the jutsu engine owns (core/jutsu/Jutsus cancels their right-click)
_ENGINE_ITEMS = None


def engine_items():
    """Every technique and release item registered in core/jutsu (JutsuTable and the jutsu classes)."""
    global _ENGINE_ITEMS
    if _ENGINE_ITEMS is not None:
        return _ENGINE_ITEMS
    ids = set()
    folder = os.path.join(os.path.dirname(os.path.abspath(__file__)), 'override', 'net', 'mcreator', 'narutoshippudenmod', 'core', 'jutsu')
    for name in os.listdir(folder):
        if not name.endswith('.java'):
            continue
        t = open(os.path.join(folder, name)).read()
        ids |= set(re.findall(r'\b(?:technique|release|mangekyou|Jutsus\.technique|Jutsus\.release)\("([a-z_]+)"', t))
        for n in re.findall(r'\bnature\("([a-z_]+)"', t):
            ids |= {n + '_release_technique', n + '_release'}
    _ENGINE_ITEMS = ids
    return ids


@func
def engine_item_hooks(path, text):
    """A technique or release item never runs its own use(): the engine casts (or opens the jutsu scroll) and cancels the click.
    Pointing those dead calls at ClanJutsu.unused lets the old right-click procedures go."""
    if '/item/' not in path.replace('\\', '/'):
        return text
    ids = engine_items()
    for m in reversed(list(re.finditer(r'public static class \w+ extends NarutoShippudenModElements\.ModElement \{\s*public static Item block;\s*static \{\s*'
                                       r'Registration\.holder\(Registries\.ITEM, "(\w+)"', text))):
        if m.group(1) not in ids:
            continue
        end = find_block(text, m.start())
        cls = text[m.start():end]
        u = cls.find('public InteractionResult use(')
        if u < 0:
            continue
        use_end = find_block(cls, u)
        body = re.sub(r'\b\w+Procedure\s*\.executeProcedure\(', 'net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(', cls[u:use_end])
        text = text[:m.start()] + cls[:u] + body + cls[use_end:] + text[end:]
    return text


@func
def engine_item_hit_hooks(path, text):
    """Hitting something with a technique item ran the old jutsu's hit procedure (Boil Release, Smoke Release) next to the new jutsu:
    technique and release items lose their hurtEnemy."""
    if '/item/' not in path.replace('\\', '/'):
        return text
    ids = engine_items()
    for m in reversed(list(re.finditer(r'public static class \w+ extends NarutoShippudenModElements\.ModElement \{\s*public static Item block;\s*static \{\s*'
                                       r'Registration\.holder\(Registries\.ITEM, "(\w+)"', text))):
        if m.group(1) not in ids:
            continue
        end = find_block(text, m.start())
        cls = text[m.start():end]
        h = re.search(r'\n\t*@Override\s*public void hurtEnemy\(', cls)
        if not h:
            continue
        cls = cls[:h.start()] + cls[find_block(cls, h.end()):]
        text = text[:m.start()] + cls + text[end:]
    return text


# ---------------------------------------------------------------- dead code: old procedures, projectiles and renderers nothing calls
DEAD_CLASSES = set(open(os.path.join(os.path.dirname(os.path.abspath(__file__)), 'dead_classes.txt')).read().split())


def dead_code(path, text):
    """Removes the member classes dead_code.py found unreachable (the MCreator jutsu the new engine replaced, the projectiles and
    summons only they spawned, and their renderers), with their imports and renderer registrations."""
    if not DEAD_CLASSES:
        return text
    before = text
    text = _dead_code(path, text)
    # the gaps the removed classes leave
    return re.sub(r'\n(?:[ \t]*\n){2,}', '\n\n', text) if text != before else text


def _dead_code(path, text):
    names = '|'.join(sorted(DEAD_CLASSES))
    text = re.sub(r'\nimport [\w.]*\.(?:%s)(?:Window)?(?:\.\w+)*;' % names, '', text)
    p = path.replace('\\', '/')
    providers = p.endswith('client/ModParticleProviders.java')
    for name in DEAD_CLASSES:
        if re.search(r'public static class %s\b' % name, text) or providers and re.search(r'\n\tstatic class %s\b' % name, text):
            text = remove_class(text, name)
    if p.endswith('particle/ModParticles.java') or p.endswith('potion/ModEffects.java'):
        text = re.sub(r'\n\t*(?:%s)\.register\(\);' % names, '', text)
    if providers:
        text = re.sub(r'\n\t*event\.registerSpriteSet\(ModParticles\.(?:%s)\.particle, [^\n]*;' % names, '', text)
    text = re.sub(r'\n\t*[\w.]*\b(?:%s)\.register\w*\(event\);' % names, '', text)
    if path.replace('\\', '/').endswith('client/ModClient.java'):
        # a removed GUI's screen registration: event.register(XGui.containerType, XGuiWindow::new);
        text = re.sub(r'\n\t*event\.register\((?:%s)\.containerType, \w+::new\);' % names, '', text)
    return text


RULES.append(dead_code)


@func
def shadow_imitation_guard(path, text):
    """A Shadow Imitation entity reads its rider and owner every tick; one left without them (saved mid-jutsu, or summoned) crashed the
    server on load. It now just disappears."""
    if not path.replace('\\', '/').endswith('ClanProcedures.java'):
        return text
    return re.sub(r'(public static class ShadowImitationEntity\w*OnEntityTickUpdateProcedure \{.*?Entity entity = \(Entity\) dependencies\.get\("entity"\);)',
                  r'\1\n\t\t\tif (entity.getVehicle() == null || !(entity instanceof TamableAnimal _tamed && _tamed.getOwner() != null)) {'
                  r'\n\t\t\t\tif (!entity.level().isClientSide())\n\t\t\t\t\tentity.discard();\n\t\t\t\treturn;\n\t\t\t}', text, flags=re.S)


@func
def custom_jutsu_textures(path, text):
    """The Custom Jutsu projectiles (and a fireball) pointed at textures/<name>.png; the files are in textures/entities/."""
    return re.sub(r'"naruto_shippuden:textures/((?:custom_\w+_jutsu(?:_wave)?|fireball)(?:\.png)?)"', r'"naruto_shippuden:textures/entities/\1"', text)


# ---------------------------------------------------------------- Iburi is gone; its place (clan roll, select screen, info card) is the Yamanaka clan's
def iburi_is_yamanaka(path, text):
    """The Iburi clan was removed and the Yamanaka clan added in its slot: its paper roll, select entry and info icon now give the
    Yamanaka scroll (core/jutsu/ClanJutsu registers its jutsu). The Iburi scroll's own procedure (it sold Smoke Release) goes."""
    if 'iburi' not in text.lower():
        return text
    text = remove_class(text, 'IburiReleaseRightclickedProcedure')
    text = re.sub(r'\nimport [\w.]*\.IburiReleaseRightclickedProcedure;', '', text)
    text = re.sub(r'\bIburiReleaseRightclickedProcedure\s*\.executeProcedure\(', 'net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(', text)
    return text.replace('Iburi', 'Yamanaka').replace('iburi_release', 'yamanaka_release').replace('iburireleaselogic', 'yamanakareleaselogic')


RULES.append(iburi_is_yamanaka)


@func
def old_magnet_models(path, text):
    """The iron sand coat, arms and wings are drawn by client/jutsu/IronSandRenderer (a vanilla-style layer); the old model swaps
    drew their own on top."""
    if not path.replace('\\', '/').endswith('PlayerProcedures.java'):
        return text
    return re.sub(r'(?<!false && )(NarutoShippudenModVariables\.get\(entity\)\.magnet_coat == [123]\) \{\s*(?:if \(entity\.isShiftKeyDown\(\)\) \{\s*)?if \(_evt\.getRenderer\(\))',
                  r'false && \1', text)


# ---------------------------------------------------------------- weapons: core/jutsu/Weapons does their arts, flows and passives
WEAPON_ITEMS = {'chakra_blade', 'white_light_chakra_sabre', 'kusanagi_sasuke', 'gunbai', 'gunbai_block', 'triple_blade_scythe', 'samehada',
                'kubikiribocho', 'hiramekarei', 'hiramekarei_splitted', 'hiramekarei_hammer_form', 'kabutowari', 'kiba_sword', 'nuibari', 'shibuki',
                'shichiseiken', 'tanto', 'katana'}


@func
def weapon_old_procedures(path, text):
    """The weapons' old procedures (dropping the weapon without enough Kenjutsu, chakra drains, the sneak-toggled modes, on-hit and
    on-swing effects) are replaced by core/jutsu/Weapons: every procedure call in their item classes points at ClanJutsu.unused."""
    if '/item/' not in path.replace('\\', '/'):
        return text
    for m in reversed(list(re.finditer(r'public static class \w+ extends NarutoShippudenModElements\.ModElement \{\s*public static Item block;\s*static \{\s*'
                                       r'Registration\.holder\(Registries\.ITEM, "(\w+)"', text))):
        if m.group(1) not in WEAPON_ITEMS:
            continue
        end = find_block(text, m.start())
        cls = re.sub(r'\b\w+Procedure\s*\.executeProcedure\(', 'net.mcreator.narutoshippudenmod.core.jutsu.ClanJutsu.unused(', text[m.start():end])
        text = text[:m.start()] + cls + text[end:]
    return text


@func
def weapon_old_sharpness(path, text):
    """The old modes left sharpness tags on the swords (FlyingSwallowSharp, KusanagiSharp...) that the attribute procedure turned into
    permanent bonus damage and reach; the flows in core/jutsu/Weapons add theirs only while they last."""
    if not path.replace('\\', '/').endswith('WeaponProcedures.java'):
        return text
    i = text.find('public static class WeaponDamageModifierProcedure')
    if i < 0:
        return text
    end = find_block(text, i)
    cls = re.sub(r'(?<!false && )(itemstack\.getItem\(\) == (?:HiramekareiItem|KusanagiSasukeItem|WhiteLightChakraSabreItem|ChakraBladeItem)\.block)',
                 r'false && \1', text[i:end])
    return text[:i] + cls + text[end:]


# ---------------------------------------------------------------- the hidden village shinobi fight with core/jutsu/ShinobiAI
SHINOBI = ('HiddenLeafShinobiEntity', 'HiddenMistShinobiEntity', 'HiddenSandShinobiEntity', 'HiddenStoneShinobiEntity', 'HiddenCloudShinobiEntity')


@func
def shinobi_ai(path, text):
    """The village shinobi's goals (melee only) and tick procedure (jutsu fired on a timer) are replaced by ShinobiAI: ranks, footwork,
    hand signs, kunai, Substitution and Body Flicker, and the same jutsu players use. Their client learns when signs are woven."""
    if not path.replace('\\', '/').endswith('entity/NpcEntities.java'):
        return text
    ai = 'net.mcreator.narutoshippudenmod.core.jutsu.ShinobiAI'
    for name in SHINOBI:
        i = text.find('public static class %s ' % name)
        if i < 0:
            continue
        end = find_block(text, i)
        cls = text[i:end]
        g = cls.find('protected void registerGoals()')
        if g >= 0 and ai not in cls[g:find_block(cls, g)]:
            ge = find_block(cls, g)
            cls = cls[:g] + 'protected void registerGoals() {\n\t\t\t\tsuper.registerGoals();\n\t\t\t\t%s.goals(this, this.goalSelector, this.targetSelector);\n\t\t\t}' % ai + cls[ge:]
        cls = re.sub(r'Hidden\w+ShinobiOnEntityTickUpdateProcedure\s*\.executeProcedure\(Stream.*?Map::putAll\)\);', ai + '.tick(this);', cls, flags=re.S)
        cls = re.sub(r'(NarutoShippudenEntityChakraProcedure\.executeProcedure\(Stream.*?Map::putAll\)\);)(\s*return retval;)',
                     r'\1\n\t\t\t\t%s.spawned(this);\2' % ai, cls, count=1, flags=re.S) if ai + '.spawned' not in cls else cls
        if 'handleEntityEvent' not in cls:
            cls = cls.replace('\t\t\t@Override\n\t\t\tpublic net.minecraft.sounds.SoundEvent getHurtSound(',
                              '\t\t\t@Override\n\t\t\tpublic void handleEntityEvent(byte id) {\n\t\t\t\tif (!%s.clientEvent(this, id))\n\t\t\t\t\tsuper.handleEntityEvent(id);\n\t\t\t}\n\n'
                              '\t\t\t@Override\n\t\t\tpublic net.minecraft.sounds.SoundEvent getHurtSound(' % ai, 1)
        text = text[:i] + cls + text[end:]
    return text


@func
def shinobi_renderer(path, text):
    """The village shinobi are drawn by client/ShinobiRenderer: their own model and skin, plus arm poses (hand signs, strikes, throws)
    and the kunai in their hand."""
    if not path.replace('\\', '/').endswith('renderer/NpcRenderers.java'):
        return text
    return re.sub(r'ModRenderers\.mob\(event, (Hidden\w+ShinobiEntity)\.entity, ModelPlayer_Model\.LAYER, ModelPlayer_Model::new, 0\.5F, ',
                  r'net.mcreator.narutoshippudenmod.client.ShinobiRenderer.register(event, \1.entity, ModelPlayer_Model.LAYER, ModelPlayer_Model::new, '
                  r'm -> new net.minecraft.client.model.geom.ModelPart[] { m.root().getChild("transform0"), m.Head, m.Body, m.RightArm, m.LeftArm }, ', text)


@func
def kurama_ai(path, text):
    """Kurama's goals (a ranged attack goal firing the old Tailed Beast Bomb, a leap) and its every-tick Instant Health (which made it
    unkillable) are replaced by core/jutsu/Kurama. Its model, hitboxes and roar animation stay."""
    if not path.replace('\\', '/').endswith('entity/SummonEntities.java'):
        return text
    i = text.find('public static class KuramaEntity ')
    if i < 0:
        return text
    end = find_block(text, i)
    cls = text[i:end]
    k = 'net.mcreator.narutoshippudenmod.core.jutsu.Kurama'
    g = cls.find('protected void registerGoals()')
    if g >= 0 and k not in cls[g:find_block(cls, g)]:
        cls = cls[:g] + 'protected void registerGoals() {\n\t\t\t\tsuper.registerGoals();\n\t\t\t\t%s.goals(this, this.goalSelector, this.targetSelector);\n\t\t\t}' % k + cls[find_block(cls, g):]
    cls = re.sub(r'KuramaOnInitialEntitySpawnProcedure\s*\.executeProcedure\(Stream.*?Map::putAll\)\);', k + '.tick(this);', cls, flags=re.S)
    # no goal fires the old ranged attack (the Tailed Beast Bomb item) any more
    cls = cls.replace(' extends Monster implements RangedAttackMob {', ' extends Monster {')
    r = cls.find('public void performRangedAttack(')
    if r >= 0:
        cls = cls[:cls.rfind('\n', 0, r)] + cls[find_block(cls, r):]
    return text[:i] + cls + text[end:]


@func
def old_stat_attributes(path, text):
    """Medicine and Speed set max health and speed with /attribute commands naming generic.max_health and generic.movement_speed,
    which no longer exist (so the stats did nothing). core/Stats applies them as attribute modifiers instead."""
    return re.sub(r'\n\t*Compat\.runCommandAt\(world, x, y, z, \("/attribute " \+ entity\.getDisplayName\(\)\.getString\(\)\s*\+ " minecraft:generic\.(?:max_health|movement_speed) base set "[^;]*;',
                  '', text)


# The buttons each hand-written screen (gui/*Screens) still sends to its generated GUI's handleButtonAction; the other branches are
# old MCreator buttons nobody can press any more (the Jutsu page has none: it works through core/NarutoActions). Not listed: the
# advent calendar and the mini-game, which use all theirs.
GUI_BUTTONS = {
    'NarutoShippudenCheatGUIGui': set(),
    'NarutoShippudenCheatDojutsuGUIGui': {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17},
    'NarutoShippudenCheatKekkeiGenkaiGUIGui': set(range(16)),
    'MangekyouSharinganCheatGui': set(range(6)),
    'PasswordGUIDojutsuGui': {0},
    'GeninHeadbandSelectGui': {0, 1, 2},
    'PatreonKitGui': {0},
    'InfoCardGui': set(),
    'InfoCardUpgradeGui': set(),
    'InfoCardMissionsGui': set(),
    'InfoCardDojutsuGui': set(range(1, 10)),
    'StatSelectGui': {0, 1, 2, 3, 4, 5, 6},
    'CreateJutsuGUIGui': set(),
    'CreateJutsuGUI2Gui': set(),
}


@func
def unused_gui_buttons(path, text):
    """Drops the handleButtonAction branches of buttons the new screens no longer have (see GUI_BUTTONS), so the old procedures
    they called can go as dead code."""
    if not re.search(r'gui/\w+Guis\.java$', path.replace('\\', '/')):
        return text
    for name, used in GUI_BUTTONS.items():
        m = re.search(r'public static class %s extends' % name, text)
        if not m:
            continue
        end = find_block(text, m.start())
        h = text.find('static void handleButtonAction(', m.start(), end)
        if h < 0:
            continue
        hend = find_block(text, h)
        body = text[h:hend]
        while True:
            b = next((x for x in re.finditer(r'\n\t*if \(buttonID == (\d+)\) \{', body) if int(x.group(1)) not in used), None)
            if not b:
                break
            body = body[:b.start()] + body[find_block(body, b.end() - 1):]
        text = text[:h] + body + text[hend:]
    return text


# ---------------------------------------------------------------- DNA (core/jutsu/Dna)
@func
def dna_items(path, text):
    """DNA items are handled by core/jutsu/Dna (identifying, implanting by Medicine, kekkei genkai needing their natures): they lose
    their own use() and hurtEnemy(), which ran the old coin-flip procedures."""
    if not path.replace('\\', '/').endswith('item/DnaItems.java'):
        return text
    for sig in ('public InteractionResult use(', 'public void hurtEnemy('):
        while True:
            i = text.find(sig)
            if i < 0:
                break
            start = text.rfind('\n', 0, text.rfind('@Override', 0, i))
            text = text[:start] + text[find_block(text, i):]
    return text


@func
def old_dna_drop(path, text):
    """Any creature killed had a chance (config dna_drop) to drop Undefined DNA; now shinobi drop it (core/jutsu/Dna)."""
    if not path.replace('\\', '/').endswith('procedures/EntityProcedures.java') or '"dna_drop"' not in text:
        return text
    d = text.index('"dna_drop"')
    start = text.rfind('NarutoShippuden = (File) new File(', 0, d)
    block = text.index('{', text.index(';', start))
    end = find_block(text, block)
    return text[:text.rfind('\n', 0, start)] + text[end:]


# ---------------------------------------------------------------- the config (core/NarutoConfig)
CONFIG_KEYS = {
    'clan_random': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.randomClan()',
    'kekkei_genkai_spawn_chance': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.kekkeiGenkaiAtBirth()',
    'sharingan_awake': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.seconds(net.mcreator.narutoshippudenmod.core.NarutoConfig.SHARINGAN)',
    'mangekyou_sharingan_awake': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.seconds(net.mcreator.narutoshippudenmod.core.NarutoConfig.MANGEKYOU_SHARINGAN)',
    'byakugan_awake': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.seconds(net.mcreator.narutoshippudenmod.core.NarutoConfig.BYAKUGAN)',
    'ketsuryugan_awake': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.seconds(net.mcreator.narutoshippudenmod.core.NarutoConfig.KETSURYUGAN)',
    'tenseigan_awake': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.seconds(net.mcreator.narutoshippudenmod.core.NarutoConfig.TENSEIGAN)',
    'rinnegan_awake': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.seconds(net.mcreator.narutoshippudenmod.core.NarutoConfig.RINNEGAN)',
    'isshiki_dojutsu_awake': 'net.mcreator.narutoshippudenmod.core.NarutoConfig.seconds(net.mcreator.narutoshippudenmod.core.NarutoConfig.KOKUGAN)',
}


@func
def config_reads(path, text):
    """The procedures read config/narutoshippuden/narutoshippudenconfig.json from disk each time (the player tick every tick), and a
    missing key crashed them. They now read core/NarutoConfig, in memory; the procedure that wrote the old file's defaults goes."""
    text = remove_class(text, 'NarutoshippudenconfigProcedure')
    while True:
        m = re.search(r'\n[ \t]*NarutoShippuden = \(File\) new File\([^;]*"narutoshippudenconfig\.json"\);\s*\{\s*try \{', text)
        if not m:
            break
        outer = text.rindex('{', 0, text.index('try {', m.start()))
        outer_end = find_block(text, outer)
        try_open = text.index('try {', m.start()) + 4
        try_end = find_block(text, try_open)
        parsed = text.index('mainjsonobject = new Gson().fromJson(', try_open)
        body = text[text.index(';', parsed) + 1:try_end - 1].rstrip()
        text = text[:m.start()] + body + text[outer_end:]

    def value(k):
        key = k.group(1)
        if key not in CONFIG_KEYS:
            raise KeyError('config key without a NarutoConfig value: ' + key)
        return CONFIG_KEYS[key]
    return re.sub(r'mainjsonobject\s*\.get\("(\w+)"\)\s*\.getAs(?:Double|Boolean)\(\)', value, text)


@func
def headband_hat(path, text):
    """A headband's model starts from the player mesh, whose head carries the hat layer (a cube a little bigger than the head); the
    headband's head replaced the head but kept that hat, which drew stray bits of the band texture beside the head, like an
    overlay. The hat is now empty."""
    if not path.replace('\\', '/').endswith('client/ArmorModels.java'):
        return text
    return re.sub(r'(\n(\t*)PartDefinition (p\d+) = root\.addOrReplaceChild\("head", [^\n]*\);)(?!\n\t*\3\.addOrReplaceChild\("hat")',
                  r'\1\n\2\3.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);', text)


@func
def sync_on_change(path, text):
    """The procedures set a variable and sync every time, even to the value it already has: the player tick copied health into the
    variables each tick, so every player was sent all their variables 20 times a second. A sync now happens only on a change."""
    return re.sub(r'ifPresent\((\w+), capability -> \{(\s*)capability\.(\w+) = _setval;\s*capability\.syncPlayerVariables\(\1\);(\s*)\}\);',
                  r'ifPresent(\1, capability -> {\2if (!java.util.Objects.equals(capability.\3, _setval)) {\2\tcapability.\3 = _setval;\2\tcapability.syncPlayerVariables(\1);\2}\4});',
                  text)


@func
def gamemode_check(path, text):
    """The procedures checked a game mode with an inline object that asked the client's player list (Minecraft, PlayerInfo): client-only
    classes in server code, which can crash a dedicated server. compat/Compat.isGameMode does it safely. The cheat menu now needs
    operator rights rather than creative mode."""
    rx = re.compile(r'new Object\(\) \{\s*public boolean checkGamemode\(Entity _ent\) \{.*?GameType\.(\w+);.*?return false;\s*\}\s*\}\.checkGamemode\((\w+)\)', re.S)
    text = rx.sub(r'net.mcreator.narutoshippudenmod.compat.Compat.isGameMode(\2, GameType.\1)', text)
    i = text.find('public static class CheatGUIProcedure ')
    if i >= 0:
        end = find_block(text, i)
        cls = text[i:end].replace('net.mcreator.narutoshippudenmod.compat.Compat.isGameMode(entity, GameType.CREATIVE)',
                                  '(entity instanceof ServerPlayer _op && net.mcreator.narutoshippudenmod.core.NarutoActions.canCheat(_op))')
        cls = cls.replace('"To use this command you have to be in creative."', '"Cheats need operator rights."')
        text = text[:i] + cls + text[end:]
    return text


@func
def tick_only_own_player(path, text):
    """The procedures' player tick ran on every player a client has, other players' copies too, which know none of their numbers
    (chakra 0 there): the Susanoo, draining chakra, switched itself off on everyone else's screen. On a client it now runs for the
    client's own player only; the server runs it for everyone."""
    return re.sub(r'(public static void onPlayerTick\(PlayerTickEvent\.\w+ event\) \{\s*)if \(true\) \{',
                  r'\1if (!(event.getEntity().level().isClientSide() && !event.getEntity().isLocalInstanceAuthoritative())) {', text)


@func
def training_dummy(path, text):
    """The training dummy is drawn by client/TrainingDummyClient (a vanilla-style straw dummy on a plank base that rocks when
    hit, no red flash) and sounds like the armor stand it is kin to, not like a hurt mob."""
    p = path.replace('\\', '/')
    if p.endswith('entity/renderer/NpcRenderers.java'):
        text = text.replace('ModRenderers.mob(event, TrainingDummyEntity.entity, ModelTrainingDummy.LAYER, ModelTrainingDummy::new, 0.3F, '
                            'Identifier.parse("naruto_shippuden:textures/entities/training_dummy.png"));',
                            'net.mcreator.narutoshippudenmod.client.TrainingDummyClient.register(event);')
        text = text.replace('event.registerLayerDefinition(ModelTrainingDummy.LAYER, ModelTrainingDummy::createBodyLayer);',
                            'net.mcreator.narutoshippudenmod.client.TrainingDummyClient.registerLayer(event);')
    elif p.endswith('entity/NpcEntities.java'):
        i = text.find('public static class TrainingDummyEntity ')
        if i >= 0:
            end = find_block(text, i)
            cls = text[i:end].replace('Compat.sound("entity.generic.hurt")', 'net.minecraft.sounds.SoundEvents.ARMOR_STAND_HIT')
            cls = cls.replace('Compat.sound("entity.generic.death")', 'net.minecraft.sounds.SoundEvents.ARMOR_STAND_BREAK')
            text = text[:i] + cls + text[end:]
    return text


@func
def chakra_paper_story(path, text):
    """Using the Chakra Paper tells the story (the Academy's Chakra Paper lesson waits for it)."""
    if not path.replace('\\', '/').endswith('item/StuffItems.java'):
        return text
    return text.replace('ChakraPaperRightclickedProcedure.executeProcedure(',
                        'net.mcreator.narutoshippudenmod.story.Story.chakraPaperUsed(entity);\n\t\t\t\tChakraPaperRightclickedProcedure.executeProcedure(', 1)


@func
def chakra_paper_in_lesson(path, text):
    """New players no longer get the Chakra Paper with their starting kit: Iruka hands it out in the Academy's Chakra
    Nature lesson (story/quests/chapter1/05_chakra_paper), where using it moves the story on."""
    if not path.replace('\\', '/').endswith('procedures/PlayerProcedures.java'):
        return text
    return re.sub(r'\n(\t*)if \(entity instanceof Player\) \{\s*ItemStack _setstack = new ItemStack\(ChakraPaperItem\.block\);\s*'
                  r'_setstack\.setCount\(\(int\) 1\);\s*Compat\.giveItemToPlayer\(\(\(Player\) entity\), _setstack\);\s*\}', '', text, count=1)
