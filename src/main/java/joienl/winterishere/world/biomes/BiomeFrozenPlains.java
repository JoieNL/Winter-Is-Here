package joienl.winterishere.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

public class BiomeFrozenPlains extends BiomeFrozen {
    @SuppressWarnings({"FieldCanBeLocal", "unused"})
    private boolean sunflowers;

    BiomeFrozenPlains(boolean sunflowers, Biome.BiomeProperties properties) {
        super(properties);

        this.sunflowers = sunflowers;
        this.decorator.treesPerChunk = -999;
        this.decorator.extraTreeChance = 0.05F;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return rand.nextInt(3) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE;
    }
}