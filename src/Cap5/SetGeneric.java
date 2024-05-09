package Cap5;

import java.util.Set;
import java.util.TreeSet;

public class SetGeneric {

  //método sem generics com advertências
  public Set unionError(Set s1, Set s2) {
    Set result = new TreeSet<>(s1);
    result.addAll(s2);
    return result;
  }


  // O primeiro <E> tipo de parametro
  // O segundo <E> tipo de retorno do metodo
  public <E> Set<E> union(Set<E> s1, Set<E> s2) {
    Set<E> result = new TreeSet<>(s1);
    result.addAll(s2);
    return result;
  }


}
