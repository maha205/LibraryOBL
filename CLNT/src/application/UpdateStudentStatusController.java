package application;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 * Updating student status controller
 * @author Reem
 *
 */
public class UpdateStudentStatusController {

    @FXML
    private TextField IDinput;

    @FXML
    private Button SBMT;

    @FXML
    private Text FirstName;

    @FXML
    private Text Operation;

    @FXML
    private Text IDtxt;

    @FXML
    private Text Status;
    
    @FXML
    private Text Errormsg;

    @FXML
    public ComboBox <String> cmboChoose;
    
    @FXML
    private Button UPDT;
    
    private int flag = 0 ;
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void logout(ActionEvent event) throws IOException 
    {

    	sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
    	sigINController.ManagementId =null ;
    	
		
		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/sigIN.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setScene(new Scene(root));
			stage.show();
    }
    @FXML
	/**
	 * 
	 * @param event
	 * @throws IOException
	 */

    void backForm(ActionEvent event) throws IOException 
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
     * Getting Id Button handler
     * @param event
     */
    void getid(ActionEvent event) 
    {
      String ID = IDinput.getText();
      ArrayList<String> msg = new ArrayList<String>();
      ArrayList<String>  result = new ArrayList<String>();
     	 msg.add(""+ID);
     	 msg.add("GetData");
     	 result = (ArrayList<String>)IPController.client.Request(msg);
     	 System.out.println(result);
     	if(result.size() >0)
     	{
     	 Errormsg.setVisible(false);
     	 cmboChoose.setVisible(true);
     	 UPDT.setVisible(true);
     	 IDtxt.setVisible(true);
       	 FirstName.setVisible(true);
       	 Status.setVisible(true);
       	 Operation.setVisible(true);
     	 IDtxt.setText(result.get(0));
     	 FirstName.setText(result.get(1));
     	 Status.setText(result.get(2));
     	 Operation.setText(result.get(3));
     	 if(flag==0)
     	{
     		    cmboChoose.getItems().addAll("Locked", "Frozen", "Active","NotRegistered");
     		    flag = 1 ;
        }
      }
     	else
     	{
     		Errormsg.setVisible(true);
     		cmboChoose.setVisible(false);
        	 UPDT.setVisible(false);
     		IDtxt.setVisible(false);
        	FirstName.setVisible(false);
        	Status.setVisible(false);
            Operation.setVisible(false);
        	System.out.println("not found");
     	}
    }
    
    @FXML
    /**
     * Updating Button handler
     * @param event
     */
    void Update(ActionEvent event)
    {
    	 String ID = IDinput.getText() ;
    	 String stuts = (String)cmboChoose.getSelectionModel().getSelectedItem();
    	 System.out.println(stuts); 
    	 ArrayList<String> msg = new ArrayList<String>();
    	 ArrayList<String>  result = new ArrayList<String>();
    	 msg.add(ID);
    	 msg.add(stuts);
    	 msg.add("Update");
    	 if(stuts.equals(null))
    		 Status.setText(Status.getText()); 
    	 else
    	  result = (ArrayList<String>)IPController.client.Request(msg);
    
     	 System.out.println(result);
     	 Status.setText(result.get(0)); 
    }
    
    /**
     *IP is not connected 
     */
    public void IPError() 
    {
    	System.out.println("is not Connected !!!!");
    }
}
