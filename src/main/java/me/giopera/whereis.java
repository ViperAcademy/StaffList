package me.giopera;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.plugin.Command;

public class whereis extends Command {
    public whereis() {
        super("whereis", "whereis.use", "whereis");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        commandSender.sendMessage(new ComponentBuilder(strings[0] + " is in" + ProxyServer.getInstance().getPlayer(strings[0]).getServer().getInfo().getName()).color(ChatColor.GOLD).create());
    }
}
