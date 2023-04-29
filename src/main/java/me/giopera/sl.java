package me.giopera;

import com.google.common.collect.Lists;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.scheduler.GroupedThreadFactory;
import net.md_5.bungee.command.PlayerCommand;


public class sl extends Command {

/*  public sl(String name, String permission, String... aliases) {
        super("sl", "StaffList.use", "sl", "stafflist", "liststaff", "ls");
    }
*/
    public sl(StaffList staffList) {
        super("sl", "StaffList.use", "sl", "stafflist", "liststaff", "ls");
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ComponentBuilder msgOwners = new ComponentBuilder("Owner ").color(ChatColor.DARK_RED).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgAdmins = new ComponentBuilder("Admin ").color(ChatColor.RED).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgSrMods = new ComponentBuilder("Sr. Mod ").color(ChatColor.DARK_GREEN).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgMods = new ComponentBuilder("Mod ").color(ChatColor.GREEN).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgHelpers = new ComponentBuilder("Helper ").color(ChatColor.BLUE).append("(").color(ChatColor.GRAY);

        /*
        ComponentBuilder msgOwners = new ComponentBuilder("");
        ComponentBuilder msgAdmins = new ComponentBuilder("");
        ComponentBuilder msgSrMods = new ComponentBuilder("");
        ComponentBuilder msgMods = new ComponentBuilder("");
        ComponentBuilder msgHelpers = new ComponentBuilder("");
*/
        int Owners = 0;
        int Admins = 0;
        int SrMods = 0;
        int Mods = 0;
        int Helpers = 0;

        List<ProxiedPlayer> vanished = StaffList.getVanishedPlayers();

        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers() ) {
            if (p.hasPermission("StaffList.Owner") && !(vanished.contains(p))) {
                Owners++;
            }
            if (p.hasPermission("StaffList.Admin") && !(vanished.contains(p))) {
                Admins++;
            }
            if (p.hasPermission("StaffList.SrMod") && !(vanished.contains(p))) {
                SrMods++;
            }
            if (p.hasPermission("StaffList.Mod") && !(vanished.contains(p))) {
                Mods++;
            }
            if (p.hasPermission("StaffList.Helper") && !(vanished.contains(p))) {
                Helpers++;
            }
        }

        msgOwners.append(Integer.toString(Owners)).color(ChatColor.WHITE).append(") ").color(ChatColor.GRAY);
        msgAdmins.append(Integer.toString(Admins)).color(ChatColor.WHITE).append(") ").color(ChatColor.GRAY);
        msgSrMods.append(Integer.toString(SrMods)).color(ChatColor.WHITE).append(") ").color(ChatColor.GRAY);
        msgMods.append(Integer.toString(Mods)).color(ChatColor.WHITE).append(") ").color(ChatColor.GRAY);
        msgHelpers.append(Integer.toString(Helpers)).color(ChatColor.WHITE).append(") ").color(ChatColor.GRAY);

        msgOwners.append("▪ ").color(ChatColor.GRAY);
        msgAdmins.append("▪ ").color(ChatColor.GRAY);
        msgSrMods.append("▪ ").color(ChatColor.GRAY);
        msgMods.append("▪ ").color(ChatColor.GRAY);
        msgHelpers.append("▪ ").color(ChatColor.GRAY);

        for (ProxiedPlayer p : ProxyServer.getInstance().getPlayers() ) {
            if (p.hasPermission("StaffList.Owner") && !(vanished.contains(p))) {
                msgOwners.append(p.getName()).color(ChatColor.WHITE).append(", ");
            }
            if (p.hasPermission("StaffList.Admin") && !(vanished.contains(p))) {
                msgAdmins.append(p.getName()).color(ChatColor.WHITE).append(", ");
            }
            if (p.hasPermission("StaffList.SrMod") && !(vanished.contains(p))) {
                msgSrMods.append(p.getName()).color(ChatColor.WHITE).append(", ");
            }
            if (p.hasPermission("StaffList.Mod") && !(vanished.contains(p))) {
                msgMods.append(p.getName()).color(ChatColor.WHITE).append(", ");
            }
            if (p.hasPermission("StaffList.Helper") && !(vanished.contains(p))) {
                msgHelpers.append(p.getName()).color(ChatColor.WHITE).append(", ");
            }
        }
        msgOwners.removeComponent(msgOwners.getCursor());
        msgAdmins.removeComponent(msgAdmins.getCursor());
        msgSrMods.removeComponent(msgSrMods.getCursor());
        msgMods.removeComponent(msgMods.getCursor());
        msgHelpers.removeComponent(msgHelpers.getCursor());

        ComponentBuilder init = new ComponentBuilder("Staffer Online").color(ChatColor.GOLD).bold(true);
        if(!(Owners == 0 && Admins == 0 && SrMods == 0 && Mods == 0 && Helpers == 0))
            commandSender.sendMessage(init.create());
        if(Owners != 0)
            commandSender.sendMessage(msgOwners.create());
        if(Admins != 0)
            commandSender.sendMessage(msgAdmins.create());
        if(SrMods != 0)
            commandSender.sendMessage(msgSrMods.create());
        if(Mods != 0)
            commandSender.sendMessage(msgMods.create());
        if(Helpers != 0)
            commandSender.sendMessage(msgHelpers.create());

        if(Owners == 0 && Admins == 0 && SrMods == 0 && Mods == 0 && Helpers == 0){
            ComponentBuilder noStaff = new ComponentBuilder("Attualmente non ci sono staffers online").color(ChatColor.RED);
            commandSender.sendMessage(noStaff.create());
        }
    }
}
