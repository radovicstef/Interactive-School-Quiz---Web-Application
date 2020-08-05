/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.Korisnik;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Criteria;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */

@ManagedBean(name = "korisnici")
@ViewScoped
public class Korisnici {
    private List<Korisnik> korisnici=null;
    private List<Korisnik> neodobreniKorisnici=null;
    private List<Korisnik> odobreniKorisnici=null;

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(List<Korisnik> korisnici) {
        this.korisnici = korisnici;
    }

    public List<Korisnik> getNeodobreniKorisnici() {
        return neodobreniKorisnici;
    }

    public void setNeodobreniKorisnici(List<Korisnik> neodobreniKorisnici) {
        this.neodobreniKorisnici = neodobreniKorisnici;
    }

    public List<Korisnik> getOdobreniKorisnici() {
        return odobreniKorisnici;
    }

    public void setOdobreniKorisnici(List<Korisnik> odobreniKorisnici) {
        this.odobreniKorisnici = odobreniKorisnici;
    }
    
    public void dohvatiKorisnike(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Criteria q=session.createCriteria(Korisnik.class);
        korisnici=q.list();
        
        session.getTransaction().commit();
        session.close();
    }
    
    public void postaviNeodobreneKorisnike(){
        if(korisnici==null){
            dohvatiKorisnike();
        }
        
        neodobreniKorisnici=new ArrayList<>();
        
        for(Korisnik kor: korisnici){
            if(kor.getOdobren()==0){
                neodobreniKorisnici.add(kor);
            }
        }
    }
    
    public void postaviOdobreneKorisnike(){
        if(korisnici==null){
            dohvatiKorisnike();
        }
        
        odobreniKorisnici=new ArrayList<>();
        
        for(Korisnik kor: korisnici){
            if(kor.getOdobren()==1){
                odobreniKorisnici.add(kor);
            }
        }
    }
    
    public void odobri(String username){
        Iterator<Korisnik> it=neodobreniKorisnici.iterator();
        while(it.hasNext()){
            Korisnik kor=it.next();
            if(kor.getUsername().equals(username)){
                kor.setOdobren(1);
                
                Session session=HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                
                session.update(kor);
                
                session.getTransaction().commit();
                session.close();
                
                FacesContext context=FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registracija korisnika sa korisnickim imenom - "+kor.getUsername()+" je odobrena!",""));
                
                it.remove();
                
                break;
            }
        }
    }
}
