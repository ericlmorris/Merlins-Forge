package events;

import commands.CommandFillSpace;
import items.ItemMerlinsArmor;
import merlinsforge.MerlinsForge;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import schematics.StructureSave;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID)
public class EventPlayerTickLoad {

	public static PlayerEntity thePlayer;
	public static World tickWorld;
	public static Boolean softLanding = false;
	public static ITextComponent textComponent = null;

	@SubscribeEvent
	public static void onPlayerLoggedIn(final PlayerLoggedInEvent event) {

		if (event.getPlayer() instanceof PlayerEntity) {

			thePlayer = event.getPlayer();
			tickWorld = event.getPlayer().getEntityWorld();

			EventClock.playerLoggedIn = true;

			CommandFillSpace.fromX = 0;
			StructureSave.startX = 0;
			
			int xLevel = thePlayer.experienceLevel;
			int xTotal = thePlayer.experienceTotal;
			textComponent = new TranslationTextComponent(
					"Your experience level is: " + xLevel + " and total experience is: " + xTotal);
			textComponent.getStyle().setColor(TextFormatting.WHITE);
			thePlayer.sendMessage(textComponent);

		}
	}

	@SubscribeEvent
	public static void deployParachute(final TickEvent.PlayerTickEvent event) {

		PlayerEntity player = event.player;

		if (player.inventory.armorInventory.get(2) != null) {

			Item item = player.inventory.armorInventory.get(2).getItem();

			if (item != null && item instanceof ItemMerlinsArmor && player.fallDistance > 3) {

				player.setMotion(player.getMotion().mul(1.0D, 0.5D, 1.0D));

			}

		}
	}

	@SubscribeEvent
	public static void negateFallDamage(final LivingFallEvent event) {

		if (event.getEntityLiving() != null && event.getEntityLiving() instanceof PlayerEntity) {
			
			Item item = thePlayer.inventory.armorInventory.get(2).getItem();

			if (item != null && item instanceof ItemMerlinsArmor && thePlayer.fallDistance > 3) {
				event.setCanceled(true);
			}

		}
	}

}
