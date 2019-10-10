package items;

import java.util.List;

import items.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.item.Items;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityMerlinsGrenade extends SnowballEntity {

	public static Integer tickDelay = 0;

	public EntityMerlinsGrenade(World worldIn, LivingEntity throwerIn) {
		super(worldIn, throwerIn);
	}

	@Override
	protected void onImpact(RayTraceResult result) {

		if (result.getType() == RayTraceResult.Type.BLOCK) {

			Vec3d vex = result.getHitVec();

			BlockPos pos = new BlockPos(vex.x, vex.y, vex.z);
			if (pos != null && world != null) {
				MobEntity mobTarget = getNearestTargetableMob(world, (double) pos.getX(), (double) pos.getY(),
						(double) pos.getZ());
			}

		}

	}

	/**
	 * Returns the nearest targetable mob to the indicated [xpos, ypos, zpos].
	 * 
	 */
	private MobEntity getNearestTargetableMob(World world, double xpos, double ypos, double zpos) {

		// set bounds block +/- 16 on the x/z axis
		double d0 = 16.0D;
		// set bounds block +/- 5 on the y axis
		double d1 = 5.0D;

		// look for any mob within range
		List<MobEntity> list = world.<MobEntity>getEntitiesWithinAABB(MobEntity.class,
				new AxisAlignedBB((double) xpos - d0, (double) ypos - d1, (double) zpos - d0, (double) xpos + d0,
						ypos + d1, (double) zpos + d0));

		// clear mob holder
		MobEntity mobTarget = null;

		// look at all mobs within range
		for (MobEntity MobEntity : list) {
			if (MobEntity instanceof MobEntity && tickDelay > 5) {

				tickDelay = 0;

				mobTarget = MobEntity;
				// if the mob is hostile
				if (mobTarget != null) {

					// determine drop
					if (!world.isRemote) {

						if (mobTarget instanceof ZombieEntity) {
							mobTarget.entityDropItem(ModItems.MERLINS_GOLD, 1);

						} else {
							if (mobTarget instanceof CaveSpiderEntity) {
								mobTarget.entityDropItem(ModItems.MERLINS_DIAMOND, 1);

							} else {
								if (mobTarget instanceof CreeperEntity || mobTarget instanceof SkeletonEntity) {
									mobTarget.entityDropItem(Items.EMERALD, 1);

								} else {
									mobTarget.entityDropItem(ModItems.MERLINS_GRENADE, 1);
								}
							}
						} // kill the mob
						mobTarget.setFire(5);
						mobTarget.setHealth(0);
					}
				}
			} else {
				tickDelay++;
			}
		}

		return null;
	}
}
