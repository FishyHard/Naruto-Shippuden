package net.mcreator.narutoshippudenmod.core;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import net.mcreator.narutoshippudenmod.NarutoShippudenModElements;
import net.mcreator.narutoshippudenmod.NarutoShippudenMod;

import java.util.function.Supplier;
import java.util.Set;
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
		float base = get(entity, BASE);
		EntitySize size = event.getNewSize();
		float eyeHeight = event.getNewEyeHeight();
		event.setNewSize(size.scale(base * get(entity, HITBOX_WIDTH), base * get(entity, HITBOX_HEIGHT)), false);
		event.setNewEyeHeight(eyeHeight * base * get(entity, EYE_HEIGHT));
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

	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void onRenderPre(RenderLivingEvent.Pre<?, ?> event) {
		float base = get(event.getEntity(), BASE);
		if (base != 1 && !ModelSwapRenderers.isOwnRenderer(event.getRenderer()) && scaledRenders.add(event.getEntity())) {
			event.getMatrixStack().push();
			event.getMatrixStack().scale(base, base, base);
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
