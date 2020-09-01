package modifyFxml;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;



public class MyMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception { 		
    	
		System.out.println("java version: " 	+System.getProperty("java.version")); 
		System.out.println("javafx.version: "	+System.getProperty("javafx.version"));
		
		
		
		// import fxml
		FXMLLoader loader = new FXMLLoader();
	    loader.setLocation(MyMain.class.getResource("MyLayout.fxml"));
	    Parent root = loader.load();
	    
	    
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
        
        // import controller
		  MyControl controller = loader.getController(); // Controller Method: set Circle Visible
		  controller.setVis(false);//  Visible or onVisible


		  
		  
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}