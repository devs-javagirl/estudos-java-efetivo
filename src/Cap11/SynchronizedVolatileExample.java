package Cap11;

public class SynchronizedVolatileExample {
    private static class Counter {
        private volatile int value = 0;

        //O volatile garante que a variável value seja sempre lida e escrita 
        //diretamente na memória principal, evitando que threads leiam valores 
        //desatualizados. Porém, deve ser usado com cuidado, pois não garante
        //a atomicidade de operações compostas quando há múltiplas threads.

        public void increment() {
            value++;
        }

        public void decrement() {
            value--;
        }

        public int getValue() {
            return value;
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
