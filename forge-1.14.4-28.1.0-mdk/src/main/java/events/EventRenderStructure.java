package events;

import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import merlinsforge.MerlinsForge;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID)
public class EventRenderStructure {

	public static boolean toggleXXEnabled = false;
	public static boolean showNoShow = false;

	public static int structureX;
	public static int structureY;
	public static int structureZ;
	public static int structureWidth;
	public static int structureLength;
	public static int structureHeight;

	public static int shiftNorthSouth = 0;
	public static int shiftEastWest = 0;
	public static int shiftUpDown = 0;

	public static int tickCount = 0;

	@SubscribeEvent
	public static void onTick(final RenderWorldLastEvent event) {
		
		if (toggleXXEnabled && showNoShow) {
			RenderStructure.render(event.getPartialTicks());
		}

	}
}
