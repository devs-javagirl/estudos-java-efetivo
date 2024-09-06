package Cap8;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigInteger;

public class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    //Opção de correção do método para que sejam impressas as strings de cada subtipo:
    // public static String classify(Collection<?> c) {
    //     return c instanceof Set ? "Set" :
    //     c instanceof List ? "List" : "Unknown Collection";
    // }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(classify(c));
            // Todas são consiedradas Collections, que é a classe mãe.
            // Printa 3x Unknown
        }
    }
}

