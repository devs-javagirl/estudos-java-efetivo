package Cap11;

public class StopThread2 {
    private static volatile boolean stopRequested;
    private static long cont = 0;

    public static synchronized void requestStop() {
        stopRequested = true;
    }

    public static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            while (!stopRequested()) {
                // Loop agora termina corretamente
                for (int i = 0; i < 100; i++) {
                    cont++;
                }
            }
        });
        backgroundThread.start();
        long start = System.currentTimeMillis();

        Thread.sleep(1000);
        requestStop();
        long end = System.currentTimeMillis();

        System.out.println((end - start) + " Milisegundos se passaram");
    }
}
