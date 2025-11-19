package Hilos;

import java.util.ArrayList;
import java.util.List;

public class SimulacionTaquilla {

    public static void main(String[] args) {

        Taquilla taquilla = new Taquilla();
        //Seran 20 clientes
        int numClientes = 20;
        //Se crea un hilo por cada cliente
        List<Thread> hilosClientes = new ArrayList<>();

        for (int i = 1; i <= numClientes; i++) {
            //Se crean los hilos con los clientes
            Cliente cliente = new Cliente(taquilla, "Cliente " + i);
            Thread hilo = new Thread(cliente);
            hilosClientes.add(hilo);
        }

        //Se empiezan los hilos
        for (Thread hilo : hilosClientes) {
            hilo.start();
        }

        //Hace una espera del hilo hasta que se termine para poder empezar con el siguiente
        for (Thread hilo : hilosClientes) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error " + hilo.getName());
            }
        }
        System.out.println("-------------------------------------------");
        System.out.println("Boletos restantes en la taquilla: " + taquilla.getBoletosRestantes());
    }
}