package joienl.winterishere.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBlizzard extends ModelBase {
    /** The sticks that fly around the Blizzard. */
    private final ModelRenderer[] blizzardSticks = new ModelRenderer[12];
    private final ModelRenderer blizzardHead;

    public ModelBlizzard() {
        for (int i = 0; i < this.blizzardSticks.length; ++i) {
            this.blizzardSticks[i] = new ModelRenderer(this, 0, 16);
            this.blizzardSticks[i].addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
        }

        this.blizzardHead = new ModelRenderer(this, 0, 0);
        this.blizzardHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.blizzardHead.render(scale);

        for (ModelRenderer modelrenderer : this.blizzardSticks) {
            modelrenderer.render(scale);
        }
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        float f = ageInTicks * (float)Math.PI * -0.1F;

        for (int i = 0; i < 4; ++i) {
            this.blizzardSticks[i].rotationPointY = -2.0F + MathHelper.cos(((float)(i * 2) + ageInTicks) * 0.25F);
            this.blizzardSticks[i].rotationPointX = MathHelper.cos(f) * 9.0F;
            this.blizzardSticks[i].rotationPointZ = MathHelper.sin(f) * 9.0F;
            ++f;
        }

        f = ((float)Math.PI / 4F) + ageInTicks * (float)Math.PI * 0.03F;

        for (int j = 4; j < 8; ++j) {
            this.blizzardSticks[j].rotationPointY = 2.0F + MathHelper.cos(((float)(j * 2) + ageInTicks) * 0.25F);
            this.blizzardSticks[j].rotationPointX = MathHelper.cos(f) * 7.0F;
            this.blizzardSticks[j].rotationPointZ = MathHelper.sin(f) * 7.0F;
            ++f;
        }

        f = 0.47123894F + ageInTicks * (float)Math.PI * -0.05F;

        for (int k = 8; k < 12; ++k) {
            this.blizzardSticks[k].rotationPointY = 11.0F + MathHelper.cos(((float)k * 1.5F + ageInTicks) * 0.5F);
            this.blizzardSticks[k].rotationPointX = MathHelper.cos(f) * 5.0F;
            this.blizzardSticks[k].rotationPointZ = MathHelper.sin(f) * 5.0F;
            ++f;
        }

        this.blizzardHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.blizzardHead.rotateAngleX = headPitch * 0.017453292F;
    }
}