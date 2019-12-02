import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class CountAllStringsTest {

    StringNamesOperator allStringsCounter = new StringNamesOperator();

    @Before()
    public void onBefore() {
        allStringsCounter = new StringNamesOperator();
    }

    @Test()
    public void countAllStringSingleName() {
        int lengthCount = 1;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        listOfAllNames.add("adam");
        HashMap<String, Integer> countOfStrings = new HashMap<String, Integer>();
        countOfStrings.put("a",2);
        countOfStrings.put("d",1);
        countOfStrings.put("m",1);

        Assert.assertEquals(countOfStrings, allStringsCounter.countAllStrings(listOfAllNames, lengthCount));
    }

    @Test()
    public void countAllStringOnSingleNameSizeTwo() {
        int lengthCount = 2;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        listOfAllNames.add("adam");
        HashMap<String, Integer> countOfStrings = new HashMap<String, Integer>();
        countOfStrings.put("ad",1);
        countOfStrings.put("da",1);
        countOfStrings.put("am",1);

        Assert.assertEquals(countOfStrings, allStringsCounter.countAllStrings(listOfAllNames, lengthCount));
    }

    @Test()
    public void countAllStringOnSingleNameSizeThree() {
        int lengthCount = 3;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        listOfAllNames.add("adam");
        HashMap<String, Integer> countOfStrings = new HashMap<String, Integer>();
        countOfStrings.put("ada",1);
        countOfStrings.put("dam",1);

        Assert.assertEquals(countOfStrings, allStringsCounter.countAllStrings(listOfAllNames, lengthCount));
    }

    @Test()
    public void countAllStringOnSingleNameWholeLength() {
        int lengthCount = 4;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        listOfAllNames.add("adam");
        HashMap<String, Integer> countOfStrings = new HashMap<String, Integer>();
        countOfStrings.put("adam",1);

        Assert.assertEquals(countOfStrings, allStringsCounter.countAllStrings(listOfAllNames, lengthCount));
    }

    @Test()
    public void countWithMoreThanOneName() {
        int lengthCount = 1;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        listOfAllNames.add("adam");
        listOfAllNames.add("yuval");
        HashMap<String, Integer> countOfStrings = new HashMap<String, Integer>();
        countOfStrings.put("a",3);
        countOfStrings.put("d", 1);
        countOfStrings.put("y", 1);
        countOfStrings.put("u", 1);
        countOfStrings.put("v", 1);
        countOfStrings.put("l", 1);
        countOfStrings.put("m", 1);

        Assert.assertEquals(countOfStrings, allStringsCounter.countAllStrings(listOfAllNames, lengthCount));

    }

    @Test(expected = NullPointerException.class)
    public void countOnNullList() {
        int lengthCount = 1;
        ArrayList<String> listOfAllNames = null ;
        HashMap<String, Integer> countOfStrings = new HashMap<String, Integer>();
        countOfStrings.put("a",2);

        Assert.assertEquals(countOfStrings, allStringsCounter.countAllStrings(listOfAllNames, lengthCount));
    }

    @Test()
    public void countLengthOfZero() {
        int lengthCount = 0;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        HashMap<String, Integer> countOfStrings = new HashMap<String, Integer>();
        listOfAllNames.add("adam");
        listOfAllNames.add("bony");

        Assert.assertEquals(countOfStrings, allStringsCounter.countAllStrings(listOfAllNames, lengthCount));
    }

}