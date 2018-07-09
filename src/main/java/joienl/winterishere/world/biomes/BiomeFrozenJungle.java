package joienl.winterishere.world.biomes;

import joienl.winterishere.world.gen.feature.WorldGenDeadMegaJungleTree;
import joienl.winterishere.world.gen.feature.WorldGenDeadTrees;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenMelon;
import net.minecraft.world.gen.feature.WorldGenShrub;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

class BiomeFrozenJungle extends BiomeFrozen {
    private final boolean isEdge;
    private static final IBlockState JUNGLE_LOG = Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE);
    private static final IBlockState JUNGLE_LEAF = Blocks.LEAVES.getDefaultState().withProperty(BlockOldLeaf.VARIANT, BlockPlanks.EnumType.JUNGLE).withProperty(BlockLeaves.CHECK_DECAY, false);

    BiomeFrozenJungle(boolean isEdgeIn, Biome.BiomeProperties properties) {
        super(properties);

        this.isEdge = isEdgeIn;

        this.decorator.treesPerChunk = isEdgeIn ? 2 : 50;
    }

    @Override
    public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
        if (rand.nextInt(10) == 0) {
            return BIG_TREE_FEATURE;
        }
        else if (rand.nextInt(2) == 0) {
            return new WorldGenShrub(JUNGLE_LOG, Blocks.AIR.getDefaultState());
        }
        else {
            return !this.isEdge && rand.nextInt(3) == 0 ? new WorldGenDeadMegaJungleTree(false, 10, 20, JUNGLE_LOG, JUNGLE_LEAF) : new WorldGenDeadTrees(false, 4 + rand.nextInt(7), JUNGLE_LOG);
        }
    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        super.decorate(worldIn, rand, pos);
        int i = rand.nextInt(16) + 8;
        int j = rand.nextInt(16) + 8;
        int height = worldIn.getHeight(pos.add(i, 0, j)).getY() * 2; // could == 0, which crashes nextInt
        if (height < 1) {
            height = 1;
        }
        int k = rand.nextInt(height);
        if(TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.PUMPKIN)) {
            (new WorldGenMelon()).generate(worldIn, rand, pos.add(i, k, j));
        }
    }
}