package schematics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import configuration.SchematicPathConfiguration;
import events.EventPlayerTickLoad;
import items.ItemMerlinsGold;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Direction.Axis;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class SchematicUpgrade {

	public static ITextComponent textComponent = null;
	public static final EnumProperty<SlabType> TYPE = BlockStateProperties.SLAB_TYPE;
	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
	public static final EnumProperty<Half> HALF = BlockStateProperties.HALF;
	public static final EnumProperty<Axis> AXIS = BlockStateProperties.AXIS;
	public static final EnumProperty<DoubleBlockHalf> DOORHALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
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
	public static int volume;
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

	/** BlockState array */
	public static String[] blockStateKeys;
	public static String[] undoStateKeys;
	public static String undoStateKey;

	public static BlockState loadState;

	// NBT keys
	public static String stateKey = "key";
	public static String fileKey;
	public static Boolean fileFound;
	public static String fileIn;

	public static Integer offsetX;
	public static Integer offsetY;
	public static Integer offsetZ;

	public static String rotateFlip = "OK";
	public static boolean flipX = false;
	public static Integer rotateY = 0;
	public static Integer rotateZ = 0;

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

	/**
	 * Load schematic from file
	 */

	public static Boolean loadSchematic(String myFile, File file, String flipRotate, PlayerEntity playerIn,
			World worldIn) throws IOException {

		if (file.length() > TAG_FILE_SIZE_LIMIT) {
			throw new IOException("File is too large: " + file.length());
		}
		/*
		 * Load incoming parameters
		 */

		// test for "flip" of structure
		flipX = flipRotate.contains("x");
		player = playerIn;
		thisWorld = worldIn;
		fileIn = myFile;

		/*
		 * Load the HashMaps of the BlockStates
		 */

		// load the block metadata tables
		BlockStates.loadMaps();

		// read the schematic from its file
		fileFound = false;
		readSchematic(readTags(file));

		if (!fileFound) {

			textComponent = new TranslationTextComponent("Schematic not found! Check your config file.");
			textComponent.getStyle().setColor(TextFormatting.RED);
			EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
		}

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
			EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
			return false;
		}

		// build the schematic
		buildSchematic();

		saveUndo(thisWorld);

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

		/*
		 * ghostX = ShowRenderHandler.shiftEastWest; ghostY =
		 * ShowRenderHandler.shiftUpDown; ghostZ = ShowRenderHandler.shiftNorthSouth;
		 */

		// scan the structure and output blocks to world
		for (int ix = 0; ix < width; ++ix) {

			for (int iy = 0; iy < height; ++iy) {

				for (int iz = 0; iz < length; ++iz) {

					// get the initial block position within the schematic
					BlockPos pos = getWorldPos(ix, iy, iz);

					// set the block
					int bX = (int) locatorPosition.getX() + pos.getX();
					int bY = (int) locatorPosition.getY() + pos.getY();
					int bZ = (int) locatorPosition.getZ() + pos.getZ();

					if (oldFormat) {
						bY--;
					}

					// get the position of the block to be placed
					BlockPos newPos = new BlockPos(bX, bY, bZ);
					undoStateKey = buildUndoKey(thisWorld, newPos);

					if (iy > height - 1) {
						Block xblock = Blocks.AIR;
						thisWorld.setBlockState(newPos, xblock.getDefaultState());
					} else {
						// locate the block to be loaded at this position in
						// volume
						int index = getIndex(ix, iy, iz);

						if (oldFormat) {

							int newMetaValue = adjustMeta(blocks[index], meta[index]);
							loadState = BlockStates.buildBlockStateKey(blocks[index], newMetaValue, rotateY);
							blockStateKeys[index] = BlockStates.newBlockKey;
							
							System.out.println(loadState + "/" + blockStateKeys[index]);

						} else {

							// new schematic format
							loadState = BlockStates.loadBlockState(blockStateKeys[index], rotateY);
							blockStateKeys[index] = BlockStates.newBlockKey;
						}

						if (loadState != null) {
							thisWorld.setBlockState(newPos, loadState, 2);
						} else {
							loadState = thisWorld.getBlockState(newPos);
							thisWorld.setBlockState(newPos, Blocks.COBBLESTONE.getDefaultState());
						}

						/*
						 * Save undo block
						 */
						undoStateKeys[index] = undoStateKey;

						Block blox = loadState.getBlock();
						if (blox == Blocks.CHEST) {

							final TileEntity tileentity = thisWorld.getTileEntity(newPos);

							if (tileentity instanceof ChestTileEntity) {

								int lootType = MathHelper.nextInt(thisWorld.rand, 0, 7);

								if (lootType == 0)
									((ChestTileEntity) tileentity).setInventorySlotContents(0,
											new ItemStack(Items.GOLD_INGOT));
								else if (lootType == 1)
									((ChestTileEntity) tileentity).setInventorySlotContents(0,
											new ItemStack(Items.IRON_INGOT));
								else if (lootType == 2)
									((ChestTileEntity) tileentity).setInventorySlotContents(0,
											new ItemStack(Items.GUNPOWDER, 4));
								else if (lootType == 3)
									((ChestTileEntity) tileentity).setInventorySlotContents(0,
											new ItemStack(Items.EMERALD));
								else if (lootType == 4)
									((ChestTileEntity) tileentity).setInventorySlotContents(0,
											new ItemStack(Items.STRING, 3));
								else if (lootType == 5)
									((ChestTileEntity) tileentity).setInventorySlotContents(0,
											new ItemStack(Items.ARROW, 3));
								else if (lootType == 6)
									((ChestTileEntity) tileentity).setInventorySlotContents(0,
											new ItemStack(Items.BONE, 9));
								else if (lootType == 7)
									((ChestTileEntity) tileentity).setInventorySlotContents(0,
											new ItemStack(Items.DIAMOND));
							}
						}

					}
				}

			}

		}

	}

	/**
	 * Read from schematic tag
	 */
	private static void readSchematic(CompoundNBT tag) throws IOException {
		
		System.out.println(tag);

		// ensure proper type of schematic
		String materials = tag.getString("Materials");
		String format  = tag.getString("Format");
	
		if (!materials.equals("Alpha") && !materials.equals("Beta")) {
			throw new IOException("Materials of schematic is not an alpha: [" + materials + "]");
		}
		//if (format == "Beta") materials = format;
		// capture the width/height/length of the schematic and ensure it isn't
		// too big
		width = tag.getShort("Width");
		height = tag.getShort("Height");
		length = tag.getShort("Length");

		if (fileIn.contains("undo")) {
			short posX = tag.getShort("PositionX");
			short posY = tag.getShort("PositionY");
			short posZ = tag.getShort("PositionZ");
			locatorPosition = new BlockPos(posX, posY, posZ);
		}

		String dimensions = "[W=" + width + ";H=" + height + ";L=" + length + "]";
		String dimLimit = "[W=" + WIDTH_LIMIT + ";H=" + HEIGHT_LIMIT + ";L=" + LENGTH_LIMIT + "]";
		if (width <= 0 || height <= 0 || length <= 0) {
			throw new IOException("Schematic has non-positive dimensions: " + dimensions);
		}
		if (width > WIDTH_LIMIT || height > HEIGHT_LIMIT || length > LENGTH_LIMIT) {
			throw new IOException("Schematic dimensions are too large: " + dimensions + "/" + dimLimit);
		}
		volume = (width * height * length);
		
		System.out.println(volume + "/" + width + "/" + height + "/" + length);
		
		if (volume > VOLUME_LIMIT || volume < 0) {
			throw new IOException("Volume error: " + volume + "/" + VOLUME_LIMIT);
		}

		// initialize conversion array
		blockStateKeys = new String[volume];
		undoStateKeys = new String[volume];

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

			// new format
			
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
	 * @param blocksID  Vanilla block array
	 * @param addBlocks Additional postfix array
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
	 * @param file File to read
	 * @return NBT tag from file
	 * @throws IOException If reading failed
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

		if (fileIn.contains("undo")) {

			return true;

		} else {

			locatorPosition = null;
			for (int x = -32; x < 33; x++) {
				for (int y = -6; y < 6; y++) {
					for (int z = -32; z < 33; z++) {

						searcherPosition = new BlockPos(playerPosX + x, playerPosY + y, playerPosZ + z);
						BlockState BlockState = thisWorld.getBlockState(searcherPosition);
						Block vblock = BlockState
								.getBlock();

						if (vblock == Blocks.REDSTONE_BLOCK) {

							// center building on building block
							int xAdj = adjustedWidth / 2;
							int zAdj = adjustedLength / 2;

							// set location to build structure
							locatorPosition = new BlockPos(searcherPosition.getX() - xAdj, searcherPosition.getY(),
									searcherPosition.getZ() - zAdj);

							// remove building block prior to build
							Block xblock = Blocks.AIR;
							thisWorld.setBlockState(searcherPosition, xblock.getDefaultState());
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static Boolean takePayment(PlayerEntity player) {

		int invSize = player.inventory.getSizeInventory();
		ItemStack invStack = null;

		int index;
		// compare the cost (denomination and units) to the player's inventory
		for (index = 0; index < invSize; index++) {

			invStack = player.inventory.getStackInSlot(index);

			if ((invStack.getItem() == Items.GOLD_INGOT || invStack.getItem() instanceof ItemMerlinsGold) && invStack.getCount() >= 1) {

				player.inventory.getStackInSlot(index).setCount(invStack.getCount() - 1);
				textComponent = new TranslationTextComponent("Taking payment of 1 GOLD item");
				textComponent.getStyle().setColor(TextFormatting.WHITE);
				EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
				return true;
			}
		}

		return false;

	}

	public static String buildUndoKey(World world, BlockPos pos) {

		BlockState state = world.getBlockState(pos);

		Block blox = state.getBlock();
		Integer blockID = BlockStates.getBlockID(blox);

		String blockKey = String.valueOf(blockID) + "x";

		final BlockState currentState = world.getBlockState(pos);

		if (blox instanceof StairsBlock || blox instanceof ChestBlock || blox instanceof LadderBlock
				|| blox instanceof TorchBlock || blox instanceof FurnaceBlock || blox instanceof DoorBlock) {
			Direction xFacing = currentState.get(FACING);
			if (xFacing == Direction.NORTH) {
				blockKey = blockKey + "nf";
			}
			if (xFacing == Direction.SOUTH) {
				blockKey = blockKey + "sf";
			}
			if (xFacing == Direction.EAST) {
				blockKey = blockKey + "ef";
			}
			if (xFacing == Direction.WEST) {
				blockKey = blockKey + "wf";
			}
		}

		if (blox instanceof DoorBlock) {
			final DoubleBlockHalf theDoor = currentState.get(DOORHALF);
			if (theDoor == DoubleBlockHalf.LOWER) {
				blockKey = blockKey + "lh";
			}
			if (theDoor == DoubleBlockHalf.UPPER) {
				blockKey = blockKey + "uh";
			}
		}

		if (blox instanceof LogBlock) {

			final Axis xAxis = currentState.get(AXIS);
			if (xAxis == Direction.Axis.X) {
				blockKey = blockKey + "xa";
			}
			if (xAxis == Direction.Axis.Y) {
				blockKey = blockKey + "ya";
			}
			if (xAxis == Direction.Axis.Z) {
				blockKey = blockKey + "za";
			}

		}
		if (blox instanceof SlabBlock) {
			SlabType xType = currentState.get(TYPE);
			if (xType != null && xType == SlabType.BOTTOM) {
				blockKey = blockKey + "bh";
			}
			if (xType != null && xType == SlabType.TOP) {
				blockKey = blockKey + "th";
			}
		}

		if (blox instanceof StairsBlock || blox instanceof TrapDoorBlock) {
			Half xHalf = currentState.get(HALF);
			if (xHalf == Half.TOP) {
				blockKey = blockKey + "th";
			}
			if (xHalf == Half.BOTTOM) {
				blockKey = blockKey + "bh";
			}
		}

		return blockKey;

	}

	public static void saveUndo(World world) throws IOException {
		
		ItemStack schematicItemStack = new ItemStack(Blocks.WATER);

		CompoundNBT compound = schematicItemStack.getTag();
		if (compound == null) {
			compound = new CompoundNBT();
		}

		schematicItemStack.setTag(compound);
		schematicKey = compound;

		compound.putString("Materials", "Beta");

		compound.putShort("Width", width);
		compound.putShort("Length", length);
		compound.putShort("Height", height);
		compound.putShort("PositionX", (short) locatorPosition.getX());
		compound.putShort("PositionY", (short) locatorPosition.getY());
		compound.putShort("PositionZ", (short) locatorPosition.getZ());
		compound.putInt("RotateY", rotateY);
	
		for (int idx = 0; idx < undoStateKeys.length; idx++) {

			if (undoStateKeys[idx] != null) {

				fileKey = stateKey + Integer.toString(idx);
				compound.putString(fileKey, undoStateKeys[idx]);
				
			}
		}
		
		String myFile = SchematicPathConfiguration.SCHEMATIC_PATH.get() + "schematics/undo.schematic";
		File fileName = new File(myFile);

		writeTags(fileName, schematicKey);

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
