package application;

import java.awt.Button;
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
import javafx.scene.Parent;
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
/**
 * 
 * Extern Loan book controller
 *
 */
public class ExternLoanBookController implements Runnable
{
	public static String Bookid  = null;
	public static String newDate = null ,oldDate = null ,nameBook =null;
	public static String Copyid  = null;
	public static int flag  = 0;
	public static int flagNoBook  = 1;
	
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
    /**
     * Back button handle
     * @param event
     * @throws IOException
     */
    void BackGui(ActionEvent event) throws IOException 
    {
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
     * Checking book to extending 
     * @param event
     */
    void checkBookToExtend(ActionEvent event)
    {
         //STEP 1: Get relevant data from Server + Put it in ArrayList
        //STEP 2: Create Columns and add data to TableView
    	flag =1 ;
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(sigINController.StudentId);
        msg.add("CheckitemLoan");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	
    	if(result.size()<=0) {
    		JOptionPane.showMessageDialog(null, "There are no books to extend !!");
    		flagNoBook=0;
    	}

    	
    	
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
    /**
     * Selected item with the mouse
     * @param event
     */
    void SelectedItem(MouseEvent event) {
     itemInLoan s = extendTable.getSelectionModel().getSelectedItem();
    //	System.out.println(s.getBookID());
    	Bookid = s.getBookID() ;
    	Copyid=s.getCopyID();
    }
    @FXML
    /**
     * Extend loan button handler
     * @param event
     */
    void ExtendLoan(ActionEvent event) 
    {
        Thread t = new Thread(this); 
        if(flag==0) 
        	JOptionPane.showMessageDialog(null, "Please press Check book to extend and after this select book from the table to extend!!");
        if(flagNoBook==0)
        	JOptionPane.showMessageDialog(null, "There are no books to extend !!");
        
        if(flagNoBook==1 && flag==1) {	
    	  
    		  if(Bookid ==null || Copyid==null )
    		     JOptionPane.showMessageDialog(null, "Please select book from the table to extend !!");
    		  else {
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
        	JOptionPane.showMessageDialog(null, "Extend successful , Extend this for for 7 days extra");
        	ArrayList<String> msg2 = new ArrayList<String>();
            ArrayList<String>  result2 = new ArrayList<String>();
            msg2.add(sigINController.StudentId);
            msg2.add("CheckitemLoan");
        	result2 = (ArrayList<String>)IPController.client.Request(msg2);
        	System.out.println(result2);
       	
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
            
            for (int i = 0; i < result2.size(); i += 6) {
             data.add(new itemInLoan(result2.get(i),result2.get(i+5), result2.get(i + 1), result2.get(i + 2), result2.get(i + 3),result2.get(i + 4)));
            }
            
            
            StudentID.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("StudentID"));
            
            BookID.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("BookID"));

            CopyID.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("CopyID"));

            loanDate.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("loanDate"));
            
            returnDate.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("returnDate"));
            
            bookName.setCellValueFactory(new PropertyValueFactory<itemInLoan,String>("BookName"));
            
             extendTable.setItems(data);
             
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
        	
        	t.start();
            }
        else
        	JOptionPane.showMessageDialog(null, "Extend cannot be completed !!");
        	
    		  }
    	}
         
    }
  

    @FXML
    /**
     * Exit button handler
     * @param event
     * @throws IOException
     */
    void exitGui(ActionEvent event) throws IOException 
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
	@Override
	/**
	 * run method
	 */
	public void run() {
		// TODO Auto-generated method stub
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

}