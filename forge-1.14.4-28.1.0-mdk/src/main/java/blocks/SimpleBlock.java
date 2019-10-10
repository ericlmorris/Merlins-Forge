package blocks;

import java.util.List;
import java.util.Random;

import events.EventPlayerTickLoad;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SimpleBlock extends Block {
	
	public static final int RADIUS = 10;

	public SimpleBlock(Properties properties) {
		super(properties);
	}

	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		if (placer instanceof PlayerEntity) {

			// post 1
			BlockPos blockpos2 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
			worldIn.setBlockState(blockpos2, Blocks.OAK_FENCE.getDefaultState());
			// post 2
			blockpos2 = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ());
			worldIn.setBlockState(blockpos2, Blocks.OAK_FENCE.getDefaultState());
			// glowstone
			blockpos2 = new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ());
			worldIn.setBlockState(blockpos2, Blocks.GLOWSTONE.getDefaultState());

		}
	}

	/**
	 * Called after a player destroys this Block - the posiiton pos may no longer
	 * hold the state indicated.
	 */
	public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {

		// post 1
		BlockPos blockpos2 = new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ());
		worldIn.setBlockState(blockpos2, Blocks.AIR.getDefaultState(), 0);
		// post 2
		blockpos2 = new BlockPos(pos.getX(), pos.getY() + 2, pos.getZ());
		worldIn.setBlockState(blockpos2, Blocks.AIR.getDefaultState(), 0);
		// glowstone
		blockpos2 = new BlockPos(pos.getX(), pos.getY() + 3, pos.getZ());
		worldIn.setBlockState(blockpos2, Blocks.AIR.getDefaultState(), 0);
	}

	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		killMobs(pos);
	}

	public void killMobs(BlockPos pos) {

		World world = EventPlayerTickLoad.tickWorld;
		if (!world.isRemote) {

			final AxisAlignedBB areaToSearch = new AxisAlignedBB(pos.add(-RADIUS, -RADIUS, -RADIUS),
					pos.add(RADIUS, RADIUS, RADIUS));
			// kill mobs
			final List<MonsterEntity> entities = world.getEntitiesWithinAABB(MonsterEntity.class, areaToSearch);
			entities.stream().forEach(entity -> entity.setHealth(0));
			// heal villagers
			final List<VillagerEntity> villager = world.getEntitiesWithinAABB(VillagerEntity.class, areaToSearch);
			villager.stream().forEach(entity -> entity.setHealth(entity.getMaxHealth()));
		}
	}
}