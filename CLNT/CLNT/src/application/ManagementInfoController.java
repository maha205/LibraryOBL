
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

public class ManagementInfoController 
{
	static private String back =IPController.backGui;
    @FXML
    private Text ManagementName;

    @FXML
    private Text ManagementID;

    @FXML
    private Text ManagementPhone;

    @FXML
    private Text ManagementEmail;
    
    public void loadStudentInfo(ArrayList<String> result)
    {
    	ManagementID.setText(result.get(0));
    	ManagementName.setText(result.get(1));
    	ManagementPhone.setText(result.get(2));
    	ManagementEmail.setText(result.get(3));
    }
    @FXML
    void backGui(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/"+back+".fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void editProfile(ActionEvent event) throws IOException 
    {
    	//IPController.backGui="ManagementInfo";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/ManagementEdit.fxml").openStream());
		primaryStage.setTitle("Edit Management Profile");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException 
    {

    	sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
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