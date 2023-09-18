/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_corte2;

import java.util.Scanner;

/**
 *
 * @author Edward
 */
public class Punto_13_Equipo {
    String nombre;
    int puntuacion;
 public Equipo(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
    }
 public class LigaFutbolin {
    public static void main(String[] args) {
        int numEquipos = 10;
        Equipo[] equipos = new Equipo[numEquipos];

        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < numEquipos; i++) {
            System.out.print("Ingrese el nombre del equipo " + (i + 1) + ": ");
            String nombreEquipo = scanner.nextLine();
            equipos[i] = new Equipo(nombreEquipo);
        }
          int[][] tabla = new int[numEquipos][numEquipos];
        for (int i = 0; i < numEquipos; i++) {
            for (int j = 0; j < numEquipos; j++) {
                if (i != j) {
                    System.out.print("Ingrese los tantos de " + equipos[i].nombre + " contra " + equipos[j].nombre + ": ");
                    int tantos = scanner.nextInt();
                    tabla[i][j] = tantos;
                    equipos[i].puntuacion += calcularPuntos(tantos);
                }
            }
        }

        // Calcular puntuación de cada equipo
        for (Equipo equipo : equipos) {
            System.out.println(equipo.nombre + " - Puntuación: " + equipo.puntuacion);
        }
    }

    public static int calcularPuntos(int tantos) {
        if (tantos > 3) {
            return 3; // Ganado
        } else if (tantos == 3) {
            return 1; // Empatado
        } else {
            return 0; // Perdido
        }
    }
}
}