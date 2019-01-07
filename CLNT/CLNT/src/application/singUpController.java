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
    void back(ActionEvent event) throws IOException 
    {
    	editStudentProfileController.editStudentBack ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/LibrarianProfile.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException
    {
    	editStudentProfileController.editStudentBack ="LibrarianProfile";
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
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
       	 if(result.size() >0)
       		userExist.setVisible(false); 
       	 else
       		userExist.setVisible(true); 
    	
    }

}