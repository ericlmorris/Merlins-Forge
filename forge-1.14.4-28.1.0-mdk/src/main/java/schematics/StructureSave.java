package schematics;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import events.EventPlayerTickLoad;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;

public class StructureSave {

	public static ITextComponent textComponent = null;

	public static String outputName;
	public static File outputFile;

	public static String fileKey;
	public static String[] blockStateKeys;
	public static String blockKey;

	public static double startX;
	public static double startY;
	public static double startZ;
	public static double endX;
	public static double endY;
	public static double endZ;

	public static short width;
	public static short length;
	public static short height;
	public static Integer volume;

	public static void saveSchematic(String shortName, File fullName, World world) throws IOException {

		outputName = shortName;
		outputFile = fullName;

		if (startX != 0 && endX != 0) {

			double absWidth = Math.abs(startX - endX) + 1;
			double absHeight = Math.abs(startY - endY) + 1;
			double absLength = Math.abs(startZ - endZ) + 1;

			width = (short) absWidth;
			height = (short) absHeight;
			length = (short) absLength;
			volume = width * height * length;
			
			ItemStack schematicItemStack;

			schematicItemStack = new ItemStack(Blocks.WATER);

			CompoundNBT compound = schematicItemStack.getTag();
			if (compound == null) {
				compound = new CompoundNBT();
			}			
					
			compound.putString("Format", "Beta");
			compound.putShort("Width", width);
			compound.putShort("Length", length);
			compound.putShort("Height", height);
			ListNBT tagBlocks = new ListNBT();

			// scan the structure and output blocks to world
			for (int ix = 0; ix < width; ++ix) {

				for (int iy = 0; iy < height; ++iy) {

					for (int iz = 0; iz < length; ++iz) {

						// locate the position in volume to place this block

						BlockPos worldPos = new BlockPos(ix + startX, iy + startY, iz + startZ);
						BlockState state = world.getBlockState(worldPos);
						
						System.out.println(worldPos + "/" + state);
						
						CompoundNBT c = new CompoundNBT();						
						c.put("Block", NBTUtil.writeBlockState(state));
						tagBlocks.add(c);						

					}
				}
			}
			
			compound.put("StructureBlocks", tagBlocks);	

			System.out.println(compound);
			writeTags(outputFile, compound);
			
			/*
			 * Wrapup and reset block marker
			 */
			textComponent = new TranslationTextComponent(shortName + " has been successfully saved.");
			textComponent.getStyle().setColor(TextFormatting.WHITE);
			EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
			
			startX = 0;
			endX= 0;

		}

	}

	/**
	 * Write tags to file
	 */
	public static void writeTags(File file, CompoundNBT tag) throws IOException {
		
		if (file.getParentFile() != null && !file.getParentFile().exists()) {
			if (!file.getParentFile().mkdirs()) {
				throw new IOException("Can't create path: " + file.getParent());
			}
		}
		FileOutputStream fos = new FileOutputStream(file);
		try {
			CompressedStreamTools.writeCompressed(tag, fos);
		} finally {
			fos.close();
		}
	}

}
