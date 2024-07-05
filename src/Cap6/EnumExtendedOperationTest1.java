package Cap6;

public class EnumExtendedOperationTest1 {
    public static void main(String[] args) {
        double x = 4;
        double y = 2;

        test(EnumExtendedOperation.class, x, y);
    }

    private static <T extends Enum<T> & Operation> void test(Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
