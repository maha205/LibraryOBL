package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.Librarian;
import TableView.itemInLoan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * Manual Extension Controller
 *
 */
public class ManualExtensionController {
	
	public static String Bookid  = null;
	public static String Copyid  = null;
    @FXML
    private TextField userID;
    @FXML
    private Text libraryName; //The extension was performed by the librarian:
    @FXML
    private TableView<itemInLoan> extendTable;
   
    @FXML
    void back(ActionEvent event) throws IOException {
    	
  		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/"+IPController.backGui+".fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }

    
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void logout(ActionEvent event) throws IOException {
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
     * Extend loan Button handler
     * @param event
     */
    void ExtendLoan(ActionEvent event) {

    	if(Bookid ==null ||userID.getText().equals(""))
    		JOptionPane.showMessageDialog(null, "Please select book to extend !!");
    	else {
    	String newDate = null ,oldDate = null ,nameBook =null;
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(userID.getText());
        msg.add(Bookid);
        msg.add(Copyid);
        msg.add("ExtendLoan");
        result = (ArrayList<String>)IPController.client.Request(msg);
        System.out.println(result);
        if(result.size() >0) {
    	  JOptionPane.showMessageDialog(null, "Extend successful");
    	  ArrayList<String> msg1 = new ArrayList<String>();
    	  ArrayList<Librarian>  result1 = new ArrayList<Librarian>();
		     msg1.add("AllLibrarianWorker");
		     result1=new ArrayList<Librarian>();
		     result1 = (ArrayList<Librarian>)IPController.client.Request(msg1);
		     if(result1.size()>0) {
		    	// libraryName.setText(result1.get(0));; //The extension was performed by the librarian:
		    	 for(int j=0;j<result1.size();j++)
		         {
		      	   if(result1.get(j).getLibrarianID().equals(sigINController.LibrarianId)) {
		      		 libraryName.setText("The extension was performed by the librarian: "+result1.get(j).getLibrarianName());
		      	   
		      	   ArrayList<String> msg5 = new ArrayList<String>();
		      	   String result5 = null ;
		      	  //LibrarianExtern
		      	    msg5.add(result1.get(j).getLibrarianName());
		      	    msg5.add(userID.getText());
		      	    msg5.add(Bookid) ;
		      	    msg5.add(Copyid);
		      	    msg5.add("LibrarianExtern");
		      	    
		            result5 = (String)IPController.client.Request(msg5);
		            System.out.println(result5);
   }
		      			 
		        }
		    	 
             }
        }
        else
          JOptionPane.showMessageDialog(null, "Extend cannot be completed!!");
        } 
    }

    @FXML
    /**
     * Selecting the wanted item using the mouse
     * @param event
     */
    void SelectedItem(MouseEvent event) {
    	 itemInLoan s = extendTable.getSelectionModel().getSelectedItem();
     	//System.out.println(s.getBookID());
    	 Copyid=s.getCopyID();
     	Bookid = s.getBookID() ;
    }

    @FXML
    /**
     * Check Book foe extending Button handler
     * @param event
     */
    void checkBookToExtend(ActionEvent event) {

        //STEP 1: Get relevant data from Server + Put it in ArrayList
       //STEP 2: Create Columns and add data to TableView
   	if(userID.getText().equals(""))   
        JOptionPane.showMessageDialog(null, "Please Enter Subscriber ID !!");
   	else {
   	ArrayList<String> msg = new ArrayList<String>();
       ArrayList<String>  result = new ArrayList<String>();
       msg.add(userID.getText());
       msg.add("CheckitemLoan");
   	result = (ArrayList<String>)IPController.client.Request(msg);
   	System.out.println(result);
   	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
   	TableColumn StudentID = new TableColumn("Subscriber ID");
   	StudentID.setMinWidth(200);
   	TableColumn bookName = new TableColumn("Book Name"); 
       bookName.setMinWidth(200);
       TableColumn BookID = new TableColumn("Book ID");
       BookID.setMinWidth(200);
       TableColumn CopyID  = new TableColumn("Copy ID");
       CopyID.setMinWidth(200);
       TableColumn loanDate = new TableColumn("Lend Date"); 
       loanDate.setMinWidth(200);
        TableColumn returnDate = new TableColumn("Return Date"); 
        returnDate.setMinWidth(200);
        
        extendTable.getColumns().addAll(StudentID,bookName, BookID, CopyID , loanDate,returnDate );
       
   
       final ObservableList<itemInLoan> data = FXCollections.observableArrayList();
       
       for (int i = 0; i < result.size(); i += 6) {
        data.add(new itemInLoan(result.get(i),result.get(i+5), result.get(i + 1), result.get(i + 2), result.get(i + 3),result.get(i + 4)));
       }
       
       
       StudentID.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("StudentID"));
       
       BookID.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("BookID"));

       CopyID.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("CopyID"));

       loanDate.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("loanDate"));
       
       returnDate.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("returnDate"));
       
       bookName.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("BookName"));
       
        extendTable.setItems(data);
    }
    }

}