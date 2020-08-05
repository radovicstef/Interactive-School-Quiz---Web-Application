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
@Table(name="igrazgeos")
public class IgraZgeos implements Serializable{
    @Id
    @Column
    private int idigrazgeos;
    
    @Column
    private int idigranapartija;
    
    @Column
    private char slovo;
    
    @Column
    private String username1;
    
    @Column
    private String username2;
    
    @Column
    private int koigra;
    
    @Column
    private boolean igrase;
    
    @Column
    private String drzava;
    
    @Column
    private String grad;
    
    @Column
    private String reka;
    
    @Column
    private String jezero;
    
    @Column
    private String planina;
    
    @Column
    private String zivotinja;
    
    @Column
    private String biljka;
    
    @Column
    private String grupa;
    
    @Column
    private int brpoena1;
    
    @Column
    private int brpoena2;
    
    @Column
    private boolean zavrsenarevizija;
    
    @Column
    private boolean zakljucanodgovor1;
    
    @Column
    private boolean zakljucanodgovor2;

    public boolean isZakljucanodgovor1() {
        return zakljucanodgovor1;
    }

    public void setZakljucanodgovor1(boolean zakljucanodgovor1) {
        this.zakljucanodgovor1 = zakljucanodgovor1;
    }

    public boolean isZakljucanodgovor2() {
        return zakljucanodgovor2;
    }

    public void setZakljucanodgovor2(boolean zakljucanodgovor2) {
        this.zakljucanodgovor2 = zakljucanodgovor2;
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

    public boolean isZavrsenarevizija() {
        return zavrsenarevizija;
    }

    public void setZavrsenarevizija(boolean zavrsenarevizija) {
        this.zavrsenarevizija = zavrsenarevizija;
    }

    public int getIdigrazgeos() {
        return idigrazgeos;
    }

    public void setIdigrazgeos(int idigrazgeos) {
        this.idigrazgeos = idigrazgeos;
    }

    public int getIdigranapartija() {
        return idigranapartija;
    }

    public void setIdigranapartija(int idigranapartija) {
        this.idigranapartija = idigranapartija;
    }

    public char getSlovo() {
        return slovo;
    }

    public void setSlovo(char slovo) {
        this.slovo = slovo;
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

    public int getKoigra() {
        return koigra;
    }

    public void setKoigra(int koigra) {
        this.koigra = koigra;
    }

    public boolean isIgrase() {
        return igrase;
    }

    public void setIgrase(boolean igrase) {
        this.igrase = igrase;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getReka() {
        return reka;
    }

    public void setReka(String reka) {
        this.reka = reka;
    }

    public String getJezero() {
        return jezero;
    }

    public void setJezero(String jezero) {
        this.jezero = jezero;
    }

    public String getPlanina() {
        return planina;
    }

    public void setPlanina(String planina) {
        this.planina = planina;
    }

    public String getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(String zivotinja) {
        this.zivotinja = zivotinja;
    }

    public String getBiljka() {
        return biljka;
    }

    public void setBiljka(String biljka) {
        this.biljka = biljka;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }
    
    
}
