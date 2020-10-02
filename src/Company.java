import java.util.Arrays;

public class Company {
    boolean paired;
    public int[] preferences;
    int partnerProgrammer;

    public Company(int[] rankings){
        preferences = rankings;
        paired = false;
    }


    public int challenge(int challenger) {
        int partnerRank = getRank(partnerProgrammer);
        int challengerRank = getRank(challenger);

        //lower rank means higher preference
        if(challenger < partnerProgrammer){
            return 1;
        }
        if(partnerProgrammer < challenger){
            return -1;
        }
        //if it returns 0, we will have a bad time
        return 0;
    }

    public int getRank(int programmer){
        for(int i = 0; i < preferences.length; i++){
            if(programmer == preferences[i]){
                return i;
            }
        }
        return -1;
    }

    public String toString(){
        String asString = Arrays.toString(preferences);
        return asString;
    }
}
