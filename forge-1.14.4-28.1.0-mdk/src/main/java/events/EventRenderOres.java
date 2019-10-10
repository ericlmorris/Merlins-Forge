package events;

import java.util.ArrayList;
import java.util.List;

import merlinsforge.MerlinsForge;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.IFluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID)
public class EventRenderOres {

	/*
	 * Ore Detection
	 */
	public static Boolean pickaxeDetection = false;
	public static Integer oreDetectionRange = 10;

	// blocks to be highlighted
	private static List<RenderOres> oreTargets = new ArrayList<>();

	public static int updateFrequency = 10;

	/*
	 * player and world come from EventClientTick
	 */

	public static PlayerEntity player;
	public static World world;

	/*
	 * Ore Detection
	 */

	@SubscribeEvent
	public static void renderInWorld(final RenderWorldLastEvent event) {

		if (pickaxeDetection && player != null) {

			for (RenderOres target : oreTargets) {
				target.render(event.getPartialTicks());
			}
		}
	}

	/*
	 * Called from EventClientTick
	 */
	public static void displayOres() {

		PlayerEntity player = EventPlayerTickLoad.thePlayer;

		if (pickaxeDetection) {

			if (player != null && world != null && world.getDayTime() % updateFrequency == 0) {

				oreTargets.clear();

				int xLower = (int) player.posX - oreDetectionRange;
				int xHigher = (int) player.posX + oreDetectionRange;
				int yLower = (int) player.posY - oreDetectionRange;
				int yHigher = (int) player.posY + oreDetectionRange;
				int zLower = (int) player.posZ - oreDetectionRange;
				int zHigher = (int) player.posZ + oreDetectionRange;

				for (int x = xLower; x < xHigher; x++) {
					for (int y = yLower; y < yHigher; y++) {
						for (int z = zLower; z < zHigher; z++) {
							BlockPos pos = new BlockPos(x, y, z);
							validatePos(world, pos, player);
						}
					}
				}
			}

		} else if (!oreTargets.isEmpty()) {

			oreTargets.clear();
		}

	}

	public static void validatePos(World world, BlockPos pos, PlayerEntity player) {

		if (pos != null && player != null) {
			
			//IFluidState x = world.getFluidState(pos);

			if (world.getBlockState(pos).getBlock() != Blocks.AIR) {

				BlockState state = world.getBlockState(pos);
				int oreColor = -1;
				
				if (!state.isSolid()) {
					
					oreColor = 7;

				} else {

					oreColor = getColorForOre(world.getBlockState(pos));
				}

				if (oreColor != -1) {
					oreTargets.add(new RenderOres(world, player, pos, oreColor));
				}

			}
		}
	}

	// white, dark purple, maroon, olive drab, yellow, light blue, fuchia,
	// orange, dark gray,
	// turquoise, lt purple, dk blue,
	// dk gold, dkgreen, red, black

	private static final int[] BLOCK_COLOR = new int[] { 0xffffff, 0x660066, 0x999900, 0x666600, 0xffff00, 0xc0c9ed,
			0xff69b4, 0xff8000, 0x606060, 0x00ffff, 0xEE82EE, 0x0000ff, 0xCC6600, 0x008000, 0xff0000, 0x000000 };

	private static int getColorForOre(BlockState block) {

		int oreColor = -1;

		if (block.getBlock() == Blocks.GOLD_ORE)
			oreColor = 4;
		if (block.getBlock() == Blocks.IRON_ORE)
			oreColor = 8;
		if (block.getBlock() == Blocks.DIAMOND_ORE)
			oreColor = 6;
		if (block.getBlock() == Blocks.LAVA)
			oreColor = 7;
		if (block.getBlock() == Blocks.WATER)
			oreColor = 11;
		if (block.getBlock() == Blocks.REDSTONE_ORE)
			oreColor = 14;
		if (block.getBlock() == Blocks.LAPIS_ORE)
			oreColor = 5;
		if (block.getBlock() == Blocks.EMERALD_ORE)
			oreColor = 13;
		if (block.getBlock() == Blocks.COAL_ORE)
			oreColor = 15;

		if (oreColor > 0) {
			return BLOCK_COLOR[oreColor];
		}

		return -1;
	}

}
