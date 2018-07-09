package joienl.winterishere.world.gen.feature;

import joienl.winterishere.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenHellWater extends WorldGenerator {
    private final Block block;
    private final boolean insideRock;

    public WorldGenHellWater(Block blockIn, boolean insideRockIn) {
        this.block = blockIn;
        this.insideRock = insideRockIn;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        if (world.getBlockState(pos.up()).getBlock() != ModBlocks.FROSTED_NETHERRACK) {
            return false;
        }
        else if (!world.isAirBlock(pos) && world.getBlockState(pos).getBlock() != ModBlocks.FROSTED_NETHERRACK) {
            return false;
        }
        else {
            int i = 0;

            if (world.getBlockState(pos.west()).getBlock() == ModBlocks.FROSTED_NETHERRACK) {
                ++i;
            }

            if (world.getBlockState(pos.east()).getBlock() == ModBlocks.FROSTED_NETHERRACK) {
                ++i;
            }

            if (world.getBlockState(pos.north()).getBlock() == ModBlocks.FROSTED_NETHERRACK) {
                ++i;
            }

            if (world.getBlockState(pos.south()).getBlock() == ModBlocks.FROSTED_NETHERRACK) {
                ++i;
            }

            if (world.getBlockState(pos.down()).getBlock() == ModBlocks.FROSTED_NETHERRACK) {
                ++i;
            }

            int j = 0;

            if (world.isAirBlock(pos.west())) {
                ++j;
            }

            if (world.isAirBlock(pos.east())) {
                ++j;
            }

            if (world.isAirBlock(pos.north())) {
                ++j;
            }

            if (world.isAirBlock(pos.south())) {
                ++j;
            }

            if (world.isAirBlock(pos.down())) {
                ++j;
            }

            if (!this.insideRock && i == 4 && j == 1 || i == 5) {
                IBlockState state = this.block.getDefaultState();
                world.setBlockState(pos, state, 2);
                world.immediateBlockTick(pos, state, rand);
            }

            return true;
        }
    }
}