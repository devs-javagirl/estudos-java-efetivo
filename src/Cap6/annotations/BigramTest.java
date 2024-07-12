package Cap6.annotations;

import java.util.HashSet;
import java.util.Set;

public class BigramTest {
    public static void main(String[] args) {
        // Uso:
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));
        System.out.println(s.size()); // Esperado: 26, Real: 260
    }
}
