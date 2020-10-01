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
            Company[][] comp = new Company[compProg][compProg]; // creates the 3d array for the companies based on size given above
            Programmer[][] prog = new Programmer[compProg][compProg]; // creates the 3d array for the programmers based on size given above

            for (int i = 0; i < compProg; i++){ //takes in the preferences for each programmer and puts it into the the prog array.
                System.out.println("Please input preferences (separated by spaces) for programmer "+ (i+1) +": ");
                while ( j < compProg){
                    prog[i][k] = scan.nextInt();
                    k++;
                    j++;
                }
                j=0;
                k=0;
            }
            for (int i =0; i < compProg; i++){ //takes in the preferences for each companies and puts it into the the comp array.
                System.out.println("Please input preferences (separated by spaces) for company "+ (i+1) +": ");
                while ( j < compProg){
                    comp[i][k] = scan.nextInt();
                    k++;
                    j++;
                }
                j=0;
                k=0;
            }
            System.out.println(Arrays.deepToString(prog));
            System.out.println(Arrays.deepToString(comp));

            //BestFit.stableMatch(prog, comp, compProg);
        }

}
