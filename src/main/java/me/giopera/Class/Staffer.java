package me.giopera.Class;

import net.md_5.bungee.api.connection.ProxiedPlayer;

public class Staffer {

    private ProxiedPlayer p;
    private Role r;

    public Staffer (ProxiedPlayer p){
        this.p = p;
    }
    public Staffer (ProxiedPlayer p, Role r){
        this.p = p;
        this.r = r;
    }

    public Role getRole(){
        return r;
    }

    public ProxiedPlayer getPlayer(){
        return p;
    }

    public void setPlayer(ProxiedPlayer p){
        this.p = p;
    }

    public void setRole(Role r){
        this.r = r;
    }
}
