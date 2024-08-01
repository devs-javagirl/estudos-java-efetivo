package Cap7;

import java.math.BigInteger;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {
        // Exemplo: Manuseio de Caracteres com Streams
        processChars("Hello world!");

        // Exemplo: Primos de Mersenne
        displayMersennePrimes(20);
    }

    // Demonstração de problemas ao usar streams para processar char
    private static void processChars(String input) {
        System.out.println("Exibindo caracteres como inteiros:");
        input.chars().forEach(ch -> System.out.print(ch)); // Problema: Exibe inteiros
        System.out.println("\nExibindo caracteres corretamente:");
        input.chars().forEach(ch -> System.out.print((char) ch)); // Solução: Conversão para char
        System.out.println();
    }

    // Exibe os primeiros 20 primos de Mersenne
    private static void displayMersennePrimes(int limit) {
        System.out.println("Primos de Mersenne:");
        primes()
                .map(p -> BigInteger.TWO.pow(p.intValueExact()).subtract(BigInteger.ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(limit)
                .forEach(mp -> System.out.println(mp.bitLength() + " " + mp));
    }

    // Gera uma stream infinita de números primos
    private static Stream<BigInteger> primes() {
        return Stream.iterate(BigInteger.TWO, BigInteger::nextProbablePrime);
    }
}

