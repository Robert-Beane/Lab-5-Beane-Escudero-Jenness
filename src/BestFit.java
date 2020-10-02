import java.util.Arrays;

public class BestFit {
    public static int[][] stableMatch(Programmer[] programmers, Company[] companies, int pairCount){
        int pairsMade = 0;
        int[][] pairs = new int[pairCount][2];

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

}
