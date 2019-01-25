package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentProfileController {
	 @FXML
	 private Button edit;

	 @FXML
	 private Button signUp;
	 
	 @FXML
	 private TableView<String> loanedBooks;

	    @FXML
	    private TableColumn<String, String> bookNamecol;

	    @FXML
	    private TableColumn<String, String> bookAuthorCol;

	    @FXML
	    private TableColumn<String, String> genreCol;

	    @FXML
	    private TableColumn<String, String> DescriptionCol;

	    @FXML
	    private TableColumn<String, String> PublisherCol;

	    @FXML
	    private TableColumn<String, String> PrintDateCol;

	    @FXML
	    private TableColumn<String, String> CopyNumberCol;

	    @FXML
	    private TableColumn<String, String> QuantityCol;
	    
	    @FXML
	    void showStudentInfo(ActionEvent event) throws IOException 
	    {
	    	IPController.backGui="StudentProfile";
	    	((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/StudentInfo.fxml").openStream());
	  		primaryStage.setTitle("Student Details");
	  		 String StudentID = sigINController.StudentId ;
    		 ArrayList<String> msg1 = new ArrayList<String>();
    	     ArrayList<String>  result1 = new ArrayList<String>();
    	     msg1.add(""+StudentID);
    	   
    	     msg1.add("StudentToEditByLibrarian");
    	     result1 = (ArrayList<String>)IPController.client.Request(msg1);
    	     
    	     StudentInfoController  studentInfo = loader.getController();	
			
    	     studentInfo.loadStudentInfo(result1);
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	    }
	  @FXML
	 void ExtendLoanDuration(ActionEvent event) throws IOException 
	 {
		  IPController.backGui="StudentProfile";
		  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/ExternLoanBook.fxml").openStream());
	  		primaryStage.setTitle("Extern Loan Book");
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	 }

	 @FXML
	void LoanBook(ActionEvent event) throws IOException 
	 {
		 IPController.backGui="StudentProfile";
		 ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/loanBook.fxml").openStream());
	  		primaryStage.setTitle("Loan Book");
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	 }

	  @FXML
	 void searchBook(ActionEvent event) throws IOException
	  {
		  IPController.backGui="StudentProfile";
		  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/SearchBook.fxml").openStream());
	  		primaryStage.setTitle("Search Book");
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	  }
    @FXML
    void editFunc(ActionEvent event)throws IOException
    {
    	IPController.backGui="StudentProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/editStudentProfile.fxml").openStream());
		primaryStage.setTitle("Edit Student Profile");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }
    @FXML
    void signUpFunc(ActionEvent event) throws IOException
    {
    	sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
    	sigINController.ManagementId =null ;
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
		primaryStage.setTitle("Sign-IN");
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void show(ActionEvent event) 
    {

    }
}