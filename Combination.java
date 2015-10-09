import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class Main {
	static public final int horario = 1;
	static public final int antiHorario = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<Integer> output = new ArrayList<Integer>();

		while ((line = bf.readLine()) != null && line.length() != 0) {
			if (line.equals("0 0 0 0")) {
				break;
			}
			input.add(line);
		}

		for(String data: input) {
			int valor = 1080;

			valor += magia(0, 1, data);
			output.add(valor);
		}

		for(int data : output)
			System.out.println(data);
	}

	public static int magia(int i, int j, String data) {
		int sentido = 0;
		if (i<=2 && j<=3) {
			if(i == 0 || i == 2) {
				sentido = 1;
			}
			int valor = comparaValores(Integer.parseInt(data.split(" ")[i]), Integer.parseInt(data.split(" ")[j]), sentido);
			++i;
			++j;
			return valor + magia(i, j, data);
		}
		return 0;
	}

	public static int comparaValores(int numero1, int numero2, int sentido) {
		if (numero1 < numero2) {
			if (sentido == horario)
				return horarioMayor(numero1, numero2);
			else
				return horarioMenor(numero2, numero1);
		} else if (numero2 < numero1) {
			if (sentido == horario)
				return horarioMenor(numero1, numero2);
			else
				return horarioMayor(numero2, numero1);
		} else
			return 0;
	}

	public static int horarioMayor(int numero1, int numero2) {
		return (40 - (numero2 - numero1)) * 9;
	}

	public static int horarioMenor(int numero1, int numero2) {
		return (numero1 - numero2) * 9;
	}

}
