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

public class LibrarianEditProfileController 
{
    @FXML
    private Button upEmailBtn;

    @FXML
    private Button upPhone;

    @FXML
    private Button upPass;

    @FXML
    private Text email;

    @FXML
    private Text phone;

    @FXML
    private Text oldPasswordTochange;

    @FXML
    private Text newPass;

    @FXML
    private Text AssertPass;

    @FXML
    private TextField emailTxt;

    @FXML
    private TextField phontTxt;

    @FXML
    private TextField oldPassTxt;

    @FXML
    private TextField newPassTxt;

    @FXML
    private TextField assertPassTxt;

    @FXML
    private Button saveBtn;

    @FXML
    private Button backBtn;

    @FXML
    private Button exitBtn;

    @FXML
    void backFunc(ActionEvent event) throws IOException
    {

    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/LibrarianProfile.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void exitFun(ActionEvent event) throws IOException
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/login.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void saveFunc(ActionEvent event)
    {
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        try{
        	if(!(emailTxt.getText().equals(null)))
        	{
        		msg.add(sigINController.LibrarianId);
        		msg.add(emailTxt.getText());
        		msg.add("UpdateEmailLibrarian");
        		result = (ArrayList<String>)IPController.client.Request(msg);
            	System.out.println(result);
        	}
        	
        }catch( NullPointerException  e) {e.printStackTrace();  }
    	
    	
       try{
           if(!(phontTxt.getText().equals(null)))    	
    	   {
    	   	msg.add(sigINController.LibrarianId);
    		msg.add(phontTxt.getText());
    		msg.add("UpdatephontLibrariant");
    		result = (ArrayList<String>)IPController.client.Request(msg);
    	    System.out.println(result);
    	   }
       }catch( NullPointerException  e) {e.printStackTrace();  }
    		
     try{
    	if(!(oldPassTxt.getText().equals(null)) && !(newPassTxt.getText().equals(null)) && !(assertPassTxt.getText().equals(null)) )
    	{
    		
    		msg.add(sigINController.LibrarianId);
    		msg.add(oldPassTxt.getText());
    		msg.add(newPassTxt.getText());
    		msg.add(assertPassTxt.getText());
    		msg.add("UpdatePasswordLibrarian");
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

}
