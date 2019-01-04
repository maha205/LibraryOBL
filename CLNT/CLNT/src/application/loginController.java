package application;


import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class loginController {
    @FXML
    private Button login;
    
    @FXML
    private TextField userID;

    @FXML
    private TextField pass;
  
    @FXML
    private Button back;
    
    @FXML
    void loginFunc(ActionEvent event) throws IOException
    {
    	String UserID = userID.getText();
    	String UserPass = pass.getText();
        ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(UserID);
    	msg.add(UserPass);
    	msg.add("login");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	if(result.size() > 0)
     	{
    		((Node)event.getSource()).getScene().getWindow().hide();
    		Stage primaryStage = new Stage();
    		FXMLLoader loader = new FXMLLoader();
    		Pane root = loader.load(getClass().getResource("/application/Sample.fxml").openStream());
    		
    		Scene scene = new Scene(root);			
    		
    		primaryStage.setScene(scene);		
    		primaryStage.show();
     	}
    }

    @FXML
    void backGui(ActionEvent event) throws IOException{
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/IP.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }


}

