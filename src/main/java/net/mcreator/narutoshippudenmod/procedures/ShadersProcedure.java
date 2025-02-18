package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.ResourceLocation;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.potion.CoercionSharinganEffectPotionEffect;
import net.mcreator.narutoshippudenmod.NarutoShippudenModVariables;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class ShadersProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.END) {
				Entity entity = event.player;
				World world = entity.world;
				double i = entity.getPosX();
				double j = entity.getPosY();
				double k = entity.getPosZ();
				Map<String, Object> dependencies = new HashMap<>();
				dependencies.put("x", i);
				dependencies.put("y", j);
				dependencies.put("z", k);
				dependencies.put("world", world);
				dependencies.put("entity", entity);
				dependencies.put("event", event);
				executeProcedure(dependencies);
			}
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency world for procedure Shaders!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency entity for procedure Shaders!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (world.isRemote()) {
			if (entity instanceof PlayerEntity) {
				if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new NarutoShippudenModVariables.PlayerVariables())).Mangekyou_Sharingan == true) {
					if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new NarutoShippudenModVariables.PlayerVariables())).Eternal_Mangekyou_Sharingan == false) {
						if ((entity.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new NarutoShippudenModVariables.PlayerVariables())).Mangekyou_Sharingan_Technique_Use >= (entity
										.getCapability(NarutoShippudenModVariables.PLAYER_VARIABLES_CAPABILITY, null)
										.orElse(new NarutoShippudenModVariables.PlayerVariables())).Mangekyou_Sharingan_Technique_Use_Max) {
							if (Minecraft.getInstance().gameRenderer.getShaderGroup() == null) {
								Minecraft.getInstance().gameRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
							}
						}
					} else {
						if (!(Minecraft.getInstance().gameRenderer.getShaderGroup() == null)) {
							Minecraft.getInstance().gameRenderer.stopUseShader();
						}
					}
				}
				if (new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == CoercionSharinganEffectPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity)) {
					if (Minecraft.getInstance().gameRenderer.getShaderGroup() == null) {
						Minecraft.getInstance().gameRenderer.loadShader(new ResourceLocation("naruto_shippuden:shaders/post/coercionsharingan.json"));
					}
				} else if (!(new Object() {
					boolean check(Entity _entity) {
						if (_entity instanceof LivingEntity) {
							Collection<EffectInstance> effects = ((LivingEntity) _entity).getActivePotionEffects();
							for (EffectInstance effect : effects) {
								if (effect.getPotion() == CoercionSharinganEffectPotionEffect.potion)
									return true;
							}
						}
						return false;
					}
				}.check(entity))) {
					if (!(Minecraft.getInstance().gameRenderer.getShaderGroup() == null)) {
						Minecraft.getInstance().gameRenderer.stopUseShader();
					}
				}
			}
		}
	}
}
