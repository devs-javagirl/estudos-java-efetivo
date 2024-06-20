package Cap6;

import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public enum OperationEnum {
  PLUS("+") {
    public double apply(double x, double y) { return x + y;}
  },
  MINUS("-") {
    public double apply(double x, double y) { return x - y;}
  },
  TIMES("*") {
    public double apply(double x, double y) { return x * y;}
  },
  DIVIDE("/") {
    public double apply(double x, double y) { return x / y;}
  };

  private final String symbol;

  OperationEnum(String symbol) {
    this.symbol = symbol;

  }

  @Override
  public String toString() {
    return symbol;
  }

  private static final Map<String, OperationEnum> stringToEnum =
      Stream.of(values()).collect(
          toMap(Object::toString, e -> e));

  public static Optional<OperationEnum> fromString(String symbol) {
    return Optional.ofNullable(stringToEnum.get(symbol));
  }
  public abstract double apply(double x, double y);

}
