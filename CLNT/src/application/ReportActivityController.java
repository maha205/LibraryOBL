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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * Report activity controller
 *
 */
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
    /***
     * Converting month
     * @param month
     * @return
     */
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
    /**
     * Loading combobox
     */
    public void loadCombo()
    {
  		this.comboDay.getItems().addAll("1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"
			,"18","19","20","21","22","23","24","25","26","26","27","28","29","30","31");
  		this.comboMonth.getItems().addAll("January", "February", "March","April","May","June","July","August","September","October"
  				,"November","December");
  		this.comboYear.getItems().addAll("2019", "2018", "2017","2016","2015","2014","2013","2012","2011","2010");
  		
    }
    /**
     * removing
     */
    public void removeCombo()
    {
  		this.comboDay.getItems().removeAll("1", "2", "3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"
			,"18","19","20","21","22","23","24","25","26","26","27","28","29","30","31");
  		this.comboMonth.getItems().removeAll("January", "February", "March","April","May","June","July","August","September","October"
  				,"November","December");
  		this.comboYear.getItems().removeAll("2019", "2018", "2017","2016","2015","2014","2013","2012","2011","2010");
    }
    @FXML
    /**
     * requesting reports Button handler
     * @param event
     */
    void requestReport(ActionEvent event)
    { 
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
		  result =(int)IPController.client.Request(msg);
		  System.out.println(result);
		  delayReturning.setText(""+result);

		  ArrayList<String> msg1 = new ArrayList<String>();
		  int result1 ;
		  msg1.add(date);
		  msg1.add("copiesNumber");
		  result1 =(int)IPController.client.Request(msg1);
		  System.out.println(result);
		  copiesNumber.setText(""+result1);
		  
		  ArrayList<String> msg2 = new ArrayList<String>();
		  ArrayList<String> result2 = new ArrayList<String>();
		  msg2.add(date);
		  msg2.add("ActiveLockedFrozenSubscribersNumber");
		  result2 =( ArrayList<String>)IPController.client.Request(msg2);
		  if(result2.size()>0) {
		  ActiveSubscribers.setText(result2.get(0));
          FrozenSubscribers.setText(result2.get(2));
          LockedSubscribers.setText(result2.get(1));
		  }
		  else {
			  ActiveSubscribers.setText("0");
	          FrozenSubscribers.setText("0");
	          LockedSubscribers.setText("0");
		  }
          
          ArrayList<String> msg3 = new ArrayList<String>();
          String result3 =null;
		  msg3.add(result2.get(0));//Active
		  msg3.add(result2.get(2));//Frozen
		  msg3.add(result2.get(1));//Locked
		  msg3.add(""+result1);
		  msg3.add(""+result);
		  msg3.add(date);
		  msg3.add("RequestActionReport");
		  result3 =(String) IPController.client.Request(msg3);
		  if(result3==null)
	 			 JOptionPane.showMessageDialog(null, "Failed to save report! ");
	 		 else
	 			 JOptionPane.showMessageDialog(null, "Successfuly saved report! ");
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
		  
		  ArrayList<String> msg2 = new ArrayList<String>();
		  ArrayList<String> result2 = new ArrayList<String>();
		  msg2.add(date);
		  msg2.add("ActiveLockedFrozenSubscribersNumber");
		  result2 =( ArrayList<String>) IPController.client.Request(msg2);
		  if(result2.size()>0) {
			  ActiveSubscribers.setText(result2.get(0));
	          FrozenSubscribers.setText(result2.get(2));
	          LockedSubscribers.setText(result2.get(1));
			  }
			  else {
				  ActiveSubscribers.setText("0");
		          FrozenSubscribers.setText("0");
		          LockedSubscribers.setText("0");
			  }
		
          ArrayList<String> msg3 = new ArrayList<String>();
		  String result3;
		  msg3.add(result2.get(0));
		  msg3.add(result2.get(2));
		  msg3.add(result2.get(1));
		  msg3.add(""+result1);
		  msg3.add(""+result);
		  msg3.add(date);
		  msg3.add("RequestActionReport");
		  result3 =(String) IPController.client.Request(msg3);
		  if(result3==null)
	 			 JOptionPane.showMessageDialog(null, "Failed to save report! ");
	 		 else
	 			 JOptionPane.showMessageDialog(null, "Successfuly saved report! ");
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
		  
		  ArrayList<String> msg2 = new ArrayList<String>();
		  ArrayList<String> result2 = new ArrayList<String>();
		  msg2.add(date);
		  msg2.add("ActiveLockedFrozenSubscribersNumber");
		  result2 =( ArrayList<String>) IPController.client.Request(msg2);
		  if(result2.size()>0) {
			  ActiveSubscribers.setText(result2.get(0));
	          FrozenSubscribers.setText(result2.get(2));
	          LockedSubscribers.setText(result2.get(1));
			  }
			  else {
				  ActiveSubscribers.setText("0");
		          FrozenSubscribers.setText("0");
		          LockedSubscribers.setText("0");
			  }
			 
			
          
          //RequestActionReport
		  ArrayList<String> msg3 = new ArrayList<String>();
		  String result3;
		  msg3.add(result2.get(0));
		  msg3.add(result2.get(2));
		  msg3.add(result2.get(1));
		  msg3.add(""+result1);
		  msg3.add(""+result);
		  msg3.add(date);
		  msg3.add("RequestActionReport");
		  result3 =(String) IPController.client.Request(msg3);
 		 if(result3==null)
 			 JOptionPane.showMessageDialog(null, "Failed to save report! ");
 		 else
 			 JOptionPane.showMessageDialog(null, "Successfuly saved report! ");

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
  /**
   * Annual report Button handler
   * @param event
   */
    void AnnualReport(ActionEvent event) //year
    {
	  searchYear = 1;
	  searchDay =0;
	  searchMonth =0;
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
    /**
     * Daily report Button handler
     * @param event
     */
    void DailyReport(ActionEvent event) //day
    {
       searchDay =1 ;
       searchYear =0;
 	  searchMonth =0;
 	  
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
    /**
     * Monthly report Button handler
     * @param event
     */
    void MonthlyReport(ActionEvent event) //month
    {
        searchMonth = 1;
        searchDay =0;
  	  searchYear =0;
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
    /**
     * 
     * @param event
     * @throws IOException
     */
    void back(ActionEvent event) throws IOException {
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
     * 
     * @param event
     * @throws IOException
     */
    void logout(ActionEvent event) throws IOException {

    	sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
    	sigINController.ManagementId =null ;
    	
    	
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
     * Activity log Button handler
     * @param event
     * @throws IOException
     */
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
