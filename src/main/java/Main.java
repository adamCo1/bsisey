
public class Main {

    public static void main(String[] args) {
        try{
            StringNamesOperator operator = new StringNamesOperator();
            StringNamesService namesService = new StringNamesService(operator);
            namesService.performOnNames(args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
