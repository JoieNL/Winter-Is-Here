package joienl.winterishere.world.dimensions;

import joienl.winterishere.world.biomes.ModBiomes;
import joienl.winterishere.world.gen.ChunkGeneratorFrozenHell;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldProviderFrozenHell extends WorldProvider {
    @Override
    public void init() { this.biomeProvider = new BiomeProviderSingle(ModBiomes.FROZEN_HELL); }

    /**
     * Return Vec3D with biome specific fog color
     */
    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float p_76562_1_, float p_76562_2_) { return new Vec3d(8D/255D, 37D/255D, 51D/255D); }

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkGeneratorFrozenHell(this.world, this.world.getWorldInfo().isMapFeaturesEnabled(), this.world.getSeed());
    }

    @Override
    public boolean isSurfaceWorld() { return false; }

    @Override
    public boolean canCoordinateBeSpawn(int x, int z) { return false; }

    @Override
    public float calculateCelestialAngle(long worldTime, float partialTicks) { return 0.5F; }

    @Override
    public boolean canRespawnHere() { return false; }

    @Override
    public WorldBorder createWorldBorder() {
        return new WorldBorder() {
            @Override
            public double getCenterX() { return super.getCenterX() / 8.0D; }
            @Override
            public double getCenterZ() { return super.getCenterZ() / 8.0D; }
        };
    }

    @Override
    public DimensionType getDimensionType() { return ModDimensions.FROZEN_NETHER; }
}