package modifyFxml;

import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class MyControl {
	
	
	
	@FXML
	Circle circleVis;

    // Constructor
    public void setVis(Boolean x) {
    	circleVis.setVisible(x);  }
    
    // Method
    public Circle setVis() {
        return circleVis;	}


    
}


