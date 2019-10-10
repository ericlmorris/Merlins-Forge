package items;

import merlinsforge.MerlinsForge;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class EntityLightningBolt extends SnowballEntity {
	
	public static int explosionRadius = 1;
	public static World world;
	
	public EntityLightningBolt(World worldIn, LivingEntity throwerIn) {
		super(worldIn, throwerIn);
		world = worldIn;
	}
	
	@Override
	protected void onImpact(RayTraceResult result) {

		if (result.getType() == RayTraceResult.Type.BLOCK) {
			Vec3d vex = result.getHitVec();
			BlockPos pos = new BlockPos(vex.x, vex.y, vex.z);
			if (pos != null && world != null && !world.isRemote) {
				world.createExplosion(this, vex.x, vex.y, vex.z, (float)this.explosionRadius * 1.0F, true, Explosion.Mode.DESTROY);
			}
		}

	}
	@Override
	protected void registerData() {
		// TODO Auto-generated method stub
		
	}

}
