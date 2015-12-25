/* The MediaBar class handles setting up the time slider and
 * volume bar for the media player. An instance of the class
 * should be added to the bottom of a Player object.
 */
package components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;

public class MediaBar extends HBox {
	
	private Slider timeSlider = new Slider();
	private Slider volumeSlider = new Slider();
	private Button playButton = new Button("||");
	private Label volumeLabel = new Label("Volume: ");
	private MediaPlayer player;
	
	public MediaBar(MediaPlayer player) {
		this.player = player;
		
		// visual set up (alignment and bar padding)
		setAlignment(Pos.CENTER);
		setPadding(new Insets(PlayerConstants.TOP_BOT_OFFSET, PlayerConstants.LEFT_RIGHT_OFFSET,
							  PlayerConstants.TOP_BOT_OFFSET, PlayerConstants.LEFT_RIGHT_OFFSET));
		
		// adjust volume bar settings
		this.volumeSlider.setMinWidth(PlayerConstants.VOLUME_BAR_MIN_WIDTH);
		this.volumeSlider.setPrefWidth(PlayerConstants.VOLUME_BAR_MAX_WIDTH);
		this.volumeSlider.setValue(PlayerConstants.DEFAULT_VOLUME);
		
		// set time slider priority
		HBox.setHgrow(this.timeSlider, Priority.ALWAYS);
		
		// adjust play button settings
		this.playButton.setPrefWidth(PlayerConstants.PLAY_BUTTON_WIDTH);
		
		// add components
		getChildren().add(this.playButton);
		getChildren().add(this.timeSlider);
		getChildren().add(this.volumeLabel);
		getChildren().add(this.volumeSlider);	
	}
}
