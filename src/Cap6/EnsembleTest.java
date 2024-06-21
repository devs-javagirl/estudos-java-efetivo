package Cap6;

public class EnsembleTest {
    public static void main(String[] args) {
        for (Ensemble2 e : Ensemble2.values()) {
            System.out.printf("%s has %d musicians%n", e, e.numberOfMusicians());
        }
    }
}
