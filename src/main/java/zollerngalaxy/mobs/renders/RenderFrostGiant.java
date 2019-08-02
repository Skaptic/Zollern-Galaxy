package zollerngalaxy.mobs.renders;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import zollerngalaxy.lib.ZGInfo;
import zollerngalaxy.mobs.entities.EntityFrostGiant;
import zollerngalaxy.mobs.models.ModelFrostGiant;

@SideOnly(Side.CLIENT)
public class RenderFrostGiant extends RenderLiving<EntityFrostGiant> {
	
	private ModelFrostGiant model;
	private static float f6 = 3.6F;
	
	public RenderFrostGiant(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelFrostGiant(), 0.5F);
	}
	
	@Override
	protected void preRenderCallback(EntityFrostGiant entitylivingbaseIn, float partialTickTime) {
		this.scaleFrostGiant(entitylivingbaseIn, partialTickTime);
	}
	
	protected void scaleFrostGiant(EntityFrostGiant par1EntityCaveSpider, float par2) {
		GL11.glScalef(f6, f6, f6);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(EntityFrostGiant entity) {
		return new ResourceLocation(ZGInfo.MOD_ID + ":textures/entity/frostgiant.png");
	}
	
}