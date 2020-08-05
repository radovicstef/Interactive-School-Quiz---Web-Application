/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.BazaReci;
import entityBeans.IgraDanaPartija;
import entityBeans.IgraZgeos;
import entityBeans.IgranaPartija;
import entityBeans.RevizijaReci;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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

@ManagedBean(name="zgeossingle")
@SessionScoped
public class ZanimljivaGeografijaSingle implements Serializable{
    
    private String color;
    
    private char slovo;
    
    private IgraZgeos igrazanimljivageografija;
    private IgranaPartija igranapartija;
    private BazaReci bazareci;
    
    private boolean neigram;
    
    private boolean timerstart;
    
    private int timer;
    
    private boolean zakljucanodgovor;
    
    private boolean odgovornaprotivnikovu;
    
    private String drzava;
    
    private String grad;
    
    private String reka;
    
    private String jezero;
    
    private String planina;
    
    private String zivotinja;
    
    private String biljka;
    
    private String grupa;
    
    private boolean disdrzava;
    
    private boolean disgrad;
    
    private boolean disreka;
    
    private boolean disjezero;
    
    private boolean displanina;
    
    private boolean diszivotinja;
    
    private boolean disbiljka;
    
    private boolean disgrupa;
    
    private boolean sacekajreviziju;

    public boolean isSacekajreviziju() {
        return sacekajreviziju;
    }

    public void setSacekajreviziju(boolean sacekajreviziju) {
        this.sacekajreviziju = sacekajreviziju;
    }

    public boolean isZakljucanodgovor() {
        return zakljucanodgovor;
    }

    public void setZakljucanodgovor(boolean zakljucanodgovor) {
        this.zakljucanodgovor = zakljucanodgovor;
    }

    public boolean isDisdrzava() {
        return disdrzava;
    }

    public void setDisdrzava(boolean disdrzava) {
        this.disdrzava = disdrzava;
    }

    public boolean isDisgrad() {
        return disgrad;
    }

    public void setDisgrad(boolean disgrad) {
        this.disgrad = disgrad;
    }

    public boolean isDisreka() {
        return disreka;
    }

    public void setDisreka(boolean disreka) {
        this.disreka = disreka;
    }

    public boolean isDisjezero() {
        return disjezero;
    }

    public void setDisjezero(boolean disjezero) {
        this.disjezero = disjezero;
    }

    public boolean isDisplanina() {
        return displanina;
    }

    public void setDisplanina(boolean displanina) {
        this.displanina = displanina;
    }

    public boolean isDiszivotinja() {
        return diszivotinja;
    }

    public void setDiszivotinja(boolean diszivotinja) {
        this.diszivotinja = diszivotinja;
    }

    public boolean isDisbiljka() {
        return disbiljka;
    }

    public void setDisbiljka(boolean disbiljka) {
        this.disbiljka = disbiljka;
    }

    public boolean isDisgrupa() {
        return disgrupa;
    }

    public void setDisgrupa(boolean disgrupa) {
        this.disgrupa = disgrupa;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getReka() {
        return reka;
    }

    public void setReka(String reka) {
        this.reka = reka;
    }

    public String getJezero() {
        return jezero;
    }

    public void setJezero(String jezero) {
        this.jezero = jezero;
    }

    public String getPlanina() {
        return planina;
    }

    public void setPlanina(String planina) {
        this.planina = planina;
    }

    public String getZivotinja() {
        return zivotinja;
    }

    public void setZivotinja(String zivotinja) {
        this.zivotinja = zivotinja;
    }

    public String getBiljka() {
        return biljka;
    }

    public void setBiljka(String biljka) {
        this.biljka = biljka;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public boolean isOdgovornaprotivnikovu() {
        return odgovornaprotivnikovu;
    }

    public void setOdgovornaprotivnikovu(boolean odgovornaprotivnikovu) {
        this.odgovornaprotivnikovu = odgovornaprotivnikovu;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
    

    public boolean isTimerstart() {
        return timerstart;
    }

    public void setTimerstart(boolean timerstart) {
        this.timerstart = timerstart;
    }

    public boolean isNeigram() {
        return neigram;
    }

    public void setNeigram(boolean igram) {
        this.neigram = neigram;
    }

    public char getSlovo() {
        return slovo;
    }

    public void setSlovo(char slovo) {
        this.slovo = slovo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    public void podesiIgruPlaviGlavniPlavi(String username){
        color="cornflowerblue";
        
        timer=120;
        
        zakljucanodgovor=false;
        
        odgovornaprotivnikovu=false;
        
        disdrzava=true; disgrad=true; disreka=true; disjezero=true; displanina=true; diszivotinja=true; disbiljka=true; disgrupa=true;
        
        drzava=null; grad=null; reka=null; jezero=null; planina=null;zivotinja=null; biljka=null; grupa=null;
        
        sacekajreviziju=false;
        
        Random r = new Random();
        
        String alphabet = "ertzuiopšđasdfghjklčćžcvbnm";
        //PRAVI RANDOM KARAKTER
        slovo=alphabet.charAt(r.nextInt(alphabet.length()));
                
        bazareci=new BazaReci();
        igranapartija=new IgranaPartija();
        igrazanimljivageografija=new IgraZgeos();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        
        if(igranapartija!=null){
            igrazanimljivageografija.setSlovo(slovo);
            igrazanimljivageografija.setUsername1(username);
            igrazanimljivageografija.setBrpoena1(0);
            igrazanimljivageografija.setBrpoena2(0);
            igrazanimljivageografija.setKoigra(1);
            igrazanimljivageografija.setIgrase(true);
            timerstart=true;
        }
        
        session.persist(igrazanimljivageografija);
        
        transaction.commit();
        session.close();
    }
    
    
    public void odbrojavajPlaviGlavniPlavi(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        if(!timerstart) return;
        if(timer>0){
            timer--;
        }
        if(timer==0){
            zakljucanodgovor=true;
        }


        Criteria q=session.createCriteria(IgraZgeos.class);
        if(igrazanimljivageografija!=null) igrazanimljivageografija=(IgraZgeos)q.add(Restrictions.eq("username1", igrazanimljivageografija.getUsername1())).uniqueResult();

        if(igrazanimljivageografija!=null){
            igrazanimljivageografija.setZakljucanodgovor2(zakljucanodgovor);
            session.saveOrUpdate(igrazanimljivageografija);
        }


        transaction.commit();
        session.close();

        if(zakljucanodgovor){
            proveriOdgovoreGlavni(1);
        }
    }
    
   
    
    public void odgovori(int br){
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraZgeos.class);
        if(igrazanimljivageografija!=null) igrazanimljivageografija=(IgraZgeos)q.add(Restrictions.eq("username1", igrazanimljivageografija.getUsername1())).uniqueResult();
                
        if(drzava!=null) igrazanimljivageografija.setDrzava(drzava);
        if(grad!=null) igrazanimljivageografija.setGrad(grad);
        if(reka!=null) igrazanimljivageografija.setReka(reka);
        if(jezero!=null) igrazanimljivageografija.setJezero(jezero);
        if(planina!=null) igrazanimljivageografija.setPlanina(planina);
        if(zivotinja!=null) igrazanimljivageografija.setZivotinja(zivotinja);
        if(biljka!=null) igrazanimljivageografija.setBiljka(biljka);
        if(grupa!=null) igrazanimljivageografija.setGrupa(grupa);
        
        if(br==1){ 
            igrazanimljivageografija.setZakljucanodgovor1(zakljucanodgovor);
        }
        else{
            igrazanimljivageografija.setZakljucanodgovor2(zakljucanodgovor);
        }
        
        session.saveOrUpdate(igrazanimljivageografija);
        
        zakljucanodgovor=true;
        sacekajreviziju=true;
        
        System.out.printf("REVIZIJA CRVENI");
        
        transaction.commit();
        session.close();
    }
    
   
    public void proveriOdgovoreGlavni(int br){
        
        RevizijaReci[] revizija=new RevizijaReci[8];
        for(int i=0;i<8;i++){
            revizija[i]=null;
        }

        int brpoena=0;
        
        boolean cekamsupervizora=false;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria q=session.createCriteria(IgraZgeos.class);
        if(igrazanimljivageografija!=null) igrazanimljivageografija=(IgraZgeos)q.add(Restrictions.eq("username1", igrazanimljivageografija.getUsername1())).uniqueResult();
        
        if(igrazanimljivageografija==null) return;
        if(igrazanimljivageografija.getDrzava()!=null){
            if(igrazanimljivageografija.getDrzava().equals("") || igrazanimljivageografija.getDrzava().toLowerCase(Locale.FRENCH).charAt(0)!=slovo){
                igrazanimljivageografija.setDrzava(null);
            }
            else{
                String odgdrzava=igrazanimljivageografija.getDrzava().toLowerCase(Locale.FRENCH);
                Criteria qbazadrzava=session.createCriteria(BazaReci.class);
                BazaReci bazadrzava=(BazaReci)qbazadrzava.add(Restrictions.eq("pocetnoslovo", igrazanimljivageografija.getSlovo())).add(Restrictions.eq("tip", "drzava")).add(Restrictions.eq("rec",odgdrzava)).uniqueResult();
                if(bazadrzava!=null){
                    System.out.printf("DRZAVA");
                    brpoena+=2;
                }
                else{
                    //DODAJ SUPERVIZORU
                    cekamsupervizora=true;
                    revizija[1]=new RevizijaReci();
                    revizija[1].setIdzgeosigre(igrazanimljivageografija.getIdigrazgeos());
                    revizija[1].setSlovo(slovo);
                    revizija[1].setTip("drzava");
                    revizija[1].setTekst(odgdrzava);
                    revizija[1].setBrpoenadodato(4);
                    if(br==2){
                        revizija[1].setKomedodajem("brpoena2");
                    }
                    else{
                        revizija[1].setKomedodajem("brpoena1");
                    }
                }
            }
        }
        if(igrazanimljivageografija.getGrad()!=null){
            System.out.printf(igrazanimljivageografija.getGrad());
            if(igrazanimljivageografija.getGrad().equals("") || igrazanimljivageografija.getGrad().toLowerCase(Locale.FRENCH).charAt(0)!=slovo){
            System.out.printf("2");
                igrazanimljivageografija.setGrad(null);
            }
            else{
                String odggrad=igrazanimljivageografija.getGrad().toLowerCase(Locale.FRENCH);
                Criteria qbazagrad=session.createCriteria(BazaReci.class);
                BazaReci baza=(BazaReci)qbazagrad.add(Restrictions.eq("pocetnoslovo", igrazanimljivageografija.getSlovo())).add(Restrictions.eq("tip", "grad")).add(Restrictions.eq("rec",odggrad)).uniqueResult();
                if(baza!=null){
                    System.out.printf("GRAD");
                    brpoena+=2;
                }
                else{
                    //DODAJ SUPERVIZORU
                    cekamsupervizora=true;
                    revizija[2]=new RevizijaReci();
                    revizija[2].setIdzgeosigre(igrazanimljivageografija.getIdigrazgeos());
                    revizija[2].setSlovo(slovo);
                    revizija[2].setTip("grad");
                    revizija[2].setTekst(odggrad);
                    revizija[2].setBrpoenadodato(4);
                    if(br==2){
                        revizija[2].setKomedodajem("brpoena2");
                    }
                    else{
                        revizija[2].setKomedodajem("brpoena1");
                    }
                }
            }
        }
        if(igrazanimljivageografija.getReka()!=null){
            if(igrazanimljivageografija.getReka().equals("") || igrazanimljivageografija.getReka().toLowerCase(Locale.FRENCH).charAt(0)!=slovo){
                igrazanimljivageografija.setReka(null);
            }
            else{
                String odgreka=igrazanimljivageografija.getReka().toLowerCase(Locale.FRENCH);
                Criteria qbazareka=session.createCriteria(BazaReci.class);
                BazaReci baza=(BazaReci)qbazareka.add(Restrictions.eq("pocetnoslovo", igrazanimljivageografija.getSlovo())).add(Restrictions.eq("tip", "reka")).add(Restrictions.eq("rec",odgreka)).uniqueResult();
                if(baza!=null){
                    brpoena+=2;
                }
                else{
                    //DODAJ SUPERVIZORU
                    cekamsupervizora=true;
                    revizija[3]=new RevizijaReci();
                    revizija[3].setIdzgeosigre(igrazanimljivageografija.getIdigrazgeos());
                    revizija[3].setSlovo(slovo);
                    revizija[3].setTip("reka");
                    revizija[3].setTekst(odgreka);
                    revizija[3].setBrpoenadodato(4);
                    if(br==2){
                        revizija[3].setKomedodajem("brpoena2");
                    }
                    else{
                        revizija[3].setKomedodajem("brpoena1");
                    }
                }
            }
        }
        if(igrazanimljivageografija.getJezero()!=null){
            if(igrazanimljivageografija.getJezero().equals("") || igrazanimljivageografija.getJezero().toLowerCase(Locale.FRENCH).charAt(0)!=slovo){
                igrazanimljivageografija.setJezero(null);
            }
            else{
                String odgjezero=igrazanimljivageografija.getJezero().toLowerCase(Locale.FRENCH);
                Criteria qbazajezero=session.createCriteria(BazaReci.class);
                BazaReci baza=(BazaReci)qbazajezero.add(Restrictions.eq("pocetnoslovo", igrazanimljivageografija.getSlovo())).add(Restrictions.eq("tip", "jezero")).add(Restrictions.eq("rec",odgjezero)).uniqueResult();
                if(baza!=null){
                    brpoena+=2;
                }
                else{
                    //DODAJ SUPERVIZORU
                    cekamsupervizora=true;
                    revizija[4]=new RevizijaReci();
                    revizija[4].setIdzgeosigre(igrazanimljivageografija.getIdigrazgeos());
                    revizija[4].setSlovo(slovo);
                    revizija[4].setTip("jezero");
                    revizija[4].setTekst(odgjezero);
                    revizija[4].setBrpoenadodato(4);
                    if(br==2){
                        revizija[4].setKomedodajem("brpoena2");
                    }
                    else{
                        revizija[4].setKomedodajem("brpoena1");
                    }
                }
            }
        }
        if(igrazanimljivageografija.getPlanina()!=null){
            if(igrazanimljivageografija.getPlanina().equals("") || igrazanimljivageografija.getPlanina().toLowerCase(Locale.FRENCH).charAt(0)!=slovo){
                igrazanimljivageografija.setPlanina(null);
            }
            else{
                String odgplanina=igrazanimljivageografija.getPlanina().toLowerCase(Locale.FRENCH);
                Criteria qbazaplanina=session.createCriteria(BazaReci.class);
                BazaReci baza=(BazaReci)qbazaplanina.add(Restrictions.eq("pocetnoslovo", igrazanimljivageografija.getSlovo())).add(Restrictions.eq("tip", "planina")).add(Restrictions.eq("rec",odgplanina)).uniqueResult();
                if(baza!=null){
                    brpoena+=2;
                }
                else{
                    //DODAJ SUPERVIZORU
                    cekamsupervizora=true;
                    revizija[5]=new RevizijaReci();
                    revizija[5].setIdzgeosigre(igrazanimljivageografija.getIdigrazgeos());
                    revizija[5].setSlovo(slovo);
                    revizija[5].setTip("planina");
                    revizija[5].setTekst(odgplanina);
                    revizija[5].setBrpoenadodato(4);
                    if(br==2){
                        revizija[5].setKomedodajem("brpoena2");
                    }
                    else{
                        revizija[5].setKomedodajem("brpoena1");
                    }
                }
            }
        }
        if(igrazanimljivageografija.getZivotinja()!=null){
            if(igrazanimljivageografija.getZivotinja().equals("") || igrazanimljivageografija.getZivotinja().toLowerCase(Locale.FRENCH).charAt(0)!=slovo){
                igrazanimljivageografija.setZivotinja(null);
            }
            else{
                String odgzivotinja=igrazanimljivageografija.getZivotinja().toLowerCase(Locale.FRENCH);
                Criteria qbazazivotinja=session.createCriteria(BazaReci.class);
                BazaReci baza=(BazaReci)qbazazivotinja.add(Restrictions.eq("pocetnoslovo", igrazanimljivageografija.getSlovo())).add(Restrictions.eq("tip", "zivotinja")).add(Restrictions.eq("rec",odgzivotinja)).uniqueResult();
                if(baza!=null){
                    brpoena+=2;
                }
                else{
                    //DODAJ SUPERVIZORU
                    cekamsupervizora=true;
                    revizija[6]=new RevizijaReci();
                    revizija[6].setIdzgeosigre(igrazanimljivageografija.getIdigrazgeos());
                    revizija[6].setSlovo(slovo);
                    revizija[6].setTip("zivotinja");
                    revizija[6].setTekst(odgzivotinja);
                    revizija[6].setBrpoenadodato(4);
                    if(br==2){
                        revizija[6].setKomedodajem("brpoena2");
                    }
                    else{
                        revizija[6].setKomedodajem("brpoena1");
                    }
                }
            }
        }
        if(igrazanimljivageografija.getBiljka()!=null){
            if(igrazanimljivageografija.getBiljka().equals("") || igrazanimljivageografija.getBiljka().toLowerCase(Locale.FRENCH).charAt(0)!=slovo){
                igrazanimljivageografija.setBiljka(null);
            }
            else{
                String odgbiljka=igrazanimljivageografija.getBiljka().toLowerCase(Locale.FRENCH);
                Criteria qbazabiljka=session.createCriteria(BazaReci.class);
                BazaReci baza=(BazaReci)qbazabiljka.add(Restrictions.eq("pocetnoslovo", igrazanimljivageografija.getSlovo())).add(Restrictions.eq("tip", "biljka")).add(Restrictions.eq("rec",odgbiljka)).uniqueResult();
                if(baza!=null){
                    brpoena+=2;
                }
                else{
                    //DODAJ SUPERVIZORU
                    cekamsupervizora=true;
                    revizija[7]=new RevizijaReci();
                    revizija[7].setIdzgeosigre(igrazanimljivageografija.getIdigrazgeos());
                    revizija[7].setSlovo(slovo);
                    revizija[7].setTip("biljka");
                    revizija[7].setTekst(odgbiljka);
                    revizija[7].setBrpoenadodato(4);
                    if(br==2){
                        revizija[7].setKomedodajem("brpoena2");
                    }
                    else{
                        revizija[7].setKomedodajem("brpoena1");
                    }
                }
            }
        }
        if(igrazanimljivageografija.getGrupa()!=null){
            if(igrazanimljivageografija.getGrupa().equals("") || igrazanimljivageografija.getGrupa().toLowerCase(Locale.FRENCH).charAt(0)!=slovo){
                igrazanimljivageografija.setGrupa(null);
            }
            else{
                String odggrupa=igrazanimljivageografija.getGrupa().toLowerCase(Locale.FRENCH);
                Criteria qbazagrupa=session.createCriteria(BazaReci.class);
                BazaReci baza=(BazaReci)qbazagrupa.add(Restrictions.eq("pocetnoslovo", igrazanimljivageografija.getSlovo())).add(Restrictions.eq("tip", "grupa")).add(Restrictions.eq("rec",odggrupa)).uniqueResult();
                if(baza!=null){
                    brpoena+=2;
                }
                else{
                    //DODAJ SUPERVIZORU
                    Session session1 = HibernateUtil.getSessionFactory().openSession();
                    transaction=session1.beginTransaction();
                    cekamsupervizora=true;
                    revizija[0]=new RevizijaReci();
                    revizija[0].setIdzgeosigre(igrazanimljivageografija.getIdigrazgeos());
                    revizija[0].setSlovo(slovo);
                    revizija[0].setTip("grupa");
                    revizija[0].setTekst(odggrupa);
                    revizija[0].setBrpoenadodato(4);
                    if(br==2){
                        revizija[0].setKomedodajem("brpoena2");
                    }
                    else{
                        revizija[0].setKomedodajem("brpoena1");
                    }
                }
            }
        }
        
        transaction.commit();
        session.close();
        
        if(revizija[0]!=null){
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction1=session1.beginTransaction();
            RevizijaReci revizija0=revizija[0];
            session1.persist(revizija0);
            transaction1.commit();
            session1.close();
        }
        if(revizija[1]!=null){
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction1=session1.beginTransaction();
            RevizijaReci revizija1=revizija[1];
            session1.persist(revizija1);
            transaction1.commit();
            session1.close();
        }
        if(revizija[2]!=null){
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction1=session1.beginTransaction();
            RevizijaReci revizija2=revizija[2];
            session1.persist(revizija2);
            transaction1.commit();
            session1.close();
        }
        if(revizija[3]!=null){
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction1=session1.beginTransaction();
            RevizijaReci revizija3=revizija[3];
            session1.persist(revizija3);
            transaction1.commit();
            session1.close();
        }
        if(revizija[4]!=null){
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction1=session1.beginTransaction();
            RevizijaReci revizija4=revizija[4];
            session1.persist(revizija4);
            transaction1.commit();
            session1.close();
        }
        if(revizija[5]!=null){
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction1=session1.beginTransaction();
            RevizijaReci revizija5=revizija[5];
            session1.persist(revizija5);
            transaction1.commit();
            session1.close();
        }
        if(revizija[6]!=null){
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction1=session1.beginTransaction();
            RevizijaReci revizija6=revizija[6];
            session1.persist(revizija6);
            transaction1.commit();
            session1.close();
        }
        if(revizija[7]!=null){
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction1=session1.beginTransaction();
            RevizijaReci revizija7=revizija[7];
            session1.persist(revizija7);
            transaction1.commit();
            session1.close();
        }
        
        
        //NEKI ODGOVOR NIJE PRONADJEN U BAZI - CEKAJ SUPERVIZORA
        if(cekamsupervizora){
            while(cekamsupervizora){
                Session session3 = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction3=session3.beginTransaction();
        
                Criteria crit=session3.createCriteria(RevizijaReci.class);
                //SUPERVIZOR U FUNKCIJI DODAJE POENE I U POGRESNE RECI UPISUJE NULL U IGRI - ima id igre
                //OVDE SAMO CEKAMO DA U REVIZIJI NE POSTOJI NI JEDNA KOLONA SA ID OVE IGRE
                List<RevizijaReci> lista=crit.add(Restrictions.eq("idzgeosigre", igrazanimljivageografija.getIdigrazgeos())).list();
                if(lista!=null){
                    if(lista.isEmpty()) cekamsupervizora=false;
                    else cekamsupervizora=true;
                }
                else{
                    cekamsupervizora=false;
                }
                
                transaction3.commit();
                session3.close();
            }
        }
      
        Session session2 = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction2=session2.beginTransaction();
        
        Criteria q2=session2.createCriteria(IgraZgeos.class);
        igrazanimljivageografija=(IgraZgeos)q2.add(Restrictions.eq("username1", igrazanimljivageografija.getUsername1())).uniqueResult();
        int prethpoeni;
        if(br==1){
            prethpoeni=igrazanimljivageografija.getBrpoena1();
            brpoena+=prethpoeni;
            igrazanimljivageografija.setBrpoena1(brpoena);
            igrazanimljivageografija.setKoigra(1);
        } 
        else{
            prethpoeni=igrazanimljivageografija.getBrpoena2();
            brpoena+=prethpoeni;
            igrazanimljivageografija.setBrpoena2(brpoena);
            igrazanimljivageografija.setKoigra(0);
            
        }
        
        neigram=true;
                
        session2.saveOrUpdate(igrazanimljivageografija);
        
        IgraDanaPartija igranapart=new IgraDanaPartija();
        
        igrazanimljivageografija=(IgraZgeos)q2.add(Restrictions.eq("username1", igrazanimljivageografija.getUsername1())).uniqueResult();
        
        igranapart.setUsername(igrazanimljivageografija.getUsername1());
        igranapart.setBrpoena(igrazanimljivageografija.getBrpoena1());
        
        LocalDateTime ldt=LocalDateTime.now();
        String datumstring=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(ldt);
        
        igranapart.setDatum(datumstring);
        
        session2.persist(igranapart);
        
        Query query=session2.createQuery("delete IgraZgeos where idigrazgeos=:id");
        query.setParameter("id", igrazanimljivageografija.getIdigrazgeos());
        query.executeUpdate();
        
        
        transaction2.commit();
        session2.close();
        
        
        try {
            if(br==1){
                FacesContext.getCurrentInstance().getExternalContext().redirect("uspesanlogin.xhtml");
            }
        } catch (IOException ex) {
            Logger.getLogger(ZanimljivaGeografija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void osluskujKrajCrveni(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraZgeos.class);
        if(igrazanimljivageografija!=null) igrazanimljivageografija=(IgraZgeos)q.add(Restrictions.eq("username1", igrazanimljivageografija.getUsername1())).uniqueResult();
        
        if(igrazanimljivageografija.getKoigra()==1){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("zanimljivageografijacrveniodgc.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(ZanimljivaGeografija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        transaction.commit();
        session.close();
    }
    
    public void osluskujKrajCrveniOdgPlavi(){
        System.out.printf("OSLUSKUJ KRAJ CRVENI");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraZgeos.class);
        if(igrazanimljivageografija!=null) igrazanimljivageografija=(IgraZgeos)q.add(Restrictions.eq("username1", igrazanimljivageografija.getUsername1())).uniqueResult();
        
        if(igrazanimljivageografija==null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("zanimljivageografijacrveni2.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(ZanimljivaGeografija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        transaction.commit();
        session.close();
    }
    
    public void osluskujKrajPlaviOdgCrveni(){
        System.out.printf("OSLUSKUJ KRAJ PLAVI");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraZgeos.class);
        if(igrazanimljivageografija!=null) igrazanimljivageografija=(IgraZgeos)q.add(Restrictions.eq("username1", igrazanimljivageografija.getUsername1())).uniqueResult();
        
        if(igrazanimljivageografija==null){
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("peharplavi.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(ZanimljivaGeografija.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        transaction.commit();
        session.close();
    }
}
