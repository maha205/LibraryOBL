package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

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
 * Management Edit Controller
 *
 */
public class ManagementEditController 
{
	@FXML
    private TextField emailTxt;

    @FXML
    private TextField phontTxt;

    @FXML
    private TextField oldPassTxt;

    @FXML
    private TextField newPassTxt;

    @FXML
    private TextField assertPassTxt;

    @FXML
    private Text email;

    @FXML
    private Text phone;

    @FXML
    private Text oldPasswordTochange;

    @FXML
    private Text newPass;

    @FXML
    private Text AssertPass;

    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void backFunc(ActionEvent event) throws IOException 
    {
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/"+IPController.backGui+".fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }

    @FXML
    /**
     * Save button handler
     * @param event
     * @throws NullPointerException
     */
    void saveFunc(ActionEvent event) throws NullPointerException 
    {
    	
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        try{
        	if(emailTxt.getText().equals("") && (phontTxt.getText().equals("")) && (oldPassTxt.getText().equals("")) && (newPassTxt.getText().equals("")) && (assertPassTxt.getText().equals("")))
        		JOptionPane.showMessageDialog(null, "something is wrong");
        	if(!(emailTxt.getText().equals("")))
        	{
        		msg.add(sigINController.ManagementId);
        		msg.add(emailTxt.getText());
        		msg.add("UpdatedManagementEmail");
        		result = (ArrayList<String>)IPController.client.Request(msg);
            	System.out.println(result);
            	emailTxt.clear();
            	if(result.size()>0) 
            		JOptionPane.showMessageDialog(null, "Save succeeded");
            	else
            		JOptionPane.showMessageDialog(null, "something is wrong");
        	}
        	
        }catch( NullPointerException  e) {e.printStackTrace();  }
    	
    	
       try{
           if(!(phontTxt.getText().equals("")))  	
    	   {
    	   	msg.add(sigINController.ManagementId);
    		msg.add(phontTxt.getText());
    		msg.add("UpdatedManagementPhone");
    		result = (ArrayList<String>)IPController.client.Request(msg);
    	    System.out.println(result);
    	    phontTxt.clear();
    	    if(result.size()>0) 
            	JOptionPane.showMessageDialog(null, "Save succeeded");
              else
            	JOptionPane.showMessageDialog(null, "something is wrong");
    	   }
       }catch( NullPointerException  e) {e.printStackTrace();  }
    		
       try{
    	if(!(oldPassTxt.getText().equals("")) && !(newPassTxt.getText().equals("")) && !(assertPassTxt.getText().equals(""))) 
    	{
    		
    		msg.add(sigINController.ManagementId);
    		msg.add(oldPassTxt.getText());
    		msg.add(newPassTxt.getText());
    		msg.add(assertPassTxt.getText());
    		msg.add("UpdatedManagementPassword");
    		result = (ArrayList<String>)IPController.client.Request(msg);
    	    System.out.println(result);
    	    oldPassTxt.clear();
    	    newPassTxt.clear();
    	    assertPassTxt.clear();
    	    if(result.size()>0) 
            	JOptionPane.showMessageDialog(null, "Save succeeded");
            else
            	JOptionPane.showMessageDialog(null, "something is wrong");
    	}
       }catch( NullPointerException  e) {e.printStackTrace();  }
    }
    @FXML
    /**
     * Updating Email button handler
     * @param event
     */
    void updateEmailFunc(ActionEvent event) 
    {
    	emailTxt.setVisible(true);
    	email.setVisible(true);
    	phontTxt.setVisible(false);
    	phone.setVisible(false);
    	oldPassTxt.setVisible(false);
    	newPass.setVisible(false);
    	newPassTxt.setVisible(false);
    	AssertPass.setVisible(false);
    	assertPassTxt.setVisible(false);
    	oldPasswordTochange.setVisible(false);
    	
    	phontTxt.clear();
    	newPassTxt.clear();
    	assertPassTxt.clear();
    	oldPassTxt.clear();
    }

    @FXML
    /**
     * Updating password button handler
     * @param event
     */
    void updatePassFunc(ActionEvent event) 
    {
    	emailTxt.setVisible(false);
    	email.setVisible(false);
    	phontTxt.setVisible(false);
    	phone.setVisible(false);
    	oldPassTxt.setVisible(true);
    	newPass.setVisible(true);
    	newPassTxt.setVisible(true);
    	AssertPass.setVisible(true);
    	assertPassTxt.setVisible(true);
    	oldPasswordTochange.setVisible(true);
    	
    	phontTxt.clear();
    	emailTxt.clear();
    }

    @FXML
    /**
     * Updating phone number button handler
     * @param event
     */	
    void updatePhoneFunc(ActionEvent event) 
    {
    	emailTxt.setVisible(false);
    	email.setVisible(false);
    	phontTxt.setVisible(true);
    	phone.setVisible(true);
    	oldPassTxt.setVisible(false);
    	newPass.setVisible(false);
    	newPassTxt.setVisible(false);
    	AssertPass.setVisible(false);
    	assertPassTxt.setVisible(false);
    	oldPasswordTochange.setVisible(false);
    	
    	emailTxt.clear();
    	newPassTxt.clear();
    	assertPassTxt.clear();
    	oldPassTxt.clear();
    }
    @FXML
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */

    void exitFun(ActionEvent event) throws IOException 
    {
    	sigINController.LibrarianId=null;
    	sigINController.StudentId=null;
    	sigINController.ManagementId =null ;
    	
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }

}