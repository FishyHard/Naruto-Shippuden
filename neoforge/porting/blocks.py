"""block/ModBlocks.java for 26.3: properties without Material, block entities, changed method signatures."""
import re
from rules import find_block, split_header, method_blocks, scan_chain, for_each_element

RENDER_TYPES = {}  # block name -> render type ("cutout", "translucent", ...)
MINEABLE = {}  # block name -> (tool, level)

MATERIAL_EXTRA = {'AIR': '.replaceable()', 'FIRE': '.replaceable()', 'WATER': '.replaceable()'}


def convert(path, text):
    head, body = split_header(text)

    def per_element(block):
        holder = re.search(r'Registration\.holder\(Registries\.BLOCK, "(\w+)"', block)
        if not holder:
            return block
        name = holder.group(1)
        # properties
        m = re.search(r'super\(Block\.Properties\.of\(Material\.(\w+)(?:, MaterialColor\.\w+)?\)', block)
        if m:
            chain_start = m.end()
            chain_end = scan_chain(block, chain_start)
            chain = block[chain_start:chain_end]
            tail = re.match(r'\);', block[chain_end:])
            harvest = re.search(r'\.harvestLevel\((\d+)\)\s*\.harvestTool\(ToolType\.(\w+)\)', chain)
            if harvest:
                MINEABLE[name] = (harvest.group(2).lower(), int(harvest.group(1)))
                chain = chain.replace(harvest.group(0), '.requiresCorrectToolForDrops()' if int(harvest.group(1)) > 0 else '')
            chain = chain.replace('.noCollission()', '.noCollision()').replace('.noDrops()', '.noLootTable()')
            chain = MATERIAL_EXTRA.get(m.group(1), '') + chain
            new = 'super(Registration.blockProps("%s", BlockBehaviour.Properties.of()%s));' % (name, chain)
            block = block[:m.start()] + new + block[chain_end + tail.end():]
            block = re.sub(r'\n\s*setRegistryName\("\w+"\);', '', block)
        # render layer -> recorded for the block model json
        rt = re.search(r'RenderTypeLookup\.setRenderLayer\(block, RenderType\.(\w+)\(\)\);', block)
        if rt:
            RENDER_TYPES[name] = {'cutoutMipped': 'cutout_mipped', 'cutout': 'cutout', 'translucent': 'translucent'}.get(rt.group(1), rt.group(1))
        block = re.sub(r'\n\s*@Override\s*\n\s*@OnlyIn\(Dist\.CLIENT\)\s*\n\s*public void clientLoad\(FMLClientSetupEvent event\) \{\s*RenderTypeLookup[^;]*;\s*\}', '', block)
        # block entity: minimal type carrying persistent data
        if 'class CustomTileEntity' in block:
            s0 = block.index('public static class CustomTileEntity')
            block = block[:s0] + '''public static class CustomTileEntity extends BlockEntity {
			public CustomTileEntity(BlockPos pos, BlockState state) {
				super(tileEntityType, pos, state);
			}
		}''' + block[find_block(block, s0):]
            block = re.sub(r'\n\s*public static class TileEntityRegisterHandler \{.*?\n\t\t\}\n', '\n', block, flags=re.S)
            block = block.replace('NarutoShippudenMod.MOD_BUS.register(new TileEntityRegisterHandler());',
                                  'Registration.add(Registries.BLOCK_ENTITY_TYPE, "%s", () -> new BlockEntityType<>(CustomTileEntity::new, block), null);' % name)
            block = block.replace('public static class CustomBlock extends Block {', 'public static class CustomBlock extends Block implements EntityBlock {')
            block = re.sub(r'\n\s*@Override\s*\n\s*public boolean hasTileEntity\(BlockState state\) \{\s*return true;\s*\}', '', block)
            block = re.sub(r'@Override\s*\n(\s*)public BlockEntity createTileEntity\(BlockState state, BlockGetter world\) \{\s*return new CustomTileEntity\(\);\s*\}',
                           r'@Override\n\1public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {\n\1\treturn new CustomTileEntity(pos, state);\n\1}', block)
            block = re.sub(r'\n\s*@Override\s*\n\s*public MenuProvider getMenuProvider\(BlockState state, Level worldIn, BlockPos pos\) \{.*?\n\t\t\t\}', '', block, flags=re.S)
            block = re.sub(r'\n\s*@Override\s*\n\s*public boolean triggerEvent\(BlockState state, Level world, BlockPos pos, int eventID, int eventParam\) \{.*?\n\t\t\t\}', '', block, flags=re.S)
        return block

    body = for_each_element(body, per_element)
    body = re.sub(r'public int getLightBlock\(BlockState (\w+), BlockGetter \w+, BlockPos \w+\)', r'protected int getLightDampening(BlockState \1)', body)
    body = re.sub(r'public boolean propagatesSkylightDown\(BlockState (\w+), BlockGetter \w+, BlockPos \w+\)', r'protected boolean propagatesSkylightDown(BlockState \1)', body)
    body = body.replace('LootContext.Builder builder', 'LootParams.Builder builder')
    body = re.sub(r'public void entityInside\(BlockState (\w+), Level (\w+), BlockPos (\w+), Entity (\w+)\)',
                  r'protected void entityInside(BlockState \1, Level \2, BlockPos \3, Entity \4, InsideBlockEffectApplier effectApplier, boolean isPrecise)', body)
    body = re.sub(r'super\.entityInside\((\w+), (\w+), (\w+), (\w+)\);', r'super.entityInside(\1, \2, \3, \4, effectApplier, isPrecise);', body)
    body = re.sub(r'(\w+)\.getOffset\(\w+, (\w+)\)', r'\1.getOffset(\2)', body)
    body = re.sub(r'public void stepOn\(Level (\w+), BlockPos (\w+), Entity (\w+)\)', r'public void stepOn(Level \1, BlockPos \2, BlockState onState, Entity \3)', body)
    body = re.sub(r'super\.stepOn\((\w+), (\w+), (\w+)\);', r'super.stepOn(\1, \2, onState, \3);', body)
    body = body.replace('public static class CustomBlock extends FallingBlock {', '''public static class CustomBlock extends FallingBlock {
			@Override
			public int getDustColor(BlockState state, BlockGetter level, BlockPos pos) {
				return -8356741;
			}
''')
    body = re.sub(r'\bEnumProperty FACING\b', 'EnumProperty<Direction> FACING', body)
    body = re.sub(r'(\w+)\.getBlockTicks\(\)\.scheduleTick\(', r'\1.scheduleTick(', body)
    imports = ['net.minecraft.world.level.block.state.BlockBehaviour', 'net.minecraft.world.level.block.EntityBlock',
               'net.minecraft.world.level.block.entity.BlockEntity', 'net.minecraft.world.level.block.entity.BlockEntityType',
               'net.minecraft.world.level.storage.loot.LootParams', 'net.minecraft.world.entity.InsideBlockEffectApplier',
               'net.minecraft.core.Direction', 'net.minecraft.core.registries.Registries', 'net.mcreator.narutoshippudenmod.compat.Registration']
    have = set(re.findall(r'^import ([\w.]+);', head, re.M))
    head = head.rstrip('\n') + '\n' + ''.join('import %s;\n' % i for i in imports if i not in have) + '\n'
    return head + body
