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
    private Text LastName;

    @FXML
    private Text IDtxt;

    @FXML
    private Text Status;

    @FXML
    void getid(ActionEvent event) {
      String ID = IDinput.getText();
      ArrayList<String> msg = new ArrayList<String>();
      ArrayList<String>  result = new ArrayList<String>();

         System.out.println(ID);
     	 msg.add(""+ID);
     	 msg.add("GetData");
     	 result = (ArrayList<String>)Main.client.Request(msg);
     //	 System.out.println(result.get(3));
     	 
     	 
//	Main.client.handleMessageFromServer(result);
    }

}
