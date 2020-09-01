package playAudio;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MyControl {
	
	
	//local
	//String path = "/home/lucas/eclipse-workspace/sandbox/src/playerAudio/open.wav";
	String path = "src/audio/introA.wav";

	Media media = new Media(new File(path).toURI().toString());
	
	// url
	//Media media = new Media("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3");

	
	// get MediaPlayer
	MediaPlayer mediaPlayer = new MediaPlayer(media);

	
	
	@FXML public void initialize() {
		
		System.out.println("initialize");
		
		// play media file
		mediaPlayer.play();
	}

}


