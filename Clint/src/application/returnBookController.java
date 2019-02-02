package application;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class returnBookController {

	
	public static String BookID;
	public static String CopyID;
	
    @FXML
    private TextField BOOKIDField;

    @FXML
    private Button RETURNBtn;

    @FXML
    private TextField COPYIDField;

    @FXML
    void backGui(ActionEvent event) throws IOException 
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

    @FXML
    void returnFunc(ActionEvent event) 
    {
    	IPController.backGui="returnBookController";
    	int FlagBook=9; 
    	int FlagCopy=9;
    	String StudentID;
    	String ReturnDate;
    	BookID = BOOKIDField.getText();
    	CopyID = COPYIDField.getText();
    	BOOKIDField.clear();
    	COPYIDField.clear();
    	
    	
    	
        ArrayList<String> msg3 = new ArrayList<String>();
	    ArrayList<String>  result3 = new ArrayList<String>();
	    msg3.add(BookID);
	    msg3.add(CopyID);
	    msg3.add("CheckIfBookAndCopyInloan");
	    result3 = (ArrayList<String>)IPController.client.Request(msg3);
	    System.out.println(result3);    //// check if there an book to return that dont have returnOnTime date
	    System.out.println("test!tset");
	    if(result3.get(0).equals("Exists")) {
    	
    	
        ArrayList<String> msg = new ArrayList<String>();
	    ArrayList<String>  result = new ArrayList<String>();
	    msg.add(BookID);
	    msg.add("CheckIfBookExists");
	    result = (ArrayList<String>)IPController.client.Request(msg);
	    System.out.println(result);
	    
	    if(result.get(0).equals("Exists")) {
	    FlagBook=1;
	    } 
	    else {FlagBook = 0;}//END IF bookID exists
	    msg.clear();
	    msg.add(BookID);
	    msg.add(CopyID);
    	msg.add("CheckIfCopyExists");
    	result.clear();
    	result = (ArrayList<String>)IPController.client.Request(msg);
	    System.out.println(result); 
	    
	    if(result.get(0).equals("Exists")) {
		    FlagCopy=1;
		    } 
		    else {FlagCopy = 0;}
	    
	    System.out.print("Flag 1 = ");
	    System.out.println(FlagBook);
	    System.out.print("Flag 2 = ");
	    System.out.println(FlagCopy);
	    
	    
	 if(FlagBook == 0) 
		  JOptionPane.showMessageDialog(null, "The book does not exist. Please make sure you're entering a right Book ID");
	 
	 if(FlagBook == 1 && FlagCopy == 0) 
		 JOptionPane.showMessageDialog(null, "The copy does not exist. Please make sure you're entering a right Copy ID");	 
	 
	 
	 
	  if(FlagBook == 1 && FlagCopy == 1) {
	    msg.add("BookReturn");
	    result = (ArrayList<String>)IPController.client.Request(msg);
	    System.out.println(result);
	    StudentID = result.get(0); //Got Student's ID
	    ReturnDate = result.get(1); //Got Book's Return Date
	
    	
	    ///////////////////////////////////////////////////////////////////////////////
	    
	         int diffDays = 0;
	    
	        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
		    Calendar c1 = Calendar.getInstance();
		    c1.setTime(new Date()); 
		    String outputcurrentDate = currentDate.format(c1.getTime());
		    System.out.print("Current date is: ");
		    System.out.println(outputcurrentDate);
		    
		    try {
 	 			String date1 = outputcurrentDate; //REAL Return Date
 	 			String date2 = ReturnDate;        //SUPPOSED Return Date
 	 			String format = "dd/MM/yyyy";

 	 			SimpleDateFormat sdf = new SimpleDateFormat(format);

 	 			Date dateObj1 = sdf.parse(date1);
 	 			Date dateObj2 = sdf.parse(date2);
 	 			System.out.println(dateObj1);
 	 			System.out.println(dateObj2 + "\n");

 	 			DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");

 	 			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
 	 			long diff = dateObj1.getTime() - dateObj2.getTime();

 	 			 diffDays = (int) (diff / (24 * 60 * 60 * 1000));
 	 			System.out.println("difference between days: " + diffDays);	 			
 	 		} catch (Exception e) {
 	 			e.printStackTrace();
 	 		}

		   if(diffDays > 0) { //LATE RETURN, To Do: change membership status to Active , Update ITEMINLOAN row, change copy status to available
			   msg.clear();
			   result.clear();
			   msg.add(BookID);
			   msg.add(CopyID);
			   msg.add(StudentID);
			   msg.add("LateReturn");
			   result = (ArrayList<String>)IPController.client.Request(msg);
			   System.out.println(result);
			   JOptionPane.showMessageDialog(null, "You successfully returned the book.");
			   
			   ArrayList<String> msg1 = new ArrayList<String>();
               ArrayList<String>  result1 = new ArrayList<String>();
               msg1.add(StudentID);
               msg1.add("Return Book");
               msg1.add("UserAction");
               result1 = (ArrayList<String>)IPController.client.Request(msg1);
			   
		    	
		    }
		    else { //RETURN ON TIME, To Do: Delete ITEMINLOAN row, change copy status to available
		    	msg.clear();
				   result.clear();
				   msg.add(BookID);
				   msg.add(CopyID);
				   msg.add(StudentID);
				   msg.add("OnTimeReturn");
				   result = (ArrayList<String>)IPController.client.Request(msg);
				   System.out.println(result);
				   JOptionPane.showMessageDialog(null, "You successfully returned the book.");
					
	            		ArrayList<String> msg1 = new ArrayList<String>();
	                    ArrayList<String>  result1 = new ArrayList<String>();
	                    msg1.add(StudentID);
	                    msg1.add("Return Book");
	                    msg1.add("UserAction");
	                    result1 = (ArrayList<String>)IPController.client.Request(msg1);
	            
	    }
      }
    }
  }
}
