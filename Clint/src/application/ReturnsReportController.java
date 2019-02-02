package application;

import java.io.IOException;
import java.util.ArrayList;

import Entity.NormalLending;
import TableView.DurationOfLateness;
import TableView.LendingReportRequestBook;
import TableView.NumberOfDelays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReturnsReportController {

	final static String rang1 = "0-1";
    final static String rang2  = "2-3";
    final static String rang3 = "4-5";
    final static String rang4 = "6-7";
    final static String rang5 = "8-9";
    final static String rang6 = "10-11";
    final static String rang7  = "12-13";
    final static String rang8 = "14-15";
    final static String rang9 = "16-17";
    final static String rang10 = "18-19";
    @FXML
    private TableView<NumberOfDelays> TableDelaysNumbers;

    @FXML
    private TableView<DurationOfLateness> TableDuration;

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
    
    public void DuringTable(ArrayList<Integer> noDelays)
    {
    	int arr[] = new int[10] ;
 	   for(int i=0;i<10;i++)
 		   arr[i]=0;
 	   
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	TableColumn Range = new TableColumn("Range Duration Of Lateness");
    	Range.setMinWidth(210);
    	TableColumn  numbers= new TableColumn("No. Of Duration Of Lateness"); 
    	numbers.setMinWidth(200);
         
    	TableDuration.getColumns().addAll(Range,numbers);
        
    	 final ObservableList<DurationOfLateness> data = FXCollections.observableArrayList();
    	 for(int k =0 , w=0;k<20;k+=2 ,w++)   
  	   {
  	   	 for(int j=0 ;j<noDelays.size();j++)
  	   	 {
  	   		 int x = noDelays.get(j) ;
  	   		 if( x >= k && x <= (k+1)) arr[w]++;
  	   	}
  	   }
    	   	 for (int i = 0 ,k=0; i < 20 ; i +=2 ,k++)
    	   	 {
    	   		String s = ""+i;
    			 s+="-"+(i+1);
    	  		 data.add(new DurationOfLateness (s,""+arr[k]));
    	     }
       
     	   	Range.setCellValueFactory(new PropertyValueFactory<DurationOfLateness,String>("Range"));
     	   	numbers.setCellValueFactory(new PropertyValueFactory<DurationOfLateness,String>("no"));
     	   	TableDuration.setItems(data);
     	   	
     	   int total = 0;
       	double avg =0;
       	for(int i = 0; i < noDelays.size(); i++)
       	{
       	    total += noDelays.get(i);
       	    avg = (double)total / noDelays.size();
       	    System.out.println("The Average IS:" + avg);
       	}
       	AvgDuration.setText(""+avg);
       	
       	int median=0;
       	int size =noDelays.size() ;
       	if(size!=0) {
   		 if (size % 2 == 0) {
   		        int x1 = noDelays.get(size / 2 - 1);
   		        int x2 = noDelays.get(size / 2);
   		        median = (x1 + x2) / 2;
   		    } else {
   		        median = noDelays.get(size / 2);
   		    }}
   		medianDuration.setText(""+median);
   		 System.out.println("The median is: "+median);
     	   	
     	   XYChart.Series series1 = new XYChart.Series();
 	      series1.setName("This month");       
 	      series1.getData().add(new XYChart.Data(rang1, arr[0]));
 	      series1.getData().add(new XYChart.Data(rang2, arr[1]));
 	      series1.getData().add(new XYChart.Data(rang3, arr[2]));
 	      series1.getData().add(new XYChart.Data(rang4, arr[3]));
 	      series1.getData().add(new XYChart.Data(rang5, arr[4])); 
 	      series1.getData().add(new XYChart.Data(rang6, arr[5]));
 	      series1.getData().add(new XYChart.Data(rang7, arr[6]));
 	      series1.getData().add(new XYChart.Data(rang8, arr[7]));
 	      series1.getData().add(new XYChart.Data(rang9, arr[8]));
 	      series1.getData().add(new XYChart.Data(rang10, arr[9]));
 	      
 	     BarChaDuration.getData().addAll(series1);
    }
    public void NoDelaysTable(ArrayList<Integer> noDelays)
    {
    	int arr[] = new int[10] ;
 	   for(int i=0;i<10;i++)
 		   arr[i]=0;
 	   
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    	TableColumn Range = new TableColumn("Range Number Of Delays");
    	Range.setMinWidth(200);
    	TableColumn  numbers= new TableColumn("No. Of Number Of Delays"); 
    	numbers.setMinWidth(200);
         
    	TableDelaysNumbers.getColumns().addAll(Range,numbers);
    	
    	 final ObservableList<NumberOfDelays> data = FXCollections.observableArrayList();
    	
    	   for(int k =0 , w=0;k<20;k+=2 ,w++)   
    	   {
    	   	 for(int j=0 ;j<noDelays.size();j++)
    	   	 {
    	   		 int x = noDelays.get(j) ;
    	   		 if( x >= k && x <= (k+1)) arr[w]++;
    	   	}
    	   }
    	   
    	   	 for (int i = 0 ,k=0; i < 20 ; i +=2 ,k++)
    	   	 {
    	   		String s = ""+i;
    			 s+="-"+(i+1);
    	  		 data.add(new NumberOfDelays (s,""+arr[k]));
    	     }
        
    	   	Range.setCellValueFactory(new PropertyValueFactory<NumberOfDelays,String>("Range"));
    	   	numbers.setCellValueFactory(new PropertyValueFactory<NumberOfDelays,String>("no"));
    	   	TableDelaysNumbers.setItems(data);
    	   	
    		int total = 0;
        	double avg =0;
        	for(int i = 0; i < noDelays.size(); i++)
        	{
        	    total += noDelays.get(i);
        	    avg = (double)total / noDelays.size();
        	    System.out.println("The Average IS:" + avg);
        	}
        	avgDelaysNumbers.setText(""+avg);
        	
        	int median=0;
        	int size =noDelays.size() ;
        	if(size!=0) {
    		 if (size % 2 == 0) {
    		        int x1 = noDelays.get(size / 2 - 1);
    		        int x2 = noDelays.get(size / 2);
    		        median = (x1 + x2) / 2;
    		    } else {
    		        median = noDelays.get(size / 2);
    		    }}
    		 medianDelaysNumbers.setText(""+median);
    		 System.out.println("The median is: "+median);
    		 
    	   	  XYChart.Series series1 = new XYChart.Series();
    	      series1.setName("This month");       
    	      series1.getData().add(new XYChart.Data(rang1, arr[0]));
    	      series1.getData().add(new XYChart.Data(rang2, arr[1]));
    	      series1.getData().add(new XYChart.Data(rang3, arr[2]));
    	      series1.getData().add(new XYChart.Data(rang4, arr[3]));
    	      series1.getData().add(new XYChart.Data(rang5, arr[4])); 
    	      series1.getData().add(new XYChart.Data(rang6, arr[5]));
    	      series1.getData().add(new XYChart.Data(rang7, arr[6]));
    	      series1.getData().add(new XYChart.Data(rang8, arr[7]));
    	      series1.getData().add(new XYChart.Data(rang9, arr[8]));
    	      series1.getData().add(new XYChart.Data(rang10, arr[9]));
    	      
    	      BarCharDelaysNumbers.getData().addAll(series1);
    	      
    	      
    }
    
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
    void requestReportFunc(ActionEvent event)
    {
    	ArrayList<String> msg = new ArrayList<String>();
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	msg.add("RangeNumberOfDelays");
	    result = (ArrayList<Integer>)IPController.client.Request(msg);
        System.out.println(result);
        //DurationDelays
        ArrayList<String> msg1 = new ArrayList<String>();
    	ArrayList<Integer> result1 = new ArrayList<Integer>();
    	msg1.add("DurationDelays");
	    result1 = (ArrayList<Integer>)IPController.client.Request(msg1);
        System.out.println(result1);
        
    	NoDelaysTable(result);
    	DuringTable(result1);
    }

}