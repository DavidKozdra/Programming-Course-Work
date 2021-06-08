package sample;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PhilosopherFx extends Thread {

    private int id;
    private ChopstickFx leftChopstick;
    private ChopstickFx rightChopstick;
    private Circle ch;
    public PhilosopherFx(int id, ChopstickFx leftChopstick, ChopstickFx rightChopstick, Circle ch) {
        this.ch = ch;
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
        try{
            synchronized (leftChopstick) {
                if (!(leftChopstick.isinUse() && rightChopstick.isinUse())) {
                    leftChopstick.take("by philosopher " + id, ch);
                    synchronized (rightChopstick) {
                        rightChopstick.take("by philosopher " + id, ch);
                        System.out.println("Philosopher " + id + " is eating");
                        ch.setFill(Color.RED);
                        Thread.currentThread().sleep((int) (Math.random() * 3000));
                        leftChopstick.release("by philosopher " + id);
                        rightChopstick.release("by philosopher " + id);
                        ch.setFill(Color.BLACK);
                    }


                }
            }
        } catch(InterruptedException e) {}

    }
/*
*        synchronized (leftChopstick) {
           if(!rightChopstick.isinUse() && !leftChopstick.isinUse()){

               System.out.println("Philosopher " + id+ " is Eating");
               //  System.out.println(" Circle " + id + " Should be RED");
               ch.setFill(Color.RED); //always happens
           }
            leftChopstick.take("by philosopher "+ id , ch);
            synchronized (rightChopstick) {
                rightChopstick.take("by philosopher "+ id,ch);
                rightChopstick.release("by philosopher "+ id);
            }
            leftChopstick.release("by philosopher "+ id);
        }
* */

    void think(){
        try{
            sleep((int)(Math.random()*3000));
            System.out.println("Philosopher " + id+ " is Thinking");
            //System.out.println(" Circle " + id + " Should be Black");
        }
        catch(InterruptedException e){
        
        }
    
    }

}