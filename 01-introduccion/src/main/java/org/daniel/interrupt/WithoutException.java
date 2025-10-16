package org.daniel.interrupt;

import java.time.Duration;

public class WithoutException {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(
                () -> {
                    System.out.println("Iniciando t1 ");
                    int i = 0;

                    for(; ;) {

                        if(Thread.currentThread().isInterrupted()) {
                            System.out.println("Thread is interrupt");
                            return;
                        } else {
                            if( ++i == 50000000) {
                                System.out.println("He llegado al máximo");
                                i = 0;
                            }
                        }

                    }

                }
        );

        t1.start();

        Thread.sleep(Duration.ofSeconds(2));

        System.out.println("t1 en que estado esta : " + t1.getState());

        t1.interrupt();



    }

}
