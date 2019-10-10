package commands;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import configuration.SchematicPathConfiguration;
import events.EventPlayerTickLoad;
import net.minecraft.block.Blocks;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class CommandListSchematic {

	public static ItemStack schematicItemStack;
	public static File thisFile;
	public static short width;
	public static short length;
	public static short height;
	public static String wLH;
	public static String fName;
	public static CompoundNBT tagThis;
	
	public static ITextComponent textComponent = null;


	static ArgumentBuilder<CommandSource, ?> register() {

		return Commands.literal("list").then(Commands.argument("searchstring", StringArgumentType.word())
				.executes(context -> execute(context, StringArgumentType.getString(context, "searchstring"))));
	}

	private static int execute(final CommandContext<CommandSource> context, String name)
			throws CommandSyntaxException {
		
		if (name.length() < 1) {
			name = "all";
		}

		textComponent = new TranslationTextComponent("List input: " + name);
		textComponent.getStyle().setColor(TextFormatting.WHITE);
		EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
		
		try {
			listSchematics(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	public static void listSchematics(String input) throws IOException {

		// get starting point (page) for the list

		String argName = input;
		int fileOffset = 0;
		
		//System.out.println(argName);

		if (Character.isLetter(input.charAt(0))) {
		} else {
			fileOffset = Integer.valueOf(input);
		}
		// get the complete list of files in an array
		
		String myFile = SchematicPathConfiguration.SCHEMATIC_PATH.get() + "schematics/";
		System.out.println(myFile);
		File fileList = new File(myFile);
		File[] listOfFiles = getFileList(fileList);	
		
		// output from list of files
		int lineCounter = 0;

		schematicItemStack = new ItemStack(Blocks.AIR);

		for (int k = fileOffset; k < listOfFiles.length; k++) {

			// pull file path + name from array
			thisFile = listOfFiles[k];

			// read the schematic from its file
			readSchematic(readTags(thisFile));

			// change data type to string
			StringBuilder sb = new StringBuilder();
			sb.append(thisFile);
			String kFile = sb.toString();
			// find last backslash
			int l = kFile.lastIndexOf("\\");
			//int m = kFile.lastIndexOf(".");
			// extract file name from string
			fName = kFile.substring(l + 1, (kFile.length() - 10));

			if (fName.contains(argName)) {

				textComponent = new TranslationTextComponent(fName + " -- " + wLH);
				textComponent.getStyle().setColor(TextFormatting.WHITE);
				EventPlayerTickLoad.thePlayer.sendMessage(textComponent);
			
				lineCounter++;
				if (lineCounter > 25)
					break;

			}

		}

	}

	public static File[] getFileList(File file) {

		if (file.isFile() && !file.isDirectory()) {
			return new File[] { file };
		}
		return file.listFiles() != null ? file.listFiles() : new File[0];
	}

	private static void readSchematic(CompoundNBT tag) throws IOException {

		tagThis = tag;

		// capture the width/height/length of the schematic
		width = tag.getShort("Width");
		height = tag.getShort("Height");
		length = tag.getShort("Length");

		wLH = "WLH=" + width + "/" + length + "/" + height;

	}

	public static CompoundNBT readTags(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		try {
			return CompressedStreamTools.readCompressed(fis);
		} finally {
			fis.close();
		}
	}
}
