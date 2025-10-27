package org.daniel.newAndRun;

public class WithExtends extends Thread {

    public WithExtends(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Soy " + Thread.currentThread().getName() + " is running");
    }
}
