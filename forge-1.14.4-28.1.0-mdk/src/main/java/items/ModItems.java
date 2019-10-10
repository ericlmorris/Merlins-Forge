package items;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;
import merlinsforge.MerlinsForge;
import static utilities.InjectionUtility.Null;

import java.util.HashSet;
import java.util.Set;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@ObjectHolder(MerlinsForge.MODID)
public class ModItems {

	public static final ItemMerlinsArmor REPLACEMENT_HELMET = Null();
	public static final ItemMerlinsArmor REPLACEMENT_CHESTPLATE = Null();
	public static final ItemMerlinsArmor REPLACEMENT_LEGGINGS = Null();
	public static final ItemMerlinsArmor REPLACEMENT_BOOTS = Null();
	
	public static final ItemMerlinsGrenade MERLINS_GRENADE = Null();
	public static final ItemMerlinsBow MERLINS_BOW = Null();
	public static final ItemMerlinsBlockMarker BLOCK_MARKER = Null();
	public static final ItemMerlinsPickAxe MERLINS_PICKAXE = Null();
	public static final ItemMerlinsAxe MERLINS_AXE = Null();
	public static final ItemMerlinsTravelingStaff TRAVELING_STAFF = Null();
	public static final ItemMerlinsGold MERLINS_GOLD = Null();
	public static final ItemMerlinsDiamond MERLINS_DIAMOND = Null();
	public static final ItemMerlinsSword MERLINS_SWORD = Null();
	public static final ItemMerlinsBeefJerky MERLINS_FOOD = Null();
	public static final ItemMerlinsHarvestStaff HARVEST_STAFF = Null();
	public static final ItemMerlinsShovel MERLINS_SHOVEL = Null();
	public static final ItemMerlinsEnderChest SPAWNING_STICK = Null();
	public static final ItemSchematicStick SCHEMATIC_STICK = Null();
	public static final ItemMerlinsBeefJerky BEEF_JERKY = Null();
	public static final ItemShamanStick SHAMAN_STICK = Null();
	public static final ItemMerlinsCompass MERLINS_COMPASS = Null();
	
	@Mod.EventBusSubscriber(modid = MerlinsForge.MODID, bus = Bus.MOD)

	public static class RegistrationHandler {

		public static final Set<Item> ITEMS = new HashSet<>();

		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {

			final ItemMerlinsArmor replacementHelmet = new ItemMerlinsArmor(ModArmorMaterial.REPLACEMENT, EquipmentSlotType.HEAD, defaultItemProperties());
			final ItemMerlinsArmor replacementChestplate = new ItemMerlinsArmor(ModArmorMaterial.REPLACEMENT, EquipmentSlotType.CHEST, defaultItemProperties());
			final ItemMerlinsArmor replacementLeggings = new ItemMerlinsArmor(ModArmorMaterial.REPLACEMENT, EquipmentSlotType.LEGS, defaultItemProperties());
			final ItemMerlinsArmor replacementBoots = new ItemMerlinsArmor(ModArmorMaterial.REPLACEMENT, EquipmentSlotType.FEET, defaultItemProperties());
			
			// Capabilities are registered and injected in FMLCommonSetupEvent, which is
			// fired after RegistryEvent.Register.
			// This means that item constructors can't directly reference Capability fields
			// (e.g. CapabilityPigSpawner.PIG_SPAWNER_CAPABILITY).
			@SuppressWarnings("Convert2MethodRef")
			final Item[] items = {

					new ItemMerlinsGold(defaultItemProperties()).setRegistryName("merlinsgold"),
					new ItemMerlinsDiamond(defaultItemProperties()).setRegistryName("merlinsdiamond"),
					new ItemMerlinsSword(defaultItemProperties()).setRegistryName("merlinssword"),
					new ItemMerlinsGrenade(defaultItemProperties()).setRegistryName("merlinsgrenade"),
					new ItemMerlinsBow(defaultItemProperties()).setRegistryName("merlinsbow"),
					new ItemMerlinsBlockMarker(defaultItemProperties()).setRegistryName("merlinsblockmarker"),
					new ItemMerlinsPickAxe(defaultItemProperties()).setRegistryName("merlinspickaxe"),
					new ItemMerlinsAxe(defaultItemProperties()).setRegistryName("merlinsaxe"),
					new ItemMerlinsBeefJerky(defaultItemProperties()).setRegistryName("merlinsbeefjerky"),
					new ItemMerlinsTravelingStaff(defaultItemProperties()).setRegistryName("merlinstravelingstaff"),
					new ItemMerlinsHarvestStaff(defaultItemProperties()).setRegistryName("merlinsharveststaff"),
					new ItemMerlinsShovel(defaultItemProperties()).setRegistryName("merlinsshovel"),
					new ItemMerlinsEnderChest(defaultItemProperties()).setRegistryName("spawningstick"),
					new ItemSchematicStick(defaultItemProperties()).setRegistryName("schematicstick"),
					new ItemShamanStick(defaultItemProperties()).setRegistryName("shamanstick"),
					new ItemMerlinsCompass(defaultItemProperties()).setRegistryName("compass"),

					replacementHelmet.setRegistryName("merlinshelmet"),
					replacementChestplate.setRegistryName("merlinschestplate"),
					replacementLeggings.setRegistryName("merlinsleggings"),
					replacementBoots.setRegistryName("merlinsboots"),
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) {
				registry.register(item);
				ITEMS.add(item);
			}
		}

		/**
		 * Gets an {@link Item.Properties} instance with the {@link ItemGroup} set to
		 * {@link TestMod3#ITEM_GROUP}.
		 *
		 * @return The item properties
		 */
		private static Item.Properties defaultItemProperties() {
			return new Item.Properties().group(MerlinsForge.ITEM_GROUP);
		}
	}
}
