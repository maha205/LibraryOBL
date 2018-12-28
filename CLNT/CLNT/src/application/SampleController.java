package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class SampleController {

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
    void getid(ActionEvent event) {
      String ID = IDinput.getText();
      ArrayList<String> msg = new ArrayList<String>();
      ArrayList<String>  result = new ArrayList<String>();

         System.out.println(ID);
     	 msg.add(""+ID);
     	 msg.add("GetData");
     	 result = (ArrayList<String>)Main.client.Request(msg);
     	 System.out.println(result);
     	if(result!= null)
     	{
     	 IDtxt.setVisible(true);
       	 FirstName.setVisible(true);
       	 Status.setVisible(true);
       	 Operation.setVisible(true);
     	 IDtxt.setText(result.get(0));
     	 FirstName.setText(result.get(1));
     	 Status.setText(result.get(2));
     	 Operation.setText(result.get(3));
      }
     	else
     	{
     		Errormsg.setVisible(true);
     		IDtxt.setVisible(false);
        	 FirstName.setVisible(false);
        	 Status.setVisible(false);
        	 Operation.setVisible(false);
        	 System.out.println("not found");
     	}
     		 
    
    }
}
