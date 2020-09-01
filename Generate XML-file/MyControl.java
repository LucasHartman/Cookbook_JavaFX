package saveData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;




public class MyControl {

	// Input Variables
	String name = "Lucas";
	String last = "Hart";
	String nick = "lulu";
	String sal = "9001";
    
    
	
	@FXML
    private void handleButtonAction(ActionEvent event) {			// Button Action      
		
		//Method - Generate xml file
		WriteXMLFile.WriteXmlFile(name, last, nick, sal);				// Method: Create Xml 
	            
	}

}