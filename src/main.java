import java.util.Arrays;
import java.util.Scanner;

public class main {

        public static void  main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int compProg;
            int k = 0;
            int j = 0;
            int pref;

            System.out.println("Input your n amount of companies/programmers.");
            compProg = scan.nextInt();
            int[][] comp = new int[compProg][compProg];
            int[][] prog = new int[compProg][compProg];

            for (int i = 0; i < compProg; i++){
                System.out.println("Please input preferences (separated by spaces) for programmer "+ (i+1) +": ");
                while ( j < compProg){
                    prog[i][k] = scan.nextInt();
                    k++;
                    j++;
                }
                j=0;
                k=0;
            }
            for (int i =0; i < compProg; i++){
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
