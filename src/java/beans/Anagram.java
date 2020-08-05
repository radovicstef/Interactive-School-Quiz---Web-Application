/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.Anagrami;
import entityBeans.IgraAnagrami;
import entityBeans.IgranaPartija;
import entityBeans.Partija;
import java.io.IOException;
import java.io.Serializable;
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
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */
@ManagedBean (name="anagram")
@SessionScoped
public class Anagram implements Serializable{
    private String labela="ANAGRAM";
    
    private String color;
    
    private IgranaPartija partija;
    private IgraAnagrami igraanagram;
    private Anagrami anagramobjekt;
    
    private String odgovor;
    
    private boolean zakljucanodgovor;
    
    private int timer;

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
    
    public void podesiIgruPlavi(String username, int br){
        if(br==1){
            color="cornflowerblue";
        }
        else{
            color="orangered";
        }
        
        partija=new IgranaPartija();
        igraanagram=new IgraAnagrami();
        anagramobjekt=new Anagrami();
        
        zakljucanodgovor=false;
        
        timer=60;
        
        odgovor="";
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria q=session.createCriteria(IgranaPartija.class);
        Criteria qb=session.createCriteria(Anagrami.class);
        partija=(IgranaPartija)q.add(Restrictions.eq("username1", username)).uniqueResult();
        
        if(br==1){
            partija.setPoeni1(0);
            partija.setPoeni2(0);    
            session.persist(partija);
        }
        
        
        igraanagram.setIdigranapartija(partija.getIdigranapartija());
        igraanagram.setUsername1(partija.getUsername1());
        igraanagram.setUsername2(partija.getUsername2());
        
        List<Anagrami> anagrami=new ArrayList<>();
        anagrami=qb.list();
        
        int maxbr=anagrami.size();
        
        int randomNum = ThreadLocalRandom.current().nextInt(1, maxbr + 1);

        q=session.createCriteria(Anagrami.class);
        
        anagramobjekt=(Anagrami)q.add(Restrictions.eq("idanagrami", randomNum)).uniqueResult();
   
        while(anagramobjekt==null){
            randomNum = ThreadLocalRandom.current().nextInt(1, maxbr + 1);
            anagramobjekt=(Anagrami)q.add(Restrictions.eq("idanagrami", randomNum)).uniqueResult();
        }
        
        if(anagramobjekt!=null){
            igraanagram.setTekst(anagramobjekt.getTekst());
            igraanagram.setResenje(anagramobjekt.getResenje());
            igraanagram.setIgrase(1);
        }
        
        session.persist(igraanagram);
        
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
        
        boolean ready=false;
        
        zakljucanodgovor=false;
        
        timer=60;
        
        odgovor="";
        
        while(!ready){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraAnagrami.class);
            igraanagram=(IgraAnagrami)q.add(Restrictions.eq("username2", username)).uniqueResult();
            
            if(igraanagram!=null){
                ready=true;
            }
            
            transaction.commit();
            session.close();
        }     
        
    }
    
    public void odgovoriplavi(){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();

         Criteria q=session.createCriteria(IgraAnagrami.class);
         igraanagram=(IgraAnagrami)q.add(Restrictions.eq("username1", igraanagram.getUsername1())).uniqueResult();
         
         igraanagram.setOdgovorusername1(odgovor.toLowerCase(Locale.FRENCH));
         
         session.saveOrUpdate(igraanagram);
         
         transaction.commit();
         session.close();
         
         zakljucanodgovor=true;
    }
    
    public void odgovoricrveni(){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();

         Criteria q=session.createCriteria(IgraAnagrami.class);
         igraanagram=(IgraAnagrami)q.add(Restrictions.eq("username2", igraanagram.getUsername2())).uniqueResult();
         
         igraanagram.setOdgovorusername2(odgovor.toLowerCase(Locale.FRENCH));
         
         session.saveOrUpdate(igraanagram);
         
         transaction.commit();
         session.close();
         
         zakljucanodgovor=true;
    }
    
    public void odbrojavajPlavi(int br){
        if(timer>-1){
            timer--;
        }
        if(timer==-1){
            zakljucanodgovor=true;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraAnagrami.class);
        if(igraanagram!=null) igraanagram=(IgraAnagrami)q.add(Restrictions.eq("username1", igraanagram.getUsername1())).uniqueResult();

        if(igraanagram!=null) igraanagram.setZakljucan1(zakljucanodgovor);

        if(igraanagram!=null) session.saveOrUpdate(igraanagram);

        transaction.commit();
        session.close();
        
        if(igraanagram!=null){
            if(igraanagram.isZakljucan1() && igraanagram.isZakljucan2()){
                proveriodgovore(br);
            }
        }
    }
    
    public void odbrojavajCrveni(int br){
        if(timer>0){
            timer--;
        }
        if(timer==0){
            zakljucanodgovor=true;
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraAnagrami.class);
        if(igraanagram!=null) igraanagram=(IgraAnagrami)q.add(Restrictions.eq("idigraanagrami", igraanagram.getIdigraanagrami())).uniqueResult();
        
        if(igraanagram==null){
            try {
                if(br==1){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("anagramcrveni2.xhtml");   
                    transaction.commit();
                    session.close();
                }
                else{
                    System.out.printf("OOVDE SAM");
                    FacesContext.getCurrentInstance().getExternalContext().redirect("mojbrojcrveni.xhtml"); 
                    transaction.commit();
                    session.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Anagram.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            igraanagram.setZakljucan2(zakljucanodgovor);

            session.saveOrUpdate(igraanagram);

            transaction.commit();
            session.close();     
        }
       
    }
    
    public void proveriodgovore(int br){
        String odgovorplavi="";
        String odgovorcrveni="";
        if(igraanagram.getOdgovorusername1()!=null){
            odgovorplavi=igraanagram.getOdgovorusername1();
        }
        if(igraanagram.getOdgovorusername2()!=null){
            odgovorcrveni=igraanagram.getOdgovorusername2();
        }
        
        String tacanodgovor=igraanagram.getResenje();

        int poeniplavi=0;
        int poenicrveni=0;

        if(odgovorplavi.equals(tacanodgovor) && !odgovorcrveni.equals(tacanodgovor)){
            poeniplavi=10;
        }
        else if(!odgovorplavi.equals(tacanodgovor) && odgovorcrveni.equals(tacanodgovor)){
            poenicrveni=10;
        }
        else if(odgovorplavi.equals(tacanodgovor) && odgovorcrveni.equals(tacanodgovor)){
            poeniplavi=5;
            poenicrveni=5;
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgranaPartija.class);
        IgranaPartija igranapartija=(IgranaPartija)q.add(Restrictions.eq("username1", igraanagram.getUsername1())).uniqueResult();

        int prethodnipoeniplavi=igranapartija.getPoeni1();
        int prethodnipoenicrveni=igranapartija.getPoeni2();
        
        int prethpoeni1=igranapartija.getAnagram1();
        int prethpoeni2=igranapartija.getAnagram2();
        
        prethpoeni1+=poeniplavi;
        prethpoeni2+=poenicrveni;

        poeniplavi+=prethodnipoeniplavi;
        poenicrveni+=prethodnipoenicrveni;

        igranapartija.setPoeni1(poeniplavi);
        igranapartija.setPoeni2(poenicrveni);
        
        
        igranapartija.setAnagram1(prethpoeni1);
        igranapartija.setAnagram2(prethpoeni2);

        session.saveOrUpdate(igranapartija);
        
        String hqlUpdate="delete IgraAnagrami where username1=:username1";
        session.createQuery(hqlUpdate).setString("username1", igraanagram.getUsername1()).executeUpdate();

        transaction.commit();
        session.close();
        
        System.out.println("STIGAO JE ANAGRAM DO OVDE");
        
        try {
            if(br==1){
             FacesContext.getCurrentInstance().getExternalContext().redirect("anagramplavi2.xhtml");   
            }
            else{
               FacesContext.getCurrentInstance().getExternalContext().redirect("mojbrojplavi.xhtml"); 
            }
        } catch (IOException ex) {
            Logger.getLogger(Anagram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
