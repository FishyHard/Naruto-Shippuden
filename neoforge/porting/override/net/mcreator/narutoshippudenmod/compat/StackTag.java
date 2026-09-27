package net.mcreator.narutoshippudenmod.compat;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;

import java.util.function.Consumer;

/**
 * Stand-in for 1.16 ItemStack.getOrCreateTag(): item NBT is now the CUSTOM_DATA component. Reads see the current data,
 * writes go straight back to the stack.
 */
public final class StackTag {
	private final ItemStack stack;

	private StackTag(ItemStack stack) {
		this.stack = stack;
	}

	public static StackTag of(ItemStack stack) {
		return new StackTag(stack);
	}

	private CompoundTag read() {
		return stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
	}

	private void write(Consumer<CompoundTag> change) {
		CustomData.update(DataComponents.CUSTOM_DATA, stack, change);
	}

	public double getDoubleOr(String key, double fallback) {
		return read().getDoubleOr(key, fallback);
	}

	public boolean getBooleanOr(String key, boolean fallback) {
		return read().getBooleanOr(key, fallback);
	}

	public String getStringOr(String key, String fallback) {
		return read().getStringOr(key, fallback);
	}

	public int getIntOr(String key, int fallback) {
		return read().getIntOr(key, fallback);
	}

	public float getFloatOr(String key, float fallback) {
		return read().getFloatOr(key, fallback);
	}

	public boolean contains(String key) {
		return read().contains(key);
	}

	public void putDouble(String key, double value) {
		write(tag -> tag.putDouble(key, value));
	}

	public void putBoolean(String key, boolean value) {
		write(tag -> tag.putBoolean(key, value));
	}

	public void putString(String key, String value) {
		write(tag -> tag.putString(key, value));
	}

	public void putInt(String key, int value) {
		write(tag -> tag.putInt(key, value));
	}

	public void putFloat(String key, float value) {
		write(tag -> tag.putFloat(key, value));
	}

	public void remove(String key) {
		write(tag -> tag.remove(key));
	}
}
