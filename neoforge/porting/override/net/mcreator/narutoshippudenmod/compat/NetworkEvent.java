package net.mcreator.narutoshippudenmod.compat;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

/** Minimal stand-in for Forge's NetworkEvent so the old message handlers compile unchanged. */
public final class NetworkEvent {
	private NetworkEvent() {
	}

	public static final class Context {
		private final IPayloadContext context;

		public Context(IPayloadContext context) {
			this.context = context;
		}

		public ServerPlayer getSender() {
			return context.player() instanceof ServerPlayer player ? player : null;
		}

		public void enqueueWork(Runnable work) {
			context.enqueueWork(work);
		}

		public void setPacketHandled(boolean handled) {
		}

		public Direction getDirection() {
			return new Direction(context.flow().isServerbound());
		}
	}

	public record Direction(boolean toServer) {
		public Side getReceptionSide() {
			return new Side(toServer);
		}
	}

	public record Side(boolean server) {
		public boolean isServer() {
			return server;
		}

		public boolean isClient() {
			return !server;
		}
	}
}
