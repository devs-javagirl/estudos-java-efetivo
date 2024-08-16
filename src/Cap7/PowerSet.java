package Cap7;

import java.util.*;

public final class PowerSet {
    /*
    Exemplo de PowerSet (Conjunto Potência) como uma Collection Customizada:
    Implementação do Conjunto Potência:
    */
    public static <E> Collection<Set<E>> of(Set<E> s) {
        List<E> src = new ArrayList<>(s);
        if (src.size() > 30) {
            throw new IllegalArgumentException("Set too big");
        }
        return new AbstractList<Set<E>>() {
            @Override
            public int size() {
                return 1 << src.size();
            }
            @Override
            public boolean contains(Object o) {
                return o instanceof Set && src.containsAll((Set<?>) o);
            }
            @Override
            public Set<E> get(int index) {
                Set<E> result = new HashSet<>();
                for (int i = 0; index != 0; i++, index >>= 1) {
                    if ((index & 1) == 1) {
                        result.add(src.get(i));
                    }
                }
                return result;
            }
        };
    }
}

