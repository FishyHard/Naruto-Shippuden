package net.mcreator.narutoshippudenmod.itemgroup;

import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * The mod's creative tabs, six of them in a set order: Jutsu (the natures and kekkei genkai), Clans, Dojutsu, Weapons,
 * Headbands and Shinobi Items. Every scroll is followed by the technique it unlocks. Spawn eggs go in the vanilla Spawn Eggs tab.
 * (The old MCreator tabs were thirteen, several with only an item or two; items still name their old tab, which is ignored.)
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class ModItemGroups {
	private static final String[] NATURES = { "fire", "water", "wind", "earth", "lightning" };
	private static final String[] KEKKEI_GENKAI = { "boil", "bone", "dust", "ice", "magnet", "smoke", "steel", "storm", "swift", "typhoon", "wood" };
	private static final String[] CLANS = { "uchiha", "uzumaki", "hyuga", "aburame", "akimichi", "nara", "yamanaka", "inuzuka", "lee", "sarutobi", "hozuki",
			"fuma", "tsuchigumo", "chinoike" };
	private static final String[] EYES = { "sharingan", "byakugan", "ketsuryugan", "rinnegan", "tenseigan", "isshiki_dojutsu" };
	private static final String[] MANGEKYOU = { "itachi", "sasuke", "obito", "kakashi", "shisui", "madara" };
	private static final String[] SPAWN_EGGS = { "shinobi_merchant_spawn_egg", "hidden_leaf_shinobi_spawn_egg", "hidden_sand_shinobi_spawn_egg",
			"hidden_mist_shinobi_spawn_egg", "hidden_cloud_shinobi_spawn_egg", "hidden_stone_shinobi_spawn_egg", "asuma_spawn_egg", "shikamaru_spawn_egg",
			"kurama_spawn_egg" };

	private ModItemGroups() {
	}

	private static List<String> jutsu() {
		List<String> ids = new ArrayList<>(List.of("shadow_clone_technique"));
		for (String nature : NATURES)
			ids.addAll(List.of(nature + "_release", nature + "_release_technique", nature + "_dna_release", nature + "_dna"));
		ids.add("chakra_nature_reset");
		for (String kekkeiGenkai : KEKKEI_GENKAI) {
			ids.addAll(List.of(kekkeiGenkai + "_release", kekkeiGenkai + "_release_technique"));
			// the DNA items don't all follow one naming
			for (String dna : new String[] { kekkeiGenkai + "_dna_release", kekkeiGenkai + "_dna" })
				ids.add(dna);
		}
		ids.add("undefined_dna");
		return ids;
	}

	private static List<String> clans() {
		List<String> ids = new ArrayList<>();
		for (String clan : CLANS)
			ids.addAll(List.of(clan + "_release", clan + "_release_technique"));
		ids.addAll(List.of("clan_paper", "clan_reset_stat"));
		return ids;
	}

	private static List<String> dojutsu() {
		List<String> ids = new ArrayList<>();
		for (String eye : EYES)
			ids.addAll(List.of(eye + "_release", eye + "_release_technique"));
		for (String whose : MANGEKYOU)
			ids.addAll(List.of("mangekyou_sharingan_" + whose + "_release", "mangekyou_sharingan_" + whose + "_release_technique"));
		return ids;
	}

	private static List<String> weapons() {
		return List.of("kunai", "shuriken", "explosive_kunai", "poison_kunai", "fuma_shuriken", "toroi_unique_fuma_shuriken", "flying_thunder_god_kunai",
				"tanto", "katana", "chakra_blade", "white_light_chakra_sabre", "kusanagi_sasuke", "gunbai", "triple_blade_scythe", "samehada", "kubikiribocho",
				"hiramekarei", "kabutowari", "kiba_sword", "nuibari", "shibuki", "shichiseiken");
	}

	private static List<String> headbands() {
		List<String> ids = new ArrayList<>();
		for (String village : new String[] { "konohagakure", "sunagakure", "kirigakure", "kumogakure", "iwagakure" })
			for (String colour : new String[] { "", "_black", "_red" })
				ids.add("genin_" + village + colour + "_helmet");
		return ids;
	}

	private static List<String> shinobiItems() {
		return List.of("bronze_ryo", "silver_ryo", "gold_ryo", "chakra_paper", "iron_stick", "sharp_iron", "paper_bomb", "kamui_stone", "ichiraku_ramen", "shogi",
				"shogiboard", "story_mode", "shikamaru_quest_d", "asuma_quest_c", "iron_defense", "pillage_the_post", "save_the_village");
	}

	private static Item item(String id) {
		return BuiltInRegistries.ITEM.getValue(Registration.id(id));
	}

	/** The tab registered just before (each tab sits after it, so they keep this order rather than sorting by name). */
	private static String previous;

	private static void tab(String name, String icon, java.util.function.Supplier<List<String>> ids) {
		String after = previous;
		previous = name;
		Registration.add(Registries.CREATIVE_MODE_TAB, name, () -> (after == null ? CreativeModeTab.builder()
				: CreativeModeTab.builder().withTabsBefore(net.minecraft.resources.ResourceKey.create(Registries.CREATIVE_MODE_TAB, Registration.id(after))))
				.title(Component.translatable("itemGroup.naruto_shippuden." + name))
				.icon(() -> new ItemStack(item(icon))).displayItems((parameters, output) -> {
					for (String id : ids.get()) {
						Item item = item(id);
						// ids that aren't items (a DNA spelling that doesn't exist) are skipped
						if (item != Items.AIR)
							output.accept(item);
					}
				}).build(), null);
	}

	/** Called from the mod's constructor, before the registries fill (in this order, which is the tabs' order). */
	public static void register() {
		tab("jutsu", "fire_release_technique", ModItemGroups::jutsu);
		tab("clans", "uchiha_release", ModItemGroups::clans);
		tab("dojutsu", "sharingan_release", ModItemGroups::dojutsu);
		tab("weapons", "kunai", ModItemGroups::weapons);
		tab("headbands", "genin_konohagakure_helmet", ModItemGroups::headbands);
		tab("shinobi_items", "chakra_paper", ModItemGroups::shinobiItems);
	}

	@SubscribeEvent
	public static void spawnEggs(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS)
			for (String id : SPAWN_EGGS)
				if (item(id) != Items.AIR)
					event.accept(item(id));
	}

	// the old tab classes, kept so the generated item files' imports of them still resolve
	public static final class ArmorItemGroup {
	}

	public static final class ClansItemGroup {
	}

	public static final class DNAItemGroup {
	}

	public static final class DojutsuItemGroup {
	}

	public static final class MissionsItemGroup {
	}

	public static final class ReleasesItemGroup {
	}

	public static final class SpawnEggsItemGroup {
	}

	public static final class StuffItemGroup {
	}

	public static final class TechniquesItemGroup {
	}

	public static final class WeaponsItemGroup {
	}

	public static final class BlocksItemGroup {
	}

	public static final class FoodItemGroup {
	}

	public static final class ReleaseTechniqueItemGroup {
	}
}
