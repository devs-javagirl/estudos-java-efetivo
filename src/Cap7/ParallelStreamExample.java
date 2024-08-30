package Cap7;

import java.util.stream.LongStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        // Cálculo sequencial
        long startTime = System.nanoTime();
        long sum = LongStream.rangeClosed(1, 100_000_000).sum();
        long endTime = System.nanoTime();
        System.out.println("Sequencial: " + sum + " em " + (endTime - startTime) / 1_000_000 + " ms");

        // Cálculo paralelo
        startTime = System.nanoTime();
        long parallelSum = LongStream.rangeClosed(1, 100_000_000).parallel().sum();
        endTime = System.nanoTime();
        System.out.println("Paralelo: " + parallelSum + " em " + (endTime - startTime) / 1_000_000 + " ms");
    }
}

