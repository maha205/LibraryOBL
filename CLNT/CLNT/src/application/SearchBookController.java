package application;

import java.awt.Desktop;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SearchBookController  
{
	public static int Flag = 0;  //// NAME = 1, GENRE = 2, DESCRIPTION = 3, AUTHOR = 4
	public static String BookIDvariable = "NO";
	private String TempID;
	@FXML
    private AnchorPane Achor;
	@FXML
    private AnchorPane UserAnchorPane;
    @FXML
    private TextField bookID;

    @FXML
    private Label label;
    @FXML
    private Button Search;

    @FXML
    private Text IDLabel;

    @FXML
    private Text NAMELabel;

    @FXML
    private Text AUTHORLabel;

    @FXML
    private Button VIEWbtn;
    
    @FXML
    private Text GENRELabel;

    @FXML
    private Text DESCRIPTIONLabel;

    @FXML
    private Text PUBLISHERLabel;

    @FXML
    private Text PRINTIDLabel;

    @FXML
    private Text SEARCHBYlabel;

    @FXML
    private Button NAMEBtn;

    @FXML
    private Button GENREBtn;

    @FXML
    private Button DESCRIPTIONBtn;

    @FXML
    private Button AUTHORBtn;
    @FXML
    private Label Label1;
    

    @FXML
    private Button prev;

    @FXML
    private Button Exit;

    @FXML
    void Search(ActionEvent event) {
    	//String status="Available";
    	if(Flag == 0) {
    		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
    	}
    	
    	if(Flag == 1) {
    		
    		TempID = bookID.getText();
    		bookID.clear();
    		ArrayList<String> msg = new ArrayList<String>();
            ArrayList<String>  result = new ArrayList<String>();
        	msg.add(TempID);
        	msg.add("SearchByName");
        	result = (ArrayList<String>)IPController.client.Request(msg);
        	
        	
        	System.out.println(result);
        	
        	
        	
        	 
        		if(TempID.equals("")) {

            		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
        		}
        		BookIDvariable = result.get(0);
        		System.out.println(BookIDvariable);
        		/*IDLabel.setText(result.get(0));
        		NAMELabel.setText(result.get(1));
        		AUTHORLabel.setText(result.get(2));
        		GENRELabel.setText(result.get(3));
        		DESCRIPTIONLabel.setText(result.get(4));
        		PUBLISHERLabel.setText(result.get(5));
        		PRINTIDLabel.setText(result.get(6));*/
        		
        	
        		 FlowPane show = new FlowPane();

                show.setPrefWidth(300);

                show.setPrefHeight(200);

                show.setPadding(new Insets(10, 10, 10, 10));

                show.setVgap(30);

                show.setHgap(15);

                show.setAlignment(Pos.CENTER);

                ScrollPane scroll = new ScrollPane();

                scroll.setPrefSize(947, 335);
                //scroll.setStyle( "#FFE4C4");
                Pane ShowPane = new Pane();

                ShowPane.getChildren().add(show);

                show.setLayoutX(10);

                show.setLayoutY(10);

                scroll.setContent(ShowPane);

                scroll.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);

                scroll.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

               Achor.getChildren().add(scroll);
               ArrayList<String> msg1 = new ArrayList<String>();
         		msg1.add(BookIDvariable);
         		msg1.add("SearchBookStatusAndLocation");
         		ArrayList<String>  result1 = new ArrayList<String>();
         		result1 = (ArrayList<String>)IPController.client.Request(msg1);
    
                for (int i=0;i < result.size();i+=8) 
                	
                {
                	 VBox box = new VBox();
                	 AnchorPane pane2 = new AnchorPane();
                	
                	if(result1.size()>0) {
                	  String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)  +"\nShelf: "+result1.get(0));
                	  
                	//  if (result1.size()>0) 
                	//  {
                	                              Label label1 = new Label() ;
                	                              label1.setPrefSize(400, 200);
                	  
                                                   Pane textPane = new Pane();
                      
                   
                  //    if (result1.size()>0)
                      
              	                                    textPane.setPrefSize(150, 100);
                	  
               	                                    textPane.getChildren().add(label1);
                	  
             	                                    label1.setText(string);
             	                                    label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
             	                                   
             	                                    label1.setWrapText(true);
             	                                    
             	                                    
             	                                   /////////////////finding available copies
             	                                 
             	                                 
             	                                	   //System.out.println("fffffffffffffffffffffffffffffffffffffffffff");
             	                                   Button btn = new Button("Loan Book");
             	                                   Button btncon=new Button("Book Content");
             	                                  
             	                                  
        	                                          btn.setLayoutX(20);
             	                                  
            	                                      btn.setLayoutY(60);
            	                                      
            	                                      btncon.setLayoutX(20);
                 	                                  
            	                                      btncon.setLayoutY(100);
             	                                   
             	                                 
             	                                      Pane BtnPane = new Pane();
             	                                 
            	                                       BtnPane.setPrefWidth(400);
             	                                  
            	                                       BtnPane.getChildren().addAll(btn,btncon);
             	                                   
             	                                      box.getChildren().addAll(textPane, BtnPane);
            	                                       pane2.getChildren().add(box);
             	                                  
            	                                       show.getChildren().addAll(pane2);
            	                                       
            	                                       btn.setOnAction(new EventHandler<ActionEvent>() {
            	                                        @Override
            	                                       public void handle(ActionEvent event) {
            	                                                                    		  
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
            	                                	  		
            	                                	  		            	                                        }});
            	                                       btncon.setOnAction(new EventHandler<ActionEvent>() {
               	                                        @Override
               	                                       public void handle(ActionEvent event) {
               	                                        	try {
               	                                     		
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
               	                                        }
               	                                     });		  
            	                                                                      
            	                                         
                      }
                	else {
                		////returning the closest returning date 
                		System.out.println("There are not available copies!!");
                	}
                	
            	                                                                    
                	
                }
                
                

               }
        	else {
        		BookIDvariable = "NO";
        
        	
        		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
        	}
    	
        	
        	
        	
        	if(Flag == 2) {
        		TempID = bookID.getText();
        		bookID.clear();
        		ArrayList<String> msg = new ArrayList<String>();
                ArrayList<String>  result = new ArrayList<String>();
            	msg.add(TempID);
            	msg.add("SearchByGenre");
            	result = (ArrayList<String>)IPController.client.Request(msg);
            	System.out.println(result);
            	if(result.size() >0) {
            		
            		BookIDvariable = result.get(0);
            		IDLabel.setText(result.get(0));
            		NAMELabel.setText(result.get(1));
            		AUTHORLabel.setText(result.get(2));
            		GENRELabel.setText(result.get(3));
            		DESCRIPTIONLabel.setText(result.get(4));
            		PUBLISHERLabel.setText(result.get(5));
            		PRINTIDLabel.setText(result.get(6));
            		
            		
            		
            		
            		
    /////////////////finding available copies
            		ArrayList<String> msg1 = new ArrayList<String>();
            		msg1.add(BookIDvariable);
            		msg1.add("SearchBookStatusAndLocation");
            		ArrayList<String>  result1 = new ArrayList<String>();
            		result1 = (ArrayList<String>)IPController.client.Request(msg1);
            		if(result1.size()>0) {
            		label.setText(result1.get(0));
            		System.out.println("Available copy was found!!");
            	
            		}
            	}
            	else {
            		BookIDvariable = "NO";
            		IDLabel.setText("Book ID");
            		NAMELabel.setText("Book Name");
            		AUTHORLabel.setText("Book Author");
            		GENRELabel.setText("Genre");
            		DESCRIPTIONLabel.setText("Description");
            		PUBLISHERLabel.setText("Publisher");
            		PRINTIDLabel.setText("Print ID");
            		

            		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
            	}
            	
            	
            	
            	
            	
        	}
        	
        	
        	
        	if(Flag == 3) {
        		TempID = bookID.getText();
        		bookID.clear();
        		ArrayList<String> msg = new ArrayList<String>();
                ArrayList<String>  result = new ArrayList<String>();
            	msg.add(TempID);
            	msg.add("SearchByDescription");
            	result = (ArrayList<String>)IPController.client.Request(msg);
            	System.out.println(result);
            	if(result.size() >0) {
            		
            		BookIDvariable = result.get(0);
            		IDLabel.setText(result.get(0));
            		NAMELabel.setText(result.get(1));
            		AUTHORLabel.setText(result.get(2));
            		GENRELabel.setText(result.get(3));
            		DESCRIPTIONLabel.setText(result.get(4));
            		PUBLISHERLabel.setText(result.get(5));
            		PRINTIDLabel.setText(result.get(6));
            		
            		
            		
            		
    /////////////////finding available copies
            		ArrayList<String> msg1 = new ArrayList<String>();
            		msg1.add(BookIDvariable);
            		msg1.add("SearchBookStatusAndLocation");
            		ArrayList<String>  result1 = new ArrayList<String>();
            		result1 = (ArrayList<String>)IPController.client.Request(msg1);
            		if(result1.size()>0) {
            		label.setText(result1.get(0));
            		System.out.println("Available copy was found!!");
            	
            		}
            	}
            	else {
            		BookIDvariable = "NO";
            		IDLabel.setText("Book ID");
            		NAMELabel.setText("Book Name");
            		AUTHORLabel.setText("Book Author");
            		GENRELabel.setText("Genre");
            		DESCRIPTIONLabel.setText("Description");
            		PUBLISHERLabel.setText("Publisher");
            		PRINTIDLabel.setText("Print ID");
            		
            		

            		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
            		
            	}
            	
            	
            	
            	
            	
        	}
    	
        	
        	
        	if(Flag == 4) {
        		TempID = bookID.getText();
        		bookID.clear();
        		ArrayList<String> msg = new ArrayList<String>();
                ArrayList<String>  result = new ArrayList<String>();
            	msg.add(TempID);
            	msg.add("SearchByAuthor");
            	result = (ArrayList<String>)IPController.client.Request(msg);
            
            	System.out.println(result);
            	if(result.size() >0) {
            		
            		BookIDvariable = result.get(0);
            		IDLabel.setText(result.get(0));
            		NAMELabel.setText(result.get(1));
            		AUTHORLabel.setText(result.get(2));
            		GENRELabel.setText(result.get(3));
            		DESCRIPTIONLabel.setText(result.get(4));
            		PUBLISHERLabel.setText(result.get(5));
            		PRINTIDLabel.setText(result.get(6));
            		
            		ArrayList<String> msg1 = new ArrayList<String>();
            		msg1.add(BookIDvariable);
            		msg1.add("SearchBookStatusAndLocation");
            		ArrayList<String>  result1 = new ArrayList<String>();
            		result1 = (ArrayList<String>)IPController.client.Request(msg1);
            		if(result1.size()>0) {
            		label.setText(result1.get(0));
            		System.out.println("Available copy was found!!");
            	
            		}
            		
            		
            	}
            	else {
            		BookIDvariable = "NO";
            		IDLabel.setText("Book ID");
            		NAMELabel.setText("Book Name");
            		AUTHORLabel.setText("Book Author");
            		GENRELabel.setText("Genre");
            		DESCRIPTIONLabel.setText("Description");
            		PUBLISHERLabel.setText("Publisher");
            		PRINTIDLabel.setText("Print ID");
            		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
            	}
            	
            	
            	
            	
            	
        	}
    	////END IF FLAG == 1
    	
   
    	
    	
    /*	TempID = bookID.getText();
    	bookID.clear();
        ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(TempID);
    	msg.add("SearchByName");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
    	if(result.size() >0) {
    		
    		BookIDvariable = result.get(0);
    		IDLabel.setText(result.get(0));
    		NAMELabel.setText(result.get(1));
    		AUTHORLabel.setText(result.get(2));
    	}
    	else {
    		BookIDvariable = "NO";
    		IDLabel.setText("Book ID");
    		NAMELabel.setText("Book Name");
    		AUTHORLabel.setText("Book Author");
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("ID Not Found");
    		alert.setHeaderText("Book ID Not Found! Please Try Again");
    		alert.showAndWait(); 
    	}*/
  
    }

    @FXML
    void View(ActionEvent event) {
    	try {
    		
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
    }
    
    
    @FXML
    void AuthorFunc(ActionEvent event) {
    	Flag = 4;
    	SEARCHBYlabel.setText("Search By Author:");
    }

    @FXML
    void DescriptionFunc(ActionEvent event) {
    	Flag = 3;
    	SEARCHBYlabel.setText("Search By Description:");
    }

    @FXML
    void GenreFunc(ActionEvent event) {
    	Flag = 2;
    	SEARCHBYlabel.setText("Search By Genre:");
    }

    @FXML
    void NameFun(ActionEvent event) {
    	Flag = 1;
    	SEARCHBYlabel.setText("Search By Name:");
    }
    
    
    
    
    
	public void start(Stage arg0) throws Exception {
        showStage();
}
	public void showStage() {
		
		//System.out.println("good" );
		Stage primaryStage = new Stage();
		
		Pane root;

		try {
	  		 root = FXMLLoader.load(getClass().getResource("/application/Test.fxml"));
	  		Scene scene = new Scene(root);			
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
		} catch (IOException e) {
		
			e.printStackTrace();
		}

		
	}
	 @FXML
	    void Exitbtn(ActionEvent event) throws IOException{
		 
		 ((Node)event.getSource()).getScene().getWindow().hide();
	    }
	 
	 @FXML
	    void prevbtn(ActionEvent event)throws IOException {
		 ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/mainForm.fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	    }
   @FXML
   void backGUi(ActionEvent event) throws IOException
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
 void exiteGui(ActionEvent event) throws IOException
 {
    String Exit ;
    if (IPController.backGui.equals("mainForm"))
    	Exit ="IP";
    else
    	Exit ="sigIN";
   
 	sigINController.LibrarianId=null;
 	sigINController.StudentId =null;
 	sigINController.ManagementId =null ;
 	((Node)event.getSource()).getScene().getWindow().hide();
		Stage primaryStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		Pane root = loader.load(getClass().getResource("/application/"+Exit+".fxml").openStream());
		
		Scene scene = new Scene(root);			
		
		primaryStage.setScene(scene);		
		primaryStage.show();
 }
}


