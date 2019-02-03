package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Student information controller
 *
 */
public class StudentInfoController 
{
	static private String back =IPController.backGui;
   @FXML
    private Text studentID;

    @FXML
    private Text studentName;

    @FXML
    private Text email;

    @FXML
    private Text phoneNumbet;

    @FXML
    private Text pass;

    @FXML
    private Text cardStatus;
    /**
     * load student information
     * @param result
     */
    public void loadStudentInfo(ArrayList<String> result)
    {
    	studentID.setText(result.get(0));
    	studentName.setText(result.get(1));
    	email.setText(result.get(2));
    	phoneNumbet.setText(result.get(3));
    	pass.setText(result.get(5));
    	cardStatus.setText(result.get(4));
    	
    }
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void back(ActionEvent event) throws IOException 
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
     * Editing profile Button handler
     * @param event
     * @throws IOException
     */
    void editProfile(ActionEvent event) throws IOException 
    {
    	//IPController.backGui="StudentInfo";
  		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/editStudentProfile.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Edit Student Profile");
			stage.setScene(new Scene(root));
			stage.show();
  		
    }

    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void logout(ActionEvent event) throws IOException
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

}