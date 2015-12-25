/* Non-instantiable class to keep track of all relevant constants
 * for the application and individual GUI components.
 */

package components;

public class PlayerConstants {
	
	private PlayerConstants() {
		// can't instantiate
	}
	
	public static final String FILENAME = 
			"file:/Users/Kashif/Desktop/lecture-videos/bitwise-operators.mp4";

	// Application Size Constants
	public static final int MEDIA_BAR_BUFFER = 35;
	public static final int APPLICATION_WIDTH = 640;
	public static final int APPLICATION_HEIGHT = 480 + MEDIA_BAR_BUFFER;
	
	// Media Bar Constants
	public static final String BAR_BG_COLOR = "-fx-background-color: #bfc2c7";
	public static final int TOP_BOT_OFFSET = 5;
	public static final int LEFT_RIGHT_OFFSET = 10;
	public static final int DEFAULT_VOLUME = 100;
	public static final int VOLUME_BAR_MAX_WIDTH = 70;
	public static final int VOLUME_BAR_MIN_WIDTH = 30;
	public static final int PLAY_BUTTON_WIDTH = 30;
}
