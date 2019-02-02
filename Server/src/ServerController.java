import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ServerController extends Application{


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		           BorderPane root =
				  (BorderPane)FXMLLoader.load(EchoServer.class.getClassLoader().getResource(
				  "serverFxml.fxml")); Scene scene = new Scene(root); primaryStage.setScene(scene);
				  primaryStage.setTitle("IP Connected"); primaryStage.show();
		
	}

}
