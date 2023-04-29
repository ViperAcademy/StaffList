package me.giopera;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.List;

public final class StaffList extends Plugin {

    public static List<ProxiedPlayer> vanished = new ArrayList<>();
    public static void toggleVanish(ProxiedPlayer p){
        if(vanished.contains(p))
            vanished.remove(p);
        else {
            vanished.add(p);
        }
    }

    public static List<ProxiedPlayer> getVanishedPlayers(){
        return vanished;
    }

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new sl (this));
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new slvanish (this));
        getLogger().info("StaffList Avviato con successo");

    }

    @Override
    public void onDisable() {
        getLogger().info("StaffList Disabilitato con successo");
    }
}
