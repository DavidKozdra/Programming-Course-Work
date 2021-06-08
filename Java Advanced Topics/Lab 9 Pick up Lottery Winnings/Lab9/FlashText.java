import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.util.Random;

//synchronized in Java

public class FlashText extends Application {
                    
       @Override 
       public void start(Stage primaryStage) {
              Font font = Font.font("Arial", FontWeight.BOLD,18);
              Button stbtn = new Button("Stop");
              Label lblText = new Label("");
              FlashThread ft = new FlashThread(lblText);
              GridPane pane = new GridPane();
              Button extbtn = new Button("Exit");
              lblText.setFont(font);
              stbtn.setFont(font);
              extbtn.setFont(font);
              pane.add(lblText,0,0);
              pane.add(stbtn,0,1);
              pane.add(extbtn,1,1);
              //exit button for closing the window.
              extbtn.setOnAction(e->{System.exit(0);});
              //start thread (ft)
              ft.start();
              //event handler for stbtn
              stbtn.setOnAction(e->{
                 //Insert codes here
                 try{
                    System.out.println(stbtn.getText());
                    if(stbtn.getText().equals("Stop")){
                        stbtn.setText("Start");
                        ft.pauseThread();
                    }else{

                        stbtn.setText("Stop");
                        ft.resumeThread();
                    }
                 }catch(InterruptedException err){


                 }
              }
              );
              Scene scene = new Scene(pane, 200, 100);
              primaryStage.setTitle("Flash Text"); 
              primaryStage.setScene(scene); 
              primaryStage.show(); 
       }
       public static void main(String[] args) {
              launch(args);
       }
}