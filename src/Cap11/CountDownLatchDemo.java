package Cap11;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CountDownLatchDemo {

    public static long time(Executor executor, int concurrency, Runnable action) throws InterruptedException {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                try {
                    ready.countDown(); // Indica que está pronto
                    start.await();     // Aguarda o sinal de início
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                } finally {
                    done.countDown(); // Indica que terminou
                }
            });
        }

        ready.await();   // Aguarda todas as threads ficarem prontas
        long startTime = System.nanoTime();
        start.countDown(); // Dispara o sinal de início
        done.await();     // Aguarda todas as threads finalizarem
        return System.nanoTime() - startTime;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);
        try {
            long time = time(executor, 2, () -> System.out.println("Hello"));
            System.out.println("Tempo de execução: " + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
