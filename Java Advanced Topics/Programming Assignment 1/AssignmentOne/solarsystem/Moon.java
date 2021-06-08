package solarsystem;

import javax.swing.*;
import solarsystem.exceptions.*;
import java.util.Scanner;


public class Moon extends CelestialBody{
    private CelestialBody orbits;

    public void getOrbit(){
        System.out.println(getName() + " is orbiting the" + orbits.getType() + " " + orbits.getName() + "");
    }

    public Moon(String name,CelestialBody orbits){
        super(name,"Moon");
        this.orbits = orbits;
    }


}