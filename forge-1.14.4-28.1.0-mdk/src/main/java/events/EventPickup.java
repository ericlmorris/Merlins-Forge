package events;

import java.util.List;

import configuration.AutoPickup;
import merlinsforge.MerlinsForge;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.EntityInteractSpecific;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID)
public class EventPickup {

	/*
	 * Instant Pickup
	 */
	private static final int DELAY = 1;
	public static int PICKUP_RADIUS = 10;
	public static Integer delays = 0;
	public static PlayerEntity thisPlayer = null;
	public static AxisAlignedBB aabb;

	@SubscribeEvent
	public static void onEvent(final TickEvent.WorldTickEvent event) {

		// check config
		Boolean pickup = AutoPickup.PICK_UP.get();

		if (pickup) {

			thisPlayer = EventPlayerTickLoad.thePlayer;

			if (thisPlayer != null && !event.world.isRemote && delays == 1) {

				List<ItemEntity> items = event.world.getEntitiesWithinAABB(ItemEntity.class, aabb);
			
				for (ItemEntity item : items) {
					boolean value = thisPlayer.inventory.addItemStackToInventory(item.getItem());
				}

				List<ExperienceOrbEntity> xp = event.world.getEntitiesWithinAABB(ExperienceOrbEntity.class, aabb);
							
				for (ExperienceOrbEntity orb : xp) {
					
					System.out.println(thisPlayer.experienceTotal);
					thisPlayer.giveExperiencePoints(orb.xpValue);
					System.out.println(thisPlayer.experienceTotal);
		
				}

				delays = 0;

			}
		}

	}

	/** Detect when mob killed and give drops to player. */
	@SubscribeEvent
	public static void onEvent(final LivingDropsEvent event) {

		if (!event.getEntity().world.isRemote) {

			// get the position of the dead entity
			setDelayedPickup(event.getEntity().posX, event.getEntity().posY, event.getEntity().posZ);
			thisPlayer = EventPlayerTickLoad.thePlayer;
		}
	}

	/** Detect when mob sheared. */
	@SubscribeEvent
	public static void onEvent(final EntityInteractSpecific event) {

		if (!event.getEntityPlayer().world.isRemote) {
			setDelayedPickup(event.getTarget().posX, event.getTarget().posY, event.getTarget().posZ);
		}
	}

	/** Detect when blocks are broken and give drops to player. */
	@SubscribeEvent
	public static void onBreak(final BlockEvent.BreakEvent event) {

		if (!event.getWorld().isRemote()) {
			setDelayedPickup(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
		}

	}

	/** Detect when blocks are broken and give drops to player. */
	@SubscribeEvent
	public static void onHarvest(final BlockEvent.HarvestDropsEvent event) {

		System.out.println("harvest");

		if (!event.getWorld().isRemote()) {
			setDelayedPickup(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
		}

	}

	public static void setDelayedPickup(double x, double y, double z) {

		delays = DELAY;
		aabb = new AxisAlignedBB(x - PICKUP_RADIUS, y - PICKUP_RADIUS, z - PICKUP_RADIUS, x + PICKUP_RADIUS,
				y + PICKUP_RADIUS, z + PICKUP_RADIUS);

	}

}
