import java.util.Arrays;
import java.util.Collections;

public class Tests {
    public static void main(String[] args){
        //Setup
        int totalPairs;
        int k = 0;
        int j = 0;

        totalPairs = 5;
        int[][] comp = new int[totalPairs][totalPairs]; // creates the 3d array for the companies based on size given above
        int[][] prog = new int[totalPairs][totalPairs]; // creates the 3d array for the programmers based on size given above

        Integer[] shuffler = new Integer[totalPairs];
        for(int i = 0; i < shuffler.length; i++){
            shuffler[i] = i;
        }

        for (int i = 0; i < totalPairs; i++){ //takes in the preferences for each programmer and puts it into the the prog array.
            Collections.shuffle(Arrays.asList(shuffler));
            while ( j < totalPairs){
                prog[i][k] = shuffler[j];
                k++;
                j++;
            }
            j=0;
            k=0;
        }
        for (int i =0; i < totalPairs; i++){ //takes in the preferences for each companies and puts it into the the comp array.
            Collections.shuffle(Arrays.asList(shuffler));
            while ( j < totalPairs){
                comp[i][k] = shuffler[j];
                k++;
                j++;
            }
            j=0;
            k=0;
        }
        System.out.println("Programmers and preferences: " + Arrays.deepToString(prog));
        System.out.println("Companies and preferences: " + Arrays.deepToString(comp));

        int[][] pairs = BestFit.stableMatch(prog, comp, totalPairs);
        System.out.println("Finished matches: " + Arrays.deepToString(pairs));

    }
}
