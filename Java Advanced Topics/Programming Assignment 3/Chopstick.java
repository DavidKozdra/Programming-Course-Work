public class Chopstick{
    private int id;
    private boolean inUse;
    
    public Chopstick(int id){
        this.id = id;
        inUse = false;

    }

    public synchronized void release(String des){
        inUse = false;
        System.out.println("Chopstick "+id+" has been set down " + des);
    }

    public synchronized void take(String des){

        inUse = true;
        System.out.println("Chopstick "+id+" has been picked up " + des);
    }

    public synchronized boolean isinUse(){

        return inUse;
    }

    public synchronized int getId(){

        return id;
    }
}