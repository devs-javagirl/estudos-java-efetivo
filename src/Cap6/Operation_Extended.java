package Cap6;

public enum Operation_Extended implements Operation_ {
    EXP("^") {
        public double apply (double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply (double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    Operation_Extended(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
