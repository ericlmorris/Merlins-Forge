package items;

import merlinsforge.MerlinsForge;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class ItemMerlinsGrenade extends Item {

	public ItemMerlinsGrenade(Item.Properties properties) {
		super(properties);
		properties.group(MerlinsForge.ITEM_GROUP);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand playerIn) {

		ItemStack itemstack = player.getHeldItem(playerIn);

		itemstack.shrink(1);

		world.playSound((PlayerEntity) null, player.posX, player.posY, player.posZ,
				SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (1.0F * 0.4F + 0.8F));

		if (!world.isRemote) {
			EntityMerlinsGrenade entitysnowball = new EntityMerlinsGrenade(world, player);
			entitysnowball.shoot(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
			world.addEntity(entitysnowball);

		}

		return new ActionResult<>(ActionResultType.SUCCESS, itemstack);
	}
}
