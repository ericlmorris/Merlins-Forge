package events;


import net.minecraftforge.client.event.InputEvent.KeyInputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.api.distmarker.Dist;

//@Mod.EventBusSubscriber(modid = MerlinsForge.MODID, bus = Bus.MOD)

@EventBusSubscriber(value = Dist.CLIENT, bus = Bus.FORGE)

public class EventTester {

	@SubscribeEvent
	public static void onKeyTyped(KeyInputEvent event) {
		
		int keyIn = event.getKey();
		//System.out.println(keyIn);
	}
}
