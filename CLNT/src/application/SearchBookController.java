package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import wep.Browser ;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import TableView.BookTable;
/**
 * Searching book controller
 * @author Reem Hamed
 *
 */
public class SearchBookController {
	public static int Flag = 0;  //// NAME = 1, GENRE = 2, DESCRIPTION = 3, AUTHOR = 4
	public static String BookIDvariable = "NO";
	private String TempID;
	private ArrayList<String> l=new ArrayList<String>();

    @FXML
    private Button btnLend;
    @FXML
    private Button btnContent;
	@FXML
    private Button prev;

    @FXML
    private Button NAMEBtn;

    @FXML
    private Button GENREBtn;

    @FXML
    private Button DESCRIPTIONBtn;

    @FXML
    private Button AUTHORBtn;

    @FXML
    private Text SEARCHBYlabel;

    @FXML
    private TextField bookID;

    @FXML
    private TableView<BookTable> BookTable;

    @FXML
    private TableColumn<BookTable, String> NameCol;     

    @FXML
    private TableColumn<BookTable, String> IDCol;

    @FXML
    private TableColumn<BookTable, String> AuthorCol;

    @FXML
    private TableColumn<BookTable, String> GenreCol;

    @FXML
    private TableColumn<BookTable, String> DescriptionCol;

    @FXML
    private TableColumn<BookTable, String> shelfCol;

    @FXML
    private TableColumn<BookTable, String> retundDateCol;

    @FXML
    private Text contentTxt;

    @FXML
    /**
     * Searching book By name
     */
    private Text lendTxt;  
    public void searchByName()
    {TempID = bookID.getText();
	//bookID.clear();
	ArrayList<String> msg = new ArrayList<String>();
    ArrayList<String>  result = new ArrayList<String>();
	msg.add(TempID);
	msg.add("SearchByName");
	result = (ArrayList<String>)IPController.client.Request(msg);
	int sizeResult ;
	
	System.out.println(result);
	if(TempID.equals(""))JOptionPane.showMessageDialog(null, "Please fill out the field !!");
	if(result.isEmpty()) JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");

    if(result.size()>0) {
		
		l=result;

       ArrayList<String> msg1 = new ArrayList<String>();

       try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
   
        	//  BookTable.getColumns().addAll(NameCol,IDCol,AuthorCol,GenreCol, DescriptionCol,shelfCol,retundDateCol);
	        
		    
	        final ObservableList<BookTable> data = FXCollections.observableArrayList();
	        
	        for (int i = 0; i < result.size(); i+=10) {
	         if(result.get(i+8).equals("available"))
	           data.add(new BookTable (result.get(i+1),result.get(i),result.get(i+2),result.get(i+3),result.get(i+4),result.get(i+9),""));
	       
	         else
	         {
         		System.out.println("There are not available copies!!");
         		ArrayList<String> msg3 = new ArrayList<String>();
                 ArrayList<String>  result3 = new ArrayList<String>();
                 msg3.add(result.get(i));
             	msg3.add("sortDate");
             	result3 = (ArrayList<String>)IPController.client.Request(msg3);
                System.out.println(result3);
                if(result3.size()>0)
 	           data.add(new BookTable (result.get(i+1),result.get(i),result.get(i+2),result.get(i+3),result.get(i+4),"",result3.get(0)));

             	//System.out.println(result3.get(0));
	         }
	        }
	        
	        
	        NameCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("BookName"));
	        
	        IDCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("BookID"));

	        AuthorCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("AuthorName"));

	        GenreCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Genre"));
	        
	        DescriptionCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Description"));
	        
	        shelfCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Shelf"));
	        
	        retundDateCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("returnDate"));
	        
	         BookTable.setItems(data);
	       
    }       
    }
    /**
     * Searching book by author
     */
    public void searchByAuthor()
    {
    	TempID = bookID.getText();
		//bookID.clear();
		ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(TempID);
    	msg.add("SearchByAuthor");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	int sizeResult ;
    	
    	System.out.println(result);
    	if(TempID.equals(""))JOptionPane.showMessageDialog(null, "Please fill out the field !!");
    	if(result.isEmpty()) JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
	
        if(result.size()>0) {
    		
    		l=result;

           ArrayList<String> msg1 = new ArrayList<String>();

           try {
   			Thread.sleep(100);
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}    	
       
            	//  BookTable.getColumns().addAll(NameCol,IDCol,AuthorCol,GenreCol, DescriptionCol,shelfCol,retundDateCol);
    	        
    		    
    	        final ObservableList<BookTable> data = FXCollections.observableArrayList();
    	        
    	        for (int i = 0; i < result.size(); i+=10) {
    	         if(result.get(i+8).equals("available"))
    	           data.add(new BookTable (result.get(i+1),result.get(i),result.get(i+2),result.get(i+3),result.get(i+4),result.get(i+9),""));
    	       
    	         else
    	         {
             		System.out.println("There are not available copies!!");
             		ArrayList<String> msg3 = new ArrayList<String>();
                     ArrayList<String>  result3 = new ArrayList<String>();
                     msg3.add(result.get(i));
                 	msg3.add("sortDate");
                 	result3 = (ArrayList<String>)IPController.client.Request(msg3);
                    System.out.println(result3);
                    
                    if(result3.size()>0)
      	           data.add(new BookTable (result.get(i+1),result.get(i),result.get(i+2),result.get(i+3),result.get(i+4),result.get(i+9),result3.get(0)));

                 	//System.out.println(result3.get(0));
    	         }
    	        }
    	        
    	        
    	        NameCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("BookName"));
    	        
    	        IDCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("BookID"));

    	        AuthorCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("AuthorName"));

    	        GenreCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Genre"));
    	        
    	        DescriptionCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Description"));
    	        
    	        shelfCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Shelf"));
    	        
    	        retundDateCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("returnDate"));
    	        
    	         BookTable.setItems(data);
    	       
        }
    }
    /**
     * Searching book by genre
     */
    public void searchByGenre()
    {
    	TempID = bookID.getText();
		//bookID.clear();
		ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(TempID);
    	msg.add("SearchByGenre");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	int sizeResult ;
    	
    	System.out.println(result);
    	if(TempID.equals(""))JOptionPane.showMessageDialog(null, "Please fill out the field !!");
    	if(result.isEmpty()) JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
	
        if(result.size()>0) {
    		
    		l=result;

           ArrayList<String> msg1 = new ArrayList<String>();

           try {
   			Thread.sleep(100);
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}    	
       
            	//  BookTable.getColumns().addAll(NameCol,IDCol,AuthorCol,GenreCol, DescriptionCol,shelfCol,retundDateCol);
    	        
    		    
    	        final ObservableList<BookTable> data = FXCollections.observableArrayList();
    	        
    	        for (int i = 0; i < result.size(); i+=10) {
    	         if(result.get(i+8).equals("available"))
    	           data.add(new BookTable (result.get(i+1),result.get(i),result.get(i+2),result.get(i+3),result.get(i+4),result.get(i+9),""));
    	       
    	         else
    	         {
             		System.out.println("There are not available copies!!");
             		ArrayList<String> msg3 = new ArrayList<String>();
                     ArrayList<String>  result3 = new ArrayList<String>();
                     msg3.add(result.get(i));
                 	msg3.add("sortDate");
                 	result3 = (ArrayList<String>)IPController.client.Request(msg3);
                    System.out.println(result3);
                    
                    if(result3.size()>0)
      	           data.add(new BookTable (result.get(i+1),result.get(i),result.get(i+2),result.get(i+3),result.get(i+4),result.get(i+9),result3.get(0)));

                 	//System.out.println(result3.get(0));
    	         }
    	        }
    	        
    	        
    	        NameCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("BookName"));
    	        
    	        IDCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("BookID"));

    	        AuthorCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("AuthorName"));

    	        GenreCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Genre"));
    	        
    	        DescriptionCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Description"));
    	        
    	        shelfCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Shelf"));
    	        
    	        retundDateCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("returnDate"));
    	        
    	         BookTable.setItems(data);
    	       
        }
        
    }
    /**
     * Searching book by description
     */
    public void searchByDescription()
    {
    	TempID = bookID.getText();
		//bookID.clear();
		ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(TempID);
    	msg.add("SearchByDescription");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	int sizeResult ;
    	
    	System.out.println(result);
    	if(TempID.equals(""))JOptionPane.showMessageDialog(null, "Please fill out the field !!");
    	if(result.isEmpty()) JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
	
        if(result.size()>0) {
    		
    		l=result;

           ArrayList<String> msg1 = new ArrayList<String>();

           try {
   			Thread.sleep(100);
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}    	
       
            	//  BookTable.getColumns().addAll(NameCol,IDCol,AuthorCol,GenreCol, DescriptionCol,shelfCol,retundDateCol);
    	        
    		    
    	        final ObservableList<BookTable> data = FXCollections.observableArrayList();
    	        
    	        for (int i = 0; i < result.size(); i+=10) {
    	         if(result.get(i+8).equals("available"))
    	           data.add(new BookTable (result.get(i+1),result.get(i),result.get(i+2),result.get(i+3),result.get(i+4),result.get(i+9),""));
    	       
    	         else
    	         {
             		System.out.println("There are not available copies!!");
             		ArrayList<String> msg3 = new ArrayList<String>();
                     ArrayList<String>  result3 = new ArrayList<String>();
                     msg3.add(result.get(i));
                 	msg3.add("sortDate");
                 	result3 = (ArrayList<String>)IPController.client.Request(msg3);
                    System.out.println(result3);
                    
                    if(result3.size()>0)
      	           data.add(new BookTable (result.get(i+1),result.get(i),result.get(i+2),result.get(i+3),result.get(i+4),result.get(i+9),result3.get(0)));

                 	//System.out.println(result3.get(0));
    	         }
    	        }
    	        
    	        
    	        NameCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("BookName"));
    	        
    	        IDCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("BookID"));

    	        AuthorCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("AuthorName"));

    	        GenreCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Genre"));
    	        
    	        DescriptionCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Description"));
    	        
    	        shelfCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("Shelf"));
    	        
    	        retundDateCol.setCellValueFactory(new PropertyValueFactory<BookTable,String>("returnDate"));
    	        
    	         BookTable.setItems(data);
    	       
        }
    }
    @FXML
    /**
     * Searching Button handler
     * @param event
     */
    void Search(ActionEvent event) {
    	//String status="Available";
    	if(Flag == 0) {
    	//	JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
        	SEARCHBYlabel.setText("Search By Descriptin:");
    		searchByDescription();
    	}
    	
    	if(Flag == 1) {
    		searchByName();
    		SEARCHBYlabel.setText("Search By :");
    		Flag=0;	
    	}
    		
               
        if(Flag == 2) {
          searchByGenre();
          SEARCHBYlabel.setText("Search By :");
          Flag=0;
          }
            	
          if(Flag == 4) {
           searchByAuthor();
           SEARCHBYlabel.setText("Search By :");
           Flag=0;
          }
    	
  
    }
    @FXML
    /**
     * Search by author Button handler
     * @param event
     */
    void AuthorFunc(ActionEvent event) {
    	Flag = 4;
    	SEARCHBYlabel.setText("Search By Author:");
    }


    @FXML
    /**
     * Search by genre Button handler
     * @param event
     */
    void GenreFunc(ActionEvent event) {
    	Flag = 2;
    	SEARCHBYlabel.setText("Search By Genre:");
    }

    @FXML
    /**
     * Searching by name Button handler
     * @param event
     */
    void NameFun(ActionEvent event) {
    	Flag = 1;
    	SEARCHBYlabel.setText("Search By Name:");
    }


    @FXML
    /**
     * Showing book content Button handler
     * @param event
     */
    void bookContent(ActionEvent event) throws IOException {
   /* 	try {
   		
   		if(!BookIDvariable.equals("NO")) {
   			//System.out.println(BookIDvariable);
			Desktop.getDesktop().open(new java.io.File("PDFs/"+BookIDvariable+".pdf"));
   		} else {
   			System.out.println("tst");
   			JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
   		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/
    	
    	
    	ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(BookIDvariable);
    	msg.add("BookPDF");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	byte[] by_new = Base64.getDecoder().decode(result.get(0));
    	File someFile2 = new File("fromserverinclient.pdf"); // change the Byte[] to file
		FileOutputStream fos1 = new FileOutputStream(someFile2);
		fos1.write(by_new);
		fos1.flush();
		fos1.close();
		Desktop.getDesktop().open(someFile2);
    	
    	
    	
    }

    @FXML
    /**
     * Lending book Button handler
     * @param event
     */
    void lendBook(ActionEvent event)
    {
    	   if(sigINController.LibrarianId!=null)   {                                      		  
               ((Node)event.getSource()).getScene().getWindow().hide();
               Stage primaryStage = new Stage();
               FXMLLoader loader = new FXMLLoader();
               Pane root;
                  try {
		           root = loader.load(getClass().getResource("/application/loanBook.fxml").openStream());
		           Scene scene = new Scene(root);
		           primaryStage.setScene(scene);		
                   primaryStage.show();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
                   }
                   
                   else 
                	   JOptionPane.showMessageDialog(null, "You can't lend the book , you must go to the librarian and lend the book");

    }

    @FXML
    /**
     * 
     * @param event
     * @throws IOException
     */
    void prevbtn(ActionEvent event) throws IOException {
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
     * Selecting the wanting book using the mouse
     * @param event
     */
    void selectBook(MouseEvent event) {
    	BookTable s = BookTable.getSelectionModel().getSelectedItem();
    	BookIDvariable =s.getBookID();
    	System.out.println(BookIDvariable);
    	contentTxt.setVisible(true); 
    	btnContent.setVisible(true);
    	
    	if(s.getReturnDate().equals(""))
    	{
    		btnLend.setVisible(true);
    		lendTxt.setVisible(true);
    	}
    	else
    	{
    		btnLend.setVisible(false);
    		lendTxt.setVisible(false);
    	}
    }
    

    @FXML
    /**
     * Searching by google Button handler
     * @param event
     */
    void searchGoogle(ActionEvent event) {
    	   Scene scene;
    	   Stage stage = new Stage();
	    	 stage.setTitle("Web View");
	         scene = new Scene(new Browser(),750,500, Color.web("#666970"));
	         stage.setScene(scene);
	         scene.getStylesheets().add("webviewsample/BrowserToolbar.css");        
	         stage.show();
    }

}
