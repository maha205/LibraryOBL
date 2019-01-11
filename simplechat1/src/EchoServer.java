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
				 System.out.println("Update student Email");
		    	 break;
		    	 
	      case "UpdatephontLibrariant":
	    	  msg = (UpdatedLibrarianPhone(msg.get(0),msg.get(1))); //student email update
			  System.out.println("Update student Phone");
		      break;
		      
	      case "UpdatePasswordLibrarian":
	    	  msg = (UpdatedLibrarianPassword(msg.get(0),msg.get(1),msg.get(2),msg.get(3))); //student password update
			  System.out.println("Update student Password");
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
	      
	      case "OrderBook":
	    	  try {
				msg=OrderBook(msg.get(0),msg.get(1),msg.get(2));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	  System.out.println("Order Book");
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
    System.out.println(ExternLoanBook("318301488" ,"1564893212"));
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
   			ResultSet rs = stmt.executeQuery("SELECT * FROM userstudent WHERE UserID ="+UserID);
   			
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
      
      public static ArrayList<String> ExternLoanBook(String Studentid ,String bookID)  throws SQLException 
      {
    	Statement stmt ,stmt2;
    	int diffDays = 0;
   		ArrayList<String> Extern = new ArrayList<String>();
   		String copyID = null  ,outputtwoWeeksAfter = null;
   		
 			stmt = conn.createStatement();
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
 	 				 stmt.executeUpdate("UPDATE iteminloan SET loanDate ='"+outputcurrentDate+"' WHERE BookID ='"+bookID+"' AND CopyID ='"+copyID+"';");
 	 				 stmt.executeUpdate("UPDATE iteminloan SET returnDate ='"+outputtwoWeeksAfter+"' WHERE BookID ='"+bookID+"' AND CopyID ='"+copyID+"';");
 	 				 Extern.add("Extern");
 	 			}
 	 		   rs.close();
 	 		 return Extern;
 	 		}
 		}

   		return Extern;
      }
      
      public static ArrayList<String> OrderBook(String Studentid ,String bookId ,String copyID)  throws SQLException 
      {
    	Statement stmt ,stmt2;
   		ArrayList<String> Order = new ArrayList<String>();
   		
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
 		 		    Order.add(copyID);//copy ID
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
 			return Order;

      }
      
      
      
      
}
//End of EchoServer class
