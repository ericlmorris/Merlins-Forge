package blocks;

import java.util.Random;

import events.EventPlayerTickLoad;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class FishTrapBlock extends Block{
	
	public static Integer tickCounter = 0;

	public FishTrapBlock(Properties properties) {
		super(properties);
	}
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldObj, BlockPos pos, Random rand) {
		{

			if (tickCounter < 20) {
				tickCounter++;
			} else {
				
				tickCounter = 0;
				// make sure surrounded by water

				if (worldObj.getBlockState(pos.down()).getBlock() == Blocks.WATER
						&& worldObj.getBlockState(pos.down(2)).getBlock() == Blocks.WATER
						&& worldObj.getBlockState(pos.north()).getBlock() == Blocks.WATER
						&& worldObj.getBlockState(pos.east()).getBlock() == Blocks.WATER
						&& worldObj.getBlockState(pos.west()).getBlock() == Blocks.WATER
						&& worldObj.getBlockState(pos.south()).getBlock() == Blocks.WATER

				) {

					ItemStack cod = new ItemStack(Items.COD);
					double codChance = 50;

					ItemStack salmon = new ItemStack(Items.SALMON);
					double salmonChance = 50; 
					
					double diceRoll = rand.nextDouble() * 100;

					ItemStack fishSpawned = null;

					if (diceRoll < codChance) {
						fishSpawned = cod;
					} else if (diceRoll > salmonChance) {
						fishSpawned = salmon;
					}
					if (fishSpawned != null) {
						ItemEntity ei = dropItemStackInWorld(worldObj, pos.up(), fishSpawned);
					}
				}
			}
		}
	}

	public static ItemEntity dropItemStackInWorld(World worldObj, BlockPos pos, ItemStack stack) {

		World world = EventPlayerTickLoad.tickWorld;

		ItemEntity entityItem = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack);

		if (!world.isRemote)// do not spawn a second 'ghost' one on client side
		{
			world.addEntity(entityItem);
		}
		return entityItem;
	}
}

