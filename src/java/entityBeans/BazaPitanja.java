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
@Table(name="bazapitanja")
public class BazaPitanja implements Serializable {
    @Id
    @Column
    private int idbazapitanja;
    
    @Column
    private String pitanjeprvo9;
    
    @Column
    private String pitanjeprvo8;
    
    @Column
    private String pitanjeprvo7;
    
    @Column
    private String pitanjeprvo6;
    
    @Column
    private String pitanjeprvo5;
    
    @Column
    private String pitanjeprvo4;
    
    @Column
    private String pitanjeprvo3;
    
    @Column
    private String odgovorprvi9;
    
    @Column
    private String odgovorprvi8;
    
    @Column
    private String odgovorprvi7;
    
    @Column
    private String odgovorprvi6;
    
    @Column
    private String odgovorprvi5;
    
    @Column
    private String odgovorprvi4;
    
    @Column
    private String odgovorprvi3;
    
     @Column
    private String pitanjedrugo9;
    
    @Column
    private String pitanjedrugo8;
    
    @Column
    private String pitanjedrugo7;
    
    @Column
    private String pitanjedrugo6;
    
    @Column
    private String pitanjedrugo5;
    
    @Column
    private String pitanjedrugo4;
    
    @Column
    private String pitanjedrugo3;
    
    @Column
    private String odgovordrugi9;
    
    @Column
    private String odgovordrugi8;
    
    @Column
    private String odgovordrugi7;
    
    @Column
    private String odgovordrugi6;
    
    @Column
    private String odgovordrugi5;
    
    @Column
    private String odgovordrugi4;
    
    @Column
    private String odgovordrugi3;

    public int getIdbazapitanja() {
        return idbazapitanja;
    }

    public void setIdbazapitanja(int idbazapitanja) {
        this.idbazapitanja = idbazapitanja;
    }

    public String getPitanjeprvo9() {
        return pitanjeprvo9;
    }

    public void setPitanjeprvo9(String pitanjeprvo9) {
        this.pitanjeprvo9 = pitanjeprvo9;
    }

    public String getPitanjeprvo8() {
        return pitanjeprvo8;
    }

    public void setPitanjeprvo8(String pitanjeprvo8) {
        this.pitanjeprvo8 = pitanjeprvo8;
    }

    public String getPitanjeprvo7() {
        return pitanjeprvo7;
    }

    public void setPitanjeprvo7(String pitanjeprvo7) {
        this.pitanjeprvo7 = pitanjeprvo7;
    }

    public String getPitanjeprvo6() {
        return pitanjeprvo6;
    }

    public void setPitanjeprvo6(String pitanjeprvo6) {
        this.pitanjeprvo6 = pitanjeprvo6;
    }

    public String getPitanjeprvo5() {
        return pitanjeprvo5;
    }

    public void setPitanjeprvo5(String pitanjeprvo5) {
        this.pitanjeprvo5 = pitanjeprvo5;
    }

    public String getPitanjeprvo4() {
        return pitanjeprvo4;
    }

    public void setPitanjeprvo4(String pitanjeprvo4) {
        this.pitanjeprvo4 = pitanjeprvo4;
    }

    public String getPitanjeprvo3() {
        return pitanjeprvo3;
    }

    public void setPitanjeprvo3(String pitanjeprvo3) {
        this.pitanjeprvo3 = pitanjeprvo3;
    }

    public String getOdgovorprvi9() {
        return odgovorprvi9;
    }

    public void setOdgovorprvi9(String odgovorprvi9) {
        this.odgovorprvi9 = odgovorprvi9;
    }

    public String getOdgovorprvi8() {
        return odgovorprvi8;
    }

    public void setOdgovorprvi8(String odgovorprvi8) {
        this.odgovorprvi8 = odgovorprvi8;
    }

    public String getOdgovorprvi7() {
        return odgovorprvi7;
    }

    public void setOdgovorprvi7(String odgovorprvi7) {
        this.odgovorprvi7 = odgovorprvi7;
    }

    public String getOdgovorprvi6() {
        return odgovorprvi6;
    }

    public void setOdgovorprvi6(String odgovorprvi6) {
        this.odgovorprvi6 = odgovorprvi6;
    }

    public String getOdgovorprvi5() {
        return odgovorprvi5;
    }

    public void setOdgovorprvi5(String odgovorprvi5) {
        this.odgovorprvi5 = odgovorprvi5;
    }

    public String getOdgovorprvi4() {
        return odgovorprvi4;
    }

    public void setOdgovorprvi4(String odgovorprvi4) {
        this.odgovorprvi4 = odgovorprvi4;
    }

    public String getOdgovorprvi3() {
        return odgovorprvi3;
    }

    public void setOdgovorprvi3(String odgovorprvi3) {
        this.odgovorprvi3 = odgovorprvi3;
    }

    public String getPitanjedrugo9() {
        return pitanjedrugo9;
    }

    public void setPitanjedrugo9(String pitanjedrugo9) {
        this.pitanjedrugo9 = pitanjedrugo9;
    }

    public String getPitanjedrugo8() {
        return pitanjedrugo8;
    }

    public void setPitanjedrugo8(String pitanjedrugo8) {
        this.pitanjedrugo8 = pitanjedrugo8;
    }

    public String getPitanjedrugo7() {
        return pitanjedrugo7;
    }

    public void setPitanjedrugo7(String pitanjedrugo7) {
        this.pitanjedrugo7 = pitanjedrugo7;
    }

    public String getPitanjedrugo6() {
        return pitanjedrugo6;
    }

    public void setPitanjedrugo6(String pitanjedrugo6) {
        this.pitanjedrugo6 = pitanjedrugo6;
    }

    public String getPitanjedrugo5() {
        return pitanjedrugo5;
    }

    public void setPitanjedrugo5(String pitanjedrugo5) {
        this.pitanjedrugo5 = pitanjedrugo5;
    }

    public String getPitanjedrugo4() {
        return pitanjedrugo4;
    }

    public void setPitanjedrugo4(String pitanjedrugo4) {
        this.pitanjedrugo4 = pitanjedrugo4;
    }

    public String getPitanjedrugo3() {
        return pitanjedrugo3;
    }

    public void setPitanjedrugo3(String pitanjedrugo3) {
        this.pitanjedrugo3 = pitanjedrugo3;
    }

    public String getOdgovordrugi9() {
        return odgovordrugi9;
    }

    public void setOdgovordrugi9(String odgovordrugi9) {
        this.odgovordrugi9 = odgovordrugi9;
    }

    public String getOdgovordrugi8() {
        return odgovordrugi8;
    }

    public void setOdgovordrugi8(String odgovordrugi8) {
        this.odgovordrugi8 = odgovordrugi8;
    }

    public String getOdgovordrugi7() {
        return odgovordrugi7;
    }

    public void setOdgovordrugi7(String odgovordrugi7) {
        this.odgovordrugi7 = odgovordrugi7;
    }

    public String getOdgovordrugi6() {
        return odgovordrugi6;
    }

    public void setOdgovordrugi6(String odgovordrugi6) {
        this.odgovordrugi6 = odgovordrugi6;
    }

    public String getOdgovordrugi5() {
        return odgovordrugi5;
    }

    public void setOdgovordrugi5(String odgovordrugi5) {
        this.odgovordrugi5 = odgovordrugi5;
    }

    public String getOdgovordrugi4() {
        return odgovordrugi4;
    }

    public void setOdgovordrugi4(String odgovordrugi4) {
        this.odgovordrugi4 = odgovordrugi4;
    }

    public String getOdgovordrugi3() {
        return odgovordrugi3;
    }

    public void setOdgovordrugi3(String odgovordrugi3) {
        this.odgovordrugi3 = odgovordrugi3;
    }
    
}
