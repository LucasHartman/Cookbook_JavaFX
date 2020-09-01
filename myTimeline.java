package animation;
	

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class myTimeline extends Application {

	
    @Override
    public void start(Stage stage) {
   	

        // Rectangle
        var rect = new Circle(30);
        rect.setEffect(new Lighting());
        rect.setFill(Color.CADETBLUE);
        
        
        // METHOD: pon Motion
    	ponMotion( rect, 200, 200, 2000 );
        
    	
    	// Layout
        var root = new Pane();
        root.getChildren().addAll(rect);
        var scene = new Scene(root, 350, 250);
        stage.setTitle("Timeline");
        stage.setScene(scene);
        stage.show();
    }

    
    
    
    
    // METHOD: Pon Motion
    private void ponMotion( Circle Shape, int translateX, int translateY, int duration ) {

        // Timeline
        var tl = new Timeline();
        tl.setCycleCount(1);
        tl.setAutoReverse(true);

        // Translate
        var kv = new KeyValue(Shape.translateXProperty(), translateX);
        var kh = new KeyValue(Shape.translateYProperty(), translateY);
        
        // Duration
        var kf = new KeyFrame(Duration.millis(duration), kv, kh);
        tl.getKeyFrames().addAll(kf);
        tl.play();  

    }

    
    
    public static void main(String[] args) {
        launch(args);
    }
}
