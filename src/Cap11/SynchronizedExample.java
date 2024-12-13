package Cap11;

import java.util.concurrent.atomic.AtomicLong;

public class SynchronizedExample {
    private static class Counter {
        private static final AtomicLong value = new AtomicLong();
        //private volatile int value = 0;

        // Método sincronizado para incrementar o valor
        public void increment() {
            value.getAndIncrement();
            //value++;
        }

        // Método sincronizado para decrementar o valor
        public void decrement() {
            value.getAndDecrement();
            //value--;
        }

        // Método sincronizado para obter o valor atual
        public long getValue() {
            return value.longValue();
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        // Thread para incrementar o valor
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Thread para decrementar o valor
        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.decrement();
            }
        });

        // Inicia ambas as threads
        incrementThread.start();
        decrementThread.start();

        // Aguarda ambas as threads terminarem
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Exibe o valor final do contador
        System.out.println("Valor final do contador: " + counter.getValue());
    }
}
