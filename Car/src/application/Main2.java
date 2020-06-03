package application;

import javafx.application.Application;



import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

 
public class Main2 extends Application {
	
	
	public static final String MainStyle="style";
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
			Scene scene = new Scene(root,  688, 526);
			scene.getStylesheets().add(MainStyle);

			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
