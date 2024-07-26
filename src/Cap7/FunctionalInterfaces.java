package Cap7;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaces {
    public static void main(String[] args) {

        //Predicate<T>: Usado para testar uma condição, como verificar se uma coleção está vazia
        Collection<?> someCollection = null;
        Predicate<Collection<?>> isEmpty = Collection::isEmpty;
        boolean result = isEmpty.test(someCollection);

        //Function<T, R>: Usado para converter uma lista de strings para uma lista de inteiros:
        Function<String, Integer> toInteger = Integer::valueOf;
        Optional<String> stringList = null;
        List<Integer> integerList = stringList.stream()
                .map(toInteger)
                .collect(Collectors.toList());

        //Consumer<T>: Usado para consumir um valor sem retornar nada, como imprimir valores:
        Consumer<String> print = System.out::println;
        print.accept("Hello, world!");

        //Supplier<T>: Usado para fornecer um valor sem entrada, como fornecer o instante atual:
        Supplier<Instant> now = Instant::now;
        Instant currentTime = now.get();

    }
}
