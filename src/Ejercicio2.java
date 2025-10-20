import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Ejercicio2 {

    static void main(String[] args) {
        System.out.println();
        System.out.println("### EJERCICIO 2 ###");
        System.out.println(LocalDateTime.now());
        execute(args[0]);
    }

    /**
     * Ejercicio 2: Crea un programa en Java utilizando el método listFiles() para mostrar la lista de ficheros en un directorio. El nombre del directorio se pasará al programa desde los argumentos de
     * main(). Ten en cuenta también el caso cuando el directorio que pasamos no exista y se muestre un mensaje.
     */
    public static void execute(String dirName) {
        File dir = new File(dirName);

        if (!dir.exists()) {
            System.out.println("El directorio " + dirName + " no existe.");
            return;
        }

        File[] files = dir.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
