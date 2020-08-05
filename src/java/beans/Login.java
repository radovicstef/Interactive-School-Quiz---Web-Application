/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.BazaIgraDana;
import entityBeans.IgraDanaPartija;
import entityBeans.Korisnik;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import util.PasswordService;



/**
 *
 * @author Legion
 */

@ManagedBean(name = "login")
@SessionScoped
@Entity
public class Login implements Serializable{
    
    @Id
    private String username;
    private String password;
    
    private Korisnik korisnik=new Korisnik();

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void checkUser(){
        try{
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            
            Criteria query=session.createCriteria(Korisnik.class);
            
            PasswordService ps=new PasswordService();
            String hashPass;
            hashPass=ps.encrypt(password);
            
            Korisnik user=(Korisnik)query.add(Restrictions.eq("username", username)).add(Restrictions.eq("password", hashPass)).uniqueResult();
            
            korisnik=user;
            
            if(user!=null){
                if(user.getOdobren()==0){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                }
                if(user.getUsername().equals("admin")){
                    HttpSession hs = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                    hs.setAttribute("user", user);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("adminstranica.xhtml");
                }
                else if(user.getUsername().equals("supervizor")){
                    HttpSession hs = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                    hs.setAttribute("user", user);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("supervizorstranica.xhtml");
                }
                else {
                    HttpSession hs = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
                    hs.setAttribute("user", user);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
                }
            }
            else{
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
                FacesContext context=FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Korisnik nije pronadjen u bazi",""));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void login(){
    }   
    
    public void logout(){
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession s = (HttpSession) fc.getExternalContext().getSession(false);
            s.invalidate();
            fc.getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void proveraIgraDana(String username){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria qb=session.createCriteria(BazaIgraDana.class);
        
        LocalDateTime ldt=LocalDateTime.now();
        String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        
        BazaIgraDana igradana=(BazaIgraDana)qb.add(Restrictions.eq("datum", datumstring)).uniqueResult();
        
        Criteria qigradana=session.createCriteria(IgraDanaPartija.class);
        
        IgraDanaPartija igradanapart=(IgraDanaPartija)qigradana.add(Restrictions.eq("username", username)).add(Restrictions.eq("datum", datumstring)).uniqueResult();
        
        if(igradanapart!=null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("vecodigranaigradana.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            if(igradana==null){
                try {
                    FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                if(igradana.getTipigre().equals("anagram")){
                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("anagramsingle.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(igradana.getTipigre().equals("mojbroj")){
                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("mojbrojsingle.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(igradana.getTipigre().equals("vesanje")){
                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("vesanjesingle.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(igradana.getTipigre().equals("zgeos")){
                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("zanimljivageografijasingle.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else if(igradana.getTipigre().equals("pehar")){
                    try {
                        FacesContext.getCurrentInstance().getExternalContext().redirect("peharsingle.xhtml");
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            transaction.commit();
            session.close();
        }
    }
}
