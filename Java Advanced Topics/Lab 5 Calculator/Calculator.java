//package calculator;
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


 public class Calculator extends Application {

        public double a=0.0; // number
        public int op=0; //operator 

        public void start(Stage primaryStage) {     
            //font        
            Font font = Font.font("Arial", FontWeight.BOLD,20);

            //title
            primaryStage.setTitle("Calculator");

            // layout definitions 
            BorderPane root = new BorderPane(); 
            Button btn[] = new Button[9]; //Button 1,2,3,....,9
            GridPane gridPane = new GridPane();
            TextField input = new TextField("");
            input.setFont(font);

            //remaining buttons
            Button button_plus = new Button("+"); 
            Button button_minus = new Button("-"); 
            Button button_times = new Button("*"); 
            Button button_div = new Button("/"); 
            Button button_clr = new Button("cl"); 
            Button button_eql = new Button("="); 
            Button button = new Button("0"); 

            //event handler for buttons
            EventHandler<ActionEvent> buttonHandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String text = input.getText(); //store value 

                //number click
                if(event.getSource() == button){
                    input.setText(text + "0");

                }
                else if (event.getSource() == btn[0]) {
                    input.setText(text + "1");

                }
                 else if (event.getSource() == btn[1]) {
                    input.setText(text + "2");

                }
                 else if (event.getSource() == btn[2]) {
                    input.setText(text + "3");

                }
                 else if (event.getSource() == btn[3]) {
                    input.setText(text + "4");

                }
                else if (event.getSource() == btn[4]) {
                    input.setText(text + "5");

                }
                else if (event.getSource() == btn[5]) {
                    input.setText(text + "6");

                }
                else if (event.getSource() == btn[6]) {
                    input.setText(text + "7");

                }
                else if (event.getSource() == btn[7]) {
                    input.setText(text + "8");

                }
                else if (event.getSource() == btn[8]) {
                    input.setText(text + "9");

                }
                //operator click
                else if (event.getSource() == button_plus) {
                    a = Double.parseDouble(text);
                    op = 1;
                    input.setText("");
                }
                else if (event.getSource() == button_minus) {
                    a = Double.parseDouble(text);
                    op = 2;
                    input.setText("");
                }
                else if (event.getSource() == button_times) {
                    a = Double.parseDouble(text);
                    op = 3;
                    input.setText("");
                }
                else if (event.getSource() == button_div) {
                    a = Double.parseDouble(text);
                    op = 4;
                    input.setText("");
                }
                //done
                else if (event.getSource() == button_eql) {
                    Double b = Double.parseDouble(text);
                    if(op == 1){
                        Double answer = a + b;
                        input.setText( String.valueOf(answer));
                        a = a+b;
                        op =0;
                        System.out.println(answer);
                    }
                    else if(op == 2){
                        Double answer = a - b;
                        input.setText( String.valueOf(answer));

                        op =0;
                    }
                    else if(op == 3){
                        Double answer = a * b;
                        input.setText( String.valueOf(answer));
                        op =0;

                    }
                      else if(op == 4){
                        Double answer = a / b;
                        input.setText( String.valueOf(answer));
                        op =0;

                    }


                }
                //clear
                 else if (event.getSource() == button_clr) {
                    input.setText("");
                    a =0;
                }
            }};

            // define each button in 1-9
            for(int i = 0; i < 9; i++) {
                btn[i] = new Button(""+(i+1));
                btn[i].setFont(Font.font("Arial", FontWeight.BOLD, 20));
                btn[i].setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
                gridPane.add(btn[i], i%3, (i/3));
                btn[i].setOnAction(buttonHandler);
            } 

            //layout code to remaining
            button_clr.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            button_clr.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            button_eql.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            button_eql.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            button.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            button.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            button_plus.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            button_plus.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            button_minus.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            button_minus.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            button_times.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            button_times.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
            button_div.setFont(Font.font("Arial", FontWeight.BOLD, 20));
            button_div.setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);

            for(int row = 0; row < 3 ; row ++){
                RowConstraints rc = new RowConstraints(); 
                rc.setFillHeight(true); 
                rc.setVgrow(Priority.ALWAYS);
                gridPane.getRowConstraints().add(rc);

            }

            
            for(int col = 0; col < 3 ; col ++){
                ColumnConstraints cc = new ColumnConstraints(); 
                cc.setFillWidth(true); 
                cc.setHgrow(Priority.ALWAYS);
                gridPane.getColumnConstraints().add(cc);

            }

            //add handler to remaing
            button_clr.setOnAction(buttonHandler);
            button_eql.setOnAction(buttonHandler);
            button_times.setOnAction(buttonHandler);
            button_minus.setOnAction(buttonHandler);
            button_plus.setOnAction(buttonHandler);
            button_div.setOnAction(buttonHandler);
            button.setOnAction(buttonHandler);

           // gridPane definitions for remaining buttons
           
            gridPane.add(button_clr, 0, 3); 
            gridPane.add(button_eql, 2, 3); 
            gridPane.add(button, 1, 3); 
            gridPane.add(button_plus, 3, 0); 
            gridPane.add(button_minus, 3, 1); 
            gridPane.add(button_times, 3, 2);
            gridPane.add(button_div, 3, 3); 

            HBox top = new HBox();
            top.getChildren().add(input);
            top.setMargin(input, new Insets(0, 0, 0, 0)); 
            root.setTop(top); 
            root.setCenter(gridPane); 
         
            //text set u
            Scene scene = new Scene(root,300,300);
            primaryStage.setScene(scene);
            primaryStage.show();

        }   
        public static void main(String[] args) { 
            
            launch(args); 

        }

 }
//javac --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls Calculator.java
//java --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls Calculator.java
