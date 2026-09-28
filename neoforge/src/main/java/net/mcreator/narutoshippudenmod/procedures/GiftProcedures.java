package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;

import io.netty.buffer.Unpooled;
import java.util.Map;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.gui.MiscGuis.AdventCalendarGUIGui;
import net.mcreator.narutoshippudenmod.item.DnaItems.UndefinedDNAItem;
import net.mcreator.narutoshippudenmod.item.FoodItems.ChristmasRamenItem;
import net.mcreator.narutoshippudenmod.item.FoodItems.GingerbreadItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.IronStickItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.SharpIronItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KatanaItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.KusanagiSasukeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.TantoItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;


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
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (_ent instanceof ServerPlayer) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					((ServerPlayer) _ent).openMenu(new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("AdventCalendarGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new AdventCalendarGUIGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
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
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.REGENERATION, (int) 200, (int) 2, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SPEED, (int) 200, (int) 1, (false), (false)));
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.JUMP_BOOST, (int) 200, (int) 1, (false), (false)));
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 2);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 10;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) entity, 81);
			}
			{
				double _setval = 11;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(GingerbreadItem.block);
				_setstack.setCount((int) 5);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 12;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(TantoItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 13;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(Blocks.OAK_LOG);
				_setstack.setCount((int) 64);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(Blocks.COBBLESTONE);
				_setstack.setCount((int) 64);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 14;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 3);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 15;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 16;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 17;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 18;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 19;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(ChristmasRamenItem.block);
				_setstack.setCount((int) 5);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 1;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 5);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(ChristmasRamenItem.block);
				_setstack.setCount((int) 3);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(GingerbreadItem.block);
				_setstack.setCount((int) 3);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 20;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(KatanaItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 21;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(KusanagiSasukeItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 22;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(ChakraBladeItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 23;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 24;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 5);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(ChristmasRamenItem.block);
				_setstack.setCount((int) 15);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(GingerbreadItem.block);
				_setstack.setCount((int) 15);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(ChakraBladeItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			if (entity instanceof Player) {
				net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) entity, 243);
			}
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVEL + 30);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 25;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.giftcount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player && !entity.level().isClientSide()) {
				((Player) entity).sendSystemMessage(Component.literal("\u00A72FishyHard: \u00A74Merry Christmas!"));
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
			if (entity instanceof Player) {
				net.mcreator.narutoshippudenmod.economy.Ryo.give((Player) entity, 45);
			}
			{
				double _setval = 2;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(IronStickItem.block);
				_setstack.setCount((int) 16);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 3;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(SharpIronItem.block);
				_setstack.setCount((int) 16);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 4;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(UndefinedDNAItem.block);
				_setstack.setCount((int) 1);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 5;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(GingerbreadItem.block);
				_setstack.setCount((int) 5);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 6;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(Items.DIAMOND);
				_setstack.setCount((int) 15);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 7;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(Blocks.IRON_BLOCK);
				_setstack.setCount((int) 5);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 8;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
			if (entity instanceof Player) {
				ItemStack _setstack = new ItemStack(ChristmasRamenItem.block);
				_setstack.setCount((int) 5);
				Compat.giveItemToPlayer(((Player) entity), _setstack);
			}
			{
				double _setval = 9;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
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
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.RESISTANCE, (int) 200, (int) 1, (false), (false)));
		}
	}
}
