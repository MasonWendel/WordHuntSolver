import java.util.*; 
import java.io.*; 

public class BootUp {
    public static Set<String> loadDict() {
        Set<String> words = new LinkedHashSet(); 
        try{
            BufferedReader br = new BufferedReader(new FileReader("Dict.txt")); 
            String line;
            while((line = br.readLine()) != null) words.add(line);
            br.close();
        } catch(Exception e){}
        return words;
    } 
}


