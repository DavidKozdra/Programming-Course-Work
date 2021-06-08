
import java.util.Scanner;
import java.util.Random;

class Player {

    public String name = "";
    public int wins =0;
    public Player(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is the Player's Name?");
        name = scanner.next();
    }

}

class Bar{
    public Player A;
    public Player B;
    public int sticks;
    Scanner scanner = new Scanner(System.in);

    public Player firstPlayer(){
        Random random = new Random();
        int num = random.nextInt(2)+1;
        if(num == 1){
            return A;
        }  else {
            return B;
        }
     }

    public Bar (int s){
        sticks = s;
        A = new Player();
        B = new Player();
    }

    public void Play(){
        Player CurrentPlayer = firstPlayer();
        while (sticks > 0){
            System.out.println("Sticks Left :" + sticks);
            System.out.println("Player "+CurrentPlayer.name + " picks :");
            int input = scanner.nextInt();
            if(input <= sticks && input < 4){
                sticks -= input;
                if(CurrentPlayer == B){
                    CurrentPlayer = A;
                }else{

                    CurrentPlayer = B;
                }
            }else{

                 System.out.println("Sorry Player "+ CurrentPlayer.name +"  too many pick again");
            }
        }
        System.out.println("Player "+ CurrentPlayer.name +" Wins thanks for playing friend !!! ");
        CurrentPlayer.wins+=1;
        System.out.println("WINS:"+A.name+" :"+ A.wins + " " + B.name + " :" + B.wins);
     }

    }
