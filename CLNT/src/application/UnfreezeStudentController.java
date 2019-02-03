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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * 
 * Unfreeze student controller
 *
 */
public class UnfreezeStudentController {

	public static String StudentID = "NO";
	
	
    @FXML
    private Button CHECKSTUDENTSButton;

    @FXML
    private TableView<Student> UnlockTable;

    @FXML
    private Button UNLOCKSELECTEDButton;

    @FXML
    private Button BACKButton;
    
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void logout(ActionEvent event) throws IOException {
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
    void BackFunc(ActionEvent event) throws IOException {
    	
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
     * Check student Button handler
     * @param event
     */
    void CheckStudents(ActionEvent event) {
    	
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add("CheckUnlock");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	
    	try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	TableColumn id = new TableColumn("ID");
    	id.setMinWidth(200);
        TableColumn name = new TableColumn("NAME");
        name.setMinWidth(200);
        TableColumn email = new TableColumn("EMAIL");
        email.setMinWidth(200);
        TableColumn delay = new TableColumn("DELAY"); 
        delay.setMinWidth(120);
        UnlockTable.getColumns().addAll(id, name, email, delay);
    	
        
        final ObservableList<Student> data = FXCollections.observableArrayList();
        for (int i = 0; i < result.size(); i += 4) {
         data.add(new Student(result.get(i), result.get(i + 1), result.get(i + 2), result.get(i + 3)));
        }
    	
 id.setCellValueFactory(new PropertyValueFactory<Student,String>("ID"));
        
        name.setCellValueFactory(new PropertyValueFactory<Student,String>("Name"));

        email.setCellValueFactory(new PropertyValueFactory<Student,String>("Email"));

        delay.setCellValueFactory(new PropertyValueFactory<Student,String>("Delay"));
        
         UnlockTable.setItems(data);
    }

    @FXML
    /**
     * Selecting the wanted student using the mouse
     * @param event
     */
    void SelectedStudent(MouseEvent event) {
    	Student s = UnlockTable.getSelectionModel().getSelectedItem();
    	//System.out.println(s.getID());
    	StudentID = s.getID();
    }

    @FXML
    /**
     * Unlock the selected student Button handler
     * @param event
     */
    void UnlockSelected(ActionEvent event)  {
		
		if(StudentID == "NO") {
		JOptionPane.showMessageDialog(null, "Please select a user to unlock.");	
		}
		else {
		ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
        msg.add(StudentID);
        msg.add("UnlockUser");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	JOptionPane.showMessageDialog(null, "Thank you, user successfully unlocked.");
		}
    }
}
