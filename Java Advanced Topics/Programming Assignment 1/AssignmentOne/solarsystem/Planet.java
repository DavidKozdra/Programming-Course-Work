package solarsystem;

import javax.swing.*;
import solarsystem.exceptions.*;
import java.util.Scanner;


public class Planet extends CelestialBody implements IOrbit {
    private CelestialBody orbits;
    
    public Planet(String name, CelestialBody orbits) throws InvalidCelestialBodyException{
        super(name,"Planet");
        this.orbits = orbits;
        if(orbits.getType() != "Star"){
            throw new InvalidCelestialBodyException("A planet must orbit astar."); 

        }
    }

    public void getOrbit(){
        System.out.println(getName() + "is orbiting the " + orbits.getType() + " " + orbits.getName());
    }

}