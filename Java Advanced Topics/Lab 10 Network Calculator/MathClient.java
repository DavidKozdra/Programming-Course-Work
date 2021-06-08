package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MathClient {

    /*
    * define the port
    * take input from user
    * define a connection to server through a socket local host and port
    * define a print writer for our input
    * define reader for incomming messages
    * always define outtext as our scanners input
    * print our input to the server using printwriter
    * check if input == null or exit
    * print the incoming message
    *
    * */

    public static void main(String[] args) {
        int listen_port = 8000;
        try ( Scanner console = new Scanner(System.in);
              Socket client = new Socket("localhost",listen_port);
              PrintWriter outgoing = new PrintWriter(client.getOutputStream(),true);
              BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()))
            )
        {
            while (true)
            {
               String outext = console.nextLine();
               outgoing.println(outext);
               if(outext==null||outext.equals("exit"))
                 break;
               System.out.println(incoming.readLine());
            }
              
        }catch(IOException e){ 
            e.printStackTrace(); 
        } 
    } 
 }

 /*
 *     int listen_port = 8000;
        try ( Scanner console = new Scanner(System.in);
              Socket client = new Socket("localhost",listen_port);
              PrintWriter outgoing = new PrintWriter(client.getOutputStream(),true);
              BufferedReader incoming = new BufferedReader(new InputStreamReader(client.getInputStream()))
            )
        {
            while (true)
            {
               String outext = console.nextLine();
               outgoing.println(outext);
               if(outext==null||outext.equals("exit"))
                 break;
               System.out.println(incoming.readLine());
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
 * */