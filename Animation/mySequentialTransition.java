package animation;
	

import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class mySequentialTransition extends Application {

    @Override
    public void start(Stage stage) {

        initUI(stage);
    }

    private void initUI(Stage stage) {

        var root = new Pane();

        
        
        // Shape: Rectangle
        var rect = new Rectangle(50, 50, 30, 30);
        rect.setArcHeight(10);
        rect.setArcWidth(10);
        rect.setFill(Color.CADETBLUE);

        
        
        // Anim 1: Rotation
        var rottr = new RotateTransition(Duration.millis(2000), rect);
        rottr.setByAngle(180);
        rottr.setCycleCount(2);
        rottr.setAutoReverse(true);

        // Anim 2: Scale
        var sctr = new ScaleTransition(Duration.millis(2000), rect);
        sctr.setByX(2);
        sctr.setByY(2);
        sctr.setCycleCount(2);
        sctr.setAutoReverse(true);
        
        // Anime 3: Color
        var fltr = new FillTransition(Duration.millis(2000), rect,
        Color.CADETBLUE, Color.STEELBLUE);
        fltr.setCycleCount(2);
        fltr.setAutoReverse(true);

        
        
        // add Shape to Panel
        root.getChildren().add(rect);
        
        
        
        //Sequential: Bind Anim1, Anime2, Anim3
        var str = new SequentialTransition();
        str.getChildren().addAll(rottr, sctr, fltr);

        str.play();

        
        
        // Stage
        var scene = new Scene(root, 300, 250);
        stage.setTitle("SequentialTransition");
        stage.setScene(scene);
        stage.show();
    }

    
    
    
    // EXECUTE
    public static void main(String[] args) {
        launch(args);
    }
}