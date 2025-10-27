package org.daniel.newAndRun;

import java.time.Duration;

public class WithImplements implements Runnable {

    @Override
    public void run() {
        System.out.println("Soy " + Thread.currentThread().getName() + " is running");

        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(i + " - " + Thread.currentThread().getName());
                Thread.sleep(Duration.ofSeconds(1));
            }
        } catch (InterruptedException e) {
            System.out.println("He sido interrumpido");
        }

    }
}
