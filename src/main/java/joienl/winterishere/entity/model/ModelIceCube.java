package joienl.winterishere.entity.model;

import joienl.winterishere.entity.EntityIceCube;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelIceCube extends ModelBase {
    private ModelRenderer[] segments = new ModelRenderer[8];
    private ModelRenderer core;

    public ModelIceCube() {
        for (int i = 0; i < this.segments.length; ++i) {
            int j = 0;
            int k = i;

            if (i == 2) {
                j = 24;
                k = 10;
            }
            else if (i == 3) {
                j = 24;
                k = 19;
            }

            this.segments[i] = new ModelRenderer(this, j, k);
            this.segments[i].addBox(-4.0F, (float)(16 + i), -4.0F, 8, 1, 8);
        }

        this.core = new ModelRenderer(this, 0, 16);
        this.core.addBox(-2.0F, 18.0F, -2.0F, 4, 4, 4);
    }

    @Override
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime) {
        EntityIceCube entityicecube = (EntityIceCube)entitylivingbaseIn;
        float f = entityicecube.prevSquishFactor + (entityicecube.squishFactor - entityicecube.prevSquishFactor) * partialTickTime;

        if (f < 0.0F) {
            f = 0.0F;
        }

        for (int i = 0; i < this.segments.length; ++i) {
            this.segments[i].rotationPointY = (float)(-(4 - i)) * f * 1.7F;
        }
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.core.render(scale);

        for (ModelRenderer modelrenderer : this.segments) {
            modelrenderer.render(scale);
        }
    }
}