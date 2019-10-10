package commands;

import java.io.File;
import java.io.IOException;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import configuration.SchematicPathConfiguration;
import events.EventPlayerTickLoad;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import schematics.StructureSave;

public class CommandSaveSchematic {
	
	public static String outputName;
	public static ITextComponent textComponent = null;
	
	static ArgumentBuilder<CommandSource, ?> register() {

		return Commands.literal("save").then(Commands.argument("schematic", StringArgumentType.word())
				.executes(context -> execute(context, StringArgumentType.getString(context, "schematic"))));
	}

	private static int execute(final CommandContext<CommandSource> context, final String name)
			throws CommandSyntaxException {

		textComponent = new TranslationTextComponent("Saving schematic: " + name);
		textComponent.getStyle().setColor(TextFormatting.WHITE);
		EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
		
		saveSchematic(name);

		return 0;
	}

	public static void saveSchematic(String name) {

		String myFile = SchematicPathConfiguration.SCHEMATIC_PATH.get() + "schematics/" + name + ".schematic";
		String passFile = name;
			
		File fileName = new File(myFile);
		try {
			//SchematicSave.saveSchematic(passFile, fileName, EventPlayerTickLoad.tickWorld);
			StructureSave.saveSchematic(passFile, fileName, EventPlayerTickLoad.tickWorld);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
