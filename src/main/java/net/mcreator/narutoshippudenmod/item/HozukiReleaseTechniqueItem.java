
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

import net.mcreator.narutoshippudenmod.procedures.HozukiReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.itemgroup.TechniquesItemGroup;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@NarutoShippudenModElements.ModElement.Tag
public class HozukiReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
	@ObjectHolder("naruto_shippuden:hozuki_release_technique")
	public static final Item block = null;

	public HozukiReleaseTechniqueItem(NarutoShippudenModElements instance) {
		super(instance, 941);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("hozuki_release_technique");
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
			list.add(new StringTextComponent("Right-Click to use technique"));
			list.add(new StringTextComponent("Sneak and Right-Click to select or change technique"));
			list.add(new StringTextComponent("\u00A72Drowning Water Blob Technique: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 15"));
			list.add(new StringTextComponent("\u00A72Water Gun Technique: \u00A7bChakra cost: 300 \u00A73Ninjutsu required: 20"));
			list.add(new StringTextComponent("\u00A72Great Water Arm Technique: \u00A7bChakra cost: 40/sec \u00A73Ninjutsu required: 25"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			HozukiReleaseTechniqueRightclickedProcedure
					.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("entity", entity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}
	}
}
