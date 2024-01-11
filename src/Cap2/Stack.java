package Cap2;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    //Em termos práticos, ela administra a própria memória.

    private Object[] elements;
    private int size = 0; //ponteiro
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    //aumenta
    public void push(Object e) {
        System.out.println(elements.length);
        ensureCapacity();
        elements[size++] = e;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    //diminui
    public Object pop() {
        if(size == 0)
            throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; //eliminando as refs obsoletas
        return result;
    }
}
