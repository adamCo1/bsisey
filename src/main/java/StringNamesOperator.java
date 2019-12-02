import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class StringNamesOperator {

    private HashMap<String, Integer> countOfStrings;
    private int maxCount = 0;

    public StringNamesOperator() {
        initializeCountMap();
    }

    public int countSpecificString(ArrayList<String> listOfAllNames, String stringToCount) throws NullPointerException{
        int countOfString = 0;
        for (String name:
             listOfAllNames) {
            countOfString += countInCommon(name, stringToCount);
        }
        return countOfString;
    }

    private int countInCommon(String name, String stringToCount) {
        int stringIndex = name.indexOf(stringToCount);
        int count = (stringIndex >= 0) ? 1 : 0 ;
        return count;
    }

    public HashMap<String, Integer> countAllStrings(ArrayList<String> listOfAllNames, int lengthToCount) throws NullPointerException{
        initializeCountMap();
        if(lengthToCount > 0){
            for (String name:
                    listOfAllNames) {
                fillCountBySubstrings(name, lengthToCount);
            }
        }

        return countOfStrings;
    }

    private void fillCountBySubstrings(String name, int lengthToCount) {
        HashSet<String> allSubStrings = getAllSubStrings(name, lengthToCount);
        for (String substring:
                allSubStrings) {
            fillCount(name, substring);
        }
    }

    private HashSet<String> getAllSubStrings(String string, int subStringLength) {
        HashSet<String> allSubStrings = new HashSet<String>();
        int currentLocation = 0 , locationAdvance = 1 ;

        while(currentLocation < string.length()){
            if(currentLocation + subStringLength < string.length()+1) {
                allSubStrings.add(string.substring(currentLocation, currentLocation + subStringLength));
            }
            currentLocation += locationAdvance ;
        }
        return allSubStrings;
    }

    private void fillCount(String name, String stringToCount) {
        int count = StringUtils.countMatches(name, stringToCount);
        insert(stringToCount, count);
    }

    private void insert(String stringToCount, int count){
        try {
            int stringCount = this.countOfStrings.get(stringToCount);
            this.countOfStrings.put(stringToCount, stringCount + count);
        }catch (NullPointerException e){
            this.countOfStrings.put(stringToCount, count);
        }
    }

    public ArrayList<String> countMaxString(ArrayList<String> listOfNames, int length) throws NullPointerException {
        listOfNames = getListWithoutCapitals(listOfNames);
        ArrayList<String> allMatchingStrings = new ArrayList<String>();
        HashMap<String, Integer> wantedLengthNames = new HashMap<String, Integer>();
        this.countAllStrings(listOfNames, length);
        wantedLengthNames = this.getMapAllStringsOfSize(length);
        allMatchingStrings = this.getMaxCountStrings(wantedLengthNames);
        return allMatchingStrings;
    }

    private ArrayList<String> getListWithoutCapitals(ArrayList<String> listOfNames){
        ArrayList<String> listWithoutCapitals = new ArrayList<>();
        for (String name:
             listOfNames) {
            listWithoutCapitals.add(name.toLowerCase());
        }
        return listWithoutCapitals;
    }

    private HashMap<String, Integer> getMapAllStringsOfSize(int length) {
        HashMap<String, Integer> namesOfSameSize = new HashMap<String, Integer>();
        Iterator<Map.Entry<String, Integer>> namesIterator = this.countOfStrings.entrySet().iterator();
        while(namesIterator.hasNext()) {
            Map.Entry<String, Integer> entry = namesIterator.next();
            String currentName = entry.getKey();
            int numberOfOccurrences = entry.getValue();
            if(currentName.length() == length){
                namesOfSameSize.put(currentName, entry.getValue());
                checkMaxCount(numberOfOccurrences);
            }
        }
        return namesOfSameSize;
    }

    private ArrayList<String> getMaxCountStrings(HashMap<String,Integer> namesMap) {
        ArrayList<String> maxOccurredNames = new ArrayList<String>();
        Iterator<Map.Entry<String, Integer>> iterator = namesMap.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            String name = entry.getKey();
            int occurrencesCount = entry.getValue();
            if(occurrencesCount == this.maxCount){
                maxOccurredNames.add(name);
            }
        }
        return maxOccurredNames;
    }

    private void checkMaxCount(int count) {
        if(count > this.maxCount){
            this.maxCount = count;
        }
    }

    public ArrayList<String> allIncludesString(ArrayList<String> listOfNames, String pattern)throws NullPointerException {
        listOfNames = getListWithoutCapitals(listOfNames);
        ArrayList<String> foundNames = new ArrayList<String>();
        for (String name:
             listOfNames) {
            if(nameInPattern(name, pattern)){
                foundNames.add(name);
            }
        }
        return foundNames;
    }

    private boolean nameInPattern(String name, String pattern){
        int startingIndex = pattern.indexOf(name);
        return startingIndex != -1 ;
    }

    private void initializeCountMap() {
        this.countOfStrings = new HashMap<String, Integer>();
    }

}
