package events;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RenderOres {
	
	public final World world;
	public final BlockPos pos;
	public final PlayerEntity player;
	public final int color;

	static float red;
	static float green;
	static float blue;
	static float alpha;

	public RenderOres(World world, PlayerEntity player, BlockPos pos, int color) {
		
		this.world = EventRenderOres.world;
		this.player = EventRenderOres.player;
		this.pos = pos;
		this.color = color;
	}

	public void render(float partialTicks) {
			
		BlockPos blockpos = pos;
		BlockState iblockstate = this.world.getBlockState(blockpos);
		red = ((color >> 16) & 0xff) / 255f;
		green = ((color >> 8) & 0xff) / 255f;
		blue = ((color) & 0xff) / 255f;
		alpha = 1.0f;
		
		GlStateManager.pushMatrix();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		GlStateManager.disableDepthTest();		
		GlStateManager.lineWidth(3.0F);
		GlStateManager.disableTexture();
		GlStateManager.depthMask(false);
		GlStateManager.matrixMode(5889);
		GlStateManager.scalef(1.0F, 1.0F, 0.999F);
		double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double) partialTicks;
		double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double) partialTicks;
		double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double) partialTicks;
		WorldRenderer.drawShape(iblockstate.getShape(this.world, blockpos), (double) blockpos.getX() - d0,
				(double) blockpos.getY() - d1, (double) blockpos.getZ() - d2, red, green, blue, 1.0F);
		GlStateManager.matrixMode(5888);
		GlStateManager.depthMask(true);
		GlStateManager.enableDepthTest();
		GlStateManager.enableTexture();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();

	}

}
