package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class ChopstickFx {
    private int id;
    private boolean inUse;
    private Rectangle ch;

    public ChopstickFx(int id, Rectangle ch){
        this.ch = ch;
        this.id = id;
        inUse = false;

    }

    public synchronized void release(String des){
        inUse = false;
        System.out.println("Chopstick "+id+" has been set down " + des);
        //System.out.println(" rectangle " + id + " Should be Black");
        //ch.setLayoutY(100);
        //ch.setLayoutX(80);
        //ch.setStyle("-fx-background-color: black;");
    }

    public synchronized void take(String des, Circle r){
        inUse = true;
        //ch.setStyle("-fx-background-color: red;");
        ch.setLayoutY(r.getCenterY() + 10);
        ch.setLayoutX(r.getCenterX() + 20);
        //System.out.println(" rectangle " + id + " Should be RED");
        System.out.println("Chopstick "+id+" has been picked up " + des);
    }

    public synchronized boolean isinUse(){

        return inUse;
    }

    public synchronized int getId(){

        return id;
    }
}