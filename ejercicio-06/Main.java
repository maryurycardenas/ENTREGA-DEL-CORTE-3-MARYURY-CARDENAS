/** Ejercicio 12 (Capítulo 5, estructurado): Hallar la suma de los diez primeros números pares. */
public class Main {

    public static void main(String[] args) {
        int s = 0;                      // S = 0 (suma acumulada)
        int i = 0;                      // I = 0 (genera los pares 2, 4, ... 20)

        do {                            // Repetir hasta que I = 20
            i = i + 2;                  // I = I + 2
            s = s + i;                  // S = S + I
        } while (i != 20);

        System.out.println("La suma de los diez primeros números pares es: " + s);
    }
}

