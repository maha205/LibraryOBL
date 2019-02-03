package application;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * 
 * Sending Email message 
 *
 */
public class EmailMsg {

	public static String Too; 
	public static String TextBody;

	
	/**
	 * Getting Too
	 * @return Too
	 */
    public String getToo()
    {
    	return this.Too ;
    }
    /**
     * Getting Text
     * @return
     */
    public String getTextBody()
    {
    	return this.TextBody ;
    }
    /**
     * Setting Too
     * @param newToo
     */
    public void setToo(String newToo)
    {
    	 this.Too =newToo ;
    }
    /**
     * Setting Text
     * @param newTextBody
     */
    public void setTextBody(String newTextBody)
    {
    	 this.TextBody =newTextBody ;
    }
    
    /**
     * Sending Mail Action
     */
    void SendAction() 
    {
        try{
            String host ="smtp.gmail.com" ;
            String user = "ortbraudelibrary.g27@gmail.com";
            String pass = "Library123";
            String to = EmailMsg.Too;
            String from = "ortbraudelibrary.g27@gmail.com";
            String subject = "ORT BRAUDE LIBRARY - Hello!";
            String messageText = EmailMsg.TextBody;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
    	
    	
    }

}