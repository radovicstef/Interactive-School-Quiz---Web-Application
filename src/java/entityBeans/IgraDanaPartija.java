/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Legion
 */
@Entity
@Table(name="igradanapartija")
public class IgraDanaPartija implements Serializable{
    @Id
    @Column
    private int idigradanapartija;
    
    @Column
    private String username;
    
    @Column
    private String datum;
    
    @Column
    private int brpoena;

    public int getIdigradanapartija() {
        return idigradanapartija;
    }

    public void setIdigradanapartija(int idigradanapartija) {
        this.idigradanapartija = idigradanapartija;
    }

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
