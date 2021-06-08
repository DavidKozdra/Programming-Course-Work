package lottery;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;

public class Lottery extends Application {
       
       @Override 
       public void start(Stage primaryStage) {
              /*
                 0,0    1,0    2,0    3,0    4,0     5,0
                 0,1    1,1    2,1    3,1    4,1     5,1
                 0,2    1,2    2,2    3,2    4,2     5,2
                 0,3    
              */
              GridPane pane = new GridPane();
              pane.setVgap(5);
              pane.setHgap(5);
              pane.setPadding(new Insets(25));
             
              //Insertcode here
              Label lblText[] = new Label[6];      
              FlashThread ft[] = new FlashThread();
              Button btn[] = new Button[6];
              //Button stbtn = new Button("Stop");
              TextArea txtarea = new TextArea();
              Font font = new Font.font("Arial",FontWeight.BOLD,18);
              txtarea.setFont(font);
              Button exitbtn = new Button("Exit");
              exitbtn.setFont(font);
              Button addbtn = new Button("Add");
              addbtn.setFont(font);
              Button clearbtn = new Button("Clear");
              clearbtn.setFont(font);
              
              for(int i =0; i<6; i++) {
                  lblText[i] = new Label("       " +i);
                  btn[i] = new Button("Stop");
                  
                  btn[i].setFont(font);
                  btn[i].setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
                  lblText[i].setFont(font);
                  pane.add(lblText[i],i,0);
                  pane.add(btn[i],i,1);

                  ft[i] = new FlashThread(lblText[i]);
                  ft[i].start();
                  final Button fbtn = btn[i];
                final FlashThread fft = ft[i];
                  btn[i].setOnAction(e ->eventHandler(fbtn,fft));
                  
              }

              exitbtn.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
              addbtn.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
              clearbtn.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
              pane.add(exitbtn,4,2,2,1);
              pane.add(addbtn,0,2,2,1);
              pane.add(clearbtn,2,2,2,1);
              pane.add(txtarea,0,3,6,1);
              
              exitbtn.setOnAction(e->System.exit(0));
              clearbtn.setOnAction(e->txtarea.setText(""));
              addbtn.setOnAction(e->{
                  String txtNum ="";
                  for (int i =0; i < 6; i++){

                      if(btn[i].getText().equals("Start")){
                          txtNum =txtNum+lblText[i].getText().trim();
                          btn[i].setText("Stop");
                          ft[i].resumeThread();

                      }
                  }
                  if(!txtNum.equals("")){
                      txtarea.appendText(txtNum+"\n");

                  }
              });


    
              Scene scene = new Scene(pane, 475, 325);
              primaryStage.setTitle("Lottery Winners"); 
              primaryStage.setScene(scene); 
              primaryStage.show(); 
              primaryStage.setOnCloseRequest(e -> System.exit(0));
       }

        public void eventHandler(Button btn, FlashThread ft){
                 //Insert codes here
                //btn and ft must be final
                 
                    System.out.println(btn.getText());
                    if(btn.getText().equals("Stop")){
                        btn.setText("Start");
                       try{
                        ft.pauseThread();
                    
                    }catch(InterruptedException err){

                 }
                    }else{

                        btn.setText("Stop");
                        ft.resumeThread();
                    }
                
        }

       public static void main(String[] args) {
              launch(args);
       }
             
}

//javac --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls Lottery.java
//java --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls Lottery.java