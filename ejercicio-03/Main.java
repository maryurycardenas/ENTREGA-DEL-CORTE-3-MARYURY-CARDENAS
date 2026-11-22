/** Ejercicio 9 (Capítulo 3): Crear una tabla en memoria para 200 elementos y rellenarla con los números pares. */
public class Main {

    static final int TOTAL = 200;

    public static void main(String[] args) {
        int[] tabla = new int[TOTAL];   // A(1..200) -> tabla[0..199]

        int i = 0;                      // I = 0 (subíndice)
        int j = 0;                      // J = 0 (generador de pares)
        do {
            i = i + 1;                  // I = I + 1
            j = j + 2;                  // J = J + 2
            tabla[i - 1] = j;           // A(I) = J
        } while (i != TOTAL);           // ¿I = 200?

        System.out.println("Tabla creada con " + TOTAL + " números pares:");
        for (int k = 0; k < TOTAL; k++) {
            System.out.print(tabla[k] + (((k + 1) % 10 == 0) ? "\n" : "\t"));
        }
    }
}
