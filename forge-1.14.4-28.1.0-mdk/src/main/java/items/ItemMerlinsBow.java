
package items;

import javax.annotation.Nullable;

//import events.EventChangeFOV;
import merlinsforge.MerlinsForge;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ItemMerlinsBow extends BowItem {

	public ItemMerlinsBow(Item.Properties properties) {
		super(properties);
		properties.group(MerlinsForge.ITEM_GROUP);
	}

	public ItemStack findAmmo(PlayerEntity player) {
		if (this.isArrow(player.getHeldItem(Hand.OFF_HAND))) {
			return player.getHeldItem(Hand.OFF_HAND);
		} else if (this.isArrow(player.getHeldItem(Hand.MAIN_HAND))) {
			return player.getHeldItem(Hand.MAIN_HAND);
		} else {
			for (int i = 0; i < player.inventory.getSizeInventory(); ++i) {
				ItemStack itemstack = player.inventory.getStackInSlot(i);

				if (this.isArrow(itemstack)) {
					return itemstack;
				}
			}

			return null;
		}
	}

	protected boolean isArrow(@Nullable ItemStack stack) {
		return stack != null && stack.getItem() instanceof ArrowItem;
	}

	/**
	 * Called when the player stops using an Item (stops holding the right mouse
	 * button).
	 */
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {

		if (entityLiving instanceof PlayerEntity) {

			PlayerEntity entityplayer = (PlayerEntity) entityLiving;

			boolean flag = EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
			ItemStack itemstack = this.findAmmo(entityplayer);

			if (flag || itemstack != null) {

				int i = this.getMaxItemUseDuration(stack) - timeLeft;
				i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, (PlayerEntity) entityLiving,
						i, itemstack != null || flag);
				if (i < 0)
					return;

				itemstack = new ItemStack(Items.ARROW);

				float f = getArrowVelocity(i);

				if ((double) f >= 0.1D) {
					boolean flag1 = (itemstack.getItem() instanceof ArrowItem
							? ((ArrowItem) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer)
							: false);

					if (!worldIn.isRemote) {
						ArrowItem itemarrow = (ArrowItem) ((ArrowItem) (itemstack.getItem() instanceof ArrowItem
								? itemstack.getItem()
								: Items.ARROW));
						
						AbstractArrowEntity entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);

						entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F,
								f * 3.0F, 1.0F);

						if (f == 1.0F) {
							entityarrow.setIsCritical(true);
						}

						int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

						if (j > 0) {
							entityarrow.setDamage(entityarrow.getDamage() + (double) j * 0.5D + 0.5D);
						}

						int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

						if (k > 0) {
							entityarrow.setKnockbackStrength(k);
						}

						entityarrow.setFire(100);

						if (flag1) {
							entityarrow.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;
						}

						worldIn.addEntity(entityarrow);
					}

					if (!flag1) {
						itemstack.shrink(1);

						if (itemstack.isEmpty()) {
							entityplayer.inventory.deleteStack(itemstack);
						}
					}

					entityplayer.addScore(1);
				}

			}

		}

	}

	/**
	 * Gets the velocity of the arrow entity from the bow's charge
	 */
	public static float getArrowVelocity(int charge) {
		float f = 20.0F;
		return f;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}


	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, PlayerEntity playerIn,
			Hand hand) {

		boolean flag = this.findAmmo(playerIn) != null;

		ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemStackIn, worldIn,
				playerIn, hand, flag);
		if (ret != null) {
			return ret;
		}

		playerIn.setActiveHand(hand);
		return new ActionResult<>(ActionResultType.SUCCESS, itemStackIn);

	}

	/**
	 * Return the enchantability factor of the item, most of the time is based on
	 * material.
	 */
	public int getItemEnchantability() {
		return 1;
	}

}
