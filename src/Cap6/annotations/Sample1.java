package Cap6.annotations;

public class Sample1 {
    @Testy public static void m1() { } // Deve passar
    public static void m2() { }
    @Testy public static void m3() { throw new RuntimeException("Falhou"); } // Deve falhar
    public static void m4() { }
    @Testy public void m5() { } // Inválido: método de instância
    @Testy public static void m6() { } // Deve passar
    @Testy public static void m7() { throw new RuntimeException("Falhou"); } // Deve falhar
}

