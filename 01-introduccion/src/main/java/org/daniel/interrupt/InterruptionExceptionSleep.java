package org.daniel.interrupt;

import java.time.Duration;

public class InterruptionExceptionSleep {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(
                () -> {
                    System.out.println("Estoy iniciando t");
                    try {
                        Thread.sleep(Duration.ofSeconds(3));
                        System.out.println("Ey he terminado correctamente");
                    } catch (InterruptedException e) {
                        System.out.println("He sido interrumpido");
                    }

                }
        );

        t.start();
        t.interrupt();
        t.join();

        System.out.println(t.isInterrupted());


    }



}
