package me.giopera;

import me.giopera.Class.Role;
import me.giopera.Class.Staffer;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.ArrayList;

import static me.giopera.StaffList.onlineStaffers;

public class onPlayerUnJoin implements Listener {
    @EventHandler
    public void onDisconnect(PlayerDisconnectEvent event) {
        ArrayList<Staffer> al = new ArrayList<>();
        onlineStaffers.removeIf(s -> s.getPlayer().equals(event.getPlayer()));

/*
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.OWNER));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.COOWNER));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.SRADMIN));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.ADMINPLUS));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.ADMIN));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.CAPOSTAFF));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.SRMOD));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.MODPLUS));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.MOD));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.HELPERPLUS));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.HELPER));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.CAPOBUILDER));
        onlineStaffers.remove(new Staffer(event.getPlayer(), Role.BUILDER));
*/


    }
}
