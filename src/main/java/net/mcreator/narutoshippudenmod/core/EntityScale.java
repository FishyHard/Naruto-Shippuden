package net.mcreator.narutoshippudenmod.core;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Entity;
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
		MinecraftForge.EVENT_BUS.register(this);
	}

	/** Server side: equivalent of {@code /scale set pehkui:<type> <value>}. */
	public static void set(Entity entity, String type, double value) {
		if (entity.world.isRemote)
			return;
		CompoundNBT data = entity.getPersistentData().getCompound(KEY);
		if (value == 1)
			data.remove(type);
		else
			data.putFloat(type, (float) value);
		if (data.isEmpty())
			entity.getPersistentData().remove(KEY);
		else
			entity.getPersistentData().put(KEY, data);
		entity.recalculateSize();
		NarutoShippudenMod.PACKET_HANDLER.send(PacketDistributor.TRACKING_ENTITY_AND_SELF.with(() -> entity), new SyncMessage(entity));
	}

	public static float get(Entity entity, String type) {
		CompoundNBT data = entity.getPersistentData().getCompound(KEY);
		return data.contains(type) ? data.getFloat(type) : 1;
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

	private static EntitySize scaled(Entity entity, EntitySize size) {
		float base = get(entity, BASE);
		return size.scale(base * get(entity, HITBOX_WIDTH), base * get(entity, HITBOX_HEIGHT));
	}

	/** Players whose pose this class is forcing, so the force can be lifted once they are back to normal size. */
	private static final Set<PlayerEntity> forcedPoses = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap<>()));

	/**
	 * Vanilla picks standing/crouching/crawling by testing fixed full-size player boxes, so a shrunk player was put
	 * into the crawling pose under a one-block gap (and a grown one could stand inside blocks). Redo that choice
	 * with the scaled boxes and hand it to the Forge forced-pose hook, which vanilla's updatePose then applies.
	 */
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase != TickEvent.Phase.START)
			return;
		PlayerEntity player = event.player;
		if (player.getPersistentData().contains(KEY)) {
			player.setForcedPose(choosePose(player));
			forcedPoses.add(player);
		} else if (forcedPoses.remove(player)) {
			player.setForcedPose(null);
		}
	}

	/** Same decision as PlayerEntity.updatePose, but testing the scaled boxes. */
	private static Pose choosePose(PlayerEntity player) {
		if (!player.isAlive() || player.getPose() == Pose.DYING || !fits(player, Pose.SWIMMING))
			return player.getPose();
		Pose pose;
		if (player.isElytraFlying())
			pose = Pose.FALL_FLYING;
		else if (player.isSleeping())
			pose = Pose.SLEEPING;
		else if (player.isSwimming())
			pose = Pose.SWIMMING;
		else if (player.isSpinAttacking())
			pose = Pose.SPIN_ATTACK;
		else if (player.isSneaking() && !player.abilities.isFlying)
			pose = Pose.CROUCHING;
		else
			pose = Pose.STANDING;
		if (!player.isSpectator() && !player.isPassenger() && !fits(player, pose))
			pose = fits(player, Pose.CROUCHING) ? Pose.CROUCHING : Pose.SWIMMING;
		return pose;
	}

	private static boolean fits(PlayerEntity player, Pose pose) {
		EntitySize size = scaled(player, player.getSize(pose));
		double halfWidth = size.width / 2.0;
		AxisAlignedBB box = new AxisAlignedBB(player.getPosX() - halfWidth, player.getPosY(), player.getPosZ() - halfWidth,
				player.getPosX() + halfWidth, player.getPosY() + size.height, player.getPosZ() + halfWidth);
		return player.world.hasNoCollisions(player, box.shrink(1.0E-7D));
	}

	@SubscribeEvent
	public void onStartTracking(PlayerEvent.StartTracking event) {
		Entity target = event.getTarget();
		if (target.getPersistentData().contains(KEY) && event.getPlayer() instanceof ServerPlayerEntity)
			NarutoShippudenMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) event.getPlayer()),
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
		if (entity.world.isRemote || !entity.getPersistentData().contains(KEY))
			return;
		entity.recalculateSize();
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
			event.getMatrixStack().push();
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
				shadowSizeField = ObfuscationReflectionHelper.findField(EntityRenderer.class, "field_76989_e");
			Float original = originalShadows.get(renderer);
			if (original == null) {
				if (base == 1)
					return;
				original = shadowSizeField.getFloat(renderer);
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
			event.getMatrixStack().pop();
	}

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public void onRenderPost(RenderLivingEvent.Post<?, ?> event) {
		if (!ModelSwapRenderers.isOwnRenderer(event.getRenderer()) && scaledRenders.remove(event.getEntity()))
			event.getMatrixStack().pop();
	}

	public static class SyncMessage {
		private final int entityId;
		private final CompoundNBT data;

		SyncMessage(Entity entity) {
			this.entityId = entity.getEntityId();
			this.data = entity.getPersistentData().getCompound(KEY);
		}

		SyncMessage(PacketBuffer buffer) {
			this.entityId = buffer.readVarInt();
			this.data = buffer.readCompoundTag();
		}

		static void encode(SyncMessage message, PacketBuffer buffer) {
			buffer.writeVarInt(message.entityId);
			buffer.writeCompoundTag(message.data);
		}

		static void handle(SyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			if (context.getDirection().getReceptionSide().isClient())
				context.enqueueWork(() -> ClientHandler.apply(message));
			context.setPacketHandled(true);
		}
	}

	@OnlyIn(Dist.CLIENT)
	private static class ClientHandler {
		static void apply(SyncMessage message) {
			if (Minecraft.getInstance().world == null)
				return;
			Entity entity = Minecraft.getInstance().world.getEntityByID(message.entityId);
			if (entity == null)
				return;
			if (message.data == null || message.data.isEmpty())
				entity.getPersistentData().remove(KEY);
			else
				entity.getPersistentData().put(KEY, message.data);
			entity.recalculateSize();
		}
	}
}
