package me.giopera;

import me.giopera.Class.Role;
import me.giopera.Class.Staffer;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import static me.giopera.StaffList.onlineStaffers;

public class onPlayerUnJoin implements Listener {
    @EventHandler
    public void onDisconnect(ServerDisconnectEvent event) {
        for (Role r : Role.values()) {
            onlineStaffers.remove(new Staffer(event.getPlayer(), r));
        }
    }
}
