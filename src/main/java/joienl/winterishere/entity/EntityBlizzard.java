package joienl.winterishere.entity;

import joienl.winterishere.util.ModLootTables;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class EntityBlizzard extends EntityMob {
    /** Random offset used in floating behaviour */
    private float heightOffset = 0.5F;
    /** ticks until heightOffset is randomized */
    private int heightOffsetUpdateTime;
    private static final DataParameter<Byte> ON_FIRE = EntityDataManager.createKey(EntityBlizzard.class, DataSerializers.BYTE);

    public EntityBlizzard(World world) {
        super(world);
        this.setPathPriority(PathNodeType.WATER, -1.0F);
        this.setPathPriority(PathNodeType.LAVA, 8.0F);
        this.setPathPriority(PathNodeType.DANGER_FIRE, 0.0F);
        this.setPathPriority(PathNodeType.DAMAGE_FIRE, 0.0F);
        this.isImmuneToFire = false;
        this.experienceValue = 10;
    }

    public static void registerFixesBlizzard(DataFixer fixer) {
        EntityLiving.registerFixesMob(fixer, EntityBlizzard.class);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(4, new EntityBlizzard.AIFireballAttack(this));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.23000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48.0D);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(ON_FIRE, (byte) 0);
    }

    @Override
    protected SoundEvent getAmbientSound() { return SoundEvents.ENTITY_BLAZE_AMBIENT; }

    @Override
    protected SoundEvent getHurtSound(DamageSource p_184601_1_) { return SoundEvents.ENTITY_BLAZE_HURT; }

    @Override
    protected SoundEvent getDeathSound() { return SoundEvents.ENTITY_BLAZE_DEATH; }

    @Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender() { return 15728880; }

    /**
     * Gets how bright this entity is.
     */
    @Override
    public float getBrightness() { return 1.0F; }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    @Override
    public void onLivingUpdate() {
        if (!this.onGround && this.motionY < 0.0D) {
            this.motionY *= 0.6D;
        }

        if (this.world.isRemote) {
            if (this.rand.nextInt(24) == 0 && !this.isSilent()) {
                this.world.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, SoundEvents.ENTITY_BLAZE_BURN, this.getSoundCategory(), 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
            }

            for (int i = 0; i < 2; ++i) {
                this.world.spawnParticle(EnumParticleTypes.SNOW_SHOVEL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
            }
        }

        super.onLivingUpdate();
    }

    @Override
    protected void updateAITasks() {
        --this.heightOffsetUpdateTime;

        if (this.heightOffsetUpdateTime <= 0) {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
        }

        EntityLivingBase entitylivingbase = this.getAttackTarget();

        if (entitylivingbase != null && entitylivingbase.posY + (double)entitylivingbase.getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset) {
            this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
            this.isAirBorne = true;
        }

        super.updateAITasks();
    }

    @Override
    public void fall(float distance, float damageMultiplier) { }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() { return ModLootTables.BLIZZARD; }

    private void setOnFire(boolean onFire) {
        byte aByte = this.dataManager.get(ON_FIRE);

        if (onFire) {
            aByte = (byte)(aByte | 1);
        }
        else {
            aByte = (byte)(aByte & -2);
        }

        this.dataManager.set(ON_FIRE, aByte);
    }

    /**
     * Checks to make sure the light is not too bright where the mob is spawning
     */
    @Override
    protected boolean isValidLightLevel() { return true; }

    static class AIFireballAttack extends EntityAIBase {
        private final EntityBlizzard blizzard;
        private int attackStep;
        private int attackTime;

        AIFireballAttack(EntityBlizzard blizzardIn) {
            this.blizzard = blizzardIn;
            this.setMutexBits(3);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        @Override
        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.blizzard.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        @Override
        public void startExecuting() {
            this.attackStep = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        @Override
        public void resetTask() {
            this.blizzard.setOnFire(false);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        @Override
        public void updateTask() {
            --this.attackTime;
            EntityLivingBase entitylivingbase = this.blizzard.getAttackTarget();
            double d0 = this.blizzard.getDistanceSqToEntity(entitylivingbase);

            if (d0 < 4.0D) {
                if (this.attackTime <= 0) {
                    this.attackTime = 20;
                    this.blizzard.attackEntityAsMob(entitylivingbase);
                }

                this.blizzard.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
            }
            else if (d0 < this.getFollowDistance() * this.getFollowDistance()) {
                double d1 = entitylivingbase.posX - this.blizzard.posX;
                double d2 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (this.blizzard.posY + (double)(this.blizzard.height / 2.0F));
                double d3 = entitylivingbase.posZ - this.blizzard.posZ;

                if (this.attackTime <= 0) {
                    ++this.attackStep;

                    if (this.attackStep == 1) {
                        this.attackTime = 60;
                        this.blizzard.setOnFire(true);
                    }
                    else if (this.attackStep <= 4) {
                        this.attackTime = 6;
                    }
                    else {
                        this.attackTime = 100;
                        this.attackStep = 0;
                        this.blizzard.setOnFire(false);
                    }

                    if (this.attackStep > 1) {
                        float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                        this.blizzard.world.playEvent(null, 1018, new BlockPos((int)this.blizzard.posX, (int)this.blizzard.posY, (int)this.blizzard.posZ), 0);

                        for (int i = 0; i < 1; ++i) {
                            EntitySmallIceball smallIceball = new EntitySmallIceball(this.blizzard.world, this.blizzard, d1 + this.blizzard.getRNG().nextGaussian() * (double)f, d2, d3 + this.blizzard.getRNG().nextGaussian() * (double)f);
                            smallIceball.posY = this.blizzard.posY + (double)(this.blizzard.height / 2.0F) + 0.5D;
                            this.blizzard.world.spawnEntity(smallIceball);
                        }
                    }
                }

                this.blizzard.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
            }
            else {
                this.blizzard.getNavigator().clearPathEntity();
                this.blizzard.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
            }

            super.updateTask();
        }

        private double getFollowDistance() {
            IAttributeInstance iattributeinstance = this.blizzard.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
            return iattributeinstance.getAttributeValue();
        }
    }
}