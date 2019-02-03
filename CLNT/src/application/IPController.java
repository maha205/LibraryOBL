package application;

import java.io.IOException;
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
 *IP controller
 *
 */
public class IPController
{
	public static String backGui =null;
	public static Client client = null;
    @FXML
    private TextField ipaddr;

    @FXML
    private Button ConnectButton;

    @FXML
    private TextField portTxt;

    @FXML
    private Text error;
    @FXML
    /**
     * Connect button handler to connect 
     * @param event
     * @throws IOException
     */
    void connect(ActionEvent event) throws IOException 
    {
    	 if(ipaddr.getText().equals("")|| portTxt.getText().equals("")) error.setVisible(true);
    	backGui ="IP";
    	if(ipaddr.getText().equals(null) || portTxt.getText().equals(null)) IPError() ;
        Config.getConfig().setHost(ipaddr.getText());
        Config.getConfig().setPort(Integer.parseInt(portTxt.getText()));
    	Config cfg = Config.getConfig();
		if (client != null)
		{
			client.close();
			client = null;
		}
		//client = new Client("localhost",5555); in my computer :)
		 client = new Client(cfg.getHost(),cfg.getPort());
		 client.open();
		 if(client.isConnected())
		 {
			System.out.println("isConnected");
			((Node)event.getSource()).getScene().getWindow().hide();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/application/mainForm.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setResizable(false);
			stage.setTitle("Welcome To OBL Library");
			stage.setScene(new Scene(root));
			stage.show();
			
			
		/*	Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			Pane root = loader.load(getClass().getResource("/application/mainForm.fxml").openStream());
			primaryStage.setTitle("Welcome to OBL Library");
			Scene scene = new Scene(root);			
			
			primaryStage.setScene(scene);		
			primaryStage.show();*/
		}
		else
		{
			error.setVisible(true);
		}
    }
    
    /**
     * Error message 
     * IP is not connected 
     */
    
    public void IPError() 
    {
    	System.out.println("is not Connected !!!!");
    	error.setVisible(true);
    }
}
