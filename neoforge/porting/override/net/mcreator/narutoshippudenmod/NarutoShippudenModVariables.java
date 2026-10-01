package net.mcreator.narutoshippudenmod;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.attachment.IAttachmentSerializer;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

/** Per-player data (was a Forge capability, now a NeoForge data attachment that is kept on death). */
public class NarutoShippudenModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES,
			NarutoShippudenMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENTS.register("player_variables",
			() -> AttachmentType.builder(PlayerVariables::new).serialize(new IAttachmentSerializer<PlayerVariables>() {
				@Override
				public PlayerVariables read(IAttachmentHolder holder, ValueInput input) {
					PlayerVariables variables = new PlayerVariables();
					variables.read(input);
					return variables;
				}

				@Override
				public boolean write(PlayerVariables attachment, ValueOutput output) {
					attachment.write(output);
					return true;
				}
			}).copyOnDeath().build());

	/** Read-only fallback for entities that are not players. Never write to it. */
	private static final PlayerVariables DEFAULTS = new PlayerVariables();

	public static void register(IEventBus modBus) {
		ATTACHMENTS.register(modBus);
		modBus.addListener(NarutoShippudenModVariables::registerPayloads);
	}

	/** Player variables of the entity, or shared defaults when it is not a player. Only read from the result. */
	public static PlayerVariables get(Entity entity) {
		return entity instanceof Player ? entity.getData(PLAYER_VARIABLES) : DEFAULTS;
	}

	/** Runs the change on the entity's variables if it is a player (was capability.ifPresent). */
	public static void ifPresent(Entity entity, Consumer<PlayerVariables> change) {
		if (entity instanceof Player)
			change.accept(entity.getData(PLAYER_VARIABLES));
	}

	public static class PlayerVariables {
		public double A_Mission = 0;
		public boolean aburamereleaselogic = false;
		public boolean akimichireleaselogic = false;
		public boolean asumaquest = false;
		public double B_Mission = 0;
		public boolean byakugan = false;
		public boolean byakuganactivate = false;
		public double C_Mission = 0;
		public double ChakraAmount = 0;
		public double ChakraMax = 0.0;
		public boolean chinoikereleaselogic = false;
		public double D_Mission = 0;
		public boolean deathgod = false;
		public String DojutsuSelectResize = "Sharingan";
		public double earth_release = 0;
		public double earth_technique = 0;
		public double earthlearn = 0;
		public boolean earthreleaselogic = false;
		public double Eyes_Height = 1.0;
		public double fire_release = 0;
		public double firelearn = 0;
		public boolean firereleaselogic = false;
		public double firetechnique = 0;
		public boolean fumareleaselogic = false;
		public double genjutsu = 0;
		public boolean hatakereleaselogic = false;
		public double Health = 0;
		public double HealthMax = 0;
		public boolean hoshigakireleaselogic = false;
		public boolean hozukireleaselogic = false;
		public double hyugalearn = 0.0;
		public double hyugarelease = 0;
		public boolean hyugareleaselogic = false;
		public double hyugatechnique = 0;
		public boolean yamanakareleaselogic = false;
		public boolean inuzukareleaselogic = false;
		public double IQ = 0;
		public boolean izanagi = false;
		public boolean izanagiuse = false;
		public boolean izunoreleaselogic = false;
		public boolean joinworld = false;
		public double jp = 0;
		public double jutsupowerstat = 0;
		public boolean kaguyareleaselogic = false;
		public boolean kazekagereleaselogic = false;
		public double kenjutsu = 0;
		public boolean ketsuryugan = false;
		public boolean ketsuryuganactivate = false;
		public double kinjutsu = 0;
		public boolean kuramareleaselogic = false;
		public boolean leereleaselogic = false;
		public double LEVEL = 0.0;
		public double LEVELMAX = 1.0;
		public double LEVELMAXMINIGAME = 5.0;
		public double LEVELMINIGAME = 0;
		public double LEVELSTAT = 0.0;
		public double LEVELSTATMINIGAME = 0;
		public double lightning_release = 0;
		public double lightning_technique = 0.0;
		public double lightninglearn = 0;
		public boolean lightningreleaselogic = false;
		public boolean Mangekyou_Sharingan = false;
		public double maxhealth = 20.0;
		public double maxspeed = 0.1;
		public double medicine = 0;
		public double Mini_Game_Timer_Button = 0;
		public boolean namikazereleaselogic = false;
		public boolean narareleaselogic = false;
		public double NarutoTimerAwakening = 0;
		public double ninjutsu = 0;
		public boolean otsutsukireleaselogic = false;
		public double Pupils_Height = 1.0;
		public String rank = "Academy Student";
		public double S_Mission = 0;
		public boolean sarutobireleaselogic = false;
		public double selectclanrelease = 0;
		public double selectnaturerelease = 0;
		public double selectvillage = 0;
		public boolean senjureleaselogic = false;
		public double senjutsu = 0;
		public double SenjutsuChakraMax = 0;
		public boolean sharingan = false;
		public boolean sharinganactivate = false;
		public double sharinganlearn = 0.0;
		public double sharinganrelease = 0;
		public double sharingantechnique = 0.0;
		public boolean shikamaruquest = false;
		public boolean shimurareleaselogic = false;
		public double Shinobi_Murder_Count = 0;
		public double shurikenjutsu = 0;
		public double smokelearn = 0.0;
		public boolean smokereleaselogic = false;
		public double smoketechnique = 0;
		public double sp = 0;
		public double speed = 0;
		public double spusecount = 1.0;
		public double SS_Mission = 0;
		public double storymode = 0;
		public double summoning = 0;
		public double taijutsu = 0;
		public boolean tenroreleaselogic = false;
		public boolean tsuchigumoreleaselogic = false;
		public boolean uchihareleaselogic = false;
		public boolean uzumakichains = false;
		public double uzumakilearn = 0.0;
		public double uzumakirelease = 0;
		public boolean uzumakireleaselogic = false;
		public double uzumakitechnique = 0.0;
		public String village = "";
		public double water_release = 0;
		public double water_technique = 0;
		public double waterlearn = 0;
		public boolean waterreleaselogic = false;
		public double wind_release = 0;
		public double wind_technique = 0;
		public double windlearn = 0;
		public boolean windreleaselogic = false;
		public boolean yukireleaselogic = false;
		public double smokerelease = 0;
		public boolean Chakra_Control = false;
		public String player_name = "\"\"";
		public String customjutsutype1save = "\"\"";
		public String customjutsuspeed1save = "\"\"";
		public String customjutsurelease1save = "\"\"";
		public double customjutsuchakra1save = 0;
		public String jutsunamesave1 = "\"\"";
		public boolean customjutsu1learn = false;
		public boolean isshikidojutsu = false;
		public boolean isshikidojutsuactivate = false;
		public double isshikidojutsutechnique = 0.0;
		public double isshikidojutsulearn = 0.0;
		public double isshikidojutsurelease = 0;
		public double inuzukatechnique = 0;
		public double inuzukalearn = 0.0;
		public boolean mangekyouletter = false;
		public double magnettechnique = 0;
		public boolean magnetreleaselogic = false;
		public double magnetlearn = 0;
		public boolean Login_Dojutsu = false;
		public String DojutsuSelect2 = "Default";
		public String DojutsuSelect3 = " ";
		public boolean MangekyouSharinganSasuke = false;
		public boolean MangekyouSharinganItachi = false;
		public boolean MangekyouSharinganMadara = false;
		public boolean MangekyouSharinganObito = false;
		public boolean MangekyouSharinganShisui = false;
		public boolean MangekyouSharinganActivate = false;
		public boolean MangekyouSharinganKakashi = false;
		public boolean SharinganKakashi = false;
		public double magnet_release = 0;
		public double lee_technique = 0;
		public double leelearn = 0;
		public boolean deathgodcooldown = false;
		public double inuzuka_release = 0;
		public boolean akamaru_summon = false;
		public double lee_release = 0;
		public double gateslee = 0;
		public boolean Gate8 = false;
		public double flyingthundergodkunaiteleportselect = 0;
		public String dojutsubyakugan = "\"\"";
		public String dojutsusharingan = "\"\"";
		public String dojutsuketsuryugan = "\"\"";
		public String dojutsums = "\"\"";
		public String dojutsuisshiki = "\"\"";
		public boolean PassingFang = false;
		public double stormtechnique = 0;
		public boolean stormreleaselogic = false;
		public double stormlearn = 0;
		public double storm_release = 0;
		public boolean stormlaser = false;
		public double otsutsuki_tool = 0;
		public String dojutsurinnegan = "\"\"";
		public String dojutsutenseigan = "\"\"";
		public boolean tenseigan = false;
		public boolean tenseiganactivate = false;
		public boolean rinnegan = false;
		public boolean rinneganactivate = false;
		public double otsutsuki_path = 0;
		public boolean woodreleaselogic = false;
		public double woodtechnique = 0;
		public double woodlearn = 0;
		public double wood_release = 0;
		public boolean otsutsuki_mangekyou = false;
		public boolean icereleaselogic = false;
		public double icetechnique = 0;
		public double icelearn = 0;
		public double ice_release = 0;
		public boolean ice_mirror = false;
		public boolean tenromode = false;
		public boolean izunochakramode = false;
		public boolean izunocat = false;
		public double calendar_calculator = 0;
		public boolean shimura_active = false;
		public boolean SharinganShimura = false;
		public double aburametechnique = 0;
		public double aburamelearn = 0;
		public double aburame_release = 0;
		public double sarutobitechnique = 0;
		public double sarutobilearn = 0;
		public double sarutobirelease = 0;
		public double naratechnique = 0;
		public double naralearn = 0;
		public double nararelease = 0;
		public boolean restrained = false;
		public double possessing = 0;
		public double mangekyousharinganitachitechnique = 0;
		public double mangekyousharingankakashitechnique = 0;
		public double yamanakatechnique = 0;
		public double yamanakalearn = 0;
		public double yamanakarelease = 0;
		public double byakugantechnique = 0;
		public double byakuganlearn = 0;
		public double byakuganrelease = 0;
		public double ketsuryugantechnique = 0;
		public double ketsuryuganlearn = 0;
		public double ketsuryuganrelease = 0;
		public double rinnegantechnique = 0;
		public double rinneganlearn = 0;
		public double rinneganrelease = 0;
		public double tenseigantechnique = 0;
		public double tenseiganlearn = 0;
		public double tenseiganrelease = 0;
		public double uchihatechnique = 0;
		public double uchihalearn = 0;
		public double uchiharelease = 0;
		public double mangekyousharinganshisuitechnique = 0;
		public double mangekyousharinganshisuilearn = 0;
		public double mangekyousharinganmadaratechnique = 0;
		public double mangekyousharinganmadaralearn = 0;
		public double hozukitechnique = 0;
		public double hozukilearn = 0;
		public double hozukirelease = 0;
		public double tsuchigumotechnique = 0;
		public double tsuchigumolearn = 0;
		public double tsuchigumorelease = 0;
		public boolean waterblob = false;
		public boolean Great_Water_Arm = false;
		public boolean bonereleaselogic = false;
		public double bonetechnique = 0;
		public double bonelearn = 0;
		public double bone_release = 0;
		public boolean DanceOfTheLarch = false;
		public double fumatechnique = 0;
		public double fumalearn = 0;
		public double fumarelease = 0;
		public double magnet_coat = 0;
		public double Shadow1X = 0;
		public double Shadow2X = 0;
		public double Shadow1Z = 0;
		public double Shadow2Z = 0;
		public boolean NaraClanShadow = false;
		public double OriginalZ1 = 0;
		public double OriginalX1 = 0;
		public boolean EightTrigramsPalmsRevolvingHeaven = false;
		public boolean InsectJarTechnique = false;
		public double ShadowX1 = 0;
		public double ShadowX2 = 0;
		public double ShadowZ1 = 0;
		public double ShadowZ2 = 0;
		public double akimichitechnique = 0;
		public double akimichilearn = 0;
		public double akimichirelease = 0;
		public boolean HumanBulletTank = false;
		public boolean ButterflyMode = false;
		public boolean SpikedHumanBulletTank = false;
		public double zombiekillcount = 0;
		public double pillagerkillcount = 0;
		public double typhoontechnique = 0;
		public double typhoonlearn = 0;
		public double typhoonrelease = 0;
		public boolean typhoonreleaslogic = false;
		public double swiftlearn = 0;
		public double swiftrelease = 0;
		public boolean swiftreleaselogic = false;
		public double steeltechnique = 0;
		public double steellearn = 0;
		public double steelrelease = 0;
		public boolean steelreleaselogic = false;
		public double dusttechnique = 0;
		public double dustlearn = 0;
		public double dustrelease = 0;
		public boolean dustreleaselogic = false;
		public double boiltechnique = 0;
		public double boillearn = 0;
		public double boilrelease = 0;
		public boolean boilreleaselogic = false;
		public boolean swiftmode = false;
		public boolean ImperviousArmor = false;
		public boolean WindMode = false;
		public boolean SmokeForm = false;
		public String ButterFlyModeColor = "\"\"";
		public double HPBarfill = 0;
		public double ChakraBarfill = 0;
		public boolean DashCooldown = false;
		public double DashCooldownTicks = 0;
		public double WPressed = 0;
		public double APressed = 0;
		public double DPressed = 0;
		public double SPressed = 0;
		public double SpacePressed = 0;
		public boolean UpDashCooldown = false;
		public double UpDashCooldownTicks = 0;
		public boolean Dash = false;
		public double DashReset = 0;
		public boolean WHold = false;
		public boolean WaterWalk = false;
		public boolean WallClimb = false;
		public double StorymodeCooldown = 0;
		public String directionstorymode = "\"\"";
		public double TrainingDummyHits = 0;
		public String StoryModeGeninFight = " ";
		public double HeadbandSelect = 0;
		public boolean Kagutsuchi = false;
		public boolean AmaterasuSusano = false;
		public double MangekyouSharinganRelease = 0;
		public double mangekyousharingansasukeamaterasurelease = 0;
		public double mangekyousharingansasukeamaterasulearn = 0;
		public double mangekyousharingansasukeamaterasutechnique = 0;
		public double mangekyousharingansasukesusanorelease = 0;
		public double mangekyousharingansasukesusanolearn = 0;
		public double mangekyousharingansusanostage = 0;
		public double mangekyoushrainganitachiamaterasulearn = 0;
		public double mangekyoushrainganitachisusanorelease = 0;
		public double mangekyoushrainganitachisusanolearn = 0;
		public double mangekyousharingankakashikamuilearn = 0;
		public double mangekyousharinganobitokamuirelease = 0;
		public double mangekyousharinganobitokamuilearn = 0;
		public double mangekyousharinganobitokamuitechnique = 0;
		public double mangekyousharinganobitosusanorelease = 0;
		public double mangekyousharinganobitosusanolearn = 0;
		public boolean KamuiPhantomPhase = false;
		public boolean Eternal_Mangekyou_Sharingan = false;
		public double Mangekyou_Sharingan_Technique_Use = 0;
		public double Mangekyou_Sharingan_Technique_Use_Max = 0;
		public double mangekyousharinganmadarasusanorelease = 0;
		public double mangekyousharinganmadarasusanolearn = 0;
		public double mangekyousharinganshisuisusanorelease = 0;
		public double mangekyousharinganshisuisusanolearn = 0;
		public ItemStack gunbaicopy = ItemStack.EMPTY;
		public double LevelStatMaxChange = 100.0;
		public double inuzuka_mode = 0;
		/** Custom jutsu made in the Jutsu Creation screen, one per line (see core/jutsu/CustomJutsu). */
		public String custom_jutsu = "";
		/** The art selected on each weapon: "item=index" pairs separated by commas (see core/jutsu/Weapons). */
		public String weapon_arts = "";
		/** The release jutsu this player has learned, by id ("fire_release_technique/great_fireball_technique"), comma separated (see core/jutsu/Jutsus). */
		public String learned_jutsu = "";
		/** Whether the old learned counts (firelearn, …) were turned into learned_jutsu. */
		public boolean learned_jutsu_migrated = false;
		/** Restrained by a shadow that copies its caster (Shadow Imitation): crouch with them. */
		public boolean mimic_sneak = false;
		/** learned_jutsu parsed (not saved; see Jutsus.learnedSet). */
		public java.util.Set<String> learnedParsed = java.util.Set.of();
		public String learnedParsedFrom = "";

		public void write(ValueOutput out) {
			out.putDouble("A_Mission", A_Mission);
			out.putBoolean("aburamereleaselogic", aburamereleaselogic);
			out.putBoolean("akimichireleaselogic", akimichireleaselogic);
			out.putBoolean("asumaquest", asumaquest);
			out.putDouble("B_Mission", B_Mission);
			out.putBoolean("byakugan", byakugan);
			out.putBoolean("byakuganactivate", byakuganactivate);
			out.putDouble("C_Mission", C_Mission);
			out.putDouble("ChakraAmount", ChakraAmount);
			out.putDouble("ChakraMax", ChakraMax);
			out.putBoolean("chinoikereleaselogic", chinoikereleaselogic);
			out.putDouble("D_Mission", D_Mission);
			out.putBoolean("deathgod", deathgod);
			out.putString("DojutsuSelectResize", DojutsuSelectResize);
			out.putDouble("earth_release", earth_release);
			out.putDouble("earth_technique", earth_technique);
			out.putDouble("earthlearn", earthlearn);
			out.putBoolean("earthreleaselogic", earthreleaselogic);
			out.putDouble("Eyes_Height", Eyes_Height);
			out.putDouble("fire_release", fire_release);
			out.putDouble("firelearn", firelearn);
			out.putBoolean("firereleaselogic", firereleaselogic);
			out.putDouble("firetechnique", firetechnique);
			out.putBoolean("fumareleaselogic", fumareleaselogic);
			out.putDouble("genjutsu", genjutsu);
			out.putBoolean("hatakereleaselogic", hatakereleaselogic);
			out.putDouble("Health", Health);
			out.putDouble("HealthMax", HealthMax);
			out.putBoolean("hoshigakireleaselogic", hoshigakireleaselogic);
			out.putBoolean("hozukireleaselogic", hozukireleaselogic);
			out.putDouble("hyugalearn", hyugalearn);
			out.putDouble("hyugarelease", hyugarelease);
			out.putBoolean("hyugareleaselogic", hyugareleaselogic);
			out.putDouble("hyugatechnique", hyugatechnique);
			out.putBoolean("yamanakareleaselogic", yamanakareleaselogic);
			out.putBoolean("inuzukareleaselogic", inuzukareleaselogic);
			out.putDouble("IQ", IQ);
			out.putBoolean("izanagi", izanagi);
			out.putBoolean("izanagiuse", izanagiuse);
			out.putBoolean("izunoreleaselogic", izunoreleaselogic);
			out.putBoolean("joinworld", joinworld);
			out.putDouble("jp", jp);
			out.putDouble("jutsupowerstat", jutsupowerstat);
			out.putBoolean("kaguyareleaselogic", kaguyareleaselogic);
			out.putBoolean("kazekagereleaselogic", kazekagereleaselogic);
			out.putDouble("kenjutsu", kenjutsu);
			out.putBoolean("ketsuryugan", ketsuryugan);
			out.putBoolean("ketsuryuganactivate", ketsuryuganactivate);
			out.putDouble("kinjutsu", kinjutsu);
			out.putBoolean("kuramareleaselogic", kuramareleaselogic);
			out.putBoolean("leereleaselogic", leereleaselogic);
			out.putDouble("LEVEL", LEVEL);
			out.putDouble("LEVELMAX", LEVELMAX);
			out.putDouble("LEVELMAXMINIGAME", LEVELMAXMINIGAME);
			out.putDouble("LEVELMINIGAME", LEVELMINIGAME);
			out.putDouble("LEVELSTAT", LEVELSTAT);
			out.putDouble("LEVELSTATMINIGAME", LEVELSTATMINIGAME);
			out.putDouble("lightning_release", lightning_release);
			out.putDouble("lightning_technique", lightning_technique);
			out.putDouble("lightninglearn", lightninglearn);
			out.putBoolean("lightningreleaselogic", lightningreleaselogic);
			out.putBoolean("Mangekyou_Sharingan", Mangekyou_Sharingan);
			out.putDouble("maxhealth", maxhealth);
			out.putDouble("maxspeed", maxspeed);
			out.putDouble("medicine", medicine);
			out.putDouble("Mini_Game_Timer_Button", Mini_Game_Timer_Button);
			out.putBoolean("namikazereleaselogic", namikazereleaselogic);
			out.putBoolean("narareleaselogic", narareleaselogic);
			out.putDouble("NarutoTimerAwakening", NarutoTimerAwakening);
			out.putDouble("ninjutsu", ninjutsu);
			out.putBoolean("otsutsukireleaselogic", otsutsukireleaselogic);
			out.putDouble("Pupils_Height", Pupils_Height);
			out.putString("rank", rank);
			out.putDouble("S_Mission", S_Mission);
			out.putBoolean("sarutobireleaselogic", sarutobireleaselogic);
			out.putDouble("selectclanrelease", selectclanrelease);
			out.putDouble("selectnaturerelease", selectnaturerelease);
			out.putDouble("selectvillage", selectvillage);
			out.putBoolean("senjureleaselogic", senjureleaselogic);
			out.putDouble("senjutsu", senjutsu);
			out.putDouble("SenjutsuChakraMax", SenjutsuChakraMax);
			out.putBoolean("sharingan", sharingan);
			out.putBoolean("sharinganactivate", sharinganactivate);
			out.putDouble("sharinganlearn", sharinganlearn);
			out.putDouble("sharinganrelease", sharinganrelease);
			out.putDouble("sharingantechnique", sharingantechnique);
			out.putBoolean("shikamaruquest", shikamaruquest);
			out.putBoolean("shimurareleaselogic", shimurareleaselogic);
			out.putDouble("Shinobi_Murder_Count", Shinobi_Murder_Count);
			out.putDouble("shurikenjutsu", shurikenjutsu);
			out.putDouble("smokelearn", smokelearn);
			out.putBoolean("smokereleaselogic", smokereleaselogic);
			out.putDouble("smoketechnique", smoketechnique);
			out.putDouble("sp", sp);
			out.putDouble("speed", speed);
			out.putDouble("spusecount", spusecount);
			out.putDouble("SS_Mission", SS_Mission);
			out.putDouble("storymode", storymode);
			out.putDouble("summoning", summoning);
			out.putDouble("taijutsu", taijutsu);
			out.putBoolean("tenroreleaselogic", tenroreleaselogic);
			out.putBoolean("tsuchigumoreleaselogic", tsuchigumoreleaselogic);
			out.putBoolean("uchihareleaselogic", uchihareleaselogic);
			out.putBoolean("uzumakichains", uzumakichains);
			out.putDouble("uzumakilearn", uzumakilearn);
			out.putDouble("uzumakirelease", uzumakirelease);
			out.putBoolean("uzumakireleaselogic", uzumakireleaselogic);
			out.putDouble("uzumakitechnique", uzumakitechnique);
			out.putString("village", village);
			out.putDouble("water_release", water_release);
			out.putDouble("water_technique", water_technique);
			out.putDouble("waterlearn", waterlearn);
			out.putBoolean("waterreleaselogic", waterreleaselogic);
			out.putDouble("wind_release", wind_release);
			out.putDouble("wind_technique", wind_technique);
			out.putDouble("windlearn", windlearn);
			out.putBoolean("windreleaselogic", windreleaselogic);
			out.putBoolean("yukireleaselogic", yukireleaselogic);
			out.putDouble("smokerelease", smokerelease);
			out.putBoolean("Chakra_Control", Chakra_Control);
			out.putString("player_name", player_name);
			out.putString("customjutsutype1save", customjutsutype1save);
			out.putString("customjutsuspeed1save", customjutsuspeed1save);
			out.putString("customjutsurelease1save", customjutsurelease1save);
			out.putDouble("customjutsuchakra1save", customjutsuchakra1save);
			out.putString("jutsunamesave1", jutsunamesave1);
			out.putBoolean("customjutsu1learn", customjutsu1learn);
			out.putBoolean("isshikidojutsu", isshikidojutsu);
			out.putBoolean("isshikidojutsuactivate", isshikidojutsuactivate);
			out.putDouble("isshikidojutsutechnique", isshikidojutsutechnique);
			out.putDouble("isshikidojutsulearn", isshikidojutsulearn);
			out.putDouble("isshikidojutsurelease", isshikidojutsurelease);
			out.putDouble("inuzukatechnique", inuzukatechnique);
			out.putDouble("inuzukalearn", inuzukalearn);
			out.putBoolean("mangekyouletter", mangekyouletter);
			out.putDouble("magnettechnique", magnettechnique);
			out.putBoolean("magnetreleaselogic", magnetreleaselogic);
			out.putDouble("magnetlearn", magnetlearn);
			out.putBoolean("Login_Dojutsu", Login_Dojutsu);
			out.putString("DojutsuSelect2", DojutsuSelect2);
			out.putString("DojutsuSelect3", DojutsuSelect3);
			out.putBoolean("MangekyouSharinganSasuke", MangekyouSharinganSasuke);
			out.putBoolean("MangekyouSharinganItachi", MangekyouSharinganItachi);
			out.putBoolean("MangekyouSharinganMadara", MangekyouSharinganMadara);
			out.putBoolean("MangekyouSharinganObito", MangekyouSharinganObito);
			out.putBoolean("MangekyouSharinganShisui", MangekyouSharinganShisui);
			out.putBoolean("MangekyouSharinganActivate", MangekyouSharinganActivate);
			out.putBoolean("MangekyouSharinganKakashi", MangekyouSharinganKakashi);
			out.putBoolean("SharinganKakashi", SharinganKakashi);
			out.putDouble("magnet_release", magnet_release);
			out.putDouble("lee_technique", lee_technique);
			out.putDouble("leelearn", leelearn);
			out.putBoolean("deathgodcooldown", deathgodcooldown);
			out.putDouble("inuzuka_release", inuzuka_release);
			out.putBoolean("akamaru_summon", akamaru_summon);
			out.putDouble("lee_release", lee_release);
			out.putDouble("gateslee", gateslee);
			out.putBoolean("Gate8", Gate8);
			out.putDouble("flyingthundergodkunaiteleportselect", flyingthundergodkunaiteleportselect);
			out.putString("dojutsubyakugan", dojutsubyakugan);
			out.putString("dojutsusharingan", dojutsusharingan);
			out.putString("dojutsuketsuryugan", dojutsuketsuryugan);
			out.putString("dojutsums", dojutsums);
			out.putString("dojutsuisshiki", dojutsuisshiki);
			out.putBoolean("PassingFang", PassingFang);
			out.putDouble("stormtechnique", stormtechnique);
			out.putBoolean("stormreleaselogic", stormreleaselogic);
			out.putDouble("stormlearn", stormlearn);
			out.putDouble("storm_release", storm_release);
			out.putBoolean("stormlaser", stormlaser);
			out.putDouble("otsutsuki_tool", otsutsuki_tool);
			out.putString("dojutsurinnegan", dojutsurinnegan);
			out.putString("dojutsutenseigan", dojutsutenseigan);
			out.putBoolean("tenseigan", tenseigan);
			out.putBoolean("tenseiganactivate", tenseiganactivate);
			out.putBoolean("rinnegan", rinnegan);
			out.putBoolean("rinneganactivate", rinneganactivate);
			out.putDouble("otsutsuki_path", otsutsuki_path);
			out.putBoolean("woodreleaselogic", woodreleaselogic);
			out.putDouble("woodtechnique", woodtechnique);
			out.putDouble("woodlearn", woodlearn);
			out.putDouble("wood_release", wood_release);
			out.putBoolean("otsutsuki_mangekyou", otsutsuki_mangekyou);
			out.putBoolean("icereleaselogic", icereleaselogic);
			out.putDouble("icetechnique", icetechnique);
			out.putDouble("icelearn", icelearn);
			out.putDouble("ice_release", ice_release);
			out.putBoolean("ice_mirror", ice_mirror);
			out.putBoolean("tenromode", tenromode);
			out.putBoolean("izunochakramode", izunochakramode);
			out.putBoolean("izunocat", izunocat);
			out.putDouble("calendar_calculator", calendar_calculator);
			out.putBoolean("shimura_active", shimura_active);
			out.putBoolean("SharinganShimura", SharinganShimura);
			out.putDouble("aburametechnique", aburametechnique);
			out.putDouble("aburamelearn", aburamelearn);
			out.putDouble("aburame_release", aburame_release);
			out.putDouble("sarutobitechnique", sarutobitechnique);
			out.putDouble("sarutobilearn", sarutobilearn);
			out.putDouble("sarutobirelease", sarutobirelease);
			out.putDouble("naratechnique", naratechnique);
			out.putDouble("naralearn", naralearn);
			out.putDouble("nararelease", nararelease);
			out.putBoolean("restrained", restrained);
			out.putDouble("possessing", possessing);
			out.putDouble("mangekyousharinganitachitechnique", mangekyousharinganitachitechnique);
			out.putDouble("mangekyousharingankakashitechnique", mangekyousharingankakashitechnique);
			out.putDouble("yamanakatechnique", yamanakatechnique);
			out.putDouble("yamanakalearn", yamanakalearn);
			out.putDouble("yamanakarelease", yamanakarelease);
			out.putDouble("byakugantechnique", byakugantechnique);
			out.putDouble("byakuganlearn", byakuganlearn);
			out.putDouble("byakuganrelease", byakuganrelease);
			out.putDouble("ketsuryugantechnique", ketsuryugantechnique);
			out.putDouble("ketsuryuganlearn", ketsuryuganlearn);
			out.putDouble("ketsuryuganrelease", ketsuryuganrelease);
			out.putDouble("rinnegantechnique", rinnegantechnique);
			out.putDouble("rinneganlearn", rinneganlearn);
			out.putDouble("rinneganrelease", rinneganrelease);
			out.putDouble("tenseigantechnique", tenseigantechnique);
			out.putDouble("tenseiganlearn", tenseiganlearn);
			out.putDouble("tenseiganrelease", tenseiganrelease);
			out.putDouble("uchihatechnique", uchihatechnique);
			out.putDouble("uchihalearn", uchihalearn);
			out.putDouble("uchiharelease", uchiharelease);
			out.putDouble("mangekyousharinganshisuitechnique", mangekyousharinganshisuitechnique);
			out.putDouble("mangekyousharinganshisuilearn", mangekyousharinganshisuilearn);
			out.putDouble("mangekyousharinganmadaratechnique", mangekyousharinganmadaratechnique);
			out.putDouble("mangekyousharinganmadaralearn", mangekyousharinganmadaralearn);
			out.putDouble("hozukitechnique", hozukitechnique);
			out.putDouble("hozukilearn", hozukilearn);
			out.putDouble("hozukirelease", hozukirelease);
			out.putDouble("tsuchigumotechnique", tsuchigumotechnique);
			out.putDouble("tsuchigumolearn", tsuchigumolearn);
			out.putDouble("tsuchigumorelease", tsuchigumorelease);
			out.putBoolean("waterblob", waterblob);
			out.putBoolean("Great_Water_Arm", Great_Water_Arm);
			out.putBoolean("bonereleaselogic", bonereleaselogic);
			out.putDouble("bonetechnique", bonetechnique);
			out.putDouble("bonelearn", bonelearn);
			out.putDouble("bone_release", bone_release);
			out.putBoolean("DanceOfTheLarch", DanceOfTheLarch);
			out.putDouble("fumatechnique", fumatechnique);
			out.putDouble("fumalearn", fumalearn);
			out.putDouble("fumarelease", fumarelease);
			out.putDouble("magnet_coat", magnet_coat);
			out.putDouble("Shadow1X", Shadow1X);
			out.putDouble("Shadow2X", Shadow2X);
			out.putDouble("Shadow1Z", Shadow1Z);
			out.putDouble("Shadow2Z", Shadow2Z);
			out.putBoolean("NaraClanShadow", NaraClanShadow);
			out.putDouble("OriginalZ1", OriginalZ1);
			out.putDouble("OriginalX1", OriginalX1);
			out.putBoolean("EightTrigramsPalmsRevolvingHeaven", EightTrigramsPalmsRevolvingHeaven);
			out.putBoolean("InsectJarTechnique", InsectJarTechnique);
			out.putDouble("ShadowX1", ShadowX1);
			out.putDouble("ShadowX2", ShadowX2);
			out.putDouble("ShadowZ1", ShadowZ1);
			out.putDouble("ShadowZ2", ShadowZ2);
			out.putDouble("akimichitechnique", akimichitechnique);
			out.putDouble("akimichilearn", akimichilearn);
			out.putDouble("akimichirelease", akimichirelease);
			out.putBoolean("HumanBulletTank", HumanBulletTank);
			out.putBoolean("ButterflyMode", ButterflyMode);
			out.putBoolean("SpikedHumanBulletTank", SpikedHumanBulletTank);
			out.putDouble("zombiekillcount", zombiekillcount);
			out.putDouble("pillagerkillcount", pillagerkillcount);
			out.putDouble("typhoontechnique", typhoontechnique);
			out.putDouble("typhoonlearn", typhoonlearn);
			out.putDouble("typhoonrelease", typhoonrelease);
			out.putBoolean("typhoonreleaslogic", typhoonreleaslogic);
			out.putDouble("swiftlearn", swiftlearn);
			out.putDouble("swiftrelease", swiftrelease);
			out.putBoolean("swiftreleaselogic", swiftreleaselogic);
			out.putDouble("steeltechnique", steeltechnique);
			out.putDouble("steellearn", steellearn);
			out.putDouble("steelrelease", steelrelease);
			out.putBoolean("steelreleaselogic", steelreleaselogic);
			out.putDouble("dusttechnique", dusttechnique);
			out.putDouble("dustlearn", dustlearn);
			out.putDouble("dustrelease", dustrelease);
			out.putBoolean("dustreleaselogic", dustreleaselogic);
			out.putDouble("boiltechnique", boiltechnique);
			out.putDouble("boillearn", boillearn);
			out.putDouble("boilrelease", boilrelease);
			out.putBoolean("boilreleaselogic", boilreleaselogic);
			out.putBoolean("swiftmode", swiftmode);
			out.putBoolean("ImperviousArmor", ImperviousArmor);
			out.putBoolean("WindMode", WindMode);
			out.putBoolean("SmokeForm", SmokeForm);
			out.putString("ButterFlyModeColor", ButterFlyModeColor);
			out.putDouble("HPBarfill", HPBarfill);
			out.putDouble("ChakraBarfill", ChakraBarfill);
			out.putBoolean("DashCooldown", DashCooldown);
			out.putDouble("DashCooldownTicks", DashCooldownTicks);
			out.putDouble("WPressed", WPressed);
			out.putDouble("APressed", APressed);
			out.putDouble("DPressed", DPressed);
			out.putDouble("SPressed", SPressed);
			out.putDouble("SpacePressed", SpacePressed);
			out.putBoolean("UpDashCooldown", UpDashCooldown);
			out.putDouble("UpDashCooldownTicks", UpDashCooldownTicks);
			out.putBoolean("Dash", Dash);
			out.putDouble("DashReset", DashReset);
			out.putBoolean("WHold", WHold);
			out.putBoolean("WaterWalk", WaterWalk);
			out.putBoolean("WallClimb", WallClimb);
			out.putDouble("StorymodeCooldown", StorymodeCooldown);
			out.putString("directionstorymode", directionstorymode);
			out.putDouble("TrainingDummyHits", TrainingDummyHits);
			out.putString("StoryModeGeninFight", StoryModeGeninFight);
			out.putDouble("HeadbandSelect", HeadbandSelect);
			out.putBoolean("Kagutsuchi", Kagutsuchi);
			out.putBoolean("AmaterasuSusano", AmaterasuSusano);
			out.putDouble("MangekyouSharinganRelease", MangekyouSharinganRelease);
			out.putDouble("mangekyousharingansasukeamaterasurelease", mangekyousharingansasukeamaterasurelease);
			out.putDouble("mangekyousharingansasukeamaterasulearn", mangekyousharingansasukeamaterasulearn);
			out.putDouble("mangekyousharingansasukeamaterasutechnique", mangekyousharingansasukeamaterasutechnique);
			out.putDouble("mangekyousharingansasukesusanorelease", mangekyousharingansasukesusanorelease);
			out.putDouble("mangekyousharingansasukesusanolearn", mangekyousharingansasukesusanolearn);
			out.putDouble("mangekyousharingansusanostage", mangekyousharingansusanostage);
			out.putDouble("mangekyoushrainganitachiamaterasulearn", mangekyoushrainganitachiamaterasulearn);
			out.putDouble("mangekyoushrainganitachisusanorelease", mangekyoushrainganitachisusanorelease);
			out.putDouble("mangekyoushrainganitachisusanolearn", mangekyoushrainganitachisusanolearn);
			out.putDouble("mangekyousharingankakashikamuilearn", mangekyousharingankakashikamuilearn);
			out.putDouble("mangekyousharinganobitokamuirelease", mangekyousharinganobitokamuirelease);
			out.putDouble("mangekyousharinganobitokamuilearn", mangekyousharinganobitokamuilearn);
			out.putDouble("mangekyousharinganobitokamuitechnique", mangekyousharinganobitokamuitechnique);
			out.putDouble("mangekyousharinganobitosusanorelease", mangekyousharinganobitosusanorelease);
			out.putDouble("mangekyousharinganobitosusanolearn", mangekyousharinganobitosusanolearn);
			out.putBoolean("KamuiPhantomPhase", KamuiPhantomPhase);
			out.putBoolean("Eternal_Mangekyou_Sharingan", Eternal_Mangekyou_Sharingan);
			out.putDouble("Mangekyou_Sharingan_Technique_Use", Mangekyou_Sharingan_Technique_Use);
			out.putDouble("Mangekyou_Sharingan_Technique_Use_Max", Mangekyou_Sharingan_Technique_Use_Max);
			out.putDouble("mangekyousharinganmadarasusanorelease", mangekyousharinganmadarasusanorelease);
			out.putDouble("mangekyousharinganmadarasusanolearn", mangekyousharinganmadarasusanolearn);
			out.putDouble("mangekyousharinganshisuisusanorelease", mangekyousharinganshisuisusanorelease);
			out.putDouble("mangekyousharinganshisuisusanolearn", mangekyousharinganshisuisusanolearn);
			out.store("gunbaicopy", ItemStack.OPTIONAL_CODEC, gunbaicopy);
			out.putDouble("LevelStatMaxChange", LevelStatMaxChange);
			out.putDouble("inuzuka_mode", inuzuka_mode);
			out.putString("custom_jutsu", custom_jutsu);
			out.putString("weapon_arts", weapon_arts);
			out.putString("learned_jutsu", learned_jutsu);
			out.putBoolean("learned_jutsu_migrated", learned_jutsu_migrated);
			out.putBoolean("mimic_sneak", mimic_sneak);
		}

		public void read(ValueInput in) {
			A_Mission = in.getDoubleOr("A_Mission", 0);
			aburamereleaselogic = in.getBooleanOr("aburamereleaselogic", false);
			akimichireleaselogic = in.getBooleanOr("akimichireleaselogic", false);
			asumaquest = in.getBooleanOr("asumaquest", false);
			B_Mission = in.getDoubleOr("B_Mission", 0);
			byakugan = in.getBooleanOr("byakugan", false);
			byakuganactivate = in.getBooleanOr("byakuganactivate", false);
			C_Mission = in.getDoubleOr("C_Mission", 0);
			ChakraAmount = in.getDoubleOr("ChakraAmount", 0);
			ChakraMax = in.getDoubleOr("ChakraMax", 0.0);
			chinoikereleaselogic = in.getBooleanOr("chinoikereleaselogic", false);
			D_Mission = in.getDoubleOr("D_Mission", 0);
			deathgod = in.getBooleanOr("deathgod", false);
			DojutsuSelectResize = in.getStringOr("DojutsuSelectResize", "Sharingan");
			earth_release = in.getDoubleOr("earth_release", 0);
			earth_technique = in.getDoubleOr("earth_technique", 0);
			earthlearn = in.getDoubleOr("earthlearn", 0);
			earthreleaselogic = in.getBooleanOr("earthreleaselogic", false);
			Eyes_Height = in.getDoubleOr("Eyes_Height", 1.0);
			fire_release = in.getDoubleOr("fire_release", 0);
			firelearn = in.getDoubleOr("firelearn", 0);
			firereleaselogic = in.getBooleanOr("firereleaselogic", false);
			firetechnique = in.getDoubleOr("firetechnique", 0);
			fumareleaselogic = in.getBooleanOr("fumareleaselogic", false);
			genjutsu = in.getDoubleOr("genjutsu", 0);
			hatakereleaselogic = in.getBooleanOr("hatakereleaselogic", false);
			Health = in.getDoubleOr("Health", 0);
			HealthMax = in.getDoubleOr("HealthMax", 0);
			hoshigakireleaselogic = in.getBooleanOr("hoshigakireleaselogic", false);
			hozukireleaselogic = in.getBooleanOr("hozukireleaselogic", false);
			hyugalearn = in.getDoubleOr("hyugalearn", 0.0);
			hyugarelease = in.getDoubleOr("hyugarelease", 0);
			hyugareleaselogic = in.getBooleanOr("hyugareleaselogic", false);
			hyugatechnique = in.getDoubleOr("hyugatechnique", 0);
			yamanakareleaselogic = in.getBooleanOr("yamanakareleaselogic", in.getBooleanOr("iburireleaselogic", false));
			inuzukareleaselogic = in.getBooleanOr("inuzukareleaselogic", false);
			IQ = in.getDoubleOr("IQ", 0);
			izanagi = in.getBooleanOr("izanagi", false);
			izanagiuse = in.getBooleanOr("izanagiuse", false);
			izunoreleaselogic = in.getBooleanOr("izunoreleaselogic", false);
			joinworld = in.getBooleanOr("joinworld", false);
			jp = in.getDoubleOr("jp", 0);
			jutsupowerstat = in.getDoubleOr("jutsupowerstat", 0);
			kaguyareleaselogic = in.getBooleanOr("kaguyareleaselogic", false);
			kazekagereleaselogic = in.getBooleanOr("kazekagereleaselogic", false);
			kenjutsu = in.getDoubleOr("kenjutsu", 0);
			ketsuryugan = in.getBooleanOr("ketsuryugan", false);
			ketsuryuganactivate = in.getBooleanOr("ketsuryuganactivate", false);
			kinjutsu = in.getDoubleOr("kinjutsu", 0);
			kuramareleaselogic = in.getBooleanOr("kuramareleaselogic", false);
			leereleaselogic = in.getBooleanOr("leereleaselogic", false);
			LEVEL = in.getDoubleOr("LEVEL", 0.0);
			LEVELMAX = in.getDoubleOr("LEVELMAX", 1.0);
			LEVELMAXMINIGAME = in.getDoubleOr("LEVELMAXMINIGAME", 5.0);
			LEVELMINIGAME = in.getDoubleOr("LEVELMINIGAME", 0);
			LEVELSTAT = in.getDoubleOr("LEVELSTAT", 0.0);
			LEVELSTATMINIGAME = in.getDoubleOr("LEVELSTATMINIGAME", 0);
			lightning_release = in.getDoubleOr("lightning_release", 0);
			lightning_technique = in.getDoubleOr("lightning_technique", 0.0);
			lightninglearn = in.getDoubleOr("lightninglearn", 0);
			lightningreleaselogic = in.getBooleanOr("lightningreleaselogic", false);
			Mangekyou_Sharingan = in.getBooleanOr("Mangekyou_Sharingan", false);
			maxhealth = in.getDoubleOr("maxhealth", 20.0);
			maxspeed = in.getDoubleOr("maxspeed", 0.1);
			medicine = in.getDoubleOr("medicine", 0);
			Mini_Game_Timer_Button = in.getDoubleOr("Mini_Game_Timer_Button", 0);
			namikazereleaselogic = in.getBooleanOr("namikazereleaselogic", false);
			narareleaselogic = in.getBooleanOr("narareleaselogic", false);
			NarutoTimerAwakening = in.getDoubleOr("NarutoTimerAwakening", 0);
			ninjutsu = in.getDoubleOr("ninjutsu", 0);
			otsutsukireleaselogic = in.getBooleanOr("otsutsukireleaselogic", false);
			Pupils_Height = in.getDoubleOr("Pupils_Height", 1.0);
			rank = in.getStringOr("rank", "Academy Student");
			S_Mission = in.getDoubleOr("S_Mission", 0);
			sarutobireleaselogic = in.getBooleanOr("sarutobireleaselogic", false);
			selectclanrelease = in.getDoubleOr("selectclanrelease", 0);
			selectnaturerelease = in.getDoubleOr("selectnaturerelease", 0);
			selectvillage = in.getDoubleOr("selectvillage", 0);
			senjureleaselogic = in.getBooleanOr("senjureleaselogic", false);
			senjutsu = in.getDoubleOr("senjutsu", 0);
			SenjutsuChakraMax = in.getDoubleOr("SenjutsuChakraMax", 0);
			sharingan = in.getBooleanOr("sharingan", false);
			sharinganactivate = in.getBooleanOr("sharinganactivate", false);
			sharinganlearn = in.getDoubleOr("sharinganlearn", 0.0);
			sharinganrelease = in.getDoubleOr("sharinganrelease", 0);
			sharingantechnique = in.getDoubleOr("sharingantechnique", 0.0);
			shikamaruquest = in.getBooleanOr("shikamaruquest", false);
			shimurareleaselogic = in.getBooleanOr("shimurareleaselogic", false);
			Shinobi_Murder_Count = in.getDoubleOr("Shinobi_Murder_Count", 0);
			shurikenjutsu = in.getDoubleOr("shurikenjutsu", 0);
			smokelearn = in.getDoubleOr("smokelearn", 0.0);
			smokereleaselogic = in.getBooleanOr("smokereleaselogic", false);
			smoketechnique = in.getDoubleOr("smoketechnique", 0);
			sp = in.getDoubleOr("sp", 0);
			speed = in.getDoubleOr("speed", 0);
			spusecount = in.getDoubleOr("spusecount", 1.0);
			SS_Mission = in.getDoubleOr("SS_Mission", 0);
			storymode = in.getDoubleOr("storymode", 0);
			summoning = in.getDoubleOr("summoning", 0);
			taijutsu = in.getDoubleOr("taijutsu", 0);
			tenroreleaselogic = in.getBooleanOr("tenroreleaselogic", false);
			tsuchigumoreleaselogic = in.getBooleanOr("tsuchigumoreleaselogic", false);
			uchihareleaselogic = in.getBooleanOr("uchihareleaselogic", false);
			uzumakichains = in.getBooleanOr("uzumakichains", false);
			uzumakilearn = in.getDoubleOr("uzumakilearn", 0.0);
			uzumakirelease = in.getDoubleOr("uzumakirelease", 0);
			uzumakireleaselogic = in.getBooleanOr("uzumakireleaselogic", false);
			uzumakitechnique = in.getDoubleOr("uzumakitechnique", 0.0);
			village = in.getStringOr("village", "");
			water_release = in.getDoubleOr("water_release", 0);
			water_technique = in.getDoubleOr("water_technique", 0);
			waterlearn = in.getDoubleOr("waterlearn", 0);
			waterreleaselogic = in.getBooleanOr("waterreleaselogic", false);
			wind_release = in.getDoubleOr("wind_release", 0);
			wind_technique = in.getDoubleOr("wind_technique", 0);
			windlearn = in.getDoubleOr("windlearn", 0);
			windreleaselogic = in.getBooleanOr("windreleaselogic", false);
			yukireleaselogic = in.getBooleanOr("yukireleaselogic", false);
			smokerelease = in.getDoubleOr("smokerelease", 0);
			Chakra_Control = in.getBooleanOr("Chakra_Control", false);
			player_name = in.getStringOr("player_name", "\"\"");
			customjutsutype1save = in.getStringOr("customjutsutype1save", "\"\"");
			customjutsuspeed1save = in.getStringOr("customjutsuspeed1save", "\"\"");
			customjutsurelease1save = in.getStringOr("customjutsurelease1save", "\"\"");
			customjutsuchakra1save = in.getDoubleOr("customjutsuchakra1save", 0);
			jutsunamesave1 = in.getStringOr("jutsunamesave1", "\"\"");
			customjutsu1learn = in.getBooleanOr("customjutsu1learn", false);
			isshikidojutsu = in.getBooleanOr("isshikidojutsu", false);
			isshikidojutsuactivate = in.getBooleanOr("isshikidojutsuactivate", false);
			isshikidojutsutechnique = in.getDoubleOr("isshikidojutsutechnique", 0.0);
			isshikidojutsulearn = in.getDoubleOr("isshikidojutsulearn", 0.0);
			isshikidojutsurelease = in.getDoubleOr("isshikidojutsurelease", 0);
			inuzukatechnique = in.getDoubleOr("inuzukatechnique", 0);
			inuzukalearn = in.getDoubleOr("inuzukalearn", 0.0);
			mangekyouletter = in.getBooleanOr("mangekyouletter", false);
			magnettechnique = in.getDoubleOr("magnettechnique", 0);
			magnetreleaselogic = in.getBooleanOr("magnetreleaselogic", false);
			magnetlearn = in.getDoubleOr("magnetlearn", 0);
			Login_Dojutsu = in.getBooleanOr("Login_Dojutsu", false);
			DojutsuSelect2 = in.getStringOr("DojutsuSelect2", "Default");
			DojutsuSelect3 = in.getStringOr("DojutsuSelect3", " ");
			MangekyouSharinganSasuke = in.getBooleanOr("MangekyouSharinganSasuke", false);
			MangekyouSharinganItachi = in.getBooleanOr("MangekyouSharinganItachi", false);
			MangekyouSharinganMadara = in.getBooleanOr("MangekyouSharinganMadara", false);
			MangekyouSharinganObito = in.getBooleanOr("MangekyouSharinganObito", false);
			MangekyouSharinganShisui = in.getBooleanOr("MangekyouSharinganShisui", false);
			MangekyouSharinganActivate = in.getBooleanOr("MangekyouSharinganActivate", false);
			MangekyouSharinganKakashi = in.getBooleanOr("MangekyouSharinganKakashi", false);
			SharinganKakashi = in.getBooleanOr("SharinganKakashi", false);
			magnet_release = in.getDoubleOr("magnet_release", 0);
			lee_technique = in.getDoubleOr("lee_technique", 0);
			leelearn = in.getDoubleOr("leelearn", 0);
			deathgodcooldown = in.getBooleanOr("deathgodcooldown", false);
			inuzuka_release = in.getDoubleOr("inuzuka_release", 0);
			akamaru_summon = in.getBooleanOr("akamaru_summon", false);
			lee_release = in.getDoubleOr("lee_release", 0);
			gateslee = in.getDoubleOr("gateslee", 0);
			Gate8 = in.getBooleanOr("Gate8", false);
			flyingthundergodkunaiteleportselect = in.getDoubleOr("flyingthundergodkunaiteleportselect", 0);
			dojutsubyakugan = in.getStringOr("dojutsubyakugan", "\"\"");
			dojutsusharingan = in.getStringOr("dojutsusharingan", "\"\"");
			dojutsuketsuryugan = in.getStringOr("dojutsuketsuryugan", "\"\"");
			dojutsums = in.getStringOr("dojutsums", "\"\"");
			dojutsuisshiki = in.getStringOr("dojutsuisshiki", "\"\"");
			PassingFang = in.getBooleanOr("PassingFang", false);
			stormtechnique = in.getDoubleOr("stormtechnique", 0);
			stormreleaselogic = in.getBooleanOr("stormreleaselogic", false);
			stormlearn = in.getDoubleOr("stormlearn", 0);
			storm_release = in.getDoubleOr("storm_release", 0);
			stormlaser = in.getBooleanOr("stormlaser", false);
			otsutsuki_tool = in.getDoubleOr("otsutsuki_tool", 0);
			dojutsurinnegan = in.getStringOr("dojutsurinnegan", "\"\"");
			dojutsutenseigan = in.getStringOr("dojutsutenseigan", "\"\"");
			tenseigan = in.getBooleanOr("tenseigan", false);
			tenseiganactivate = in.getBooleanOr("tenseiganactivate", false);
			rinnegan = in.getBooleanOr("rinnegan", false);
			rinneganactivate = in.getBooleanOr("rinneganactivate", false);
			otsutsuki_path = in.getDoubleOr("otsutsuki_path", 0);
			woodreleaselogic = in.getBooleanOr("woodreleaselogic", false);
			woodtechnique = in.getDoubleOr("woodtechnique", 0);
			woodlearn = in.getDoubleOr("woodlearn", 0);
			wood_release = in.getDoubleOr("wood_release", 0);
			otsutsuki_mangekyou = in.getBooleanOr("otsutsuki_mangekyou", false);
			icereleaselogic = in.getBooleanOr("icereleaselogic", false);
			icetechnique = in.getDoubleOr("icetechnique", 0);
			icelearn = in.getDoubleOr("icelearn", 0);
			ice_release = in.getDoubleOr("ice_release", 0);
			ice_mirror = in.getBooleanOr("ice_mirror", false);
			tenromode = in.getBooleanOr("tenromode", false);
			izunochakramode = in.getBooleanOr("izunochakramode", false);
			izunocat = in.getBooleanOr("izunocat", false);
			calendar_calculator = in.getDoubleOr("calendar_calculator", 0);
			shimura_active = in.getBooleanOr("shimura_active", false);
			SharinganShimura = in.getBooleanOr("SharinganShimura", false);
			aburametechnique = in.getDoubleOr("aburametechnique", 0);
			aburamelearn = in.getDoubleOr("aburamelearn", 0);
			aburame_release = in.getDoubleOr("aburame_release", 0);
			sarutobitechnique = in.getDoubleOr("sarutobitechnique", 0);
			sarutobilearn = in.getDoubleOr("sarutobilearn", 0);
			sarutobirelease = in.getDoubleOr("sarutobirelease", 0);
			naratechnique = in.getDoubleOr("naratechnique", 0);
			naralearn = in.getDoubleOr("naralearn", 0);
			nararelease = in.getDoubleOr("nararelease", 0);
			restrained = in.getBooleanOr("restrained", false);
			possessing = in.getDoubleOr("possessing", 0);
			mangekyousharinganitachitechnique = in.getDoubleOr("mangekyousharinganitachitechnique", 0);
			mangekyousharingankakashitechnique = in.getDoubleOr("mangekyousharingankakashitechnique", 0);
			yamanakatechnique = in.getDoubleOr("yamanakatechnique", 0);
			yamanakalearn = in.getDoubleOr("yamanakalearn", 0);
			yamanakarelease = in.getDoubleOr("yamanakarelease", 0);
			byakugantechnique = in.getDoubleOr("byakugantechnique", 0);
			byakuganlearn = in.getDoubleOr("byakuganlearn", 0);
			byakuganrelease = in.getDoubleOr("byakuganrelease", 0);
			ketsuryugantechnique = in.getDoubleOr("ketsuryugantechnique", 0);
			ketsuryuganlearn = in.getDoubleOr("ketsuryuganlearn", 0);
			ketsuryuganrelease = in.getDoubleOr("ketsuryuganrelease", 0);
			rinnegantechnique = in.getDoubleOr("rinnegantechnique", 0);
			rinneganlearn = in.getDoubleOr("rinneganlearn", 0);
			rinneganrelease = in.getDoubleOr("rinneganrelease", 0);
			tenseigantechnique = in.getDoubleOr("tenseigantechnique", 0);
			tenseiganlearn = in.getDoubleOr("tenseiganlearn", 0);
			tenseiganrelease = in.getDoubleOr("tenseiganrelease", 0);
			uchihatechnique = in.getDoubleOr("uchihatechnique", 0);
			uchihalearn = in.getDoubleOr("uchihalearn", 0);
			uchiharelease = in.getDoubleOr("uchiharelease", 0);
			mangekyousharinganshisuitechnique = in.getDoubleOr("mangekyousharinganshisuitechnique", 0);
			mangekyousharinganshisuilearn = in.getDoubleOr("mangekyousharinganshisuilearn", 0);
			mangekyousharinganmadaratechnique = in.getDoubleOr("mangekyousharinganmadaratechnique", 0);
			mangekyousharinganmadaralearn = in.getDoubleOr("mangekyousharinganmadaralearn", 0);
			hozukitechnique = in.getDoubleOr("hozukitechnique", 0);
			hozukilearn = in.getDoubleOr("hozukilearn", 0);
			hozukirelease = in.getDoubleOr("hozukirelease", 0);
			tsuchigumotechnique = in.getDoubleOr("tsuchigumotechnique", 0);
			tsuchigumolearn = in.getDoubleOr("tsuchigumolearn", 0);
			tsuchigumorelease = in.getDoubleOr("tsuchigumorelease", 0);
			waterblob = in.getBooleanOr("waterblob", false);
			Great_Water_Arm = in.getBooleanOr("Great_Water_Arm", false);
			bonereleaselogic = in.getBooleanOr("bonereleaselogic", false);
			bonetechnique = in.getDoubleOr("bonetechnique", 0);
			bonelearn = in.getDoubleOr("bonelearn", 0);
			bone_release = in.getDoubleOr("bone_release", 0);
			DanceOfTheLarch = in.getBooleanOr("DanceOfTheLarch", false);
			fumatechnique = in.getDoubleOr("fumatechnique", 0);
			fumalearn = in.getDoubleOr("fumalearn", 0);
			fumarelease = in.getDoubleOr("fumarelease", 0);
			magnet_coat = in.getDoubleOr("magnet_coat", 0);
			Shadow1X = in.getDoubleOr("Shadow1X", 0);
			Shadow2X = in.getDoubleOr("Shadow2X", 0);
			Shadow1Z = in.getDoubleOr("Shadow1Z", 0);
			Shadow2Z = in.getDoubleOr("Shadow2Z", 0);
			NaraClanShadow = in.getBooleanOr("NaraClanShadow", false);
			OriginalZ1 = in.getDoubleOr("OriginalZ1", 0);
			OriginalX1 = in.getDoubleOr("OriginalX1", 0);
			EightTrigramsPalmsRevolvingHeaven = in.getBooleanOr("EightTrigramsPalmsRevolvingHeaven", false);
			InsectJarTechnique = in.getBooleanOr("InsectJarTechnique", false);
			ShadowX1 = in.getDoubleOr("ShadowX1", 0);
			ShadowX2 = in.getDoubleOr("ShadowX2", 0);
			ShadowZ1 = in.getDoubleOr("ShadowZ1", 0);
			ShadowZ2 = in.getDoubleOr("ShadowZ2", 0);
			akimichitechnique = in.getDoubleOr("akimichitechnique", 0);
			akimichilearn = in.getDoubleOr("akimichilearn", 0);
			akimichirelease = in.getDoubleOr("akimichirelease", 0);
			HumanBulletTank = in.getBooleanOr("HumanBulletTank", false);
			ButterflyMode = in.getBooleanOr("ButterflyMode", false);
			SpikedHumanBulletTank = in.getBooleanOr("SpikedHumanBulletTank", false);
			zombiekillcount = in.getDoubleOr("zombiekillcount", 0);
			pillagerkillcount = in.getDoubleOr("pillagerkillcount", 0);
			typhoontechnique = in.getDoubleOr("typhoontechnique", 0);
			typhoonlearn = in.getDoubleOr("typhoonlearn", 0);
			typhoonrelease = in.getDoubleOr("typhoonrelease", 0);
			typhoonreleaslogic = in.getBooleanOr("typhoonreleaslogic", false);
			swiftlearn = in.getDoubleOr("swiftlearn", 0);
			swiftrelease = in.getDoubleOr("swiftrelease", 0);
			swiftreleaselogic = in.getBooleanOr("swiftreleaselogic", false);
			steeltechnique = in.getDoubleOr("steeltechnique", 0);
			steellearn = in.getDoubleOr("steellearn", 0);
			steelrelease = in.getDoubleOr("steelrelease", 0);
			steelreleaselogic = in.getBooleanOr("steelreleaselogic", false);
			dusttechnique = in.getDoubleOr("dusttechnique", 0);
			dustlearn = in.getDoubleOr("dustlearn", 0);
			dustrelease = in.getDoubleOr("dustrelease", 0);
			dustreleaselogic = in.getBooleanOr("dustreleaselogic", false);
			boiltechnique = in.getDoubleOr("boiltechnique", 0);
			boillearn = in.getDoubleOr("boillearn", 0);
			boilrelease = in.getDoubleOr("boilrelease", 0);
			boilreleaselogic = in.getBooleanOr("boilreleaselogic", false);
			swiftmode = in.getBooleanOr("swiftmode", false);
			ImperviousArmor = in.getBooleanOr("ImperviousArmor", false);
			WindMode = in.getBooleanOr("WindMode", false);
			SmokeForm = in.getBooleanOr("SmokeForm", false);
			ButterFlyModeColor = in.getStringOr("ButterFlyModeColor", "\"\"");
			HPBarfill = in.getDoubleOr("HPBarfill", 0);
			ChakraBarfill = in.getDoubleOr("ChakraBarfill", 0);
			DashCooldown = in.getBooleanOr("DashCooldown", false);
			DashCooldownTicks = in.getDoubleOr("DashCooldownTicks", 0);
			WPressed = in.getDoubleOr("WPressed", 0);
			APressed = in.getDoubleOr("APressed", 0);
			DPressed = in.getDoubleOr("DPressed", 0);
			SPressed = in.getDoubleOr("SPressed", 0);
			SpacePressed = in.getDoubleOr("SpacePressed", 0);
			UpDashCooldown = in.getBooleanOr("UpDashCooldown", false);
			UpDashCooldownTicks = in.getDoubleOr("UpDashCooldownTicks", 0);
			Dash = in.getBooleanOr("Dash", false);
			DashReset = in.getDoubleOr("DashReset", 0);
			WHold = in.getBooleanOr("WHold", false);
			WaterWalk = in.getBooleanOr("WaterWalk", false);
			WallClimb = in.getBooleanOr("WallClimb", false);
			StorymodeCooldown = in.getDoubleOr("StorymodeCooldown", 0);
			directionstorymode = in.getStringOr("directionstorymode", "\"\"");
			TrainingDummyHits = in.getDoubleOr("TrainingDummyHits", 0);
			StoryModeGeninFight = in.getStringOr("StoryModeGeninFight", " ");
			HeadbandSelect = in.getDoubleOr("HeadbandSelect", 0);
			Kagutsuchi = in.getBooleanOr("Kagutsuchi", false);
			AmaterasuSusano = in.getBooleanOr("AmaterasuSusano", false);
			MangekyouSharinganRelease = in.getDoubleOr("MangekyouSharinganRelease", 0);
			mangekyousharingansasukeamaterasurelease = in.getDoubleOr("mangekyousharingansasukeamaterasurelease", 0);
			mangekyousharingansasukeamaterasulearn = in.getDoubleOr("mangekyousharingansasukeamaterasulearn", 0);
			mangekyousharingansasukeamaterasutechnique = in.getDoubleOr("mangekyousharingansasukeamaterasutechnique", 0);
			mangekyousharingansasukesusanorelease = in.getDoubleOr("mangekyousharingansasukesusanorelease", 0);
			mangekyousharingansasukesusanolearn = in.getDoubleOr("mangekyousharingansasukesusanolearn", 0);
			mangekyousharingansusanostage = in.getDoubleOr("mangekyousharingansusanostage", 0);
			mangekyoushrainganitachiamaterasulearn = in.getDoubleOr("mangekyoushrainganitachiamaterasulearn", 0);
			mangekyoushrainganitachisusanorelease = in.getDoubleOr("mangekyoushrainganitachisusanorelease", 0);
			mangekyoushrainganitachisusanolearn = in.getDoubleOr("mangekyoushrainganitachisusanolearn", 0);
			mangekyousharingankakashikamuilearn = in.getDoubleOr("mangekyousharingankakashikamuilearn", 0);
			mangekyousharinganobitokamuirelease = in.getDoubleOr("mangekyousharinganobitokamuirelease", 0);
			mangekyousharinganobitokamuilearn = in.getDoubleOr("mangekyousharinganobitokamuilearn", 0);
			mangekyousharinganobitokamuitechnique = in.getDoubleOr("mangekyousharinganobitokamuitechnique", 0);
			mangekyousharinganobitosusanorelease = in.getDoubleOr("mangekyousharinganobitosusanorelease", 0);
			mangekyousharinganobitosusanolearn = in.getDoubleOr("mangekyousharinganobitosusanolearn", 0);
			KamuiPhantomPhase = in.getBooleanOr("KamuiPhantomPhase", false);
			Eternal_Mangekyou_Sharingan = in.getBooleanOr("Eternal_Mangekyou_Sharingan", false);
			Mangekyou_Sharingan_Technique_Use = in.getDoubleOr("Mangekyou_Sharingan_Technique_Use", 0);
			Mangekyou_Sharingan_Technique_Use_Max = in.getDoubleOr("Mangekyou_Sharingan_Technique_Use_Max", 0);
			mangekyousharinganmadarasusanorelease = in.getDoubleOr("mangekyousharinganmadarasusanorelease", 0);
			mangekyousharinganmadarasusanolearn = in.getDoubleOr("mangekyousharinganmadarasusanolearn", 0);
			mangekyousharinganshisuisusanorelease = in.getDoubleOr("mangekyousharinganshisuisusanorelease", 0);
			mangekyousharinganshisuisusanolearn = in.getDoubleOr("mangekyousharinganshisuisusanolearn", 0);
			gunbaicopy = in.read("gunbaicopy", ItemStack.OPTIONAL_CODEC).orElse(ItemStack.EMPTY);
			LevelStatMaxChange = in.getDoubleOr("LevelStatMaxChange", 100.0);
			inuzuka_mode = in.getDoubleOr("inuzuka_mode", 0);
			custom_jutsu = in.getStringOr("custom_jutsu", "");
			weapon_arts = in.getStringOr("weapon_arts", "");
			learned_jutsu = in.getStringOr("learned_jutsu", "");
			learned_jutsu_migrated = in.getBooleanOr("learned_jutsu_migrated", false);
			mimic_sneak = in.getBooleanOr("mimic_sneak", false);
		}

		/** Queues a sync to the owning client; sent once at the end of the current server tick. */
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer player) {
				if (net.mcreator.narutoshippudenmod.core.TickProfiler.ENABLED && !PENDING_SYNC.contains(player))
					net.mcreator.narutoshippudenmod.core.TickProfiler.syncFrom(new Throwable().getStackTrace());
				PENDING_SYNC.add(player);
			}
		}
	}

	/** Players whose variables changed this tick; flushed once at the end of the server tick. */
	private static final Set<ServerPlayer> PENDING_SYNC = new LinkedHashSet<>();

	@net.neoforged.fml.common.EventBusSubscriber(modid = NarutoShippudenMod.MODID)
	public static class Events {
		@SubscribeEvent
		public static void flushPendingSyncs(ServerTickEvent.Post event) {
			if (PENDING_SYNC.isEmpty())
				return;
			for (ServerPlayer player : PENDING_SYNC) {
				if (!player.hasDisconnected()) {
					sendTo(player);
					sendVisible(player);
					net.mcreator.narutoshippudenmod.core.TickProfiler.syncs++;
				}
			}
			PENDING_SYNC.clear();
		}

		/** A player coming into view: what they look like (eyes, Susanoo, iron sand, wings...). */
		@SubscribeEvent
		public static void onStartTracking(PlayerEvent.StartTracking event) {
			if (event.getTarget() instanceof ServerPlayer seen && event.getEntity() instanceof ServerPlayer viewer)
				PacketDistributor.sendToPlayer(viewer, new SeenPayload(seen.getId(), visible(seen)));
		}

		@SubscribeEvent
		public static void onLogout(PlayerEvent.PlayerLoggedOutEvent event) {
			LAST_VISIBLE.remove(event.getEntity().getUUID());
		}

		@SubscribeEvent
		public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				sendTo(player);
		}

		@SubscribeEvent
		public static void onRespawn(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				sendTo(player);
		}

		@SubscribeEvent
		public static void onChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				sendTo(player);
		}
	}

	private static void sendTo(ServerPlayer player) {
		TagValueOutput out = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, player.registryAccess());
		get(player).write(out);
		PacketDistributor.sendToPlayer(player, new SyncPayload(out.buildResult()));
	}

	/**
	 * The variables other players' clients need to draw this player (the renderers read them on every player, not only their own):
	 * eyes and the eye shapes chosen, the Mangekyou and its Susanoo, jutsu forms (iron sand, Akimichi tank and wings, Passing Fang,
	 * Kamui phasing, the water blob...), restraint and possession. Without them another player looks unchanged.
	 */
	private static final Set<String> VISIBLE = Set.of("sharingan", "sharinganactivate", "SharinganKakashi", "SharinganShimura", "shimura_active",
			"shimurareleaselogic", "byakugan", "byakuganactivate", "rinnegan", "rinneganactivate", "tenseigan", "tenseiganactivate", "ketsuryugan",
			"ketsuryuganactivate", "isshikidojutsu", "isshikidojutsuactivate", "MangekyouSharinganActivate", "MangekyouSharinganItachi",
			"MangekyouSharinganKakashi", "MangekyouSharinganMadara", "MangekyouSharinganObito", "MangekyouSharinganSasuke", "MangekyouSharinganShisui",
			"mangekyousharingansusanostage", "dojutsusharingan", "dojutsums", "dojutsubyakugan", "dojutsurinnegan", "dojutsutenseigan",
			"dojutsuketsuryugan", "dojutsuisshiki", "magnet_coat", "HumanBulletTank", "SpikedHumanBulletTank", "ButterflyMode", "ButterFlyModeColor",
			"KamuiPhantomPhase", "PassingFang", "DanceOfTheLarch", "EightTrigramsPalmsRevolvingHeaven", "InsectJarTechnique", "deathgod", "ice_mirror",
			"waterblob", "restrained", "possessing", "mimic_sneak");
	/** What each player's watchers were last sent, so they get a packet only when something they can see changed. */
	private static final java.util.Map<java.util.UUID, CompoundTag> LAST_VISIBLE = new java.util.HashMap<>();

	private static CompoundTag visible(ServerPlayer player) {
		TagValueOutput out = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, player.registryAccess());
		get(player).write(out);
		CompoundTag all = out.buildResult(), seen = new CompoundTag();
		for (String key : VISIBLE)
			if (all.get(key) != null)
				seen.put(key, all.get(key));
		return seen;
	}

	private static void sendVisible(ServerPlayer player) {
		CompoundTag seen = visible(player);
		if (seen.equals(LAST_VISIBLE.put(player.getUUID(), seen)))
			return;
		PacketDistributor.sendToPlayersTrackingEntity(player, new SeenPayload(player.getId(), seen));
	}

	/** Another player's visible variables (see VISIBLE), for this client to draw them. */
	public record SeenPayload(int entity, CompoundTag data) implements CustomPacketPayload {
		public static final Type<SeenPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(NarutoShippudenMod.MODID, "seen_player_variables"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SeenPayload> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, SeenPayload::entity,
				ByteBufCodecs.COMPOUND_TAG, SeenPayload::data, SeenPayload::new);

		@Override
		public Type<SeenPayload> type() {
			return TYPE;
		}
	}

	private static void handleSeen(SeenPayload payload, IPayloadContext context) {
		context.enqueueWork(() -> {
			Player self = context.player();
			if (self.level().getEntity(payload.entity()) instanceof Player other && other != self)
				get(other).read(TagValueInput.create(ProblemReporter.DISCARDING, self.registryAccess(), payload.data()));
		});
	}

	public record SyncPayload(CompoundTag data) implements CustomPacketPayload {
		public static final Type<SyncPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath(NarutoShippudenMod.MODID, "player_variables"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SyncPayload> CODEC = StreamCodec.composite(ByteBufCodecs.COMPOUND_TAG,
				SyncPayload::data, SyncPayload::new);

		@Override
		public Type<SyncPayload> type() {
			return TYPE;
		}
	}

	private static void registerPayloads(RegisterPayloadHandlersEvent event) {
		event.registrar("1").playToClient(SyncPayload.TYPE, SyncPayload.CODEC, NarutoShippudenModVariables::handleSync)
				.playToClient(SeenPayload.TYPE, SeenPayload.CODEC, NarutoShippudenModVariables::handleSeen);
	}

	private static void handleSync(SyncPayload payload, IPayloadContext context) {
		context.enqueueWork(() -> {
			Player player = context.player();
			get(player).read(TagValueInput.create(ProblemReporter.DISCARDING, player.registryAccess(), payload.data()));
		});
	}
}
