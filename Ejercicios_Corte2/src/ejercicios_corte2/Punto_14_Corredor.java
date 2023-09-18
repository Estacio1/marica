/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios_corte2;

import java.util.Arrays;

/**
 *
 * @author Edward
 */
public class Punto_14_Corredor {
    int dorsal;
    int[] tiempos;
    public Corredor(int dorsal, int numEtapas) {
        this.dorsal = dorsal;
        this.tiempos = new int[numEtapas];
    }
    public void registrarTiempo(int etapa, int tiempo) {
        tiempos[etapa] = tiempo;
    }
    public int obtenerTiempoTotal() {
        int tiempoTotal = 0;
        for (int tiempo : tiempos) {
            tiempoTotal += tiempo;
        }
        return tiempoTotal;
    }
    public class VueltaCiclista {
    public static void main(String[] args) {
        int numEtapas = 5;
        int numCorredores = 120;

        Corredor[] corredores = new Corredor[numCorredores];

        // Inicializar corredores
        for (int i = 0; i < numCorredores; i++) {
            corredores[i] = new Corredor(i + 1, numEtapas);
        }
        for (int etapa = 0; etapa < numEtapas; etapa++) {
            for (int i = 0; i < numCorredores; i++) {
                int tiempo = (int) (Math.random() * 3600); // Tiempo aleatorio en segundos (máx. 1 hora)
                corredores[i].registrarTiempo(etapa, tiempo);
            }
        }
        int etapaGanadora = 3;
        int dorsalGanador = obtenerGanadorEtapa(corredores, etapaGanadora);
        System.out.println("Ganador de la etapa " + etapaGanadora + ": Corredor " + dorsalGanador);

        // Obtener ganador de la prueba (menor tiempo total)
        Corredor ganadorPrueba = obtenerGanadorPrueba(corredores);
        System.out.println("Ganador de la prueba: Corredor " + ganadorPrueba.dorsal + " - Tiempo Total: " + ganadorPrueba.obtenerTiempoTotal() + " segundos");
    }
    public static int obtenerGanadorEtapa(Corredor[] corredores, int etapa) {
        int dorsalGanador = 0;
        int tiempoMinimo = Integer.MAX_VALUE;

        for (Corredor corredor : corredores) {
            if (corredor.tiempos[etapa] > 0 && corredor.tiempos[etapa] < tiempoMinimo) {
                dorsalGanador = corredor.dorsal;
                tiempoMinimo = corredor.tiempos[etapa];
            }
        }

        return dorsalGanador;
    }
    public static Corredor obtenerGanadorPrueba(Corredor[] corredores) {
        Corredor ganador = corredores[0];

        for (Corredor corredor : corredores) {
            if (corredor.obtenerTiempoTotal() < ganador.obtenerTiempoTotal()) {
                ganador = corredor;
            }
        }

        return ganador;
    }
}