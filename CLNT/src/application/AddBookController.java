package application;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * 
 * Adding book controller
 *
 */

public class AddBookController 
{
//	public static String[] arr;
	
	public String PDFString;
	
	public static int m =0;
    @FXML
    private TextField bookID;

    @FXML
    private TextField BookName;
    @FXML
    private TextField BookAuthor;
    
    @FXML
    private Button PDFButton;

    @FXML
    private TextField BookGenre;

    @FXML
    private TextField BookPublisher;

    @FXML
    private TextField BookPrintdate;

    @FXML
    private TextField CopyQuantity;

    @FXML
    private TextField BookShelfLocation;

    @FXML
    private TextField BookDescription;
 
    @FXML
  /**
   * Back button action
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
  		     * Add BDF button action
  		     * @param event
  		     * @throws IOException
  		     */
  			
  			void AddPDFFunc(ActionEvent event) throws FileNotFoundException {
  				PDFString = new String();
  				FileChooser fileChooser = new FileChooser();
  				fileChooser.setTitle("Open Resource File");
  				File file = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

  				// File file = new File("java1.pdf");
  				FileInputStream fis = new FileInputStream(file); // get the file
  				ByteArrayOutputStream bos = new ByteArrayOutputStream();
  				byte[] buf = new byte[1024];
  				try {
  					for (int readNum; (readNum = fis.read(buf)) != -1;) {
  						bos.write(buf, 0, readNum); // no doubt here is 0
  						// Writes len bytes from the specified byte array starting at offset off to this
  						// byte array output stream.
  						System.out.println("read " + readNum + " bytes,");
  					}
  				} catch (IOException ex) {
  				}
  				byte[] bytes = bos.toByteArray(); // save it to Byte
  				PDFString = Base64.getEncoder().encodeToString(bytes); // change Byte[] to string
  			}
  				
  
  
  
  
	    @FXML
	    /**
	     * Add book button action
	     * @param event
	     * @throws IOException
	     */
	    void addBook(ActionEvent event) throws IOException
	    {
	      ArrayList<String> msg = new ArrayList<String>();
	      ArrayList<String>  result = new ArrayList<String>();
	      if(!(bookID.getText().equals("")) &&!(CopyQuantity.getText().equals("")) && !(BookName.getText().equals("")) && !( BookAuthor.getText().equals("")) && !( BookDescription.getText().equals("")) && !( BookPublisher.getText().equals("")) && !( BookPrintdate.getText().equals(null))&& !(BookShelfLocation.getText().equals("")))
	      {

	      msg.add(bookID.getText());
	      msg.add(BookName.getText());
	      msg.add(BookAuthor.getText());
	      msg.add(BookGenre.getText());
	      msg.add(BookDescription.getText());
	      msg.add(BookPublisher.getText());
	      msg.add(BookPrintdate.getText());
	      msg.add(""+CopyQuantity.getText());
	      msg.add(BookShelfLocation.getText());
	      msg.add(PDFString);
	      msg.add("addBook");
	      result = (ArrayList<String>)IPController.client.Request(msg);
	      System.out.println(result);
	      if(result.isEmpty())JOptionPane.showMessageDialog(null, "The book you are trying to add is exists !! !!");
	      
	      if(result.size()>0 &&result.get(0).equals("newBookAdded"))
      		JOptionPane.showMessageDialog(null, "The book is Added");

	      }
	      else
      		JOptionPane.showMessageDialog(null, "Please fill out the fieldS !!");

	    }

	    @FXML
	    /**
	     * Logout gui
	     * @param event
	     * @throws IOException
	     */
	    void logoutGui(ActionEvent event) throws IOException 
	    {
	    	sigINController.LibrarianId=null;
	    	sigINController.StudentId =null;
	    	sigINController.ManagementId =null ;
	    /*	((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show(); */
	    	((Node)event.getSource()).getScene().getWindow().hide();
  			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
  			Parent root = (Parent) fxmlLoader.load();
  			Stage stage = new Stage();
  			stage.setResizable(false);
  			stage.setScene(new Scene(root));
  			stage.show();
	    	
	    }
}
