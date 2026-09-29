package net.mcreator.narutoshippudenmod.procedures;

import java.util.Map;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.minecraft.world.entity.Entity;

public final class GuiDisplayProcedures {
	private GuiDisplayProcedures() {
	}

	public static class ChakraDisplayLength1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraDisplayLength1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).ChakraMax)).length() == 1) {
				return true;
			}
			return false;
		}
	}

	public static class ChakraDisplayLength2Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraDisplayLength2!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).ChakraMax)).length() == 2) {
				return true;
			}
			return false;
		}
	}

	public static class ChakraDisplayLength3Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraDisplayLength3!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).ChakraMax)).length() == 3) {
				return true;
			}
			return false;
		}
	}

	public static class ChakraDisplayLength4Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraDisplayLength4!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).ChakraMax)).length() == 4) {
				return true;
			}
			return false;
		}
	}

	public static class ChakraDisplayLength5Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraDisplayLength5!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).ChakraMax)).length() == 5) {
				return true;
			}
			return false;
		}
	}

	public static class ChakraDisplayLength6Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraDisplayLength6!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).ChakraMax)).length() == 6) {
				return true;
			}
			return false;
		}
	}

	public static class ChakraDisplayLength7Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraDisplayLength7!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).ChakraMax)).length() == 7) {
				return true;
			}
			return false;
		}
	}

	public static class DiplayFumaSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DiplayFumaSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 12) {
				return true;
			}
			return false;
		}
	}


	public static class DiplayHozukiSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DiplayHozukiSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 13) {
				return true;
			}
			return false;
		}
	}



	public static class DiplaySarutobiSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DiplaySarutobiSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 11) {
				return true;
			}
			return false;
		}
	}

	public static class Display10MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display10Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 10) {
				return true;
			}
			return false;
		}
	}

	public static class Display11MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display11Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 11) {
				return true;
			}
			return false;
		}
	}

	public static class Display12MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display12Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 12) {
				return true;
			}
			return false;
		}
	}

	public static class Display13MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display13Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 13) {
				return true;
			}
			return false;
		}
	}

	public static class Display14MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display14Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 14) {
				return true;
			}
			return false;
		}
	}

	public static class Display15MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display15Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 15) {
				return true;
			}
			return false;
		}
	}

	public static class Display16MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display16Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 16) {
				return true;
			}
			return false;
		}
	}

	public static class Display17MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display17Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 17) {
				return true;
			}
			return false;
		}
	}

	public static class Display18MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display18Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 18) {
				return true;
			}
			return false;
		}
	}

	public static class Display19MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display19Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 19) {
				return true;
			}
			return false;
		}
	}

	public static class Display1MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display1Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 1) {
				return true;
			}
			return false;
		}
	}

	public static class Display20MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display20Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 20) {
				return true;
			}
			return false;
		}
	}

	public static class Display21MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display21Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 21) {
				return true;
			}
			return false;
		}
	}

	public static class Display22MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display22Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 22) {
				return true;
			}
			return false;
		}
	}

	public static class Display23MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display23Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 23) {
				return true;
			}
			return false;
		}
	}

	public static class Display24MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display24Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 24) {
				return true;
			}
			return false;
		}
	}

	public static class Display25MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display25Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 25) {
				return true;
			}
			return false;
		}
	}

	public static class Display26MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display26Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 26) {
				return true;
			}
			return false;
		}
	}

	public static class Display27MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display27Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 27) {
				return true;
			}
			return false;
		}
	}

	public static class Display28MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display28Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 28) {
				return true;
			}
			return false;
		}
	}

	public static class Display29MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display29Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 29) {
				return true;
			}
			return false;
		}
	}

	public static class Display2MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display2Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 2) {
				return true;
			}
			return false;
		}
	}

	public static class Display30MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display30Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 30) {
				return true;
			}
			return false;
		}
	}

	public static class Display31MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display31Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 31) {
				return true;
			}
			return false;
		}
	}

	public static class Display32MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display32Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 32) {
				return true;
			}
			return false;
		}
	}

	public static class Display33MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display33Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 33) {
				return true;
			}
			return false;
		}
	}

	public static class Display34MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display34Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 34) {
				return true;
			}
			return false;
		}
	}

	public static class Display35MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display35Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 35) {
				return true;
			}
			return false;
		}
	}

	public static class Display36MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display36Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 36) {
				return true;
			}
			return false;
		}
	}

	public static class Display37MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display37Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 37) {
				return true;
			}
			return false;
		}
	}

	public static class Display38MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display38Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 38) {
				return true;
			}
			return false;
		}
	}

	public static class Display39MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display39Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 39) {
				return true;
			}
			return false;
		}
	}

	public static class Display3MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display3Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 3) {
				return true;
			}
			return false;
		}
	}

	public static class Display40MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display40Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 40) {
				return true;
			}
			return false;
		}
	}

	public static class Display41MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display41Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 41) {
				return true;
			}
			return false;
		}
	}

	public static class Display42MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display42Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 42) {
				return true;
			}
			return false;
		}
	}

	public static class Display43MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display43Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 43) {
				return true;
			}
			return false;
		}
	}

	public static class Display44MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display44Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 44) {
				return true;
			}
			return false;
		}
	}

	public static class Display45MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display45Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 45) {
				return true;
			}
			return false;
		}
	}

	public static class Display46MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display46Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 46) {
				return true;
			}
			return false;
		}
	}

	public static class Display47MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display47Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 47) {
				return true;
			}
			return false;
		}
	}

	public static class Display48MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display48Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 48) {
				return true;
			}
			return false;
		}
	}

	public static class Display4MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display4Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 4) {
				return true;
			}
			return false;
		}
	}

	public static class Display5MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display5Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 5) {
				return true;
			}
			return false;
		}
	}

	public static class Display6MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display6Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 6) {
				return true;
			}
			return false;
		}
	}

	public static class Display7MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display7Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 7) {
				return true;
			}
			return false;
		}
	}

	public static class Display8MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display8Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 8) {
				return true;
			}
			return false;
		}
	}

	public static class Display9MiniProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Display9Mini!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Mini_Game_Timer_Button == 9) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayAburameInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayAburameInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).aburamereleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayAburameSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayAburameSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 6) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayAkimichiInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayAkimichiInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).akimichireleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayAkimichiSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayAkimichiSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 4) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayBoilInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayBoilInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).boilreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayBoneInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayBoneInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).bonereleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayByakugan2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayByakugan2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayByakugan2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayByakugan2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayByakugan2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayByakugan2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayByakugan2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayByakugan2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayByakuganActivated2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayByakuganActivated2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					|| NarutoShippudenModVariables.get(entity).Pupils_Height == 2)
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayByakuganActivated2x2Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayByakuganActivated2x2!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					|| NarutoShippudenModVariables.get(entity).Pupils_Height == 2)
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Byakugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayByakuganInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayByakuganInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).byakugan == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayChinoikeInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayChinoikeInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).chinoikereleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayChinoikeSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayChinoikeSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 10) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayCloudSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayCloudSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectvillage == 2) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayDustInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayDustInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).dustreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayEarthInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayEarthInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).earthreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayEarthSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayEarthSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 4) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayFireInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayFireInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).firereleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayFireSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayFireSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 0) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayFumaInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayFumaInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).fumareleaselogic == true) {
				return true;
			}
			return false;
		}
	}




	public static class DisplayHozukiInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayHozukiInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hozukireleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayHyugaInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayHyugaInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).hyugareleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayHyugaSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayHyugaSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 2) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayIburiInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIburiInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).iburireleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayIburiSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIburiSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 9) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayIceInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIceInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).icereleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayInuzukaInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayInuzukaInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).inuzukareleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayInuzukaSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayInuzukaSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 7) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayIsshikiDojutsu2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIsshikiDojutsu2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Kokugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayIsshikiDojutsu2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIsshikiDojutsu2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Kokugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayIsshikiDojutsu2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIsshikiDojutsu2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Kokugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayIsshikiDojutsu2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIsshikiDojutsu2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Kokugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayIsshikiDojutsuInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayIsshikiDojutsuInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).isshikidojutsu == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayItachiDojutsu2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayItachiDojutsu2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Itachi")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayItachiDojutsu2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayItachiDojutsu2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Itachi")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayItachiDojutsu2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayItachiDojutsu2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Itachi")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayItachiDojutsu2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayItachiDojutsu2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Itachi")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}



	public static class DisplayKakashi1Dojutsu2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKakashi1Dojutsu2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKakashi1Dojutsu2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKakashi1Dojutsu2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKakashi1Dojutsu2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKakashi1Dojutsu2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKakashi1Dojutsu2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKakashi1Dojutsu2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKakashiDojutsu2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKakashiDojutsu2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi ")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKakashiDojutsu2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKakashiDojutsu2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi ")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKakashiDojutsu2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKakashiDojutsu2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi ")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKakashiDojutsu2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKakashiDojutsu2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi ")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}



	public static class DisplayKetsuryugan2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKetsuryugan2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKetsuryugan2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKetsuryugan2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKetsuryugan2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKetsuryugan2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKetsuryugan2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKetsuryugan2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Ketsuryugan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKetsuryuganInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKetsuryuganInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).ketsuryugan == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayKonohaSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayKonohaSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectvillage == 0) {
				return true;
			}
			return false;
		}
	}



	public static class DisplayLearnCustomJutsu1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayLearnCustomJutsu1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).customjutsu1learn == false) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayLeeInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayLeeInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).leereleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayLeeSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayLeeSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 3) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayLightningInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayLightningInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).lightningreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayLightningSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayLightningSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 1) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMSItachiInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMSItachiInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganItachi == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMSMadaraInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMSMadaraInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganMadara == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMSObitoInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMSObitoInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganObito == true
					|| NarutoShippudenModVariables.get(entity).MangekyouSharinganKakashi == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMSSasukeInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMSSasukeInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganSasuke == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMSShisuiInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMSShisuiInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).MangekyouSharinganShisui == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMadaraDojutsu2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMadaraDojutsu2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Madara")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMadaraDojutsu2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMadaraDojutsu2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Madara")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMadaraDojutsu2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMadaraDojutsu2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Madara")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMadaraDojutsu2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMadaraDojutsu2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Madara")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMagnetInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMagnetInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).magnetreleaselogic == true) {
				return true;
			}
			return false;
		}
	}





	public static class DisplayMinus2SelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMinus2Select!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					|| (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")
					|| (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayMistSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayMistSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectvillage == 1) {
				return true;
			}
			return false;
		}
	}



	public static class DisplayNaraInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayNaraInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).narareleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayNaraSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayNaraSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 5) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayObitoDojutsu2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayObitoDojutsu2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Obito")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayObitoDojutsu2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayObitoDojutsu2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Obito")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayObitoDojutsu2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayObitoDojutsu2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Obito")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayObitoDojutsu2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayObitoDojutsu2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Obito")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}



	public static class DisplayRinnegan2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayRinnegan2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayRinnegan2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayRinnegan2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayRinnegan2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayRinnegan2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayRinnegan2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayRinnegan2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Rinnegan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayRinneganInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayRinneganInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).rinnegan == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySandSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySandSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectvillage == 3) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySarutobiInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySarutobiInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sarutobireleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySasukeDojutsu2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySasukeDojutsu2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Sasuke")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySasukeDojutsu2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySasukeDojutsu2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Sasuke")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySasukeDojutsu2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySasukeDojutsu2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Sasuke")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySasukeDojutsu2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySasukeDojutsu2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Sasuke")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayScarProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayScar!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi")
					|| (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Kakashi ")) {
				return true;
			}
			return false;
		}
	}



	public static class DisplaySharingan2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySharingan2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySharingan2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySharingan2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySharingan2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySharingan2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySharingan2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySharingan2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySharinganInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySharinganInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).sharingan == true
					|| NarutoShippudenModVariables.get(entity).SharinganKakashi == true
					|| NarutoShippudenModVariables.get(entity).SharinganShimura == true) {
				return true;
			}
			return false;
		}
	}



	public static class DisplayShisuiDojutsu2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayShisuiDojutsu2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Shisui")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayShisuiDojutsu2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayShisuiDojutsu2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Shisui")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayShisuiDojutsu2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayShisuiDojutsu2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Shisui")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayShisuiDojutsu2x2Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayShisuiDojutsu2x2Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Mangekyou")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect2).equals("Shisui")
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelect3).equals("Sharingan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySmokeInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySmokeInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).smokereleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySteelInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySteelInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).steelreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayStoneSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayStoneSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectvillage == 4) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayStormInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayStormInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).stormreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplaySwiftInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplaySwiftInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).swiftreleaselogic == true) {
				return true;
			}
			return false;
		}
	}



	public static class DisplayTenseigan2x1Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTenseigan2x1Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayTenseigan2x1Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTenseigan2x1Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 1
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayTenseigan2x21Pupils2x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTenseigan2x21Pupils2x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 2
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayTenseigan2x2Pupils1x1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTenseigan2x2Pupils1x1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).Pupils_Height == 1
					&& NarutoShippudenModVariables.get(entity).Eyes_Height == 2
					&& (NarutoShippudenModVariables.get(entity).DojutsuSelectResize).equals("Tenseigan")) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayTenseiganInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTenseiganInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tenseigan == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayTsuchigumoInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTsuchigumoInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).tsuchigumoreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayTsuchigumoSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTsuchigumoSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 8) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayTyphoonInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayTyphoonInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).typhoonreleaslogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayUchihaInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayUchihaInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).uchihareleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayUchihaSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayUchihaSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 0) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayUnlearnCustomJutsu1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayUnlearnCustomJutsu1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).customjutsu1learn == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayUzumakiInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayUzumakiInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).uzumakireleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayUzumakiSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayUzumakiSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectclanrelease == 1) {
				return true;
			}
			return false;
		}
	}





	public static class DisplayWaterInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayWaterInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).waterreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayWaterSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayWaterSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 3) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayWindInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayWindInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).windreleaselogic == true) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayWindSelectProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayWindSelect!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).selectnaturerelease == 2) {
				return true;
			}
			return false;
		}
	}

	public static class DisplayWoodInfoProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DisplayWoodInfo!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).woodreleaselogic == true) {
				return true;
			}
			return false;
		}
	}



	public static class GiftOpenDisplay10Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay10!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 10) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay11Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay11!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 11) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay12Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay12!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 12) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay13Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay13!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 13) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay14Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay14!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 14) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay15Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay15!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 15) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay16Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay16!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 16) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay17Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay17!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 17) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay18Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay18!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 18) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay19Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay19!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 19) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 1) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay20Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay20!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 20) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay21Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay21!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 21) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay22Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay22!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 22) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay23Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay23!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 23) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay24Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay24!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 24) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay25Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay25!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 25) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay2Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay2!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 2) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay3Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay3!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 3) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay4Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay4!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 4) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay5Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay5!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 5) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay6Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay6!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 6) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay7Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay7!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 7) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay8Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay8!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 8) {
				return true;
			}
			return false;
		}
	}

	public static class GiftOpenDisplay9Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GiftOpenDisplay9!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).giftcount >= 9) {
				return true;
			}
			return false;
		}
	}

	public static class Headband1DisplayProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Headband1Display!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 0) {
				return true;
			}
			return false;
		}
	}

	public static class Headband2DisplayProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Headband2Display!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 1) {
				return true;
			}
			return false;
		}
	}

	public static class Headband3DisplayProcedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Headband3Display!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).HeadbandSelect == 2) {
				return true;
			}
			return false;
		}
	}

	public static class HealthDisplayLength1Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HealthDisplayLength1!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).HealthMax)).length() == 2) {
				return true;
			}
			return false;
		}
	}

	public static class HealthDisplayLength2Procedure {

		public static boolean executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HealthDisplayLength2!");
				return false;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if ((new java.text.DecimalFormat("##.##").format(NarutoShippudenModVariables.get(entity).HealthMax)).length() == 3) {
				return true;
			}
			return false;
		}
	}
}
