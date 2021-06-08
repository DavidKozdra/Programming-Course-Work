package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Controller {

    @FXML
    private Circle c1,c2,c3,c4,c5;

    @FXML
    private Rectangle r1,r2,r3,r4,r5;


    public void initialize(){
        ArrayList<ChopstickFx> stickList = new ArrayList<ChopstickFx>();
        ArrayList<PhilosopherFx> phosopherList = new ArrayList<PhilosopherFx>();
        stickList.add(new ChopstickFx(1,r1));
        stickList.add(new ChopstickFx(2,r2));
        stickList.add(new ChopstickFx(3,r3));
        stickList.add(new ChopstickFx(4,r4));
        stickList.add(new ChopstickFx(5,r5));

        phosopherList.add(new PhilosopherFx(1,stickList.get(0),stickList.get(1),c1));
        phosopherList.add(new PhilosopherFx(2,stickList.get(1),stickList.get(2),c2));
        phosopherList.add(new PhilosopherFx(3,stickList.get(2),stickList.get(3),c3));
        phosopherList.add(new PhilosopherFx(4,stickList.get(3),stickList.get(4),c4));
        phosopherList.add(new PhilosopherFx(5,stickList.get(0),stickList.get(4),c5));

        for(int i=0; i<5; i++){
            phosopherList.get(i).start();
        }

    }




}
