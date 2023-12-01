import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class adventofcode1 {
    public static void main(String[] args) throws Exception {

        // Leemos las líneas del archivo de entrada
        List<String> lines = readLines("input.txt");
        int numeroTotal = 0;
        int contador = 0;

        // Iteramos sobre cada línea
        for (String line : lines) {
            // Obtenemos el primer número de la línea
            int primerNumero = primerNumero(line);
            // Obtenemos el último número de la línea
            int ultimNumero = ultimNumero(line);
            // Sumamos el número formado por el primer y último número a nuestro total
            numeroTotal = numeroTotal + Integer.valueOf(String.valueOf(primerNumero) + String.valueOf(ultimNumero));

            contador = contador + 1;

            System.out.println(contador + " ");

            List<ValorPosicion> llistaValorPosicio = new ArrayList<>();
            llistaValorPosicio = primerNumeroString(line);
            int numeroMesGranString = 0;
            int numeroMesPetitString = 0;
            int major = 0;
            int menor = 0;

            for(int i = 0; i < llistaValorPosicio.size(); i++){
                if (llistaValorPosicio.get(i).getPosicion() > major) {
                    major = llistaValorPosicio.get(i).getPosicion();
                }
            }
            for(ValorPosicion valorPosicion:llistaValorPosicio){
                if(major == valorPosicion.getPosicion()){
                    numeroMesGranString = valorPosicion.getValor();
                    System.out.println("El numero mes gran es" + numeroMesGranString);
                }
            }
            for(int i = 0; i < llistaValorPosicio.size(); i++){
                if (llistaValorPosicio.get(i).getPosicion() < menor) {
                    menor = llistaValorPosicio.get(i).getPosicion();
                }
            }
            for(ValorPosicion valorPosicion:llistaValorPosicio){
                if(menor == valorPosicion.getPosicion()){
                    numeroMesPetitString = valorPosicion.getValor();
                    System.out.println("El numero mes petit es" + numeroMesPetitString);
                }
            }
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
    public static int primerNumero(String linea) {
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
    public static int ultimNumero(String linea) {
        int ultimNumero = 0;
        for (int iterUiltimoNum = linea.length() - 1; iterUiltimoNum >= 0; iterUiltimoNum--) {
            if (Character.isDigit(linea.charAt(iterUiltimoNum))) {
                ultimNumero = Character.getNumericValue(linea.charAt(iterUiltimoNum));
                return ultimNumero;
            }
        }
        return ultimNumero;
    }

    public static List<ValorPosicion> primerNumeroString(String linea) {

        List<String> listaNumerosStrings = listaNumeros();
        List<ValorPosicion> listaValorPosicion = new ArrayList<>();
        for (int i = 0; i < listaNumerosStrings.size(); i++) {
            if (linea.indexOf(listaNumerosStrings.get(i)) >= 0) {
                int valorInciail = valorStringToNumerico(i);
                int posicioValor = linea.indexOf(listaNumerosStrings.get(i));
                ValorPosicion valorPosicion = new ValorPosicion(valorInciail, posicioValor);
                listaValorPosicion.add(valorPosicion);
                System.out.print("valor:" + valorInciail + " Posicio: " + posicioValor + "\n");
            }
        }
        return listaValorPosicion;
    }

    public static int valorStringToNumerico(int num) {
        switch (num) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            default:
                return 0;
        }

    }

    public static String ultimNumeroString(String linea) {
        return "";

    }

    public static List<String> listaNumeros() {
        List<String> listaNumerosStrings = new ArrayList<>();
        listaNumerosStrings.add("one");
        listaNumerosStrings.add("two");
        listaNumerosStrings.add("three");
        listaNumerosStrings.add("four");
        listaNumerosStrings.add("five");
        listaNumerosStrings.add("six");
        listaNumerosStrings.add("seven");
        listaNumerosStrings.add("eight");
        listaNumerosStrings.add("nine");

        return listaNumerosStrings;
    }

    public static class ValorPosicion {
        private int valor;
        private int posicion;

        public ValorPosicion(int valor, int posicion) {
            this.valor = valor;
            this.posicion = posicion;
        }

        public int getValor() {
            return valor;
        }

        public int getPosicion() {
            return posicion;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }

        public void setPosicion(int posicion) {
            this.posicion = posicion;
        }
    }

}