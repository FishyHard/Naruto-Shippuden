package net.mcreator.narutoshippudenmod.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import net.mcreator.narutoshippudenmod.procedures.CheatProcedures.CheatGUIProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.InfonarutoshippudenCommandExecutedProcedure;
import net.mcreator.narutoshippudenmod.procedures.MissionAndCommandProcedures.PatreonKitCommandCommandExecutedProcedure;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public final class ModCommands {
	private ModCommands() {
	}

	@Mod.EventBusSubscriber
	public static class InfonarutoshippudenCommand {
		@SubscribeEvent
		public static void registerCommands(RegisterCommandsEvent event) {
			event.getDispatcher().register(LiteralArgumentBuilder.<CommandSource>literal("infonarutoshippuden")

					.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
						ServerWorld world = arguments.getSource().getWorld();
						double x = arguments.getSource().getPos().getX();
						double y = arguments.getSource().getPos().getY();
						double z = arguments.getSource().getPos().getZ();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getHorizontalFacing();
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
						ServerWorld world = arguments.getSource().getWorld();
						double x = arguments.getSource().getPos().getX();
						double y = arguments.getSource().getPos().getY();
						double z = arguments.getSource().getPos().getZ();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getHorizontalFacing();
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

	@Mod.EventBusSubscriber
	public static class NarutoShippudenCheatCommand {
		@SubscribeEvent
		public static void registerCommands(RegisterCommandsEvent event) {
			event.getDispatcher().register(LiteralArgumentBuilder.<CommandSource>literal("narutoshippudencheat")

					.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
						ServerWorld world = arguments.getSource().getWorld();
						double x = arguments.getSource().getPos().getX();
						double y = arguments.getSource().getPos().getY();
						double z = arguments.getSource().getPos().getZ();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getHorizontalFacing();
						HashMap<String, String> cmdparams = new HashMap<>();
						int index = -1;
						for (String param : arguments.getInput().split("\\s+")) {
							if (index >= 0)
								cmdparams.put(Integer.toString(index), param);
							index++;
						}

						CheatGUIProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						return 0;
					})).executes(arguments -> {
						ServerWorld world = arguments.getSource().getWorld();
						double x = arguments.getSource().getPos().getX();
						double y = arguments.getSource().getPos().getY();
						double z = arguments.getSource().getPos().getZ();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getHorizontalFacing();
						HashMap<String, String> cmdparams = new HashMap<>();
						int index = -1;
						for (String param : arguments.getInput().split("\\s+")) {
							if (index >= 0)
								cmdparams.put(Integer.toString(index), param);
							index++;
						}

						CheatGUIProcedure.executeProcedure(Stream
								.of(new AbstractMap.SimpleEntry<>("world", world), new AbstractMap.SimpleEntry<>("x", x),
										new AbstractMap.SimpleEntry<>("y", y), new AbstractMap.SimpleEntry<>("z", z),
										new AbstractMap.SimpleEntry<>("entity", entity))
								.collect(HashMap::new, (_m, _e) -> _m.put(_e.getKey(), _e.getValue()), Map::putAll));
						return 0;
					}));
		}
	}

	@Mod.EventBusSubscriber
	public static class PatreonKitCommandCommand {
		@SubscribeEvent
		public static void registerCommands(RegisterCommandsEvent event) {
			event.getDispatcher().register(LiteralArgumentBuilder.<CommandSource>literal("Patreon")

					.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(arguments -> {
						ServerWorld world = arguments.getSource().getWorld();
						double x = arguments.getSource().getPos().getX();
						double y = arguments.getSource().getPos().getY();
						double z = arguments.getSource().getPos().getZ();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getHorizontalFacing();
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
						ServerWorld world = arguments.getSource().getWorld();
						double x = arguments.getSource().getPos().getX();
						double y = arguments.getSource().getPos().getY();
						double z = arguments.getSource().getPos().getZ();
						Entity entity = arguments.getSource().getEntity();
						if (entity == null)
							entity = FakePlayerFactory.getMinecraft(world);
						Direction direction = entity.getHorizontalFacing();
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
