package Cap6;

import org.junit.jupiter.api.Test;

public class Annotation {

    @Test
    public void m1() {}
    public void m2() {}
    @Test
    public void m3() {
        throw new RuntimeException("Boom");
    }

    public void m4() {}

    @Test
    public void m5(){}

    public void m6() {}

    @Test
    public void m7() {
        throw new RuntimeException("Crash");
    }


    public void m8(){}



}
