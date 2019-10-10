package events;

import java.util.List;

import items.ItemMerlinsAxe;
import items.ItemMerlinsBow;
import items.ItemMerlinsPickAxe;
import items.ItemMerlinsSword;
import items.ItemSchematicStick;
import merlinsforge.MerlinsForge;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID)
public class EventClientTick {

	private static final Minecraft MINECRAFT = Minecraft.getInstance();
	public static ITextComponent textComponent = null;

	public static int oreDetectionRange = 5;
	public static Boolean stickInHand = false;
	public static Integer tickCounter = 0;

	public static Boolean mobHit = false;

	@SubscribeEvent
	public static void onClientTick(final TickEvent.ClientTickEvent event) {

		final PlayerEntity player = MINECRAFT.player;
		final World playersWorld = MINECRAFT.world;

		if (event.phase == TickEvent.Phase.END && MINECRAFT.player != null) {

			/*
			 * Test for players depth and pickaxe in hand
			 */
			// double yDepth = player.posY;
			ItemStack mainHand = player.getHeldItemMainhand();
			
			
			if (mainHand.getItem() != null && mainHand.getItem() instanceof ItemMerlinsPickAxe && player.isSneaking()) {

				EventRenderOres.pickaxeDetection = true;
				EventRenderOres.player = player;
				EventRenderOres.world = playersWorld;
				EventRenderOres.displayOres();
			} else {
				EventRenderOres.pickaxeDetection = false;
			}

			if (mainHand.getItem() != null && (mainHand.getItem() instanceof ItemMerlinsBow
					|| mainHand.getItem() instanceof ItemMerlinsSword || mainHand.getItem() instanceof ItemMerlinsPickAxe
					|| mainHand.getItem() instanceof ItemMerlinsAxe)) {
			
				if (tickCounter > 20) {

					double x = player.posX;
					double y = player.posY;
					double z = player.posZ;
					getNearestTargetableMob(player, playersWorld, x, y, z);
					tickCounter = 0;

				} else {
					tickCounter++;
				}
			}
			
			if (mainHand.getItem() != null && mainHand.getItem() instanceof ItemSchematicStick) {
				EventRenderStructure.showNoShow = true;
			} else {
				EventRenderStructure.showNoShow = false;
			}

		}

	}

	/**
	 * Returns the nearest targetable mob to the indicated [xpos, ypos, zpos].
	 * 
	 */
	public static MobEntity getNearestTargetableMob(PlayerEntity player, World world, double xpos, double ypos,
			double zpos) {

		// set bounds block +/- 16 on the x/z axis
		double d0 = 8.0D;
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
				break;
			}
		}
	
		if (mobHit) {
			textComponent = new TranslationTextComponent("Hostile Mob!");
			textComponent.getStyle().setColor(TextFormatting.RED);
			player.sendMessage(textComponent);
		}

		return null;

	}
}
