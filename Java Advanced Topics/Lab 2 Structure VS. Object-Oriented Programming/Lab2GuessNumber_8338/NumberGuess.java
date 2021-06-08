import java.util.Scanner;
import java.util.Random;

class NumberGuess{
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int input =-1;
    int high =100;
    int low =1;
    int answer=0;

    public NumberGuess (){
         answer =random.nextInt(high);
    }

    public void Play(){
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