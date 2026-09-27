package net.mcreator.narutoshippudenmod.compat;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Registration glue replacing @ObjectHolder and setRegistryName. Objects that need their id at construction time
 * (items, blocks, entity types) record it through {@link #itemProps}, {@link #blockProps} or {@link #entityKey} while
 * being built; {@link #holder} replaces the old @ObjectHolder static fields.
 */
public final class Registration {
	public static final String MODID = "naruto_shippuden";
	private static String pendingName;
	private static final Map<String, List<Consumer<Object>>> HOLDERS = new HashMap<>();
	private static final List<Entry<?>> EXTRA = new ArrayList<>();

	private Registration() {
	}

	private record Entry<T>(ResourceKey<? extends Registry<T>> registry, String name, Supplier<? extends T> factory, Consumer<Holder<T>> onRegistered) {
	}

	public static Identifier id(String name) {
		return Identifier.fromNamespaceAndPath(MODID, name);
	}

	/** Item properties carrying the item's id (required before an item is constructed). */
	public static Item.Properties itemProps(String name) {
		pendingName = name;
		return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, id(name)));
	}

	/** Creative tab name (the old ItemGroup element class) -> item names, in registration order. */
	public static final Map<String, List<String>> TAB_ITEMS = new HashMap<>();

	/** Item properties carrying the item's id, also recording which creative tab lists it (null = none). */
	public static Item.Properties itemProps(String name, String tab) {
		if (tab != null)
			TAB_ITEMS.computeIfAbsent(tab, k -> new ArrayList<>()).add(name);
		return itemProps(name);
	}

	/** Adds the block's id to its properties (required before a block is constructed). */
	public static BlockBehaviour.Properties blockProps(String name, BlockBehaviour.Properties properties) {
		pendingName = name;
		return properties.setId(ResourceKey.create(Registries.BLOCK, id(name)));
	}

	/** Key for EntityType.Builder.build. */
	public static ResourceKey<EntityType<?>> entityKey(String name) {
		pendingName = name;
		return ResourceKey.create(Registries.ENTITY_TYPE, id(name));
	}

	/** Called with the object registered under this name (replaces @ObjectHolder fields). */
	public static void holder(String name, Consumer<Object> setter) {
		HOLDERS.computeIfAbsent(name, k -> new ArrayList<>()).add(setter);
	}

	/** Registers an item/block/entity type built by the supplier under the name it recorded while being built. */
	public static <T> void registerNamed(RegisterEvent.RegisterHelper<T> helper, Supplier<? extends T> supplier) {
		pendingName = null;
		T value = supplier.get();
		String name = pendingName;
		if (name == null)
			throw new IllegalStateException("Object registered without a name: " + value);
		pendingName = null;
		helper.register(id(name), value);
		fire(name, value);
	}

	private static void fire(String name, Object value) {
		List<Consumer<Object>> setters = HOLDERS.get(name);
		if (setters != null)
			setters.forEach(s -> s.accept(value));
	}

	/** Registers any other object (effects, particles, menus, ...), calling back with its holder. */
	public static <T> void add(ResourceKey<? extends Registry<T>> registry, String name, Supplier<? extends T> factory, Consumer<Holder<T>> onRegistered) {
		EXTRA.add(new Entry<>(registry, name, factory, onRegistered));
	}

	public static void register(IEventBus modBus) {
		modBus.addListener(Registration::onRegister);
	}

	@SuppressWarnings("unchecked")
	private static void onRegister(RegisterEvent event) {
		for (Entry<?> entry : EXTRA) {
			if (event.getRegistryKey().equals(entry.registry()))
				registerExtra(event, (Entry<Object>) entry);
		}
	}

	@SuppressWarnings("unchecked")
	private static <T> void registerExtra(RegisterEvent event, Entry<T> entry) {
		T value = entry.factory().get();
		Registry<T> registry = (Registry<T>) event.getRegistry();
		Holder<T> holder = Registry.registerForHolder(registry, id(entry.name()), value);
		fire(entry.name(), value);
		if (entry.onRegistered() != null)
			entry.onRegistered().accept(holder);
	}

	public static Block block(String name) {
		return BuiltInRegistries.BLOCK.getValue(id(name));
	}
}
