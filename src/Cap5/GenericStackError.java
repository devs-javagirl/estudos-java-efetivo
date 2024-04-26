package Cap5;

import java.util.Arrays;
import java.util.EmptyStackException;

public class GenericStackError<E> {
    private E[] elements;
    private static int size = 0;
    private static final int DEFAULT_CAPACITY = 16;


    @SuppressWarnings("unchecked")
    public GenericStackError() {
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

