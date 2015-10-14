import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class LanguageDetection {
    static public final String UNKNOW = "UNKNOWN";
    static public final String ENGLISH = "ENGLISH";
    static public final String SPANISH = "SPANISH";
    static public final String GERMAN = "GERMAN";
    static public final String FRENCH = "FRENCH";
    static public final String ITALIAN = "ITALIAN";
    static public final String RUSSIAN = "RUSSIAN";

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String line;
        ArrayList<String> output = new ArrayList<String>();
        while ((line = bf.readLine()) != null && line.length() != 0 && !line.equals("#")) {
            if(line.equals("HELLO"))
                output.add(ENGLISH);
            else if(line.equals("HOLA"))
                output.add(SPANISH);
            else if(line.equals("HALLO"))
                output.add(GERMAN);
            else if(line.equals("BONJOUR"))
                output.add(FRENCH);
            else if(line.equals("CIAO"))
                output.add(ITALIAN);
            else if(line.equals("ZDRAVSTVUJTE"))
                output.add(RUSSIAN);
            else
                output.add(UNKNOW);
        }

        for (int i = 1; i <= output.size() ; i++) {
            System.out.println("Case " + i + ": " + output.get(i-1));
        }
    }
}
