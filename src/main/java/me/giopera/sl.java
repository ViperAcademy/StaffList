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
        ComponentBuilder msgAdminsPlus = new ComponentBuilder("▪ Admin+ ").color(ChatColor.of("#940000")).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgAdmins = new ComponentBuilder("▪ Admin ").color(ChatColor.RED).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgCapoStaff = new ComponentBuilder("▪ Capo Staff ").color(ChatColor.of("#3dcbff")).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgSrMods = new ComponentBuilder("▪ Sr. Mod ").color(ChatColor.GREEN).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgModsPlus = new ComponentBuilder("▪ Mod+ ").color(ChatColor.of("#42c742")).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgMods = new ComponentBuilder("▪ Mod ").color(ChatColor.DARK_GREEN).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgHelpersPlus = new ComponentBuilder("▪ Helper+ ").color(ChatColor.of("#3e3ecf")).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgHelpers = new ComponentBuilder("▪ Helper ").color(ChatColor.BLUE).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgCapoBuilder = new ComponentBuilder("▪ Capo Builder ").color(ChatColor.of("#7d00d1")).append("(").color(ChatColor.GRAY);
        ComponentBuilder msgBuilders = new ComponentBuilder("▪ Builder ").color(ChatColor.of("#a000d1")).append("(").color(ChatColor.GRAY);

        long owners = onlineStaffers.stream().filter(s -> Role.OWNER.equals(s.getRole())).count();
        long coOwners = onlineStaffers.stream().filter(s -> Role.COOWNER.equals(s.getRole())).count();
        long srAdmins = onlineStaffers.stream().filter(s -> Role.SRADMIN.equals(s.getRole())).count();
        long adminsPlus = onlineStaffers.stream().filter(s -> Role.ADMINPLUS.equals(s.getRole())).count();
        long admins = onlineStaffers.stream().filter(s -> Role.ADMIN.equals(s.getRole())).count();
        long capoStaff = onlineStaffers.stream().filter(s -> Role.CAPOSTAFF.equals(s.getRole())).count();
        long srMods = onlineStaffers.stream().filter(s -> Role.SRMOD.equals(s.getRole())).count();
        long modsPlus = onlineStaffers.stream().filter(s -> Role.MODPLUS.equals(s.getRole())).count();
        long mods = onlineStaffers.stream().filter(s -> Role.MOD.equals(s.getRole())).count();
        long helpersPlus = onlineStaffers.stream().filter(s -> Role.HELPERPLUS.equals(s.getRole())).count();
        long helpers = onlineStaffers.stream().filter(s -> Role.HELPER.equals(s.getRole())).count();
        long capoBuilder = onlineStaffers.stream().filter(s -> Role.CAPOBUILDER.equals(s.getRole())).count();
        long builder = onlineStaffers.stream().filter(s -> Role.BUILDER.equals(s.getRole())).count();

        msgOwners.append(Long.toString(owners)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgCoOwners.append(Long.toString(coOwners)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgSrAdmins.append(Long.toString(srAdmins)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgAdminsPlus.append(Long.toString(adminsPlus)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgAdmins.append(Long.toString(admins)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgCapoStaff.append(Long.toString(capoStaff)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgSrMods.append(Long.toString(srMods)).color(ChatColor.WHITE).append(") ").color(ChatColor.GRAY);
        msgModsPlus.append(Long.toString(modsPlus)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgMods.append(Long.toString(mods)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgHelpersPlus.append(Long.toString(helpersPlus)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgHelpers.append(Long.toString(helpers)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgCapoBuilder.append(Long.toString(capoBuilder)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);
        msgBuilders.append(Long.toString(builder)).color(ChatColor.WHITE).append(") » ").color(ChatColor.GRAY);

        for (Staffer s : onlineStaffers) {
            ProxiedPlayer p = s.getPlayer();
            if (s.getRole() == Role.OWNER && !(vanished.contains(p))) {
                msgOwners.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgOwners.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgOwners.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgOwners.append(", ");
            }
            if (s.getRole() == Role.COOWNER && !(vanished.contains(p))) {
                msgCoOwners.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgCoOwners.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgCoOwners.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgCoOwners.append(", ");
            }
            if (s.getRole() == Role.SRADMIN && !(vanished.contains(p))) {
                msgSrAdmins.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgSrAdmins.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgSrAdmins.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgSrAdmins.append(", ");
            }
            if (s.getRole() == Role.ADMINPLUS && !(vanished.contains(p))) {
                msgAdminsPlus.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgAdminsPlus.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgAdminsPlus.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgAdminsPlus.append(", ");
            }
            if (s.getRole() == Role.ADMIN && !(vanished.contains(p))) {
                msgAdmins.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgAdmins.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgAdmins.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgAdmins.append(", ");
            }
            if (s.getRole() == Role.CAPOSTAFF && !(vanished.contains(p))) {
                msgCapoStaff.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgCapoStaff.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgCapoStaff.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgCapoStaff.append(", ");
            }
            if (s.getRole() == Role.SRMOD && !(vanished.contains(p))) {
                msgSrMods.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgSrMods.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgSrMods.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgSrMods.append(", ");
            }
            if (s.getRole() == Role.MODPLUS && !(vanished.contains(p))) {
                msgModsPlus.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgModsPlus.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgModsPlus.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgModsPlus.append(", ");
            }
            if (s.getRole() == Role.MOD && !(vanished.contains(p))) {
                msgMods.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgMods.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgMods.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgMods.append(", ");
            }
            if (s.getRole() == Role.HELPERPLUS && !(vanished.contains(p))) {
                msgHelpersPlus.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgHelpersPlus.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgHelpersPlus.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgHelpersPlus.append(", ");
            }
            if (s.getRole() == Role.HELPER && !(vanished.contains(p))) {
                msgHelpers.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgHelpers.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgHelpers.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgHelpers.append(", ");
            }
            if (s.getRole() == Role.CAPOBUILDER && !(vanished.contains(p))) {
                msgCapoBuilder.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgCapoBuilder.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgCapoBuilder.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgCapoBuilder.append(", ");
            }
            if (s.getRole() == Role.BUILDER && !(vanished.contains(p))) {
                msgBuilders.append(p.getName()).color(ChatColor.WHITE);
                if(afkPlayers.contains(p)) {
                    msgBuilders.append(" [AFK]").color(ChatColor.GRAY).italic(true);
                    msgBuilders.append(", ").color(ChatColor.WHITE).italic(false);
                } else
                    msgBuilders.append(", ");
            }
        }
        msgOwners.removeComponent(msgOwners.getCursor());
        msgCoOwners.removeComponent(msgCoOwners.getCursor());
        msgSrAdmins.removeComponent(msgSrAdmins.getCursor());
        msgAdminsPlus.removeComponent(msgAdminsPlus.getCursor());
        msgAdmins.removeComponent(msgAdmins.getCursor());
        msgCapoStaff.removeComponent(msgCapoStaff.getCursor());
        msgSrMods.removeComponent(msgSrMods.getCursor());
        msgModsPlus.removeComponent(msgModsPlus.getCursor());
        msgMods.removeComponent(msgMods.getCursor());
        msgHelpersPlus.removeComponent(msgHelpersPlus.getCursor());
        msgHelpers.removeComponent(msgHelpers.getCursor());
        msgCapoBuilder.removeComponent(msgCapoBuilder.getCursor());
        msgBuilders.removeComponent(msgBuilders.getCursor());

        ComponentBuilder init = new ComponentBuilder("Staffers Online: ").color(ChatColor.GOLD).bold(true).append("(( Online: ").color(ChatColor.GRAY).italic(true).bold(false).append(Long.toString(owners+coOwners+srAdmins+adminsPlus+admins+capoStaff+srMods+modsPlus+mods+helpersPlus+helpers+capoBuilder+builder)).color(ChatColor.WHITE).italic(true).append(" ))").color(ChatColor.GRAY).italic(true);
        boolean isThereAnybodyOnline = owners == 0 && srAdmins == 0 && adminsPlus == 0 && admins == 0 && capoStaff == 0 && srMods == 0 && modsPlus == 0 && mods == 0 && helpersPlus == 0 && helpers == 0 && capoBuilder == 0 && builder == 0;
        if(!(isThereAnybodyOnline))
            commandSender.sendMessage(init.create());
        if(owners != 0)
            commandSender.sendMessage(msgOwners.create());
        if(coOwners != 0)
            commandSender.sendMessage(msgCoOwners.create());
        if(srAdmins != 0)
            commandSender.sendMessage(msgSrAdmins.create());
        if(adminsPlus != 0)
            commandSender.sendMessage(msgAdminsPlus.create());
        if(admins != 0)
            commandSender.sendMessage(msgAdmins.create());
        if(capoStaff != 0)
            commandSender.sendMessage(msgCapoStaff.create());
        if(srMods != 0)
            commandSender.sendMessage(msgSrMods.create());
        if(modsPlus != 0)
            commandSender.sendMessage(msgModsPlus.create());
        if(mods != 0)
            commandSender.sendMessage(msgMods.create());
        if(helpersPlus != 0)
            commandSender.sendMessage(msgHelpersPlus.create());
        if(helpers != 0)
            commandSender.sendMessage(msgHelpers.create());
        if(capoBuilder != 0)
            commandSender.sendMessage(msgCapoBuilder.create());
        if(builder != 0)
            commandSender.sendMessage(msgBuilders.create());

        if(isThereAnybodyOnline){
            ComponentBuilder noStaff = new ComponentBuilder("Attualmente non ci sono staffers online").color(ChatColor.RED);
            commandSender.sendMessage(noStaff.create());
        }
    }
}
