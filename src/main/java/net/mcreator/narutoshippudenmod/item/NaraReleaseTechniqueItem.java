
package net.mcreator.narutoshippudenmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.BlockState;

import net.mcreator.narutoshippudenmod.procedures.NaraReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.itemgroup.TechniquesItemGroup;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

import java.util.Collections;

@NarutoShippudenModElements.ModElement.Tag
public class NaraReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
	@ObjectHolder("naruto_shippuden:nara_release_technique")
	public static final Item block = null;

	public NaraReleaseTechniqueItem(NarutoShippudenModElements instance) {
		super(instance, 992);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("nara_release_technique");
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
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			NaraReleaseTechniqueRightclickedProcedure.executeProcedure(Collections.emptyMap());
			return ar;
		}
	}
}
