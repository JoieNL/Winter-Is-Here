package joienl.winterishere.world.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.Biome;

class BiomeFrozenMushroomIsland extends BiomeFrozen {
    BiomeFrozenMushroomIsland(Biome.BiomeProperties properties) {
        super(properties);

        this.decorator.treesPerChunk = -100;
        this.topBlock = Blocks.MYCELIUM.getDefaultState();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
    }
}