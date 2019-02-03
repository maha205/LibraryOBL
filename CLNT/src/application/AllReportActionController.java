package application;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.ReportActivity;
import javafx.scene.input.MouseEvent;

import TableView.Student;
import TableView.reportAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import TableView.reportAction;
/**
 * 
 * Reports controller
 *
 */

public class AllReportActionController {
	private static String back =IPController.backGui;
	ArrayList<ReportActivity> reports = new ArrayList<ReportActivity>();
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
    
    /**
     * loading reports
     * @param reports
     */
    public void loadReports(ArrayList<ReportActivity> reports)
    {
    	this.reports =reports ;
    	if(reports.size()>0)
    	{
    		ReportTable.getColumns().addAll(activeSubscribers,frozenSubscribers, lockedSubscribers, copiesNumber , delayReurning,reportDate );
    	        
    		    
    	        final ObservableList<reportAction> data = FXCollections.observableArrayList();
    	        
    	        for (int i = 0; i < reports.size(); i ++) {
    	         data.add(new reportAction  (reports.get(i).getActiveSubscribers(),
    	        		 reports.get(i).getFrozenSubscribers(), reports.get(i).getLockedSubscribers(),
    	        		 reports.get(i).getCopiesNumber(),
    	        		 reports.get(i).getDelayReurning(),reports.get(i).getReportDate()));
    	        }
    	        
    	        
    	        activeSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("activeSubscribers"));
    	        
    	        frozenSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("frozenSubscribers"));

    	        lockedSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("lockedSubscribers"));

    	        copiesNumber.setCellValueFactory(new PropertyValueFactory<reportAction,String>("copiesNumber"));
    	        
    	        delayReurning.setCellValueFactory(new PropertyValueFactory<reportAction,String>("delayReurning"));
    	        
    	        reportDate.setCellValueFactory(new PropertyValueFactory<reportAction,String>("reportDate"));
    	        
    	        ReportTable.setItems(data);
    	}
    }
    
    @FXML
    /**
     * Searching reports
     * @param event
     */
    void searchReport(ActionEvent event) 
    {
    	int flag =0;
    	if(reportSearch.getText().equals("")) 
    		JOptionPane.showMessageDialog(null, "Please fill out the field !!");
    	
    	else {
    	  for (int i = 0; i < reports.size(); i ++) 
    	  {
    	    if(reports.get(i).getReportDate().equals(reportSearch.getText()))
    	    {
               final ObservableList<reportAction> data = FXCollections.observableArrayList();
    	        
    	      //  for (int i = 0; i < reports.size(); i ++) {
    	         data.add(new reportAction  (reports.get(i).getActiveSubscribers(),
    	        		 reports.get(i).getFrozenSubscribers(), reports.get(i).getLockedSubscribers(),
    	        		 reports.get(i).getCopiesNumber(),
    	        		 reports.get(i).getDelayReurning(),reports.get(i).getReportDate()));
    	       // }
    	        
    	        
    	        activeSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("activeSubscribers"));
    	        
    	        frozenSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("frozenSubscribers"));

    	        lockedSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("lockedSubscribers"));

    	        copiesNumber.setCellValueFactory(new PropertyValueFactory<reportAction,String>("copiesNumber"));
    	        
    	        delayReurning.setCellValueFactory(new PropertyValueFactory<reportAction,String>("delayReurning"));
    	        
    	        reportDate.setCellValueFactory(new PropertyValueFactory<reportAction,String>("reportDate"));
    	        
    	        ReportTable.setItems(data);
    	    	   flag=1 ;
    	    };
    	  }
    	  
    	  if(flag==0) 
    		  JOptionPane.showMessageDialog(null, "No report on this date !");
    	}
    }
    @FXML
    /**
     * Back button gui
     * @param event
     * @throws IOException
     */
    void backGui(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/"+back+".fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }

    @FXML

    /**
     * Logout button gui
     * @param event
     * @throws IOException
     */
    void logout(ActionEvent event) throws IOException {

    	sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
    	sigINController.ManagementId =null ;
    	/*((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();*/
    	
    	((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }

    @FXML
    /**
     * Requesting new report button
     * @param event
     * @throws IOException
     */
    void requestNewReport(ActionEvent event) throws IOException {
    	IPController.backGui="AllReportAction";

    	((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/ReportActivity.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    	

    }

    @FXML
    /**
     * View again button
     * @param event
     */
    void viewAgain(ActionEvent event) 
    {
    	 final ObservableList<reportAction> data = FXCollections.observableArrayList();
	        
	        for (int i = 0; i < reports.size(); i ++) {
	         data.add(new reportAction  (reports.get(i).getActiveSubscribers(),
	        		 reports.get(i).getFrozenSubscribers(), reports.get(i).getLockedSubscribers(),
	        		 reports.get(i).getCopiesNumber(),
	        		 reports.get(i).getDelayReurning(),reports.get(i).getReportDate()));
	        }
	        
	        
	        activeSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("activeSubscribers"));
	        
	        frozenSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("frozenSubscribers"));

	        lockedSubscribers.setCellValueFactory(new PropertyValueFactory<reportAction,String>("lockedSubscribers"));

	        copiesNumber.setCellValueFactory(new PropertyValueFactory<reportAction,String>("copiesNumber"));
	        
	        delayReurning.setCellValueFactory(new PropertyValueFactory<reportAction,String>("delayReurning"));
	        
	        reportDate.setCellValueFactory(new PropertyValueFactory<reportAction,String>("reportDate"));
	        
	        ReportTable.setItems(data);
    }

}