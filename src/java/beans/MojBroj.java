/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entityBeans.IgraMojBroj;
import entityBeans.IgranaPartija;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Legion
 */

@ManagedBean(name="mojbroj")
@SessionScoped
public class MojBroj implements Serializable{
    
    private String color;
    
    private IgranaPartija partija;
    private IgraMojBroj igramojbroj;
    
    private String odgovor;
    
    private int odgovorbroj;
    
    private boolean zakljucanodgovor;
    
    private int timer;
    
    private boolean timerstart;
    
    private Deque<String> izrazi;
   
    
    private int j1;
    private int j2;
    private int j3;
    private int j4;
    private int gb;
    private int d1;
    private int d2;
    
    private boolean stopj1;
    private boolean stopj2;
    private boolean stopj3;
    private boolean stopj4;
    private boolean stopgb;
    private boolean stopd1;
    private boolean stopd2;
    
    private boolean disabledj1;
    private boolean disabledj2;
    private boolean disabledj3;
    private boolean disabledj4;
    private boolean disabledd1;
    private boolean disabledd2;
    
    private int numberOfStops;
    
    private boolean disabledStop;

    private boolean neispravanizraz;

    public boolean isDisabledStop() {
        return disabledStop;
    }

    public void setDisabledStop(boolean disabledStop) {
        this.disabledStop = disabledStop;
    }
    
    
    public boolean isNeispravanizraz() {
        return neispravanizraz;
    }

    public void setNeispravanizraz(boolean neispravanizraz) {
        this.neispravanizraz = neispravanizraz;
    }
    
    public int getOdgovorbroj() {
        return odgovorbroj;
    }

    public void setOdgovorbroj(int odgovorbroj) {
        this.odgovorbroj = odgovorbroj;
    }
    
    public boolean isDisabledj1() {
        return disabledj1;
    }

    public void setDisabledj1(boolean disabledj1) {
        this.disabledj1 = disabledj1;
    }

    public boolean isDisabledj2() {
        return disabledj2;
    }

    public void setDisabledj2(boolean disabledj2) {
        this.disabledj2 = disabledj2;
    }

    public boolean isDisabledj3() {
        return disabledj3;
    }

    public void setDisabledj3(boolean disabledj3) {
        this.disabledj3 = disabledj3;
    }

    public boolean isDisabledj4() {
        return disabledj4;
    }

    public void setDisabledj4(boolean disabledj4) {
        this.disabledj4 = disabledj4;
    }

    public boolean isDisabledd1() {
        return disabledd1;
    }

    public void setDisabledd1(boolean disabledd1) {
        this.disabledd1 = disabledd1;
    }

    public boolean isDisabledd2() {
        return disabledd2;
    }

    public void setDisabledd2(boolean disabledd2) {
        this.disabledd2 = disabledd2;
    }  
    
    public int getJ1() {
        return j1;
    }

    public void setJ1(int j1) {
        this.j1 = j1;
    }

    public int getJ2() {
        return j2;
    }

    public void setJ2(int j2) {
        this.j2 = j2;
    }

    public int getJ3() {
        return j3;
    }

    public void setJ3(int j3) {
        this.j3 = j3;
    }

    public int getJ4() {
        return j4;
    }

    public void setJ4(int j4) {
        this.j4 = j4;
    }

    public int getGb() {
        return gb;
    }

    public void setGb(int gb) {
        this.gb = gb;
    }

    public int getD1() {
        return d1;
    }

    public void setD1(int d1) {
        this.d1 = d1;
    }

    public int getD2() {
        return d2;
    }

    public void setD2(int d2) {
        this.d2 = d2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public IgranaPartija getPartija() {
        return partija;
    }

    public void setPartija(IgranaPartija partija) {
        this.partija = partija;
    }

    public IgraMojBroj getIgramojbroj() {
        return igramojbroj;
    }

    public void setIgramojbroj(IgraMojBroj igramojbroj) {
        this.igramojbroj = igramojbroj;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public boolean isZakljucanodgovor() {
        return zakljucanodgovor;
    }

    public void setZakljucanodgovor(boolean zakljucanodgovor) {
        this.zakljucanodgovor = zakljucanodgovor;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
    
    public void podesiIgruPlavi(String username, int br){
        stopj1=false; stopj2=false; stopj3=false; stopj4=false;
        stopd1=false; stopd2=false; stopgb=false;
        
        disabledj1=true; disabledj2=true; disabledj3=true; disabledj4=true;
        disabledd1=true; disabledd2=true;
    
        if(br==1){
            color="cornflowerblue";
        }
        else{
            color="orangered";
        }
        
        numberOfStops=0;
        
        disabledStop=false;
        
        partija=new IgranaPartija();
        igramojbroj=new IgraMojBroj();
        
        timer=60;
        
        timerstart=false;
        
        zakljucanodgovor=false;
        
        odgovor="";
        
        odgovorbroj=0;
        
        neispravanizraz=false;
        
        izrazi=new ArrayDeque<>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria q=session.createCriteria(IgranaPartija.class);
        
        if(br==1){
            partija=(IgranaPartija)q.add(Restrictions.eq("username1", username)).uniqueResult();
        }
        else{
            partija=(IgranaPartija)q.add(Restrictions.eq("username2", username)).uniqueResult();
        }
        
        igramojbroj.setIdigranapartija(partija.getIdigranapartija());
        igramojbroj.setUsername1(partija.getUsername1());
        igramojbroj.setUsername2(partija.getUsername2());

        session.persist(igramojbroj);
        
        transaction.commit();
        session.close();
    }
    
    
    public void podesiIgruCrveni(String username, int br){
        System.out.print("PODESAVAM MOJ BROOOJ");
        stopj1=false; stopj2=false; stopj3=false; stopj4=false;
        stopd1=false; stopd2=false; stopgb=false;
        
        disabledj1=true; disabledj2=true; disabledj3=true; disabledj4=true;
        disabledd1=true; disabledd2=true;
    
        if(br==1){
            color="cornflowerblue";
        }
        else{
            color="orangered";
        }
        
        numberOfStops=1; //ceka se na prvi stop
        
        disabledStop=false;
        
        partija=new IgranaPartija();
        igramojbroj=new IgraMojBroj();
        
        timer=60;
        
        timerstart=false;
        
        odgovor="";
        
        odgovorbroj=0;
        
        zakljucanodgovor=false;
        
        neispravanizraz=false;
        
        izrazi=new ArrayDeque<>();
        
        boolean ready=false;
        
        System.out.printf("HERE I AM");
        
        while(!ready){
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction=session.beginTransaction();

            Criteria q=session.createCriteria(IgraMojBroj.class);
            
            if(br==1){
                igramojbroj=(IgraMojBroj)q.add(Restrictions.eq("username2", username)).uniqueResult();
            }
            else{
                igramojbroj=(IgraMojBroj)q.add(Restrictions.eq("username1", username)).uniqueResult();
            }
            
            if(igramojbroj!=null){
                ready=true;
            }
            
            transaction.commit();
            session.close();
        }     
    }
    
    
    
    
    public void vrtibrojeve(){
        if(!stopj1) j1=ThreadLocalRandom.current().nextInt(1, 9 + 1);
        if(!stopj2) j2=ThreadLocalRandom.current().nextInt(1, 9 + 1);
        if(!stopj3) j3=ThreadLocalRandom.current().nextInt(1, 9 + 1);
        if(!stopj4)j4=ThreadLocalRandom.current().nextInt(1, 9 + 1);
        int gd1=0;
        if(!stopd1) gd1=ThreadLocalRandom.current().nextInt(1, 3 + 1);
        int gd2=0;
        if(!stopd2) gd2=ThreadLocalRandom.current().nextInt(1, 4 + 1);

        if(gd1==1){
            d1=10;
        }
        else if(gd1==2){
            d1=15;
        }
        else if(gd1==3){
            d1=20;
        }
        if(gd2==1){
            d2=25;
        }
        else if(gd2==2){
            d2=50;
        }
        else if(gd2==3){
            d2=75;
        }
        else if(gd2==4){
            d2=100;
        }
        if(!stopgb) gb=ThreadLocalRandom.current().nextInt(1, 999 + 1);
    }
    
    public void stopPlavi(){
        numberOfStops++;
        vrtibrojeve();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria q=session.createCriteria(IgraMojBroj.class);
        igramojbroj=(IgraMojBroj)q.add(Restrictions.eq("username1", igramojbroj.getUsername1())).uniqueResult();
        
        switch(numberOfStops) {
        case 1:
          stopgb=true;
          igramojbroj.setGlavnibr(gb);
          break; 
        case 2:
          stopj1=true;
          igramojbroj.setJednocifr1(j1);
          break;
        case 3:
          stopj2=true;
          igramojbroj.setJednocifr2(j2);
          break;
        case 4:
          stopj3=true;
          igramojbroj.setJednocifr3(j3);
          break;
        case 5:
          stopj4=true;
          igramojbroj.setJednocifr4(j4);
          break;
        case 6:
          stopd1=true;
          igramojbroj.setDvocifrenimali(d1);
          break;
        case 7:
          stopd2=true;
          igramojbroj.setDvocifreniveliki(d2);
          igramojbroj.setIgrase(1);
          disabledStop=true;
          timerstart=true;
          disabledj1=false; disabledj2=false; disabledj3=false; disabledj4=false;
          disabledd1=false; disabledd2=false;
          break;
        default:
        }
        
        session.saveOrUpdate(igramojbroj);
        
        transaction.commit();
        session.close();
    }
    
    
    
    public void stopCrveni(){
        System.out.printf(Integer.toString(timer));
        if(timerstart){
            System.out.printf("true");
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraMojBroj.class);

        IgraMojBroj igramojbrojtest;
        
        switch(numberOfStops) {
        case 1:
           System.out.printf("CASE1");
           igramojbrojtest=(IgraMojBroj)q.add(Restrictions.eq("username2", igramojbroj.getUsername2())).add(Restrictions.ne("glavnibr", 0)).uniqueResult();
           if(igramojbrojtest!=null){
            System.out.printf("PROSAO GB");
            igramojbroj=igramojbrojtest;
            stopgb=true;
            gb=igramojbroj.getGlavnibr();
            numberOfStops++;
           }
          break; 
        case 2:
          igramojbrojtest=(IgraMojBroj)q.add(Restrictions.eq("username2", igramojbroj.getUsername2())).add(Restrictions.ne("jednocifr1", 0)).uniqueResult();
          if(igramojbrojtest!=null){
            igramojbroj=igramojbrojtest;
            stopj1=true;
            j1=igramojbroj.getJednocifr1();
            numberOfStops++;
          }
          break;
        case 3:
          igramojbrojtest=(IgraMojBroj)q.add(Restrictions.eq("username2", igramojbroj.getUsername2())).add(Restrictions.ne("jednocifr2", 0)).uniqueResult();
          if(igramojbrojtest!=null){
            igramojbroj=igramojbrojtest;
            stopj2=true;
            j2=igramojbroj.getJednocifr2();
            numberOfStops++;
          }
          break;
        case 4:
          igramojbrojtest=(IgraMojBroj)q.add(Restrictions.eq("username2", igramojbroj.getUsername2())).add(Restrictions.ne("jednocifr3", 0)).uniqueResult();
          if(igramojbrojtest!=null){
            igramojbroj=igramojbrojtest;
            stopj3=true;
            j3=igramojbroj.getJednocifr3();
            numberOfStops++;
          }
          break;
        case 5:
          igramojbrojtest=(IgraMojBroj)q.add(Restrictions.eq("username2", igramojbroj.getUsername2())).add(Restrictions.ne("jednocifr4", 0)).uniqueResult();
          if(igramojbrojtest!=null){
            igramojbroj=igramojbrojtest;
            stopj4=true;
            j4=igramojbroj.getJednocifr4();
            numberOfStops++;
          }break;
        case 6:
          igramojbrojtest=(IgraMojBroj)q.add(Restrictions.eq("username2", igramojbroj.getUsername2())).add(Restrictions.ne("dvocifrenimali", 0)).uniqueResult();
          if(igramojbrojtest!=null){
            igramojbroj=igramojbrojtest;
            stopd1=true;
            d1=igramojbroj.getDvocifrenimali();
            numberOfStops++;
          }break;
        case 7:
          igramojbrojtest=(IgraMojBroj)q.add(Restrictions.eq("username2", igramojbroj.getUsername2())).add(Restrictions.ne("dvocifreniveliki", 0)).uniqueResult();
          if(igramojbrojtest!=null){
            igramojbroj=igramojbrojtest;
            stopd2=true;
            d2=igramojbroj.getDvocifreniveliki();
            numberOfStops++;
            disabledj1=false; disabledj2=false; disabledj3=false; disabledj4=false;
            disabledd1=false; disabledd2=false;
            timerstart=true;
          }
          break;
        default:
        }
        transaction.commit();
        session.close();
    }
    
    
    
    public void odgovori(int broj){
        switch(broj){
        case 1:
            odgovor+=Integer.toString(j1);
            izrazi.add(Integer.toString(j1));
            disabledj1=true;
            break;
        case 2:
            odgovor+=Integer.toString(j2);
            izrazi.add(Integer.toString(j2));
            disabledj2=true;
            break;
        case 3:
            odgovor+=Integer.toString(j3);
            izrazi.add(Integer.toString(j3));
            disabledj3=true;
            break;
        case 4:
            odgovor+=Integer.toString(j4);            
            izrazi.add(Integer.toString(j4));
            disabledj4=true;
            break;
        case 5:
            odgovor+=Integer.toString(d1);
            izrazi.add(Integer.toString(d1));
            disabledd1=true;
            break;
        case 6:
            odgovor+=Integer.toString(d2);
            izrazi.add(Integer.toString(d2));            
            disabledd2=true;
            break;
        case 7:
            odgovor+=" + ";
            izrazi.add("+");
            break;
        case 8:
            odgovor+=" - ";
            izrazi.add("-");
            break;
        case 9:
            odgovor+=" * ";
            izrazi.add("*");
            break;
        case 10:
            odgovor+=" / ";
            izrazi.add("/");
            break;    
        case 11:
            odgovor+=" ( ";
            izrazi.add("(");
            break;
        case 12:
            odgovor+=" ) ";
            izrazi.add(")");
            break;
        default:
            break;
        }
    }
    
    public void nazad(){
        String operand=izrazi.removeLast();
        if(operand.equals("+") || operand.equals("-") || operand.equals("*") || operand.equals("/") || operand.equals("(") || operand.equals(")")){
            odgovor="";
            Iterator<String> it=izrazi.iterator();
            while(it.hasNext()){
                odgovor+=it.next();
                odgovor+=" ";
            }
            System.out.println(validirajizraz());
            return;
        }
        int operandbroj=Integer.parseInt(operand);
        if(operandbroj==j1){
            disabledj1=false;
        }
        else if(operandbroj==j2){
            disabledj2=false;
        }
        else if(operandbroj==j3){
            disabledj3=false;
        }
        else if(operandbroj==j4){
            disabledj4=false;
        }
        else if(operandbroj==d1){
            disabledd1=false;
        }
        else if(operandbroj==d2){
            disabledd2=false;
        }
        odgovor="";
        Iterator<String> it=izrazi.iterator();
        while(it.hasNext()){
            odgovor+=it.next();
            odgovor+=" ";
        }
        
        System.out.println(validirajizraz());
    }
    
    
    public void odbrojavajPlavi(int br){
        if(!timerstart) return;
        if(timer>-1){
            timer--;
        }
        if(timer==-1){
            zakljucanodgovor=true;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraMojBroj.class);
        if(igramojbroj!=null) igramojbroj=(IgraMojBroj)q.add(Restrictions.eq("username1", igramojbroj.getUsername1())).uniqueResult();

        if(igramojbroj!=null){
            if(br==1){
                igramojbroj.setZakljucan1(zakljucanodgovor);
            }
            else{
                igramojbroj.setZakljucan2(zakljucanodgovor);
            }
            session.saveOrUpdate(igramojbroj);
        }
       

        transaction.commit();
        session.close();
        
        if(igramojbroj!=null){
            if(igramojbroj.isZakljucan1() && igramojbroj.isZakljucan2()){
                proveriodgovore(br);
            }
        }
    }
    
    public void proveriodgovore(int br){
        int odgovorplavi;
        int odgovorcrveni;
        
        odgovorplavi=igramojbroj.getOdgovorusername1();
        odgovorcrveni=igramojbroj.getOdgovorusername2();
        
        int tacanodgovor=igramojbroj.getGlavnibr();

        int poeniplavi=0;
        int poenicrveni=0;
        
        int udaljenostplavi=Math.abs(tacanodgovor-odgovorplavi);
        int udaljenostcrveni=Math.abs(tacanodgovor-odgovorcrveni);

        if(udaljenostplavi==udaljenostcrveni){
            poeniplavi=5;
            poenicrveni=5;
        }
        else if(udaljenostplavi<udaljenostcrveni){
            poeniplavi=10;
            poenicrveni=0;
        }
        else if(udaljenostcrveni<udaljenostplavi){
            poenicrveni=10;
            poeniplavi=0;
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgranaPartija.class);
        IgranaPartija igranapartija=(IgranaPartija)q.add(Restrictions.eq("username1", igramojbroj.getUsername1())).uniqueResult();

        int prethodnipoeniplavi=igranapartija.getPoeni1();
        int prethodnipoenicrveni=igranapartija.getPoeni2();

        int prethpoeni1=igranapartija.getMojbroj1();
        int prethpoeni2=igranapartija.getMojbroj2();
        
        prethpoeni1+=poeniplavi;
        prethpoeni2+=poenicrveni;
        
        poeniplavi+=prethodnipoeniplavi;
        poenicrveni+=prethodnipoenicrveni;

        igranapartija.setPoeni1(poeniplavi);
        igranapartija.setPoeni2(poenicrveni);
        
        igranapartija.setMojbroj1(prethpoeni1);
        igranapartija.setMojbroj2(prethpoeni2);

        session.saveOrUpdate(igranapartija);
        
        String hqlUpdate="delete IgraMojBroj where username1=:username1";
        session.createQuery(hqlUpdate).setString("username1", igramojbroj.getUsername1()).executeUpdate();

        transaction.commit();
        session.close();
        
        
        //1-plavi je plavi, 2-crveni uzima funkcije plavog
        try {
            if(br==1){
             FacesContext.getCurrentInstance().getExternalContext().redirect("mojbrojplavi2.xhtml");   
            }
            else{
               FacesContext.getCurrentInstance().getExternalContext().redirect("vesanjecrveni.xhtml"); 
            }
        } catch (IOException ex) {
            Logger.getLogger(Anagram.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void odbrojavajCrveni(int br){
        if(!timerstart) return;
        if(timer>0){
            timer--;
        }
        if(timer==0){
            zakljucanodgovor=true;
        }
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Criteria q=session.createCriteria(IgraMojBroj.class);
        if(igramojbroj!=null) igramojbroj=(IgraMojBroj)q.add(Restrictions.eq("idigramojbroj", igramojbroj.getIdigramojbroj())).uniqueResult();
        
        if(igramojbroj==null){
            try {
                if(br==1){
                    FacesContext.getCurrentInstance().getExternalContext().redirect("mojbrojcrveni2.xhtml"); 
                    transaction.commit();
                    session.close();
                }
                else{
                    FacesContext.getCurrentInstance().getExternalContext().redirect("vesanjeplavi.xhtml"); 
                    transaction.commit();
                    session.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Anagram.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            if(br==1){
               igramojbroj.setZakljucan2(zakljucanodgovor);
           }
           else{
               igramojbroj.setZakljucan1(zakljucanodgovor);
           }

           session.saveOrUpdate(igramojbroj);

           transaction.commit();
           session.close();   
        }
    }
    
    
    public void konacanOdgovorPlavi(int br){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();

         Criteria q=session.createCriteria(IgraMojBroj.class);
         igramojbroj=(IgraMojBroj)q.add(Restrictions.eq("username1", igramojbroj.getUsername1())).uniqueResult();
         
         racunaj();
         
         if(neispravanizraz==true){
             odgovorbroj=2500;
         }
         
         if(br==1){
            igramojbroj.setOdgovorusername1(odgovorbroj);
         }
         else{
            igramojbroj.setOdgovorusername2(odgovorbroj);
         }
              
         session.saveOrUpdate(igramojbroj);
         
         transaction.commit();
         session.close();
         
         zakljucanodgovor=true;
    }
    
    public void konacanOdgovorCrveni(int br){
         Session session = HibernateUtil.getSessionFactory().openSession();
         Transaction transaction=session.beginTransaction();

         Criteria q=session.createCriteria(IgraMojBroj.class);
         igramojbroj=(IgraMojBroj)q.add(Restrictions.eq("username1", igramojbroj.getUsername1())).uniqueResult();
         
         racunaj();
         
         if(neispravanizraz==true){
             odgovorbroj=2500;
         }
         
         if(br==1){
            igramojbroj.setOdgovorusername2(odgovorbroj);
         }
         else{
            igramojbroj.setOdgovorusername1(odgovorbroj);
         }
              
         session.saveOrUpdate(igramojbroj);
         
         transaction.commit();
         session.close();
         
         zakljucanodgovor=true;
         
         System.out.printf("ZAKLJUCAN ODGoOvR CRVENI");
         if(zakljucanodgovor){
             System.out.printf("true");
         }
         else{
             System.out.printf("false");
         }
    }
    
    public boolean validirajizraz(){
        int otvorenezagrade=0;
        String prviizraz=izrazi.getFirst();
        if(prviizraz.equals("+") || prviizraz.equals("-") || prviizraz.equals("*") || prviizraz.equals("/") || prviizraz.equals(")")){
            return false;
        }
        String poslizraz=izrazi.getLast();
        if(poslizraz.equals("+") || poslizraz.equals("-") || poslizraz.equals("*") || poslizraz.equals("/") || poslizraz.equals("(")){
            return false;
        }
        Iterator<String> it=izrazi.iterator();
        String operand1=it.next();
        String operand2=null;
        while(it.hasNext()){
            operand2=it.next();
            
            if(operand1.equals(")")){
                if(otvorenezagrade==0){
                    return false;
                }
                else{
                    otvorenezagrade--;
                }
            }
            if(operand1.equals("(")){
                otvorenezagrade++;
            }
            
            //NE MOZE DVA UZASTOPNA BROJA
            if((!operand1.equals("+") && !operand1.equals("-") && !operand1.equals("*") && !operand1.equals("/") && !operand1.equals("(") && !operand1.equals(")"))
                    &&
               (!operand2.equals("+") && !operand2.equals("-") && !operand2.equals("*") && !operand2.equals("/") && !operand2.equals("(") && !operand2.equals(")"))){
                return false;
            }
            
            //NE MOZE )(, (+-/*, +-/*)
            if(operand1.equals("(") && operand2.equals("(")){
                return false;
            }
            if(operand1.equals("(") && (operand2.equals("+") || operand2.equals("-") || operand2.equals("*") || operand2.equals("/"))){
                return false;
            }
            if((operand1.equals("+") || operand1.equals("-") || operand1.equals("*") || operand1.equals("/")) && operand2.equals(")")){
                return false;
            }
            
            //NE MOZE ++, --, //, **
            if((operand1.equals("+") || operand1.equals("-") || operand1.equals("*") || operand1.equals("/"))
                    &&
               (operand2.equals("+") || operand2.equals("-") || operand2.equals("*") || operand2.equals("/"))){
                return false;
            }
            
            operand1=operand2;
        }
        if(operand1.equals(")")){
            otvorenezagrade--;
        }
        if(otvorenezagrade>0){
            return false;
        }
        else{
            return true;
        }
    }
    
    
    public int racunaj(){
        
        if(odgovor.equals("")){
            return odgovorbroj;
        }
        
        if(validirajizraz()){
            neispravanizraz=false;
        }
        else{
            neispravanizraz=true;
            return odgovorbroj; 
        }
        
        char[] tokens = odgovor.toCharArray();
  
         // Stack for numbers: 'values' 
        Stack<Integer> values = new Stack<>(); 
  
        // Stack for Operators: 'ops' 
        Stack<Character> ops = new Stack<>(); 
  
        for (int i = 0; i < tokens.length; i++) 
        { 
             // Current token is a whitespace, skip it 
            if (tokens[i] == ' ') 
                continue; 
  
            // Current token is a number, push it to stack for numbers 
            if (tokens[i] >= '0' && tokens[i] <= '9') 
            { 
                StringBuffer sbuf = new StringBuffer(); 
                // There may be more than one digits in number 
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
                    sbuf.append(tokens[i++]); 
                values.push(Integer.parseInt(sbuf.toString())); 
            } 
  
            // Current token is an opening brace, push it to 'ops' 
            else if (tokens[i] == '(') 
                ops.push(tokens[i]); 
  
            // Closing brace encountered, solve entire brace 
            else if (tokens[i] == ')') 
            { 
                while (ops.peek() != '(') 
                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
                ops.pop(); 
            } 
  
            // Current token is an operator. 
            else if (tokens[i] == '+' || tokens[i] == '-' || 
                     tokens[i] == '*' || tokens[i] == '/') 
            { 
                // While top of 'ops' has same or greater precedence to current 
                // token, which is an operator. Apply operator on top of 'ops' 
                // to top two elements in values stack 
                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
                  values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
  
                // Push current token to 'ops'. 
                ops.push(tokens[i]); 
            } 
        } 
  
        // Entire expression has been parsed at this point, apply remaining 
        // ops to remaining values 
        while (!ops.empty()) 
            values.push(applyOp(ops.pop(), values.pop(), values.pop())); 
  
        // Top of 'values' contains result, return it 
        odgovorbroj=values.pop(); 
        return odgovorbroj;
    }
    
    // Returns true if 'op2' has higher or same precedence as 'op1', 
    // otherwise returns false. 
    public boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 
  
    // A utility method to apply an operator 'op' on operands 'a'  
    // and 'b'. Return the result. 
    public int applyOp(char op, int b, int a) 
    { 
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
                neispravanizraz=true; 
            return a / b; 
        } 
        return 0; 
    } 
}