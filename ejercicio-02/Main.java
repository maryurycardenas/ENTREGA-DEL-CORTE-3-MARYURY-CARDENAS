import java.util.Scanner;

/** Ejercicio 8 (Capítulo 2): Dado un número, contestar si es par o impar. */
public class Main {

    static long leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                return Long.parseLong(linea);
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido. Escriba un número entero.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = leerEntero(sc, "Dame el número N: ");   // Entrada

        long z = n / 2;                                  // Z = N / 2 (parte entera)
        if (n == 2 * z) {                                // ¿N = 2 x INT(Z)?
            System.out.println("El número " + n + " es PAR");
        } else {
            System.out.println("El número " + n + " es IMPAR");
        }
    }
}
