package items;

import java.util.List;

import merlinsforge.MerlinsForge;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMerlinsHarvestStaff extends Item {

	public static AxisAlignedBB aabb;
	public static int PICKUP_RADIUS = 10;

	public ItemMerlinsHarvestStaff(Item.Properties properties) {
		super(properties);
		properties.group(MerlinsForge.ITEM_GROUP);
	}

	// method initiated on right click of harvest staff
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

		ItemStack stack = player.getHeldItem(hand);
			
		if (!world.isRemote) {

			// scan across nearby blocks

			// scan across x-axis
			for (int i = -9; i < 10; i++) {

				// scan across z-axis
				for (int j = -9; j < 10; j++) {

					// scan up/down y-axis
					for (int k = -2; k < 3; k++) {

						// get the block and its position
						BlockPos pos = new BlockPos(player.getPosition().getX() + i, player.getPosition().getY() + k,
								player.getPosition().getZ() + j);
						BlockPos pox = new BlockPos(player.getPosition().getX() + i, player.getPosition().getY() + 1 + k,
								player.getPosition().getZ() + j);
						BlockState bos = world.getBlockState(pos);
						BlockState box = world.getBlockState(pos);

						Block blox = bos.getBlock();

						// is it a crop block?
						if (blox instanceof CropsBlock) {
							// is the crop mature enough to harvest
							boolean maxAge = bos.get(((CropsBlock) blox).getAgeProperty()) >= ((CropsBlock) blox)
									.getMaxAge();
							if (maxAge) {
								world.destroyBlock(pos, true);
								world.setBlockState(pox, box);	

							} else {
								if (blox instanceof IGrowable) {
									IGrowable igrowable = (IGrowable) blox;

									if (igrowable.canGrow(world, pos, bos, world.isRemote)) {
										{
											if (!world.isRemote) {
												igrowable.grow(world, world.rand, pos, bos);

											}
										}
									}
								}
							}

						} else {
							// mow down these
							if ((blox == Blocks.GRASS_BLOCK) || (blox == Blocks.TALL_GRASS) || (blox == Blocks.GRASS)
									|| (blox == Blocks.SUNFLOWER) || (blox == Blocks.LILAC)
									|| (blox == Blocks.ROSE_BUSH) || (blox == Blocks.PEONY) || (blox == Blocks.SEAGRASS)
									|| (blox == Blocks.TALL_SEAGRASS)) {
								BlockPos poz = new BlockPos(player.getPosition().getX() + i, player.getPosition().getY() + k + 1,
										player.getPosition().getZ() + j);
								world.destroyBlock(poz, true);
							}
						}

					}
				}
			}
			
			aabb = new AxisAlignedBB(player.posX - PICKUP_RADIUS, player.posY - PICKUP_RADIUS,
					player.posZ - PICKUP_RADIUS, player.posX + PICKUP_RADIUS, player.posY + PICKUP_RADIUS,
					player.posZ + PICKUP_RADIUS);
			List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, aabb);

			for (ItemEntity item : items) {
				boolean value = player.inventory.addItemStackToInventory(item.getItem());
			}
			
			List<AnimalEntity> mobs = world.getEntitiesWithinAABB(AnimalEntity.class, aabb);
		    for (AnimalEntity animal : mobs)
		    {
		       	animal.setInLove(player);
		    }
		}
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

	@Override
	public void addInformation(ItemStack stack, World world, List<ITextComponent> list, ITooltipFlag flag) {
		super.addInformation(stack, world, list, flag);
		list.add(new StringTextComponent(TextFormatting.BLUE + "Right click to harvest and pick up."));
		list.add(new StringTextComponent(TextFormatting.GREEN + "+ shaped recipe with wheat seeds."));
	}
}
