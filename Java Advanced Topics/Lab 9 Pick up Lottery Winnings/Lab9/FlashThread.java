import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.text.*;
import java.util.Random;

//synchronized in Java

public class FlashThread extends Thread {
      Label lblText;
      private Object MONITOR = new Object();
      private boolean pauseThreadFlag = false;
      
      FlashThread(Label lblText){
         this.lblText=lblText;
      }
      
      @Override
      public void run() {
             while (true) {
                  Random rand = new Random();
                  String text;
                  text=""+rand.nextInt(10);
                  Platform.runLater(new Runnable() {
                      @Override
                      public void run() {
                          lblText.setText(text);
                      }
                  });
                  try{    
                     sleep(100);
                     checkForPaused();
                  }
                  catch(InterruptedException e){
                  }
             }
      } 
      
      private void checkForPaused() {
        synchronized (MONITOR) {
            while (pauseThreadFlag) { 
                try {
                    MONITOR.wait();
                } 
                catch (InterruptedException e) {}
            }
        }
      }
      public void pauseThread() throws InterruptedException {
        pauseThreadFlag = true;
      }
      public void resumeThread() {
        synchronized(MONITOR) {
            pauseThreadFlag = false;
            MONITOR.notify();
        }
      }    
}
