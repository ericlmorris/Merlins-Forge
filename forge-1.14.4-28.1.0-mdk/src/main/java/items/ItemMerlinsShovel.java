package items;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.collect.Sets;

import merlinsforge.MerlinsForge;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemMerlinsShovel extends ToolItem {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.DIRT, Blocks.PODZOL,
			Blocks.COARSE_DIRT, Blocks.STONE, Blocks.DIORITE, Blocks.GRANITE, Blocks.ANDESITE,
			Blocks.GRASS_BLOCK, Blocks.GRASS_PATH, Blocks.COAL_ORE, Blocks.GRAVEL, Blocks.SAND,
			Blocks.SANDSTONE);
	public static int attackdamage = 5;
	public static int attackspeed = -5;
	public static AxisAlignedBB aabb;
	public static int PICKUP_RADIUS = 10;

	protected ItemMerlinsShovel(Item.Properties builder) {
		super(attackdamage, attackspeed, ItemTier.DIAMOND, EFFECTIVE_ON,
				builder.addToolType(net.minecraftforge.common.ToolType.SHOVEL, ItemTier.DIAMOND.getHarvestLevel()));
        builder.group(MerlinsForge.ITEM_GROUP);

	}
	
	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (!world.isRemote) {

			aabb = new AxisAlignedBB(player.posX - PICKUP_RADIUS, player.posY - PICKUP_RADIUS, player.posZ - PICKUP_RADIUS, player.posX + PICKUP_RADIUS,
					player.posY + PICKUP_RADIUS, player.posZ + PICKUP_RADIUS);
			List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, aabb);

			for (ItemEntity item : items) {		
				boolean value = player.inventory.addItemStackToInventory(item.getItem());
			}
			return new ActionResult<>(ActionResultType.SUCCESS, stack);
		}

		player.swingArm(hand);
		
		return new ActionResult<>(ActionResultType.FAIL, stack);
	}
	
	@Override
	public boolean hitEntity(final ItemStack stack, final LivingEntity target,
			@Nonnull final LivingEntity attacker) {

		if (attacker instanceof PlayerEntity && target instanceof LivingEntity) {
			target.attackEntityFrom(DamageSource.GENERIC, 25);
			target.setFire(5);
		}

		return super.hitEntity(stack, target, attacker);
	}
	
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {

		if (entityLiving instanceof PlayerEntity) {
			

			PlayerEntity thisPlayer = (PlayerEntity) entityLiving;
			aabb = new AxisAlignedBB(thisPlayer.posX - PICKUP_RADIUS, thisPlayer.posY - PICKUP_RADIUS, thisPlayer.posZ - PICKUP_RADIUS, thisPlayer.posX + PICKUP_RADIUS,
					thisPlayer.posY + PICKUP_RADIUS, thisPlayer.posZ + PICKUP_RADIUS);
			List<ItemEntity> items = worldIn.getEntitiesWithinAABB(ItemEntity.class, aabb);

			for (ItemEntity item : items) {		
				boolean value = thisPlayer.inventory.addItemStackToInventory(item.getItem());
			}
		}

		return true;

	}
}

