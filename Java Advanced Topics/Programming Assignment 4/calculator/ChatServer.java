package calculator;

import calculator.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;


public class ChatServer {
    private ServerSocket serverSocket;
    private int serverPort;                   //listening port
    private ArrayList<ClientThread> clients;  //List of clients
    public ChatServer(int port){
        serverPort=port;
    }
    public ArrayList<ClientThread> getClients(){
        return clients;
    }
    public void startServer(){
        clients = new ArrayList<ClientThread>();
        try {
            serverSocket = new ServerSocket(serverPort); //Create SeverSocket
            acceptClient(serverSocket);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void acceptClient(ServerSocket serverSocket){
        System.out.println("Server listens on port : " + serverPort);
        Date now = new Date();
        System.out.println(now.toString()); //display current date-time
        while(true) {
            try {
                //Create socket for each Client.
                Socket socket = serverSocket.accept();
                System.out.println("accepts : " + socket.getRemoteSocketAddress());
                System.out.println(now.toString()); //display date-time when accepts client
                //Initial client object
                ClientThread client = new ClientThread(this, socket);
                client.start();
                //Add client into Arraylist clients
                clients.add(client);
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        int portNumber = 4444;
        ChatServer server = new ChatServer(portNumber);
        server.startServer();
    }
}

