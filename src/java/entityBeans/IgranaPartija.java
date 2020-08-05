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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Legion
 */

@Entity
@Table(name = "igranapartija")
public class IgranaPartija implements Serializable{
    @Id
    @Column
    private int idigranapartija;
    
    @Column
    private String username1;
    
    @Column
    private String username2;
    
    @Column
    private int poeni1;
    
    @Column
    private int poeni2;
    
    @Column
    private String ishod;
    
    @Column
    private Date datum;
    
    @Column
    private int anagram1;
    
    @Column
    private int anagram2;
    
    @Column
    private int mojbroj1;
    
    @Column
    private int mojbroj2;
    
    @Column
    private int vesanje1;
    
    @Column
    private int vesanje2;
    
    @Column
    private int zanimljivageografija1;
    
    @Column
    private int zanimljivageografija2;
    
    @Column
    private int pehar1;
    
    @Column
    private int pehar2;
    
    @Column
    private int pogledano;

    public int getAnagram1() {
        return anagram1;
    }

    public void setAnagram1(int anagram1) {
        this.anagram1 = anagram1;
    }

    public int getAnagram2() {
        return anagram2;
    }

    public void setAnagram2(int anagram2) {
        this.anagram2 = anagram2;
    }

    public int getMojbroj1() {
        return mojbroj1;
    }

    public void setMojbroj1(int mojbroj1) {
        this.mojbroj1 = mojbroj1;
    }

    public int getMojbroj2() {
        return mojbroj2;
    }

    public void setMojbroj2(int mojbroj2) {
        this.mojbroj2 = mojbroj2;
    }

    public int getVesanje1() {
        return vesanje1;
    }

    public void setVesanje1(int vesanje1) {
        this.vesanje1 = vesanje1;
    }

    public int getVesanje2() {
        return vesanje2;
    }

    public void setVesanje2(int vesanje2) {
        this.vesanje2 = vesanje2;
    }

    public int getZanimljivageografija1() {
        return zanimljivageografija1;
    }

    public void setZanimljivageografija1(int zanimljivageografija1) {
        this.zanimljivageografija1 = zanimljivageografija1;
    }

    public int getZanimljivageografija2() {
        return zanimljivageografija2;
    }

    public void setZanimljivageografija2(int zanimljivageografija2) {
        this.zanimljivageografija2 = zanimljivageografija2;
    }

    public int getPehar1() {
        return pehar1;
    }

    public void setPehar1(int pehar1) {
        this.pehar1 = pehar1;
    }

    public int getPehar2() {
        return pehar2;
    }

    public void setPehar2(int pehar2) {
        this.pehar2 = pehar2;
    }

    public int getPogledano() {
        return pogledano;
    }

    public void setPogledano(int pogledano) {
        this.pogledano = pogledano;
    }

    public int getIdigranapartija() {
        return idigranapartija;
    }

    public void setIdigranapartija(int idigranapartija) {
        this.idigranapartija = idigranapartija;
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

    public int getPoeni1() {
        return poeni1;
    }

    public void setPoeni1(int poeni1) {
        this.poeni1 = poeni1;
    }

    public int getPoeni2() {
        return poeni2;
    }

    public void setPoeni2(int poeni2) {
        this.poeni2 = poeni2;
    }

    public String getIshod() {
        return ishod;
    }

    public void setIshod(String ishod) {
        this.ishod = ishod;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }
    
    
}
