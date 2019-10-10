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
import net.minecraft.block.LogBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.IProperty;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;

public class StructureLoad {

	public static ITextComponent textComponent = null;
	/*
	 * Schematic Maximum Size Limits
	 */
	/** Tag file size limit in bytes */
	private static final long TAG_FILE_SIZE_LIMIT = 1024 * 1024 * 256;
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

	// List of blockstates loaded from schematic file
	public static BlockState[] blockStateKeys;
	public static BlockState loadState;

	// NBT keys
	public static CompoundNBT compound;
	public static File outputFile;
	public static String fileKey;
	public static Boolean fileFound;
	public static String fileIn;

	public static Integer offsetX;
	public static Integer offsetY;
	public static Integer offsetZ;

	// public static String rotateFlip = "OK";
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

	/**
	 * Load schematic from file
	 */

	public static Boolean loadSchematic(String myFile, File file, String flipRotate, PlayerEntity playerIn,
			World worldIn) throws IOException {

		if (file.length() > TAG_FILE_SIZE_LIMIT) {
			throw new IOException("File is too large: " + file.length());
		}
		if (worldIn.getGameRules().getBoolean(GameRules.DO_FIRE_TICK)) {
			textComponent = new TranslationTextComponent("Set gamerules DO_FIRE_Tick to false to prevent structure fire.");
			textComponent.getStyle().setColor(TextFormatting.RED);
			EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
		}

		/*
		 * Load incoming parameters
		 */

		player = playerIn;
		thisWorld = worldIn;
		fileIn = myFile;

		playerPosX = (int) player.posX;
		playerPosZ = (int) player.posZ;
		playerPosY = (int) player.posY;

		// read the schematic from its file
		fileFound = false;
		System.out.println(file);
		readSchematic(readTags(file));

		if (!fileFound) {
			textComponent = new TranslationTextComponent("Schematic not found! Check your config file.");
			textComponent.getStyle().setColor(TextFormatting.RED);
			EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
		}

		/*
		 * The schematic structure will ALWAYS load to the SOUTHEAST of the player. The
		 * direction of the main house feature (door/opening/etc) will shift direction
		 * based on the the sDirection table and the playerFacing direction
		 */
		if (myFile.contains("undo")) {

		} else {

			// determine the direction to load the schematic based on direction the player
			// is facing

			Direction vFacing = player.getHorizontalFacing();

			// set rotation based on player and schematic
			rotateY = 0;

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
		}

		/*
		 * Validate Funds and Take Payment
		 */

		if (!takePayment(player)) {
			textComponent = new TranslationTextComponent("Insufficient funds! Need 1 GOLD INGOT or 1 Merlins Gold");
			textComponent.getStyle().setColor(TextFormatting.RED);
			EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
			return false;
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

		saveUndo();

		/*
		 * ShowRenderHandler.shiftEastWest = 0; ShowRenderHandler.shiftUpDown = 0;
		 * ShowRenderHandler.shiftNorthSouth = 0;
		 */

		return true;

	}

	/*
	 * Load the schematic into the world
	 */
	private static void buildSchematic() throws IOException {

		/*
		 * ghostX = ShowRenderHandler.shiftEastWest; ghostY =
		 * ShowRenderHandler.shiftUpDown; ghostZ = ShowRenderHandler.shiftNorthSouth;
		 */

		/*
		 * Initialize Undo output
		 */
		compound = new CompoundNBT();
		compound.putString("Format", "Beta");
		compound.putShort("Width", width);
		compound.putShort("Length", length);
		compound.putShort("Height", height);
		compound.putShort("PositionX", (short) locatorPosition.getX());
		compound.putShort("PositionY", (short) locatorPosition.getY());
		compound.putShort("PositionZ", (short) locatorPosition.getZ());
		compound.putInt("RotateY", rotateY);
		ListNBT tagBlocks = new ListNBT();

		int index = 0;

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

					// get the position of the block to be placed
					BlockPos newPos = new BlockPos(bX, bY, bZ);

					// get the current block at this position and add to undo
					BlockState state = thisWorld.getBlockState(newPos);
					CompoundNBT c = new CompoundNBT();
					c.put("Block", NBTUtil.writeBlockState(state));
					tagBlocks.add(c);

					// locate the block to be loaded at this position in volume
					// int index = getIndex(ix, iy, iz);

					if (index < blockStateKeys.length) {
						loadState = blockStateKeys[index];
						loadState = changeFacing(loadState, rotateY);
						index++;
					} else {
						loadState = null;
					}

					if (loadState != null) {

						Block blox = loadState.getBlock();
						if (blox instanceof LogBlock) {
							loadState = thisWorld.getBlockState(newPos);
							thisWorld.setBlockState(newPos, Blocks.OAK_WOOD.getDefaultState());
						} else {
							thisWorld.setBlockState(newPos, loadState, 2);
						}

					} else {
						loadState = thisWorld.getBlockState(newPos);
						thisWorld.setBlockState(newPos, Blocks.COBBLESTONE.getDefaultState());
					}

					Block blox = loadState.getBlock();

					if (blox != null && blox == Blocks.CHEST) {

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
		compound.put("StructureBlocks", tagBlocks);

	}

	/**
	 * Read from schematic tag
	 */
	private static void readSchematic(CompoundNBT tag) throws IOException {

		System.out.println(tag);

		// ensure proper type of schematic
		String materials = tag.getString("Format");
		if (!materials.equals("Beta")) {
			throw new IOException("Format of schematic is not 1.14+: [" + materials + "]");
		}
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
			rotateY = tag.getInt("RotateY");
		}

		String dimensions = "[W=" + width + ";H=" + height + ";L=" + length + "]";
		System.out.println(dimensions);
		String dimLimit = "[W=" + WIDTH_LIMIT + ";H=" + HEIGHT_LIMIT + ";L=" + LENGTH_LIMIT + "]";
		if (width <= 0 || height <= 0 || length <= 0) {
			throw new IOException("Schematic has non-positive dimensions: " + dimensions);
		}
		if (width > WIDTH_LIMIT || height > HEIGHT_LIMIT || length > LENGTH_LIMIT) {
			throw new IOException("Schematic dimensions are too large: " + dimensions + "/" + dimLimit);
		}
		volume = width * length * height;
		if (volume > VOLUME_LIMIT || volume < 0) {
			throw new IOException("Volume error: " + volume + "/" + VOLUME_LIMIT);
		}

		blockStateKeys = new BlockState[volume];
		ListNBT tagBlocks = tag.getList("StructureBlocks", 10);

		for (int idx = 0; idx < tagBlocks.size(); idx++) {
			CompoundNBT c = tagBlocks.getCompound(idx);
			BlockState readBlockState = NBTUtil.readBlockState(c.getCompound("Block"));
			blockStateKeys[idx] = readBlockState;
		}

	}

	public static int getSize() {
		return width * height * length;
	}

	/**
	 * Load map tag from file
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

		// save the initial x-axis
		int wx = x;
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

						searcherPosition = new BlockPos(playerPosX + x, playerPosY + y - 1, playerPosZ + z);
						BlockState BlockState = thisWorld.getBlockState(searcherPosition);
						Block vblock = BlockState.getBlock();

						if (vblock == Blocks.REDSTONE_BLOCK) {

							// center building on building block
							int xAdj = adjustedWidth / 2;
							int zAdj = adjustedLength / 2;

							// set location to build structure
							locatorPosition = new BlockPos(searcherPosition.getX() - xAdj, searcherPosition.getY() - 1,
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
		
		// no charge for undo
		if (fileIn.contains("undo")) return true; 

		int invSize = player.inventory.getSizeInventory();
		ItemStack invStack = null;

		int index;
		// compare the cost (denomination and units) to the player's inventory
		for (index = 0; index < invSize; index++) {

			invStack = player.inventory.getStackInSlot(index);

			if ((invStack.getItem() == Items.GOLD_INGOT || invStack.getItem() instanceof ItemMerlinsGold)
					&& invStack.getCount() >= 1) {

				player.inventory.getStackInSlot(index).setCount(invStack.getCount() - 1);
				textComponent = new TranslationTextComponent("Taking payment of 1 GOLD item");
				textComponent.getStyle().setColor(TextFormatting.WHITE);
				EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
				return true;
			}
		}

		return false;

	}

	public static void saveUndo() throws IOException {

		String myFile = SchematicPathConfiguration.SCHEMATIC_PATH.get() + "schematics/undo.schematic";
		File fileName = new File(myFile);

		System.out.println(compound);

		writeTags(fileName, compound);
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

	// shift direction of blocks
	public static BlockState changeFacing(BlockState stateIn, Integer rotate) {
		for (IProperty<?> property : stateIn.getProperties()) {
			// Directional Blocks
			if (property instanceof DirectionProperty) {
				// east
				if (rotate == 1) {
					if (stateIn.get(property) == Direction.SOUTH) {
						return stateIn.with((DirectionProperty) property, Direction.EAST);
					} else {
						if (stateIn.get(property) == Direction.NORTH) {
							return stateIn.with((DirectionProperty) property, Direction.WEST);
						} else {
							if (stateIn.get(property) == Direction.EAST) {
								return stateIn.with((DirectionProperty) property, Direction.NORTH);
							} else {
								// default WEST
								return stateIn.with((DirectionProperty) property, Direction.SOUTH);
							}
						}
					}
				}
				// north
				if (rotate == 2) {
					if (stateIn.get(property) == Direction.SOUTH) {
						return stateIn.with((DirectionProperty) property, Direction.NORTH);
					} else {
						if (stateIn.get(property) == Direction.NORTH) {
							return stateIn.with((DirectionProperty) property, Direction.SOUTH);
						} else {
							if (stateIn.get(property) == Direction.EAST) {
								return stateIn.with((DirectionProperty) property, Direction.WEST);
							} else {
								// default WEST
								return stateIn.with((DirectionProperty) property, Direction.EAST);
							}
						}
					}
				}
				// west
				if (rotate == 3) {
					if (stateIn.get(property) == Direction.SOUTH) {
						return stateIn.with((DirectionProperty) property, Direction.WEST);
					} else {
						if (stateIn.get(property) == Direction.NORTH) {
							return stateIn.with((DirectionProperty) property, Direction.EAST);
						} else {
							if (stateIn.get(property) == Direction.EAST) {
								return stateIn.with((DirectionProperty) property, Direction.SOUTH);
							} else {
								// default WEST
								return stateIn.with((DirectionProperty) property, Direction.NORTH);
							}
						}
					}
				}

			}
		}
		return stateIn;
	}

}