package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables.PlayerVariables;
import net.mcreator.narutoshippudenmod.compat.Compat;
import net.mcreator.narutoshippudenmod.core.NarutoConfig;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import org.jspecify.annotations.Nullable;

/**
 * DNA: how players gain natures and kekkei genkai.
 * <ul>
 * <li>Shinobi drop Undefined DNA when killed: village shinobi by rank (Genin 15%, Chunin 25%, Jonin 40%), Asuma and Shikamaru half
 * the time, Kurama three.</li>
 * <li>Right-clicking Undefined DNA identifies it, always: a nature 80% of the time, a kekkei genkai 20%.</li>
 * <li>Right-clicking a DNA implants it in yourself; hitting a player with it implants it in them. It's a medical procedure: the
 * implanter's Medicine sets the chance (a nature 50% at Medicine 0 up to 100% at 300, a kekkei genkai 25% to 100%), and a failure
 * uses up the DNA.</li>
 * <li>A kekkei genkai combines natures (Ice: Water and Wind…): its DNA can only be implanted in someone who has them, unless
 * combine_natures is off in the config.</li>
 * </ul>
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Dna {
	/** A nature or kekkei genkai DNA: its item, the release it unlocks, and the natures it combines (none for a nature). */
	public record Kind(String id, String title, String item, Predicate<PlayerVariables> has, BiConsumer<PlayerVariables, Boolean> set, List<String> needs) {
		public boolean natural() {
			return NATURES.contains(this);
		}
	}

	public static final List<Kind> NATURES = List.of(
			new Kind("fire", "Fire Release", "fire_dna_release", v -> v.firereleaselogic, (v, b) -> v.firereleaselogic = b, List.of()),
			new Kind("water", "Water Release", "water_dna_release", v -> v.waterreleaselogic, (v, b) -> v.waterreleaselogic = b, List.of()),
			new Kind("wind", "Wind Release", "wind_dna", v -> v.windreleaselogic, (v, b) -> v.windreleaselogic = b, List.of()),
			new Kind("earth", "Earth Release", "earth_dna", v -> v.earthreleaselogic, (v, b) -> v.earthreleaselogic = b, List.of()),
			new Kind("lightning", "Lightning Release", "lightning_dna", v -> v.lightningreleaselogic, (v, b) -> v.lightningreleaselogic = b, List.of()));

	/**
	 * The kekkei genkai and what they combine. From the wiki: Boil, Dust, Ice, Magnet, Storm, Wood. The wiki doesn't say for Steel and
	 * Swift, says Typhoon is at least Wind, Smoke is fanon and Bone (the Kaguya clan's Shikotsumyaku) isn't made of natures: those are
	 * our choices.
	 */
	public static final List<Kind> KEKKEI_GENKAI = List.of(
			new Kind("boil", "Boil Release", "boil_dna_release", v -> v.boilreleaselogic, (v, b) -> v.boilreleaselogic = b, List.of("fire", "water")),
			new Kind("bone", "Bone Release", "bone_dna_release", v -> v.bonereleaselogic, (v, b) -> v.bonereleaselogic = b, List.of()),
			new Kind("dust", "Dust Release", "dust_dna_release", v -> v.dustreleaselogic, (v, b) -> v.dustreleaselogic = b, List.of("earth", "wind", "fire")),
			new Kind("ice", "Ice Release", "ice_dna_release", v -> v.icereleaselogic, (v, b) -> v.icereleaselogic = b, List.of("water", "wind")),
			new Kind("magnet", "Magnet Release", "magnet_dna_release", v -> v.magnetreleaselogic, (v, b) -> v.magnetreleaselogic = b, List.of("wind", "earth")),
			new Kind("smoke", "Smoke Release", "smoke_dna_release", v -> v.smokereleaselogic, (v, b) -> v.smokereleaselogic = b, List.of("fire", "wind", "water")),
			new Kind("steel", "Steel Release", "steel_dna_release", v -> v.steelreleaselogic, (v, b) -> v.steelreleaselogic = b, List.of("earth", "fire")),
			new Kind("storm", "Storm Release", "storm_dna_release", v -> v.stormreleaselogic, (v, b) -> v.stormreleaselogic = b, List.of("lightning", "water")),
			new Kind("swift", "Swift Release", "swift_dna_release", v -> v.swiftreleaselogic, (v, b) -> v.swiftreleaselogic = b, List.of("wind", "lightning")),
			new Kind("typhoon", "Typhoon Release", "typhoon_dna_release", v -> v.typhoonreleaslogic, (v, b) -> v.typhoonreleaslogic = b, List.of("wind", "water")),
			new Kind("wood", "Wood Release", "wood_dna_release", v -> v.woodreleaselogic, (v, b) -> v.woodreleaselogic = b, List.of("earth", "water")));

	static final String UNDEFINED = "undefined_dna";
	/** Out of 100: how often identifying gives a kekkei genkai rather than a nature. */
	static final int KEKKEI_GENKAI_CHANCE = 20;

	private Dna() {
	}

	private static Item item(String id) {
		return BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("naruto_shippuden", id));
	}

	private static String id(ItemStack stack) {
		return BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath();
	}

	public static @Nullable Kind kind(ItemStack stack) {
		if (stack.isEmpty())
			return null;
		String id = id(stack);
		for (List<Kind> list : List.of(NATURES, KEKKEI_GENKAI))
			for (Kind kind : list)
				if (kind.item.equals(id))
					return kind;
		return null;
	}

	public static boolean undefined(ItemStack stack) {
		return !stack.isEmpty() && id(stack).equals(UNDEFINED);
	}

	public static Kind nature(String id) {
		return NATURES.stream().filter(k -> k.id.equals(id)).findFirst().orElseThrow();
	}

	/** The natures a kekkei genkai needs that this player lacks (none when combining is off in the config). */
	public static List<Kind> missing(Kind kind, PlayerVariables v) {
		List<Kind> missing = new ArrayList<>();
		if (NarutoConfig.combineNatures())
			for (String need : kind.needs)
				if (!nature(need).has.test(v))
					missing.add(nature(need));
		return missing;
	}

	/** "Water and Wind Release", "Earth, Wind and Fire Release". */
	public static String names(List<Kind> kinds) {
		List<String> words = kinds.stream().map(k -> k.title.replace(" Release", "")).toList();
		String joined = words.size() == 1 ? words.getFirst()
				: String.join(", ", words.subList(0, words.size() - 1)) + " and " + words.getLast();
		return joined + " Release";
	}

	/** Out of 100: the implanter's chance, from their Medicine (up to 300). */
	public static int chance(Kind kind, PlayerVariables implanter) {
		double medicine = Math.max(0, Math.min(300, implanter.medicine)) / 300;
		return (int) Math.round(kind.natural() ? 50 + 50 * medicine : 25 + 75 * medicine);
	}

	// ------------------------------------------------------------------ using DNA
	@SubscribeEvent
	public static void onRightClick(PlayerInteractEvent.RightClickItem event) {
		ItemStack stack = event.getItemStack();
		Kind kind = kind(stack);
		if (kind == null && !undefined(stack))
			return;
		event.setCanceled(true);
		event.setCancellationResult(InteractionResult.SUCCESS);
		if (!(event.getEntity() instanceof ServerPlayer player))
			return;
		if (kind == null)
			identify(player, stack);
		else
			implant(player, player, stack, kind);
	}

	/** Hitting a player with DNA implants it in them (it does no damage); creatures can't take it. */
	@SubscribeEvent
	public static void onAttack(AttackEntityEvent event) {
		ItemStack stack = event.getEntity().getMainHandItem();
		Kind kind = kind(stack);
		if (kind == null && !undefined(stack))
			return;
		event.setCanceled(true);
		if (!(event.getEntity() instanceof ServerPlayer player))
			return;
		if (kind == null)
			tell(player, "Identify the DNA first (right-click it)");
		else if (event.getTarget() instanceof ServerPlayer target)
			implant(player, target, stack, kind);
		else
			tell(player, "DNA can only be implanted in a player");
	}

	public static void identify(ServerPlayer player, ItemStack stack) {
		boolean kekkeiGenkai = player.getRandom().nextInt(100) < KEKKEI_GENKAI_CHANCE;
		List<Kind> from = kekkeiGenkai ? KEKKEI_GENKAI : NATURES;
		Kind kind = from.get(player.getRandom().nextInt(from.size()));
		stack.shrink(1);
		Compat.giveItemToPlayer(player, new ItemStack(item(kind.item)));
		tell(player, "Identified: " + kind.title + " DNA" + (kekkeiGenkai ? " (kekkei genkai)" : ""));
		sound(player, SoundEvents.BREWING_STAND_BREW, 1.4F);
	}

	public static void implant(ServerPlayer implanter, ServerPlayer target, ItemStack stack, Kind kind) {
		PlayerVariables v = NarutoShippudenModVariables.get(target);
		boolean self = implanter == target;
		String whose = self ? "You" : target.getName().getString();
		if (kind.has.test(v)) {
			tell(implanter, (self ? "You already have " : whose + " already has ") + kind.title);
			return;
		}
		List<Kind> missing = missing(kind, v);
		if (!missing.isEmpty()) {
			tell(implanter, kind.title + " combines " + names(kind.needs.stream().map(Dna::nature).toList()) + ": " + (self ? "you" : whose)
					+ " still need" + (self ? "" : "s") + " " + names(missing));
			return;
		}
		int chance = chance(kind, NarutoShippudenModVariables.get(implanter));
		stack.shrink(1);
		ServerLevel level = (ServerLevel) target.level();
		if (implanter.getRandom().nextInt(100) >= chance) {
			tell(implanter, "Implanting " + kind.title + " failed (" + chance + "% chance)");
			if (!self)
				tell(target, "Implanting " + kind.title + " failed");
			level.sendParticles(ParticleTypes.SMOKE, target.getX(), target.getY() + 1, target.getZ(), 12, 0.3, 0.5, 0.3, 0.02);
			sound(target, SoundEvents.FIRE_EXTINGUISH, 1.2F);
			return;
		}
		NarutoShippudenModVariables.ifPresent(target, vars -> {
			kind.set.accept(vars, true);
			vars.syncPlayerVariables(target);
		});
		Compat.giveItemToPlayer(target, new ItemStack(item(kind.id + "_release")));
		tell(target, kind.title + " implanted: open its scroll to learn its jutsu");
		if (!self)
			tell(implanter, kind.title + " implanted in " + whose);
		level.sendParticles(ParticleTypes.HAPPY_VILLAGER, target.getX(), target.getY() + 1, target.getZ(), 12, 0.4, 0.6, 0.4, 0);
		sound(target, SoundEvents.PLAYER_LEVELUP, 1.6F);
	}

	private static void tell(Player player, String message) {
		player.sendOverlayMessage(Component.literal(message));
	}

	private static void sound(Entity at, net.minecraft.sounds.SoundEvent sound, float pitch) {
		at.level().playSound(null, at.getX(), at.getY(), at.getZ(), sound, SoundSource.PLAYERS, 0.8F, pitch);
	}

	// ------------------------------------------------------------------ where DNA comes from
	/** Out of 100: the chance a shinobi drops Undefined DNA (village shinobi by rank: Genin, Chunin, Jonin). */
	private static final int[] VILLAGE_CHANCE = { 15, 25, 40 };

	@SubscribeEvent
	public static void onDrops(LivingDropsEvent event) {
		LivingEntity dead = event.getEntity();
		if (!(dead.level() instanceof ServerLevel))
			return;
		String type = BuiltInRegistries.ENTITY_TYPE.getKey(dead.getType()).getPath();
		int count = 0;
		if (type.startsWith("hidden_") && type.endsWith("_shinobi"))
			count = dead.getRandom().nextInt(100) < VILLAGE_CHANCE[ShinobiAI.rank(dead)] ? 1 : 0;
		else if (type.equals("asuma") || type.equals("shikamaru"))
			count = dead.getRandom().nextBoolean() ? 1 : 0;
		else if (type.equals("kurama"))
			count = 3;
		for (int i = 0; i < count; i++) {
			ItemEntity drop = new ItemEntity(dead.level(), dead.getX(), dead.getY() + 0.5, dead.getZ(), new ItemStack(item(UNDEFINED)));
			drop.setDefaultPickUpDelay();
			event.getDrops().add(drop);
		}
	}
}
