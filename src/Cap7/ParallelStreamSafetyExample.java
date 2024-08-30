package Cap7;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamSafetyExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("parallel", "stream", "example", "failure");

        // Redução incorreta que não é thread-safe
        String concatenatedWords = words.parallelStream()
                .reduce("", (s1, s2) -> s1 + s2);

        System.out.println("Resultado: " + concatenatedWords);
    }
}
