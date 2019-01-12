package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class loanBookController 
{
	public static String OrderBookID = "1564893212";
	public static String OrderCopyID = "1";
    @FXML
    private TextField bookName;

    @FXML
    void BackGui(ActionEvent event) throws IOException 
    {
    	  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/StudentProfile.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }

    @FXML
    void LoanBook(ActionEvent event) 
    {
     
    }

    @FXML
    void exitGui(ActionEvent event) throws IOException 
    {
    	  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }

    @FXML
    void search(ActionEvent event) {

    }
    @FXML
    void orderBook(ActionEvent event) throws IOException {

  	  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/AskForOrder.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }

}