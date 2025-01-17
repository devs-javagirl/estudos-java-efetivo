package Cap11;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        int numberOfWorkers = 3;
        CountDownLatch latch = new CountDownLatch(numberOfWorkers);

        for (int i = 0; i < numberOfWorkers; i++) {
            new Thread(new Worker(latch, "Worker-" + i)).start();
        }

        System.out.println("Waiting for workers to finish...");
        latch.await(); // Aguarda todos os trabalhadores chamarem latch.countDown()
        System.out.println("All workers are done. Proceeding...");
    }

    static class Worker implements Runnable {
        private final CountDownLatch latch;
        private final String name;

        Worker(CountDownLatch latch, String name) {
            this.latch = latch;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " is working...");
            try {
                Thread.sleep((long) (Math.random() * 2000)); // Simula trabalho
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(name + " finished.");
            latch.countDown(); // Decrementa o contador
        }
    }
}

