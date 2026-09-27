package net.mcreator.narutoshippudenmod.core;

import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/**
 * Replacement for the Pehkui scale types the mod used.
 * <ul>
 * <li>base: the vanilla scale attribute, which already scales model, hitbox, eye height, shadow and pose checks and is
 * synced and saved by the game;</li>
 * <li>hitbox_width, hitbox_height, eye_height: extra multipliers kept in the entity's persistent data, synced to
 * tracking clients and applied through the size event.</li>
 * </ul>
 */
@EventBusSubscriber(modid = "naruto_shippuden")
public final class EntityScale {
	private static final String KEY = "naruto_shippuden_scale";
	private static final Identifier MODIFIER = Identifier.fromNamespaceAndPath("naruto_shippuden", "jutsu_scale");
	public static final String BASE = "base";
	public static final String HITBOX_WIDTH = "hitbox_width";
	public static final String HITBOX_HEIGHT = "hitbox_height";
	public static final String EYE_HEIGHT = "eye_height";

	private EntityScale() {
	}

	public static void register(IEventBus modBus) {
		modBus.addListener(EntityScale::registerPayloads);
	}

	/** Server side: equivalent of {@code /scale set pehkui:<type> <value>}. */
	public static void set(Entity entity, String type, double value) {
		if (entity.level().isClientSide())
			return;
		if (BASE.equals(type)) {
			if (entity instanceof LivingEntity living) {
				AttributeInstance scale = living.getAttribute(Attributes.SCALE);
				if (scale != null) {
					scale.removeModifier(MODIFIER);
					if (value != 1)
						scale.addPermanentModifier(new AttributeModifier(MODIFIER, value - 1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
				}
			}
			return;
		}
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
		PacketDistributor.sendToPlayersTrackingEntityAndSelf(entity, new SyncPayload(entity.getId(), data));
	}

	public static float get(Entity entity, String type) {
		if (BASE.equals(type))
			return entity instanceof LivingEntity living ? living.getScale() : 1;
		CompoundTag data = entity.getPersistentData().getCompoundOrEmpty(KEY);
		return data.getFloatOr(type, 1);
	}

	@SubscribeEvent
	public static void onSize(EntityEvent.Size event) {
		Entity entity = event.getEntity();
		if (!entity.getPersistentData().contains(KEY))
			return;
		EntityDimensions size = event.getNewSize();
		EntityDimensions scaled = size.scale(get(entity, HITBOX_WIDTH), get(entity, HITBOX_HEIGHT));
		event.setNewSize(scaled.withEyeHeight(size.eyeHeight() * get(entity, EYE_HEIGHT)));
	}

	@SubscribeEvent
	public static void onStartTracking(PlayerEvent.StartTracking event) {
		Entity target = event.getTarget();
		if (target.getPersistentData().contains(KEY) && event.getEntity() instanceof net.minecraft.server.level.ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new SyncPayload(target.getId(), target.getPersistentData().getCompoundOrEmpty(KEY)));
	}

	@SubscribeEvent
	public static void onLogin(PlayerEvent.PlayerLoggedInEvent event) {
		resync(event.getEntity());
	}

	@SubscribeEvent
	public static void onChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		resync(event.getEntity());
	}

	private static void resync(Entity entity) {
		if (entity.level().isClientSide() || !entity.getPersistentData().contains(KEY))
			return;
		entity.refreshDimensions();
		PacketDistributor.sendToPlayersTrackingEntityAndSelf(entity, new SyncPayload(entity.getId(), entity.getPersistentData().getCompoundOrEmpty(KEY)));
	}

	public record SyncPayload(int entityId, CompoundTag data) implements CustomPacketPayload {
		public static final Type<SyncPayload> TYPE = new Type<>(Identifier.fromNamespaceAndPath("naruto_shippuden", "entity_scale"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SyncPayload> CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, SyncPayload::entityId,
				ByteBufCodecs.COMPOUND_TAG, SyncPayload::data, SyncPayload::new);

		@Override
		public Type<SyncPayload> type() {
			return TYPE;
		}
	}

	private static void registerPayloads(RegisterPayloadHandlersEvent event) {
		event.registrar("1").playToClient(SyncPayload.TYPE, SyncPayload.CODEC, EntityScale::handle);
	}

	private static void handle(SyncPayload payload, IPayloadContext context) {
		context.enqueueWork(() -> {
			Entity entity = context.player().level().getEntity(payload.entityId());
			if (entity == null)
				return;
			if (payload.data().isEmpty())
				entity.getPersistentData().remove(KEY);
			else
				entity.getPersistentData().put(KEY, payload.data());
			entity.refreshDimensions();
		});
	}
}
