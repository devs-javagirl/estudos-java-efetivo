package Cap6.annotations;

import java.lang.reflect.Method;
import java.util.Arrays;

public class RunTests3 {
    public static void main(String[] args) throws Exception {
        // Verifica se o array args está vazio e adiciona um elemento se necessário
        if (args.length == 0) {
            args = new String[1];
        }
        // Seta valor no args de classe args Cap6.annotations.Sample3
        args[0] = "Cap6.annotations.Sample3";
        if (args[0].isEmpty()) {
            throw new IllegalArgumentException("Nome da classe de teste não fornecido");
        }
        int tests = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Testy.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Teste %s falhou: %s %n", m, ex.getCause());
                }
            } else if (m.isAnnotationPresent(ExceptionTestArray.class)) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.printf("Teste %s falhou: não lançou exceção%n", m);
                } catch (Throwable ex) {
                    Throwable cause = ex.getCause();
                    Class<? extends Throwable>[] excTypes = m.getAnnotation(ExceptionTestArray.class).value();
                    int oldPassed = passed;
                    for (Class<? extends Throwable> excType : excTypes) {
                        if (excType.isInstance(cause)) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.printf("Teste %s falhou: lançou %s esperado %s%n", m, cause, Arrays.toString(excTypes));
                    }
                }
            }
        }
        System.out.printf("Passaram: %d, Falharam: %d%n", passed, tests - passed);
    }
}

