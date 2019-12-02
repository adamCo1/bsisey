import java.lang.reflect.Array;
import java.util.*;

public class StringNamesService {

    private int functionNameIndex = 0 , variableIndex = 1 ;
    private StringNamesOperator operator;
    private ArrayList<String> listOfNames = new ArrayList<>();

    public StringNamesService(StringNamesOperator operator) {
        this.operator = operator;
        getListOfNames();
    }

    public void performOnNames(String[] action) throws Exception {
        ArrayList<String> countList ;
        HashMap<String, Integer> countmap ;
        int count = 0;
        try{
            String functionName = getVariable(action, functionNameIndex);
            String functionArgument = getVariable(action, variableIndex);
            if(functionName.equals("CountSpecificString")){
                count = this.operator.countSpecificString(listOfNames, functionArgument);
                print(count);
            }else if(functionName.equals("CountAllStrings")){
                countmap = this.operator.countAllStrings(listOfNames, Integer.parseInt(functionArgument));
                print(countmap);
            }else if(functionName.equals("CountMaxString")){
                countList = this.operator.countMaxString(listOfNames,Integer.parseInt(functionArgument));
                print(countList);
            }else if(functionName.equals("AllIncludesString")){
                countList = this.operator.allIncludesString(listOfNames, functionArgument);
                print(countList);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e ;
        }
    }

    private void print(ArrayList<String> answerList) {
        for (String answer:
             answerList) {
            System.out.println(answer);
        }
    }

    private void print(int count){
        System.out.println(count);
    }

    private void print(HashMap<String, Integer> countMap){
        Iterator<Map.Entry<String, Integer>> iterator = countMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    private String getVariable(String[] fromArray, int atIndex) throws Exception{
        String variable ;
        try{
            variable = fromArray[atIndex];
        }catch (Exception e){
            throw e;
        }

        return variable;
    }



    private void getListOfNames() {
        NameListing nameListing = new NameListing();
        this.listOfNames = nameListing.getNames();
    }
}
