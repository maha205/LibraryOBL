package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SearchBookController 
{
    @FXML
    void BookDescription(ActionEvent event) {

    }

    @FXML
    void backGUi(ActionEvent event) throws IOException
    {
    	String back = mainFormController.backSearch ;
  		((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/"+ back+".fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void bookAuthosr(ActionEvent event) {

    }

    @FXML
    void bookGenre(ActionEvent event) {

    }

    @FXML
    void bookName(ActionEvent event) {

    }

    @FXML
    void exiteGui(ActionEvent event) throws IOException
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/IP.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void searchBook(ActionEvent event) {

    }

}
