package configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClockDirection {
	
    public static ForgeConfigSpec.ConfigValue<Boolean> CLOCK_ON;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        CLIENT_BUILDER.comment("Direction/Clock Display");

        CLOCK_ON = CLIENT_BUILDER
                .comment("A value of true turns the clock on, false turns the clock off")
                .define("clock", true);

    }
}
