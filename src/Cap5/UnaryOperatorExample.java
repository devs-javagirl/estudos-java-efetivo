package Cap5;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class UnaryOperatorExample {

  private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

  public static <T> UnaryOperator<T> identityFunction() {
    return (UnaryOperator<T>) IDENTITY_FN;

  }

  public static void main(String[] args) {
    String[] strings = { "jute", "hemp", "nylon"};
    UnaryOperator<String> sameString = identityFunction();
    for (String s : strings) {
      System.out.println(sameString.apply(s));
    }

    Number[] numbers = { 1, 2.0, 3L};
    UnaryOperator<Number> sameNumber = identityFunction();
    for (Number n : numbers) {
      System.out.println(sameNumber.apply(n));
    }

    dateExample();
  }

  public static void dateExample() {
    /* UnaryOperator é uma interface funcional, ou seja,
        possui um único método abstrato -> apply()
        Existem outros métodos que são os default methods, ou seja,
        métodos que possuem uma implementação padrão -> compose() e andThen() e identity()

        Porque utilizar o método identity() ? na programação funcional é muito utilizado,
        flexibilidade para futuras alterações (caso seja necessária uma transformação
        adicional no dado), legibilidade do código (esta explícito que o código retorna
        o próprio objeto).
        A principio a função identity pode parecer desnecessária, mas pode contribuir
        em clareza e flexibilidade.



     */
    UnaryOperator<LocalDate> operator = localDate -> localDate.plusDays(10);

    List<LocalDate> localDates = Arrays.asList(
        LocalDate.of(2022, 4, 1),
        LocalDate.of(2022, 4, 2),
        LocalDate.of(2022, 4, 3));

      // Método verboso, utilizando lambda com chamada do método abstrato
//    List<LocalDate> localDatesIn10Days = localDates.stream()
//        .map(date -> operator.apply(date))
//        .collect(Collectors.toList());

      // Utilização de method reference
//    List<LocalDate> localDatesIn10Days = localDates.stream()
//      .map(operator::apply)
//      .collect(Collectors.toList());

      List<LocalDate> localDatesIn10Days = localDates.stream()
        .map(operator)
        .collect(Collectors.toList());

    System.out.println(localDates); // [2022-04-01, 2022-04-02, 2022-04-03]
    System.out.println(localDatesIn10Days); // [2022-04-11, 2022-04-12, 2022-04-13]
  }
}
