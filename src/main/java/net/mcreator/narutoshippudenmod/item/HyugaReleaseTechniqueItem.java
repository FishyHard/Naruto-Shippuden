
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

import net.mcreator.narutoshippudenmod.procedures.HyugaReleaseTechniqueRightclickedProcedure;
import net.mcreator.narutoshippudenmod.procedures.HyugaReleaseTechniqueLivingEntityIsHitWithItemProcedure;
import net.mcreator.narutoshippudenmod.itemgroup.TechniquesItemGroup;
import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;

import java.util.stream.Stream;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.AbstractMap;

@NarutoShippudenModElements.ModElement.Tag
public class HyugaReleaseTechniqueItem extends NarutoShippudenModElements.ModElement {
	@ObjectHolder("naruto_shippuden:hyuga_release_technique")
	public static final Item block = null;

	public HyugaReleaseTechniqueItem(NarutoShippudenModElements instance) {
		super(instance, 451);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TechniquesItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("hyuga_release_technique");
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
			list.add(new StringTextComponent("\u00A72Gentle Fist: \u00A7bChakra cost: 200 \u00A73Ninjutsu required: 10"));
			list.add(new StringTextComponent("\u00A72Gentle Step Twin Lion Fists: \u00A7bChakra cost: 350 \u00A73Ninjutsu required: 20"));
			list.add(new StringTextComponent(
					"\u00A72Eight Trigrams Twin Lions Crumbling Attack: \u00A7bChakra cost: 500 \u00A73Ninjutsu required: 30"));
			list.add(new StringTextComponent("\u00A72Eight Trigrams Palms Revolving Heaven: \u00A7bChakra cost: 650 \u00A73Ninjutsu required: 40"));
			list.add(new StringTextComponent("\u00A72Eight Trigrams Sixty-Four Palms: \u00A7bChakra cost: 900 \u00A73Ninjutsu required: 45"));
		}

		@Override
		public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity entity, Hand hand) {
			ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
			ItemStack itemstack = ar.getResult();
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();

			HyugaReleaseTechniqueRightclickedProcedure.executeProcedure(Stream
					.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x), new AbstractMap.SimpleEntry<>("y", y),
							new AbstractMap.SimpleEntry<>("z", z), new AbstractMap.SimpleEntry<>("entity", entity))
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

			HyugaReleaseTechniqueLivingEntityIsHitWithItemProcedure.executeProcedure(
					Stream.of(new AbstractMap.SimpleEntry<>("entity", entity), new AbstractMap.SimpleEntry<>("sourceentity", sourceentity))
							.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
			return retval;
		}
	}
}
