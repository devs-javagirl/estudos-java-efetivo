package Cap5;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericStack<E> {
    private E[] elements;
    private static int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public GenericStack() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // Elimina a referência para evitar vazamento de memória
        return result;
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }

    public static <E> boolean isEmpty() {
        return size == 0;
    }
}

