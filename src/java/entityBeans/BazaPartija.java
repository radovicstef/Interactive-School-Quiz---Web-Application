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
@Table(name="bazapartija")
public class BazaPartija implements Serializable{
    @Id
    @Column
    private int idbazapartija;
    
    @Column
    private String username1;
    
    @Column
    private String username2;
    
    @Column
    private int brpoena1;
    
    @Column
    private int brpoena2;
    
    @Column
    private String rezultat;
    
    @Column
    private Date datum;

    public int getIdbazapartija() {
        return idbazapartija;
    }

    public void setIdbazapartija(int idbazapartija) {
        this.idbazapartija = idbazapartija;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public int getBrpoena1() {
        return brpoena1;
    }

    public void setBrpoena1(int brpoena1) {
        this.brpoena1 = brpoena1;
    }

    public int getBrpoena2() {
        return brpoena2;
    }

    public void setBrpoena2(int brpoena2) {
        this.brpoena2 = brpoena2;
    }

    public String getRezultat() {
        return rezultat;
    }

    public void setRezultat(String rezultat) {
        this.rezultat = rezultat;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
}
