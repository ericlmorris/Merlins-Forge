package items;

import java.util.List;

import merlinsforge.MerlinsForge;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.structure.VillagePieces.Village;
import net.minecraftforge.common.util.ChunkCoordComparator;

public class ItemShamanStick extends Item {

	public static ITextComponent textComponent = null;
	public static Double range;

	public ItemShamanStick(Properties properties) {
		super(properties);
		properties.group(MerlinsForge.ITEM_GROUP);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {

		ItemStack stack = player.getHeldItem(hand);

		if (!world.isRemote) {

			int xLevel = player.experienceLevel;

			range = 4D;
			
			if (xLevel > 10) range = range + 2;
			if (xLevel > 20) range = range + 2;
			if (xLevel > 30) range = range + 4;
			
			textComponent = new TranslationTextComponent(
					"Your experience level is: " + xLevel + " and effective range is: " + range);
			textComponent.getStyle().setColor(TextFormatting.WHITE);
			player.sendMessage(textComponent);

			getNearestTargetableMob(world, player, player.posX, player.posY, player.posZ);
		}
		return new ActionResult<>(ActionResultType.SUCCESS, stack);
	}

	/**
	 * Returns the nearest targetable mob to the indicated [xpos, ypos, zpos].
	 * 
	 */
	private MobEntity getNearestTargetableMob(World world, PlayerEntity player, double xpos, double ypos, double zpos) {

		int mobCount = 0;
		// set bounds block on the x/z axis
		double d0 = range;
		// set bounds block on the y axis
		double d1 = range / 4;

		// look for any mob within range
		List<MobEntity> list = world.<MobEntity>getEntitiesWithinAABB(MobEntity.class,
				new AxisAlignedBB((double) xpos - d0, (double) ypos - d1, (double) zpos - d0, (double) xpos + d0,
						ypos + d1, (double) zpos + d0));

		// clear mob holder
		MobEntity mobTarget = null;

		// look at all mobs within range
		for (MobEntity MobEntity : list) {

			mobTarget = MobEntity;

			if (mobTarget != null && !world.isRemote) {

				if (MobEntity instanceof VillagerEntity || MobEntity instanceof IronGolemEntity) {

					float oldHealth = mobTarget.getHealth();

					if (MobEntity instanceof VillagerEntity)
						mobCount++;

					mobTarget.addPotionEffect(new EffectInstance(Effects.INSTANT_HEALTH, 600, 1));

					String mobData;

					if (mobTarget instanceof VillagerEntity) {
						mobData = "Villager";
					} else {
						mobData = "Iron Golem";
					}
					textComponent = new TranslationTextComponent(
							mobData + " restored to health level from " + oldHealth + " to " + mobTarget.getHealth());
					textComponent.getStyle().setColor(TextFormatting.WHITE);
					player.sendMessage(textComponent);

				} else {

					if (MobEntity instanceof ZombieEntity || mobTarget instanceof CreeperEntity
							|| mobTarget instanceof RavagerEntity || mobTarget instanceof VindicatorEntity
							|| mobTarget instanceof EvokerEntity || mobTarget instanceof VexEntity
							|| mobTarget instanceof PillagerEntity || mobTarget instanceof IllusionerEntity) {
						mobTarget.setFire(5);
						mobTarget.setHealth(0);

					}
				}

			}
		}

		textComponent = new TranslationTextComponent(mobCount + " Villagers in the vicinity");
		textComponent.getStyle().setColor(TextFormatting.WHITE);
		player.sendMessage(textComponent);
		return mobTarget;
	}
}
