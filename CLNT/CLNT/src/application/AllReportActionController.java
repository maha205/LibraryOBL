package application;

import java.awt.TextField;
import java.io.IOException;

import TableView.reportAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AllReportActionController {
	private static String back =IPController.backGui;
    @FXML
    private TableView<reportAction> ReportTable;

    @FXML
    private TableColumn<reportAction, String> activeSubscribers;

    @FXML
    private TableColumn<reportAction, String> frozenSubscribers;

    @FXML
    private TableColumn<reportAction, String> lockedSubscribers;

    @FXML
    private TableColumn<reportAction, String> copiesNumber;

    @FXML
    private TableColumn<reportAction, String> delayReurning;
    @FXML
    private TableColumn<reportAction, String>  reportDate;
    @FXML
    private TextField reportSearch;
    
    @FXML
    void searchReport(ActionEvent event) {

    }
    @FXML
    void backGui(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/"+back+".fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {

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

    @FXML
    void requestNewReport(ActionEvent event) {

    }

    @FXML
    void selectItem(MouseEvent event) {

    }

}