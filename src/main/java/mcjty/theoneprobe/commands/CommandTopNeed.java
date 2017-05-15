package mcjty.theoneprobe.commands;

import mcjty.lib.compat.CompatCommand;
import mcjty.lib.compat.CompatCommandBase;
import mcjty.lib.tools.MinecraftTools;
import mcjty.theoneprobe.TheOneProbe;
import mcjty.theoneprobe.proxy.ClientProxy;
import mcjty.theoneprobe.proxy.GuiProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import java.util.Collections;
import java.util.List;

public class CommandTopNeed implements CompatCommand {


    @Override
    public String getName() {
        return "topneed";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "topneed";
    }

    @Override
    public List<String> getAliases() {
        return Collections.emptyList();
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        ClientProxy.ignoreNextGuiClose = true;
        EntityPlayerSP player = MinecraftTools.getPlayer(Minecraft.getMinecraft());
        player.openGui(TheOneProbe.instance, GuiProxy.GUI_NOTE, player.getEntityWorld(), (int) player.posX, (int) player.posY, (int) player.posZ);
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }


    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos pos) {
        return Collections.emptyList();
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return getName().compareTo(CompatCommandBase.getCommandName(o));
    }
}