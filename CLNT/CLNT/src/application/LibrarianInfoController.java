package application;

import java.io.IOException;
import java.util.ArrayList;

import Entity.Librarian;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LibrarianInfoController {
	static private ArrayList<Librarian> librarians = new ArrayList<Librarian>();
	static public String back = IPController.backGui ;
    @FXML
    private Text name;

    @FXML
    private Text id;

    @FXML
    private Text email;

    @FXML
    private Text phone;

    @FXML
    private Text serialNumber;

    @FXML
    private Text role;
    @FXML
    private Text OrgAffilliation;
    
    public void loadLibraryInfo(ArrayList<Librarian> librarians)
    {
    	this.librarians =librarians;
    	 for(int j=0;j<librarians.size();j++)
         {
      	   if(librarians.get(j).getLibrarianID().equals(sigINController.LibrarianId)) {
    	serialNumber.setText(""+librarians.get(j).getLibrarianSerialNumber());
    	phone.setText(librarians.get(j).getLibrarianPhone());
    	name.setText(librarians.get(j).getLibrarianName());
    	email.setText(librarians.get(j).getLibrarianEmail());
    	id.setText(librarians.get(j).getLibrarianID());
    	role.setText(librarians.get(j).getLibrarianRole());
    	OrgAffilliation.setText(librarians.get(j).getLibrarianOrganizationalAffiliation());
      	   }
         }
    }
   

    @FXML
    void back(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/"+back+".fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void editProfile(ActionEvent event) throws IOException {
    //	IPController.backGui ="LibrarianInfo";
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/LibrarianEditProfile.fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
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