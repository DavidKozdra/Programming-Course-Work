
public class Candidate extends Person {
  private int voteCount =0;

  public Candidate(){

    voteCount =0;
  }
  public Candidate(int age, char gender, String firstName,String lastName, String politicalParty) throws MinimumAgeException{
      super(age,gender,firstName,lastName,politicalParty);
        if(age < 25){
            throw new MinimumAgeException(" Canadiate age cannot be less than 25");
        }
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