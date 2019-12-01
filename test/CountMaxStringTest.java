import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CountMaxStringTest {

    StringNamesOperator maxStringCounter = new StringNamesOperator();

    @Before()
    public void onBefore() {
        maxStringCounter = new StringNamesOperator();
    }

    @Test()
    public void countMaxStringSingleName() {
        int stringLength = 4 ;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        expectedNames.add("adam");
        listOfAllNames.add("adam");

        Assert.assertEquals(expectedNames, maxStringCounter.countMaxString(listOfAllNames, stringLength));
    }

    @Test()
    public void countMaxStringEmptyList() {
        int stringLength = 4 ;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();

        Assert.assertEquals(expectedNames, maxStringCounter.countMaxString(listOfAllNames, stringLength));
    }

    @Test()
    public void countMaxStringMixedSizes() {
        int stringLength = 3 ;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        listOfAllNames.add("ada");
        listOfAllNames.add("baba");
        listOfAllNames.add("kdif");
        listOfAllNames.add("ada");
        listOfAllNames.add("vvvv");
        listOfAllNames.add("ada");
        expectedNames.add("ada");

        Assert.assertEquals(expectedNames, maxStringCounter.countMaxString(listOfAllNames, stringLength));
    }

    @Test()
    public void countMaxStringNormal() {
        int stringLength = 2 ;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        listOfAllNames.add("ab");
        listOfAllNames.add("ab");
        listOfAllNames.add("vv");
        expectedNames.add("ab");

        Assert.assertEquals(expectedNames, maxStringCounter.countMaxString(listOfAllNames, stringLength));
    }

    @Test()
    public void countMaxStringSizeDontExist() {
        int stringLength = 1 ;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        listOfAllNames.add("ab");
        listOfAllNames.add("ab");
        listOfAllNames.add("vvv");
        expectedNames.add("v");

        Assert.assertEquals(expectedNames, maxStringCounter.countMaxString(listOfAllNames, stringLength));
    }

    @Test()
    public void countMaxStringWithSameSize() {
        int stringLength = 2 ;
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        listOfAllNames.add("ab");
        listOfAllNames.add("ab");
        listOfAllNames.add("vv");
        listOfAllNames.add("vv");
        listOfAllNames.add("k");
        listOfAllNames.add("ab");
        listOfAllNames.add("vv");
        listOfAllNames.add("ioio");
        expectedNames.add("vv");
        expectedNames.add("ab");

        Assert.assertEquals(expectedNames, maxStringCounter.countMaxString(listOfAllNames, stringLength));
    }

    @Test(expected = NullPointerException.class)
    public void countMaxStringOnNull() {
        int maxLength = 2;
        ArrayList<String> expectedNames = new ArrayList<String>();
        Assert.assertEquals(expectedNames, maxStringCounter.countMaxString(null, maxLength));
    }
}
