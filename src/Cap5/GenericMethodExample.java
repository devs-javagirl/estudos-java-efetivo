package Cap5;
import java.util.Arrays;
import java.util.List;

public class GenericMethodExample {
    // Método genérico para encontrar o maior elemento em uma lista
    public static <T extends Comparable<T>> T findMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }
        T max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).compareTo(max) > 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 7, 4, 2);
        System.out.println("Maior elemento: " + findMax(numbers));

        List<String> words = Arrays.asList("banana", "apple", "orange", "grape", "kiwi");
        System.out.println("Maior elemento: " + findMax(words));
    }
}

