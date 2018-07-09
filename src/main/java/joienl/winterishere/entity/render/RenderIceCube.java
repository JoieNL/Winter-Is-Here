package joienl.winterishere.entity.render;

import joienl.winterishere.entity.EntityIceCube;
import joienl.winterishere.entity.model.ModelIceCube;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderIceCube extends RenderLiving<EntityIceCube> {
    private static final ResourceLocation ICE_CUBE_TEXTURES = new ResourceLocation("wih","textures/entities/ice_cube.png");

    RenderIceCube(RenderManager renderManager) {
        super(renderManager, new ModelIceCube(), 0.25F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityIceCube entity) { return ICE_CUBE_TEXTURES; }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    @Override
    protected void preRenderCallback(EntityIceCube entityIceCube, float partialTickTime) {
        int i = entityIceCube.getSlimeSize();
        float f = (entityIceCube.prevSquishFactor + (entityIceCube.squishFactor - entityIceCube.prevSquishFactor) * partialTickTime) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        GlStateManager.scale(f1 * (float)i, 1.0F / f1 * (float)i, f1 * (float)i);
    }
}