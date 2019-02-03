package application;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Sign in controller
 
 *
 */
public class sigINController implements Initializable {
	
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
    /**
     * Forget password Button handler
     * @param event
     * @throws IOException
     */
    void forgetPass(ActionEvent event) throws IOException 
    {
    /*	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/ResetPasswordRequest.fxml").openStream());
		primaryStage.setTitle("Reset Password");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show(); */
    	((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ResetPasswordRequest.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Reset Password");
			stage.setScene(new Scene(root));
			stage.show();
    }
    
    @FXML
    /**
     * Login Button handler
     * @param event
     * @throws IOException
     */
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
    		  if(result.size()==1) {
        		  NotFound.setVisible(false);
        		  StudentId=userID.getText();
   
      			((Node)event.getSource()).getScene().getWindow().hide();
      			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/StudentProfile.fxml"));
      			Parent root = (Parent) fxmlLoader.load();
      			Stage stage = new Stage();
      			stage.setResizable(false);
      			stage.setTitle("Student Profile");
      			stage.setScene(new Scene(root));
      			stage.show();
    		  }
    		  else JOptionPane.showMessageDialog(null, "Your account is locked !!");
    		
    	   }
    	  
    	   if(result.get(0).equals("librarian"))
    	   {
    		  NotFound.setVisible(false);
    		  LibrarianId=userID.getText();
             System.out.println(" aaaaaaaa LibrarianId");
             System.out.println(LibrarianId);
    		  
    			((Node)event.getSource()).getScene().getWindow().hide();
      			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/LibrarianProfile.fxml"));
      			Parent root = (Parent) fxmlLoader.load();
      			Stage stage = new Stage();
      			stage.setResizable(false);
      			stage.setTitle("Librarian Profile");
      			stage.setScene(new Scene(root));
      			stage.show();
    		}
    	   if(result.get(0).equals("management"))
    	   {
    		  NotFound.setVisible(false);
    		  ManagementId=userID.getText();
   
    		  
    			((Node)event.getSource()).getScene().getWindow().hide();
      			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ManagementProfile.fxml"));
      			Parent root = (Parent) fxmlLoader.load();
      			Stage stage = new Stage();
      			stage.setResizable(false);
      			stage.setTitle("Manager Profile");
      			stage.setScene(new Scene(root));
      			stage.show();
    		}
    	}
    	else
    		NotFound.setVisible(true);

    		
    }

    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void backGui(ActionEvent event) throws IOException{

    	
    	((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/mainForm.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Main");
			stage.setScene(new Scene(root));
			stage.show();
    }
    
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void exitGui(ActionEvent event) throws IOException
    {
    	sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
    	sigINController.ManagementId =null ;

    	((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/IP.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Connect");
			stage.setScene(new Scene(root));
			stage.show();
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
    


}

