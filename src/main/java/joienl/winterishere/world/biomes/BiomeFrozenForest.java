package joienl.winterishere.world.biomes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class BiomeFrozenForest extends BiomeFrozen {

    private final Type type;

    BiomeFrozenForest(Type typeIn, Biome.BiomeProperties properties) {
        super(properties);

        this.type = typeIn;
        this.decorator.treesPerChunk = 10;

        if (this.type == Type.FLOWER) {
            this.decorator.treesPerChunk = 6;
        }

        if (this.type == Type.ROOFED) {
            this.decorator.treesPerChunk = -999;
        }
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        if (this.type == Type.ROOFED && rand.nextInt(3) > 0) {
            return ROOF_TREE;
        }
        else if (this.type != Type.BIRCH && rand.nextInt(5) != 0) {
            return rand.nextInt(10) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE;
        }
        else {
            return BIRCH_TREE;
        }
    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos) {
        if (this.type == BiomeFrozenForest.Type.ROOFED) {
            for (int i = 0; i < 4; ++i) {
                for (int j = 0; j < 4; ++j) {
                    int k = i * 4 + 1 + 8 + rand.nextInt(3);
                    int l = j * 4 + 1 + 8 + rand.nextInt(3);
                    BlockPos blockpos = world.getHeight(pos.add(k, 0, l));

                    if (net.minecraftforge.event.terraingen.TerrainGen.decorate(world, rand, blockpos, net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE)) {
                        WorldGenAbstractTree worldgenabstracttree = this.getRandomTreeFeature(rand);
                        worldgenabstracttree.setDecorationDefaults();

                        if (worldgenabstracttree.generate(world, rand, blockpos)) {
                            worldgenabstracttree.generateSaplings(world, rand, blockpos);
                        }
                    }
                }
            }
        }

        super.decorate(world, rand, pos);
    }

    @Override
    public Class <? extends Biome> getBiomeClass() { return BiomeFrozenForest.class; }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        int i = super.getGrassColorAtPos(pos);
        return this.type == Type.ROOFED ? (i & 16711422) + 2634762 >> 1 : i;
    }

    public enum Type { NORMAL, FLOWER, BIRCH, ROOFED }
}