package Cap6;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

enum LifeCycle2 { ANNUAL, PERENNIAL, BIENNIAL }
public class LifeCycleEnumMap {

    static class Plant2 {
        String name;
        LifeCycle lifeCycle;

        Plant2(String name, LifeCycle lifeCycle) {
            this.name = name;
            this.lifeCycle = lifeCycle;
        }
    }

    public static void main(String[] args) {
        // Jardim com plantas
        Plant2[] garden = {
                new Plant2("Rose", LifeCycle.PERENNIAL),
                new Plant2("Carrot", LifeCycle.BIENNIAL),
                new Plant2("Lettuce", LifeCycle.ANNUAL)
        };

        // EnumMap para categorizar plantas por ciclo de vida
        Map<LifeCycle, Set<Plant2>> plantsByLifeCycle = new EnumMap<>(LifeCycle.class);
        for (LifeCycle lc : LifeCycle.values()) {
            plantsByLifeCycle.put(lc, new HashSet<>());
        }

        for (Plant2 p : garden) {
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        }

        // Imprime as plantas por ciclo de vida
        for (Map.Entry<LifeCycle, Set<Plant2>> entry : plantsByLifeCycle.entrySet()) {
            System.out.printf("%s: %s%n", entry.getKey(), entry.getValue());
        }
    }

}
