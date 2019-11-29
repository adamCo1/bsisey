import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CountAllStrings {

    public static void main(String[] args) {
        int lengthCount = 1;
        StringCountingOperations allStringsCounter = new StringCountingOperations();
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        listOfAllNames.add("adam");
        HashMap<String, Integer> countOfStrings = new HashMap<String, Integer>();
        countOfStrings.put("ad",1);
        countOfStrings.put("da",1);
        countOfStrings.put("am",1);
        HashMap<String, Integer> stringCounts = allStringsCounter.countAllStrings(listOfAllNames, lengthCount);
        printAnswer(stringCounts);
    }

    private static void printAnswer(HashMap<String, Integer> stringCounts) {
        Iterator<Map.Entry<String, Integer>> stringCountsIterator = stringCounts.entrySet().iterator();
        while(stringCountsIterator.hasNext()) {
            Map.Entry<String, Integer> entry = stringCountsIterator.next();
            String name = entry.getKey();
            int count = entry.getValue();

            System.out.println(name + ":" + count);
        }
    }

}
