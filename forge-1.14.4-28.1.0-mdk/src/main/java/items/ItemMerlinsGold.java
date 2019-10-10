package items;

import java.util.List;

import merlinsforge.MerlinsForge;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMerlinsGold extends Item {
	
    public ItemMerlinsGold(Item.Properties properties) {
        super(properties);
        properties.group(MerlinsForge.ITEM_GROUP);
    }
    
	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.BLUE + "Required for most Merlin's Recipes."));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Smelt from GOLD INGOTS and REDSTONE BLOCKS."));
	} 
}
