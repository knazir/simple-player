/* The MediaBar class handles setting up the time slider and
 * volume bar for the media myPlayer. An instance of the class
 * should be added to the bottom of a Player object.
 */
package components;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class MediaBar extends HBox {

	private Slider timeSlider = new Slider();
	private Slider volumeSlider = new Slider();
	private Button playButton = new Button("||");
	private Label volumeLabel = new Label("Volume: ");
	private MediaPlayer myPlayer;

	public MediaBar(MediaPlayer player) {
		this.myPlayer = player;
		setupVisuals();
		setupVolumeSlider();
		setupTimeSlider();
		setupPlayButton();
		addComponents();
		
		playButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				Status status = myPlayer.getStatus();
				
				if (status == status.PLAYING) {
					if (myPlayer.getCurrentTime().greaterThanOrEqualTo(myPlayer.getTotalDuration())) {
						myPlayer.seek(myPlayer.getStartTime());
						myPlayer.play();
					} else {
						myPlayer.pause();
						playButton.setText("►");
					}
				} else if (status == status.PAUSED || status == status.HALTED || status == status.STOPPED) {
					myPlayer.play();
					playButton.setText("||");
				}
			}
		});
		
		myPlayer.currentTimeProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable obsv) {
				updateTime();
			}
		});
	}
	
	protected void updateTime() {
		Platform.runLater(new Runnable() {
			public void run() {
				double currentTime = myPlayer.getCurrentTime().toMillis() / myPlayer.getTotalDuration().toMillis() * 100;
				System.out.println("Current time: " + currentTime);
				timeSlider.setValue(currentTime);
			}
		});
	}

	/** Sets up media bar visuals (alignment and bar padding */
	private void setupVisuals() {
		setAlignment(Pos.CENTER);
		setPadding(new Insets(PlayerConstants.TOP_BOT_OFFSET, PlayerConstants.LEFT_RIGHT_OFFSET,
				PlayerConstants.TOP_BOT_OFFSET, PlayerConstants.LEFT_RIGHT_OFFSET));
	}

	/** Sets up volume slider settings */
	private void setupVolumeSlider() {
		this.volumeSlider.setMinWidth(PlayerConstants.VOLUME_BAR_MIN_WIDTH);
		this.volumeSlider.setPrefWidth(PlayerConstants.VOLUME_BAR_MAX_WIDTH);
		this.volumeSlider.setValue(PlayerConstants.DEFAULT_VOLUME);
	}

	/** Sets up time slider */
	private void setupTimeSlider() {
		HBox.setHgrow(this.timeSlider, Priority.ALWAYS);	// sets priority to time slider
	}

	/** Sets up play button */
	private void setupPlayButton() {
		this.playButton.setPrefWidth(PlayerConstants.PLAY_BUTTON_WIDTH);
	}

	/** Adds member components to the media bar */
	private void addComponents() {
		getChildren().add(this.playButton);
		getChildren().add(this.timeSlider);
		getChildren().add(this.volumeLabel);
		getChildren().add(this.volumeSlider);	
	}

}
