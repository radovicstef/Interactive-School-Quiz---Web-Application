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
public class MesecniRang implements Serializable{
    private String username;
    private String datum;
    private int brpoena;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getBrpoena() {
        return brpoena;
    }

    public void setBrpoena(int brpoena) {
        this.brpoena = brpoena;
    }
    
    
}
