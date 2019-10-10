package configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class SchematicPathConfiguration {
	
    public static ForgeConfigSpec.ConfigValue<String> SCHEMATIC_PATH;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        CLIENT_BUILDER.comment("Path to Schematic Files");

        SCHEMATIC_PATH = CLIENT_BUILDER
                .comment("Typically: C:/Users/<User Name>/AppData/Roaming/.minecraft/schematics/")
                .define("schematic path", "C:/");

    }
}
