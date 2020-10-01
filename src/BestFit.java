import java.util.Arrays;

public class BestFit {
    public static int[][] stableMatch(Programmer[] programmers, Company[] companies, int pairCount){
        int pairsMade = 0;
        int[][] pairs = new int[pairCount][2];
        boolean[] programmersPartnered = new boolean[pairCount];

        //while there exists unpaired programmers
        while(pairsMade < pairCount) {
            //this gets us our unpaired programmer
            int selectedProgrammer;
            for(selectedProgrammer = 0; selectedProgrammer < pairCount; selectedProgrammer++){
                if(programmers[selectedProgrammer].paired == false){
                    break;
                }
            }

            //get first unpaired company
            int selectedCompany = programmers[selectedProgrammer].preferences[pairCount-1];
            for(int i = 0; i < pairCount && !programmers[selectedProgrammer].paired; i++){
                selectedCompany = programmers[selectedProgrammer].preferences[i];
                if(!programmers[selectedProgrammer].attemptedPairings[selectedCompany]){
                    break;
                }
            }

            //if unpaired
            if(!companies[selectedCompany].paired){
                programmers[selectedProgrammer].paired = true;
                programmers[selectedProgrammer].partnerCompany = selectedCompany;
                companies[selectedCompany].paired = true;
                companies[selectedCompany].partnerProgrammer = selectedProgrammer;
                pairsMade++;
                pairs[selectedCompany][0] = selectedCompany;
                pairs[selectedCompany][1] = selectedProgrammer;
            }else{
                if(companies[selectedCompany].challenge(selectedProgrammer) > 0){
                    int formerPartner = companies[selectedCompany].partnerProgrammer;
                    programmers[formerPartner].paired = false;
                    programmers[formerPartner].partnerCompany = -1;
                    companies[selectedCompany].partnerProgrammer = selectedProgrammer;
                    programmers[selectedProgrammer].paired = true;
                    programmers[selectedProgrammer].partnerCompany = selectedCompany;

                    pairs[selectedCompany][1] = selectedProgrammer;

                }else{
                    programmers[selectedProgrammer].attemptedPairings[selectedCompany] = true;
                }

            }

        }
        return pairs;
    }

    private static int rankCompare(int[] preferences, int currentPair, int potentialPair) {
        int result = 0;
        int currentRank = -1;
        int potentialRank = -1;
        for(int i = 0; i < preferences.length; i++){
            if(preferences[i] == currentPair){
                currentRank = i;
            }
            if(preferences[i] == potentialPair){
                potentialRank = i;
            }
        }
        //current ranks better than potential
        if(currentRank < potentialRank){
            result = 1;
        }

        //potential ranks better than current
        if(currentRank > potentialRank){
            result = -1;
        }
        //something breaks
        if(currentRank == potentialRank){
            return 0;
        }

        return result;
    }

    private static boolean isFree(int[][] groupList, int company){
        boolean result = true;
        for(int j = 0; j < groupList.length; j++){
            if(groupList[j][1] == company){
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

//while
/*
while(pairsMade < pairCount) {
            parings:
            for (int programmer : freeProgrammers) {
                if (programmer != -1) {
                    int[] preferenceList = programmers[programmer];
                    int preferredCompany = 0;

                    firstPreference:
                    //gets the first non-attempted company
                    for (int preference : preferenceList) {
                        //-1 here means attempted to pair
                        if (preference != -1) {
                            preferredCompany = preference;
                        }
                    }

                        //checks if preferred company is NOT paired
                        if (!(Arrays.binarySearch(pairedCompanies, preferredCompany) > 0)) {
                            pairs[preferredCompany][0] = preferredCompany;
                            pairs[preferredCompany][1] = programmer;
                            freeProgrammers[programmer] = -1;
                            freeCompanies[preferredCompany] = -1;
                            pairsMade++;
                            break parings;
                        } else {
                            if (rankCompare(companies[preferredCompany], pairs[preferredCompany][1], programmer) < 0){
                                freeProgrammers[pairs[preferredCompany][1]] = pairs[preferredCompany][1];
                                pairs[preferredCompany][1] = programmer;
                                freeProgrammers[programmer] = -1;
                            } else{
                                programmers[programmer][Arrays.binarySearch(programmers[programmer],preferredCompany)] = -1;
                            }
                        }
                    //}
                }
            }
            System.out.println("Total pairs: " + pairsMade);
            System.out.println("Current Pairs: " + Arrays.deepToString(pairs));
        }
 */

