package application;
import java.awt.Button;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * Order book controller
 * @author Reem
 *
 */
public class OrderBookController 
{  
	   @FXML
	    private Text studentNameTxt;

	    @FXML
	    private Text StudentIDTxt;

	    @FXML
	    private Text StudentPhoneTxt;

	    @FXML
	    private Text StudentEmailTxt;

	    @FXML
	    private Text BooknameTxt;

	    @FXML
	    private Text BookIDTxt;

	    @FXML
	    private Text copyIDTxt;

	    @FXML
	    private Text DateOrderText;


	    @FXML
	    private Text showText;

	    @FXML
	    private Text errorShow;

	    @FXML
	    private Text studentName;

	    @FXML
	    private Text studentID;

	    @FXML
	    private Text studentPhoneNumber;

	    @FXML
	    private Text studentEmail;

	    @FXML
	    private Text BookName;

	    @FXML
	    private Text BookID;

	    @FXML
	    private Text CopyID;

	    @FXML
	    private Text OrderDate;
	    /**
	     * load book order
	     * @param bookToOrder
	     */
		public void loadBookOrder(ArrayList<String> bookToOrder)
		{
			if(bookToOrder.size() >0) {
            errorShow.setVisible(false);
            
            this.studentName.setText(bookToOrder.get(0));
           this.studentID.setText(bookToOrder.get(1));
           this.studentPhoneNumber.setText(bookToOrder.get(2));
           this.studentEmail.setText(bookToOrder.get(3));
           this.BookName.setText(bookToOrder.get(4));
           this.BookID.setText(bookToOrder.get(5));
           this.CopyID.setText(bookToOrder.get(6));
           this.OrderDate.setText(bookToOrder.get(7));
			}
			else
			{
				errorShow.setVisible(true);
	    		studentNameTxt.setVisible(false);
	    		StudentIDTxt.setVisible(false);
	            StudentPhoneTxt.setVisible(false);
	            StudentEmailTxt.setVisible(false);
	            BooknameTxt.setVisible(false);
	            BookIDTxt.setVisible(false);
	            copyIDTxt.setVisible(false);
	            DateOrderText.setVisible(false);
	            studentName.setVisible(false);
	             studentID.setVisible(false);
	            studentPhoneNumber.setVisible(false);
	            studentEmail.setVisible(false);
	             BookName.setVisible(false);
	            BookID.setVisible(false);
	             CopyID.setVisible(false);
	            OrderDate.setVisible(false);
			}
           
		}
		
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void BackGui(ActionEvent event) throws IOException 
    {
  		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/"+IPController.backGui+".fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Manager Profile");
			stage.setScene(new Scene(root));
			stage.show();
    }

    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void logoutGui(ActionEvent event) throws IOException 
    {
        sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
    	sigINController.ManagementId =null ;
    	
  		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }

    @FXML
    /**
     * approving order Button handler
     * @param event
     * @throws IOException
     */
    void approvedOrder(ActionEvent event) throws IOException 
    {
    	if(!(loanBookController.OrderBookID.equals(null)) && !(loanBookController.OrderCopyID.equals(null)))
    	{   
    	     String StudentID = loanBookController.StudentID ;
    		 ArrayList<String> msg = new ArrayList<String>();
    	     ArrayList<String>  result = new ArrayList<String>();
    	     msg.add(""+StudentID);
    	     msg.add(loanBookController.OrderBookID);
    	     msg.add(loanBookController.OrderCopyID);
    	     msg.add("approvedOrderBook");
    	     result = (ArrayList<String>)IPController.client.Request(msg);
    	     System.out.println(result);
    	     if(result.size()>0)
    	     {
    	    	 
   	    	  errorShow.setVisible(false);
        		ArrayList<String> msg1 = new ArrayList<String>();
                ArrayList<String>  result1 = new ArrayList<String>();
                msg1.add(StudentID);
                msg1.add("Order Book");
                msg1.add("UserAction");
                result1 = (ArrayList<String>)IPController.client.Request(msg1);
        	
   		 JOptionPane.showMessageDialog(null, "Thanks For Your Order! \r\n" +
    	    	 "We'll notify you when the book your ordered is available  \r\n" +
    	          "Thank you! Your order is saved in the system. \r\n" +
    	    	 
    	          "Please note that if you do not take the book in 2 days, the order will be canceled.");
   		        
    	    	 ((Node)event.getSource()).getScene().getWindow().hide();
     	   		Stage primaryStage = new Stage();
     	   		FXMLLoader loader = new FXMLLoader();
     	   		Pane root = loader.load(getClass().getResource("/application/LibrarianProfile.fxml").openStream());
     	   	primaryStage.setTitle("Librarian Profile");
     	   		Scene scene = new Scene(root);			
     	   		
     	   		primaryStage.setScene(scene);		
     	   		primaryStage.show();
    	    	 
    	     }
    	     else
    	    	 {
    	    	 errorShow.setVisible(true);
    	    	 }
    	   
    	}
    }
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void cancelOrder(ActionEvent event) throws IOException 
    {
  		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/StudentProfile.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
  		
    }

}
