
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
 * 
 * Management Info Controller 
 *
 */
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
    /**
     * load Student Information
     * @param result
     */
    public void loadStudentInfo(ArrayList<String> result)
    {
    	ManagementID.setText(result.get(0));
    	ManagementName.setText(result.get(1));
    	ManagementPhone.setText(result.get(2));
    	ManagementEmail.setText(result.get(3));
    }
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
			stage.setTitle("Manager Profile");
			stage.setScene(new Scene(root));
			stage.show();
  		
    }

    @FXML
    /**
     * edit profile button handler
     * @param event
     * @throws IOException
     */
    void editProfile(ActionEvent event) throws IOException 
    {
    	//IPController.backGui="ManagementInfo";
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ManagementEdit.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Edit Management Profile");
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