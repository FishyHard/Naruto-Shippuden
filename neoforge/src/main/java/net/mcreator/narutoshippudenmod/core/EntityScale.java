package net.mcreator.narutoshippudenmod.core;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import net.neoforged.neoforge.network.PacketDistributor;
import net.mcreator.narutoshippudenmod.compat.NetworkEvent;
import net.neoforged.fml.util.ObfuscationReflectionHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.mcreator.narutoshippudenmod.compat.TickEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.entity.EntityEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.phys.AABB;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.Map;
import java.util.WeakHashMap;
import java.lang.reflect.Field;
import java.util.IdentityHashMap;
import java.util.Collections;

/**
 * Built-in replacement for the Pehkui scale types the mod used (base, hitbox_width, hitbox_height, eye_height).
 * Scales live in the entity's persistent data, are synced to every client tracking the entity, and are applied
 * through the Forge size event (hitbox and eye height) and around the living renderer (visual size).
 */
@NarutoShippudenModElements.ModElement.Tag
public class EntityScale extends NarutoShippudenModElements.ModElement {
	private static final String KEY = "naruto_shippuden_scale";
	public static final String BASE = "base";
	public static final String HITBOX_WIDTH = "hitbox_width";
	public static final String HITBOX_HEIGHT = "hitbox_height";
	public static final String EYE_HEIGHT = "eye_height";

	public EntityScale(NarutoShippudenModElements elements) {
		super(elements, 0);
		elements.addNetworkMessage(SyncMessage.class, SyncMessage::encode, SyncMessage::new, SyncMessage::handle);
		NeoForge.EVENT_BUS.register(this);
	}

	/** Server side: equivalent of {@code /scale set pehkui:<type> <value>}. */
	public static void set(Entity entity, String type, double value) {
		if (entity.level().isClientSide())
			return;
		CompoundTag data = entity.getPersistentData().getCompoundOrEmpty(KEY);
		if (value == 1)
			data.remove(type);
		else
			data.putFloat(type, (float) value);
		if (data.isEmpty())
			entity.getPersistentData().remove(KEY);
		else
			entity.getPersistentData().put(KEY, data);
		entity.refreshDimensions();
		NarutoShippudenMod.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new SyncMessage(entity));
	}

	public static float get(Entity entity, String type) {
		CompoundTag data = entity.getPersistentData().getCompoundOrEmpty(KEY);
		return data.contains(type) ? data.getFloatOr(type, 0) : 1;
	}

	@SubscribeEvent
	public void onSize(EntityEvent.Size event) {
		Entity entity = event.getEntity();
		if (!entity.getPersistentData().contains(KEY))
			return;
		float eyeHeight = event.getNewEyeHeight();
		event.setNewSize(scaled(entity, event.getNewSize()), false);
		event.setNewEyeHeight(eyeHeight * get(entity, BASE) * get(entity, EYE_HEIGHT));
	}

	private static EntityDimensions scaled(Entity entity, EntityDimensions size) {
		float base = get(entity, BASE);
		return size.scale(base * get(entity, HITBOX_WIDTH), base * get(entity, HITBOX_HEIGHT));
	}

	/** Players whose pose this class is forcing, so the force can be lifted once they are back to normal size. */
	private static final Set<Player> forcedPoses = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<>()));

	/**
	 * Vanilla picks standing/crouching/crawling by testing fixed full-size player boxes, so a shrunk player was put
	 * into the crawling pose under a one-block gap (and a grown one could stand inside blocks). Redo that choice
	 * with the scaled boxes and hand it to the Forge forced-pose hook, which vanilla's updatePose then applies.
	 */
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent.Post event) {
		if (event.phase != TickEvent.Phase.START)
			return;
		Player player = event.getEntity();
		if (player.getPersistentData().contains(KEY)) {
			player.setForcedPose(choosePose(player));
			forcedPoses.add(player);
		} else if (forcedPoses.remove(player)) {
			player.setForcedPose(null);
		}
	}

	/** Same decision as Player.updatePose, but testing the scaled boxes. */
	private static Pose choosePose(Player player) {
		if (!player.isAlive() || player.getPose() == Pose.DYING || !fits(player, Pose.SWIMMING))
			return player.getPose();
		Pose pose;
		if (player.isFallFlying())
			pose = Pose.FALL_FLYING;
		else if (player.isSleeping())
			pose = Pose.SLEEPING;
		else if (player.isSwimming())
			pose = Pose.SWIMMING;
		else if (player.isAutoSpinAttack())
			pose = Pose.SPIN_ATTACK;
		else if (player.isShiftKeyDown() && !player.getAbilities().flying)
			pose = Pose.CROUCHING;
		else
			pose = Pose.STANDING;
		if (!player.isSpectator() && !player.isPassenger() && !fits(player, pose))
			pose = fits(player, Pose.CROUCHING) ? Pose.CROUCHING : Pose.SWIMMING;
		return pose;
	}

	private static boolean fits(Player player, Pose pose) {
		EntityDimensions size = scaled(player, player.getDimensions(pose));
		double halfWidth = size.width / 2.0;
		AABB box = new AABB(player.getX() - halfWidth, player.getY(), player.getZ() - halfWidth,
				player.getX() + halfWidth, player.getY() + size.height, player.getZ() + halfWidth);
		return player.level().noCollision(player, box.deflate(1.0E-7D));
	}

	@SubscribeEvent
	public void onStartTracking(PlayerEvent.StartTracking event) {
		Entity target = event.getTarget();
		if (target.getPersistentData().contains(KEY) && event.getPlayer() instanceof ServerPlayer)
			NarutoShippudenMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getPlayer()),
					new SyncMessage(target));
	}

	@SubscribeEvent
	public void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
		resync(event.getPlayer());
	}

	@SubscribeEvent
	public void onChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		resync(event.getPlayer());
	}

	private static void resync(Entity entity) {
		if (entity.level().isClientSide() || !entity.getPersistentData().contains(KEY))
			return;
		entity.refreshDimensions();
		NarutoShippudenMod.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new SyncMessage(entity));
	}

	/** Entities whose render matrix was pushed for scaling and still needs popping. */
	private static final Set<Entity> scaledRenders = Collections.newSetFromMap(new IdentityHashMap<>());

	/** Unscaled shadow radius of every renderer that has drawn a scaled entity. Renderers are shared per entity type. */
	private static final Map<EntityRenderer<?>, Float> originalShadows = new IdentityHashMap<>();
	private static Field shadowSizeField;

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onRenderPre(RenderLivingEvent.Pre<?, ?> event) {
		float base = get(event.getEntity(), BASE);
		if (ModelSwapRenderers.isOwnRenderer(event.getRenderer()))
			return;
		scaleShadow(event.getRenderer(), base);
		if (base != 1 && scaledRenders.add(event.getEntity())) {
			event.getMatrixStack().pushPose();
			event.getMatrixStack().scale(base, base, base);
		}
	}

	/**
	 * The shadow is drawn after the entity with the renderer's shadow radius, outside the scaled matrix. Set the
	 * radius for each entity before it renders; entities at normal size get the original radius back.
	 */
	@OnlyIn(Dist.CLIENT)
	private static void scaleShadow(EntityRenderer<?> renderer, float base) {
		try {
			if (shadowSizeField == null)
				shadowSizeField = ObfuscationReflectionHelper.findField(EntityRenderer.class, "shadowRadius");
			Float original = originalShadows.get(renderer);
			if (original == null) {
				if (base == 1)
					return;
				original = shadowSizeField.getFloatOr(renderer, 0);
				originalShadows.put(renderer, original);
			}
			shadowSizeField.setFloat(renderer, original * base);
		} catch (ReflectiveOperationException | RuntimeException e) {
			NarutoShippudenMod.LOGGER.debug("Could not scale shadow", e);
		}
	}

	/** Post does not fire for a cancelled Pre (the model swaps cancel it), so pop here in that case. */
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOWEST, receiveCanceled = true)
	public void onRenderPreCancelled(RenderLivingEvent.Pre<?, ?> event) {
		if (event.isCanceled() && !ModelSwapRenderers.isOwnRenderer(event.getRenderer()) && scaledRenders.remove(event.getEntity()))
			event.getMatrixStack().popPose();
	}

	/** Lowest priority so overlays other handlers draw in Post (dojutsu eyes, Susanoo) still get the scale. */
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onRenderPost(RenderLivingEvent.Post<?, ?> event) {
		if (!ModelSwapRenderers.isOwnRenderer(event.getRenderer()) && scaledRenders.remove(event.getEntity()))
			event.getMatrixStack().popPose();
	}

	public static class SyncMessage {
		private final int entityId;
		private final CompoundTag data;

		SyncMessage(Entity entity) {
			this.entityId = entity.getId();
			this.data = entity.getPersistentData().getCompoundOrEmpty(KEY);
		}

		SyncMessage(FriendlyByteBuf buffer) {
			this.entityId = buffer.readVarInt();
			this.data = buffer.readNbt();
		}

		static void encode(SyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeVarInt(message.entityId);
			buffer.writeNbt(message.data);
		}

		static void handle(SyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			if (context.getDirection().getReceptionSide().isClient())
				context.enqueueWork(() -> ClientHandler.apply(message));
			context.setPacketHandled(true);
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class ClientHandler {
		static void apply(SyncMessage message) {
			if (Minecraft.getInstance().level == null)
				return;
			Entity entity = Minecraft.getInstance().level.getEntity(message.entityId);
			if (entity == null)
				return;
			if (message.data == null || message.data.isEmpty())
				entity.getPersistentData().remove(KEY);
			else
				entity.getPersistentData().put(KEY, message.data);
			entity.refreshDimensions();
		}
	}
}
