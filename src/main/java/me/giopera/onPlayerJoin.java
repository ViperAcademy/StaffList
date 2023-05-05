package me.giopera;

import me.giopera.Class.Role;
import me.giopera.Class.Staffer;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerHandshakeEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import static me.giopera.StaffList.*;
import static me.giopera.StaffList.vanished;

public class onPlayerJoin implements Listener {
    @EventHandler
    public void onJoin(ServerConnectEvent event) {
        ProxiedPlayer p = event.getPlayer();
        if (p.hasPermission("StaffList.Owner")) {
            onlineStaffers.add(new Staffer(p, Role.OWNER));
        }
        if (p.hasPermission("StaffList.CoOwner")) {
            onlineStaffers.add(new Staffer(p, Role.COOWNER));
        }
        if (p.hasPermission("StaffList.SrAdmin")) {
            onlineStaffers.add(new Staffer(p, Role.SRADMIN));
        }
        if (p.hasPermission("StaffList.AdminPlus")) {
            onlineStaffers.add(new Staffer(p, Role.ADMINPLUS));
        }
        if (p.hasPermission("StaffList.Admin")) {
            onlineStaffers.add(new Staffer(p, Role.ADMIN));
        }
        if (p.hasPermission("StaffList.SrMod")) {
            onlineStaffers.add(new Staffer(p, Role.SRMOD));
        }
        if (p.hasPermission("StaffList.ModPlus")) {
            onlineStaffers.add(new Staffer(p, Role.MODPLUS));
        }
        if (p.hasPermission("StaffList.Mod")) {
            onlineStaffers.add(new Staffer(p, Role.MOD));
        }
        if (p.hasPermission("StaffList.HelperPlus")) {
            onlineStaffers.add(new Staffer(p, Role.HELPERPLUS));
        }
        if (p.hasPermission("StaffList.Helper")) {
            onlineStaffers.add(new Staffer(p, Role.HELPER));
        }
        if (p.hasPermission("StaffList.CapoStaff")) {
            onlineStaffers.add(new Staffer(p, Role.CAPOSTAFF));
        }
        if (p.hasPermission("StaffList.capoBuilder")) {
            onlineStaffers.add(new Staffer(p, Role.CAPOBUILDER));
        }
        if (p.hasPermission("StaffList.builder")) {
            onlineStaffers.add(new Staffer(p, Role.BUILDER));
        }
    }
}

