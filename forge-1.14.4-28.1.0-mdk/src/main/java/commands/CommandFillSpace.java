package commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import events.EventPlayerTickLoad;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CommandFillSpace {

	public static double fromX;
	public static double fromY;
	public static double fromZ;
	public static double toX;
	public static double toY;
	public static double toZ;
	public static Block fromBlock;
	public static Block toBlock;
	public static ITextComponent textComponent = null;

	static ArgumentBuilder<CommandSource, ?> register() {

		return Commands.literal("with").then(Commands.argument("blocktype", StringArgumentType.word())
				.executes(context -> execute(context, StringArgumentType.getString(context, "blocktype"))));
	}

	private static int execute(final CommandContext<CommandSource> context, final String name)
			throws CommandSyntaxException {
	
		textComponent = new TranslationTextComponent("Filled area with: " + name);
		textComponent.getStyle().setColor(TextFormatting.WHITE);
		EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
		if (name.contains("watertoair")) {

			replaceTheSpace(name);

		} else {

			fillTheSpace(name);

		}

		return 0;
	}

	public static void fillTheSpace(String blocktype) {

		World world = EventPlayerTickLoad.tickWorld;

		Block blox = Blocks.DIRT;

		if (blocktype.contains("dirt")) {
			blox = Blocks.DIRT;
		}
		if (blocktype.contains("stone")) {
			blox = Blocks.STONE;
		}
		if (blocktype.contains("gravel")) {
			blox = Blocks.GRAVEL;
		}
		if (blocktype.contains("cobble")) {
			blox = Blocks.COBBLESTONE;
		}
		if (blocktype.contains("grass")) {
			blox = Blocks.GRASS_BLOCK;
		}
		if (blocktype.contains("path")) {
			blox = Blocks.GRASS_PATH;
		}
		if (blocktype.contains("water")) {
			blox = Blocks.WATER;
		}
		if (blocktype.contains("lava")) {
			blox = Blocks.LAVA;
		}
		if (blocktype.contains("sand")) {
			blox = Blocks.SAND;
		}
		if (blocktype.contains("moss")) {
			blox = Blocks.MOSSY_COBBLESTONE;
		}
		if (blocktype.contains("sandstone")) {
			blox = Blocks.SANDSTONE;
		}
		if (blocktype.contains("air")) {
			blox = Blocks.AIR;
		}

		if (toY > 0) {

			for (int x = (int) fromX; x < toX + 1; x++) {
				for (int y = (int) fromY; y < toY + 1; y++) {
					for (int z = (int) fromZ; z < toZ + 1; z++) {

						BlockPos blockpos2 = new BlockPos(x, y, z);
						world.setBlockState(blockpos2, blox.getDefaultState());

					}

				}
			}
			// clear for next block marker
			fromX = 0;
			toX = 0;
		}
	}

	public static void replaceTheSpace(String name) {

		World world = EventPlayerTickLoad.tickWorld;

		if (name.contains("watertoair")) {
			fromBlock = Blocks.WATER;
			toBlock = Blocks.AIR;
		}
		if (toY > 0) {

			for (int x = (int) fromX; x < toX + 1; x++) {
				for (int y = (int) fromY; y < toY + 1; y++) {
					for (int z = (int) fromZ; z < toZ + 1; z++) {

						BlockPos blockpos2 = new BlockPos(x, y, z);
						BlockState state = world.getBlockState(blockpos2);
						Block blox = state.getBlock();
						if (blox == fromBlock) {
							world.setBlockState(blockpos2, toBlock.getDefaultState());
						}	
					}
				}
			}
			// clear for next block marker
			fromX = 0;
			toX = 0;
		}
	}

}
