package Cap6;

import java.util.HashSet;
import java.util.Set;

enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL}


public class LifeCycleOrdinal {

    static class Plant {
        String name;
        LifeCycle lifeCycle;

        Plant(String name, LifeCycle lifeCycle) {
            this.name = name;
            this.lifeCycle = lifeCycle;
        }
    }

    public static void main(String[] args) {

        // Jardim com plantas
        Plant[] garden = {
                new Plant("Rose", LifeCycle.PERENNIAL),
                new Plant("Carrot", LifeCycle.BIENNIAL),
                new Plant("Lettuce", LifeCycle.ANNUAL)
        };

        // Arrays para categorizar plantas por ciclo de vida
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        for (Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        // Imprime as plantas por ciclo de vida
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

}
