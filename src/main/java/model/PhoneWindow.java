package model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class PhoneWindow {

    // doesn't need to be called "start" any more...    
    public void start(Phone phone) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("view/PhoneWindowView.fxml"));
    	StackPane root = new StackPane();
    	Scene scene =  new Scene(root, 200 ,200);
        //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        
         
        Stage secondStage = new Stage();
        secondStage.setTitle("New Stage");
        secondStage.setScene(scene);
         
        secondStage.show();

    }
}   