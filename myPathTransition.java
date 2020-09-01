package animation;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.PathTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

import javafx.util.Duration;

//Soucre: http://zetcode.com/gui/javafx/animation/

public class myPathTransition extends Application {

	
/*=====================================================
						Start 
=====================================================*/ 
    
	@Override
    public void start(Stage stage) {

        initUI(stage);
    }

	
	
    
/*=====================================================
				Scene Graph
=====================================================*/  	
	
	
    private void initUI(Stage stage) {					// Construct Method

        var root = new Pane();							// Layout

        
        
        var path = new Path();							// Create Path obj
        path.getElements().add(new MoveTo(20, 120));
        path.getElements().add(new CubicCurveTo(180, 60, 250, 340, 420, 240));

        
        
        var circle = new Circle(20, 120, 10);			// Create Shape obj
        circle.setFill(Color.CADETBLUE);				// Shape Color

        
        
        var ptr = new PathTransition();					// Create Path Transition obj
        ptr.setDuration(Duration.seconds(6));			// Time Duration
        ptr.setDelay(Duration.seconds(2));				// Time Delay
        ptr.setPath(path);								// input path obj
        ptr.setNode(circle);							// input shape obj
        ptr.setCycleCount(2);							// cycles
        ptr.setAutoReverse(true);						// add Reverse
        ptr.play();										// play anim

        
        root.getChildren().addAll(path, circle);		// add to layout

        
        
        var scene = new Scene(root, 450, 300);
        stage.setTitle("PathTransition");
        stage.setScene(scene);
        stage.show();
    }

    
    
/*=====================================================
					EXECUTE
=====================================================*/    
    
    public static void main(String[] args) {
        launch(args);
    }
}