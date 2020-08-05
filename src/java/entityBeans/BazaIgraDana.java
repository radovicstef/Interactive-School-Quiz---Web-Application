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
@Table(name="bazaigradana")
public class BazaIgraDana implements Serializable{
    @Id
    @Column
    private int idbazaigradana;
    
    @Column
    private String tipigre;
    
    @Column
    private String datum;
    
    @Column
    private int idigre;

    public int getIdbazaigradana() {
        return idbazaigradana;
    }

    public void setIdbazaigradana(int idbazaigradana) {
        this.idbazaigradana = idbazaigradana;
    }

    public String getTipigre() {
        return tipigre;
    }

    public void setTipigre(String tipigre) {
        this.tipigre = tipigre;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getIdigre() {
        return idigre;
    }

    public void setIdigre(int idigre) {
        this.idigre = idigre;
    }
}
