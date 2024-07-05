package Cap6;

import Cap6.EnumBasicOperation;
import Cap6.EnumExtendedOperation;
import Cap6.Operation;

import java.util.*;

public class EnumExtendedOperationTest2 {
    public static void main(String[] args) {
        double x = 4;
        double y = 2;

        List<Operation> operations = new ArrayList<>();
        //operations.addAll(Arrays.asList(EnumBasicOperation.values()));
        operations.addAll(Arrays.asList(EnumExtendedOperation.values()));

        test(operations, x, y);
    }

    //  tipo wildcard limitado
    private static void test(Collection<? extends Operation> operations, double x, double y) {
        for (Operation op : operations) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
