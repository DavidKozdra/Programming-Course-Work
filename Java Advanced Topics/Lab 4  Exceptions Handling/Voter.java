
public class Voter extends Person{
    private int voterid;
    private boolean voted = false;
    public Voter(){}
    public Voter(int voterId, int age, char gender, String firstName, String lastName, String politicalParty){
        super(age, gender, firstName, lastName,politicalParty);
        this.voterid = voterid;
    }
    public int getVoterid(){

        return voterid;
    }

    public boolean hasVoted(){


        return voted;
    }
    public void voted(){

        voted = true;
    }
    public String getFullName(){

        return firstName + " " + lastName;
    }

}