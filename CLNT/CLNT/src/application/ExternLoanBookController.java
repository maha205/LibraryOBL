package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExternLoanBookController
{
	public EmailMsg email ;
	@FXML
	private Text dayMsg;   

	 @FXML
    private Text dateReturn;
    @FXML
    private Text succesful;
    @FXML
    private TextField bookID;
    @FXML
    private Text errorMsg;
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
    void ExtendLoan(ActionEvent event) 
    {
    	String newDate = null ,oldDate = null;
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(sigINController.StudentId);
        msg.add(bookID.getText());
        msg.add("ExtendLoan");
        result = (ArrayList<String>)IPController.client.Request(msg);
        System.out.println(result);
        if(result.size() >0)
        {
        	newDate=result.get(0) ;
        	oldDate = result.get(1);
        	
        	errorMsg.setVisible(false);
        	succesful.setVisible(true);
        	dayMsg.setVisible(true);
        	dateReturn.setText(result.get(0));
        	dateReturn.setVisible(true);
        	
        	ArrayList<String> msg1 = new ArrayList<String>();
            ArrayList<String>  result1 = new ArrayList<String>();
            msg1.add("LibrarianEmail");
            result1 = (ArrayList<String>)IPController.client.Request(msg1);
            System.out.println(result1);
            if(result1.size()>0)
            {
            	for(int i=0;i<result1.size();i+=2)
            	{
        	     email = new EmailMsg();
        	     email.Too =result1.get(i);
        	     System.out.println(result1.get(i));
        	     email.TextBody ="Hello "+result1.get(i+1)+" ,\r\n" + 
        			"\r\n" + 
        			"Please note that student: \r\n" + 
        			"ID : '"+sigINController.StudentId+"' \r\n" + 
        			"Extended his loan duration for the following book:\r\n" + 
        			"Book Name\r\n" + 
        			"Book ID : '"+bookID.getText()+"'\r\n" + 
        			"Old return Date : '"+oldDate+"'\r\n" + 
        			"\r\n" + 
        			"New return date is: '"+newDate+"'\r\n" + 
        			"\r\n" + 
        			"Thank you,\r\n" + 
        			"ORT Braude Library";
        	    email.SendAction();
            	}
            }
        	
        }
        else
        {
        	errorMsg.setVisible(true);
        	succesful.setVisible(false);
        	dayMsg.setVisible(false);
        	dateReturn.setVisible(false);
        	
        }
    }
  

    @FXML
    void exitGui(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

}