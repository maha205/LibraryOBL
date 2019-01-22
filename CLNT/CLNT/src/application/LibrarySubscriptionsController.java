package application;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class LibrarySubscriptionsController
{
	static private ArrayList<Student>  LibrarySubscriptions ;
	
	private Text SubscriptionID;

    @FXML
    private Text SubscriptionName;

    @FXML
    private Text SubscriptionStatus;

    @FXML
    private Text SubscriptionPhone;

    @FXML
    private Text SubscriptionEmail;

    @FXML
    private Text SubscriptionSerialNumber;

    @FXML
    private Text errorFound;

    public void loadLibraryStudents(ArrayList<Student> result1) 
    {
    	this.LibrarySubscriptions =result1;
    	errorFound.setVisible(false);
    	SubscriptionID.setText(result1.get(0).getStudentId());
    	SubscriptionName.setText(result1.get(0).getStudentName());
    	SubscriptionStatus.setText(result1.get(0).getStatusMembership());
    	SubscriptionPhone.setText(result1.get(0).getPhone());
    	SubscriptionEmail.setText(result1.get(0).getEmail());
    	SubscriptionSerialNumber.setText(""+result1.get(0).getSubscriptionNumber());
    }
    @FXML
    void back(ActionEvent event) throws IOException 
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
    void editStudentProfile(ActionEvent event)
    {

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

    @FXML
    void next(ActionEvent event) 
    {

    }

    @FXML
    void prv(ActionEvent event) 
    {

    }

}