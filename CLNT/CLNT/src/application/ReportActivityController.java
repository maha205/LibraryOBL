package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.ReportActivity;
import TableView.itemInLoan;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReportActivityController 
{
	private static String back =IPController.backGui;
	public static int flag =0 ;
	private static int searchDay =0;
	private static int searchMonth =0;
	private static int searchYear =0;
	
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
    private  ComboBox<String> comboDay;

    @FXML
    private ComboBox<String> comboMonth;

    @FXML
    private ComboBox<String> comboYear;
    @FXML
    private CheckBox monthchoose;

    @FXML
    private CheckBox yearchoose;

    @FXML
    private CheckBox daychoose;
    
    public static String convertMonth(String month)
    {
    	if(month.equals("January"))
    	  return "1" ;
    	if(month.equals("February"))
      	  return "2" ;
    	if(month.equals("March"))
        	  return "3" ;
    	if(month.equals("April"))
      	  return "4" ;
    	if(month.equals("May"))
        	  return "5" ;
    	if(month.equals("June"))
        	  return "6" ;
    	if(month.equals("July"))
        	  return "7" ;
    	if(month.equals("August"))
        	  return "8" ;
    	if(month.equals("September"))
        	  return "9" ;
    	if(month.equals("October"))
        	  return "10" ;
    	if(month.equals("November"))
        	  return "11" ;
    	if(month.equals("December"))
        	  return "12" ;
    	
    	return null;
    }
    public void loadCombo()
    {
  		this.comboDay.getItems().addAll("1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"
			,"18","19","20","21","22","23","24","25","26","26","27","28","29","30","31");
  		this.comboMonth.getItems().addAll("January", "February", "March","April","May","June","July","August","September","October"
  				,"November","December");
  		this.comboYear.getItems().addAll("2019", "2018", "2017","2016","2015","2014","2013","2012","2011","2010");
  		
    }
    public void removeCombo()
    {
  		this.comboDay.getItems().removeAll("1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"
			,"18","19","20","21","22","23","24","25","26","26","27","28","29","30","31");
  		this.comboMonth.getItems().removeAll("January", "February", "March","April","May","June","July","August","September","October"
  				,"November","December");
  		this.comboYear.getItems().removeAll("2019", "2018", "2017","2016","2015","2014","2013","2012","2011","2010");
    }
    @FXML
    void requestReport(ActionEvent event)
    {
    	 if(searchYear==1 && searchDay==1)
    		 JOptionPane.showMessageDialog(null, "Please select only one !!");
    	 if(searchMonth==1 && searchDay==1)
    		 JOptionPane.showMessageDialog(null, "Please select only one !!");
    	 if(searchYear==1 && searchMonth==1)
    		 JOptionPane.showMessageDialog(null, "Please select only one !!");
    	 
    	 if(searchYear==1 && searchMonth==1 && searchDay==1)
    		 JOptionPane.showMessageDialog(null, "Please select only one !!");
    	 
     if(searchYear==1 && searchMonth==0 && searchDay==0)
     {
    	 if((String)comboYear.getSelectionModel().getSelectedItem()==null)
        	 JOptionPane.showMessageDialog(null, "Please fill out the Year ");

    	 else {
    	  ArrayList<String> msg = new ArrayList<String>();
		  int result ;
		  String date = "31/12/";
		  date+= (String)comboYear.getSelectionModel().getSelectedItem();
		  msg.add(date);
		  msg.add("year");
		  msg.add("NumberOfDelays");
		  result =(int) IPController.client.Request(msg);
		  System.out.println(result);
		  delayReturning.setText(""+result);

		  ArrayList<String> msg1 = new ArrayList<String>();
		  int result1 ;
		  msg1.add(date);
		  msg1.add("copiesNumber");
		  result1 =(int) IPController.client.Request(msg1);
		  System.out.println(result);
		  copiesNumber.setText(""+result1);
		
		  }
    	 flag=0;
     }
     
     if(searchDay==1 && searchMonth==0 && searchYear==0)
     {
    	 if((String)comboDay.getSelectionModel().getSelectedItem()==null||(String)comboMonth.getSelectionModel().getSelectedItem()==null || (String)comboYear.getSelectionModel().getSelectedItem()==null)        	
    		 JOptionPane.showMessageDialog(null, "Please fill out the Date ");

        else {
    	 ArrayList<String> msg = new ArrayList<String>();
		  int result ;
		  String date = (String)comboDay.getSelectionModel().getSelectedItem();
		  date += "/" ;
		  String conv =convertMonth((String)comboMonth.getSelectionModel().getSelectedItem());
		  
		  if(conv==null) delayReturning.setText("0");
		  
		  else {
		  date += conv ;
		  date += "/" ;
		  date+= (String)comboYear.getSelectionModel().getSelectedItem();
		  msg.add(date);
		  msg.add("day");
		  msg.add("NumberOfDelays");
		  result =(int) IPController.client.Request(msg);
		  System.out.println(result);
		  delayReturning.setText(""+result);
		  
		  ArrayList<String> msg1 = new ArrayList<String>();
		  int result1 ;
		  msg1.add(date);
		  msg1.add("copiesNumber");
		  result1 =(int) IPController.client.Request(msg1);
		  System.out.println(result);
		  copiesNumber.setText(""+result1);
		  }
		  flag=0;
        }
     }
     
     if(searchMonth==1 && searchYear==0 && searchDay==0)
     {
    	 if((String)comboMonth.getSelectionModel().getSelectedItem()==null || (String)comboYear.getSelectionModel().getSelectedItem()==null)        	
    		 JOptionPane.showMessageDialog(null, "Please fill out the Date ");

        else {
    	 ArrayList<String> msg = new ArrayList<String>();
		  int result ;
		  String date = "31";
		  date += "/" ;
		  String conv =convertMonth((String)comboMonth.getSelectionModel().getSelectedItem());
          
		  if(conv==null) delayReturning.setText("0");
		  
		  else {
		  date += conv ;
		  date += "/" ;
		  date+= (String)comboYear.getSelectionModel().getSelectedItem();
		  msg.add(date);
		  msg.add("month");
		  msg.add("NumberOfDelays");
		  result =(int) IPController.client.Request(msg);
		  System.out.println(result);
		  delayReturning.setText(""+result);
		  
		  ArrayList<String> msg1 = new ArrayList<String>();
		  int result1 ;
		  msg1.add(date);
		  msg1.add("copiesNumber");
		  result1 =(int) IPController.client.Request(msg1);
		  System.out.println(result);
		  copiesNumber.setText(""+result1);
		  }
		  flag=0;
        }
     }
     if(searchMonth==0 && searchYear==0 && searchDay==0) {
    	 JOptionPane.showMessageDialog(null, "Please select only one ");
    	// removeCombo();
    	 flag=0;
    	 loadCombo();
     }
     removeCombo();
     //flag=0;
 	loadCombo();
    }
  @FXML
    void AnnualReport(ActionEvent event) //year
    {
	  searchYear = 1- searchYear;
	  if(flag ==0)
	  {
		  flag =1 ;
		  loadCombo();
	  }
	  if(searchYear == 1) {
	  comboDay.setDisable(true);
	  comboMonth.setDisable(true);
	  comboYear.setDisable(false);}
	  
    }

    @FXML
    void DailyReport(ActionEvent event) //day
    {
       searchDay =1- searchDay ;
    	
      if(flag ==0)
   	  {
   		  flag =1 ;
   		  loadCombo();
   	  }
      if( searchDay == 1) {
      comboDay.setDisable(false);
  	  comboMonth.setDisable(false);
  	  comboYear.setDisable(false);}
  	  
    }

    @FXML
    void MonthlyReport(ActionEvent event) //month
    {
        searchMonth = 1- searchMonth;
      
     if(flag ==0)
   	  {
   		  flag =1 ;
   		  loadCombo();
   	  }
     if( searchMonth == 1) {
      comboDay.setDisable(true);
  	  comboMonth.setDisable(false);
  	  comboYear.setDisable(false);}
  	  
  	
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
    @FXML
    void ActivityLog(ActionEvent event) throws IOException {
    	IPController.backGui="ReportActivity";
		  ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/AllReportAction.fxml").openStream());
	  		
	  		//ReportActivity
	  		ArrayList<String> msg = new ArrayList<String>();
	        ArrayList<ReportActivity>  result = new ArrayList<ReportActivity>();
	        msg.add("ReportActivity");
	    	result = (ArrayList<ReportActivity>)IPController.client.Request(msg);
	    	System.out.println(result);
	  		
  
	    	AllReportActionController  reports = loader.getController();	
		 	
	    	reports.loadReports(result);
	  		
	  		primaryStage.setTitle("Report Activity Log");
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }

}
