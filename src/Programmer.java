public class Programmer {
    public boolean paired; //are they paired with a company
    public int partnerCompany;
    public int[] preferences;
    public boolean[] attemptedPairings;

    public Programmer(int[] rankings){
        preferences = rankings;
        paired = false;
        attemptedPairings = new boolean[preferences.length];
    }

//    public boolean hasBeenAttempted(int company){
//        boolean result = false;
//        for(int i = 0; i < preferences.length; i++){
//            if(company == failedPairings[i]){
//
//            }
//        }
//        return result;
//    }

}
