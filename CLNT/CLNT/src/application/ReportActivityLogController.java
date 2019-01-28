package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReportActivityLogController {

	private static String back =IPController.backGui;
    @FXML
    private Text ActiveSubscribers;

    @FXML
    private Text FrozenSubscribers;

    @FXML
    private Text LockedSubscribers;

    @FXML
    private Text copiesNumber;

    @FXML
    private Text delayReturning;

    @FXML
    private ComboBox<String> comboDay;

    @FXML
    private ComboBox<String> comboMonth;

    @FXML
    private ComboBox<String> comboYear;

    @FXML
    void ActivityLog(ActionEvent event) {

    }

    @FXML
    void AnnualReport(ActionEvent event) {

    }

    @FXML
    void DailyReport(ActionEvent event) {

    }

    @FXML
    void MonthlyReport(ActionEvent event) {

    }

    @FXML
    void back(ActionEvent event) throws IOException {

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

}
