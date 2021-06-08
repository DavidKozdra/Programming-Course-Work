import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

   class Lab1Bars21_8338{
      public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int sticks =21;
        char Player = firstPlayer();
        while (sticks > 0){
            System.out.println("Sticks Left :" + sticks);
            System.out.println("Player "+Player+" picks");
            int input = scanner.nextInt();
            if(input <= sticks && input < 4){
                sticks -= input;
                if(Player == 'B'){
                    Player = 'A';
                }else{

                    Player = 'B';
                }
            }else{

                 System.out.println("Sorry Player "+Player+"  too many pick again");
            }
        }
        System.out.println("Player "+ Player+" Wins thanks for playing friend !!! ");
     }
     public static char firstPlayer(){
        Random random = new Random();
        int num = random.nextInt(2)+1;
        System.out.println(num);
        if(num == 1){
            return 'B';
        }  else {
            return 'A';
        }
     }
    
}