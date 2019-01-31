package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReturnsReportController {

    @FXML
    private TableView<?> TableDelaysNumbers;

    @FXML
    private TableView<?> TableDuration;

    @FXML
    private BarChart<String, Number> BarChaDuration;
    
    @FXML
    private BarChart<String, Number> BarCharDelaysNumbers;

    @FXML
    private Button requestReport;

    @FXML
    private Text avgDelaysNumbers;

    @FXML
    private Text medianDelaysNumbers;

    @FXML
    private Text AvgDuration;

    @FXML
    private Text medianDuration;



    @FXML
    void back(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/"+IPController.backGui+".fxml").openStream());
  		
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
    void requestReportFunc(ActionEvent event) {

    }

}