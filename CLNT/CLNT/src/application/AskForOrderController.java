package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class AskForOrderController 
{
    @FXML
    void LogoutGui(ActionEvent event) throws IOException {
    	 ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();

    }

    @FXML
    void NoOrder(ActionEvent event) throws IOException 
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
    void backGui(ActionEvent event) throws IOException {
    	 ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/StudentProfile.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }

    @FXML
    void yesOrder(ActionEvent event) throws IOException 
    {
    	 ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/OrderBook.fxml").openStream());
	  		
	  		 String StudentID = sigINController.StudentId ;
    		 ArrayList<String> msg = new ArrayList<String>();
    	     ArrayList<String>  result = new ArrayList<String>();
    	     msg.add(""+StudentID);
    	     msg.add(loanBookController.OrderBookID);
    	     msg.add(loanBookController.OrderCopyID);
    	     msg.add("ShowOrderBook");
    	     result = (ArrayList<String>)IPController.client.Request(msg);
    	     
	  		OrderBookController orderBook = loader.getController();	
			
	  		orderBook.loadBookOrder( result);
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }

}