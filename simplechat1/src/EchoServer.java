// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.sql.*;
import java.text.DecimalFormat;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import ocsf.server.*;
import java.util.*;
import java.util.Date; 
/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
	static Connection conn ; 
	private Logger logger = new Logger(true);
	private int day;
	private int month;
	private int year;
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */

  public void handleMessageFromClient(Object message, ConnectionToClient client)
  {
	    System.out.println("Message received: " + message + " from " + client);
	    ArrayList<String> msg= new ArrayList<String>();
	    msg = (ArrayList<String>) message ; 
	    switch(msg.get(msg.size()-1))
	    {
	      case "GetData":
	    	 msg = (printCUserData(msg.get(0)));
			 System.out.println("Return User data");
	    	 break;
	    	
	      case "Update":
	    	msg = UpdatedUserStatusMembership(msg.get(0),msg.get(1));
	    	 System.out.println("Update User data");
	    	break;
	    	
	      case "login":
		    	 msg = (loginUser(msg.get(0),msg.get(1))); //student login
				 System.out.println("login User");
		    	 break;
		    	 
	      case "UpdateEmailStudent":
	    	     msg = (UpdatedStudentEmail(msg.get(0),msg.get(1))); //student email update
				 System.out.println("Update student Email");
		    	 break;
		    	 
	      case "UpdatephontStudent":
	    	  msg = (UpdatedStudentPhone(msg.get(0),msg.get(1))); //student email update
			  System.out.println("Update student Phone");
		      break;
		      
	      case "UpdatePasswordStudent":
	    	  msg = (UpdatedStudentPassword(msg.get(0),msg.get(1),msg.get(2),msg.get(3))); //student password update
			  System.out.println("Update student Password");
		      break;
		      
	      case "UpdateEmailLibrarian":
	    	     msg = (UpdatedLibrarianEmail(msg.get(0),msg.get(1))); //student email update
				 System.out.println("Update Librarian Email");
		    	 break;
		    	 
	      case "UpdatephontLibrariant":
	    	  msg = (UpdatedLibrarianPhone(msg.get(0),msg.get(1))); //student email update
			  System.out.println("Update Librarian Phone");
		      break;
		      
	      case "UpdatePasswordLibrarian":
	    	  msg = (UpdatedLibrarianPassword(msg.get(0),msg.get(1),msg.get(2),msg.get(3))); //student password update
			  System.out.println("Update Librarian Password");
		      break;
		      
	      case "UpdatedManagementPassword":
	    	  msg=UpdatedManagementPassword(msg.get(0),msg.get(1),msg.get(2),msg.get(3));
	    	  System.out.println("Update Management Password");
		      break;
		      
	      case "signUP":
	    	  msg = signUp(msg.get(0),msg.get(1),msg.get(2),msg.get(3));
	    	  System.out.println("Insert Student");
		      break;
		      
	      case "ExtendLoan":
			try {
				msg = ExternLoanBook(msg.get(0),msg.get(1));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	  System.out.println("Extern Loan Book");
	      break;
	      
	      case "ShowOrderBook":
	    	  try {
				msg=ShowOrderBook(msg.get(0),msg.get(1),msg.get(2));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	  System.out.println("Show Order Book");
		      break;
	   
	     case "approvedOrderBook":
	    	 try {
				msg=approvedOrderBook(msg.get(0),msg.get(1),msg.get(2));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 System.out.println("Order Book");
		     break;
	    	 
	     case "StudentToEditByLibrarian":
	    	 try {
				msg =StudentToEditByLibrarian(msg.get(0));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	 System.out.println("show student info to librarian ");
		     break;
		     
	     case "addBook":
	    	try {
	    		int CopyQuantityy = Integer.parseInt(msg.get(7));
	    		System.out.println("mahaaaa");
				msg=AddBook(msg.get(0),msg.get(1),msg.get(2),msg.get(3),msg.get(4),msg.get(5),msg.get(6), CopyQuantityy,msg.get(8));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	 System.out.println("Add Book");
		     break;
		     
	     case "LibrarianEmail":
			try {
				msg =LibrarianEmail();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	     System.out.println("Send Email to librarian");
	     break;
		    
	     case "ResetPasswordRequest":
			try {
				msg =ResetPasswordRequest(msg.get(0));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	      System.out.println("Reset Password Request");
		     break;
		     
	     case "LoanSearch":  ///JERIES
	    	  msg = LoanSearch(msg.get(0));
		      break;
	      case "SearchInCopy":  ///JERIES 
	    	  msg = SearchInCopy(msg.get(0));
		      break;
	      case "AddItemInLoan":   /// JERIES
	    	  msg = AddItemInLoan(msg.get(0), msg.get(1), msg.get(2), msg.get(3));
		      break;
	      case "CheckStudentStatus":   /// JERIES
	    	  msg = CheckStudentStatus(msg.get(0));
		      break;
	    }
	    
	    try {
    	System.out.println(msg);
		client.sendToClient(msg);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
    
    printStatus();
  }
	protected void printStatus() {
		logger.info("Status");
		logger.info("\t[Server is " + (this.isListening() == true ? "online" : "offline"));
		logger.info("\t[Port " + this.getPort());
		logger.info("\t[Clients connected " + this.getNumberOfClients());
		logger.info("-------------------------");
	}
  
	protected void clientConnected(ConnectionToClient client) {
		System.out.println("New client connected: " + client.getInetAddress() + ", total : " + this.getNumberOfClients());
	}

	protected void clientDisconnected(ConnectionToClient client) {
		System.out.println(" client disconnected: " + client.getInetAddress() + ", total : " + this.getNumberOfClients());
	}
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
 * @throws SQLException 
   */
  public static void main(String[] args)  throws IOException, SQLException 
  {
    int port = 0; //Port to listen on
    connectToDB();
    UpdatedManagementPassword("123456789" ,"123456789" ,"1" ,"1");
    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
  //connectToDB() func to connect to data base //schema's name : librarysys
  public static void connectToDB()
  {
	try 
	{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
    } catch (Exception ex) {/* handle the error*/}
    
    try 
    {
       conn = DriverManager.getConnection("jdbc:mysql://localhost/librarysys","root","Aa123456");
      System.out.println("SQL connection succeed");
 	}catch (SQLException ex) 
 	 {/* handle any errors*/
       System.out.println("SQLException: " + ex.getMessage());
       System.out.println("SQLState: " + ex.getSQLState());
 	   System.out.println("VendorError: " + ex.getErrorCode());
 	 }
  }
  
  //printCUserData(String studentID) get studen ID and print all the data for the student 
    public static ArrayList<String> printCUserData(String studentID)
	{
		Statement stmt;
		ArrayList<String> studentsInfo = new ArrayList<String>();
	
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student  WHERE StudentId = "+studentID);
	 		if(rs.next())
	 		{
	 			studentsInfo.add(""+rs.getString(1));
	 			studentsInfo.add(""+rs.getString(2));
	 			studentsInfo.add(""+rs.getString(3));
	 			studentsInfo.add(""+rs.getString(4));
	 			studentsInfo.add(""+rs.getString(5));
	 			studentsInfo.add("GetData");
	 			return studentsInfo;
			}
	 		
		  else
		  {
			   rs.close();
	 			return studentsInfo ;
		  }
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println(studentsInfo);
		return studentsInfo;
	}
  
    //printCUserData(String studentID) get studen ID and print all the data for the student 
    public static ArrayList<String> UpdatedUserStatusMembership(String studentID,String SStatusMembership)
	{
		Statement stmt;
		ArrayList<String> update = new ArrayList<String>();
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student  WHERE StudentId = "+studentID);
			
	 		if(rs.next())//if the student is existing 
	 		{
	 			stmt.executeUpdate("UPDATE student SET StatusMembership ='"+SStatusMembership+"' WHERE StudentId = '"+studentID+"';");
	 			update.add(SStatusMembership);
	 			return update;
	 		}
			
	 		 else
			  {
				   rs.close();
		 			return update ;
			  }
		} catch (SQLException e) {e.printStackTrace();}
		return update;
	}

    //loginUser(String studentID,String pass) get user ID and passsword and return if the user is subscription or not
    public static ArrayList<String> loginUser(String UserID,String pass)
    {
    	Statement stmt;
		ArrayList<String> UserLogin = new ArrayList<String>();
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM userstudent  WHERE UserID = "+UserID);
	 		if(rs1.next())//if the student is existing 
	 		{
	 			if(rs1.getString(2).equals(pass))
	 		    	UserLogin.add("student");
	 			return UserLogin;
	 		}
	 		rs1.close();
		} catch (SQLException e) {e.printStackTrace();}	
	
		return loginUserLibririan (UserID, pass);
    }
    public static ArrayList<String> loginUserLibririan(String UserID,String pass)
    {
    	Statement stmt;
		ArrayList<String> UserLogin = new ArrayList<String>();
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM useworker  WHERE userID = "+UserID);
	 		if(rs1.next())//if the student is existing 
	 		{
	 			if(rs1.getString(2).equals(pass))
	 			  UserLogin.add("librarian");
	 			return UserLogin;
	 		}
	
	 		rs1.close();
		} catch (SQLException e) {e.printStackTrace();}	
		return loginUsermanagement (UserID, pass);
    }
    public static ArrayList<String> loginUsermanagement(String UserID,String pass)
    {
    	Statement stmt;
		ArrayList<String> UserLogin = new ArrayList<String>();
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM usermanagement  WHERE UserID = "+UserID);
	 		if(rs1.next())//if the student is existing 
	 		{
	 			if(rs1.getString(2).equals(pass))
	 			  UserLogin.add("management");
	 			return UserLogin;
	 		}
	
	 		rs1.close();
		} catch (SQLException e) {e.printStackTrace();}	
		return UserLogin;
    }
    public static ArrayList<String> UpdatedStudentEmail(String studentID,String Email)
	{
		Statement stmt;
		ArrayList<String> update = new ArrayList<String>();
		try 
		{
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM student  WHERE StudentId = "+studentID);
			
	 		if(rs.next())//if the student is existing 
	 		{
	 			stmt.executeUpdate("UPDATE student SET Email ='"+Email+"' WHERE StudentId = '"+studentID+"';");
	 			update.add(Email);
	 			  rs.close();
	 			return update;
	 		}
		} catch (SQLException e)
		{
			e.printStackTrace();
			return update;
		}
		return update;
	}
    public static ArrayList<String> UpdatedStudentPhone(String studentID,String Phone)
   	{
   		Statement stmt;
   		ArrayList<String> update = new ArrayList<String>();
   		try 
   		{
   			stmt = conn.createStatement();
   			ResultSet rs = stmt.executeQuery("SELECT * FROM student  WHERE StudentId = "+studentID);
   			
   	 		if(rs.next())//if the student is existing 
   	 		{
   	 			stmt.executeUpdate("UPDATE student SET phone ='"+Phone+"' WHERE StudentId = '"+studentID+"';");
   	 			update.add(Phone);
   	 			  rs.close();
   	 			return update;
   	 		}
   		} catch (SQLException e)
   		{
   			e.printStackTrace();
   			return update;
   		}
   		return update;
   	}
    public static ArrayList<String> UpdatedStudentPassword(String UserID,String oldPass ,String newPass ,String AssertPass)
   	{
   		Statement stmt;
   		ArrayList<String> update = new ArrayList<String>();
   		try 
   		{
   			stmt = conn.createStatement();
   			ResultSet rs = stmt.executeQuery("SELECT * FROM userstudent WHERE UserID ='"+UserID+"';");
   			
   	 		if(rs.next() && newPass.equals(AssertPass) && rs.getString(2).equals(oldPass))//if the student is existing 
   	 		{
   	 		   stmt.executeUpdate("UPDATE userstudent SET Password ='"+newPass+"' WHERE UserID ='"+UserID+"';");
   	 		   update.add(newPass);
   	 		   rs.close();
   	 	       return update;
   	 		}
   		} catch (SQLException e)
   		{
   			e.printStackTrace();
   			return update;
   		}
   		return update;
   	}
    public static ArrayList<String> UpdatedLibrarianEmail(String LibrariandentID,String Email)
  	{
  		Statement stmt;
  		ArrayList<String> update = new ArrayList<String>();
  		try 
  		{
  			stmt = conn.createStatement();
  			ResultSet rs = stmt.executeQuery("SELECT * FROM librarian WHERE Id = "+LibrariandentID);
  			
  	 		if(rs.next())//if the librarian is existing 
  	 		{
  	 			stmt.executeUpdate("UPDATE librarian SET email ='"+Email+"' WHERE Id = '"+LibrariandentID+"';");
  	 			update.add(Email);
  	 			  rs.close();
  	 			return update;
  	 		}
  		} catch (SQLException e)
  		{
  			e.printStackTrace();
  			return update;
  		}
  		return update;
  	}
      public static ArrayList<String> UpdatedLibrarianPhone(String LibrariandentID,String Phone)
     	{
     		Statement stmt;
     		ArrayList<String> update = new ArrayList<String>();
     		try 
     		{
     			stmt = conn.createStatement();
     			ResultSet rs = stmt.executeQuery("SELECT * FROM librarian WHERE Id = "+LibrariandentID);
     			
     	 		if(rs.next())//if the librarian is existing 
     	 		{
     	 			stmt.executeUpdate("UPDATE librarian SET phone ='"+Phone+"' WHERE Id = '"+LibrariandentID+"';");
     	 			update.add(Phone);
     	 			  rs.close();
     	 			return update;
     	 		}
     		} catch (SQLException e)
     		{
     			e.printStackTrace();
     			return update;
     		}
     		return update;
     	}
      public static ArrayList<String> UpdatedLibrarianPassword(String UserID,String oldPass ,String newPass ,String AssertPass)
      {
     		Statement stmt;
     		ArrayList<String> update = new ArrayList<String>();
     		try 
     		{
     			stmt = conn.createStatement();
     			ResultSet rs = stmt.executeQuery("SELECT * FROM useworker WHERE userID ="+UserID);
     			
     	 		if(rs.next() && newPass.equals(AssertPass) && rs.getString(2).equals(oldPass))//if the librarian is existing 
     	 		{
     	 		   stmt.executeUpdate("UPDATE useworker SET password ='"+newPass+"' WHERE UserID ='"+UserID+"';");
     	 		   update.add(newPass);
     	 		   rs.close();
     	 	       return update;
     	 		}
     		} catch (SQLException e)
     		{
     			e.printStackTrace();
     			return update;
     		}
     		return update;
     }
      public static ArrayList<String> UpdatedManagementPassword(String UserID,String oldPass ,String newPass ,String AssertPass)
      {
     		Statement stmt;
     		ArrayList<String> update = new ArrayList<String>();
     		try 
     		{
     			stmt = conn.createStatement();
     			ResultSet rs = stmt.executeQuery("SELECT * FROM usermanagement WHERE UserID ='"+UserID+"';");
     			
     	 		if(rs.next() && newPass.equals(AssertPass) && rs.getString(2).equals(oldPass))//if the librarian is existing 
     	 		{
     	 		   stmt.executeUpdate("UPDATE usermanagement SET Pass ='"+newPass+"' WHERE UserID ='"+UserID+"';");
     	 		   update.add(newPass);
     	 		   rs.close();
     	 	       return update;
     	 		}
     		} catch (SQLException e)
     		{
     			e.printStackTrace();
     			return update;
     		}
     		return update;
     }
      
      
      public static ArrayList<String> signUp(String studentID,String name,String Email ,String phoneNumber)
      {
     		Statement stmt;
     		ArrayList<String> update = new ArrayList<String>();
     		try 
     		{
     			stmt = conn.createStatement();
     			ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE StudentId ="+studentID);
     			
     	 		if(!rs.next())//if the student is not existing 
     	 		{
     	 		   stmt.executeUpdate("INSERT INTO student (StudentId ,StudentName ,Email,phone) VALUES('"+studentID+"','"+name+"','"+Email+"','"+phoneNumber+"')");
     	 		   stmt.executeUpdate("INSERT INTO userstudent (UserID ,Password ) VALUES('"+studentID+"','"+studentID+"')");
     	 		   update.add("signUP");
     	 		   rs.close();
     	 	       return update;
     	 		}
     		} catch (SQLException e)
     		{
     			e.printStackTrace();
     			return update;
     		}
     		return update;
     }
      
      public static ArrayList<String> ExternLoanBook(String Studentid ,String bookName)  throws SQLException 
      {
    	Statement stmt ,stmt2;
    	String oldDate = null;
    	int diffDays = 0;
   		ArrayList<String> Extern = new ArrayList<String>();
   		String copyID = null  ,outputtwoWeeksAfter = null ,bookID=null ;
   		
 		stmt = conn.createStatement();
 		ResultSet rs2 = stmt.executeQuery("SELECT * FROM book WHERE bookName ='"+bookName+"';");
 		
 		if(rs2.next())
 		{
 			bookID=rs2.getString(1);
 			System.out.println(bookID);
 			ResultSet rs = stmt.executeQuery("SELECT * FROM iteminloan WHERE StudentID ="+Studentid);
 			if(rs.next())
 			{
 		     copyID = rs.getString(3);
 		     System.out.println(copyID);
 			
 	 		  if( rs.getString(2).equals(bookID) && rs.getString(3).equals(copyID))//if the student loan the book
 	 		  {
 	 			stmt2 = conn.createStatement();
 	 			ResultSet rs1 = stmt2.executeQuery("SELECT * FROM copy WHERE idcopy ="+copyID);
 	 			
 	 	        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
 	 		    Calendar c1 = Calendar.getInstance();
 	 		    c1.setTime(new Date()); // Now use today date.
 	 		    String outputcurrentDate = currentDate.format(c1.getTime());
 	 		    System.out.println(outputcurrentDate);
 	
 	 	       try {
 	 			String date1 = outputcurrentDate;
 	 			String date2 = rs.getString(6);//return day ;
 	 			 oldDate = date2;
 	 			String format = "dd/MM/yyyy";

 	 			SimpleDateFormat sdf = new SimpleDateFormat(format);

 	 			Date dateObj1 = sdf.parse(date1);
 	 			Date dateObj2 = sdf.parse(date2);
 	 			System.out.println(dateObj1);
 	 			System.out.println(dateObj2 + "\n");

 	 			DecimalFormat crunchifyFormatter = new DecimalFormat("###,###");

 	 			// getTime() returns the number of milliseconds since January 1, 1970, 00:00:00 GMT represented by this Date object
 	 			long diff = dateObj2.getTime() - dateObj1.getTime();

 	 			 diffDays = (int) (diff / (24 * 60 * 60 * 1000));
 	 			System.out.println("difference between days: " + diffDays);


 	 		} catch (Exception e) {
 	 			e.printStackTrace();
 	 		}
 	 			
 	 			if(rs1.next() && rs1.getInt(5)==0 && diffDays <= 7 && diffDays >= 0) //there are no orders for this book 
 	 			{	 	 		
 	 	 		    SimpleDateFormat twoWeeksAfter = new SimpleDateFormat("dd/MM/yyyy");
 	 	 		    Calendar c2 = Calendar.getInstance();
 	 	 		    c2.setTime(new Date()); // Now use today date.
 	 	 		    c2.add(Calendar.DATE, 14); // Adding 14 days
 	 	 		    outputtwoWeeksAfter = twoWeeksAfter.format(c2.getTime());
 	 	 		
 	 	 		     Extern.add(outputtwoWeeksAfter);
 	 	 		     Extern.add(oldDate);
 	 				 stmt.executeUpdate("UPDATE iteminloan SET loanDate ='"+outputcurrentDate+"' WHERE BookID ='"+bookID+"' AND CopyID ='"+copyID+"';");
 	 				 stmt.executeUpdate("UPDATE iteminloan SET returnDate ='"+outputtwoWeeksAfter+"' WHERE BookID ='"+bookID+"' AND CopyID ='"+copyID+"';");
 	 				 Extern.add("Extern");
 	 				 
 	 			}
 	 		  }
 	 		   rs.close();
 	 		 return Extern;
 	 		}
 		}
 		
   		return Extern;
      }
      
      public static ArrayList<String> ShowOrderBook(String Studentid ,String bookId ,String copyID)  throws SQLException 
      {
    	Statement stmt ,stmt1,stmt2;
   		ArrayList<String> Order = new ArrayList<String>();
   		stmt1 = conn.createStatement();
	    ResultSet rs3 = stmt1.executeQuery("SELECT * FROM book WHERE bookID ="+bookId);
   		if(rs3.next() && rs3.getInt(9) < rs3.getInt(8))
   		{
 			stmt = conn.createStatement();
 			ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE StudentID ="+Studentid);
 			if(rs.next())
 			{
 		    	Order.add(rs.getString(2));//Student Name
 		    	Order.add(Studentid);//Student ID
 		    	Order.add(rs.getString(6));//Student phone Number
 		    	Order.add(rs.getString(7));//Student E-mail
 		    	
 		    	stmt2 = conn.createStatement();
 	 			ResultSet rs1 = stmt2.executeQuery("SELECT * FROM book WHERE bookID ='"+bookId+"';");
 	 			if(rs1.next())
 	 			{
 	 				Order.add(rs1.getString(2));//Book Name
 	 				Order.add(bookId);//Book ID
 		 		    Order.add(copyIDtoOrder(bookId));//copy ID to order
 	 			}
 	 			
 	 	        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
 	 		    Calendar c1 = Calendar.getInstance();
 	 		    c1.setTime(new Date()); // Now use today date.
 	 		    String outputcurrentDate = currentDate.format(c1.getTime());
 	 		    System.out.println(outputcurrentDate);
 	 		    Order.add(outputcurrentDate);//current Date
 	 	      
 	 		
 	 		   rs.close();
 	 		 return Order;
 	 		}
   		}
 			return Order;

      }
      public static ArrayList<String> approvedOrderBook(String Studentid ,String bookId ,String copyID)  throws SQLException 
      {
    	Statement stmt ,stmt1,stmt2,stmt3;
   		ArrayList<String> Order = new ArrayList<String>();
   		
   	    SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar c1 = Calendar.getInstance();
	    c1.setTime(new Date()); // Now use today date.
	    String outputcurrentDate = currentDate.format(c1.getTime());
	    System.out.println(outputcurrentDate);
	    
   		stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT * FROM book WHERE bookID ="+bookId);
   		if(rs.next() && rs.getInt(9)< rs.getInt(8))
   		{
   		    copyID=copyIDtoOrder(bookId);
   		    if(!(copyID.equals("")))
   		    {
   		    	int OrderNumber = rs.getInt(9) + 1 ;//Order Qantity
   		    	int OrderStatus = 1;
   		    	
   		    	stmt2 = conn.createStatement();
   	   		    stmt2.executeUpdate("UPDATE book SET OrderQantity ='"+OrderNumber+"' WHERE  bookID ="+bookId);
   	   		    
   	   		    stmt3 = conn.createStatement();
			    stmt3.executeUpdate("INSERT INTO booksorder (StudentID ,BookID ,CopyID,OrderDate ,OrderStatus,OrderNumber) VALUES('"+Studentid+"','"+bookId+"','"+copyID+"','"+outputcurrentDate+"' ,'"+OrderStatus+"' , '"+OrderNumber+"')");
			   
			    
   		    	stmt1 = conn.createStatement();
   		    	stmt1.executeUpdate("UPDATE copy SET orderBook = '"+OrderStatus+"' WHERE idcopy = '"+copyID+"' AND bookID ='"+bookId+"';");
   			    
   		        Order.add("ApprovedThisOrder");
   		    }
   		}
 		return Order;
      }
      
      public static String copyIDtoOrder(String bookId)  throws SQLException 
      {
    	  Statement stmt;
    	  String copID=null;
    	  stmt = conn.createStatement();
  	      ResultSet rs = stmt.executeQuery("SELECT * FROM copy WHERE bookID ="+bookId);
  	      
  		  while(rs.next())
  		  {
  		    if(rs.getInt(5)==0)//copy to order
  		    {
  		       copID=rs.getString(1);
  		       return copID;
  		    }
  		  }
		return copID;
      } 
      
      public static ArrayList<String> StudentToEditByLibrarian(String studentID) throws SQLException 
  	{
  		Statement stmt ,stmt1;
  		ArrayList<String> studentsInfo = new ArrayList<String>();
  	
  		try 
  		{
  			stmt = conn.createStatement();
  			ResultSet rs = stmt.executeQuery("SELECT * FROM student  WHERE StudentId = "+studentID);
  	 		if(rs.next())
  	 		{
  	 			studentsInfo.add(studentID);//Student ID
  	 			studentsInfo.add(rs.getString(2));//Student name
  	 			studentsInfo.add(rs.getString(7));//Student Email
  	 			studentsInfo.add(rs.getString(6));//Student Phone Number
  	 	
  	 			stmt1 = conn.createStatement();
  	  			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM userstudent  WHERE UserID = "+studentID);
  	  			
  	  			if(rs1.next()) 
  	  			   studentsInfo.add(rs1.getString(2));//Student Password
  	  			
  	  			
  	 			return studentsInfo;
  			}
  	 		
  		  else
  		  {
  			   rs.close();
  	 			return studentsInfo ;
  		  }
  		} catch (SQLException e)
  		{
  			e.printStackTrace();
  		}
  		System.out.println(studentsInfo);
  		return studentsInfo;
  	}
      

      public static ArrayList<String> AddBook(String bookId ,String bookName , String bookAuthor , String genre,String description,String publisher,String printdate ,int copyQuantity , String Location) throws SQLException 
      {
    		ArrayList<String> AddBook = new ArrayList<String>();
    		Statement stmt , stmt1 ;
       		
       		stmt = conn.createStatement();
    	    ResultSet rs = stmt.executeQuery("SELECT * FROM book WHERE bookID ="+bookId);
       		if(!rs.next())
       		{
       		      int ordeQuantity =0;
    			  stmt.executeUpdate("INSERT INTO book (bookID,bookName,AuthorName,genre,description,publisher,printdate,copyQuantity,OrderQantity) VALUES('"+bookId+"','"+bookName+"','"+bookAuthor+"','"+genre+"' ,'"+description+"' , '"+publisher+"','"+printdate+"','"+copyQuantity+"','"+ordeQuantity+"')"); 
       		      AddBook.add("newBookAdded");
       		      System.out.println("hiiiiiiii");
       		       for(int i=1 ; i<=copyQuantity ;i++)
       		       {
       		    	   String locationShelf = Location  ,stutus = "available" ,copyID = "" +i;
       		    	   locationShelf += "-";
       		    	   locationShelf+= ""+ i  ;
       		    	   String ordercopy = "0";
       		    	    
       		    	   stmt1 = conn.createStatement();
        			   stmt1.executeUpdate("INSERT INTO copy (idcopy,locationShelf,status,bookID) VALUES('"+copyID+"','"+ locationShelf+"','"+stutus+"','"+bookId+"')");
       		           stmt1.executeUpdate("UPDATE copy SET orderBook ="+ordercopy+" WHERE  idcopy ='"+copyID+"' AND bookID ='"+bookId+"';") ;
       		       }
       		}
     	
    		return AddBook;
      }
      
      public static ArrayList<String> RemoveBook(String studentID) throws SQLException 
      {

    		ArrayList<String> RemoveBook = new ArrayList<String>();
    		return RemoveBook;
      }
      public static ArrayList<String> UpdateBook(String studentID) throws SQLException 
      {

    		ArrayList<String> UpdateBook = new ArrayList<String>();
    		return UpdateBook;
      }
      
      public static ArrayList<String> LibrarianEmail() throws SQLException 
      {
    	 ArrayList<String> LibrarianEmail = new ArrayList<String>();
    	 Statement stmt ;
    	 String Name="" ;
    	stmt = conn.createStatement();
 	    ResultSet rs = stmt.executeQuery("SELECT *FROM librarian");
        while(rs.next())
        {
        	LibrarianEmail.add(rs.getString(5));//Email
        	Name += rs.getString(2);
        	Name +=" ";
        	Name +=rs.getString(3);
        	LibrarianEmail.add(Name);// Name
        	
        	System.out.println(Name);
        	System.out.println(rs.getString(5));
        	
        	Name ="";
        }
  		return LibrarianEmail;
      }
      public static ArrayList<String> ResetPasswordRequest(String UserID) throws SQLException 
      {
    	 ArrayList<String> LibrarianEmail = new ArrayList<String>();
    	 Statement stmt ;
    	 stmt = conn.createStatement();
 	     ResultSet rs = stmt.executeQuery("SELECT *FROM useworker");
        while(rs.next())
        {
        	if(rs.getString(1).equals(UserID))
        	{
        		LibrarianEmail.add("Librarian User");
        		LibrarianEmail.add(rs.getString(2));//oldPassword
        	}
        }
        
        rs = stmt.executeQuery("SELECT *FROM userstudent");
        while(rs.next())
        {
        	if(rs.getString(1).equals(UserID))
        	{
        		LibrarianEmail.add("Student User");
        		LibrarianEmail.add(rs.getString(2));//oldPassword
        	}
        }
        
        rs = stmt.executeQuery("SELECT *FROM usermanagement");
        while(rs.next())
        {
        	if(rs.getString(1).equals(UserID))
        	{
        		LibrarianEmail.add("Management User");
        		LibrarianEmail.add(rs.getString(2));//oldPassword
        	}
        }
        
  		return LibrarianEmail;
      }
      public static ArrayList<String> LoanSearch(String BookName)   ////JERIES
      {
      	Statement stmt;
  		ArrayList<String> BookInfo = new ArrayList<String>();
  		try 
  		{
  			stmt = conn.createStatement();
  			System.out.println("hi");
  			ResultSet rs1 = stmt.executeQuery("SELECT * FROM book  WHERE bookName = '"+BookName+"';");
  			System.out.println("hi2");
  	 		if(rs1.next())
  	 		{
  	 			BookInfo.add(rs1.getString(1));
  	 			BookInfo.add(rs1.getString(2));
  	 			BookInfo.add(rs1.getString(3));
  	 			BookInfo.add(rs1.getString(4));
  	 			BookInfo.add(rs1.getString(5));
  	 			BookInfo.add(rs1.getString(6));
  	 			return BookInfo;
  	 		}else BookInfo.add("No");
  	 		
  	 	
  	 		    rs1.close();
  	 		    return BookInfo;
  		} catch (SQLException e) {e.printStackTrace();}
	    return BookInfo;
      }

public static ArrayList<String> SearchInCopy(String BookID)   ////JERIES
{
	Statement stmt;
	ArrayList<String> BookInfo = new ArrayList<String>();
	try 
	{
		stmt = conn.createStatement();
		ResultSet rs1 = stmt.executeQuery("SELECT idcopy FROM copy WHERE bookID = '"+BookID+"' AND status = 'available';");
		
		if(rs1.next()) {
		BookInfo.add(rs1.getString(1));
		BookInfo.add(rs1.getString(2));
		BookInfo.add(rs1.getString(3));
		 return BookInfo;
		}
		else BookInfo.add("NO"); 
		rs1.close();
	/*	while(rs1.next()){
		BookInfo.add(rs1.getString(i));	
			i++;
		}*/
	} catch (SQLException e) {e.printStackTrace();}
	
  return BookInfo;
  
  }


public static ArrayList<String> CheckStudentStatus(String StudentID)   ////JERIES
{
	Statement stmt;
	Statement stmt1;
	ArrayList<String> StatusMembership = new ArrayList<String>();
	try 
	{
		stmt = conn.createStatement();
		ResultSet rs1 = stmt.executeQuery("SELECT StatusMembership FROM student WHERE StudentId = '"+StudentID+"';");
		if(rs1.next()) {
		StatusMembership.add(rs1.getString(1));
		}
		else rs1.close();

	} catch (SQLException e) {e.printStackTrace();}
	
	try 
	{
		stmt1 = conn.createStatement();
		ResultSet rs2 = stmt1.executeQuery("SELECT Email FROM student WHERE StudentId = '"+StudentID+"';");
		if(rs2.next()) {
		StatusMembership.add(rs2.getString(1));
		}

	} catch (SQLException e) {e.printStackTrace();}
	
  return StatusMembership;
  
  }


public static ArrayList<String> AddItemInLoan(String StudentID, String BookID, String CopyID, String Delay) ////JERIES
{
	String loanDate = "";
	String returnDate = "";
	
	    SimpleDateFormat twoWeeksAfter = new SimpleDateFormat("dd/MM/yyyy");
	    Calendar c2 = Calendar.getInstance();
	    c2.setTime(new Date()); // Now use today date.
	    loanDate = twoWeeksAfter.format(c2.getTime());
	    c2.add(Calendar.DATE, 14); // Adding 14 days
	    returnDate = twoWeeksAfter.format(c2.getTime());
	
	    
	
	Statement stmt;
	ArrayList<String> update = new ArrayList<String>();
	try 
	{
		stmt = conn.createStatement();
		
		stmt.executeUpdate("INSERT INTO iteminloan (StudentID ,BookID ,CopyID ,delay, loanDate, returnDate) VALUES('"+StudentID+"','"+BookID+"','"+CopyID+"','"+Delay+"','"+loanDate+"','"+returnDate+"')");
		update.add(loanDate);
		update.add(returnDate);
		
	} catch (SQLException e) {e.printStackTrace();}
	
	Statement stmt1;
	try 
	{
		stmt = conn.createStatement();
		
		stmt.executeUpdate("UPDATE copy SET status ='Loan' WHERE idcopy = '"+CopyID+"' AND bookID = '"+ BookID+"' ;");
		
	} catch (SQLException e) {e.printStackTrace();}
	
	
  return update;
  
  }
      
}
//End of EchoServer class
