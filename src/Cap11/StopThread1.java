package Cap11;

public class StopThread1 {

        private static boolean stopRequested = false;
        private static long cont = 0;

        public static void main(String[] args) throws InterruptedException {
            Thread backgroundThread = new Thread(() -> {
                while (!stopRequested) {
                    // Loop infinito, pois mudanças em stopRequested podem não ser visíveis
                    for (int i = 0; i < 100; i++) {
                        cont++;
                    }
                }
            });
            backgroundThread.start();
            long start = System.currentTimeMillis();

            Thread.sleep(1000);
            stopRequested = true; // Pode nunca ser visto pela outra thread

            long end = System.currentTimeMillis();
            System.out.println((end - start) + " Milisegundos se passaram");
        }

}
