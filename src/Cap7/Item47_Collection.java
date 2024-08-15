package Cap7;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Item47_Collection {

    // Não entendi o uso desta função
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static <E> Stream<List<E>> of (List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start ->
                        IntStream.rangeClosed(start + 1, list.size())
                                .mapToObj(end -> list.subList(start, end)))
                .flatMap(x -> x);
    }

    public static void main(String[] args) {
        List<String> list = List.of("um", "dois", "três", "quatro");
        list.forEach(number -> System.out.println(number));
        for(String number: list){
            System.out.println(number);
        }

        Stream<String> stream = Stream.of("um", "dois", "três", "quatro");
        stream.forEach(number -> System.out.println(number));
        // Não é possível fazer o forEach acima 2 vezes, apresenta o erro abaixo
        // stream has already been operated upon or closed

        // O comando For abaixo não funciona com stream
        // for (String number: stream) {
        //    System.out.println(number);
        // }

        System.out.println("Exemplo utilizando método streamOf");
        Stream<String> st = streamOf(list);
        st.forEach(number -> System.out.println(number));

        System.out.println("Exemplo de conjunto utilizando stream a partir de uma lista");
        List<String> conjunto = List.of("a", "b", "c");
        Stream<List<String>> conjunto_stream = Item47_Sublists.of(conjunto);
        conjunto_stream.forEach(cjto -> System.out.println(cjto));

        System.out.println("Segundo exemplo de conjunto utilizando stream a partir de uma lista");
        Stream<List<String>> conjunto_stream2 = of(conjunto);
        conjunto_stream2.forEach(cjto -> System.out.println(cjto));


    }


}
