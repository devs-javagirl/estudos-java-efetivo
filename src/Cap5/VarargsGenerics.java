package Cap5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VarargsGenerics {

    public static void main(String[] args) {
        dangerous("um", "dois", "três");

        String[] strings = toArray("um", "dois", "três");

        List<String> list = safeList("um", "dois", "três");

        printElements("um", "dois", "três");

        List<String> list1 = List.of("um");
        List<String> list2 = List.of("dois", "três");
        List<String> combined = safeFlatten(list1, list2);
        System.out.println(combined);

    }

    public static <T> void dangerous(T... args) {
        // Este método não parece perigoso, mas lança ClassCastException.
        List<String> stringList = (List<String>) Arrays.asList(args);
    }

    public static <T> T[] toArray(T... args) {
        return args;
    }

    @SafeVarargs
    public static <T> List<T> safeList(T... elements) {
        return Arrays.asList(elements);
    }

    @SafeVarargs
    public static <T> void printElements(T... elements) {
        for (T element : elements) {
            System.out.println(element);
        }
    }

    public static <T> List<T> safeFlatten(List<T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<T> list : lists) {
            result.addAll(list);
        }
        return result;
    }

}
