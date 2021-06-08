    import java.util.*;
    import java.io.*;

    // Name Team Position height wieght age
    public class Assignment1 {
        public static void main(String[] args) throws Exception {
            //parsing a CSV file into Scanner class constructor  
            Scanner sc = new Scanner(new File("mlb_players.csv"));
            ArrayList < String > name = new ArrayList < String > ();
            ArrayList < String > team = new ArrayList < String > ();
            ArrayList < String > position = new ArrayList < String > ();
            ArrayList < Integer > height = new ArrayList < Integer > ();
            ArrayList < Integer > weight = new ArrayList < Integer > ();
            ArrayList < Double > age = new ArrayList < Double > ();
            while (sc.hasNext()){
                String str = sc.nextLine();
                String[] field = str.split(",");
                name.add(field[0]);
                team.add(field[1]);
                position.add(field[2]);
                height.add(Integer.parseInt(field[3].trim()));
                weight.add(Integer.parseInt(field[4].trim()));
                age.add(Double.parseDouble(field[5].trim()));
                System.out.println(field[0] + " ," + field[1] + " ," + field[2] + " ," + field[3] + " ," + field[4] + " ," + field[5]);
            }
            sc.close(); //closes the scanner 
            //ArrayList<ArrayList> Columns = {name,team,position,height,weight,age};

            int input = 0;
            Scanner Reader = new Scanner(System.in);
            while (input != 6) {
                System.out.println("\n Manipulate the table of MLB player \n 1. player per team \n 2. player per position \n 3. tallest and shortest \n 4. heaviest  and lightest \n 5. age average \n 6. quit");
                input = Reader.nextInt();
                if (input == 1) {
                    Seperation(team);

                } else if (input == 2) {
                    Seperation(position);
                } else if (input == 3) {
                    LowHigh(height, name);

                } else if (input == 4) {
                    LowHigh(weight, name);
                       
                } else if (input == 5) {
                    System.out.println(Average(age));
                }
            }
        }

        public static void LowHigh(ArrayList < Integer > Collection, ArrayList < String > Names) {
            /*
            Loop through the numbers finding the lowest and highest and there index
           Loop again but now check if it is equla to the final max and min
            concat string of name they will have the same index add to output list
             add it to the master lists one for max on for min
             end loop 
             print the lists 
            */

            int max = 0;
            int min = Collection.get(0);
            int index1 = 0, index2 = 0;
            for (int i = 0; i < Collection.size(); i++) {
                if (Collection.get(i) < min) {
                    min = Collection.get(i);
                    index1 = i;

                } else if (Collection.get(i) > max) {
                    max = Collection.get(i);
                    index2 = i;
                }

            }
            ArrayList High = new ArrayList();
            ArrayList Low = new ArrayList();

              for (int i = 0; i < Collection.size(); i++) {
                if (Collection.get(i) == min) {
                    Low.add(Names.get(i) + " " + min); 
                } else if (Collection.get(i) == max) {
                    High.add(Names.get(i) + " " + max); 
                }

            }
            System.out.println("Lowest");
            for (int i = 0; i < Low.size(); i++) {
                System.out.println(Low.get(i));

            }
            System.out.println("Highest");
            for (int i = 0; i < High.size(); i++) {
                System.out.println(High.get(i));

            }
        }


        public static double Average(ArrayList < Double > Collection) {
            double sum = 0;
            for (double Value: Collection) {
                sum += Value;
            }

            return sum / (Collection.size());
        }

        public static void Seperation(ArrayList < String > Collection) {
            /*
            Make a list of every type of team then do !contain() gate to insure no duplicates 
            Dictionary needs to be made to teams count teams index in teams count:
            loop through collection 
            add to teamscount at index
            dictionary.key of object value ++
            print dictionary
        
            basiclly keep track of types of teams and use that to count each new one 
            new type of team is added to the dictionary with 1 team member as its value and team name as its key
            from then on if it is contained as a key just add to that keys value
            */
            Hashtable<String,Integer> dictionary = new Hashtable();
            for (String item: Collection) {
                if (!dictionary.containsKey(item)) {
                    dictionary.put(item,1);

                }else {
                    dictionary.put(item,dictionary.get(item)+1);
                }

            }
              System.out.println(dictionary);

        }

    }