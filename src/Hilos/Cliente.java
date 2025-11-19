package Hilos;

import java.util.Random;

public class Cliente implements Runnable {

    private Taquilla taquilla;
    private String nombre;
    private Random random = new Random();

    public Cliente(Taquilla taquilla, String nombre) {
        this.taquilla = taquilla;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            int boletoComprado = taquilla.venderBoleto();
            System.out.println(nombre + " compró el boleto número: " + boletoComprado);
            Thread.sleep(3000);
            if (random.nextBoolean()) { 
                taquilla.reponerBoleto(boletoComprado);
            } else {
                System.out.println(nombre + " usó su boleto " + boletoComprado + " y disfrutó el paseo.");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(nombre + " fue interrumpido.");
        }
    }
}