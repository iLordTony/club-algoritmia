import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class Combination {
	static public final int horario = 1;
	static public final int antiHorario = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<Integer> output = new ArrayList<Integer>();

		while ((line = bf.readLine()) != null && line.length() != 0 && !line.equals("0 0 0 0")) {
			input.add(line);
		}

		for(String data: input) {
			int valor = 1080;

			int inicio = castear(data, 0);
			int clave1 = castear(data, 1);
			int clave2 = castear(data, 2);
			int clave3 = castear(data, 3);

			valor += comparaValores(inicio, clave1, horario);
			valor += comparaValores(clave1, clave2, antiHorario);
			valor += comparaValores(clave2, clave3, horario);

			output.add(valor);
		}

		for(int data : output)
			System.out.println(data);
	}

	public static int castear(String data, int position) {
		return Integer.parseInt(data.split(" ")[position]);
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
