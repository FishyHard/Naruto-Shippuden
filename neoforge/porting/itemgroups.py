"""itemgroup/ModItemGroups.java: creative tabs are registry entries listing the items recorded by Registration.itemProps."""
import re
from rules import split_header, for_each_element


def convert(path, text):
    head, body = split_header(text)

    def per_element(block):
        cls = re.search(r'public static class (\w+ItemGroup) extends', block).group(1)
        m = re.search(r'tab = new CreativeModeTab\("(\w+)"\) \{.*?return (new ItemStack\([^;]*\));', block, re.S)
        if not m:
            return block
        tab_id, icon = m.groups()
        search = 'true' if re.search(r'hasSearchBar\(\) \{\s*return true;', block) else 'false'
        init_start = block.index('@Override\n\t\tpublic void initElements()')
        init_end = block.index('public static CreativeModeTab tab;')
        new_init = ('@Override\n\t\tpublic void initElements() {\n'
                    '\t\t\tRegistration.add(Registries.CREATIVE_MODE_TAB, "%s", () -> CreativeModeTab.builder()\n'
                    '\t\t\t\t\t.title(Component.translatable("itemGroup.%s"))\n'
                    '\t\t\t\t\t.icon(() -> %s)\n'
                    '\t\t\t\t\t.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("%s", java.util.List.of())\n'
                    '\t\t\t\t\t\t\t.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))\n'
                    '\t\t\t\t\t.build(), holder -> tab = holder.value());\n\t\t}\n\n\t\t') % (tab_id, tab_id, icon, cls)
        return block[:init_start] + new_init + block[init_end:]

    body = for_each_element(body, per_element)
    imports = ['net.minecraft.core.registries.Registries', 'net.minecraft.core.registries.BuiltInRegistries', 'net.minecraft.network.chat.Component',
               'net.mcreator.narutoshippudenmod.compat.Registration', 'net.minecraft.world.item.CreativeModeTab', 'net.minecraft.world.item.ItemStack']
    have = set(re.findall(r'^import ([\w.]+);', head, re.M))
    head = head.rstrip('\n') + '\n' + ''.join('import %s;\n' % i for i in imports if i not in have) + '\n'
    return head + body
