package Cap5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenericsItem26 {

  public record Stamp(String country, double price) {}
  public record Coin(String country, double value) {}

  private static void rawExample() {
    // Coleção bruta sem definição de tipo
    // Permite a inclusão de objetos diferentes

    List stamps = new ArrayList();
    stamps.add(new Stamp("BR", 4.50));
    stamps.add(new Coin("BR", 2.0));

    System.out.println(stamps.get(0));
  }

  private static void rawExampleWithError() {
    // Coleção bruta sem definição de tipo
    // Permite a inclusão de objetos diferentes
    // Apresenta erro quando é feito o cast de (Stamp) para Coin

    Collection stamps = new ArrayList();
    stamps.add(new Stamp("BR", 4.50));
    stamps.add(new Coin("BR", 2.0));

    for (Object stamp : stamps){
      Stamp item = (Stamp) stamp;
      System.out.println(item);
    }

    System.out.println(stamps);
  }

  private static void unsafeAdd(List list, Object o){
    list.add(o);
  }

  private static void bookExample(){
    List<String> strings = new ArrayList<>();
    unsafeAdd(strings, Integer.valueOf(42));
    // Linha abaixo tem cast compilado, por isso apresenta erro ClassCastException
    // ao ler Integer
    String s = strings.get(0);
  }

  private static int rawNumElementsInCommon(Set s1, Set s2) {
    int result = 0;
    for (Object o1 : s1)
      if (s2.contains(o1))
        result++;

    return result;
  }

  private static void rawNumElementsInCommonTestOk() {
    Set s1 = new HashSet();
    s1.add(1);
    s1.add(2);

    Set s2 = new HashSet();
    s2.add(2);
    s2.add(3);

    System.out.println("total de elementos comuns:" + rawNumElementsInCommon(s1, s2));

  }

  private static void rawNumElementsInCommonTestNOK() {
    Set s1 = new HashSet();
    s1.add(1);
    s1.add(2);

    Set s2 = new HashSet();
    s2.add(2.0);
    s2.add(3.0);

    System.out.println("total de elementos comuns:" + rawNumElementsInCommon(s1, s2));

  }

  private static int rawNumElementsInCommonTypeSafe(Set<?> s1, Set<?> s2) {
    int result = 0;
    for (Object o1 : s1)
      if (s2.contains(o1))
        result++;

    return result;
  }

  private static void rawNumElementsInCommonTypeSafeTest() {
    Set s1 = new HashSet();
    s1.add(1);
    s1.add(2);

    Set s2 = new HashSet();
    s2.add(2);
    s2.add(3);

    System.out.println("total de elementos comuns:" + rawNumElementsInCommonTypeSafe(s1, s2));

  }

  private static void rawNumElementsInCommonTypeSafeTestNOK() {
   Set<?> s1 = new HashSet();
    s1.add(null);

    Set s2 = new HashSet();
    s2.add(2.0);
    s2.add(3.0);

    System.out.println("total de elementos comuns:" + rawNumElementsInCommonTypeSafe(s1, s2));

  }
  public static void main(String[] args) {
    //rawExample();
    //rawExampleWithError();
    //bookExample();
    //rawNumElementsInCommonTestOk();
    //rawNumElementsInCommonTestNOK();
    rawNumElementsInCommonTypeSafeTestNOK();

  }

}
