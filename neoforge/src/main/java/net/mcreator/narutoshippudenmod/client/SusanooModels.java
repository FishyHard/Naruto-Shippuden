package net.mcreator.narutoshippudenmod.client;

import net.mcreator.narutoshippudenmod.core.Susanoo.Owner;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;

/**
 * The Susanoo's shapes, built of boxes the way vanilla's mobs are, one model for each owner and stage. Model space is the usual
 * entity model's: units of a sixteenth, -Y up, -Z the front, +X the model's left; the origin is the user's feet (the Complete
 * stage's belly, where its user floats). SusanooRenderer scales each stage up (Ghast- and Giant-like big texels).
 * <p>
 * The texture (textures/entities/susanoo/&lt;owner&gt;.png, porting/skins/susanoo.py) is laid out in zones every box draws from:
 * chakra for the flesh, bone, armour, the dark of mouths and sockets, flame, the glowing eyes, the weapon and the owner's
 * markings. Named parts the renderer moves: body, head, jaw, right_arm/left_arm (with forearm), right_leg/left_leg (with
 * shin), right_wing/left_wing, ring0..ring4 (built up one after another), flame* (flicker), weapon.
 */
final class SusanooModels {
	// texture zones (u, v) in the 256x256 texture
	private static final int[] CHAKRA = { 0, 0 }, BONE = { 128, 0 }, ARMOR = { 128, 64 }, DARK = { 0, 128 }, FLAME = { 64, 128 }, EYE = { 128, 128 },
			WEAPON = { 144, 128 }, MARK = { 0, 192 }, PLATE = { 128, 192 };
	private static final float PI = (float) Math.PI;

	private SusanooModels() {
	}

	/**
	 * The user's own model for this owner and stage, converted (porting/skins/susanoo_convert.py: assets/naruto_shippuden/susanoo/
	 * &lt;owner&gt;_&lt;stage&gt;.json), or null if there is none yet. Bones keep their pivots and turns; a turned box gets a part of
	 * its own.
	 */
	/** A converted model and its height and lowest point (sixteenths), for drawing the Complete stages all one size. */
	record Converted(LayerDefinition layer, float height, float bottom, float[] seat) {
	}

	static @org.jspecify.annotations.Nullable Converted converted(Owner owner, String key) {
		var id = net.minecraft.resources.Identifier.fromNamespaceAndPath("naruto_shippuden", "susanoo/" + owner.id() + "_" + key + ".json");
		var resource = net.minecraft.client.Minecraft.getInstance().getResourceManager().getResource(id);
		if (resource.isEmpty())
			return null;
		com.google.gson.JsonObject json;
		try (var reader = resource.get().openAsReader()) {
			json = com.google.gson.JsonParser.parseReader(reader).getAsJsonObject();
		} catch (java.io.IOException e) {
			return null;
		}
		MeshDefinition mesh = new MeshDefinition();
		java.util.Map<String, PartDefinition> parts = new java.util.HashMap<>();
		for (var element : json.getAsJsonArray("bones")) {
			var bone = element.getAsJsonObject();
			String name = bone.get("name").getAsString();
			PartDefinition parent = bone.get("parent").isJsonNull() ? mesh.getRoot() : parts.get(bone.get("parent").getAsString());
			CubeListBuilder cubes = CubeListBuilder.create();
			java.util.List<com.google.gson.JsonObject> turned = new java.util.ArrayList<>();
			for (var c : bone.getAsJsonArray("cubes")) {
				var cube = c.getAsJsonObject();
				if (cube.has("rot"))
					turned.add(cube);
				else
					box(cubes, cube);
			}
			float[] p = floats(bone, "pivot"), r = floats(bone, "rot");
			PartDefinition part = parent.addOrReplaceChild(name, cubes, PartPose.offsetAndRotation(p[0], p[1], p[2], r[0], r[1], r[2]));
			for (int i = 0; i < turned.size(); i++) {
				var cube = turned.get(i);
				float[] cp = floats(cube, "pivot"), cr = floats(cube, "rot");
				part.addOrReplaceChild(name + "_c" + i, box(CubeListBuilder.create(), cube), PartPose.offsetAndRotation(cp[0], cp[1], cp[2], cr[0], cr[1], cr[2]));
			}
			parts.put(name, part);
		}
		var texture = json.getAsJsonArray("texture");
		return new Converted(LayerDefinition.create(mesh, texture.get(0).getAsInt(), texture.get(1).getAsInt()),
				json.has("height") ? json.get("height").getAsFloat() : 0, json.has("bottom") ? json.get("bottom").getAsFloat() : 0,
				json.has("seat") ? floats(json, "seat") : new float[] { 0, 0 });
	}

	private static CubeListBuilder box(CubeListBuilder builder, com.google.gson.JsonObject cube) {
		float[] uv = floats(cube, "uv"), from = floats(cube, "from"), size = floats(cube, "size");
		float inflate = cube.has("inflate") ? cube.get("inflate").getAsFloat() : 0;
		// the texture laid out on whole pixels (as susanoo_convert.py paints it), the box then stretched to its exact size:
		// Minecraft maps a box's texture from the size it's given, so a fractional size would sample its faces off the
		// painted pixels (stray pixels of the neighbouring face's colour)
		float[] whole = new float[3], grow = new float[3];
		for (int i = 0; i < 3; i++) {
			whole[i] = Math.max(1, Math.round(size[i]));
			grow[i] = (size[i] - whole[i]) / 2 + inflate;
		}
		return builder.texOffs((int) uv[0], (int) uv[1]).addBox(from[0] + (size[0] - whole[0]) / 2, from[1] + (size[1] - whole[1]) / 2,
				from[2] + (size[2] - whole[2]) / 2, whole[0], whole[1], whole[2],
				new net.minecraft.client.model.geom.builders.CubeDeformation(grow[0], grow[1], grow[2]));
	}

	private static float[] floats(com.google.gson.JsonObject o, String key) {
		var a = o.getAsJsonArray(key);
		float[] out = new float[a.size()];
		for (int i = 0; i < out.length; i++)
			out[i] = a.get(i).getAsFloat();
		return out;
	}

	static LayerDefinition layer(Owner owner, int stage) {
		MeshDefinition mesh = new MeshDefinition();
		PartDefinition root = mesh.getRoot();
		switch (stage) {
			case 1 -> ribcage(root, owner);
			case 2 -> skeleton(root, owner);
			case 3 -> humanoid(root, owner, false);
			case 4 -> humanoid(root, owner, true);
			default -> complete(root, owner);
		}
		return LayerDefinition.create(mesh, 256, 256);
	}

	private static CubeListBuilder c(int[] zone) {
		return CubeListBuilder.create().texOffs(zone[0], zone[1]);
	}

	private static CubeListBuilder none() {
		return CubeListBuilder.create();
	}

	// ------------------------------------------------------------------ ribs
	/**
	 * A rib ring round the body at height y: segments of bone round a circle, open at the front (the ribs' ends curl in there, as
	 * in the anime), so the user shows between them.
	 */
	private static void ring(PartDefinition parent, String name, float y, float radius, float thick, int segments, int gap, int[] zone) {
		PartDefinition ring = parent.addOrReplaceChild(name, none(), PartPose.offset(0, y, 0));
		float length = (float) (2 * Math.PI * radius / segments) + thick * 0.6F;
		for (int i = 0; i < segments; i++) {
			if (i < gap || i > segments - gap)
				continue;
			float a = i * 2 * PI / segments;
			float x = (float) Math.sin(a) * radius, z = -(float) Math.cos(a) * radius;
			ring.addOrReplaceChild(name + "_" + i, c(zone).addBox(-length / 2, -thick / 2, -thick / 2, length, thick, thick),
					PartPose.offsetAndRotation(x, 0, z, 0, -a, 0));
		}
		// the ends curl forward and in
		for (int side : new int[] { -1, 1 }) {
			float a = (gap - 0.4F) * 2 * PI / segments * side;
			float x = (float) Math.sin(a) * radius, z = -(float) Math.cos(a) * radius;
			ring.addOrReplaceChild(name + "_end" + (side < 0 ? "r" : "l"), c(zone).addBox(-thick / 2, -thick * 0.4F, -thick * 1.2F, thick, thick * 0.8F, thick * 1.6F),
					PartPose.offsetAndRotation(x, thick * 0.3F, z, 0.3F, -a - side * 0.6F, 0));
		}
	}

	/** Stacked rib rings with a spine behind them; the rings are ring0 (lowest) up to ring4. */
	private static void ribs(PartDefinition parent, float bottom, float step, float[] radii, float thick, int[] zone) {
		for (int i = 0; i < radii.length; i++)
			ring(parent, "ring" + i, bottom - i * step, radii[i], thick, 14, 2, zone);
		float top = bottom - (radii.length - 1) * step - step;
		float back = radii[radii.length / 2] + thick * 0.2F;
		parent.addOrReplaceChild("spine", c(zone).addBox(-thick * 0.75F, top, back - thick * 0.75F, thick * 1.5F, bottom - top + thick, thick * 1.5F),
				PartPose.ZERO);
	}

	// ------------------------------------------------------------------ stage 1: the ribcage
	private static void ribcage(PartDefinition root, Owner owner) {
		PartDefinition body = root.addOrReplaceChild("body", none(), PartPose.ZERO);
		ribs(body, -4, 5.5F, new float[] { 9, 11, 12.5F, 12, 10.5F }, 2.2F, BONE);
		// the collarbones from the spine round to the front, and the first wisps of the shoulders
		for (int side : new int[] { -1, 1 }) {
			body.addOrReplaceChild("collar" + side, c(BONE).addBox(-1, -1, -11, 2, 2, 13),
					PartPose.offsetAndRotation(side * 7, -30, 3, 0, side * 0.5F, side * 0.25F));
			body.addOrReplaceChild("flame_s" + side, c(FLAME).addBox(-2, -6, -2, 4, 6, 4), PartPose.offsetAndRotation(side * 11, -30, 2, 0, 0, side * 0.3F));
		}
	}

	// ------------------------------------------------------------------ stage 2: the skeleton
	private static void skeleton(PartDefinition root, Owner owner) {
		PartDefinition body = root.addOrReplaceChild("body", none(), PartPose.ZERO);
		ribs(body, -3, 3.4F, new float[] { 6.5F, 8, 9, 8.6F, 7.5F }, 1.6F, BONE);
		body.addOrReplaceChild("neck", c(BONE).addBox(-1.2F, -4, -1.2F, 2.4F, 4, 2.4F), PartPose.offset(0, -21, 6));
		body.addOrReplaceChild("clavicle", c(BONE).addBox(-10, -1, -1, 20, 2, 2), PartPose.offset(0, -21, 4));
		PartDefinition head = body.addOrReplaceChild("head", none(), PartPose.offset(0, -24, 3));
		skull(head, owner);
		for (int side : new int[] { -1, 1 }) {
			String name = side < 0 ? "right_arm" : "left_arm";
			PartDefinition arm = body.addOrReplaceChild(name, c(BONE).addBox(-1.2F, 0, -1.2F, 2.4F, 10, 2.4F)
					.texOffs(BONE[0], BONE[1]).addBox(-2, -2, -2, 4, 3, 4), PartPose.offsetAndRotation(side * 10, -21, 4, -0.25F, 0, side * 0.12F));
			PartDefinition fore = arm.addOrReplaceChild("forearm", c(BONE).addBox(-1, 0, -1, 2, 9, 2), PartPose.offsetAndRotation(0, 10, 0, -0.5F, 0, 0));
			fore.addOrReplaceChild("hand", c(BONE).addBox(-2.5F, 0, -2, 5, 3, 4).texOffs(BONE[0], BONE[1]).addBox(-2.4F, 3, -1.8F, 1, 4, 1)
					.addBox(-1, 3, -1.8F, 1, 4.6F, 1).addBox(0.4F, 3, -1.8F, 1, 4.4F, 1).addBox(1.6F, 3, -1.8F, 1, 3.6F, 1).addBox(side < 0 ? 2.4F : -3.4F, 1, -2.4F, 1, 3, 1),
					PartPose.offset(0, 9, 0));
		}
	}

	/** The skull: cranium, sockets with glowing eyes, the grin; each owner's own head bones over it. */
	private static void skull(PartDefinition head, Owner owner) {
		head.addOrReplaceChild("cranium", c(BONE).addBox(-4.5F, -9, -5, 9, 7, 9), PartPose.ZERO);
		head.addOrReplaceChild("cheeks", c(BONE).addBox(-4, -2, -5, 8, 2, 6), PartPose.ZERO);
		head.addOrReplaceChild("sockets", c(DARK).addBox(-3.5F, -6.5F, -5.3F, 2.6F, 2.4F, 1).addBox(0.9F, -6.5F, -5.3F, 2.6F, 2.4F, 1)
				.addBox(-0.6F, -4, -5.3F, 1.2F, 1.4F, 1), PartPose.ZERO);
		head.addOrReplaceChild("eyes", c(EYE).addBox(-3, -6, -5.5F, 1.6F, 1.4F, 0.4F).addBox(1.4F, -6, -5.5F, 1.6F, 1.4F, 0.4F), PartPose.ZERO);
		PartDefinition jaw = head.addOrReplaceChild("jaw", c(BONE).addBox(-3.5F, 0, -5, 7, 2, 6), PartPose.offset(0, -1, 0));
		head.addOrReplaceChild("teeth", c(BONE).addBox(-3, -0.5F, -5.2F, 6, 1, 0.5F), PartPose.offset(0, -1, 0));
		jaw.addOrReplaceChild("teeth_low", c(BONE).addBox(-3, -0.6F, -5.2F, 6, 0.8F, 0.5F), PartPose.ZERO);
		switch (owner) {
			case SASUKE -> {
				// the two horns, swept up and back like ears (the anime's skeleton)
				// the two horns, out to the sides and curling up (the user's skeleton model)
				for (int side : new int[] { -1, 1 }) {
					PartDefinition horn = head.addOrReplaceChild("horn" + side, c(BONE).addBox(-1.2F, -1.2F, -1.2F, 2.4F, 2.4F, 2.4F)
							.texOffs(BONE[0], BONE[1]).addBox(side < 0 ? -5 : 1.2F, -1, -1, 3.8F, 2, 2), PartPose.offset(side * 4.5F, -7, 0));
					horn.addOrReplaceChild("tip", c(BONE).addBox(-0.9F, -5, -0.9F, 1.8F, 5, 1.8F).texOffs(BONE[0], BONE[1]).addBox(-0.5F, -7.5F, -0.5F, 1, 2.5F, 1),
							PartPose.offsetAndRotation(side * 4.5F, 0, 0, 0, 0, side * 0.35F));
				}
			}
			case ITACHI -> head.addOrReplaceChild("nose", c(BONE).addBox(-1, -1, -5, 2, 2, 5), PartPose.offsetAndRotation(0, -4.5F, -5, 0.25F, 0, 0));
			case MADARA -> head.addOrReplaceChild("crest", c(BONE).addBox(-1, -10, -1, 2, 10, 2), PartPose.offsetAndRotation(0, -8, -1, -0.45F, 0, 0));
			case SHISUI -> {
				for (int i = -2; i <= 2; i++)
					head.addOrReplaceChild("spike" + (i + 2), c(BONE).addBox(-0.8F, -4, -0.8F, 1.6F, 4, 1.6F),
							PartPose.offsetAndRotation(i * 2, -9, -1 + Math.abs(i), -0.3F, 0, i * 0.25F));
			}
			case OBITO -> head.addOrReplaceChild("crest", c(BONE).addBox(-2, -3, -1, 4, 3, 2), PartPose.offset(0, -9, -3.5F));
		}
	}

	// ------------------------------------------------------------------ stages 3 and 4: the humanoid and its armour
	private static void humanoid(PartDefinition root, Owner owner, boolean armoured) {
		PartDefinition body = root.addOrReplaceChild("body", none(), PartPose.ZERO);
		torso(body, owner, armoured, 0);
		ribs(body, -1, 2.2F, new float[] { 6.2F, 6.8F, 7.2F, 7.2F }, 1.2F, BONE);
		PartDefinition head = body.addOrReplaceChild("head", none(), PartPose.offset(0, -23, -0.5F));
		face(head, owner, armoured);
		for (int side : new int[] { -1, 1 })
			arm(body, owner, side, armoured, -18);
		if (owner == Owner.MADARA)
			for (int side : new int[] { -1, 1 }) {
				// Madara's second pair of arms, raised in a sign over the shoulders
				PartDefinition upper = body.addOrReplaceChild((side < 0 ? "right" : "left") + "_arm_upper", c(CHAKRA).addBox(-3, -12, -3, 6, 12, 6),
						PartPose.offsetAndRotation(side * 11, -20, 2, -0.2F, 0, side * 0.35F));
				PartDefinition up2 = upper.addOrReplaceChild("forearm", c(CHAKRA).addBox(-2.5F, -10, -2.5F, 5, 10, 5), PartPose.offsetAndRotation(0, -12, 0, 0.2F, 0, -side * 0.6F));
				up2.addOrReplaceChild("hand", c(CHAKRA).addBox(-3, -5, -2, 6, 5, 4).texOffs(CHAKRA[0], CHAKRA[1]).addBox(-1, -9, -1, 2, 4, 2), PartPose.offset(0, -10, 0));
			}
		// the waist fades into flame
		body.addOrReplaceChild("flame_waist", c(FLAME).addBox(-8, 0, -5.5F, 16, 6, 11), PartPose.ZERO);
		marks(body, owner);
		if (armoured)
			armour(body, owner);
		weapons(body, owner, armoured ? 4 : 3);
	}

	/** The torso, broad at the shoulders and narrowing to the waist: abdomen, chest, pecs over a sternum, the abs, the traps. */
	private static void torso(PartDefinition body, Owner owner, boolean armoured, float y) {
		body.addOrReplaceChild("abdomen", c(CHAKRA).addBox(-6.5F, -9, -4.5F, 13, 9, 9), PartPose.offset(0, y, 0));
		body.addOrReplaceChild("waist_chest", c(CHAKRA).addBox(-8.5F, -14, -5.5F, 17, 5, 11), PartPose.offset(0, y, 0));
		body.addOrReplaceChild("chest", c(CHAKRA).addBox(-10.5F, -21, -6.5F, 21, 7, 12), PartPose.offset(0, y, 0));
		body.addOrReplaceChild("traps", c(CHAKRA).addBox(-6.5F, -23, -2.5F, 13, 2, 7), PartPose.offset(0, y, 0));
		body.addOrReplaceChild("pecs", c(CHAKRA).addBox(-9.5F, -20.5F, -7.4F, 8.6F, 5.5F, 1).addBox(0.9F, -20.5F, -7.4F, 8.6F, 5.5F, 1), PartPose.offset(0, y, 0));
		body.addOrReplaceChild("abs", c(CHAKRA).addBox(-3.6F, -8.5F, -5.1F, 3.3F, 2.4F, 0.8F).addBox(0.3F, -8.5F, -5.1F, 3.3F, 2.4F, 0.8F)
				.addBox(-3.6F, -5.6F, -5.1F, 3.3F, 2.4F, 0.8F).addBox(0.3F, -5.6F, -5.1F, 3.3F, 2.4F, 0.8F), PartPose.offset(0, y, 0));
		body.addOrReplaceChild("neck", c(CHAKRA).addBox(-3.5F, -3, -3, 7, 3, 6), PartPose.offset(0, y - 21, 0));
	}

	/**
	 * An arm on its shoulder: deltoid, upper arm, forearm and a fist with its knuckles; on the shoulder a lick of flame (the
	 * Humanoid) or a pauldron (armoured). The forearm's own armour from the Armoured stage on.
	 */
	private static PartDefinition arm(PartDefinition body, Owner owner, int side, boolean armoured, float shoulder) {
		String name = side < 0 ? "right_arm" : "left_arm";
		PartDefinition arm = body.addOrReplaceChild(name, c(CHAKRA).addBox(-4.5F, -4.5F, -4.5F, 9, 7, 9).texOffs(CHAKRA[0], CHAKRA[1]).addBox(-3.5F, 0, -3.5F, 7, 11, 7),
				PartPose.offsetAndRotation(side * 13.5F, shoulder, 0, -0.12F, 0, side * 0.14F));
		PartDefinition fore = arm.addOrReplaceChild("forearm", c(CHAKRA).addBox(-3.3F, 0, -3.3F, 6.6F, 10, 6.6F), PartPose.offsetAndRotation(0, 10.5F, 0, -0.35F, 0, 0));
		fore.addOrReplaceChild("hand", c(CHAKRA).addBox(-3.6F, 0, -3.6F, 7.2F, 4.5F, 7.2F).texOffs(CHAKRA[0], CHAKRA[1]).addBox(-3.4F, 4.5F, -3.6F, 1.6F, 3, 3)
				.addBox(-1.6F, 4.5F, -3.6F, 1.6F, 3.4F, 3).addBox(0.2F, 4.5F, -3.6F, 1.6F, 3.2F, 3).addBox(2, 4.5F, -3.6F, 1.4F, 2.8F, 3)
				.addBox(side < 0 ? 3.4F : -4.6F, 1, -3, 1.2F, 4, 2.4F), PartPose.offset(0, 9.5F, 0));
		if (armoured) {
			arm.addOrReplaceChild("pauldron", c(ARMOR).addBox(-6, -1.5F, -6, 12, 3, 12).texOffs(ARMOR[0], ARMOR[1]).addBox(side < 0 ? -6.5F : 5.5F, 1.5F, -6, 1, 5, 12)
					.addBox(-5, -3, -5, 10, 1.5F, 10), PartPose.offsetAndRotation(0, -5, 0, 0, 0, side * 0.2F));
			fore.addOrReplaceChild("vambrace", c(ARMOR).addBox(-3.9F, 1, -3.9F, 7.8F, 7, 7.8F), PartPose.ZERO);
		} else {
			PartDefinition flame = arm.addOrReplaceChild("flame_s" + side, none(), PartPose.offset(side * 1.5F, -4, 1));
			for (int i = 0; i < 3; i++)
				flame.addOrReplaceChild("spike" + i, c(FLAME).addBox(-2, -10 + i * 2, -2, 4, 10 - i * 2, 4).texOffs(FLAME[0], FLAME[1]).addBox(-1, -13 + i * 2, -1, 2, 3, 2),
						PartPose.offsetAndRotation(side * i * 2.5F, 0, i * 1.5F, 0.15F * i, 0, side * (0.3F + i * 0.4F)));
		}
		return arm;
	}

	/** The face of the Humanoid and later stages: each owner's own. */
	private static void face(PartDefinition head, Owner owner, boolean armoured) {
		head.addOrReplaceChild("skull", c(CHAKRA).addBox(-5, -11, -5.5F, 10, 11, 10), PartPose.ZERO);
		head.addOrReplaceChild("brow", c(BONE).addBox(-5.2F, -7.5F, -6.2F, 10.4F, 1.6F, 1.5F), PartPose.ZERO);
		head.addOrReplaceChild("eyes", c(EYE).addBox(-3.8F, -6.3F, -5.8F, 2.6F, 1.5F, 0.5F).addBox(1.2F, -6.3F, -5.8F, 2.6F, 1.5F, 0.5F), PartPose.ZERO);
		PartDefinition jaw = head.addOrReplaceChild("jaw", c(BONE).addBox(-4, 0, -6, 8, 2.5F, 7), PartPose.offset(0, -2.5F, 0));
		head.addOrReplaceChild("mouth", c(DARK).addBox(-3.5F, -3.2F, -5.9F, 7, 1.4F, 0.5F), PartPose.ZERO);
		jaw.addOrReplaceChild("teeth", c(BONE).addBox(-3.4F, -0.4F, -6.2F, 6.8F, 0.9F, 0.5F), PartPose.ZERO);
		switch (owner) {
			case SASUKE -> {
				for (int side : new int[] { -1, 1 })
					head.addOrReplaceChild("horn" + side, c(armoured ? ARMOR : CHAKRA).addBox(-1.2F, -10, -1.2F, 2.4F, 10, 2.4F)
							.texOffs(BONE[0], BONE[1]).addBox(-0.6F, -15, -0.6F, 1.2F, 5, 1.2F), PartPose.offsetAndRotation(side * 4, -10, 1, -0.4F, 0, side * 0.42F));
			}
			case ITACHI -> {
				// the long tengu nose and the mask over the jaw
				head.addOrReplaceChild("nose", c(CHAKRA).addBox(-1.2F, -1.2F, -7, 2.4F, 2.4F, 7), PartPose.offsetAndRotation(0, -5, -5.5F, 0.35F, 0, 0));
				head.addOrReplaceChild("mask", c(MARK).addBox(-5.5F, -4, -7, 11, 4, 3), PartPose.ZERO);
				for (int side : new int[] { -1, 1 })
					head.addOrReplaceChild("ear" + side, c(CHAKRA).addBox(-0.5F, -3, -1, 1, 4, 2), PartPose.offsetAndRotation(side * 5.3F, -7, -1, 0, 0, side * 0.3F));
			}
			case MADARA -> head.addOrReplaceChild("crest", c(CHAKRA).addBox(-1.5F, -14, -1.5F, 3, 14, 3).texOffs(CHAKRA[0], CHAKRA[1]).addBox(-1, -20, -1, 2, 6, 2),
					PartPose.offsetAndRotation(0, -10, -2, -0.55F, 0, 0));
			case SHISUI -> {
				// the spiked crown of hair
				for (int i = 0; i < 7; i++)
					head.addOrReplaceChild("spike" + i, c(FLAME).addBox(-1.2F, -6, -1.2F, 2.4F, 6, 2.4F),
							PartPose.offsetAndRotation(-4.5F + i * 1.5F, -10.5F, -3 + Math.abs(i - 3) * 0.8F, -0.45F, 0, (i - 3) * 0.22F));
			}
			case OBITO -> {
				head.addOrReplaceChild("crest", c(PLATE).addBox(-2, -3.5F, -0.5F, 4, 3.5F, 1), PartPose.offset(0, -8, -6));
				for (int i = 0; i < 5; i++)
					head.addOrReplaceChild("spike" + i, c(FLAME).addBox(-1, -5, -1, 2, 5, 2),
							PartPose.offsetAndRotation(-4 + i * 2, -11, 1, -0.6F, 0, (i - 2) * 0.3F));
			}
		}
	}

	/** Markings on the body: Itachi's spirals, Shisui's ringed belly, Madara's plated spine. */
	private static void marks(PartDefinition body, Owner owner) {
		switch (owner) {
			case ITACHI -> {
				body.addOrReplaceChild("spiral_r", c(MARK).addBox(-4, -4, -0.5F, 8, 8, 1), PartPose.offsetAndRotation(-10.5F, -14, 0, 0, PI / 2, 0));
				body.addOrReplaceChild("spiral_l", c(MARK).addBox(-4, -4, -0.5F, 8, 8, 1), PartPose.offsetAndRotation(10.5F, -14, 0, 0, PI / 2, 0));
			}
			case SHISUI -> {
				for (int i = 0; i < 4; i++)
					body.addOrReplaceChild("belly" + i, c(MARK).addBox(-5, -1.2F, -0.5F, 10, 2.4F, 1), PartPose.offset(0, -2 - i * 3, -5.6F));
			}
			default -> {
			}
		}
	}

	/** The Armoured stage's plates: breastplate and backplate, tassets over the flame, the helm on the head, Sasuke's mane of flame. */
	private static void armour(PartDefinition body, Owner owner) {
		body.addOrReplaceChild("breastplate", c(ARMOR).addBox(-11, -21.5F, -7.9F, 22, 8, 1.5F).texOffs(ARMOR[0], ARMOR[1]).addBox(-9, -13.5F, -6.9F, 18, 4, 1.4F),
				PartPose.ZERO);
		body.addOrReplaceChild("backplate", c(ARMOR).addBox(-11, -21.5F, 5.6F, 22, 12, 1.5F), PartPose.ZERO);
		for (int side : new int[] { -1, 1 })
			body.addOrReplaceChild("tasset" + side, c(ARMOR).addBox(-4, 0, -1, 8, 7, 1.2F), PartPose.offsetAndRotation(side * 4.5F, 0, -5.5F, -0.15F, 0, side * 0.1F));
		body.getChild("head").addOrReplaceChild("helm", c(ARMOR).addBox(-5.8F, -12, -6.3F, 11.6F, 4, 11.6F).texOffs(ARMOR[0], ARMOR[1])
				.addBox(-6, -8, -6.6F, 1.2F, 6, 11).addBox(4.8F, -8, -6.6F, 1.2F, 6, 11), PartPose.ZERO);
		if (owner == Owner.SASUKE)
			mane(body.getChild("head"));
	}

	/** Sasuke's mane: spikes of flame fanned round the back and sides of the head, the way his armoured and complete ones have it. */
	private static void mane(PartDefinition head) {
		PartDefinition mane = head.addOrReplaceChild("flame_mane", none(), PartPose.offset(0, -6, 1));
		for (int ring = 0; ring < 2; ring++)
			for (int i = 0; i < 9; i++) {
				float a = (i - 4) * 0.36F;
				float len = 7 + ring * 3 - Math.abs(i - 4) * 0.6F;
				mane.addOrReplaceChild("spike" + ring + "_" + i, c(FLAME).addBox(-1.5F, -len, -1.5F, 3, len, 3),
						PartPose.offsetAndRotation((float) Math.sin(a) * (6 + ring), -ring * 3, (float) Math.cos(a) * (5 + ring), -0.5F - ring * 0.25F, a, 0));
			}
	}

	/** Weapons in the hands: Sasuke's bow in the left (and the Kagutsuchi sword in the right from the Armoured stage on). */
	private static void weapons(PartDefinition body, Owner owner, int stage) {
		if (owner != Owner.SASUKE)
			return;
		// the bow held upright in the left fist: a curved stave of flame and its string
		PartDefinition bow = body.getChild("left_arm").getChild("forearm").getChild("hand").addOrReplaceChild("weapon_bow", none(),
				PartPose.offsetAndRotation(0, 3, -1, 1.2F, 0, 0));
		for (int i = -3; i <= 3; i++)
			bow.addOrReplaceChild("stave" + (i + 3), c(WEAPON).addBox(-0.8F, -2.6F, -0.8F, 1.6F, 5.2F, 1.6F),
					PartPose.offsetAndRotation(0, i * 4.6F, -Math.abs(i) * Math.abs(i) * 0.45F, i * 0.18F, 0, 0));
		bow.addOrReplaceChild("string", c(EYE).addBox(-0.2F, -15, -0.2F, 0.4F, 30, 0.4F), PartPose.offset(0, 0, 0.8F));
		if (stage >= 4)
			sword(body, Owner.SASUKE, 26, DARK);
	}

	/** A sword in the right fist, its blade forward and down. */
	private static void sword(PartDefinition body, Owner owner, float length, int[] blade) {
		body.getChild("right_arm").getChild("forearm").getChild("hand").addOrReplaceChild("weapon",
				c(blade).addBox(-1, 0, -1.6F, 2, length, 3.2F).texOffs(PLATE[0], PLATE[1]).addBox(-2.6F, -1.2F, -2.6F, 5.2F, 1.2F, 5.2F)
						.addBox(-1.2F, -6, -1.2F, 2.4F, 5, 2.4F),
				PartPose.offsetAndRotation(0, 6, -1, -1.25F, 0, 0));
	}

	// ------------------------------------------------------------------ stage 5: the complete Susanoo
	private static void complete(PartDefinition root, Owner owner) {
		// legs: from the hips (at +2) down to the feet (at +24), where the user floats in the belly
		for (int side : new int[] { -1, 1 }) {
			String name = side < 0 ? "right_leg" : "left_leg";
			PartDefinition leg = root.addOrReplaceChild(name, c(CHAKRA).addBox(-4, 0, -4, 8, 11, 8).texOffs(ARMOR[0], ARMOR[1]).addBox(-4.4F, 1, -4.6F, 8.8F, 7, 1),
					PartPose.offset(side * 4.5F, 2, 0));
			PartDefinition shin = leg.addOrReplaceChild("shin", c(CHAKRA).addBox(-3.3F, 0, -3.3F, 6.6F, 10, 6.6F).texOffs(ARMOR[0], ARMOR[1])
					.addBox(-3.8F, 0.5F, -4, 7.6F, 8, 1.2F).addBox(-2.5F, -1.5F, -4.4F, 5, 3, 1.5F), PartPose.offset(0, 11, 0));
			shin.addOrReplaceChild("foot", c(ARMOR).addBox(-3.8F, 0, -6, 7.6F, 2.5F, 10), PartPose.offset(0, 10, 0));
		}
		PartDefinition body = root.addOrReplaceChild("body", none(), PartPose.ZERO);
		torso(body, owner, true, -1);
		body.addOrReplaceChild("hips", c(CHAKRA).addBox(-8, -2, -5, 16, 5, 10), PartPose.ZERO);
		// a robe's skirt over the thighs (Obito's long, the others' armour skirts) and a sash
		body.addOrReplaceChild("skirt", c(owner == Owner.OBITO ? CHAKRA : ARMOR).addBox(-9, 0, -6, 18, owner == Owner.OBITO ? 14 : 8, 12), PartPose.offset(0, 2, 0));
		body.addOrReplaceChild("sash", c(PLATE).addBox(-8.5F, -1.5F, -5.6F, 17, 3, 11.2F), PartPose.offset(0, -3, 0));
		body.addOrReplaceChild("breastplate", c(ARMOR).addBox(-11, -22.5F, -7.9F, 22, 8, 1.5F).texOffs(ARMOR[0], ARMOR[1]).addBox(-9, -14.5F, -6.9F, 18, 4, 1.4F),
				PartPose.ZERO);
		PartDefinition head = body.addOrReplaceChild("head", none(), PartPose.offset(0, -24, -0.5F));
		face(head, owner, true);
		head.addOrReplaceChild("helm", c(ARMOR).addBox(-5.8F, -12, -6.3F, 11.6F, 4, 11.6F).texOffs(ARMOR[0], ARMOR[1])
				.addBox(-6, -8, -6.6F, 1.2F, 6, 11).addBox(4.8F, -8, -6.6F, 1.2F, 6, 11), PartPose.ZERO);
		for (int side : new int[] { -1, 1 })
			arm(body, owner, side, true, -19);
		// the wings: tall, rising from the shoulder blades to well over the head, rows of feather tiles overlapping down them
		// (the user's complete model); Shisui and Itachi wear a mantle of flame instead
		boolean wings = owner == Owner.SASUKE || owner == Owner.OBITO || owner == Owner.MADARA;
		for (int side : new int[] { -1, 1 }) {
			String name = side < 0 ? "right_wing" : "left_wing";
			PartDefinition wing = body.addOrReplaceChild(name, none(), PartPose.offset(side * 4, -16, 7.5F));
			if (!wings) {
				wing.addOrReplaceChild("mantle", c(FLAME).addBox(-4, 0, 0, 8, 22, 2), PartPose.offsetAndRotation(side * 2, 0, 0, 0.25F, 0, side * 0.2F));
				continue;
			}
			wing.addOrReplaceChild("arm", c(ARMOR).addBox(-1.5F, -34, -1.5F, 3, 34, 3), PartPose.rotation(0, 0, side * 0.32F));
			for (int row = 0; row < 11; row++) {
				// each row a little wider than the one above, the lowest the widest; staggered like scales
				int tiles = 2 + Math.min(row, 6) / 2;
				for (int t = 0; t < tiles; t++) {
					float x = side * (2 + t * 3.1F + row * 0.9F + (row % 2) * 1.5F);
					float y = -36 + row * 3.4F;
					wing.addOrReplaceChild("tile" + row + "_" + t, c(row % 3 == 0 ? ARMOR : PLATE).addBox(-1.6F, 0, -0.6F, 3.2F, 5.5F, 1.2F),
							PartPose.offsetAndRotation(x, y, row * 0.15F + t * 0.25F, 0.08F, 0, side * 0.12F));
				}
			}
		}
		if (owner == Owner.SASUKE) {
			// the crest curling up off the helm and forward over the brow
			PartDefinition crest = head.addOrReplaceChild("crest", c(ARMOR).addBox(-1.5F, -4, -1.5F, 3, 4, 3), PartPose.offset(0, -12, 2));
			PartDefinition c2 = crest.addOrReplaceChild("c2", c(ARMOR).addBox(-1.3F, -4, -1.3F, 2.6F, 4, 2.6F), PartPose.offsetAndRotation(0, -4, 0, -0.6F, 0, 0));
			PartDefinition c3 = c2.addOrReplaceChild("c3", c(ARMOR).addBox(-1.1F, -4, -1.1F, 2.2F, 4, 2.2F), PartPose.offsetAndRotation(0, -4, 0, -0.7F, 0, 0));
			c3.addOrReplaceChild("c4", c(ARMOR).addBox(-0.8F, -4, -0.8F, 1.6F, 4, 1.6F), PartPose.offsetAndRotation(0, -4, 0, -0.7F, 0, 0));
			mane(head);
		}
		marks(body, owner);
		if (owner == Owner.SASUKE) {
			sword(body, owner, 34, WEAPON);
			weapons(body, owner, 3);
		}
		if (owner == Owner.OBITO)
			// the two great Kamui shuriken, one held in each hand
			for (String arm : new String[] { "right_arm", "left_arm" }) {
				PartDefinition shuriken = body.getChild(arm).getChild("forearm").getChild("hand").addOrReplaceChild("weapon", none(),
						PartPose.offsetAndRotation(0, 3, -9, PI / 2, 0, 0));
				for (int b = 0; b < 3; b++)
					shuriken.addOrReplaceChild("blade" + b, c(DARK).addBox(-2, -11, -0.8F, 5, 11, 1.6F), PartPose.rotation(0, 0, b * 2 * PI / 3));
				shuriken.addOrReplaceChild("hub", c(DARK).addBox(-3, -3, -1, 6, 6, 2), PartPose.ZERO);
			}
	}
}
