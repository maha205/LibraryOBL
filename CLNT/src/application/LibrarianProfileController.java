package application;


import java.io.IOException;
import java.util.ArrayList;

import Entity.Librarian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * 
 * Librarian Profile Controller
 *
 */
public class LibrarianProfileController 
{
	static private ArrayList<Librarian>  result1 ;
  @FXML
    private Button editBtn;


  @FXML
  private Button RECEIVEDButton;
  
    @FXML
    private Button logout;
    
    @FXML
    /**
     * Extend Loan Duration button handler
     * @param event
     * @throws IOException
     */
    void ExtendLoanDuration(ActionEvent event) throws IOException {
    	IPController.backGui="LibrarianProfile";
    	
	  		((Node)event.getSource()).getScene().getWindow().hide();
  			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ManualExtension.fxml"));
  			Parent root = (Parent) fxmlLoader.load();
  			Stage stage = new Stage();
  			stage.setResizable(false);
  			stage.setScene(new Scene(root));
  			stage.show();
	  		
    }

    @FXML
    /**
     * Librarian info button handler 
     * @param event
     * @throws IOException
     */
    void LibrarianInfo(ActionEvent event) throws IOException {
    	IPController.backGui="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/LibrarianInfo.fxml").openStream());
	  		
	  		ArrayList<String> msg1 = new ArrayList<String>();
		     msg1.add("AllLibrarianWorker");
		     result1=new ArrayList<Librarian>();
		     result1 = (ArrayList<Librarian>)IPController.client.Request(msg1);
		     
		     
		     LibrarianInfoController LibraryInfo = loader.getController();	
		     LibraryInfo.loadLibraryInfo(result1);
	  		
	  		primaryStage.setTitle("Loan Book");
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }

    @FXML
    /**
     * Loan book button handler
     * @param event
     * @throws IOException
     */
    void LoanBook(ActionEvent event) throws IOException {
    	IPController.backGui="LibrarianProfile";
	  		((Node)event.getSource()).getScene().getWindow().hide();
  			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/loanBook.fxml"));
  			Parent root = (Parent) fxmlLoader.load();
  			Stage stage = new Stage();
  			stage.setResizable(false);
  			stage.setScene(new Scene(root));
  			stage.show();
    }
    @FXML
    /**
     * Searching book button handler
     * @param event
     * @throws IOException
     */
    void searchBook(ActionEvent event) throws IOException {
    	IPController.backGui="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/SearchBook.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    	
    	
    }
    @FXML
    /**
     *  removing book button handler
     */
    void RemoveBook(ActionEvent event) throws IOException
    {
    	IPController.backGui ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/deleteBook.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setScene(new Scene(root));
		stage.show();
    }

    @FXML
    /**
     * Updating book button handler
     * @param event
     * @throws IOException
     */
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
	/**
	 * Adding book button handler
	 * @param event
	 * @throws IOException
	 */

    void addBook(ActionEvent event) throws IOException
    {
    	IPController.backGui="LibrarianProfile";
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/AddBook.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		
    }
    
    @FXML
    /**
     * Returning book button handler
     * @param event
     * @throws IOException
     */
    void returning(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/returnBook.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Return Book");
			stage.setScene(new Scene(root));
			stage.show();
    }
    @FXML
    /**
     * Edit student profile button handler
     * @param event
     * @throws IOException
     */
    void editStudentProfile(ActionEvent event) throws IOException
    {
    	IPController.backGui ="LibrarianProfile";
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/LibrarianEditStudentProfile.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Edit Librarian Profile");
			stage.setScene(new Scene(root));
			stage.show();
    }
    @FXML
    /**
     * open new subscription button handler
     * @param event
     * @throws IOException
     */
    void OpenNewSubscription(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/singUp.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Sign-Up");
			stage.setScene(new Scene(root));
			stage.show();
    }

    @FXML
    /**
     * Updating student card button handler
     * @param event
     * @throws IOException
     */
    void UpdateStudentdCard(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/UpdateStudentStatus.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Update Student Status");
			stage.setScene(new Scene(root));
			stage.show();
		
    }

    @FXML
    /**
     * Edit button handler
     * @param event
     * @throws IOException
     */
    void editFunc(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
    	
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/LibrarianEditProfile.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Edit Librarian Profile");
			stage.setScene(new Scene(root));
			stage.show();
    }

    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void logoutFunc(ActionEvent event) throws IOException 
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

    @FXML
    /**
     * Received Books Page button handler
     * @param event
     * @throws IOException
     */
    void ReceivedBooksPage(ActionEvent event) throws IOException {
    	sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
    	sigINController.ManagementId =null ;
    	
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ReceivedBookOrders.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
		
    }
}