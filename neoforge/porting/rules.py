"""Ordered code transformation rules: each is fn(relpath, text) -> text."""
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
            val('getUses'), val('getSpeed'), val('getAttackDamageBonus'), val('getEnchantmentValue'))
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
