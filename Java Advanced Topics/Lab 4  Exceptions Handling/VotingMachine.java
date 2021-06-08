import java.util.*;

public class VotingMachine {

   public ArrayList<Candidate> candidates;

  public VotingMachine(ArrayList<Candidate> candidates) throws MissingCandidatesException{
      this.candidates = candidates;
      if(candidates == null || candidates.isEmpty()){

            throw new MissingCandidatesException("The candidate list cannot be null or empty");
      }

  }

    public void vote(Voter v, Candidate c) throws CandidateNotFoundException{
           if(!candidates.contains(c)){
            throw new CandidateNotFoundException("Canadidate does not exists in the candidates collection");
        }
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