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
@Table(name="igraanagrami")
public class IgraAnagrami implements Serializable{
    @Id
    private int idigraanagrami;
    
    @Column
    private int idigranapartija;
    
    @Column
    private String odgovorusername1;
    
    @Column
    private String odgovorusername2;
    
    @Column
    private int igrase;
    
    @Column
    private String tekst;
    
    @Column
    private String resenje;
    
    @Column
    private String username1;
    
    @Column
    private String username2;
    
    @Column
    private boolean zakljucan1;
    
    @Column
    private boolean zakljucan2;

    public boolean isZakljucan1() {
        return zakljucan1;
    }

    public void setZakljucan1(boolean zakljucan1) {
        this.zakljucan1 = zakljucan1;
    }

    public boolean isZakljucan2() {
        return zakljucan2;
    }

    public void setZakljucan2(boolean zakljucan2) {
        this.zakljucan2 = zakljucan2;
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

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public String getResenje() {
        return resenje;
    }

    public void setResenje(String resenje) {
        this.resenje = resenje;
    }

    public int getIgrase() {
        return igrase;
    }

    public void setIgrase(int igrase) {
        this.igrase = igrase;
    }

    public int getIdigraanagrami() {
        return idigraanagrami;
    }

    public void setIdigraanagrami(int idigraanagrami) {
        this.idigraanagrami = idigraanagrami;
    }

    public int getIdigranapartija() {
        return idigranapartija;
    }

    public void setIdigranapartija(int idigranapartija) {
        this.idigranapartija = idigranapartija;
    }

    public String getOdgovorusername1() {
        return odgovorusername1;
    }

    public void setOdgovorusername1(String odgovorusername1) {
        this.odgovorusername1 = odgovorusername1;
    }

    public String getOdgovorusername2() {
        return odgovorusername2;
    }

    public void setOdgovorusername2(String odgovorusername2) {
        this.odgovorusername2 = odgovorusername2;
    }
    
    
}
