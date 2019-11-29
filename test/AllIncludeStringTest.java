import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class AllIncludeStringTest {

    StringCountingOperations includeNames ;

    @Before()
    public void onBefore() {
        includeNames = new StringCountingOperations();
    }

    @Test()
    public void allIncludeSingleName(){
        String pattern = "madamkgddassafbfg";
        ArrayList<String> listOfNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        listOfNames.add("adam");
        expectedNames.add("adam");

        Assert.assertEquals(expectedNames, includeNames.allIncludesString(listOfNames, pattern));
    }

    @Test()
    public void AllIncludesSingleNameOnEnd() {
        String pattern = "kgddassafbfgadam";
        ArrayList<String> listOfNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        listOfNames.add("adam");
        expectedNames.add("adam");

        Assert.assertEquals(expectedNames, includeNames.allIncludesString(listOfNames, pattern));
    }

    @Test()
    public void AllIncludesSingleNameOnStart() {
        String pattern = "adamkgddassafbfg";
        ArrayList<String> listOfNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        listOfNames.add("adam");
        expectedNames.add("adam");

        Assert.assertEquals(expectedNames, includeNames.allIncludesString(listOfNames, pattern));
    }

    @Test()
    public void allIncludeMixed(){
        String pattern = "adamkgddassafbfg";
        ArrayList<String> listOfNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();
        listOfNames.add("adam");
        listOfNames.add("assaf");
        expectedNames.add("adam");
        expectedNames.add("assaf");

        Assert.assertEquals(expectedNames, includeNames.allIncludesString(listOfNames, pattern));
    }

    @Test()
    public void allIncludeInputPatternEmpty() {
        String pattern = "";
        ArrayList<String> listOfNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();

        Assert.assertEquals(expectedNames, includeNames.allIncludesString(listOfNames, pattern));
    }


    @Test()
    public void allIncludeInputListEmpty() {
        String pattern = "dsadsada";
        ArrayList<String> listOfNames = new ArrayList<String>();
        ArrayList<String> expectedNames = new ArrayList<String>();

        Assert.assertEquals(expectedNames, includeNames.allIncludesString(listOfNames, pattern));
    }


    @Test(expected = NullPointerException.class)
    public void allIncludeInputNull() {
        String pattern = "dsadsada";
        ArrayList<String> listOfNames = null;
        ArrayList<String> expectedNames = new ArrayList<String>();

        Assert.assertEquals(expectedNames, includeNames.allIncludesString(listOfNames, pattern));
    }


}
