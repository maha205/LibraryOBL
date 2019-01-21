package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StudentInfoController 
{
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
    void back(ActionEvent event) throws IOException 
    {

		 editStudentProfileController.editStudentBack = "StudentInfo";
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/StudentProfile.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void editProfile(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/editStudentProfile.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

}