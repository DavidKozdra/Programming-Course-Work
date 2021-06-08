package regexfile;

import java.io.*;
import java.util.regex.*;
import java.util.*;

public class ExtractData{

   ArrayList<String> lastname;
   ArrayList<String> firstname;
   ArrayList<String> id;
   ArrayList<Character> al;
      
   public ExtractData(){
      lastname = new ArrayList<String>();
      firstname = new ArrayList<String>();
      id = new ArrayList<String>();
      al = new ArrayList<Character>();
      //insert code here
      String reg = "\"(.+),\\s*(.+)\",\\d+,\\d+\\D+(\\d+)";
      Pattern pattern = Pattern.compile(reg); // rules for pattern in regex
      File file = new File("studentlist.csv"); // file we will search in
      System.out.println(file.getAbsolutePath());
      try(Scanner input = new Scanner(file)){ // scan the file
          while(input.hasNext()){ // if the scanner has not finnished
            String line= input.nextLine(); // line currently on
            Matcher matcher = pattern.matcher(line); //check current line
            char c;
            while(matcher.find()) { // makes each column data a part of the array lists they belong to
                //System.out.println(matcher.group(1));
              lastname.add(matcher.group(1));
              firstname.add(matcher.group(2));
              id.add(matcher.group(3));

              c=matcher.group(1).charAt(0); // first letter of last name
              if(!al.contains(c)) al.add(c); //adds the first letter if it doesnt exist this helps us know what initails there are 
            }
          }

      }catch(IOException e){


      }
      
   }
   /*
   public static void main(String args[]){
       ExtractData extract = new ExtractData(); 
       ArrayList<String> lname = extract.lastname;
       ArrayList<String> fname = extract.firstname;
       ArrayList<String> id = extract.id;
       ArrayList<Character> al = extract.al;
       
       for (Character st: al){
           System.out.println(st);
       }
   }
   */
}
