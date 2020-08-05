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
@Table(name="igrapehar")
public class IgraPehar implements Serializable{
    @Id
    @Column
    private int idigrapehar;
    
    @Column
    private int idigranapartija;
    
    @Column
    private int idpitanjaubazi;
    
    @Column
    private int pogodio1;
    
    @Column
    private int pogodio2;
    
    @Column
    private int pogodio3;
    
    @Column
    private int pogodio4;
    
    @Column
    private int pogodio5;
    
    @Column
    private int pogodio6;
    
    @Column
    private int pogodio7;
    
    @Column
    private int pogodio8;
    
    @Column
    private int pogodio9;
    
    @Column
    private int pogodio10;
    
    @Column
    private int pogodio11;
    
    @Column
    private int pogodio12;
    
    @Column
    private int pogodio13;
    
    @Column
    private int pogodio14;
    
    @Column
    private int koigra;
    
    @Column
    private boolean igrase;
    
    @Column
    private String username1;
    
    @Column
    private String username2;
    
    @Column
    private int brpoena1;
    
    @Column
    private int brpoena2;
    
    @Column
    private int brpitanja;

    public int getBrpitanja() {
        return brpitanja;
    }

    public void setBrpitanja(int brpitanja) {
        this.brpitanja = brpitanja;
    }

    public int getIdigrapehar() {
        return idigrapehar;
    }

    public void setIdigrapehar(int idigrapehar) {
        this.idigrapehar = idigrapehar;
    }

    public int getIdigranapartija() {
        return idigranapartija;
    }

    public void setIdigranapartija(int idigranapartija) {
        this.idigranapartija = idigranapartija;
    }

    public int getIdpitanjaubazi() {
        return idpitanjaubazi;
    }

    public void setIdpitanjaubazi(int idpitanjaubazi) {
        this.idpitanjaubazi = idpitanjaubazi;
    }

    public int getPogodio1() {
        return pogodio1;
    }

    public void setPogodio1(int pogodio1) {
        this.pogodio1 = pogodio1;
    }

    public int getPogodio2() {
        return pogodio2;
    }

    public void setPogodio2(int pogodio2) {
        this.pogodio2 = pogodio2;
    }

    public int getPogodio3() {
        return pogodio3;
    }

    public void setPogodio3(int pogodio3) {
        this.pogodio3 = pogodio3;
    }

    public int getPogodio4() {
        return pogodio4;
    }

    public void setPogodio4(int pogodio4) {
        this.pogodio4 = pogodio4;
    }

    public int getPogodio5() {
        return pogodio5;
    }

    public void setPogodio5(int pogodio5) {
        this.pogodio5 = pogodio5;
    }

    public int getPogodio6() {
        return pogodio6;
    }

    public void setPogodio6(int pogodio6) {
        this.pogodio6 = pogodio6;
    }

    public int getPogodio7() {
        return pogodio7;
    }

    public void setPogodio7(int pogodio7) {
        this.pogodio7 = pogodio7;
    }

    public int getPogodio8() {
        return pogodio8;
    }

    public void setPogodio8(int pogodio8) {
        this.pogodio8 = pogodio8;
    }

    public int getPogodio9() {
        return pogodio9;
    }

    public void setPogodio9(int pogodio9) {
        this.pogodio9 = pogodio9;
    }

    public int getPogodio10() {
        return pogodio10;
    }

    public void setPogodio10(int pogodio10) {
        this.pogodio10 = pogodio10;
    }

    public int getPogodio11() {
        return pogodio11;
    }

    public void setPogodio11(int pogodio11) {
        this.pogodio11 = pogodio11;
    }

    public int getPogodio12() {
        return pogodio12;
    }

    public void setPogodio12(int pogodio12) {
        this.pogodio12 = pogodio12;
    }

    public int getPogodio13() {
        return pogodio13;
    }

    public void setPogodio13(int pogodio13) {
        this.pogodio13 = pogodio13;
    }

    public int getPogodio14() {
        return pogodio14;
    }

    public void setPogodio14(int pogodio14) {
        this.pogodio14 = pogodio14;
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
    
    
}
