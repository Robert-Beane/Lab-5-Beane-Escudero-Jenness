import java.util.Arrays;

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

    public String toString(){
        String asString = Arrays.toString(preferences);
        return asString;
    }

}
