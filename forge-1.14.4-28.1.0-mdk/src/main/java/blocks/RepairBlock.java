package blocks;

import items.ItemMerlinsAxe;
import items.ItemMerlinsGold;
import items.ItemMerlinsPickAxe;
import items.ItemMerlinsShovel;
import items.ItemMerlinsSword;
import items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class RepairBlock extends Block {

	public static ItemStack heldItem;
	public static Integer damage;
	public static Integer maxdamage;
	public static Boolean canAfford;
	public static String message;
	public static ITextComponent textComponent = null;

	public RepairBlock(Properties properties) {
		super(properties);
	}

	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {

		ItemStack heldItem = player.getHeldItem(handIn);

		if (worldIn.isRemote) {
			return true;
		} else {

			heldItem = player.getHeldItem(handIn);
			processPayment(player, heldItem);

			if (!worldIn.isRemote && heldItem != null) {

				damage = heldItem.getDamage();
				maxdamage = heldItem.getMaxDamage();

				heldItem.setDamage(0);

			}

			return true;
		}
	}

	public static void processPayment(PlayerEntity player, ItemStack helditem) {
		// payment routine
		// set up scan for affordability
		int invSize = player.inventory.getSizeInventory();
		ItemStack invStack = null;
		canAfford = false;

		int index;
		// compare the cost (denomination and units) to the player's inventory
		for (index = 0; index < invSize; index++) {

			invStack = player.inventory.getStackInSlot(index);

			if (invStack.getItem() instanceof ItemMerlinsGold && invStack.getCount() >= 1) {
				canAfford = true;
				break;
			}
		}
		if (canAfford) {
			// remove payment from player's inventory
			player.inventory.getStackInSlot(index).setCount(invStack.getCount() - 1);
			textComponent = new TranslationTextComponent("Taking payment of 1 GOLD MERLIN");
			textComponent.getStyle().setColor(TextFormatting.WHITE);
			player.sendMessage(textComponent);

		} else {
			// inform player of insufficient funds
			textComponent = new TranslationTextComponent("Repair Requires 1 GOLD MERLIN");
			textComponent.getStyle().setColor(TextFormatting.RED);
			player.sendMessage(textComponent);
		}
	}
}
