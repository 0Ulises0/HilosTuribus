package Hilos;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
public class Taquilla {

    private BlockingQueue<Integer> boletos;
    private int capacidadMaxima = 15;


    //
    public Taquilla() {
        //Se crea array de boletos
        this.boletos = new ArrayBlockingQueue<>(capacidadMaxima, true);
        System.out.println("Taquilla abierta con 15 boletos");
        //Se llena el array (inicializa la taquilla de 15 boletos de capacidad)
        for (int i = 1; i <= capacidadMaxima; i++) {
            try {
                boletos.put(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error al inicializar la taquilla.");
            }
        }
        System.out.println("Taquilla lista. Hay " + boletos.size() + " boletos disponibles.");
    }
    //Metodo que retorna un boleto
    public int venderBoleto() throws InterruptedException {
        int boleto = boletos.take();
        //System.out.println("Boleto " + boleto + " vendido. Boletos restantes: " + boletos.size());
        return boleto;
    }
    //Metodo que devuelve un boleto
    public void reponerBoleto(int boleto) throws InterruptedException {
        boletos.put(boleto);
        //System.out.println(">> Boleto " + boleto + " devuelto. Boletos disponibles: " + boletos.size());
    }
    //Saber cuantos boletos quedan
    public int getBoletosRestantes() {
        return boletos.size();
    }
}
