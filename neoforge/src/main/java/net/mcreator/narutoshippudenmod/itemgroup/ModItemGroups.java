package net.mcreator.narutoshippudenmod.itemgroup;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.block.ModBlocks.KamuiStoneBlock;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKonohagakureBlackItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.UchihaReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.UndefinedDNAItem;
import net.mcreator.narutoshippudenmod.item.DojutsuItems.SharinganReleaseItem;
import net.mcreator.narutoshippudenmod.item.FoodItems.IchirakuRamenItem;
import net.mcreator.narutoshippudenmod.item.MiscItems.SpawnItem;
import net.mcreator.narutoshippudenmod.item.MiscItems.TechniquesTabItem;
import net.mcreator.narutoshippudenmod.item.MissionItems.ShikamaruQuestDItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.FireReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.IceReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ChakraPaperItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.GunbaiItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.mcreator.narutoshippudenmod.compat.Registration;

public final class ModItemGroups {
	private ModItemGroups() {
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ArmorItemGroup extends NarutoShippudenModElements.ModElement {
		public ArmorItemGroup(NarutoShippudenModElements instance) {
			super(instance, 1045);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabarmor", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabarmor"))
					.icon(() -> new ItemStack(GeninKonohagakureBlackItem.helmet))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("ArmorItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BlocksItemGroup extends NarutoShippudenModElements.ModElement {
		public BlocksItemGroup(NarutoShippudenModElements instance) {
			super(instance, 1237);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabblocks", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabblocks"))
					.icon(() -> new ItemStack(KamuiStoneBlock.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("BlocksItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ClansItemGroup extends NarutoShippudenModElements.ModElement {
		public ClansItemGroup(NarutoShippudenModElements instance) {
			super(instance, 101);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabclans", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabclans"))
					.icon(() -> new ItemStack(UchihaReleaseItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("ClansItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DNAItemGroup extends NarutoShippudenModElements.ModElement {
		public DNAItemGroup(NarutoShippudenModElements instance) {
			super(instance, 289);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabdna", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabdna"))
					.icon(() -> new ItemStack(UndefinedDNAItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("DNAItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DojutsuItemGroup extends NarutoShippudenModElements.ModElement {
		public DojutsuItemGroup(NarutoShippudenModElements instance) {
			super(instance, 385);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabdojutsu", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabdojutsu"))
					.icon(() -> new ItemStack(SharinganReleaseItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("DojutsuItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FoodItemGroup extends NarutoShippudenModElements.ModElement {
		public FoodItemGroup(NarutoShippudenModElements instance) {
			super(instance, 283);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabfood", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabfood"))
					.icon(() -> new ItemStack(IchirakuRamenItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("FoodItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MissionsItemGroup extends NarutoShippudenModElements.ModElement {
		public MissionsItemGroup(NarutoShippudenModElements instance) {
			super(instance, 224);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabmissions", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabmissions"))
					.icon(() -> new ItemStack(ShikamaruQuestDItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("MissionsItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ReleaseTechniqueItemGroup extends NarutoShippudenModElements.ModElement {
		public ReleaseTechniqueItemGroup(NarutoShippudenModElements instance) {
			super(instance, 827);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabrelease_technique", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabrelease_technique"))
					.icon(() -> new ItemStack(IceReleaseTechniqueItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("ReleaseTechniqueItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ReleasesItemGroup extends NarutoShippudenModElements.ModElement {
		public ReleasesItemGroup(NarutoShippudenModElements instance) {
			super(instance, 6);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabreleases", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabreleases"))
					.icon(() -> new ItemStack(FireReleaseItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("ReleasesItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SpawnEggsItemGroup extends NarutoShippudenModElements.ModElement {
		public SpawnEggsItemGroup(NarutoShippudenModElements instance) {
			super(instance, 221);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabspawn_eggs", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabspawn_eggs"))
					.icon(() -> new ItemStack(SpawnItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("SpawnEggsItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StuffItemGroup extends NarutoShippudenModElements.ModElement {
		public StuffItemGroup(NarutoShippudenModElements instance) {
			super(instance, 282);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabstuff", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabstuff"))
					.icon(() -> new ItemStack(ChakraPaperItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("StuffItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TechniquesItemGroup extends NarutoShippudenModElements.ModElement {
		public TechniquesItemGroup(NarutoShippudenModElements instance) {
			super(instance, 387);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabtechniques", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabtechniques"))
					.icon(() -> new ItemStack(TechniquesTabItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("TechniquesItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WeaponsItemGroup extends NarutoShippudenModElements.ModElement {
		public WeaponsItemGroup(NarutoShippudenModElements instance) {
			super(instance, 202);
		}

		@Override
		public void initElements() {
			Registration.add(Registries.CREATIVE_MODE_TAB, "tabweapons", () -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.tabweapons"))
					.icon(() -> new ItemStack(GunbaiItem.block))
					.displayItems((parameters, output) -> Registration.TAB_ITEMS.getOrDefault("WeaponsItemGroup", java.util.List.of())
							.forEach(name -> output.accept(BuiltInRegistries.ITEM.getValue(Registration.id(name)))))
					.build(), holder -> tab = holder.value());
		}

		public static CreativeModeTab tab;
	}
}
