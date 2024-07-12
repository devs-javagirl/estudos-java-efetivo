package Cap6.annotations;

public class Sample1 {
    @Test public static void m1() { } // Deve passar
    public static void m2() { }
    @Test public static void m3() { throw new RuntimeException("Falhou"); } // Deve falhar
    public static void m4() { }
    @Test public void m5() { } // Inválido: método de instância
    @Test public static void m6() { } // Deve passar
    @Test public static void m7() { throw new RuntimeException("Falhou"); } // Deve falhar
}

