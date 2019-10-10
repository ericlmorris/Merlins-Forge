package commands;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import events.EventPlayerTickLoad;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class CommandFindMineshaft {

	public static ITextComponent textComponent = null;

	public static String[] structures = { "mineshaft", "village", "shipwreck", "buried_treasure", "desert_pyramid",
			"stronghold", "fortress", "pillager_outpost" };

	static ArgumentBuilder<CommandSource, ?> register() {

		return Commands.literal("structure").then(Commands.argument("structure", StringArgumentType.word())
				.executes(context -> execute(context, StringArgumentType.getString(context, "structure"))));
	}

	private static int execute(final CommandContext<CommandSource> context, final String name)
			throws CommandSyntaxException {

		PlayerEntity player = EventPlayerTickLoad.thePlayer;

		boolean hit = false;
		for (int i = 0; i < structures.length; i++) {
			if (name.contains(structures[i])) {
				hit = true;
				break;
			}
		}
		if (!hit) {
			textComponent = new TranslationTextComponent("Unsupported request for " + name + " try another structure");
			textComponent.getStyle().setColor(TextFormatting.RED);
			player.sendMessage(textComponent);
			return 0;
		}

		BlockPos loc = findStructure(name);

		if (loc != null) {

			textComponent = new TranslationTextComponent(
					"Teleporting to " + name + " found at x/z " + loc.getX() + "/" + loc.getZ());
			textComponent.getStyle().setColor(TextFormatting.WHITE);
			player.sendMessage(textComponent);
			EventPlayerTickLoad.softLanding = true;
			EventPlayerTickLoad.thePlayer.setPositionAndUpdate(loc.getX(), (double) 99, loc.getZ());
		} else {
			textComponent = new TranslationTextComponent(name + " not found within 500 block radius");
			textComponent.getStyle().setColor(TextFormatting.RED);
			player.sendMessage(textComponent);
		}

		return 0;

	}

	public static BlockPos findStructure(String mineshaft) {

		PlayerEntity player = EventPlayerTickLoad.thePlayer;
		World world = EventPlayerTickLoad.tickWorld;

		final BlockPos pos = world.findNearestStructure(mineshaft, player.getPosition(), 500, false);

		return pos;

	}
}
