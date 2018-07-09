package joienl.winterishere.world.biomes;

import net.minecraft.block.BlockSilverfish;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BiomeFrozenHills extends BiomeFrozen {
    private final WorldGenerator silverfishSpawner = new WorldGenMinable(Blocks.MONSTER_EGG.getDefaultState().withProperty(BlockSilverfish.VARIANT, BlockSilverfish.EnumType.STONE), 9);
    private final WorldGenTaiga2 spruceGenerator = new WorldGenTaiga2(false);
    private final Type type;

    BiomeFrozenHills(Type type, Biome.BiomeProperties properties) {
        super(properties);

        if (type == Type.EXTRA_TREES) {
            this.decorator.treesPerChunk = 3;
        }

        this.type = type;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        return rand.nextInt(3) > 0 ? this.spruceGenerator : (rand.nextInt(10) == 0 ? BIG_TREE_FEATURE : TREE_FEATURE);
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);

        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(worldIn, rand, pos));
        WorldGenerator emeralds = new BiomeFrozenHills.EmeraldGenerator();
        if (TerrainGen.generateOre(worldIn, rand, emeralds, pos, OreGenEvent.GenerateMinable.EventType.EMERALD)) {
            emeralds.generate(worldIn, rand, pos);
        }

        for (int j1 = 0; j1 < 7; ++j1) {
            int k1 = rand.nextInt(16);
            int l1 = rand.nextInt(64);
            int i2 = rand.nextInt(16);
            if (TerrainGen.generateOre(worldIn, rand, silverfishSpawner, pos.add(j1, k1, l1), OreGenEvent.GenerateMinable.EventType.SILVERFISH)) {
                this.silverfishSpawner.generate(worldIn, rand, pos.add(k1, l1, i2));
            }
        }
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(worldIn, rand, pos));
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.fillerBlock = Blocks.DIRT.getDefaultState();

        if ((noiseVal < -1.0D || noiseVal > 2.0D) && this.type == Type.MUTATED) {
            this.topBlock = Blocks.GRAVEL.getDefaultState();
            this.fillerBlock = Blocks.GRAVEL.getDefaultState();
        }
        else if (noiseVal > 1.0D && this.type != Type.EXTRA_TREES) {
            this.topBlock = Blocks.STONE.getDefaultState();
            this.fillerBlock = Blocks.STONE.getDefaultState();
        }

        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    public enum Type { NORMAL, EXTRA_TREES, MUTATED }

    private static class EmeraldGenerator extends WorldGenerator {
        @Override
        public boolean generate(World worldIn, Random rand, BlockPos pos) {
            int count = 3 + rand.nextInt(6);
            for (int i = 0; i < count; i++) {
                BlockPos blockpos = pos.add(rand.nextInt(16), rand.nextInt(28) + 4, rand.nextInt(16));

                IBlockState state = worldIn.getBlockState(blockpos);
                if (state.getBlock().isReplaceableOreGen(state, worldIn, blockpos, BlockMatcher.forBlock(Blocks.STONE))) {
                    worldIn.setBlockState(blockpos, Blocks.EMERALD_ORE.getDefaultState(), 16 | 2);
                }
            }
            return true;
        }
    }
}