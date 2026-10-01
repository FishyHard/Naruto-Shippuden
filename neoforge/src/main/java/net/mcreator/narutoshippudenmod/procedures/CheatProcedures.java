package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.util.RandomSource;

import io.netty.buffer.Unpooled;
import java.util.Map;
import java.util.Random;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.MangekyouSharinganCheatGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatDojutsuGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatGUIGui;
import net.mcreator.narutoshippudenmod.gui.CheatGuis.NarutoShippudenCheatKekkeiGenkaiGUIGui;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.MenuProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public final class CheatProcedures {
	private CheatProcedures() {
	}

	public static class CheatDojutstuButtonShimuraProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutstuButtonShimura!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.SharinganShimura, _setval)) {
						capability.SharinganShimura = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
						capability.dojutsusharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatDojutsuButtonBackProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure CheatDojutsuButtonBack!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure CheatDojutsuButtonBack!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure CheatDojutsuButtonBack!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure CheatDojutsuButtonBack!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutsuButtonBack!");
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
							return Component.literal("NarutoShippudenCheatGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new NarutoShippudenCheatGUIGui.GuiContainerMod(id, inventory,
									new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
				}
			}
		}
	}

	public static class CheatDojutsuButtonByakuganProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutsuButtonByakugan!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.byakugan, _setval)) {
						capability.byakugan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsubyakugan, _setval)) {
						capability.dojutsubyakugan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatDojutsuButtonIsshikiDojutsuProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutsuButtonIsshikiDojutsu!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.isshikidojutsu, _setval)) {
						capability.isshikidojutsu = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsuisshiki, _setval)) {
						capability.dojutsuisshiki = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatDojutsuButtonKetsuryuganProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutsuButtonKetsuryugan!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.ketsuryugan, _setval)) {
						capability.ketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsuketsuryugan, _setval)) {
						capability.dojutsuketsuryugan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatDojutsuButtonRinneganProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutsuButtonRinnegan!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.rinnegan, _setval)) {
						capability.rinnegan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsurinnegan, _setval)) {
						capability.dojutsurinnegan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatDojutsuButtonSharinganProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutsuButtonSharingan!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.sharingan, _setval)) {
						capability.sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
						capability.dojutsusharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatDojutsuButtonTenseiganProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatDojutsuButtonTenseigan!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.tenseigan, _setval)) {
						capability.tenseigan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsutenseigan, _setval)) {
						capability.dojutsutenseigan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatGUIProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure CheatGUI!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure CheatGUI!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure CheatGUI!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure CheatGUI!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatGUI!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			if ((entity instanceof ServerPlayer _op && net.mcreator.narutoshippudenmod.core.NarutoActions.canCheat(_op))) {
				{
					Entity _ent = entity;
					if (_ent instanceof ServerPlayer) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						((ServerPlayer) _ent).openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("NarutoShippudenCheatGUI");
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new NarutoShippudenCheatGUIGui.GuiContainerMod(id, inventory,
										new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _buf -> _buf.writeBlockPos(_bpos));
					}
				}
			} else if (!((entity instanceof ServerPlayer _op && net.mcreator.narutoshippudenmod.core.NarutoActions.canCheat(_op)))) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendSystemMessage(Component.literal("Cheats need operator rights."));
				}
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonBoilReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonBoilRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.boilreleaselogic, _setval)) {
						capability.boilreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonBoneReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonBoneRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.bonereleaselogic, _setval)) {
						capability.bonereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonDustReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonDustRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dustreleaselogic, _setval)) {
						capability.dustreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonIceReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonIceRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.icereleaselogic, _setval)) {
						capability.icereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonMagnetReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonMagnetRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.magnetreleaselogic, _setval)) {
						capability.magnetreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonSmokeReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonSmokeRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.smokereleaselogic, _setval)) {
						capability.smokereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonSteelReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonSteelRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.steelreleaselogic, _setval)) {
						capability.steelreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonStormReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonStormRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.stormreleaselogic, _setval)) {
						capability.stormreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonSwiftReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonSwiftRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.swiftreleaselogic, _setval)) {
						capability.swiftreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonTyphoonReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonTyphoonRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.typhoonreleaslogic, _setval)) {
						capability.typhoonreleaslogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class CheatKekkeiGenkaiButtonWoodReleaseProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure CheatKekkeiGenkaiButtonWoodRelease!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.woodreleaselogic, _setval)) {
						capability.woodreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class ItachiMSCheatProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ItachiMSCheat!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (Mth.nextInt(RandomSource.create(), 1000, 1500));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use_Max, _setval)) {
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.MangekyouSharinganItachi, _setval)) {
						capability.MangekyouSharinganItachi = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class KakashiMSCheatProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KakashiMSCheat!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (Mth.nextInt(RandomSource.create(), 1000, 1500));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use_Max, _setval)) {
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.MangekyouSharinganKakashi, _setval)) {
						capability.MangekyouSharinganKakashi = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class KakashiSharinganCheatProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure KakashiSharinganCheat!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.SharinganKakashi, _setval)) {
						capability.SharinganKakashi = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsusharingan, _setval)) {
						capability.dojutsusharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class MadaraMSCheatProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MadaraMSCheat!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (Mth.nextInt(RandomSource.create(), 1000, 1500));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use_Max, _setval)) {
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.MangekyouSharinganMadara, _setval)) {
						capability.MangekyouSharinganMadara = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class MangekyouCheatGUIOpenProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure MangekyouCheatGUIOpen!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure MangekyouCheatGUIOpen!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure MangekyouCheatGUIOpen!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure MangekyouCheatGUIOpen!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure MangekyouCheatGUIOpen!");
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
							return Component.literal("MangekyouSharinganCheat");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new MangekyouSharinganCheatGui.GuiContainerMod(id, inventory,
									new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _buf -> _buf.writeBlockPos(_bpos));
				}
			}
		}
	}

	public static class ObitoMSCheatProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ObitoMSCheat!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (Mth.nextInt(RandomSource.create(), 1000, 1500));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use_Max, _setval)) {
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.MangekyouSharinganObito, _setval)) {
						capability.MangekyouSharinganObito = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class SasukeMSCheatProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure SasukeMSCheat!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (Mth.nextInt(RandomSource.create(), 1000, 1500));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use_Max, _setval)) {
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.MangekyouSharinganSasuke, _setval)) {
						capability.MangekyouSharinganSasuke = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}

	public static class ShisuiMSCheatProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShisuiMSCheat!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = (Mth.nextInt(RandomSource.create(), 1000, 1500));
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan_Technique_Use_Max, _setval)) {
						capability.Mangekyou_Sharingan_Technique_Use_Max = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.Mangekyou_Sharingan, _setval)) {
						capability.Mangekyou_Sharingan = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				boolean _setval = (true);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.MangekyouSharinganShisui, _setval)) {
						capability.MangekyouSharinganShisui = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
			{
				String _setval = "1x1";
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					if (!java.util.Objects.equals(capability.dojutsums, _setval)) {
						capability.dojutsums = _setval;
						capability.syncPlayerVariables(entity);
					}
				});
			}
		}
	}
}
