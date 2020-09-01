package animation;
	

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

//Soucre: http://zetcode.com/gui/javafx/animation/

public class myAnimationTimer extends Application {		// fade out effect 

	
	
/*=====================================================
 					Variables
=====================================================*/
	
    private double opacity = 1;							// visiblity
    private Label lbl;									// empty text object
    
/*=====================================================
						Start
=====================================================*/
    
    @Override
    public void start(Stage stage) {

        initUI(stage);									// run Method
    }


    
/*=====================================================
				Scene Graph
=====================================================*/    
    
    private void initUI(Stage stage) {					// Construct Method

        var root = new StackPane();						// Layout

        lbl = new Label("JavaFX");						// lbl = text
        lbl.setFont(Font.font(48));
        root.getChildren().add(lbl);					// text => layout

        AnimationTimer timer = new MyTimer();			// IOBJ, from the class constructed below (MyTime)
        timer.start();									// Start Animation
        												// NOTE: AnimationTimer allows to create a timer that is called in each frame while it is active. 
     
        
        
        
        
        var scene = new Scene(root, 300, 250);			// scene setup

        stage.setTitle("AnimationTimer");
        stage.setScene(scene);
        stage.show();
    }

    
/*=====================================================
					 Class Animation
=====================================================*/    
    
    private class MyTimer extends AnimationTimer {		// Class AnimationTimer

        @Override										// add extra cod to an abstract class
        public void handle(long now) {					// hande method (called for each frame)

            doHandle();									// Run Method
        }

        
        
        
        private void doHandle() {						// Constrcut Method

            opacity -= 0.01;							// Subtract per frame
            lbl.opacityProperty().set(opacity);			// opacity effect

            if (opacity <= 0) {							// if 0...

                stop();									// Stop Animtion
                System.out.println("Animation stopped");// Console Message
            }
        }
    }

    
/*=====================================================
					EXECUTE
=====================================================*/  
    
    public static void main(String[] args) {
        launch(args);
    }
}