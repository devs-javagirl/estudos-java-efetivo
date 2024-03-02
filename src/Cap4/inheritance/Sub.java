package Cap4.inheritance;

import java.time.Instant;

public class Sub extends Super {

    private final Instant instant;

    public Sub() {
        super();
        this.instant = Instant.now();
    }

    @Override
    public void overrideMe() {
        System.out.println(instant);
    }

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();
    }

}
