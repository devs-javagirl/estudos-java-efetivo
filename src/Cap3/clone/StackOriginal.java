package Cap3.clone;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackOriginal implements Cloneable {
  private Object[] elements;
  private int size = 0;
  private static final int DEFAULT_INITIAL_CAPACITY = 16;

  public StackOriginal() {
    this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
  }

  public void push(Object e) {
    ensureCapacity();
    elements[size++] = e;
  }

  public Object pop() {
    if (size == 0)
      throw new EmptyStackException();
    Object result = elements[--size];
    elements[size] = null;
    return result;
  }

  private void ensureCapacity() {
    if (elements.length == size)
      elements = Arrays.copyOf(elements, 2 * size + 1);
  }

  @Override
  protected StackOriginal clone() throws CloneNotSupportedException {
    return (StackOriginal)super.clone();
  }

  @Override
  public String toString() {
    return "StackOriginal{" +
        "elements=" + Arrays.toString(elements) +
        ", size=" + size +
        '}';
  }
}
