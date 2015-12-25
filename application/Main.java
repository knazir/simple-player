/* A very simple Java media player with bare-minimum functionality.
 * Credits to Eduonix for their discussion on implementing a simple
 * media player in Java. This project will be created around that
 * implementation as a base.
 */

package application;

import java.io.File;
import java.net.MalformedURLException;

import components.Player;
import components.PlayerConstants;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {	

	private Player player;
	private FileChooser fileChooser;

	@Override
	public void start(final Stage primaryStage) {
		// set up menu
		final MenuBar menu = new MenuBar();
		Menu file = new Menu("File");
		MenuItem open = new MenuItem("Open");
		file.getItems().add(open);
		menu.getMenus().add(file);
		fileChooser = new FileChooser();

		// set "open" menu item handler
		open.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				player.getPlayer().pause();
				chooseFile(primaryStage, menu);
			}
		});
		
		// first-time player setup
		player = new Player(PlayerConstants.FILENAME);
		player.setTop(menu);
		Scene scene = new Scene(player, PlayerConstants.APPLICATION_WIDTH, PlayerConstants.APPLICATION_HEIGHT, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	/** Allows user to choose new file for player */
	private void chooseFile(final Stage primaryStage, final MenuBar menu) {
		File file = fileChooser.showOpenDialog(primaryStage);
		if (file != null) {
			try {
				player = new Player(file.toURI().toURL().toExternalForm());
				player.setTop(menu);
				Scene scene = new Scene(player, PlayerConstants.APPLICATION_WIDTH, PlayerConstants.APPLICATION_HEIGHT, Color.BLACK);
				primaryStage.setScene(scene);
			} catch (MalformedURLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
