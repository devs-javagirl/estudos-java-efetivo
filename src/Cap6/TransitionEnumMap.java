package Cap6;

import java.util.EnumMap;
import java.util.Map;

public class TransitionEnumMap {
    enum Phase { SOLID, LIQUID, GAS }

    enum Transition {
        MELT(Phase.SOLID, Phase.LIQUID),
        FREEZE(Phase.LIQUID, Phase.SOLID),
        BOIL(Phase.LIQUID, Phase.GAS),
        CONDENSE(Phase.GAS, Phase.LIQUID);

        private final Phase from;
        private final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>> map = new EnumMap<>(Phase.class);

        static {
            for (Phase p : Phase.values()) {
                map.put(p, new EnumMap<>(Phase.class));
            }
            for (Transition trans : Transition.values()) {
                map.get(trans.from).put(trans.to, trans);
            }
        }

        public static Transition from(Phase from, Phase to) {
            return map.get(from).get(to);
        }
    }

    public static void main(String[] args) {
        // Uso
        Phase from = Phase.SOLID;
        Phase to = Phase.LIQUID;
        System.out.println(Transition.from(from, to));  // Output: MELT
    }
}
