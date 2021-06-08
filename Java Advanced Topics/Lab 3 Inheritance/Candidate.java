
public class Candidate extends Person {
  private int voteCount =0;
  public Candidate(){

    voteCount =0;
  }
  public Candidate(int age, char gender, String firstName,String lastName, String politicalParty){
      super(age,gender,firstName,lastName,politicalParty);
      voteCount =0;
  }

  public int getVoteCount(){

      return voteCount;
  }

  public void incrementVoteCount(){

      voteCount++;
  }


  public String getFullName(){
      String Party;
        if(politicalParty =="Non-Affiliate"){
            Party = "NA";

        }else{
            Party = politicalParty.substring(0);
        }
    return firstName + " " + lastName + " -" + Party;

  }


}