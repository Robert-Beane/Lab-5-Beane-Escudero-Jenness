import java.util.Arrays;
import java.util.Collections;

public class Tests {
    public static void main(String[] args){
        //Setup
        int totalPairs;
        int k = 0;
        int j = 0;

        totalPairs = 5;
        Company[] companies = new Company[totalPairs]; // creates the 3d array for the companies based on size given above
        Programmer[] programmers = new Programmer[totalPairs]; // creates the 3d array for the programmers based on size given above

        Integer[] shuffler = new Integer[totalPairs];
        for(int i = 0; i < shuffler.length; i++){
            shuffler[i] = i;
        }

        for (int i = 0; i < totalPairs; i++){ //takes in the preferences for each programmer and puts it into the the prog array.
            Collections.shuffle(Arrays.asList(shuffler));
            int[] prog = new int[totalPairs];
            while ( j < totalPairs){
                prog[k] = shuffler[j];
                k++;
                j++;
            }
            programmers[i] = new Programmer(prog);
            j=0;
            k=0;
        }
        for (int i =0; i < totalPairs; i++){ //takes in the preferences for each companies and puts it into the the comp array.
            Collections.shuffle(Arrays.asList(shuffler));
            int[] comp = new int[totalPairs];
            while ( j < totalPairs){
                comp[k] = shuffler[j];
                k++;
                j++;
            }
            companies[i] = new Company(comp);
            j=0;
            k=0;
        }

        for (int i = 0; i < totalPairs; i++){
            System.out.println("Programmer " + i + " prefs: " + programmers[i].toString());
        }

        for(int i = 0; i<totalPairs; i++){
            System.out.println("Company " + i + " prefs: " + companies[i].toString());
        }


        int[][] pairs = BestFit.stableMatch(programmers, companies, totalPairs);
        System.out.println("Finished matches (Ordered [company,programmer]): " + Arrays.deepToString(pairs));

    }
}
