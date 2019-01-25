package application;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Librarian;
import Entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ManagementProfileController
{
	static private ArrayList<Librarian>  result1 ;
	static private ArrayList<Student>  result2 ;

    @FXML
    void editProfile(ActionEvent event) throws IOException
    {
    	IPController.backGui="ManagementProfile";
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
    void ManagementInfo(ActionEvent event) throws IOException 
    {
    	IPController.backGui="ManagementProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/ManagementInfo.fxml").openStream());
		primaryStage.setTitle("Management Details");
		String ManagementID = sigINController.ManagementId ;
		 ArrayList<String> msg1 = new ArrayList<String>();
	     ArrayList<String>  result1 = new ArrayList<String>();
	     msg1.add(ManagementID);
	   
	     msg1.add("ManagementInfo");
	     result1 = (ArrayList<String>)IPController.client.Request(msg1);
	     
	     ManagementInfoController   ManagementInfo = loader.getController();	
		
	     ManagementInfo.loadStudentInfo(result1);
	     
		 Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
    
    @FXML
    void LibrarianDetails(ActionEvent event) throws IOException 
    {
    	IPController.backGui="ManagementProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/LibraryWorkers.fxml").openStream());
		primaryStage.setTitle("Librarian Details");
		 ArrayList<String> msg1 = new ArrayList<String>();
	     msg1.add("AllLibrarianWorker");
	     result1=new ArrayList<Librarian>();
	     result1 = (ArrayList<Librarian>)IPController.client.Request(msg1);
	     
	     LibraryWorkersController LibraryWorkers = loader.getController();	
	     LibraryWorkers.loadLibraryWorkers(result1);
  		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void StudentDetails(ActionEvent event) throws IOException 
    {

    	IPController.backGui="ManagementProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/LibrarySubscriptions.fxml").openStream());
		primaryStage.setTitle("Subscription Details");
		 ArrayList<String> msg1 = new ArrayList<String>();
	     msg1.add("AllStudents");
	     result2=new ArrayList<Student>();
	     result2 = (ArrayList<Student>)IPController.client.Request(msg1);
	     
	     LibrarySubscriptionsController LibraryStudents = loader.getController();	
	     LibraryStudents.loadLibraryStudents(result2);
  		
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
