/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Legion
 */

@Entity
@Table(name="igravesanja")
public class IgraVesanja implements Serializable {
    @Id
    @Column
    private int idigravesanja;
    
    @Column
    private int idigranapartija;
    
    @Column
    private String rec;
    
    @Column
    private String username1;
    
    @Column
    private String username2;
    
    @Column
    private boolean igrase;
    
    //0 - igra plavi, 1 - igra crveni
    @Column
    private int koigra;
    
    @Column
    private int brpromasenih1;
    
    @Column
    private int brpromasenih2;
    
    @Column
    private String pogodjenaslova;
    
    @Column
    private String promasenaslova;
    
    @Column
    private int brpoena1;
    
    @Column
    private  int brpoena2;

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

    public String getPromasenaslova() {
        return promasenaslova;
    }

    public void setPromasenaslova(String promasenaslova) {
        this.promasenaslova = promasenaslova;
    }

    public int getIdigravesanja() {
        return idigravesanja;
    }

    public void setIdigravesanja(int idigravesanja) {
        this.idigravesanja = idigravesanja;
    }

    public int getIdigranapartija() {
        return idigranapartija;
    }

    public void setIdigranapartija(int idigranapartija) {
        this.idigranapartija = idigranapartija;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
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

    public boolean isIgrase() {
        return igrase;
    }

    public void setIgrase(boolean igrase) {
        this.igrase = igrase;
    }

    public int getKoigra() {
        return koigra;
    }

    public void setKoigra(int koigra) {
        this.koigra = koigra;
    }

    public int getBrpromasenih1() {
        return brpromasenih1;
    }

    public void setBrpromasenih1(int brpromasenih1) {
        this.brpromasenih1 = brpromasenih1;
    }

    public int getBrpromasenih2() {
        return brpromasenih2;
    }

    public void setBrpromasenih2(int brpromasenih2) {
        this.brpromasenih2 = brpromasenih2;
    }

    public String getPogodjenaslova() {
        return pogodjenaslova;
    }

    public void setPogodjenaslova(String pogodjenaslova) {
        this.pogodjenaslova = pogodjenaslova;
    }
    
    
}
