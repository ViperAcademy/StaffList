package me.giopera;


import java.util.LinkedList;
import java.util.List;


import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import static me.giopera.StaffList.vanished;
import static me.giopera.StaffList.afkPlayers;
import static me.giopera.StaffList.onlineStaffers;

import me.giopera.Class.Role;
import me.giopera.Class.Staffer;


public class sl extends Command {

/*  public sl(String name, String permission, String... aliases) {
        super("sl", "StaffList.use", "sl", "stafflist", "liststaff", "ls");
    }
*/
    public sl() {
        super("sl", "StaffList.use", "sl", "stafflist", "liststaff", "ls");
    }


    /*
     * @param commandSender The command sender
     * @param strings Command strings
     */
    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        ComponentBuilder msgOwners = new ComponentBuilder("▪ Owner ").color(ChatColor.DARK_RED).bold(true).append("(").color(ChatColor.GRAY).bold(false);
        ComponentBuilder msgCoOwners = new ComponentBuilder("▪ CoOwner ").color(ChatColor.DARK_RED).bold(true).append("(").color(ChatColor.GRAY).bold(false);
        ComponentBuilder msgSrAdmins = new ComponentBuilder("▪ Sr. Admin ").color(ChatColor.DARK_RED).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgAdminsPlus = new ComponentBuilder("▪ Admin+ ").color(ChatColor.RED).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgAdmins = new ComponentBuilder("▪ Admin ").color(ChatColor.RED).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgCapoStaff = new ComponentBuilder("▪ Capo Staff ").color(ChatColor.BLUE).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgSrMods = new ComponentBuilder("▪ Sr. Mod ").color(ChatColor.DARK_GREEN).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgModsPlus = new ComponentBuilder("▪ Mod+ ").color(ChatColor.of("#3bb33b")).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgMods = new ComponentBuilder("▪ Mod ").color(ChatColor.GREEN).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgHelpersPlus = new ComponentBuilder("▪ Helper+ ").color(ChatColor.of("#3e3ecf")).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgHelpers = new ComponentBuilder("▪ Helper ").color(ChatColor.BLUE).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgCapoBuilder = new ComponentBuilder("▪ Capo Builder ").color(ChatColor.BLUE).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgBulders = new ComponentBuilder("▪ Builder ").color(ChatColor.BLUE).append("(").color(ChatColor.GRAY);

        /*
        ComponentBuilder msgOwners = new ComponentBuilder("");
        ComponentBuilder msgAdmins = new ComponentBuilder("");
        ComponentBuilder msgSrMods = new ComponentBuilder("");
        ComponentBuilder msgMods = new ComponentBuilder("");
        ComponentBuilder msgHelpers = new ComponentBuilder("");
*/
        int owners = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int coOwners = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int srAdmins = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int adminsPlus = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int admins = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int capoStaff = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int srMods = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int modsPlus = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int mods = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int helpersPlus = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int helpers = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int capoBuilder = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        int builder = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();

        msgOwners.append(owners).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgCoOwners.append(coOwners).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgSrAdmins.append(srAdmins).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgAdminsPlus.append(adminsPlus).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgAdmins.append(admins).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgCapoStaff.append(capoStaff).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgSrMods.append(srMods).color(ChatColor.WHITE).append(") ").color(ChatColor.GRAY);
        msgModsPlus.append(modsPlus).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgMods.append(mods).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgHelpersPlus.append(helpersPlus).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgHelpers.append(helpers).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgCapoBuilder.append(capoBuilder).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgBulders.append(builder).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
/*
        msgOwners.append("» ").color(ChatColor.GRAY);
        msgAdmins.append("» ").color(ChatColor.GRAY);
        msgSrMods.append("» ").color(ChatColor.GRAY);
        msgMods.append("» ").color(ChatColor.GRAY);
        msgHelpers.append("» ").color(ChatColor.GRAY);
*/

        for (Staffer s : onlineStaffers) {
            ProxiedPlayer p = s.getPlayer();
            if (s.getRole() == Role.OWNER && !(vanished.contains(p))) {
                msgOwners.append(p.getName()).color(ChatColor.WHITE);
                if(afk.contains(p)) {
                    msgOwners.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgOwners.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgOwners.append(", ");
            }
            if (s.getRole() == Role.COOWNER && !(vanished.contains(p))) {
                msgCoOwners.append(p.getName()).color(ChatColor.WHITE);
                if(afk.contains(p)) {
                    msgCoOwners.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgCoOwners.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgCoOwners.append(", ");
            }
            if (s.getRole() == Role.SRADMIN && !(vanished.contains(p))) {
                msgSrAdmins.append(p.getName()).color(ChatColor.WHITE);
                if(afk.contains(p)) {
                    msgSrAdmins.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgSrAdmins.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgSrAdmins.append(", ");
            }
            if (s.getRole() == Role.SRMOD && !(vanished.contains(p))) {
                msgSrMods.append(p.getName()).color(ChatColor.WHITE);
                if(afk.contains(p)) {
                    msgSrMods.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgSrMods.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgSrMods.append(", ");
            }
            if (s.getRole() == Role.MOD && !(vanished.contains(p))) {
                msgMods.append(p.getName()).color(ChatColor.WHITE);
                if(afk.contains(p)) {
                    msgMods.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgMods.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgMods.append(", ");
            }
            if (s.getRole() == Role.HELPER && !(vanished.contains(p))) {
                msgHelpers.append(p.getName()).color(ChatColor.WHITE);
                if(afk.contains(p)) {
                    msgHelpers.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgHelpers.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgHelpers.append(", ");
            }
            
        }
        msgOwners.removeComponent(msgOwners.getCursor());
        msgAdmins.removeComponent(msgAdmins.getCursor());
        msgSrMods.removeComponent(msgSrMods.getCursor());
        msgMods.removeComponent(msgMods.getCursor());
        msgHelpers.removeComponent(msgHelpers.getCursor());

        ComponentBuilder init = new ComponentBuilder("Staffers Online: ").color(ChatColor.GOLD).bold(true).append("(( Online: ").color(ChatColor.GRAY).italic(true).bold(false).append(Integer.toString(Owners+Admins+SrMods+Mods+Helpers)).color(ChatColor.WHITE).italic(true).append(" ))").color(ChatColor.GRAY).italic(true);
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
