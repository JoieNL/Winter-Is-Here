package joienl.winterishere.event;

import joienl.winterishere.command.util.Teleport;
import joienl.winterishere.world.gen.WorldTypeWinter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class ModEventHandler {
    @SubscribeEvent
    public static void onWorldTickEvent(TickEvent.WorldTickEvent e) {
        if (e.world.getWorldType() instanceof WorldTypeWinter && !e.world.getWorldInfo().isRaining()) {
            WorldInfo worldInfo = e.world.getWorldInfo();
            worldInfo.setCleanWeatherTime(0);
            worldInfo.setRainTime(1000000);
            worldInfo.setRaining(true);
        }
    }

    @SubscribeEvent
    public static void onEntityTravelToDimensionEvent(EntityTravelToDimensionEvent e) {
        if (e.getDimension() != 0) {
            e.setCanceled(true);
        }
        if (e.getEntity() instanceof EntityPlayer) {
            if (e.getDimension() == -1) {
                Teleport.teleportToDimension((EntityPlayer) e.getEntity(), -2, 0, 100, 0);
            }
            else if (e.getDimension() == 1) {
                Teleport.teleportToDimension((EntityPlayer) e.getEntity(), 2, 0, 100, 0);
            }
        }
    }

    /*@SubscribeEvent
    public static void onPlayerTickEvent(TickEvent.PlayerTickEvent e) {
        if (e.player.world instanceof WorldServer && (e.player.dimension == 0 || e.player.dimension == 2)) {
            WorldServer world = (WorldServer) e.player.world;
            int snowRadius = 16 * Minecraft.getMinecraft().gameSettings.renderDistanceChunks;
            int posX = e.player.getPosition().getX();
            int posZ = e.player.getPosition().getZ();
            BlockPos[][] topBlocks = new BlockPos[2 * snowRadius + 3][2 * snowRadius + 3];
            for (int z = posZ - (snowRadius + 1); z <= posZ + (snowRadius + 1); z++) {
                for (int x = posX - (snowRadius + 1); x <= posX + (snowRadius + 1); x++) {
                    topBlocks[x - posX + (snowRadius + 1)][z - posZ + (snowRadius + 1)] = getTopSolidOrLiquidBlock(x, z, world);
                }
            }
            for (int z = posZ - snowRadius; z <= posZ + snowRadius; z++) {
                for (int x = posX - snowRadius; x <= posX + snowRadius; x++) {
                    if (e.player.world.rand.nextInt(1000) == 0) {
                        if (Math.sqrt(Math.pow(x - posX, 2) + Math.pow(z - posZ, 2)) < snowRadius) {
                            BlockPos pos = topBlocks[x - posX + (snowRadius + 1)][z - posZ + (snowRadius + 1)];
                            if (Blocks.SNOW_LAYER.canPlaceBlockAt(world, pos.up())) {
                                if (world.rand.nextInt(Math.round(1000F / getWeightedSnowChance(x - posX + (snowRadius + 1), z - posZ + (snowRadius + 1), topBlocks, world))) < 1000) {
                                    IBlockState state = world.getBlockState(pos.up());
                                    if (state.getBlock() == Blocks.SNOW_LAYER) {
                                        world.setBlockState(pos.up(), Blocks.SNOW_LAYER.getDefaultState().withProperty(BlockSnow.LAYERS, state.getValue(BlockSnow.LAYERS) + 1));
                                    } else {
                                        world.setBlockState(pos.up(), Blocks.SNOW_LAYER.getDefaultState());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static BlockPos getTopSolidOrLiquidBlock(double x, double z, World world) {
        BlockPos pos = new BlockPos(x, 0, z);
        Chunk chunk = world.getChunkFromBlockCoords(pos);
        BlockPos blockpos;
        BlockPos blockpos1;

        for (blockpos = new BlockPos(x, chunk.getTopFilledSegment() + 16, z); blockpos.getY() >= 0; blockpos = blockpos1) {
            blockpos1 = blockpos.down();
            IBlockState state = chunk.getBlockState(blockpos1);

            if ((state.getMaterial().blocksMovement() && !state.getBlock().isFoliage(world, blockpos1)) ||
                    (state.getBlock() == Blocks.SNOW_LAYER && state.getValue(BlockSnow.LAYERS) == 8)) {
                break;
            }
        }

        return blockpos.down();
    }

    private static float getWeightedSnowChance(int x, int z, BlockPos[][] topBlocks, World world) {
        float north = topBlocks[x][z - 1].getY();
        float east = topBlocks[x + 1][z].getY();
        float south = topBlocks[x][z + 1].getY();
        float west = topBlocks[x - 1][z].getY();
        float middle = topBlocks[x][z].getY();
        if (world.getBlockState(topBlocks[x][z - 1].up()).getBlock() == Blocks.SNOW_LAYER) {
            north += 0.125F * world.getBlockState(topBlocks[x][z - 1].up()).getValue(BlockSnow.LAYERS);
        }
        if (world.getBlockState(topBlocks[x + 1][z].up()).getBlock() == Blocks.SNOW_LAYER) {
            east += 0.125F * world.getBlockState(topBlocks[x + 1][z].up()).getValue(BlockSnow.LAYERS);
        }
        if (world.getBlockState(topBlocks[x][z + 1].up()).getBlock() == Blocks.SNOW_LAYER) {
            south += 0.125F * world.getBlockState(topBlocks[x][z + 1].up()).getValue(BlockSnow.LAYERS);
        }
        if (world.getBlockState(topBlocks[x - 1][z].up()).getBlock() == Blocks.SNOW_LAYER) {
            west += 0.125F * world.getBlockState(topBlocks[x - 1][z].up()).getValue(BlockSnow.LAYERS);
        }
        if (world.getBlockState(topBlocks[x][z].up()).getBlock() == Blocks.SNOW_LAYER) {
            middle += 0.125F * world.getBlockState(topBlocks[x][z].up()).getValue(BlockSnow.LAYERS);
        }

        float average = (north + east + south + west) / 4F;
        float difference = middle - average;
        return (float) (1F / (1F + Math.pow(Math.E, 15F * (difference + 0.05F))));
    }*/
}