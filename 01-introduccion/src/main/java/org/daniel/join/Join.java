package org.daniel.join;

import java.time.Duration;

public class Join {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                () -> {
                    System.out.println("Iniciando t1");
                    try {
                        Thread.sleep(Duration.ofSeconds(5));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Terminamos");
                }
        );

        t1.start();

        t1.join();

        System.out.println("Listo ha terminado t1");

    }

}
