import java.util.Scanner;
class TexQuote {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        StringBuilder inputBuilder = new StringBuilder(input);
        char abrir = '`';
        char cerrar = '\'';
        char[] output;
        int contador = 0;
        int j = 0;
        int k = 0;
        boolean aumentar = false;
        boolean isOpen = false;
        String salida;

        for (int i = 0; i < inputBuilder.length(); i++) {
            if (inputBuilder.charAt(i) == '"') {
                contador++;
            }
        }
        output = new char[inputBuilder.length() + (contador)];

        for (int i = 0; i < inputBuilder.length(); i++ ) {
            if(aumentar) {
                j = i + k;
            } else {
                j = i;
            }
            if (inputBuilder.charAt(i) == '"') {
                ++k;
                if(isOpen) {
                    output[j] = cerrar;
                    output[j+1] = cerrar;
                    isOpen = false;
                } else {
                    output[j] = abrir;
                    output[j+1] = abrir;
                    isOpen = true;
                }
                aumentar = true;
            } else {
                output[j] = inputBuilder.charAt(i);
            }
        }
        salida = new String(output);
        System.out.print(salida);

    }
}
