package joienl.winterishere.entity.render;

import joienl.winterishere.entity.EntityBlizzard;
import joienl.winterishere.entity.model.ModelBlizzard;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBlizzard extends RenderLiving<EntityBlizzard> {
    private static final ResourceLocation TEXTURES = new ResourceLocation("wih", "textures/entities/blizzard.png");

    RenderBlizzard(RenderManager renderManager) { super(renderManager, new ModelBlizzard(), 0.5F); }

    @Override
    protected ResourceLocation getEntityTexture(EntityBlizzard entity) { return TEXTURES; }
}