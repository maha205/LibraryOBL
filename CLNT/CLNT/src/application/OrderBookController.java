package application;
import java.awt.Button;
import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OrderBookController 
{    @FXML
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
    private TextField studentName;

    @FXML
    private TextField studentID;

    @FXML
    private TextField studentPhoneNumber;

    @FXML
    private TextField studentEmail;

    @FXML
    private TextField BookName;

    @FXML
    private TextField BookID;

    @FXML
    private TextField CopyID;

    @FXML
    private TextField OrderDate;

  //  @FXML
  //  private Button approvedByn;

   // @FXML
  //  private Button show;

    @FXML
    private Text showText;

    @FXML
    void BackGui(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/StudentProfile.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void logoutGui(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void showOrder(ActionEvent event) 
    {
    	if(!(loanBookController.OrderBookID.equals(null)) && !(loanBookController.OrderCopyID.equals(null)))
    	{   
    		studentNameTxt.setVisible(true);
    		StudentIDTxt.setVisible(true);
            StudentPhoneTxt.setVisible(true);
            StudentEmailTxt.setVisible(true);
            BooknameTxt.setVisible(true);
            BookIDTxt.setVisible(true);
            copyIDTxt.setVisible(true);
            DateOrderText.setVisible(true);
            studentName.setVisible(true);
             studentID.setVisible(true);
            studentPhoneNumber.setVisible(true);
            studentEmail.setVisible(true);
             BookName.setVisible(true);
            BookID.setVisible(true);
             CopyID.setVisible(true);
            OrderDate.setVisible(true);
          ////  approvedByn.setVisible(true);
           ///  show.setVisible(false);
             showText.setVisible(false);
             
    	     String StudentID = sigINController.StudentId ;
    		 ArrayList<String> msg = new ArrayList<String>();
    	     ArrayList<String>  result = new ArrayList<String>();
    	     msg.add(""+StudentID);
    	     msg.add(loanBookController.OrderBookID);
    	     msg.add(loanBookController.OrderCopyID);
    	     msg.add("OrderBook");
    	     result = (ArrayList<String>)IPController.client.Request(msg);
    	     System.out.println(result);
    	     if(result.size()>0)
    	     {
    	    	studentName.setText(result.get(0));
                studentID.setText(result.get(1));
                studentPhoneNumber.setText(result.get(2));
                studentEmail.setText(result.get(3));
                BookName.setText(result.get(4));
                BookID.setText(result.get(5));
               CopyID.setText(result.get(6));
               OrderDate.setText(result.get(7));
    	     }
    	}
    	else
    	{
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
            //approvedByn.setVisible(false);
           //  show.setVisible(true);
             showText.setVisible(true);
    	}
    }
    @FXML
    void approvedOrder(ActionEvent event) 
    {
    	
    }
    @FXML
    void cancelOrder(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/StudentProfile.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

}
