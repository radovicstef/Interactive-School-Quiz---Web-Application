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
@Table(name="vesanja")
public class Vesanja implements Serializable{
    @Id
    @Column
    private int idvesanja;
    
    @Column
    private String rec;

    public int getIdvesanja() {
        return idvesanja;
    }

    public void setIdvesanja(int idvesanja) {
        this.idvesanja = idvesanja;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }
}
