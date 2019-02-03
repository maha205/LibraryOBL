import java.io.IOException;
import java.text.DateFormat;
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


/**
 * 
 * Student Details
 *
 */
public class StudentDetails implements Observer {

	
	private String studentID;
	private String studentName;
	private String studentEmail;
	private String bookID;
	private String copyID;
	private String loanBook;
	private String returnBook;
	private String bookName;
	long remindDays;
	
	

	public StudentDetails(String studentID2, String studentName2, String studentEmail2, String bookSerialNumer,
			String loanBook2, String returnBook2,String copyID2,String bookName2) {
		// TODO Auto-generated constructor stub
		this.studentID = studentID2;
		this.studentName = studentName2;
		this.studentEmail = studentEmail2;
		this.bookID = bookSerialNumer;
		this.loanBook = loanBook2;
		this.returnBook = returnBook2;
		this.copyID=copyID2;
		this.bookName=bookName2;
	}

	
	@Override
	/**
	 * Update method
	 */
	public void update(Observable o, Object dateOfTheDay) {
		
		System.out.println("date of the day "+(String)dateOfTheDay);
		System.out.println("Return Date "+this.returnBook);
		
		
		
		
		DateFormat formatter;
		Date returnDate = null,currentDate = null;
		formatter = new SimpleDateFormat("ddddd/MM/yy");
		try {
			returnDate = formatter.parse(this.returnBook);
			currentDate=formatter.parse((String)dateOfTheDay);
			System.out.println(returnDate);
			System.out.println(currentDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 remindDays = (int)( (returnDate.getTime() - currentDate.getTime())/ (1000 * 60 * 60 * 24) );
		 System.out.println("remind Days  : " + remindDays);
		 
		 if(remindDays==1)
		 {
			 System.out.println(this.studentName+ " have to return book tomorrow ");
			 System.out.println("student ID :"+this.studentID+" name  "+this.studentName+" email "+this.studentEmail);
			 System.out.println("book ID :"+this.bookID+" loan date  "+this.loanBook+" returndate "+this.returnBook);			 
			
			 ////////////////////sent Email 

			 try{
	   	            String host ="smtp.gmail.com" ;
	   	            String user = "ortbraudelibrary.g27@gmail.com";
	   	            String pass = "Library123";
	   	            String to = studentEmail;
	   	            String from = "ortbraudelibrary.g27@gmail.com";
	   	            String subject = "ORT BRAUDE LIBRARY - Reminder to return Library Book !";
	   	            String messageText ="Reminder ! Ort Braude Library"
	   	    	     		+ "\nHello "+this.studentName+"\n\n In "+this.loanBook+" you lent the Book :"+this.bookName+" \n" 
	    	     				+ "With serial Id "+this.bookID+""
	    	     						+ "\nThis Email sent to remind you , that you have to return the book tomorrow \n"
	    	     				         +" Return Date:"+this.returnBook+""
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
		 
		 
		 
		 if(remindDays<0) {
			 

			    ArrayList<String>  result = new ArrayList<String>(); 
		        EchoServer.increaseDelayTimes(studentID);
		        
		   	 ////////////////////sent Email 

				 try{
		   	            String host ="smtp.gmail.com" ;
		   	            String user = "ortbraudelibrary.g27@gmail.com";
		   	            String pass = "Library123";
		   	            String to = studentEmail;
		   	            String from = "ortbraudelibrary.g27@gmail.com";
		   	            String subject = "ORT BRAUDE LIBRARY - Frozen Account !";
		   	            String messageText ="Reminder ! Ort Braude Library"
		   	    	     		+ "\nHello "+this.studentName+"\n\nYour account has been frozen due to your late in return the book"; 
		    	     					
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
		 
	}
	
	/**
	 * Getting studentID
	 * @return studentID
	 */
	public String getstudentID() {
		return studentID;
	}


	/**
	 * Setting studentID
	 * @param studentID
	 */
	public void setstudentID(String studentID) {
		this.studentID = studentID;
	}


	/**
	 * Getting studentName
	 * @return studentName
	 */
	public String getstudentName() {
		return studentName;
	}


	/**
	 * Setting studentName
	 * @param studentName
	 */
	public void setstudentName(String studentName) {
		this.studentName = studentName;
	}


	/**
	 * Getting studentEmail
	 * @return studentEmail
	 */
	public String getstudentEmail() {
		return studentEmail;
	}


	/**
	 * Setting studentEmail
	 * @param studentEmail
	 */
	public void setstudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}


	/**
	 * Getting bookID
	 * @return bookID
	 */
	public String getbookID() {
		return bookID;
	}


	/**
	 * Setting bookID
	 * @param bookID
	 */
	public void setBbookID(String bookID) {
		this.bookID = bookID;
	}


	/**
	 * Getting loanBook
	 * @return loanBook
	 */
	public String getloanBook() {
		return loanBook;
	}


	/**
	 * Setting loanBook
	 * @param loanBook
	 */
	public void setloanBook(String loanBook) {
		this.loanBook = loanBook;
	}

	

	/**
	 * Getting returnBook
	 * @return returnBook
	 */
	public String getreturnBook() {
		return returnBook;
	}


	/**
	 * Setting returnBook
	 * @param returnBook
	 */
	public void setreturnBook(String returnBook) {
		this.returnBook = returnBook;
	}

	/**
	 * Getting copyID
	 * @return copyID
	 */
	public String getcopyID() {
		return copyID;
	}


	/**
	 * Setting copyID
	 * @param copyID
	 */
	public void setcopyID(String copyID) {
		this.copyID = copyID;
	}
	
	/**
	 * Getting bookName
	 * @return bookName
	 */
	public String getbookName() {
		return bookName;
	}


	/**
	 * Setting bookName
	 * @param bookName
	 */
	public void setbookName(String bookName) {
		this.bookName = bookName;
	}
	
	
}
