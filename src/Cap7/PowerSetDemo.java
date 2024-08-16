package Cap7;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PowerSetDemo {

    /*
    Esses exemplos demonstram como voc� pode lidar com a quest�o de escolher o tipo de retorno
    adequado para m�todos que retornam sequ�ncias de elementos, e como implementar solu��es pr�ticas
    quando Collection, Stream, ou Iterable s�o mais apropriados.
     */
    public static void main(String[] args) {

        //Itera��o sobre Conjuntos Pot�ncia:
        Set<Integer> set = Set.of(1, 2, 3);
        Collection<Set<Integer>> powerSet = PowerSet.of(set);
        for (Set<Integer> subset : powerSet) {
            System.out.println(subset);
        }

        //Uso da Fun��o para Gerar Sublistas:
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
