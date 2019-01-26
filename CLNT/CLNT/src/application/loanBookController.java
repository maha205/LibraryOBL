package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javafx.fxml.FXMLLoader;
public class loanBookController 
{
	ArrayList<String>  tmp = new ArrayList<String>();
    public static String StudentEmail;
	public static String OrderBookID = null;
	public static String OrderCopyID = null;
	public static String BookID = "NO";
	public static int bookstatus = 0, memberstatus = 0;
	  @FXML
	    private TextField BOOKNAMEField;

	    @FXML
	    private Button SEARCHBtn;

	    @FXML
	    private Button LOANBtn;

	    @FXML
	    private Text BOOKNAMELabel;

	    @FXML
	    private Text AUTHORLabel;

	    @FXML
	    private Text GENRELabel;

	    @FXML
	    private Text DESCRIPTIONLabel;

	    @FXML
	    private Text PUBLISHERLabel;

	    @FXML
	    void LoanFunc(ActionEvent event) throws IOException {
	    	
	    	
	    	if(BookID == "NO") {
	    		JOptionPane.showMessageDialog(null, "Please search for a book");
	    	}
	    	else {
	    		  ArrayList<String> msg = new ArrayList<String>();
	    	       ArrayList<String>  result = new ArrayList<String>();
	    	       msg.add(BookID);
	    	       msg.add("SearchInCopy");
	    	       result = (ArrayList<String>)IPController.client.Request(msg);
	    	       System.out.println(result);
	    	       if(!result.get(0).equals("NO")) { 
	    	    	   System.out.println(result.get(0));
	    	    	   bookstatus = 1;
	    	       }else
	    	       {
	    	    	bookstatus=0;
	    	       }
	    	       String copyid = result.get(0);
	    	       
	    	       
	    	       msg.clear();
	    	       result.clear();
	    	       
	    	       msg.add(sigINController.StudentId);
	    	       msg.add("CheckStudentStatus");
	    	       result = (ArrayList<String>)IPController.client.Request(msg);
	    	       StudentEmail = result.get(1);
	    	       System.out.println(result);
	    	       if(result.get(0).equals("Active")) 
	    	        memberstatus = 1;
	    	       
	    	        System.out.println("Book flag = ");
	    	        System.out.println(bookstatus);
	    	        System.out.println("Member flag = ");
	    	        System.out.println(memberstatus);
	    	        
		   	    	///////////////////////
	    	       
	    	        
	    	        
	    	        if(memberstatus == 1 && bookstatus == 1) {
	    	        	msg.clear();
	    	        	result.clear();
	    	        	msg.add(sigINController.StudentId);
	    	        	msg.add(BookID);
	    	        	msg.add(copyid);
	    	        	msg.add("0");
	    	        	msg.add("AddItemInLoan");
	    	            result = (ArrayList<String>)IPController.client.Request(msg);
	   	    	        System.out.println(result);
	   	    	        
	   	    	          
	   	    	        
	   	    	     JOptionPane.showMessageDialog(null, "Thank you! You successfully loaned the book."
	   	    	     		+ "\nBook Name:"+tmp.get(1)+""
	   	    	     				+ "\nLoan Date:"+result.get(0)+""
	   	    	     						+ "\nReturn Date:"+result.get(1)+"");
	   	    	     
	   	
	   	    	  try{
	   	            String host ="smtp.gmail.com" ;
	   	            String user = "ortbraudelibrary.g27@gmail.com";
	   	            String pass = "Library123";
	   	            String to = StudentEmail;
	   	            String from = "ortbraudelibrary.g27@gmail.com";
	   	            String subject = "ORT BRAUDE LIBRARY - Hello!";
	   	            String messageText ="Thank you! You successfully loaned the book."
	   	    	     		+ "\nBook Name:"+tmp.get(1)+""
	    	     				+ "\nLoan Date:"+result.get(0)+""
	    	     						+ "\nReturn Date:"+result.get(1)+""
	    	     								+ "\n\nBest regards,\nORT Braude Library";
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
	   	            Message msg1 = new MimeMessage(mailSession);
	   	            msg1.setFrom(new InternetAddress(from));
	   	            InternetAddress[] address = {new InternetAddress(to)};
	   	            msg1.setRecipients(Message.RecipientType.TO, address);
	   	            msg1.setSubject(subject); msg1.setSentDate(new Date());
	   	            msg1.setText(messageText);

	   	           Transport transport=mailSession.getTransport("smtp");
	   	           transport.connect(host, user, pass);
	   	           transport.sendMessage(msg1, msg1.getAllRecipients());
	   	           transport.close();
	   	           System.out.println("message send successfully");
	   	        }catch(Exception ex)
	   	        {
	   	            System.out.println(ex);
	   	        }
	   	    	     
	   	    	        ///////////////////////////
	   	    	        
	    	        }
	    	        else {
	    	        if(memberstatus == 0) { //Member not active
	    	        	JOptionPane.showMessageDialog(null, "Your membership status is not active. Please contact the Librarian for more info.");
	    	        }
	    	        else {
	    	        if(bookstatus == 0) { //No Book available, send to order
	    	        	    int response = JOptionPane.showConfirmDialog(null, "Book is not available. Would you like to order the book?", "Book Not Available",
	    	        	        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    	        	    if (response == JOptionPane.NO_OPTION) {
	    	        	      System.out.println("No button clicked");
	    	        	    } else if (response == JOptionPane.YES_OPTION) {
	    	        	     ////////////////*******************************************************************************
	    	        	    	OrderBookID = BookID;
	    	        	    	OrderCopyID = copyid;
	    	        	    
	    	        	    	((Node)event.getSource()).getScene().getWindow().hide();
	    	        	  		Stage primaryStage = new Stage();
	    	        	  		FXMLLoader loader = new FXMLLoader();
	    	        	  		Pane root = loader.load(getClass().getResource("/application/OrderBook.fxml").openStream());
	    	        	  		
	    	        	  	 	 String StudentID = sigINController.StudentId ;
		    	        		 ArrayList<String> msg1 = new ArrayList<String>();
		    	        	     ArrayList<String>  result1 = new ArrayList<String>();
		    	        	     msg1.add(""+StudentID);
		    	        	     msg1.add(loanBookController.OrderBookID);
		    	        	     msg1.add(loanBookController.OrderCopyID);
		    	        	     msg1.add("ShowOrderBook");
		    	        	     result1 = (ArrayList<String>)IPController.client.Request(msg1);
		    	        	     
		    	    	  		OrderBookController orderBook = loader.getController();	
		    	    			
		    	    	  		orderBook.loadBookOrder( result1);
		    	    	  		
	    	        	  		Scene scene = new Scene(root);			
	    	        	  		primaryStage.setScene(scene);		
	    	        	  		primaryStage.show();
	    	        	    } else if (response == JOptionPane.
	    	        	    		
	    	        	    		CLOSED_OPTION) {
	    	        	      System.out.println("JOptionPane closed");
	    	        	    }
	    	              }
	    	        } //end else
	    	  }
	    	}
	    }

		@FXML
	    void SearchFunc(ActionEvent event) throws IOException {
        String BookName = BOOKNAMEField.getText();
        BOOKNAMEField.clear();
        ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(BookName);
        msg.add("LoanSearch");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	tmp = result;
    	System.out.println(result);
    	
    	if(!result.get(0).equals("No")){
    	BookID = result.get(0);      
    	BOOKNAMELabel.setText(result.get(1));
    	AUTHORLabel.setText(result.get(2));
    	GENRELabel.setText(result.get(3));
    	DESCRIPTIONLabel.setText(result.get(4));
    	PUBLISHERLabel.setText(result.get(5));    	
    	      }
    	else {
    	    bookstatus = 0;
    	    memberstatus = 0;
    		BookID = "NO";		
        	BOOKNAMELabel.setText("");
        	AUTHORLabel.setText("");
        	GENRELabel.setText("");
        	DESCRIPTIONLabel.setText("");;
        	PUBLISHERLabel.setText("");  
          	}
    
	    }
	    
	    
    @FXML
    void BackGui(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/"+IPController.backGui+".fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }


    @FXML
    void exitGui(ActionEvent event) throws IOException 
    {
       sigINController.LibrarianId=null;
	   sigINController.StudentId =null;
	   sigINController.ManagementId =null ;
	   ((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

 
}