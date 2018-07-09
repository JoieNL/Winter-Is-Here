package joienl.winterishere.world.biomes;

import net.minecraft.world.biome.Biome;

class BiomeFrozenOcean extends BiomeFrozen {
    BiomeFrozenOcean(BiomeProperties properties) {
        super(properties);
        this.spawnableCreatureList.clear();
        this.decorator.treesPerChunk = -999;
    }

    @Override
    public Biome.TempCategory getTempCategory() {
        return Biome.TempCategory.OCEAN;
    }
}