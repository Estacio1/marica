/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicios_corte2;

import java.util.Scanner;

/**
 *
 * @author Edward
 */

public class Punto_15_Vendedor {
    String nombre;
    int [] ventasSemanales = new int[7];
    int totalVentasMensuales;
    public Vendedor(String nombre){
        this.nombre = nombre;
    }
    public void ingresarVentas(){
        System.out.print("Ingresar ventas semanales para " + nombre + ":");
        for (int i = 0; i < 7; i++){
            System.out.print("Día " + (i + 1) + ": ");
            ventasSemanales[i] = scanner.nextInt();
        }
    }
    public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numVendedores = 5;
        Vendedor[] vendedores = new Vendedor[numVendedores];

        // Ingresar nombres de vendedores
        for (int i = 0; i < numVendedores; i++) {
            System.out.print("Nombre del vendedor " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            vendedores[i] = new Vendedor(nombre);
        }

        // Ingresar ventas semanales para cada vendedor
        for (Vendedor vendedor : vendedores) {
            vendedor.ingresarVentas();
            vendedor.calcularTotalVentasMensuales();
        }

        // Calcular el vendedor con más ventas en un día de la semana
        int maxVentasDia = 0;
        String vendedorMaxVentasDia = "";

        for (int dia = 0; dia < 7; dia++) {
            for (Vendedor vendedor : vendedores) {
                if (vendedor.ventasSemanales[dia] > maxVentasDia) {
                    maxVentasDia = vendedor.ventasSemanales[dia];
                    vendedorMaxVentasDia = vendedor.nombre;
                }
            }
            System.out.println("El vendedor con más ventas el día " + (dia + 1) + " es: " + vendedorMaxVentasDia);
            maxVentasDia = 0;
            vendedorMaxVentasDia = "";
        }

        // Mostrar total de ventas mensuales por vendedor
        System.out.println("Total de ventas mensuales por vendedor:");
        for (Vendedor vendedor : vendedores) {
            System.out.println(vendedor.nombre + ": $" + vendedor.totalVentasMensuales);
        }
    }
}
}