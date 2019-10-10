package commands;

import merlinsforge.MerlinsForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID)
public class ModCommands {

	/**
	 * Register the commands and command arguments.
	 *
	 * @param event
	 *            The server starting event
	 */
	@SubscribeEvent
	public static void registerCommands(final FMLServerStartingEvent event) {
		
		MerlinsForgeCommands.register(event.getCommandDispatcher());
	}
}
