package me.giopera;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class slvanish extends Command {
    public slvanish(StaffList staffList) {
        super("slvanish", "stafflist.vanish", "slvanish", "stafflistvanish", "vanishsl", "vanishstafflist");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (commandSender.hasPermission("stafflist.vanishothers") && strings.length > 0){
            if(ProxyServer.getInstance().getPlayer(strings[0]) == null) {
                ComponentBuilder err = new ComponentBuilder("Errore, il player non risulta essere online nel server proxy!").color(ChatColor.DARK_RED).bold(true);
                commandSender.sendMessage(err.create());
            } else {
                StaffList.toggleVanish(ProxyServer.getInstance().getPlayer(strings[1]));
                ComponentBuilder confirm = new ComponentBuilder("Hai attivato la vanish per " + strings[0]).color(ChatColor.GREEN).bold(true);
                commandSender.sendMessage(confirm.create());
            }
            return;
        }

        StaffList.toggleVanish((ProxiedPlayer) commandSender);
        ComponentBuilder confirm = new ComponentBuilder("Hai attivato la vanish").color(ChatColor.GREEN).bold(true);
        commandSender.sendMessage(confirm.create());
    }
}
