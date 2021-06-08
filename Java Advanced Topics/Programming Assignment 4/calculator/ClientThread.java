package calculator;

import java.net.Socket;
import java.io.PrintWriter; //output stream
import java.util.Scanner;  //input stream
import java.io.IOException;

public class ClientThread extends Thread{
    private Socket socket;
    private PrintWriter clientOut;
    private ChatServer server;

    public ClientThread(ChatServer server, Socket socket){
        this.server = server;
        this.socket = socket;
    }

    private PrintWriter getWriter(){
        return clientOut;
    }

    @Override
    public void run() {
        try{
            // setup output stream
            this.clientOut = new PrintWriter(socket.getOutputStream(),true); //auto flush = false
            // setup input stream
            Scanner in = new Scanner(socket.getInputStream());
            while(!socket.isClosed()) {
                // check if there is message from Client?
                if(in.hasNextLine()) {
                    //get message and assign to string input
                    String input = in.nextLine();
                    System.out.println(input);
                    //broadcast the message to all clients in List of clients
                    for(ClientThread thatClient : server.getClients()) {
                        //setup output stream for each client
                        PrintWriter thatClientOut = thatClient.getWriter();
                        if (thatClientOut!=null){
                            thatClientOut.println(input);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

