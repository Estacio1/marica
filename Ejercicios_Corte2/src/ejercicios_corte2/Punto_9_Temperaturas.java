/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_corte2;

/**
 *
 * @author Edward
 */
public class Punto_9_Temperaturas {
    public static void main(String[] args) {
        int[][] temperaturas = {
            {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43},
            {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42},
            // Agrega aquí las temperaturas para los días restantes
        };

        double[] temperaturasMediasDiarias = obtenerTemperaturasMediasDiarias(temperaturas);
        double temperaturaMediaMensual = obtenerTemperaturaMediaMensual(temperaturasMediasDiarias);

        System.out.println("Temperaturas Medias Diarias:");
        for (int i = 0; i < temperaturasMediasDiarias.length; i++) {
            System.out.println("Día " + (i + 1) + ": " + temperaturasMediasDiarias[i]);
        }

        System.out.println("Temperatura Media Mensual: " + temperaturaMediaMensual);
    }

    public static double[] obtenerTemperaturasMediasDiarias(int[][] temperaturas) {
        int numDias = temperaturas.length;
        double[] mediasDiarias = new double[numDias];

        for (int i = 0; i < numDias; i++) {
            int sumaDiaria = 0;
            for (int j = 0; j < 24; j++) {
                sumaDiaria += temperaturas[i][j];
            }
            mediasDiarias[i] = (double) sumaDiaria / 24;
        }

        return mediasDiarias;
    }

    public static double obtenerTemperaturaMediaMensual(double[] mediasDiarias) {
        double sumaMensual = 0;
        int numDias = mediasDiarias.length;

        for (int i = 0; i < numDias; i++) {
            sumaMensual += mediasDiarias[i];
        }

        return sumaMensual / numDias;
    }
}
