package Cap6.annotations;

import java.lang.reflect.Method;

public class RunTests1 {
    public static void main(String[] args) throws Exception {
        // Verifica se o array args está vazio e adiciona um elemento se necessário
        if (args.length == 0) {
            args = new String[1];
        }
        // Seta valor no args de classe args Cap6.annotations.Sample1
        args[0] = "Cap6.annotations.Sample1";
        if (args[0].isEmpty()) {
            throw new IllegalArgumentException("Nome da classe de teste não fornecido");
        }
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Teste %s falhou: %s %n", m, ex.getCause());
                }
            }
        }
        System.out.printf("Passaram: %d, Falharam: %d%n", passed, tests - passed);
    }

}

