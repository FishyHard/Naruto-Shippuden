package net.mcreator.narutoshippudenmod.compat;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Carries the old SimpleChannel-style messages (a class with encoder, decoder and handler) over NeoForge payloads.
 * Each message class gets its own payload type named after the class.
 */
public final class ModNetwork {
	private static final List<Entry<?>> ENTRIES = new ArrayList<>();
	private static final Map<Class<?>, Entry<?>> BY_CLASS = new HashMap<>();

	private ModNetwork() {
	}

	private record Entry<T>(Class<T> type, CustomPacketPayload.Type<Payload<T>> payloadType, StreamCodec<RegistryFriendlyByteBuf, Payload<T>> codec,
			BiConsumer<T, Supplier<NetworkEvent.Context>> handler) {
	}

	public record Payload<T>(CustomPacketPayload.Type<Payload<T>> type, T message) implements CustomPacketPayload {
	}

	public static <T> void register(Class<T> type, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> handler) {
		String name = type.getName().substring(type.getName().lastIndexOf('.') + 1).replace('$', '_').toLowerCase(Locale.ROOT);
		CustomPacketPayload.Type<Payload<T>> payloadType = new CustomPacketPayload.Type<>(Identifier.fromNamespaceAndPath("naruto_shippuden", name));
		StreamCodec<RegistryFriendlyByteBuf, Payload<T>> codec = StreamCodec.of((buf, payload) -> encoder.accept(payload.message(), buf),
				buf -> new Payload<>(payloadType, decoder.apply(buf)));
		Entry<T> entry = new Entry<>(type, payloadType, codec, handler);
		ENTRIES.add(entry);
		BY_CLASS.put(type, entry);
	}

	public static void registerPayloads(RegisterPayloadHandlersEvent event) {
		var registrar = event.registrar("1").optional();
		for (Entry<?> entry : ENTRIES)
			registerOne(registrar, entry);
	}

	private static <T> void registerOne(net.neoforged.neoforge.network.registration.PayloadRegistrar registrar, Entry<T> entry) {
		registrar.playToServer(entry.payloadType(), entry.codec(),
				(Payload<T> payload, IPayloadContext context) -> entry.handler().accept(payload.message(), () -> new NetworkEvent.Context(context)));
	}

	@SuppressWarnings("unchecked")
	private static <T> Payload<T> wrap(T message) {
		Entry<T> entry = (Entry<T>) BY_CLASS.get(message.getClass());
		if (entry == null)
			throw new IllegalArgumentException("Unregistered message " + message.getClass());
		return new Payload<>(entry.payloadType(), message);
	}

	/** Same surface as the old SimpleChannel for the calls the mod makes. */
	public static final class Channel {
		public void sendToServer(Object message) {
			ClientPacketDistributor.sendToServer(wrap(message));
		}

		public void sendToPlayer(ServerPlayer player, Object message) {
			PacketDistributor.sendToPlayer(player, wrap(message));
		}
	}
}
