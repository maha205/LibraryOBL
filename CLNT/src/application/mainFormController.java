package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class mainFormController 
{
    @FXML
    private Button signIn;

    @FXML
    private Button signup;

    @FXML
    private Button search;

    @FXML
    private Button exit;

    @FXML
    /**
     * 
     * @param Exit event
     * @throws IOException
     */
    void exitFunc(ActionEvent event) throws IOException 
    {	
		((Node)event.getSource()).getScene().getWindow().hide();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/IP.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Welcome To OBL Library");
		stage.setScene(new Scene(root));
		stage.show();
    }

    @FXML
    /**
     * Searching button handler
     * @param event
     * @throws IOException
     */
    void searchFunc(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="mainForm";
		((Node)event.getSource()).getScene().getWindow().hide();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/SearchBook.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Search Book");
		stage.setScene(new Scene(root));
		stage.show();
    }

    @FXML
    /**
     * sign in button handler
     * @param event
     * @throws IOException
     */
    void signInFunc(ActionEvent event) throws IOException 
    {
    	/*IPController.backGui ="mainForm";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
		primaryStage.setTitle("Sign-In");
		Scene scene = new Scene(root);			
		primaryStage.setScene(scene);		
		primaryStage.show();  */
    	
		((Node)event.getSource()).getScene().getWindow().hide();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setResizable(false);
		stage.setTitle("Sign In");
		stage.setScene(new Scene(root));
		stage.show();
    }
}