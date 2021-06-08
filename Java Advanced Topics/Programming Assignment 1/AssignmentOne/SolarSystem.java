import java.util.*;
import solarsystem.*;
import solarsystem.exceptions.*;


public class SolarSystem {
    public static void main(String[] args) {// Set up our candidates for the election

        try{
            Star Sun = new Star("Sun",5778);
            Planet Mercury = new Planet("Mercury",Sun);
            Planet Earth = new Planet("Earth",Sun);
            Planet Mars = new Planet("Mars",Sun);
            Planet Jupiter = new Planet("Jupiter",Sun);
            Planet Saturn = new Planet("Saturn",Sun);
            Planet Uranus = new Planet("Uranus",Sun);
            Planet Neptune = new Planet("Neptune",Sun);

            Moon The_Moon = new Moon("Moon",Earth);
            Moon Phobos = new Moon("Phobos",Mars);
            Moon Deimos = new Moon("Deimos",Mars);

        }
        catch(DuplicateCelestialBodyException e){
           
            System.out.println(e.getMessage());
        }
        catch(InvalidCelestialBodyException e){
           
            System.out.println(e.getMessage());
        }
   
    }
}   