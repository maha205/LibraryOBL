// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;
import ocsf.server.*;
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
//  public void handleMessageFromClient (Object msg, ConnectionToClient client)
//  {
//	    System.out.println("Message received: " + msg + " from " + client);
//	    this.sendToAllClients(msg);
//  }
  
 
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
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on
    connectToDB();
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

	
}
//End of EchoServer class
