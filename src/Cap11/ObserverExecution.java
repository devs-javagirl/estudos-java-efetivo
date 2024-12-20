package Cap11;

import java.util.HashSet;

public class ObserverExecution {
    public static void main(String[] args) {
        ObservableSet<Integer> set = new ObservableSet<>(new HashSet<>());
        //populateSet(set);
        populateWithRemove(set);
    }

    private static void populateSet(ObservableSet<Integer> set) {

        //DEFINIÇÃO DO COMPORTAMENTO DO OBSERVADOR
        set.addObserver((s, e) -> System.out.println("tamanho " + s.size() + " elemento " + e));

        for (int i = 0; i < 100; i++)
            set.add(i);
    }

    private static void populateWithRemove(ObservableSet<Integer> set) {
        set.addObserver(new SetObserver<>() {
            public void added(ObservableSet<Integer> s, Integer e) {
                System.out.println(e);
                if (e == 23) {
                    System.out.println("removing item 23");
                    s.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++)
            set.add(i);
    }
}
