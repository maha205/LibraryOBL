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
 * Sigup controller
 *
 */
public class singUpController {

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private Text userExist;
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void back(ActionEvent event) throws IOException 
    {
    	IPController.backGui ="LibrarianProfile";
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
     * 
     * @param event
     * @throws IOException
     */
    void logout(ActionEvent event) throws IOException
    {
    	IPController.backGui ="LibrarianProfile";

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
     */
    void singUP(ActionEvent event)
    {
        ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
       	 msg.add(id.getText());
       	 msg.add(name.getText());
       	 msg.add(email.getText());
       	msg.add(phone.getText());
       	 msg.add("signUP");
       	 result = (ArrayList<String>)IPController.client.Request(msg);
       	 System.out.println(result);
       	 if(result.size() >0) {
       		userExist.setVisible(false); 
    		JOptionPane.showMessageDialog(null, "Sing Up successful");

       	 }
       	 else {
       		userExist.setVisible(true); 
    		JOptionPane.showMessageDialog(null, "Subscriber is existes !!");

       	 }
    	
    }

}