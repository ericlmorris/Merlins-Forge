package events;

import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import schematics.SchematicShow;

public class RenderStructure {

	public static final Minecraft MINECRAFT = Minecraft.getInstance();

	public static int xArray[];
	public static int yArray[];
	public static int zArray[];
	public static int airArray[];
	public static int arrayIndex;
	
	public static int startX;
	public static int startY;
	public static int startZ;
	public static int endX;
	public static int endY;
	public static int endZ;
	

	// white, dark purple, maroon, olive drab, yellow, light blue, fuchia,
	// orange, dark gray,
	// turquoise, lt purple, dk blue,
	// dk gold, dkgreen, red, black

	private static final int[] BLOCK_COLOR = new int[] { 0xffffff, 0x660066, 0x999900, 0x666600, 0xffff00, 0xc0c9ed,
			0xff69b4, 0xff8000, 0x606060, 0x00ffff, 0xEE82EE, 0x0000ff, 0xCC6600, 0x008000, 0xff0000, 0x000000 };

	public static void initialize(int endArray) {

		xArray = new int[100000];
		yArray = new int[100000];
		zArray = new int[100000];
		airArray = new int[100000];

		for (int xRay = 0; xRay < endArray + 1; xRay++) {

			xArray[xRay] = 0;
			yArray[xRay] = 0;
			zArray[xRay] = 0;
			airArray[xRay] = 0;

		}

		RenderStructure.arrayIndex = 1;
	}

	public static void render(float partialTicks) {

		// remote world
		final World mcWorld = MINECRAFT.world;

		for (int x = 1; x < arrayIndex; x++) {

			BlockPos blockpos = new BlockPos(xArray[x], yArray[x], zArray[x]);
			BlockState iblockstate = SchematicShow.thisWorld.getBlockState(blockpos);
			
			// airArray[x]);

			PlayerEntity player = SchematicShow.player;
			int color = BLOCK_COLOR[airArray[x]];
			float red = ((color >> 16) & 0xff) / 255f;
			float green = ((color >> 8) & 0xff) / 255f;
			float blue = ((color) & 0xff) / 255f;
			float alpha = 1.0f;

			GlStateManager.pushMatrix();
			GlStateManager.enableBlend();
			GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA,
					GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
			GlStateManager.disableDepthTest();
			GlStateManager.lineWidth(3.0F);
			GlStateManager.disableTexture();
			GlStateManager.depthMask(false);
			GlStateManager.matrixMode(5889);
			GlStateManager.scalef(1.0F, 1.0F, 0.999F);
			double d0 = player.lastTickPosX + (player.posX - player.lastTickPosX) * (double) partialTicks;
			double d1 = player.lastTickPosY + (player.posY - player.lastTickPosY) * (double) partialTicks;
			double d2 = player.lastTickPosZ + (player.posZ - player.lastTickPosZ) * (double) partialTicks;
			
			WorldRenderer.drawShape(iblockstate.getShape(mcWorld, blockpos), (double) blockpos.getX() - d0, (double) blockpos.getY() - d1, (double) blockpos.getZ() - d2, red, green, blue, alpha);
		
			GlStateManager.matrixMode(5888);
			GlStateManager.depthMask(true);
			GlStateManager.enableDepthTest();
			GlStateManager.enableTexture();
			GlStateManager.disableBlend();
			GlStateManager.popMatrix();

		}

	}

}
