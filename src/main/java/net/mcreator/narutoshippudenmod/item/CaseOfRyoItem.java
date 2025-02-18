
package net.mcreator.narutoshippudenmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.narutoshippudenmod.itemgroup.StuffItemGroup;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

import java.util.List;

@NarutoShippudenModElements.ModElement.Tag
public class CaseOfRyoItem extends NarutoShippudenModElements.ModElement {
	@ObjectHolder("naruto_shippuden:case_of_ryo")
	public static final Item block = null;

	public CaseOfRyoItem(NarutoShippudenModElements instance) {
		super(instance, 286);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(StuffItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("case_of_ryo");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("(500000 Gold Ryo)"));
		}
	}
}
