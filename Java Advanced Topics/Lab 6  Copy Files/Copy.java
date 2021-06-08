package copy;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage; 
import javafx.scene.layout.*;       //Panel
import javafx.scene.shape.*;        //Shape
import javafx.scene.text.*;  //Text and Font
import javafx.scene.paint.Color;    //Color
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;           //Insets, Pos
import java.util.*;
import java.io.*;

class ErrorStage extends Stage{
    
    ErrorStage(String err_message){
        Label l = new Label(err_message);
        Button b = new Button("Ok");
        b.setOnAction(e -> close());
        GridPane root = new GridPane();
        root.add(l,0,0);
        root.add(b,0,1);
        Scene scene = new Scene(root,300,200);
        setTitle("Copy error");
        setScene(scene);
        show();
    }
}

class ResultStage extends Stage{
    
    ResultStage(String err_message){
        Label l = new Label(err_message);
        Button b = new Button("Ok");
        b.setOnAction(e -> close());
        GridPane root = new GridPane();
        root.add(l,0,0);
        root.add(b,0,1);
        Scene scene = new Scene(root,300,200);
        setTitle("Copy Message");
        setScene(scene);
        show();
    }
}

public class Copy extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        Label lb1 = new Label("Source File");
        Label lb2 = new Label("Copy File");
        TextField tf1 = new TextField();
        TextField tf2 = new TextField();
        Button btn = new Button("Copy");
        btn.setOnAction(e -> {
        if(tf1.getText() == tf2.getText()){
            new ErrorStage("That is the same file ??");
        }
        File sourceFile = new File(tf1.getText());
       if (!sourceFile.exists()){
          new ErrorStage("Source file" + tf1.getText() + "does not exist");

       }
       File targetFile = new File(tf2.getText());
       if (!targetFile.exists()){
          new ErrorStage("Target file "+ tf2.getText() + "does not exist");

       }
       try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(tf1.getText()));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(tf2.getText()));)
       {
           int r, numberOfBytesCopied = 0;
           while((r=input.read()) != -1){
              output.write((byte) r);
              numberOfBytesCopied++;
           }
           new ResultStage(numberOfBytesCopied + " bytes copied");
       }
       catch (IOException err){
          new ErrorStage(err.getMessage());
       }

        });
        root.add(lb1,0,0);
        root.add(lb2,0,1);
        root.add(tf1,1,0);
        root.add(tf2,1,1);
        root.add(btn,1,2);

        //root.setStyle("-fx-background-color: lightblue");
        Scene scene = new Scene(root,300,200); 
        primaryStage.setTitle("Copy File");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

//javac --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls copy\Copy.java
//java --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls copy\Copy.java
