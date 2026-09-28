"""Regenerate item/ArmorItems.java (headband helmets with custom head models) for 26.3, plus client/ArmorModels.java."""
import re
import models
from rules import find_block, split_header, for_each_element

EQUIPMENT_ASSETS = []  # asset names needing assets/<ns>/equipment/<name>.json
CLIENT_ENTRIES = []  # (element class, item holder field, layer id, model code lines, texture)


def val(block, method):
    m = re.search(r'%s\([^)]*\)\s*\{\s*return ([^;]+);' % method, block)
    return m.group(1) if m else None


def convert(path, text):
    head, body = split_header(text)

    def per_element(block):
        if 'ArmorMaterial armormaterial' not in block:
            return block
        cls = re.search(r'public static class (\w+) extends', block).group(1)
        name = val(block, 'getName').strip('"')
        dur = re.search(r'getDurabilityForSlot[^{]*\{\s*return new int\[\]\{[^}]*\}\[slot\.getIndex\(\)\] \* (\d+);', block).group(1)
        defense = [x.strip() for x in re.search(r'getDefenseForSlot[^{]*\{\s*return new int\[\]\{([^}]*)\}', block).group(1).split(',')]
        tough = val(block, 'getToughness') or '0f'
        kb = val(block, 'getKnockbackResistance') or '0f'
        EQUIPMENT_ASSETS.append(name)
        material = ('new ArmorMaterial(%s, Map.of(ArmorType.BOOTS, %s, ArmorType.LEGGINGS, %s, ArmorType.CHESTPLATE, %s, ArmorType.HELMET, %s, '
                    'ArmorType.BODY, 0), 1, SoundEvents.ARMOR_EQUIP_GENERIC, %s, %s, ItemTags.REPAIRS_LEATHER_ARMOR, '
                    'ResourceKey.create(EquipmentAssets.ROOT_ID, Registration.id("%s")))' % (dur, defense[0], defense[1], defense[2], defense[3], tough, kb, name))
        # model classes kept in the element (1.16 form) -> parse for the client layer
        model_src = {}
        for mm in re.finditer(r'public static class (\w+) extends EntityModel<\w+> \{', block):
            model_src[mm.group(1)] = block[mm.start():find_block(block, mm.start())]
        pieces = []
        for mm in re.finditer(r'elements\.items\.add\(\(\) -> new ArmorItem\(armormaterial, EquipmentSlot\.(\w+), new Item\.Properties\(\)', block):
            chain_start = mm.end()
            # property chain then ') {' anonymous body then '.setRegistryName("x"))'
            i = chain_start
            depth = 0
            while True:
                c = block[i]
                if c == '(':
                    depth += 1
                elif c == ')':
                    if depth == 0:
                        break
                    depth -= 1
                i += 1
            chain = block[chain_start:i]
            body_start = i + 1
            body_end = find_block(block, body_start) if block[body_start:body_start + 2] == ' {' else body_start
            anon = block[body_start:body_end]
            item_name = re.match(r'\s*\.setRegistryName\("(\w+)"\)', block[body_end:]).group(1)
            pieces.append((mm.group(1), chain, anon, item_name))
        items = []
        for slot, chain, anon, item_name in pieces:
            tab = re.search(r'\.tab\(([\w.]+)\)', chain)
            tabname = '"%s"' % tab.group(1).split('.')[0] if tab and tab.group(1) != 'null' else 'null'
            rest = re.sub(r'\.tab\([\w.]+\)', '', chain)
            armor_type = {'HEAD': 'HELMET', 'CHEST': 'CHESTPLATE', 'LEGS': 'LEGGINGS', 'FEET': 'BOOTS'}[slot]
            # keep non-client overrides
            kept = []
            for om in re.finditer(r'@Override\s*\n(\s*@OnlyIn\(Dist\.CLIENT\)\s*\n)?\s*public [^(]* (\w+)\(', anon):
                if om.group(2) in ('getArmorModel', 'getArmorTexture'):
                    continue
                s0 = om.start()
                kept.append(anon[s0:find_block(anon, s0)])
            anon_body = ' {\n' + '\n'.join(kept) + '\n}' if kept else ''
            items.append('elements.items.add(() -> new Item(Registration.itemProps("%s", %s).humanoidArmor(MATERIAL, ArmorType.%s)%s)%s);'
                         % (item_name, tabname, armor_type, rest, anon_body))
            tex = re.search(r'getArmorTexture[^{]*\{\s*return "([^"]*)";', anon)
            model = re.search(r'armorModel\.head = new (\w+)\(\)\.(\w+);', anon)
            if model:
                parts, order, tw, th = models.parse_model(model.group(1), model_src[model.group(1)])
                code = models.emit_part(parts, model.group(2), 'root', part_name='head', pose_override='PartPose.ZERO')
                holder = re.search(r'Registration\.holder\((?:Registries\.\w+, )?"%s", v -> (\w+) =' % item_name, block).group(1)
                CLIENT_ENTRIES.append((cls, holder, item_name, code, tw, th, tex.group(1) if tex else None))
        # rebuild element: holders, constructor, material, initElements
        holders = re.findall(r'\t*public static Item \w+;\n\s*static \{\n[^}]*\}', block)
        ctor = re.search(r'public %s\(NarutoShippudenModElements instance\) \{.*?\n\t\t\}' % cls, block, re.S).group(0)
        sort_line = ctor
        out = ['public static class %s extends NarutoShippudenModElements.ModElement {' % cls]
        out += ['\t' + h.strip() for h in holders]
        out.append('\t\tpublic static final ArmorMaterial MATERIAL = %s;' % material)
        out.append('')
        out.append('\t\t' + sort_line)
        out.append('')
        out.append('\t\t@Override\n\t\tpublic void initElements() {')
        out += ['\t\t\t' + it for it in items]
        out.append('\t\t}')
        out.append('\t}')
        return '\n'.join(out)

    body = for_each_element(body, per_element)
    imports = ['java.util.Map', 'net.minecraft.world.item.equipment.ArmorMaterial', 'net.minecraft.world.item.equipment.ArmorType',
               'net.minecraft.world.item.equipment.EquipmentAssets', 'net.minecraft.sounds.SoundEvents', 'net.minecraft.tags.ItemTags',
               'net.minecraft.resources.ResourceKey', 'net.minecraft.world.item.Item', 'net.mcreator.narutoshippudenmod.compat.Registration']
    have = set(re.findall(r'^import ([\w.]+);', head, re.M))
    head = head.rstrip('\n') + '\n' + ''.join('import %s;\n' % i for i in imports if i not in have) + '\n'
    return head + body


def client_file():
    lines = ['package net.mcreator.narutoshippudenmod.client;', '',
             'import net.mcreator.narutoshippudenmod.item.ArmorItems;',
             'import net.minecraft.client.Minecraft;', 'import net.minecraft.client.model.HumanoidModel;', 'import net.minecraft.client.model.Model;',
             'import net.minecraft.client.model.geom.ModelLayerLocation;', 'import net.minecraft.client.model.geom.PartPose;',
             'import net.minecraft.client.model.geom.builders.CubeDeformation;', 'import net.minecraft.client.model.geom.builders.CubeListBuilder;',
             'import net.minecraft.client.model.geom.builders.LayerDefinition;', 'import net.minecraft.client.model.geom.builders.MeshDefinition;',
             'import net.minecraft.client.model.geom.builders.PartDefinition;', 'import net.minecraft.client.resources.model.EquipmentClientInfo;',
             'import net.minecraft.resources.Identifier;', 'import net.minecraft.world.item.ItemStack;',
             'import net.neoforged.api.distmarker.Dist;', 'import net.neoforged.api.distmarker.OnlyIn;',
             'import net.neoforged.neoforge.client.event.EntityRenderersEvent;',
             'import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;',
             'import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;', '',
             '/** Custom helmet (headband) models and textures, registered as client item extensions. */',
             '@OnlyIn(Dist.CLIENT)', 'public final class ArmorModels {', '\tprivate ArmorModels() {', '\t}', '']
    for i, (cls, holder, item_name, code, tw, th, tex) in enumerate(CLIENT_ENTRIES):
        lines.append('\tprivate static final ModelLayerLocation LAYER_%d = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "armor_%s"), "main");' % (i, item_name))
        lines.append('\tprivate static HumanoidModel<?> model%d;' % i)
        lines.append('')
        lines.append('\tprivate static LayerDefinition layer%d() {' % i)
        lines.append('\t\tMeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);')
        lines.append('\t\tPartDefinition root = mesh.getRoot();')
        for pn, pose in [('hat', 'PartPose.ZERO'), ('body', 'PartPose.ZERO'), ('right_arm', 'PartPose.offset(-5.0F, 2.0F, 0.0F)'),
                         ('left_arm', 'PartPose.offset(5.0F, 2.0F, 0.0F)'), ('right_leg', 'PartPose.offset(-1.9F, 12.0F, 0.0F)'),
                         ('left_leg', 'PartPose.offset(1.9F, 12.0F, 0.0F)')]:
            lines.append('\t\troot.addOrReplaceChild("%s", CubeListBuilder.create(), %s);' % (pn, pose))
        lines += ['\t\t' + c for c in code]
        lines.append('\t\treturn LayerDefinition.create(mesh, %d, %d);' % (tw, th))
        lines.append('\t}')
        lines.append('')
    lines.append('\tpublic static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {')
    for i, _ in enumerate(CLIENT_ENTRIES):
        lines.append('\t\tevent.registerLayerDefinition(LAYER_%d, ArmorModels::layer%d);' % (i, i))
    lines.append('\t}')
    lines.append('')
    lines.append('\tpublic static void registerExtensions(RegisterClientExtensionsEvent event) {')
    for i, (cls, holder, item_name, code, tw, th, tex) in enumerate(CLIENT_ENTRIES):
        lines.append('\t\tevent.registerItem(new IClientItemExtensions() {')
        lines.append('\t\t\t@Override')
        lines.append('\t\t\tpublic Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {')
        lines.append('\t\t\t\tif (model%d == null)' % i)
        lines.append('\t\t\t\t\tmodel%d = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(LAYER_%d));' % (i, i))
        lines.append('\t\t\t\treturn model%d;' % i)
        lines.append('\t\t\t}')
        if tex:
            lines.append('')
            lines.append('\t\t\t@Override')
            lines.append('\t\t\tpublic Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {')
            lines.append('\t\t\t\treturn Identifier.parse("%s");' % tex)
            lines.append('\t\t\t}')
        lines.append('\t\t}, ArmorItems.%s.%s);' % (cls, holder))
    lines.append('\t}')
    lines.append('}')
    return '\n'.join(lines) + '\n'
