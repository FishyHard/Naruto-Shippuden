package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.story.StoryGear;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

/**
 * The Hokage's hat on the head, in the vanilla manner: a broad brim, a tier with the red panel, the crown and its red tip,
 * stepped like a cone, and the white cloth hanging at the back of the neck (texture: porting/skins/gear.py). The jonin vest
 * needs nothing here: it is a chestplate drawn on vanilla's armour model from its equipment asset.
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class StoryGearClient {
	private static final ModelLayerLocation HAT = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "hokage_hat"), "main");
	private static final Identifier HAT_TEXTURE = Identifier.parse("naruto_shippuden:textures/entities/hokage_hat.png");
	private static HumanoidModel<?> hat;

	private StoryGearClient() {
	}

	static LayerDefinition hatLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0).addBox(-7.0F, -8.6F, -7.0F, 14, 1, 14)        // the brim
				.texOffs(0, 16).addBox(-5.0F, -10.6F, -5.0F, 10, 2, 10)      // the tier with the red panel
				.texOffs(0, 30).addBox(-3.0F, -12.6F, -3.0F, 6, 2, 6)        // the crown
				.texOffs(24, 30).addBox(-1.0F, -13.6F, -1.0F, 2, 1, 2)       // the tip
				.texOffs(0, 40).addBox(-4.5F, -7.6F, 4.3F, 9, 8, 1),         // the cloth down the back of the neck
				PartPose.ZERO);
		head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		return LayerDefinition.create(mesh, 64, 64);
	}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(HAT, StoryGearClient::hatLayer);
	}

	@SubscribeEvent
	public static void registerExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (hat == null)
					hat = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(HAT));
				return hat;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return HAT_TEXTURE;
			}
		}, StoryGear.HAT);
	}
}
