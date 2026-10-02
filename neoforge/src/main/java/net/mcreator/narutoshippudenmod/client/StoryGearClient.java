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
 * stepped like a cone, and the white cloth hanging at the back of the neck; the jonin vest's padded body with its thick
 * collar and the scroll pockets standing out (textures: porting/skins/gear.py).
 */
@EventBusSubscriber(modid = "naruto_shippuden", value = Dist.CLIENT)
public final class StoryGearClient {
	private static final ModelLayerLocation HAT = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "hokage_hat"), "main");
	private static final Identifier HAT_TEXTURE = Identifier.parse("naruto_shippuden:textures/entities/hokage_hat.png");
	private static final ModelLayerLocation VEST = new ModelLayerLocation(Identifier.fromNamespaceAndPath("naruto_shippuden", "jonin_vest"), "main");
	private static final Identifier VEST_TEXTURE = Identifier.parse("naruto_shippuden:textures/entities/jonin_vest.png");
	private static HumanoidModel<?> hat, vest;

	private StoryGearClient() {
	}

	/** The player mesh with every part emptied, for gear that adds its own boxes to one part. */
	private static PartDefinition empty(MeshDefinition mesh) {
		PartDefinition root = mesh.getRoot();
		root.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.ZERO).addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.ZERO);
		root.addOrReplaceChild("right_arm", CubeListBuilder.create(), PartPose.offset(-5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("left_arm", CubeListBuilder.create(), PartPose.offset(5.0F, 2.0F, 0.0F));
		root.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-1.9F, 12.0F, 0.0F));
		root.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(1.9F, 12.0F, 0.0F));
		return root;
	}

	/** A broad brim at the brow, then a cone a pixel narrower each step to the tip; the cloth down the back of the neck. */
	static LayerDefinition hatLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = empty(mesh);
		// the cone: a step a pixel narrower each pixel up from the brim at the brow (texture: porting/skins/gear.py CONE)
		int[][] cone = { { 16, 0, 0 }, { 14, 64, 0 }, { 12, 0, 17 }, { 10, 48, 17 }, { 8, 88, 17 }, { 6, 0, 30 } };
		CubeListBuilder hat = CubeListBuilder.create();
		for (int i = 0; i < cone.length; i++) {
			float half = cone[i][0] / 2.0F;
			hat.texOffs(cone[i][1], cone[i][2]).addBox(-half, -8.5F - i, -half, cone[i][0], 1, cone[i][0]);
		}
		hat.texOffs(24, 30).addBox(-2.0F, -8.5F - cone.length, -2.0F, 4, 1, 4)            // the tip
				.texOffs(40, 30).addBox(-1.0F, -9.5F - cone.length, -1.0F, 2, 1, 2)
				.texOffs(48, 30).addBox(-5.0F, -7.5F, 4.4F, 10, 7, 1);                      // the cloth at the back of the neck
		root.addOrReplaceChild("head", hat, PartPose.ZERO).addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		return LayerDefinition.create(mesh, 128, 64);
	}

	/** The padded body over the shirt, the thick collar round the neck, four scroll pockets standing out of the chest. */
	static LayerDefinition vestLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = empty(mesh);
		CubeListBuilder body = CubeListBuilder.create()
				.texOffs(0, 0).addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, new CubeDeformation(0.45F))
				.texOffs(0, 16).addBox(-4.5F, -1.2F, -2.5F, 9, 2, 5, new CubeDeformation(0.15F));
		for (float x : new float[] { -4.1F, 1.1F })
			for (float y : new float[] { 1.6F, 5.0F })
				body.texOffs(28, 16).addBox(x, y, -3.35F, 3, 3, 1);
		root.addOrReplaceChild("body", body, PartPose.ZERO);
		return LayerDefinition.create(mesh, 64, 32);
	}

	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(HAT, StoryGearClient::hatLayer);
		event.registerLayerDefinition(VEST, StoryGearClient::vestLayer);
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
		event.registerItem(new IClientItemExtensions() {
			@Override
			public Model getHumanoidArmorModel(ItemStack stack, EquipmentClientInfo.LayerType type, Model original) {
				if (vest == null)
					vest = new HumanoidModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(VEST));
				return vest;
			}

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier _default) {
				return VEST_TEXTURE;
			}
		}, StoryGear.VEST);
	}
}
