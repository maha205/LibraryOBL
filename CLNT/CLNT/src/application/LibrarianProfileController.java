package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LibrarianProfileController 
{
  @FXML
    private Button editBtn;

    @FXML
    private Button logout;

    @FXML
    void RemoveBook(ActionEvent event) throws IOException
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/deleteBook.fxml").openStream());
		primaryStage.setTitle("Delete Book");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void UpdateBook(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/UpdateBook.fxml").openStream());
		primaryStage.setTitle("Update Book");
		UpdateBookController updateBook =loader.getController();	
		updateBook.loadComboList();
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
    
    @FXML
    void addBook(ActionEvent event) throws IOException
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/AddBook.fxml").openStream());
		primaryStage.setTitle("Add Book");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
    
    @FXML
    void returning(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/returnBook.fxml").openStream());
		primaryStage.setTitle("Return Book");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
    @FXML
    void editStudentProfile(ActionEvent event) throws IOException
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/LibrarianEditStudentProfile.fxml").openStream());
		primaryStage.setTitle("Edit Librarian Profile");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
    @FXML
    void OpenNewSubscription(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/singUp.fxml").openStream());
		primaryStage.setTitle("Sign-Up");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void UpdateStudentdCard(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/UpdateStudentStatus.fxml").openStream());
		primaryStage.setTitle("Update Student Status");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void editFunc(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/LibrarianEditProfile.fxml").openStream());
		primaryStage.setTitle("Edit Librarian Profile");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void logoutFunc(ActionEvent event) throws IOException 
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