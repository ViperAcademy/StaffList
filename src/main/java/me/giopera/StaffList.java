package me.giopera;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

public final class StaffList extends Plugin {

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
