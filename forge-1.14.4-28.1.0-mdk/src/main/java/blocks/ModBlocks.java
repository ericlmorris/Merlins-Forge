
package blocks;

import java.util.HashSet;
import java.util.Set;

import merlinsforge.MerlinsForge;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import static utilities.InjectionUtility.Null;

@ObjectHolder(MerlinsForge.MODID)
public class ModBlocks {

	private static final Set<Block> MOD_BLOCKS = new HashSet<>();

	public static final SimpleBlock SIMPLE_BLOCK = Null();
	public static final RepairBlock REPAIR_BLOCK = Null();
	public static final SpawnBlock SPAWN_BLOCK = Null();
	public static final FishTrapBlock FISHTRAP_BLOCK = Null();

	@Mod.EventBusSubscriber(modid = MerlinsForge.MODID, bus = Bus.MOD)
	public static class RegistrationHandler {

		/*
		 * Register Blocks
		 */
		@SubscribeEvent
		public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {

			Block.Properties metal = Block.Properties.create(Material.IRON).hardnessAndResistance(2.5f, 6)
					.lightValue(15);
			Block.Properties rock = Block.Properties.create(Material.ROCK).hardnessAndResistance(2.5f, 6);

			registerBlock(new SimpleBlock(metal), "simpleblock", blockRegistryEvent.getRegistry());
			registerBlock(new RepairBlock(rock), "repairblock", blockRegistryEvent.getRegistry());
			registerBlock(new SpawnBlock(rock), "spawnerblock", blockRegistryEvent.getRegistry());
			registerBlock(new FishTrapBlock(rock), "fishtrapblock", blockRegistryEvent.getRegistry());
		}

		private static void registerBlock(Block block, String name, IForgeRegistry<Block> registry) {
			registry.register(block.setRegistryName(name));
			MOD_BLOCKS.add(block);
		}

		/*
		 * Register BlockItems
		 */
		@SubscribeEvent
		public static void onItemsRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) {
			IForgeRegistry<Item> registry = itemRegistryEvent.getRegistry();
			Item.Properties properties1 = new Item.Properties().group(MerlinsForge.ITEM_GROUP);
			for (Block block : MOD_BLOCKS) {
				registerItem(new BlockItem(block, properties1), block.getRegistryName().toString(), registry);
			}
		}

		private static void registerItem(Item item, String name, IForgeRegistry<Item> registry) {
			registry.register(item.setRegistryName(name));
		}

	}
}
