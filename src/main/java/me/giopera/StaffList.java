package me.giopera;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.List;

public final class StaffList extends Plugin {

    public static List<ProxiedPlayer> vanished;
    public static void addVanishedPlayer(ProxiedPlayer p){
        vanished.add(p);
    }
    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new sl (this));
        getLogger().info("StaffList Avviato con successo");
    }

    @Override
    public void onDisable() {
        getLogger().info("StaffList Disabilitato con successo");
    }
}
