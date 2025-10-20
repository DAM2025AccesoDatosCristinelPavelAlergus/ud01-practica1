import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Ejercicio1 {

    static void main() {
        System.out.println();
        System.out.println("### EJERCICIO 1 ###");
        System.out.println(LocalDateTime.now());
        execute();
    }

    /**
     * Ejercicio 1: Crea un programa en Java donde muestres una lista con el nombre de los ficheros del directorio actual, recuerda, que para indicar que estamos en el directorio actual se hace
     * mediante “.” Ayúdate del método list() de la clase File.
     */
    public static void execute() {
        String[] filesInCurrentDir = new File(".").list();
        System.out.println(Arrays.toString(filesInCurrentDir));
    }
}
