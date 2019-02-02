import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OrderWaitDetails implements Observer{
	
	

	private String studentID;
	private String studentName;
	private String studentEmail;
	private String BookName;
	private String bookID;
	private String copyID;
	private String OrderDate;
	private String OrderStatus;
	private int    OrderNumber;
	private String ExpiredDay;
	
	long remindDays;
	
	public OrderWaitDetails(String studentID2, String studentName2, String studentEmail2, String BookName2,
			String bookID2, String copyID2,String OrderDate2,String OrderStatus2,int OrderNumber2,String ExpiredDay2) {
		// TODO Auto-generated constructor stub
		this.studentID = studentID2;
		this.studentName = studentName2;
		this.studentEmail = studentEmail2;
		this.BookName = BookName2;
		this.bookID = bookID2;
		this.copyID = copyID2;
		this.OrderDate=OrderDate2;
		this.OrderStatus=OrderStatus2;
		this.OrderNumber=OrderNumber2;
		this.ExpiredDay=ExpiredDay2;
	}
	

	
	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getBookID() {
		return bookID;
	}

	public void setBookID(String bookID) {
		this.bookID = bookID;
	}

	public String getCopyID() {
		return copyID;
	}

	public void setCopyID(String copyID) {
		this.copyID = copyID;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getOrderStatus() {
		return OrderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}

	public int getOrderNumber() {
		return OrderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		OrderNumber = orderNumber;
	}

	public String getExpiredDay() {
		return ExpiredDay;
	}

	public void setExpiredDay(String expiredDay) {
		ExpiredDay = expiredDay;
	}



	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("11111111");
   	    SimpleDateFormat twoDaysAfter = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar c2 = Calendar.getInstance();
	    c2.setTime(new Date()); // Now use today date.
	    String outputcurrentDate = twoDaysAfter.format(c2.getTime());
	    c2.add(Calendar.DATE, 2); // Adding 3 days
	    String OrderDate2 = twoDaysAfter.format(c2.getTime());
		
		ArrayList<String>  result1 = new ArrayList<String>(); 
		result1 = EchoServer.CheckOrderStatus(bookID,OrderNumber,OrderDate2);
		
		
		
		System.out.println(result1);
		System.out.println("11111111");
		
		
		if(result1.get(0)=="Okay") {
			
		
			
			
			 try{
	   	            String host ="smtp.gmail.com" ;
	   	            String user = "ortbraudelibrary.g27@gmail.com";
	   	            String pass = "Library123";
	   	            String to = studentEmail;
	   	            String from = "ortbraudelibrary.g27@gmail.com";
	   	            String subject = "ORT BRAUDE LIBRARY - The book you ordered in the library !";
	   	            String messageText =
	   	    	     		"Hello "+this.studentName+"\n\nThe Book you ordered is waiting for you!\nYou have until the Date : "+OrderDate2+" to take it. \n" 
	    	     								+ "\n\nBest regards,\nORT Braude Library";
	   	            boolean sessionDebug = false;

	   	            Properties props = System.getProperties();

	   	            props.put("mail.smtp.starttls.enable", "true");
	   	            props.put("mail.smtp.host", host);
	   	            props.put("mail.smtp.port", "587");
	   	            props.put("mail.smtp.auth", "true");
	   	            props.put("mail.smtp.starttls.required", "true");

	   	            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
	   	            Session mailSession = Session.getDefaultInstance(props, null);
	   	            mailSession.setDebug(sessionDebug);
	   	            Message msg1 = new MimeMessage(mailSession);
	   	            msg1.setFrom(new InternetAddress(from));
	   	            InternetAddress[] address = {new InternetAddress(to)};
	   	            msg1.setRecipients(Message.RecipientType.TO, address);
	   	            msg1.setSubject(subject); msg1.setSentDate(new Date());
	   	            msg1.setText(messageText);

	   	           Transport transport=mailSession.getTransport("smtp");
	   	           transport.connect(host, user, pass);
	   	           transport.sendMessage(msg1, msg1.getAllRecipients());
	   	           transport.close();
	   	           System.out.println("message send successfully");
	   	        }catch(Exception ex)
	   	        {
	   	            System.out.println(ex);
	   	        }
				
	   
		}
			
		
		ArrayList<String>  result2 = new ArrayList<String>(); 
		result2 = EchoServer.ExpiredDay(bookID,OrderNumber);
		System.out.println(result2);
		if(result2.get(0)=="Exist") {

			   SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
	 		    Calendar c1 = Calendar.getInstance();
	 		    c1.setTime(new Date()); // Now use today date.
	 		    String outputcurrentDate2 = currentDate.format(c1.getTime());
	 		    System.out.println(outputcurrentDate2);
	 		    
		        int diffDays=0;
	 			String date1 = outputcurrentDate2;
	 			String date2 = ( result2.get(1));//ExpiredDay ;
	 			
	 			System.out.println(date1);
	 			System.out.println(date2);
	 			
	 			String format = "dd/MM/yyyy";

	 			SimpleDateFormat sdf = new SimpleDateFormat(format);

	 			Date dateObj1 = null;
				try {
					dateObj1 = sdf.parse(date1);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 			Date dateObj2 = null;
				try {
					dateObj2 = sdf.parse(date2);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	 			System.out.println(dateObj1);
	 			System.out.println(dateObj2 + "\n");

	 			DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");

	 			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
	 			long diff = dateObj2.getTime() - dateObj1.getTime();

	 			 diffDays = (int) (diff / (24 * 60 * 60 * 1000));
	 			System.out.println("!!!!!difference between days: " + diffDays);
	 			System.out.println("Helllo112222211");
	 			if(diffDays<0) 
	 			{
	 				
	 				
	 				System.out.println("Helllo1111");
	 				ArrayList<String>  result3 = new ArrayList<String>(); 
	 				result3 = EchoServer.DeleteExpiredDay(bookID,OrderNumber);	
	 				System.out.println("Helllo");
	 				System.out.println(result3);
	            }
	 			
             }
	}
}