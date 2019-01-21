package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddBookController 
{
    @FXML
    private TextField bookID;

    @FXML
    private TextField BookName;
    @FXML
    private TextField BookAuthor;

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
	    void BackGui(ActionEvent event) throws IOException 
	    {
	    	((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/LibrarianProfile.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	    }

	    @FXML
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
	      msg.add("addBook");
	      result = (ArrayList<String>)IPController.client.Request(msg);
	      System.out.println(result);
	      
	      if(result.get(0).equals("newBookAdded"))
	    	  System.out.println("yessssssssss");
	      }
	      else
	    	  System.out.println("noooooooooooooooooooooo");
	    }

	    @FXML
	    void logoutGui(ActionEvent event) throws IOException 
	    {
	    	((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	    }
}
