package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * 
 * Receiving book orders controller
 *
 */
public class ReceivedBookOrdersController {
	public static String OrderID = "NO";
	public static String StudentID = "NO";
	public static String StudentEmail = "NO";
    @FXML
    private Button SHOWRECEIVEDButton;

    @FXML
    private TableView<OrdersForTable> Table;

    @FXML
    private Button BACKButton;

    @FXML
    private Button LOANButton;
    
    
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void BackFunc(ActionEvent event) throws IOException {
    	
  		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/LibrarianProfile.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
			
    }
    
    @FXML
    /**
     * Loan Button handler
     * @param event
     */
    void LoanFunc(ActionEvent event) {
    	System.out.println("One");
    	if(OrderID != "NO") {
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(OrderID);
        msg.add("LoanFromReceivedOrder");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	//result.clear();
    	//msg.clear();
    	System.out.println("One");
    	
    	JOptionPane.showMessageDialog(null, "Thank you! You successfully loaned the book.");
    	
    	
		  ArrayList<String> msg2 = new ArrayList<String>();
          ArrayList<String>  result2 = new ArrayList<String>();
          msg2.add(StudentID);
          msg2.add("Lend Book");
          msg2.add("UserAction");
          result2 = (ArrayList<String>)IPController.client.Request(msg2);
    	
          
           ArrayList<String> msg3 = new ArrayList<String>();
           ArrayList<String>  result3 = new ArrayList<String>();
           msg3.add(StudentID);
	       msg3.add("CheckStudentStatus");
	       result3 = (ArrayList<String>)IPController.client.Request(msg3);
	       StudentEmail = result3.get(1);
          
          try{
 	            String host ="smtp.gmail.com" ;
 	            String user = "ortbraudelibrary.g27@gmail.com";
 	            String pass = "Library123";
 	            String to = StudentEmail;
 	            String from = "ortbraudelibrary.g27@gmail.com";
 	            String subject = "ORT BRAUDE LIBRARY - Hello!";
 	            String messageText ="Thank you! You successfully loaned the book."
  	     				+ "\nLoan Date:"+result.get(0)+""
  	     						+ "\nReturn Date:"+result.get(1)+""
  	     								+ "\n\nBest regards,\nORT Braude Library";
 	            boolean sessionDebug = false;

 	            Properties props = System.getProperties();

 	            props.put("mail.smtp.starttls.enable", "true");
 	            props.put("mail.smtp.host", host);
 	            props.put("mail.smtp.port", "587");
 	            props.put("mail.smtp.auth", "true");
 	            props.put("mail.smtp.starttls.required", "true");

 	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
 	            Session mailSession = Session.getDefaultInstance(props, null);
 	            mailSession.setDebug(sessionDebug);
 	            Message msg1 = new MimeMessage(mailSession);
 	            msg1.setFrom(new InternetAddress(from));
 	            InternetAddress[] address = {new InternetAddress(to)};
 	            msg1.setRecipients(Message.RecipientType.TO, address);
 	            msg1.setSubject(subject); msg1.setSentDate(new Date());
 	            msg1.setText(messageText);

 	           Transport transport=mailSession.getTransport("smtp");
 	           transport.connect(host, user, pass);
 	           transport.sendMessage(msg1, msg1.getAllRecipients());
 	           transport.close();
 	           System.out.println("message send successfully");
 	        }catch(Exception ex)
 	        {
 	            System.out.println(ex);
 	        }
          
    	
    	
    	} ///ENDIF
    	else {
    		JOptionPane.showMessageDialog(null, "Please select a an order to loan.");	
    	}
    }
    
    @FXML
    /**
     * Show received Button handler
     * @param event
     */
    void ShowReceived(ActionEvent event) {
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add("GetReceivedOrders");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	TableColumn StudentID = new TableColumn("Student ID");
    	StudentID.setMinWidth(125);
    	TableColumn BookID = new TableColumn("Book ID");
    	BookID.setMinWidth(125);
    	TableColumn OrderDate = new TableColumn("Order Date");
    	OrderDate.setMinWidth(125);
    	TableColumn ExpiredDay = new TableColumn("Expired Day");
    	ExpiredDay.setMinWidth(125);
    	TableColumn OrderID = new TableColumn("Order ID");
    	OrderID.setMinWidth(125);
    	Table.getColumns().addAll(StudentID, BookID, OrderDate, ExpiredDay, OrderID);
    	
    	
    	   final ObservableList<OrdersForTable> data = FXCollections.observableArrayList();
           for (int i = 0; i < result.size(); i += 5) {
            data.add(new OrdersForTable(result.get(i), result.get(i + 1), result.get(i + 2), result.get(i + 3), result.get(i + 4)));
           }
           StudentID.setCellValueFactory(new PropertyValueFactory<OrdersForTable,String>("StudentID"));
           BookID.setCellValueFactory(new PropertyValueFactory<OrdersForTable,String>("BookID"));
           OrderDate.setCellValueFactory(new PropertyValueFactory<OrdersForTable,String>("OrderDate"));
           ExpiredDay.setCellValueFactory(new PropertyValueFactory<OrdersForTable,String>("ExpiredDay"));
           OrderID.setCellValueFactory(new PropertyValueFactory<OrdersForTable,String>("OrderID"));
            Table.setItems(data);
    }
    
    @FXML
    /**
     * Selection using the mouse
     * @param event
     */
    void Selection(MouseEvent event) {
    	System.out.print("Order ID BEFORE: ");
    	System.out.println(OrderID);
    	OrdersForTable o = Table.getSelectionModel().getSelectedItem();
    	OrderID = o.getOrderID();
    	StudentID = o.getStudentID();
    	System.out.print("Order ID is: ");
    	System.out.println(OrderID);
    	
    }
}
