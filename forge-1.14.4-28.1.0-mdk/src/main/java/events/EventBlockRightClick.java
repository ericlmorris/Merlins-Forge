package events;

import merlinsforge.MerlinsForge;
import net.minecraft.block.BlockState;
import net.minecraft.block.StandingSignBlock;
import net.minecraft.block.WallSignBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)

public class EventBlockRightClick {

	private static final String[] IS_EDITABLE_FIELDS = {
			"field_145916_j",
			"isEditable",
	};
	
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event){
		
		
		if(event.getPlayer().isSneaking() && !isHoldingEditor(event.getPlayer())){
			
			BlockPos pos = event.getPos();
			BlockState state = event.getWorld().getBlockState(pos);
			
			if(state.getBlock() instanceof StandingSignBlock || state.getBlock() instanceof WallSignBlock){
				PlayerEntity player = event.getPlayer();
				TileEntity tileentity = event.getWorld().getTileEntity(pos);
				if(tileentity instanceof SignTileEntity){
					SignTileEntity sign = (SignTileEntity) tileentity;
					setSignEditable(sign);
					if(sign.getIsEditable()){
						sign.setPlayer(player);
						player.openSignEditor(sign);
					}else{
						player.sendMessage(new TranslationTextComponent("Can't edit sign."));
					}
				}
			}
		}
	}
	
	private static void setSignEditable(SignTileEntity sign){
		for(String field : IS_EDITABLE_FIELDS){
			try{
				ObfuscationReflectionHelper.setPrivateValue(SignTileEntity.class, sign, true, field);
				return;
			}
			catch(ObfuscationReflectionHelper.UnableToFindFieldException e){
				System.out.println("Failed to get field {}" + "/" + field);

			}
		}
		System.out.println("Couldn't set sign editable");

	}
	
	private static boolean isHoldingEditor(PlayerEntity player){
		for(ItemStack stack : player.getHeldEquipment()){
			if(stack.getItem() instanceof SignItem){
				return true;
			}
		}
		return false;
	}
}
