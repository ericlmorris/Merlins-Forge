package items;

import java.util.List;

import merlinsforge.MerlinsForge;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMerlinsBeefJerky extends Item {
	
	public static final Food FRUIT = (new Food.Builder()).hunger(4).saturation(0.3F).setAlwaysEdible().build();

    public ItemMerlinsBeefJerky(Properties properties) {
		super(properties);
        properties.group(MerlinsForge.ITEM_GROUP);
        properties.food(FRUIT);
	}
    
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);
		
		player.clearActivePotions();	
		player.removeActivePotionEffect(Effects.BAD_OMEN);
		player.removeActivePotionEffect(Effects.MINING_FATIGUE);
		player.removeActivePotionEffect(Effects.BLINDNESS);
		player.removeActivePotionEffect(Effects.SLOWNESS);
		player.removeActivePotionEffect(Effects.MINING_FATIGUE);
		player.removeActivePotionEffect(Effects.INSTANT_DAMAGE);
		player.removeActivePotionEffect(Effects.NAUSEA);
		player.removeActivePotionEffect(Effects.HUNGER);
		player.removeActivePotionEffect(Effects.POISON);
		player.removeActivePotionEffect(Effects.WITHER);
		player.removeActivePotionEffect(Effects.LEVITATION);
		player.removeActivePotionEffect(Effects.UNLUCK);
		player.removeActivePotionEffect(Effects.WEAKNESS);
		
		player.setAbsorptionAmount(10);
		player.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 600, 1));
		player.addPotionEffect(new EffectInstance(Effects.SATURATION,600, 20));
		player.addPotionEffect(new EffectInstance(Effects.CONDUIT_POWER, 600, 1, false, false));

		if (stack.getDamage() < 3) {
			stack.setDamage(stack.getDamage() + 1);
		} else {
			stack.shrink(1);
			stack.setDamage(0);
		}
		
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}
	   
	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.BLUE + "Cures what ails you."));
		list.add(new StringTextComponent(TextFormatting.GREEN + "Smelt cooked beasts."));
	}  
}
