package Cap5;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxExample {

    // Método original
//     public static <T extends Comparable<T>> T max(List<T> list) {
//         if (list.isEmpty()) {
//             throw new IllegalArgumentException("List is empty");
//         }
//         T max = list.get(0);
//         for (T item : list) {
//             if (item.compareTo(max) > 0) {
//                 max = item;
//             }
//         }
//         return max;
//     }

    // Método modificado usando wildcards
    public static <T> T max(List<? extends T> list, Comparator<? super T> comparator) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        T max = list.get(0);
        for (T item : list) {
            if (comparator.compare(item, max) > 0) {
                max = item;
            }
        }
        return max;
    }

    // Exemplo de uso
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Integer maxNumber = max(numbers, Comparator.naturalOrder());
        System.out.println("Máximo número: " + maxNumber);
    }
}
