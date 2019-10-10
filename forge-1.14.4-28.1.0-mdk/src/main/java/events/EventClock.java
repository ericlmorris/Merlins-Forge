package events;

import java.awt.Color;

import com.mojang.blaze3d.platform.GlStateManager;

import configuration.ClockDirection;
import merlinsforge.MerlinsForge;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID)
public class EventClock {

	public static long worldTime = 0;
	public static long thisTime;
	public static int hour = 0;
	private static final Minecraft MINECRAFT = Minecraft.getInstance();
	public static boolean playerLoggedIn = false;

	@SubscribeEvent
	public static void onEvent(final TickEvent.WorldTickEvent event) {
		worldTime = event.world.getDayTime();
	}

	@SubscribeEvent
	public static void onEvent(final TickEvent.RenderTickEvent event) {

		PlayerEntity player = MINECRAFT.player;

		Boolean clock = ClockDirection.CLOCK_ON.get();
		// System.out.println(clock);

		if (clock) {

			long remainingticks = worldTime % 24000;
			String realTime = "";

			if (remainingticks < 1000) {
				hour = 0;
			} else {
				hour = (int) remainingticks / 1000;
			}

			switch (hour) {

			case 0:
				realTime = "7 AM";
				break;
			case 1:
				realTime = "8 AM";
				break;
			case 2:
				realTime = "9 AM";
				break;
			case 3:
				realTime = "10 AM";
				break;
			case 4:
				realTime = "11 AM";
				break;
			case 5:
				realTime = "12 PM";
				break;
			case 6:
				realTime = "1 PM";
				break;
			case 7:
				realTime = "2 PM";
				break;
			case 8:
				realTime = "3 PM";
				break;
			case 9:
				realTime = "4 PM";
				break;
			case 10:
				realTime = "5 PM";
				break;
			case 11:
				realTime = "6 PM";
				break;
			case 12:
				realTime = "7 PM";
				break;
			case 13:
				realTime = "8 PM";
				break;
			case 14:
				realTime = "9 PM";
				break;
			case 15:
				realTime = "10 PM";
				break;
			case 16:
				realTime = "11 PM";
				break;
			case 17:
				realTime = "12 AM";
				break;
			case 18:
				realTime = "1 AM";
				break;
			case 19:
				realTime = "2 AM";
				break;
			case 20:
				realTime = "3 AM";
				break;
			case 21:
				realTime = "4 AM";
				break;
			case 22:
				realTime = "5 AM";
				break;
			case 23:
				realTime = "6 AM";
				break;
			default:
				realTime = "Problem Houston";
				break;
			}

			int xPos = 0;
			int yPos = 0;
			String timeText = realTime;

			if (player != null) {

				if ((MINECRAFT.isGameFocused() && !MINECRAFT.gameSettings.showDebugInfo)) {
					int width = MINECRAFT.mainWindow.getScaledWidth();
					int height = MINECRAFT.mainWindow.getScaledHeight();
					int xColor = 0;

					if (hour > 12)
						xColor = Color.RED.getRGB();
					else
						xColor = Color.GREEN.getRGB();

					GlStateManager.scalef(1, 1, 0);

					MINECRAFT.ingameGUI.drawString(MINECRAFT.fontRenderer, timeText, (int) (xPos + width - 120),
							(int) (yPos + height - 10), xColor);

					GlStateManager.scalef(1, 1, 1); // Reset scale

				}

			}
		}
	}

}
