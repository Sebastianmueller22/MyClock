import java.time.LocalDate;
import java.time.LocalTime;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClockMain extends Application {

	TextField theText;

	public static void main(String[] args) {
		launch(args);
	}

	
	/**
	 * sets up a TextField with the current time passed in as a String
	 */
	public void createTime() {
		theText = new TextField();
		theText.setText(LocalTime.now().toString());
		GridPane.setConstraints(theText, 12, 5);
	}

	/**
	 * responsible for setting the window up and initializing the AnimationTimer
	 */
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane root = new GridPane();
		root.setPadding(new Insets(10, 10, 10, 10));
		root.setVgap(8);
		root.setHgap(10);

		createTime();

		primaryStage.setTitle("Clock 1.0");
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

		root.getChildren().add(theText);

		AnimationTimer timer = new AnimationTimer() {
			private long lastUpdate = 0;

			@Override
			public void handle(long now) {
				if (now - lastUpdate >= 39_000_000) {
					update();
					lastUpdate = now;
				}
			}
		};
		timer.start();
	}

	/**
	 * responsible for animation
	 */
	public void update() {
	theText.setText(LocalTime.now().toString());
	}
	
}
