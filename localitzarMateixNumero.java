import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import javax.swing.text.Position;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class localitzarMateixNumero {
    public static void main(String[] args) {
        String numero = "five";
        String linea = "sdpgz3five4seven6fiveh";
        int contador = 0;
        contador = linea.indexOf(numero);
        while (contador >= 0) {
            System.out.println(contador);
            contador = linea.indexOf(numero, contador + 1);
        }

    }
}