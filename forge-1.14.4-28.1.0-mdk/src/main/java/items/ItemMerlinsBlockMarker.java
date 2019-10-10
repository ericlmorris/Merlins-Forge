package items;

import commands.CommandFillSpace;
import merlinsforge.MerlinsForge;
import net.minecraft.item.ItemUseContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemMerlinsBlockMarker extends Item {

	public static ITextComponent textComponent = null;

	public ItemMerlinsBlockMarker(Properties properties) {
		super(properties);
		properties.group(MerlinsForge.ITEM_GROUP);
	}

	public ActionResultType onItemUse(ItemUseContext context) {

		PlayerEntity player = context.getPlayer();
		World world = context.getWorld();
		BlockPos pos = context.getPos();

		if (player.getHeldItemMainhand() != null && !world.isRemote) {
			// clear from/to
			if (player.isSneaking()) {
				CommandFillSpace.fromX = 0;
				CommandFillSpace.toX = 0;
				textComponent = new TranslationTextComponent("Block Marker Reset");
				textComponent.getStyle().setColor(TextFormatting.WHITE);
				player.sendMessage(textComponent);
			} else {
				if (CommandFillSpace.fromX == 0) {
					CommandFillSpace.fromX = pos.getX();
					CommandFillSpace.fromY = pos.getY();
					CommandFillSpace.fromZ = pos.getZ();
					textComponent = new TranslationTextComponent(
							"Starting Block Set. Set Ending Block to the SOUTHEAST.");
					textComponent.getStyle().setColor(TextFormatting.WHITE);
					player.sendMessage(textComponent);
				} else {
					if (CommandFillSpace.toX == 0) {
						CommandFillSpace.toX = pos.getX();
						CommandFillSpace.toY = pos.getY();
						CommandFillSpace.toZ = pos.getZ();
						textComponent = new TranslationTextComponent(
								"Ending Block Set. Use command to complete action.");
						textComponent.getStyle().setColor(TextFormatting.WHITE);
						player.sendMessage(textComponent);
					} else {
						textComponent = new TranslationTextComponent("Use command or sneak-click this item to reset.");
						textComponent.getStyle().setColor(TextFormatting.RED);
						player.sendMessage(textComponent);
					}
				}
			}
		}

		return null;
	}

}
