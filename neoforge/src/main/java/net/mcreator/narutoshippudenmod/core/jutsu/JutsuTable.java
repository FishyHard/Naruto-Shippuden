package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.procedures.ClanProcedures;

import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.jutsu;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.technique;

/**
 * The technique items still cast by their MCreator procedure. Everything else is registered by the jutsu classes (NatureJutsu,
 * KekkeiGenkaiJutsu, ClanJutsu, DojutsuJutsu, FlyingRaijin, Weapons, CustomJutsu). Each jutsu: name, unlock (learn variable and
 * tier), stat requirement, chakra cost, cooldown in ticks for Academy Student, Genin, Chunin, Jonin and Kage.
 */
final class JutsuTable {
	private JutsuTable() {
	}

	static void register() {
		technique("shadow_clone_technique", v -> 0, (v, i) -> {}, null, ClanProcedures.ShadowCloneTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Shadow Clone Technique", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 30, 25, 25, 25, 25, 25));
	}
}
