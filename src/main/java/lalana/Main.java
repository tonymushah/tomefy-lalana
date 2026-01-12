package lalana;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {
		Pane root = new VBox();

		Scene scene = new Scene(new ScrollPane(root), 500, 500, Color.rgb(100, 200, 0, 1.0));

		Button button = new Button("Button");
		root.getChildren().add(button);
		button.setOnMouseClicked((b) -> {
			System.out.println("Button");
		});

		Text text = new Text(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		text.setWrappingWidth(200);
		root.getChildren().add(new TextFlow(text));

		arg0.setScene(scene);
		arg0.setTitle("lalana");
		root.autosize();
		arg0.show();

	}
}