import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

/**
 * Ejercicio 11 (Capítulo 4): Crear un fichero de acceso directo, con organización
 * relativa, para 200 registros, rellenándolo a ceros y espacios.
 *
 * Registro de longitud fija (37 bytes): CLAVE(5) + NOMBRE(20) + CANTIDAD(12)
 *   CLAVE    -> "00000"        (ceros)
 *   NOMBRE   -> 20 espacios    (espacios)
 *   CANTIDAD -> "000000000.00" (ceros)
 */
public class Main {

    static final int TOTAL_REGISTROS = 200;
    static final int LONG_REGISTRO = 5 + 20 + 12;
    static final String NOMBRE_FICHERO = "clientes.rel";

    static String registroVacio() {
        return String.format(Locale.US, "%05d%-20s%012.2f", 0, "", 0.0);
    }

    public static void main(String[] args) {
        byte[] vacio = registroVacio().getBytes(StandardCharsets.US_ASCII);

        try (RandomAccessFile fichero = new RandomAccessFile(NOMBRE_FICHERO, "rw")) { // Abrir fichero
            fichero.setLength(0);
            int i = 0;                                         // I = 0
            do {
                i = i + 1;                                     // I = I + 1
                fichero.seek((long) (i - 1) * LONG_REGISTRO);  // Posición relativa del registro I
                fichero.write(vacio);                          // Grabar registro a ceros y espacios
            } while (i != TOTAL_REGISTROS);                    // ¿I = 200?

            // Verificación: leer el primer y el último registro
            byte[] buf = new byte[LONG_REGISTRO];
            fichero.seek(0);
            fichero.readFully(buf);
            System.out.println("Registro 1  : [" + new String(buf, StandardCharsets.US_ASCII) + "]");
            fichero.seek((long) (TOTAL_REGISTROS - 1) * LONG_REGISTRO);
            fichero.readFully(buf);
            System.out.println("Registro 200: [" + new String(buf, StandardCharsets.US_ASCII) + "]");
            System.out.println("Tamaño del fichero: " + fichero.length() + " bytes ("
                    + TOTAL_REGISTROS + " registros de " + LONG_REGISTRO + " bytes)");
        } catch (IOException e) {                              // Cerrar fichero (automático)
            System.out.println("Error con el fichero: " + e.getMessage());
            return;
        }
        System.out.println("Fichero creado: " + NOMBRE_FICHERO);
    }
}

