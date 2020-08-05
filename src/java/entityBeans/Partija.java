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

/**
 *
 * @author Legion
 */

@Entity
public class Partija implements Serializable{
    @Id
    @Column
    private int idpartije;
    
    @Column
    private String username1;
    
    @Column
    private String username2;

    public int getIdpartije() {
        return idpartije;
    }

    public void setIdpartije(int idpartije) {
        this.idpartije = idpartije;
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
}
