
public class VotingMachine {

    public Candidate[] candidates;

  public VotingMachine(Candidate candidates[]){
      this.candidates = candidates;

  }

    public void vote(Voter v, Candidate c){
        if(!v.hasVoted()){
            v.voted();
            c.incrementVoteCount();
        }
        
    }

    public void tally(){
        int max=0;
        Candidate Winner = null;
        for(Candidate c : candidates){
            if(c.getVoteCount() > max){
                max = c.getVoteCount();
                Winner = c;
            }
            System.out.println(c.getFullName() + " has " + c.getVoteCount() + " votes");
        }
        System.out.println(Winner.getFullName() + " WON THE ELECTION with" + max + " Votes");
    }

}