package solarsystem;

import javax.swing.*;
import solarsystem.exceptions.*;
import java.util.Scanner;


public class Star extends CelestialBody{
    
    private int surfaceTemp;
    public Star(String name,int surfaceTemp) {
        super(name,"Star");
        this.surfaceTemp = surfaceTemp;
    }
    public int getSurfaceTemp(){

        return surfaceTemp;
    }

}