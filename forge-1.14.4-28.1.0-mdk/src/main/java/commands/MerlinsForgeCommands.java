package commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class MerlinsForgeCommands {
	
	public static void register(final CommandDispatcher<CommandSource> dispatcher) {
		
		dispatcher.register(Commands.literal("fillin").then(CommandFillSpace.register()));
		
		dispatcher.register(Commands.literal("find")
				.then(CommandFindBiome.register())
				.then(CommandFindMineshaft.register()));
	
		dispatcher.register(Commands.literal("sch")
				.then(CommandShowSchematic.register())
				.then(CommandLoadSchematic.register())
				.then(CommandListSchematic.register())
				.then(CommandUpgradeSchematic.register())
				.then(CommandSaveSchematic.register()));
	}
}
