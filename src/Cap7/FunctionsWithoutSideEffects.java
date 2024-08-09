package Cap7;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class FunctionsWithoutSideEffects {


    private static Map<String, Long> wrongFrequency(List<String> words) {
        //não use forEach em streams com variaveis externas
        Map<String, Long> wordFrequency = new HashMap<>();
        words.stream().forEach(word -> {
            wordFrequency.merge(word.toLowerCase(), 1L, Long::sum);
        });
        return wordFrequency;
    }

    private static Map<String, Long> frequencyStream(List<String> words) {
        Map<String, Long> wordFrequency = new HashMap<>();
        wordFrequency.putAll(words.stream().collect(groupingBy(String::toLowerCase, counting())));
        return wordFrequency;

    }

    private static List<String> get3MoreUsedWords(Map<String, Long> words) {
        return words.keySet().stream()
                .sorted(comparing(words::get).reversed())
                .limit(3)
                .collect(toList());
    }

    private enum Talheres {
        GARFO,
        COLHER,
        FACA
    }

    private static final Map<String, Talheres> stringToEnum = Stream.of(Talheres.values()).collect(toMap(Object::toString, e -> e));

    record Album (Artist artist, String albumName, int sales){ }
    record Artist (String name) { }

    private static Map<Artist, Album> getArtistLatestAlbum(List<Album> albums) {
        return albums.stream().collect(
                toMap(Album::artist, album -> album, (v1, v2) -> v2));
    }


    private static  Map<Artist, Album> getArtistTopSales(List<Album> albums) {
        Map<Artist, Album> topAlbums = albums.stream()
                .collect(Collectors.toMap(
                        Album::artist,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(Album::sales))
                ));
        return topAlbums;
    }


    public static void main(String[] args) {
        List<String> words = List.of("casa", "prato", "garfo", "colher", "faca", "casa", "casa", "faca", "garrafa", "guardanapo",
                "copo", "garrafa", "caneca", "caneta", "lápis", "estojo", "borracha", "régua", "tesoura", "pincel", "bucha", "detergente");

        System.out.println(wrongFrequency(words));

        System.out.println(frequencyStream(words));

        System.out.println(get3MoreUsedWords(frequencyStream(words)));

        System.out.println(stringToEnum);

        List<Album> albums = new ArrayList<>();

        albums.add(new Album(new Artist("Mozart"), "Sinfonia 5", 50000));
        albums.add(new Album(new Artist("Mozart"), "Sinfonia 10", 10000));
        albums.add(new Album(new Artist("Vivaldi"), "As quatro estações", 10010));

        System.out.println(getArtistLatestAlbum(albums));

        System.out.println(getArtistTopSales(albums));

    }
}
