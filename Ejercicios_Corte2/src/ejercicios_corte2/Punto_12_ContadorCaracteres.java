/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_corte2;

import java.util.Random;

/**
 *
 * @author Edward
 */
public class Punto_12_ContadorCaracteres {
    public static void main(String[] args) {
        int n = 5; // Número de filas
        int m = 6; // Número de columnas

        char[][] matriz = generarMatrizAleatoria(n, m);
        imprimirMatriz(matriz);

        int[] maximosPorFila = encontrarMaximosPorFila(matriz);
        int[] maximosPorColumna = encontrarMaximosPorColumna(matriz);

        int filaMaxima = encontrarFilaMaxima(maximosPorFila);
        int columnaMaxima = encontrarColumnaMaxima(maximosPorColumna);

        System.out.println("Cantidad máxima de X contiguos por fila:");
        imprimirArreglo(maximosPorFila);
        System.out.println("Cantidad máxima de X contiguos por columna:");
         imprimirArreglo(maximosPorColumna);

        System.out.println("Fila con más X contiguos: " + filaMaxima);
        System.out.println("Columna con más X contiguos: " + columnaMaxima);
        public static char[][] generarMatrizAleatoria(int n, int m) {
        char[][] matriz = new char[n][m];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = random.nextBoolean() ? 'X' : 'O';
            }
        }

        return matriz;
    }

    // Imprime una matriz en la consola
    public static void imprimirMatriz(char[][] matriz) {
        for (char[] fila : matriz) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    // Encuentra la cantidad máxima de caracteres 'X' contiguos por fila
    public static int[] encontrarMaximosPorFila(char[][] matriz) {
        int n = matriz.length;
        int m = matriz[0].length;
        int[] maximosPorFila = new int[n];

        for (int i = 0; i < n; i++) {
            int contador = 0;
            int maximo = 0;

            for (int j = 0; j < m; j++) {
                if (matriz[i][j] == 'X') {
                    contador++;
                    maximo = Math.max(maximo, contador);
                } else {
                    contador = 0;
                }
            }

            maximosPorFila[i] = maximo;
        }

        return maximosPorFila;
    }

    // Encuentra la cantidad máxima de caracteres 'X' contiguos por columna
    public static int[] encontrarMaximosPorColumna(char[][] matriz) {
        int n = matriz.length;
        int m = matriz[0].length;
        int[] maximosPorColumna = new int[m];

        for (int j = 0; j < m; j++) {
            int contador = 0;
            int maximo = 0;

            for (int i = 0; i < n; i++) {
                if (matriz[i][j] == 'X') {
                    contador++;
                    maximo = Math.max(maximo, contador);
                } else {
                    contador = 0;
                }
            }

            maximosPorColumna[j] = maximo;
        }

        return maximosPorColumna;
    }

    // Encuentra la fila con más X contiguos
    public static int encontrarFilaMaxima(int[] maximosPorFila) {
        int filaMaxima = 0;
        int maximo = maximosPorFila[0];

        for (int i = 1; i < maximosPorFila.length; i++) {
            if (maximosPorFila[i] > maximo) {
                maximo = maximosPorFila[i];
                filaMaxima = i;
            }
        }

        return filaMaxima;
    }

    // Encuentra la columna con más X contiguos
    public static int encontrarColumnaMaxima(int[] maximosPorColumna) {
        int columnaMaxima = 0;
        int maximo = maximosPorColumna[0];

        for (int i = 1; i < maximosPorColumna.length; i++) {
            if (maximosPorColumna[i] > maximo) {
                maximo = maximosPorColumna[i];
                columnaMaxima = i;
            }
        }

        return columnaMaxima;
    }

    // Imprime un arreglo en la consola
    public static void imprimirArreglo(int[] arreglo) {
        for (int valor : arreglo) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }
}
