package Cap7;

import java.util.stream.Stream;

public class InefficientParallelStream {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // Tentativa de paralelizar uma pipeline que não é adequada para paralelismo
        long count = Stream.iterate(1, n -> n + 1)
                .parallel()
                .limit(1_000_000)
                .filter(InefficientParallelStream::isPrime)
                .count();
        long endTime = System.nanoTime();
        System.out.println("Contagem de primos: " + count + " em " + (endTime - startTime) / 1_000_000 + " ms");
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}

