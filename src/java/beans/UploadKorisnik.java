/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Legion
 */

@ManagedBean
@ViewScoped
public class UploadKorisnik {
    private byte[] fajl=null;
    private boolean validacijaNijeUspela;
    
    private static boolean validateImageDimensions(byte[] bytes) throws IOException{
        BufferedImage buffImage=ImageIO.read(new ByteArrayInputStream(bytes));
        return buffImage.getHeight()<=300 && buffImage.getWidth()<=300;
    }
    
    public void fileUploadListener(FileUploadEvent event) throws IOException{
        UploadedFile uploadedFile=event.getFile();
        byte[] bytes=new byte[(int)uploadedFile.getSize()];
        
        InputStream is=uploadedFile.getInputstream();
        ByteArrayOutputStream buff=new ByteArrayOutputStream();
        int numReadByte;
        while((numReadByte=is.read(bytes,0,bytes.length))!=-1){
            buff.write(bytes,0,numReadByte);
        }
        
        buff.flush();
        
        fajl=buff.toByteArray();
        if(UploadKorisnik.validateImageDimensions(fajl)){
            validacijaNijeUspela=false;
        }
        else{
            validacijaNijeUspela=true;
        }
        
        if(validacijaNijeUspela){
            FacesContext context=FacesContext.getCurrentInstance();
            context.validationFailed();
            ((UIInput) event.getComponent()).setValid(false);
            FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"Upload failed","Dimenzije slike mogu biti do 300x300px!");
            context.addMessage(event.getComponent().getClientId(), message);
            ((UIInput) event.getComponent()).resetValue();
            fajl=null;
        }
    }
    
    public byte[] getFajl(){
        return fajl;
    }
}
