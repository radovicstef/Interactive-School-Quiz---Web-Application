/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author Legion
 */
public class Rang implements Serializable{
    private int mesto;
    
    private String username;
    
    private int brpoena;

    public int getMesto() {
        return mesto;
    }

    public void setMesto(int mesto) {
        this.mesto = mesto;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBrpoena() {
        return brpoena;
    }

    public void setBrpoena(int brpoena) {
        this.brpoena = brpoena;
    }
    
    public Rang(int rbroj, String username, int brpoena){
        mesto=rbroj;
        this.username=username;
        this.brpoena=brpoena;
    }
    
}
