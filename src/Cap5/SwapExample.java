package Cap5;

import java.util.ArrayList;
import java.util.List;

public class SwapExample {

    // Método usando wildcards
    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    // Método auxiliar para capturar o tipo wildcard
    private static <E> void swapHelper(List<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    // Exemplo de uso
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");

        System.out.println("Antes da troca: " + strings);

        swap(strings, 1, 3);

        System.out.println("Depois da troca: " + strings);
    }
}

