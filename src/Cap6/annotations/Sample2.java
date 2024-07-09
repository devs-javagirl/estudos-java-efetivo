package Cap6.annotations;

public class Sample2 {
    @ExceptionTesty(ArithmeticException.class)
    public static void m1() { // Deve passar
        int i = 1 / 0;
    }

    @ExceptionTesty(ArithmeticException.class)
    public static void m2() { // Deve falhar (sem exceção)
        int i = 1 / 1;
    }

    @ExceptionTesty(ArithmeticException.class)
    public static void m3() { // Deve falhar (exceção errada)
        throw new NullPointerException();
    }
}

