package Cap6;

public class EnumTransition {
    enum Phase { SOLID, LIQUID, GAS }

    enum Transition {
        MELT, FREEZE, BOIL, CONDENSE;

        private static final Transition[][] TRANSITIONS = {
                { null, MELT, null },       // SOLID to LIQUID
                { FREEZE, null, BOIL },     // LIQUID to SOLID or GAS
                { null, CONDENSE, null }    // GAS to LIQUID
        };

        public static Transition from(Phase from, Phase to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }

        public static void main(String[] args) {
            // Uso
            Phase from = Phase.SOLID;
            Phase to = Phase.LIQUID;
            System.out.println(Transition.from(from, to));  // Output: MELT
        }
    }

}
