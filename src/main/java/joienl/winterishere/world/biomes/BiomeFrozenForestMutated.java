package joienl.winterishere.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeFrozenForestMutated extends BiomeFrozenForest {
    BiomeFrozenForestMutated(Biome.BiomeProperties properties) {
        super(BiomeFrozenForest.Type.BIRCH, properties);
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return rand.nextBoolean() ? SUPER_BIRCH_TREE : BIRCH_TREE;
    }
}