package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Controller {
    @FXML
    Button conBtn;
    @FXML
    TextArea txtArea;
    @FXML
    TextField textField;
    @FXML
    Label userLb;

    private String userName;
    private String serverHost;
    private int serverPort;
    private Scanner userInputScanner;  //input stream
    private String text;               //message
    private ServerThread serverThread=null;
    private Socket socket=null;

    public void handler(ActionEvent e) {
          Button btn = (Button)e.getSource();
          btn.setDefaultButton(true);
          if(btn.getText().equals("Connect!")){
              serverHost="127.0.0.1";
              serverPort=4444;
              userName=textField.getText();
              //start connection
              startClient();
          } else if(btn.getText().equals("Send")) {
              serverThread.addNextMessage(textField.getText());
              if(textField.getText().equals("exit")) {
                  try{socket.close();}
                  catch(IOException e1) {e1.printStackTrace();}
              }
          }
    }
    private void startClient(){
        try{
            socket = new Socket(serverHost, serverPort);
            Thread.sleep(1000); // waiting for network communicating.
            //Create ServerThread
            serverThread = new ServerThread(socket, userName, txtArea);
            serverThread.start();
            //Make the first message
            text=userName+" enters the Chat!!";
            //Send the message to server, the message must synchronized
            serverThread.addNextMessage(text);
            conBtn.setText("Send");
            userLb.setText("Send a Message:");
            textField.setText("");
        }
        catch(InterruptedException e1){
            e1.printStackTrace();
        }
        catch(IOException e2) {
            e2.printStackTrace();
        }
    }

}


