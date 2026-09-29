package net.mcreator.narutoshippudenmod.core.jutsu.engine;

import com.mojang.math.Transformation;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Brightness;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;

import java.util.HashMap;
import java.util.Map;

import org.joml.Matrix4f;

/**
 * Real blocks shaped by jutsu without touching the world: block display entities that grow in, move and shrink away smoothly
 * (the client interpolates between the shapes). Used for Wood Release trees and Ice Release mirrors; none are ever saved.
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class Displays {
	private static final String TAG = "naruto_shippuden.jutsu_display";
	private static final Map<Display.BlockDisplay, Matrix4f> LIVE = new HashMap<>();

	private Displays() {
	}

	/**
	 * A box of a block: centred on its base at the given point, turned by yaw (around Y), then tilted by pitch (around its own X),
	 * sized w × h × d blocks.
	 */
	public static Matrix4f box(float yaw, float pitch, float w, float h, float d) {
		return new Matrix4f().rotateY(yaw).rotateX(pitch).scale(w, h, d).translate(-0.5F, 0, -0.5F);
	}

	/** Like {@link #box}, shifted by dx, dy in its own turned and tilted frame (the parts of a framed panel). */
	public static Matrix4f box(float yaw, float pitch, float dx, float dy, float w, float h, float d) {
		return new Matrix4f().rotateY(yaw).rotateX(pitch).translate(dx, dy, 0).scale(w, h, d).translate(-0.5F, 0, -0.5F);
	}

	/** Spawns a block display at a point that grows from nothing into its shape over the given ticks, and lives for life ticks. */
	public static Display.BlockDisplay grow(ServerLevel level, Vec3 at, BlockState block, Matrix4f shape, int growTicks, int life, boolean bright) {
		Display.BlockDisplay display = new Display.BlockDisplay(EntityTypes.BLOCK_DISPLAY, level);
		display.setPos(at);
		display.setBlockState(block);
		display.setTransformation(new Transformation(shrunk(shape)));
		if (bright)
			display.setBrightnessOverride(Brightness.FULL_BRIGHT);
		display.addTag(TAG);
		level.addFreshEntity(display);
		LIVE.put(display, new Matrix4f(shape));
		// the first shape has to reach the client before the one it interpolates to
		Techniques.after(level, 1, () -> animate(display, shape, growTicks));
		Techniques.after(level, life, () -> remove(display, 4));
		return display;
	}

	/** The shape shrunk to a speck at its own centre (to grow from or vanish into). */
	private static Matrix4f shrunk(Matrix4f shape) {
		return new Matrix4f(shape).translate(0.5F, 0.5F, 0.5F).scale(0.01F).translate(-0.5F, -0.5F, -0.5F);
	}

	/** Moves a display smoothly into a new shape. */
	public static void animate(Display.BlockDisplay display, Matrix4f shape, int ticks) {
		if (display.isRemoved())
			return;
		if (LIVE.containsKey(display))
			LIVE.put(display, new Matrix4f(shape));
		display.setTransformationInterpolationDuration(ticks);
		display.setTransformation(new Transformation(shape));
		display.setTransformationInterpolationDelay(0);
	}

	/** Shrinks a display away and removes it. */
	public static void remove(Display.BlockDisplay display, int ticks) {
		if (display.isRemoved())
			return;
		Matrix4f shape = LIVE.get(display);
		if (shape != null)
			animate(display, shrunk(shape), ticks);
		Techniques.after((ServerLevel) display.level(), ticks, () -> {
			display.discard();
			LIVE.remove(display);
		});
	}

	@SubscribeEvent
	public static void stopping(ServerStoppingEvent event) {
		for (Display.BlockDisplay display : LIVE.keySet())
			display.discard();
		LIVE.clear();
	}

	/** Displays left behind by a crash are removed when their chunk loads. */
	@SubscribeEvent
	public static void loaded(EntityJoinLevelEvent event) {
		if (event.loadedFromDisk() && event.getEntity() instanceof Display && event.getEntity().entityTags().contains(TAG))
			event.setCanceled(true);
	}
}
