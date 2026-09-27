package net.mcreator.narutoshippudenmod.procedures;

import io.netty.buffer.Unpooled;
import java.util.Map;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.AdventCalendarGUIGui;
import net.mcreator.narutoshippudenmod.item.DnaItems.UndefinedDNAItem;
import net.mcreator.narutoshippudenmod.item.FoodItems.ChristmasRamenItem;
import net.mcreator.narutoshippudenmod.item.FoodItems.GingerbreadItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.BanknoteOfRyoItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.IronStickItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.SharpIronItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.WadOfRyoItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KatanaItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KusanagiSasukeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.TantoItem;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IWorld;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.items.ItemHandlerHelper;

public final class GiftProcedures {
	private GiftProcedures() {
	}

	public static class AdventCalendarRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure AdventCalendarRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure AdventCalendarRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure AdventCalendarRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure AdventCalendarRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure AdventCalendarRightclicked!");
				return;
			}
			IWorld world = (IWorld) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayerEntity) {
					BlockPos _bpos = new BlockPos(x, y, z);
					NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
						@Override
						public ITextComponent getDisplayName() {
							return new StringTextComponent("AdventCalendarGUI");
						}

						@Override
						public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
							return new AdventCalendarGUIGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			}
		}
	}

	public static class ChristmasRamenPlayerFinishesUsingItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChristmasRamenPlayerFinishesUsingItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 200, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 200, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, (int) 200, (int) 1, (false), (false)));
		}
	}

	public static class Gift10Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift10!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 12000
					&& NarutoShippudenModVariables.get(entity).giftcount == 9) {
				return true;
			}
			return false;
		}
	}

	public static class Gift11Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift11!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 13200
					&& NarutoShippudenModVariables.get(entity).giftcount == 10) {
				return true;
			}
			return false;
		}
	}

	public static class Gift12Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift12!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 14400
					&& NarutoShippudenModVariables.get(entity).giftcount == 11) {
				return true;
			}
			return false;
		}
	}

	public static class Gift13Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift13!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 15600
					&& NarutoShippudenModVariables.get(entity).giftcount == 12) {
				return true;
			}
			return false;
		}
	}

	public static class Gift14Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift14!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 16800
					&& NarutoShippudenModVariables.get(entity).giftcount == 13) {
				return true;
			}
			return false;
		}
	}

	public static class Gift15Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift15!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 18000
					&& NarutoShippudenModVariables.get(entity).giftcount == 14) {
				return true;
			}
			return false;
		}
	}

	public static class Gift16Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift16!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 19200
					&& NarutoShippudenModVariables.get(entity).giftcount == 15) {
				return true;
			}
			return false;
		}
	}

	public static class Gift17Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift17!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 20400
					&& NarutoShippudenModVariables.get(entity).giftcount == 16) {
				return true;
			}
			return false;
		}
	}

	public static class Gift18Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift18!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 21600
					&& NarutoShippudenModVariables.get(entity).giftcount == 17) {
				return true;
			}
			return false;
		}
	}

	public static class Gift19Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift19!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 22800
					&& NarutoShippudenModVariables.get(entity).giftcount == 18) {
				return true;
			}
			return false;
		}
	}

	public static class Gift1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 1200
					&& NarutoShippudenModVariables.get(entity).giftcount == 0) {
				return true;
			}
			return false;
		}
	}

	public static class Gift20Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift20!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 24000
					&& NarutoShippudenModVariables.get(entity).giftcount == 19) {
				return true;
			}
			return false;
		}
	}

	public static class Gift21Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift21!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 25200
					&& NarutoShippudenModVariables.get(entity).giftcount == 20) {
				return true;
			}
			return false;
		}
	}

	public static class Gift22Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift22!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 26400
					&& NarutoShippudenModVariables.get(entity).giftcount == 21) {
				return true;
			}
			return false;
		}
	}

	public static class Gift23Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift23!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 27600
					&& NarutoShippudenModVariables.get(entity).giftcount == 22) {
				return true;
			}
			return false;
		}
	}

	public static class Gift24Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift24!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 28800
					&& NarutoShippudenModVariables.get(entity).giftcount == 23) {
				return true;
			}
			return false;
		}
	}

	public static class Gift25Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift25!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 30000
					&& NarutoShippudenModVariables.get(entity).giftcount == 24) {
				return true;
			}
			return false;
		}
	}

	public static class Gift2Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift2!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 2400
					&& NarutoShippudenModVariables.get(entity).giftcount == 1) {
				return true;
			}
			return false;
		}
	}

	public static class Gift3Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift3!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 3600
					&& NarutoShippudenModVariables.get(entity).giftcount == 2) {
				return true;
			}
			return false;
		}
	}

	public static class Gift4Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift4!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 4800
					&& NarutoShippudenModVariables.get(entity).giftcount == 3) {
				return true;
			}
			return false;
		}
	}

	public static class Gift5Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift5!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 6000
					&& NarutoShippudenModVariables.get(entity).giftcount == 4) {
				return true;
			}
			return false;
		}
	}

	public static class Gift6Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift6!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 7200
					&& NarutoShippudenModVariables.get(entity).giftcount == 5) {
				return true;
			}
			return false;
		}
	}

	public static class Gift7Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift7!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 8400
					&& NarutoShippudenModVariables.get(entity).giftcount == 6) {
				return true;
			}
			return false;
		}
	}

	public static class Gift8Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift8!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 9600
					&& NarutoShippudenModVariables.get(entity).giftcount == 7) {
				return true;
			}
			return false;
		}
	}

	public static class Gift9Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Gift9!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).calendar_calculator >= 10800
					&& NarutoShippudenModVariables.get(entity).giftcount == 8) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpen10Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen10!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 2);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 10;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen11Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen11!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WadOfRyoItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 11;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen12Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen12!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(GingerbreadItem.block);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 12;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen13Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen13!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(TantoItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 13;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen14Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen14!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Blocks.OAK_LOG);
				_setstack.setCount((int) 64);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Blocks.COBBLESTONE);
				_setstack.setCount((int) 64);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 14;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen15Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen15!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 3);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 15;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen16Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen16!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 15);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 16;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen17Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen17!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 15);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 17;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen18Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen18!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 20);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 18;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen19Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen19!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 20);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 19;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen1Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen1!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ChristmasRamenItem.block);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 1;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen20Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen20!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 20);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ChristmasRamenItem.block);
				_setstack.setCount((int) 3);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(GingerbreadItem.block);
				_setstack.setCount((int) 3);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 20;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen21Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen21!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(KatanaItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 21;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen22Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen22!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(KusanagiSasukeItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 22;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen23Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen23!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ChakraBladeItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 23;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen24Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen24!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 25);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 24;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen25Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen25!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ChristmasRamenItem.block);
				_setstack.setCount((int) 15);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(GingerbreadItem.block);
				_setstack.setCount((int) 15);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ChakraBladeItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(WadOfRyoItem.block);
				_setstack.setCount((int) 3);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 30);
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 25;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
				((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("\u00A72FishyHard: \u00A74Merry Christmas!"), (false));
			}
		}
	}

	public static class GiftOpen2Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen2!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(BanknoteOfRyoItem.block);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 2;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen3Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen3!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(IronStickItem.block);
				_setstack.setCount((int) 16);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 3;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen4Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen4!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(SharpIronItem.block);
				_setstack.setCount((int) 16);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 4;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen5Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen5!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 5;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen6Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen6!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(GingerbreadItem.block);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 6;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen7Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen7!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Items.DIAMOND);
				_setstack.setCount((int) 15);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 7;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen8Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen8!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(Blocks.IRON_BLOCK);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 8;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GiftOpen9Procedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpen9!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(ChristmasRamenItem.block);
				_setstack.setCount((int) 5);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
			{
				double _setval = 9;
				entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class GingerbreadPlayerFinishesUsingItemProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GingerbreadPlayerFinishesUsingItem!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 200, (int) 1, (false), (false)));
		}
	}
}
