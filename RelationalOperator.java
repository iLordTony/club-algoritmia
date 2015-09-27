import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class RelationalOperator {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a, b, c;
        int longitud = 0;
        String line;
        ArrayList<String> content = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();

        try {
            while ((line = br.readLine()) != null && line.length() != 0) {
                if (longitud <= 0) {
                    longitud = stringToInt(line);
                    if (longitud > 15) {
                        break;
                    }
                } else {
                    if (valorAbsoluto(line)) {
                        break;
                    }
                    content.add(line);
                    --longitud;
                }
                if (longitud <= 0) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < content.size(); i++) {
            a = stringToInt(content.get(i).split(" ")[0]);
            b = stringToInt(content.get(i).split(" ")[1]);
            c = a - b;

            if (c > 0) {
                output.add(">");
            }else if (c < 0) {
                output.add("<");
            } else {
                output.add("=");
            }
        }

        for (String result : output) {
            System.out.println(result);
        }
    }

    public static boolean valorAbsoluto(String line) {
        return (calcularAbsoluto(line.split(" ")[0]) > 1000000001) || (calcularAbsoluto(line.split(" ")[1]) > 1000000001);
    }

    public static int stringToInt(String line) {
        return Integer.parseInt(line);
    }

    public static int calcularAbsoluto(String line) {
        return Math.abs(stringToInt(line));
    }

}
