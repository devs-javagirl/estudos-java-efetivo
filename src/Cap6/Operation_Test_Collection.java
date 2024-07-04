package Cap6;

import java.util.Arrays;
import java.util.Collection;

public class Operation_Test_Collection {
    public static void main(String[] args) {
        double x = 2.0;
        double y = 2.0;
        test(Arrays.asList(Operation_Extended.values()), x, y);
        test(Arrays.asList(Operation_Basic.values()), x, y);
    }

    private static void test (
            Collection<? extends Operation_> opSet, double x, double y) {

        for (Operation_ op: opSet)
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}
