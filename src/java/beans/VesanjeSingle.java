
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.BazaIgraDana;
import entityBeans.IgraDanaPartija;
import entityBeans.IgraVesanja;
import entityBeans.IgranaPartija;
import entityBeans.Vesanja;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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

@ManagedBean(name="vesanjesingle")
@SessionScoped
public class VesanjeSingle implements Serializable{
    
    private String color;

    private String otkrivenarec;
    
    private String displayotkrivenarec;
    
    private String pogodjenaslova;
    
    private String promasenaslova;
    
    private String odgovor;
    
    private IgranaPartija partija;
    private IgraVesanja igravesanja;
    private Vesanja vesanjaobjekat;
    private IgraDanaPartija igradanapart;
    
    private String trenutnaslika;
    
    private int idigrevesanja;
    
    private String rec;
    
    private int brpoena;
    

    public IgraVesanja getIgravesanja() {
        return igravesanja;
    }

    public void setIgravesanja(IgraVesanja igravesanja) {
        this.igravesanja = igravesanja;
    }

    public String getTrenutnaslika() {
        return trenutnaslika;
    }

    public void setTrenutnaslika(String trenutnaslika) {
        this.trenutnaslika = trenutnaslika;
    }

    public String getDisplayotkrivenarec() {
        return displayotkrivenarec;
    }

    public void setDisplayotkrivenarec(String displayotkrivenarec) {
        this.displayotkrivenarec = displayotkrivenarec;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public String getPogodjenaslova() {
        return pogodjenaslova;
    }

    public void setPogodjenaslova(String pogodjenaslova) {
        this.pogodjenaslova = pogodjenaslova;
    }

    public String getPromasenaslova() {
        return promasenaslova;
    }

    public void setPromasenaslova(String promasenaslova) {
        this.promasenaslova = promasenaslova;
    }

    public String getOtkrivenarec() {
        return otkrivenarec;
    }

    public void setOtkrivenarec(String otkrivenarec) {
        this.otkrivenarec = otkrivenarec;
    }
    
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
 
    
    public void podesiIgru(String username){
        
        trenutnaslika="resources/images/hangman0.png";
        
        odgovor="";
        
        otkrivenarec="";
        
        displayotkrivenarec="";
        
        brpoena=0;
        
        promasenaslova="";
        
        pogodjenaslova="";
        
        partija=new IgranaPartija();
        igravesanja=new IgraVesanja();
        vesanjaobjekat=new Vesanja();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria qb=session.createCriteria(Vesanja.class);
        
        igradanapart=new IgraDanaPartija();
        
        LocalDateTime ldt=LocalDateTime.now();
        String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        
        igradanapart.setUsername(username);
        igradanapart.setDatum(datumstring);
 
        session.persist(igradanapart);
        
        List<Vesanja> vesanja=new ArrayList<>();
        vesanja=qb.list();
        
        int maxbr=vesanja.size();
        
        int randomNum = ThreadLocalRandom.current().nextInt(1, maxbr + 1);

        Criteria q=session.createCriteria(Vesanja.class);
        vesanjaobjekat=(Vesanja)q.add(Restrictions.eq("idvesanja", randomNum)).uniqueResult();
        
        rec=vesanjaobjekat.getRec();
        
        displayotkrivenarec="";
        char[] parsiranarec=rec.toCharArray();
        for(char slovo: parsiranarec){
            displayotkrivenarec+=" _ ";
        }
        
        transaction.commit();
        session.close();
    }
    
    public void podesiOtkrivenaRec(){;
        
        if(!pogodjenaslova.equals("")){
                char[] parsiranorec=rec.toCharArray();
                char[] parsiranopogodjeno=pogodjenaslova.toCharArray();
                displayotkrivenarec="";
                for(char slovo: parsiranorec){
                    boolean pogodjeno=false;
                    for(int i=0; i<parsiranopogodjeno.length; i++){
                        if(slovo==parsiranopogodjeno[i]){
                            displayotkrivenarec+=" ";
                            displayotkrivenarec+=slovo;
                            displayotkrivenarec+=" ";
                            pogodjeno=true;
                            break;
                        }
                    }
                    if(!pogodjeno) displayotkrivenarec+=" _ ";
                }
        }
        
        char[] displayparsirano=displayotkrivenarec.toCharArray();
        boolean kraj=true;
        for(char karakter : displayparsirano){
            if(karakter == ' ') continue;
            if(karakter == '_'){
                kraj=false;
                break;
            }
        }
        if(kraj){
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraDanaPartija.class);
            igradanapart=(IgraDanaPartija)q.add(Restrictions.eq("username", igradanapart.getUsername())).add(Restrictions.eq("datum", igradanapart.getDatum())).uniqueResult();
            igradanapart.setBrpoena(brpoena);

            session.saveOrUpdate(igradanapart);

            transaction.commit();
            session.close();
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(VesanjeSingle.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    
    public void odgovori(){
        System.out.printf(odgovor);
        char[] parsiranodgovor=odgovor.toCharArray();
        //NEREGULARNO JE DA ODGOVOR IMA VISE OD JEDNOG SLOVA
        if(parsiranodgovor.length>1 || odgovor.equals("")){
            int brpromasenih=0;
            if(trenutnaslika.equals("resources/images/hangman0.png")){
                trenutnaslika="resources/images/hangman1.png";
                brpromasenih=1;
            }
            else if(trenutnaslika.equals("resources/images/hangman1.png")){
                trenutnaslika="resources/images/hangman2.png";
                brpromasenih=2;
            }
            else if(trenutnaslika.equals("resources/images/hangman2.png")){
                trenutnaslika="resources/images/hangman3.png";
                brpromasenih=3;
            }
            else if(trenutnaslika.equals("resources/images/hangman3.png")){
                trenutnaslika="resources/images/hangman4.png";
                brpromasenih=4;
                proveriKraj();
            }
        }
        else{
            System.out.printf("OVDE SAAM");
            char[] parsiranarec=rec.toCharArray();
            boolean pogodjeno=false;
            for(char slovo: parsiranarec){
                if(slovo==odgovor.charAt(0)){
                    pogodjeno=true;
                    break;
                }
            }
            if(pogodjeno){
                System.out.printf("pogodjeno");
                
                boolean correctrepeated=false;
                if(!pogodjenaslova.equals("")){
                    for(int i=0; i<pogodjenaslova.length(); i++){
                        if(pogodjenaslova.charAt(i)==odgovor.charAt(0)){
                            correctrepeated=true;
                            break;
                        }
                    }
                }
                
                if(!correctrepeated){
                    pogodjenaslova+=odgovor;
                    
                    brpoena+=1;
                    
                }
            }
            else{
                int brpromasenih=0;
                if(trenutnaslika.equals("resources/images/hangman0.png")){
                    trenutnaslika="resources/images/hangman1.png";
                    brpromasenih=1;
                }
                else if(trenutnaslika.equals("resources/images/hangman1.png")){
                    trenutnaslika="resources/images/hangman2.png";
                    brpromasenih=2;
                }
                else if(trenutnaslika.equals("resources/images/hangman2.png")){
                    trenutnaslika="resources/images/hangman3.png";
                    brpromasenih=3;
                }
                else if(trenutnaslika.equals("resources/images/hangman3.png")){
                    trenutnaslika="resources/images/hangman4.png";
                    brpromasenih=4;
                    proveriKraj();
                }
                
                promasenaslova+=odgovor;
            }
            odgovor="";
        }
    }
    
    public void proveriKraj(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraDanaPartija.class);
        
        if(igradanapart!=null){
            igradanapart=(IgraDanaPartija)q.add(Restrictions.eq("username", igradanapart.getUsername())).add(Restrictions.eq("datum", igradanapart.getDatum())).uniqueResult();
            if(trenutnaslika.equals("resources/images/hangman4.png")){

                igradanapart.setBrpoena(brpoena);
                
                session.saveOrUpdate(igradanapart);
                
                try {
                    transaction.commit();
                    session.close();
                    FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(Vesanje.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
               //PROVERI DA LI SU POGODJENA SLOVA
                char[] displayparsirano=displayotkrivenarec.toCharArray();
                boolean kraj=true;
                for(char karakter : displayparsirano){
                    if(karakter == ' ') continue;
                    if(karakter == '_'){
                        kraj=false;
                        break;
                    }
                }

                if(kraj){
                    if(igradanapart!=null){
                        igradanapart=(IgraDanaPartija)q.add(Restrictions.eq("username", igradanapart.getUsername())).add(Restrictions.eq("datum", igradanapart.getDatum())).uniqueResult();

                        igradanapart.setBrpoena(brpoena);

                        session.saveOrUpdate(igradanapart);

                        try {
                            transaction.commit();
                            session.close();
                            FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
                        } catch (IOException ex) {
                            Logger.getLogger(Vesanje.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else{
                }
            }

            transaction.commit();
            session.close();
        }
    }
}
