package items;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemMerlinsTravelingStaff extends Item {

	public static String name;

	public static int[] xPos;
	public static int[] yPos;
	public static int[] zPos;
	public static long[] wSeed;

	public static int tpCount = 0;
	public static int maxHits = 3;

	public ItemMerlinsTravelingStaff(Item.Properties properties) {
		super(properties);
		properties.group(MerlinsForge.ITEM_GROUP);

	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

		ItemStack stack = player.getHeldItem(hand);

		if (!world.isRemote) {
			
			double x = 0;
			double y = 99;
			double z = 0;
			
			for(int v = 0; v < 100; v++) {
				
				Vec3d vec = getPos(player, v);

				x = vec.x;
				y = vec.y;
				z = vec.z;
				BlockPos pos = new BlockPos(x, y, z);
				BlockState state = world.getBlockState(pos);
				Block blox = state.getBlock();
				if (blox != Blocks.AIR) {
					break;
				}	
			}

			player.setPositionAndUpdate(x, y, z);

			return new ActionResult<>(ActionResultType.SUCCESS, stack);

		}

		return new ActionResult<>(ActionResultType.FAIL, stack);
	}

	public static Vec3d getPos(PlayerEntity player, double distance) {

		float f = player.rotationPitch;
		float f1 = player.rotationYaw;
		double d0 = player.posX;
		double d1 = player.posY + (double) player.getEyeHeight();
		double d2 = player.posZ;
		Vec3d vec3 = new Vec3d(d0, d1, d2);
		float f2 = MathHelper.cos(-f1 * 0.017453292F - (float) Math.PI);
		float f3 = MathHelper.sin(-f1 * 0.017453292F - (float) Math.PI);
		float f4 = -MathHelper.cos(-f * 0.017453292F);
		float f5 = MathHelper.sin(-f * 0.017453292F);
		float f6 = f3 * f4;
		float f7 = f2 * f4;
		Vec3d vec31 = vec3.add((double) f6 * distance, (double) f5 * distance, (double) f7 * distance);
		return vec31;
	}

}
