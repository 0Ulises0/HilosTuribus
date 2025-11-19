package Hilos;

import java.util.ArrayList;
import java.util.List;

public class SimulacionTaquilla {

    public static void main(String[] args) {

        Taquilla taquilla = new Taquilla();
        int numClientes = 20;
        List<Thread> hilosClientes = new ArrayList<>();

        System.out.println("--- Iniciando simulación con " + numClientes + " clientes ---");

        for (int i = 1; i <= numClientes; i++) {
            Cliente cliente = new Cliente(taquilla, "Cliente " + i);
            Thread hilo = new Thread(cliente);
            hilosClientes.add(hilo);
        }

        for (Thread hilo : hilosClientes) {
            hilo.start();
        }

        for (Thread hilo : hilosClientes) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error esperando al hilo " + hilo.getName());
            }
        }

        System.out.println("--- Simulación Finalizada ---");
        System.out.println("Boletos restantes en la taquilla: " + taquilla.getBoletosRestantes());
    }
}