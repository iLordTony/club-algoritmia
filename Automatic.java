import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Automatic {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ArrayList<String> input = new ArrayList<String>();
    ArrayList<Character> output = new ArrayList<Character>();
    int numero = 0;
		while ((line = bf.readLine()) != null && line.length() != 0) {
			if(numero <= 0) {
        numero = Integer.parseInt(line);
      } else {
        input.add(line);
        --numero;
      }
      if (numero <= 0) {
          break;
      }
		}
    for (String data : input) {
      String valor = String.valueOf((Integer.parseInt(data) * 315) + 36962);
      output.add(valor.charAt(valor.length() - 2));
    }
    for(char res : output) {
      System.out.println(res);
    }
	}
	// MAlloc
}
