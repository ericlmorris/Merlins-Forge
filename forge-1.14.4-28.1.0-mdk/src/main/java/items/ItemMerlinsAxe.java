package items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Nonnull;

import com.google.common.collect.Sets;
import com.google.common.collect.ImmutableMap.Builder;

import merlinsforge.MerlinsForge;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemMerlinsAxe extends ToolItem {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.OAK_PLANKS, Blocks.SPRUCE_PLANKS,
			Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS, Blocks.BOOKSHELF,
			Blocks.OAK_WOOD, Blocks.SPRUCE_WOOD, Blocks.BIRCH_WOOD, Blocks.JUNGLE_WOOD, Blocks.ACACIA_WOOD,
			Blocks.DARK_OAK_WOOD, Blocks.OAK_LOG, Blocks.SPRUCE_LOG, Blocks.BIRCH_LOG, Blocks.JUNGLE_LOG,
			Blocks.ACACIA_LOG, Blocks.DARK_OAK_LOG, Blocks.CHEST, Blocks.PUMPKIN, Blocks.CARVED_PUMPKIN,
			Blocks.JACK_O_LANTERN, Blocks.MELON, Blocks.LADDER, Blocks.OAK_BUTTON, Blocks.SPRUCE_BUTTON,
			Blocks.BIRCH_BUTTON, Blocks.JUNGLE_BUTTON, Blocks.DARK_OAK_BUTTON, Blocks.ACACIA_BUTTON,
			Blocks.OAK_PRESSURE_PLATE, Blocks.SPRUCE_PRESSURE_PLATE, Blocks.BIRCH_PRESSURE_PLATE,
			Blocks.JUNGLE_PRESSURE_PLATE, Blocks.DARK_OAK_PRESSURE_PLATE, Blocks.ACACIA_PRESSURE_PLATE);
	protected static final Map<Block, Block> BLOCK_STRIPPING_MAP = (new Builder<Block, Block>())
			.put(Blocks.OAK_WOOD, Blocks.STRIPPED_OAK_WOOD).put(Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG)
			.put(Blocks.DARK_OAK_WOOD, Blocks.STRIPPED_DARK_OAK_WOOD)
			.put(Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG).put(Blocks.ACACIA_WOOD, Blocks.STRIPPED_ACACIA_WOOD)
			.put(Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG).put(Blocks.BIRCH_WOOD, Blocks.STRIPPED_BIRCH_WOOD)
			.put(Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG).put(Blocks.JUNGLE_WOOD, Blocks.STRIPPED_JUNGLE_WOOD)
			.put(Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG).put(Blocks.SPRUCE_WOOD, Blocks.STRIPPED_SPRUCE_WOOD)
			.put(Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG).build();
	public static int attackdamage = 5;
	public static int attackspeed = -5;
	public static AxisAlignedBB aabb;
	public static int PICKUP_RADIUS = 10;

	protected ItemMerlinsAxe(Item.Properties builder) {
		super(attackdamage, attackspeed, ItemTier.DIAMOND, EFFECTIVE_ON,
				builder.addToolType(net.minecraftforge.common.ToolType.AXE, ItemTier.DIAMOND.getHarvestLevel()));
		builder.group(MerlinsForge.ITEM_GROUP);

	}

	public float getDestroySpeed(ItemStack stack, BlockState state) {
		Material material = state.getMaterial();
		return material != Material.WOOD && material != Material.PLANTS && material != Material.LEAVES
				? super.getDestroySpeed(stack, state)
				: this.efficiency;
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
		ItemStack stack = player.getHeldItem(hand);

		if (!world.isRemote) {

			int playerY = (int) player.posY;
			
			// player near surface

			if (playerY > 60) {

				if (player.isSneaking()) {

					Block block;

					List<BlockPos> poslist = new ArrayList<BlockPos>();

					for (int x = -4; x <= 4; x++) {
						for (int y = 0; y <= 20; y++) {
							for (int z = -4; z <= 4; z++) {
								BlockPos pos = player.getPosition().add(x, y, z);
								block = world.getBlockState(pos).getBlock();
								if (block instanceof LeavesBlock || block instanceof LogBlock
								// if (block instanceof BlockLog
										|| block == Blocks.BROWN_MUSHROOM_BLOCK || block == Blocks.RED_MUSHROOM_BLOCK) {
									poslist.add(player.getPosition().add(x, y, z));
								}
							}
						}
					}

					if (!poslist.isEmpty()) {
						for (int i = 0; i <= poslist.size() - 1; i++) {

							BlockPos targetpos = poslist.get(i);
							block = world.getBlockState(targetpos).getBlock();

							if (block instanceof LogBlock || block == Blocks.BROWN_MUSHROOM_BLOCK
									|| block == Blocks.RED_MUSHROOM_BLOCK) {
								world.destroyBlock(targetpos, true);
							}

							if (block instanceof LeavesBlock) {

								if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {

									ItemStack leafstack = new ItemStack(block, 1);
									Block.spawnAsEntity(world, targetpos, leafstack);
									world.destroyBlock(targetpos, true);

								} else {
									world.destroyBlock(targetpos, true);

								}
							}

						}
					}
				} else {
					
					// pick up loose items
					
					aabb = new AxisAlignedBB(player.posX - PICKUP_RADIUS, player.posY - PICKUP_RADIUS,
							player.posZ - PICKUP_RADIUS, player.posX + PICKUP_RADIUS, player.posY + PICKUP_RADIUS,
							player.posZ + PICKUP_RADIUS);
					List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, aabb);

					for (ItemEntity item : items) {

						boolean value = player.inventory.addItemStackToInventory(item.getItem());
					}
				}
			}

			else {
				// player in mine
						
				// Setting everything to air
				int range = 3;

				for (int x = -range; x < range + 1; x++) {

					for (int z = -range; z < range + 1; z++) {

						for (int y = 0; y < range + 2; y++) {

							int theX = (int) player.posX + x;
							int theY = (int) player.posY + y;
							int theZ = (int) player.posZ + z;

							BlockPos pos = new BlockPos(theX, theY, theZ);
							Block block = world.getBlockState(pos).getBlock();

							// Remove Water
							if (block == Blocks.WATER) {
								world.destroyBlock(pos, false);
							}
							// Remove Lava
							else if (block == Blocks.LAVA) {
								world.destroyBlock(pos, false);
							}
							// Remove Webs
							else if ((block == Blocks.COBWEB)) {
								world.destroyBlock(pos, true);
							}
							// Remove gravel
							else if ((block == Blocks.GRAVEL)) {
								world.destroyBlock(pos, true);
							}
							// Remove Mine Bracing
							else if ((block == Blocks.OAK_PLANKS || block == Blocks.OAK_FENCE)) {
								world.destroyBlock(pos, true);
							}
							// Remove Rails
							else if ((block == Blocks.RAIL)) {
								world.destroyBlock(pos, true);

							}
						}
					}
				}
				// pick up loose items
				
				aabb = new AxisAlignedBB(player.posX - PICKUP_RADIUS, player.posY - PICKUP_RADIUS,
						player.posZ - PICKUP_RADIUS, player.posX + PICKUP_RADIUS, player.posY + PICKUP_RADIUS,
						player.posZ + PICKUP_RADIUS);
				List<ItemEntity> items = world.getEntitiesWithinAABB(ItemEntity.class, aabb);

				for (ItemEntity item : items) {

					boolean value = player.inventory.addItemStackToInventory(item.getItem());
				}
				
				
			}
			return new ActionResult<>(ActionResultType.SUCCESS, stack);
		}

		player.swingArm(hand);

		return new ActionResult<>(ActionResultType.FAIL, stack);
	}

	@Override
	public boolean hitEntity(final ItemStack stack, final LivingEntity target, @Nonnull final LivingEntity attacker) {

		if (attacker instanceof PlayerEntity && target instanceof LivingEntity) {
			target.attackEntityFrom(DamageSource.GENERIC, 25);
			target.setFire(5);
		}

		return super.hitEntity(stack, target, attacker);
	}

	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos,
			LivingEntity entityLiving) {

		if (entityLiving instanceof PlayerEntity) {

			PlayerEntity thisPlayer = (PlayerEntity) entityLiving;
			aabb = new AxisAlignedBB(thisPlayer.posX - PICKUP_RADIUS, thisPlayer.posY - PICKUP_RADIUS,
					thisPlayer.posZ - PICKUP_RADIUS, thisPlayer.posX + PICKUP_RADIUS, thisPlayer.posY + PICKUP_RADIUS,
					thisPlayer.posZ + PICKUP_RADIUS);
			List<ItemEntity> items = worldIn.getEntitiesWithinAABB(ItemEntity.class, aabb);

			for (ItemEntity item : items) {
				boolean value = thisPlayer.inventory.addItemStackToInventory(item.getItem());
			}
		}

		return true;

	}
}
