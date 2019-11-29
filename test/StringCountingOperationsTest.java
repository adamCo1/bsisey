import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class StringCountingOperationsTest {

    StringCountingOperations specificStringCounter ;

    @Before()
    public void onBefore() {
        specificStringCounter = new StringCountingOperations();
    }

    @Test
    public void countStringOnList() {
        int countOfString = 2;
        String toCount = "da";
        String[] names = new String[]{"Adam", "Bony", "Dama", "Galamda"};
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        for (String name:
                names) {
            listOfAllNames.add(name);
        }

        Assert.assertEquals(countOfString, specificStringCounter.countStringOnList(listOfAllNames, toCount));
    }

    @Test
    public void countStringOnListMixedLocations() {
        int countOfString = 5;
        String toCount = "da";
        String[] names = new String[]{"daAdam", "Bonyda", "Damada", "Galamda"};
        ArrayList<String> listOfAllNames = new ArrayList<String>();
        for (String name:
                names) {
            listOfAllNames.add(name);
        }

        Assert.assertEquals(countOfString, specificStringCounter.countStringOnList(listOfAllNames, toCount));
    }

    @Test
    public void countEmptyList() {
        int countOfString = 0;
        String toCount = "a";
        ArrayList<String> listOfAllNames = new ArrayList<String>();

        Assert.assertEquals(countOfString, specificStringCounter.countStringOnList(listOfAllNames, toCount));
    }

    @Test(expected = NullPointerException.class)
    public void countOnNullList() {
        int countOfString = 0;
        String toCount = "test";
        ArrayList<String> listOfAllNames = null ;

        Assert.assertEquals(countOfString, specificStringCounter.countStringOnList(listOfAllNames, toCount));
    }
}
