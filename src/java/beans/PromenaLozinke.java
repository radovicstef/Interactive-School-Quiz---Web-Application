/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.Korisnik;
import java.io.IOException;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javassist.bytecode.Bytecode;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import util.PasswordService;

/**
 *
 * @author Legion
 */

@ManagedBean(name="promenaLozinke")
@SessionScoped
public class PromenaLozinke {
    private String username;
    private String oldPass;
    private String newPass;
    private BigInteger jmbgInt;
    private String jmbg;
    private String unetOdgovor;
    
    private Korisnik askedKorisnik=new Korisnik();

    public String getUnetOdgovor() {
        return unetOdgovor;
    }

    public void setUnetOdgovor(String unetOdgovor) {
        this.unetOdgovor = unetOdgovor;
    }

    public Korisnik getAskedKorisnik() {
        return askedKorisnik;
    }

    public void setAskedKorisnik(Korisnik askedKorisnik) {
        this.askedKorisnik = askedKorisnik;
    }

    public BigInteger getJmbgInt() {
        return jmbgInt;
    }

    public void setJmbgInt(BigInteger jmbgInt) {
        this.jmbgInt = jmbgInt;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }
    
    private UIComponent component;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPass() {
        return oldPass;
    }

    public void setOldPass(String oldPass) {
        this.oldPass = oldPass;
    }

    public String getNewPass() {
        return newPass;
    }

    public void setNewPass(String newPass) {
        this.newPass = newPass;
    }

    public UIComponent getComponent() {
        return component;
    }

    public void setComponent(UIComponent component) {
        this.component = component;
    }
    
    public String izmeniLozinku(){
        try {
            Session session=HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();
            
            PasswordService ps=new PasswordService();
            String hashPassOld;
            hashPassOld=ps.encrypt(oldPass);
            String hashPassNew;
            hashPassNew=ps.encrypt(newPass);
            
            String hqlUpdate="update Korisnik set password=:noviPassword where username=:korisnickoIme and password=:stariPassword";
            int brojIzmena=session.createQuery(hqlUpdate).setString("noviPassword", hashPassNew).setString("korisnickoIme", username).setString("stariPassword", hashPassOld).executeUpdate();
            
            transaction.commit();
            session.close();
            
            if(brojIzmena>0){
                FacesContext context=FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Lozinka je uspesno izmenjena!",""));
                return "index";
            }
            else{
                FacesContext context=FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lozinka nije uspesno promenjena!",""));
                context.validationFailed();
                return null;
            }
        } catch (Exception ex) {
            Logger.getLogger(PromenaLozinke.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public String izmeniLozinkuBezStare(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        PasswordService ps=new PasswordService();
        String hashPassNew="";
        try {
            hashPassNew=ps.encrypt(newPass);
        } catch (Exception ex) {
            Logger.getLogger(PromenaLozinke.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String hqlUpdate="update Korisnik set password=:noviPassword where username=:korisnickoIme";
        int brojIzmena=session.createQuery(hqlUpdate).setString("noviPassword", hashPassNew).setString("korisnickoIme", username).executeUpdate();
        
        transaction.commit();
        session.close();
        
        if(brojIzmena>0){
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Lozinka je uspesno izmenjena!",""));
            return "index";
        }
        else{
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Lozinka nije uspesno promenjena!",""));
            context.validationFailed();
            return null;
        }
    }
    
    public String potvrdaPodataka(){
        jmbgInt=new BigInteger(jmbg);
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria query=session.createCriteria(Korisnik.class);
        Korisnik user=(Korisnik)query.add(Restrictions.eq("username", username)).add(Restrictions.eq("jmbg", jmbgInt)).uniqueResult();
        
        
        if(user!=null){
            if(user.getTajanstveno_pitanje()==null || user.getOdgovor()==null){
                transaction.commit();
                session.close();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vaš nalog nema sigurnosno pitanje i odgovor!",""));
                return null;
            }
            askedKorisnik.setOdgovor(user.getOdgovor());
            askedKorisnik.setTajanstveno_pitanje(user.getTajanstveno_pitanje());
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("tajnopitanje.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(PromenaLozinke.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        else{
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pogresno uneti podaci!",""));
            return null;
        }
    }
    
    public String proveriOdg() throws IOException{
        if(getAskedKorisnik().getOdgovor().equals(this.getUnetOdgovor())){
            return "promenalozinke2";
        }
        else{
            FacesContext context=FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Pogresan odgovor!",""));
            return "index";
        }
    }
}
