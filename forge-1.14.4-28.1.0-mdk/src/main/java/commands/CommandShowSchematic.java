package commands;

import java.io.File;
import java.io.IOException;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import configuration.SchematicPathConfiguration;
import events.EventPlayerTickLoad;
import events.EventRenderStructure;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import schematics.SchematicShow;

public class CommandShowSchematic {

	public static ITextComponent textComponent = null;

	static ArgumentBuilder<CommandSource, ?> register() {

		return Commands.literal("show").then(Commands.argument("schematic", StringArgumentType.word())
				.executes(context -> execute(context, StringArgumentType.getString(context, "schematic"))));
	}

	private static int execute(final CommandContext<CommandSource> context, final String name)
			throws CommandSyntaxException {
		
		PlayerEntity player = EventPlayerTickLoad.thePlayer;

		textComponent = new TranslationTextComponent("Hold Schematic Stick to show : " + name);
		textComponent.getStyle().setColor(TextFormatting.WHITE);
		player.sendMessage(textComponent);
		
		if (name.contains("clear")) {
			
			clearSchematic();

		} else {

			showSchematic(name);
		}

		return 0;
	}

	public static void showSchematic(String sName) {
		
		EventRenderStructure.toggleXXEnabled = true;
		String myFile = SchematicPathConfiguration.SCHEMATIC_PATH.get() + "schematics/" + sName + ".schematic";
		String passFile = sName;
		File fileName = new File(myFile);
		try {
			SchematicShow.showSchematic(passFile, fileName, "00", EventPlayerTickLoad.thePlayer,
					EventPlayerTickLoad.tickWorld);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void clearSchematic() {
		
		EventRenderStructure.toggleXXEnabled = false;

	}
}
