package blocks;

import merlinsforge.MerlinsForge;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;


@Mod.EventBusSubscriber(modid = MerlinsForge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FurnaceBlock {

    /* used to register blocks and items */

    // list of all blocks and their registry name

    @ObjectHolder(MerlinsForge.MODID + ":basic_furnace")
    public static BasicFurnaceBlock BASIC_FURNACE = null;

    public static TileEntityType<BasicFurnaceTileEntity> BASIC_FURNACE_TE = null;

    public static AbstractFurnaceBlock[] blocks = {BASIC_FURNACE};


    @SubscribeEvent
    public static void registerBlock(RegistryEvent.Register<Block> registryEvent) {

        Block.Properties properties = Block.Properties.from(Blocks.FURNACE);

        BASIC_FURNACE = new BasicFurnaceBlock(properties);
        BASIC_FURNACE.setRegistryName("basic_furnace");

        registryEvent.getRegistry().registerAll(BASIC_FURNACE);

    }


    @SubscribeEvent
    public static void registerBlockItem(RegistryEvent.Register<Item> registryEvent) {

        Item.Properties properties = new Item.Properties().group(MerlinsForge.ITEM_GROUP);

        registryEvent.getRegistry().register(new BlockItem(BASIC_FURNACE, properties).setRegistryName(BASIC_FURNACE.getRegistryName()));

 

    }

    @SubscribeEvent
    public static void registerTileEntity(RegistryEvent.Register<TileEntityType<?>> registryEvent) {

        BASIC_FURNACE_TE = TileEntityType.Builder.create(BasicFurnaceTileEntity::new, BASIC_FURNACE).build(null);
        BASIC_FURNACE_TE.setRegistryName(MerlinsForge.MODID, "myte");

        registryEvent.getRegistry().registerAll(BASIC_FURNACE_TE);

    }


}

