package org.daniel.condicio_carrera.no_atomico;

public class NoAtomico {

    static class Contador {

        int value = 0;

        public void ping() {
            int old = this.value;
            old = old + 1;
            this.value = old;
        }

        public int getValue() {
            return value;
        }


    }

    static class Contable implements Runnable {

        Contador contador;

        Contable(Contador contador) {
            this.contador = contador;
        }

        public void run() {
            contador.ping();
        }


    }

    public static void iterar() {

        Contador contador = new Contador();
        int numHilos = 1000;
        Thread[] threads = new Thread[numHilos];

        for(int i = 0; i < numHilos; i++) {
            threads[i] = new Thread(new Contable(contador));
        }


        for(int i = 0; i < numHilos; i++) {
            threads[i].start();
        }

        for(int i = 0; i < numHilos; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {}
        }

        int valor = contador.getValue();

        if(valor != numHilos)
        System.out.println("Valor: " + valor);

    }

    public static void main(String[] args) {

        for(;;) {
            iterar();
        }

    }

}
