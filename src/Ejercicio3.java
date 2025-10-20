import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Ejercicio3 {

    static void main(String[] args) {
        System.out.println();
        System.out.println("### EJERCICIO 3 ###");
        System.out.println(LocalDateTime.now());
        execute("Cristinel Pavel Alergus");
        execute("\nnuevo contenido");
    }

    /**
     * Ejercicio 3: Escribe un programa que escriba una secuencia de caracteres dada por ti, en un fichero de nombre textFile.txt (si no existe lo crea). Ayúdate sólo de la clase File y FileWriter y
     * el método write. ¿Qué pasa al escribir si el fichero ya existe y tenía información almacenada anteriormente? ¿Cómo habría que modificar el código para que al escribir caracteres se inserten al
     * final del fichero?
     */
    public static void execute(String contentToWrite) {
        File file = new File("textFile.txt");

        try (FileWriter fileWriter = new FileWriter(file,true)) {
            fileWriter.write(contentToWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
