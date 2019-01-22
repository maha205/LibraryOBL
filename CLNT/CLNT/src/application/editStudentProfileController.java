package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class editStudentProfileController 
{
	@FXML
    private Text email;

    @FXML
    private Text phone;

    @FXML
    private Text newPass;

    @FXML
    private Text AssertPass;
    @FXML
    private Text oldPasswordTochange;
 
    @FXML
    private TextField emailTxt = null;

    @FXML
    private TextField phontTxt = null;

    @FXML
    private TextField oldPassTxt = null;

    @FXML
    private TextField newPassTxt = null;

    @FXML
    private TextField assertPassTxt = null;
    @FXML
    void backFunc(ActionEvent event) throws IOException 
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
    void saveFunc(ActionEvent event) throws NullPointerException 
    {
    	
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        try{
        	if(!(emailTxt.getText().equals(null)))
        	{
        		msg.add(sigINController.StudentId);
        		msg.add(emailTxt.getText());
        		msg.add("UpdateEmailStudent");
        		result = (ArrayList<String>)IPController.client.Request(msg);
            	System.out.println(result);
        	}
        	
        }catch( NullPointerException  e) {e.printStackTrace();  }
    	
    	
       try{
           if(!(phontTxt.getText().equals(null)))  	
    	   {
    	   	msg.add(sigINController.StudentId);
    		msg.add(phontTxt.getText());
    		msg.add("UpdatephontStudent");
    		result = (ArrayList<String>)IPController.client.Request(msg);
    	    System.out.println(result);
    	   }
       }catch( NullPointerException  e) {e.printStackTrace();  }
    		
       try{
    	if(!(oldPassTxt.getText().equals(null)) && !(newPassTxt.getText().equals(null)) && !(assertPassTxt.getText().equals(null))) 
    	{
    		
    		msg.add(sigINController.StudentId);
    		msg.add(oldPassTxt.getText());
    		msg.add(newPassTxt.getText());
    		msg.add(assertPassTxt.getText());
    		msg.add("UpdatePasswordStudent");
    		result = (ArrayList<String>)IPController.client.Request(msg);
    	    System.out.println(result);
    	}
       }catch( NullPointerException  e) {e.printStackTrace();  }
    }
    @FXML
    void updateEmailFunc(ActionEvent event) 
    {
    	emailTxt.setVisible(true);
    	email.setVisible(true);
    	phontTxt.setVisible(false);
    	phone.setVisible(false);
    	oldPassTxt.setVisible(false);
    	newPass.setVisible(false);
    	newPassTxt.setVisible(false);
    	AssertPass.setVisible(false);
    	assertPassTxt.setVisible(false);
    	oldPasswordTochange.setVisible(false);
    	
    	phontTxt.setText(null);
    	newPassTxt.setText(null);
    	assertPassTxt.setText(null);
    	oldPassTxt.setText(null);
    }

    @FXML
    void updatePassFunc(ActionEvent event) 
    {
    	emailTxt.setVisible(false);
    	email.setVisible(false);
    	phontTxt.setVisible(false);
    	phone.setVisible(false);
    	oldPassTxt.setVisible(true);
    	newPass.setVisible(true);
    	newPassTxt.setVisible(true);
    	AssertPass.setVisible(true);
    	assertPassTxt.setVisible(true);
    	oldPasswordTochange.setVisible(true);
    	
    	phontTxt.setText(null);
    	emailTxt.setText(null);
    }

    @FXML
    void updatePhoneFunc(ActionEvent event) 
    {
    	emailTxt.setVisible(false);
    	email.setVisible(false);
    	phontTxt.setVisible(true);
    	phone.setVisible(true);
    	oldPassTxt.setVisible(false);
    	newPass.setVisible(false);
    	newPassTxt.setVisible(false);
    	AssertPass.setVisible(false);
    	assertPassTxt.setVisible(false);
    	oldPasswordTochange.setVisible(false);
    	
    	emailTxt.setText(null);
    	newPassTxt.setText(null);
    	assertPassTxt.setText(null);
    	oldPassTxt.setText(null);
    }
    @FXML
    void exitFun(ActionEvent event) throws IOException 
    {
    	sigINController.LibrarianId=null;
    	sigINController.StudentId=null;
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
