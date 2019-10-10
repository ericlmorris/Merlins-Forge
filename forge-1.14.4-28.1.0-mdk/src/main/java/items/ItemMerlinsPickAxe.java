package items;

import java.util.List;

import javax.annotation.Nonnull;

import merlinsforge.MerlinsForge;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemMerlinsPickAxe extends PickaxeItem {

	public static int attackdamage = 5;
	public static int attackspeed = -5;
	public static AxisAlignedBB aabb;
	public static int PICKUP_RADIUS = 10;

	protected ItemMerlinsPickAxe(Properties builder) {
		super(ItemTier.DIAMOND, attackdamage, attackspeed, builder);
		builder.group(MerlinsForge.ITEM_GROUP);
	}

	@Override
	public boolean hitEntity(final ItemStack stack, final LivingEntity target, @Nonnull final LivingEntity attacker) {

		if (attacker instanceof PlayerEntity && target instanceof MobEntity) {
			target.attackEntityFrom(DamageSource.GENERIC, 25);
			target.setFire(5);
		}

		return super.hitEntity(stack, target, attacker);
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {
		if (entityLiving instanceof PlayerEntity) {

			PlayerEntity thisPlayer = (PlayerEntity) entityLiving;
			aabb = new AxisAlignedBB(thisPlayer.posX - PICKUP_RADIUS, thisPlayer.posY - PICKUP_RADIUS,
					thisPlayer.posZ - PICKUP_RADIUS, thisPlayer.posX + PICKUP_RADIUS, thisPlayer.posY + PICKUP_RADIUS,
					thisPlayer.posZ + PICKUP_RADIUS);
			List<ItemEntity> items = worldIn.getEntitiesWithinAABB(ItemEntity.class, aabb);

			for (ItemEntity item : items) {

				boolean value = thisPlayer.inventory.addItemStackToInventory(item.getItem());
			}
		}
		return true;
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (!world.isRemote) {
			
			aabb = new AxisAlignedBB(player.posX - PICKUP_RADIUS, player.posY - PICKUP_RADIUS,
					player.posZ - PICKUP_RADIUS, player.posX + PICKUP_RADIUS, player.posY + PICKUP_RADIUS,
					player.posZ + PICKUP_RADIUS);
			List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, aabb);

			for (ItemEntity item : items) {
				boolean value = player.inventory.addItemStackToInventory(item.getItem());
			}
		}
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

}
