package joienl.winterishere.command.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import java.util.Objects;

public class Teleport extends Teleporter {

    private final WorldServer world;
    private final double x;
    private final double y;
    private final double z;

    private Teleport(WorldServer world, double x, double y, double z) {
        super(world);
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void placeInPortal(Entity entityIn, float rotationYaw) {
        this.world.getBlockState(new BlockPos(x, y, z));
        entityIn.setPosition(x, y, z);
        entityIn.motionX = 0F;
        entityIn.motionY = 0F;
        entityIn.motionZ = 0F;
    }

    public static void teleportToDimension(EntityPlayer player, int dimensionId, double x, double y, double z) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        MinecraftServer server = player.getEntityWorld().getMinecraftServer();
        assert server != null : "Dimension " + dimensionId + " does not exist!";
        WorldServer worldServer = server.getWorld(dimensionId);
        Objects.requireNonNull(worldServer.getMinecraftServer()).getPlayerList().transferPlayerToDimension(entityPlayerMP, dimensionId, new Teleport(worldServer, x, y, z));
        player.setPositionAndUpdate(x, y, z);
    }
}