import java.util.Arrays;
import java.util.Scanner;

public class main {

        public static void  main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int compProg;
            int k = 0;
            int j = 0;

            System.out.println("Input the value n for the number of n companies and n programmers.");
            compProg = scan.nextInt();
            Company[] companies = new Company[compProg]; // creates the 3d array for the companies based on size given above
            Programmer[] programmers = new Programmer[compProg]; // creates the 3d array for the programmers based on size given above

            for (int i = 0; i < compProg; i++){ //takes in the preferences for each programmer and puts it into the the prog array.
                System.out.println("Please input preferences (separated by spaces, with most prefered as 0) for programmer "+ (i) +": ");
                int[] prog = new int[compProg];
                while ( j < compProg){
                    prog[k] = scan.nextInt();
                    k++;
                    j++;
                }
                programmers[i] = new Programmer(prog);
                j=0;
                k=0;
            }
            for (int i =0; i < compProg; i++){ //takes in the preferences for each companies and puts it into the the comp array.
                System.out.println("Please input preferences (separated by spaces with most prefered as 0) for company "+ (i) +": ");
                int[]comp = new int[compProg];
                while ( j < compProg){
                    comp[k] = scan.nextInt();
                    k++;
                    j++;
                }
                companies[i] = new Company(comp);
                j=0;
                k=0;
            }
            int[][] pairs = BestFit.stableMatch(programmers, companies, compProg);
        }

}
