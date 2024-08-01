package Cap7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Anagramas {

    // Versão 1: Iterativa
    public static Map<String, List<String>> encontrarAnagramasIterativo(String filePath) throws IOException {
        Map<String, List<String>> anagramMap = new HashMap<>();
        List<String> words = Files.readAllLines(Paths.get(filePath));

        for (String word : words) {
            String sorted = alphabetize(word);
            List<String> anagramList = anagramMap.get(sorted);
            if (anagramList == null) {
                anagramList = new ArrayList<>();
                anagramMap.put(sorted, anagramList);
            }
            anagramList.add(word);
        }
        return anagramMap;
    }

    // Versão 2: Streams intensivo
    public static Map<String, List<String>> encontrarAnagramasStream(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .collect(Collectors.groupingBy(Anagramas::alphabetize));
    }

    // Versão 3: Híbrido
    public static Map<String, List<String>> encontrarAnagramasHibrido(String filePath) throws IOException {
        Map<String, List<String>> anagramMap = new HashMap<>();
        try (var lines = Files.lines(Paths.get(filePath))) {
            lines.forEach(word -> {
                String sorted = alphabetize(word);
                anagramMap.computeIfAbsent(sorted, k -> new ArrayList<>()).add(word);
            });
        }
        return anagramMap;
    }

    // Método para ordenar as letras de uma palavra
    private static String alphabetize(String word) {
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Método principal para executar o programa
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\javatest\\dictionary.txt"; // Insira o caminho para o arquivo de palavras

        /**
         * Exemplo de arquivo de palavras:
         * listen
         * silent
         * enlist
         * inlets
         * google
         * gigolo
         * abc
         * cab
         * bac
         * fired
         * fried
         * god
         * dog
         * log
         * golf
         * flog
         */

        // Versão 1: Iterativa
        System.out.println("Anagramas (Iterativo):");
        Map<String, List<String>> anagramasIterativo = encontrarAnagramasIterativo(filePath);
        imprimirAnagramas(anagramasIterativo);

        // Versão 2: Streams intensivo
        System.out.println("Anagramas (Streams):");
        Map<String, List<String>> anagramasStream = encontrarAnagramasStream(filePath);
        imprimirAnagramas(anagramasStream);

        // Versão 3: Híbrido
        System.out.println("Anagramas (Híbrido):");
        Map<String, List<String>> anagramasHibrido = encontrarAnagramasHibrido(filePath);
        imprimirAnagramas(anagramasHibrido);
    }

    // Método auxiliar para imprimir os anagramas
    private static void imprimirAnagramas(Map<String, List<String>> anagramMap) {
        anagramMap.values().stream()
                .filter(list -> list.size() > 1)
                .forEach(System.out::println);
    }

    /**
     Descrição
     Grupo de Anagramas 1: "listen", "silent", "enlist", "inlets" - Todas essas palavras contêm as mesmas letras.
     Grupo de Anagramas 2: "google", "gigolo" - Compartilham as mesmas letras, exceto a quantidade de 'o's.
     Grupo de Anagramas 3: "abc", "cab", "bac" - Todas essas palavras contêm as mesmas letras.
     Grupo de Anagramas 4: "fired", "fried" - Compartilham as mesmas letras.
     Grupo de Anagramas 5: "god", "dog" - Contêm as mesmas letras.
     Grupo de Anagramas 6: "log" - Sem anagramas correspondentes neste exemplo.
     Grupo de Anagramas 7: "golf", "flog" - Contêm as mesmas letras.
     Esse exemplo abrange uma variedade de casos, incluindo palavras que formam anagramas com outras e
     algumas que não têm anagramas no conjunto. Isso ajudará a testar a funcionalidade dos diferentes métodos
     de agrupamento de anagramas.
     */
}
