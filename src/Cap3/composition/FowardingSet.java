package Cap3.composition;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


public class FowardingSet<E> implements Set<E> {
  private final Set<E> s;

  public FowardingSet(Set<E> s) {
    this.s = s;
  }

   public int size() {
    return s.size();
  }

  public boolean isEmpty() {
    return s.isEmpty();
  }

  public boolean contains(Object o) {
    return s.contains(o);
  }

  public Iterator<E> iterator() {
    return s.iterator();
  }

  public Object[] toArray() {
    return s.toArray();
  }

  public <T> T[] toArray(T[] a) {
    return s.toArray(a);
  }

  public boolean add(E e) {
    return s.add(e);
  }

  public boolean remove(Object o) {
    return s.remove(o);
  }

  public boolean containsAll(Collection<?> c) {
    return s.containsAll(c);
  }

  public boolean addAll(Collection<? extends E> c) {
    return s.addAll(c);
  }

  public boolean retainAll(Collection<?> c) {
    return s.retainAll(c);
  }

  public boolean removeAll(Collection<?> c) {
    return s.removeAll(c);
  }

  public void clear() {
    s.clear();
  }
}
