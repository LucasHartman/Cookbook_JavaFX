package modifyData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;




public class MyControl {

    
	
	@FXML
    private void handleButtonAction(ActionEvent event) {			// Button Action      
		
		ModifyXMLFile.modifyXmlfile("9000");
		
	            
	}

}