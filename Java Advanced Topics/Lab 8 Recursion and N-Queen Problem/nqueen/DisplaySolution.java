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
import javafx.geometry.*;

public class DisplaySolution extends Stage{
      Text txt;
      Button btn[][];
      GridPane gp;
      int board[][];
      int N;
      DisplaySolution(int N, int board[][], boolean solved){
          if (solved){
              gp = new GridPane();
              for(int row = 0; row < N; row++) {
                 RowConstraints rc = new RowConstraints();
                 rc.setFillHeight(true);
                 rc.setVgrow(Priority.ALWAYS);
                 gp.getRowConstraints().add(rc);
              }
              for(int col = 0; col < N; col++) {
                 ColumnConstraints cc = new ColumnConstraints();
                 cc.setFillWidth(true);
                 cc.setHgrow(Priority.ALWAYS);
                 gp.getColumnConstraints().add(cc);
              }
              //Insert code here
              btn = new Button[N][N];
              Image im = new Image("queen.jpg");
              for(int r = 0; r < N; r++){
                  for(int c = 0; c < N; c++){
                      btn[c][r] =new Button();
                      btn[c][r].setFont(Font.font("Arial",FontWeight.BOLD,20));
                      btn[c][r].setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
                      ImageView iv = new ImageView(im);
                      if(board[c][r] ==1){
                          btn[c][r].setGraphic(iv);
                          btn[c][r].setStyle("-fx-background-color:#ff0000");

                      }
                      gp.add(btn[c][r],c,r);
                  }
              }
              
              setX(450); 
              setY(10);  
              setTitle("Solution for "+N+" x "+N+" Queen Game");
              setScene(new Scene(gp, 800, 800));
              show();
          }
          else{
              //Insert code here
              new DialogStage("No solution !!!!!");
          }
      }

}
