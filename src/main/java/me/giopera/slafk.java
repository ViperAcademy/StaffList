package me.giopera;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class slafk extends Command {



    public slafk(StaffList staffList) {
        super("slafk", "stafflist.afk", "slafk", "stafflistafk", "afksl", "afkstafflist");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (!(commandSender instanceof ProxiedPlayer))
            return;
        if (commandSender.hasPermission("stafflist.afkothers") && strings.length > 0){
            if(ProxyServer.getInstance().getPlayer(strings[0]) == null) {
                ComponentBuilder err = new ComponentBuilder("Errore, il player non risulta essere online nel server proxy!").color(ChatColor.DARK_RED).bold(true);
                commandSender.sendMessage(err.create());
            } else {
                if(StaffList.toggleAfk(ProxyServer.getInstance().getPlayer(strings[1]))) {
                    ComponentBuilder confirm = new ComponentBuilder("Hai messo afk " + strings[0]).color(ChatColor.GREEN).bold(true);
                    commandSender.sendMessage(confirm.create());
                } else {
                    ComponentBuilder confirm = new ComponentBuilder("Hai tolto dall'afk " + strings[0]).color(ChatColor.GREEN).bold(true);
                    commandSender.sendMessage(confirm.create());
                }
            }
            return;
        }

        if(StaffList.toggleAfk((ProxiedPlayer) commandSender)) {
            ComponentBuilder confirm = new ComponentBuilder("Sei andato Afk").color(ChatColor.GREEN).bold(true);
            commandSender.sendMessage(confirm.create());
        } else {
            ComponentBuilder confirm = new ComponentBuilder("Bentornato alla tastiera").color(ChatColor.GREEN).bold(true);
            commandSender.sendMessage(confirm.create());
        }
    }
}

