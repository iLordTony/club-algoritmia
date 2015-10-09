import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
//Siempre se llamar a la clase Main
class TexQuote {
    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        char openCharacter = '`';
        char closeCharacter = '\'';
        char[] outputArray;
        int counter = 0;
        int j = 0;
        int k = 0;
        boolean increase = false;
        boolean isOpen = false;

        String output;
        String input = "";
        String line;

        try {
            while((line = stdin.readLine()) != null && line.length() != 0) {
                input += line + "\n";
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '"') {
                counter++;
            }
        }

        outputArray = new char[input.length() + counter];

        for (int i = 0; i < input.length(); i++ ) {
            if(increase) {
                j = i + k;
            } else {
                j = i;
            }

            if (input.charAt(i) == '"') {
                ++k;

                if(isOpen) {
                    outputArray[j] = closeCharacter;
                    outputArray[j+1] = closeCharacter;
                    isOpen = false;
                } else {
                    outputArray[j] = openCharacter;
                    outputArray[j+1] = openCharacter;
                    isOpen = true;
                }
                increase = true;
            } else {
                outputArray[j] = input.charAt(i);
            }
        }
        output = new String(outputArray);
        System.out.print(output);
    }
}
