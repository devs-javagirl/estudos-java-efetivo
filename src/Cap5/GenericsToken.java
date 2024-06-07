package Cap5;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;

public class GenericsToken {

    /* token limitado por tipo */

    public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
        return null;
    }

    // Uso da asSubclass para fazer o cast seguro de um tipo de token limitado
    static Annotation getAnnotation(AnnotatedElement element,
                                    String annotationTypeName) {
        Class<?> annotationType = null; // Unbounded type token (ilimitado)
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(annotationType.asSubclass(Annotation.class));
    }

}
