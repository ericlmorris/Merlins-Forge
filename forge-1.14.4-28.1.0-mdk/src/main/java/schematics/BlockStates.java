package schematics;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.Direction;

public class BlockStates {

	public static BlockState convertState;

	public static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

	public static HashMap<String, BlockState> blockStates;
	public static HashMap<String, String> blockProperties;
	public static HashMap<Block, Integer> blockIDs;
	public static HashMap<String, BlockState> newBlockStates;
	public static String newBlockKey;

	public final static BlockState oakDoor = Blocks.OAK_DOOR.getDefaultState();
	public final static BlockState oakDoornorthlower = oakDoor.with(DoorBlock.FACING, Direction.NORTH)
			.with(DoorBlock.HALF, DoubleBlockHalf.LOWER);
	public final static BlockState oakDoornorthupper = oakDoor.with(DoorBlock.FACING, Direction.NORTH)
			.with(DoorBlock.HALF, DoubleBlockHalf.UPPER);
	public final static BlockState oakDoorsouthlower = oakDoor.with(DoorBlock.FACING, Direction.SOUTH)
			.with(DoorBlock.HALF, DoubleBlockHalf.LOWER);
	public final static BlockState oakDoorsouthupper = oakDoor.with(DoorBlock.FACING, Direction.SOUTH)
			.with(DoorBlock.HALF, DoubleBlockHalf.UPPER);	
	public final static BlockState oakDooreastlower = oakDoor.with(DoorBlock.FACING, Direction.EAST)
			.with(DoorBlock.HALF, DoubleBlockHalf.LOWER);
	public final static BlockState oakDooreastupper = oakDoor.with(DoorBlock.FACING, Direction.EAST)
			.with(DoorBlock.HALF, DoubleBlockHalf.UPPER);
	public final static BlockState oakDoorwestlower = oakDoor.with(DoorBlock.FACING, Direction.WEST)
			.with(DoorBlock.HALF, DoubleBlockHalf.LOWER);
	public final static BlockState oakDoorwestupper = oakDoor.with(DoorBlock.FACING, Direction.WEST)
			.with(DoorBlock.HALF, DoubleBlockHalf.UPPER);		
	
	
	public final static BlockState ironDoor = Blocks.IRON_DOOR.getDefaultState();
	public final static BlockState ironDoornorthlower = ironDoor.with(DoorBlock.FACING, Direction.NORTH)
			.with(DoorBlock.HALF, DoubleBlockHalf.LOWER);
	public final static BlockState ironDoornorthupper = ironDoor.with(DoorBlock.FACING, Direction.NORTH)
			.with(DoorBlock.HALF, DoubleBlockHalf.UPPER);
	public final static BlockState ironDoorsouthlower = ironDoor.with(DoorBlock.FACING, Direction.SOUTH)
			.with(DoorBlock.HALF, DoubleBlockHalf.LOWER);
	public final static BlockState ironDoorsouthupper = ironDoor.with(DoorBlock.FACING, Direction.SOUTH)
			.with(DoorBlock.HALF, DoubleBlockHalf.UPPER);	
	public final static BlockState ironDooreastlower = ironDoor.with(DoorBlock.FACING, Direction.EAST)
			.with(DoorBlock.HALF, DoubleBlockHalf.LOWER);
	public final static BlockState ironDooreastupper = ironDoor.with(DoorBlock.FACING, Direction.EAST)
			.with(DoorBlock.HALF, DoubleBlockHalf.UPPER);
	public final static BlockState ironDoorwestlower = ironDoor.with(DoorBlock.FACING, Direction.WEST)
			.with(DoorBlock.HALF, DoubleBlockHalf.LOWER);
	public final static BlockState ironDoorwestupper = ironDoor.with(DoorBlock.FACING, Direction.WEST)
			.with(DoorBlock.HALF, DoubleBlockHalf.UPPER);	
	
	public final static BlockState glass_pane = Blocks.GLASS_PANE.getDefaultState();
	public final static BlockState glass_panenorth = glass_pane.with(PaneBlock.NORTH, true);
	public final static BlockState glass_panesouth = glass_pane.with(PaneBlock.SOUTH, true);
	public final static BlockState glass_paneeast = glass_pane.with(PaneBlock.EAST, true);
	public final static BlockState glass_panewest = glass_pane.with(PaneBlock.WEST, true);

	public final static BlockState chest = Blocks.CHEST.getDefaultState();
	public final static BlockState chestnorth = chest.with(FACING, Direction.NORTH);
	public final static BlockState chestsouth = chest.with(FACING, Direction.SOUTH);
	public final static BlockState chesteast = chest.with(FACING, Direction.EAST);
	public final static BlockState chestwest = chest.with(FACING, Direction.WEST);

	public final static BlockState furnace = Blocks.FURNACE.getDefaultState();
	public final static BlockState furnacenorth = furnace.with(FACING, Direction.NORTH);
	public final static BlockState furnacesouth = furnace.with(FACING, Direction.SOUTH);
	public final static BlockState furnaceeast = furnace.with(FACING, Direction.EAST);
	public final static BlockState furnacewest = furnace.with(FACING, Direction.WEST);

	public final static BlockState brickStairs = Blocks.BRICK_STAIRS.getDefaultState();
	public final static BlockState brickStairsnorthbottom = brickStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState brickStairsnorthtop = brickStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState brickStairssouthbottom = brickStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState brickStairssouthtop = brickStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState brickStairseastbottom = brickStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState brickStairseasttop = brickStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState brickStairswestbottom = brickStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState brickStairswesttop = brickStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState cobblestoneStairs = Blocks.COBBLESTONE_STAIRS.getDefaultState();
	public final static BlockState cobblestoneStairsnorthbottom = cobblestoneStairs
			.with(StairsBlock.FACING, Direction.NORTH).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState cobblestoneStairsnorthtop = cobblestoneStairs
			.with(StairsBlock.FACING, Direction.NORTH).with(StairsBlock.HALF, Half.TOP);
	public final static BlockState cobblestoneStairssouthbottom = cobblestoneStairs
			.with(StairsBlock.FACING, Direction.SOUTH).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState cobblestoneStairssouthtop = cobblestoneStairs
			.with(StairsBlock.FACING, Direction.SOUTH).with(StairsBlock.HALF, Half.TOP);
	public final static BlockState cobblestoneStairseastbottom = cobblestoneStairs
			.with(StairsBlock.FACING, Direction.EAST).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState cobblestoneStairseasttop = cobblestoneStairs
			.with(StairsBlock.FACING, Direction.EAST).with(StairsBlock.HALF, Half.TOP);
	public final static BlockState cobblestoneStairswestbottom = cobblestoneStairs
			.with(StairsBlock.FACING, Direction.WEST).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState cobblestoneStairswesttop = cobblestoneStairs
			.with(StairsBlock.FACING, Direction.WEST).with(StairsBlock.HALF, Half.TOP);

	public final static BlockState stonebrickStairs = Blocks.STONE_BRICK_STAIRS.getDefaultState();
	public final static BlockState stonebrickStairsnorthbottom = stonebrickStairs
			.with(StairsBlock.FACING, Direction.NORTH).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState stonebrickStairsnorthtop = stonebrickStairs
			.with(StairsBlock.FACING, Direction.NORTH).with(StairsBlock.HALF, Half.TOP);
	public final static BlockState stonebrickStairssouthbottom = stonebrickStairs
			.with(StairsBlock.FACING, Direction.SOUTH).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState stonebrickStairssouthtop = stonebrickStairs
			.with(StairsBlock.FACING, Direction.SOUTH).with(StairsBlock.HALF, Half.TOP);
	public final static BlockState stonebrickStairseastbottom = stonebrickStairs
			.with(StairsBlock.FACING, Direction.EAST).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState stonebrickStairseasttop = stonebrickStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState stonebrickStairswestbottom = stonebrickStairs
			.with(StairsBlock.FACING, Direction.WEST).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState stonebrickStairswesttop = stonebrickStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState sandstoneStairs = Blocks.SANDSTONE_STAIRS.getDefaultState();
	public final static BlockState sandstoneStairsnorthbottom = sandstoneStairs
			.with(StairsBlock.FACING, Direction.NORTH).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState sandstoneStairsnorthtop = sandstoneStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState sandstoneStairssouthbottom = sandstoneStairs
			.with(StairsBlock.FACING, Direction.SOUTH).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState sandstoneStairssouthtop = sandstoneStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState sandstoneStairseastbottom = sandstoneStairs
			.with(StairsBlock.FACING, Direction.EAST).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState sandstoneStairseasttop = sandstoneStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState sandstoneStairswestbottom = sandstoneStairs
			.with(StairsBlock.FACING, Direction.WEST).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState sandstoneStairswesttop = sandstoneStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState purpurStairs = Blocks.PURPUR_STAIRS.getDefaultState();
	public final static BlockState purpurStairsnorthbottom = purpurStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState purpurStairsnorthtop = purpurStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState purpurStairssouthbottom = purpurStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState purpurStairssouthtop = purpurStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState purpurStairseastbottom = purpurStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState purpurStairseasttop = purpurStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState purpurStairswestbottom = purpurStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState purpurStairswesttop = purpurStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState netherbrickStairs = Blocks.NETHER_BRICK_STAIRS.getDefaultState();
	public final static BlockState netherbrickStairsnorthbottom = netherbrickStairs
			.with(StairsBlock.FACING, Direction.NORTH).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState netherbrickStairsnorthtop = netherbrickStairs
			.with(StairsBlock.FACING, Direction.NORTH).with(StairsBlock.HALF, Half.TOP);
	public final static BlockState netherbrickStairssouthbottom = netherbrickStairs
			.with(StairsBlock.FACING, Direction.SOUTH).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState netherbrickStairssouthtop = netherbrickStairs
			.with(StairsBlock.FACING, Direction.SOUTH).with(StairsBlock.HALF, Half.TOP);
	public final static BlockState netherbrickStairseastbottom = netherbrickStairs
			.with(StairsBlock.FACING, Direction.EAST).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState netherbrickStairseasttop = netherbrickStairs
			.with(StairsBlock.FACING, Direction.EAST).with(StairsBlock.HALF, Half.TOP);
	public final static BlockState netherbrickStairswestbottom = netherbrickStairs
			.with(StairsBlock.FACING, Direction.WEST).with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState netherbrickStairswesttop = netherbrickStairs
			.with(StairsBlock.FACING, Direction.WEST).with(StairsBlock.HALF, Half.TOP);

	public final static BlockState oakStairs = Blocks.OAK_STAIRS.getDefaultState();
	public final static BlockState oakStairsnorthbottom = oakStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState oakStairsnorthtop = oakStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState oakStairssouthbottom = oakStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState oakStairssouthtop = oakStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState oakStairseastbottom = oakStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState oakStairseasttop = oakStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState oakStairswestbottom = oakStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState oakStairswesttop = oakStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState spruceStairs = Blocks.SPRUCE_STAIRS.getDefaultState();
	public final static BlockState spruceStairsnorthbottom = spruceStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState spruceStairsnorthtop = spruceStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState spruceStairssouthbottom = spruceStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState spruceStairssouthtop = spruceStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState spruceStairseastbottom = spruceStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState spruceStairseasttop = spruceStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState spruceStairswestbottom = spruceStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState spruceStairswesttop = spruceStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState acaciaStairs = Blocks.ACACIA_STAIRS.getDefaultState();
	public final static BlockState acaciaStairsnorthbottom = acaciaStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState acaciaStairsnorthtop = acaciaStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState acaciaStairssouthbottom = acaciaStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState acaciaStairssouthtop = acaciaStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState acaciaStairseastbottom = acaciaStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState acaciaStairseasttop = acaciaStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState acaciaStairswestbottom = acaciaStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState acaciaStairswesttop = acaciaStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState birchStairs = Blocks.BIRCH_STAIRS.getDefaultState();
	public final static BlockState birchStairsnorthbottom = birchStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState birchStairsnorthtop = birchStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState birchStairssouthbottom = birchStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState birchStairssouthtop = birchStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState birchStairseastbottom = birchStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState birchStairseasttop = birchStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState birchStairswestbottom = birchStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState birchStairswesttop = birchStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState darkoakStairs = Blocks.DARK_OAK_STAIRS.getDefaultState();
	public final static BlockState darkoakStairsnorthbottom = darkoakStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState darkoakStairsnorthtop = darkoakStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState darkoakStairssouthbottom = darkoakStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState darkoakStairssouthtop = darkoakStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState darkoakStairseastbottom = darkoakStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState darkoakStairseasttop = darkoakStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState darkoakStairswestbottom = darkoakStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState darkoakStairswesttop = darkoakStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState jungleStairs = Blocks.JUNGLE_STAIRS.getDefaultState();
	public final static BlockState jungleStairsnorthbottom = jungleStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState jungleStairsnorthtop = jungleStairs.with(StairsBlock.FACING, Direction.NORTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState jungleStairssouthbottom = jungleStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState jungleStairssouthtop = jungleStairs.with(StairsBlock.FACING, Direction.SOUTH)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState jungleStairseastbottom = jungleStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState jungleStairseasttop = jungleStairs.with(StairsBlock.FACING, Direction.EAST)
			.with(StairsBlock.HALF, Half.TOP);
	public final static BlockState jungleStairswestbottom = jungleStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.BOTTOM);
	public final static BlockState jungleStairswesttop = jungleStairs.with(StairsBlock.FACING, Direction.WEST)
			.with(StairsBlock.HALF, Half.TOP);

	public final static BlockState hopper = Blocks.HOPPER.getDefaultState();
	public final static BlockState dispenser = Blocks.DISPENSER.getDefaultState();
	public final static BlockState craftingtalbe = Blocks.CRAFTING_TABLE.getDefaultState();
	public final static BlockState anvil = Blocks.ANVIL.getDefaultState();
	public final static BlockState dropper = Blocks.DROPPER.getDefaultState();
	public final static BlockState jackolantern = Blocks.JACK_O_LANTERN.getDefaultState();
	public final static BlockState pumpkin = Blocks.CARVED_PUMPKIN.getDefaultState();
	public final static BlockState lever = Blocks.LEVER.getDefaultState();
	public final static BlockState air = Blocks.AIR.getDefaultState();
	public final static BlockState stone = Blocks.STONE.getDefaultState();
	public final static BlockState granite = Blocks.GRANITE.getDefaultState();
	public final static BlockState polished_granite = Blocks.POLISHED_GRANITE.getDefaultState();
	public final static BlockState diorite = Blocks.DIORITE.getDefaultState();
	public final static BlockState polished_diorite = Blocks.POLISHED_DIORITE.getDefaultState();
	public final static BlockState andesite = Blocks.ANDESITE.getDefaultState();
	public final static BlockState polished_andesite = Blocks.POLISHED_ANDESITE.getDefaultState();
	public final static BlockState grass_block = Blocks.GRASS_BLOCK.getDefaultState();
	public final static BlockState dirt = Blocks.DIRT.getDefaultState();
	public final static BlockState coarse_dirt = Blocks.COARSE_DIRT.getDefaultState();
	public final static BlockState podzol = Blocks.PODZOL.getDefaultState();
	public final static BlockState cobblestone = Blocks.COBBLESTONE.getDefaultState();
	public final static BlockState oak_planks = Blocks.OAK_PLANKS.getDefaultState();
	public final static BlockState spruce_planks = Blocks.SPRUCE_PLANKS.getDefaultState();
	public final static BlockState birch_planks = Blocks.BIRCH_PLANKS.getDefaultState();
	public final static BlockState jungle_planks = Blocks.JUNGLE_PLANKS.getDefaultState();
	public final static BlockState acacia_planks = Blocks.ACACIA_PLANKS.getDefaultState();
	public final static BlockState dark_oak_planks = Blocks.DARK_OAK_PLANKS.getDefaultState();
	public final static BlockState bedrock = Blocks.BEDROCK.getDefaultState();
	public final static BlockState water = Blocks.WATER.getDefaultState();
	public final static BlockState lava = Blocks.LAVA.getDefaultState();
	public final static BlockState sand = Blocks.SAND.getDefaultState();
	public final static BlockState red_sand = Blocks.RED_SAND.getDefaultState();
	public final static BlockState gravel = Blocks.GRAVEL.getDefaultState();
	public final static BlockState gold_ore = Blocks.GOLD_ORE.getDefaultState();
	public final static BlockState iron_ore = Blocks.IRON_ORE.getDefaultState();
	public final static BlockState coal_ore = Blocks.COAL_ORE.getDefaultState();
	public final static BlockState oak_leaves = Blocks.OAK_LEAVES.getDefaultState();
	public final static BlockState spruce_leaves = Blocks.SPRUCE_LEAVES.getDefaultState();
	public final static BlockState birch_leaves = Blocks.BIRCH_LEAVES.getDefaultState();
	public final static BlockState jungle_leaves = Blocks.JUNGLE_LEAVES.getDefaultState();
	public final static BlockState sponge = Blocks.SPONGE.getDefaultState();
	public final static BlockState wet_sponge = Blocks.WET_SPONGE.getDefaultState();
	public final static BlockState glass = Blocks.GLASS.getDefaultState();
	public final static BlockState lapis_ore = Blocks.LAPIS_ORE.getDefaultState();
	public final static BlockState lapis_block = Blocks.LAPIS_BLOCK.getDefaultState();
	public final static BlockState sandstone = Blocks.SANDSTONE.getDefaultState();
	public final static BlockState chiseled_sandstone = Blocks.CHISELED_SANDSTONE.getDefaultState();
	public final static BlockState cut_sandstone = Blocks.CUT_SANDSTONE.getDefaultState();
	public final static BlockState cobweb = Blocks.COBWEB.getDefaultState();
	public final static BlockState dead_bush = Blocks.DEAD_BUSH.getDefaultState();
	public final static BlockState hay_bale = Blocks.HAY_BLOCK.getDefaultState();
	public final static BlockState rail = Blocks.RAIL.getDefaultState();
	public final static BlockState grass = Blocks.GRASS.getDefaultState();
	public final static BlockState fern = Blocks.FERN.getDefaultState();
	public final static BlockState white_wool = Blocks.WHITE_WOOL.getDefaultState();
	public final static BlockState orange_wool = Blocks.ORANGE_WOOL.getDefaultState();
	public final static BlockState magenta_wool = Blocks.MAGENTA_WOOL.getDefaultState();
	public final static BlockState light_blue_wool = Blocks.LIGHT_BLUE_WOOL.getDefaultState();
	public final static BlockState yellow_wool = Blocks.YELLOW_WOOL.getDefaultState();
	public final static BlockState lime_wool = Blocks.LIME_WOOL.getDefaultState();
	public final static BlockState pink_wool = Blocks.PINK_WOOL.getDefaultState();
	public final static BlockState gray_wool = Blocks.GRAY_WOOL.getDefaultState();
	public final static BlockState light_gray_wool = Blocks.LIGHT_GRAY_WOOL.getDefaultState();
	public final static BlockState cyan_wool = Blocks.CYAN_WOOL.getDefaultState();
	public final static BlockState purple_wool = Blocks.PURPLE_WOOL.getDefaultState();
	public final static BlockState blue_wool = Blocks.BLUE_WOOL.getDefaultState();
	public final static BlockState brown_wool = Blocks.BROWN_WOOL.getDefaultState();
	public final static BlockState green_wool = Blocks.GREEN_WOOL.getDefaultState();
	public final static BlockState red_wool = Blocks.RED_WOOL.getDefaultState();
	public final static BlockState black_wool = Blocks.BLACK_WOOL.getDefaultState();
	public final static BlockState dandelion = Blocks.DANDELION.getDefaultState();
	public final static BlockState poppy = Blocks.POPPY.getDefaultState();
	public final static BlockState blue_orchid = Blocks.BLUE_ORCHID.getDefaultState();
	public final static BlockState allium = Blocks.ALLIUM.getDefaultState();
	public final static BlockState azure_bluet = Blocks.AZURE_BLUET.getDefaultState();
	public final static BlockState red_tulip = Blocks.RED_TULIP.getDefaultState();
	public final static BlockState orange_tulip = Blocks.ORANGE_TULIP.getDefaultState();
	public final static BlockState white_tulip = Blocks.WHITE_TULIP.getDefaultState();
	public final static BlockState pink_tulip = Blocks.PINK_TULIP.getDefaultState();
	public final static BlockState oxeye_daisy = Blocks.OXEYE_DAISY.getDefaultState();
	public final static BlockState red_mushroom = Blocks.RED_MUSHROOM.getDefaultState();
	public final static BlockState gold_block = Blocks.GOLD_BLOCK.getDefaultState();
	public final static BlockState iron_block = Blocks.IRON_BLOCK.getDefaultState();
	public final static BlockState smooth_stone = Blocks.SMOOTH_STONE.getDefaultState();
	public final static BlockState smooth_sandstone = Blocks.SMOOTH_SANDSTONE.getDefaultState();
	public final static BlockState smooth_quartz = Blocks.SMOOTH_QUARTZ.getDefaultState();
	public final static BlockState bricks = Blocks.BRICKS.getDefaultState();
	public final static BlockState tnt = Blocks.TNT.getDefaultState();
	public final static BlockState bookshelf = Blocks.BOOKSHELF.getDefaultState();
	public final static BlockState mossy_cobblestone = Blocks.MOSSY_COBBLESTONE.getDefaultState();
	public final static BlockState obsidian = Blocks.OBSIDIAN.getDefaultState();
	public final static BlockState torch = Blocks.TORCH.getDefaultState();
	public final static BlockState fire = Blocks.FIRE.getDefaultState();
	public final static BlockState redstone_wire = Blocks.REDSTONE_WIRE.getDefaultState();
	public final static BlockState diamond_block = Blocks.DIAMOND_BLOCK.getDefaultState();
	public final static BlockState crafting_table = Blocks.CRAFTING_TABLE.getDefaultState();
	public final static BlockState wheat = Blocks.WHEAT.getDefaultState();
	public final static BlockState farmland = Blocks.FARMLAND.getDefaultState();
	public final static BlockState sign = Blocks.OAK_SIGN.getDefaultState();
	public final static BlockState stone_pressure_plate = Blocks.STONE_PRESSURE_PLATE.getDefaultState();
	public final static BlockState redstone_torch = Blocks.REDSTONE_TORCH.getDefaultState();
	public final static BlockState cactus = Blocks.CACTUS.getDefaultState();
	public final static BlockState clay = Blocks.CLAY.getDefaultState();
	public final static BlockState sugar_cane = Blocks.SUGAR_CANE.getDefaultState();
	public final static BlockState jukebox = Blocks.JUKEBOX.getDefaultState();
	public final static BlockState oak_fence = Blocks.OAK_FENCE.getDefaultState();
	public final static BlockState netherrack = Blocks.NETHERRACK.getDefaultState();
	public final static BlockState soul_sand = Blocks.SOUL_SAND.getDefaultState();
	public final static BlockState melon_block = Blocks.MELON.getDefaultState();
	public final static BlockState glowstone = Blocks.GLOWSTONE.getDefaultState();
	public final static BlockState white_stained_glass = Blocks.WHITE_STAINED_GLASS.getDefaultState();
	public final static BlockState orange_stained_glass = Blocks.ORANGE_STAINED_GLASS.getDefaultState();
	public final static BlockState magenta_stained_glass = Blocks.MAGENTA_STAINED_GLASS.getDefaultState();
	public final static BlockState light_blue_stained_glass = Blocks.LIGHT_BLUE_STAINED_GLASS.getDefaultState();
	public final static BlockState yellow_stained_glass = Blocks.YELLOW_STAINED_GLASS.getDefaultState();
	public final static BlockState lime_stained_glass = Blocks.LIME_STAINED_GLASS.getDefaultState();
	public final static BlockState pink_stained_glass = Blocks.PINK_STAINED_GLASS.getDefaultState();
	public final static BlockState gray_stained_glass = Blocks.GRAY_STAINED_GLASS.getDefaultState();
	public final static BlockState light_gray_stained_glass = Blocks.LIGHT_GRAY_STAINED_GLASS.getDefaultState();
	public final static BlockState cyan_stained_glass = Blocks.CYAN_STAINED_GLASS.getDefaultState();
	public final static BlockState purple_stained_glass = Blocks.PURPLE_STAINED_GLASS.getDefaultState();
	public final static BlockState blue_stained_glass = Blocks.BLUE_STAINED_GLASS.getDefaultState();
	public final static BlockState brown_stained_glass = Blocks.BROWN_STAINED_GLASS.getDefaultState();
	public final static BlockState green_stained_glass = Blocks.GREEN_STAINED_GLASS.getDefaultState();
	public final static BlockState red_stained_glass = Blocks.RED_STAINED_GLASS.getDefaultState();
	public final static BlockState black_stained_glass = Blocks.BLACK_STAINED_GLASS.getDefaultState();
	public final static BlockState stone_bricks = Blocks.STONE_BRICKS.getDefaultState();
	public final static BlockState mossy_stone_bricks = Blocks.MOSSY_STONE_BRICKS.getDefaultState();
	public final static BlockState cracked_stone_bricks = Blocks.CRACKED_STONE_BRICKS.getDefaultState();
	public final static BlockState chiseled_stone_bricks = Blocks.CHISELED_STONE_BRICKS.getDefaultState();
	public final static BlockState iron_bars = Blocks.IRON_BARS.getDefaultState();
	public final static BlockState nether_bricks = Blocks.NETHER_BRICKS.getDefaultState();
	public final static BlockState enchanting_table = Blocks.ENCHANTING_TABLE.getDefaultState();
	public final static BlockState brewing_stand = Blocks.BREWING_STAND.getDefaultState();
	public final static BlockState cauldron = Blocks.CAULDRON.getDefaultState();
	public final static BlockState end_stone = Blocks.END_STONE.getDefaultState();
	public final static BlockState redstone_lamp = Blocks.REDSTONE_LAMP.getDefaultState();
	public final static BlockState emerald_block = Blocks.EMERALD_BLOCK.getDefaultState();
	public final static BlockState beacon = Blocks.BEACON.getDefaultState();
	public final static BlockState cobblestone_wall = Blocks.COBBLESTONE_WALL.getDefaultState();
	public final static BlockState mossy_cobblestone_wall = Blocks.MOSSY_COBBLESTONE_WALL.getDefaultState();
	public final static BlockState potted_cactus = Blocks.POTTED_CACTUS.getDefaultState();
	public final static BlockState carrots = Blocks.CARROTS.getDefaultState();
	public final static BlockState potatoes = Blocks.POTATOES.getDefaultState();
	public final static BlockState light_weighted_pressure_plate = Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE
			.getDefaultState();
	public final static BlockState heavy_weighted_pressure_plate = Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE
			.getDefaultState();
	public final static BlockState redstone_block = Blocks.REDSTONE_BLOCK.getDefaultState();
	public final static BlockState quartz_block = Blocks.QUARTZ_BLOCK.getDefaultState();
	public final static BlockState chiseled_quartz_block = Blocks.CHISELED_QUARTZ_BLOCK.getDefaultState();
	public final static BlockState white_terracotta = Blocks.WHITE_TERRACOTTA.getDefaultState();
	public final static BlockState orange_terracotta = Blocks.ORANGE_TERRACOTTA.getDefaultState();
	public final static BlockState magenta_terracotta = Blocks.MAGENTA_TERRACOTTA.getDefaultState();
	public final static BlockState light_blue_terracotta = Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState();
	public final static BlockState yellow_terracotta = Blocks.YELLOW_TERRACOTTA.getDefaultState();
	public final static BlockState lime_terracotta = Blocks.LIME_TERRACOTTA.getDefaultState();
	public final static BlockState pink_terracotta = Blocks.PINK_TERRACOTTA.getDefaultState();
	public final static BlockState gray_terracotta = Blocks.GRAY_TERRACOTTA.getDefaultState();
	public final static BlockState light_gray_terracotta = Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState();
	public final static BlockState cyan_terracotta = Blocks.CYAN_TERRACOTTA.getDefaultState();
	public final static BlockState purple_terracotta = Blocks.PURPLE_TERRACOTTA.getDefaultState();
	public final static BlockState blue_terracotta = Blocks.BLUE_TERRACOTTA.getDefaultState();
	public final static BlockState brown_terracotta = Blocks.BROWN_TERRACOTTA.getDefaultState();
	public final static BlockState green_terracotta = Blocks.GREEN_TERRACOTTA.getDefaultState();
	public final static BlockState red_terracotta = Blocks.RED_TERRACOTTA.getDefaultState();
	public final static BlockState black_terracotta = Blocks.BLACK_TERRACOTTA.getDefaultState();
	public final static BlockState white_stained_glass_pane = Blocks.WHITE_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState white_stained_glass_pane_north = white_stained_glass_pane
			.with(StainedGlassPaneBlock.NORTH, true);

	public final static BlockState orange_stained_glass_pane = Blocks.ORANGE_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState magenta_stained_glass_pane = Blocks.MAGENTA_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState light_blue_stained_glass_pane = Blocks.LIGHT_BLUE_STAINED_GLASS_PANE
			.getDefaultState();
	public final static BlockState yellow_stained_glass_pane = Blocks.YELLOW_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState lime_stained_glass_pane = Blocks.LIME_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState lime_stained_glass_pane_north = lime_stained_glass_pane
			.with(StainedGlassPaneBlock.NORTH, true);

	public final static BlockState pink_stained_glass_pane = Blocks.PINK_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState gray_stained_glass_pane = Blocks.GRAY_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState light_gray_stained_glass_pane = Blocks.LIGHT_GRAY_STAINED_GLASS_PANE
			.getDefaultState();
	public final static BlockState cyan_stained_glass_pane = Blocks.CYAN_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState purple_stained_glass_pane = Blocks.PURPLE_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState blue_stained_glass_pane = Blocks.BLUE_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState brown_stained_glass_pane = Blocks.BROWN_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState green_stained_glass_pane = Blocks.GREEN_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState red_stained_glass_pane = Blocks.RED_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState black_stained_glass_pane = Blocks.BLACK_STAINED_GLASS_PANE.getDefaultState();
	public final static BlockState acacia_leaves = Blocks.ACACIA_LEAVES.getDefaultState();
	public final static BlockState dark_oak_leaves = Blocks.DARK_OAK_LEAVES.getDefaultState();
	public final static BlockState slime_block = Blocks.SLIME_BLOCK.getDefaultState();
	public final static BlockState barrier = Blocks.BARRIER.getDefaultState();
	public final static BlockState prismarine = Blocks.PRISMARINE.getDefaultState();
	public final static BlockState prismarine_bricks = Blocks.PRISMARINE_BRICKS.getDefaultState();
	public final static BlockState dark_prismarine = Blocks.DARK_PRISMARINE.getDefaultState();
	public final static BlockState sea_lantern = Blocks.SEA_LANTERN.getDefaultState();
	public final static BlockState white_carpet = Blocks.WHITE_CARPET.getDefaultState();
	public final static BlockState orange_carpet = Blocks.ORANGE_CARPET.getDefaultState();
	public final static BlockState magenta_carpet = Blocks.MAGENTA_CARPET.getDefaultState();
	public final static BlockState light_blue_carpet = Blocks.LIGHT_BLUE_CARPET.getDefaultState();
	public final static BlockState yellow_carpet = Blocks.YELLOW_CARPET.getDefaultState();
	public final static BlockState lime_carpet = Blocks.LIME_CARPET.getDefaultState();
	public final static BlockState pink_carpet = Blocks.PINK_CARPET.getDefaultState();
	public final static BlockState gray_carpet = Blocks.GRAY_CARPET.getDefaultState();
	public final static BlockState light_gray_carpet = Blocks.LIGHT_GRAY_CARPET.getDefaultState();
	public final static BlockState cyan_carpet = Blocks.CYAN_CARPET.getDefaultState();
	public final static BlockState purple_carpet = Blocks.PURPLE_CARPET.getDefaultState();
	public final static BlockState blue_carpet = Blocks.BLUE_CARPET.getDefaultState();
	public final static BlockState brown_carpet = Blocks.BROWN_CARPET.getDefaultState();
	public final static BlockState green_carpet = Blocks.GREEN_CARPET.getDefaultState();
	public final static BlockState red_carpet = Blocks.RED_CARPET.getDefaultState();
	public final static BlockState black_carpet = Blocks.BLACK_CARPET.getDefaultState();
	public final static BlockState terracotta = Blocks.TERRACOTTA.getDefaultState();
	public final static BlockState coal_block = Blocks.COAL_BLOCK.getDefaultState();
	public final static BlockState red_sandstone = Blocks.RED_SANDSTONE.getDefaultState();
	public final static BlockState chiseled_red_sandstone = Blocks.CHISELED_RED_SANDSTONE.getDefaultState();
	public final static BlockState cut_red_sandstone = Blocks.CUT_RED_SANDSTONE.getDefaultState();
	public final static BlockState smooth_red_sandstone = Blocks.SMOOTH_RED_SANDSTONE.getDefaultState();
	public final static BlockState spruce_fence = Blocks.SPRUCE_FENCE.getDefaultState();
	public final static BlockState birch_fence = Blocks.BIRCH_FENCE.getDefaultState();
	public final static BlockState jungle_fence = Blocks.JUNGLE_FENCE.getDefaultState();
	public final static BlockState dark_oak_fence = Blocks.DARK_OAK_FENCE.getDefaultState();
	public final static BlockState acacia_fence = Blocks.ACACIA_FENCE.getDefaultState();
	public final static BlockState purpur_block = Blocks.PURPUR_BLOCK.getDefaultState();
	public final static BlockState end_stone_bricks = Blocks.END_STONE_BRICKS.getDefaultState();
	public final static BlockState beetroots = Blocks.BEETROOTS.getDefaultState();
	public final static BlockState grass_path = Blocks.GRASS_PATH.getDefaultState();
	public final static BlockState white_concrete = Blocks.WHITE_CONCRETE.getDefaultState();
	public final static BlockState orange_concrete = Blocks.ORANGE_CONCRETE.getDefaultState();
	public final static BlockState magenta_concrete = Blocks.MAGENTA_CONCRETE.getDefaultState();
	public final static BlockState light_blue_concrete = Blocks.LIGHT_BLUE_CONCRETE.getDefaultState();
	public final static BlockState yellow_concrete = Blocks.YELLOW_CONCRETE.getDefaultState();
	public final static BlockState lime_concrete = Blocks.LIME_CONCRETE.getDefaultState();
	public final static BlockState pink_concrete = Blocks.PINK_CONCRETE.getDefaultState();
	public final static BlockState gray_concrete = Blocks.GRAY_CONCRETE.getDefaultState();
	public final static BlockState light_gray_concrete = Blocks.LIGHT_GRAY_CONCRETE.getDefaultState();
	public final static BlockState cyan_concrete = Blocks.CYAN_CONCRETE.getDefaultState();
	public final static BlockState purple_concrete = Blocks.PURPLE_CONCRETE.getDefaultState();
	public final static BlockState blue_concrete = Blocks.BLUE_CONCRETE.getDefaultState();
	public final static BlockState brown_concrete = Blocks.BROWN_CONCRETE.getDefaultState();
	public final static BlockState green_concrete = Blocks.GREEN_CONCRETE.getDefaultState();
	public final static BlockState red_concrete = Blocks.RED_CONCRETE.getDefaultState();
	public final static BlockState black_concrete = Blocks.BLACK_CONCRETE.getDefaultState();
	public final static BlockState white_concrete_powder = Blocks.WHITE_CONCRETE_POWDER.getDefaultState();
	public final static BlockState orange_concrete_powder = Blocks.ORANGE_CONCRETE_POWDER.getDefaultState();
	public final static BlockState magenta_concrete_powder = Blocks.MAGENTA_CONCRETE_POWDER.getDefaultState();
	public final static BlockState light_blue_concrete_powder = Blocks.LIGHT_BLUE_CONCRETE_POWDER.getDefaultState();
	public final static BlockState yellow_concrete_powder = Blocks.YELLOW_CONCRETE_POWDER.getDefaultState();
	public final static BlockState lime_concrete_powder = Blocks.LIME_CONCRETE_POWDER.getDefaultState();
	public final static BlockState pink_concrete_powder = Blocks.PINK_CONCRETE_POWDER.getDefaultState();
	public final static BlockState gray_concrete_powder = Blocks.GRAY_CONCRETE_POWDER.getDefaultState();
	public final static BlockState light_gray_concrete_powder = Blocks.LIGHT_GRAY_CONCRETE_POWDER.getDefaultState();
	public final static BlockState cyan_concrete_powder = Blocks.CYAN_CONCRETE_POWDER.getDefaultState();
	public final static BlockState purple_concrete_powder = Blocks.PURPLE_CONCRETE_POWDER.getDefaultState();
	public final static BlockState blue_concrete_powder = Blocks.BLUE_CONCRETE_POWDER.getDefaultState();
	public final static BlockState brown_concrete_powder = Blocks.BROWN_CONCRETE_POWDER.getDefaultState();
	public final static BlockState green_concrete_powder = Blocks.GREEN_CONCRETE_POWDER.getDefaultState();
	public final static BlockState red_concrete_powder = Blocks.RED_CONCRETE_POWDER.getDefaultState();
	public final static BlockState black_concrete_powder = Blocks.BLACK_CONCRETE_POWDER.getDefaultState();

	public final static BlockState oaklog = Blocks.OAK_LOG.getDefaultState();
	public final static BlockState oaklogx = oaklog.with(LogBlock.AXIS, Direction.Axis.X);
	public final static BlockState oaklogy = oaklog.with(LogBlock.AXIS, Direction.Axis.Y);
	public final static BlockState oaklogz = oaklog.with(LogBlock.AXIS, Direction.Axis.Z);
	public final static BlockState darkoaklog = Blocks.DARK_OAK_LOG.getDefaultState();
	public final static BlockState darkoaklogx = darkoaklog.with(LogBlock.AXIS, Direction.Axis.X);
	public final static BlockState darkoaklogy = darkoaklog.with(LogBlock.AXIS, Direction.Axis.Y);
	public final static BlockState darkoaklogz = darkoaklog.with(LogBlock.AXIS, Direction.Axis.Z);
	public final static BlockState sprucelog = Blocks.SPRUCE_LOG.getDefaultState();
	public final static BlockState sprucelogx = sprucelog.with(LogBlock.AXIS, Direction.Axis.X);
	public final static BlockState sprucelogy = sprucelog.with(LogBlock.AXIS, Direction.Axis.Y);
	public final static BlockState sprucelogz = sprucelog.with(LogBlock.AXIS, Direction.Axis.Z);
	public final static BlockState acacialog = Blocks.ACACIA_LOG.getDefaultState();
	public final static BlockState acacialogx = acacialog.with(LogBlock.AXIS, Direction.Axis.X);
	public final static BlockState acacialogy = acacialog.with(LogBlock.AXIS, Direction.Axis.Y);
	public final static BlockState acacialogz = acacialog.with(LogBlock.AXIS, Direction.Axis.Z);
	public final static BlockState birchlog = Blocks.BIRCH_LOG.getDefaultState();
	public final static BlockState birchlogx = birchlog.with(LogBlock.AXIS, Direction.Axis.X);
	public final static BlockState birchlogy = birchlog.with(LogBlock.AXIS, Direction.Axis.Y);
	public final static BlockState birchlogz = birchlog.with(LogBlock.AXIS, Direction.Axis.Z);
	public final static BlockState junglelog = Blocks.JUNGLE_LOG.getDefaultState();
	public final static BlockState junglelogx = junglelog.with(LogBlock.AXIS, Direction.Axis.X);
	public final static BlockState junglelogy = junglelog.with(LogBlock.AXIS, Direction.Axis.Y);
	public final static BlockState junglelogz = junglelog.with(LogBlock.AXIS, Direction.Axis.Z);

	public final static BlockState birchslab = Blocks.BIRCH_SLAB.getDefaultState();
	public final static BlockState birchslabtop = birchslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState birchslabbottom = birchslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState birchslabdouble = birchslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState oakslab = Blocks.OAK_SLAB.getDefaultState();
	public final static BlockState oakslabtop = oakslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState oakslabbottom = oakslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState oakslabdouble = oakslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState spruceslab = Blocks.SPRUCE_SLAB.getDefaultState();
	public final static BlockState spruceslabtop = spruceslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState spruceslabbottom = spruceslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState spruceslabdouble = spruceslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState acaciaslab = Blocks.ACACIA_SLAB.getDefaultState();
	public final static BlockState acaciaslabtop = acaciaslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState acaciaslabbottom = acaciaslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState acaciaslabdouble = acaciaslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState jungleslab = Blocks.JUNGLE_SLAB.getDefaultState();
	public final static BlockState jungleslabtop = jungleslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState jungleslabbottom = jungleslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState jungleslabdouble = jungleslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState darkoakslab = Blocks.DARK_OAK_SLAB.getDefaultState();
	public final static BlockState darkoakslabtop = darkoakslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState darkoakslabbottom = darkoakslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState darkoakslabdouble = darkoakslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState brickslab = Blocks.BRICK_SLAB.getDefaultState();
	public final static BlockState brickslabtop = brickslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState brickslabbottom = brickslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState brickslabdouble = brickslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState cobblestoneslab = Blocks.COBBLESTONE_SLAB.getDefaultState();
	public final static BlockState cobblestoneslabtop = cobblestoneslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState cobblestoneslabbottom = cobblestoneslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState cobblestoneslabdouble = cobblestoneslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState netherbrickslab = Blocks.NETHER_BRICK_SLAB.getDefaultState();
	public final static BlockState netherbrickslabtop = netherbrickslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState netherbrickslabbottom = netherbrickslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState netherbrickslabdouble = netherbrickslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState petrifiedoakslab = Blocks.PETRIFIED_OAK_SLAB.getDefaultState();
	public final static BlockState petrifiedoakslabtop = petrifiedoakslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState petrifiedoakslabbottom = petrifiedoakslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState petrifiedoakslabdouble = petrifiedoakslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState purpurslab = Blocks.PURPUR_SLAB.getDefaultState();
	public final static BlockState purpurslabtop = purpurslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState purpurslabbottom = purpurslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState purpurslabdouble = purpurslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState quartzslab = Blocks.QUARTZ_SLAB.getDefaultState();
	public final static BlockState quartzslabtop = quartzslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState quartzslabbottom = quartzslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState quartzslabdouble = quartzslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState stoneslab = Blocks.STONE_SLAB.getDefaultState();
	public final static BlockState stoneslabtop = stoneslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState stoneslabbottom = stoneslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState stoneslabdouble = stoneslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState stonebrickslab = Blocks.STONE_BRICK_SLAB.getDefaultState();
	public final static BlockState stonebrickslabtop = stonebrickslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState stonebrickslabbottom = stonebrickslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState stonebrickslabdouble = stonebrickslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState sandstoneslab = Blocks.SANDSTONE_SLAB.getDefaultState();
	public final static BlockState sandstoneslabtop = sandstoneslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState sandstoneslabbottom = sandstoneslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState sandstoneslabdouble = sandstoneslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState redsandstoneslab = Blocks.RED_SANDSTONE_SLAB.getDefaultState();
	public final static BlockState redsandstoneslabtop = redsandstoneslab.with(SlabBlock.TYPE, SlabType.TOP);
	public final static BlockState redsandstoneslabbottom = redsandstoneslab.with(SlabBlock.TYPE, SlabType.BOTTOM);
	public final static BlockState redsandstoneslabdouble = redsandstoneslab.with(SlabBlock.TYPE, SlabType.DOUBLE);

	public final static BlockState ladder = Blocks.LADDER.getDefaultState();
	public final static BlockState laddernorth = ladder.with(FACING, Direction.NORTH);
	public final static BlockState laddersouth = ladder.with(FACING, Direction.SOUTH);
	public final static BlockState laddereast = ladder.with(FACING, Direction.EAST);
	public final static BlockState ladderwest = ladder.with(FACING, Direction.WEST);

	public final static BlockState irontrapdoor = Blocks.IRON_TRAPDOOR.getDefaultState();
	public final static BlockState irontrapdoornorthbottom = irontrapdoor.with(FACING, Direction.NORTH)
			.with(TrapDoorBlock.HALF, Half.BOTTOM);
	public final static BlockState irontrapdoorsouthbottom = irontrapdoor.with(FACING, Direction.SOUTH)
			.with(TrapDoorBlock.HALF, Half.BOTTOM);
	public final static BlockState irontrapdooreastbottom = irontrapdoor.with(FACING, Direction.EAST)
			.with(TrapDoorBlock.HALF, Half.BOTTOM);
	public final static BlockState irontrapdoorwestbottom = irontrapdoor.with(FACING, Direction.WEST)
			.with(TrapDoorBlock.HALF, Half.BOTTOM);
	public final static BlockState irontrapdoornorthtop = irontrapdoor.with(FACING, Direction.NORTH)
			.with(TrapDoorBlock.HALF, Half.TOP);
	public final static BlockState irontrapdoorsouthtop = irontrapdoor.with(FACING, Direction.SOUTH)
			.with(TrapDoorBlock.HALF, Half.TOP);
	public final static BlockState irontrapdooreasttop = irontrapdoor.with(FACING, Direction.EAST)
			.with(TrapDoorBlock.HALF, Half.TOP);
	public final static BlockState irontrapdoorwesttop = irontrapdoor.with(FACING, Direction.WEST)
			.with(TrapDoorBlock.HALF, Half.TOP);

	public final static BlockState oaktrapdoor = Blocks.OAK_TRAPDOOR.getDefaultState();
	public final static BlockState oaktrapdoornorthbottom = oaktrapdoor.with(FACING, Direction.NORTH)
			.with(TrapDoorBlock.HALF, Half.BOTTOM);
	public final static BlockState oaktrapdoorsouthbottom = oaktrapdoor.with(FACING, Direction.SOUTH)
			.with(TrapDoorBlock.HALF, Half.BOTTOM);
	public final static BlockState oaktrapdooreastbottom = oaktrapdoor.with(FACING, Direction.EAST)
			.with(TrapDoorBlock.HALF, Half.BOTTOM);
	public final static BlockState oaktrapdoorwestbottom = oaktrapdoor.with(FACING, Direction.WEST)
			.with(TrapDoorBlock.HALF, Half.BOTTOM);
	public final static BlockState oaktrapdoornorthtop = oaktrapdoor.with(FACING, Direction.NORTH)
			.with(TrapDoorBlock.HALF, Half.TOP);
	public final static BlockState oaktrapdoorsouthtop = oaktrapdoor.with(FACING, Direction.SOUTH)
			.with(TrapDoorBlock.HALF, Half.TOP);
	public final static BlockState oaktrapdooreasttop = oaktrapdoor.with(FACING, Direction.EAST)
			.with(TrapDoorBlock.HALF, Half.TOP);
	public final static BlockState oaktrapdoorwesttop = oaktrapdoor.with(FACING, Direction.WEST)
			.with(TrapDoorBlock.HALF, Half.TOP);

	public final static BlockState oakbutton = Blocks.OAK_BUTTON.getDefaultState();
	public final static BlockState oakbuttonnorth = oakbutton.with(FACING, Direction.NORTH);
	public final static BlockState oakbuttonsouth = oakbutton.with(FACING, Direction.SOUTH);
	public final static BlockState oakbuttoneast = oakbutton.with(FACING, Direction.EAST);
	public final static BlockState oakbuttonwest = oakbutton.with(FACING, Direction.WEST);

	public final static BlockState stonebutton = Blocks.STONE_BUTTON.getDefaultState();
	public final static BlockState stonebuttonnorth = stonebutton.with(FACING, Direction.NORTH);
	public final static BlockState stonebuttonsouth = stonebutton.with(FACING, Direction.SOUTH);
	public final static BlockState stonebuttoneast = stonebutton.with(FACING, Direction.EAST);
	public final static BlockState stonebuttonwest = stonebutton.with(FACING, Direction.WEST);

	public final static BlockState walltorch = Blocks.WALL_TORCH.getDefaultState();
	public final static BlockState walltorchnorth = walltorch.with(FACING, Direction.NORTH);
	public final static BlockState walltorchsouth = walltorch.with(FACING, Direction.SOUTH);
	public final static BlockState walltorcheast = walltorch.with(FACING, Direction.EAST);
	public final static BlockState walltorchwest = walltorch.with(FACING, Direction.WEST);

	public final static BlockState wallsign = Blocks.OAK_WALL_SIGN.getDefaultState();
	public final static BlockState wallsignnorth = wallsign.with(FACING, Direction.NORTH);
	public final static BlockState wallsignsouth = wallsign.with(FACING, Direction.SOUTH);
	public final static BlockState wallsigneast = wallsign.with(FACING, Direction.EAST);
	public final static BlockState wallsignwest = wallsign.with(FACING, Direction.WEST);

	public static void loadMaps() {

		blockProperties = new HashMap<String, String>();
		blockStates = new HashMap<String, BlockState>();
		blockIDs = new HashMap<Block, Integer>();
		newBlockStates = new HashMap<String, BlockState>();

		blockIDs.put(Blocks.AIR, 0);
		blockIDs.put(Blocks.STONE, 1);
		blockIDs.put(Blocks.GRASS_BLOCK, 2);
		blockIDs.put(Blocks.COARSE_DIRT, 3);
		blockIDs.put(Blocks.DIRT, 3);
		blockIDs.put(Blocks.COBBLESTONE, 4);
		blockIDs.put(Blocks.OAK_PLANKS, 5);
		blockIDs.put(Blocks.BEDROCK, 7);
		blockIDs.put(Blocks.WATER, 8);
		blockIDs.put(Blocks.WATER, 9);
		blockIDs.put(Blocks.LAVA, 10);
		blockIDs.put(Blocks.LAVA, 11);
		blockIDs.put(Blocks.SAND, 12);
		blockIDs.put(Blocks.GRAVEL, 13);
		blockIDs.put(Blocks.OAK_LOG, 17);
		blockIDs.put(Blocks.OAK_LEAVES, 18);
		blockIDs.put(Blocks.SPONGE, 19);
		blockIDs.put(Blocks.GLASS, 20);
		blockIDs.put(Blocks.LAPIS_BLOCK, 22);
		blockIDs.put(Blocks.DISPENSER, 23);
		blockIDs.put(Blocks.SANDSTONE, 24);
		blockIDs.put(Blocks.COBWEB, 30);
		blockIDs.put(Blocks.BLACK_WOOL, 35);
		blockIDs.put(Blocks.GOLD_BLOCK, 41);
		blockIDs.put(Blocks.IRON_BLOCK, 42);
		blockIDs.put(Blocks.COBBLESTONE_SLAB, 44);
		blockIDs.put(Blocks.BRICKS, 45);
		blockIDs.put(Blocks.TNT, 46);
		blockIDs.put(Blocks.BOOKSHELF, 47);
		blockIDs.put(Blocks.MOSSY_COBBLESTONE, 48);
		blockIDs.put(Blocks.OBSIDIAN, 49);
		blockIDs.put(Blocks.TORCH, 50);
		//blockIDs.put(Blocks.WALL_TORCH, 50);
		blockIDs.put(Blocks.FIRE, 51);
		blockIDs.put(Blocks.OAK_STAIRS, 53);
		blockIDs.put(Blocks.CHEST, 54);
		blockIDs.put(Blocks.REDSTONE_WIRE, 55);
		blockIDs.put(Blocks.DIAMOND_BLOCK, 57);
		blockIDs.put(Blocks.CRAFTING_TABLE, 58);
		blockIDs.put(Blocks.WHEAT, 59);
		blockIDs.put(Blocks.FARMLAND, 60);
		blockIDs.put(Blocks.FURNACE, 61);
		blockIDs.put(Blocks.OAK_DOOR, 64);
		blockIDs.put(Blocks.LADDER, 65);
		blockIDs.put(Blocks.RAIL, 66);
		blockIDs.put(Blocks.COBBLESTONE_STAIRS, 67);
		blockIDs.put(Blocks.OAK_WALL_SIGN, 68);
		blockIDs.put(Blocks.LEVER, 69);
		blockIDs.put(Blocks.STONE_PRESSURE_PLATE, 70);
		blockIDs.put(Blocks.IRON_DOOR, 71);	
		blockIDs.put(Blocks.REDSTONE_TORCH, 76);
		blockIDs.put(Blocks.STONE_BUTTON, 77);
		blockIDs.put(Blocks.CACTUS, 81);
		blockIDs.put(Blocks.CLAY, 82);
		blockIDs.put(Blocks.SUGAR_CANE, 83);
		blockIDs.put(Blocks.JUKEBOX, 84);
		blockIDs.put(Blocks.OAK_FENCE, 85);
		blockIDs.put(Blocks.PUMPKIN, 86);
		blockIDs.put(Blocks.NETHERRACK, 87);
		blockIDs.put(Blocks.SOUL_SAND, 88);
		blockIDs.put(Blocks.GLOWSTONE, 89);
		blockIDs.put(Blocks.JACK_O_LANTERN, 91);
		blockIDs.put(Blocks.BLACK_STAINED_GLASS, 95);
		blockIDs.put(Blocks.OAK_TRAPDOOR, 96);
		blockIDs.put(Blocks.STONE_BRICKS, 98);
		blockIDs.put(Blocks.IRON_BARS, 101);
		blockIDs.put(Blocks.GLASS_PANE, 102);
		blockIDs.put(Blocks.MELON, 103);
		blockIDs.put(Blocks.BRICK_STAIRS, 108);
		blockIDs.put(Blocks.STONE_BRICK_STAIRS, 109);
		blockIDs.put(Blocks.NETHER_BRICKS, 112);
		blockIDs.put(Blocks.NETHER_BRICK_STAIRS, 114);
		blockIDs.put(Blocks.ENCHANTING_TABLE, 116);
		blockIDs.put(Blocks.BREWING_STAND, 117);
		blockIDs.put(Blocks.CAULDRON, 118);
		blockIDs.put(Blocks.END_STONE, 121);
		blockIDs.put(Blocks.REDSTONE_LAMP, 123);
		blockIDs.put(Blocks.REDSTONE_LAMP, 124);
		blockIDs.put(Blocks.OAK_SLAB, 126);
		blockIDs.put(Blocks.SANDSTONE_STAIRS, 128);
		blockIDs.put(Blocks.EMERALD_BLOCK, 133);
		blockIDs.put(Blocks.SPRUCE_STAIRS, 134);
		blockIDs.put(Blocks.JUNGLE_STAIRS, 136);
		blockIDs.put(Blocks.BEACON, 138);
		blockIDs.put(Blocks.COBBLESTONE_WALL, 139);
		blockIDs.put(Blocks.POTTED_CACTUS, 140);
		blockIDs.put(Blocks.CARROTS, 141);
		blockIDs.put(Blocks.POTATOES, 142);
		blockIDs.put(Blocks.ANVIL, 145);
		blockIDs.put(Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, 147);
		blockIDs.put(Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE, 148);
		blockIDs.put(Blocks.REDSTONE_BLOCK, 152);
		blockIDs.put(Blocks.HOPPER, 154);
		blockIDs.put(Blocks.QUARTZ_BLOCK, 155);
		blockIDs.put(Blocks.DROPPER, 158);
		blockIDs.put(Blocks.ACACIA_LEAVES, 161);
		blockIDs.put(Blocks.ACACIA_LOG, 162);
		blockIDs.put(Blocks.DARK_OAK_LOG, 163);
		blockIDs.put(Blocks.DARK_OAK_STAIRS, 164);
		blockIDs.put(Blocks.SLIME_BLOCK, 165);
		blockIDs.put(Blocks.BARRIER, 166);
		blockIDs.put(Blocks.IRON_TRAPDOOR, 167);
		blockIDs.put(Blocks.PRISMARINE, 168);
		blockIDs.put(Blocks.SEA_LANTERN, 169);
		blockIDs.put(Blocks.HAY_BLOCK, 170);
		blockIDs.put(Blocks.COAL_BLOCK, 173);
		blockIDs.put(Blocks.RED_SANDSTONE, 179);
		blockIDs.put(Blocks.RED_SANDSTONE_SLAB, 182);
		blockIDs.put(Blocks.SPRUCE_FENCE, 188);
		blockIDs.put(Blocks.BIRCH_FENCE, 189);
		blockIDs.put(Blocks.JUNGLE_FENCE, 190);
		blockIDs.put(Blocks.DARK_OAK_FENCE, 191);
		blockIDs.put(Blocks.ACACIA_FENCE, 192);
		blockIDs.put(Blocks.PURPUR_BLOCK, 201);
		blockIDs.put(Blocks.PURPUR_PILLAR, 202);
		blockIDs.put(Blocks.PURPUR_STAIRS, 203);
		blockIDs.put(Blocks.PURPUR_SLAB, 205);
		blockIDs.put(Blocks.END_STONE_BRICKS, 206);
		blockIDs.put(Blocks.BEETROOTS, 207);
		blockIDs.put(Blocks.GRASS_PATH, 208);
		blockIDs.put(Blocks.OAK_SIGN, 323);
		blockIDs.put(Blocks.SMOOTH_STONE, 900);
		blockIDs.put(Blocks.SMOOTH_SANDSTONE, 901);
		blockIDs.put(Blocks.SMOOTH_QUARTZ, 902);
		blockIDs.put(Blocks.PETRIFIED_OAK_SLAB, 904);
		blockIDs.put(Blocks.ANDESITE, 1001);
		blockIDs.put(Blocks.DIORITE, 1002);
		blockIDs.put(Blocks.GRANITE, 1003);
		blockIDs.put(Blocks.POLISHED_ANDESITE, 1004);
		blockIDs.put(Blocks.POLISHED_DIORITE, 1005);
		blockIDs.put(Blocks.POLISHED_GRANITE, 1006);
		blockIDs.put(Blocks.RED_SAND, 1201);
		blockIDs.put(Blocks.SPRUCE_SLAB, 1260);
		blockIDs.put(Blocks.JUNGLE_SLAB, 1262);
		blockIDs.put(Blocks.ACACIA_SLAB, 1263);
		blockIDs.put(Blocks.DARK_OAK_SLAB, 1264);
		blockIDs.put(Blocks.MOSSY_COBBLESTONE_WALL, 1390);
		blockIDs.put(Blocks.CHISELED_QUARTZ_BLOCK, 1551);
		blockIDs.put(Blocks.QUARTZ_PILLAR, 1552);
		blockIDs.put(Blocks.DARK_OAK_LEAVES, 1610);
		blockIDs.put(Blocks.DARK_OAK_LOG, 1620);
		blockIDs.put(Blocks.DARK_PRISMARINE, 1680);
		blockIDs.put(Blocks.PRISMARINE_BRICKS, 1681);
		blockIDs.put(Blocks.BIRCH_LOG, 1701);
		blockIDs.put(Blocks.JUNGLE_LOG, 1702);
		blockIDs.put(Blocks.SPRUCE_LOG, 1703);
		blockIDs.put(Blocks.CHISELED_RED_SANDSTONE, 1791);
		blockIDs.put(Blocks.CUT_RED_SANDSTONE, 1792);
		blockIDs.put(Blocks.SMOOTH_RED_SANDSTONE, 1793);
		blockIDs.put(Blocks.BIRCH_LEAVES, 1801);
		blockIDs.put(Blocks.JUNGLE_LEAVES, 1802);
		blockIDs.put(Blocks.SPRUCE_LEAVES, 1803);
		blockIDs.put(Blocks.WET_SPONGE, 1901);
		blockIDs.put(Blocks.CHISELED_SANDSTONE, 2401);
		blockIDs.put(Blocks.CUT_SANDSTONE, 2402);
		blockIDs.put(Blocks.PODZOL, 3001);
		blockIDs.put(Blocks.BLUE_WOOL, 3501);
		blockIDs.put(Blocks.BROWN_WOOL, 3502);
		blockIDs.put(Blocks.CYAN_WOOL, 3503);
		blockIDs.put(Blocks.GRAY_WOOL, 3504);
		blockIDs.put(Blocks.GREEN_WOOL, 3505);
		blockIDs.put(Blocks.LIGHT_BLUE_WOOL, 3506);
		blockIDs.put(Blocks.LIGHT_GRAY_WOOL, 3507);
		blockIDs.put(Blocks.LIME_WOOL, 3508);
		blockIDs.put(Blocks.MAGENTA_WOOL, 3509);
		blockIDs.put(Blocks.ORANGE_WOOL, 3510);
		blockIDs.put(Blocks.PINK_WOOL, 3511);
		blockIDs.put(Blocks.PURPLE_WOOL, 3512);
		blockIDs.put(Blocks.RED_WOOL, 3513);
		blockIDs.put(Blocks.WHITE_WOOL, 3514);
		blockIDs.put(Blocks.YELLOW_WOOL, 3515);
		blockIDs.put(Blocks.BRICK_SLAB, 4401);
		blockIDs.put(Blocks.NETHER_BRICK_SLAB, 4402);
		blockIDs.put(Blocks.QUARTZ_SLAB, 4403);
		blockIDs.put(Blocks.SANDSTONE_SLAB, 4404);
		blockIDs.put(Blocks.STONE_BRICK_SLAB, 4405);
		blockIDs.put(Blocks.STONE_SLAB, 4406);
		blockIDs.put(Blocks.BIRCH_PLANKS, 5001);
		blockIDs.put(Blocks.DARK_OAK_PLANKS, 5002);
		blockIDs.put(Blocks.JUNGLE_PLANKS, 5003);
		blockIDs.put(Blocks.SPRUCE_PLANKS, 5004);
		blockIDs.put(Blocks.ACACIA_PLANKS, 5005);
		blockIDs.put(Blocks.BLUE_STAINED_GLASS, 9501);
		blockIDs.put(Blocks.BROWN_STAINED_GLASS, 9502);
		blockIDs.put(Blocks.CYAN_STAINED_GLASS, 9503);
		blockIDs.put(Blocks.GRAY_STAINED_GLASS, 9504);
		blockIDs.put(Blocks.GREEN_STAINED_GLASS, 9505);
		blockIDs.put(Blocks.LIGHT_BLUE_STAINED_GLASS, 9506);
		blockIDs.put(Blocks.LIGHT_GRAY_STAINED_GLASS, 9507);
		blockIDs.put(Blocks.LIME_STAINED_GLASS, 9508);
		blockIDs.put(Blocks.MAGENTA_STAINED_GLASS, 9509);
		blockIDs.put(Blocks.ORANGE_STAINED_GLASS, 9510);
		blockIDs.put(Blocks.PINK_STAINED_GLASS, 9511);
		blockIDs.put(Blocks.PURPLE_STAINED_GLASS, 9512);
		blockIDs.put(Blocks.RED_STAINED_GLASS, 9513);
		blockIDs.put(Blocks.WHITE_STAINED_GLASS, 9514);
		blockIDs.put(Blocks.YELLOW_STAINED_GLASS, 9515);
		blockIDs.put(Blocks.CHISELED_STONE_BRICKS, 9801);
		blockIDs.put(Blocks.CRACKED_STONE_BRICKS, 9802);
		blockIDs.put(Blocks.MOSSY_STONE_BRICKS, 9803);
		blockIDs.put(Blocks.WHITE_TERRACOTTA, 15901);
		blockIDs.put(Blocks.PURPLE_TERRACOTTA, 15902);
		blockIDs.put(Blocks.BLUE_TERRACOTTA, 15903);
		blockIDs.put(Blocks.BROWN_TERRACOTTA, 15904);
		blockIDs.put(Blocks.GREEN_TERRACOTTA, 15905);
		blockIDs.put(Blocks.RED_TERRACOTTA, 15906);
		blockIDs.put(Blocks.BLACK_TERRACOTTA, 15907);
		blockIDs.put(Blocks.ORANGE_TERRACOTTA, 15908);
		blockIDs.put(Blocks.MAGENTA_TERRACOTTA, 15909);
		blockIDs.put(Blocks.LIGHT_BLUE_TERRACOTTA, 15910);
		blockIDs.put(Blocks.YELLOW_TERRACOTTA, 15911);
		blockIDs.put(Blocks.LIME_TERRACOTTA, 15912);
		blockIDs.put(Blocks.PINK_TERRACOTTA, 15913);
		blockIDs.put(Blocks.GRAY_TERRACOTTA, 15914);
		blockIDs.put(Blocks.LIGHT_GRAY_TERRACOTTA, 15915);
		blockIDs.put(Blocks.CYAN_TERRACOTTA, 15916);
		blockIDs.put(Blocks.WHITE_STAINED_GLASS_PANE, 16001);
		blockIDs.put(Blocks.PURPLE_STAINED_GLASS_PANE, 16002);
		blockIDs.put(Blocks.BLUE_STAINED_GLASS_PANE, 16003);
		blockIDs.put(Blocks.BROWN_STAINED_GLASS_PANE, 16004);
		blockIDs.put(Blocks.GREEN_STAINED_GLASS_PANE, 16005);
		blockIDs.put(Blocks.RED_STAINED_GLASS_PANE, 16006);
		blockIDs.put(Blocks.BLACK_STAINED_GLASS_PANE, 16007);
		blockIDs.put(Blocks.ORANGE_STAINED_GLASS_PANE, 16008);
		blockIDs.put(Blocks.MAGENTA_STAINED_GLASS_PANE, 16009);
		blockIDs.put(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, 16010);
		blockIDs.put(Blocks.YELLOW_STAINED_GLASS_PANE, 16011);
		blockIDs.put(Blocks.LIME_STAINED_GLASS_PANE, 16012);
		blockIDs.put(Blocks.PINK_STAINED_GLASS_PANE, 16013);
		blockIDs.put(Blocks.GRAY_STAINED_GLASS_PANE, 16014);
		blockIDs.put(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, 16015);
		blockIDs.put(Blocks.CYAN_STAINED_GLASS_PANE, 16016);
		blockIDs.put(Blocks.WHITE_CARPET, 17101);
		blockIDs.put(Blocks.PURPLE_CARPET, 17102);
		blockIDs.put(Blocks.BLUE_CARPET, 17103);
		blockIDs.put(Blocks.BROWN_CARPET, 17104);
		blockIDs.put(Blocks.GREEN_CARPET, 17105);
		blockIDs.put(Blocks.RED_CARPET, 17106);
		blockIDs.put(Blocks.BLACK_CARPET, 17107);
		blockIDs.put(Blocks.ORANGE_CARPET, 17108);
		blockIDs.put(Blocks.MAGENTA_CARPET, 17109);
		blockIDs.put(Blocks.LIGHT_BLUE_CARPET, 17110);
		blockIDs.put(Blocks.YELLOW_CARPET, 17111);
		blockIDs.put(Blocks.LIME_CARPET, 17112);
		blockIDs.put(Blocks.PINK_CARPET, 17113);
		blockIDs.put(Blocks.GRAY_CARPET, 17114);
		blockIDs.put(Blocks.LIGHT_GRAY_CARPET, 17115);
		blockIDs.put(Blocks.CYAN_CARPET, 17116);
		blockIDs.put(Blocks.WHITE_CONCRETE, 25101);
		blockIDs.put(Blocks.PURPLE_CONCRETE, 25102);
		blockIDs.put(Blocks.BLUE_CONCRETE, 25103);
		blockIDs.put(Blocks.BROWN_CONCRETE, 25104);
		blockIDs.put(Blocks.GREEN_CONCRETE, 25105);
		blockIDs.put(Blocks.RED_CONCRETE, 25106);
		blockIDs.put(Blocks.BLACK_CONCRETE, 25107);
		blockIDs.put(Blocks.ORANGE_CONCRETE, 25108);
		blockIDs.put(Blocks.MAGENTA_CONCRETE, 25109);
		blockIDs.put(Blocks.LIGHT_BLUE_CONCRETE, 25110);
		blockIDs.put(Blocks.YELLOW_CONCRETE, 25111);
		blockIDs.put(Blocks.LIME_CONCRETE, 25112);
		blockIDs.put(Blocks.PINK_CONCRETE, 25113);
		blockIDs.put(Blocks.GRAY_CONCRETE, 25114);
		blockIDs.put(Blocks.LIGHT_GRAY_CONCRETE, 25115);
		blockIDs.put(Blocks.CYAN_CONCRETE, 25116);
		blockIDs.put(Blocks.WHITE_CONCRETE_POWDER, 25401);
		blockIDs.put(Blocks.ORANGE_CONCRETE_POWDER, 25402);
		blockIDs.put(Blocks.MAGENTA_CONCRETE_POWDER, 25403);
		blockIDs.put(Blocks.LIGHT_BLUE_CONCRETE_POWDER, 25404);
		blockIDs.put(Blocks.PURPLE_CONCRETE_POWDER, 25405);
		blockIDs.put(Blocks.BLUE_CONCRETE_POWDER, 25406);
		blockIDs.put(Blocks.BROWN_CONCRETE_POWDER, 25407);
		blockIDs.put(Blocks.GREEN_CONCRETE_POWDER, 25408);
		blockIDs.put(Blocks.RED_CONCRETE_POWDER, 25409);
		blockIDs.put(Blocks.BLACK_CONCRETE_POWDER, 25410);
		blockIDs.put(Blocks.YELLOW_CONCRETE_POWDER, 25411);
		blockIDs.put(Blocks.LIME_CONCRETE_POWDER, 25412);
		blockIDs.put(Blocks.PINK_CONCRETE_POWDER, 25413);
		blockIDs.put(Blocks.GRAY_CONCRETE_POWDER, 25414);
		blockIDs.put(Blocks.LIGHT_GRAY_CONCRETE_POWDER, 25415);
		blockIDs.put(Blocks.CYAN_CONCRETE_POWDER, 25416);

		newBlockStates.put("0x", air);
		newBlockStates.put("1x", stone);
		newBlockStates.put("2x", grass_block);
		newBlockStates.put("3x", dirt);
		newBlockStates.put("3x", coarse_dirt);
		newBlockStates.put("4x", cobblestone);
		newBlockStates.put("5x", oak_planks);
		newBlockStates.put("7x", bedrock);
		newBlockStates.put("8x", water);
		newBlockStates.put("9x", water);
		newBlockStates.put("10x", lava);
		newBlockStates.put("11x", lava);
		newBlockStates.put("12x", sand);
		newBlockStates.put("13x", gravel);
		newBlockStates.put("17xya", oaklogy);
		newBlockStates.put("17xza", oaklogz);
		newBlockStates.put("17xxa", oaklogx);
		newBlockStates.put("18x", oak_leaves);
		newBlockStates.put("19x", sponge);
		newBlockStates.put("20x", glass);
		newBlockStates.put("22x", lapis_block);
		newBlockStates.put("23x", dispenser);
		newBlockStates.put("24x", sandstone);
		newBlockStates.put("30x", cobweb);
		newBlockStates.put("35x", black_wool);
		newBlockStates.put("41x", gold_block);
		newBlockStates.put("42x", iron_block);
		newBlockStates.put("43x", stone);
		newBlockStates.put("43x", sandstone);
		newBlockStates.put("43x", cobblestone);
		newBlockStates.put("43x", bricks);
		newBlockStates.put("43x", stone_bricks);
		newBlockStates.put("43x", nether_bricks);
		newBlockStates.put("43x", quartz_block);
		newBlockStates.put("44xbh", cobblestoneslabbottom);
		newBlockStates.put("44xth", cobblestoneslabtop);
		newBlockStates.put("45x", bricks);
		newBlockStates.put("46x", tnt);
		newBlockStates.put("47x", bookshelf);
		newBlockStates.put("48x", mossy_cobblestone);
		newBlockStates.put("49x", obsidian);
		newBlockStates.put("50x", torch);
		//newBlockStates.put("50xef", walltorcheast);
		//newBlockStates.put("50xnf", walltorchnorth);
		//newBlockStates.put("50xsf", walltorchsouth);
		//newBlockStates.put("50xwf", walltorchwest);
		newBlockStates.put("51x", fire);
		newBlockStates.put("53x", oakStairs);
		newBlockStates.put("53xefbh", oakStairseastbottom);
		newBlockStates.put("53xefth", oakStairseasttop);
		newBlockStates.put("53xnfbh", oakStairsnorthbottom);
		newBlockStates.put("53xnfth", oakStairsnorthtop);
		newBlockStates.put("53xsfbh", oakStairssouthbottom);
		newBlockStates.put("53xsfth", oakStairssouthtop);
		newBlockStates.put("53xwfbh", oakStairswestbottom);
		newBlockStates.put("53xwfth", oakStairswesttop);
		newBlockStates.put("54xef", chesteast);
		newBlockStates.put("54xwf", chestwest);
		newBlockStates.put("54xnf", chestnorth);
		newBlockStates.put("54xsf", chestsouth);
		newBlockStates.put("55x", redstone_wire);
		newBlockStates.put("57x", diamond_block);
		newBlockStates.put("58x", crafting_table);
		newBlockStates.put("59x", wheat);
		newBlockStates.put("60x", farmland);
		newBlockStates.put("61x", furnace);
		newBlockStates.put("61xef", furnaceeast);
		newBlockStates.put("61xwf", furnacewest);
		newBlockStates.put("61xnf", furnacenorth);
		newBlockStates.put("61xsf", furnacesouth);
		newBlockStates.put("64x", oakDoor);
		newBlockStates.put("64xeflh", oakDooreastlower);
		newBlockStates.put("64xnflh", oakDoornorthlower);
		newBlockStates.put("64xsflh", oakDoorsouthlower);
		newBlockStates.put("64xwflh", oakDoorwestlower);
		newBlockStates.put("64xefuh", oakDooreastupper);
		newBlockStates.put("64xnfuh", oakDoornorthupper);
		newBlockStates.put("64xsfuh", oakDoorsouthupper);
		newBlockStates.put("64xwfuh", oakDoorwestupper);	
		newBlockStates.put("71x", ironDoor);
		newBlockStates.put("71xeflh", ironDooreastlower);
		newBlockStates.put("71xnflh", ironDoornorthlower);
		newBlockStates.put("71xsflh", ironDoorsouthlower);
		newBlockStates.put("71xwflh", ironDoorwestlower);
		newBlockStates.put("71xefuh", ironDooreastupper);
		newBlockStates.put("71xnfuh", ironDoornorthupper);
		newBlockStates.put("71xsfuh", ironDoorsouthupper);
		newBlockStates.put("71xwfuh", ironDoorwestupper);	
		newBlockStates.put("65x", ladder);
		newBlockStates.put("65xef", laddereast);
		newBlockStates.put("65xnf", laddernorth);
		newBlockStates.put("65xsf", laddersouth);
		newBlockStates.put("65xwf", ladderwest);
		newBlockStates.put("66x", rail);
		newBlockStates.put("67x", cobblestoneStairs);
		newBlockStates.put("67xefbh", cobblestoneStairseastbottom);
		newBlockStates.put("67xefth", cobblestoneStairseasttop);
		newBlockStates.put("67xnfbh", cobblestoneStairsnorthbottom);
		newBlockStates.put("67xnfth", cobblestoneStairsnorthtop);
		newBlockStates.put("67xsfbh", cobblestoneStairssouthbottom);
		newBlockStates.put("67xsfth", cobblestoneStairssouthtop);
		newBlockStates.put("67xwfbh", cobblestoneStairswestbottom);
		newBlockStates.put("67xwfth", cobblestoneStairswesttop);
		newBlockStates.put("68x", wallsign);
		newBlockStates.put("68xef", wallsigneast);
		newBlockStates.put("68xnf", wallsignnorth);
		newBlockStates.put("68xsf", wallsignsouth);
		newBlockStates.put("68xwf", wallsignwest);
		newBlockStates.put("69x", lever);
		newBlockStates.put("70x", stone_pressure_plate);
		newBlockStates.put("76x", redstone_torch);
		newBlockStates.put("77x", stonebutton);
		newBlockStates.put("77xef", stonebuttoneast);
		newBlockStates.put("77xnf", stonebuttonnorth);
		newBlockStates.put("77xsf", stonebuttonsouth);
		newBlockStates.put("77xwf", stonebuttonwest);
		newBlockStates.put("81x", cactus);
		newBlockStates.put("82x", clay);
		newBlockStates.put("83x", sugar_cane);
		newBlockStates.put("84x", jukebox);
		newBlockStates.put("85x", oak_fence);
		newBlockStates.put("86x", pumpkin);
		newBlockStates.put("87x", netherrack);
		newBlockStates.put("88x", soul_sand);
		newBlockStates.put("89x", glowstone);
		newBlockStates.put("91x", jackolantern);
		newBlockStates.put("95x", black_stained_glass);
		newBlockStates.put("96x", oaktrapdoor);
		newBlockStates.put("96xefbh", oaktrapdooreastbottom);
		newBlockStates.put("96xefth", oaktrapdooreasttop);
		newBlockStates.put("96xnfbh", oaktrapdoornorthbottom);
		newBlockStates.put("96xnfth", oaktrapdoornorthtop);
		newBlockStates.put("96xsfbh", oaktrapdoorsouthbottom);
		newBlockStates.put("96xsfth", oaktrapdoorsouthtop);
		newBlockStates.put("96xwfbh", oaktrapdoorwestbottom);
		newBlockStates.put("96xwfth", oaktrapdoorwesttop);
		newBlockStates.put("98x", stone_bricks);
		newBlockStates.put("101x", iron_bars);
		newBlockStates.put("102x", glass);
		newBlockStates.put("102xef", glass_paneeast);
		newBlockStates.put("102xnf", glass_panenorth);
		newBlockStates.put("102xsf", glass_panesouth);
		newBlockStates.put("102xwf", glass_panewest);
		newBlockStates.put("103x", melon_block);
		newBlockStates.put("108x", brickStairs);
		newBlockStates.put("108xefbh", brickStairseastbottom);
		newBlockStates.put("108xefth", brickStairseasttop);
		newBlockStates.put("108nfbhx", brickStairsnorthbottom);
		newBlockStates.put("108xnfth", brickStairsnorthtop);
		newBlockStates.put("108xsfbh", brickStairssouthbottom);
		newBlockStates.put("108xsfth", brickStairssouthtop);
		newBlockStates.put("108xwfbh", brickStairswestbottom);
		newBlockStates.put("108xwfth", brickStairswesttop);
		newBlockStates.put("109x", stonebrickStairs);
		newBlockStates.put("109xefbh", stonebrickStairseastbottom);
		newBlockStates.put("109xefth", stonebrickStairseasttop);
		newBlockStates.put("109xnfbh", stonebrickStairsnorthbottom);
		newBlockStates.put("109xnfth", stonebrickStairsnorthtop);
		newBlockStates.put("109xsfbh", stonebrickStairssouthbottom);
		newBlockStates.put("109xsfth", stonebrickStairssouthtop);
		newBlockStates.put("109xwfbh", stonebrickStairswestbottom);
		newBlockStates.put("109xwfth", stonebrickStairswesttop);
		newBlockStates.put("112x", nether_bricks);
		newBlockStates.put("114x", netherbrickStairs);
		newBlockStates.put("114xefbh", netherbrickStairseastbottom);
		newBlockStates.put("114xefth", netherbrickStairseasttop);
		newBlockStates.put("114xnfbh", netherbrickStairsnorthbottom);
		newBlockStates.put("114xnfth", netherbrickStairsnorthtop);
		newBlockStates.put("114xsfbh", netherbrickStairssouthbottom);
		newBlockStates.put("114xsfth", netherbrickStairssouthtop);
		newBlockStates.put("114xwfbh", netherbrickStairswestbottom);
		newBlockStates.put("114xwfth", netherbrickStairswesttop);
		newBlockStates.put("116x", enchanting_table);
		newBlockStates.put("117x", brewing_stand);
		newBlockStates.put("118x", cauldron);
		newBlockStates.put("121x", end_stone);
		newBlockStates.put("123x", redstone_lamp);
		newBlockStates.put("124x", redstone_lamp);
		newBlockStates.put("125x", oak_planks);
		newBlockStates.put("125x", spruce_planks);
		newBlockStates.put("125x", jungle_planks);
		newBlockStates.put("125x", acacia_planks);
		newBlockStates.put("125x", dark_oak_planks);
		newBlockStates.put("126xbh", oakslabbottom);
		newBlockStates.put("126xth", oakslabtop);
		newBlockStates.put("128x", sandstoneStairs);
		newBlockStates.put("128xefbh", sandstoneStairseastbottom);
		newBlockStates.put("128xefth", sandstoneStairseasttop);
		newBlockStates.put("128xnfbh", sandstoneStairsnorthbottom);
		newBlockStates.put("128xnfth", sandstoneStairsnorthtop);
		newBlockStates.put("128xsfbh", sandstoneStairssouthbottom);
		newBlockStates.put("128xsfth", sandstoneStairssouthtop);
		newBlockStates.put("128xwfbh", sandstoneStairswestbottom);
		newBlockStates.put("128xwfth", sandstoneStairswesttop);
		newBlockStates.put("133x", emerald_block);
		newBlockStates.put("134x", spruceStairs);
		newBlockStates.put("134xefbh", spruceStairseastbottom);
		newBlockStates.put("134xefth", spruceStairseasttop);
		newBlockStates.put("134xnfbh", spruceStairsnorthbottom);
		newBlockStates.put("134xnfth", spruceStairsnorthtop);
		newBlockStates.put("134xsfbh", spruceStairssouthbottom);
		newBlockStates.put("134xsfth", spruceStairssouthtop);
		newBlockStates.put("134xwfbh", spruceStairswestbottom);
		newBlockStates.put("134xwfth", spruceStairswesttop);
		newBlockStates.put("135x", birchStairs);
		newBlockStates.put("135xefbh", birchStairseastbottom);
		newBlockStates.put("135xefth", birchStairseasttop);
		newBlockStates.put("135xnfbh", birchStairsnorthbottom);
		newBlockStates.put("135xnfth", birchStairsnorthtop);
		newBlockStates.put("135xsfbh", birchStairssouthbottom);
		newBlockStates.put("135xsfth", birchStairssouthtop);
		newBlockStates.put("135xwfbh", birchStairswestbottom);
		newBlockStates.put("135xwfth", birchStairswesttop);
		newBlockStates.put("136x", jungleStairs);
		newBlockStates.put("136xefbh", jungleStairseastbottom);
		newBlockStates.put("136xefth", jungleStairseasttop);
		newBlockStates.put("136xnfbh", jungleStairsnorthbottom);
		newBlockStates.put("136xnfth", jungleStairsnorthtop);
		newBlockStates.put("136xsfbh", jungleStairssouthbottom);
		newBlockStates.put("136xsfth", jungleStairssouthtop);
		newBlockStates.put("136xwfbh", jungleStairswestbottom);
		newBlockStates.put("136xwfth", jungleStairswesttop);
		newBlockStates.put("138x", beacon);
		newBlockStates.put("139x", cobblestone_wall);
		newBlockStates.put("140x", potted_cactus);
		newBlockStates.put("141x", carrots);
		newBlockStates.put("142x", potatoes);
		newBlockStates.put("143x", oakbutton);
		newBlockStates.put("143xef", oakbuttoneast);
		newBlockStates.put("143xnf", oakbuttonnorth);
		newBlockStates.put("143xsf", oakbuttonsouth);
		newBlockStates.put("143xwf", oakbuttonwest);
		newBlockStates.put("145x", anvil);
		newBlockStates.put("146x", chest);
		newBlockStates.put("147x", light_weighted_pressure_plate);
		newBlockStates.put("148x", heavy_weighted_pressure_plate);
		newBlockStates.put("152x", redstone_block);
		newBlockStates.put("154x", hopper);
		newBlockStates.put("155x", quartz_block);
		newBlockStates.put("158x", dropper);
		newBlockStates.put("161x", acacia_leaves);
		newBlockStates.put("163xxa", darkoaklogx);
		newBlockStates.put("163xya", darkoaklogy);
		newBlockStates.put("163xza", darkoaklogz);
		newBlockStates.put("162xxa", acacialogx);
		newBlockStates.put("162xya", acacialogy);
		newBlockStates.put("162xza", acacialogz);
		newBlockStates.put("164x", darkoakStairs);
		newBlockStates.put("164xefbh", darkoakStairseastbottom);
		newBlockStates.put("164xefth", darkoakStairseasttop);
		newBlockStates.put("164xnfbh", darkoakStairsnorthbottom);
		newBlockStates.put("164xnfth", darkoakStairsnorthtop);
		newBlockStates.put("164xsfbh", darkoakStairssouthbottom);
		newBlockStates.put("164xsfth", darkoakStairssouthtop);
		newBlockStates.put("164xwfbh", darkoakStairswestbottom);
		newBlockStates.put("164xwfbh", darkoakStairswesttop);
		newBlockStates.put("165x", slime_block);
		newBlockStates.put("166x", barrier);
		newBlockStates.put("167x", irontrapdoor);
		newBlockStates.put("167xefbh", irontrapdooreastbottom);
		newBlockStates.put("167xefth", irontrapdooreasttop);
		newBlockStates.put("167xnfbh", irontrapdoornorthbottom);
		newBlockStates.put("167xnfth", irontrapdoornorthtop);
		newBlockStates.put("167xsfbh", irontrapdoorsouthbottom);
		newBlockStates.put("167xsfth", irontrapdoorsouthtop);
		newBlockStates.put("167xwfbh", irontrapdoorwestbottom);
		newBlockStates.put("167xwfth", irontrapdoorwesttop);
		newBlockStates.put("168x", prismarine);
		newBlockStates.put("169x", sea_lantern);
		newBlockStates.put("170x", hay_bale);
		newBlockStates.put("173x", coal_block);
		newBlockStates.put("179x", red_sandstone);
		newBlockStates.put("181x", redsandstoneslabdouble);
		newBlockStates.put("182x", redsandstoneslab);
		newBlockStates.put("182xbh", redsandstoneslabbottom);
		newBlockStates.put("182xth", redsandstoneslabtop);
		newBlockStates.put("188x", spruce_fence);
		newBlockStates.put("189x", birch_fence);
		newBlockStates.put("190x", jungle_fence);
		newBlockStates.put("191x", dark_oak_fence);
		newBlockStates.put("192x", acacia_fence);
		newBlockStates.put("203x", purpurStairs);
		newBlockStates.put("203xefbh", purpurStairseastbottom);
		newBlockStates.put("203xefth", purpurStairseasttop);
		newBlockStates.put("203xnfbh", purpurStairsnorthbottom);
		newBlockStates.put("203xnfth", purpurStairsnorthtop);
		newBlockStates.put("203xsfbh", purpurStairssouthbottom);
		newBlockStates.put("203xsfth", purpurStairssouthtop);
		newBlockStates.put("203xwfbh", purpurStairswestbottom);
		newBlockStates.put("203xwfth", purpurStairswesttop);
		newBlockStates.put("204x", purpurslabdouble);
		newBlockStates.put("205x", purpurslab);
		newBlockStates.put("205xbh", purpurslabbottom);
		newBlockStates.put("205xth", purpurslabtop);
		newBlockStates.put("206x", end_stone_bricks);
		newBlockStates.put("207x", beetroots);
		newBlockStates.put("208x", grass_path);
		newBlockStates.put("323x", sign);
		newBlockStates.put("900x", smooth_stone);
		newBlockStates.put("901x", smooth_sandstone);
		newBlockStates.put("902x", smooth_quartz);
		newBlockStates.put("904x", petrifiedoakslab);
		newBlockStates.put("904xbh", petrifiedoakslabbottom);
		newBlockStates.put("904xbh", petrifiedoakslabtop);
		newBlockStates.put("905x", petrifiedoakslabdouble);
		newBlockStates.put("1001x", andesite);
		newBlockStates.put("1002x", diorite);
		newBlockStates.put("1003x", granite);
		newBlockStates.put("1004x", polished_andesite);
		newBlockStates.put("1005x", polished_diorite);
		newBlockStates.put("1006x", polished_granite);
		newBlockStates.put("1201x", red_sand);
		newBlockStates.put("1260xth", spruceslabtop);
		newBlockStates.put("1260xbh", spruceslabbottom);
		newBlockStates.put("1261xth", birchslabtop);
		newBlockStates.put("1261xbh", birchslabbottom);
		newBlockStates.put("1262xbh", jungleslabbottom);
		newBlockStates.put("1262xth", jungleslabtop);
		newBlockStates.put("1263xbh", acaciaslabbottom);
		newBlockStates.put("1263xth", acaciaslabtop);
		newBlockStates.put("1264xbh", darkoakslabbottom);
		newBlockStates.put("1264xth", darkoakslabtop);
		newBlockStates.put("1390x", mossy_cobblestone_wall);
		newBlockStates.put("1551x", chiseled_quartz_block);
		newBlockStates.put("1680x", dark_prismarine);
		newBlockStates.put("1681x", prismarine_bricks);
		newBlockStates.put("1701xxa", birchlogx);
		newBlockStates.put("1701xya", birchlogy);
		newBlockStates.put("1701xza", birchlogz);
		newBlockStates.put("1702xxa", junglelogx);
		newBlockStates.put("1702xya", junglelogy);
		newBlockStates.put("1702xza", junglelogz);
		newBlockStates.put("1703xza", sprucelogz);
		newBlockStates.put("1703xya", sprucelogy);
		newBlockStates.put("1703xza", sprucelogx);
		newBlockStates.put("1791x", chiseled_red_sandstone);
		newBlockStates.put("1792x", cut_red_sandstone);
		newBlockStates.put("1793x", smooth_red_sandstone);
		newBlockStates.put("1801x", birch_leaves);
		newBlockStates.put("1802x", jungle_leaves);
		newBlockStates.put("1803x", spruce_leaves);
		newBlockStates.put("1901x", wet_sponge);
		newBlockStates.put("2401x", chiseled_sandstone);
		newBlockStates.put("2402x", cut_sandstone);
		newBlockStates.put("3001x", podzol);
		newBlockStates.put("3501x", blue_wool);
		newBlockStates.put("3502x", brown_wool);
		newBlockStates.put("3503x", cyan_wool);
		newBlockStates.put("3504x", gray_wool);
		newBlockStates.put("3505x", green_wool);
		newBlockStates.put("3506x", light_blue_wool);
		newBlockStates.put("3507x", light_gray_wool);
		newBlockStates.put("3508x", lime_wool);
		newBlockStates.put("3509x", magenta_wool);
		newBlockStates.put("3510x", orange_wool);
		newBlockStates.put("3511x", pink_wool);
		newBlockStates.put("3512x", purple_wool);
		newBlockStates.put("3513x", red_wool);
		newBlockStates.put("3514x", white_wool);
		newBlockStates.put("3515x", yellow_wool);
		newBlockStates.put("4401xbh", brickslabbottom);
		newBlockStates.put("4401xth", brickslabtop);
		newBlockStates.put("4402xbh", netherbrickslabbottom);
		newBlockStates.put("4402xth", netherbrickslabtop);
		newBlockStates.put("4403xbh", quartzslabbottom);
		newBlockStates.put("4403xth", quartzslabtop);
		newBlockStates.put("4404xbh", sandstoneslabbottom);
		newBlockStates.put("4404xth", sandstoneslabtop);
		newBlockStates.put("4405xbh", stonebrickslabbottom);
		newBlockStates.put("4405xth", stonebrickslabtop);
		newBlockStates.put("4406xbh", stoneslabbottom);
		newBlockStates.put("4406xth", stoneslabtop);
		newBlockStates.put("5001x", birch_planks);
		newBlockStates.put("5002x", dark_oak_planks);
		newBlockStates.put("5003x", jungle_planks);
		newBlockStates.put("5004x", spruce_planks);
		newBlockStates.put("5005x", acacia_planks);
		newBlockStates.put("9501x", blue_stained_glass);
		newBlockStates.put("9502x", brown_stained_glass);
		newBlockStates.put("9503x", cyan_stained_glass);
		newBlockStates.put("9504x", gray_stained_glass);
		newBlockStates.put("9505x", green_stained_glass);
		newBlockStates.put("9506x", light_blue_stained_glass);
		newBlockStates.put("9507x", light_gray_stained_glass);
		newBlockStates.put("9508x", lime_stained_glass);
		newBlockStates.put("9509x", magenta_stained_glass);
		newBlockStates.put("9510x", orange_stained_glass);
		newBlockStates.put("9511x", pink_stained_glass);
		newBlockStates.put("9512x", purple_stained_glass);
		newBlockStates.put("9513x", red_stained_glass);
		newBlockStates.put("9514x", white_stained_glass);
		newBlockStates.put("9515x", yellow_stained_glass);
		newBlockStates.put("9801x", chiseled_stone_bricks);
		newBlockStates.put("9802x", cracked_stone_bricks);
		newBlockStates.put("9803x", mossy_stone_bricks);
		newBlockStates.put("15901x", white_terracotta);
		newBlockStates.put("15902x", purple_terracotta);
		newBlockStates.put("15903x", blue_terracotta);
		newBlockStates.put("15904x", brown_terracotta);
		newBlockStates.put("15905x", green_terracotta);
		newBlockStates.put("15906x", red_terracotta);
		newBlockStates.put("15907x", black_terracotta);
		newBlockStates.put("15908x", orange_terracotta);
		newBlockStates.put("15909x", magenta_terracotta);
		newBlockStates.put("15910x", light_blue_terracotta);
		newBlockStates.put("15911x", yellow_terracotta);
		newBlockStates.put("15912x", lime_terracotta);
		newBlockStates.put("15913x", pink_terracotta);
		newBlockStates.put("15914x", gray_terracotta);
		newBlockStates.put("15915x", light_gray_terracotta);
		newBlockStates.put("15916x", cyan_terracotta);
		newBlockStates.put("16001x", white_stained_glass);
		newBlockStates.put("16002x", purple_stained_glass);
		newBlockStates.put("16003x", blue_stained_glass);
		newBlockStates.put("16004x", brown_stained_glass);
		newBlockStates.put("16005x", green_stained_glass);
		newBlockStates.put("16006x", red_stained_glass);
		newBlockStates.put("16007x", black_stained_glass);
		newBlockStates.put("16008x", orange_stained_glass);
		newBlockStates.put("16009x", magenta_stained_glass);
		newBlockStates.put("16010x", light_blue_stained_glass);
		newBlockStates.put("16011x", yellow_stained_glass);
		newBlockStates.put("16012x", lime_stained_glass);
		newBlockStates.put("16013x", pink_stained_glass);
		newBlockStates.put("16014x", gray_stained_glass);
		newBlockStates.put("16015x", light_gray_stained_glass);
		newBlockStates.put("16016x", cyan_stained_glass);
		newBlockStates.put("16101x", dark_oak_leaves);
		newBlockStates.put("17101x", white_carpet);
		newBlockStates.put("17102x", purple_carpet);
		newBlockStates.put("17103x", blue_carpet);
		newBlockStates.put("17104x", brown_carpet);
		newBlockStates.put("17105x", green_carpet);
		newBlockStates.put("17106x", red_carpet);
		newBlockStates.put("17107x", black_carpet);
		newBlockStates.put("17108x", orange_carpet);
		newBlockStates.put("17109x", magenta_carpet);
		newBlockStates.put("17110x", light_blue_carpet);
		newBlockStates.put("17111x", yellow_carpet);
		newBlockStates.put("17112x", lime_carpet);
		newBlockStates.put("17113x", pink_carpet);
		newBlockStates.put("17114x", gray_carpet);
		newBlockStates.put("17115x", light_gray_carpet);
		newBlockStates.put("17116x", cyan_carpet);
		newBlockStates.put("25101x", white_concrete);
		newBlockStates.put("25102x", purple_concrete);
		newBlockStates.put("25103x", blue_concrete);
		newBlockStates.put("25104x", brown_concrete);
		newBlockStates.put("25105x", green_concrete);
		newBlockStates.put("25106x", red_concrete);
		newBlockStates.put("25107x", black_concrete);
		newBlockStates.put("25108x", orange_concrete);
		newBlockStates.put("25109x", magenta_concrete);
		newBlockStates.put("25110x", light_blue_concrete);
		newBlockStates.put("25111x", yellow_concrete);
		newBlockStates.put("25112x", lime_concrete);
		newBlockStates.put("25113x", pink_concrete);
		newBlockStates.put("25114x", gray_concrete);
		newBlockStates.put("25115x", light_gray_concrete);
		newBlockStates.put("25116x", cyan_concrete);
		newBlockStates.put("25401x", white_concrete_powder);
		newBlockStates.put("25402x", orange_concrete_powder);
		newBlockStates.put("25403x", magenta_concrete_powder);
		newBlockStates.put("25404x", light_blue_concrete_powder);
		newBlockStates.put("25405x", purple_concrete_powder);
		newBlockStates.put("25406x", blue_concrete_powder);
		newBlockStates.put("25407x", brown_concrete_powder);
		newBlockStates.put("25408x", green_concrete_powder);
		newBlockStates.put("25409x", red_concrete_powder);
		newBlockStates.put("25410x", black_concrete_powder);
		newBlockStates.put("25411x", yellow_concrete_powder);
		newBlockStates.put("25412x", lime_concrete_powder);
		newBlockStates.put("25413x", pink_concrete_powder);
		newBlockStates.put("25414x", gray_concrete_powder);
		newBlockStates.put("25415x", light_gray_concrete_powder);
		newBlockStates.put("25416x", cyan_concrete_powder);

		blockProperties.put("0x", "0x");
		blockProperties.put("1x", "1xy");
		blockProperties.put("2x", "2x");
		blockProperties.put("3x", "3xy");
		blockProperties.put("4x", "4x");
		blockProperties.put("5x", "5xy");
		blockProperties.put("7x", "7x");
		blockProperties.put("8x", "8x");
		blockProperties.put("9x", "9x");
		blockProperties.put("10x", "10x");
		blockProperties.put("11x", "11x");
		blockProperties.put("12x", "12xy");
		blockProperties.put("13x", "13x");
		blockProperties.put("17x", "17xya");
		blockProperties.put("18x", "18xy");
		blockProperties.put("19x", "19xy");
		blockProperties.put("20x", "20x");
		blockProperties.put("22x", "22x");
		blockProperties.put("23x", "23x");
		blockProperties.put("24x", "24xy");
		blockProperties.put("30x", "30x");
		blockProperties.put("35x", "35xy");
		blockProperties.put("41x", "41x");
		blockProperties.put("42x", "42x");
		blockProperties.put("43x", "43xy");
		blockProperties.put("44x", "44xyh");
		blockProperties.put("45x", "45x");
		blockProperties.put("46x", "46x");
		blockProperties.put("47x", "47x");
		blockProperties.put("48x", "48x");
		blockProperties.put("49x", "49x");
		blockProperties.put("50x", "50x");
		blockProperties.put("51x", "51x");
		blockProperties.put("53x", "53xfh");
		blockProperties.put("54x", "54xf");
		blockProperties.put("55x", "55x");
		blockProperties.put("57x", "57x");
		blockProperties.put("58x", "58x");
		blockProperties.put("59x", "59x");
		blockProperties.put("60x", "60xf");
		blockProperties.put("61x", "61x");
		blockProperties.put("64x", "64xf");
		blockProperties.put("65x", "65xf");
		blockProperties.put("66x", "66xf");
		blockProperties.put("67x", "67xfh");
		blockProperties.put("68x", "68xf");
		blockProperties.put("69x", "69x");
		blockProperties.put("70x", "70x");
		blockProperties.put("76x", "76x");
		blockProperties.put("77x", "77xf");
		blockProperties.put("81x", "81x");
		blockProperties.put("82x", "82x");
		blockProperties.put("83x", "83x");
		blockProperties.put("84x", "84x");
		blockProperties.put("85x", "85x");
		blockProperties.put("86x", "86x");
		blockProperties.put("87x", "87x");
		blockProperties.put("88x", "88x");
		blockProperties.put("89x", "89x");
		blockProperties.put("91x", "91x");
		blockProperties.put("95x", "95xy");
		blockProperties.put("96xefbh", "96fh");
		blockProperties.put("98x", "98xy");
		blockProperties.put("101x", "101x");
		blockProperties.put("102x", "102xf");
		blockProperties.put("103x", "103x");
		blockProperties.put("108x", "108xfh");
		blockProperties.put("109x", "109xfh");
		blockProperties.put("112x", "112x");
		blockProperties.put("114x", "114xfh");
		blockProperties.put("116x", "116x");
		blockProperties.put("117x", "117x");
		blockProperties.put("118x", "118x");
		blockProperties.put("121x", "121x");
		blockProperties.put("123x", "123x");
		blockProperties.put("124x", "124x");
		blockProperties.put("125x", "125xy");
		blockProperties.put("126x", "126xyh");
		blockProperties.put("128x", "128xfh");
		blockProperties.put("133x", "133x");
		blockProperties.put("134x", "134xfh");
		blockProperties.put("135x", "135xfh");
		blockProperties.put("136x", "136xfh");
		blockProperties.put("138x", "138x");
		blockProperties.put("139x", "139xy");
		blockProperties.put("140x", "140x");
		blockProperties.put("141x", "141x");
		blockProperties.put("142x", "142x");
		blockProperties.put("143xef", "143xf");
		blockProperties.put("145x", "145x");
		blockProperties.put("146x", "146x");
		blockProperties.put("147x", "147x");
		blockProperties.put("148x", "148x");
		blockProperties.put("152x", "152x");
		blockProperties.put("154x", "154x");
		blockProperties.put("155x", "155xy");
		blockProperties.put("158x", "158x");
		blockProperties.put("159x", "159xy");
		blockProperties.put("160x", "160xy");
		blockProperties.put("161x", "161xy");
		blockProperties.put("162x", "162xya");
		blockProperties.put("164x", "164xfh");
		blockProperties.put("165x", "165x");
		blockProperties.put("166x", "166x");
		blockProperties.put("167x", "167xfh");
		blockProperties.put("168x", "168xy");
		blockProperties.put("169x", "169x");
		blockProperties.put("170x", "170x");
		blockProperties.put("171x", "171xy");
		blockProperties.put("173x", "173x");
		blockProperties.put("179x", "179xy");
		blockProperties.put("181x", "181x");
		blockProperties.put("182x", "182xh");
		blockProperties.put("188x", "188x");
		blockProperties.put("189x", "189x");
		blockProperties.put("190x", "190x");
		blockProperties.put("191x", "191x");
		blockProperties.put("192x", "192x");
		blockProperties.put("201x", "201xa");
		blockProperties.put("202x", "202xa");
		blockProperties.put("203x", "203xfh");
		blockProperties.put("204x", "204x");
		blockProperties.put("205x", "205xh");
		blockProperties.put("206x", "206x");
		blockProperties.put("207x", "207x");
		blockProperties.put("208x", "208x");
		blockProperties.put("251x", "251xy");
		blockProperties.put("252x", "252xy");
		blockProperties.put("254x10y", "254xy");
		blockProperties.put("323x", "323x");
		blockProperties.put("900x", "900x");
		blockProperties.put("901x", "901x");
		blockProperties.put("902x", "902x");
		blockProperties.put("904x", "904xh");
		blockProperties.put("905x", "905x");

		blockStates.put("0x", air);
		blockStates.put("1x", stone);
		blockStates.put("1x1y", granite);
		blockStates.put("1x2y", polished_granite);
		blockStates.put("1x3y", diorite);
		blockStates.put("1x4y", polished_diorite);
		blockStates.put("1x5y", andesite);
		blockStates.put("1x6y", polished_andesite);
		blockStates.put("2x", grass_block);
		blockStates.put("3x", dirt);
		blockStates.put("3x1y", coarse_dirt);
		blockStates.put("3x2y", podzol);
		blockStates.put("4x", cobblestone);
		blockStates.put("5x0y", oak_planks);
		blockStates.put("5x1y", spruce_planks);
		blockStates.put("5x2y", birch_planks);
		blockStates.put("5x3y", jungle_planks);
		blockStates.put("5x4y", acacia_planks);
		blockStates.put("5x5y", dark_oak_planks);
		blockStates.put("7x", bedrock);
		blockStates.put("8x", water);
		blockStates.put("9x", water);
		blockStates.put("10x", lava);
		blockStates.put("11x", lava);
		blockStates.put("12x0y", sand);
		blockStates.put("12x1y", red_sand);
		blockStates.put("13x", gravel);
		blockStates.put("17x0yya", oaklogy);
		blockStates.put("17x4yza", oaklogz);
		blockStates.put("17x4yxa", oaklogx);
		blockStates.put("17x8yxa", oaklogx);
		blockStates.put("17x8yza", oaklogz);
		blockStates.put("17x1yza", sprucelogz);
		blockStates.put("17x5yya", sprucelogy);
		blockStates.put("17x9yxa", sprucelogx);
		blockStates.put("17x2yxa", birchlogx);
		blockStates.put("17x6yya", birchlogy);
		blockStates.put("17x10yza", birchlogz);
		blockStates.put("17x3yxa", junglelogx);
		blockStates.put("17x7yya", junglelogy);
		blockStates.put("17x11yza", junglelogz);
		blockStates.put("18x", oak_leaves);
		blockStates.put("18x1y", spruce_leaves);
		blockStates.put("18x2y", birch_leaves);
		blockStates.put("18x3y", jungle_leaves);
		blockStates.put("19x", sponge);
		blockStates.put("19x1y", wet_sponge);
		blockStates.put("20x", glass);
		blockStates.put("22x", lapis_block);
		blockStates.put("23x", dispenser);
		blockStates.put("24x", sandstone);
		blockStates.put("24x1y", chiseled_sandstone);
		blockStates.put("24x2y", cut_sandstone);
		blockStates.put("30x", cobweb);
		blockStates.put("35x", white_wool);
		blockStates.put("35x10y", purple_wool);
		blockStates.put("35x11y", blue_wool);
		blockStates.put("35x12", brown_wool);
		blockStates.put("35x13", green_wool);
		blockStates.put("35x14y", red_wool);
		blockStates.put("35x15y", black_wool);
		blockStates.put("35x1y", orange_wool);
		blockStates.put("35x2y", magenta_wool);
		blockStates.put("35x3y", light_blue_wool);
		blockStates.put("35x4y", yellow_wool);
		blockStates.put("35x5y", lime_wool);
		blockStates.put("35x6y", pink_wool);
		blockStates.put("35x7y", gray_wool);
		blockStates.put("35x8y", light_gray_wool);
		blockStates.put("35x9y", cyan_wool);
		blockStates.put("41x", gold_block);
		blockStates.put("42x", iron_block);
		blockStates.put("43x", stoneslabdouble);
		blockStates.put("43x1y", sandstoneslabdouble);
		blockStates.put("43x3y", cobblestoneslabdouble);
		blockStates.put("43x4y", brickslabdouble);
		blockStates.put("43x5y", stonebrickslabdouble);
		blockStates.put("43x6y", netherbrickslabdouble);
		blockStates.put("43x7y", quartzslabdouble);
		blockStates.put("44x1ybh", sandstoneslabbottom);
		blockStates.put("44x9yth", sandstoneslabtop);
		blockStates.put("44x3ybh", cobblestoneslabbottom);
		blockStates.put("44x11yth", cobblestoneslabtop);
		blockStates.put("44x4ybh", brickslabbottom);
		blockStates.put("44x12yth", brickslabtop);
		blockStates.put("44x5ybh", stonebrickslabbottom);
		blockStates.put("44x13yth", stonebrickslabtop);
		blockStates.put("44x6ybh", netherbrickslabbottom);
		blockStates.put("44x14yth", netherbrickslabtop);
		blockStates.put("44x7ybh", quartzslabbottom);
		blockStates.put("44x15yth", quartzslabtop);
		blockStates.put("44x0ybh", stoneslabbottom);
		blockStates.put("44x8yth", stoneslabtop);
		blockStates.put("45x", bricks);
		blockStates.put("46x", tnt);
		blockStates.put("47x", bookshelf);
		blockStates.put("48x", mossy_cobblestone);
		blockStates.put("49x", obsidian);
		blockStates.put("50x", walltorch);
		blockStates.put("50xef", walltorcheast);
		blockStates.put("50xnf", walltorchnorth);
		blockStates.put("50xsf", walltorchsouth);
		blockStates.put("50xwf", walltorchwest);
		blockStates.put("51x", fire);
		blockStates.put("53x", oakStairs);
		blockStates.put("53xefbh", oakStairseastbottom);
		blockStates.put("53xefth", oakStairseasttop);
		blockStates.put("53xnfbh", oakStairsnorthbottom);
		blockStates.put("53xnfth", oakStairsnorthtop);
		blockStates.put("53xsfbh", oakStairssouthbottom);
		blockStates.put("53xsfth", oakStairssouthtop);
		blockStates.put("53xwfbh", oakStairswestbottom);
		blockStates.put("53xwfth", oakStairswesttop);
		blockStates.put("55x", redstone_wire);
		blockStates.put("57x", diamond_block);
		blockStates.put("58x", crafting_table);
		blockStates.put("59x", wheat);
		blockStates.put("60x", farmland);
		blockStates.put("61x", furnace);
		blockStates.put("64x", oakDoor);
		blockStates.put("64xef", oakDooreastlower);
		blockStates.put("64xnf", oakDoornorthlower);
		blockStates.put("64xsf", oakDoorsouthlower);
		blockStates.put("64xwf", oakDoorwestlower);
		blockStates.put("65x", ladder);
		blockStates.put("65xef", laddereast);
		blockStates.put("65xnf", laddernorth);
		blockStates.put("65xsf", laddersouth);
		blockStates.put("65xwf", ladderwest);
		blockStates.put("66x", rail);
		blockStates.put("67x", cobblestoneStairs);
		blockStates.put("67xefbh", cobblestoneStairseastbottom);
		blockStates.put("67xefth", cobblestoneStairseasttop);
		blockStates.put("67xnfbh", cobblestoneStairsnorthbottom);
		blockStates.put("67xnfth", cobblestoneStairsnorthtop);
		blockStates.put("67xsfbh", cobblestoneStairssouthbottom);
		blockStates.put("67xsfth", cobblestoneStairssouthtop);
		blockStates.put("67xwfbh", cobblestoneStairswestbottom);
		blockStates.put("67xwfth", cobblestoneStairswesttop);
		blockStates.put("68x", wallsign);
		blockStates.put("68xef", wallsigneast);
		blockStates.put("68xnf", wallsignnorth);
		blockStates.put("68xsf", wallsignsouth);
		blockStates.put("68xwf", wallsignwest);
		blockStates.put("69x", lever);
		blockStates.put("70x", stone_pressure_plate);
		blockStates.put("76x", redstone_torch);
		blockStates.put("77x", stonebutton);
		blockStates.put("77xef", stonebuttoneast);
		blockStates.put("77xnf", stonebuttonnorth);
		blockStates.put("77xsf", stonebuttonsouth);
		blockStates.put("77xwf", stonebuttonwest);
		blockStates.put("81x", cactus);
		blockStates.put("82x", clay);
		blockStates.put("83x", sugar_cane);
		blockStates.put("84x", jukebox);
		blockStates.put("85x", oak_fence);
		blockStates.put("86x", pumpkin);
		blockStates.put("87x", netherrack);
		blockStates.put("88x", soul_sand);
		blockStates.put("89x", glowstone);
		blockStates.put("91x", jackolantern);
		blockStates.put("95x", white_stained_glass);
		blockStates.put("95x10y", purple_stained_glass);
		blockStates.put("95x11y", blue_stained_glass);
		blockStates.put("95x12y", brown_stained_glass);
		blockStates.put("95x13y", green_stained_glass);
		blockStates.put("95x14y", red_stained_glass);
		blockStates.put("95x15y", black_stained_glass);
		blockStates.put("95x1y", orange_stained_glass);
		blockStates.put("95x2y", magenta_stained_glass);
		blockStates.put("95x3y", light_blue_stained_glass);
		blockStates.put("95x4y", yellow_stained_glass);
		blockStates.put("95x5y", lime_stained_glass);
		blockStates.put("95x6y", pink_stained_glass);
		blockStates.put("95x7y", gray_stained_glass);
		blockStates.put("95x8y", light_gray_stained_glass);
		blockStates.put("95x9y", cyan_stained_glass);
		blockStates.put("96x", oaktrapdoor);
		blockStates.put("96xefbh", oaktrapdooreastbottom);
		blockStates.put("96xefth", oaktrapdooreasttop);
		blockStates.put("96xnfbh", oaktrapdoornorthbottom);
		blockStates.put("96xnfth", oaktrapdoornorthtop);
		blockStates.put("96xsfbh", oaktrapdoorsouthbottom);
		blockStates.put("96xsfth", oaktrapdoorsouthtop);
		blockStates.put("96xwfbh", oaktrapdoorwestbottom);
		blockStates.put("96xwfth", oaktrapdoorwesttop);
		blockStates.put("98x0y", stone_bricks);
		blockStates.put("98x1y", mossy_stone_bricks);
		blockStates.put("98x2y", cracked_stone_bricks);
		blockStates.put("98x3y", chiseled_stone_bricks);
		blockStates.put("101x", iron_bars);
		blockStates.put("102x", glass);
		blockStates.put("102xef", glass_paneeast);
		blockStates.put("102xnf", glass_panenorth);
		blockStates.put("102xsf", glass_panesouth);
		blockStates.put("102xwf", glass_panewest);
		blockStates.put("103x", melon_block);
		blockStates.put("108x", brickStairs);
		blockStates.put("108xefbh", brickStairseastbottom);
		blockStates.put("108xefth", brickStairseasttop);
		blockStates.put("108xnfbh", brickStairsnorthbottom);
		blockStates.put("108xnfth", brickStairsnorthtop);
		blockStates.put("108xsfbh", brickStairssouthbottom);
		blockStates.put("108xsfth", brickStairssouthtop);
		blockStates.put("108xwfbh", brickStairswestbottom);
		blockStates.put("108xwfth", brickStairswesttop);
		blockStates.put("109x", stonebrickStairs);
		blockStates.put("109xefbh", stonebrickStairseastbottom);
		blockStates.put("109xefth", stonebrickStairseasttop);
		blockStates.put("109xnfbh", stonebrickStairsnorthbottom);
		blockStates.put("109xnfth", stonebrickStairsnorthtop);
		blockStates.put("109xsfbh", stonebrickStairssouthbottom);
		blockStates.put("109xsfth", stonebrickStairssouthtop);
		blockStates.put("109xwfbh", stonebrickStairswestbottom);
		blockStates.put("109xwfth", stonebrickStairswesttop);
		blockStates.put("112x", nether_bricks);
		blockStates.put("114x", netherbrickStairs);
		blockStates.put("114xefbh", netherbrickStairseastbottom);
		blockStates.put("114xefth", netherbrickStairseasttop);
		blockStates.put("114xnfbh", netherbrickStairsnorthbottom);
		blockStates.put("114xnfth", netherbrickStairsnorthtop);
		blockStates.put("114xsfbh", netherbrickStairssouthbottom);
		blockStates.put("114xsfth", netherbrickStairssouthtop);
		blockStates.put("114xwfbh", netherbrickStairswestbottom);
		blockStates.put("114xwfth", netherbrickStairswesttop);
		blockStates.put("116x", enchanting_table);
		blockStates.put("117x", brewing_stand);
		blockStates.put("118x", cauldron);
		blockStates.put("121x", end_stone);
		blockStates.put("123x", redstone_lamp);
		blockStates.put("124x", redstone_lamp);
		blockStates.put("125x0y", oakslabdouble);
		blockStates.put("125x1y", spruceslabdouble);
		blockStates.put("125x3y", jungleslabdouble);
		blockStates.put("125x4y", acaciaslabdouble);
		blockStates.put("125x5y", darkoakslabdouble);
		blockStates.put("126x9yth", spruceslabtop);
		blockStates.put("126x1ybh", spruceslabbottom);
		blockStates.put("126x10yth", birchslabtop);
		blockStates.put("126x2ybh", birchslabbottom);
		blockStates.put("126x3ybh", jungleslabbottom);
		blockStates.put("126x11yth", jungleslabtop);
		blockStates.put("126x4ybh", acaciaslabbottom);
		blockStates.put("126x12yth", acaciaslabtop);
		blockStates.put("126x5ybh", darkoakslabbottom);
		blockStates.put("126x13yth", darkoakslabtop);
		blockStates.put("126x0ybh", oakslabbottom);
		blockStates.put("126x8yth", oakslabtop);
		blockStates.put("128x", sandstoneStairs);
		blockStates.put("128xefbh", sandstoneStairseastbottom);
		blockStates.put("128xefth", sandstoneStairseasttop);
		blockStates.put("128xnfbh", sandstoneStairsnorthbottom);
		blockStates.put("128xnfth", sandstoneStairsnorthtop);
		blockStates.put("128xsfbh", sandstoneStairssouthbottom);
		blockStates.put("128xsfth", sandstoneStairssouthtop);
		blockStates.put("128xwfbh", sandstoneStairswestbottom);
		blockStates.put("128xwfth", sandstoneStairswesttop);
		blockStates.put("133x", emerald_block);
		blockStates.put("134x", spruceStairs);
		blockStates.put("134xefbh", spruceStairseastbottom);
		blockStates.put("134xefth", spruceStairseasttop);
		blockStates.put("134xnfbh", spruceStairsnorthbottom);
		blockStates.put("134xnfth", spruceStairsnorthtop);
		blockStates.put("134xsfbh", spruceStairssouthbottom);
		blockStates.put("134xsfth", spruceStairssouthtop);
		blockStates.put("134xwfbh", spruceStairswestbottom);
		blockStates.put("134xwfth", spruceStairswesttop);
		blockStates.put("135x", birchStairs);
		blockStates.put("135xefbh", birchStairseastbottom);
		blockStates.put("135xefth", birchStairseasttop);
		blockStates.put("135xnfbh", birchStairsnorthbottom);
		blockStates.put("135xnfth", birchStairsnorthtop);
		blockStates.put("135xsfbh", birchStairssouthbottom);
		blockStates.put("135xsfth", birchStairssouthtop);
		blockStates.put("135xwfbh", birchStairswestbottom);
		blockStates.put("135xwfth", birchStairswesttop);
		blockStates.put("136x", jungleStairs);
		blockStates.put("136xefbh", jungleStairseastbottom);
		blockStates.put("136xefth", jungleStairseasttop);
		blockStates.put("136xnfbh", jungleStairsnorthbottom);
		blockStates.put("136xnfth", jungleStairsnorthtop);
		blockStates.put("136xsfbh", jungleStairssouthbottom);
		blockStates.put("136xsfth", jungleStairssouthtop);
		blockStates.put("136xwfbh", jungleStairswestbottom);
		blockStates.put("136xwfth", jungleStairswesttop);
		blockStates.put("138x", beacon);
		blockStates.put("139x", cobblestone_wall);
		blockStates.put("139x1y", mossy_cobblestone_wall);
		blockStates.put("140x", potted_cactus);
		blockStates.put("141x", carrots);
		blockStates.put("142x", potatoes);
		blockStates.put("143x", oakbutton);
		blockStates.put("143xef", oakbuttoneast);
		blockStates.put("143xnf", oakbuttonnorth);
		blockStates.put("143xsf", oakbuttonsouth);
		blockStates.put("143xwf", oakbuttonwest);
		blockStates.put("145x", anvil);
		blockStates.put("146x", chest);
		blockStates.put("147x", light_weighted_pressure_plate);
		blockStates.put("148x", heavy_weighted_pressure_plate);
		blockStates.put("152x", redstone_block);
		blockStates.put("154x", hopper);
		blockStates.put("155x", quartz_block);
		blockStates.put("155x1y", chiseled_quartz_block);
		blockStates.put("158x", dropper);
		blockStates.put("159x", white_terracotta);
		blockStates.put("159x10y", purple_terracotta);
		blockStates.put("159x11y", blue_terracotta);
		blockStates.put("159x12y", brown_terracotta);
		blockStates.put("159x13y", green_terracotta);
		blockStates.put("159x14y", red_terracotta);
		blockStates.put("159x15y", black_terracotta);
		blockStates.put("159x1y", orange_terracotta);
		blockStates.put("159x2y", magenta_terracotta);
		blockStates.put("159x3y", light_blue_terracotta);
		blockStates.put("159x4y", yellow_terracotta);
		blockStates.put("159x5y", lime_terracotta);
		blockStates.put("159x6y", pink_terracotta);
		blockStates.put("159x7y", gray_terracotta);
		blockStates.put("159x8y", light_gray_terracotta);
		blockStates.put("159x9y", cyan_terracotta);
		blockStates.put("160x", white_stained_glass);
		blockStates.put("160x10y", purple_stained_glass);
		blockStates.put("160x11y", blue_stained_glass);
		blockStates.put("160x12y", brown_stained_glass);
		blockStates.put("160x13y", green_stained_glass);
		blockStates.put("160x14y", red_stained_glass);
		blockStates.put("160x15y", black_stained_glass);
		blockStates.put("160x1y", orange_stained_glass);
		blockStates.put("160x2y", magenta_stained_glass);
		blockStates.put("160x3y", light_blue_stained_glass);
		blockStates.put("160x4y", yellow_stained_glass);
		blockStates.put("160x5y", lime_stained_glass);
		blockStates.put("160x6y", pink_stained_glass);
		blockStates.put("160x7y", gray_stained_glass);
		blockStates.put("160x8y", light_gray_stained_glass);
		blockStates.put("160x9y", cyan_stained_glass);
		blockStates.put("161x", acacia_leaves);
		blockStates.put("161x1y", dark_oak_leaves);
		blockStates.put("162x1yxa", darkoaklogx);
		blockStates.put("162x1yya", darkoaklogy);
		blockStates.put("162x1yza", darkoaklogz);
		blockStates.put("162xxa", acacialogx);
		blockStates.put("162xya", acacialogy);
		blockStates.put("162xza", acacialogz);
		blockStates.put("164x", darkoakStairs);
		blockStates.put("164xefbh", darkoakStairseastbottom);
		blockStates.put("164xefth", darkoakStairseasttop);
		blockStates.put("164xnfbh", darkoakStairsnorthbottom);
		blockStates.put("164xnfth", darkoakStairsnorthtop);
		blockStates.put("164xsfbh", darkoakStairssouthbottom);
		blockStates.put("164xsfth", darkoakStairssouthtop);
		blockStates.put("164xwfbh", darkoakStairswestbottom);
		blockStates.put("164xwfth", darkoakStairswesttop);
		blockStates.put("165x", slime_block);
		blockStates.put("166x", barrier);
		blockStates.put("167x", irontrapdoor);
		blockStates.put("167xefbh", irontrapdooreastbottom);
		blockStates.put("167xefth", irontrapdooreasttop);
		blockStates.put("167xnfbh", irontrapdoornorthbottom);
		blockStates.put("167xnfbh", irontrapdoornorthtop);
		blockStates.put("167xsfbh", irontrapdoorsouthbottom);
		blockStates.put("167xsfth", irontrapdoorsouthtop);
		blockStates.put("167xwfbh", irontrapdoorwestbottom);
		blockStates.put("167xwfth", irontrapdoorwesttop);
		blockStates.put("168x", prismarine);
		blockStates.put("168x1y", prismarine_bricks);
		blockStates.put("168x2y", dark_prismarine);
		blockStates.put("169x", sea_lantern);
		blockStates.put("170x", hay_bale);
		blockStates.put("171x", white_carpet);
		blockStates.put("171x10y", purple_carpet);
		blockStates.put("171x11y", blue_carpet);
		blockStates.put("171x12y", brown_carpet);
		blockStates.put("171x13y", green_carpet);
		blockStates.put("171x14y", red_carpet);
		blockStates.put("171x15y", black_carpet);
		blockStates.put("171x1y", orange_carpet);
		blockStates.put("171x2y", magenta_carpet);
		blockStates.put("171x3y", light_blue_carpet);
		blockStates.put("171x4y", yellow_carpet);
		blockStates.put("171x5y", lime_carpet);
		blockStates.put("171x6y", pink_carpet);
		blockStates.put("171x7y", gray_carpet);
		blockStates.put("171x8y", light_gray_carpet);
		blockStates.put("171x9y", cyan_carpet);
		blockStates.put("173x", coal_block);
		blockStates.put("179x", red_sandstone);
		blockStates.put("179x1y", chiseled_red_sandstone);
		blockStates.put("179x2y", smooth_red_sandstone);
		blockStates.put("179x3y", cut_red_sandstone);
		blockStates.put("181x", redsandstoneslabdouble);
		blockStates.put("182x", redsandstoneslab);
		blockStates.put("182xbh", redsandstoneslabbottom);
		blockStates.put("182xth", redsandstoneslabtop);
		blockStates.put("188x", spruce_fence);
		blockStates.put("189x", birch_fence);
		blockStates.put("190x", jungle_fence);
		blockStates.put("191x", dark_oak_fence);
		blockStates.put("192x", acacia_fence);
		blockStates.put("203x", purpurStairs);
		blockStates.put("203xefbh", purpurStairseastbottom);
		blockStates.put("203xefth", purpurStairseasttop);
		blockStates.put("203xnfbh", purpurStairsnorthbottom);
		blockStates.put("203xnfth", purpurStairsnorthtop);
		blockStates.put("203xsfbh", purpurStairssouthbottom);
		blockStates.put("203xsfth", purpurStairssouthtop);
		blockStates.put("203xwfbh", purpurStairswestbottom);
		blockStates.put("203xwfth", purpurStairswesttop);
		blockStates.put("204x", purpurslabdouble);
		blockStates.put("205x", purpurslab);
		blockStates.put("205xbh", purpurslabbottom);
		blockStates.put("205xth", purpurslabtop);
		blockStates.put("206x", end_stone_bricks);
		blockStates.put("207x", beetroots);
		blockStates.put("208x", grass_path);
		blockStates.put("251x", white_concrete);
		blockStates.put("251x10y", purple_concrete);
		blockStates.put("251x11y", blue_concrete);
		blockStates.put("251x12y", brown_concrete);
		blockStates.put("251x13y", green_concrete);
		blockStates.put("251x14y", red_concrete);
		blockStates.put("251x15y", black_concrete);
		blockStates.put("251x1y", orange_concrete);
		blockStates.put("251x2y", magenta_concrete);
		blockStates.put("251x3y", light_blue_concrete);
		blockStates.put("251x4y", yellow_concrete);
		blockStates.put("251x5y", lime_concrete);
		blockStates.put("251x6y", pink_concrete);
		blockStates.put("251x7y", gray_concrete);
		blockStates.put("251x8y", light_gray_concrete);
		blockStates.put("251x9y", cyan_concrete);
		blockStates.put("252x", white_concrete_powder);
		blockStates.put("252x1y", orange_concrete_powder);
		blockStates.put("252x2y", magenta_concrete_powder);
		blockStates.put("252x3y", light_blue_concrete_powder);
		blockStates.put("254x10y", purple_concrete_powder);
		blockStates.put("254x11y", blue_concrete_powder);
		blockStates.put("254x12y", brown_concrete_powder);
		blockStates.put("254x13y", green_concrete_powder);
		blockStates.put("254x14y", red_concrete_powder);
		blockStates.put("254x15y", black_concrete_powder);
		blockStates.put("254x4y", yellow_concrete_powder);
		blockStates.put("254x5y", lime_concrete_powder);
		blockStates.put("254x6y", pink_concrete_powder);
		blockStates.put("254x7y", gray_concrete_powder);
		blockStates.put("254x8y", light_gray_concrete_powder);
		blockStates.put("254x9y", cyan_concrete_powder);
		blockStates.put("323x", sign);
		blockStates.put("900x", smooth_stone);
		blockStates.put("901x", smooth_sandstone);
		blockStates.put("902x", smooth_quartz);
		blockStates.put("904x", petrifiedoakslab);
		blockStates.put("904xbh", petrifiedoakslabbottom);
		blockStates.put("904xth", petrifiedoakslabtop);
		blockStates.put("905x", petrifiedoakslabdouble);
		blockStates.put("54xef", chesteast);
		blockStates.put("54xwf", chestwest);
		blockStates.put("54xnf", chestnorth);
		blockStates.put("54xsf", chestsouth);
		blockStates.put("61xef", furnaceeast);
		blockStates.put("61xwf", furnacewest);
		blockStates.put("61xnf", furnacenorth);
		blockStates.put("61xsf", furnacesouth);

	}

	/*
	 * This section is for the original schematic values
	 */
	
	
	
	public static BlockState buildBlockStateKey(Short blockID, Integer metaValue, Integer rotation) {

		// basic block
		String valueProperties = null;

		String blockStateKey = Integer.toString(blockID) + "x";
		
		if (blockProperties.containsKey(blockStateKey)) {
			valueProperties = blockProperties.get(blockStateKey);
		}

		if (valueProperties != null) {
			if (valueProperties.contains("xfh")) {
				switch (metaValue) {
				case 0: {
					blockStateKey = blockStateKey + "wfbh";
					break;
				}

				case 1: {
					blockStateKey = blockStateKey + "efbh";
					break;
				}

				case 2: {
					blockStateKey = blockStateKey + "nfbh";
					break;
				}

				case 3: {
					blockStateKey = blockStateKey + "sfbh";
					break;
				}
				case 4: {
					blockStateKey = blockStateKey + "wfth";
					break;
				}

				case 5: {
					blockStateKey = blockStateKey + "efth";
					break;
				}

				case 6: {
					blockStateKey = blockStateKey + "nfth";
					break;
				}

				case 7: {
					blockStateKey = blockStateKey + "sfth";
					break;
				}
				}

			} else {
				if (valueProperties.contains("xf")) {
					switch (metaValue) {

					case 2: {
						blockStateKey = blockStateKey + "sf";
						break;
					}

					case 3: {
						blockStateKey = blockStateKey + "nf";
						break;
					}
					case 4: {
						blockStateKey = blockStateKey + "ef";
						break;
					}

					case 5: {
						blockStateKey = blockStateKey + "wf";
						break;
					}
					}
				} else {
					if (valueProperties.contains("xya")) {
						if (valueProperties.contains("17x")) {
							switch (metaValue) {
							case 0: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yya";
								break;
							}
							case 1: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yya";
								break;
							}

							case 2: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yya";
								break;
							}

							case 3: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yya";
								break;
							}
							case 4: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yza";
								break;
							}

							case 5: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yza";
								break;
							}

							case 6: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yza";
								break;
							}

							case 7: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yza";
								break;
							}
							case 8: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yxa";
								break;
							}
							case 9: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yxa";
								break;
							}
							case 10: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yxa";
								break;
							}
							case 11: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yxa";
								break;
							}
							}
						}

						else if (valueProperties.contains("162x")) {
							switch (metaValue) {
							case 1: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yya";
								break;
							}

							case 4: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yxa";
								break;
							}

							case 7: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "yza";
								break;
							}
							}
						}
					} else {
						if (valueProperties.contains("xa")) {
							switch (metaValue) {
							case 3: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "xa";
								break;
							}
							case 6: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "za";
								break;
							}
							default: {
								blockStateKey = blockStateKey + Integer.toString(metaValue) + "ya";
								break;
							}
							}
						} else {
							if (valueProperties.contains("xyh")) {

								blockStateKey = blockStateKey + Integer.toString(metaValue) + "y";

								if (metaValue > 7) {
									blockStateKey = blockStateKey + "th";
								} else {
									blockStateKey = blockStateKey + "bh";
								}
							} else {
								if (valueProperties.contains("xh")) {

								} else {
									if (valueProperties.contains("xy")) {
										blockStateKey = blockStateKey + Integer.toString(metaValue) + "y";

									}
								}
							}
						}
					}

				}
			}
		}

		String adjustedBlockStateKey = adjustForOldDirection(blockStateKey, rotation);

		if (blockStates.containsKey(blockStateKey)) {
			
			convertState = blockStates.get(adjustedBlockStateKey);
			newBlockKey = blockStateKey;
		}

		return convertState;

	}
	
	public static String adjustForOldDirection(String blockStateKey, Integer rotation) {

		String adjustedKey = blockStateKey;

		// if there is no rotation or the key does not contain FACING, no change
		if (blockStateKey.contains("f")) {

			int fPos = blockStateKey.indexOf("f") - 1;
			char initFacing = blockStateKey.charAt(fPos);
			char newFacing = 'w';

			// w, e, n, s
			switch (rotation) {

			case 0: {
				if (initFacing == 'w') {
					newFacing = 'e';
					break;
				} else {
					if (initFacing == 'e') {
						newFacing = 'w';
						break;
					} else {
						if (initFacing == 'n') {
							newFacing = 's';
							break;
						} else {
							newFacing = 'n';
							break;
						}
					}
				}
			}

			case 1: {
				if (initFacing == 'w') {
					newFacing = 'n';
					break;
				} else {
					if (initFacing == 'e') {
						newFacing = 's';
						break;
					} else {
						if (initFacing == 'n') {
							newFacing = 'e';
							break;
						} else {
							newFacing = 'w';
							break;
						}
					}
				}
			}
			case 2: {
				if (initFacing == 'w') {
					newFacing = 'w';
					break;
				} else {
					if (initFacing == 'e') {
						newFacing = 'e';
						break;
					} else {
						if (initFacing == 'n') {
							newFacing = 'n';
							break;
						} else {
							newFacing = 's';
							break;
						}
					}
				}
			}
			case 3: {
				if (initFacing == 'w') {
					newFacing = 's';
					break;
				} else {
					if (initFacing == 'e') {
						newFacing = 'n';
						break;
					} else {
						if (initFacing == 'n') {
							newFacing = 'w';
							break;
						} else {
							newFacing = 'e';
							break;
						}
					}
				}
			}
			}

			adjustedKey = blockStateKey.replace(initFacing, newFacing);

		} else {

			if (blockStateKey.contains("a")) {

				if (rotation == 0 || rotation == 2) {

					adjustedKey = blockStateKey;

					int fPos = blockStateKey.indexOf("a") - 1;
					char initAxis = blockStateKey.charAt(fPos);

					if (initAxis == 'x') {
						adjustedKey = blockStateKey.replaceFirst("xa", "za");
					} else {
						if (initAxis == 'z') {
							adjustedKey = blockStateKey.replaceFirst("za", "xa");
						}
					}

				}

			}

		}

		return adjustedKey;

	}

	/*
	 * This section is for the new schematic values
	 */

	public static BlockState loadBlockState(String blockKey, Integer rotation) {

		
		if (newBlockStates.containsKey(blockKey)) {
			
			String adjustedBlockStateKey = adjustForDirection(blockKey, rotation);
			convertState = newBlockStates.get(adjustedBlockStateKey);
			
			newBlockKey = blockKey;

		}
		
		return convertState;
	}

	public static String adjustForDirection(String blockStateKey, Integer rotation) {

		String adjustedKey = blockStateKey;

		// if there is no rotation or the key does not contain FACING, no change
		if (blockStateKey.contains("f")) {

			int fPos = blockStateKey.indexOf("f") - 1;
			char initFacing = blockStateKey.charAt(fPos);
			char newFacing = 'w';

			// w, e, n, s
			switch (rotation) {

			case 0: {
				if (initFacing == 'w') {
					newFacing = 'w';
					break;
				} else {
					if (initFacing == 'e') {
						newFacing = 'e';
						break;
					} else {
						if (initFacing == 'n') {
							newFacing = 'n';
							break;
						} else {
							newFacing = 's';
							break;
						}
					}
				}
			}

			case 1: {
				if (initFacing == 'w') {
					newFacing = 's';
					break;
				} else {
					if (initFacing == 'e') {
						newFacing = 'n';
						break;
					} else {
						if (initFacing == 'n') {
							newFacing = 'w';
							break;
						} else {
							newFacing = 'e';
							break;
						}
					}
				}
			}
			case 2: {
				if (initFacing == 'w') {
					newFacing = 'e';
					break;
				} else {
					if (initFacing == 'e') {
						newFacing = 'w';
						break;
					} else {
						if (initFacing == 'n') {
							newFacing = 's';
							break;
						} else {
							newFacing = 'n';
							break;
						}
					}
				}
			}
			case 3: {
				if (initFacing == 'w') {
					newFacing = 'n';
					break;
				} else {
					if (initFacing == 'e') {
						newFacing = 's';
						break;
					} else {
						if (initFacing == 'n') {
							newFacing = 'e';
							break;
						} else {
							newFacing = 'w';
							break;
						}
					}
				}
			}
			}

			adjustedKey = blockStateKey.replace(initFacing, newFacing);

		} else {

			if (blockStateKey.contains("a")) {

				if (rotation == 1 || rotation == 3) {

					adjustedKey = blockStateKey;

					int fPos = blockStateKey.indexOf("a") - 1;
					char initAxis = blockStateKey.charAt(fPos);

					if (initAxis == 'x') {
						adjustedKey = blockStateKey.replaceFirst("xa", "za");
					} else {
						if (initAxis == 'z') {
							adjustedKey = blockStateKey.replaceFirst("za", "xa");
						}
					}

				}

			}

		}

		return adjustedKey;

	}

	public static Integer getBlockID(Block blox) {

		int bloxID = 0;
		if (blockIDs.containsKey(blox)) {
			bloxID = blockIDs.get(blox);
		}
		return bloxID;
	}
	
	public static BlockState getBlockState(String stateKey) {
		
		BlockState testState = cobblestone;
		if (newBlockStates.containsKey(stateKey)) {
			testState = newBlockStates.get(stateKey);
		}
		return testState;
		
	}
}