package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import TableView.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class FreezeStudentController {

	public static String StudentID = "NO";
	
    @FXML
    private Button CHECKSTUDENTSButton;

    @FXML
    private TableView<Student> LockTable;

    @FXML
    private Button LOCKSELECTEDButton;

    @FXML
    private Button BACKButton;

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
    
    @FXML
    void BackFunc(ActionEvent event) throws IOException {
    	((Node)event.getSource()).getScene().getWindow().hide();
  		Stage primaryStage = new Stage();
  		FXMLLoader loader = new FXMLLoader();
  		Pane root = loader.load(getClass().getResource("/application/"+IPController.backGui+".fxml").openStream());
  		
  		Scene scene = new Scene(root);			
  		
  		primaryStage.setScene(scene);		
  		primaryStage.show();   	
    }

    @FXML 
    void CheckStudents(ActionEvent event) {
    //STEP 1: Get relevant data from Server + Put it in ArrayList
    //STEP 2: Create Columns and add data to TableView
    	
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add("CheckLock");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Student s = new Student(result.get(0), result.get(1), result.get(2), result.get(3));
    	
    	TableColumn id = new TableColumn("ID");
    	id.setMinWidth(200);
        TableColumn name = new TableColumn("NAME");
        name.setMinWidth(200);
        TableColumn email = new TableColumn("EMAIL");
        email.setMinWidth(200);
        TableColumn delay = new TableColumn("DELAY"); 
        delay.setMinWidth(120);
        LockTable.getColumns().addAll(id, name, email, delay);
        
      //  final ObservableList<Student> data = FXCollections.observableArrayList(result);
        
     //   final ObservableList<Student> data = FXCollections.observableArrayList(
       // 		new Student(result.get(0), result.get(1), result.get(2), result.get(3)),
      //  		new Student(result.get(4), result.get(5), result.get(6), result.get(7))
       //  		);
        
        
        
        final ObservableList<Student> data = FXCollections.observableArrayList();
        
        for (int i = 0; i < result.size(); i += 4) {
         data.add(new Student(result.get(i), result.get(i + 1), result.get(i + 2), result.get(i + 3)));
        }
        
        
        id.setCellValueFactory(new PropertyValueFactory<Student,String>("ID"));
        
        name.setCellValueFactory(new PropertyValueFactory<Student,String>("Name"));

        email.setCellValueFactory(new PropertyValueFactory<Student,String>("Email"));

        delay.setCellValueFactory(new PropertyValueFactory<Student,String>("Delay"));
        
         LockTable.setItems(data);
        
    }



	@FXML
    void LockSelected(ActionEvent event) {
		
		if(StudentID == "NO") {
		JOptionPane.showMessageDialog(null, "Please select a user to lock.");	
		}
		else {
		ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(StudentID);
        msg.add("LockUser");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	JOptionPane.showMessageDialog(null, "Thank you, user successfully locked.");
		}
    }

    @FXML
    void SelectedStudent(MouseEvent event) {
    	Student s = LockTable.getSelectionModel().getSelectedItem();
    	//System.out.println(s.getID());
    	StudentID = s.getID();
    }

}
