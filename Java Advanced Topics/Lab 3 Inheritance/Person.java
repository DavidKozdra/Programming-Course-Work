
public abstract class Person
 {
    private int age;
    private char gender;
    protected String firstName, lastName;
    protected String politicalParty;

    public Person(){



    }

    public Person(int age, char gender,String firstName,String lastName,String politicalParty){
        this.age =age;
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.politicalParty = politicalParty;

    }

    public int getAge(){

        return age;
    }
    public char getGender(){

        return gender;
    }

    public abstract String getFullName();
}