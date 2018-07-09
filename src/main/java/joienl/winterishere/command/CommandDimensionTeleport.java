package joienl.winterishere.command;

import com.google.common.collect.Lists;
import joienl.winterishere.WinterIsHere;
import joienl.winterishere.command.util.Teleport;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

import java.util.List;

public class CommandDimensionTeleport extends CommandBase {

    private final List<String> aliases = Lists.newArrayList(WinterIsHere.MODID, "tpdim", "tpdimension", "teleportdimension");

    @Override
    public String getName() { return "teleportdimension"; }

    @Override
    public String getUsage(ICommandSender sender) { return getName() + " <id>"; }

    @Override
    public List<String> getAliases() { return aliases; }

    @Override
    public int getRequiredPermissionLevel() { return 2; }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) {
        if (args.length < 1) { return; }

        String s = args[0];
        int dimensionId;

        try {
            dimensionId = Integer.parseInt(s);
        }
        catch (NumberFormatException e) {
            sender.sendMessage(new TextComponentString(TextFormatting.RED + "Dimension ID invalid!"));
            return;
        }

        if (sender instanceof EntityPlayer) {
            Teleport.teleportToDimension((EntityPlayer) sender, dimensionId, 0.5D, 100D, 0.5D);
        }
    }
}