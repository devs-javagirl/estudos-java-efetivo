package Cap5;

import java.util.Arrays;
import java.util.List;

public class NonGenericMethodExample {
    // Método para encontrar o maior elemento em uma lista de inteiros
    public static int findMax(List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Lista vazia");
        }
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 1, 7, 4, 2);
        System.out.println("Maior elemento: " + findMax(numbers));
    }
}

