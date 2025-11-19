package Hilos;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class Taquilla {

    private BlockingQueue<Integer> boletos;
    private int capacidadMaxima = 15;

    public Taquilla() {
        this.boletos = new ArrayBlockingQueue<>(capacidadMaxima, true);
        System.out.println("Taquilla abriendo y generando 15 boletos...");
        for (int i = 1; i <= capacidadMaxima; i++) {
            try {
                boletos.put(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error al inicializar la taquilla.");
            }
        }
        System.out.println("Taquilla lista. " + boletos.size() + " boletos disponibles.");
    }
    public int venderBoleto() throws InterruptedException {
        int boleto = boletos.take();
        System.out.println("Boleto " + boleto + " vendido. Boletos restantes: " + boletos.size());
        return boleto;
    }
    public void reponerBoleto(int boleto) throws InterruptedException {
        boletos.put(boleto);
        System.out.println(">> Boleto " + boleto + " devuelto. Boletos disponibles: " + boletos.size());
    }
    public int getBoletosRestantes() {
        return boletos.size();
    }
}
