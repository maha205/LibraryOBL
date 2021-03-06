import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observer;
/**
 * 
 *order checking
 *
 */
public class OrderCheck implements ReminderInterface, Runnable{
	
	List<Observer> observerList= new ArrayList<>(); 
	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Thread t1;
	public static String indexToOrderTable;
	public static int index;
	public static int index2;
	public static int OrderNumber=0;
	public static int indexToOrderTable2;
	
	
	
	
	public  void start () {
		String threadName1="OrderThread";
	    System.out.println("Starting " +  threadName1 );
	    if (t1 == null) {
	       t1 = new Thread (threadName1);
	       run();  
	       System.out.println("Inside");
	    }
	    System.out.println("Outside");
	 }

	
	
	@Override
	/**
	 * notify All Observers
	 */
	public void notifyAllObservers() {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		getOrders();
		 for(Observer OrderDetails: observerList) {
			 OrderDetails.update(null, sdf.format(calendar.getTime()));
					 	      
	   }
	}

		/**
		 * Getting orders
		 */
	public void getOrders()
	{
		
		System.out.println("GetOrderData");
		
		
	     	ArrayList<String>  max = new ArrayList<String>(); 
		    max = EchoServer.getMaxNumberOfOrderBooks();
		    System.out.println(max);
		
		
		    if(max.get(0).equals("dataSeleced")) {
	    	indexToOrderTable=max.get(1);
            index=Integer.parseInt(indexToOrderTable);
            System.out.println("The index is :"  +index);
            index2=index;
		    }
		    else
		    {
		    index=0;
		    index2=0;
		    }
            
		    while(index!=0) {
				
				
				OrderNumber++;
				
				
				ArrayList<String>  result = new ArrayList<String>(); 
				result = EchoServer.getOrderDataForObserver(OrderNumber);
				System.out.println("DataSelectedForOrder");
				
			    System.out.println(result);
				if(result.get(0)!="NotOkay")
				{		
					index--;
	    		String OrderNumber=result.get(1);
	    		int OrderNumber1=Integer.parseInt(OrderNumber);
	    		String StudentID=result.get(2);
	    		String StudentName =result.get(3);
	    		String Email=result.get(4);
	    		String BookID=result.get(5);
	    		String OrderDate=result.get(6);
	    		String OrderStatus=result.get(7);
	    		String EpiredDay=result.get(8);
	    		String copyID=result.get(9);
	    		String BookName=result.get(10);
	    		OrderDetails studentInOrder=new OrderDetails(StudentID,StudentName,Email,BookName,BookID,copyID,OrderDate,OrderStatus,OrderNumber1,EpiredDay);
	    		addObserver(studentInOrder);
	    		 
	    	}	 else
	    		
	   	    		 index--;
	    		    System.out.println("times ");
		    }
	}

	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true)
		{
			notifyAllObservers();
			OrderWait OrderWaitTask = new OrderWait(); 
			OrderWaitTask.start(); 
		}		
	}




	
	
    @Override
    /**
     * /** First of all we go to data base to bring all the data we are need 
    	 *  After that we make student and enter them to Observe List 
    	   At the end in notifyAllObservers() function we check which observer has to return book tomorrow 
     */
	public void addObserver(Observer OrderDetails) {
		// TODO Auto-generated method stub
    	
    	System.out.println(" Add ObserverList ");
		 observerList.add(OrderDetails);
	}
	
	

}




