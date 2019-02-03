package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * 
 * reset password request controller
 *
 */
public class ResetPasswordRequestController 
{
	private EmailMsg email ;
	private String UserIDinput ;
	private String oldPassword ;
	private String UserTable ;
	private String UserCod ;
	public int flag =1 ;
	public int flagCode =1 ;

    @FXML
    private Text EnterEmai;

    @FXML
    private TextField inputTxt;

    @FXML
    private Text EnterCode;

    @FXML
    private Text enterID;

    @FXML
    private TextField UserID;

    @FXML
    private Text UserNotFound;


    @FXML
    private Text assertPass;

    @FXML
    private Text successful;

    @FXML
    private Text errorInputPass;

    @FXML
    private Text newPass;
    @FXML
    /**
     * Sending Email Button handler
     * @param event
     * @throws IOException
     */
    void SendEmail(ActionEvent event) throws IOException 
    {
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
       
        msg.add( UserID.getText());
        msg.add("ResetPasswordRequest");
        result = (ArrayList<String>)IPController.client.Request(msg);
        System.out.println(result);
        if(result.size()>0 && !(inputTxt.getText().equals("")) && !(UserID.getText().equals("")) && flag ==1)
        {
        	flag =0;
        	 UserIDinput =UserID.getText() ;
        	UserNotFound.setVisible(false);
        	Random  random = new Random();
            UserCod = String.format("%04d", random.nextInt(10000));
        	System.out.println(UserCod);
        	
         UserTable=result.get(0);
         oldPassword=result.get(1);
         System.out.println(oldPassword);
         System.out.println(UserTable);
    	 email = new EmailMsg();
	     email.Too =inputTxt.getText() ;
	     email.TextBody ="Hi \r\n" + 
     			"We received a request to reset your Account password , You can enter the following password reset code: "+UserCod+" \r\n";
	     email.SendAction();
	    
	     UserID.setText("");
	     inputTxt.setText("");

        }
        if(flag==1 )
        {
        	errorInputPass.setVisible(false);
    		UserNotFound.setVisible(true);
        }
         if(flag == 0)
        {
   	        UserID.setVisible(false);
       	    inputTxt.setVisible(true);
           	EnterEmai.setVisible(false);
       	    enterID.setVisible(false);
       	    errorInputPass.setVisible(false);
       	    EnterCode.setVisible(true);
        	UserID.setVisible(false);
     	    
         	
        	if(inputTxt.getText().equals(UserCod))
        	{
        		flag = 2;
        		flagCode =0;
                UserID.setVisible(true);
           	    inputTxt.setVisible(true);
             	 errorInputPass.setVisible(false);
     		    UserNotFound.setVisible(false);
     		
        		UserID.setText("");
       	        inputTxt.setText("");
        	}
        	
        }
         if(flag==2)
        {
        	ArrayList<String> msg1 = new ArrayList<String>();
            ArrayList<String>  result1 = new ArrayList<String>();
           
            UserID.setVisible(true);
     	    inputTxt.setVisible(true);
           	EnterEmai.setVisible(false);
       	    enterID.setVisible(false);
       	    errorInputPass.setVisible(false);
       	    EnterCode.setVisible(false);
        	assertPass.setVisible(true);
        	newPass.setVisible(true);
        	
            msg1.add(UserIDinput);//user id
            msg1.add(oldPassword);//old pass
            msg1.add(UserID.getText());//new pass
            msg1.add( inputTxt.getText());// assert pass
          
        	
        	if(UserTable.equals("Management User")&& !(inputTxt.getText().equals("")) && !(UserID.getText().equals("")))
        	{
                 msg1.add("UpdatedManagementPassword");
                 result1 = (ArrayList<String>)IPController.client.Request(msg1);
                 System.out.println(result1);
                 if(result1.size() >0 ) 
                 {
                 	   try {
                 		   successful.setVisible(true);
                 		   TimeUnit.SECONDS.sleep(2);
 					} catch (InterruptedException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
                 	   
            	   		((Node)event.getSource()).getScene().getWindow().hide();
              			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
              			Parent root = (Parent) fxmlLoader.load();
              			Stage stage = new Stage();
              			stage.setResizable(false);
              			stage.setScene(new Scene(root));
              			stage.show();
            	   		
                }
                 else
                 {
                 	successful.setVisible(false);
                 	errorInputPass.setVisible(true);
             		UserNotFound.setVisible(false);
                 }
        	}
        		
            if(UserTable.equals("Student User") && !(inputTxt.getText().equals("")) && !(UserID.getText().equals("")))
            {
                msg1.add("UpdatePasswordStudent");
                result1 = (ArrayList<String>)IPController.client.Request(msg1);
                System.out.println(result1);
                if(result1.size() >0 ) 
                {
                	   try {
                		   successful.setVisible(true);
                		   TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	   
           	 	((Node)event.getSource()).getScene().getWindow().hide();
      			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
      			Parent root = (Parent) fxmlLoader.load();
      			Stage stage = new Stage();
      			stage.setResizable(false);
      			stage.setScene(new Scene(root));
      			stage.show();
           	   		
               }
                else
                {
                	successful.setVisible(false);
                	errorInputPass.setVisible(true);
            		UserNotFound.setVisible(false);
                }
                	
            	//UpdatePasswordStudent
            }
            if(UserTable.equals("Librarian User")&& !(inputTxt.getText().equals("")) && !(UserID.getText().equals("")))
            {
            	 msg1.add("UpdatePasswordLibrarian");
                 result1 = (ArrayList<String>)IPController.client.Request(msg1);
                 System.out.println(result1);
                 if(result1.size() >0 ) 
                 {
                 	   try {
                 		   successful.setVisible(true);
                 		   TimeUnit.SECONDS.sleep(2);
 					} catch (InterruptedException e) {
 						// TODO Auto-generated catch block
 						e.printStackTrace();
 					}
                 	   
            	   		((Node)event.getSource()).getScene().getWindow().hide();
              			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
              			Parent root = (Parent) fxmlLoader.load();
              			Stage stage = new Stage();
              			stage.setResizable(false);
              			stage.setScene(new Scene(root));
              			stage.show();
                }
                 else
                 {
                 	successful.setVisible(false);
                 	errorInputPass.setVisible(true);
             		UserNotFound.setVisible(false);
                 }
            	
            }		
        }
    
    	
    }

    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void cancel(ActionEvent event) throws IOException 
    {
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/mainForm.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }

}
