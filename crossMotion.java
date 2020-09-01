package animation;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class crossMotion extends Application {
	
	int currentX = 1;
	int currentY = 1;
	
	int newX = 11;
	int newY = 11;
	
	
	
	

    private Button move;																	// Action button
    private Pane unitPane, root;
    private GridPane gridPane;

    @Override
    public void start(Stage primaryStage) throws Exception{									// Start Script

    	
//===================================================================================================================================   	
//															Layout 
//===================================================================================================================================   	
    	
    	// Set Layout
        gridPane = new GridPane();															// Grid Setting
        gridPane.setVgap(5);																// Vertical Size
        gridPane.setHgap(5);																// Horizantal Size

        // Set Object
        unitPane = new Unit(new Text("101"), new Rectangle(50, 50)).getStackPane();			// Use; Unit METHOD
        gridPane.add(unitPane, 0, 0);														// add METHOD to Gridpane/Location

        // Set Button
        move = new Button("Move");															// Create Button
        move.setOnAction(e->animate());														// input Aciton
        root = new BorderPane(gridPane, null, null, move, null);							// add to layout:  button and grid pane

        // Set Scene
        Scene scene = new Scene(root, 300, 275);											// Scene Setup
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
//===================================================================================================================================   	
//															Animation 
//===================================================================================================================================   	
    
    
   
    private void animate() {																// ANIMAITON SETUP

        //remove unit, make it invisible, and add it to desired location
        gridPane.getChildren().remove(unitPane);											// remove: my motion object
        unitPane.setVisible(false);															// make invisible
        gridPane.add(unitPane, 20, 20);														// add NEW location
        root.layout(); 																		// apply top down layout pass
        //get x y of new location
        double x = unitPane.getLayoutX(); double y = unitPane.getLayoutY(); 				// measure new location

        //return to original location
        gridPane.getChildren().remove(unitPane);											// remove: my motion object
        gridPane.add(unitPane, 0, 0);														// add NEW location
        unitPane.setVisible(true);															// make Visible

        //apply translation to x,y of new location
        TranslateTransition translateTransition = new TranslateTransition();				// Creaete Translater
        translateTransition.setDuration(Duration.seconds(3));								// Duration
        translateTransition.setToX(x);														// set NEW location x
        translateTransition.setToY(y);														// set NEW location y
        translateTransition.setNode(unitPane);												// get my Motoin Object
        translateTransition.play();															// play
        
        //when translation is finished remove from original location
        //add to desired location and set translation to 0
        
        translateTransition.setOnFinished(e->{
            gridPane.getChildren().remove(unitPane);
            unitPane.setTranslateX(0);unitPane.setTranslateY(0);
            gridPane.add(unitPane, 20, 20);
        });
    }
    
    


//===================================================================================================================================   	
//  															Object 
//===================================================================================================================================   


  class Unit {

      private Text text;
      private Rectangle rectangle;
      private StackPane stackPane;

      Unit(Text text, Rectangle rectangle) {
          this.text = text;
          this.rectangle = rectangle;
          text.setFill(Color.RED);
          stackPane = new StackPane(rectangle, text);
      }

      public Text getText() {
          return text;
      }

      public void setText(Text text) {
          this.text = text;
      }

      public Rectangle getRectangle() {
          return rectangle;
      }

      public void setRectangle(Rectangle rectangle) {
          this.rectangle = rectangle;
      }

      public StackPane getStackPane() {
          return stackPane;
      }

      public void setStackPane(StackPane stackPane) {
          this.stackPane = stackPane;
      }
  }  
    
    

  
  
  
//===================================================================================================================================   	
//															LAUNCH 
//===================================================================================================================================   

    

    public static void main(String[] args) {
        launch(args);

    }
}



// 1. Object + Current Location
// 2. Transition(Object, Current Location, New Location
		// 3. hide
		// 4. move to new location
		// 5 unhide




