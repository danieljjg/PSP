package org.daniel.newAndRun;

import java.time.Duration;



public class Main {

    public static void main(String[] args) throws InterruptedException {

        // SUBCLASE DE THREAD
       Thread t1 = new WithExtends("Hilo extends");

       // SUBCLASE DE RUNNABLE
       Thread t2 = new Thread(new WithImplements(), "Hilo Runnable");

       // CON CLASE ANONIMA
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Soy " + Thread.currentThread().getName() + " is running");
            }
        }, "Hilo clase Anonima");

        // CON EXPRESIÓN LAMBDA
        Thread t4 = new Thread( () ->
                System.out.println("Soy " + Thread.currentThread().getName() + " is running"
                ), "Hilo Expresión Lambda");

        prueba1(t1, t2, t3, t4);


    }

    public static void prueba1(Thread t1, Thread t2, Thread t3, Thread t4) throws InterruptedException {

        System.out.println("Estado de " + t1.getName() + " : " + t1.getState());

        t1.start();
        t2.start();

        System.out.println("Estado de " + t2.getName() + " : " + t2.getState());

        t3.start();
        t4.start();

        Thread.sleep(Duration.ofSeconds(2));
        System.out.println("Estado de " + t2.getName() + " : " + t2.getState());
    }

}
