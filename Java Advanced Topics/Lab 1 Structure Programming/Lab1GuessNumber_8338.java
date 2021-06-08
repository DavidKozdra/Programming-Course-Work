import javax.swing.*;
import java.util.Scanner;
import java.util.Random;
import java.lang.Math;

   class Lab1GuessNumber_8338{


      public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int answer = random.nextInt(100);
        int low =1;
        int high = 100; 
        int input =-1;
        while (input != answer){
            System.out.println("Pick a number between" + low + " to " + high);
            input = scanner.nextInt();
            if(input > low && answer > input){
                low = input;

            }else if(input < high && answer < input){
                high = input;

            }else {
                System.out.println("Sorry that is invalid");

            }
            if(high -low == 1){
                System.out.println("You Lose Answer was " + answer);
                return;
            }
        }
        System.out.println("You Win thanks for playing friend !!! ");
     }
    
}