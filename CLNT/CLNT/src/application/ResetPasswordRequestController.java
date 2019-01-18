package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ResetPasswordRequestController 
{
	private EmailMsg email ;
	private String UserIDinput ;
	private String oldPassword ;
	private String UserTable ;
	private String UserCod ;
	public int flag =1 ;

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
    void SendEmail(ActionEvent event) 
    {
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        
	     
	    UserIDinput =UserID.getText() ;
        msg.add( UserID.getText());
        msg.add("ResetPasswordRequest");
        result = (ArrayList<String>)IPController.client.Request(msg);
        System.out.println(result);
        if(result.size()>0 && !(inputTxt.getText().equals("")) && !(UserID.getText().equals("")) && flag ==1)
        {
        	flag =0;
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
        if(flag == 0)
        {
        	
            UserID.setVisible(false);
       	    inputTxt.setVisible(true);
           	EnterEmai.setVisible(false);
       	    enterID.setVisible(false);
       	    errorInputPass.setVisible(false);
       	    EnterCode.setVisible(true);
        	UserID.setVisible(false);
     	    inputTxt.setVisible(false);
         	
        	if(inputTxt.getText().equals(UserCod))
        	{
        		flag = 2;
        		UserID.setText("");
       	       inputTxt.setText("");
        	}
        	else
        	{
        		errorInputPass.setVisible(true);
        		UserNotFound.setVisible(false);
        	}
        }
        if(flag==2)
        {
        	
        	ArrayList<String> msg1 = new ArrayList<String>();
            ArrayList<String>  result1 = new ArrayList<String>();
            
            UserID.setVisible(true);
     	    inputTxt.setVisible(true);
            
            msg1.add(UserID.getText());
            msg1.add(oldPassword);
            msg1.add(UserID.getText());
            msg1.add( inputTxt.getText());
          
        	
        	if(UserTable.equals("Management User"))
        	{
//        	//  msg1.add("ResetPasswordRequest");
//                result1 = (ArrayList<String>)IPController.client.Request(msg1);
//                System.out.println(result1);
        	}
        		
            if(UserTable.equals("Student User"))
            {
               msg1.add("UpdatePasswordStudent");
                result1 = (ArrayList<String>)IPController.client.Request(msg1);
                System.out.println(result1);
                if(result1.size() >0) successful.setVisible(true);
            	//UpdatePasswordStudent
            }
            if(UserTable.equals("Librarian User"))
            {
                 msg1.add("UpdatePasswordLibrarian");
                result1 = (ArrayList<String>)IPController.client.Request(msg1);
                System.out.println(result1);
            	
            }
        			
        }
    	if(flag==1)
    	{
    		UserNotFound.setVisible(true);
    		errorInputPass.setVisible(false);
    	}
    
    	
    }

    @FXML
    void cancel(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/mainForm.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

}
