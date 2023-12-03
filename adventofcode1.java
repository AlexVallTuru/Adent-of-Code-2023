import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import javax.swing.text.Position;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class adventofcode1 {
    public static void main(String[] args) throws Exception {

        // Leemos las líneas del archivo de entrada
        List<String> lines = readLines(
                "C:\\Users\\Alex\\Documents\\Develop\\AdventOfCode\\Adent-of-Code-Day1\\input.txt");
        int numeroTotal = 0;
        int numeroTotalString = 0;
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

            List<ValorPosicion> llistaValorPosicio = new ArrayList<>();
            llistaValorPosicio = primerNumeroString(line);
            // Obtenemos el primer y ultimo numero de la linea
            int numeroMesGranString = obtenirGran(llistaValorPosicio);
            int numeroMesPetitString = ObtenirPetit(llistaValorPosicio);

            // Souts para mostrar los numeros selecionados para cada ronda
            /*
             * System.out.println("\nNumero posicion primera P2: " + numeroMesPetitString);
             * System.out.println("Numero posicion ultima P2: " + numeroMesGranString +
             * "\n");
             * 
             * 
             * int numeroDeRonda = Integer
             * .valueOf(String.valueOf(numeroMesPetitString) +
             * String.valueOf(numeroMesGranString));
             * 
             * System.out.println("Num Concadenado P2: " + numeroDeRonda);
             * System.out.println("\n---------------------------------------------");
             */

            numeroTotalString = numeroTotalString
                    + Integer.valueOf(String.valueOf(numeroMesPetitString) + String.valueOf(numeroMesGranString));
        }
        System.out.println("Numero total P1: " + numeroTotal);
        System.out.println("Numero total P2: " + numeroTotalString);
    }

    // Metodo para obterner el ultimo numero del string de la parte 2
    public static int obtenirGran(List<ValorPosicion> llistaValorPosicio) {
        int numeroMesGranString = 0;
        int major = 0;

        // Obtenim el ultim numero de la linea que estem recorrent.
        for (int i = 0; i < llistaValorPosicio.size(); i++) {
            if (llistaValorPosicio.get(i).getPosicion() >= major) {
                major = llistaValorPosicio.get(i).getPosicion();
                numeroMesGranString = llistaValorPosicio.get(i).getValor();
            }
        }
        return numeroMesGranString;
    }

    // Metodo para obterner el primer numero del string de la parte 2
    public static int ObtenirPetit(List<ValorPosicion> llistaValorPosicio) {
        int numeroMesPetitString = 0;
        int menor = 0;
        int entrador = -1;

        // Obtenim el primer numero de la linea que estem recorrent.
        for (int i = 0; i < llistaValorPosicio.size(); i++) {
            if (entrador == -1) {
                menor = llistaValorPosicio.get(i).getPosicion();
                numeroMesPetitString = llistaValorPosicio.get(i).getValor();
                entrador = 0;
            } else if (llistaValorPosicio.get(i).getPosicion() <= menor) {
                menor = llistaValorPosicio.get(i).getPosicion();
                numeroMesPetitString = llistaValorPosicio.get(i).getValor();
            }
        }

        return numeroMesPetitString;
    }

    // Método para obtener el primer número de una cadena. Parte 1
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

    // Método para obtener el último número de una cadena. Parte 1
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

    // Funcion para encontrar el valor y la posicion de los numeros String de la
    // primera linea .
    public static List<ValorPosicion> encontrarValorPosicionPrimeraLinea(String linea,
            List<String> listaNumerosStrings) {
        List<ValorPosicion> listaValorPosicion = new ArrayList<>();
        for (int i = 0; i < listaNumerosStrings.size(); i++) {
            int contador = linea.indexOf(listaNumerosStrings.get(i));
            while (contador >= 0) {
                int valorInicial = valorStringToNumerico(i);
                ValorPosicion valorPosicion = new ValorPosicion(valorInicial, contador);
                listaValorPosicion.add(valorPosicion);
                contador = linea.indexOf(listaNumerosStrings.get(i), contador + 1);
            }
        }
        return listaValorPosicion;
    }

    // Funcion para encontrar el valor y la posicion de la primera posicion de la
    // primera linea .
    public static List<ValorPosicion> encontrarValorPosicionPrimerNumero(String linea,
            List<String> listaNumerosStrings) {
        List<ValorPosicion> listaValorPosicion = new ArrayList<>();
        for (int i = 0; i <= listaNumerosStrings.size(); i++) {
            int contador = linea.indexOf(String.valueOf(i));
            while (contador >= 0) {
                ValorPosicion valorPosicion = new ValorPosicion(i, contador);
                listaValorPosicion.add(valorPosicion);
                contador = linea.indexOf(i, contador + 1);
            }
        }
        return listaValorPosicion;
    }

    // Funcion para encontrar el valor y la posicion de la ultima posicion de la
    // primera linea .
    public static List<ValorPosicion> encontrarValorPosicionUltimoNumero(String linea,
            List<String> listaNumerosStrings) {
        List<ValorPosicion> listaValorPosicion = new ArrayList<>();
        for (int i = 0; i <= listaNumerosStrings.size(); i++) {
            int contador = linea.lastIndexOf(String.valueOf(i));
            while (contador >= 0) {
                ValorPosicion valorPosicion = new ValorPosicion(i, contador);
                listaValorPosicion.add(valorPosicion);
                contador = linea.lastIndexOf(i, contador + 1);
            }
        }
        return listaValorPosicion;
    }

    public static List<ValorPosicion> primerNumeroString(String linea) {
        List<String> listaNumerosStrings = listaNumeros();
        List<ValorPosicion> listaValorPosicion = new ArrayList<>();
        listaValorPosicion.addAll(encontrarValorPosicionPrimeraLinea(linea, listaNumerosStrings));
        listaValorPosicion.addAll(encontrarValorPosicionPrimerNumero(linea, listaNumerosStrings));
        listaValorPosicion.addAll(encontrarValorPosicionUltimoNumero(linea, listaNumerosStrings));
        return listaValorPosicion;
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