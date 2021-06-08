package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
This is a server for the specific client
    this is a thread
* set client socket to null
* constructor takes new socket for client
* set client socket to param given
*
*
* run
* define our incoming and outgoingprint client getoutputstream
* define input and output strings
 create a regex pattern that has three groups 1 or more numbers 1 of the four funtions or 1 or more numbers

define result

always

set input string to the incoming buffers next line

check if input string is exit or null if so stop while
print disconnect sleep for 1 secound before this

set up a matcher for the pattern

if mather.find
    group 1 is operator
    if group 1 is +
    result is group 1 + group2 parse double
    print result send result to outgoing



* */
class MathClientThread extends Thread{
     Socket client=null;
     
     MathClientThread(Socket client){
       this.client=client; 
     }
     
     public void run(){
       try ( PrintWriter outgoing = new PrintWriter(client.getOutputStream(),true);
             BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()))
           )
       {
            System.out.println("Connection from " + client.getInetAddress().toString());
            
            String intext,outext;
            Pattern pattern = Pattern.compile("(\\d+)\\s*(\\+|\\*|\\-|\\/)\\s*(\\d+)"); 
            double result=0.0;
            while(true){
                intext = incoming.readLine();
                if ((intext==null)||intext.equals("exit")){
                   System.out.println(client.getInetAddress().toString()+ " disconnected!!"); 
                   Thread.sleep(1000); //Wait for Client to disconnection
                   break;
                }
                Matcher matcher = pattern.matcher(intext);
                if (matcher.find()){
                   //" 1 + 3"
                   //group(0)  ==> " 1 + 3"
                   //group(1)  ==> operand 1  1
                   //group(2)  ==> operator   +
                   //group(3)  ==> operand 2  3
                   if (matcher.group(2).equals("+")){
                      result=Double.parseDouble(matcher.group(1))+Double.parseDouble(matcher.group(3));
                      System.out.println(result);
                      outgoing.println(result);
                      //outgoing.flush();
                   }
                    if (matcher.group(2).equals("-")){
                        result=Double.parseDouble(matcher.group(1))-Double.parseDouble(matcher.group(3));
                        System.out.println(result);
                        outgoing.println(result);
                        //outgoing.flush();
                    }
                    if (matcher.group(2).equals("*")){
                        result=Double.parseDouble(matcher.group(1))*Double.parseDouble(matcher.group(3));
                        System.out.println(result);
                        outgoing.println(result);
                        //outgoing.flush();
                    }
                    if (matcher.group(2).equals("/")){
                        result=Double.parseDouble(matcher.group(1))/Double.parseDouble(matcher.group(3));
                        System.out.println(result);
                        outgoing.println(result);
                        //outgoing.flush();
                    }
                }
            }
            client.close();
        }
        catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

     }
}


/*This is the main server it finds connections and gives them their own threads
*
* define a clientthread
*  a server socket
*  a socket connection
*  and a port
*  set server socket to a new serversocket with the port as a param
*
* display port and listening to
*
*
* always  set socket to server socket.accept which will wait for a client request
*  make a new thread with server socket as param
* start it
*
* */
public class MathServer {

    public static void main(String[] args) {
        MathClientThread ct;
        ServerSocket listener;
        Socket connection;
        int listen_port = 8000;
        try {
            listener = new ServerSocket(listen_port);
            System.out.println("Listening on port " + listen_port);
            while (true) {
                connection = listener.accept();
                ct = new MathClientThread(connection);
                ct.start();
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}


/*
*
*
*
*
*
* */