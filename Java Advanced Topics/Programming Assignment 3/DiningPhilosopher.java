import java.io.*;
import java.util.*;

public class DiningPhilosopher{


    public static void main (String[] args){

        ArrayList<Chopstick> stickList = new ArrayList<Chopstick>();
        ArrayList<Philosopher> phosopherList = new ArrayList<Philosopher>();
        for(int i=0; i<5; i++){
            stickList.add(new Chopstick(i+1));
        }
        phosopherList.add(new Philosopher(1,stickList.get(0),stickList.get(1)));
        phosopherList.add(new Philosopher(2,stickList.get(1),stickList.get(2)));
        phosopherList.add(new Philosopher(3,stickList.get(2),stickList.get(3)));
        phosopherList.add(new Philosopher(4,stickList.get(3),stickList.get(4)));
        phosopherList.add(new Philosopher(5,stickList.get(0),stickList.get(4)));

        for(int i=0; i<5; i++){
            phosopherList.get(i).start();
        }
    }
}