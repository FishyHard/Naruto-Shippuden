package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.EarthWallBlock;
import net.mcreator.narutoshippudenmod.block.ModBlocks.WaterwallBlock;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.EarthGolemEntity;
import net.mcreator.narutoshippudenmod.item.DnaItems.EarthDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.FireDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.LightningDNAItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WaterDNAReleaseItem;
import net.mcreator.narutoshippudenmod.item.DnaItems.WindDNAItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.GreatFireDragonItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.EarthReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.FireReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.LightningReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WaterReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WindReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.EarthReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.FireReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.LightningReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.WaterReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.ReleaseTechniqueItems.WindReleaseTechniqueItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.minecraft.core.registries.BuiltInRegistries;

public final class NatureReleaseProcedures {
	private NatureReleaseProcedures() {
	}

}
