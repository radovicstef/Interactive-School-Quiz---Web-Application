/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.Anagrami;
import entityBeans.BazaIgraDana;
import entityBeans.IgraAnagrami;
import entityBeans.IgraDanaPartija;
import entityBeans.IgranaPartija;
import entityBeans.Partija;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */
@ManagedBean (name="anagramsingle")
@SessionScoped
public class AnagramSingle implements Serializable{
    private String labela="ANAGRAM";
    
    private String color;
    
    private IgranaPartija partija;
    private IgraAnagrami igraanagram;
    private Anagrami anagramobjekt;
    private IgraDanaPartija igradanapartija;
    
    private String odgovor;
    
    private boolean zakljucanodgovor;
    
    private int timer;
    
    private String tekst;
    
    private String resenje;

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
    
    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public boolean isZakljucanodgovor() {
        return zakljucanodgovor;
    }

    public void setZakljucanodgovor(boolean zakljucanodgovor) {
        this.zakljucanodgovor = zakljucanodgovor;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public Anagrami getAnagramobjekt() {
        return anagramobjekt;
    }

    public void setAnagramobjekt(Anagrami anagramobjekt) {
        this.anagramobjekt = anagramobjekt;
    }

    public IgranaPartija getPartija() {
        return partija;
    }

    public void setPartija(IgranaPartija partija) {
        this.partija = partija;
    }

    public IgraAnagrami getIgraanagram() {
        return igraanagram;
    }

    public void setIgraanagram(IgraAnagrami igraanagram) {
        this.igraanagram = igraanagram;
    }

    public String getLabela() {
        return labela;
    }

    public void setLabela(String labela) {
        this.labela = labela;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public void podesiIgru(String username){
        
        partija=new IgranaPartija();
        igraanagram=new IgraAnagrami();
        anagramobjekt=new Anagrami();
        
        zakljucanodgovor=false;
        
        timer=60;
        
        odgovor="";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria qa=session.createCriteria(Anagrami.class);
        Criteria qb=session.createCriteria(BazaIgraDana.class);
        
        LocalDateTime ldt=LocalDateTime.now();
        String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        
        System.out.printf(datumstring);
        
        BazaIgraDana igradana=(BazaIgraDana)qb.add(Restrictions.eq("datum", datumstring)).uniqueResult();
        
        if(igradana==null){
            System.out.printf("NIJE PRONADJENA IGRA ZA DANAS");
            return;
        }
        
        anagramobjekt=(Anagrami)qa.add(Restrictions.eq("idanagrami", igradana.getIdigre())).uniqueResult();
        
        tekst=anagramobjekt.getTekst();
        resenje=anagramobjekt.getResenje();
        
        igradanapartija=new IgraDanaPartija();
        igradanapartija.setDatum(datumstring);
        igradanapartija.setUsername(username);

        session.persist(igradanapartija);
        
        transaction.commit();
        session.close();
        
    }
    
    public void odgovori(){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();

         Criteria q=session.createCriteria(IgraDanaPartija.class);
         if(igradanapartija!=null) igradanapartija=(IgraDanaPartija)q.add(Restrictions.eq("datum", igradanapartija.getDatum())).add(Restrictions.eq("username", igradanapartija.getUsername())).uniqueResult();
         
         int brpoena=0;
         
         if(odgovor.equals(resenje)){
             brpoena=10;
         }
         
         if(igradanapartija!=null) igradanapartija.setBrpoena(brpoena);
         
         session.saveOrUpdate(igradanapartija);
         
         transaction.commit();
         session.close();
         
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(AnagramSingle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    public void odbrojavaj(){
        if(timer>-1){
            timer--;
        }
        if(timer==-1){
            zakljucanodgovor=true;
            odgovori();
        }
    }
}
