/* The Player class handles instantiating all classes that help
 * manage playing the media file. The class interacts with other
 * classes such as MediaBar to create the player's GUI.
 */
package components;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Player extends BorderPane {
	
	private Media media;		// handles the actual media file
	private MediaPlayer player;	// handles playing the media file
	private MediaView view;		// handles viewing the media components
	private Pane mediaPane;		// handles outputting the media view to the components screen
	private MediaBar mediaBar;
	
	public Player(String filename) {
		initializeComponents(filename);
		setupView();
		setupMediaBar();
		this.player.play();
	}

	/** Instantiates members */
	private void initializeComponents(String filename) {
		this.media = new Media(filename);
		this.player = new MediaPlayer(media);
		this.view = new MediaView(player);
		this.mediaPane = new Pane();
	}
	
	/** Sets up player view */
	private void setupView() {
		this.mediaPane.getChildren().add(view);
		setCenter(mediaPane);	// adds media pane to center of components
	}
	
	/** Initializes and sets up media bar */
	private void setupMediaBar() {
		this.mediaBar = new MediaBar(this.player);
		setBottom(this.mediaBar);
		setStyle(PlayerConstants.BAR_BG_COLOR);
	}	
}
