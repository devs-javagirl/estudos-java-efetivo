package Cap6.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Define a anotação @Testy
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Testy {

}
