package me.giopera;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import me.giopera.StaffList;

import static net.md_5.bungee.api.ProxyServer.getInstance;

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
                return;
            } else {
                StaffList.addVanishedPlayer(ProxyServer.getInstance().getPlayer(strings[1]));
                ComponentBuilder err = new ComponentBuilder("Hai attivato la vanish per " + strings[1]).color(ChatColor.GREEN).bold(true);
                return;
            }
        }

        StaffList.addVanishedPlayer((ProxiedPlayer) commandSender);

    }
}
