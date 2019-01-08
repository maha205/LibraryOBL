package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ExternLoanBookController
{
	@FXML
	private Text dayMsg;   

	 @FXML
    private Text dateReturn;
    @FXML
    private Text succesful;
    @FXML
    private TextField bookID;
    @FXML
    private Text errorMsg;
    @FXML
    void BackGui(ActionEvent event) throws IOException 
    {
    	 ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/StudentProfile.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
    }

    @FXML
    void ExtendLoan(ActionEvent event) 
    {
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(sigINController.StudentId);
        msg.add(bookID.getText());
        msg.add("ExtendLoan");
        result = (ArrayList<String>)IPController.client.Request(msg);
        System.out.println(result);
        if(result.size() >0)
        {
        	errorMsg.setVisible(false);
        	succesful.setVisible(true);
        	dayMsg.setVisible(true);
        	dateReturn.setText(result.get(0));
        	dateReturn.setVisible(true);
        }
        else
        {
        	errorMsg.setVisible(true);
        	succesful.setVisible(false);
        	dayMsg.setVisible(false);
        	dateReturn.setVisible(false);
        }
    }

    @FXML
    void exitGui(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

}