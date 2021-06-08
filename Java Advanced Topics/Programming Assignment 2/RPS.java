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
import java.lang.Math; 

class Player{
    private int Wins=0,Losses=0;

    public int getWins(){

        return Wins;
    }
    public int getLosses(){

        return Losses;
    }

    public void Win(){

        Wins ++;
    }

    public void Lose(){

        Losses ++;
    }

    public void reset(){
        Wins = 0;
        Losses = 0;

    }
}

class Game{
    public Player p;
    public int complayed;
    Game(){

        p = new Player();

    }

    public int com(){
        int rand = (int)(Math.random() * 3) + 1;
        return rand;
    }

    public String getName(int played){
        if(played ==1){

            return "Rock";
        }
        if(played ==2){

            return "Paper";
        }
        if(played ==3){

            return "Scissors";
        }
        return "";
    }

    public int Is_Win(int player){ //who won
        /*
        1. rock
        2. paper
        3. scisors

        0 win 1 lose 2 tie
        */
        complayed = com();
        if(player == complayed){
            return 2;
        }else if(player == 1 && complayed == 3){
            return 0;
        }
        else if(player == 3 && complayed == 1){
            return 1;
        }
        else if(player == 1 && complayed ==2){
            return 1;
        }
        else if(player == 2 && complayed ==1){
            return 0;
        }
        else if(player == 2 && complayed == 3){
            return 1;
        }
        else if(player == 3 && complayed == 2){
            return 0;
        }
        return 1;
    }
}

public class RPS extends Application {

        public void start(Stage primaryStage) {            
            //text set u
            GridPane root = new GridPane();
            Scene scene = new Scene(root,300,300);
            Game game = new Game();
            Text winText = new Text("0");
            //winText.setColor("Green");
            Text loseText = new Text("0");
            Text resultText = new Text("");
            root.add(winText,0,2);
            root.add(loseText,1,2);
            Text playerText = new Text("Player");
            Text comText = new Text("Computer");
            root.add(playerText,0,1);
            root.add(comText,1,1);
            root.add(resultText,2,1);

            Button Reset = new Button("Reset");
            Reset.setOnAction(e -> { 
                game.p.reset();
                winText.setText(String.valueOf(game.p.getWins()));
                loseText.setText(String.valueOf(game.p.getLosses()));
                playerText.setText("Player");
                comText.setText("Computer");
            });
            
            Button exitBtn = new Button("Exit");
            exitBtn.setOnAction(e -> System.exit(0));

            root.add(exitBtn,0,3);
            root.add(Reset,1,3);

            Button Rock = new Button("Rock");
            Rock.setOnAction(e -> { 
                int result =game.Is_Win(1);
                if(result == 0){
                    game.p.Win();
                    resultText.setText("You Win");
                }else if(result ==1){
                    resultText.setText("You Lose");
                    game.p.Lose();
                }
                else{
                    resultText.setText("Tie");
                }
                playerText.setText("Rock");
                comText.setText(game.getName(game.complayed)); // com choice
                winText.setText(String.valueOf(game.p.getWins()));
                loseText.setText(String.valueOf(game.p.getLosses()));
            });

            Button Paper = new Button("Paper");
            Paper.setOnAction(e -> { 
                 int result =game.Is_Win(2);
                if(result == 0){
                    game.p.Win();
                    resultText.setText("You Win");
                }else if(result ==1){
                    resultText.setText("You Lose");
                    game.p.Lose();
                }
                else{
                    resultText.setText("Tie");
                }
                playerText.setText("Paper");
                comText.setText(game.getName(game.complayed)); // com choice
                winText.setText(String.valueOf(game.p.getWins()));
                loseText.setText(String.valueOf(game.p.getLosses()));
            });

            Button Scissors = new Button("Scissors");
            Scissors.setOnAction(e -> { 
                 int result =game.Is_Win(3);
                if(result == 0){
                    game.p.Win();
                    resultText.setText("You Win");
                }else if(result == 1){
                    resultText.setText("You Lose");
                    game.p.Lose();
                }
                else{
                    resultText.setText("Tie");
                }
                playerText.setText("Scissors");
                comText.setText(game.getName(game.complayed)); // com choice
                winText.setText(String.valueOf(game.p.getWins()));
                loseText.setText(String.valueOf(game.p.getLosses()));
            });

            root.add(Rock,0,0);
            root.add(Paper,1,0);
            root.add(Scissors,2,0);

            primaryStage.setTitle("Rock Paper Scissors");
            primaryStage.setScene(scene);
            primaryStage.show();

        }   
        public static void main(String[] args) { 
            
            launch(args); 

        }

 }
//javac --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls RPS.java
//java --module-path javafx-sdk-11.0.2\lib --add-modules javafx.controls RPS
