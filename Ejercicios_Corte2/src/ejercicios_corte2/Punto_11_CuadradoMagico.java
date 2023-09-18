/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_corte2;

/**
 *
 * @author Edward
 */
public class Punto_11_CuadradoMagico {
    public static void main(String[] args) {
        int[][] matriz = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 8}
        };
        boolean esCuadradoMagico = verificarCuadradoMagico(matriz);

        if (esCuadradoMagico) {
            System.out.println("La matriz es un cuadrado mágico.");
        } else {
            System.out.println("La matriz NO es un cuadrado mágico.");
        }
    }
    public static boolean verificarCuadradoMagico(int[][] matriz) {
        int n = matriz.length;

        // Calcula la suma de la primera fila y la usa como referencia
        int sumaReferencia = 0;
        for (int j = 0; j < n; j++) {
            sumaReferencia += matriz[0][j];
        }

        // Verifica la suma de cada fila
        for (int i = 1; i < n; i++) {
            int sumaFila = 0;
            for (int j = 0; j < n; j++) {
                sumaFila += matriz[i][j];
            }
            if (sumaFila != sumaReferencia) {
                return false;
            }
        }

        // Verifica la suma de cada columna
        for (int j = 0; j < n; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < n; i++) {
                sumaColumna += matriz[i][j];
            }
            if (sumaColumna != sumaReferencia) {
                return false;
            }
        }

        // Verifica la suma de la diagonal principal
        int sumaDiagonalPrincipal = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalPrincipal += matriz[i][i];
        }
        if (sumaDiagonalPrincipal != sumaReferencia) {
            return false;
        }

        // Verifica la suma de la diagonal secundaria
        int sumaDiagonalSecundaria = 0;
        for (int i = 0; i < n; i++) {
            sumaDiagonalSecundaria += matriz[i][n - 1 - i];
        }
        if (sumaDiagonalSecundaria != sumaReferencia) {
            return false;
        }

        return true;
    }
}
