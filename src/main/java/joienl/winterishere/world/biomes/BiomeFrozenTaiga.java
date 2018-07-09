package joienl.winterishere.world.biomes;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class BiomeFrozenTaiga extends BiomeFrozen {
    private static final WorldGenTaiga1 PINE_GENERATOR = new WorldGenTaiga1();
    private static final WorldGenTaiga2 SPRUCE_GENERATOR = new WorldGenTaiga2(false);
    private static final WorldGenMegaPineTree MEGA_PINE_GENERATOR = new WorldGenMegaPineTree(false, false);
    private static final WorldGenMegaPineTree MEGA_SPRUCE_GENERATOR = new WorldGenMegaPineTree(false, true);
    private static final WorldGenBlockBlob FOREST_ROCK_GENERATOR = new WorldGenBlockBlob(Blocks.MOSSY_COBBLESTONE, 0);
    private final BiomeFrozenTaiga.Type type;

    BiomeFrozenTaiga(BiomeFrozenTaiga.Type typeIn, Biome.BiomeProperties properties) {
        super(properties);

        this.type = typeIn;
        this.decorator.treesPerChunk = 10;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        if ((this.type == BiomeFrozenTaiga.Type.MEGA || this.type == BiomeFrozenTaiga.Type.MEGA_SPRUCE) && rand.nextInt(3) == 0) {
            return this.type != BiomeFrozenTaiga.Type.MEGA_SPRUCE && rand.nextInt(13) != 0 ? MEGA_PINE_GENERATOR : MEGA_SPRUCE_GENERATOR;
        }
        else {
            return rand.nextInt(3) == 0 ? PINE_GENERATOR : SPRUCE_GENERATOR;
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    @Override
    public WorldGenerator getRandomWorldGenForGrass(Random rand) {
        return rand.nextInt(5) > 0 ? new WorldGenTallGrass(BlockTallGrass.EnumType.FERN) : new WorldGenTallGrass(BlockTallGrass.EnumType.GRASS);
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        if ((this.type == BiomeFrozenTaiga.Type.MEGA || this.type == BiomeFrozenTaiga.Type.MEGA_SPRUCE) && TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.ROCK)) {
            int i = rand.nextInt(3);

            for (int j = 0; j < i; ++j) {
                int k = rand.nextInt(16) + 8;
                int l = rand.nextInt(16) + 8;
                BlockPos blockpos = worldIn.getHeight(pos.add(k, 0, l));
                FOREST_ROCK_GENERATOR.generate(worldIn, rand, blockpos);
            }
        }

        super.decorate(worldIn, rand, pos);
    }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        if (this.type == BiomeFrozenTaiga.Type.MEGA || this.type == BiomeFrozenTaiga.Type.MEGA_SPRUCE) {
            this.topBlock = Blocks.GRASS.getDefaultState();
            this.fillerBlock = Blocks.DIRT.getDefaultState();

            if (noiseVal > 1.75D) {
                this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.COARSE_DIRT);
            }
            else if (noiseVal > -0.95D) {
                this.topBlock = Blocks.DIRT.getDefaultState().withProperty(BlockDirt.VARIANT, BlockDirt.DirtType.PODZOL);
            }
        }

        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    public enum Type { NORMAL, MEGA, MEGA_SPRUCE }
}