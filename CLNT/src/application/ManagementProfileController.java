package application;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Librarian;
import Entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * 
 * Management Profile Controller
 *
 */
public class ManagementProfileController
{
	static private ArrayList<Librarian>  result1 ;
	static private ArrayList<Student>  result2 ;
   
	 @FXML
	 /**
	  * Return report button handler
	  * @param event
	  * @throws IOException
	  */
	   void returnReport(ActionEvent event) throws IOException {
		 IPController.backGui="ManagementProfile";
		  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/ReturnsReport.fxml").openStream());
	  		
	  		ReportActivityController.flag=0;
	  		primaryStage.setTitle("Report Activity Log");
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	    }
    @FXML
    /**
     * lending report button handler
     * @param event
     * @throws IOException
     */
    void lendingReport(ActionEvent event) throws IOException {
    	IPController.backGui="ManagementProfile";
		  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/LendingReport.fxml").openStream());
	  		
	  		ReportActivityController.flag=0;
	  		primaryStage.setTitle("Report Activity Log");
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }
    
	@FXML
	/**
	 * Activity report button handler
	 * @param event
	 * @throws IOException
	 */
    void ActivityReport(ActionEvent event) throws IOException {
    	IPController.backGui="ManagementProfile";
		  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/ReportActivity.fxml").openStream());
	  		
	  		ReportActivityController.flag=0;
	  		primaryStage.setTitle("Report Activity Log");
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }
    
	@FXML
	/**
	 * unlock card button handler
	 * @param event
	 * @throws IOException
	 */
    void unlockCard(ActionEvent event) throws IOException 
	{
		IPController.backGui="ManagementProfile";
		
	  		((Node)event.getSource()).getScene().getWindow().hide();
  			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/UnfreezeStudent.fxml"));
  			Parent root = (Parent) fxmlLoader.load();
  			Stage stage = new Stage();
  			stage.setResizable(false);
  			stage.setTitle("Search Book");
  			stage.setScene(new Scene(root));
  			stage.show();
	  		
    }
    
    @FXML
    /**
     * Lock card button handler
     * @param event
     * @throws IOException
     */
    void lockCard(ActionEvent event) throws IOException 
    {
    	IPController.backGui="ManagementProfile";
	  		((Node)event.getSource()).getScene().getWindow().hide();
  			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/FreezeStudent.fxml"));
  			Parent root = (Parent) fxmlLoader.load();
  			Stage stage = new Stage();
  			stage.setResizable(false);
  			stage.setTitle("Search Book");
  			stage.setScene(new Scene(root));
  			stage.show();
    }
    
    @FXML
    /**
     * searching book button handler
     * @param event
     * @throws IOException
     */
    void searchBook(ActionEvent event) throws IOException
    {
    	IPController.backGui="ManagementProfile";
    	
	  		((Node)event.getSource()).getScene().getWindow().hide();
  			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/SearchBook.fxml"));
  			Parent root = (Parent) fxmlLoader.load();
  			Stage stage = new Stage();
  			stage.setResizable(false);
  			stage.setTitle("Search Book");
  			stage.setScene(new Scene(root));
  			stage.show();
	  		
	  		
    }
    @FXML
    /**
     * Edit profile button handler
     * @param event
     * @throws IOException
     */
    void editProfile(ActionEvent event) throws IOException
    {
    	IPController.backGui="ManagementProfile";
		
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
     * Management information button handler
     * @param event
     * @throws IOException
     */
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
    /**
     * showing librarian details button handler
     * @param event
     * @throws IOException
     */	
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
    /**
     * student details button handler
     * @param event
     * @throws IOException
     */
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
