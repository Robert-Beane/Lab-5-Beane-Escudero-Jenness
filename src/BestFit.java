import java.util.Arrays;

public class BestFit {
    public static void stableMatch(int[][] programmers, int[][] companies, int pairCount){
        int pairs = 0;
        int[][] pairGroups = new int[pairCount][2];
        while(pairs < pairCount){
            for(int programmer = 0; programmer < programmers.length; programmer++){
                if(!isPaired(pairGroups, programmer)) {
                    for (int rank = 0; rank < programmers[programmer].length; rank++){
                        if(isFree(pairGroups,programmers[programmer][rank])){
                            pairGroups[programmer][1] = programmers[programmer][rank];
                        }else{

                        }
                    }
                }
            }
        }
    }

    private static boolean isFree(int[][] groupList, int company){
        boolean result = true;
        for(int i = 0; i < groupList.length; i++){
            if(groupList[i][1] == company){
                result = false;
            }
        }
        return result;
    }

    private static boolean isPaired(int [][] groupList, int programmer){
        boolean result = false;
        for(int i = 0; i < groupList.length; i++){
            if(groupList[i][0] == programmer){
                result = true;
            }
        }
        return result;
    }

}
