package nqueen;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.collections.*; 
import javafx.geometry.Insets;

class DialogStage extends Stage{         //Dialog Message Window
      DialogStage(String message){
          Label lb = new Label();
          Button btn = new Button("Close");     
          lb.setText(message);
          lb.setTranslateX(100);
          lb.setTranslateY(50);
          btn.setTranslateX(120);
          btn.setTranslateY(100);
          Pane root= new Pane();
          root.getChildren().add(lb);
          root.getChildren().add(btn);
          btn.setOnAction(e->close());
          setTitle("Dialog Message");
          setScene(new Scene(root, 300, 200));
          show();
      }
}


public class NQueenGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();        
        //Insert code here
        
        Text text = new Text("Enter Board Size between 2 and 20");
        text.setFont( Font.font("Arial",FontWeight.BOLD,20));
        Button Playbtn = new Button("Play");
        Playbtn.setFont( Font.font("Arial",FontWeight.BOLD,20));
        Button SolveBtn = new Button("Solution");
        SolveBtn.setFont(Font.font("Arial",FontWeight.BOLD,20));
        
        TextField textField = new TextField();
        textField.setFont( Font.font("Arial",FontWeight.BOLD,20));

        SolveBtn.setOnAction(e->{
            if(textField.getText().equals("")){
                new DialogStage("Wrong Value entered for size");
                textField.setText("");
            }else{
                NQueen nq = new NQueen(Integer.parseInt(textField.getText()));
                DisplaySolution ds = new DisplaySolution(nq.getN(),nq.getBoard(),nq.getSolved());
            }
        });

        Playbtn.setOnAction(e->{
            if(textField.getText().equals("")){
                new DialogStage("Wrong Value entered for size");
                textField.setText("");
            }else{
                NQueen nq = new NQueen(Integer.parseInt(textField.getText()));  
                PlayBoard pb = new PlayBoard(nq.getN(),nq.getBoard(),nq.getSolved());
            }
        });

        root.add(text,0,0,2,1);
        root.add(Playbtn,0,2); //spanning
        root.add(SolveBtn,1,2);
        root.add(textField,0,1,2,1);

        primaryStage.setX(10);
        primaryStage.setY(10);
        primaryStage.setTitle("NQueen Problem Game");
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }
}

//javac --module-path C:\Users\david\OneDrive\Documents\CODE\JavaCode\javafx-sdk-11.0.2\lib --add-modules javafx.controls NQueenGame.java
//java  --module-path C:\Users\david\OneDrive\Documents\CODE\JavaCode\javafx-sdk-11.0.2\lib --add-modules javafx.controls NQueenGame     

