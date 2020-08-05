/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.istack.logging.Logger;
import entityBeans.Korisnik;
import java.math.BigInteger;
import java.util.logging.Level;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import util.PasswordService;

/**
 *
 * @author Legion
 */

@ManagedBean(name = "registracija")
@ViewScoped
public class Registracija {
    Korisnik noviKorisnik=new Korisnik();
    private UIComponent component;
    
    private String jmbg;

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public Korisnik getNoviKorisnik() {
        return noviKorisnik;
    }

    public void setNoviKorisnik(Korisnik noviKorisnik) {
        this.noviKorisnik = noviKorisnik;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
    
    private boolean vecPostoji(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria q=session.createCriteria(Korisnik.class);
        Korisnik user=(Korisnik)q.add(Restrictions.eq("username", noviKorisnik.getUsername())).uniqueResult();
        
        session.getTransaction().commit();
        session.close();
        
        if(user!=null){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void registracija(UploadKorisnik upload){
        try {
            if(vecPostoji()){
                FacesContext context=FacesContext.getCurrentInstance();
                context.addMessage(component.getClientId(), new FacesMessage(FacesMessage.SEVERITY_ERROR,"Username je vec zauzet!",""));
                ((UIInput) component).setValid(false);
                return;
            }
            
            BigInteger jmbgint=new BigInteger(jmbg);
            
            noviKorisnik.setJmbg(jmbgint);
            
            noviKorisnik.setOdobren(0);
            
            PasswordService ps=new PasswordService();
            String hashPass;
            
            hashPass=ps.encrypt(noviKorisnik.getPassword());
            
            noviKorisnik.setPassword(hashPass);
            
            noviKorisnik.setSlika(upload.getFajl());
            
            prazneNull();
            
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            session.persist(noviKorisnik);
            
            session.getTransaction().commit();
            session.close();
            
            noviKorisnik=new Korisnik();
            
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vas zahtev za registraciju je uspesno poslat",""));
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Registracija.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }
    
    private void prazneNull(){
        if(noviKorisnik.getTajanstveno_pitanje()!=null && noviKorisnik.getTajanstveno_pitanje().equals("")){
            noviKorisnik.setTajanstveno_pitanje(null);
        }
        if(noviKorisnik.getOdgovor()!=null && noviKorisnik.getOdgovor().equals("")){
            noviKorisnik.setOdgovor(null);
        }
    }
}
