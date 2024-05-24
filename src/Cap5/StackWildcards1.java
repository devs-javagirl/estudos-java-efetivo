package Cap5;

import java.util.ArrayList;
import java.util.List;

public class StackWildcards1<E> {

        private final List<E> elements = new ArrayList<>();

        public void push(E e) {
            elements.add(e);
        }

        public E pop() {
            if (elements.isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return elements.remove(elements.size() - 1);
        }

        // Método original
//         public void pushAll(Iterable<E> src) {
//             for (E e : src) {
//                 push(e);
//             }
//         }

        // Método modificado usando wildcards
        public void pushAll(Iterable<? extends E> src) {
            for (E e : src) {
                push(e);
            }
        }

        // Exemplo de uso
        public static void main(String[] args) {
            StackWildcards1<Number> numberStack1 = new StackWildcards1<>();
            List<Long> longs = List.of(1L, 2L, 3L);
            List<Integer> integers = List.of(1, 2, 3);
            List<Double> doubles = List.of(1.5, 2.2, 3.4);

            // Funciona com o método modificado
            numberStack1.pushAll(longs);
            numberStack1.pushAll(integers);
            numberStack1.pushAll(doubles);

            while (!numberStack1.elements.isEmpty()) {
                System.out.println(numberStack1.pop());
            }
        }
    }

