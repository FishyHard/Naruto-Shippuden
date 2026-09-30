package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

/**
 * Technique items that the old mod never had: the Byakugan, Ketsuryugan, Rinnegan and Tenseigan, the Uchiha and Yamanaka clans, and
 * Shisui's and Madara's Mangekyou. They are plain items; {@link Jutsus} casts their jutsu (their scrolls are the old eye and clan
 * items).
 */
public final class JutsuItems {
	static final String[] TECHNIQUES = { "byakugan_release_technique", "ketsuryugan_release_technique", "rinnegan_release_technique",
			"tenseigan_release_technique", "uchiha_release_technique", "yamanaka_release_technique", "mangekyou_sharingan_shisui_release_technique",
			"mangekyou_sharingan_madara_release_technique" };

	private JutsuItems() {
	}

	/** Called from the mod's constructor, before the registries fill. */
	public static void register() {
		for (String name : TECHNIQUES)
			Registration.add(Registries.ITEM, name, () -> new Item(Registration.itemProps(name, "TechniquesItemGroup").stacksTo(1).rarity(Rarity.COMMON)),
					null);
	}
}
