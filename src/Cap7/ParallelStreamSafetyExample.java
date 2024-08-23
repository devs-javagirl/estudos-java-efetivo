package Cap7;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamSafetyExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("parallel", "stream", "example", "failure");

        // Redu��o incorreta que n�o � thread-safe
        String concatenatedWords = words.parallelStream()
                .reduce("", (s1, s2) -> s1 + s2);

        System.out.println("Resultado: " + concatenatedWords);
    }
}
