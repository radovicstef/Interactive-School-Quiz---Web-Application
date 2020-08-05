/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.Anagrami;
import entityBeans.BazaIgraDana;
import entityBeans.BazaPitanja;
import entityBeans.IgraDanaPartija;
import entityBeans.IgraPehar;
import entityBeans.IgranaPartija;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */

@ManagedBean(name="pehar")
@SessionScoped
public class Pehar implements Serializable {
    
    private String color;
    
    private IgranaPartija igranapartija;
    private IgraPehar igrapehar;
    private BazaPitanja pitanja;
    
    private int timer;
    
    private boolean timerstart;
    
    private boolean disabledbutton;
    
    private boolean zakljucanodgovor;
    
    private String pitanje;
    
    private String odgovor;
    
    private int rednopitanje;
    
    private boolean[] helper=new boolean[14];
    
    String[] bojapitanja=new String[14];
    
    String[] odgovori=new String[14];
    
    char r1s1;
    char r1s2;
    char r1s3;
    char r1s4;
    char r1s5;
    char r1s6;
    char r1s7;
    char r1s8;
    char r1s9;
    char r2s1;
    char r2s2;
    char r2s3;
    char r2s4;
    char r2s5;
    char r2s6;
    char r2s7;
    char r2s8;
    char r3s1;
    char r3s2;
    char r3s3;
    char r3s4;
    char r3s5;
    char r3s6;
    char r3s7;
    char r4s1;
    char r4s2;
    char r4s3;
    char r4s4;
    char r4s5;
    char r4s6;
    char r5s1;
    char r5s2;
    char r5s3;
    char r5s4;
    char r5s5;
    char r6s1;
    char r6s2;
    char r6s3;
    char r6s4;
    char r7s1;
    char r7s2;
    char r7s3;
    char r8s1;
    char r8s2;
    char r8s3;
    char r9s1;
    char r9s2;
    char r9s3;
    char r9s4;
    char r10s1;
    char r10s2;
    char r10s3;
    char r10s4;
    char r10s5;
    char r11s1;
    char r11s2;
    char r11s3;
    char r11s4;
    char r11s5;
    char r11s6;
    char r12s1;
    char r12s2;
    char r12s3;
    char r12s4;
    char r12s5;
    char r12s6;
    char r12s7;
    char r13s1;
    char r13s2;
    char r13s3;
    char r13s4;
    char r13s5;
    char r13s6;
    char r13s7;
    char r13s8;
    char r14s1;
    char r14s2;
    char r14s3;
    char r14s4;
    char r14s5;
    char r14s6;
    char r14s7;
    char r14s8;
    char r14s9;

    public char getR1s4() {
        return r1s4;
    }

    public void setR1s4(char r1s4) {
        this.r1s4 = r1s4;
    }

    public char getR1s5() {
        return r1s5;
    }

    public void setR1s5(char r1s5) {
        this.r1s5 = r1s5;
    }

    public char getR1s6() {
        return r1s6;
    }

    public void setR1s6(char r1s6) {
        this.r1s6 = r1s6;
    }

    public char getR1s7() {
        return r1s7;
    }

    public void setR1s7(char r1s7) {
        this.r1s7 = r1s7;
    }

    public char getR1s8() {
        return r1s8;
    }

    public void setR1s8(char r1s8) {
        this.r1s8 = r1s8;
    }

    public char getR1s9() {
        return r1s9;
    }

    public void setR1s9(char r1s9) {
        this.r1s9 = r1s9;
    }

    public char getR2s1() {
        return r2s1;
    }

    public void setR2s1(char r2s1) {
        this.r2s1 = r2s1;
    }

    public char getR2s2() {
        return r2s2;
    }

    public void setR2s2(char r2s2) {
        this.r2s2 = r2s2;
    }

    public char getR2s3() {
        return r2s3;
    }

    public void setR2s3(char r2s3) {
        this.r2s3 = r2s3;
    }

    public char getR2s4() {
        return r2s4;
    }

    public void setR2s4(char r2s4) {
        this.r2s4 = r2s4;
    }

    public char getR2s5() {
        return r2s5;
    }

    public void setR2s5(char r2s5) {
        this.r2s5 = r2s5;
    }

    public char getR2s6() {
        return r2s6;
    }

    public void setR2s6(char r2s6) {
        this.r2s6 = r2s6;
    }

    public char getR2s7() {
        return r2s7;
    }

    public void setR2s7(char r2s7) {
        this.r2s7 = r2s7;
    }

    public char getR2s8() {
        return r2s8;
    }

    public void setR2s8(char r2s8) {
        this.r2s8 = r2s8;
    }

    public char getR3s1() {
        return r3s1;
    }

    public void setR3s1(char r3s1) {
        this.r3s1 = r3s1;
    }

    public char getR3s2() {
        return r3s2;
    }

    public void setR3s2(char r3s2) {
        this.r3s2 = r3s2;
    }

    public char getR3s3() {
        return r3s3;
    }

    public void setR3s3(char r3s3) {
        this.r3s3 = r3s3;
    }

    public char getR3s4() {
        return r3s4;
    }

    public void setR3s4(char r3s4) {
        this.r3s4 = r3s4;
    }

    public char getR3s5() {
        return r3s5;
    }

    public void setR3s5(char r3s5) {
        this.r3s5 = r3s5;
    }

    public char getR3s6() {
        return r3s6;
    }

    public void setR3s6(char r3s6) {
        this.r3s6 = r3s6;
    }

    public char getR3s7() {
        return r3s7;
    }

    public void setR3s7(char r3s7) {
        this.r3s7 = r3s7;
    }

    public char getR4s1() {
        return r4s1;
    }

    public void setR4s1(char r4s1) {
        this.r4s1 = r4s1;
    }

    public char getR4s2() {
        return r4s2;
    }

    public void setR4s2(char r4s2) {
        this.r4s2 = r4s2;
    }

    public char getR4s3() {
        return r4s3;
    }

    public void setR4s3(char r4s3) {
        this.r4s3 = r4s3;
    }

    public char getR4s4() {
        return r4s4;
    }

    public void setR4s4(char r4s4) {
        this.r4s4 = r4s4;
    }

    public char getR4s5() {
        return r4s5;
    }

    public void setR4s5(char r4s5) {
        this.r4s5 = r4s5;
    }

    public char getR4s6() {
        return r4s6;
    }

    public void setR4s6(char r4s6) {
        this.r4s6 = r4s6;
    }

    public char getR5s1() {
        return r5s1;
    }

    public void setR5s1(char r5s1) {
        this.r5s1 = r5s1;
    }

    public char getR5s2() {
        return r5s2;
    }

    public void setR5s2(char r5s2) {
        this.r5s2 = r5s2;
    }

    public char getR5s3() {
        return r5s3;
    }

    public void setR5s3(char r5s3) {
        this.r5s3 = r5s3;
    }

    public char getR5s4() {
        return r5s4;
    }

    public void setR5s4(char r5s4) {
        this.r5s4 = r5s4;
    }

    public char getR5s5() {
        return r5s5;
    }

    public void setR5s5(char r5s5) {
        this.r5s5 = r5s5;
    }

    public char getR6s1() {
        return r6s1;
    }

    public void setR6s1(char r6s1) {
        this.r6s1 = r6s1;
    }

    public char getR6s2() {
        return r6s2;
    }

    public void setR6s2(char r6s2) {
        this.r6s2 = r6s2;
    }

    public char getR6s3() {
        return r6s3;
    }

    public void setR6s3(char r6s3) {
        this.r6s3 = r6s3;
    }

    public char getR6s4() {
        return r6s4;
    }

    public void setR6s4(char r6s4) {
        this.r6s4 = r6s4;
    }

    public char getR7s1() {
        return r7s1;
    }

    public void setR7s1(char r7s1) {
        this.r7s1 = r7s1;
    }

    public char getR7s2() {
        return r7s2;
    }

    public void setR7s2(char r7s2) {
        this.r7s2 = r7s2;
    }

    public char getR7s3() {
        return r7s3;
    }

    public void setR7s3(char r7s3) {
        this.r7s3 = r7s3;
    }

    public char getR8s1() {
        return r8s1;
    }

    public void setR8s1(char r8s1) {
        this.r8s1 = r8s1;
    }

    public char getR8s2() {
        return r8s2;
    }

    public void setR8s2(char r8s2) {
        this.r8s2 = r8s2;
    }

    public char getR8s3() {
        return r8s3;
    }

    public void setR8s3(char r8s3) {
        this.r8s3 = r8s3;
    }

    public char getR9s1() {
        return r9s1;
    }

    public void setR9s1(char r9s1) {
        this.r9s1 = r9s1;
    }

    public char getR9s2() {
        return r9s2;
    }

    public void setR9s2(char r9s2) {
        this.r9s2 = r9s2;
    }

    public char getR9s3() {
        return r9s3;
    }

    public void setR9s3(char r9s3) {
        this.r9s3 = r9s3;
    }

    public char getR9s4() {
        return r9s4;
    }

    public void setR9s4(char r9s4) {
        this.r9s4 = r9s4;
    }

    public char getR10s1() {
        return r10s1;
    }

    public void setR10s1(char r10s1) {
        this.r10s1 = r10s1;
    }

    public char getR10s2() {
        return r10s2;
    }

    public void setR10s2(char r10s2) {
        this.r10s2 = r10s2;
    }

    public char getR10s3() {
        return r10s3;
    }

    public void setR10s3(char r10s3) {
        this.r10s3 = r10s3;
    }

    public char getR10s4() {
        return r10s4;
    }

    public void setR10s4(char r10s4) {
        this.r10s4 = r10s4;
    }

    public char getR10s5() {
        return r10s5;
    }

    public void setR10s5(char r10s5) {
        this.r10s5 = r10s5;
    }

    public char getR11s1() {
        return r11s1;
    }

    public void setR11s1(char r11s1) {
        this.r11s1 = r11s1;
    }

    public char getR11s2() {
        return r11s2;
    }

    public void setR11s2(char r11s2) {
        this.r11s2 = r11s2;
    }

    public char getR11s3() {
        return r11s3;
    }

    public void setR11s3(char r11s3) {
        this.r11s3 = r11s3;
    }

    public char getR11s4() {
        return r11s4;
    }

    public void setR11s4(char r11s4) {
        this.r11s4 = r11s4;
    }

    public char getR11s5() {
        return r11s5;
    }

    public void setR11s5(char r11s5) {
        this.r11s5 = r11s5;
    }

    public char getR11s6() {
        return r11s6;
    }

    public void setR11s6(char r11s6) {
        this.r11s6 = r11s6;
    }

    public char getR12s1() {
        return r12s1;
    }

    public void setR12s1(char r12s1) {
        this.r12s1 = r12s1;
    }

    public char getR12s2() {
        return r12s2;
    }

    public void setR12s2(char r12s2) {
        this.r12s2 = r12s2;
    }

    public char getR12s3() {
        return r12s3;
    }

    public void setR12s3(char r12s3) {
        this.r12s3 = r12s3;
    }

    public char getR12s4() {
        return r12s4;
    }

    public void setR12s4(char r12s4) {
        this.r12s4 = r12s4;
    }

    public char getR12s5() {
        return r12s5;
    }

    public void setR12s5(char r12s5) {
        this.r12s5 = r12s5;
    }

    public char getR12s6() {
        return r12s6;
    }

    public void setR12s6(char r12s6) {
        this.r12s6 = r12s6;
    }

    public char getR12s7() {
        return r12s7;
    }

    public void setR12s7(char r12s7) {
        this.r12s7 = r12s7;
    }

    public char getR13s1() {
        return r13s1;
    }

    public void setR13s1(char r13s1) {
        this.r13s1 = r13s1;
    }

    public char getR13s2() {
        return r13s2;
    }

    public void setR13s2(char r13s2) {
        this.r13s2 = r13s2;
    }

    public char getR13s3() {
        return r13s3;
    }

    public void setR13s3(char r13s3) {
        this.r13s3 = r13s3;
    }

    public char getR13s4() {
        return r13s4;
    }

    public void setR13s4(char r13s4) {
        this.r13s4 = r13s4;
    }

    public char getR13s5() {
        return r13s5;
    }

    public void setR13s5(char r13s5) {
        this.r13s5 = r13s5;
    }

    public char getR13s6() {
        return r13s6;
    }

    public void setR13s6(char r13s6) {
        this.r13s6 = r13s6;
    }

    public char getR13s7() {
        return r13s7;
    }

    public void setR13s7(char r13s7) {
        this.r13s7 = r13s7;
    }

    public char getR13s8() {
        return r13s8;
    }

    public void setR13s8(char r13s8) {
        this.r13s8 = r13s8;
    }

    public char getR14s1() {
        return r14s1;
    }

    public void setR14s1(char r14s1) {
        this.r14s1 = r14s1;
    }

    public char getR14s2() {
        return r14s2;
    }

    public void setR14s2(char r14s2) {
        this.r14s2 = r14s2;
    }

    public char getR14s3() {
        return r14s3;
    }

    public void setR14s3(char r14s3) {
        this.r14s3 = r14s3;
    }

    public char getR14s4() {
        return r14s4;
    }

    public void setR14s4(char r14s4) {
        this.r14s4 = r14s4;
    }

    public char getR14s5() {
        return r14s5;
    }

    public void setR14s5(char r14s5) {
        this.r14s5 = r14s5;
    }

    public char getR14s6() {
        return r14s6;
    }

    public void setR14s6(char r14s6) {
        this.r14s6 = r14s6;
    }

    public char getR14s7() {
        return r14s7;
    }

    public void setR14s7(char r14s7) {
        this.r14s7 = r14s7;
    }

    public char getR14s8() {
        return r14s8;
    }

    public void setR14s8(char r14s8) {
        this.r14s8 = r14s8;
    }

    public char getR14s9() {
        return r14s9;
    }

    public void setR14s9(char r14s9) {
        this.r14s9 = r14s9;
    }

    public String[] getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(String[] odgovori) {
        this.odgovori = odgovori;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public String[] getBojapitanja() {
        return bojapitanja;
    }

    public void setBojapitanja(String[] bojapitanja) {
        this.bojapitanja = bojapitanja;
    }
    
    public int getRednopitanje() {
        return rednopitanje;
    }

    public void setRednopitanje(int rednopitanje) {
        this.rednopitanje = rednopitanje;
    }

    public boolean isZakljucanodgovor() {
        return zakljucanodgovor;
    }

    public void setZakljucanodgovor(boolean zakljucanodgovor) {
        this.zakljucanodgovor = zakljucanodgovor;
    }

    public boolean isDisabledbutton() {
        return disabledbutton;
    }

    public void setDisabledbutton(boolean disabledbutton) {
        this.disabledbutton = disabledbutton;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public boolean isTimerstart() {
        return timerstart;
    }

    public void setTimerstart(boolean timerstart) {
        this.timerstart = timerstart;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public IgranaPartija getIgranapartija() {
        return igranapartija;
    }

    public void setIgranapartija(IgranaPartija igranapartija) {
        this.igranapartija = igranapartija;
    }

    public IgraPehar getIgrapehar() {
        return igrapehar;
    }

    public void setIgrapehar(IgraPehar igrapehar) {
        this.igrapehar = igrapehar;
    }

    public BazaPitanja getPitanja() {
        return pitanja;
    }

    public void setPitanja(BazaPitanja pitanja) {
        this.pitanja = pitanja;
    }
    
    //---------------------------------------------------------------------------------------------------------------------------------
    public void podesiIgruPlavi(String username, int br){
        if(br==1){
            color="cornflowerblue";
        }
        else{
            color="orangered";
        }
        
        inicijalizujNizove();
        
        rednopitanje=1;
        
        zakljucanodgovor=false;
        
        odgovor="";
        
        for(int i=0; i<helper.length; i++){
            helper[i]=false;
        }
        
        if(br==1){
            disabledbutton=false;
        }
        else{
            disabledbutton=true;
        }
        
        igranapartija=new IgranaPartija();
        igrapehar=new IgraPehar();
        pitanja=new BazaPitanja();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria q=session.createCriteria(IgranaPartija.class);
        igranapartija=(IgranaPartija)q.add(Restrictions.eq("username1", username)).uniqueResult();
        
        if(igranapartija!=null){
            igrapehar.setIdigranapartija(igranapartija.getIdigranapartija());
            igrapehar.setUsername1(igranapartija.getUsername1());
            igrapehar.setUsername2(igranapartija.getUsername2());
            igrapehar.setBrpoena1(0);
            igrapehar.setBrpoena2(0);
            igrapehar.setBrpitanja(1);
            if(br==1){
                igrapehar.setKoigra(1);
            }
            else{
                igrapehar.setKoigra(2);
            }
        }
        
        Criteria q2=session.createCriteria(BazaPitanja.class);
        List<BazaPitanja> svekombinacije=new ArrayList<>();
        svekombinacije=q2.list();
        
        int maxkombinacije=svekombinacije.size();
        
        int randomNum = ThreadLocalRandom.current().nextInt(1, maxkombinacije + 1);
        
        q=session.createCriteria(BazaPitanja.class);
        pitanja=(BazaPitanja)q.add(Restrictions.eq("idbazapitanja", randomNum)).uniqueResult();
        
        igrapehar.setIdpitanjaubazi(pitanja.getIdbazapitanja());
    
        igrapehar.setIgrase(true);
        
        session.persist(igrapehar);
        
        timer=30;
        
        timerstart=true;
        
        pitanje=pitanja.getPitanjeprvo9();
        
        transaction.commit();
        session.close();
    }
    
    public void podesiIgruCrveni(String username, int br){
        if(br==1){
            color="cornflowerblue";
        }
        else{
            color="orangered";
        }
        
        inicijalizujNizove();
        
        rednopitanje=1;
        
        zakljucanodgovor=false;
        
        odgovor="";
        
        for(int i=0; i<helper.length; i++){
            helper[i]=false;
        }        
        if(br==2){
            disabledbutton=false;
        }
        else{
            disabledbutton=true;
        }
        
        timer=30;
        
        boolean ready=false;
        
        while(!ready){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraPehar.class);
            Criteria qpitanje=session.createCriteria(BazaPitanja.class);
            igrapehar=(IgraPehar)q.add(Restrictions.eq("username2", username)).uniqueResult();
            
            Criteria q1=session.createCriteria(IgranaPartija.class);
            igranapartija=(IgranaPartija)q1.add(Restrictions.eq("username2", username)).uniqueResult();
            
            if(igrapehar!=null){
                pitanja=(BazaPitanja)qpitanje.add(Restrictions.eq("idbazapitanja", igrapehar.getIdpitanjaubazi())).uniqueResult();
                
                pitanje=pitanja.getPitanjeprvo9();

                
                timerstart=true;
                ready=true;
            }
            
            
            transaction.commit();
            session.close();
        }
        
    }
    
    public void inicijalizujNizove(){
        for(int i=0;i<bojapitanja.length;i++){
            bojapitanja[i]="orange";
        }
        
        r1s1=' '; r1s2=' '; r1s3=' '; r1s4=' '; r1s5=' '; r1s6=' '; r1s7=' '; r1s8=' '; r1s9=' '; r2s1=' '; r2s2=' '; r2s3=' '; r2s4=' '; r2s5=' '; r2s6=' '; r2s7=' '; r2s8=' ';
        r3s1=' '; r3s2=' '; r3s3=' '; r3s4=' '; r3s5=' '; r3s6=' '; r3s7=' '; r4s1=' '; r4s2=' '; r4s3=' '; r4s4=' '; r4s5=' '; r4s6=' '; r5s1=' '; r5s2=' '; r5s3=' '; r5s4=' '; r5s5=' '; r6s1=' '; r6s2=' '; r6s3=' '; r6s4=' '; r7s1=' '; r7s2=' '; r7s3=' '; r8s1=' '; r8s2=' '; r8s3=' '; r9s1=' '; r9s2=' '; r9s3=' '; r9s4=' ';
        r10s1=' '; r10s2=' '; r10s3=' '; r10s4=' '; r10s5=' '; r11s1=' '; r11s2=' '; r11s3=' '; r11s4=' '; r11s5=' '; r11s6=' '; r12s1=' '; r12s2=' '; r12s3=' '; r12s4=' '; r12s5=' '; r12s6=' '; r12s7=' '; r13s1=' '; r13s2=' '; r13s3=' '; r13s4=' '; r13s5=' '; r13s6=' '; r13s7=' '; r13s8=' ';
        r14s1=' '; r14s2=' '; r14s3=' '; r14s4=' '; r14s5=' '; r14s6=' '; r14s7=' '; r14s8=' '; r14s9=' ';
    }
    
    
    //br je broj partije
    public void odbrojavajPlavi(int br){
        if(!timerstart) return;
        if(timer>0){
            timer--;
        }
        if(timer==0){
            System.out.printf("ISTEKAO TAJMER");
            zakljucanodgovor=true;
        }
        //ZAVRSENA IGRA
        if(rednopitanje==15){
            System.out.printf("ZAVRSI PLAVI 1");
            zavrsiIgru(1,br);
            return;
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraPehar.class);
        if(igranapartija!=null) igrapehar=(IgraPehar)q.add(Restrictions.eq("username1", igranapartija.getUsername1())).uniqueResult();
        
        if(igrapehar!=null){
            if(igrapehar.getBrpitanja()!=rednopitanje){
                if(igrapehar.getBrpitanja()==15){
                    int brpolja=rednopitanje-1;
                    bojapitanja[brpolja]=uzmiBojuNaPrethodnoPitanje(rednopitanje, igrapehar);
                    String tacanodgovor=uzmiOdgovor(rednopitanje);
                    odgovori[brpolja]=tacanodgovor;
                    podesiIspisOdgovora(rednopitanje, odgovori[brpolja]);
                    rednopitanje=15;
                    return;
                }
                else{
                    System.out.printf("MENJA SE PITANJE PLAVI");
                    int brpolja=rednopitanje-1;
                    bojapitanja[brpolja]=uzmiBojuNaPrethodnoPitanje(rednopitanje, igrapehar);
                    String tacanodgovor=uzmiOdgovor(rednopitanje);
                    odgovori[brpolja]=tacanodgovor;
                    podesiIspisOdgovora(rednopitanje, odgovori[brpolja]);
                    rednopitanje=igrapehar.getBrpitanja();
                    pitanje=uzmiPitanje(rednopitanje);
                    if(igrapehar.getKoigra()==1){
                        disabledbutton=false;
                    }
                    else{
                        disabledbutton=true;
                    }
                    timer=30;
                    timerstart=true;
                    zakljucanodgovor=false;
                    odgovor="";
                }
            }
            else if(rednopitanje!=15){
                int pomredno=rednopitanje-1;
                if(igrapehar.getKoigra()==1 && proveriVecOdgovarano(rednopitanje) && !helper[pomredno]){
                    helper[pomredno]=true;
                    timer=30;
                    timerstart=true;
                    zakljucanodgovor=false;
                    odgovor="";
                    disabledbutton=false;
                }
            }
        }
        
        transaction.commit();
        session.close();
        
        if(igrapehar!=null){
            if(zakljucanodgovor && rednopitanje!=15 && igrapehar.getKoigra()==1){
                System.out.printf("IZMENJENO PLAVI");
                disabledbutton=true;
                proveriOdgovorPlavi();
            }
        }
    }
    
    //br je broj partije
    public void odbrojavajCrveni(int br){
        if(!timerstart) return;
        if(timer>0){
            timer--;
        }
        if(timer==0){
            zakljucanodgovor=true;
        }
        //ZAVRSENA IGRA
        if(rednopitanje==15){
            //takmicar - 1 plavi, 2 - crveni
            System.out.printf("ZAVRSI CRVENI 1");
            zavrsiIgru(2, br);
            return;
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraPehar.class);
        if(igranapartija!=null) igrapehar=(IgraPehar)q.add(Restrictions.eq("username1", igranapartija.getUsername1())).uniqueResult();
        
        if(igrapehar!=null){
            if(igrapehar.getBrpitanja()!=rednopitanje){
                if(igrapehar.getBrpitanja()==15){
                    int brpolja=rednopitanje-1;
                    bojapitanja[brpolja]=uzmiBojuNaPrethodnoPitanje(rednopitanje, igrapehar);
                    String tacanodgovor=uzmiOdgovor(rednopitanje);
                    odgovori[brpolja]=tacanodgovor;
                    podesiIspisOdgovora(rednopitanje, odgovori[brpolja]);
                    rednopitanje=15;
                    return;
                }
                else{
                    System.out.printf("NAREDNO PITANJE");
                    int brpolja=rednopitanje-1;
                    bojapitanja[brpolja]=uzmiBojuNaPrethodnoPitanje(rednopitanje, igrapehar);
                    String tacanodgovor=uzmiOdgovor(rednopitanje);
                    odgovori[brpolja]=tacanodgovor;
                    podesiIspisOdgovora(rednopitanje, odgovori[brpolja]);
                    rednopitanje=igrapehar.getBrpitanja();
                    pitanje=uzmiPitanje(rednopitanje);
                    if(igrapehar.getKoigra()==2){
                        disabledbutton=false;
                    }
                    else{
                        disabledbutton=true;
                    }
                    timer=30;
                    timerstart=true;
                    zakljucanodgovor=false;
                    odgovor=" ";
                }
            }
            else if(rednopitanje!=15){
                int pomredno=rednopitanje-1;
                if(igrapehar.getKoigra()==2 && proveriVecOdgovarano(rednopitanje) && !helper[pomredno]){
                    helper[pomredno]=true;
                    timer=30;
                    timerstart=true;
                    zakljucanodgovor=false;
                    odgovor=" ";
                    disabledbutton=false;
                }
            }
        }
        
        transaction.commit();
        session.close();
        
        if(igrapehar!=null){
            if(zakljucanodgovor && rednopitanje!=15 && igrapehar.getKoigra()==2){
                System.out.printf("IZMENJENO CRVENI");
                disabledbutton=true;
                proveriOdgovorCrveni();
            }
        }
    }
    
    public void zavrsiIgru(int takmicar, int brpartije){
        
        //OBRISI IZ BAZE I REDIREKTUJ SE
        if((brpartije==1 && takmicar==1) || (brpartije==2 && takmicar==2)){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraPehar.class);
            Criteria qp=session.createCriteria(IgranaPartija.class);

            igranapartija=(IgranaPartija)qp.add(Restrictions.eq("username1", igranapartija.getUsername1())).uniqueResult();
        
            if(igrapehar!=null) igrapehar=(IgraPehar)q.add(Restrictions.eq("username1", igrapehar.getUsername1())).uniqueResult();
            if(igrapehar!=null){
                int brpoena1=igrapehar.getBrpoena1();
                int brpoena2=igrapehar.getBrpoena2();
                int brpoenaprethpehar1=igranapartija.getPehar1();
                int brpoenaprethpehar2=igranapartija.getPehar2();
                brpoenaprethpehar1+=brpoena1;
                brpoenaprethpehar2+=brpoena2;
                brpoena1+=igranapartija.getPoeni1();
                brpoena2+=igranapartija.getPoeni2();
                igranapartija.setPoeni1(brpoena1);
                igranapartija.setPoeni2(brpoena2);
                igranapartija.setPehar1(brpoenaprethpehar1);
                igranapartija.setPehar2(brpoenaprethpehar2);
            }
            
            session.saveOrUpdate(igranapartija);
            
            if(igrapehar!=null){
                String hqlUpdate="delete IgraPehar where username1=:username1";
                session.createQuery(hqlUpdate).setString("username1", igrapehar.getUsername1()).executeUpdate();
            }
            
            try {
                if(brpartije==1){
                    if(takmicar==1){
                        FacesContext.getCurrentInstance().getExternalContext().redirect("peharplavi2.xhtml");
                    }
                    else{
                        FacesContext.getCurrentInstance().getExternalContext().redirect("peharcrveni2.xhtml");
                    }
                }
                else{
                if(takmicar==1){
                        FacesContext.getCurrentInstance().getExternalContext().redirect("rezultatplavi.xhtml");
                    }
                    else{
                        FacesContext.getCurrentInstance().getExternalContext().redirect("rezultatcrveni.xhtml");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Vesanje.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            transaction.commit();
            session.close();
        }
        //CEKAJ DA SE OBRISE IZ BAZE I REDIREKTUJ SE
        else{
            do{
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction=session.beginTransaction();

                Criteria q=session.createCriteria(IgraPehar.class);
                if(igrapehar!=null) igrapehar=(IgraPehar)q.add(Restrictions.eq("idigrapehar", igrapehar.getIdigrapehar())).uniqueResult();
                
                transaction.commit();
                session.close();
            }while(igrapehar!=null);

            if(igrapehar==null){
                try {
                    if(brpartije==1){
                        if(takmicar==1){
                            FacesContext.getCurrentInstance().getExternalContext().redirect("peharplavi2.xhtml");
                        }
                        else{
                            FacesContext.getCurrentInstance().getExternalContext().redirect("peharcrveni2.xhtml");
                        }
                    }
                    else{
                    if(takmicar==1){
                            FacesContext.getCurrentInstance().getExternalContext().redirect("rezultatplavi.xhtml");
                        }
                        else{
                            FacesContext.getCurrentInstance().getExternalContext().redirect("rezultatcrveni.xhtml");
                        }
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Vesanje.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    public void odgovori(int br){
        zakljucanodgovor=true;
    }
    
    public void proveriOdgovorPlavi(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraPehar.class);
        if(igranapartija!=null) igrapehar=(IgraPehar)q.add(Restrictions.eq("username1", igranapartija.getUsername1())).uniqueResult();
        
        String tacanodgovor=uzmiOdgovor(rednopitanje);
        if(odgovor.toLowerCase(Locale.FRENCH).equals(tacanodgovor)){
            
            if(igrapehar!=null){
                igrapehar.setKoigra(1); 
               switch(rednopitanje){
                    case 1:
                        igrapehar.setPogodio1(1);
                        break;
                    case 2:
                        igrapehar.setPogodio2(1);
                        break;
                    case 3:
                        igrapehar.setPogodio3(1);
                        break;
                    case 4:
                        igrapehar.setPogodio4(1);
                        break;
                    case 5:
                        igrapehar.setPogodio5(1);
                        break;
                    case 6:
                        igrapehar.setPogodio6(1);
                        break;
                    case 7:
                        igrapehar.setPogodio7(1);
                        break;
                    case 8:
                        igrapehar.setPogodio8(1);
                        break;
                    case 9:
                        igrapehar.setPogodio9(1);
                        break;
                    case 10:
                        igrapehar.setPogodio10(1);
                        break;
                    case 11:
                        igrapehar.setPogodio11(1);
                        break;
                    case 12:
                        igrapehar.setPogodio12(1);
                        break;
                    case 13:
                        igrapehar.setPogodio13(1);
                        break;
                    case 14:
                        igrapehar.setPogodio14(1);
                        break;   
                }
                int redno=rednopitanje+1;
                timer=30;
                igrapehar.setBrpitanja(redno);
                int prethpoeni=igrapehar.getBrpoena1();
                prethpoeni+=2;
                igrapehar.setBrpoena1(prethpoeni);
            }
        }
        else{
            //VEC JE ODGOVARANO, PREDJI NA SLEDECE PITANJE, ALI PUSTI DRUGOG
            if(proveriVecOdgovarano(rednopitanje)){
                System.out.printf("vec odgovarano");
                int redno=rednopitanje+1;
                igrapehar.setBrpitanja(redno);
                igrapehar.setKoigra(2);
            }
            else{
                //POSTAVI DA JE VEC ODGOVORENO
                System.out.printf("nije vec odgovarano");
                switch(rednopitanje){
                    case 1:
                        igrapehar.setPogodio1(4);
                        break;
                        
                    case 2:
                        igrapehar.setPogodio2(4);
                        break;
                        
                    case 3:
                        igrapehar.setPogodio3(4);
                        break;
                        
                    case 4:
                        igrapehar.setPogodio4(4);
                        break;
                        
                    case 5:
                        igrapehar.setPogodio5(4);
                        break;
                        
                    case 6:
                        igrapehar.setPogodio6(4);
                        break;
                        
                    case 7:
                        igrapehar.setPogodio7(4);
                        break;
                        
                    case 8:
                        igrapehar.setPogodio8(4);
                        break;
                        
                    case 9:
                        igrapehar.setPogodio9(4);
                        break;
                        
                    case 10:
                        igrapehar.setPogodio10(4);
                        break;
                        
                    case 11:
                        igrapehar.setPogodio11(4);
                        break;
                        
                    case 12:
                        igrapehar.setPogodio12(4);
                        break;
                        
                    case 13:
                        igrapehar.setPogodio13(4);
                        break;
                        
                    case 14:
                        igrapehar.setPogodio14(4);
                        break;
                }
                timer=30;
                timerstart=true;
                igrapehar.setKoigra(2);
            }
        }
        
        zakljucanodgovor=false;
        
        session.saveOrUpdate(igrapehar);

        transaction.commit();
        session.close();
    }
    
    
    public void proveriOdgovorCrveni(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraPehar.class);
        if(igranapartija!=null) igrapehar=(IgraPehar)q.add(Restrictions.eq("username1", igranapartija.getUsername1())).uniqueResult();
        
        String tacanodgovor=uzmiOdgovor(rednopitanje);
        if(odgovor.toLowerCase(Locale.FRENCH).equals(tacanodgovor)){
            System.out.printf("TACAN ODGOVOR CRVENI");
            if(igrapehar!=null){
                igrapehar.setKoigra(2);
                switch(rednopitanje){
                    case 1:
                        igrapehar.setPogodio1(2);
                        break;
                    case 2:
                        igrapehar.setPogodio2(2);
                        break;
                    case 3:
                        igrapehar.setPogodio3(2);
                        break;
                    case 4:
                        igrapehar.setPogodio4(2);
                        break;
                    case 5:
                        igrapehar.setPogodio5(2);
                        break;
                    case 6:
                        igrapehar.setPogodio6(2);
                        break;
                    case 7:
                        igrapehar.setPogodio7(2);
                        break;
                    case 8:
                        igrapehar.setPogodio8(2);
                        break;
                    case 9:
                        igrapehar.setPogodio9(2);
                        break;
                    case 10:
                        igrapehar.setPogodio10(2);
                        break;
                    case 11:
                        igrapehar.setPogodio11(2);
                        break;
                    case 12:
                        igrapehar.setPogodio12(2);
                        break;
                    case 13:
                        igrapehar.setPogodio13(2);
                        break;
                    case 14:
                        igrapehar.setPogodio14(2);
                        break;   
                }
                int redno=rednopitanje+1;
                igrapehar.setBrpitanja(redno);
                int prethpoeni=igrapehar.getBrpoena2();
                prethpoeni+=2;
                igrapehar.setBrpoena2(prethpoeni);
            }
        }
        else{
            System.out.printf("PROMASEN ODGOVOR CRVENI");
            //VEC JE ODGOVARANO, PREDJI NA SLEDECE PITANJE, ALI PUSTI DRUGOG
            if(proveriVecOdgovarano(rednopitanje)){
                int redno=rednopitanje+1;
                igrapehar.setBrpitanja(redno);
                igrapehar.setKoigra(1);
            }
            else{
                //POSTAVI DA JE VEC ODGOVORENO
                switch(rednopitanje){
                    case 1:
                        igrapehar.setPogodio1(4);
                        break;
                        
                    case 2:
                        igrapehar.setPogodio2(4);
                        break;
                        
                    case 3:
                        igrapehar.setPogodio3(4);
                        break;
                        
                    case 4:
                        igrapehar.setPogodio4(4);
                        break;
                        
                    case 5:
                        igrapehar.setPogodio5(4);
                        break;
                        
                    case 6:
                        igrapehar.setPogodio6(4);
                        break;
                        
                    case 7:
                        igrapehar.setPogodio7(4);
                        break;
                        
                    case 8:
                        igrapehar.setPogodio8(4);
                        break;
                        
                    case 9:
                        igrapehar.setPogodio9(4);
                        break;
                        
                    case 10:
                        igrapehar.setPogodio10(4);
                        break;
                        
                    case 11:
                        igrapehar.setPogodio11(4);
                        break;
                        
                    case 12:
                        igrapehar.setPogodio12(4);
                        break;
                        
                    case 13:
                        igrapehar.setPogodio13(4);
                        break;
                        
                    case 14:
                        igrapehar.setPogodio14(4);
                        break;
                }
                igrapehar.setKoigra(1);
            }
            timer=30;
            timerstart=true;
        }
        
        zakljucanodgovor=false;
        
        session.saveOrUpdate(igrapehar);

        transaction.commit();
        session.close();
    }
    
    public void podesiIspisOdgovora(int rednibr, String odgovor){
        switch(rednibr){
                case 1:
                r1s1=odgovor.charAt(0);
                r1s2=odgovor.charAt(1);
                r1s3=odgovor.charAt(2);
                r1s4=odgovor.charAt(3);
                r1s5=odgovor.charAt(4);
                r1s6=odgovor.charAt(5);
                r1s7=odgovor.charAt(6);
                r1s8=odgovor.charAt(7);
                r1s9=odgovor.charAt(8);
                break;
                
                case 2:
                r2s1=odgovor.charAt(0);
                r2s2=odgovor.charAt(1);
                r2s3=odgovor.charAt(2);
                r2s4=odgovor.charAt(3);
                r2s5=odgovor.charAt(4);
                r2s6=odgovor.charAt(5);
                r2s7=odgovor.charAt(6);
                r2s8=odgovor.charAt(7);
                break;
                    
                case 3:
                r3s1=odgovor.charAt(0);
                r3s2=odgovor.charAt(1);
                r3s3=odgovor.charAt(2);
                r3s4=odgovor.charAt(3);
                r3s5=odgovor.charAt(4);
                r3s6=odgovor.charAt(5);
                r3s7=odgovor.charAt(6);
                break;
                    
                case 4:
                r4s1=odgovor.charAt(0);
                r4s2=odgovor.charAt(1);
                r4s3=odgovor.charAt(2);
                r4s4=odgovor.charAt(3);
                r4s5=odgovor.charAt(4);
                r4s6=odgovor.charAt(5);
                break;
                    
                case 5:
                r5s1=odgovor.charAt(0);
                r5s2=odgovor.charAt(1);
                r5s3=odgovor.charAt(2);
                r5s4=odgovor.charAt(3);
                r5s5=odgovor.charAt(4);
                break;
                    
                case 6:
                r6s1=odgovor.charAt(0);
                r6s2=odgovor.charAt(1);
                r6s3=odgovor.charAt(2);
                r6s4=odgovor.charAt(3);
                break;
                    
                case 7:
                r7s1=odgovor.charAt(0);
                r7s2=odgovor.charAt(1);
                r7s3=odgovor.charAt(2);
                break;
                    
                case 8:
                r8s1=odgovor.charAt(0);
                r8s2=odgovor.charAt(1);
                r8s3=odgovor.charAt(2);
                break;    
                    
                case 9:
                r9s1=odgovor.charAt(0);
                r9s2=odgovor.charAt(1);
                r9s3=odgovor.charAt(2);
                r9s4=odgovor.charAt(3);
                break;
                    
                case 10:
                r10s1=odgovor.charAt(0);
                r10s2=odgovor.charAt(1);
                r10s3=odgovor.charAt(2);
                r10s4=odgovor.charAt(3);
                r10s5=odgovor.charAt(4);
                break;
                    
                case 11:
                r11s1=odgovor.charAt(0);
                r11s2=odgovor.charAt(1);
                r11s3=odgovor.charAt(2);
                r11s4=odgovor.charAt(3);
                r11s5=odgovor.charAt(4);
                r11s6=odgovor.charAt(5);
                break;
                    
                case 12:
                r12s1=odgovor.charAt(0);
                r12s2=odgovor.charAt(1);
                r12s3=odgovor.charAt(2);
                r12s4=odgovor.charAt(3);
                r12s5=odgovor.charAt(4);
                r12s6=odgovor.charAt(5);
                r12s7=odgovor.charAt(6);
                break;
                    
                case 13:
                r13s1=odgovor.charAt(0);
                r13s2=odgovor.charAt(1);
                r13s3=odgovor.charAt(2);
                r13s4=odgovor.charAt(3);
                r13s5=odgovor.charAt(4);
                r13s6=odgovor.charAt(5);
                r13s7=odgovor.charAt(6);
                r13s8=odgovor.charAt(7);
                break;
                    
                case 14:
                r14s1=odgovor.charAt(0);
                r14s2=odgovor.charAt(1);
                r14s3=odgovor.charAt(2);
                r14s4=odgovor.charAt(3);
                r14s5=odgovor.charAt(4);
                r14s6=odgovor.charAt(5);
                r14s7=odgovor.charAt(6);
                r14s8=odgovor.charAt(7);
                r14s9=odgovor.charAt(8);
                break;
        }
    }
    
    public String uzmiPitanje(int br){
        if(pitanja==null) return "";
        String pitanje="";
        switch(br){
            case 1:
                pitanje=pitanja.getPitanjeprvo9();
                break;
                
            case 2:
                pitanje=pitanja.getPitanjeprvo8();
                break;
            
            case 3:
                pitanje=pitanja.getPitanjeprvo7();
                break;
                
            case 4:
                pitanje=pitanja.getPitanjeprvo6();
                break;
                
            case 5:
                pitanje=pitanja.getPitanjeprvo5();
                break;
                
            case 6:
                pitanje=pitanja.getPitanjeprvo4();
                break;
                
            case 7:
                pitanje=pitanja.getPitanjeprvo3();
                break;
                
            case 8:
                pitanje=pitanja.getPitanjedrugo3();
                break;
                
            case 9:
                pitanje=pitanja.getPitanjedrugo4();
                break;
            
            case 10:
                pitanje=pitanja.getPitanjedrugo5();
                break;
            
            case 11:
                pitanje=pitanja.getPitanjedrugo6();
                break;
                
            case 12:
                pitanje=pitanja.getPitanjedrugo7();
                break;
                
            case 13:
                pitanje=pitanja.getPitanjedrugo8();
                break;
                
            case 14:
                pitanje=pitanja.getPitanjedrugo9();
                break;
                
        }
        return pitanje;
    }
    
    public String uzmiOdgovor(int br){
        if(pitanja==null) return "";
        String odgovor="";
        switch(br){
            case 1:
                odgovor=pitanja.getOdgovorprvi9();
                break;
                
            case 2:
                odgovor=pitanja.getOdgovorprvi8();
                break;
            
            case 3:
                odgovor=pitanja.getOdgovorprvi7();
                break;
                
            case 4:
                odgovor=pitanja.getOdgovorprvi6();
                break;
                
            case 5:
                odgovor=pitanja.getOdgovorprvi5();
                break;
                
            case 6:
                odgovor=pitanja.getOdgovorprvi4();
                break;
                
            case 7:
                odgovor=pitanja.getOdgovorprvi3();
                break;
                
            case 8:
                odgovor=pitanja.getOdgovordrugi3();
                break;
                
            case 9:
                odgovor=pitanja.getOdgovordrugi4();
                break;
            
            case 10:
                odgovor=pitanja.getOdgovordrugi5();
                break;
            
            case 11:
                odgovor=pitanja.getOdgovordrugi6();
                break;
                
            case 12:
                odgovor=pitanja.getOdgovordrugi7();
                break;
                
            case 13:
                odgovor=pitanja.getOdgovordrugi8();
                break;
                
            case 14:
                odgovor=pitanja.getOdgovordrugi9();
                break;
                
        }
        return odgovor;
    }
    
    public String uzmiBojuNaPrethodnoPitanje(int rednibr, IgraPehar igrapehar){
        String boja="orange";
        switch(rednibr){
            case 1:
                if(igrapehar.getPogodio1()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio1()==2){
                    boja="orangered";
                }
                break;
            case 2:
                if(igrapehar.getPogodio2()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio2()==2){
                    boja="orangered";
                }
                break;
            case 3:
                if(igrapehar.getPogodio3()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio3()==2){
                    boja="orangered";
                }
                break;
            case 4:
                if(igrapehar.getPogodio4()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio4()==2){
                    boja="orangered";
                }
                break;
            case 5:
                if(igrapehar.getPogodio5()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio5()==2){
                    boja="orangered";
                }
                break;
            case 6:
                if(igrapehar.getPogodio6()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio6()==2){
                    boja="orangered";
                }
                break;
            case 7:
                if(igrapehar.getPogodio7()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio7()==2){
                    boja="orangered";
                }
                break;
            case 8:
                if(igrapehar.getPogodio8()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio8()==2){
                    boja="orangered";
                }
                break;
            case 9:
                if(igrapehar.getPogodio9()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio9()==2){
                    boja="orangered";
                }
                break;
            case 10:
                if(igrapehar.getPogodio10()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio10()==2){
                    boja="orangered";
                }
                break;
            case 11:
                if(igrapehar.getPogodio11()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio11()==2){
                    boja="orangered";
                }
                break;
            case 12:
                if(igrapehar.getPogodio12()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio12()==2){
                    boja="orangered";
                }
                break;
            case 13:
                if(igrapehar.getPogodio13()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio13()==2){
                    boja="orangered";
                }
                break;
            case 14:
                if(igrapehar.getPogodio14()==1){
                    boja="cornflowerblue";
                }
                else if(igrapehar.getPogodio14()==2){
                    boja="orangered";
                }
                break;    
        }
        return boja;
    }
    
    public boolean proveriVecOdgovarano(int rednibr){
        boolean vecodgovarano=false;
        switch(rednibr){
            case 1:
                if(igrapehar.getPogodio1()==4){
                    vecodgovarano=true;
                }
                break;
            case 2:
                if(igrapehar.getPogodio2()==4){
                    vecodgovarano=true;
                }
                break;
            case 3:
                if(igrapehar.getPogodio3()==4){
                    vecodgovarano=true;
                }
                break;
            case 4:
                if(igrapehar.getPogodio4()==4){
                    vecodgovarano=true;
                }
                break;
            case 5:
                if(igrapehar.getPogodio5()==4){
                    vecodgovarano=true;
                }
                break;
            case 6:
                if(igrapehar.getPogodio6()==4){
                    vecodgovarano=true;
                }
                break;
            case 7:
                if(igrapehar.getPogodio7()==4){
                    vecodgovarano=true;
                }
                break;
            case 8:
                if(igrapehar.getPogodio8()==4){
                    vecodgovarano=true;
                }
                break;
            case 9:
                if(igrapehar.getPogodio9()==4){
                    vecodgovarano=true;
                }
                break;
            case 10:
                if(igrapehar.getPogodio10()==4){
                    vecodgovarano=true;
                }
                break;
            case 11:
                if(igrapehar.getPogodio11()==4){
                    vecodgovarano=true;
                }
                break;
            case 12:
                if(igrapehar.getPogodio12()==4){
                    vecodgovarano=true;
                }
                break;
            case 13:
                if(igrapehar.getPogodio13()==4){
                    vecodgovarano=true;
                }
                break;
            case 14:
                if(igrapehar.getPogodio14()==4){
                    vecodgovarano=true;
                }
                break;    
        }
        return vecodgovarano;
    }

    public char getR1s1() {
        return r1s1;
    }

    public void setR1s1(char r1s1) {
        this.r1s1 = r1s1;
    }

    public char getR1s2() {
        return r1s2;
    }

    public void setR1s2(char r1s2) {
        this.r1s2 = r1s2;
    }

    public char getR1s3() {
        return r1s3;
    }

    public void setR1s3(char r1s3) {
        this.r1s3 = r1s3;
    }
    
    
    //-----
    public void podesiIgruPlaviSingle(String username){
        color="black";
        
        inicijalizujNizove();
        
        rednopitanje=1;
        
        zakljucanodgovor=false;
        
        odgovor="";
        
        for(int i=0; i<helper.length; i++){
            helper[i]=false;
        }
        
        disabledbutton=false;
        
        igranapartija=new IgranaPartija();
        igrapehar=new IgraPehar();
        pitanja=new BazaPitanja();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria qb=session.createCriteria(BazaIgraDana.class);
        
        LocalDateTime ldt=LocalDateTime.now();
        String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        
        System.out.printf(datumstring);
        
        BazaIgraDana igradana=(BazaIgraDana)qb.add(Restrictions.eq("datum", datumstring)).uniqueResult();
        
        if(igradana==null){
            System.out.printf("NIJE PRONADJENA IGRA ZA DANAS");
            return;
        }
        
        igrapehar.setUsername1(username);
        igrapehar.setBrpoena1(0);
        igrapehar.setBrpoena2(0);
        igrapehar.setBrpitanja(1);
        igrapehar.setKoigra(1);
        igrapehar.setIdigrapehar(igradana.getIdigre());
        
        Criteria q2=session.createCriteria(BazaPitanja.class);
        List<BazaPitanja> svekombinacije=new ArrayList<>();
        svekombinacije=q2.list();
        
        int maxkombinacije=svekombinacije.size();
        
        int randomNum = ThreadLocalRandom.current().nextInt(1, maxkombinacije + 1);
        
        
        pitanja=(BazaPitanja)q2.add(Restrictions.eq("idbazapitanja", igradana.getIdigre())).uniqueResult();
        
        igrapehar.setIdpitanjaubazi(pitanja.getIdbazapitanja());
    
        igrapehar.setIgrase(true);
        
        session.persist(igrapehar);
        
        timer=30;
        
        timerstart=true;
        
        pitanje=pitanja.getPitanjeprvo9();
        
        transaction.commit();
        session.close();
    }
    
    public void odbrojavajPlaviSingle(int br){
        if(!timerstart) return;
        if(timer>0){
            timer--;
        }
        if(timer==0){
            System.out.printf("ISTEKAO TAJMER");
            zakljucanodgovor=true;
        }
        //ZAVRSENA IGRA
        if(rednopitanje==15){
            System.out.printf("ZAVRSI PLAVI 1");
            zavrsiIgruSingle(1,br);
            return;
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraPehar.class);
        if(igrapehar!=null) igrapehar=(IgraPehar)q.add(Restrictions.eq("username1", igrapehar.getUsername1())).uniqueResult();
        
        if(igrapehar!=null){
            if(igrapehar.getBrpitanja()!=rednopitanje){
                if(igrapehar.getBrpitanja()==15){
                    int brpolja=rednopitanje-1;
                    bojapitanja[brpolja]=uzmiBojuNaPrethodnoPitanje(rednopitanje, igrapehar);
                    String tacanodgovor=uzmiOdgovor(rednopitanje);
                    odgovori[brpolja]=tacanodgovor;
                    podesiIspisOdgovora(rednopitanje, odgovori[brpolja]);
                    rednopitanje=15;
                    return;
                }
                else{
                    System.out.printf("MENJA SE PITANJE PLAVI");
                    int brpolja=rednopitanje-1;
                    bojapitanja[brpolja]=uzmiBojuNaPrethodnoPitanje(rednopitanje, igrapehar);
                    String tacanodgovor=uzmiOdgovor(rednopitanje);
                    odgovori[brpolja]=tacanodgovor;
                    podesiIspisOdgovora(rednopitanje, odgovori[brpolja]);
                    rednopitanje=igrapehar.getBrpitanja();
                    pitanje=uzmiPitanje(rednopitanje);
                    if(igrapehar.getKoigra()==1){
                        disabledbutton=false;
                    }
                    else{
                        disabledbutton=true;
                    }
                    timer=30;
                    timerstart=true;
                    zakljucanodgovor=false;
                    odgovor="";
                }
            }
            else if(rednopitanje!=15){
                int pomredno=rednopitanje-1;
                if(igrapehar.getKoigra()==1 && proveriVecOdgovarano(rednopitanje) && !helper[pomredno]){
                    helper[pomredno]=true;
                    timer=30;
                    timerstart=true;
                    zakljucanodgovor=false;
                    odgovor="";
                    disabledbutton=false;
                }
            }
        }
        
        transaction.commit();
        session.close();
        
        if(zakljucanodgovor && rednopitanje!=15){
            System.out.printf("ZAKLJUCAN ODGOVOR PLAVI");
            disabledbutton=true;
            proveriOdgovorPlaviSingle();
        }
    }
    
    
    
    public void zavrsiIgruSingle(int takmicar, int brpartije){
        
        //OBRISI IZ BAZE I REDIREKTUJ SE
        if((brpartije==1 && takmicar==1) || (brpartije==2 && takmicar==2)){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraDanaPartija.class);
            IgraDanaPartija igradanapart=new IgraDanaPartija();
            
            Criteria q1=session.createCriteria(IgraPehar.class);
        
            if(igrapehar!=null) igrapehar=(IgraPehar)q1.add(Restrictions.eq("username1", igrapehar.getUsername1())).uniqueResult();
            if(igrapehar!=null){
                int brpoena1=igrapehar.getBrpoena1();
                
                
                igradanapart.setUsername(igrapehar.getUsername1());
                igradanapart.setBrpoena(brpoena1);
                
                LocalDateTime ldt=LocalDateTime.now();
                String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
                
                igradanapart.setDatum(datumstring);
                session.saveOrUpdate(igradanapart);
            }
            

            
            if(igrapehar!=null){
                String hqlUpdate="delete IgraPehar where username1=:username1";
                session.createQuery(hqlUpdate).setString("username1", igrapehar.getUsername1()).executeUpdate();
            }
            
            try {
                if(brpartije==1){
                    if(takmicar==1){
                        FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
                    }
                    else{
                        FacesContext.getCurrentInstance().getExternalContext().redirect("peharcrveni2.xhtml");
                    }
                }
                else{
                if(takmicar==1){
                        FacesContext.getCurrentInstance().getExternalContext().redirect("rezultatplavi.xhtml");
                    }
                    else{
                        FacesContext.getCurrentInstance().getExternalContext().redirect("rezultatcrveni.xhtml");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Vesanje.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            transaction.commit();
            session.close();
        }
    }
    
    
    public void odgovoriSingle(int br){
        disabledbutton=true;
        zakljucanodgovor=true;
    }
    
    public void proveriOdgovorPlaviSingle(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraPehar.class);
        igrapehar=(IgraPehar)q.add(Restrictions.eq("username1", igrapehar.getUsername1())).uniqueResult();
        
        String tacanodgovor=uzmiOdgovor(rednopitanje);
        if(odgovor.toLowerCase(Locale.FRENCH).equals(tacanodgovor)){
            
            if(igrapehar!=null){
                igrapehar.setKoigra(1); 
               switch(rednopitanje){
                    case 1:
                        igrapehar.setPogodio1(1);
                        break;
                    case 2:
                        igrapehar.setPogodio2(1);
                        break;
                    case 3:
                        igrapehar.setPogodio3(1);
                        break;
                    case 4:
                        igrapehar.setPogodio4(1);
                        break;
                    case 5:
                        igrapehar.setPogodio5(1);
                        break;
                    case 6:
                        igrapehar.setPogodio6(1);
                        break;
                    case 7:
                        igrapehar.setPogodio7(1);
                        break;
                    case 8:
                        igrapehar.setPogodio8(1);
                        break;
                    case 9:
                        igrapehar.setPogodio9(1);
                        break;
                    case 10:
                        igrapehar.setPogodio10(1);
                        break;
                    case 11:
                        igrapehar.setPogodio11(1);
                        break;
                    case 12:
                        igrapehar.setPogodio12(1);
                        break;
                    case 13:
                        igrapehar.setPogodio13(1);
                        break;
                    case 14:
                        igrapehar.setPogodio14(1);
                        break;   
                }
                int redno=rednopitanje+1;
                timer=30;
                igrapehar.setBrpitanja(redno);
                int prethpoeni=igrapehar.getBrpoena1();
                prethpoeni+=2;
                igrapehar.setBrpoena1(prethpoeni);
                }
            }
            else{
                //VEC JE ODGOVARANO, PREDJI NA SLEDECE PITANJE, ALI PUSTI DRUGOG

                    System.out.printf("vec odgovarano");
                    int redno=rednopitanje+1;
                    igrapehar.setBrpitanja(redno);
                    igrapehar.setKoigra(1);

                    timer=30;
                    timerstart=true;
                }
            zakljucanodgovor=false;

            session.saveOrUpdate(igrapehar);

            transaction.commit();
            session.close();
        }
}
