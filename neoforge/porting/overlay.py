"""gui/overlay/ChakraBarOverlay.java -> a NeoForge GUI layer drawn with GuiGraphicsExtractor."""
import re
from rules import find_block, split_header
from gui import split_args, color


def convert(path, text):
    head, body = split_header(text)
    m = re.search(r'public static void eventHandler\(RenderGameOverlayEvent\.Post event\)\s*\{', body)
    inner = body[m.end():find_block(body, m.start()) - 1]
    inner = re.sub(r'^\s*if \(event\.getType\(\) == RenderGameOverlayEvent\.ElementType\.\w+\) \{', '{', inner, count=1)
    inner = inner.replace('event.getWindow().getGuiScaledWidth()', 'graphics.guiWidth()').replace('event.getWindow().getGuiScaledHeight()', 'graphics.guiHeight()')
    inner = re.sub(r'\n\s*RenderSystem\.[^;]*;', '', inner)

    def draw(mm):
        args = split_args(mm.group(1))
        return 'graphics.text(Minecraft.getInstance().font, %s, %s, %s, %s, false);' % (args[1], args[2], args[3], color(args[4]))
    inner = re.sub(r'Minecraft\.getInstance\(\)\.font\s*\.draw\((.*?)\);', draw, inner, flags=re.S)
    inner = re.sub(r'Minecraft\.getInstance\(\)\.getTextureManager\(\)\s*\.bind\(([^;]*)\);', r'_tex = \1;', inner)
    inner = re.sub(r'Minecraft\.getInstance\(\)\.gui\.blit\(event\.getMatrixStack\(\), ', 'graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, ', inner)
    inner = re.sub(r'(?:Minecraft\.getInstance\(\)\.gui\.|GuiComponent\.|AbstractGui\.)?blit\(event\.getMatrixStack\(\), ', 'graphics.blit(RenderPipelines.GUI_TEXTURED, _tex, ', inner)
    layer = ('\n\t/** Chakra and health numbers on the right side of the screen. */\n'
             '\tpublic static void render(GuiGraphicsExtractor graphics, DeltaTracker deltaTracker) {\n'
             '\t\tIdentifier _tex = null;\n' + inner + '\n\t}\n\n'
             '\t@SubscribeEvent\n\tpublic static void register(RegisterGuiLayersEvent event) {\n'
             '\t\tevent.registerAboveAll(Identifier.fromNamespaceAndPath("naruto_shippuden", "chakra_bar"), ChakraBarOverlay::render);\n\t}\n')
    body = body[:m.start()] + layer.strip('\n') + body[find_block(body, m.start()):]
    body = re.sub(r'@OnlyIn\(Dist\.CLIENT\)\s*\n\s*@SubscribeEvent\(priority = EventPriority\.NORMAL\)\s*\n\s*(/\*\*)', r'\1', body)
    body = re.sub(r'@EventBusSubscriber\(modid = "naruto_shippuden"\)\s*\npublic class ChakraBarOverlay',
                  '@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)\npublic class ChakraBarOverlay', body)
    head = re.sub(r'^import .*(RenderGameOverlayEvent|GlStateManager|RenderSystem|PoseStack).*;\n', '', head, flags=re.M)
    imports = ['net.minecraft.client.DeltaTracker', 'net.minecraft.client.gui.GuiGraphicsExtractor', 'net.minecraft.client.renderer.RenderPipelines',
               'net.minecraft.resources.Identifier', 'net.neoforged.neoforge.client.event.RegisterGuiLayersEvent', 'net.minecraft.client.Minecraft',
               'net.neoforged.api.distmarker.Dist', 'net.neoforged.fml.common.EventBusSubscriber', 'net.neoforged.bus.api.SubscribeEvent']
    have = set(re.findall(r'^import ([\w.]+);', head, re.M))
    head = head.rstrip('\n') + '\n' + ''.join('import %s;\n' % i for i in imports if i not in have) + '\n'
    return head + body
