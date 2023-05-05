package me.giopera;

import me.giopera.Class.Staffer;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.LinkedList;

public final class StaffList extends Plugin {

    public static LinkedList<ProxiedPlayer> vanished = new LinkedList<>();
    public static LinkedList<ProxiedPlayer> afkPlayers = new LinkedList<>();
    public static ArrayList<Staffer> onlineStaffers = new ArrayList<>();

    public static boolean toggleVanish(ProxiedPlayer p){
        if(vanished.contains(p)) {
            vanished.remove(p);
            return false;
        } else {
            vanished.add(p);
            return true;
        }
    }

    public static boolean toggleAfk(ProxiedPlayer p){
        if(afkPlayers.contains(p)) {
            afkPlayers.remove(p);
            return false;
        } else {
            afkPlayers.add(p);
            return true;
        }
    }


    public static LinkedList<ProxiedPlayer> getAfkPlayers(){
        return afkPlayers;
    }
    public static LinkedList<ProxiedPlayer> getVanishedPlayers(){
        return vanished;
    }

    @Override
    public void onEnable() {
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new sl ());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new whereis ());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new slafk ());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new slvanish ());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new playerinfo ());
        ProxyServer.getInstance().getPluginManager().registerCommand(this, new truesl ());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new onPlayerJoin ());
        ProxyServer.getInstance().getPluginManager().registerListener(this, new onPlayerUnJoin ());
        getLogger().info("StaffList Avviato con successo");

    }

    @Override
    public void onDisable() {
        getLogger().info("StaffList Disabilitato con successo");
    }

}
