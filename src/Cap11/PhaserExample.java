package Cap11;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Registra o "partida principal"

        for (int i = 0; i < 3; i++) {
            new Thread(new Task(phaser, "Task-" + i)).start();
        }

        // Avança para a próxima fase após garantir que todas as threads registradas concluíram
        System.out.println("Main thread waiting for phase 1 completion...");
        phaser.arriveAndAwaitAdvance();

        System.out.println("Main thread waiting for phase 2 completion...");
        phaser.arriveAndAwaitAdvance();

        System.out.println("All tasks completed phase 2. Main thread moving to phase 3...");
        phaser.arriveAndAwaitAdvance();

        phaser.arriveAndDeregister(); // Desregistra a thread principal
    }

    static class Task implements Runnable {
        private final Phaser phaser;
        private final String name;

        Task(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register(); // Registra a thread no Phaser
        }

        @Override
        public void run() {
            System.out.println(name + " is working on phase 1...");
            try {
                Thread.sleep((long) (Math.random() * 2000)); // Simula trabalho
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(name + " completed phase 1.");
            phaser.arriveAndAwaitAdvance(); // Indica chegada na fase atual e aguarda

            System.out.println(name + " is working on phase 2...");
            try {
                Thread.sleep((long) (Math.random() * 2000)); // Simula trabalho
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(name + " completed phase 2.");
            phaser.arriveAndDeregister(); // Indica chegada e desregistra
        }
    }
}
