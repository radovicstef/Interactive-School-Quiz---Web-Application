/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entityBeans;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 *
 * @author Legion
 */

@Entity
public class Korisnik implements Serializable{
    public static final int NIJE_ODOBREN=-1;
    
    @Id
    @Column
    private String username;
    
    @Column
    private String password;
    
    @Column
    private String ime;
    
    @Column
    private String prezime;
    
    @Column
    private String email;
    
    @Column
    private String zanimanje;
    
    @Column
    private char pol;
    
    @Column
    private BigInteger jmbg;
    
    @Lob
    @Column
    private byte[] slika;
    
    @Column
    private String tajanstveno_pitanje;
    
    @Column
    private String odgovor;
    
    @Column
    private int odobren;

    public int getOdobren() {
        return odobren;
    }

    public void setOdobren(int odobren) {
        this.odobren = odobren;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getZanimanje() {
        return zanimanje;
    }

    public void setZanimanje(String zanimanje) {
        this.zanimanje = zanimanje;
    }

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
        this.pol = pol;
    }

    public BigInteger getJmbg() {
        return jmbg;
    }

    public void setJmbg(BigInteger jmbg) {
        this.jmbg = jmbg;
    }

    public byte[] getSlika() {
        return slika;
    }

    public void setSlika(byte[] slika) {
        this.slika = slika;
    }

    public String getTajanstveno_pitanje() {
        return tajanstveno_pitanje;
    }

    public void setTajanstveno_pitanje(String tajanstveno_pitanje) {
        this.tajanstveno_pitanje = tajanstveno_pitanje;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }
}
