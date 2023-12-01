import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List; 
import java.util.ArrayList;

public class adventofcode1 {
    public static void main(String[] args) throws Exception {
        // Leemos las líneas del archivo de entrada
        List<String> lines = readLines("input.txt");
        int numeroTotal = 0;
        // Iteramos sobre cada línea
        for (String line : lines) {
            // Obtenemos el primer número de la línea
            int primerNumero = primerNumero(line);
            // Obtenemos el último número de la línea
            int ultimNumero = ultimNumero(line);
            // Sumamos el número formado por el primer y último número a nuestro total
            numeroTotal = numeroTotal + Integer.valueOf(String.valueOf(primerNumero) + String.valueOf(ultimNumero));
        }
        System.out.println("Numero total: " + numeroTotal);
    }

    // Método para leer las líneas de un archivo
    public static List<String> readLines(String filename) throws Exception {
        InputStream ins = new FileInputStream(filename);
        List<String> lines = new ArrayList<>();
        try (Scanner obj = new Scanner(ins)) {
            while (obj.hasNextLine())
                lines.add(obj.nextLine());
        }
        return lines;
    }

    // Método para obtener el primer número de una cadena
    public static int primerNumero(String linea){
        int primerNumero = 0;
        for (int iterPrimerNum = 0; iterPrimerNum < linea.length(); iterPrimerNum++) {
            if (Character.isDigit(linea.charAt(iterPrimerNum))) {
                primerNumero = Character.getNumericValue(linea.charAt(iterPrimerNum));
                return primerNumero;
            }
        }
        return primerNumero;
    }

    // Método para obtener el último número de una cadena
    public static int ultimNumero(String linea){
        int ultimNumero = 0;
        for (int iterUiltimoNum = linea.length()-1; iterUiltimoNum >=0; iterUiltimoNum--) {
            if (Character.isDigit(linea.charAt(iterUiltimoNum))) {
                ultimNumero = Character.getNumericValue(linea.charAt(iterUiltimoNum));
                return ultimNumero;
            }
        }
        return ultimNumero;
    }
}