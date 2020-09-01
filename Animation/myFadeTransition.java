package animation;
	
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

// Soucre: http://zetcode.com/gui/javafx/animation/

public class myFadeTransition extends Application {		// Onmouse Click - Fade out Effect

	
/*=====================================================
					Variables
=====================================================*/
	
    private FadeTransition ft;							// visiblity
    private Rectangle rect;								// empty Shape

    
/*=====================================================
					Start

- This example uses FadeTransition to create a fade
  out effect on a rectangle. The animation is started
  after a mouse click inside the area of the rectangle. 
=====================================================*/  
   
    @Override
    public void start(Stage stage) {

        initUI(stage);									// run Method
    }

    
/*=====================================================
				Scene Graph
				
- Setup Rectangle
- Mouse Click
- FadeTrasition
- Stage
=====================================================*/    
    
    private void initUI(Stage stage) {					// Construct Method

        var root = new Group();							// Layout

        rect = new Rectangle(20, 20, 150, 150);			// Shape = Rectangle
        rect.setOnMouseClicked(new RectClickHandler());	// Shape On Mouse Click + input

        ft = new FadeTransition(Duration.millis(5000), rect); // mouse clicked handler is set to the rectangle. 
        ft.setFromValue(1.0);							// Its first parameter is the duration of the transition.
        ft.setToValue(0.0);								// Fade end   value

        root.getChildren().add(rect);					// Shape => Layout

        
        
        
        var scene = new Scene(root, 300, 250);			// Scene

        stage.setTitle("Fading transition");
        stage.setScene(scene);
        stage.show();
    }

    
    
/*=====================================================
	 			Class Animation
	 			
- handle user mouse click
- end handle when opacity = 0
- Animation Status
=====================================================*/    
    
    private class RectClickHandler implements EventHandler<MouseEvent> { // Class MouseEvent

        @Override
        public void handle(MouseEvent event) {			// User Mouse Event

            doHandle();									// Run Method
            											// Event stops when: return 0
            											// After the rectangle fades out, 
            											// we dismiss the mouse click.
        }

        
        
        
        private void doHandle() {						// Constrcut Method

            double opa = rect.getOpacity();				// The current opacity value is determined 
            											// with the getOpacity() method.

            if ((int) opa == 0) {						// if var = 0...
                return;									// return 0
            }
            
            

            Animation.Status as = ft.getStatus();		// getStatus() method determines 
            											// the transition's status

            if (as == Animation.Status.RUNNING) {		
                return;
            }

            if (as == Animation.Status.STOPPED) {		// start the transition with the play() method
                ft.play();
            }
        }
    }
    
    
/*=====================================================
					EXECUTE
=====================================================*/    

    public static void main(String[] args) {
        Application.launch(args);
    }
}
