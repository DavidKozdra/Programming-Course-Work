import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage; 
import javafx.scene.layout.*;       //Panel
import javafx.scene.shape.*;        //Shape
import javafx.scene.text.*;  //Text and Font
import javafx.scene.paint.Color;    //Color
import javafx.geometry.*;           //Insets, Pos
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert.AlertType; 
import javafx.stage.Modality;


 public class labBars extends Application {

     public static int out;
        public void start(Stage primaryStage) { 
            FlowPane  root = new FlowPane (); 
            ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
            for (int i = 0; i <21; i++){
                Rectangle r = new Rectangle();
                r.setWidth(50);
                r.setHeight(70);
                rects.add(r);
            }
            Button button1 = new Button("1");
            Button button2= new Button("2");
            Button button3 = new Button("3");
            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                       
                    if(event.getSource() == button1){
                        out ++;
                        root.getChildren().remove( rects.get(out));
                        System.out.println("Clicked");
                        if(rects.size() == 0){
                            final Stage dialog = new Stage();
                            dialog.initModality(Modality.APPLICATION_MODAL);
                            //dialog.initOwner(primaryStage);
                            VBox dialogVbox = new VBox(20);
                            dialogVbox.getChildren().add(new Text("Thank you for playing good bye"));
                            Scene dialogScene = new Scene(dialogVbox, 300, 200);
                            dialog.setScene(dialogScene);
                            dialog.show();
                            
                            //primaryStage.close();
                        }  

                    }else if(event.getSource() == button2 && 21 -out >= 2 ){
                        System.out.println("Clicked");
                         out+=1;
                        root.getChildren().remove(rects.get(out));
                        out+=1;
                        root.getChildren().remove( rects.get(out));
                      

                    }else if(event.getSource() == button3 && 21 -out >= 3){
                        System.out.println("Clicked");
                         out +=1;
                        root.getChildren().remove( rects.get(out));
                       out +=1;
                         root.getChildren().remove( rects.get(out));
                        out +=1;
                         root.getChildren().remove( rects.get(out));

                    }
                }
            };
            for(Rectangle rect : rects){

                root.getChildren().add(rect);
            }
            button1.setOnAction(buttonHandler);
            button2.setOnAction(buttonHandler);
            button3.setOnAction(buttonHandler);
            root.getChildren().addAll(button1,button2,button3);
            Scene scene = new Scene(root,400,350);
            primaryStage.setScene(scene);
            primaryStage.show();            
        }   

        public static void main(String[] args) { 
                launch(args);   

        }
 }
//javac --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls labBars.java
//java --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls MidTermClock.java
