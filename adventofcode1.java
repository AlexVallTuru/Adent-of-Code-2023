import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List; // Importar la interfaz List
import java.util.ArrayList; 

public class adventofcode1 {
    public static void main(String[] args) throws Exception {      
        List<String> lines = readLines("input.txt");
        for(String line:lines){
            System.out.println(line);
        }
    }



    public static List<String> readLines(String filename) throws Exception {
        InputStream ins = new FileInputStream(filename);
        List<String> lines = new ArrayList<>();
        try (Scanner obj = new Scanner(ins)) {
            while (obj.hasNextLine()) lines.add(obj.nextLine());
        }
        return lines;
    }
}
