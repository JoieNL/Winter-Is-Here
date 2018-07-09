package joienl.winterishere.world.biomes;

import joienl.winterishere.block.ModBlocks;
import net.minecraft.world.biome.Biome;

class BiomeFrozenBeach extends BiomeFrozen {
    BiomeFrozenBeach(Biome.BiomeProperties properties) {
        super(properties);

        this.topBlock = ModBlocks.BLUE_SAND.getDefaultState();
        this.fillerBlock = ModBlocks.BLUE_SAND.getDefaultState();
        this.decorator.treesPerChunk = -999;
    }
}