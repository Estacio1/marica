/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_corte2;

/**
 *
 * @author Edward
 */
public class Punto_10_MapaEstrellas {
    public static void main(String[] args) {
        int[][] intensidadLuminosa = {
            {10, 20, 15, 5, 10},
            {5, 25, 30, 10, 20},
            {15, 10, 35, 10, 5},
            {5, 15, 20, 10, 15},
            {10, 5, 10, 5, 15}
        };

        int K = 20;

        boolean[][] mapaEstrellas = obtenerMapaEstrellas(intensidadLuminosa, K);

        // Imprime el mapa de estrellas
        for (int i = 0; i < mapaEstrellas.length; i++) {
            for (int j = 0; j < mapaEstrellas[0].length; j++) {
                if (mapaEstrellas[i][j]) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static boolean[][] obtenerMapaEstrellas(int[][] intensidadLuminosa, int K) {
        int filas = intensidadLuminosa.length;
        int columnas = intensidadLuminosa[0].length;
        boolean[][] mapaEstrellas = new boolean[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (esEstrella(intensidadLuminosa, K, i, j)) {
                    mapaEstrellas[i][j] = true;
                }
            }
        }

        return mapaEstrellas;
    }

    public static boolean esEstrella(int[][] intensidadLuminosa, int K, int fila, int columna) {
        int sumaVecinos = 0;
        int numVecinos = 0;

        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = columna - 1; j <= columna + 1; j++) {
                if (i >= 0 && i < intensidadLuminosa.length && j >= 0 && j < intensidadLuminosa[0].length) {
                    sumaVecinos += intensidadLuminosa[i][j];
                    numVecinos++;
                }
            }
        }

        int intensidadPromedio = sumaVecinos / numVecinos;
        return intensidadPromedio > K;
    }
}