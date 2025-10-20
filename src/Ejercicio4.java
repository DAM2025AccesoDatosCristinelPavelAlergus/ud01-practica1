import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Ejercicio4 {

    static void main() {
        System.out.println();
        System.out.println("### EJERCICIO 4 ###");
        System.out.println(LocalDateTime.now());
        executeFileWriter();
        executeBufferedWriter();
    }

    /**
     * Ejercicio 4: Las clases FileReader o FileWriter no contienen métodos que nos permitan leer o escribir líneas de forma eficiente, es decir, no carácter a carácter. Para esto utilizamos las
     * clases BufferedReader o BufferedWriter. Transforma el ejercicio 3 para que utilice la clase Buffered de manera que la lectura o escritura sea más eficiente.
     */
    public static void executeFileWriter() {
        File fileFileWriter = new File("textFile_FileWriter.txt");
        String content = "Hello world! This is a test line.\n";
        int repetitions = 1_000_000; // number of times to write

        // --- FileWriter ---
        long start = System.currentTimeMillis();
        try (FileWriter fw = new FileWriter(fileFileWriter, true)) {
            for (int i = 0; i < repetitions; i++) {
                fw.write(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.println("FileWriter time: " + (end - start) + " ms");
    }

    public static void executeBufferedWriter() {
        File file = new File("textFile_BufferedWriter.txt");
        String content = "Hello world! This is a test line.\n";
        int repetitions = 1_000_000; // number of times to write

        long start = System.currentTimeMillis();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            for (int i = 0; i < repetitions; i++) {
                bw.write(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();

        System.out.println("BufferedWriter time: " + (end - start) + " ms");
    }
}
