/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.BazaPartija;
import entityBeans.IgraDanaPartija;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */

@ManagedBean(name="listarezultati")
@SessionScoped
public class ListaRezultati implements Serializable{
 
    private List<IgraDanaPartija> igradanapartija;
    
    private List<Rang> topdeset;
    
    private List<BazaPartija> multiplayer;
    
    private List<Rang> topgost;
    
    private boolean ulisti;
    
    private String mojusername;
    
    private String brpoena;
    
    private int rbroj;

    public List<Rang> getTopgost() {
        return topgost;
    }

    public void setTopgost(List<Rang> topgost) {
        this.topgost = topgost;
    }
    
    public List<BazaPartija> getMultiplayer() {
        return multiplayer;
    }

    public void setMultiplayer(List<BazaPartija> multiplayer) {
        this.multiplayer = multiplayer;
    }

    public List<Rang> getTopdeset() {
        return topdeset;
    }

    public void setTopdeset(List<Rang> topdeset) {
        this.topdeset = topdeset;
    }

    public int getRbroj() {
        return rbroj;
    }

    public void setRbroj(int rbroj) {
        this.rbroj = rbroj;
    }

    public List<IgraDanaPartija> getIgradanapartija() {
        return igradanapartija;
    }

    public void setIgradanapartija(List<IgraDanaPartija> igradanapartija) {
        this.igradanapartija = igradanapartija;
    }

    public boolean isUlisti() {
        return ulisti;
    }

    public void setUlisti(boolean ulisti) {
        this.ulisti = ulisti;
    }

    public String getMojusername() {
        return mojusername;
    }

    public void setMojusername(String mojusername) {
        this.mojusername = mojusername;
    }

    public String getBrpoena() {
        return brpoena;
    }

    public void setBrpoena(String brpoena) {
        this.brpoena = brpoena;
    }
    
    
    
    public void postaviIgraDana(String username){
        
        igradanapartija=new ArrayList<>();
        
        topdeset=new ArrayList<>();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        LocalDateTime ldt=LocalDateTime.now();
        String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        
        String hqlUpdate="from IgraDanaPartija where datum=:datumstring order by brpoena desc";
        igradanapartija=session.createQuery(hqlUpdate).setParameter("datumstring", datumstring).list();
        
        ulisti=false;
        
        mojusername="";
        brpoena="";
        
        
        if(igradanapartija!=null){
            if(igradanapartija.isEmpty()){
                return;
            }
            Iterator<IgraDanaPartija> it=igradanapartija.iterator();
            int rbrojpom=1;
            while(it.hasNext()){
                IgraDanaPartija igrapom=it.next();
                if(rbrojpom<=10) topdeset.add(new Rang(rbrojpom, igrapom.getUsername(), igrapom.getBrpoena()));
                if(igrapom.getUsername().equals(username) && rbrojpom<=10){
                    ulisti=true;
                    rbroj=rbrojpom;
                }
                else if(igrapom.getUsername().equals(username)){
                    topdeset.add(new Rang(rbrojpom, igrapom.getUsername(), igrapom.getBrpoena()));
                }
                rbrojpom++;
            }
            if(!ulisti){
                mojusername=username;
                
                Criteria q=session.createCriteria(IgraDanaPartija.class);
                IgraDanaPartija idp=(IgraDanaPartija)q.add(Restrictions.eq("username", username)).add(Restrictions.eq("datum", datumstring)).uniqueResult();
                
                if(idp==null){
                    brpoena="Niste igrali igru dana!";
                }
            }
        }
        
        transaction.commit();
        session.close();
    }
    
    
    public void postaviIgraMultiplayer(String username){
        
        multiplayer=new ArrayList<>();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        LocalDateTime ldt=LocalDateTime.now();
        String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        
        String hqlUpdate="from BazaPartija where username1=:username or username2=:username";
        multiplayer=session.createQuery(hqlUpdate).setParameter("username", username).list();
        
       
        transaction.commit();
        session.close();
    }
    
    public void postaviListaGost(){
        igradanapartija=new ArrayList<>();
        
        topdeset=new ArrayList<>();
        
        topgost=new ArrayList<>();
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        LocalDateTime ldt=LocalDateTime.now();
        String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        
        String uporedjivanje=datumstring.substring(0, 7);
        
        String hqlUpdate="select idp.username, sum(idp.brpoena) as suma  from IgraDanaPartija as idp where substring(idp.datum, 1, 7) like :uporedjivanje group by idp.username order by suma desc";
        List<?> mesecnirang=(List<?>)session.createQuery(hqlUpdate).setParameter("uporedjivanje", uporedjivanje).list();
        
        if(mesecnirang!=null){
            System.out.printf("RAZLICITO");
            System.out.printf(Integer.toString(mesecnirang.size()));
            int rb=1;
            for(int i=0; i<mesecnirang.size(); i++) {
                Object[] row = (Object[]) mesecnirang.get(i);
                Integer brp=(int) (long) row[1];
                topgost.add(new Rang(rb, row[0].toString(), brp));
                rb++;
            }
        }
        
        transaction.commit();
        session.close();
    }
}
