package blocks;

import items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.horse.TraderLlamaEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.villager.IVillagerType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SpawnBlock extends Block {

	public static EntityType type;

	public SpawnBlock(Properties properties) {
		super(properties);
	}

	public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn,
			BlockRayTraceResult hit) {

		final ItemStack heldItem = player.getHeldItem(handIn);

		if (worldIn.isRemote) {

			return true;

		} else {

			if (heldItem != null) {

				Item clickItem = heldItem.getItem();
				player.getHeldItem(handIn).shrink(1);

				type = EntityType.IRON_GOLEM;
				if (clickItem == Items.IRON_INGOT) {
					IronGolemEntity entitygolem = new IronGolemEntity(EntityType.IRON_GOLEM, worldIn);
					entitygolem.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 0.5D, 0.0F, 0.0F);
					worldIn.addEntity(entitygolem);
					return true;
				}

				if (clickItem == Items.ROTTEN_FLESH) {
					type = EntityType.VILLAGER;
					VillagerEntity entityvillager = new VillagerEntity(EntityType.VILLAGER, worldIn, IVillagerType.PLAINS);
					entityvillager.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 0.5D, 0.0F, 0.0F);

					entityvillager.setVillagerData(
							entityvillager.getVillagerData().withProfession(VillagerProfession.ARMORER));

					entityvillager.setInvulnerable(true);
					worldIn.addEntity(entityvillager);
					return true;
				}

				if (clickItem == Items.GOLD_INGOT) {
					type = EntityType.WANDERING_TRADER;
					WanderingTraderEntity entityvillager = new WanderingTraderEntity(EntityType.WANDERING_TRADER, worldIn);
					entityvillager.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 0.5D, 0.0F, 0.0F);
					worldIn.addEntity(entityvillager);
					type = EntityType.TRADER_LLAMA;
					TraderLlamaEntity entitytraveler = new TraderLlamaEntity(EntityType.TRADER_LLAMA, worldIn);
					entitytraveler.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 3.5D, 0.0F, 0.0F);
					worldIn.addEntity(entitytraveler);
					return true;
				}

				if (clickItem == Items.BEEF) {
					type = EntityType.COW;
					CowEntity entitycow = new CowEntity(type, worldIn);
					entitycow.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 0.5D, 0.0F, 0.0F);
					worldIn.addEntity(entitycow);
					return true;
				}

				if (clickItem == Items.PORKCHOP) {
					type = EntityType.PIG;
					PigEntity entitypig = new PigEntity(type, worldIn);
					entitypig.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 0.5D, 0.0F, 0.0F);
					worldIn.addEntity(entitypig);
					return true;
				}
				if (clickItem == Items.MUTTON) {
					type = EntityType.SHEEP;
					SheepEntity entitysheep = new SheepEntity(type, worldIn);
					entitysheep.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 0.5D, 0.0F, 0.0F);
					worldIn.addEntity(entitysheep);
					return true;
				}
				if (clickItem == Items.CHICKEN) {
					type = EntityType.CHICKEN;
					ChickenEntity entitychicken = new ChickenEntity(type, worldIn);
					entitychicken.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 0.5D, 0.0F, 0.0F);
					worldIn.addEntity(entitychicken);
					return true;
				}
				if (clickItem == Items.BONE) {
					type = EntityType.WOLF;
					WolfEntity entitywolf = new WolfEntity(type, worldIn);
					entitywolf.setLocationAndAngles((double) pos.getX() + 1.5D, (double) pos.getY() + 1.05D,
							(double) pos.getZ() + 0.5D, 0.0F, 0.0F);
					worldIn.addEntity(entitywolf);
					return true;
				}
			}
		}

		return true;

	}
}
