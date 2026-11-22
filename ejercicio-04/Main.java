import java.util.Scanner;

/** Ejercicio 10 (Capítulo 3): Crear una matriz de X columnas y N filas, rellenándola a ceros. */
public class Main {

    static int leerEnteroPositivo(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(linea);
                if (v > 0) {
                    return v;
                }
                System.out.println("El valor debe ser mayor que 0.");
            } catch (NumberFormatException e) {
                System.out.println("Valor no válido. Escriba un número entero.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = leerEnteroPositivo(sc, "Dame el número de columnas X: ");
        int n = leerEnteroPositivo(sc, "Dame el número de filas N: ");

        int[][] a = new int[n][x];      // A(I,J)

        int i = 0;                      // I = 0
        do {
            i = i + 1;                  // I = I + 1
            int j = 0;                  // J = 0
            do {
                j = j + 1;              // J = J + 1
                a[i - 1][j - 1] = 0;    // A(I,J) = 0
            } while (j != x);           // ¿J = X?
        } while (i != n);               // ¿I = N?

        System.out.println("Matriz de " + n + " filas por " + x + " columnas:");
        for (int f = 0; f < n; f++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < x; c++) {
                sb.append(a[f][c]).append(c < x - 1 ? " " : "");
            }
            System.out.println(sb);
        }
    }
}
