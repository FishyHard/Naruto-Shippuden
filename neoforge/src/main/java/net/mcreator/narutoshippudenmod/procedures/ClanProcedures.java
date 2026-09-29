package net.mcreator.narutoshippudenmod.procedures;

import net.mcreator.narutoshippudenmod.compat.Compat;
import net.minecraft.util.RandomSource;
import net.mcreator.narutoshippudenmod.compat.Registration;
import net.mcreator.narutoshippudenmod.compat.ModArrow;
import net.neoforged.neoforge.event.tick.ServerTickEvent;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.block.ModBlocks.NaraShadowBlock;
import net.mcreator.narutoshippudenmod.core.EntityScale;
import net.mcreator.narutoshippudenmod.entity.JutsuEntities.ShadowCloneEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.AsumaEntity;
import net.mcreator.narutoshippudenmod.entity.NpcEntities.ShikamaruEntity;
import net.mcreator.narutoshippudenmod.entity.SummonEntities.AkamaruEntity;
import net.mcreator.narutoshippudenmod.item.ClanItems.AburameReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.AkimichiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ChinoikeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ClanResetStatItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.FumaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.FumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.HozukiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.HyugaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.IburiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.InuzukaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.LeeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.NaraReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.SarutobiReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.ToroiUniqueFumaShurikenClanItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.TsuchigumoReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.UchihaReleaseItem;
import net.mcreator.narutoshippudenmod.item.ClanItems.UzumakiReleaseItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.DrowningWaterBlobTechniqueItem;
import net.mcreator.narutoshippudenmod.item.JutsuProjectileItems.WaterGunItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.BoneReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.ChakraNatureResetItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.EarthReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.FireReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.IceReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.LightningReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.MagnetReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.SmokeReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.StormReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WaterReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WindReleaseItem;
import net.mcreator.narutoshippudenmod.item.ReleaseItems.WoodReleaseItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ChakraPaperItem;
import net.mcreator.narutoshippudenmod.item.StuffItems.ClanPaperItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.AburameReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.AkimichiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.FumaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.HozukiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.HyugaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.InuzukaReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.LeeReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.SarutobiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.ShadowCloneTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.SharinganReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.TsuchigumoReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.TechniqueItems.UzumakiReleaseTechniqueItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.FlyingThunderGodKunaiItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiAxeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiBatItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiBladeItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiChoppingSwordItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiHammerItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiKatanaItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiSpearItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.OtsutsukiSwordItem;
import net.mcreator.narutoshippudenmod.item.WeaponItems.WhiteLightChakraSabreItem;
import net.mcreator.narutoshippudenmod.particle.ModParticles.AshParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.BlueSteamParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.FlameParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.GreenSteamParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.RedSteamParticle;
import net.mcreator.narutoshippudenmod.particle.ModParticles.SmokeParticle;
import net.mcreator.narutoshippudenmod.potion.ModEffects.CoercionSharinganEffectPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.DespawnPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.DrowningPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesBluePotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen2PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen3PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen4PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen5PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreen6PotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesGreenPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.GatesRedPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.HyugaPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.IceMirrorEffectPotionEffect;
import net.mcreator.narutoshippudenmod.potion.ModEffects.InuzukaAkamaruPotionEffect;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.zombie.Husk;
import net.minecraft.world.entity.monster.illager.Illusioner;
import net.minecraft.world.entity.monster.illager.Pillager;
import net.minecraft.world.entity.monster.skeleton.Skeleton;
import net.minecraft.world.entity.monster.illager.Vindicator;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.entity.monster.zombie.ZombieVillager;
import net.minecraft.world.entity.monster.zombie.ZombifiedPiglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.AABB;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.server.level.ServerLevel;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.bus.api.SubscribeEvent;
import net.minecraft.core.registries.BuiltInRegistries;

public final class ClanProcedures {
	private ClanProcedures() {
	}








	public static class ChakraNatureResetRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraNatureResetRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.firereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.waterreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.windreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.lightningreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.earthreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(ChakraNatureResetItem.block);
				((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
						((Player) entity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class ChakraPaperRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ChakraPaperRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double chakrapaperrandom = 0;
			chakrapaperrandom = (Mth.nextInt(RandomSource.create(), 1, 18));
			if (chakrapaperrandom == 1) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 2) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 3) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 4) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 5) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 6) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 7) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 8) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 9) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 10) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 11) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 12) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 13) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 14) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 15) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 16) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 17) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else if (chakrapaperrandom == 18) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WaterReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LightningReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(WindReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(EarthReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FireReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.windreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.earthreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.lightningreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.firereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(ChakraPaperItem.block);
				((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
						((Player) entity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class ClanPaperRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ClanPaperRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			double clanpaperrandom = 0;
			clanpaperrandom = (Mth.nextInt(RandomSource.create(), 1, 14));
			if (clanpaperrandom == 1) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(UchihaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.uchihareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 120);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+25 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+15 Genjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+120 IQ"));
				}
			} else if (clanpaperrandom == 2) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(UzumakiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.uzumakireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).kinjutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.kinjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 120);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 250);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+25 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+25 Kinjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+120 IQ"));
				}
			} else if (clanpaperrandom == 3) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(HyugaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.hyugareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+115 IQ"));
				}
			} else if (clanpaperrandom == 4) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(IburiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.iburireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 5) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(InuzukaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.inuzukareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 85);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Summoning"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+85 IQ"));
				}
			} else if (clanpaperrandom == 6) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(LeeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.leereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).taijutsu + 25);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.taijutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 115);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+25 Taijutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+115 IQ"));
				}
			} else if (clanpaperrandom == 7) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(NaraReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.narareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 210);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+210 IQ"));
				}
			} else if (clanpaperrandom == 8) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(TsuchigumoReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.tsuchigumoreleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 9) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(AburameReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.aburamereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).summoning + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.summoning = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 105);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Summoning"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+105 IQ"));
				}
			} else if (clanpaperrandom == 10) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(AkimichiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.akimichireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+100 IQ"));
				}
			} else if (clanpaperrandom == 11) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(ChinoikeReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.chinoikereleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).genjutsu + 5);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.genjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 95);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+5 Genjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+95 IQ"));
				}
			} else if (clanpaperrandom == 12) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(SarutobiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 15);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 105);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 150);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.sarutobireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+15 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+105 IQ"));
				}
			} else if (clanpaperrandom == 13) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(FumaReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.fumareleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+90 IQ"));
				}
			} else if (clanpaperrandom == 14) {
				if (entity instanceof Player) {
					ItemStack _setstack = new ItemStack(HozukiReleaseItem.block);
					_setstack.setCount((int) 1);
					Compat.giveItemToPlayer(((Player) entity), _setstack);
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ninjutsu + 10);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ninjutsu = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).IQ + 90);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.IQ = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (NarutoShippudenModVariables.get(entity).ChakraMax + 100);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.ChakraMax = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.hozukireleaselogic = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+10 Ninjutsu"));
				}
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("+90 IQ"));
				}
			}
			if (entity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(ClanPaperItem.block);
				((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
						((Player) entity).inventoryMenu.getCraftSlots());
			}
		}
	}

	public static class ClanResetRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ClanResetRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.uchihareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.uzumakireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hyugareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.leereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.otsutsukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hatakereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.akimichireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.narareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.namikazereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.aburamereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.inuzukareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.tsuchigumoreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.iburireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.chinoikereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.yukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kazekagereleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.tenroreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.shimurareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.senjureleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kuramareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.sarutobireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.fumareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hoshigakireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.kaguyareleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.hozukireleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.izunoreleaselogic = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if (entity instanceof Player) {
				ItemStack _stktoremove = new ItemStack(ClanResetStatItem.block);
				((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
						((Player) entity).inventoryMenu.getCraftSlots());
			}
		}
	}




	public static class DrowningEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DrowningEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof Creeper
					|| entity instanceof Husk || entity instanceof Illusioner || entity instanceof Piglin
					|| entity instanceof PiglinBrute || entity instanceof Pillager || entity instanceof Skeleton
					|| entity instanceof Villager || entity instanceof Vindicator || entity instanceof Witch
					|| entity instanceof Zombie || entity instanceof ZombieVillager || entity instanceof ZombifiedPiglin) {
				entity.getPersistentData().putBoolean("waterblob", (false));
				entity.setAirSupply((int) 1);
			}
			if (entity instanceof Player) {
				{
					boolean _setval = (false);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterblob = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				entity.setAirSupply((int) 1);
			}
		}
	}

	public static class DrowningOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure DrowningOnEffectActiveTick!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			entity.setAirSupply((int) 0);
			entity.hurt(Compat.damage().drown(), (float) 1);
		}
	}

	public static class DrowningWaterBlobTechniqueProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency entity for procedure DrowningWaterBlobTechniqueProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof Creeper
					|| entity instanceof Husk || entity instanceof Illusioner || entity instanceof Piglin
					|| entity instanceof PiglinBrute || entity instanceof Pillager || entity instanceof Skeleton
					|| entity instanceof Villager || entity instanceof Vindicator || entity instanceof Witch
					|| entity instanceof Zombie || entity instanceof ZombieVillager || entity instanceof ZombifiedPiglin) {
				entity.getPersistentData().putBoolean("waterblob", (true));
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
			}
			if (!(entity instanceof AsumaEntity.CustomEntity || entity instanceof ShikamaruEntity.CustomEntity || entity instanceof Creeper
					|| entity instanceof Husk || entity instanceof Illusioner || entity instanceof Piglin
					|| entity instanceof PiglinBrute || entity instanceof Pillager || entity instanceof Skeleton
					|| entity instanceof Villager || entity instanceof Vindicator || entity instanceof Witch
					|| entity instanceof Zombie || entity instanceof ZombieVillager || entity instanceof ZombifiedPiglin
					|| entity instanceof Player)) {
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
			}
			if (entity instanceof Player) {
				{
					boolean _setval = (true);
					NarutoShippudenModVariables.ifPresent(entity, capability -> {
						capability.waterblob = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof LivingEntity)
					((LivingEntity) entity).addEffect(new MobEffectInstance(DrowningPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
			}
		}
	}







	public static class GatesBlueOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure GatesBlueOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure GatesBlueOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure GatesBlueOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure GatesBlueOnEffectActiveTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(BlueSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(BlueSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
			}
		}
	}

	public static class GatesGreen2EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen2EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1000);
			}
		}
	}

	public static class GatesGreen3EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen3EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1250);
			}
		}
	}

	public static class GatesGreen4EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen4EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1500);
			}
		}
	}

	public static class GatesGreen5EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen5EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 1750);
			}
		}
	}

	public static class GatesGreen6EffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesGreen6EffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			if ((NarutoShippudenModVariables.get(entity).rank).equals("Academy Student")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 3000);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Genin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2750);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Chunin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2500);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Jonin")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2250);
			} else if ((NarutoShippudenModVariables.get(entity).rank).equals("Kage")) {
				if (entity instanceof Player)
					((Player) entity).getCooldowns().addCooldown(new ItemStack(LeeReleaseTechniqueItem.block), (int) 2000);
			}
		}
	}

	public static class GatesGreenOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure GatesGreenOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure GatesGreenOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure GatesGreenOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure GatesGreenOnEffectActiveTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(GreenSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(GreenSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
			}
		}
	}

	public static class GatesRedEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure GatesRedEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			String death = "";
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.SPEED);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.STRENGTH);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.JUMP_BOOST);
			}
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).removeEffect(MobEffects.RESISTANCE);
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.gateslee = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			entity.hurt(Compat.damage().generic(), (float) 99999);
		}
	}

	public static class GatesRedOnEffectActiveTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure GatesRedOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure GatesRedOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure GatesRedOnEffectActiveTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure GatesRedOnEffectActiveTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(RedSteamParticle.particle, x, y, z, (int) 7, 0, 0, 0, 0.05);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(RedSteamParticle.particle, x, (y + 1), z, (int) 7, 0, 0, 0, 0.05);
			}
		}
	}






	public static class HyugaEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure HyugaEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.EightTrigramsPalmsRevolvingHeaven = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.InsectJarTechnique = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}




	public static class IburiReleaseRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure IburiReleaseRightclicked!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (NarutoShippudenModVariables.get(entity).iburi_release == 0) {
				if (NarutoShippudenModVariables.get(entity).jp >= 5) {
					if (entity instanceof Player) {
						ItemStack _setstack = new ItemStack(SmokeReleaseItem.block);
						_setstack.setCount((int) 1);
						Compat.giveItemToPlayer(((Player) entity), _setstack);
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).jp - 5);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.jp = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).iburi_release + 1);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.iburi_release = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("-5 JP"));
					}
					{
						boolean _setval = (true);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.smokereleaselogic = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player) {
						ItemStack _stktoremove = new ItemStack(IburiReleaseItem.block);
						((Player) entity).getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), false, (int) 1,
								((Player) entity).inventoryMenu.getCraftSlots());
					}
				} else if (NarutoShippudenModVariables.get(entity).jp <= 4) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough JP"));
					}
				}
			}
		}
	}


	public static class InuzukaAkamaruEffectExpiresProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure InuzukaAkamaruEffectExpires!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			{
				boolean _setval = (false);
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.akamaru_summon = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				NarutoShippudenModVariables.ifPresent(entity, capability -> {
					capability.inuzuka_mode = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}













	public static class NaraReleaseTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {

		}
	}

	public static class NaraShadowUpdateTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure NaraShadowUpdateTick!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure NaraShadowUpdateTick!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure NaraShadowUpdateTick!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure NaraShadowUpdateTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					Registration.listen(NeoForge.EVENT_BUS, this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(ServerTickEvent.Post event) {
					if (true) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == NaraShadowBlock.block) {
						world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
					}
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 5);
		}
	}



	public static class OtsutsukiToolsSwitchProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure OtsutsukiToolsSwitch!");
				return;
			}
			if (dependencies.get("itemstack") == null) {
				if (!dependencies.containsKey("itemstack"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure OtsutsukiToolsSwitch!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
			ItemStack tool = ItemStack.EMPTY;
			tool = itemstack;
			if (entity.isShiftKeyDown()) {
				if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 0) {
					{
						double _setval = 1;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Otsutsuki Axe"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 1) {
					{
						double _setval = 2;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Otsutsuki Bat"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 2) {
					{
						double _setval = 3;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Otsutsuki Blade"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 3) {
					{
						double _setval = 4;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Otsutsuki Chopping Sword"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 4) {
					{
						double _setval = 5;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Otsutsuki Hammer"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 5) {
					{
						double _setval = 6;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Otsutsuki Katana"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 6) {
					{
						double _setval = 7;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Otsutsuki Spear"));
					}
				} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 7) {
					{
						double _setval = 0;
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.otsutsuki_tool = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Otsutsuki Sword"));
					}
				}
			} else if (!entity.isShiftKeyDown()) {
				if (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getMainHandItem() : ItemStack.EMPTY).getItem() == (tool).getItem()) {
					if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 0) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiSwordItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 1) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiAxeItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 2) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiBatItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 3) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiBladeItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 4) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiChoppingSwordItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 5) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiHammerItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 6) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiKatanaItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					} else if (NarutoShippudenModVariables.get(entity).otsutsuki_tool == 7) {
						if (entity instanceof LivingEntity) {
							ItemStack _setstack = new ItemStack(OtsutsukiSpearItem.block);
							_setstack.setCount((int) 1);
							((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (entity instanceof ServerPlayer)
								((ServerPlayer) entity).getInventory().setChanged();
						}
					}
				}
			}
		}
	}




	public static class ShadowCloneEntityDiesProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneEntityDies!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneEntityDies!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (world instanceof Level && !world.isClientSide()) {
				((Level) world).playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
						Compat.sound("naruto_shippuden:clone_death"),
						SoundSource.NEUTRAL, (float) 1, (float) 1);
			} else {
				((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()),
						Compat.sound("naruto_shippuden:clone_death"),
						SoundSource.NEUTRAL, (float) 1, (float) 1, false);
			}
			if (world instanceof ServerLevel) {
				((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, (entity.getX()), (entity.getY() + 1), (entity.getZ()), (int) 3, 0, 1, 0,
						0);
			}
		}
	}

	public static class ShadowCloneOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneOnEntityTickUpdate!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			Entity playerowner = null;
			playerowner = (entity instanceof TamableAnimal) ? ((TamableAnimal) entity).getOwner() : null;
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (15 / 2d), y - (15 / 2d), z - (15 / 2d), x + (15 / 2d), y + (15 / 2d), z + (15 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if (playerowner == entityiterator) {
							if (entity instanceof LivingEntity) {
								if (entity instanceof Player)
									((Player) entity).setItemSlot(EquipmentSlot.FEET,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.FEET)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemSlot(EquipmentSlot.FEET,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.FEET)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof Player)
									((Player) entity).setItemSlot(EquipmentSlot.LEGS,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.LEGS)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemSlot(EquipmentSlot.LEGS,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.LEGS)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof Player)
									((Player) entity).setItemSlot(EquipmentSlot.CHEST,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.CHEST)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemSlot(EquipmentSlot.CHEST,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.CHEST)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								if (entity instanceof Player)
									((Player) entity).setItemSlot(EquipmentSlot.HEAD,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.HEAD)
													: ItemStack.EMPTY));
								else
									((LivingEntity) entity).setItemSlot(EquipmentSlot.HEAD,
											((playerowner instanceof LivingEntity)
													? ((LivingEntity) playerowner).getItemBySlot(EquipmentSlot.HEAD)
													: ItemStack.EMPTY));
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = ((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getMainHandItem()
										: ItemStack.EMPTY);
								_setstack.setCount((int) ((((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getMainHandItem()
										: ItemStack.EMPTY)).getCount()));
								((LivingEntity) entity).setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
							if (entity instanceof LivingEntity) {
								ItemStack _setstack = ((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getOffhandItem()
										: ItemStack.EMPTY);
								_setstack.setCount((int) ((((playerowner instanceof LivingEntity)
										? ((LivingEntity) playerowner).getOffhandItem()
										: ItemStack.EMPTY)).getCount()));
								((LivingEntity) entity).setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (entity instanceof ServerPlayer)
									((ServerPlayer) entity).getInventory().setChanged();
							}
						}
					}
				}
			}
		}
	}

	public static class ShadowCloneOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneOnInitialEntitySpawn!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					Compat.runCommand(_ent, "/data merge entity @s {HandItems:[{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b}],HandDropChances:[0.000F,0.000F]}");
				}
			}
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.level().getServer() != null) {
					Compat.runCommand(_ent, "/data merge entity @s {ArmorItems:[{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b},{id:\"minecraft:air\",Count:1b}],ArmorDropChances:[0.000F,0.000F,0.000F,0.000F]}");
				}
			}
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					Registration.listen(NeoForge.EVENT_BUS, this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(ServerTickEvent.Post event) {
					if (true) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (entity.isAlive()) {
						if (world instanceof Level && !world.isClientSide()) {
							((Level) world)
									.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()),
											(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
													.getValue(Identifier.parse("naruto_shippuden:clone_death")),
											SoundSource.NEUTRAL, (float) 1, (float) 1);
						} else {
							((Level) world).playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()),
									(net.minecraft.sounds.SoundEvent) BuiltInRegistries.SOUND_EVENT
											.getValue(Identifier.parse("naruto_shippuden:clone_death")),
									SoundSource.NEUTRAL, (float) 1, (float) 1, false);
						}
						if (world instanceof ServerLevel) {
							((ServerLevel) world).sendParticles(ParticleTypes.CLOUD, (entity.getX()), (entity.getY() + 1), (entity.getZ()),
									(int) 3, 0, 1, 0, 0);
						}
					}
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 299);
			{
				List<Entity> _entfound = world
						.getEntitiesOfClass(Entity.class,
								new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf(x, y, z)).collect(Collectors.toList());
				for (Entity entityiterator : _entfound) {
					if (entityiterator instanceof Player) {
						if ((entity instanceof TamableAnimal && entityiterator instanceof LivingEntity)
								? ((TamableAnimal) entity).isOwnedBy((LivingEntity) entityiterator)
								: false) {
							entity.setYRot((float) ((entityiterator.getYRot())));
							entity.setYBodyRot(entity.getYRot());
							entity.yRotO = entity.getYRot();
							if (entity instanceof LivingEntity) {
								((LivingEntity) entity).yBodyRotO = entity.getYRot();
								((LivingEntity) entity).yHeadRot = entity.getYRot();
								((LivingEntity) entity).yHeadRotO = entity.getYRot();
							}
							entity.setXRot((float) (0));
						}
					}
				}
			}
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(DespawnPotionEffect.potion, (int) 300, (int) 1, (false), (false)));
		}
	}

	public static class ShadowCloneTechniqueRightclickedProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowCloneTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("x") == null) {
				if (!dependencies.containsKey("x"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency x for procedure ShadowCloneTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("y") == null) {
				if (!dependencies.containsKey("y"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency y for procedure ShadowCloneTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("z") == null) {
				if (!dependencies.containsKey("z"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency z for procedure ShadowCloneTechniqueRightclicked!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowCloneTechniqueRightclicked!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
			double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
			double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
			Entity entity = (Entity) dependencies.get("entity");
			double clonecount = 0;
			double storyrandomclones = 0;
			if (NarutoShippudenModVariables.get(entity).ninjutsu >= 5) {
				if (NarutoShippudenModVariables.get(entity).ChakraAmount >= 30) {
					if (!(NarutoShippudenModVariables.get(entity).storymode == 14) && !(NarutoShippudenModVariables.get(entity).storymode == 5)) {
						net.mcreator.narutoshippudenmod.core.jutsu.ShadowClones.cast(entity);
					} else if (false) {
						clonecount = (Mth.nextInt(RandomSource.create(), 1, 6));
						if ((entity.getDirection()) == Direction.SOUTH) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.NORTH) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.WEST) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.EAST) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
									new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
									if (!((entityiterator instanceof TamableAnimal) ? ((TamableAnimal) entityiterator).isTame() : false)) {
										if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
											((TamableAnimal) entityiterator).setTame(true, true);
											((TamableAnimal) entityiterator).tame((Player) entity);
										}
										entityiterator.setYRot((float) ((entity.getYRot())));
										entity.setYBodyRot(entity.getYRot());
										entity.yRotO = entity.getYRot();
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).yBodyRotO = entity.getYRot();
											((LivingEntity) entity).yHeadRot = entity.getYRot();
											((LivingEntity) entity).yHeadRotO = entity.getYRot();
										}
										entityiterator.setXRot((float) (0));
										entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString())));
									}
								}
							}
						}
						if (entity instanceof Player)
							((Player) entity).getCooldowns().addCooldown(new ItemStack(ShadowCloneTechniqueItem.block), (int) 25);
					} else if (NarutoShippudenModVariables.get(entity).storymode == 14) {
						if (NarutoShippudenModVariables.get(entity).StorymodeCooldown == 7) {
							storyrandomclones = (Mth.nextInt(RandomSource.create(), 1, 2));
							if (storyrandomclones == 1) {
								if ((entity.getDirection()) == Direction.SOUTH) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.NORTH) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.WEST) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								} else if ((entity.getDirection()) == Direction.EAST) {
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x + 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z + 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 2), y, (z - 1), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z + 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
									if (world instanceof ServerLevel) {
										Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
										entityToSpawn.snapTo((x - 1), y, (z - 2), (float) (entity.getYRot()), (float) 0);
										entityToSpawn.setYBodyRot((float) (entity.getYRot()));
										entityToSpawn.setYHeadRot((float) (entity.getYRot()));
										entityToSpawn.setDeltaMovement(0, 0, 0);
										if (entityToSpawn instanceof Mob)
											((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
													((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
										world.addFreshEntity(entityToSpawn);
									}
								}
								{
									List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
											new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true).stream().sorted(new Object() {
												Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
													return Comparator
															.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
												}
											}.compareDistOf(x, y, z)).collect(Collectors.toList());
									for (Entity entityiterator : _entfound) {
										if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
											if (!((entityiterator instanceof TamableAnimal) ? ((TamableAnimal) entityiterator).isTame() : false)) {
												if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
													((TamableAnimal) entityiterator).setTame(true, true);
													((TamableAnimal) entityiterator).tame((Player) entity);
												}
												entityiterator.setYRot((float) ((entity.getYRot())));
												entity.setYBodyRot(entity.getYRot());
												entity.yRotO = entity.getYRot();
												if (entity instanceof LivingEntity) {
													((LivingEntity) entity).yBodyRotO = entity.getYRot();
													((LivingEntity) entity).yHeadRot = entity.getYRot();
													((LivingEntity) entity).yHeadRotO = entity.getYRot();
												}
												entityiterator.setXRot((float) (0));
												entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString())));
											}
										}
									}
								}
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Shadow Clone Techique: Succesful"));
								}
								{
									double _setval = 15;
									NarutoShippudenModVariables.ifPresent(entity, capability -> {
										capability.storymode = _setval;
										capability.syncPlayerVariables(entity);
									});
								}
							} else if (storyrandomclones == 2) {
								if (entity instanceof Player && !entity.level().isClientSide()) {
									((Player) entity).sendOverlayMessage(Component.literal("Shadow Clone Techique: Unsuccessful"));
								}
							}
							if (entity instanceof Player)
								((Player) entity).getCooldowns().addCooldown(new ItemStack(ShadowCloneTechniqueItem.block), (int) 25);
						}
					} else if (NarutoShippudenModVariables.get(entity).storymode == 5) {
						clonecount = (Mth.nextInt(RandomSource.create(), 1, 6));
						if ((entity.getDirection()) == Direction.SOUTH) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.NORTH) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo(x, y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.WEST) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						} else if ((entity.getDirection()) == Direction.EAST) {
							if (clonecount == 1) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 2) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 3) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 4) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 5) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, z, (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							} else if (clonecount == 6) {
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z + 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x + 1), y, (z - 2), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z + 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel) {
									Entity entityToSpawn = new ShadowCloneEntity.CustomEntity(ShadowCloneEntity.entity, (Level) world);
									entityToSpawn.snapTo((x - 2), y, (z - 1), (float) 0, (float) 0);
									entityToSpawn.setYBodyRot((float) 0);
									entityToSpawn.setYHeadRot((float) 0);
									entityToSpawn.setDeltaMovement(0, 0, 0);
									if (entityToSpawn instanceof Mob)
										((Mob) entityToSpawn).finalizeSpawn((ServerLevel) world,
												((ServerLevel) world).getCurrentDifficultyAt(entityToSpawn.blockPosition()), EntitySpawnReason.MOB_SUMMONED, (SpawnGroupData) null);
									world.addFreshEntity(entityToSpawn);
								}
							}
						}
						{
							List<Entity> _entfound = world.getEntitiesOfClass(Entity.class,
									new AABB(x - (10 / 2d), y - (10 / 2d), z - (10 / 2d), x + (10 / 2d), y + (10 / 2d), z + (10 / 2d)), e -> true)
									.stream().sorted(new Object() {
										Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
											return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
										}
									}.compareDistOf(x, y, z)).collect(Collectors.toList());
							for (Entity entityiterator : _entfound) {
								if (entityiterator instanceof ShadowCloneEntity.CustomEntity) {
									if (!((entityiterator instanceof TamableAnimal) ? ((TamableAnimal) entityiterator).isTame() : false)) {
										if ((entityiterator instanceof TamableAnimal) && (entity instanceof Player)) {
											((TamableAnimal) entityiterator).setTame(true, true);
											((TamableAnimal) entityiterator).tame((Player) entity);
										}
										entityiterator.setYRot((float) ((entity.getYRot())));
										entity.setYBodyRot(entity.getYRot());
										entity.yRotO = entity.getYRot();
										if (entity instanceof LivingEntity) {
											((LivingEntity) entity).yBodyRotO = entity.getYRot();
											((LivingEntity) entity).yHeadRot = entity.getYRot();
											((LivingEntity) entity).yHeadRotO = entity.getYRot();
										}
										entityiterator.setXRot((float) (0));
										entityiterator.setCustomName(Component.literal((entity.getDisplayName().getString())));
									}
								}
							}
						}
						{
							double _setval = 6;
							NarutoShippudenModVariables.ifPresent(entity, capability -> {
								capability.storymode = _setval;
								capability.syncPlayerVariables(entity);
							});
						}
					}
					{
						double _setval = (NarutoShippudenModVariables.get(entity).ChakraAmount - 30);
						NarutoShippudenModVariables.ifPresent(entity, capability -> {
							capability.ChakraAmount = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof Player)
						((Player) entity).getCooldowns().addCooldown(new ItemStack(ShadowCloneTechniqueItem.block), (int) 25);
				} else if (NarutoShippudenModVariables.get(entity).ChakraAmount <= 29) {
					if (entity instanceof Player && !entity.level().isClientSide()) {
						((Player) entity).sendOverlayMessage(Component.literal("Not enough chakra"));
					}
				}
			} else if (NarutoShippudenModVariables.get(entity).ninjutsu <= 4) {
				if (entity instanceof Player && !entity.level().isClientSide()) {
					((Player) entity).sendOverlayMessage(Component.literal("Not enough Ninjutsu"));
				}
			}
		}
	}

	public static class ShadowImitationEntityOnEntityTickUpdateProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowImitationEntityOnEntityTickUpdate!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity.getVehicle() == null || !(entity instanceof TamableAnimal _tamed && _tamed.getOwner() != null)) {
				if (!entity.level().isClientSide())
					entity.discard();
				return;
			}
			(entity.getVehicle()).setYRot((float) ((((entity instanceof TamableAnimal)
					? ((TamableAnimal) entity).getOwner()
					: null).getYRot())));
			entity.setYBodyRot(entity.getYRot());
			entity.yRotO = entity.getYRot();
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).yBodyRotO = entity.getYRot();
				((LivingEntity) entity).yHeadRot = entity.getYRot();
				((LivingEntity) entity).yHeadRotO = entity.getYRot();
			}
			(entity.getVehicle()).setXRot((float) ((((entity instanceof TamableAnimal)
					? ((TamableAnimal) entity).getOwner()
					: null).getXRot())));
			if ((entity.getVehicle()) instanceof LivingEntity)
				((LivingEntity) (entity.getVehicle())).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 60, (int) 99, (false), (false)));
		}
	}

	public static class ShadowImitationEntityOnInitialEntitySpawnProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure ShadowImitationEntityOnInitialEntitySpawn!");
				return;
			}
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure ShadowImitationEntityOnInitialEntitySpawn!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity entity = (Entity) dependencies.get("entity");
			if (((Entity) world
					.getEntitiesOfClass(Player.class,
							new AABB((entity.getX()) - (40 / 2d), (entity.getY()) - (40 / 2d), (entity.getZ()) - (40 / 2d),
									(entity.getX()) + (40 / 2d), (entity.getY()) + (40 / 2d), (entity.getZ()) + (40 / 2d)), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) != null) {
				if ((entity instanceof TamableAnimal) && (((Entity) world
						.getEntitiesOfClass(Player.class,
								new AABB((entity.getX()) - (40 / 2d), (entity.getY()) - (40 / 2d), (entity.getZ()) - (40 / 2d),
										(entity.getX()) + (40 / 2d), (entity.getY()) + (40 / 2d), (entity.getZ()) + (40 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) instanceof Player)) {
					((TamableAnimal) entity).setTame(true, true);
					((TamableAnimal) entity).tame((Player) ((Entity) world
							.getEntitiesOfClass(Player.class,
									new AABB((entity.getX()) - (40 / 2d), (entity.getY()) - (40 / 2d), (entity.getZ()) - (40 / 2d),
											(entity.getX()) + (40 / 2d), (entity.getY()) + (40 / 2d), (entity.getZ()) + (40 / 2d)), e -> true)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
								}
							}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
				}
			}
			if (((Entity) world
					.getEntitiesOfClass(LivingEntity.class,
							new AABB((entity.getX()) - (10 / 2d), (entity.getY()) - (10 / 2d), (entity.getZ()) - (10 / 2d),
									(entity.getX()) + (10 / 2d), (entity.getY()) + (10 / 2d), (entity.getZ()) + (10 / 2d)), e -> true)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
						}
					}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)) != null) {
				entity.startRiding(((Entity) world
						.getEntitiesOfClass(LivingEntity.class,
								new AABB((entity.getX()) - (10 / 2d), (entity.getY()) - (10 / 2d), (entity.getZ()) - (10 / 2d),
										(entity.getX()) + (10 / 2d), (entity.getY()) + (10 / 2d), (entity.getZ()) + (10 / 2d)), e -> true)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.distanceToSqr(_x, _y, _z)));
							}
						}.compareDistOf((entity.getX()), (entity.getY()), (entity.getZ()))).findFirst().orElse(null)));
			}
		}
	}







	public static class UzumakiChainProjectileHitsLivingEntityProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("entity") == null) {
				if (!dependencies.containsKey("entity"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure UzumakiChainProjectileHitsLivingEntity!");
				return;
			}
			Entity entity = (Entity) dependencies.get("entity");
			if (entity instanceof LivingEntity)
				((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.SLOWNESS, (int) 10, (int) 4, (false), (false)));
		}
	}

	public static class UzumakiChainWhileProjectileFlyingTickProcedure {

		public static void executeProcedure(Map<String, Object> dependencies) {
			if (dependencies.get("world") == null) {
				if (!dependencies.containsKey("world"))
					NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure UzumakiChainWhileProjectileFlyingTick!");
				return;
			}
			if (dependencies.get("immediatesourceentity") == null) {
				if (!dependencies.containsKey("immediatesourceentity"))
					NarutoShippudenMod.LOGGER
							.warn("Failed to load dependency immediatesourceentity for procedure UzumakiChainWhileProjectileFlyingTick!");
				return;
			}
			LevelAccessor world = (LevelAccessor) dependencies.get("world");
			Entity immediatesourceentity = (Entity) dependencies.get("immediatesourceentity");
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private LevelAccessor world;

				public void start(LevelAccessor world, int waitTicks) {
					this.waitTicks = waitTicks;
					Registration.listen(NeoForge.EVENT_BUS, this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(ServerTickEvent.Post event) {
					if (true) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (!immediatesourceentity.level().isClientSide())
						immediatesourceentity.discard();
					NeoForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 2);
		}
	}




}
