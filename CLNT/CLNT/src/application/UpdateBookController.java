package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entity.Book;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UpdateBookController {

    @FXML
    private Text bookNametxt;

    @FXML
    private Text authorTxt;

    @FXML
    private Text desTxt;

    @FXML
    private Text genreTxt;

    @FXML
    private Text publisherTxt;

    @FXML
    private Text printedatetxt;

    @FXML
    private Text cqTxt;

    @FXML
    private Text locationTxt;

    @FXML
    private TextField nemeEdit;

    @FXML
    private TextField AuthorNameInput;

    @FXML
    private TextField GenreEdit;

    @FXML
    private TextField DescEdit;

    @FXML
    private TextField publisherEdit;

    @FXML
    private TextField printDateEdit;

    @FXML
    private TextField cQuantyEdit;

    @FXML
    private TextField locationEdit;

    @FXML
    private ComboBox<String> comboEdit;

    @FXML
    private Button edit;

    @FXML
    private Button saveAll;

    @FXML
    private Text NameNotEdit;

    @FXML
    private Text AuthorNotEdit;

    @FXML
    private Text DescNotEdit;

    @FXML
    private Text genreNotEdit;

    @FXML
    private Text publisherNotEdit;

    @FXML
    private Text printDateNotEdit;

    @FXML
    private Text copyQNotEdit;

    @FXML
    private Text LocationNotEdit;
    @FXML
    private TextField searchInput;
    public void loadComboList()
    {
    	comboEdit.setDisable(true);
    	edit.setDisable(true);
    	comboEdit.getItems().addAll("All details", "Book Name", "Author Name","Description","Genre","Publisher","Printdate","Copy Quantity","Location Shelf");
    }
    

    @FXML
    void cancel(ActionEvent event) throws IOException 
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
    void edit(ActionEvent event) 
    {
      String choose =(String)comboEdit.getSelectionModel().getSelectedItem();
      System.out.println(choose);
      switch(choose)
      {
        case "All details":
        	NameNotEdit.setVisible(false);
            AuthorNotEdit.setVisible(false);
            DescNotEdit.setVisible(false);
            genreNotEdit.setVisible(false);
            publisherNotEdit.setVisible(false);
            printDateNotEdit.setVisible(false);
            copyQNotEdit.setVisible(false);
            LocationNotEdit.setVisible(false);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(true);
            AuthorNameInput.setVisible(true);
            GenreEdit.setVisible(true);
            DescEdit.setVisible(true);
            publisherEdit.setVisible(true);
            printDateEdit.setVisible(true);
            cQuantyEdit.setVisible(true);
            locationEdit.setVisible(true);
        	break ;
        	
        case "Book Name":
        	NameNotEdit.setVisible(false);
            AuthorNotEdit.setVisible(true);
            DescNotEdit.setVisible(true);
            genreNotEdit.setVisible(true);
            publisherNotEdit.setVisible(true);
            printDateNotEdit.setVisible(true);
            copyQNotEdit.setVisible(true);
            LocationNotEdit.setVisible(true);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(true);
            AuthorNameInput.setVisible(false);
            GenreEdit.setVisible(false);
            DescEdit.setVisible(false);
            publisherEdit.setVisible(false);
            printDateEdit.setVisible(false);
            cQuantyEdit.setVisible(false);
            locationEdit.setVisible(false);
            
        	break ;
        	
        case "Author Name":
        	NameNotEdit.setVisible(true);
            AuthorNotEdit.setVisible(false);
            DescNotEdit.setVisible(true);
            genreNotEdit.setVisible(true);
            publisherNotEdit.setVisible(true);
            printDateNotEdit.setVisible(true);
            copyQNotEdit.setVisible(true);
            LocationNotEdit.setVisible(true);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(false);
            AuthorNameInput.setVisible(true);
            GenreEdit.setVisible(false);
            DescEdit.setVisible(false);
            publisherEdit.setVisible(false);
            printDateEdit.setVisible(false);
           cQuantyEdit.setVisible(false);
            locationEdit.setVisible(false);
        	break ;
        	
        case "Description":
        	NameNotEdit.setVisible(true);
            AuthorNotEdit.setVisible(true);
            DescNotEdit.setVisible(false);
            genreNotEdit.setVisible(true);
            publisherNotEdit.setVisible(true);
            printDateNotEdit.setVisible(true);
            copyQNotEdit.setVisible(true);
            LocationNotEdit.setVisible(true);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(false);
            AuthorNameInput.setVisible(false);
            GenreEdit.setVisible(false);
            DescEdit.setVisible(true);
            publisherEdit.setVisible(false);
            printDateEdit.setVisible(false);
           cQuantyEdit.setVisible(false);
            locationEdit.setVisible(false);
        	break ;
        	
        case "Genre":
        	NameNotEdit.setVisible(true);
            AuthorNotEdit.setVisible(true);
            DescNotEdit.setVisible(true);
            genreNotEdit.setVisible(false);
            publisherNotEdit.setVisible(true);
            printDateNotEdit.setVisible(true);
            copyQNotEdit.setVisible(true);
            LocationNotEdit.setVisible(true);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(false);
            AuthorNameInput.setVisible(false);
            GenreEdit.setVisible(true);
            DescEdit.setVisible(false);
            publisherEdit.setVisible(false);
            printDateEdit.setVisible(false);
           cQuantyEdit.setVisible(false);
            locationEdit.setVisible(false);
        	break ;
        	
        case "Publisher":
        	NameNotEdit.setVisible(true);
            AuthorNotEdit.setVisible(true);
            DescNotEdit.setVisible(true);
            genreNotEdit.setVisible(true);
            publisherNotEdit.setVisible(false);
            printDateNotEdit.setVisible(true);
            copyQNotEdit.setVisible(true);
            LocationNotEdit.setVisible(true);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(false);
            AuthorNameInput.setVisible(false);
            GenreEdit.setVisible(false);
            DescEdit.setVisible(false);
            publisherEdit.setVisible(true);
            printDateEdit.setVisible(false);
           cQuantyEdit.setVisible(false);
            locationEdit.setVisible(false);
        	break ;
        	
        case "Printdate":
        	NameNotEdit.setVisible(true);
            AuthorNotEdit.setVisible(true);
            DescNotEdit.setVisible(true);
            genreNotEdit.setVisible(true);
            publisherNotEdit.setVisible(true);
            printDateNotEdit.setVisible(false);
            copyQNotEdit.setVisible(true);
            LocationNotEdit.setVisible(true);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(false);
            AuthorNameInput.setVisible(false);
            GenreEdit.setVisible(false);
            DescEdit.setVisible(false);
            publisherEdit.setVisible(false);
            printDateEdit.setVisible(true);
            cQuantyEdit.setVisible(false);
            locationEdit.setVisible(false);
        	break ;
        	
        case "Copy Quantity":
        	NameNotEdit.setVisible(true);
            AuthorNotEdit.setVisible(true);
            DescNotEdit.setVisible(true);
            genreNotEdit.setVisible(true);
            publisherNotEdit.setVisible(true);
            printDateNotEdit.setVisible(true);
            copyQNotEdit.setVisible(false);
            LocationNotEdit.setVisible(true);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(false);
            AuthorNameInput.setVisible(false);
            GenreEdit.setVisible(false);
            DescEdit.setVisible(false);
            publisherEdit.setVisible(false);
            printDateEdit.setVisible(false);
           cQuantyEdit.setVisible(true);
            locationEdit.setVisible(false);
            break;
            
        case "Location Shelf":
        	NameNotEdit.setVisible(true);
            AuthorNotEdit.setVisible(true);
            DescNotEdit.setVisible(true);
            genreNotEdit.setVisible(true);
            publisherNotEdit.setVisible(true);
            printDateNotEdit.setVisible(true);
            copyQNotEdit.setVisible(true);
            LocationNotEdit.setVisible(false);
        	saveAll.setVisible(true);
        	bookNametxt.setVisible(true);
            authorTxt.setVisible(true);
            desTxt.setVisible(true);
            genreTxt.setVisible(true);
            publisherTxt.setVisible(true);
            printedatetxt.setVisible(true);
            cqTxt.setVisible(true);
            locationTxt.setVisible(true);
            nemeEdit.setVisible(false);
            AuthorNameInput.setVisible(false);
            GenreEdit.setVisible(false);
            DescEdit.setVisible(false);
            publisherEdit.setVisible(false);
            printDateEdit.setVisible(false);
           cQuantyEdit.setVisible(false);
            locationEdit.setVisible(true);
        	break ;
        	
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

    @FXML
    void saveAllFunc(ActionEvent event) 
    {

    }
    @FXML
    void serach(ActionEvent event) 
    {
    	
    	 ArrayList<String> msg = new ArrayList<String>();
         ArrayList<Book>  result = new ArrayList<Book>();
         if(searchInput.getText().equals(""))
         {
        	comboEdit.setDisable(true);
           	edit.setDisable(true);
           	NameNotEdit.setVisible(false);
            AuthorNotEdit.setVisible(false);
            DescNotEdit.setVisible(false);
            genreNotEdit.setVisible(false);
            publisherNotEdit.setVisible(false);
            printDateNotEdit.setVisible(false);
            copyQNotEdit.setVisible(false);
            LocationNotEdit.setVisible(false);
        	saveAll.setVisible(false);
        	bookNametxt.setVisible(false);
            authorTxt.setVisible(false);
            desTxt.setVisible(false);
            genreTxt.setVisible(false);
            publisherTxt.setVisible(false);
            printedatetxt.setVisible(false);
            cqTxt.setVisible(false);
            locationTxt.setVisible(false);
            nemeEdit.setVisible(false);
            AuthorNameInput.setVisible(false);
            GenreEdit.setVisible(false);
            DescEdit.setVisible(false);
            publisherEdit.setVisible(false);
            printDateEdit.setVisible(false);
           cQuantyEdit.setVisible(false);
            locationEdit.setVisible(false);
        	 JOptionPane.showMessageDialog(null, "Please fill out the field !!");
         }
         else 
         {
          msg.add(searchInput.getText());
          msg.add("SearchBookAndReturn");
          result = (ArrayList<Book>)IPController.client.Request(msg);
          System.out.println(result);
          if(result.size()>0)
          {
        	comboEdit.setDisable(false);
          	edit.setDisable(false);
        	NameNotEdit.setText(result.get(0).getBookName());
            AuthorNotEdit.setText(result.get(0).getAuthor());
            DescNotEdit.setText(result.get(0).getDescription());
            genreNotEdit.setText(result.get(0).getGenre());
            publisherNotEdit.setText(result.get(0).getPublisher());
            printDateNotEdit.setText(result.get(0).getPrintdate());
            copyQNotEdit.setText(""+result.get(0).getCopyQuantity());
            LocationNotEdit.setText(result.get(0).getLocation());
          }
          else {
        	  JOptionPane.showMessageDialog(null, "The book you are trying to update is not exists !!");
        	  comboEdit.setDisable(true);
             	edit.setDisable(true);
             	NameNotEdit.setVisible(false);
              AuthorNotEdit.setVisible(false);
              DescNotEdit.setVisible(false);
              genreNotEdit.setVisible(false);
              publisherNotEdit.setVisible(false);
              printDateNotEdit.setVisible(false);
              copyQNotEdit.setVisible(false);
              LocationNotEdit.setVisible(false);
          	saveAll.setVisible(false);
          	bookNametxt.setVisible(false);
              authorTxt.setVisible(false);
              desTxt.setVisible(false);
              genreTxt.setVisible(false);
              publisherTxt.setVisible(false);
              printedatetxt.setVisible(false);
              cqTxt.setVisible(false);
              locationTxt.setVisible(false);
              nemeEdit.setVisible(false);
              AuthorNameInput.setVisible(false);
              GenreEdit.setVisible(false);
              DescEdit.setVisible(false);
              publisherEdit.setVisible(false);
              printDateEdit.setVisible(false);
             cQuantyEdit.setVisible(false);
              locationEdit.setVisible(false);
          }
          }
    	
    }


}
