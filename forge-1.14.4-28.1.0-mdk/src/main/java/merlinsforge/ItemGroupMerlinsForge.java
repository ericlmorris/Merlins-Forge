package merlinsforge;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class ItemGroupMerlinsForge extends ItemGroup {
	
	private final ItemStack sword = new ItemStack(Items.DAMAGED_ANVIL);

	public ItemGroupMerlinsForge() {
			super(MerlinsForge.MODID);
		}

	@OnlyIn(Dist.CLIENT)
	@Override
	public ItemStack createIcon() {
		return sword;
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void fill(final NonNullList<ItemStack> items) {
		items.add(sword.copy());
		super.fill(items);
	}
}
