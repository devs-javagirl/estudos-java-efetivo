package Cap7;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.stream.Stream;

public class ParallelStreamMersennePrimes {

    public static void main(String[] args) {

        displayMersennePrimesSequencial(20);
        displayMersennePrimesParallel(20);

        teste(null);
    }

    private static void teste(@NotNull String obj) {
        if (obj != null || obj.isEmpty()) {
            System.out.println("obj é nulo");
        } else {
            System.out.println("obj não é nulo");
        }
        //donothing
    }

    // Exibe os primeiros 20 primos de Mersenne
    private static void displayMersennePrimesSequencial(int limit) {
        long startTime = System.nanoTime();
        System.out.println("Primos de Mersenne Sequencial:");
        primes()
                .map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(limit)
                .forEach(mp -> System.out.println(mp.bitLength() + " " + mp));
        long endTime = System.nanoTime();
        System.out.println("Tempo total: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void displayMersennePrimesParallel(int limit) {
        long startTime = System.nanoTime();
        System.out.println("Primos de Mersenne Parallel:");
        primes()
                .parallel()
                .map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(limit)
                .forEach(mp -> System.out.println(mp.bitLength() + " " + mp));
        long endTime = System.nanoTime();
        System.out.println("Tempo total: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    // Gera uma stream infinita de números primos
    private static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }


}
