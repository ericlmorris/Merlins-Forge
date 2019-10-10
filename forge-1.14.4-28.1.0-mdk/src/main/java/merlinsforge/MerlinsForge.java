package merlinsforge;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import configuration.Configuration;
import events.EventBiomes;
import events.EventPainting;
import net.minecraftforge.fml.config.ModConfig;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file for src and bin
@Mod(MerlinsForge.MODID)
public class MerlinsForge {

	// Directly reference a log4j logger.
	private static final Logger LOGGER = LogManager.getLogger();

	// the MODID and NAME of the mod
	public static final String MODID = "merlinsforge";
	public static final String NAME = "MerlinsForge";
	
	public static final ItemGroupMerlinsForge ITEM_GROUP = new ItemGroupMerlinsForge();

	/*
	 * The method below registers listeners for the methods immediately following
	 * There appears to be no need to change this
	 */

	public MerlinsForge() {
		// Register the setup method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		// Register the enqueueIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
		// Register the processIMC method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
		// Register the doClientStuff method for modloading
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::loadComplete);

		// Register ourselves for server and other game events we are interested in
		MinecraftForge.EVENT_BUS.register(this);

		// Register Configuration
		ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CLIENT_CONFIG);
		ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Configuration.SERVER_CONFIG);

		// Load Configuration Data
		Configuration.loadConfig(Configuration.CLIENT_CONFIG,
				FMLPaths.CONFIGDIR.get().resolve("merlinsforge-client.toml"));
		Configuration.loadConfig(Configuration.SERVER_CONFIG,
				FMLPaths.CONFIGDIR.get().resolve("merlinsforge-server.toml"));

	}

	/*
	 * Like the old preinit event
	 */
	private void setup(final FMLCommonSetupEvent event) {
		// some preinit code
		LOGGER.info("HELLO FROM PREINIT");
		
        MinecraftForge.EVENT_BUS.register(new EventPainting());

	}

	/*
	 * Like the old Client Proxy
	 */
	private void doClientStuff(final FMLClientSetupEvent event) {
		// do something that can only be done on the client
		LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
	}

    private void loadComplete(final FMLLoadCompleteEvent event) // PostRegistrationEven
    {
		LOGGER.info("HELLO FROM BIOME");

    	EventBiomes.registerBiomes();
    }
	
	
	/*
	 * Send information to another mod
	 */
	private void enqueueIMC(final InterModEnqueueEvent event) {
		// some example code to dispatch IMC to another mod
		InterModComms.sendTo("merlinsforge", "helloworld", () -> {
			LOGGER.info("Hello world from the MDK");
			return "Hello world";
		});
	}

	/*
	 * Receive information from another mod
	 */
	private void processIMC(final InterModProcessEvent event) {
		// some example code to receive and process InterModComms from other mods
		LOGGER.info("Got IMC {}",
				event.getIMCStream().map(m -> m.getMessageSupplier().get()).collect(Collectors.toList()));
	}

	/*
	 * You can use SubscribeEvent and let the Event Bus discover methods to call
	 */

	@SubscribeEvent
	public void onServerStarting(FMLServerStartingEvent event) {
		// do something when the server starts
		LOGGER.info("HELLO from server starting");
	}
	
}
