import java.util.Random;

public class Philosopher extends Thread {

    private int id;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;
    public Philosopher(int id, Chopstick leftChopstick,Chopstick rightChopstick) {

        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    @Override
    public void run(){
        while (true) {
            eat();
            think();
        }
    }

    public void eat(){
       synchronized (leftChopstick) {
            leftChopstick.take("by philosopher "+ id);
            synchronized (rightChopstick) {
                rightChopstick.take("by philosopher "+ id);
                if(rightChopstick.isinUse() && leftChopstick.isinUse()){ 
                    System.out.println("Philosopher " + id+ " is Eating");
                    
                }
                rightChopstick.release("by philosopher "+ id);
            }
            leftChopstick.release("by philosopher "+ id);
        }
    }


    void think(){
        try{    
            sleep((int)(Math.random()*3000));
            System.out.println("Philosopher " + id+ " is Thinking");
        }
        catch(InterruptedException e){
        
        }
    
    }

}