package Cap7;

import java.util.Comparator;

/**
 * Comparator<T>: Uma interface funcional que define a comparação entre objetos de tipo T,
 * e apesar de poder ser substituída por ToIntBiFunction<T, T>, é usada porque fornece um nome descritivo,
 * tem um contrato forte e métodos padrões úteis:
 */
public class CustomFunctionalInterface {
    //O Comparator oferece métodos padrões como thenComparing, reversed,
    // e naturalOrder, que são extremamente úteis na comparação e ordenação de coleções.
    Comparator<String> comparator = String::compareToIgnoreCase;
    int result = comparator.compare("apple", "Apple");

}
