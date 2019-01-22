package application;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Librarian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ManagementProfileController
{
    @FXML
    void LibrarianDetails(ActionEvent event) throws IOException 
    {
    	IPController.backGui="ManagementProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/LibraryWorkers.fxml").openStream());
		
		 ArrayList<String> msg1 = new ArrayList<String>();
	     ArrayList<Librarian>  result1 = new ArrayList<Librarian>();
	     msg1.add("AllLibrarianWorker");
	     result1 = (ArrayList<Librarian>)IPController.client.Request(msg1);
	     
	     LibraryWorkersController LibraryWorkers = loader.getController();	
	     LibraryWorkers.loadLibraryWorkers(result1);
  		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void StudentDetails(ActionEvent event) 
    {
    	IPController.backGui=" ManagementProfile";
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
