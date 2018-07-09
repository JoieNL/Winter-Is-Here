package joienl.winterishere.world.gen.feature;

import joienl.winterishere.block.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenGlowStone extends WorldGenerator {
    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        if (!worldIn.isAirBlock(position)) {
            return false;
        }
        else if (worldIn.getBlockState(position.up()).getBlock() != ModBlocks.FROSTED_NETHERRACK) {
            return false;
        }
        else {
            worldIn.setBlockState(position, Blocks.GLOWSTONE.getDefaultState(), 3);

            for (int i = 0; i < 1500; ++i) {
                BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), -rand.nextInt(12), rand.nextInt(8) - rand.nextInt(8));

                if (worldIn.isAirBlock(blockpos)) {
                    int j = 0;

                    for (EnumFacing enumfacing : EnumFacing.values()) {
                        if (worldIn.getBlockState(blockpos.offset(enumfacing)).getBlock() == Blocks.GLOWSTONE) {
                            ++j;
                        }

                        if (j > 1) {
                            break;
                        }
                    }

                    if (j == 1) {
                        worldIn.setBlockState(blockpos, Blocks.GLOWSTONE.getDefaultState(), 3);
                    }
                }
            }

            return true;
        }
    }
}