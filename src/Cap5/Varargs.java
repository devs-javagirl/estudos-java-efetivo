package Cap5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Varargs {

  static void dangerous(List<String>... stringLists){
    List<Integer> intList = List.of(42);
    Object[] objects = stringLists;
    System.out.println(objects[0]);
    objects[0] = intList;
    System.out.println(objects[0]);
    /* Linha abaixo com erro, pois foi inserida uma lista de Integer num objeto que contém
       List<String>. O compilador faz um cast invisível
       class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')

    */
    String s = stringLists[0].get(0);

  }

  static <T> T[] toArray(T... args) {
    return args;
  }
  static <T> T[] pickTwo(T a, T b, T c) {
    switch(ThreadLocalRandom.current().nextInt(3)) {
      case 0: return toArray(a, b);
      case 1: return toArray(a, c);
      case 2: return toArray(b, c);
    }
    throw new AssertionError();
  }

  /*
    Método abaixo sem anotação @SafeVarargs, apresenta warning:
    Possible heap pollution from parametrized vararg type
   */
  @SafeVarargs
  static <T> List<T> flatten(List<? extends T>... lists) {
    List<T> result = new ArrayList<>();
    for (List<? extends T> list: lists)
      result.addAll(list);

    return result;

  }

  static <T> List<T> flattenGenerics(List<List<? extends T>> lists) {
    List<T> result = new ArrayList<>();
    for (List<? extends T> list: lists)
      result.addAll(list);

    return result;
  }

  static <T> List<T> pickTwoGenerics(T a, T b, T c) {
    switch(ThreadLocalRandom.current().nextInt(3)) {
      case 0: return List.of(a, b);
      case 1: return List.of(a, c);
      case 2: return List.of(b, c);
    }
    throw new AssertionError();
  }
  public static void main(String[] args) {
//    List<String> list1 = List.of("a", "b", "c");
//    List<String> list2 = List.of("d", "e", "f");
//    dangerous(list1, list2);

    /*
     Ocorre erro pq existe um cast oculto para String[], sendo que a
     função pickTwo retorna Object[] (que não e subtipo de String)
     ClassCastException: class [Ljava.lang.Object; cannot be cast to class [Ljava.lang.String; ([Ljava.lang.Object; and [Ljava.lang.String; are in module java.base of loader 'bootstrap')
     */
    //String[] attributes = pickTwo("Good", "Fast", "Cheap");

    /*
      Método utiliza varargs e precisa da notação @SafeVarargs para não exibir warning
     */
//    List<String> list1 = List.of("a", "b", "c");
//    List<String> list2 = List.of("d", "e", "f");
//    System.out.println(flatten(list1, list2));

    /*
      Método mais verboso, porém type safe porque utiliza generics ao invés de array
     */
//    List<String> list1 = List.of("a", "b", "c");
//    List<String> list2 = List.of("d", "e", "f");
//    System.out.println(flattenGenerics(List.of(list1, list2)));

    /*
      Método abaixo utiliza generics, portanto é typesafe
     */
    List<String> attributes = pickTwoGenerics("Good", "Fast", "Cheap");
    System.out.println(attributes);
  }
}
