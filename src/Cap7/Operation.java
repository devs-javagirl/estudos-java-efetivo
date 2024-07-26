package Cap7;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS("+",(x, y) -> x + y),
    MINUS("-",(x, y) -> x - y),
    TIMES("*",(x, y) -> x * y),
    DIVIDE("/",(x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator operation;

    Operation(String symbol,DoubleBinaryOperator operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public double apply(double x, double y) {
        return operation.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }
}

