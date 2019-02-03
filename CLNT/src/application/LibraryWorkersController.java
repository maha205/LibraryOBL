package application;

import java.io.IOException;
import java.util.ArrayList;
import Entity.Librarian;
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
 *Library Workers Controller  
 *
 */
public class LibraryWorkersController  
{  
	static private ArrayList<Librarian> librarians = new ArrayList<Librarian>();
	static public int i=0;
	static public String back = IPController.backGui ;
	@FXML
    private Text LibrarianRole;

    @FXML
    private Text LibrarianOrganizationalAffiliation;

    @FXML
    private Text LibrarianName;

    @FXML
    private Text LibrarianID;

    @FXML
    private Text LibrarianEmail;

    @FXML
    private Text LibrarianPhone;

    @FXML
    private Text LibrarianSerialNumber;
    @FXML
    private Button prevBtn;

    @FXML
    private Button nextBtn;
    @FXML
    private TextField searchInput;

    @FXML
    private Text usernotfound;
    /**
     * load Library Workers
     * @param librarians
     */
    public void loadLibraryWorkers(ArrayList<Librarian> librarians)
    {
    	this.librarians =librarians;
    	if( librarians!=null)
    	usernotfound.setVisible(false);
    	LibrarianSerialNumber.setText(""+librarians.get(0).getLibrarianSerialNumber());
    	LibrarianPhone.setText(librarians.get(0).getLibrarianPhone());
    	LibrarianName.setText(librarians.get(0).getLibrarianName());
    	LibrarianEmail.setText(librarians.get(0).getLibrarianEmail());
    	LibrarianID.setText(librarians.get(0).getLibrarianID());
    	LibrarianRole.setText(librarians.get(0).getLibrarianRole());
    	LibrarianOrganizationalAffiliation.setText(librarians.get(0).getLibrarianOrganizationalAffiliation());
    }
    @FXML
    /**
     * finding nextLibrarian button handler
     * @param event
     */
    void nextLibrarian(ActionEvent event)
    {
    	 if(i>=librarians.size()-1)
         {
       	  System.out.println("The last librarian");
       	  nextBtn.setDisable(true);
         }
    	 else
    	 {
    		prevBtn.setDisable(false);
    		i++;
    		LibrarianSerialNumber.setText(""+librarians.get(i).getLibrarianSerialNumber());
    	    LibrarianPhone.setText(librarians.get(i).getLibrarianPhone());
    	    LibrarianName.setText(librarians.get(i).getLibrarianName());
    	    LibrarianEmail.setText(librarians.get(i).getLibrarianEmail());
    	    LibrarianID.setText(librarians.get(i).getLibrarianID());
    	    LibrarianRole.setText(librarians.get(i).getLibrarianRole());
    	    LibrarianOrganizationalAffiliation.setText(librarians.get(i).getLibrarianOrganizationalAffiliation());
    		 
    	 }
    }

    @FXML
    /**
     * finding previous button handler
     * @param event
     */
    void PrevLibrarian(ActionEvent event) 
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
 		LibrarianSerialNumber.setText(""+librarians.get(i).getLibrarianSerialNumber());
 	    LibrarianPhone.setText(librarians.get(i).getLibrarianPhone());
 	    LibrarianName.setText(librarians.get(i).getLibrarianName());
 	    LibrarianEmail.setText(librarians.get(i).getLibrarianEmail());
 	    LibrarianID.setText(librarians.get(i).getLibrarianID());
 	    LibrarianRole.setText(librarians.get(i).getLibrarianRole());
 	    LibrarianOrganizationalAffiliation.setText(librarians.get(i).getLibrarianOrganizationalAffiliation());
 	  }
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
			stage.setTitle("Manager Profile");
			stage.setScene(new Scene(root));
			stage.show();
		
    }
    @FXML
    /**
     * Searching button handler
     * @param event
     */
    void search(ActionEvent event)
    {
    	int flag=0;
       for(int j=0;j<librarians.size();j++)
       {
    	   if(librarians.get(j).getLibrarianID().equals(searchInput.getText()))
    	   {
    		   i=j;
    		   usernotfound.setVisible(false);
    		   flag = 1;
    		   LibrarianSerialNumber.setText(""+librarians.get(i).getLibrarianSerialNumber());
    	 	   LibrarianPhone.setText(librarians.get(i).getLibrarianPhone());
    	 	   LibrarianName.setText(librarians.get(i).getLibrarianName());
    	 	   LibrarianEmail.setText(librarians.get(i).getLibrarianEmail());
    	 	   LibrarianID.setText(librarians.get(i).getLibrarianID());
    	 	   LibrarianRole.setText(librarians.get(i).getLibrarianRole());
    	 	   LibrarianOrganizationalAffiliation.setText(librarians.get(i).getLibrarianOrganizationalAffiliation());
    	   }
       }
       
       if(flag==0)  usernotfound.setVisible(true);
       
    }

}