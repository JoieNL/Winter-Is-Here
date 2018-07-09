package joienl.winterishere.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

import java.util.Random;

class BiomeFrozenSavanna extends BiomeFrozen {
    BiomeFrozenSavanna(Biome.BiomeProperties properties) {
        super(properties);

        this.decorator.treesPerChunk = 1;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return rand.nextInt(5) > 0 ? SAVANNA_TREE : TREE_FEATURE;
    }

    @Override
    public Class <? extends Biome > getBiomeClass() { return BiomeSavanna.class; }
}