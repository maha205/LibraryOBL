package application;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class sigINController {
	
	public static String StudentId =null ;
	public static String LibrarianId =null ;
	public static String ManagementId =null ;
	
    @FXML
    private TextField userID;

    @FXML
    private TextField pass;
  
    @FXML
    private Button back;
    
    @FXML
    private Text NotFound;
    
    @FXML
    void forgetPass(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/ResetPasswordRequest.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
    
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
    	if(result.size() >0) 
    	{
    	  if(result.get(0).equals("student"))
    	  {
    		  NotFound.setVisible(false);
    		  StudentId=userID.getText();
    		((Node)event.getSource()).getScene().getWindow().hide();
    		Stage primaryStage = new Stage();
    		FXMLLoader loader = new FXMLLoader();
    		Pane root = loader.load(getClass().getResource("/application/StudentProfile.fxml").openStream());
    		
    		Scene scene = new Scene(root);			
    		
    		primaryStage.setScene(scene);		
    		primaryStage.show();
    	   }
    	  
    	   if(result.get(0).equals("librarian"))
    	   {
    		  NotFound.setVisible(false);
    		  LibrarianId=userID.getText();
    		 ((Node)event.getSource()).getScene().getWindow().hide();
        	  Stage primaryStage = new Stage();
        	  FXMLLoader loader = new FXMLLoader();
        	  Pane root = loader.load(getClass().getResource("/application/LibrarianProfile.fxml").openStream());
        		
        	  Scene scene = new Scene(root);			
        		
        	  primaryStage.setScene(scene);		
        	  primaryStage.show();
    		}
    	   if(result.get(0).equals("management"))
    	   {
    		  NotFound.setVisible(false);
    		  ManagementId=userID.getText();
    		 ((Node)event.getSource()).getScene().getWindow().hide();
        	  Stage primaryStage = new Stage();
        	  FXMLLoader loader = new FXMLLoader();
        	  Pane root = loader.load(getClass().getResource("/application/ManagementProfile.fxml").openStream());
        		
        	  Scene scene = new Scene(root);			
        		
        	  primaryStage.setScene(scene);		
        	  primaryStage.show();
    		}
    	   
    	}
    	else
    	{
    		NotFound.setVisible(true);
//    		Alert alert = new Alert(AlertType.ERROR);
//    		alert.setTitle("Error Dialog");
//    		alert.setHeaderText("Look, an Error Dialog");
//    		alert.setContentText("Ooops, there was an error please check your input!");
//    		alert.showAndWait();
    	}
    		
    }

    @FXML
    void backGui(ActionEvent event) throws IOException{
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/mainForm.fxml").openStream());
		
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
		Pane root = loader.load(getClass().getResource("/application/IP.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
    


}

