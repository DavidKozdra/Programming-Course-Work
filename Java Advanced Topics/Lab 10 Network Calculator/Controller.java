package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    @FXML
    private TextField txtnum;
    @FXML
    private Button btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnadd, btnsub, btntimes, btndiv, btnclr, btnequal;

    private final int listen_port = 8000;
    private Socket client;
    private PrintWriter outgoing;
    private BufferedReader incoming;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            client = new Socket("localhost",listen_port);
            outgoing = new PrintWriter(client.getOutputStream(),true);
            incoming = new BufferedReader(new InputStreamReader(client.getInputStream()));
        }
        catch(IOException e){
            e.printStackTrace();
            txtnum.setText("Server Error");
        }
    }

    public PrintWriter getOutgoing(){

        return  outgoing;
    }

    public Socket getSocket(){

        return client;
    }

    public BufferedReader getIncoming(){

        return incoming;
    }

    public double a = 0.0; // number
    public int op = 0; //operator


    @FXML
    public void ophandle(ActionEvent e){
    //operator click
        String text = txtnum.getText(); //store value
        System.out.println(op);
        if(e.getSource()==btnadd)
    {
        a = Double.parseDouble(text);
        op = 1;
        txtnum.setText("");
    }
        else if(e.getSource()==btnsub)

    {
        a = Double.parseDouble(text);
        op = 2;
        txtnum.setText("");
    }
        else if(e.getSource()==btntimes)

    {
        a = Double.parseDouble(text);
        op = 3;
        txtnum.setText("");
    }
        else if(e.getSource()==btndiv)

    {
        a = Double.parseDouble(text);
        op = 4;
        txtnum.setText("");
    }

       else if (e.getSource() == btnequal) {
            //System.out.println("???");
            Double b = Double.parseDouble(text);
            try{
                switch (op){
                    case 1:
                        outgoing.println((int)a+"+"+ b);
                        txtnum.setText(incoming.readLine());
                        break;
                    case 2:
                        outgoing.println((int)a+"-"+ b);
                        txtnum.setText(incoming.readLine());
                        break;
                    case 3:
                        outgoing.println((int)a+"*"+ b);
                        txtnum.setText(incoming.readLine());
                        break;
                    case 4:
                        outgoing.println((int)a+"/"+ b);
                        txtnum.setText(incoming.readLine());
                        break;
                }

            }catch(IOException ei){
                ei.printStackTrace();

            }


        }
        //clear
        else if (e.getSource() == btnclr) {
            txtnum.setText("");
            a =0;
        }

}


    @FXML
    public void handler(ActionEvent e){
        Button source = (Button)e.getSource();
        txtnum.setText(txtnum.getText() + source.getText());
        String text = txtnum.getText(); //store value

        //number click
        //done


    }


}
