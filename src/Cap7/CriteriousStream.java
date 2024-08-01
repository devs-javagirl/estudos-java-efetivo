package Cap7;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;
import java.util.stream.Stream;


import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;
import static java.util.stream.Collectors.groupingBy;

public class CriteriousStream {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> words = Arrays.asList("petals", "staple", "casa", "saca", "asac");
        int minGroupSize = 2;

        findAnagramsWithCompute(words, minGroupSize);

        findAnagramsDontUse(words, minGroupSize);

        findAnagramsElegant(words, minGroupSize);

        helloWorldCrazy();

        System.out.println(""); // pula linha antes do próximo exemplo

        helloWorldCorrect();

        System.out.println(""); // pula linha antes do próximo exemplo

        mersennePrime();

    }

    private static void findAnagramsWithCompute(List<String> words, int minGroupSize) {
        System.out.println("encontra anagramas implementação mediana:");
        Map<String, Set<String>> groups = new HashMap<>();
        for(String word : words) {
            groups.computeIfAbsent(alphabetize(word),
                    (unused) -> new TreeSet<>()).add(word);
        }

        for (Set<String> group: groups.values()) {
            if (group.size() >= minGroupSize)
                System.out.println(group.size() + ": " + group);
        }
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }

    private static void findAnagramsDontUse(List<String> words, int minGroupSize) {
        System.out.println("encontra anagramas implementação horrível:");

        words.stream().collect(
                    groupingBy(word -> word.chars().sorted()
                        .collect(StringBuilder::new,
                                (sb, c) -> sb.append((char) c),
                                StringBuilder::append).toString()))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .map(group -> group.size() + ": " + group)
                .forEach(System.out::println);

    }

    private static void findAnagramsElegant(List<String> words, int minGroupSize) {
        System.out.println("encontra anagramas implementação elegante:");

        words.stream().collect(
                    groupingBy(word -> alphabetize(word)))
                .values().stream()
                .filter(group -> group.size() >= minGroupSize)
                .forEach(group -> System.out.println(group.size() + ":" + group));

    }

    private static void helloWorldCrazy() {
        System.out.println("Imprime Hello world usando stream sem cast para char (RESULTADO INESPERADO):");
        "Hello world".chars().forEach(System.out::print);
    }

    private static void helloWorldCorrect() {
        System.out.println("Imprime Hello world usando stream com cast para char (NÃO RECOMENDADO):");
        // Conselho do livro, evite usar streams com valores char
        "Hello world".chars().forEach(letter -> System.out.print((char) letter));
    }

    private static Stream<BigInteger> primes() {
        // retorna uma stream infinita de números primos
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }
    private static void mersennePrime() {
        // número de Mersenne = (2 elevado a x) - 1
        // se x é um número primo, o número de Mersenne correspondente pode ser primo
        // se o número de Mersenne é primo, ele é um primo de Mersenne

        System.out.println("Imprime números de Mersenne que são primos:");

        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(0))
                .limit(20)
                .forEach(mp -> System.out.println("expoente " + mp.bitLength() + ": " + mp));
    }
}
