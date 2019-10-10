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
import net.minecraft.world.biome.DarkForestBiome;
import net.minecraft.world.biome.DesertBiome;
import net.minecraft.world.biome.FlowerForestBiome;
import net.minecraft.world.biome.ForestBiome;
import net.minecraft.world.biome.MountainsBiome;
import net.minecraft.world.biome.OceanBiome;
import net.minecraft.world.biome.PlainsBiome;
import net.minecraft.world.biome.RiverBiome;
import net.minecraft.world.biome.SavannaBiome;
import net.minecraft.world.biome.TaigaBiome;
import net.minecraft.world.biome.TaigaHillsBiome;
import net.minecraft.world.biome.TaigaMountainsBiome;
import net.minecraft.world.biome.WoodedHillsBiome;
import net.minecraft.world.biome.WoodedMountainsBiome;

public class CommandFindBiome {

	public static ITextComponent textComponent = null;

	static ArgumentBuilder<CommandSource, ?> register() {

		return Commands.literal("biome").then(Commands.argument("biometype", StringArgumentType.word())
				.executes(context -> execute(context, StringArgumentType.getString(context, "biometype"))));
	}

	private static int execute(final CommandContext<CommandSource> context, final String name)
			throws CommandSyntaxException {

		findBiomes(name);
		return 0;

	}

	public static void findBiomes(String biometype) {

		PlayerEntity player = EventPlayerTickLoad.thePlayer;
		World world = EventPlayerTickLoad.tickWorld;

		long start = System.currentTimeMillis();
		int timeout = 10000;

		BlockPos pos = spiralOutwardsLookingForBiome(world, biometype, player.getPosition().getX(),
				player.getPosition().getZ(), timeout);

		if (pos == null) {
			textComponent = new TranslationTextComponent("Sorry, biome could not be found.");
			textComponent.getStyle().setColor(TextFormatting.RED);
			player.sendMessage(textComponent);
			return;
		}
		if (player instanceof PlayerEntity) {
			PlayerEntity playerMP = (PlayerEntity) player;
			EventPlayerTickLoad.softLanding = true;
			player.setPositionAndUpdate(pos.getX(), 110, pos.getZ());
			textComponent = new TranslationTextComponent("Transporting you to " + biometype + " biome.");
			textComponent.getStyle().setColor(TextFormatting.WHITE);
			player.sendMessage(textComponent);
		}
	}

	public static BlockPos spiralOutwardsLookingForBiome(World world, String biome, double startX, double startZ,
			int timeout) {
		double a = 16 / Math.sqrt(Math.PI);
		double b = 2 * Math.sqrt(Math.PI);
		double x;
		double z;
		double dist = 0;
		int n;
		long start = System.currentTimeMillis();
		for (n = 0; dist < Integer.MAX_VALUE; ++n) {
			if ((System.currentTimeMillis() - start) > 10000) {
				return null;
			}
			double rootN = Math.sqrt(n);
			dist = a * rootN;
			x = startX + (dist * Math.sin(b * rootN));
			z = startZ + (dist * Math.cos(b * rootN));

			if (world.getBiome(new BlockPos(x, 0, z)) instanceof MountainsBiome && biome.contains("mountains")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof ForestBiome && biome.contains("forest")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof OceanBiome && biome.contains("ocean")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof WoodedHillsBiome
							&& biome.contains("woodedhills")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof WoodedMountainsBiome
							&& biome.contains("woodedmountains")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof TaigaBiome && biome.contains("taiga")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof TaigaHillsBiome && biome.contains("taigahills")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof TaigaMountainsBiome
							&& biome.contains("taigamountains")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof DesertBiome && biome.contains("desert")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof SavannaBiome && biome.contains("savanna")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof PlainsBiome && biome.contains("plains")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof DarkForestBiome && biome.contains("darkforest")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof RiverBiome && biome.contains("river")
					|| world.getBiome(new BlockPos(x, 0, z)) instanceof FlowerForestBiome
							&& biome.contains("flowerforest")) {
				return new BlockPos((int) x, 0, (int) z);
			}
		}
		return null;

	}

}
