package items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class CalculateCompassAngle implements IItemPropertyGetter {

	private double prevAngle = 0.0D;
	private double prevWobble = 0.0D;
	private long prevWorldTime = 0L;
	public static BlockPos minePos;

	/**
	 * Calculates the compass angle from an item stack and an entity/item frame
	 *
	 * @param stack
	 *            The item stack
	 * @param world
	 *            The world
	 * @param livingEntity
	 *            The entity
	 * @return The angle
	 */
	@Override
	public float call(ItemStack stack, @Nullable World world, @Nullable LivingEntity livingEntity) {

		if (livingEntity != null && livingEntity instanceof PlayerEntity) {

			PlayerEntity player = (PlayerEntity) livingEntity;
			world = livingEntity.world;

			BlockPos strongholdPos = ItemMerlinsCompass.minePos;

			double angle;

			if (strongholdPos != null) {
				double entityAngle = player.rotationYaw;
				entityAngle /= 360.0D;
				entityAngle = MathHelper.positiveModulo(entityAngle, 1.0D);
				double posAngle = getPosToAngle(strongholdPos, player);
				posAngle /= Math.PI * 2D;
				angle = 0.5D - (entityAngle - 0.25D - posAngle);
			} else {
				angle = Math.random();
			}

			angle = wobble(world, angle);
			
			if (strongholdPos != null) {
				//System.out.println(MathHelper.positiveModulo((float) angle, 1.0F));
			}

			return MathHelper.positiveModulo((float) angle, 1.0F);
		}

		return 0.0F;

	}

	/**
	 * Adds wobbliness based on the previous angle and the specified angle
	 *
	 * @param world
	 *            The world
	 * @param angle
	 *            The current angle
	 * @return The new, wobbly angle
	 */
	private double wobble(World world, double angle) {
		long worldTime = world.getGameTime();
		if (worldTime != prevWorldTime) {
			prevWorldTime = worldTime;
			double angleDifference = angle - prevAngle;
			angleDifference = MathHelper.positiveModulo(angleDifference + 0.5D, 1.0D) - 0.5D;
			prevWobble += angleDifference * 0.1D;
			prevWobble *= 0.8D;
			prevAngle = MathHelper.positiveModulo(prevAngle + prevWobble, 1.0D);
		}
		return prevAngle;
	}

	/**
	 * Gets the facing direction of an item frame in degrees
	 *
	 * @param entity
	 *            The entity instance of the item frame
	 * @return The angle
	 */
	private double getFrameAngle(ItemFrameEntity entity) {
		return MathHelper.wrapDegrees(180 + entity.getHorizontalFacing().getHorizontalIndex() * 90);
	}

	/**
	 * Gets the angle from an entity to the specified position in radians
	 *
	 * @param pos
	 *            The position
	 * @param entity
	 *            The entity
	 * @return The angle
	 */
	private double getPosToAngle(BlockPos pos, Entity entity) {
		return Math.atan2(pos.getZ() - entity.posZ, pos.getX() - entity.posX);
	}

}
