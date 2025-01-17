package Cap11;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        int permits = 5; // Número de permissões disponíveis
        Semaphore semaphore = new Semaphore(permits);

        for (int i = 1; i <= 5; i++) {
            new Thread(new Task(semaphore, "Task-" + i)).start();
        }
    }

    static class Task implements Runnable {
        private final Semaphore semaphore;
        private final String name;

        Task(Semaphore semaphore, String name) {
            this.semaphore = semaphore;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is waiting for a permit...");
                semaphore.acquire(); // Adquire uma permissão
                System.out.println(name + " got a permit and is working...");
                Thread.sleep((long) (Math.random() * 2000)); // Simula trabalho
                System.out.println(name + " is releasing a permit.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                semaphore.release(); // Libera a permissão
            }
        }
    }
}
