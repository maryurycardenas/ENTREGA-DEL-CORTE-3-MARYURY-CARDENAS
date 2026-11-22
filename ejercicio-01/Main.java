import java.util.Scanner;

/**
 * Ejercicio 1 (Capítulo 2): Hallar la suma de dos números X e Y.
 */
public class Main {

    /** Pide un número por pantalla y repite la pregunta hasta que sea válido. */
    static double leerNumero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido. Intente de nuevo.");
            }
        }
    }

    /** Muestra los enteros sin ".0" (5.0 -> 5). */
    static String fmt(double v) {
        return (v == Math.rint(v) && Math.abs(v) < 1e15) ? String.valueOf((long) v) : String.valueOf(v);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = leerNumero(sc, "Dame el número X: ");   // Entrada
        double y = leerNumero(sc, "Dame el número Y: ");   // Entrada

        double z = x + y;                                  // Proceso: Z = X + Y

        System.out.println("La suma de " + fmt(x) + " y " + fmt(y) + " es: " + fmt(z)); // Salida
    }
}

