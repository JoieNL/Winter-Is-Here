package joienl.winterishere.world.biomes;

import net.minecraft.world.biome.Biome;

class BiomeFrozenRiver extends BiomeFrozen {
    BiomeFrozenRiver(Biome.BiomeProperties properties) {
        super(properties);
        this.spawnableCreatureList.clear();
        this.decorator.treesPerChunk = -999;
    }
}