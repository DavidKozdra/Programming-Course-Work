package calculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root = loader.load();
            Controller myControl = loader.getController();

        primaryStage.setTitle("CalcNet");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();


        primaryStage.setOnCloseRequest(
                e -> {
                    Socket client = myControl.getSocket();
                    PrintWriter outgoing = myControl.getOutgoing();
                    outgoing.println("connection end gui exit");
                    outgoing.close();
                    try {
                        client.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }

        );
    }


    public static void main(String[] args) {
        launch(args);
    }
}
