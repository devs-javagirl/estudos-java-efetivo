package Cap5;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetGenericTest {

    @Test
    void setGenericTest() {
        SetGeneric setGeneric = new SetGeneric();
        Set<String> s1 = new HashSet<>();
        s1.addAll(Arrays.asList("test1", "test2"));
        System.out.println(s1);

        Set<String> s2 = new HashSet<>();
        s2.addAll(Arrays.asList("test10", "test20"));
        System.out.println(s2);


        Set<String> result = setGeneric.union(s1, s2);
        System.out.println(result);

        assertTrue(result.contains("test1"));
        assertTrue(result.contains("test10"));


    }

    @Test
    void linkedHashSetGenericTest() {
        SetGeneric setGeneric = new SetGeneric();
        Set<String> s1 = new LinkedHashSet<>();
        s1.addAll(Arrays.asList("test3", "test1", "test2"));
        System.out.println(s1);

        Set<String> s2 = new LinkedHashSet<>();
        s2.addAll(Arrays.asList("test10", "test30", "test20"));

        System.out.println(s2);

        Set<String> result = setGeneric.union(s1, s2);
        System.out.println(result);

        assertTrue(result.contains("test1"));
        assertTrue(result.contains("test10"));

    }

    @Test
    void linkedTreeSetGenericTest() {
        SetGeneric setGeneric = new SetGeneric();
        Set<String> s1 = new TreeSet<>();
        s1.addAll(Arrays.asList("test2", "test1", "test3"));
        System.out.println(s1);

        Set<String> s2 = new TreeSet<>();
        s2.addAll(Arrays.asList("test30", "test10", "test20"));

        System.out.println(s2);

        Set<String> result = setGeneric.union(s1, s2);
        System.out.println(result);

        assertTrue(result.contains("test1"));
        assertTrue(result.contains("test10"));

    }

    @Test
    void integerSetTest() {
        Set<Integer> s1 = Set.of(9, 2, 1, 5, 8);
        Set<Integer> s2 = Set.of(40, 30, 10, 50);

        SetGeneric setGeneric = new SetGeneric();
        Set<Integer> result = setGeneric.union(s1, s2);

        System.out.println(result);

        assertTrue(result.contains(8));
        assertTrue(result.contains(10));
    }
}
