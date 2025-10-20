import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class Ejercicio5 {

    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private static final String[] TITLES = {"Las tinieblas y el alba", "Don Quijote de la Mancha", "El Señor de los Anillos", "El principito"};
    private static final int[] PUBLICATION_YEAR = {2020, 1605, 1954, 1943};

    static void main() {
        IO.println();
        IO.println("### EJERCICIO 5 ###");
        IO.println(LocalDateTime.now());
        IO.println();
        execute();
    }

    public static void execute() {
        write();
        read();
    }

    private static void write() {
        File file = new File("BinaryFile.dat");
        IO.println("Writing to file: " + file.getAbsolutePath());

        try (OutputStream out = new FileOutputStream(file)) {
            for (int i = 0; i < TITLES.length; i++) {
                out.write(("Título: %s".formatted(TITLES[i])).getBytes(DEFAULT_CHARSET));
                out.write(", Año de publicación: %s".formatted(PUBLICATION_YEAR[i]).getBytes(DEFAULT_CHARSET));
                out.write('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        IO.println("File written successfully\n");
    }

    private static void read() {
        File file = new File("BinaryFile.dat");
        IO.println("Reading from file: " + file.getAbsolutePath());

        try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            int read = reader.read();
            while (read != -1) {
                IO.print((char) read);
                read = reader.read();
            }
            IO.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
