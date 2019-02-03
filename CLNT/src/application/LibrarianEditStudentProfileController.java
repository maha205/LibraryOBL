package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * Edit student profile controller by the librarian
 *
 */
public class LibrarianEditStudentProfileController
{
    static public String back = IPController.backGui ;
    @FXML
    private Text StudentIDTxt;

    @FXML
    private Text StudentNameTxt;

    @FXML
    private Text emailTxt;

    @FXML
    private Text phoneNumberTxt;

    @FXML
    private Text ID;

    @FXML
    private Text Name;

    @FXML
    private Text Email;

    @FXML
    private Text phone;

    @FXML
    private Text passTxt;

    @FXML
    private Text pass;

    @FXML
    private Button editProfile;

    @FXML
    private TextField id;
    

    @FXML
    private Text statusCard;
    
    @FXML
    private Text CardTxt;
    
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void backGui(ActionEvent event) throws IOException
    {
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/"+back+".fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }

    @FXML
    /**
     * Ediring the user profile handler
     * @param event
     * @throws IOException
     */
    void editProfileFunc(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianEditStudentProfile";
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/editStudentProfile.fxml"));
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
     * Show student data button handler
     * @param event
     */
    void showStudentData(ActionEvent event) 
    {
     ArrayList<String> msg = new ArrayList<String>();
     ArrayList<String>  result = new ArrayList<String>();
     msg.add(id.getText());
     msg.add("StudentToEditByLibrarian");
     result = (ArrayList<String>)IPController.client.Request(msg);
     System.out.println(result);
      if(result.size() >0)
       {
    	  sigINController.StudentId =id.getText();
          StudentIDTxt.setVisible(true);
          StudentNameTxt.setVisible(true);
         emailTxt.setVisible(true);
         phoneNumberTxt.setVisible(true);
         ID.setVisible(true);
         Name.setVisible(true);
          Email.setVisible(true);
          phone.setVisible(true);
         passTxt.setVisible(true);
          pass.setVisible(true);
         editProfile.setVisible(true);
         statusCard.setVisible(true);
         CardTxt.setVisible(true);
         
         ID.setText(result.get(0));
         Name.setText(result.get(1));
         Email.setText(result.get(2));
         phone.setText(result.get(3));
         pass.setText(result.get(5));
         statusCard.setText(result.get(4));
       }
      
      else {
    	  StudentIDTxt.setVisible(false);
          StudentNameTxt.setVisible(false);
         emailTxt.setVisible(false);
         phoneNumberTxt.setVisible(false);
         ID.setVisible(false);
         Name.setVisible(false);
          Email.setVisible(false);
          phone.setVisible(false);
         passTxt.setVisible(false);
          pass.setVisible(false);
         editProfile.setVisible(false);
         statusCard.setVisible(false);
         CardTxt.setVisible(false);
      }
    }

}