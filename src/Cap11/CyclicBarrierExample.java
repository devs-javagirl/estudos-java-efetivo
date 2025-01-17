package Cap11;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        int numberOfThreads = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, () -> {
            System.out.println("All threads have reached the barrier. Proceeding...");
        });

        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(new Task(barrier, "Thread-" + i)).start();
        }
    }

    static class Task implements Runnable {
        private final CyclicBarrier barrier;
        private final String name;

        Task(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(name + " is performing some work...");
                Thread.sleep((long) (Math.random() * 2000)); // Simula trabalho
                System.out.println(name + " reached the barrier.");
                barrier.await(); // Aguarda todas as threads chegarem à barreira
                System.out.println(name + " passed the barrier.");
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
