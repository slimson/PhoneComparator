package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import model.AppInfo;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class MainWindow extends Application {
	@Override
	public void start(Stage primaryStage) throws IOException {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("view/MainwindowView.fxml"));
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle(AppInfo.APP_NAME);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
