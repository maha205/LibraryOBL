package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;

import Entity.NormalLending;
import Entity.RequestLending;
import TableView.LendingReportNormalBook;
import TableView.LendingReportRequestBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LendingReportController {

	    final static String rang1 = "0-3";
	    final static String rang2  = "4-7";
	    final static String rang3 = "8-11";
	    final static String rang4 = "12-15";
	    final static String rang5 = "16-19";
	    final static String rang6 = "20-23";
	    final static String rang7  = "24-27";
	    final static String rang8 = "28-31";
	    final static String rang9 = "32-35";
	    final static String rang10 = "36-39";
	    
    @FXML
    private TableView<LendingReportRequestBook> requestTable;

    @FXML
    private TableView<LendingReportNormalBook> normalTable;

    @FXML
    private BarChart<String, Number> BarcharNormal;

//    @FXML
//    private StackedBarChart<?, ?> BarcharRequest;

    @FXML
    private BarChart<String, Number> BarcharRequest;
    @FXML
    private Button requestReport;

    @FXML
    private Text avgRequest;

    @FXML
    private Text MedianRequest;

    @FXML
    private Text AvgNormal;

    @FXML
    private Text medianNormal;
public void VarChartNormal()
{
	 
}
    public void AvgNormal(ArrayList<NormalLending> normal)
    {
    	ArrayList<Integer> sum = new ArrayList<Integer>() ;
    	for(int i =0;i<normal.size();i++)
    	{
    		sum.add(Integer.parseInt(normal.get(i).getDuringNormalLending()));
    	}
        Collections.sort(sum);//Sort list

    	int total = 0;
    	double avg =0;
    	for(int i = 0; i < sum.size(); i++)
    	{
    	    total += sum.get(i);
    	    avg = (double)total / sum.size();
    	    System.out.println("The Average IS:" + avg);
    	}
    	AvgNormal.setText(""+avg);
    	
    	int median=0;
    	int size =sum.size() ;
		 if (size % 2 == 0) {
		        int x1 = sum.get(size / 2 - 1);
		        int x2 = sum.get(size / 2);
		        median = (x1 + x2) / 2;
		    } else {
		        median = sum.get(size / 2);
		    }
		 medianNormal.setText(""+median);
		 System.out.println("The median is: "+median);
    }

    public void avgRequest(ArrayList<RequestLending> normal)
    {
    	ArrayList<Integer> sum = new ArrayList<Integer>() ;
    	for(int i =0;i<normal.size();i++)
    	{
    		sum.add(Integer.parseInt(normal.get(i).getDuringRequestLending()));
    	}
    	 Collections.sort(sum);//Sort list
    	int total = 0;
    	double avg =0;
    	for(int i = 0; i < sum.size(); i++)
    	{
    	    total += sum.get(i);
    	    avg = (double)total / sum.size();
    	    System.out.println("The Average IS:" + avg);
    	}
    	avgRequest.setText(""+avg);
    	
    	int median=0;
    	int size =sum.size() ;
		 if (size % 2 == 0) {
		        int x1 = sum.get(size / 2 - 1);
		        int x2 = sum.get(size / 2);
		        median = (x1 + x2) / 2;
		    } else {
		        median = sum.get(size / 2);
		    }
		 MedianRequest.setText(""+median);
		 System.out.println("The median is: "+median);
    }
    public void RequestTable(ArrayList<RequestLending> request)
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
    	TableColumn DuringRequestLending = new TableColumn("Range Duration of lending ");
    	DuringRequestLending.setMinWidth(200);
    	TableColumn  noRequestSubscribers= new TableColumn("No. Of Duration Of Lending Request Book "); 
    	 noRequestSubscribers.setMinWidth(400);
         
    	 requestTable.getColumns().addAll(DuringRequestLending,noRequestSubscribers);
        
    
    	 final ObservableList<LendingReportRequestBook> data = FXCollections.observableArrayList();
    	 for(int k =0 , w=0;k<40;k+=4 ,w++)    
    	  {
    	   	 for(int j=0 ;j<request.size();j++)
    	   	 {
    	   		 int x = Integer.parseInt(request.get(j).getDuringRequestLending());
    	   		 int y= Integer.parseInt(request.get(j).getNoRequestSubscribers());
    	   		if(y==0) y++;
    	   		 if( x >=k && x <= (k+3)) arr[w]+=y;
    	   	}
    	  }
    	   	 for (int i = 0 ,k=0; i < 40 ; i +=4 ,k++)
    	   	 {
    	   		String s = ""+i;
    			 s+="-"+(i+3);
    	  		 data.add(new LendingReportRequestBook (s,""+arr[k]));
    	     }
        
        
       DuringRequestLending.setCellValueFactory(new PropertyValueFactory<LendingReportRequestBook,String>("DuringRequestLending"));
       noRequestSubscribers.setCellValueFactory(new PropertyValueFactory<LendingReportRequestBook,String>("noRequestSubscribers"));
       requestTable.setItems(data);
       
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
       
       BarcharRequest.getData().addAll(series1);
    
    }
   public void NormalTable(ArrayList<NormalLending> normal)
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
   	TableColumn DuringNormalLending = new TableColumn("Range Duration of lending ");
   	DuringNormalLending.setMinWidth(200);
   	TableColumn  noNormalSubscribers= new TableColumn("No. Of Duration Of Lending Normal Book "); 
   	 noNormalSubscribers.setMinWidth(400);
        
   	 normalTable.getColumns().addAll(DuringNormalLending,noNormalSubscribers);
       
   
   	 final ObservableList<LendingReportNormalBook> data = FXCollections.observableArrayList();
   for(int k =0 , w=0;k<40;k+=4 ,w++)   
   {
   	 for(int j=0 ;j<normal.size();j++)
   	 {
   		 int x = Integer.parseInt(normal.get(j).getDuringNormalLending());
   		 int y= Integer.parseInt(normal.get(j).getNoNormalSubscribers());
   		 if(y==0) y++;
   		 if( x >= k && x <= (k+3) ) arr[w]+=y;
   	}
   }
   	 for (int i = 0 ,k=0; i < 40; i +=4,k++) {
   		String s = ""+i;
		 s+="-"+(i+3);
  		 data.add(new LendingReportNormalBook (s,""+arr[k]));
       }
       
       
      DuringNormalLending.setCellValueFactory(new PropertyValueFactory<LendingReportRequestBook,String>("DuringNormalLending"));
      noNormalSubscribers.setCellValueFactory(new PropertyValueFactory<LendingReportRequestBook,String>("noNormalSubscribers"));
      normalTable.setItems(data);
      
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
      
   
      BarcharNormal.getData().addAll(series1);
      
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
    	ArrayList<NormalLending> result = new ArrayList<NormalLending>();
    	msg.add("DurationLendingNormal");
	    result = (ArrayList<NormalLending>)IPController.client.Request(msg);
        System.out.println(result);
       
	    ArrayList<String> msg1 = new ArrayList<String>();
    	ArrayList<RequestLending> result1 = new ArrayList<RequestLending>();
	    msg1.add("DurationLendingRequest");
	    result1 = (ArrayList<RequestLending>)IPController.client.Request(msg1);
	    System.out.println(result1);
	    
	    RequestTable(result1);
    	NormalTable(result);
    	 AvgNormal(result);
    	 avgRequest(result1);
    	
    }
    
    
}