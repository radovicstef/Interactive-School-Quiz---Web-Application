/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Legion
 */

@Entity
public class Anagrami implements Serializable {
    @Id @GeneratedValue
    @Column
    private int idanagrami;
    
    @Column
    private String tekst;
    
    @Column
    private String resenje;

    public int getIdanagrami() {
        return idanagrami;
    }

    public void setIdanagrami(int idanagrami) {
        this.idanagrami = idanagrami;
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
    
    
}
