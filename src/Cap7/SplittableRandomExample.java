package Cap7;

import java.util.Random;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;

public class SplittableRandomExample {
    public static void main(String[] args) {
        SplittableRandom random = new SplittableRandom();
        Random randomUtil = new Random();

        long startTime = System.nanoTime();
        long sum = LongStream.generate(() -> randomUtil.nextInt(100))
                .parallel()
                .limit(100_000_000)
                .sum();
        long endTime = System.nanoTime();
        System.out.println("Soma: " + sum + " em " + (endTime - startTime) / 1_000_000 + " ms");
    }
}

