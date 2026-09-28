package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.procedures.ClanProcedures;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures;
import net.mcreator.narutoshippudenmod.procedures.KekkeiGenkaiProcedures;
import net.mcreator.narutoshippudenmod.procedures.NatureReleaseProcedures;

import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.jutsu;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.release;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.technique;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.tier;

/**
 * Every technique item and release scroll, read out of the MCreator procedures (porting/jutsu_table.py). Each jutsu:
 * name, unlock (learn variable and tier), stat requirement, chakra cost, cooldown in ticks for Academy Student, Genin,
 * Chunin, Jonin and Kage. Each release: its bought counter, the procedure that buys the next tier, the technique item
 * and learn variable it unlocks, and per tier the JP price, learn value and item given.
 */
final class JutsuTable {
	private JutsuTable() {
	}

	static void register() {
		technique("aburame_release_technique", v -> v.aburametechnique, (v, i) -> v.aburametechnique = i, ClanProcedures.AburameReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Poison Cloud Technique", v -> v.aburamelearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40),
				jutsu("Insect Jar Technique", v -> v.aburamelearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 500, 200, 160, 120, 80, 40),
				jutsu("Insect Bog", v -> v.aburamelearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 650, 200, 160, 120, 80, 40));
		technique("akimichi_release_technique", v -> v.akimichitechnique, (v, i) -> v.akimichitechnique = i, ClanProcedures.AkimichiReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Calorie Control", v -> v.akimichilearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 300, 200, 160, 120, 80, 40),
				jutsu("Human Bullet Tank", v -> v.akimichilearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 0, 750, 500, 300, 200, 100),
				jutsu("Spiked Human Bullet Tank", v -> v.akimichilearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 0, 750, 500, 300, 200, 100),
				jutsu("Butterfly Mode", v -> v.akimichilearn, 4, "Ninjutsu", v -> v.ninjutsu, 35, 0, 750, 500, 300, 200, 100));
		technique("boil_release_technique", v -> v.boiltechnique, (v, i) -> v.boiltechnique = i, KekkeiGenkaiProcedures.BoilReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Skilled Mist Technique", v -> v.boillearn, 1, "Ninjutsu", v -> v.ninjutsu, 25, 500, 200, 160, 120, 80, 40),
				jutsu("Steam Dash", v -> v.boillearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 350, 200, 160, 120, 80, 40),
				jutsu("Unrivalled Strength", v -> v.boillearn, 3, "Ninjutsu", v -> v.ninjutsu, 35, 0, 750, 500, 300, 200, 100));
		technique("bone_release_technique", v -> v.bonetechnique, (v, i) -> v.bonetechnique = i, KekkeiGenkaiProcedures.BoneReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Dance of the Camellia", v -> v.bonelearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 200, 750, 500, 300, 200, 100),
				jutsu("Dance of the Clematis: Flower", v -> v.bonelearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 350, 750, 500, 300, 200, 100),
				jutsu("Dance of the Larch", v -> v.bonelearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 0, 750, 500, 300, 200, 100));
		technique("dust_release_technique", v -> v.dusttechnique, (v, i) -> v.dusttechnique = i, KekkeiGenkaiProcedures.DustReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Detachment of the Primitive World", v -> v.dustlearn, 1, "Ninjutsu", v -> v.ninjutsu, 70, 5000, 10000, 7500, 5000, 3500, 2500));
		technique("earth_release_technique", v -> v.earth_technique, (v, i) -> v.earth_technique = i, NatureReleaseProcedures.EarthReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Fist Rock Technique", v -> v.earthlearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Golem Technique", v -> v.earthlearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Earth-Style Wall", v -> v.earthlearn, 3, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Earth Spear", v -> v.earthlearn, 4, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40));
		technique("fire_release_technique", v -> v.firetechnique, (v, i) -> v.firetechnique = i, NatureReleaseProcedures.FireReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Running Fire", v -> v.firelearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Great Fireball Technique", v -> v.firelearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Great Dragon Fire Technique", v -> v.firelearn, 3, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Phoenix Flower Jutsu", v -> v.firelearn, 4, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40));
		technique("fuma_release_technique", v -> v.fumatechnique, (v, i) -> v.fumatechnique = i, ClanProcedures.FumaReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Shuriken", v -> v.fumalearn, 1, "Ninjutsu", v -> v.ninjutsu, 15, 30, 140, 100, 60, 40, 20),
				jutsu("Fuma Shuriken", v -> v.fumalearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 50, 140, 100, 60, 40, 20),
				jutsu("Toroi Unique Fuma Shuriken", v -> v.fumalearn, 3, "Ninjutsu", v -> v.ninjutsu, 25, 80, 140, 100, 60, 40, 20));
		technique("furamingogan_technique", v -> v.furamingogan_technique, (v, i) -> v.furamingogan_technique = i, DojutsuProcedures.FuramingoganTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Furamingogan Secret Ritual", v -> v.furamingoganlearn, 1, "Ninjutsu", v -> v.ninjutsu, 15, 150, 750, 500, 400, 300, 200),
				jutsu("Furamingogan Beam", v -> v.furamingoganlearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 350, 1500, 1000, 750, 500, 250),
				jutsu("Furamingogan Jump", v -> v.furamingoganlearn, 3, "Ninjutsu", v -> v.ninjutsu, 25, 500, 2500, 2000, 1500, 1000, 500));
		technique("hozuki_release_technique", v -> v.hozukitechnique, (v, i) -> v.hozukitechnique = i, ClanProcedures.HozukiReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Drowning Water Blob Technique", v -> v.hozukilearn, 1, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Water Gun Technique", v -> v.hozukilearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 300, 200, 160, 120, 80, 40),
				jutsu("Great Water Arm Technique", v -> v.hozukilearn, 3, "Ninjutsu", v -> v.ninjutsu, 25, 0, 750, 500, 300, 200, 100));
		technique("hyuga_release_technique", v -> v.hyugatechnique, (v, i) -> v.hyugatechnique = i, ClanProcedures.HyugaReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Gentle Fist", v -> v.hyugalearn, 1, null, v -> v.ninjutsu, 0, 0, 200, 160, 120, 80, 40),
				jutsu("Gentle Step Twin Lion Fists", v -> v.hyugalearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40),
				jutsu("Eight Trigrams Twin Lions Crumbling Attack", v -> v.hyugalearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40),
				jutsu("Eight Trigrams Palms Revolving Heaven", v -> v.hyugalearn, 4, "Ninjutsu", v -> v.ninjutsu, 40, 650, 200, 160, 120, 80, 40),
				jutsu("Eight Trigrams Sixty-Four Palms", v -> v.hyugalearn, 5, "Ninjutsu", v -> v.ninjutsu, 45, 900, 200, 160, 120, 80, 40));
		technique("ice_release_technique", v -> v.icetechnique, (v, i) -> v.icetechnique = i, KekkeiGenkaiProcedures.IceReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Certain-Kill Ice Spears", v -> v.icelearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 300, 100, 80, 60, 40, 20),
				jutsu("Demonic Mirroring Ice Crystals", v -> v.icelearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 500, 1000, 800, 600, 400, 150),
				jutsu("Black Dragon Blizzard", v -> v.icelearn, 3, "Ninjutsu", v -> v.ninjutsu, 35, 750, 1000, 800, 600, 400, 150));
		technique("inuzuka_release_technique", v -> v.inuzukatechnique, (v, i) -> v.inuzukatechnique = i, ClanProcedures.InuzukaReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Akamaru", v -> v.inuzukalearn, 1, "Ninjutsu", v -> v.ninjutsu, 10, 200, 0, 0, 0, 0, 0),
				jutsu("Passing Fang", v -> v.inuzukalearn, 2, "Ninjutsu", v -> v.ninjutsu, 15, 350, 500, 400, 300, 200, 100),
				jutsu("Human Beast Combination Transformation: Double-Headed Wolf", v -> v.inuzukalearn, 3, "Ninjutsu", v -> v.ninjutsu, 20, 500, 0, 0, 0, 0, 0),
				jutsu("Human Beast Mixture Transformation: Three-Headed Wolf", v -> v.inuzukalearn, 4, "Ninjutsu", v -> v.ninjutsu, 25, 750, 0, 0, 0, 0, 0));
		technique("isshiki_dojutsu_release_technique", v -> v.isshikidojutsutechnique, (v, i) -> v.isshikidojutsutechnique = i, DojutsuProcedures.IsshikiDojutsuReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Sukunahikona", v -> v.isshikidojutsulearn, 1, "Ninjutsu", v -> v.ninjutsu, 25, 500, 200, 160, 120, 80, 40),
				jutsu("Disruption Cube", v -> v.isshikidojutsulearn, 2, "Ninjutsu", v -> v.ninjutsu, 35, 1000, 200, 160, 120, 80, 40));
		technique("izuno_release_technique", v -> v.izunotechnique, (v, i) -> v.izunotechnique = i, ClanProcedures.IzunoReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Cat Covering", v -> v.izunolearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 0, 750, 500, 300, 200, 100),
				jutsu("Monster Cat Beckoning Technique", v -> v.izunolearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 0, 1500, 1250, 1000, 750, 500));
		technique("lee_release_technique", v -> v.lee_technique, (v, i) -> v.lee_technique = i, ClanProcedures.LeeReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Gate of Opening", v -> v.leelearn, 1, null, v -> v.ninjutsu, 0, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Healing", v -> v.leelearn, 2, "Taijutsu", v -> v.taijutsu, 30, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Life", v -> v.leelearn, 3, "Taijutsu", v -> v.taijutsu, 45, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Pain", v -> v.leelearn, 4, "Taijutsu", v -> v.taijutsu, 60, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Limit", v -> v.leelearn, 5, "Taijutsu", v -> v.taijutsu, 75, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of View", v -> v.leelearn, 6, "Taijutsu", v -> v.taijutsu, 90, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Wonder", v -> v.leelearn, 7, "Taijutsu", v -> v.taijutsu, 105, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Death", v -> v.leelearn, 8, "Taijutsu", v -> v.taijutsu, 105, 0, 0, 0, 0, 0, 0));
		technique("lightning_release_technique", v -> v.lightning_technique, (v, i) -> v.lightning_technique = i, NatureReleaseProcedures.LightningReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Lightning Ball Technique", v -> v.lightninglearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Chidori Senbon", v -> v.lightninglearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Lariat", v -> v.lightninglearn, 3, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Kirin", v -> v.lightninglearn, 4, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40));
		technique("magnet_release_technique", v -> v.magnettechnique, (v, i) -> v.magnettechnique = i, KekkeiGenkaiProcedures.MagnetReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Iron Sand Coat", v -> v.magnetlearn, 1, "Ninjutsu", v -> v.ninjutsu, 25, 0, 200, 160, 120, 80, 40),
				jutsu("Iron Sand Drizzle", v -> v.magnetlearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40),
				jutsu("Black Iron Fists", v -> v.magnetlearn, 3, "Ninjutsu", v -> v.ninjutsu, 35, 0, 200, 160, 120, 80, 40),
				jutsu("Black Iron Wings", v -> v.magnetlearn, 4, "Ninjutsu", v -> v.ninjutsu, 40, 0, 200, 160, 120, 80, 40));
		technique("sarutobi_release_technique", v -> v.sarutobitechnique, (v, i) -> v.sarutobitechnique = i, ClanProcedures.SarutobiReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Ash Pile Burning", v -> v.sarutobilearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40),
				jutsu("Fire Dragon Flame Bullet", v -> v.sarutobilearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 350, 200, 160, 120, 80, 40));
		technique("sharingan_release_technique", v -> v.sharingantechnique, (v, i) -> v.sharingantechnique = i, DojutsuProcedures.SharinganReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Coercion Sharingan", v -> v.sharinganlearn, 1, "Ninjutsu", v -> v.ninjutsu, 10, 200, 200, 160, 120, 80, 40),
				jutsu("Demonic Illusion: Mirage Crow", v -> v.sharinganlearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40),
				jutsu("Demonic Illusion: Shackling Stakes Technique", v -> v.sharinganlearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40));
		technique("smoke_release_technique", v -> v.smoketechnique, (v, i) -> v.smoketechnique = i, KekkeiGenkaiProcedures.SmokeReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Smoke Form", v -> v.smokelearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 0, 750, 500, 300, 200, 100),
				jutsu("Smoke Fist", v -> v.smokelearn, 2, null, v -> v.ninjutsu, 0, 0, 200, 160, 120, 80, 40),
				jutsu("Smoke Gun", v -> v.smokelearn, 3, "Ninjutsu", v -> v.ninjutsu, 50, 1000, 200, 160, 120, 80, 40));
		technique("steel_release_technique", v -> v.steeltechnique, (v, i) -> v.steeltechnique = i, KekkeiGenkaiProcedures.SteelReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Impervious Armour", v -> v.steellearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 0, 750, 500, 300, 200, 100),
				jutsu("Steel Projectile", v -> v.steellearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 450, 200, 160, 120, 80, 40));
		technique("storm_release_technique", v -> v.stormtechnique, (v, i) -> v.stormtechnique = i, KekkeiGenkaiProcedures.StormReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Laser Circus", v -> v.stormlearn, 1, null, v -> v.ninjutsu, 0, 0, 0, 0, 0, 0, 0),
				jutsu("Thunder Cloud Inner Wave", v -> v.stormlearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 500, 1000, 800, 600, 400, 150));
		technique("tenro_release_technique", v -> v.tenrotechnique, (v, i) -> v.tenrotechnique = i, ClanProcedures.TenroReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Beast-Human Fury Kicks", v -> v.tenrolearn, 1, "Ninjutsu", v -> v.ninjutsu, 15, 50, 20, 15, 10, 5, 3),
				jutsu("Beast-Human Transformation Technique", v -> v.tenrolearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 0, 1500, 1250, 1000, 750, 500),
				jutsu("Beast-Human Needle Senbon", v -> v.tenrolearn, 3, "Ninjutsu", v -> v.ninjutsu, 25, 300, 500, 400, 300, 200, 100));
		technique("typhoon_release_technique", v -> v.typhoontechnique, (v, i) -> v.typhoontechnique = i, KekkeiGenkaiProcedures.TyphoonReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Great Consecutive Bursting Strong Winds", v -> v.typhoonlearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 300, 200, 160, 120, 80, 40),
				jutsu("Great Consecutive Bursting Extreme Winds", v -> v.typhoonlearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 450, 200, 160, 120, 80, 40));
		technique("uzumaki_release_technique", v -> v.uzumakitechnique, (v, i) -> v.uzumakitechnique = i, ClanProcedures.UzumakiReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Adamantine Sealing Chains", v -> v.uzumakilearn, 1, null, v -> v.ninjutsu, 0, 0, 200, 160, 120, 80, 40),
				jutsu("Heal Bite", v -> v.uzumakilearn, 2, null, v -> v.ninjutsu, 0, 0, 200, 160, 120, 80, 40),
				jutsu("Dead Demon Consuming Seal", v -> v.uzumakilearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40));
		technique("voltic_mode_technique", v -> v.voltic_technique, (v, i) -> v.voltic_technique = i, DojutsuProcedures.VolticModeTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Voltic Hammer", v -> v.volticlearn, 1, "Ninjutsu", v -> v.ninjutsu, 15, 100, 200, 160, 120, 80, 40),
				jutsu("Voltic Execution", v -> v.volticlearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 450, 3000, 2500, 2000, 1500, 1000),
				jutsu("Voltic Thomas Cannon", v -> v.volticlearn, 3, "Ninjutsu", v -> v.ninjutsu, 25, 500, 3500, 3000, 2500, 2000, 1500));
		technique("water_release_technique", v -> v.water_technique, (v, i) -> v.water_technique = i, NatureReleaseProcedures.WaterReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Water Formation Wall", v -> v.waterlearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Water Gun", v -> v.waterlearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Water Shark Bullet Technique", v -> v.waterlearn, 3, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Water Dragon Bullet Technique", v -> v.waterlearn, 4, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40));
		technique("wind_release_technique", v -> v.wind_technique, (v, i) -> v.wind_technique = i, NatureReleaseProcedures.WindReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Boruto Stream", v -> v.windlearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Vacuum Sphere", v -> v.windlearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Wind Mode", v -> v.windlearn, 3, "Ninjutsu", v -> v.ninjutsu, 10, 0, 200, 160, 120, 80, 40),
				jutsu("Rasenshuriken", v -> v.windlearn, 4, "Ninjutsu", v -> v.ninjutsu, 10, 250, 200, 160, 120, 80, 40));
		technique("wood_release_technique", v -> v.woodtechnique, (v, i) -> v.woodtechnique = i, KekkeiGenkaiProcedures.WoodReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Wood Dragon Technique", v -> v.woodlearn, 1, "Ninjutsu", v -> v.ninjutsu, 25, 300, 1000, 800, 600, 400, 150),
				jutsu("Tree Bind Flourishing Burial", v -> v.woodlearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 500, 1000, 800, 600, 400, 150),
				jutsu("Wood Human Technique", v -> v.woodlearn, 3, "Ninjutsu", v -> v.ninjutsu, 35, 650, 1000, 800, 600, 400, 150));

		release("aburame_release", v -> v.aburame_release, ClanProcedures.AburameReleaseRightclickProcedure::executeProcedure, "aburame_release_technique", v -> v.aburamelearn,
				tier(10, 1, "aburame_release_technique"), tier(15, 2, null), tier(20, 3, null));
		release("akimichi_release", v -> v.akimichirelease, ClanProcedures.AkimichiReleaseRightclickProcedure::executeProcedure, "akimichi_release_technique", v -> v.akimichilearn,
				tier(15, 1, "akimichi_release_technique"), tier(20, 2, null), tier(25, 3, null), tier(30, 4, null));
		release("boil_release", v -> v.boilrelease, KekkeiGenkaiProcedures.BoilReleaseRightClickedProcedure::executeProcedure, "boil_release_technique", v -> v.boillearn,
				tier(20, 1, "boil_release_technique"), tier(25, 2, null), tier(30, 3, null));
		release("bone_release", v -> v.bone_release, KekkeiGenkaiProcedures.BoneReleaseRightclickedProcedure::executeProcedure, "bone_release_technique", v -> v.bonelearn,
				tier(15, 1, "bone_release_technique"), tier(20, 2, null), tier(25, 3, null));
		release("dust_release", v -> v.dustrelease, KekkeiGenkaiProcedures.DustReleaseRightClickedProcedure::executeProcedure, "dust_release_technique", v -> v.dustlearn,
				tier(100, 1, "dust_release_technique"));
		release("earth_release", v -> v.earth_release, NatureReleaseProcedures.EarthReleaseRightClickedProcedure::executeProcedure, "earth_release_technique", v -> v.earthlearn,
				tier(5, 1, "earth_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null));
		release("fire_release", v -> v.fire_release, NatureReleaseProcedures.FireReleaseRightclickedProcedure::executeProcedure, "fire_release_technique", v -> v.firelearn,
				tier(5, 1, "fire_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null));
		release("fuma_release", v -> v.fumarelease, ClanProcedures.FumaReleaseRightclickProcedure::executeProcedure, "fuma_release_technique", v -> v.fumalearn,
				tier(10, 1, "fuma_release_technique"), tier(15, 2, null), tier(20, 3, null));
		release("furamingogan_release", v -> v.furamingoganrelease, DojutsuProcedures.FuramingoganReleaseRightclickedProcedure::executeProcedure, "furamingogan_technique", v -> v.furamingoganlearn,
				tier(15, 1, "furamingogan_technique"), tier(20, 2, null), tier(25, 3, null));
		release("hatake_release", v -> v.hatakelearn, ClanProcedures.HatakeReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(5, 0, "white_light_chakra_sabre"));
		release("hoshigaki_release", v -> v.hoshigaki_release, ClanProcedures.HoshigakiReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(5, 0, "hoshigaki_release_technique"));
		release("hozuki_release", v -> v.hozukirelease, ClanProcedures.HozukiReleaseRightclickProcedure::executeProcedure, "hozuki_release_technique", v -> v.hozukilearn,
				tier(10, 1, "hozuki_release_technique"), tier(15, 2, null), tier(20, 3, null));
		release("hyuga_release", v -> v.hyugarelease, ClanProcedures.HyugaReleaseRightclickedProcedure::executeProcedure, "hyuga_release_technique", v -> v.hyugalearn,
				tier(15, 1, "hyuga_release_technique"), tier(20, 2, null), tier(25, 3, null), tier(30, 4, null), tier(35, 5, null));
		release("iburi_release", v -> v.iburi_release, ClanProcedures.IburiReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(5, 0, "smoke_release"));
		release("ice_release", v -> v.ice_release, KekkeiGenkaiProcedures.IceReleaseRightclickedProcedure::executeProcedure, "ice_release_technique", v -> v.icelearn,
				tier(15, 1, "ice_release_technique"), tier(20, 2, null), tier(25, 3, null));
		release("inuzuka_release", v -> v.inuzuka_release, ClanProcedures.InuzukaReleaseRightclickedProcedure::executeProcedure, "inuzuka_release_technique", v -> v.inuzukalearn,
				tier(5, 1, "inuzuka_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null));
		release("isshiki_dojutsu_release", v -> v.isshikidojutsurelease, DojutsuProcedures.IsshikiDojutsuReleaseRightclickedProcedure::executeProcedure, "isshiki_dojutsu_release_technique", v -> v.isshikidojutsulearn,
				tier(25, 1, "isshiki_dojutsu_release_technique"), tier(40, 2, null));
		release("izuno_release", v -> v.izuno_release, ClanProcedures.IzunoReleaseRightclickedProcedure::executeProcedure, "izuno_release_technique", v -> v.izunolearn,
				tier(25, 1, "izuno_release_technique"), tier(30, 2, null));
		release("kaguya_release", v -> v.kaguya_release, ClanProcedures.KaguyaReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(5, 0, "bone_release"));
		release("kazekage_release", v -> v.kazekage_release, ClanProcedures.KazekageReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(5, 0, "magnet_release"));
		release("lee_release", v -> v.lee_release, ClanProcedures.LeeReleaseRightclickedProcedure::executeProcedure, "lee_release_technique", v -> v.leelearn,
				tier(10, 1, "lee_release_drunken_fist"), tier(20, 2, "lee_release_technique"), tier(25, 3, null), tier(30, 4, null), tier(35, 5, null), tier(40, 6, null), tier(45, 7, null), tier(50, 8, null), tier(55, 9, null));
		release("lightning_release", v -> v.lightning_release, NatureReleaseProcedures.LightningReleaseRightClickedProcedure::executeProcedure, "lightning_release_technique", v -> v.lightninglearn,
				tier(5, 1, "lightning_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null));
		release("magnet_release", v -> v.magnet_release, KekkeiGenkaiProcedures.MagnetReleaseRightclickedProcedure::executeProcedure, "magnet_release_technique", v -> v.magnetlearn,
				tier(25, 1, "magnet_release_technique"), tier(30, 2, null), tier(35, 3, null), tier(40, 4, null));
		release("namikaze_release", v -> v.namikaze_release, ClanProcedures.NamikazeReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(5, 0, "storm_release"), tier(10, 0, "flying_thunder_god_kunai"));
		release("otsutsuki_release", v -> v.otsutsuki_release, ClanProcedures.OtsutsukiReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(30, 0, "otsutsuki_sword"));
		release("sarutobi_release", v -> v.sarutobirelease, ClanProcedures.SarutobiReleaseRightclickProcedure::executeProcedure, "sarutobi_release_technique", v -> v.sarutobilearn,
				tier(10, 1, "sarutobi_release_technique"), tier(15, 2, null));
		release("senju_release", v -> v.senju_release, ClanProcedures.SenjuReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(5, 0, "wood_release"));
		release("sharingan_release", v -> v.sharinganrelease, DojutsuProcedures.SharinganReleaseRightclickedProcedure::executeProcedure, "sharingan_release_technique", v -> v.sharinganlearn,
				tier(15, 1, "sharingan_release_technique"), tier(20, 2, null), tier(25, 3, null), tier(30, 4, null));
		release("smoke_release", v -> v.smokerelease, KekkeiGenkaiProcedures.SmokeReleaseRightclickedProcedure::executeProcedure, "smoke_release_technique", v -> v.smokelearn,
				tier(25, 1, "smoke_release_technique"), tier(30, 2, null), tier(35, 3, null));
		release("steel_release", v -> v.steelrelease, KekkeiGenkaiProcedures.SteelReleaseRightClickedProcedure::executeProcedure, "steel_release_technique", v -> v.steellearn,
				tier(25, 1, "steel_release_technique"), tier(30, 2, null));
		release("storm_release", v -> v.storm_release, KekkeiGenkaiProcedures.StormReleaseRightclickedProcedure::executeProcedure, "storm_release_technique", v -> v.stormlearn,
				tier(25, 1, "storm_release_technique"), tier(30, 2, null));
		release("swift_release", v -> v.swiftrelease, KekkeiGenkaiProcedures.SwiftReleaseRightClickedProcedure::executeProcedure, null, v -> v.swiftlearn,
				tier(35, 1, "swift_release_technique"));
		release("tenro_release", v -> v.tenro_release, ClanProcedures.TenroReleaseRightclickedProcedure::executeProcedure, "tenro_release_technique", v -> v.tenrolearn,
				tier(15, 1, "tenro_release_technique"), tier(20, 2, null), tier(25, 3, "tenro_release"));
		release("tsuchigumo_release", v -> v.tsuchigumorelease, ClanProcedures.TsuchigumoReleaseRightclickProcedure::executeProcedure, null, v -> v.tsuchigumolearn,
				tier(20, 1, "tsuchigumo_release_technique"));
		release("typhoon_release", v -> v.typhoonrelease, KekkeiGenkaiProcedures.TyphoonReleaseRightClickedProcedure::executeProcedure, "typhoon_release_technique", v -> v.typhoonlearn,
				tier(25, 1, "typhoon_release_technique"), tier(30, 2, "typhoon_release"));
		release("uzumaki_release", v -> v.uzumakirelease, ClanProcedures.UzumakiReleaseRightclickedProcedure::executeProcedure, "uzumaki_release_technique", v -> v.uzumakilearn,
				tier(15, 1, "uzumaki_release_technique"), tier(20, 2, null), tier(25, 3, null));
		release("voltic_mode_release", v -> v.volticrelease, DojutsuProcedures.VolticModeReleaseRightclickedProcedure::executeProcedure, "voltic_mode_technique", v -> v.volticlearn,
				tier(25, 1, "voltic_mode_technique"), tier(35, 2, null), tier(50, 3, null));
		release("water_release", v -> v.water_release, NatureReleaseProcedures.WaterReleaseRightClickedProcedure::executeProcedure, "water_release_technique", v -> v.waterlearn,
				tier(5, 1, "water_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null));
		release("wind_release", v -> v.wind_release, NatureReleaseProcedures.WindReleaseRightclickedProcedure::executeProcedure, "wind_release_technique", v -> v.windlearn,
				tier(5, 1, "wind_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null));
		release("wood_release", v -> v.wood_release, KekkeiGenkaiProcedures.WoodReleaseRightclickedProcedure::executeProcedure, "wood_release_technique", v -> v.woodlearn,
				tier(20, 1, "wood_release_technique"), tier(25, 2, null), tier(30, 3, null));
		release("yuki_release", v -> v.yuki_release, ClanProcedures.YukiReleaseRightclickedProcedure::executeProcedure, null, null,
				tier(5, 0, "ice_release"));
	}
}
