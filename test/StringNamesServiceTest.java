import org.junit.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import static org.mockito.Mockito.*;

public class StringNamesServiceTest {


    StringNamesOperator mockedOperator = Mockito.mock(StringNamesOperator.class);
    StringNamesService stringNamesService = new StringNamesService(mockedOperator);

    @Test()
    public void callSpecificStringMethod() throws Exception{
        String[] input = new String[]{"CountSpecificString", "test"} ;
        stringNamesService.performOnNames(input);
        verify(mockedOperator).countSpecificString((ArrayList<String>) anyObject(), anyString());
    }

    @Test
    public void callAllStringsCounterMethod() throws Exception{
        String[] input = new String[]{"CountAllStrings", "5"} ;
        stringNamesService.performOnNames(input);
        verify(mockedOperator).countAllStrings((ArrayList<String>) anyObject(), anyInt());
    }

    @Test
    public void callCountMaxStringMethod() throws Exception{
        String[] input = new String[]{"CountMaxString", "2"} ;
        stringNamesService.performOnNames(input);
        verify(mockedOperator).countMaxString((ArrayList<String>) anyObject(), anyInt());
    }

    @Test
    public void callAllIncludesStringsMethod() throws Exception{
        String[] input = new String[]{"AllIncludesString", "2"} ;
        stringNamesService.performOnNames(input);
        verify(mockedOperator).allIncludesString((ArrayList<String>) anyObject(), anyString());
    }

    @Test(expected = NullPointerException.class)
    public void checkInvalidArrayInput() throws Exception {
        String[] input = null;
        stringNamesService.performOnNames(input);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkNoVariable() throws Exception{
        String[] input = new String[]{"doesntExistName"};
        stringNamesService.performOnNames(input);
    }
}