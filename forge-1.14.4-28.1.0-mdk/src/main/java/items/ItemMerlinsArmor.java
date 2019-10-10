package items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.Commands;

/**
 * An armour item that will be deleted as soon as it's unequipped (i.e. in a
 * player's inventory or on the ground).
 * <p>
 * Test for this thread:
 * http://www.minecraftforum.net/forums/mapping-and-modding/minecraft-mods/modification-development/2595100-persistent-variables-for-armor
 *
 * @author Choonster
 */
public class ItemMerlinsArmor extends ArmorItem {
	private static final Logger LOGGER = LogManager.getLogger();

	public ItemMerlinsArmor(final IArmorMaterial material, final EquipmentSlotType equipmentSlot,
			final Item.Properties properties) {
		super(material, equipmentSlot, properties);
	}

	/**
	 * Called every tick while the item is in a player's inventory (including while
	 * worn).
	 *
	 * @param stack      The ItemStack of this item
	 * @param world      The entity's world
	 * @param entity     The entity
	 * @param itemSlot   The slot containing this item
	 * @param isSelected Is the entity holding this item?
	 */

	@Override
	public void inventoryTick(final ItemStack stack, final World world, final Entity entity, final int itemSlot,
			final boolean isSelected) {
		
		if (!world.isRemote) {

			Item armorItem = stack.getItem();

			if (entity instanceof PlayerEntity) {

				PlayerEntity player = (PlayerEntity) entity;

				if (itemSlot == 3) {
					player.addPotionEffect(new EffectInstance(Effects.NIGHT_VISION, 200, 1));
					player.addPotionEffect(new EffectInstance(Effects.WATER_BREATHING, 200, 1));
				}
				if (itemSlot == 2) {
					player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 200, 1));
				}
				if (itemSlot == 1) {
					player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 200, 1));
				}
				if (itemSlot == 0) {
					player.addPotionEffect(new EffectInstance(Effects.SPEED, 200, 1));
				}
			}

		}
	}
	
	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag)
	{
		super.addInformation(stack, world, list, flag);				
		list.add(new StringTextComponent(TextFormatting.BLUE + "...with potions and enhancements."));
		list.add(new StringTextComponent(TextFormatting.GREEN + "x shaped recipe with iron item."));
	}  
}
