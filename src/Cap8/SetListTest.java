package Cap8;

import java.util.ArrayList;
import java.util.TreeSet;
import java.util.List;
import java.util.Set;

public class SetListTest {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }

        System.out.println(set + " " + list);

        /*
            Here?s what?s happening: The call to set.remove(i) selects the
            overloading remove(E), where E is the element type of the set (Integer),
            and autoboxes i from int to Integer. This is the behavior you?d expect, so
            the program ends up removing the positive values from the set. The call to
            list.remove(i), on the other hand, selects the overloading remove(int
            i), which removes the element at the specified position in the list
        */


        // To fix the problem, cast list.remove?s argument to Integer, forcing the correct overloading to be selected.
        Set<Integer> set2 = new TreeSet<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = -3; i < 3; i++) {
            set2.add(i);
            list2.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set2.remove(i);
            list2.remove((Integer) i);
        }

        System.out.println(set2 + " " + list2);
    }
}
