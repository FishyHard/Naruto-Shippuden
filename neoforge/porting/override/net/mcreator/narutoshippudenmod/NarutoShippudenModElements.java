package net.mcreator.narutoshippudenmod;

import net.mcreator.narutoshippudenmod.compat.ModNetwork;
import net.mcreator.narutoshippudenmod.compat.NetworkEvent;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforgespi.language.ModFileScanData;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Collects the mod's elements (the classes tagged with {@link ModElement.Tag}) and what they register.
 * Registration itself happens in {@link NarutoShippudenMod} from the RegisterEvent.
 */
public class NarutoShippudenModElements {
	public final List<ModElement> elements = new ArrayList<>();
	public final List<Supplier<Block>> blocks = new ArrayList<>();
	public final List<Supplier<Item>> items = new ArrayList<>();
	public final List<Supplier<EntityType<?>>> entities = new ArrayList<>();
	public static final Map<Identifier, SoundEvent> sounds = new LinkedHashMap<>();

	public NarutoShippudenModElements() {
		for (String name : new String[]{"dust_release_and_tailed_beast_bomb", "sharingan", "isshiki_dojutsu", "byakugan", "flying_thunder_god_sound",
				"tenseigan", "rinnegan", "dust_release", "shadow_clone", "clone_death", "kamui", "mangekyou_sharingan"}) {
			Identifier id = Identifier.fromNamespaceAndPath(NarutoShippudenMod.MODID, name);
			sounds.put(id, SoundEvent.createVariableRangeEvent(id));
		}
		try {
			ModFileScanData scan = ModList.get().getModFileById(NarutoShippudenMod.MODID).getFile().getScanResult();
			for (ModFileScanData.AnnotationData data : scan.getAnnotations()) {
				if (data.annotationType().getClassName().equals(ModElement.Tag.class.getName())) {
					Class<?> clazz = Class.forName(data.clazz().getClassName());
					if (clazz.getSuperclass() == ModElement.class)
						elements.add((ModElement) clazz.getConstructor(getClass()).newInstance(this));
				}
			}
		} catch (Exception e) {
			throw new IllegalStateException("Failed to load mod elements", e);
		}
		Collections.sort(elements);
		elements.forEach(ModElement::initElements);
	}

	public <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder,
			BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		ModNetwork.register(messageType, encoder, decoder, messageConsumer);
	}

	public List<ModElement> getElements() {
		return elements;
	}

	public static class ModElement implements Comparable<ModElement> {
		@Retention(RetentionPolicy.RUNTIME)
		public @interface Tag {
		}

		protected final NarutoShippudenModElements elements;
		protected final int sortid;

		public ModElement(NarutoShippudenModElements elements, int sortid) {
			this.elements = elements;
			this.sortid = sortid;
		}

		public void initElements() {
		}

		public void init(FMLCommonSetupEvent event) {
		}

		public void serverLoad(ServerStartingEvent event) {
		}

		@OnlyIn(Dist.CLIENT)
		public void clientLoad(FMLClientSetupEvent event) {
		}

		@Override
		public int compareTo(ModElement other) {
			return this.sortid - other.sortid;
		}
	}
}
