package joienl.winterishere.world.biomes;

import net.minecraft.block.material.Material;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenFossils;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

class BiomeFrozenSwamp extends BiomeFrozen {
    BiomeFrozenSwamp(Biome.BiomeProperties properties) {
        super(properties);

        this.decorator.treesPerChunk = 2;
        this.decorator.clayPerChunk = 1;
        this.decorator.sandPatchesPerChunk = 0;
        this.decorator.gravelPatchesPerChunk = 0;
        this.spawnableMonsterList.add(new Biome.SpawnListEntry(EntitySlime.class, 1, 1, 1));
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) { return SWAMP_FEATURE; }

    @Override
    public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int x, int z, double noiseVal) {
        double d0 = GRASS_COLOR_NOISE.getValue((double)x * 0.25D, (double)z * 0.25D);

        if (d0 > 0.0D) {
            int i = x & 15;
            int j = z & 15;

            for (int k = 255; k >= 0; --k) {
                if (chunkPrimerIn.getBlockState(j, k, i).getMaterial() != Material.AIR) {
                    if (k == 62 && chunkPrimerIn.getBlockState(j, k, i).getBlock() != Blocks.WATER) {
                        chunkPrimerIn.setBlockState(j, k, i, WATER);
                    }

                    break;
                }
            }
        }

        this.generateBiomeTerrain(worldIn, rand, chunkPrimerIn, x, z, noiseVal);
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);

        if(TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.FOSSIL)) {
            if (rand.nextInt(64) == 0) {
                new WorldGenFossils().generate(worldIn, rand, pos);
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getGrassColorAtPos(BlockPos pos) {
        double d0 = GRASS_COLOR_NOISE.getValue((double)pos.getX() * 0.0225D, (double)pos.getZ() * 0.0225D);
        return d0 < -0.1D ? 5011004 : 6975545;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getFoliageColorAtPos(BlockPos pos) { return 6975545; }
}
