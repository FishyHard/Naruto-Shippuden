package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;

import com.google.gson.Gson;
import io.netty.buffer.Unpooled;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.PasswordGUIDojutsuGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardDojutsuGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardMiniGameGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardMissionsGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.InfoCardUpgradeGui;
import net.mcreator.narutoshippudenmod.gui.InfoCardGuis.StatSelectGui;
import net.mcreator.narutoshippudenmod.gui.JutsuCreationGuis.CreateJutsuGUIGui;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninIwagakureBlackItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninIwagakureItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninIwagakureRedItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKirigakureBlackItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKirigakureItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKirigakureRedItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKonohagakureBlackItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKonohagakureItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKonohagakureRedItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKumogakureBlackItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKumogakureItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninKumogakureRedItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninSunagakureBlackItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninSunagakureItem;
import net.mcreator.narutoshippudenmod.item.ArmorItems.GeninSunagakureRedItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.AburameReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.AkimichiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ChinoikeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.FumaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.HozukiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.HyugaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.YamanakaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.InuzukaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.LeeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.NaraReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.SarutobiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.TsuchigumoReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.UchihaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.UzumakiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.BoilReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.BoneReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.DustReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.EarthReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.FireReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.IceReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.LightningReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.MagnetReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.SmokeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.SteelReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.StormReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.SwiftReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.TyphoonReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WaterReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WindReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WoodReleaseItem;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.fml.loading.FMLPaths;

public final class GuiProcedures {
	private GuiProcedures() {
	}

	public static class ButtonDojutsuSelect2MinusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ButtonDojutsuSelect2Minus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Sasuke")) {
				{
					String _setval = "Kakashi ";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Shisui")) {
				{
					String _setval = "Obito";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Obito")) {
				{
					String _setval = "Madara";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Madara")) {
				{
					String _setval = "Itachi";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Itachi")) {
				{
					String _setval = "Sasuke";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi ")) {
				{
					String _setval = "Shisui";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Default")) {
				{
					String _setval = "Kakashi";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
				{
					String _setval = "Default";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class ButtonDojutsuSelect2PlusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ButtonDojutsuSelect2Plus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Sasuke")) {
				{
					String _setval = "Itachi";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Itachi")) {
				{
					String _setval = "Madara";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Madara")) {
				{
					String _setval = "Obito";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Obito")) {
				{
					String _setval = "Shisui";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Shisui")) {
				{
					String _setval = "Kakashi ";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi ")) {
				{
					String _setval = "Sasuke";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Default")) {
				{
					String _setval = "Kakashi";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
				{
					String _setval = "Default";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.DojutsuSelect2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class ButtonSelectPressProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ButtonSelectPress!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			File NarutoShippuden = new File("");
			com.google.gson.JsonObject mainjsonobject = new com.google.gson.JsonObject();
			double random = 0;
			double randomkkg = 0;
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 0) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(UchihaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 120);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.uchihareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+25 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+15 Genjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+120 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 1) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(UzumakiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).kinjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.kinjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 120);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.uzumakireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+25 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+25 Kinjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+120 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 2) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(HyugaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.hyugareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+115 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 3) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LeeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).taijutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.taijutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.leereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+25 Taijutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+115 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 4) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(AkimichiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.akimichireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+100 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 5) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(NaraReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 210);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.narareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+210 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 6) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(AburameReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 105);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.aburamereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Summoning"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+105 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 7) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(InuzukaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 85);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.inuzukareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Summoning"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+85 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 8) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(TsuchigumoReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.tsuchigumoreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+90 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 9) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(YamanakaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.yamanakareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+90 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 10) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(ChinoikeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu + 5);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 95);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.chinoikereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+5 Genjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+95 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 11) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(SarutobiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 105);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sarutobireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+105 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 12) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FumaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.fumareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+90 IQ"));
				}
			} else if (NarutoShippudenModVariables.get(entity).selectclanrelease == 13) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(HozukiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.hozukireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+90 IQ"));
				}
			}
			if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 0) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 1) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 2) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 3) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 4) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (NarutoShippudenModVariables.get(entity).selectvillage == 0) {
				{
					String _setval = "Hidden Leaf";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.village = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).selectvillage == 1) {
				{
					String _setval = "Hidden Mist";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.village = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).selectvillage == 2) {
				{
					String _setval = "Hidden Cloud";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.village = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).selectvillage == 3) {
				{
					String _setval = "Hidden Sand";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.village = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).selectvillage == 4) {
				{
					String _setval = "Hidden Stone";
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.village = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			NarutoShippuden = (File) new File((FMLPaths.GAMEDIR.get().toString() + "/config/narutoshippuden"),
					File.separator + "narutoshippudenconfig.json");
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(NarutoShippuden));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					mainjsonobject = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					random = (Mth.nextInt(RandomSource.create(), 1, 1000));
					if (random <= mainjsonobject.get("kekkei_genkai_spawn_chance").getAsDouble() * 10) {
						if (entity instanceof Player && !entity.level().isClientSide()) {
							((Player) entity).sendOverlayMessage(Component.literal("Looks like you were borned with Kekkei Genkai"));
						}
						randomkkg = (Mth.nextInt(RandomSource.create(), 1, 11));
						if (randomkkg == 1) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(SmokeReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.smokereleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 2) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(MagnetReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.magnetreleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 3) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(StormReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.stormreleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 4) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(WoodReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.woodreleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 5) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(IceReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.icereleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 6) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(BoneReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.bonereleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 7) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(TyphoonReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.typhoonreleaslogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 8) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(SwiftReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.swiftreleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 9) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(BoilReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.boilreleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 10) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(DustReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.dustreleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						} else if (randomkkg == 11) {
							if (entity instanceof Player) {
								ItemStack _setstack = new ItemStack(SteelReleaseItem.block);
								_setstack.setCount((int) 1);
								Compat.giveItemToPlayer(((Player) entity), _setstack);
							}
							{
								boolean _setval = (true);
								NarutoShippudenModVariables.ifPresent(entity, capability -> {
									capability.steelreleaselogic = _setval;
									capability.syncPlayerVariables(entity);
								});
							}
						}
					}

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (entity instanceof Player)
				((Player) entity).closeContainer();
		}
	}

	public static class ClanReleaseMinusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ClanReleaseMinus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 0) {
				{
					double _setval = 13;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectclanrelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(NarutoShippudenModVariables.get(entity).selectclanrelease == 0)) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).selectclanrelease - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectclanrelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class ClanReleasePlusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ClanReleasePlus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 13) {
				{
					double _setval = 0;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectclanrelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(NarutoShippudenModVariables.get(entity).selectclanrelease == 13)) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).selectclanrelease + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectclanrelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class DojutsuButtonMinusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DojutsuButtonMinus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (true) {
				if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
					{
						String _setval = "Kokugan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = " ";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
					{
						String _setval = "Sharingan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Default";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
					{
						String _setval = "Byakugan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")) {
					{
						String _setval = "Ketsuryugan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = " ";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = " ";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
					{
						String _setval = "Mangekyou";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Sharingan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Sasuke";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
					{
						String _setval = "Rinnegan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Kokugan")) {
					{
						String _setval = "Tenseigan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}

	public static class DojutsuButtonPlusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DojutsuButtonPlus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (true) {
				if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
					{
						String _setval = "Byakugan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = " ";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
					{
						String _setval = "Ketsuryugan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
					{
						String _setval = "Mangekyou";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Sharingan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Sasuke";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")) {
					{
						String _setval = "Rinnegan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = " ";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = " ";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect3 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
					{
						String _setval = "Tenseigan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
					{
						String _setval = "Kokugan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Kokugan")) {
					{
						String _setval = "Sharingan";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelectResize = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						String _setval = "Default";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.DojutsuSelect2 = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}

	public static class EyesHeightButtonMinusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure EyesHeightButtonMinus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
				{
					double _setval = 2;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Eyes_Height = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
				{
					double _setval = 1;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Eyes_Height = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class HeadbandSelectBackProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HeadbandSelectBack!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 0) {
				{
					double _setval = 2;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.HeadbandSelect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 1) {
				{
					double _setval = 0;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.HeadbandSelect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 2) {
				{
					double _setval = 1;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.HeadbandSelect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class HeadbandSelectNextProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HeadbandSelectNext!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 0) {
				{
					double _setval = 1;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.HeadbandSelect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 1) {
				{
					double _setval = 2;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.HeadbandSelect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 2) {
				{
					double _setval = 0;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.HeadbandSelect = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class HeadbandSelectProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HeadbandSelect!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 0) {
				if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Leaf")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKonohagakureItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Stone")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninIwagakureItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Mist")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKirigakureItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Sand")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninSunagakureItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Cloud")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKumogakureItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 1) {
				if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Leaf")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKonohagakureBlackItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Stone")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninIwagakureBlackItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Mist")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKirigakureBlackItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Sand")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninSunagakureBlackItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Cloud")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKumogakureBlackItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 2) {
				if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Leaf")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKonohagakureRedItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Stone")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninIwagakureRedItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Mist")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKirigakureRedItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Sand")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninSunagakureRedItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				} else if ((NarutoShippudenModVariables.get(entity).village).equals("Hidden Cloud")) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(GeninKumogakureRedItem.helmet);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
				}
			}
			{
				String _setval = "Genin";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 22;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.storymode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player)
				((Player) entity).closeContainer();
		}
	}

	public static class InfoCardMiniGameThisGUIIsClosedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InfoCardMiniGameThisGUIIsClosed!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.Mini_Game_Timer_Button = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class InfoCardMiniGameWhileThisGUIIsOpenTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InfoCardMiniGameWhileThisGUIIsOpenTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.tickCount % 10 == 0) {
				{
					double _setval = (Mth.nextInt(RandomSource.create(), 1, 48));
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Mini_Game_Timer_Button = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class InfoCardNextPageProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure InfoCardNextPage!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure InfoCardNextPage!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure InfoCardNextPage!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure InfoCardNextPage!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InfoCardNextPage!");
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
							return Component.literal("InfoCardUpgrade");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new InfoCardUpgradeGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
				}
			}
		}
	}

	public static class JutsuCreateGUIOpenProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure JutsuCreateGUIOpen!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure JutsuCreateGUIOpen!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure JutsuCreateGUIOpen!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure JutsuCreateGUIOpen!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure JutsuCreateGUIOpen!");
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
							return Component.literal("CreateJutsuGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new CreateJutsuGUIGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
				}
			}
		}
	}

	public static class LoginButtonProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure LoginButton!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure LoginButton!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure LoginButton!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure LoginButton!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure LoginButton!");
				return;
			}
			if (dependencies.get("guistate") == null) {
				if (!dependencies.containsKey("guistate"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency guistate for procedure LoginButton!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			HashMap guistate = (HashMap) dependencies.get("guistate");
			if ((new Object() {
				public String getText() {
					EditBox _tf = (EditBox) guistate.get("text:Password");
					if (_tf != null) {
						return _tf.getValue();
					}
					return "";
				}
			}.getText()).equals("oogaboogafrenchtoast")) {
				{
					Entity _ent = entity;
					if (_ent instanceof ServerPlayer) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						((ServerPlayer) _ent).openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("InfoCardDojutsu");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new InfoCardDojutsuGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _buf -> _buf.writeBlockPos(_bpos));
					}
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Login_Dojutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((new Object() {
				public String getText() {
					EditBox _tf = (EditBox) guistate.get("text:Password");
					if (_tf != null) {
						return _tf.getValue();
					}
					return "";
				}
			}.getText()).equals("fishymarcus010")) {
				{
					Entity _ent = entity;
					if (_ent instanceof ServerPlayer) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						((ServerPlayer) _ent).openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("InfoCardDojutsu");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new InfoCardDojutsuGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _buf -> _buf.writeBlockPos(_bpos));
					}
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Login_Dojutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class MiniGameGUIOpenProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MiniGameGUIOpen!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure MiniGameGUIOpen!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure MiniGameGUIOpen!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure MiniGameGUIOpen!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MiniGameGUIOpen!");
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
							return Component.literal("InfoCardMiniGame");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new InfoCardMiniGameGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
				}
			}
		}
	}

	public static class NatureReleaseMinusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NatureReleaseMinus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 0) {
				{
					double _setval = 4;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectnaturerelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(NarutoShippudenModVariables.get(entity).selectnaturerelease == 0)) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).selectnaturerelease - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectnaturerelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class NatureReleasePlusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure NatureReleasePlus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 4) {
				{
					double _setval = 0;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectnaturerelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(NarutoShippudenModVariables.get(entity).selectnaturerelease == 4)) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).selectnaturerelease + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectnaturerelease = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class OpenDojutsuInfoCardProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure OpenDojutsuInfoCard!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure OpenDojutsuInfoCard!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure OpenDojutsuInfoCard!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure OpenDojutsuInfoCard!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure OpenDojutsuInfoCard!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if (true) {
				{
					Entity _ent = entity;
					if (_ent instanceof ServerPlayer) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						((ServerPlayer) _ent).openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("InfoCardDojutsu");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new InfoCardDojutsuGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _buf -> _buf.writeBlockPos(_bpos));
					}
				}
			}
		}
	}

	public static class PressButtonMiniProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PressButtonMini!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (NarutoShippudenModVariables.get(entity).LEVELMINIGAME + 1);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVELMINIGAME = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.Mini_Game_Timer_Button = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class PupilsHeightButtonMinusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure PupilsHeightButtonMinus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1) {
				{
					double _setval = 2;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Pupils_Height = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2) {
				{
					double _setval = 1;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Pupils_Height = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class QuestGUIOpenProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure QuestGUIOpen!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure QuestGUIOpen!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure QuestGUIOpen!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure QuestGUIOpen!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure QuestGUIOpen!");
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
							return Component.literal("InfoCardMissions");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new InfoCardMissionsGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
				}
			}
		}
	}

	public static class RankSetAcademyStudentProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RankSetAcademyStudent!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				String _setval = "Academy Student";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class RankSetChuninProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RankSetChunin!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				String _setval = "Chunin";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class RankSetGeninProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RankSetGenin!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				String _setval = "Genin";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class RankSetJoninProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RankSetJonin!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				String _setval = "Jonin";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class RankSetKageProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure RankSetKage!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				String _setval = "Kage";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.rank = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class ResetDojutsuProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ResetDojutsu!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (!(NarutoShippudenModVariables.get(entity).byakuganactivate == true
					|| NarutoShippudenModVariables.get(entity).ketsuryuganactivate == true
					|| NarutoShippudenModVariables.get(entity).sharinganactivate == true
					|| NarutoShippudenModVariables.get(entity).isshikidojutsuactivate == true
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganActivate == true
					|| NarutoShippudenModVariables.get(entity).tenseiganactivate == true
					|| NarutoShippudenModVariables.get(entity).rinneganactivate == true)) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.byakugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sharingan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.isshikidojutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.SharinganKakashi = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganSasuke = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganItachi = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganMadara = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganObito = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganShisui = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganKakashi = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.MangekyouSharinganActivate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.byakuganactivate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ketsuryuganactivate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sharinganactivate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.isshikidojutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.rinnegan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.rinneganactivate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.tenseigan = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.tenseiganactivate = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Deactivate all dojutsu"));
				}
			}
		}
	}

	public static class ResetInfoStatsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ResetInfoStats!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.firereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.waterreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.windreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.lightningreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.earthreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.uchihareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.uzumakireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hyugareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.leereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.otsutsukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hatakereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.akimichireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.narareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.namikazereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.aburamereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.inuzukareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.tsuchigumoreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.yamanakareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.chinoikereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.yukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kazekagereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.tenroreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.shimurareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.senjureleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kuramareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.sarutobireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.fumareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hoshigakireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kaguyareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hozukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.izunoreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class ResetLevelJPandSPProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ResetLevelJPandSP!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVEL = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 1;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVELMAX = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.LEVELSTAT = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.jp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.sp = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class ResetUpgradeStatsProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ResetUpgradeStats!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kenjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kinjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.jutsupowerstat = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.medicine = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.ninjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.senjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.genjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.shurikenjutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.speed = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.taijutsu = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.summoning = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.IQ = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 100;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.ChakraAmount = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 100;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.ChakraMax = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	public static class SelectDojutsuInfoProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SelectDojutsuInfo!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Default")) {
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "2x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "1x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "2x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "2x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "1x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "2x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsusharingan = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsubyakugan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsubyakugan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsubyakugan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsubyakugan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsuketsuryugan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsuketsuryugan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsuketsuryugan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsuketsuryugan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Sasuke")) {
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "2x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "1x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "2x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Itachi")) {
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "2x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "1x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "2x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Madara")) {
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "2x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "1x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "2x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Obito")) {
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "2x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "1x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "2x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Shisui")) {
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "2x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "1x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "2x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "1x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
						{
							String _setval = "2x1";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "1x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
							&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
						{
							String _setval = "2x2";
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.dojutsums = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsurinnegan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsurinnegan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsurinnegan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsurinnegan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsutenseigan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsutenseigan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsutenseigan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsutenseigan = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			} else if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Kokugan")) {
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "1x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsuisshiki = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1) {
					{
						String _setval = "2x1";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsuisshiki = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "1x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsuisshiki = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
						&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2) {
					{
						String _setval = "2x2";
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.dojutsuisshiki = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
			}
		}
	}

	public static class SelectMenuProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure SelectMenu!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure SelectMenu!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure SelectMenu!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure SelectMenu!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SelectMenu!");
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
							return Component.literal("StatSelect");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new StatSelectGui.GuiContainerMod(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
				}
			}
		}
	}

	public static class VIllageSelectPlusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure VIllageSelectPlus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectvillage == 4) {
				{
					double _setval = 0;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectvillage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(NarutoShippudenModVariables.get(entity).selectvillage == 4)) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).selectvillage + 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectvillage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}

	public static class VillageSelectMinusProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure VillageSelectMinus!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectvillage == 0) {
				{
					double _setval = 4;
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectvillage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (!(NarutoShippudenModVariables.get(entity).selectvillage == 0)) {
				{
					double _setval = (NarutoShippudenModVariables.get(entity).selectvillage - 1);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.selectvillage = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
	}
}
