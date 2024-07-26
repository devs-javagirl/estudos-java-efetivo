package Cap7;

import java.util.Comparator;

/**
 * Comparator<T>: Uma interface funcional que define a compara��o entre objetos de tipo T,
 * e apesar de poder ser substitu�da por ToIntBiFunction<T, T>, � usada porque fornece um nome descritivo,
 * tem um contrato forte e m�todos padr�es �teis:
 */
public class CustomFunctionalInterface {
    //O Comparator oferece m�todos padr�es como thenComparing, reversed,
    // e naturalOrder, que s�o extremamente �teis na compara��o e ordena��o de cole��es.
    Comparator<String> comparator = String::compareToIgnoreCase;
    int result = comparator.compare("apple", "Apple");

}
