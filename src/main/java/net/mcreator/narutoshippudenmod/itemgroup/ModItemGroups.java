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
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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
			tab = new ItemGroup("tabarmor") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(GeninKonohagakureBlackItem.helmet);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class BlocksItemGroup extends NarutoShippudenModElements.ModElement {
		public BlocksItemGroup(NarutoShippudenModElements instance) {
			super(instance, 1237);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabblocks") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(KamuiStoneBlock.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ClansItemGroup extends NarutoShippudenModElements.ModElement {
		public ClansItemGroup(NarutoShippudenModElements instance) {
			super(instance, 101);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabclans") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(UchihaReleaseItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DNAItemGroup extends NarutoShippudenModElements.ModElement {
		public DNAItemGroup(NarutoShippudenModElements instance) {
			super(instance, 289);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabdna") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(UndefinedDNAItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class DojutsuItemGroup extends NarutoShippudenModElements.ModElement {
		public DojutsuItemGroup(NarutoShippudenModElements instance) {
			super(instance, 385);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabdojutsu") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(SharinganReleaseItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class FoodItemGroup extends NarutoShippudenModElements.ModElement {
		public FoodItemGroup(NarutoShippudenModElements instance) {
			super(instance, 283);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabfood") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(IchirakuRamenItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class MissionsItemGroup extends NarutoShippudenModElements.ModElement {
		public MissionsItemGroup(NarutoShippudenModElements instance) {
			super(instance, 224);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabmissions") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(ShikamaruQuestDItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ReleaseTechniqueItemGroup extends NarutoShippudenModElements.ModElement {
		public ReleaseTechniqueItemGroup(NarutoShippudenModElements instance) {
			super(instance, 827);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabrelease_technique") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(IceReleaseTechniqueItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class ReleasesItemGroup extends NarutoShippudenModElements.ModElement {
		public ReleasesItemGroup(NarutoShippudenModElements instance) {
			super(instance, 6);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabreleases") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(FireReleaseItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class SpawnEggsItemGroup extends NarutoShippudenModElements.ModElement {
		public SpawnEggsItemGroup(NarutoShippudenModElements instance) {
			super(instance, 221);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabspawn_eggs") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(SpawnItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class StuffItemGroup extends NarutoShippudenModElements.ModElement {
		public StuffItemGroup(NarutoShippudenModElements instance) {
			super(instance, 282);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabstuff") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(ChakraPaperItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class TechniquesItemGroup extends NarutoShippudenModElements.ModElement {
		public TechniquesItemGroup(NarutoShippudenModElements instance) {
			super(instance, 387);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabtechniques") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(TechniquesTabItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}

	@NarutoShippudenModElements.ModElement.Tag
	public static class WeaponsItemGroup extends NarutoShippudenModElements.ModElement {
		public WeaponsItemGroup(NarutoShippudenModElements instance) {
			super(instance, 202);
		}

		@Override
		public void initElements() {
			tab = new ItemGroup("tabweapons") {
				@OnlyIn(Dist.CLIENT)
				@Override
				public ItemStack createIcon() {
					return new ItemStack(GunbaiItem.block);
				}

				@OnlyIn(Dist.CLIENT)
				public boolean hasSearchBar() {
					return false;
				}
			};
		}

		public static ItemGroup tab;
	}
}
