import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class CostCutting {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ArrayList<String> input = new ArrayList<String>();
        ArrayList<Integer> output = new ArrayList<Integer>();
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
            int[] array = new int[3];
            array[0] = Integer.parseInt(data.split(" ")[0]);
            array[1] = Integer.parseInt(data.split(" ")[1]);
            array[2] = Integer.parseInt(data.split(" ")[2]);
            Arrays.sort(array);
            output.add(array[1]);
        }
        for (int i = 1; i <= output.size(); i++) {
            System.out.println("Case " + i + ": " + output.get(i-1));
        }
    }
}
