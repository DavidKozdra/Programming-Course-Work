
public class Election {
    public static void main(String[] args) {// Set up our candidates for the election
    Candidate janeDoe = new Candidate(35, 'F', "Jane", "Doe", "Republican");
    Candidate johnSmith = new Candidate(35, 'M', "John", "Smith", "Democrat");
    Candidate fredJohnson = new Candidate(35, 'M', "Fred", "Johnson", "Non-Affiliate");
    // Add our candidates to the array candidates
    Candidate candidates[] = {janeDoe, johnSmith, fredJohnson};
 // Initialize VotingMachine
    VotingMachine vm = new VotingMachine(candidates);
    //Create our voters and cast their votesVoter 
    Voter v1 = new Voter(1, 20, 'M', "Martin", "Amis", "Non-Affiliate");
    vm.vote(v1, janeDoe);
    Voter v2 = new Voter(2, 45, 'F', "Jane", "Smith", "Republican");
    vm.vote(v2, janeDoe);
    Voter v3 = new Voter(3, 31, 'M', "John", "Johnson", "Democrat");
    vm.vote(v3, johnSmith);
    Voter v4 = new Voter(4, 35, 'M', "Tommy", "Bradon", "Non-Affiliate");
    vm.vote(v4, janeDoe);
    Voter v5 = new Voter(5, 27, 'M', "Bob", "Dylan", "Non-Affiliate");
    vm.vote(v5, johnSmith);
    Voter v6 = new Voter(6, 27, 'F', "Ellie", "Smith", "Democrat");
    vm.vote(v6, janeDoe); 
    Voter v7 = new Voter(7, 30, 'F', "Lilly", "Frederick", "Non-Affiliate");
    vm.vote(v7, fredJohnson);
    vm.tally();
    }
  }