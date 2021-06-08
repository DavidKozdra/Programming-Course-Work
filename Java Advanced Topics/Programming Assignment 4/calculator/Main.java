package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
        
    }


    public static void main(String[] args) {
        launch(args);
    }
}
