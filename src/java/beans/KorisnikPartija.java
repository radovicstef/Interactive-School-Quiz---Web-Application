/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.BazaPartija;
import entityBeans.IgranaPartija;
import entityBeans.Korisnik;
import entityBeans.Partija;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */
@ManagedBean(name = "korisnikpartija")
@SessionScoped
public class KorisnikPartija implements Serializable{
    private List<Partija> partije=null;
    private List<Partija> partijaispis=null;
    
    private IgranaPartija igranapart=new IgranaPartija();
    
    private boolean pridruzen;
    
    private Partija partija=new Partija();
    
    private boolean render=false;
    
    private UIComponent component;
    
    private IgranaPartija igranaPartija=new IgranaPartija();
    
    private boolean pobednik;

    public IgranaPartija getIgranaPartija() {
        return igranaPartija;
    }

    public void setIgranaPartija(IgranaPartija igranaPartija) {
        this.igranaPartija = igranaPartija;
    }

    public boolean isPobednik() {
        return pobednik;
    }

    public void setPobednik(boolean pobednik) {
        this.pobednik = pobednik;
    }

    public IgranaPartija getIgranapart() {
        return igranapart;
    }

    public void setIgranapart(IgranaPartija igranapart) {
        this.igranapart = igranapart;
    }

    public boolean isPridruzen() {
        return pridruzen;
    }

    public void setPridruzen(boolean pridruzen) {
        this.pridruzen = pridruzen;
    }

    public List<Partija> getPartije() {
        return partije;
    }

    public void setPartije(List<Partija> partije) {
        this.partije = partije;
    }

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
    
    public Partija getPartija() {
        return partija;
    }

    public void setPartija(Partija partija) {
        this.partija = partija;
    }
    
     private boolean vecPostoji(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria q=session.createCriteria(Partija.class);
        Partija part=(Partija)q.add(Restrictions.eq("username1", username)).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        
        if(part!=null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String kreirajpartiju(String username){
        try {
            pridruzen=false;
            if(vecPostoji(username)){
                FacesContext context=FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Partija je vec kreirana!",""));
                return null;
            }
            
            partija.setUsername1(username);
            partija.setUsername2("");
            
            //prazneNull();
            
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.persist(partija);
            
            session.getTransaction().commit();
            session.close();
            
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Partija je uspesno kreirana, sacekajte crvenog igraca...",""));
            
            FacesContext.getCurrentInstance().getExternalContext().redirect("cekanjenacrvenog.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(KorisnikPartija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "cekanjenacrvenog";
    }
    
    /*private void prazneNull(){
        if(partija.getUsername2()!=null && partija.getUsername2().equals("")){
            partija.setUsername2(null);
        }
    }*/
    
    public void postaviPartije(){
        dohvatiPartije();
    }
    
    public void dohvatiPartije(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria q=session.createCriteria(Partija.class).add(Restrictions.eq("username2", ""));
        partije=q.list();
        
        session.getTransaction().commit();
        session.close();
    }
    
    public void postaviRender(){
        if(render==false){
            render=true;
        }
        else{
            render=false;
        }
    }
    
    public void izaberi(String username1, String username2){
        if(username1.equals(username2)){
            return;
        }
        Iterator<Partija> it=partije.iterator();
        while(it.hasNext()){
                Partija par=it.next();
                if(par.getUsername1().equals(username1)){
                    par.setUsername2(username2);

                    Session session=HibernateUtil.getSessionFactory().openSession();
                    Transaction transaction=session.beginTransaction();

                    session.saveOrUpdate(par);

                    transaction.commit();
                    session.close();
                    
                    igranapart.setUsername1(par.getUsername1());
                    igranapart.setUsername2(par.getUsername2());

                    FacesContext context=FacesContext.getCurrentInstance();
                    context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Uspesno ste izabrali partiju!",""));

                    it.remove();

                    break;
                }
        }
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("anagramcrveni.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(KorisnikPartija.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void obrisiZahtev(String username){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        String hqlUpdate="delete Partija where username1=:username1";
        int brojIzmena=session.createQuery(hqlUpdate).setString("username1", username).executeUpdate();
        
        System.out.println(brojIzmena);
        
        transaction.commit();
        session.close();
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(KorisnikPartija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cekaj(String username){
        System.out.println(username);
        boolean twoplayers=false;
        while(!twoplayers){
         Session session=HibernateUtil.getSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();
         
         String username2="";
         
         Criteria q=session.createCriteria(Partija.class);
         Partija part=(Partija)q.add(Restrictions.eq("username1", username)).add(Restrictions.ne("username2", username2)).uniqueResult();
         
         
         if(part!=null){
           if(igranapart==null) igranapart=new IgranaPartija();
            igranapart.setUsername1(username);
            igranapart.setUsername2(part.getUsername2());
            
            System.out.println(igranapart.getUsername1());
            System.out.println(igranapart.getUsername2());
         
             session.persist(igranapart);
             
             String hqlUpdate="delete Partija where username1=:username1";
             session.createQuery(hqlUpdate).setString("username1", username).executeUpdate();
             twoplayers=true;
         }
         transaction.commit();
         session.close();
        }
        
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("anagramplavi.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(KorisnikPartija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String uzmipoene1(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgranaPartija.class);
        Criterion q1= Restrictions.eq("username1", username);
        Criterion q2= Restrictions.eq("username2", username);
        igranapart=(IgranaPartija)q.add(Restrictions.or(q1, q2)).uniqueResult();

        transaction.commit();
        session.close();
    
        if(igranapart!=null) {
            return Integer.toString(igranapart.getPoeni1()); 
        }
        else return "0";
    }
    
    public String uzmipoene2(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgranaPartija.class);
        Criterion q1= Restrictions.eq("username1", username);
        Criterion q2= Restrictions.eq("username2", username);
        igranapart=(IgranaPartija)q.add(Restrictions.or(q1, q2)).uniqueResult();
        
        transaction.commit();
        session.close();
    
        if(igranapart!=null) {
            return Integer.toString(igranapart.getPoeni2()); 
        }
        else return "0";
    }
    
    public void pogledajPoenePlavi(){
        igranaPartija=new IgranaPartija();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgranaPartija.class);
        igranaPartija=(IgranaPartija)q.add(Restrictions.eq("idigranapartija", igranapart.getIdigranapartija())).uniqueResult();
        
        BazaPartija bazapart=new BazaPartija();
        
        if(igranaPartija!=null){
            bazapart.setBrpoena1(igranaPartija.getPoeni1());
            bazapart.setBrpoena2(igranaPartija.getPoeni2());
            bazapart.setUsername1(igranaPartija.getUsername1());
            bazapart.setUsername2(igranaPartija.getUsername2());
            java.util.Date utilDate=new java.util.Date();
            bazapart.setDatum(new java.sql.Date(utilDate.getTime()));
            if(igranaPartija.getPoeni1()>igranaPartija.getPoeni2()){
                bazapart.setRezultat("pobedio plavi");
                pobednik=true;
            }
            else if(igranaPartija.getPoeni1()<igranaPartija.getPoeni2()){
                bazapart.setRezultat("pobedio crveni");
                pobednik=false;
            }
            else{
                bazapart.setRezultat("nereseno");
                pobednik=false;
            }
        }
            
        igranaPartija.setPogledano(1);
        
        session.persist(bazapart);
        session.persist(igranaPartija);

        transaction.commit();
        session.close();
    }
    
    public void pogledajPoeneCrveni(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgranaPartija.class);
        
        boolean ready=false;
        
        while(!ready){
            IgranaPartija igranaPartijaPom=(IgranaPartija)q.add(Restrictions.eq("idigranapartija", igranapart.getIdigranapartija())).uniqueResult();
            if(igranaPartijaPom.getPogledano()!=1){
                igranaPartija=igranaPartijaPom;
            }
            else{
                ready=true;
                String hqlUpdate="delete IgranaPartija where username1=:username1";
                session.createQuery(hqlUpdate).setString("username1", igranapart.getUsername1()).executeUpdate();
            }
        }
        
        if(igranaPartija!=null){
            if(igranaPartija.getPoeni1()>igranaPartija.getPoeni2()){
                pobednik=false;
            }
            else if(igranaPartija.getPoeni1()<igranaPartija.getPoeni2()){
                pobednik=true;
            }
            else{
                pobednik=false;
            }
        }
        
        transaction.commit();
        session.close();
    }
}
