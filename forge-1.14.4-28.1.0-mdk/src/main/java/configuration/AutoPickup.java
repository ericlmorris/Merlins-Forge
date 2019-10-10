package configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class AutoPickup {
	
    public static ForgeConfigSpec.ConfigValue<Boolean> PICK_UP;

    public static void init(ForgeConfigSpec.Builder SERVER_BUILDER, ForgeConfigSpec.Builder CLIENT_BUILDER) {
        CLIENT_BUILDER.comment("Automatic Drop Pickup");

        PICK_UP = CLIENT_BUILDER
                .comment("A value of true turns automatic pickup on, false turns pickup off")
                .define("pickup", true);

    }
}

