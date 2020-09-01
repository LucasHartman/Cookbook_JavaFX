package closeWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;




public class MyControl {

	
	@FXML
	Button closeButton;
    
    
	
	@FXML
    private void handleButtonAction(ActionEvent event) {			// Button Action      
		
		
		// get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
		stage.close();
	    
		System.out.println("close window");
		
	}

}