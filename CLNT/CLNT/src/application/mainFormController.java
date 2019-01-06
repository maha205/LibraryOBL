package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainFormController {

    @FXML
    private Button signIn;

    @FXML
    private Button signup;

    @FXML
    private Button search;

    @FXML
    private Button exit;

    @FXML
    void exitFunc(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/IP.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();

    }

    @FXML
    void searchFunc(ActionEvent event) {

    }

    @FXML
    void signInFunc(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/loginUser.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();

    }

    @FXML
    void signupFunc(ActionEvent event) {

    }

}