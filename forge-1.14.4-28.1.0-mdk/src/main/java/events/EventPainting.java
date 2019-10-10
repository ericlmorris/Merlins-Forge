package events;

import net.minecraft.util.math.BlockPos;

import java.util.ArrayList;
import java.util.List;

import merlinsforge.MerlinsForge;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MerlinsForge.MODID)
public class EventPainting
{
    @SubscribeEvent
    public void onClick(final PlayerInteractEvent.EntityInteract entityInteract) {
    	
    	System.out.println("hit");
    	
    	// server world
        final World world2 = entityInteract.getWorld();
        if (world2.isRemote) {
            return;
        }
        // is player holding a painting
        final ItemStack itemStack3 = entityInteract.getItemStack();
        System.out.println(itemStack3);
        if (!itemStack3.getItem().equals(Items.PAINTING)) {
            return;
        }
        
        // is player interacting with a painting
        final Entity entity4 = entityInteract.getTarget();
        System.out.println(entity4);
        if (!(entity4 instanceof PaintingEntity)) {
            return;
        }
        
        // get the target painting
        final PaintingEntity entityPainting5 = (PaintingEntity)entity4;
        // get type of painting
        final PaintingType enumArt6 = entityPainting5.art;
        // place for possible replacement
        PaintingType enumArt7 = null;
        
        
        System.out.println(entityPainting5 + "/" + enumArt6);
        
        final List<PaintingType> list8 = getSimilarArt(enumArt6);
        if (list8.get(list8.size() - 1).equals(enumArt6)) {
            enumArt7 = list8.get(0);
        }
        else {
            Boolean boolean9 = false;
            for (final PaintingType enumArt8 : list8) {
                if (boolean9) {
                    enumArt7 = enumArt8;
                    break;
                }
                if (!enumArt8.equals(enumArt6)) {
                    continue;
                }
                boolean9 = true;
            }
        }
        // is there a similar size painting
        if (enumArt7 == null) {
            return;
        }
        
        System.out.println("hit");
        final BlockPos blockPos9 = entityPainting5.getPosition();
        final PaintingEntity entityPainting6 = new PaintingEntity(world2, blockPos9.down(1), entityPainting5.getAdjustedHorizontalFacing());
        entityPainting6.art = enumArt7;
        //world2.getSimilarArt((Entity)entityPainting6);

        world2.addEntity((Entity)entityPainting6);
    }
    
    public static List<PaintingType> getSimilarArt(final PaintingType enumArt) {
    	
        final List<PaintingType> list2 = new ArrayList<PaintingType>();
        final int integer3 = enumArt.getWidth();
        final int integer4 = enumArt.getHeight();
        for (final PaintingType enumArt2 : list2) {
            if (enumArt2.getWidth() == integer3 && enumArt2.getHeight() == integer4) {
                list2.add(enumArt2);
            }
        }
        return list2;
    }
}
