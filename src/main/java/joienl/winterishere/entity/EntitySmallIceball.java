package joienl.winterishere.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Objects;

public class EntitySmallIceball extends EntityIceball {
    public EntitySmallIceball(World worldIn) {
        super(worldIn);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntitySmallIceball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }

    public EntitySmallIceball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
        this.setSize(0.3125F, 0.3125F);
    }

    /**
     * Called when this EntityIceball hits a block or entity.
     */
    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.entityHit != null) {
                if (result.entityHit instanceof EntityLivingBase && !(result.entityHit instanceof EntityBlizzard)) {
                    boolean flag = result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.shootingEntity), 5.0F);

                    if (flag) {
                        this.applyEnchantments(this.shootingEntity, result.entityHit);
                        ((EntityLivingBase) result.entityHit).addPotionEffect(new PotionEffect(Objects.requireNonNull(Potion.getPotionById(2)), 200, 0, false, true));
                    }
                }
            }
            else {
                boolean flag1 = true;

                if (this.shootingEntity instanceof EntityLiving) {
                    flag1 = this.world.getGameRules().getBoolean("mobGriefing");
                }

                if (flag1) {
                    BlockPos pos = result.getBlockPos().offset(result.sideHit);

                    if (this.world.isAirBlock(pos) && this.world.canSnowAt(pos, false) && Blocks.SNOW_LAYER.canPlaceBlockAt(world, pos)) {
                        this.world.setBlockState(pos, Blocks.SNOW_LAYER.getDefaultState());
                    }
                }
            }

            this.setDead();
        }
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    @Override
    public boolean canBeCollidedWith() { return false; }

    /**
     * Called when the entity is attacked.
     */
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) { return false; }
}