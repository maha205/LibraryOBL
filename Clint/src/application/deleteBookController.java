
package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class deleteBookController
{
    @FXML
    private TextField bookID;

    @FXML
    void back(ActionEvent event) throws IOException 
    {
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/"+IPController.backGui+".fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

    @FXML
    void deleteBook(ActionEvent event) 
    {
    	if(bookID.getText().equals(""))
    		JOptionPane.showMessageDialog(null, "Please fill out the field !!");
    	
    	else {
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(bookID.getText());
        msg.add("RemoveBook");
        result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	if(result.size()>0)
    		
    		JOptionPane.showMessageDialog(null, "The book is deleted ");
    	else
    		JOptionPane.showMessageDialog(null, "The book you are trying to delete is not exists !!");
    	
    	bookID.clear();
      }
    }

    @FXML
    void logout(ActionEvent event) throws IOException
    {
    	sigINController.LibrarianId=null;
    	sigINController.StudentId =null;
    	sigINController.ManagementId =null ;
    	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
    }

}