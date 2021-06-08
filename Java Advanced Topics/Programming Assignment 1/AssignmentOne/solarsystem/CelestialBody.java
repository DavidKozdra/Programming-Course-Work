package solarsystem;

import javax.swing.*;
//import exceptions.*;
import java.util.*;
import solarsystem.exceptions.DuplicateCelestialBodyException; 

public class CelestialBody{
    
    private String name;
    private String type;
    private ArrayList<CelestialBody> Children= new ArrayList<CelestialBody>();

    public CelestialBody(String name,String type) {
        this.name = name;
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public void addChild(CelestialBody child) throws DuplicateCelestialBodyException{
            if(!Children.contains(child)){
                Children.add(child);
                System.out.println(child.getName()+" Successfully added" + getName());
            }else{

                throw new DuplicateCelestialBodyException(child.getName()+" is already in the collection");
            }
       
    }

    public ArrayList<CelestialBody> getChildren(){

        return Children;
    }


}