import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
public class RemindBeforeOneDay implements ReminderInterface, Runnable {

	List<Observer> observerList= new ArrayList<>(); 
	private static final DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static Thread t;
	public static int loanNumber=0;
	public static String indexToLoanTable;
	public static int indexToLoanTable2;
	public static int index;
	public static int index2;

	
	
	public  void start () {
			String threadName="notifyThread";
		    System.out.println("Starting " +  threadName );
		    if (t == null) {
		       t = new Thread (threadName);
		       run();  
		       System.out.println("Inside");
		    }
		    System.out.println("Outside");
		 }

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true)
		{
			notifyAllObservers();
			OrderCheck OrderRemindCheck = new OrderCheck();
			OrderRemindCheck.start();
		}		
	}
	
	@Override
	public void notifyAllObservers() {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		getData();
		 for(Observer StudentDetails: observerList) {
			 StudentDetails.update(null, sdf.format(calendar.getTime()));
			 	        }
	}
	
	
	

	public void getData()
	{
		
		System.out.println("GetData");
		String MaxNumberInLoanNumber = null;
		
		ArrayList<String>  max = new ArrayList<String>(); 
		max = EchoServer.getMaxNumberOfLoanBooks();
		System.out.println("Im here ");
		System.out.println("GetData2");
		System.out.println(max);
		
		
	    if(max.get(0).equals("dataSeleced"))
		     {
	    	System.out.println("inside");
	    	indexToLoanTable=max.get(1);
			index=Integer.parseInt(indexToLoanTable);
			index2=index;
		     }
	    else
	       {
	        index=0;
	        index2=0;
	        }
	    
		while(index!=0) {
		
		loanNumber++;
        
		String loanID=Integer.toString(loanNumber);
		ArrayList<String>  result = new ArrayList<String>(); 
		result = EchoServer.getDataForObserver(loanID);
		System.out.println("GetData3");
	    System.out.println(result);
	    
         if(result.get(0)!="NO") {
	    		String StudentID=result.get(2);
	    		String StudentName=result.get(3);
	    		String Email=result.get(4);
	    		String BookID=result.get(5);
	    		String LoanDate=result.get(6);
	    		String ReturnDate=result.get(7);
	    		String CopyID=result.get(8);
	    		String BookName=result.get(9);
	    		MaxNumberInLoanNumber=result.get(10);
	    		StudentDetails studentInLoan=new StudentDetails(StudentID,StudentName,Email,BookID,LoanDate,ReturnDate,CopyID,BookName);
	    		addObserver(studentInLoan);
         
	    		
	    		
	    		 indexToLoanTable2=Integer.parseInt(MaxNumberInLoanNumber);
	    		 if(indexToLoanTable2>index2)
	    			 index+=indexToLoanTable2-index2;
                } 
	    	     if(index>0)
	    		 index--;
	    	   
		}//while
		
	}

    @Override
	public void addObserver(Observer StudentDetails) {
		// TODO Auto-generated method stub
    	/** First of all we go to data base to bring all the data we are need 
    	 *  After that we make student and enter them to Observe List 
    	 *  At the end in notifyAllObservers() function we check which observer has to return book tomorrow */
    	System.out.println(" Add ObserverList ");
		 observerList.add(StudentDetails);
	}

	
}
