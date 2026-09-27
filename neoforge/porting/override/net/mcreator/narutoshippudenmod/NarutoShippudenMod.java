package net.mcreator.narutoshippudenmod;

import net.mcreator.narutoshippudenmod.compat.ModNetwork;
import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.FMLEnvironment;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.RegisterEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(NarutoShippudenMod.MODID)
public class NarutoShippudenMod {
	public static final String MODID = "naruto_shippuden";
	public static final Logger LOGGER = LogManager.getLogger(NarutoShippudenMod.class);
	public static final ModNetwork.Channel PACKET_HANDLER = new ModNetwork.Channel();
	public static IEventBus MOD_BUS;
	public NarutoShippudenModElements elements;

	public NarutoShippudenMod(IEventBus modBus, ModContainer container) {
		MOD_BUS = modBus;
		NarutoShippudenModVariables.register(modBus);
		Registration.register(modBus);
		net.mcreator.narutoshippudenmod.core.EntityScale.register(modBus);
		net.mcreator.narutoshippudenmod.potion.ModEffects.register();
		net.mcreator.narutoshippudenmod.particle.ModParticles.register();
		net.mcreator.narutoshippudenmod.world.structure.KamuiTowerStructures.register();
		elements = new NarutoShippudenModElements();
		modBus.addListener(this::registerAll);
		modBus.addListener(this::init);
		modBus.addListener(ModNetwork::registerPayloads);
		if (FMLEnvironment.getDist().isClient())
			modBus.addListener(this::clientLoad);
		NeoForge.EVENT_BUS.addListener(this::serverLoad);
	}

	private void registerAll(RegisterEvent event) {
		event.register(Registries.BLOCK, helper -> elements.blocks.forEach(s -> Registration.registerNamed(Registries.BLOCK, helper, s)));
		event.register(Registries.ITEM, helper -> elements.items.forEach(s -> Registration.registerNamed(Registries.ITEM, helper, s)));
		event.register(Registries.ENTITY_TYPE, helper -> elements.entities.forEach(s -> Registration.registerNamed(Registries.ENTITY_TYPE, helper, s)));
		event.register(Registries.SOUND_EVENT, helper -> NarutoShippudenModElements.sounds.forEach(helper::register));
	}

	private void init(FMLCommonSetupEvent event) {
		elements.getElements().forEach(element -> element.init(event));
	}

	private void clientLoad(FMLClientSetupEvent event) {
		elements.getElements().forEach(element -> element.clientLoad(event));
	}

	private void serverLoad(ServerStartingEvent event) {
		elements.getElements().forEach(element -> element.serverLoad(event));
	}
}
