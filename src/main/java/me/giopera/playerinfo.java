package me.giopera;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;


public class playerinfo extends Command {
    public playerinfo(StaffList staffList) {
        super("playerinfo", "staffcore.playerinfo", "info");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if(strings.length < 1){
            commandSender.sendMessage(new ComponentBuilder("Errore: Non ho abbastanza argomenti per funzionare, prova con: /playerinfo <playerName>").create());
            return;
        }

        ProxiedPlayer p = ProxyServer.getInstance().getPlayer(strings[0]);
        ComponentBuilder msg = new ComponentBuilder();

        msg.append("Info di " + strings[0]).color(ChatColor.DARK_GREEN).append("\n");
        msg.append("Nome: " + p.getName()).color(ChatColor.GREEN).append("\n");
        msg.append("Nome Mostrato: " + p.getDisplayName()).color(ChatColor.GREEN).append("\n");
        msg.append("Chat (Nascosta/In Mostra): " + ((p.getChatMode() == ProxiedPlayer.ChatMode.SHOWN || p.getChatMode() == ProxiedPlayer.ChatMode.COMMANDS_ONLY) ? "Mostrata" : "Nascosta")).color(ChatColor.GREEN).append("\n");
        msg.append("Paese: " + p.getLocale().getCountry()).color(ChatColor.GREEN).append("\n");
        msg.append("Nome Mostrato: " + p.getDisplayName()).color(ChatColor.GREEN).append("\n");
        msg.append("Mano Principale: " + ((p.getMainHand() == ProxiedPlayer.MainHand.LEFT) ? "Sinistra" : "Destra")).color(ChatColor.GREEN).append("\n");
        msg.append("Ping: " + p.getPing()).color(ChatColor.GREEN).append("\n");
        msg.append("Server: " + p.getServer().getInfo().getName()).color(ChatColor.GREEN).append("\n");
        msg.append("UUID: " + p.getUniqueId().toString()).color(ChatColor.GREEN).append("\n");
        msg.append("View Distance: " + p.getViewDistance()).color(ChatColor.GREEN).append("\n");
        msg.append("Colori chat: " + p.hasChatColors()).color(ChatColor.GREEN).append("\n");
        msg.append("Forge: " + p.isForgeUser()).color(ChatColor.GREEN);

        commandSender.sendMessage(msg.create());


    }
}
