package onClickAction;

//import java.net.URL;
//import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


/* ========================================================================
 * The controller class allows for Java code to be executed in response 
 * to user actions on the UI elements 
 * defined in the FXML file
 ========================================================================*/


public class DefineControl {
    
	
	
    @FXML
    private Label label;
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {			// Button has onAction="#handleButtonAction", 
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    
    
    /*
    public void initialize(URL url, ResourceBundle resources) {
        // Initialization code CAN go here. 
        // The parameters url and resources can be omitted if they are not needed
    }    
    */
   
    
}