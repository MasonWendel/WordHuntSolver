import java.util.*; 
import java.io.*; 

public class BootUp {
    public static Set<String> loadDict() { // Reads in the Dict file and puts in data structure
        System.out.println("Booting Up ...");
        Set<String> words = new LinkedHashSet(); // Set is memory efficient both in storage and in access
        try{
            BufferedReader br = new BufferedReader(new FileReader("Dict.txt")); // using buffered reader bc Scanner is inefficient and slow
            String line;
            while((line = br.readLine()) != null) words.add(line.toLowerCase()); // adding words to set
            br.close();
        } catch(Exception e){}
        System.out.println("Successful Boot!\n");
        return words;
    } 
}


