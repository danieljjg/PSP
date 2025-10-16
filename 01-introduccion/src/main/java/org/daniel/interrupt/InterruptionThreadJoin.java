package org.daniel.interrupt;

public class InterruptionThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n=== DEMO 3: Interrupción de join() ===");
        Thread joinThread = new Thread(

                () -> {


                    System.out.println("🤝 [JOIN] Hilo principal iniciado");

                    // Crear un hilo que tarda mucho en terminar
                    Thread longRunningThread = new Thread(() -> {
                        try {
                            System.out.println("🐌 [LONG] Hilo lento iniciado, trabajando 15 segundos...");
                            Thread.sleep(15000); // Trabajo que tarda mucho
                            System.out.println("🐌 [LONG] Hilo lento terminado");
                        } catch (InterruptedException e) {
                            System.out.println("🐌 [LONG] Hilo lento interrumpido");
                        }
                    });

                    longRunningThread.start();

                    try {
                        System.out.println("🤝 [JOIN] Esperando a que termine el hilo lento...");
                        longRunningThread.join(); // WAITING hasta que longRunningThread termine
                        System.out.println("🤝 [JOIN] El hilo lento terminó, continuando");

                    } catch (InterruptedException e) {
                        System.out.println("⚡ [JOIN] ¡Fui interrumpido mientras esperaba el join!");
                        System.out.println("⚡ [JOIN] Estado de bandera después de catch: " +
                                Thread.currentThread().isInterrupted()); // false

                        // Limpiar el hilo que estábamos esperando
                        longRunningThread.interrupt();

                        // Restaurar bandera
                        Thread.currentThread().interrupt();
                        System.out.println("⚡ [JOIN] Bandera restaurada: " +
                                Thread.currentThread().isInterrupted()); // true
                    }

                    System.out.println("🤝 [JOIN] Hilo terminando");


                }

        );

        joinThread.start();

        Thread.sleep(3000); // Esperar 3 segundos
        System.out.println("👤 [MAIN] Interrumpiendo hilo que hace join...");
        joinThread.interrupt();
        joinThread.join();

    }

}
