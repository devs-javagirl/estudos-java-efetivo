package Cap7;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExemplo1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        //lambda
        Collections.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        //reference method
        Collections.sort(words, Comparator.comparingInt(String::length));

        System.out.println(words);
    }
}
