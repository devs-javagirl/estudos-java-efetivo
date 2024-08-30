package Cap7;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PowerSetDemo {

    /*
    Esses exemplos demonstram como você pode lidar com a questão de escolher o tipo de retorno
    adequado para métodos que retornam sequências de elementos, e como implementar soluções práticas
    quando Collection, Stream, ou Iterable são mais apropriados.
     */
    public static void main(String[] args) {

        //Iteração sobre Conjuntos Potência:
        Set<Integer> set = Set.of(1, 2, 3);
        Collection<Set<Integer>> powerSet = PowerSet.of(set);
        for (Set<Integer> subset : powerSet) {
            System.out.println(subset);
        }

        //Uso da Função para Gerar Sublistas:
        List<String> list = List.of("a", "b", "c");
        subLists(list).forEach(System.out::println);

    }

    //Gerando Sublistas de uma Lista com Stream:
    public static <E> Stream<List<E>> subLists(List<E> list) {
        return IntStream.rangeClosed(0, list.size())
                .mapToObj(start -> IntStream.rangeClosed(start, list.size())
                        .mapToObj(end -> list.subList(start, end)))
                .flatMap(x -> x);
    }


    //Concatenando Streams para Adicionar a Lista Vazia:
    public static <E> Stream<List<E>> subLists2(List<E> list) {
        return Stream.concat(
                Stream.of(Collections.emptyList()),
                IntStream.range(0, list.size())
                        .mapToObj(start -> IntStream.rangeClosed(start + 1, list.size())
                                .mapToObj(end -> list.subList(start, end)))
                        .flatMap(x -> x)
        );
    }

}
