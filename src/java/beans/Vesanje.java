
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.IgraVesanja;
import entityBeans.IgranaPartija;
import entityBeans.Vesanja;
import java.io.IOException;
import java.io.Serializable;
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

@ManagedBean(name="vesanje")
@SessionScoped
public class Vesanje implements Serializable{
    
    private String color;

    private String otkrivenarec;
    
    private String displayotkrivenarec;
    
    private String pogodjenaslova;
    
    private String promasenaslova;
    
    private String odgovor;
    
    private IgranaPartija partija;
    private IgraVesanja igravesanja;
    private Vesanja vesanjaobjekat;
    
    private String trenutnaslika;
    
    private int idigrevesanja;

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
 
    
    public void podesiIgruPlavi(String username, int br){
        if(br==1){
            color="cornflowerblue";
        }
        else{
            color="orangered";
        }
        
        trenutnaslika="resources/images/hangman0.png";
        
        odgovor="";
        
        otkrivenarec="";
        
        displayotkrivenarec="";
        
        partija=new IgranaPartija();
        igravesanja=new IgraVesanja();
        vesanjaobjekat=new Vesanja();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria q=session.createCriteria(IgranaPartija.class);
        Criteria qb=session.createCriteria(Vesanja.class);
        partija=(IgranaPartija)q.add(Restrictions.eq("username1", username)).uniqueResult();
        
        if(partija!=null){
            igravesanja.setIdigranapartija(partija.getIdigranapartija());
            igravesanja.setUsername1(partija.getUsername1());
            igravesanja.setUsername2(partija.getUsername2());
            igravesanja.setPogodjenaslova("");
            igravesanja.setPromasenaslova("");
        }
        
        List<Vesanja> vesanja=new ArrayList<>();
        vesanja=qb.list();
        
        int maxbr=vesanja.size();
        
        int randomNum = ThreadLocalRandom.current().nextInt(1, maxbr + 1);

        q=session.createCriteria(Vesanja.class);
        vesanjaobjekat=(Vesanja)q.add(Restrictions.eq("idvesanja", randomNum)).uniqueResult();
        
        igravesanja.setRec(vesanjaobjekat.getRec());
        
        displayotkrivenarec="";
        char[] parsiranarec=igravesanja.getRec().toCharArray();
        for(char slovo: parsiranarec){
            displayotkrivenarec+=" _ ";
        }
        
        if(br==1){
            igravesanja.setKoigra(0);
        }
        else{
            igravesanja.setKoigra(1);
        }
        
        igravesanja.setIgrase(true);

        session.persist(igravesanja);
        
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
        
        trenutnaslika="resources/images/hangman0.png";
        
        odgovor="";
        
        otkrivenarec="";
        
        displayotkrivenarec="";
        
        boolean ready=false;
        
        while(!ready){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraVesanja.class);
            igravesanja=(IgraVesanja)q.add(Restrictions.eq("username2", username)).uniqueResult();
            
            if(igravesanja!=null){
                char[] parsiranarec=igravesanja.getRec().toCharArray();
                for(char slovo: parsiranarec){
                    displayotkrivenarec+=" _ ";
                }
                ready=true;
                idigrevesanja=igravesanja.getIdigravesanja();
            }
            
            
            transaction.commit();
            session.close();
        }
        
    }
    
    public void podesiOtkrivenaRec(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraVesanja.class);
        if(igravesanja!=null) igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();

        if(igravesanja!=null){
            System.out.printf("OTKRIVENA REC");
            System.out.printf(displayotkrivenarec);
            promasenaslova=igravesanja.getPromasenaslova();
            otkrivenarec=igravesanja.getPogodjenaslova();
            String rec=igravesanja.getRec();
            if(!otkrivenarec.equals("")){
                char[] parsiranorec=rec.toCharArray();
                char[] parsiranopogodjeno=otkrivenarec.toCharArray();
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
        }
        System.out.printf(displayotkrivenarec);
        System.out.printf(promasenaslova);
        transaction.commit();
        session.close();  
    }
    
    public boolean koigraPlavi(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraVesanja.class);
        if(igravesanja!=null) igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
        
        transaction.commit();
        session.close();
        
        if(igravesanja!=null){
            if(igravesanja.getKoigra()==0){
                System.out.printf("IGRA PLAVI");
                return false;
            }
            else if(igravesanja.getKoigra()==1){
                return true;
            }    
        }
        return true;
    }
    
    public boolean koigraCrveni(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraVesanja.class);
        if(igravesanja!=null) igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
        
        transaction.commit();
        session.close();
        
        if(igravesanja!=null){
            if(igravesanja.getKoigra()==0){
                return true;
            }
            else if(igravesanja.getKoigra()==1){
                System.out.printf("IGRA CRVENI");
                return false;
            }    
        }
        return true;
    }
    
    public void odgovoriPlavi(){
        System.out.printf(odgovor);
        char[] parsiranodgovor=odgovor.toCharArray();
        //NEREGULARNO JE DA ODGOVOR IMA VISE OD JEDNOG SLOVA
        if(parsiranodgovor.length>1 || odgovor.equals("")){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraVesanja.class);
            igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();

            int brpromasenih2=igravesanja.getBrpromasenih2();
            
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
            }
            
            igravesanja.setBrpromasenih1(brpromasenih);
            
            if(brpromasenih2<4){
                igravesanja.setKoigra(1);
            }
            else if(brpromasenih==4){
                igravesanja.setKoigra(2);
            }
                
            session.saveOrUpdate(igravesanja);

            transaction.commit();
            session.close();
        }
        else{
            System.out.printf("OVDE SAAM");
            String rec=igravesanja.getRec();
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
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction=session.beginTransaction();

                Criteria q=session.createCriteria(IgraVesanja.class);
                igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
                
                String pogodjenopreth=igravesanja.getPogodjenaslova();
                
                boolean correctrepeated=false;
                for(int i=0; i<pogodjenopreth.length(); i++){
                    if(pogodjenopreth.charAt(i)==odgovor.charAt(0)){
                        correctrepeated=true;
                        break;
                    }
                }
                
                if(!correctrepeated){
                    pogodjenopreth+=odgovor;
                
                    igravesanja.setPogodjenaslova(pogodjenopreth);

                    int brpoenapreth=igravesanja.getBrpoena1();
                    brpoenapreth+=1;

                    igravesanja.setBrpoena1(brpoenapreth);

                    session.saveOrUpdate(igravesanja);
                    
                }

                transaction.commit();
                session.close();
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
                }
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction=session.beginTransaction();

                Criteria q=session.createCriteria(IgraVesanja.class);
                igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
                
                promasenaslova=igravesanja.getPromasenaslova();
                
                promasenaslova+=odgovor;
                
                int brpromasenih2=igravesanja.getBrpromasenih2();
                
                igravesanja.setPromasenaslova(promasenaslova);
                igravesanja.setBrpromasenih1(brpromasenih);
                
                if(brpromasenih2<4){
                    igravesanja.setKoigra(1);
                }
                else if(brpromasenih==4){
                    igravesanja.setKoigra(2);
                }
                
                session.saveOrUpdate(igravesanja);
                
                transaction.commit();
                session.close();
            }
            odgovor="";
        }
    }
    
    public void odgovoriCrveni(){
        System.out.printf(odgovor);
        char[] parsiranodgovor=odgovor.toCharArray();
        //NEREGULARNO JE DA ODGOVOR IMA VISE OD JEDNOG SLOVA
        if(parsiranodgovor.length>1){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraVesanja.class);
            igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();

            int brpromasenih1=igravesanja.getBrpromasenih1();
            
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
            }
            
            igravesanja.setBrpromasenih2(brpromasenih);
            
            if(brpromasenih1<4){
                igravesanja.setKoigra(0);
            }
            else if(brpromasenih==4){
                igravesanja.setKoigra(2);
            }
                
            session.saveOrUpdate(igravesanja);

            transaction.commit();
            session.close();
        }
        else{
            System.out.printf("OVDE SAAM");
            String rec=igravesanja.getRec();
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
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction=session.beginTransaction();

                Criteria q=session.createCriteria(IgraVesanja.class);
                igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
                
                String pogodjenopreth=igravesanja.getPogodjenaslova();
                
                boolean correctrepeated=false;
                for(int i=0; i<pogodjenopreth.length(); i++){
                    if(pogodjenopreth.charAt(i)==odgovor.charAt(0)){
                        correctrepeated=true;
                        break;
                    }
                }
                
                if(!correctrepeated){
                    pogodjenopreth+=odgovor;

                    igravesanja.setPogodjenaslova(pogodjenopreth);

                    int brpoenapreth=igravesanja.getBrpoena2();
                    brpoenapreth+=1;

                    igravesanja.setBrpoena2(brpoenapreth);

                    session.saveOrUpdate(igravesanja);
                }

                transaction.commit();
                session.close();
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
                }
                
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction=session.beginTransaction();

                Criteria q=session.createCriteria(IgraVesanja.class);
                igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
                
                promasenaslova=igravesanja.getPromasenaslova();
                
                promasenaslova+=odgovor;
                
                int brpromasenih1=igravesanja.getBrpromasenih2();
                
                igravesanja.setPromasenaslova(promasenaslova);
                igravesanja.setBrpromasenih2(brpromasenih);
                
                if(brpromasenih1<4){
                    igravesanja.setKoigra(0);
                }
                else if(brpromasenih==4){
                    igravesanja.setKoigra(2);
                }
                
                session.saveOrUpdate(igravesanja);
                
                transaction.commit();
                session.close();
            }
            odgovor="";
        }
    }
    
    public void proveriKrajPlavi(int br){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraVesanja.class);
        Criteria qp=session.createCriteria(IgranaPartija.class);
        
        if(igravesanja!=null){
            igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
            if(!igravesanja.isIgrase()){
                partija=(IgranaPartija)qp.add(Restrictions.eq("username1", partija.getUsername1())).uniqueResult();

                int poeniplavi=igravesanja.getBrpoena1();
                int poenicrveni=igravesanja.getBrpoena2();

                int prethodnipoeniplavi=partija.getPoeni1();
                int prethodnipoenicrveni=partija.getPoeni2();

                int prethpoeni1=partija.getVesanje1();
                int prethpoeni2=partija.getVesanje2();

                prethpoeni1+=poeniplavi;
                prethpoeni2+=poenicrveni;
                
                poeniplavi+=prethodnipoeniplavi;
                poenicrveni+=prethodnipoenicrveni;

                partija.setPoeni1(poeniplavi);
                partija.setPoeni2(poenicrveni);

                partija.setVesanje1(prethpoeni1);
                partija.setVesanje2(prethpoeni2);

                session.saveOrUpdate(partija);

                String hqlUpdate="delete IgraVesanja where username1=:username1";
                session.createQuery(hqlUpdate).setString("username1", igravesanja.getUsername1()).executeUpdate();
                
                try {
                    if(br==1){
                        FacesContext.getCurrentInstance().getExternalContext().redirect("vesanjeplavi2.xhtml");
                    }
                    else{
                        FacesContext.getCurrentInstance().getExternalContext().redirect("zanimljivageografijaplavi.xhtml");
                    }
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
                    if(igravesanja!=null){
                        igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
                        int koigra=igravesanja.getKoigra();
                        if(koigra==0){
                            int brpoenapreth=igravesanja.getBrpoena1();
                            brpoenapreth++;
                            igravesanja.setBrpoena1(brpoenapreth);
                            igravesanja.setIgrase(false);
                            igravesanja.setKoigra(2);
                        }
                        else{
                            int brpoenapreth=igravesanja.getBrpoena2();
                            brpoenapreth++;
                            igravesanja.setBrpoena2(brpoenapreth);
                            igravesanja.setIgrase(false);
                            igravesanja.setKoigra(2);
                        }
                        session.saveOrUpdate(igravesanja);
                    } 
                }
                else{
                    if(igravesanja!=null){
                        igravesanja=(IgraVesanja)q.add(Restrictions.eq("username1", igravesanja.getUsername1())).uniqueResult();
                        int brpogresnih1=igravesanja.getBrpromasenih1();
                        int brpogresnih2=igravesanja.getBrpromasenih2();
                        
                        if(brpogresnih1==4 && brpogresnih2==4){
                            igravesanja.setIgrase(false);
                            session.saveOrUpdate(igravesanja);
                        }
                    }
                }
            }

            transaction.commit();
            session.close();
        }
    }
    
    public void proveriKrajCrveni(int br){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraVesanja.class);
        igravesanja=(IgraVesanja)q.add(Restrictions.eq("idigravesanja", idigrevesanja)).uniqueResult();
        
        if(igravesanja==null){
            try {
                if(br==1){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("vesanjecrveni2.xhtml");
                }
                else{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("zanimljivageografijacrveni.xhtml");
                }
               
            } catch (IOException ex) {
                Logger.getLogger(Vesanje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        transaction.commit();
        session.close();
    }
}
