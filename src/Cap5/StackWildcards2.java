package Cap5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class StackWildcards2<E> {
    private List<E> elements = new ArrayList<>();

    public void push(E e) {
        elements.add(e);
    }

    public E pop() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public void pushAll(Iterable<? extends E> src) {
        for (E e : src) {
            push(e);
        }
    }

    // Método original (retirada)
//     public void popAll(Collection<E> dst) {
//         while (!elements.isEmpty()) {
//             dst.add(pop());
//         }
//     }

    // Método modificado usando wildcards
    public void popAll(Collection<? super E> dst) {
        while (!elements.isEmpty()) {
            dst.add(pop());
        }
    }

    // Exemplo de uso
    public static void main(String[] args) {
        StackWildcards2<Number> numberStack = new StackWildcards2<>();
        numberStack.push(1.5);
        numberStack.push(2);

        Collection<Object> objects = new ArrayList<>();
        numberStack.popAll(objects);

        for (Object o : objects) {
            System.out.println(o);
        }
    }
}

