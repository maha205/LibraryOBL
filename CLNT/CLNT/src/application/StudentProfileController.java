package application;

import java.io.IOException;
import java.util.ArrayList;

import TableView.itemInLoan;
import TableView.subscriberActions;
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
	 private TableView<subscriberActions> loanedBooks;

	  @FXML
	  void historyShow(ActionEvent event) {
// subscriberActions
		  //STEP 1: Get relevant data from Server + Put it in ArrayList
        //STEP 2: Create Columns and add data to TableView
    	
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(sigINController.StudentId);
        msg.add("historyAction");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	TableColumn SubscriberID = new TableColumn("Subscriber ID");
    	SubscriberID.setMinWidth(200);
    	TableColumn date= new TableColumn("Date "); 
        date.setMinWidth(200);
        TableColumn Action = new TableColumn("Action");
        Action.setMinWidth(200);
         
         loanedBooks.getColumns().addAll(SubscriberID,date, Action);
        
    
        final ObservableList<subscriberActions> data = FXCollections.observableArrayList();
        
        for (int i = 0; i < result.size(); i += 3) {
         data.add(new subscriberActions(result.get(i),result.get(i+1), result.get(i + 2)));
        }
        
        
        SubscriberID.setCellValueFactory(new PropertyValueFactory<subscriberActions,String>("SubscriberID"));
        
        date.setCellValueFactory(new PropertyValueFactory<subscriberActions,String>("date"));

        Action.setCellValueFactory(new PropertyValueFactory<subscriberActions,String>("Action"));

         loanedBooks.setItems(data);
	  }
	    
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