"""Regenerate potion/ModEffects.java (after class renames and code rules) as 26.3 MobEffects."""
import re
from rules import find_block, split_header


def method_body(block, name_re):
    m = re.search(r'public \w+ (%s)\(([^)]*)\)\s*\{' % name_re, block)
    if not m:
        return None, None
    end = find_block(block, m.start())
    return m, block[m.end():end - 1]


def convert(path, text):
    head, body = split_header(text)
    out = []
    names = []
    for m in re.finditer(r'public static class (\w+PotionEffect) \{', body):
        cls = m.group(1)
        block = body[m.start():find_block(body, m.start())]
        name = re.search(r'Registration\.holder\((?:Registries\.\w+, )?"(\w+)"', block) or re.search(r'setRegistryName\("(\w+)"\)', block)
        name = name.group(1)
        cat, color = re.search(r'super\(MobEffectCategory\.(\w+), (-?\w+)\);', block).groups()
        hidden = any(re.search(r'public boolean %s\([^)]*\)\s*\{\s*return false;' % n, block) for n in ('shouldRender', 'shouldRenderInvText', 'shouldRenderHUD'))
        tick_m, tick = method_body(block, 'applyEffectTick')
        start_m, start = method_body(block, 'addAttributeModifiers')
        end_m, expire = method_body(block, 'removeAttributeModifiers')
        dur_m, dur = method_body(block, 'isDurationEffectTick')
        names.append((cls, name, bool(expire)))
        lines = ['\tpublic static class %s {' % cls,
                 '\t\tpublic static Holder<MobEffect> potion;',
                 '\t\tpublic static final boolean HIDDEN = %s;' % ('true' if hidden else 'false'), '',
                 '\t\tstatic void register() {',
                 '\t\t\tRegistration.add(Registries.MOB_EFFECT, "%s", EffectCustom::new, h -> potion = h);' % name,
                 '\t\t}', '',
                 '\t\tpublic static class EffectCustom extends MobEffect {',
                 '\t\t\tpublic EffectCustom() {',
                 '\t\t\t\tsuper(MobEffectCategory.%s, %s);' % (cat, color),
                 '\t\t\t}']
        if tick is not None:
            params = [p.split()[-1] for p in tick_m.group(2).split(',')]
            ent, amp = params[0], params[-1]
            lines += ['', '\t\t\t@Override',
                      '\t\t\tpublic boolean applyEffectTick(ServerLevel serverLevel, LivingEntity %s, int %s) {' % (ent, amp),
                      tick.rstrip(), '\t\t\t\treturn true;', '\t\t\t}']
        if start is not None:
            params = [p.split()[-1] for p in start_m.group(2).split(',')]
            ent, amp = params[0], params[-1]
            start = re.sub(r'\s*super\.addAttributeModifiers\([^;]*\);', '', start)
            lines += ['', '\t\t\t@Override', '\t\t\tpublic void onEffectStarted(LivingEntity %s, int %s) {' % (ent, amp), start.rstrip(), '\t\t\t}']
        if dur is not None:
            params = [p.split()[-1] for p in dur_m.group(2).split(',')]
            lines += ['', '\t\t\t@Override', '\t\t\tpublic boolean shouldApplyEffectTickThisTick(int %s, int %s) {' % (params[0], params[1]),
                      dur.rstrip(), '\t\t\t}']
        lines.append('\t\t}')
        if expire is not None:
            params = [p.split()[-1] for p in end_m.group(2).split(',')]
            ent = params[0]
            expire = re.sub(r'\s*super\.removeAttributeModifiers\([^;]*\);', '', expire)
            lines += ['', '\t\t/** Runs when the effect ends (expired or removed); was removeAttributeModifiers in 1.16. */',
                      '\t\tstatic void onEnd(LivingEntity %s) {' % ent, expire.rstrip(), '\t\t}']
        lines.append('\t}')
        out.append('\n'.join(lines))
    reg = ['\tpublic static void register() {'] + ['\t\t%s.register();' % c for c, _, _ in names] + ['\t}']
    ends = ['\tprivate static void onEnd(MobEffectInstance instance, LivingEntity entity) {', '\t\tif (instance == null)', '\t\t\treturn;']
    for c, _, has in names:
        if has:
            ends.append('\t\tif (instance.getEffect() == %s.potion)\n\t\t\t%s.onEnd(entity);' % (c, c))
    ends.append('\t}')
    events = '''	@EventBusSubscriber(modid = "naruto_shippuden")
	public static class EndEvents {
		@SubscribeEvent
		public static void onExpired(MobEffectEvent.Expired event) {
			onEnd(event.getEffectInstance(), event.getEntity());
		}

		@SubscribeEvent
		public static void onRemoved(MobEffectEvent.Remove event) {
			onEnd(event.getEffectInstance(), event.getEntity());
		}
	}'''
    imports = ['net.minecraft.core.Holder', 'net.minecraft.core.registries.Registries', 'net.minecraft.server.level.ServerLevel',
               'net.minecraft.world.effect.MobEffect', 'net.minecraft.world.effect.MobEffectCategory', 'net.minecraft.world.effect.MobEffectInstance',
               'net.minecraft.world.entity.LivingEntity', 'net.neoforged.bus.api.SubscribeEvent', 'net.neoforged.fml.common.EventBusSubscriber',
               'net.neoforged.neoforge.event.entity.living.MobEffectEvent', 'net.mcreator.narutoshippudenmod.compat.Registration']
    have = set(re.findall(r'^import ([\w.]+);', head, re.M))
    head = head.rstrip('\n') + '\n' + ''.join('import %s;\n' % i for i in imports if i not in have) + '\n'
    body = ('public final class ModEffects {\n\tprivate ModEffects() {\n\t}\n\n' + '\n\n'.join(reg + [''] + ends) + '\n\n' + events + '\n\n'
            + '\n\n'.join(out) + '\n}\n')
    return head + body
