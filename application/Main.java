/* A very simple Java media player with bare-minimum functionality.
 * Credits to Eduonix for their discussion on implementing a simple
 * media player in Java. This project will be created around that
 * implementation as a base.
 */

package application;
	
import components.Player;
import components.PlayerConstants;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {	
	
	@Override
	public void start(Stage primaryStage) {
		Player player = new Player(PlayerConstants.FILENAME);
		Scene scene = new Scene(player, PlayerConstants.APPLICATION_WIDTH, 
								PlayerConstants.APPLICATION_HEIGHT, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
