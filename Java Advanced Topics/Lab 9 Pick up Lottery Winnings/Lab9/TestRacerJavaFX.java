import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;

class RacerJavaFX extends Thread
{
  private static boolean foundWinner=false;
  private HBox gp;
  RacerJavaFX(HBox gp){
     this.gp=gp;
  }
  @Override
  public void run() {
       //Insert codes here
       for(int j =1; j<20; j++) {
           try{
            thread.sleep((int)500*math.random());
           }catch(InterruptedException e){
                final int fj =j;
                Platform.runLater(new Runnable(){
                   public void CheckWinner(){
                       if(!foundWinner){
                           foundWinner = true;
                                  for(int j =1; j<20; j++) {
                                      gp.getChildren().get(i).setStyle("-fx-background-color: #ff0000");
                                  }
                       }
                       
                   }
                    @Override
                    public void run() {
                         gp.getChildren().add(new Button(" "+fj));
                        
                    }

                });
                if(j==20){CheckWinner();}
           }
       }
  }
} 

public class TestRacerJavaFX extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        VBox vbox = new VBox();
        HBox gb[] = new HBox[10];
        RacerJavaFX rc[] = new RacerJavaFX[10];
        //Insert codes here
        for(int i =0; i<10; i++) {
            gb[i] = new HBox();
            gb[i].getChildren().add(new Label(" "+ i));
            //thread the
            rc[i] = new RacerJavaFX(gb[i]);
            rc[i].setName(" " +i);
            rc[i].start();
            vbox.getChildren().add(gb[i]);
        }
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10));
        primaryStage.setTitle("Test Racer JavaFX");
        Scene scene = new Scene(vbox, 560, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
    
