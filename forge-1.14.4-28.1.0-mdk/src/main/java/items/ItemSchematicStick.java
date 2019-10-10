package items;

import net.minecraft.item.ItemUseContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import schematics.StructureSave;
import merlinsforge.MerlinsForge;

public class ItemSchematicStick extends Item {

	public static ITextComponent textComponent = null;

	public ItemSchematicStick(Properties properties) {
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
				StructureSave.startX = 0;
				StructureSave.endX = 0;
				textComponent = new TranslationTextComponent("Block Marker Reset");
				textComponent.getStyle().setColor(TextFormatting.WHITE);
				player.sendMessage(textComponent);
			} else {
				if (StructureSave.startX == 0) {
					StructureSave.startX = pos.getX();
					StructureSave.startY = pos.getY();
					StructureSave.startZ = pos.getZ();
					textComponent = new TranslationTextComponent(
							"Starting Block Set. Set Ending Block to the SOUTHEAST.");
					textComponent.getStyle().setColor(TextFormatting.WHITE);
					player.sendMessage(textComponent);
				} else {
					if (StructureSave.endX == 0) {
						StructureSave.endX = pos.getX();
						StructureSave.endY = pos.getY();
						StructureSave.endZ = pos.getZ();
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
