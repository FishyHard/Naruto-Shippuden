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

	/** The hat's roof: each of its four sides is strips a pixel thick and a pixel long, two narrower each step up (so the
	 * sides meet as smooth triangles), all at one slope; shared with porting/skins/gear.py, which paints strip k of side s at
	 * texture (s % 2 * 40, s / 2 * 18 + k * 2). */
	static final int STRIPS = 9;
	static final float SLOPE = 0.48F, HALF = 9.0F, BROW = -8.4F;

	/**
	 * The Hokage's hat as in the anime: a low, broad pyramid of red over a white rim, the white triangle on its front with
	 * the kanji, and the white cloth hanging from the brim's edge, clear of the face, over the sides and back of the head.
	 */
	static LayerDefinition hatLayer() {
		MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition root = empty(mesh);
		PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 36).addBox(-HALF, BROW, -HALF, 18, 1, 18)                   // the white rim
				.texOffs(80, 0).addBox(-6.6F, BROW + 0.8F, -3.6F, 1, 11, 10)           // the cloth, out from the sides of the head
				.texOffs(80, 0).mirror().addBox(5.6F, BROW + 0.8F, -3.6F, 1, 11, 10).mirror(false)
				.texOffs(80, 21).addBox(-6.0F, BROW + 0.8F, 6.2F, 12, 11, 1),          // and down the back
				PartPose.ZERO);
		head.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
		// the roof's four sides: front, left, back, right (turned a quarter each), sloping up from the rim's edge
		float[][] sides = { { 0, -HALF, 0 }, { -HALF, 0, (float) Math.PI / 2 }, { 0, HALF, (float) Math.PI }, { HALF, 0, (float) -Math.PI / 2 } };
		for (int side = 0; side < 4; side++)
			for (int k = 0; k < STRIPS; k++) {
				int w = 18 - 2 * k;
				head.addOrReplaceChild("roof_" + side + "_" + k, CubeListBuilder.create().texOffs(side % 2 * 40, side / 2 * 18 + k * 2)
						.addBox(-w / 2.0F, -1.0F, k, w, 1, 1), PartPose.offsetAndRotation(sides[side][0], BROW, sides[side][1], SLOPE, sides[side][2], 0));
			}
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
