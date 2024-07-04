package Cap6;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    Reflection é um termo usado para indicar a capacidade de obter metadados sobre o próprio programa compilado.
    Como assim, metadados?
    Obter informações sobre os tipos de dados, de forma dinâmica, é muito importante para códigos que atuam sobre
    objetos que não se conhece em tempo de design. É muito usado em bibliotecas que se propõem a lidar com objetos de
    tipos que elas desconhecem em sua concepção.
    #stackoverflow
 */
public class AnnotationTest {
    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = Class.forName("Cap6.Annotation");
        // A linha abaixo foi adicionada, pois precisa ser repassado o objeto para m.invoke (linha 22)
        // o método newInstance está depreciado, por isso foi utilizada a declaração abaixo
        Object object = testClass.getDeclaredConstructor().newInstance();

        for (Method m: testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(object);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);

                } catch (Exception exc) {
                    System.out.println("Invalid @Test " + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, tests - passed);
    }
}
