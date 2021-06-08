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



public class PlayBoard extends Stage{
      Button btn[][];
      GridPane gp;
      int board[][];
      int N;
      PlayBoard(int N, int board[][], boolean solved){
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
              for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    board[c][r] =0;
                    btn[c][r] =new Button(""+0);
                    btn[c][r].setFont(Font.font("Arial",FontWeight.BOLD,20));
                    btn[c][r].setMaxSize(Double.MAX_VALUE,Double.MAX_VALUE);
                    final int fc = c;
                    final int fr = r;
                    btn[fc][fr].setOnAction(e->{
                        if(board[fc][fr] == 0){
                            if(isSafe(board,fc,fr,N)){
                                board[fc][fr] = 1;
                                btn[fc][fr].setText("" + board[fc][fr]);
                                btn[fc][fr].setStyle("-fx-background-color:#00ff00");        
                            }else{
                                board[fc][fr] = 0;
                            }
                        }else{
                            btn[fc][fr].setStyle(null); 
                            board[fc][fr] = 0; 
                            btn[fc][fr].setText("" + board[fc][fr]);

                        }
                    });
                    gp.add(btn[c][r],c,r);
                  }
              }
              setX(450);
              setY(10);
              setTitle("Play "+N+" x "+N+" Queen Game");
              setScene(new Scene(gp, 800, 800));
              show();
          }
          else{
              //Insert code here
              new DialogStage("No solution");
          }
      }
      
            
      boolean isSafe(int board[][],int col,int row,int N) {  // i is col and j is row
        for (int i=0;i<N;i++)
        {
           for (int j=0;j<N;j++)
           {
              if (board[i][j]==1)
              {
                 if (i==col) return false;
                 if (j==row) return false;
                 if (Math.abs(i-col)==Math.abs(j-row)) return false;
              } 
           }
        }
        return true;
      }

}
