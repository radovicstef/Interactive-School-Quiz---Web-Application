/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Legion
 */

@Entity
@ManagedBean(name="revizijareci")
public class RevizijaReci implements Serializable{
    @Id
    @Column
    private int idrevizijareci;
    
    @Column
    private int idzgeosigre;
    
    @Column
    private char slovo;
    
    @Column
    private String tip;
    
    @Column
    private String tekst;
    
    @Column
    private boolean prihvaceno;
    
    @Column
    private int brpoenadodato;
    
    @Column
    private String komedodajem;

    public int getBrpoenadodato() {
        return brpoenadodato;
    }

    public void setBrpoenadodato(int brpoenadodato) {
        this.brpoenadodato = brpoenadodato;
    }

    public String getKomedodajem() {
        return komedodajem;
    }

    public void setKomedodajem(String komedodajem) {
        this.komedodajem = komedodajem;
    }

    public int getIdrevizijareci() {
        return idrevizijareci;
    }

    public void setIdrevizijareci(int idrevizijareci) {
        this.idrevizijareci = idrevizijareci;
    }

    public int getIdzgeosigre() {
        return idzgeosigre;
    }

    public void setIdzgeosigre(int idzgeosigre) {
        this.idzgeosigre = idzgeosigre;
    }

    public char getSlovo() {
        return slovo;
    }

    public void setSlovo(char slovo) {
        this.slovo = slovo;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public boolean isPrihvaceno() {
        return prihvaceno;
    }

    public void setPrihvaceno(boolean prihvaceno) {
        this.prihvaceno = prihvaceno;
    }
}
