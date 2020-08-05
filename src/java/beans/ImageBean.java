/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import entityBeans.Korisnik;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import util.HibernateUtil;

/**
 *
 * @author Legion
 */

@ManagedBean
@RequestScoped
public class ImageBean {
    
    private DefaultStreamedContent myImage;

    public DefaultStreamedContent getMyImage() {
        return myImage;
    }

    public void setMyImage(DefaultStreamedContent myImage) {
        this.myImage = myImage;
    }
    
    public void getPicture(String username){
        
        System.out.printf("HEJ");
        
        
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        
        Criteria query=session.createCriteria(Korisnik.class);
        
        Korisnik user=(Korisnik)query.add(Restrictions.eq("username", username)).uniqueResult();
        
        if(user==null){
            transaction.commit();
            session.close();
            return;
        }
        else if(user.getSlika()==null){
            transaction.commit();
            session.close();
            return;
        }
        
        byte[] databasepicture=user.getSlika();
        
        InputStream is = new ByteArrayInputStream(databasepicture);
        myImage = new DefaultStreamedContent(is, "image/png");
        
        transaction.commit();
        session.close();
    }
    
}
