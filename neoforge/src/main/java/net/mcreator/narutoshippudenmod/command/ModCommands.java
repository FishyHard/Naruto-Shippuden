package net.mcreator.narutoshippudenmod.command;

import net.neoforged.fml.common.EventBusSubscriber;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatGUIProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.InfonarutoshippudenCommandExecutedProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.PatreonKitCommandCommandExecutedProcedure;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.util.FakePlayerFactory;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

public final class ModCommands {
	private ModCommands() {
	}

	@EventBusSubscriber(modid = "naruto_shippuden")
	public static class InfonarutoshippudenCommand {
		@SubscribeEvent
		public static void registerCommands(RegisterCommandsEvent event) {
			event.getDispatcher().register(LiteralArgumentBuilder.<CommandSourceStack>literal("infonarutoshippuden")

					.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
						ServerLevel world = arguments.getSource().getLevel();
						double x = arguments.getSource().getPosition().x();
						double y = arguments.getSource().getPosition().y();
						double z = arguments.getSource().getPosition().z();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getDirection();
						HashMap<String, String> cmdparams = new HashMap<>();
						int index = -1;
						for (String param : arguments.getInput().split("\\s+")) {
							if (index >= 0)
								cmdparams.put(Integer.toString(index), param);
							index++;
						}

						InfonarutoshippudenCommandExecutedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						return 0;
					})).executes(arguments -> {
						ServerLevel world = arguments.getSource().getLevel();
						double x = arguments.getSource().getPosition().x();
						double y = arguments.getSource().getPosition().y();
						double z = arguments.getSource().getPosition().z();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getDirection();
						HashMap<String, String> cmdparams = new HashMap<>();
						int index = -1;
						for (String param : arguments.getInput().split("\\s+")) {
							if (index >= 0)
								cmdparams.put(Integer.toString(index), param);
							index++;
						}

						InfonarutoshippudenCommandExecutedProcedure.executeProcedure(Stream.of(new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						return 0;
					}));
		}
	}

	@EventBusSubscriber(modid = "naruto_shippuden")
	public static class PatreonKitCommandCommand {
		@SubscribeEvent
		public static void registerCommands(RegisterCommandsEvent event) {
			event.getDispatcher().register(LiteralArgumentBuilder.<CommandSourceStack>literal("Patreon")

					.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
						ServerLevel world = arguments.getSource().getLevel();
						double x = arguments.getSource().getPosition().x();
						double y = arguments.getSource().getPosition().y();
						double z = arguments.getSource().getPosition().z();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getDirection();
						HashMap<String, String> cmdparams = new HashMap<>();
						int index = -1;
						for (String param : arguments.getInput().split("\\s+")) {
							if (index >= 0)
								cmdparams.put(Integer.toString(index), param);
							index++;
						}

						PatreonKitCommandCommandExecutedProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						return 0;
					})).executes(arguments -> {
						ServerLevel world = arguments.getSource().getLevel();
						double x = arguments.getSource().getPosition().x();
						double y = arguments.getSource().getPosition().y();
						double z = arguments.getSource().getPosition().z();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getDirection();
						HashMap<String, String> cmdparams = new HashMap<>();
						int index = -1;
						for (String param : arguments.getInput().split("\\s+")) {
							if (index >= 0)
								cmdparams.put(Integer.toString(index), param);
							index++;
						}

						PatreonKitCommandCommandExecutedProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						return 0;
					}));
		}
	}
}
