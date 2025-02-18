package net.mcreator.narutoshippudenmod.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.DamageSource;
import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;

public class TreeBindFlourishingBurialOnEffectActiveTickProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure TreeBindFlourishingBurialOnEffectActiveTick!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.RESISTANCE, (int) 3, (int) 10, (false), (false)));
		entity.getPersistentData().putDouble("hurt", (entity.getPersistentData().getDouble("hurt") + 1));
		if (entity.getPersistentData().getDouble("hurt") % 3 == 0) {
			entity.attackEntityFrom(DamageSource.IN_WALL, (float) 1);
		}
		entity.setMotion(0, 0, 0);
		entity.getPersistentData().putDouble("closer", (entity.getPersistentData().getDouble("closer") - 0.04));
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/execute as @e[tag=treecore] at @s run summon armor_stand ^ ^ ^"
							+ new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("closer"))
							+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielol\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_log\",Count:1b}]}"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/execute as @e[tag=treecorereverse] at @s run summon armor_stand ^ ^ ^"
							+ new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("closer"))
							+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielol\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_log\",Count:1b}]}"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/execute as @e[tag=treecorereversetwo] at @s run summon armor_stand ^ ^ ^"
							+ new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("closer"))
							+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielol\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_log\",Count:1b}]}"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					("/execute as @e[tag=treecoretwo] at @s run summon armor_stand ^ ^ ^"
							+ new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("closer"))
							+ " {NoGravity:1b,Silent:1b,Marker:1b,Invisible:1b,Invulnerable:1b,Tags:[\"dielol\"],PersistenceRequired:1b,Rotation:[35F,45F],Pose:{Head:[0f,35f,0f]},ArmorItems:[{},{},{},{id:\"minecraft:oak_log\",Count:1b}]}"));
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=treecore] at @s run tp @s ~ ~0.13 ~ ~15 ~");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=treecorereverse] at @s run tp @s ~ ~0.13 ~ ~-15 ~");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=treecorereversetwo] at @s run tp @s ~ ~0.13 ~ ~15 ~");
		}
		if (world instanceof ServerWorld) {
			((World) world).getServer().getCommandManager().handleCommand(
					new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
							new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
					"/execute as @e[tag=treecoretwo] at @s run tp @s ~ ~0.13 ~ ~-15 ~");
		}
	}
}
