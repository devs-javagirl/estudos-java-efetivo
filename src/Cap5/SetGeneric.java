package Cap5;

import java.util.Set;
import java.util.TreeSet;

public class SetGeneric {

  public <E> Set<E> union(Set<E> s1, Set<E> s2) {
    Set<E> result = new TreeSet<>(s1);
    result.addAll(s2);
    return result;
  }

}
