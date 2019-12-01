
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NameListing {

final String namesURL = "https://www.behindthename.com/names/usage/english";

    /**
     * @return a list of legal English names starting with capital letter and no duplicates
     */
    public ArrayList<String> getNames(){
        String HTMLContent = "";
        ArrayList<String> rawNames = new ArrayList<>();
        for(int i = 1 ; i <= 14 ; i ++){
            rawNames.addAll(getNamesFromTags(namesURL+"/"+i));
        }
        ArrayList<String>ans = new ArrayList<String>();
        ans.addAll(processNames(rawNames));
        return ans;
    }


    private List<String> getNamesFromTags(String url){
        List<String> names = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements namesDivs = doc.select("div.browsename");
            for (Element nameDiv:namesDivs) {
                String name = nameDiv.select("span.listname").select("a").text();
                names.add(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    private Set<String> processNames(List<String> names){
        Set<String> processedNames = new TreeSet<>();
        for (String name:names) {
            String [] nameProperty = name.split(" ");
            String cleanedName = nameProperty[0];
            cleanedName = cleanedName.substring(0,1).toUpperCase()+cleanedName.substring(1).toLowerCase();
            processedNames.add(cleanedName);
        }
        return processedNames;
    }
}
