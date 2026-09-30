package net.mcreator.narutoshippudenmod.core.jutsu;

import net.mcreator.narutoshippudenmod.procedures.ClanProcedures;
import net.mcreator.narutoshippudenmod.procedures.CustomJutsuProcedures;
import net.mcreator.narutoshippudenmod.procedures.DojutsuProcedures;

import java.util.Map;
import java.util.function.Consumer;

import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.jutsu;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.release;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.technique;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.tier;
import static net.mcreator.narutoshippudenmod.core.jutsu.Jutsus.track;

/**
 * Every technique item and release scroll, first read out of the MCreator procedures (porting/jutsu_table.py) and kept by hand
 * since their old procedures were removed. Each jutsu:
 * name, unlock (learn variable and tier), stat requirement, chakra cost, cooldown in ticks for Academy Student, Genin,
 * Chunin, Jonin and Kage. Each release: its bought counter, the procedure that buys the next tier, the technique item
 * and learn variable it unlocks, and per tier the JP price, learn value and item given.
 */
final class JutsuTable {
	/**
	 * The items the new jutsu classes (NatureJutsu, ClanJutsu, KekkeiGenkaiJutsu, DojutsuJutsu) register again with their own
	 * casts: entered here only so release tracks can find their technique while the table is built.
	 */
	private static final Consumer<Map<String, Object>> NEW_ENGINE = deps -> {
	};

	private JutsuTable() {
	}

	static void register() {
		technique("aburame_release_technique", v -> v.aburametechnique, (v, i) -> v.aburametechnique = i, null, NEW_ENGINE,
				jutsu("Poison Cloud Technique", v -> v.aburamelearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40),
				jutsu("Insect Jar Technique", v -> v.aburamelearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 500, 200, 160, 120, 80, 40),
				jutsu("Insect Bog", v -> v.aburamelearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 650, 200, 160, 120, 80, 40));
		technique("akimichi_release_technique", v -> v.akimichitechnique, (v, i) -> v.akimichitechnique = i, null, NEW_ENGINE,
				jutsu("Calorie Control", v -> v.akimichilearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 300, 200, 160, 120, 80, 40),
				jutsu("Human Bullet Tank", v -> v.akimichilearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 0, 750, 500, 300, 200, 100),
				jutsu("Spiked Human Bullet Tank", v -> v.akimichilearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 0, 750, 500, 300, 200, 100),
				jutsu("Butterfly Mode", v -> v.akimichilearn, 4, "Ninjutsu", v -> v.ninjutsu, 35, 0, 750, 500, 300, 200, 100));
		technique("boil_release_technique", v -> v.boiltechnique, (v, i) -> v.boiltechnique = i, null, NEW_ENGINE,
				jutsu("Skilled Mist Technique", v -> v.boillearn, 1, "Ninjutsu", v -> v.ninjutsu, 25, 500, 200, 160, 120, 80, 40),
				jutsu("Steam Dash", v -> v.boillearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 350, 200, 160, 120, 80, 40),
				jutsu("Unrivalled Strength", v -> v.boillearn, 3, "Ninjutsu", v -> v.ninjutsu, 35, 0, 750, 500, 300, 200, 100));
		technique("bone_release_technique", v -> v.bonetechnique, (v, i) -> v.bonetechnique = i, null, NEW_ENGINE,
				jutsu("Dance of the Camellia", v -> v.bonelearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 200, 750, 500, 300, 200, 100),
				jutsu("Dance of the Clematis: Flower", v -> v.bonelearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 350, 750, 500, 300, 200, 100),
				jutsu("Dance of the Larch", v -> v.bonelearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 0, 750, 500, 300, 200, 100));
		technique("dust_release_technique", v -> v.dusttechnique, (v, i) -> v.dusttechnique = i, null, NEW_ENGINE,
				jutsu("Detachment of the Primitive World", v -> v.dustlearn, 1, "Ninjutsu", v -> v.ninjutsu, 70, 5000, 10000, 7500, 5000, 3500, 2500));
		technique("earth_release_technique", v -> v.earth_technique, (v, i) -> v.earth_technique = i, null, NEW_ENGINE,
				jutsu("Fist Rock Technique", v -> v.earthlearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Golem Technique", v -> v.earthlearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Earth-Style Wall", v -> v.earthlearn, 3, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Earth Spear", v -> v.earthlearn, 4, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40));
		technique("fire_release_technique", v -> v.firetechnique, (v, i) -> v.firetechnique = i, null, NEW_ENGINE,
				jutsu("Running Fire", v -> v.firelearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Great Fireball Technique", v -> v.firelearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Great Dragon Fire Technique", v -> v.firelearn, 3, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Phoenix Flower Jutsu", v -> v.firelearn, 4, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40));
		technique("fuma_release_technique", v -> v.fumatechnique, (v, i) -> v.fumatechnique = i, null, NEW_ENGINE,
				jutsu("Shuriken", v -> v.fumalearn, 1, "Ninjutsu", v -> v.ninjutsu, 15, 30, 140, 100, 60, 40, 20),
				jutsu("Fuma Shuriken", v -> v.fumalearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 50, 140, 100, 60, 40, 20),
				jutsu("Toroi Unique Fuma Shuriken", v -> v.fumalearn, 3, "Ninjutsu", v -> v.ninjutsu, 25, 80, 140, 100, 60, 40, 20));
		technique("hozuki_release_technique", v -> v.hozukitechnique, (v, i) -> v.hozukitechnique = i, null, NEW_ENGINE,
				jutsu("Drowning Water Blob Technique", v -> v.hozukilearn, 1, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Water Gun Technique", v -> v.hozukilearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 300, 200, 160, 120, 80, 40),
				jutsu("Great Water Arm Technique", v -> v.hozukilearn, 3, "Ninjutsu", v -> v.ninjutsu, 25, 0, 750, 500, 300, 200, 100));
		technique("hyuga_release_technique", v -> v.hyugatechnique, (v, i) -> v.hyugatechnique = i, null, NEW_ENGINE,
				jutsu("Gentle Fist", v -> v.hyugalearn, 1, null, v -> v.ninjutsu, 0, 0, 200, 160, 120, 80, 40),
				jutsu("Gentle Step Twin Lion Fists", v -> v.hyugalearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40),
				jutsu("Eight Trigrams Twin Lions Crumbling Attack", v -> v.hyugalearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40),
				jutsu("Eight Trigrams Palms Revolving Heaven", v -> v.hyugalearn, 4, "Ninjutsu", v -> v.ninjutsu, 40, 650, 200, 160, 120, 80, 40),
				jutsu("Eight Trigrams Sixty-Four Palms", v -> v.hyugalearn, 5, "Ninjutsu", v -> v.ninjutsu, 45, 900, 200, 160, 120, 80, 40));
		technique("ice_release_technique", v -> v.icetechnique, (v, i) -> v.icetechnique = i, null, NEW_ENGINE,
				jutsu("Certain-Kill Ice Spears", v -> v.icelearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 300, 100, 80, 60, 40, 20),
				jutsu("Demonic Mirroring Ice Crystals", v -> v.icelearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 500, 1000, 800, 600, 400, 150),
				jutsu("Black Dragon Blizzard", v -> v.icelearn, 3, "Ninjutsu", v -> v.ninjutsu, 35, 750, 1000, 800, 600, 400, 150));
		technique("inuzuka_release_technique", v -> v.inuzukatechnique, (v, i) -> v.inuzukatechnique = i, null, NEW_ENGINE,
				jutsu("Akamaru", v -> v.inuzukalearn, 1, "Ninjutsu", v -> v.ninjutsu, 10, 200, 0, 0, 0, 0, 0),
				jutsu("Passing Fang", v -> v.inuzukalearn, 2, "Ninjutsu", v -> v.ninjutsu, 15, 350, 500, 400, 300, 200, 100),
				jutsu("Human Beast Combination Transformation: Double-Headed Wolf", v -> v.inuzukalearn, 3, "Ninjutsu", v -> v.ninjutsu, 20, 500, 0, 0, 0, 0, 0),
				jutsu("Human Beast Mixture Transformation: Three-Headed Wolf", v -> v.inuzukalearn, 4, "Ninjutsu", v -> v.ninjutsu, 25, 750, 0, 0, 0, 0, 0));
		technique("isshiki_dojutsu_release_technique", v -> v.isshikidojutsutechnique, (v, i) -> v.isshikidojutsutechnique = i, null, NEW_ENGINE,
				jutsu("Sukunahikona", v -> v.isshikidojutsulearn, 1, "Ninjutsu", v -> v.ninjutsu, 25, 500, 200, 160, 120, 80, 40),
				jutsu("Disruption Cube", v -> v.isshikidojutsulearn, 2, "Ninjutsu", v -> v.ninjutsu, 35, 1000, 200, 160, 120, 80, 40));
		technique("lee_release_technique", v -> v.lee_technique, (v, i) -> v.lee_technique = i, null, NEW_ENGINE,
				jutsu("Gate of Opening", v -> v.leelearn, 1, null, v -> v.ninjutsu, 0, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Healing", v -> v.leelearn, 2, "Taijutsu", v -> v.taijutsu, 30, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Life", v -> v.leelearn, 3, "Taijutsu", v -> v.taijutsu, 45, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Pain", v -> v.leelearn, 4, "Taijutsu", v -> v.taijutsu, 60, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Limit", v -> v.leelearn, 5, "Taijutsu", v -> v.taijutsu, 75, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of View", v -> v.leelearn, 6, "Taijutsu", v -> v.taijutsu, 90, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Wonder", v -> v.leelearn, 7, "Taijutsu", v -> v.taijutsu, 105, 0, 0, 0, 0, 0, 0),
				jutsu("Gate of Death", v -> v.leelearn, 8, "Taijutsu", v -> v.taijutsu, 105, 0, 0, 0, 0, 0, 0));
		technique("lightning_release_technique", v -> v.lightning_technique, (v, i) -> v.lightning_technique = i, null, NEW_ENGINE,
				jutsu("Lightning Ball Technique", v -> v.lightninglearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Chidori Senbon", v -> v.lightninglearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Lariat", v -> v.lightninglearn, 3, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Kirin", v -> v.lightninglearn, 4, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40));
		technique("magnet_release_technique", v -> v.magnettechnique, (v, i) -> v.magnettechnique = i, null, NEW_ENGINE,
				jutsu("Iron Sand Coat", v -> v.magnetlearn, 1, "Ninjutsu", v -> v.ninjutsu, 25, 0, 200, 160, 120, 80, 40),
				jutsu("Iron Sand Drizzle", v -> v.magnetlearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40),
				jutsu("Black Iron Fists", v -> v.magnetlearn, 3, "Ninjutsu", v -> v.ninjutsu, 35, 0, 200, 160, 120, 80, 40),
				jutsu("Black Iron Wings", v -> v.magnetlearn, 4, "Ninjutsu", v -> v.ninjutsu, 40, 0, 200, 160, 120, 80, 40));
		technique("mangekyou_sharingan_itachi_release_technique", v -> 0, (v, i) -> {}, v -> v.MangekyouSharinganActivate, NEW_ENGINE,
				jutsu("Amaterasu", v -> v.mangekyoushrainganitachiamaterasulearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40));
		technique("mangekyou_sharingan_kakashi_release_technique", v -> 0, (v, i) -> {}, v -> v.MangekyouSharinganActivate, NEW_ENGINE,
				jutsu("Kamui Long-Range", v -> v.mangekyousharingankakashikamuilearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40));
		technique("mangekyou_sharingan_obito_release_technique", v -> v.mangekyousharinganobitokamuitechnique, (v, i) -> v.mangekyousharinganobitokamuitechnique = i, v -> v.MangekyouSharinganActivate, NEW_ENGINE,
				jutsu("Kamui Self-Teleportation", v -> v.mangekyousharinganobitokamuilearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40),
				jutsu("Kamui Short-Range", v -> v.mangekyousharinganobitokamuilearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40),
				jutsu("Kamui Phantom Phasing", v -> v.mangekyousharinganobitokamuilearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40));
		technique("mangekyou_sharingan_sasuke_release_technique", v -> v.mangekyousharingansasukeamaterasutechnique, (v, i) -> v.mangekyousharingansasukeamaterasutechnique = i, v -> v.MangekyouSharinganActivate, NEW_ENGINE,
				jutsu("Amaterasu", v -> v.mangekyousharingansasukeamaterasulearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40),
				jutsu("Blaze Release: Kagutsuchi", v -> v.mangekyousharingansasukeamaterasulearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 0, 200, 160, 120, 80, 40),
				jutsu("Blaze Release: Honoikazuchi", v -> v.mangekyousharingansasukeamaterasulearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40),
				jutsu("Amaterasu: Flame Wrapping Fire", v -> v.mangekyousharingansasukeamaterasulearn, 4, "Ninjutsu", v -> v.ninjutsu, 35, 0, 200, 160, 120, 80, 40));
		technique("sarutobi_release_technique", v -> v.sarutobitechnique, (v, i) -> v.sarutobitechnique = i, null, NEW_ENGINE,
				jutsu("Ash Pile Burning", v -> v.sarutobilearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40),
				jutsu("Fire Dragon Flame Bullet", v -> v.sarutobilearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 350, 200, 160, 120, 80, 40));
		technique("sharingan_release_technique", v -> v.sharingantechnique, (v, i) -> v.sharingantechnique = i, null, NEW_ENGINE,
				jutsu("Coercion Sharingan", v -> v.sharinganlearn, 1, "Ninjutsu", v -> v.ninjutsu, 10, 200, 200, 160, 120, 80, 40),
				jutsu("Demonic Illusion: Mirage Crow", v -> v.sharinganlearn, 2, "Ninjutsu", v -> v.ninjutsu, 20, 350, 200, 160, 120, 80, 40),
				jutsu("Demonic Illusion: Shackling Stakes Technique", v -> v.sharinganlearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40));
		technique("smoke_release_technique", v -> v.smoketechnique, (v, i) -> v.smoketechnique = i, null, NEW_ENGINE,
				jutsu("Smoke Form", v -> v.smokelearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 0, 750, 500, 300, 200, 100),
				jutsu("Smoke Fist", v -> v.smokelearn, 2, null, v -> v.ninjutsu, 0, 0, 200, 160, 120, 80, 40),
				jutsu("Smoke Gun", v -> v.smokelearn, 3, "Ninjutsu", v -> v.ninjutsu, 50, 1000, 200, 160, 120, 80, 40));
		technique("steel_release_technique", v -> v.steeltechnique, (v, i) -> v.steeltechnique = i, null, NEW_ENGINE,
				jutsu("Impervious Armour", v -> v.steellearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 0, 750, 500, 300, 200, 100),
				jutsu("Steel Projectile", v -> v.steellearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 450, 200, 160, 120, 80, 40));
		technique("storm_release_technique", v -> v.stormtechnique, (v, i) -> v.stormtechnique = i, null, NEW_ENGINE,
				jutsu("Laser Circus", v -> v.stormlearn, 1, null, v -> v.ninjutsu, 0, 0, 0, 0, 0, 0, 0),
				jutsu("Thunder Cloud Inner Wave", v -> v.stormlearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 500, 1000, 800, 600, 400, 150));
		technique("swift_release_technique", v -> 0, (v, i) -> {}, null, NEW_ENGINE,
				jutsu("Shadowless Flight", v -> v.swiftlearn, 1, "Ninjutsu", v -> v.ninjutsu, 30, 0, 200, 160, 120, 80, 40));
		technique("typhoon_release_technique", v -> v.typhoontechnique, (v, i) -> v.typhoontechnique = i, null, NEW_ENGINE,
				jutsu("Great Consecutive Bursting Strong Winds", v -> v.typhoonlearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 300, 200, 160, 120, 80, 40),
				jutsu("Great Consecutive Bursting Extreme Winds", v -> v.typhoonlearn, 2, "Ninjutsu", v -> v.ninjutsu, 25, 450, 200, 160, 120, 80, 40));
		technique("uzumaki_release_technique", v -> v.uzumakitechnique, (v, i) -> v.uzumakitechnique = i, null, NEW_ENGINE,
				jutsu("Adamantine Sealing Chains", v -> v.uzumakilearn, 1, null, v -> v.ninjutsu, 0, 0, 200, 160, 120, 80, 40),
				jutsu("Heal Bite", v -> v.uzumakilearn, 2, null, v -> v.ninjutsu, 0, 0, 200, 160, 120, 80, 40),
				jutsu("Dead Demon Consuming Seal", v -> v.uzumakilearn, 3, "Ninjutsu", v -> v.ninjutsu, 30, 500, 200, 160, 120, 80, 40));
		technique("water_release_technique", v -> v.water_technique, (v, i) -> v.water_technique = i, null, NEW_ENGINE,
				jutsu("Water Formation Wall", v -> v.waterlearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Water Gun", v -> v.waterlearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Water Shark Bullet Technique", v -> v.waterlearn, 3, "Ninjutsu", v -> v.ninjutsu, 15, 200, 200, 160, 120, 80, 40),
				jutsu("Water Dragon Bullet Technique", v -> v.waterlearn, 4, "Ninjutsu", v -> v.ninjutsu, 20, 250, 200, 160, 120, 80, 40));
		technique("wind_release_technique", v -> v.wind_technique, (v, i) -> v.wind_technique = i, null, NEW_ENGINE,
				jutsu("Boruto Stream", v -> v.windlearn, 1, "Ninjutsu", v -> v.ninjutsu, 5, 100, 200, 160, 120, 80, 40),
				jutsu("Vacuum Sphere", v -> v.windlearn, 2, "Ninjutsu", v -> v.ninjutsu, 10, 150, 200, 160, 120, 80, 40),
				jutsu("Wind Mode", v -> v.windlearn, 3, "Ninjutsu", v -> v.ninjutsu, 10, 0, 200, 160, 120, 80, 40),
				jutsu("Rasenshuriken", v -> v.windlearn, 4, "Ninjutsu", v -> v.ninjutsu, 10, 250, 200, 160, 120, 80, 40));
		technique("wood_release_technique", v -> v.woodtechnique, (v, i) -> v.woodtechnique = i, null, NEW_ENGINE,
				jutsu("Wood Dragon Technique", v -> v.woodlearn, 1, "Ninjutsu", v -> v.ninjutsu, 25, 300, 1000, 800, 600, 400, 150),
				jutsu("Tree Bind Flourishing Burial", v -> v.woodlearn, 2, "Ninjutsu", v -> v.ninjutsu, 30, 500, 1000, 800, 600, 400, 150),
				jutsu("Wood Human Technique", v -> v.woodlearn, 3, "Ninjutsu", v -> v.ninjutsu, 35, 650, 1000, 800, 600, 400, 150));
		technique("shadow_clone_technique", v -> 0, (v, i) -> {}, null, ClanProcedures.ShadowCloneTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Shadow Clone Technique", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 30, 25, 25, 25, 25, 25));
		technique("tsuchigumo_release_technique", v -> 0, (v, i) -> {}, null, NEW_ENGINE,
				jutsu("Fury", v -> v.tsuchigumolearn, 1, "Ninjutsu", v -> v.ninjutsu, 20, 300, 200, 160, 120, 80, 40));
		technique("custom_fire_release_technique", v -> 0, (v, i) -> {}, null, CustomJutsuProcedures.CustomFireReleaseTechniqueRightclickedProcedure::executeProcedure,
				jutsu("Custom Jutsu", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 0, 60, 50, 40, 30, 20));
		technique("custom_earth_release_technique", v -> 0, (v, i) -> {}, null, CustomJutsuProcedures.CustomEarthReleaseTechniqueRightClickedProcedure::executeProcedure,
				jutsu("Custom Jutsu", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 0, 60, 50, 40, 30, 20));
		technique("custom_water_release_technique", v -> 0, (v, i) -> {}, null, CustomJutsuProcedures.CustomWaterReleaseTechniqueRightClickedProcedure::executeProcedure,
				jutsu("Custom Jutsu", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 0, 60, 50, 40, 30, 20));
		technique("custom_wind_release_technique", v -> 0, (v, i) -> {}, null, CustomJutsuProcedures.CustomWindReleaseTechniqueRightClickedProcedure::executeProcedure,
				jutsu("Custom Jutsu", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 0, 60, 50, 40, 30, 20));
		technique("custom_lightning_release_technique", v -> 0, (v, i) -> {}, null, CustomJutsuProcedures.CustomLightningReleaseTechniqueRightClickedProcedure::executeProcedure,
				jutsu("Custom Jutsu", v -> 1, 1, "Ninjutsu", v -> v.ninjutsu, 5, 0, 60, 50, 40, 30, 20));

		release("aburame_release", NEW_ENGINE,
				track("", v -> v.aburame_release, -1, "aburame_release_technique", v -> v.aburamelearn,
					tier(10, 1, "aburame_release_technique"), tier(15, 2, null), tier(20, 3, null)));
		release("akimichi_release", NEW_ENGINE,
				track("", v -> v.akimichirelease, -1, "akimichi_release_technique", v -> v.akimichilearn,
					tier(15, 1, "akimichi_release_technique"), tier(20, 2, null), tier(25, 3, null), tier(30, 4, null)));
		release("boil_release", NEW_ENGINE,
				track("", v -> v.boilrelease, -1, "boil_release_technique", v -> v.boillearn,
					tier(20, 1, "boil_release_technique"), tier(25, 2, null), tier(30, 3, null)));
		release("bone_release", NEW_ENGINE,
				track("", v -> v.bone_release, -1, "bone_release_technique", v -> v.bonelearn,
					tier(15, 1, "bone_release_technique"), tier(20, 2, null), tier(25, 3, null)));
		release("dust_release", NEW_ENGINE,
				track("", v -> v.dustrelease, -1, "dust_release_technique", v -> v.dustlearn,
					tier(100, 1, "dust_release_technique")));
		release("earth_release", NEW_ENGINE,
				track("", v -> v.earth_release, -1, "earth_release_technique", v -> v.earthlearn,
					tier(5, 1, "earth_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null)));
		release("fire_release", NEW_ENGINE,
				track("", v -> v.fire_release, -1, "fire_release_technique", v -> v.firelearn,
					tier(5, 1, "fire_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null)));
		release("fuma_release", NEW_ENGINE,
				track("", v -> v.fumarelease, -1, "fuma_release_technique", v -> v.fumalearn,
					tier(10, 1, "fuma_release_technique"), tier(15, 2, null), tier(20, 3, null)));
		release("hozuki_release", NEW_ENGINE,
				track("", v -> v.hozukirelease, -1, "hozuki_release_technique", v -> v.hozukilearn,
					tier(10, 1, "hozuki_release_technique"), tier(15, 2, null), tier(20, 3, null)));
		release("hyuga_release", NEW_ENGINE,
				track("", v -> v.hyugarelease, -1, "hyuga_release_technique", v -> v.hyugalearn,
					tier(15, 1, "hyuga_release_technique"), tier(20, 2, null), tier(25, 3, null), tier(30, 4, null), tier(35, 5, null)));
		release("ice_release", NEW_ENGINE,
				track("", v -> v.ice_release, -1, "ice_release_technique", v -> v.icelearn,
					tier(15, 1, "ice_release_technique"), tier(20, 2, null), tier(25, 3, null)));
		release("inuzuka_release", NEW_ENGINE,
				track("", v -> v.inuzuka_release, -1, "inuzuka_release_technique", v -> v.inuzukalearn,
					tier(5, 1, "inuzuka_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null)));
		release("isshiki_dojutsu_release", NEW_ENGINE,
				track("", v -> v.isshikidojutsurelease, -1, "isshiki_dojutsu_release_technique", v -> v.isshikidojutsulearn,
					tier(25, 1, "isshiki_dojutsu_release_technique"), tier(40, 2, null)));
		release("lee_release", NEW_ENGINE,
				track("", v -> v.lee_release, -1, "lee_release_technique", v -> v.leelearn,
					tier(10, 1, null), tier(20, 2, "lee_release_technique"), tier(25, 3, null), tier(30, 4, null), tier(35, 5, null), tier(40, 6, null), tier(45, 7, null), tier(50, 8, null), tier(55, 9, null)));
		release("lightning_release", NEW_ENGINE,
				track("", v -> v.lightning_release, -1, "lightning_release_technique", v -> v.lightninglearn,
					tier(5, 1, "lightning_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null)));
		release("magnet_release", NEW_ENGINE,
				track("", v -> v.magnet_release, -1, "magnet_release_technique", v -> v.magnetlearn,
					tier(25, 1, "magnet_release_technique"), tier(30, 2, null), tier(35, 3, null), tier(40, 4, null)));
		release("mangekyou_sharingan_itachi_release", DojutsuProcedures.MangekyouSharinganItachiReleaseRightclickedProcedure::executeProcedure,
				track("", v -> v.mangekyoushrainganitachiamaterasulearn, 0, "mangekyou_sharingan_itachi_release_technique", v -> v.mangekyoushrainganitachiamaterasulearn,
					tier(10, 1, "mangekyou_sharingan_itachi_release_technique")),
				track("Susanoo", v -> v.mangekyoushrainganitachisusanorelease, 1, null, v -> v.mangekyoushrainganitachisusanolearn,
					tier(10, 1, null), tier(20, 2, null), tier(30, 3, null)));
		release("mangekyou_sharingan_kakashi_release", DojutsuProcedures.MangekyouSharinganKakashiReleaseRightclickedProcedure::executeProcedure,
				track("", v -> v.mangekyousharingankakashikamuilearn, -1, "mangekyou_sharingan_kakashi_release_technique", v -> v.mangekyousharingankakashikamuilearn,
					tier(35, 1, "mangekyou_sharingan_kakashi_release_technique")));
		release("mangekyou_sharingan_madara_release", DojutsuProcedures.MangekyouSharinganMadaraReleaseRightclickedProcedure::executeProcedure,
				track("Susanoo", v -> v.mangekyousharinganmadarasusanorelease, -1, null, v -> v.mangekyousharinganmadarasusanolearn,
					tier(10, 1, null), tier(20, 2, null), tier(30, 3, null), tier(40, 4, null)));
		release("mangekyou_sharingan_obito_release", DojutsuProcedures.MangekyouSharinganObitoReleaseRightclickedProcedure::executeProcedure,
				track("", v -> v.mangekyousharinganobitokamuirelease, 0, "mangekyou_sharingan_obito_release_technique", v -> v.mangekyousharinganobitokamuilearn,
					tier(20, 1, "mangekyou_sharingan_obito_release_technique"), tier(30, 2, null), tier(35, 3, null)),
				track("Susanoo", v -> v.mangekyousharinganobitosusanorelease, 1, null, v -> v.mangekyousharinganobitosusanolearn,
					tier(10, 1, null), tier(20, 2, null), tier(30, 3, null)));
		release("mangekyou_sharingan_sasuke_release", DojutsuProcedures.MangekyouSharinganSasukeReleaseRightclickedProcedure::executeProcedure,
				track("", v -> v.mangekyousharingansasukeamaterasurelease, 0, "mangekyou_sharingan_sasuke_release_technique", v -> v.mangekyousharingansasukeamaterasulearn,
					tier(10, 1, "mangekyou_sharingan_sasuke_release_technique"), tier(15, 2, null), tier(20, 3, null), tier(25, 4, null)),
				track("Susanoo", v -> v.mangekyousharingansasukesusanorelease, 1, null, v -> v.mangekyousharingansasukesusanolearn,
					tier(10, 1, null), tier(20, 2, null), tier(30, 3, null), tier(40, 4, null)));
		release("mangekyou_sharingan_shisui_release", DojutsuProcedures.MangekyouSharinganShisuiReleaseRightclickedProcedure::executeProcedure,
				track("Susanoo", v -> v.mangekyousharinganshisuisusanorelease, -1, null, v -> v.mangekyousharinganshisuisusanolearn,
					tier(10, 1, null), tier(20, 2, null), tier(30, 3, null), tier(40, 4, null)));
		release("sarutobi_release", NEW_ENGINE,
				track("", v -> v.sarutobirelease, -1, "sarutobi_release_technique", v -> v.sarutobilearn,
					tier(10, 1, "sarutobi_release_technique"), tier(15, 2, null)));
		release("sharingan_release", NEW_ENGINE,
				track("", v -> v.sharinganrelease, -1, "sharingan_release_technique", v -> v.sharinganlearn,
					tier(15, 1, "sharingan_release_technique"), tier(20, 2, null), tier(25, 3, null), tier(30, 4, null)));
		release("smoke_release", NEW_ENGINE,
				track("", v -> v.smokerelease, -1, "smoke_release_technique", v -> v.smokelearn,
					tier(25, 1, "smoke_release_technique"), tier(30, 2, null), tier(35, 3, null)));
		release("steel_release", NEW_ENGINE,
				track("", v -> v.steelrelease, -1, "steel_release_technique", v -> v.steellearn,
					tier(25, 1, "steel_release_technique"), tier(30, 2, null)));
		release("storm_release", NEW_ENGINE,
				track("", v -> v.storm_release, -1, "storm_release_technique", v -> v.stormlearn,
					tier(25, 1, "storm_release_technique"), tier(30, 2, null)));
		release("swift_release", NEW_ENGINE,
				track("", v -> v.swiftrelease, -1, "swift_release_technique", v -> v.swiftlearn,
					tier(35, 1, "swift_release_technique")));
		release("tsuchigumo_release", NEW_ENGINE,
				track("", v -> v.tsuchigumorelease, -1, null, v -> v.tsuchigumolearn,
					tier(20, 1, "tsuchigumo_release_technique")));
		release("typhoon_release", NEW_ENGINE,
				track("", v -> v.typhoonrelease, -1, "typhoon_release_technique", v -> v.typhoonlearn,
					tier(25, 1, "typhoon_release_technique"), tier(30, 2, "typhoon_release")));
		release("uzumaki_release", NEW_ENGINE,
				track("", v -> v.uzumakirelease, -1, "uzumaki_release_technique", v -> v.uzumakilearn,
					tier(15, 1, "uzumaki_release_technique"), tier(20, 2, null), tier(25, 3, null)));
		release("water_release", NEW_ENGINE,
				track("", v -> v.water_release, -1, "water_release_technique", v -> v.waterlearn,
					tier(5, 1, "water_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null)));
		release("wind_release", NEW_ENGINE,
				track("", v -> v.wind_release, -1, "wind_release_technique", v -> v.windlearn,
					tier(5, 1, "wind_release_technique"), tier(10, 2, null), tier(15, 3, null), tier(20, 4, null)));
		release("wood_release", NEW_ENGINE,
				track("", v -> v.wood_release, -1, "wood_release_technique", v -> v.woodlearn,
					tier(20, 1, "wood_release_technique"), tier(25, 2, null), tier(30, 3, null)));
	}
}
