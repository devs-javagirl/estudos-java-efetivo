import Cap3.*;

public class MainEquals {

    public static void main(String[] args) {

        // Teste para a regra Reflexiva
        testReflexive();

        // Teste para a regra Simétrica
        testSymmetric();

        // Teste para a regra Transitiva
        testTransitive();

        // Teste para a regra Consistente
        testConsistent();

        // Teste para a regra Não Nulo
        testNonNull();
    }

    private static void testReflexive() {
        ReflexiveEquals obj = new ReflexiveEquals(42);
        System.out.println(obj.equals(obj));  // Deve imprimir true
    }

    private static void testSymmetric() {
        //SymmetricEquals obj1 = new SymmetricEquals(42);
        //SymmetricEquals obj2 = new SymmetricEquals(42);
        Cliente obj1 = new Cliente(1, "00380246081", "Gisele");
        Cliente obj2 = new Cliente(2, "00380246082", "Cristiane");

        System.out.println(obj1.equals(obj2));  // Deve imprimir true
        System.out.println(obj2.equals(obj1));  // Deve imprimir true

    }

    private static void testTransitive() {
        TransitiveEquals obj1 = new TransitiveEquals(42);
        TransitiveEquals obj2 = new TransitiveEquals(42);
        TransitiveEquals obj3 = new TransitiveEquals(42);

        System.out.println(obj1.equals(obj2));  // Deve imprimir true
        System.out.println(obj2.equals(obj3));  // Deve imprimir true
        System.out.println(obj1.equals(obj3));  // Deve imprimir true
    }

    private static void testConsistent() {
        ConsistentEquals obj = new ConsistentEquals(42);

        // Repetir o teste várias vezes, o resultado deve ser consistente
        //for (int i = 0; i < 10; i++) {
            ConsistentEquals obj1 = new ConsistentEquals(42);
            System.out.println(obj.equals(obj1));
            obj1.setValue(41);
            System.out.println(obj.equals(obj1));
        //}
    }

    private static void testNonNull() {
        NotNullEquals obj = new NotNullEquals(42);

        System.out.println(obj.equals(null));  // Deve imprimir false
    }
}

