package Cap6;

public enum PhaseOrdinal {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

        private static final Transition [][] TRANSITIONS = {
                { null, MELT, SUBLIME },
                { FREEZE, null, BOIL },
                { DEPOSIT, CONDENSE, null}
        };

        public static Transition from(PhaseOrdinal from, PhaseOrdinal to) {
            return TRANSITIONS[from.ordinal()][to.ordinal()];
        }
    }

    public static void main(String[] args) {
        System.out.println(Transition.from(SOLID, LIQUID));
        System.out.println(Transition.from(LIQUID, GAS));
        System.out.println(Transition.from(SOLID, GAS));
        System.out.println(Transition.from(SOLID, SOLID));
    }
}
