package items;

import events.EventPlayerTickLoad;
import merlinsforge.MerlinsForge;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemMerlinsCompass extends Item {
	public static BlockPos minePos;
	public static ITextComponent textComponent = null;

	public ItemMerlinsCompass(Item.Properties properties) {
		super(properties);
		properties.group(MerlinsForge.ITEM_GROUP);
		addPropertyOverride(new ResourceLocation("angle"), new CalculateCompassAngle());
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

		ItemStack stack = player.getHeldItem(hand);

		minePos = null;

		minePos = findStructure(player, world, "mineshaft");

		if (minePos != null) {
			textComponent = new TranslationTextComponent(
					"Mineshaft found at: " + minePos.getX() + "/" + minePos.getZ() + ". Follow the North Star!");
			textComponent.getStyle().setColor(TextFormatting.WHITE);
			player.sendMessage(textComponent);
		}

		if (player.isSneaking() && minePos!= null) {

			int offset = 0;
			textComponent = new TranslationTextComponent("Transporting you to the mineshaft. Get ready to dig out!");
			textComponent.getStyle().setColor(TextFormatting.WHITE);
			player.sendMessage(textComponent);

			for (int y = 120; y > 6; y--) {
				BlockPos hitpos = new BlockPos(minePos.getX(), y, minePos.getZ());
				BlockState state = world.getBlockState(hitpos);
				Block blox = state.getBlock();
				if (blox != Blocks.AIR) {
					hitpos = new BlockPos(minePos.getX(), y + 1, minePos.getZ());
					minePos = hitpos;
					break;
				}
			}

			player.setPositionAndUpdate(minePos.getX(), minePos.getY() + offset, minePos.getZ());
		}

		return new ActionResult<>(ActionResultType.SUCCESS, stack);

	}

	public static BlockPos findStructure(PlayerEntity thePlayer, World world, String mineshaft) {

		final BlockPos pos = world.findNearestStructure(mineshaft, thePlayer.getPosition(), 500, false);
		return pos;
	}

}
