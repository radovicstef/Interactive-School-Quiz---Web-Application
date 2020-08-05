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
@Table(name="igramojbroj")
public class IgraMojBroj implements Serializable{
    @Id
    @Column
    private int idigramojbroj;
    
    @Column
    private int idigranapartija;
    
    @Column
    private int glavnibr;
    
    @Column
    private int jednocifr1;
    
    @Column
    private int jednocifr2;
    
    @Column
    private int jednocifr3;
    
    @Column
    private int jednocifr4;
    
    @Column
    private int dvocifrenimali;
    
    @Column
    private int dvocifreniveliki;
    
    @Column
    private int odgovorusername1;
    
    @Column
    private int odgovorusername2;
    
    @Column
    private int igrase;
    
    @Column
    private boolean zakljucan1;
    
    @Column
    private boolean zakljucan2;
    
    @Column
    private String username1;
    
    @Column
    private String username2;

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

    public int getIdigramojbroj() {
        return idigramojbroj;
    }

    public void setIdigramojbroj(int idigramojbroj) {
        this.idigramojbroj = idigramojbroj;
    }

    public int getIdigranapartija() {
        return idigranapartija;
    }

    public void setIdigranapartija(int idigranapartija) {
        this.idigranapartija = idigranapartija;
    }

    public int getGlavnibr() {
        return glavnibr;
    }

    public void setGlavnibr(int glavnibr) {
        this.glavnibr = glavnibr;
    }

    public int getJednocifr1() {
        return jednocifr1;
    }

    public void setJednocifr1(int jednocifr1) {
        this.jednocifr1 = jednocifr1;
    }

    public int getJednocifr2() {
        return jednocifr2;
    }

    public void setJednocifr2(int jednocifr2) {
        this.jednocifr2 = jednocifr2;
    }

    public int getJednocifr3() {
        return jednocifr3;
    }

    public void setJednocifr3(int jednocifr3) {
        this.jednocifr3 = jednocifr3;
    }

    public int getJednocifr4() {
        return jednocifr4;
    }

    public void setJednocifr4(int jednocifr4) {
        this.jednocifr4 = jednocifr4;
    }

    public int getDvocifrenimali() {
        return dvocifrenimali;
    }

    public void setDvocifrenimali(int dvocifrenimali) {
        this.dvocifrenimali = dvocifrenimali;
    }

    public int getDvocifreniveliki() {
        return dvocifreniveliki;
    }

    public void setDvocifreniveliki(int dvocifreniveliki) {
        this.dvocifreniveliki = dvocifreniveliki;
    }

    public int getOdgovorusername1() {
        return odgovorusername1;
    }

    public void setOdgovorusername1(int odgovorusername1) {
        this.odgovorusername1 = odgovorusername1;
    }

    public int getOdgovorusername2() {
        return odgovorusername2;
    }

    public void setOdgovorusername2(int odgovorusername2) {
        this.odgovorusername2 = odgovorusername2;
    }

    public int getIgrase() {
        return igrase;
    }

    public void setIgrase(int igrase) {
        this.igrase = igrase;
    }

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
    
    
}
