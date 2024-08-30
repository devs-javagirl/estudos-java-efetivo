package Cap7;

import java.util.Random;
import java.util.stream.LongStream;

public class EfficientParallelStream {
    public static void main(String[] args) {
        Random random = new Random();

        // Sequencial
        long startTime = System.nanoTime();
        long sum = LongStream.generate(() -> random.nextInt(100))
                .limit(100_000_000)
                .sum();
        long endTime = System.nanoTime();
        System.out.println("Sequencial: " + sum + " em " + (endTime - startTime) / 1_000_000 + " ms");

        // Paralelo
        startTime = System.nanoTime();
        long parallelSum = LongStream.generate(() -> random.nextInt(100))
                .parallel()
                .limit(100_000_000)
                .sum();
        endTime = System.nanoTime();
        System.out.println("Paralelo: " + parallelSum + " em " + (endTime - startTime) / 1_000_000 + " ms");
    }
}

