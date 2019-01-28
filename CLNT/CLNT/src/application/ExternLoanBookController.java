package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.scene.input.MouseEvent;

import TableView.Student;
import TableView.itemInLoan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExternLoanBookController
{
	public static String Bookid  = null;
	public static String Copyid  = null;
	public EmailMsg email ;
	@FXML
	private Text dayMsg;   
	 @FXML
    private Text dateReturn;
    @FXML
    private Text succesful;
    @FXML
    private TextField bookID;
    @FXML
    private Text errorMsg;
    @FXML
    private TableView<itemInLoan> extendTable;
    
    @FXML
    void BackGui(ActionEvent event) throws IOException 
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
    void checkBookToExtend(ActionEvent event)
    {
         //STEP 1: Get relevant data from Server + Put it in ArrayList
        //STEP 2: Create Columns and add data to TableView
    	
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(sigINController.StudentId);
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

    @FXML
    void SelectedItem(MouseEvent event) {
     itemInLoan s = extendTable.getSelectionModel().getSelectedItem();
    //	System.out.println(s.getBookID());
    	Bookid = s.getBookID() ;
    	Copyid=s.getCopyID();
    }
    @FXML
    void ExtendLoan(ActionEvent event) 
    {
    	if(Bookid ==null)
    		JOptionPane.showMessageDialog(null, "Please select book to extend !!");
    	else {
    	String newDate = null ,oldDate = null ,nameBook =null;
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(sigINController.StudentId);
        msg.add(Bookid);
        msg.add(Copyid);
        msg.add("ExtendLoan");
        result = (ArrayList<String>)IPController.client.Request(msg);
        System.out.println(result);
        if(result.size() >0)
        {
        	JOptionPane.showMessageDialog(null, "Extend successful");
        	if(sigINController.StudentId!=null) {
        		ArrayList<String> msg1 = new ArrayList<String>();
                ArrayList<String>  result1 = new ArrayList<String>();
                msg1.add(sigINController.StudentId);
                msg1.add("Extern Book");
                msg1.add("UserAction");
                result1 = (ArrayList<String>)IPController.client.Request(msg1);
        	}
        	newDate=result.get(0) ;
        	oldDate = result.get(1);
        	nameBook=result.get(2);
        	dateReturn.setText(result.get(0));
        	
        	ArrayList<String> msg1 = new ArrayList<String>();
            ArrayList<String>  result1 = new ArrayList<String>();
            msg1.add("LibrarianEmail");
            result1 = (ArrayList<String>)IPController.client.Request(msg1);
            System.out.println(result1);
            if(result1.size()>0)
            {
            	for(int i=0;i<result1.size();i+=2)
            	{
        	     email = new EmailMsg();
        	     email.Too =result1.get(i);
        	     System.out.println(result1.get(i));
        	     email.TextBody ="Hello "+result1.get(i+1)+" ,\r\n" + 
        			"\r\n" + 
        			"Please note that student: \r\n" + 
        			"ID : "+sigINController.StudentId+" \r\n" + 
        			"Extended his loan duration for the following book:\r\n" + 
        			"Book Name : "+nameBook+" \r\n" + 
        			"Book ID : "+Bookid+"\r\n" + 
        			"Old return Date : "+oldDate+"\r\n" + 
        			"\r\n" + 
        			"New return date is: "+newDate+"\r\n" + 
        			"\r\n" + 
        			"Thank you,\r\n" + 
        			"ORT Braude Library";
        	    email.SendAction();
            	}
           }
        	
        }
        else
        {
        	JOptionPane.showMessageDialog(null, "Extend cannot be completed!!");
        	
        }
    	}
    }
  

    @FXML
    void exitGui(ActionEvent event) throws IOException 
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