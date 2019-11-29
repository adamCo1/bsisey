import java.util.ArrayList;

public class CountSpecificString {

    public static void main(String[] args) {
        String stringToCount = "ad";
        ArrayList<String> listOfAllNames = getListOfAllNames();
        StringCountingOperations specificStringCounter = new StringCountingOperations();
        specificStringCounter.countStringOnList(listOfAllNames, stringToCount);
    }

    private static ArrayList<String> getListOfAllNames() {
        return new ArrayList<String>();
    }
}
