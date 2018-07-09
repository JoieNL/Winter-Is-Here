package joienl.winterishere.world.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

class BiomeFrozenStoneBeach extends BiomeFrozen {
    BiomeFrozenStoneBeach(Biome.BiomeProperties properties) {
        super(properties);

        this.topBlock = Blocks.STONE.getDefaultState();
        this.fillerBlock = Blocks.STONE.getDefaultState();
        this.decorator.treesPerChunk = -999;
    }
}