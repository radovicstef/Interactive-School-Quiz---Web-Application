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
@Table(name="bazareci")
public class BazaReci implements Serializable{
    @Id
    @Column
    private int idrec;
    
    @Column
    private char pocetnoslovo;
    
    @Column
    private String rec;
    
    @Column
    private String tip;

    public int getIdrec() {
        return idrec;
    }

    public void setIdrec(int idrec) {
        this.idrec = idrec;
    }

    public char getPocetnoslovo() {
        return pocetnoslovo;
    }

    public void setPocetnoslovo(char pocetnoslovo) {
        this.pocetnoslovo = pocetnoslovo;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
    
    
}
