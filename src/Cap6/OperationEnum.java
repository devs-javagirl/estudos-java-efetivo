package Cap6;

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

  public abstract double apply(double x, double y);

}
