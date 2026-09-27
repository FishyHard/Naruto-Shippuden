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
    while text.startswith('.', i):
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
    return i


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
sub(r'\.displayClientMessage\(([^;]+?),\s*\(?true\)?\);', r'.sendOverlayMessage(\1);', re.S)
sub(r'\.displayClientMessage\(([^;]+?),\s*\(?false\)?\);', r'.sendSystemMessage(\1);', re.S)
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
sub(r'(\b[\w.()]+?)\.getOrCreateTag\(\)', r'StackTag.of(\1)')
sub(r'(\b[\w.()]+?)\.getTag\(\)', r'StackTag.of(\1)')
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
@func
def object_holders(path, text):
    def repl(m):
        ind, name, typ, field = m.group(2), m.group(1), m.group(3), m.group(4)
        return '%spublic static %s %s;\n%sstatic {\n%s\tRegistration.holder("%s", v -> %s = (%s) v);\n%s}' % (ind, typ, field, ind, ind, name, field, typ, ind)
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
        holder = re.search(r'Registration\.holder\("(\w+)"', block)
        if not holder:
            return block
        name = holder.group(1)

        def make(m, chain, t, i):
            tail = re.match(r'\)\)\.setRegistryName\(block\.getRegistryName\(\)\)', t[i:])
            if not tail:
                return None
            return 'new BlockItem(block, %s.useBlockDescriptionPrefix())' % props_call(name, chain), i + tail.end()
        return rewrite_props(block, r'new BlockItem\(block, new Item\.Properties\(\)', make)
    return for_each_element(text, per_element)


@func
def spawn_eggs(path, text):
    def make(m, chain, t, i):
        tail = re.match(r'\)\)\s*\.setRegistryName\("(\w+)"\)', t[i:])
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
        for m in list(re.finditer(r'public static (?:final )?EntityType (\w+) = \((EntityType\.Builder\.<(\w+)>of\(.*?)\)\.build\("(\w+)"\)\.setRegistryName\("\w+"\);', block, re.S)):
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

# ---------------------------------------------------------------- opening GUIs
sub(r'NetworkHooks\.openGui\(\(ServerPlayer\) (\w+), ', r'((ServerPlayer) \1).openMenu(')
sub(r'\}, (_bpos|\w+Pos)\);', r'}, _buf -> _buf.writeBlockPos(\1));')

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
    'StackTag': 'net.mcreator.narutoshippudenmod.compat.StackTag',
    'ServerLevel': 'net.minecraft.server.level.ServerLevel',
    'Entity': 'net.minecraft.world.entity.Entity',
    'ResourceKey': 'net.minecraft.resources.ResourceKey',
    'PlayerTickEvent': 'net.neoforged.neoforge.event.tick.PlayerTickEvent',
    'ServerTickEvent': 'net.neoforged.neoforge.event.tick.ServerTickEvent',
    'LevelTickEvent': 'net.neoforged.neoforge.event.tick.LevelTickEvent',
    'ClientTickEvent': 'net.neoforged.neoforge.client.event.ClientTickEvent',
    'EventBusSubscriber': 'net.neoforged.fml.common.EventBusSubscriber',
    'NeoForge': 'net.neoforged.neoforge.common.NeoForge',
}


def ensure_imports(path, text):
    head, body = split_header(text)
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
