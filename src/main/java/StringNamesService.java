import java.util.ArrayList;

public class StringNamesService {

    private int functionNameIndex = 0 , variableIndex = 1 ;
    private StringNamesOperator operator;
    private ArrayList<String> listOfNames = new ArrayList<>();

    public StringNamesService(StringNamesOperator operator) {
        this.operator = operator;
        getListOfNames();
    }

    public void performOnNames(String[] action) throws Exception {

        try{
            String functionName = getVariable(action, functionNameIndex);
            String functionArgument = getVariable(action, variableIndex);
            if(functionName.equals("CountSpecificString")){
                this.operator.countSpecificString(listOfNames, functionArgument);
            }else if(functionName.equals("CountAllStrings")){
                this.operator.countAllStrings(listOfNames, Integer.parseInt(functionArgument));
            }else if(functionName.equals("CountMaxString")){
                this.operator.countMaxString(listOfNames,Integer.parseInt(functionArgument));
            }else if(functionName.equals("AllIncludesString")){
                this.operator.allIncludesString(listOfNames, functionArgument);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw e ;
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
