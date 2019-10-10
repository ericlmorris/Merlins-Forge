package configuration;

import java.nio.file.Path;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod.EventBusSubscriber
public class Configuration {

	private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
	private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

	public static final ForgeConfigSpec SERVER_CONFIG;
	public static final ForgeConfigSpec CLIENT_CONFIG;

	static {
		SchematicPathConfiguration.init(SERVER_BUILDER, CLIENT_BUILDER);
		ClockDirection.init(SERVER_BUILDER, CLIENT_BUILDER);
		AutoPickup.init(SERVER_BUILDER, CLIENT_BUILDER);

		SERVER_CONFIG = SERVER_BUILDER.build();
		CLIENT_CONFIG = CLIENT_BUILDER.build();
	}

	public static void loadConfig(ForgeConfigSpec spec, Path path) {

		final CommentedFileConfig configData = CommentedFileConfig.builder(path).sync().autosave()
				.writingMode(WritingMode.REPLACE).build();

		configData.load();
		spec.setConfig(configData);
	}

	@SubscribeEvent
	public static void onLoad(final ModConfig.Loading configEvent) {
	}

	@SubscribeEvent
	public static void onFileChange(final ModConfig.ConfigReloading configEvent) {
	}

}
