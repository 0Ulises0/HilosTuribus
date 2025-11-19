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
            //El cliente intenta adquirir un boleto
            int boletoComprado = taquilla.venderBoleto();
            System.out.println(nombre + " compro el boleto numero: " + boletoComprado);
            Thread.sleep(3000);

            // de manera aleatoria devuelve o utiliza el boleto que se ha adquirido

            //Se devuelve el voleto
            if (random.nextBoolean()) { 
                taquilla.reponerBoleto(boletoComprado);
                System.out.println(nombre + " devolvio el boleto "+ boletoComprado);
            } 
            //El boleto es usado
            else {
                System.out.println(nombre + " uso su boleto " + boletoComprado);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(nombre + " fue interrumpido.");
        }
    }
}