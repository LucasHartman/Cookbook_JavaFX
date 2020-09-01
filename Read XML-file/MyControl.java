package readData;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;




public class MyControl {

    
	
	@FXML
    private void handleButtonAction(ActionEvent event) {			// Button Action      
		
		//Method - read xml file
		String[] list = ReadXMLFile.readXmlFile();									// Method: Create Xml 
		
		//Print - Method content
		System.out.println("Staff id : " 	+ list[0]);
		System.out.println("First Name : " 	+ list[1]);
		System.out.println("Last Name : " 	+ list[2]);
		System.out.println("Nick Name : " 	+ list[3]);
		System.out.println("Salary : " 		+ list[4]);
		
	            
	}

}