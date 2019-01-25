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

public class SearchBookController {
	
	public static int Flag = 0;  //// NAME = 1, GENRE = 2, DESCRIPTION = 3, AUTHOR = 4
	public static String BookIDvariable = "NO";
	private String TempID;
	private ArrayList<String> l=new ArrayList<String>();
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

    public void searchByName()
    {
    	TempID = bookID.getText();
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
    		BookIDvariable = result.get(0);
    		l=result;
    		System.out.println(BookIDvariable);

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

            for (int i=0;i < result.size();i+=10) 
            {
              VBox box = new VBox();
              AnchorPane pane2 = new AnchorPane();
              
             if(result.get(i+8).equals("available")) {
            	  String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)  +"\nShelf: "+result.get(i+9));
            	  
            	  Label label1 = new Label() ;
            	  label1.setPrefSize(400, 200);
                         Pane textPane = new Pane();
                          textPane.setPrefSize(150, 100);
           	              textPane.getChildren().add(label1);
         	              label1.setText(string);
         	              label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
         	                                   
         	              label1.setWrapText(true);
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
        	                           
        	                           else {
        	                        	   JOptionPane.showMessageDialog(null, "Please log-In !");
        	                        	   ((Node)event.getSource()).getScene().getWindow().hide();
            	                       Stage primaryStage = new Stage();
            	                       FXMLLoader loader = new FXMLLoader();
            	                       Pane root;
    				                      try {
    							           root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
    							           Scene scene = new Scene(root);
    							           primaryStage.setScene(scene);		
            	                           primaryStage.show();
    									} catch (IOException e) {
    										// TODO Auto-generated catch block
    										e.printStackTrace();
    										}
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
        	                          }  );	
        	                      }	  
	                         
        	                                         
                  
            
             else {
            		////returning the closest returning date 
            		System.out.println("There are not available copies!!");
            		ArrayList<String> msg3 = new ArrayList<String>();
                    ArrayList<String>  result3 = new ArrayList<String>();
                    msg3.add(result.get(i));
                	msg3.add("sortDate");
                	result3 = (ArrayList<String>)IPController.client.Request(msg3);
                	
                	
                	System.out.println(result3);
                	//System.out.println(result3.get(0));
            		
            		 String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)+ "\nClosest Return Date: "+result3.get(0));
               	  
                 	
                 	
                     Label label1 = new Label() ;
                     label1.setPrefSize(400, 200);

                      Pane textPane = new Pane();
                         textPane.setPrefSize(150, 100);
                          textPane.getChildren().add(label1);
                          label1.setText(string);
                          label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
                          label1.setWrapText(true);
                   
                           Button btncon=new Button("Book Content");
                           btncon.setLayoutX(20);
                           btncon.setLayoutY(100);
                           Pane BtnPane = new Pane();
                           BtnPane.setPrefWidth(400);
                           BtnPane.getChildren().addAll(btncon);
                           box.getChildren().addAll(textPane, BtnPane);
                           pane2.getChildren().add(box);
                           show.getChildren().addAll(pane2);
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
            	
        	                                                                    
            	
            }
        }
            
    }
    public void searchByAuthor()
    {
    	TempID = bookID.getText();
		bookID.clear();
		ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(TempID);
    	msg.add("SearchByAuthor");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    
    	System.out.println(result);
		if(TempID.equals("")|| result.isEmpty()) {

    		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
		}
		BookIDvariable = result.get(0);
		l=result;
		System.out.println(BookIDvariable);

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
 		//msg1.add(result.get(0));
 	//	msg1.add(result.get(8));
 	//	msg1.add("SearchBookStatusAndLocation");
 	//	ArrayList<String>  result1 = new ArrayList<String>();
 	//	result1 = (ArrayList<String>)IPController.client.Request(msg1);
 	//	System.out.println(result1);

        for (int i=0;i < result.size();i+=10) 
        {
          VBox box = new VBox();
          AnchorPane pane2 = new AnchorPane();
          
         if(result.get(i+8).equals("available")) {
        	  String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)  +"\nShelf: "+result.get(i+9));
        	  
        	  Label label1 = new Label() ;
        	  label1.setPrefSize(400, 200);
                     Pane textPane = new Pane();
                      textPane.setPrefSize(150, 100);
       	              textPane.getChildren().add(label1);
     	              label1.setText(string);
     	              label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
     	                                   
     	              label1.setWrapText(true);
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
    	                           
    	                           else {
    	                        	   JOptionPane.showMessageDialog(null, "Please log-In !");
    	                        	   ((Node)event.getSource()).getScene().getWindow().hide();
        	                       Stage primaryStage = new Stage();
        	                       FXMLLoader loader = new FXMLLoader();
        	                       Pane root;
				                      try {
							           root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
							           Scene scene = new Scene(root);
							           primaryStage.setScene(scene);		
        	                           primaryStage.show();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										}
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
    	                          }  );	
    	                      }	  
                         
    	                                         
              
        
         else {
        		////returning the closest returning date 
        		System.out.println("There are not available copies!!");
        		ArrayList<String> msg3 = new ArrayList<String>();
                ArrayList<String>  result3 = new ArrayList<String>();
                msg3.add(result.get(i));
            	msg3.add("sortDate");
            	result3 = (ArrayList<String>)IPController.client.Request(msg3);
            	
            	
            	System.out.println(result3);
            	//System.out.println(result3.get(0));
        		
        		 String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)+ "\nClosest Return Date: "+result3.get(0));
           	  
             	
             	
                 Label label1 = new Label() ;
                 label1.setPrefSize(400, 200);

                  Pane textPane = new Pane();
                     textPane.setPrefSize(150, 100);
                      textPane.getChildren().add(label1);
                      label1.setText(string);
                      label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
                      label1.setWrapText(true);
               
                       Button btncon=new Button("Book Content");
                       btncon.setLayoutX(20);
                       btncon.setLayoutY(100);
                       Pane BtnPane = new Pane();
                       BtnPane.setPrefWidth(400);
                       BtnPane.getChildren().addAll(btncon);
                       box.getChildren().addAll(textPane, BtnPane);
                       pane2.getChildren().add(box);
                       show.getChildren().addAll(pane2);
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
        	
    	                                                                    
        	
        }
    }
    public void searchByGenre()
    {

		TempID = bookID.getText();
		bookID.clear();
		ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(TempID);
    	msg.add("SearchByGenre");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
		if(TempID.equals("")|| result.isEmpty()) {

    		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
		}
		BookIDvariable = result.get(0);
		l=result;
		System.out.println(BookIDvariable);

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
 		//msg1.add(result.get(0));
 	//	msg1.add(result.get(8));
 	//	msg1.add("SearchBookStatusAndLocation");
 	//	ArrayList<String>  result1 = new ArrayList<String>();
 	//	result1 = (ArrayList<String>)IPController.client.Request(msg1);
 	//	System.out.println(result1);

        for (int i=0;i < result.size();i+=10) 
        {
          VBox box = new VBox();
          AnchorPane pane2 = new AnchorPane();
          
         if(result.get(i+8).equals("available")) {
        	  String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)  +"\nShelf: "+result.get(i+9));
        	  
        	  Label label1 = new Label() ;
        	  label1.setPrefSize(400, 200);
                     Pane textPane = new Pane();
                      textPane.setPrefSize(150, 100);
       	              textPane.getChildren().add(label1);
     	              label1.setText(string);
     	              label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
     	                                   
     	              label1.setWrapText(true);
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
    	                           
    	                           else {
    	                        	   JOptionPane.showMessageDialog(null, "Please log-In !");
    	                        	   ((Node)event.getSource()).getScene().getWindow().hide();
        	                       Stage primaryStage = new Stage();
        	                       FXMLLoader loader = new FXMLLoader();
        	                       Pane root;
				                      try {
							           root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
							           Scene scene = new Scene(root);
							           primaryStage.setScene(scene);		
        	                           primaryStage.show();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										}
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
    	                          }  );	
    	                      }	  
                         
    	                                         
              
        
         else {
        		////returning the closest returning date 
        		System.out.println("There are not available copies!!");
        		ArrayList<String> msg3 = new ArrayList<String>();
                ArrayList<String>  result3 = new ArrayList<String>();
                msg3.add(result.get(i));
            	msg3.add("sortDate");
            	result3 = (ArrayList<String>)IPController.client.Request(msg3);
            	
            	
            	System.out.println(result3);
            	//System.out.println(result3.get(0));
        		
        		 String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)+ "\nClosest Return Date: "+result3.get(0));
           	  
             	
             	
                 Label label1 = new Label() ;
                 label1.setPrefSize(400, 200);

                  Pane textPane = new Pane();
                     textPane.setPrefSize(150, 100);
                      textPane.getChildren().add(label1);
                      label1.setText(string);
                      label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
                      label1.setWrapText(true);
               
                       Button btncon=new Button("Book Content");
                       btncon.setLayoutX(20);
                       btncon.setLayoutY(100);
                       Pane BtnPane = new Pane();
                       BtnPane.setPrefWidth(400);
                       BtnPane.getChildren().addAll(btncon);
                       box.getChildren().addAll(textPane, BtnPane);
                       pane2.getChildren().add(box);
                       show.getChildren().addAll(pane2);
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
        	
    	                                                                    
        	
        }
        
    }
    public void searchByDescription()
    {

		TempID = bookID.getText();
		bookID.clear();
		ArrayList<String> msg = new ArrayList<String>();
        ArrayList<String>  result = new ArrayList<String>();
    	msg.add(TempID);
    	msg.add("SearchByDescription");
    	result = (ArrayList<String>)IPController.client.Request(msg);
    	System.out.println(result);
		if(TempID.equals("")|| result.isEmpty()) {

    		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
		}
		BookIDvariable = result.get(0);
		l=result;
		System.out.println(BookIDvariable);

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
 		//msg1.add(result.get(0));
 	//	msg1.add(result.get(8));
 	//	msg1.add("SearchBookStatusAndLocation");
 	//	ArrayList<String>  result1 = new ArrayList<String>();
 	//	result1 = (ArrayList<String>)IPController.client.Request(msg1);
 	//	System.out.println(result1);

        for (int i=0;i < result.size();i+=10) 
        {
          VBox box = new VBox();
          AnchorPane pane2 = new AnchorPane();
          
         if(result.get(i+8).equals("available")) {
        	  String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)  +"\nShelf: "+result.get(i+9));
        	  
        	  Label label1 = new Label() ;
        	  label1.setPrefSize(400, 200);
                     Pane textPane = new Pane();
                      textPane.setPrefSize(150, 100);
       	              textPane.getChildren().add(label1);
     	              label1.setText(string);
     	              label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
     	                                   
     	              label1.setWrapText(true);
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
    	                           
    	                           else {
    	                        	   JOptionPane.showMessageDialog(null, "Please log-In !");
    	                        	   ((Node)event.getSource()).getScene().getWindow().hide();
        	                       Stage primaryStage = new Stage();
        	                       FXMLLoader loader = new FXMLLoader();
        	                       Pane root;
				                      try {
							           root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
							           Scene scene = new Scene(root);
							           primaryStage.setScene(scene);		
        	                           primaryStage.show();
									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
										}
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
    	                          }  );	
    	                      }	  
                         
    	                                         
              
        
         else {
        		////returning the closest returning date 
        		System.out.println("There are not available copies!!");
        		ArrayList<String> msg3 = new ArrayList<String>();
                ArrayList<String>  result3 = new ArrayList<String>();
                msg3.add(result.get(i));
            	msg3.add("sortDate");
            	result3 = (ArrayList<String>)IPController.client.Request(msg3);
            	
            	
            	System.out.println(result3);
            	//System.out.println(result3.get(0));
        		
        		 String string = new String("Book Id: " + result.get(i) + "\nBook Name : " + result.get(i+1) + "\nAuthor Name: " + result.get(i+2) + "\nGenre : " + result.get(i+3)+ "\nClosest Return Date: "+result3.get(0));
           	  
             	
             	
                 Label label1 = new Label() ;
                 label1.setPrefSize(400, 200);

                  Pane textPane = new Pane();
                     textPane.setPrefSize(150, 100);
                      textPane.getChildren().add(label1);
                      label1.setText(string);
                      label1.setFont(Font.font("Josefin Sans", FontWeight.BOLD, 16));
                      label1.setWrapText(true);
               
                       Button btncon=new Button("Book Content");
                       btncon.setLayoutX(20);
                       btncon.setLayoutY(100);
                       Pane BtnPane = new Pane();
                       BtnPane.setPrefWidth(400);
                       BtnPane.getChildren().addAll(btncon);
                       box.getChildren().addAll(textPane, BtnPane);
                       pane2.getChildren().add(box);
                       show.getChildren().addAll(pane2);
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
        	
    	                                                                    
        	
        }
    }
    @FXML
    void Search(ActionEvent event) {
    	//String status="Available";
    	if(Flag == 0) {
    		JOptionPane.showMessageDialog(null, "Book Not Found! Please Try Again");
    	}
    	
    	if(Flag == 1) 
    		searchByName();
    		
               
        if(Flag == 2) 
          searchByGenre();
            	
         if(Flag == 3) 
           searchByDescription();
            	
          if(Flag == 4) 
           searchByAuthor();
    	
  
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

	 @FXML
	    void Exitbtn(ActionEvent event) throws IOException
	 {
		 
		    Pane root ;
		 	((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		if(sigINController.LibrarianId==null && sigINController.StudentId ==null && sigINController.ManagementId ==null)
	  		  root = loader.load(getClass().getResource("/application/IP.fxml").openStream());
	  		
	  		else
	  		{
	  		 root = loader.load(getClass().getResource("/application/sigIN.fxml").openStream());
			 	sigINController.LibrarianId=null;
			 	sigINController.StudentId =null;
			 	sigINController.ManagementId =null ;
	  		}
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	   }
	 
	 @FXML
	    void prevbtn(ActionEvent event)throws IOException
	 {
		 ((Node)event.getSource()).getScene().getWindow().hide();
	  		Stage primaryStage = new Stage();
	  		FXMLLoader loader = new FXMLLoader();
	  		Pane root = loader.load(getClass().getResource("/application/"+IPController.backGui+".fxml").openStream());
	  		
	  		Scene scene = new Scene(root);			
	  		
	  		primaryStage.setScene(scene);		
	  		primaryStage.show();
	    }
}


