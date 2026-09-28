package net.mcreator.narutoshippudenmod.core.jutsu.engine;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.compat.Registration;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

/** Registers the jutsu engine's entities. */
@NarutoShippudenModElements.ModElement.Tag
public class JutsuEngine extends NarutoShippudenModElements.ModElement {
	public static EntityType<JutsuProjectile> PROJECTILE;

	public JutsuEngine(NarutoShippudenModElements instance) {
		super(instance, 5001);
	}

	@Override
	public void initElements() {
		elements.entities.add(() -> PROJECTILE = EntityType.Builder.<JutsuProjectile>of(JutsuProjectile::new, MobCategory.MISC).sized(0.5F, 0.5F)
				.clientTrackingRange(8).updateInterval(1).build(Registration.entityKey("jutsu_projectile")));
	}

	@Override
	public void init(FMLCommonSetupEvent event) {
	}
}
