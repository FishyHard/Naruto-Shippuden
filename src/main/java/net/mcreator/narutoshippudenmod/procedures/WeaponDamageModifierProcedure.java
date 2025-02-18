package net.mcreator.narutoshippudenmod.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.common.ForgeMod;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.ai.attributes.AttributeModifier;

import net.mcreator.narutoshippudenmod.item.WhiteLightChakraSabreItem;
import net.mcreator.narutoshippudenmod.item.ToroiUniqueFumaShurikenItem;
import net.mcreator.narutoshippudenmod.item.ShurikenItem;
import net.mcreator.narutoshippudenmod.item.PoisonKunaiItem;
import net.mcreator.narutoshippudenmod.item.KusanagiSasukeItem;
import net.mcreator.narutoshippudenmod.item.KunaiItem;
import net.mcreator.narutoshippudenmod.item.HiramekareiSplittedItem;
import net.mcreator.narutoshippudenmod.item.HiramekareiItem;
import net.mcreator.narutoshippudenmod.item.FumaShurikenItem;
import net.mcreator.narutoshippudenmod.item.ExplosiveKunaiItem;
import net.mcreator.narutoshippudenmod.item.ChakraBladeItem;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

public class WeaponDamageModifierProcedure {
	@Mod.EventBusSubscriber
	private static class GlobalTrigger {
		@SubscribeEvent
		public static void addAttributeModifier(ItemAttributeModifierEvent event) {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("itemstack", event.getItemStack());
			dependencies.put("event", event);
			executeProcedure(dependencies);
		}
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				NarutoShippudenMod.LOGGER.warn("Failed to load dependency itemstack for procedure WeaponDamageModifier!");
			return;
		}
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double SharpLevel = 0;
		double ReachLevel = 0;
		AttributeModifier modify = null;
		AttributeModifier modify2 = null;
		if (itemstack.getItem() == HiramekareiItem.block || itemstack.getItem() == HiramekareiSplittedItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("HiramekareiSharp"));
				modify = new AttributeModifier(UUID.fromString("9ef97f14-fb9d-4860-8d83-15e8d640a447"), "naruto_shippuden." + "HiramekareiSharp",
						SharpLevel, AttributeModifier.Operation.MULTIPLY_BASE);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
			}
		} else if (itemstack.getItem() == HiramekareiItem.block || itemstack.getItem() == HiramekareiSplittedItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.OFFHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("HiramekareiSharp"));
				modify = new AttributeModifier(UUID.fromString("9ef97f14-fb9d-4860-8d83-15e8d640a447"), "naruto_shippuden." + "HiramekareiSharp",
						SharpLevel, AttributeModifier.Operation.MULTIPLY_BASE);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
			}
		}
		if (itemstack.getItem() == KusanagiSasukeItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("KusanagiSharp"));
				ReachLevel = (itemstack.getOrCreateTag().getDouble("KusanagiReach"));
				modify = new AttributeModifier(UUID.fromString("a1ee4a52-cccf-4c63-9716-76f065b3a744"), "naruto_shippuden." + "KusanagiSharp",
						SharpLevel, AttributeModifier.Operation.ADDITION);
				modify2 = new AttributeModifier(UUID.fromString("72438fca-67d7-4e13-98bf-fd22f8229b3b"), "naruto_shippuden." + "KusanagiReach",
						ReachLevel, AttributeModifier.Operation.ADDITION);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
				_event.addModifier(ForgeMod.REACH_DISTANCE.get(), modify2);
			}
		}
		if (itemstack.getItem() == WhiteLightChakraSabreItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("WhiteLightChakraSabreSharp"));
				modify = new AttributeModifier(UUID.fromString("48c4c3c3-f3b3-491b-8f05-a4238726d696"),
						"naruto_shippuden." + "WhiteLightChakraSabreSharp", SharpLevel, AttributeModifier.Operation.ADDITION);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
			}
		}
		if (itemstack.getItem() == ChakraBladeItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("FlyingSwallowSharp"));
				modify = new AttributeModifier(UUID.fromString("1a894d1a-b601-4117-8a44-22f1c5cd20ce"), "naruto_shippuden." + "FlyingSwallowSharp",
						SharpLevel, AttributeModifier.Operation.ADDITION);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
			}
		}
		if (itemstack.getItem() == KunaiItem.block || itemstack.getItem() == ExplosiveKunaiItem.block
				|| itemstack.getItem() == PoisonKunaiItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("KunaiDamage"));
				modify = new AttributeModifier(UUID.fromString("dfa6db09-2311-4e14-a41b-a6cac416e530"), "naruto_shippuden." + "KunaiDamage",
						SharpLevel, AttributeModifier.Operation.ADDITION);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
			}
		}
		if (itemstack.getItem() == ShurikenItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("ShurikenDamage"));
				modify = new AttributeModifier(UUID.fromString("b1e338f9-4714-4653-bbc9-d6e47db0a739"), "naruto_shippuden." + "ShurikenDamage",
						SharpLevel, AttributeModifier.Operation.ADDITION);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
			}
		}
		if (itemstack.getItem() == FumaShurikenItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("FuumaShurikenDamage"));
				modify = new AttributeModifier(UUID.fromString("86f67277-1d6e-4870-9aec-85f99bb39641"), "naruto_shippuden." + "FuumaShurikenDamage",
						SharpLevel, AttributeModifier.Operation.ADDITION);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
			}
		}
		if (itemstack.getItem() == ToroiUniqueFumaShurikenItem.block) {
			if (dependencies.get("event") instanceof ItemAttributeModifierEvent
					&& ((ItemAttributeModifierEvent) dependencies.get("event")).getSlotType() == EquipmentSlotType.MAINHAND) {
				ItemAttributeModifierEvent _event = (ItemAttributeModifierEvent) dependencies.get("event");
				SharpLevel = (itemstack.getOrCreateTag().getDouble("ToroiFuumaShurikenDamage"));
				modify = new AttributeModifier(UUID.fromString("d1d98255-6cc2-457d-b2a4-bcc84a01be9f"),
						"naruto_shippuden." + "ToroiFuumaShurikenDamage", SharpLevel, AttributeModifier.Operation.ADDITION);
				_event.addModifier(net.minecraft.entity.ai.attributes.Attributes.ATTACK_DAMAGE, modify);
			}
		}
	}
}
