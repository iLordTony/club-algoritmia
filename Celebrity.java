import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		String output = "";
		while ((line = bf.readLine()) != null && line.length() != 0) {
			output += line + "\n";
		}
		System.out.print(output);
	}
	// MAlloc
}
