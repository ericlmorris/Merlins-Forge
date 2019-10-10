package schematics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import events.RenderStructure;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SchematicShow {

	public static final Minecraft MINECRAFT = Minecraft.getInstance();

	/*
	 * Schematic Maximum Size Limits
	 */
	/** Tag file size limit in bytes */
	private static final long TAG_FILE_SIZE_LIMIT = 1024 * 1024 * 16;
	/** Volume width limitation */
	private static final int WIDTH_LIMIT = 1024;
	/** Volume height limitation */
	private static final int HEIGHT_LIMIT = 256;
	/** Volume length limitation */
	private static final int LENGTH_LIMIT = 1024;
	/** Volume size limitation */
	private static final long VOLUME_LIMIT = 256 * 256 * 256;

	/** Public variables for the schematic file **/
	public static short width;
	public static short length;
	public static short height;
	public static short volume;
	public static int adjustedLength;
	public static int adjustedWidth;

	public static Boolean oldFormat = true;

	/*
	 * Array of block ids and meta values from the "old" schematic format
	 */
	/** Block ID array */
	public static short[] blocks;

	/** Block metadata array */
	public static byte[] meta;

	/** IBlockState array */
	public static String[] blockStateKeys;
	public static String blockStateKey;

	public static BlockState loadState;

	// NBT keys
	public static String stateKey = "key";
	public static String fileKey;
	public static Boolean fileFound;

	public static Integer offsetX;
	public static Integer offsetY;
	public static Integer offsetZ;

	public static String rotateFlip = "OK";
	public static boolean flipX = false;
	public static Integer rotateY = 0;

	public static PlayerEntity player;
	public static World thisWorld;
	public static String thisFile;

	public static Integer playerPosX;
	public static Integer playerPosY;
	public static Integer playerPosZ;

	public static BlockPos locatorPosition;
	public static BlockPos searcherPosition;

	public static ItemStack schematicItemStack;
	public static CompoundNBT schematicKey;
	
	public static BlockPos anchor;

	
	public static ITextComponent textComponent = null;

	/**
	 * Load schematic from file
	 */

	public static Boolean showSchematic(String myFile, File file, String flipRotate, PlayerEntity playerIn,
			World worldIn) throws IOException {
		
		if (file.length() > TAG_FILE_SIZE_LIMIT) {
			throw new IOException("File is too large: " + file.length());
		}

		/*
		 * Load the HashMaps of the IBlockStates
		 */

		// load the block metadata tables
		BlockStates.loadMaps();

		// read the schematic from its file
		fileFound = false;
		readSchematic(readTags(file));

		if (!fileFound) {
			textComponent = new TranslationTextComponent("Schematic not found! Check your config file.");
			textComponent.getStyle().setColor(TextFormatting.RED);
			player.sendMessage(textComponent);		
		
		}

		/*
		 * Load incoming parameters
		 */

		player = playerIn;
		thisWorld = worldIn;

		// test for "flip" of structure
		flipX = flipRotate.contains("x");

		playerPosX = (int) player.posX;
		playerPosZ = (int) player.posZ;
		playerPosY = (int) player.posY;

		// determine the direction to load the schematic based on direction the player
		// is facing

		flipRotate = "00";

		Direction vFacing = player.getHorizontalFacing();

		// set rotation based on player and schematic
		rotateY = 0;

		/*
		 * The schematic structure will ALWAYS load to the SOUTHEAST of the player. The
		 * direction of the main house feature (door/opening/etc) will shift direction
		 * based on the the sDirection table and the playerFacing direction
		 */

		if (vFacing == Direction.WEST) {
			rotateY = 3;
		}
		if (vFacing == Direction.EAST) {
			rotateY = 1;
		}
		// west
		if (vFacing == Direction.NORTH) {
			rotateY = 2;
		}
		// east
		if (vFacing == Direction.SOUTH) {
			rotateY = 0;
		}

		// adjust offset length/width
		if (rotateY == 0 || rotateY == 2) {
			adjustedLength = length;
			adjustedWidth = width;
		} else {
			adjustedLength = width;
			adjustedWidth = length;
		}

		/*
		 * Search for building block
		 */
		Boolean hit = findLocatorBlock();
		
		if (!hit) {
			textComponent = new TranslationTextComponent("No REDSTONE BLOCK found within 32 block radius");
			textComponent.getStyle().setColor(TextFormatting.RED);
			player.sendMessage(textComponent);				
			return false;
		}

		// build the schematic
		buildSchematic();

		BlockPos bpStart = getWorldPos(0, 0, 0);
		RenderStructure.startX = locatorPosition.getX() + bpStart.getX();
		RenderStructure.startY = locatorPosition.getY() + bpStart.getY();
		RenderStructure.startZ = locatorPosition.getZ() + bpStart.getZ();
		anchor = new BlockPos(RenderStructure.startX, RenderStructure.startY, RenderStructure.startZ);
		
		//SchematicHologram.reset();
		//SchematicWorld w = new SchematicWorld(new HashMap<>(), new Cuboid(), anchor);
		//new SchematicHologram().startHologram(w);
				
		/*
		 * ShowRenderHandler.shiftEastWest = 0; ShowRenderHandler.shiftUpDown = 0;
		 * ShowRenderHandler.shiftNorthSouth = 0;
		 */

		return true;

	}

	/*
	 * Load the schematic into the world
	 */
	private static void buildSchematic() {

		int endArray = width * length * height;
		RenderStructure.initialize(endArray);

		/*
		 * ghostX = ShowRenderHandler.shiftEastWest; ghostY =
		 * ShowRenderHandler.shiftUpDown; ghostZ = ShowRenderHandler.shiftNorthSouth;
		 */
		
		BlockPos bpStart = getWorldPos(0, 0, 0);
		RenderStructure.startX = locatorPosition.getX() + bpStart.getX();
		RenderStructure.startY = locatorPosition.getY() + bpStart.getY();
		RenderStructure.startZ = locatorPosition.getZ() + bpStart.getZ();
		
		BlockPos bpend = getWorldPos(width-1, height-1, length-1);
		RenderStructure.endX = locatorPosition.getX() + bpend.getX();
		RenderStructure.endY = locatorPosition.getY() + bpend.getY();
		RenderStructure.endZ = locatorPosition.getZ() + bpend.getZ();
		
		// scan the structure and output blocks to world
		for (int ix = 0; ix < width; ++ix) {

			//for (int iy = 0; iy < height; ++iy) {
			for (int iy = 0; iy < 1; ++iy) {

				for (int iz = 0; iz < length; ++iz) {

					// get the initial block position within the schematic
					BlockPos pos = getWorldPos(ix, iy, iz);

					// set the block
					int bX = (int) locatorPosition.getX() + pos.getX();
					int bY = (int) locatorPosition.getY() + pos.getY();
					int bZ = (int) locatorPosition.getZ() + pos.getZ();

					RenderStructure.xArray[RenderStructure.arrayIndex] = bX;
					RenderStructure.yArray[RenderStructure.arrayIndex] = bY - 3;
					RenderStructure.zArray[RenderStructure.arrayIndex] = bZ;

					// locate the block to be loaded at this position in
					// volume
					int index = getIndex(ix, iy, iz);

					if (oldFormat) {

						int newMetaValue = adjustMeta(blocks[index], meta[index]);
						loadState = BlockStates.buildBlockStateKey(blocks[index], newMetaValue, rotateY);
						blockStateKeys[index] = blockStateKey;

					} else {
						
						loadState = BlockStates.loadBlockState(blockStateKeys[index], rotateY);
						
					}

					Block blox = loadState.getBlock();
					
					if (blox != Blocks.AIR) {
						RenderStructure.airArray[RenderStructure.arrayIndex] = getColorForBlock(blox);
						RenderStructure.arrayIndex++;
					}
				}

			}

		}

	}

	/**
	 * Read from schematic tag
	 */
	private static void readSchematic(CompoundNBT tag) throws IOException {

		// ensure proper type of schematic
		String materials = tag.getString("Materials");

		if (!materials.equals("Alpha") && !materials.equals("Beta")) {
			throw new IOException("Materials of schematic is not an alpha: [" + materials + "]");
		}
		// capture the width/height/length of the schematic and ensure it isn't
		// too big
		width = tag.getShort("Width");
		height = tag.getShort("Height");
		length = tag.getShort("Length");

		String dimensions = "[W=" + width + ";H=" + height + ";L=" + length + "]";
		String dimLimit = "[W=" + WIDTH_LIMIT + ";H=" + HEIGHT_LIMIT + ";L=" + LENGTH_LIMIT + "]";
		if (width <= 0 || height <= 0 || length <= 0) {
			throw new IOException("Schematic has non-positive dimensions: " + dimensions);
		}
		if (width > WIDTH_LIMIT || height > HEIGHT_LIMIT || length > LENGTH_LIMIT) {
			throw new IOException("Schematic dimensions are too large: " + dimensions + "/" + dimLimit);
		}
		volume = (short) getSize();
		if (volume > VOLUME_LIMIT) {
			throw new IOException("Schematic is too big: " + volume + "/" + VOLUME_LIMIT);
		}

		// initialize conversion array
		blockStateKeys = new String[volume];

		if (materials.equals("Alpha")) {

			oldFormat = true;

			// load old schematic format data

			byte[] addBlocks = tag.getByteArray("AddBlocks");

			// create an array for block IDs stored in width/height/length (x/y/z)
			// sequence
			byte[] blocksID = tag.getByteArray("Blocks");

			if (volume != blocksID.length) {
				throw new IOException("Wrong schematic blocks length: " + blocksID.length + "/" + volume);
			}

			// load metadata values
			meta = tag.getByteArray("Data");

			// load blockIDs
			blocks = compose(blocksID, addBlocks);
			if (volume != meta.length) {
				throw new IOException("Wrong schematic metadata length: " + blocksID.length + "/" + volume);
			}
		} else {

			// load the new schematic format data
			oldFormat = false;

			for (int idx = 0; idx < volume; idx++) {

				fileKey = stateKey + Integer.toString(idx);

				if (tag.getString(fileKey) != null) {

					blockStateKeys[idx] = tag.getString(fileKey);
				}
			}

		}
	}

	/**
	 * Combine all 8b-blocksID and 8b-addBlocks to 16b-block
	 * 
	 * @param blocksID
	 *            Vanilla block array
	 * @param addBlocks
	 *            Additional postfix array
	 * @return Combined array of vanilla and additional blocks
	 */
	private static short[] compose(byte[] blocksID, byte[] addBlocks) {

		// create an array
		short[] blocks = new short[blocksID.length];

		// scan through block IDs and load into array
		for (int index = 0; index < blocksID.length; index++) {

			// >> is right shift bytes
			if ((index >> 1) >= addBlocks.length) {
				blocks[index] = (short) (blocksID[index] & 0xFF);
			} else {
				if ((index & 1) == 0) {
					blocks[index] = (short) (((addBlocks[index >> 1] & 0x0F) << 8) + (blocksID[index] & 0xFF));
				} else {
					blocks[index] = (short) (((addBlocks[index >> 1] & 0xF0) << 4) + (blocksID[index] & 0xFF));
				}
			}

		}
		return blocks;
	}

	public static int getSize() {
		return width * height * length;
	}

	/**
	 * Load map tag from file
	 * 
	 * @param file
	 *            File to read
	 * @return NBT tag from file
	 * @throws IOException
	 *             If reading failed
	 */
	public static CompoundNBT readTags(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		try {
			fileFound = true;
			return CompressedStreamTools.readCompressed(fis);
		} finally {
			fis.close();
		}
	}

	/**
	 * Get index using relative position
	 * 
	 * @return Volume cell index
	 */
	public static int getIndex(int x, int y, int z) {
		return x + y * width * length + z * width;
	}

	/**
	 * Get world position of volume x, y, z block
	 * 
	 * @return World block position
	 */
	static BlockPos getWorldPos(int x, int y, int z) {

		// adjust x-axis for flip
		int wx = flipX ? width - x - 1 : x;
		// save the initial y-axis
		int wy = y;
		// save the initial z-axis
		int wz = z;

		// get the schematic width, height and length
		int w = width, l = length;

		// adjust block position based on player facing rotation
		for (int i = 0; i < rotateY; ++i) {
			// save initial z-axis
			int tmp = wz;
			// new z-axis = width - x-axis - 1
			wz = w - wx - 1;
			// change the x-axis to the old z-axis
			wx = tmp;
			// save the width
			tmp = w;
			// change the width to the length
			w = l;
			// change the length to the width
			l = tmp;
		}
		// return the position of the block relative to 0,0,0 world position
		return new BlockPos(wx, wy, wz);
	}

	/*
	 * When the schematic is rotated/flipped, adjust the meta to the new direction
	 */
	public static Integer adjustMeta(int bloxIdx, int metaIdx) {

		int oldMeta = metaIdx;
		int newMeta = oldMeta;

		return newMeta;
	}

	public static Boolean findLocatorBlock() {
		/*
		 * Search for building block
		 */
		locatorPosition = null;

		for (int x = -32; x < 33; x++) {
			for (int y = -6; y < 6; y++) {
				for (int z = -32; z < 33; z++) {

					searcherPosition = new BlockPos(playerPosX + x, playerPosY + y, playerPosZ + z);
					BlockState iblockstate = thisWorld.getBlockState(searcherPosition);
					Block vblock = iblockstate.getBlock();

					if (vblock == Blocks.REDSTONE_BLOCK) {

						// center building on building block
						int xAdj = adjustedWidth / 2;
						int zAdj = adjustedLength / 2;

						// set location to build structure
						locatorPosition = new BlockPos(searcherPosition.getX() - xAdj, searcherPosition.getY(),
								searcherPosition.getZ() - zAdj);

						return true;
					}
				}
			}
		}

		return false;
	}

	private static int getColorForBlock(Block block) {

		int blockColor = 15;

		if (block == Blocks.COBBLESTONE)
			blockColor = 3;
		if (block == Blocks.STONE_BRICKS)
			blockColor = 4;
		if (block == Blocks.SANDSTONE)
			blockColor = 2;
		if (block instanceof DoorBlock)
			blockColor = 1;
		if (block instanceof LogBlock)
			blockColor = 7;
		if (block instanceof FenceBlock)
			blockColor = 13;
		if (block == Blocks.FURNACE)
			blockColor = 14;
		if (block == Blocks.CHEST)
			blockColor = 12;
		
		blockColor = 0;

		return blockColor;

	}
}