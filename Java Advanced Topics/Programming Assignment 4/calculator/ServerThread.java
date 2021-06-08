package calculator;

import javafx.scene.control.TextArea;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

public class ServerThread extends Thread {
    private Socket socket;
    private String userName;  //client username
    private LinkedList<String> messagesToSend; //list of messages
    private boolean hasMessages = false;
    private TextArea txtArea;

    public ServerThread(Socket socket, String userName, TextArea txtArea){ //constructor
        this.socket = socket;
        this.userName = userName;
        this.txtArea=txtArea;
        messagesToSend = new LinkedList<String>();
    }
    //add message to list of messages
    public void addNextMessage(String message){
        synchronized (messagesToSend){
            hasMessages = true;
            messagesToSend.push(message);
        }
    }

    @Override
    public void run(){
        //display greeting message on client terminal
        txtArea.appendText("Welcome :" + userName+"\n");
        txtArea.appendText("Communication Port :" + socket.getLocalPort()+"\n");
        txtArea.appendText("Server IP :" + socket.getRemoteSocketAddress()+"\n");
        try{
            //create input and output stream for client
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);
            InputStream serverInStream = socket.getInputStream();
            Scanner serverIn = new Scanner(serverInStream);
            while(!socket.isClosed()){
                //check data in input stream?
                if(serverInStream.available() > 0){
                    //check input stream has message from client?
                    if(serverIn.hasNextLine()){
                        //display on client screen.
                        txtArea.appendText(serverIn.nextLine()+"\n");
                    }
                }
                if(hasMessages){
                    String nextSend = "";
                    synchronized(messagesToSend){
                        //pop the message from list of messages (stack)
                        nextSend = messagesToSend.pop();
                        hasMessages = !messagesToSend.isEmpty(); //set hasMessages to false
                        //send message to a client
                        serverOut.println(userName + " > " + nextSend);
                    }
                }
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }

    }
}

