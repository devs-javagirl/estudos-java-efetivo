package Cap11;

import java.util.concurrent.CountDownLatch;

public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        this.count = count;
    }

    public void await() {
        while (count > 0) {
            // Espera-ativa: utiliza o processador desnecessariamente
            System.out.println("Esperando...");
            countDown();
        }
    }

    public void countDown() {
        if (count > 0) {
            count--;
            System.out.println("Contagem regressiva: " + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //SlowCountDownLatch slowCountDownLatch = new SlowCountDownLatch(2);
        CountDownLatch slowCountDownLatch = new CountDownLatch(2);
        long startTime = System.nanoTime();

        slowCountDownLatch.await();
        slowCountDownLatch.countDown();
        slowCountDownLatch.countDown();

        long endTime = System.nanoTime();
        System.out.println("Tempo de execução: " + (endTime - startTime));
    }

}

