package onClickAction;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception { 		
    	
		System.out.println("java version: " 	+System.getProperty("java.version")); 
		System.out.println("javafx.version: "	+System.getProperty("javafx.version"));
		
		// Exception = sub class
        Parent root = FXMLLoader.load(getClass().getResource("DefineFXML.fxml"));		// Load fxml
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
