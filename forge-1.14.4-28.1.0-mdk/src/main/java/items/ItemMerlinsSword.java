package items;

import java.util.List;

import javax.annotation.Nonnull;

import configuration.ClockDirection;
import merlinsforge.MerlinsForge;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class ItemMerlinsSword extends SwordItem {

	public static int attackdamage = 5;
	public static int attackspeed = -5;
	public static Boolean mobHit;
	public static Boolean mobRed = false;
	public static Boolean mobGreen = false;

	public ItemMerlinsSword(Item.Properties properties) {

		super(ItemTier.DIAMOND, attackdamage, attackspeed, properties);
		properties.group(MerlinsForge.ITEM_GROUP);

	}

	@Override
	public boolean hitEntity(final ItemStack stack, final LivingEntity target, @Nonnull final LivingEntity attacker) {

		if (attacker instanceof PlayerEntity && target instanceof LivingEntity) {
			target.attackEntityFrom(DamageSource.GENERIC, 25);
			target.setFire(5);
		}

		return super.hitEntity(stack, target, attacker);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (!world.isRemote) {

			double x = player.posX;
			double y = player.posY;
			double z = player.posZ;

			getNearestTargetableMob(world, x, y, z);
		}

		return new ActionResult<>(ActionResultType.SUCCESS, stack);

	}

	/**
	 * Returns the nearest targetable mob to the indicated [xpos, ypos, zpos].
	 * 
	 */
	public static MobEntity getNearestTargetableMob(World world, double xpos, double ypos, double zpos) {

		// set bounds block +/- 16 on the x/z axis
		double d0 = 16.0D;
		// set bounds block +/- 5 on the y axis
		double d1 = 4.0D;

		// look for any mob within range
		List<MobEntity> list = world.<MobEntity>getEntitiesWithinAABB(MobEntity.class,
				new AxisAlignedBB((double) xpos - d0, (double) ypos - d1, (double) zpos - d0, (double) xpos + d0,
						ypos + d1, (double) zpos + d0));

		mobHit = false;

		for (MobEntity entitymob : list) {

			if (entitymob instanceof SkeletonEntity || entitymob instanceof CreeperEntity
					|| entitymob instanceof ZombieEntity || entitymob instanceof SpiderEntity
					|| entitymob instanceof HuskEntity || entitymob instanceof CaveSpiderEntity
					|| entitymob instanceof ZombieVillagerEntity || entitymob instanceof StrayEntity
					|| entitymob instanceof WitchEntity || entitymob instanceof GuardianEntity
					|| entitymob instanceof ElderGuardianEntity) {

				mobHit = true;
				entitymob.addPotionEffect(new EffectInstance(Effects.GLOWING, 200, 1));
			} else {
				if (entitymob instanceof RavagerEntity || entitymob instanceof VindicatorEntity
						|| entitymob instanceof EvokerEntity || entitymob instanceof VexEntity
						|| entitymob instanceof PillagerEntity || entitymob instanceof IllusionerEntity) {
				}
				entitymob.attackEntityFrom(DamageSource.GENERIC, 25);
				entitymob.setFire(5);
			}
		}

		return null;

	}
}
