package Cap6;

public class Operation_Test {

    public static void main(String[] args) {
        double x = 2.0;
        double y = 2.0;
        test(Operation_Extended.class, x, y);
        test(Operation_Basic.class, x, y);
        test(EnumBasicOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation_> void test (
        Class<T> opEnumType, double x, double y) {

        for (Operation_ op: opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}
