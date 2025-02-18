
package net.mcreator.narutoshippudenmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.narutoshippudenmod.procedures.MangekyouSharinganShisuiReleaseRightclickedProcedure;
import net.mcreator.narutoshippudenmod.itemgroup.DojutsuItemGroup;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@NarutoShippudenModElements.ModElement.Tag
public class MangekyouSharinganShisuiReleaseItem extends NarutoShippudenModElements.ModElement {
	@ObjectHolder("naruto_shippuden:mangekyou_sharingan_shisui_release")
	public static final Item block = null;

	public MangekyouSharinganShisuiReleaseItem(NarutoShippudenModElements instance) {
		super(instance, 593);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(DojutsuItemGroup.tab).maxStackSize(1).rarity(Rarity.EPIC));
			setRegistryName("mangekyou_sharingan_shisui_release");
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
			list.add(new StringTextComponent("\u00A72Susano:"));
			list.add(new StringTextComponent("\u00A76Learn Susano Release: Ribcage \u00A74Cost: 10 JP"));
			list.add(new StringTextComponent("\u00A76Learn Susano Release: Skeletal Susano \u00A74Cost: 20 JP"));
			list.add(new StringTextComponent("\u00A76Learn Susano Release: Humanoid Susano \u00A74Cost: 30 JP"));
			list.add(new StringTextComponent("\u00A76Learn Susano Release: Armored Susano \u00A74Cost: 40 JP"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			MangekyouSharinganShisuiReleaseRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}
	}
}
