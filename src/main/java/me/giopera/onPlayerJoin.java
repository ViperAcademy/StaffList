package me.giopera;

import me.giopera.Class.Role;
import me.giopera.Class.Staffer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import static me.giopera.StaffList.*;
import static me.giopera.StaffList.vanished;

public class onPlayerJoin implements Listener {
    @EventHandler
    public void onJoin(ServerConnectEvent event) {
        ProxiedPlayer p = event.getPlayer();
        if (p.hasPermission("StaffList.Owner") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.OWNER));
        }
        if (p.hasPermission("StaffList.CoOwner") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.COOWNER));
        }
        if (p.hasPermission("StaffList.SrAdmin") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.SRADMIN));
        }
        if (p.hasPermission("StaffList.AdminPlus") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.ADMINPLUS));
        }
        if (p.hasPermission("StaffList.Admin") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.ADMIN));
        }
        if (p.hasPermission("StaffList.SrMod") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.SRMOD));
        }
        if (p.hasPermission("StaffList.ModPlus") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.MODPLUS));
        }
        if (p.hasPermission("StaffList.Mod") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.MOD));
        }
        if (p.hasPermission("StaffList.HelperPlus") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.HELPERPLUS));
        }
        if (p.hasPermission("StaffList.Helper") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.HELPER));
        }
        if (p.hasPermission("StaffList.CapoStaff") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.CAPOSTAFF));
        }
        if (p.hasPermission("StaffList.capoBuilder") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.CAPOBUILDER));
        }
        if (p.hasPermission("StaffList.builder") && !(vanished.contains(p))) {
            onlineStaffers.add(new Staffer(p, Role.BUILDER));
        }
    }
}
