package application;

import java.io.IOException;
import java.util.ArrayList;
import Entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * 
 * Library Subscriptions Controller 
 *
 */
public class LibrarySubscriptionsController
{
	static private ArrayList<Student>  LibrarySubscriptions ;
	static public int i=0;
	static public String back = IPController.backGui ;
    @FXML
    private TextField searchinput;

    @FXML
    private Text SubscriptionID;

    @FXML
    private Text SubscriptionName;

    @FXML
    private Text SubscriptionStatus;

    @FXML
    private Text SubscriptionPhone;

    @FXML
    private Text SubscriptionEmail;

    @FXML
    private Text SubscriptionSerialNumber;

    @FXML
    private Text errorFound;
    @FXML
    private Button nextBtn;

    @FXML
    private Button prevBtn;
    @FXML
    /**
     * Searching button handler
     * @param event
     */
    void search(ActionEvent event) 
    {

    	int flag=0;
       for(int j=0;j<LibrarySubscriptions.size();j++)
       {
    	   if(LibrarySubscriptions.get(j).getStudentId().equals(searchinput.getText()))
    	   {
    		   i=j;
    		   errorFound.setVisible(false);
    		   flag = 1;

    	   		SubscriptionID.setText(LibrarySubscriptions.get(i).getStudentId());
    	    	SubscriptionName.setText(LibrarySubscriptions.get(i).getStudentName());
    	    	SubscriptionStatus.setText(LibrarySubscriptions.get(i).getStatusMembership());
    	    	SubscriptionPhone.setText(LibrarySubscriptions.get(i).getPhone());
    	    	SubscriptionEmail.setText(LibrarySubscriptions.get(i).getEmail());
    	    	SubscriptionSerialNumber.setText(""+LibrarySubscriptions.get(i).getSubscriptionNumber());
    	   }
       }
       
       if(flag==0)  errorFound.setVisible(true);
    }
    /**
     * Loading library students
     * @param result1
     */
    public void loadLibraryStudents(ArrayList<Student> result1) 
    {
    	this.LibrarySubscriptions =result1;
    	errorFound.setVisible(false);
    	if(result1!=null) {
    	SubscriptionID.setText(result1.get(0).getStudentId());
    	SubscriptionName.setText(result1.get(0).getStudentName());
    	SubscriptionStatus.setText(result1.get(0).getStatusMembership());
    	SubscriptionPhone.setText(result1.get(0).getPhone());
    	SubscriptionEmail.setText(result1.get(0).getEmail());
    	SubscriptionSerialNumber.setText(""+result1.get(0).getSubscriptionNumber());}
    }
    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void back(ActionEvent event) throws IOException 
    {
  		((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/"+back+".fxml"));
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
    void next(ActionEvent event) 
    {
    	if(i >=LibrarySubscriptions.size()-1)
        {
      	  System.out.println("The last librarian");
      	  nextBtn.setDisable(true);
        }
   	 else
   	 {
   		prevBtn.setDisable(false);
   		i++;
   		SubscriptionID.setText(LibrarySubscriptions.get(i).getStudentId());
    	SubscriptionName.setText(LibrarySubscriptions.get(i).getStudentName());
    	SubscriptionStatus.setText(LibrarySubscriptions.get(i).getStatusMembership());
    	SubscriptionPhone.setText(LibrarySubscriptions.get(i).getPhone());
    	SubscriptionEmail.setText(LibrarySubscriptions.get(i).getEmail());
    	SubscriptionSerialNumber.setText(""+LibrarySubscriptions.get(i).getSubscriptionNumber());
   		 
   	 }
    }

    @FXML
    /**
     * 
     * @param event
     */
    void prv(ActionEvent event) 
    {
    	 if(i==0)
         {
       	  System.out.println("The first librarian");
       	  prevBtn.setDisable(true);
         }
         else
    	  {
         	nextBtn.setDisable(false);
    		i--;
    		SubscriptionID.setText(LibrarySubscriptions.get(i).getStudentId());
        	SubscriptionName.setText(LibrarySubscriptions.get(i).getStudentName());
        	SubscriptionStatus.setText(LibrarySubscriptions.get(i).getStatusMembership());
        	SubscriptionPhone.setText(LibrarySubscriptions.get(i).getPhone());
        	SubscriptionEmail.setText(LibrarySubscriptions.get(i).getEmail());
        	SubscriptionSerialNumber.setText(""+LibrarySubscriptions.get(i).getSubscriptionNumber());
    	  }
    }

}