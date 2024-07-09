package Cap6.annotations;

import java.util.ArrayList;
import java.util.List;

public class Sample3 {
    @ExceptionTestArray({ IndexOutOfBoundsException.class, NullPointerException.class })
    public static void doublyBad() {
        List<String> list = new ArrayList<>();
        list.addAll(5, null); // Deve lançar IndexOutOfBoundsException ou NullPointerException
    }
}
