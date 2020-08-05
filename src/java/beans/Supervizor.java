/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.Anagrami;
import entityBeans.BazaPitanja;
import entityBeans.BazaReci;
import entityBeans.IgraZgeos;
import entityBeans.RevizijaReci;
import entityBeans.Vesanja;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */

@ManagedBean(name = "supervizor")
@SessionScoped
public class Supervizor implements Serializable{
    
    private String tekstangrama;
    private String resenjeanagrama;
    
    private String rec;
    
    private List<RevizijaReci> revizije;
    
    private BazaPitanja pitanje;
    
    private String[] pitanja=new String[14];
    private String[] odgovori=new String[14];

    public BazaPitanja getPitanje() {
        return pitanje;
    }

    public void setPitanje(BazaPitanja pitanje) {
        this.pitanje = pitanje;
    }

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

    public List<RevizijaReci> getRevizije() {
        return revizije;
    }

    public void setRevizije(List<RevizijaReci> revizije) {
        this.revizije = revizije;
    }

    public String getRec() {
        return rec;
    }

    public void setRec(String rec) {
        this.rec = rec;
    }

    public String getTekstangrama() {
        return tekstangrama;
    }

    public void setTekstangrama(String tekstangrama) {
        this.tekstangrama = tekstangrama;
    }

    public String getResenjeanagrama() {
        return resenjeanagrama;
    }

    public void setResenjeanagrama(String resenjeanagrama) {
        this.resenjeanagrama = resenjeanagrama;
    }
    
    public void unesiAnagram(){
        if(tekstangrama==null || resenjeanagrama==null || tekstangrama.equals("") || resenjeanagrama.equals("")) return;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(Anagrami.class);
        Anagrami novianagram=new Anagrami();
        
        tekstangrama=tekstangrama.toUpperCase(Locale.FRENCH);
        resenjeanagrama=resenjeanagrama.toLowerCase(Locale.FRENCH);
    
        novianagram.setTekst(tekstangrama);
        novianagram.setResenje(resenjeanagrama);
        
        session.persist(novianagram);
        
        transaction.commit();
        session.close();
        
        tekstangrama="";
        resenjeanagrama="";
    }
    
    public void unesiRec(){
        if(rec==null || rec.equals("")) return;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(Vesanja.class);
        Vesanja novovesanje=new Vesanja();
        
        rec=rec.toLowerCase(Locale.FRENCH);
    
        novovesanje.setRec(rec);
        
        session.persist(novovesanje);
        
        transaction.commit();
        session.close();
        
        rec="";
    }
    
    public void odobri(int idrevizije){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria qrevizije=session.createCriteria(RevizijaReci.class);
        Criteria qzgeos=session.createCriteria(IgraZgeos.class);
        
        RevizijaReci odobrenarevizija=(RevizijaReci)qrevizije.add(Restrictions.eq("idrevizijareci", idrevizije)).uniqueResult();
        
        IgraZgeos igraupdate=null;
        
        if(odobrenarevizija!=null){
            igraupdate=(IgraZgeos)qzgeos.add(Restrictions.eq("idigrazgeos", odobrenarevizija.getIdzgeosigre())).uniqueResult();
        
            if(igraupdate!=null){
                int brpoenapreth1=igraupdate.getBrpoena1();
                int brpoenapreth2=igraupdate.getBrpoena2();

                if(odobrenarevizija.getKomedodajem().equals("brpoena1")){
                    brpoenapreth1+=odobrenarevizija.getBrpoenadodato();
                    System.out.printf("BR POENA PRETH 1");
                    igraupdate.setBrpoena1(brpoenapreth1);
                }
                else{
                    System.out.printf("BR POENA PRETH 2");
                    brpoenapreth2+=odobrenarevizija.getBrpoenadodato();
                    igraupdate.setBrpoena2(brpoenapreth2);
                }

                session.saveOrUpdate(igraupdate);

                BazaReci novarec=new BazaReci();
                novarec.setPocetnoslovo(odobrenarevizija.getSlovo());
                novarec.setRec(odobrenarevizija.getTekst());
                novarec.setTip(odobrenarevizija.getTip());
                session.persist(novarec);

                Query query = session.createQuery("delete RevizijaReci where idrevizijareci = :idreviz");
                query.setParameter("idreviz", odobrenarevizija.getIdrevizijareci());
                query.executeUpdate();
            }
            else{
                Query query = session.createQuery("delete RevizijaReci where idrevizijareci = :idreviz");
                query.setParameter("idreviz", odobrenarevizija.getIdrevizijareci());
                query.executeUpdate();
            }
        }
        
        Criteria qupdatereviz=session.createCriteria(RevizijaReci.class);
        revizije=qupdatereviz.list();
        
        transaction.commit();
        session.close();
        
    }
    
    public void odbaci(int idrevizije){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria qrevizije=session.createCriteria(RevizijaReci.class);
        Criteria qigrazgeos=session.createCriteria(IgraZgeos.class);
        
        RevizijaReci neodobrenarevizija=(RevizijaReci)qrevizije.add(Restrictions.eq("idrevizijareci", idrevizije)).uniqueResult();
        
        IgraZgeos igrazgeos=null;
        
        if(neodobrenarevizija!=null) igrazgeos=(IgraZgeos)qigrazgeos.add(Restrictions.eq("idigrazgeos", neodobrenarevizija.getIdzgeosigre())).uniqueResult();
        
        if(igrazgeos!=null){
            String tip=neodobrenarevizija.getTip();

            if(tip.equals("drzava")){
                igrazgeos.setDrzava(null);
            }
            else if(tip.equals("grad")){
                igrazgeos.setGrad(null);
            }
            else if(tip.equals("reka")){
                igrazgeos.setReka(null);
            }
            else if(tip.equals("jezero")){
                igrazgeos.setJezero(null);
            }
            else if(tip.equals("planina")){
                igrazgeos.setPlanina(null);
            }
            else if(tip.equals("zivotinja")){
                igrazgeos.setZivotinja(null);
            }
            else if(tip.equals("biljka")){
                igrazgeos.setBiljka(null);
            }
            else if(tip.equals("grupa")){
                igrazgeos.setGrupa(null);
            }
        }

        session.saveOrUpdate(igrazgeos);

        Query query = session.createQuery("delete RevizijaReci where idrevizijareci = :idreviz");
        query.setParameter("idreviz", neodobrenarevizija.getIdrevizijareci());
        query.executeUpdate();
    
        Criteria qupdatereviz=session.createCriteria(RevizijaReci.class);
        revizije=qupdatereviz.list();
        
        transaction.commit();
        session.close();
    }
    
    public void postaviPehar(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        pitanje=new BazaPitanja();
        
        pitanje.setPitanjeprvo9(pitanja[0]);
        pitanje.setPitanjeprvo8(pitanja[1]);
        pitanje.setPitanjeprvo7(pitanja[2]);
        pitanje.setPitanjeprvo6(pitanja[3]);
        pitanje.setPitanjeprvo5(pitanja[4]);
        pitanje.setPitanjeprvo4(pitanja[5]);
        pitanje.setPitanjeprvo3(pitanja[6]);
        pitanje.setPitanjedrugo3(pitanja[7]);
        pitanje.setPitanjedrugo4(pitanja[8]);
        pitanje.setPitanjedrugo5(pitanja[9]);
        pitanje.setPitanjedrugo6(pitanja[10]);
        pitanje.setPitanjedrugo7(pitanja[11]);
        pitanje.setPitanjedrugo8(pitanja[12]);
        pitanje.setPitanjedrugo9(pitanja[13]);
        
        pitanje.setOdgovorprvi9(odgovori[0]);
        pitanje.setOdgovorprvi8(odgovori[1]);
        pitanje.setOdgovorprvi7(odgovori[2]);
        pitanje.setOdgovorprvi6(odgovori[3]);
        pitanje.setOdgovorprvi5(odgovori[4]);
        pitanje.setOdgovorprvi4(odgovori[5]);
        pitanje.setOdgovorprvi3(odgovori[6]);
        pitanje.setOdgovordrugi3(odgovori[7]);
        pitanje.setOdgovordrugi4(odgovori[8]);
        pitanje.setOdgovordrugi5(odgovori[9]);
        pitanje.setOdgovordrugi6(odgovori[10]);
        pitanje.setOdgovordrugi7(odgovori[11]);
        pitanje.setOdgovordrugi8(odgovori[12]);
        pitanje.setOdgovordrugi9(odgovori[13]);
        
        session.persist(pitanje);
        
        for(int i=0; i<odgovori.length; i++){
            odgovori[i]="";
        }
        for(int i=0; i<pitanja.length; i++){
            pitanja[i]="";
        }
        
        transaction.commit();
        session.close();
    }
    
    public void refresh(){
        tekstangrama="";
        resenjeanagrama="";
        
        rec="";
        
        revizije=new ArrayList<>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(RevizijaReci.class);
        revizije=q.list();
        
        transaction.commit();
        session.close();
    }
}
