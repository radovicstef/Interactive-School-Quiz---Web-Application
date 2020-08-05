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
import java.io.IOException;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */
@ManagedBean(name="admin")
@SessionScoped
public class Admin implements Serializable{
    private boolean anagram;  
    private boolean mojbroj;
    private boolean vesanje;
    private boolean zgeos;
    private boolean pehar;
    
    private Date izabranDatum;
    
    private int idulisti;
    
    private String tekst;
    private String resenje;
    
    private String[] pitanja=new String[14];
    private String[] odgovori=new String[14];
    

    public String[] getPitanja() {
        return pitanja;
    }

    public void setPitanja(String[] pitanja) {
        this.pitanja = pitanja;
    }

    public String[] getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(String[] odgovori) {
        this.odgovori = odgovori;
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
    
    private List<Integer> ideviulisti;

    public int getIdulisti() {
        return idulisti;
    }

    public void setIdulisti(int idulisti) {
        this.idulisti = idulisti;
    }

    public List<Integer> getIdeviulisti() {
        return ideviulisti;
    }

    public void setIdeviulisti(List<Integer> ideviulisti) {
        this.ideviulisti = ideviulisti;
    }

    public Date getIzabranDatum() {
        return izabranDatum;
    }

    public void setIzabranDatum(Date izabranDatum) {
        this.izabranDatum = izabranDatum;
    }

    public boolean isAnagram() {
        return anagram;
    }

    public void setAnagram(boolean anagram) {
        this.anagram = anagram;
    }

    public boolean isMojbroj() {
        return mojbroj;
    }

    public void setMojbroj(boolean mojbroj) {
        this.mojbroj = mojbroj;
    }

    public boolean isVesanje() {
        return vesanje;
    }

    public void setVesanje(boolean vesanje) {
        this.vesanje = vesanje;
    }

    public boolean isZgeos() {
        return zgeos;
    }

    public void setZgeos(boolean zgeos) {
        this.zgeos = zgeos;
    }

    public boolean isPehar() {
        return pehar;
    }

    public void setPehar(boolean pehar) {
        this.pehar = pehar;
    }
     
    public void addMessageAnagram() {
        String summary = anagram ? "Izabran ANAGRAM" : "Poništen ANAGRAM";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    
    public void addMessageMojBroj() {
        String summary = mojbroj ? "Izabran MOJBROJ" : "Poništen MOJBROJ";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    
    public void addMessageVesanje() {
        String summary = vesanje ? "Izabrno VEŠANJE" : "Poništeno VEŠANJE";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    
    public void addMessageZgeos() {
        String summary = zgeos ? "Izabran ZGEOS" : "Poništen ZGEOS";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    
    public void addMessagePehar() {
        String summary = pehar ? "Izabran PEHAR" : "Poništen PEHAR";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
    }
    
    
    public void refresh(){
        pehar=false;
        zgeos=false;
        mojbroj=false;
        anagram=false;
        izabranDatum=new Date();
    }
    
    public void izaberiIgru(){
        int brizabranih=0;
        if(pehar) brizabranih++;
        if(zgeos) brizabranih++;
        if(vesanje) brizabranih++;
        if(mojbroj) brizabranih++;
        if(anagram) brizabranih++;
        
        if(brizabranih>1){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Izaberite samo jednu igru dana!",""));
            return;
        }
        if(brizabranih==0){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Izaberite jednu igru dana!",""));
            return;
        }
        
        if(pehar){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("adminpehar.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(anagram){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("adminanagram.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
           try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("adminizaberidatum.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public void postaviIgru(){
        BazaIgraDana igradana=new BazaIgraDana();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
    
        Criteria q=session.createCriteria(BazaIgraDana.class);
        List<BazaIgraDana> bazaigara=new ArrayList<>();
        
        DateFormat datumformat=new SimpleDateFormat("yyyy-MM-dd");
        
        String datumstring=datumformat.format(izabranDatum);
        
        bazaigara=q.add(Restrictions.eq("datum", datumstring)).list();
        
        if(!bazaigara.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Vec je izabran ovaj datum!",""));
            transaction.commit();
            session.close();
            return;
        }
        else{
            igradana.setDatum(datumstring);
            if(mojbroj){
                igradana.setTipigre("mojbroj");
            }
            else if(vesanje){
                igradana.setTipigre("vesanje");
            }
            else if(zgeos){
                igradana.setTipigre("zgeos");
            }
            else if(pehar){
                igradana.setTipigre("pehar");
                igradana.setIdigre(idulisti);
            }
            else if(anagram){
                igradana.setTipigre("anagram");
                igradana.setIdigre(idulisti);
            }
            session.persist(igradana);
        }
        
        transaction.commit();
        session.close();
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("adminigradana.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void inicijalizujAnagram(){
        tekst="";
        resenje="";
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        ideviulisti=new LinkedList<>();
    
        Criteria q=session.createCriteria(Anagrami.class);
        List<Anagrami> anagrami=new ArrayList<Anagrami>() ;
        anagrami=q.list();
        
        Iterator<Anagrami> it=anagrami.iterator();
        while(it.hasNext()){
            Anagrami anagrampom=it.next();
            ideviulisti.add(anagrampom.getIdanagrami());
        }
        
        transaction.commit();
        session.close();
    }
    
    public void promenaAnagram(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
    
        Criteria q=session.createCriteria(Anagrami.class);
        
        Anagrami anagram=(Anagrami)q.add(Restrictions.eq("idanagrami", idulisti)).uniqueResult();
        
        tekst=anagram.getTekst();
        resenje=anagram.getResenje();
        
        transaction.commit();
        session.close();
    }
    
     public void inicijalizujPehar(){
        pitanja=new String[14];
        odgovori=new String[14];
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        ideviulisti=new LinkedList<>();
    
        Criteria q=session.createCriteria(BazaPitanja.class);
        List<BazaPitanja> bazapitanja=new ArrayList<BazaPitanja>();
        bazapitanja=q.list();
        
        Iterator<BazaPitanja> it=bazapitanja.iterator();
        while(it.hasNext()){
            BazaPitanja bazapitanje=it.next();
            ideviulisti.add(bazapitanje.getIdbazapitanja());
        }
        
        transaction.commit();
        session.close();
    }
     
     public void promenaPehar(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
    
        Criteria q=session.createCriteria(BazaPitanja.class);
        
        BazaPitanja pitanj=(BazaPitanja)q.add(Restrictions.eq("idbazapitanja", idulisti)).uniqueResult();
        
        if(pitanj!=null){
            pitanja[0]=pitanj.getPitanjeprvo9();
            pitanja[1]=pitanj.getPitanjeprvo8();
            pitanja[2]=pitanj.getPitanjeprvo7();
            pitanja[3]=pitanj.getPitanjeprvo6();
            pitanja[4]=pitanj.getPitanjeprvo5();
            pitanja[5]=pitanj.getPitanjeprvo4();
            pitanja[6]=pitanj.getPitanjeprvo3();
            pitanja[7]=pitanj.getPitanjedrugo3();
            pitanja[8]=pitanj.getPitanjedrugo4();
            pitanja[9]=pitanj.getPitanjedrugo5();
            pitanja[10]=pitanj.getPitanjedrugo6();
            pitanja[11]=pitanj.getPitanjedrugo7();
            pitanja[12]=pitanj.getPitanjedrugo8();
            pitanja[13]=pitanj.getPitanjedrugo9();

            odgovori[0]=pitanj.getOdgovorprvi9();
            odgovori[1]=pitanj.getOdgovorprvi8();
            odgovori[2]=pitanj.getOdgovorprvi7();
            odgovori[3]=pitanj.getOdgovorprvi6();
            odgovori[4]=pitanj.getOdgovorprvi5();
            odgovori[5]=pitanj.getOdgovorprvi4();
            odgovori[6]=pitanj.getOdgovorprvi3();
            odgovori[7]=pitanj.getOdgovordrugi3();
            odgovori[8]=pitanj.getOdgovordrugi4();
            odgovori[9]=pitanj.getOdgovordrugi5();
            odgovori[10]=pitanj.getOdgovordrugi6();
            odgovori[11]=pitanj.getOdgovordrugi7();
            odgovori[12]=pitanj.getOdgovordrugi8();
            odgovori[13]=pitanj.getOdgovordrugi9();
        }
        
        transaction.commit();
        session.close();
    }
     
     
     public void izmeniIgruDana(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
    
        Criteria q=session.createCriteria(IgraDanaPartija.class);
        
        Criteria q1=session.createCriteria(BazaIgraDana.class);
        
        Date datum=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String datumstring=sdf.format(datum);
        
        BazaIgraDana igradana=(BazaIgraDana)q1.add(Restrictions.eq("datum", datumstring)).uniqueResult();
        if(igradana==null){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Postavite igru dana!"));
            return;
        }
        
        
        List<IgraDanaPartija> igradanapart=q.add(Restrictions.eq("datum", datumstring)).list();
        
        if(igradanapart==null){
            try {
                String hqlUpdate="delete BazaIgraDana where datum=:datumstring";
                session.createQuery(hqlUpdate).setString("datumstring", datumstring).executeUpdate();
                transaction.commit();
                session.close();
                FacesContext.getCurrentInstance().getExternalContext().redirect("adminigradana.xhtml");
                return;
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(igradanapart.isEmpty()){
            try {
                String hqlUpdate="delete BazaIgraDana where datum=:datumstring";
                session.createQuery(hqlUpdate).setString("datumstring", datumstring).executeUpdate();
                transaction.commit();
                session.close();
                FacesContext.getCurrentInstance().getExternalContext().redirect("adminigradana.xhtml");
                return;
            } catch (IOException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nije moguće izmeniti igru dana!"));
        }
        
     }
}
