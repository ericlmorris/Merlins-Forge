package events;

import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.eventbus.api.SubscribeEvent;



public class EventBiomes {

	@SubscribeEvent
	public static void registerBiomes() {
		
		BiomeManager.removeBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes.SWAMP, 100));
		BiomeManager.removeBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes.SWAMP_HILLS, 100));
		BiomeManager.removeBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes.MUSHROOM_FIELDS, 100));
		BiomeManager.removeBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes.MUSHROOM_FIELD_SHORE, 100));
		BiomeManager.removeBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes.BAMBOO_JUNGLE, 100));
		BiomeManager.removeBiome(BiomeType.WARM, new BiomeManager.BiomeEntry(Biomes.BAMBOO_JUNGLE_HILLS, 100));
		BiomeManager.removeBiome(BiomeType.ICY, new BiomeManager.BiomeEntry(Biomes.ICE_SPIKES, 100));
		BiomeManager.removeBiome(BiomeType.ICY, new BiomeManager.BiomeEntry(Biomes.SNOWY_TUNDRA, 100));
	}

}
