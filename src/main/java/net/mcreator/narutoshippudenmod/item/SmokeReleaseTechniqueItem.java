
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
import net.minecraft.entity.LivingEntity;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.narutoshippudenmod.procedures.SmokeReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.SmokeReleaseTechniqueLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.itemgroup.ReleaseTechniqueItemGroup;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@NarutoShippudenModElements.ModElement.Tag
public class SmokeReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
	@ObjectHolder("naruto_shippuden:smoke_release_technique")
	public static final Item block = null;

	public SmokeReleaseTechniqueItem(NarutoShippudenModElements instance) {
		super(instance, 461);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(ReleaseTechniqueItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("smoke_release_technique");
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
			list.add(new StringTextComponent("\u00A72Smoke Form: \u00A7bChakra cost: 80/sec \u00A73Ninjutsu required: 20"));
			list.add(new StringTextComponent("\u00A72Smoke Fist: \u00A7bChakra cost: 750 \u00A73Ninjutsu required: 35"));
			list.add(new StringTextComponent("\u00A72Smoke Gun: \u00A7bChakra cost: 1000 \u00A73Ninjutsu required: 50"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			SmokeReleaseTechniqueRightclickedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
					.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return ar;
		}

		@Override
		public boolean hitEntity(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
			boolean retval = super.hitEntity(itemstack, entity, sourceentity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			World world = entity.world;

			SmokeReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
					Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
