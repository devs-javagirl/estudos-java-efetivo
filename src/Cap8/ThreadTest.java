package Cap8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    public static void main(String[] args) {

        new Thread(System.out::println).start();

        ExecutorService service = Executors.newSingleThreadExecutor();
        Runnable task = () -> System.out.println("Hello World");
        //assim ele se confunde com o método submit que recebe um Callable
        //service.submit(System.out::println);

    }
}
