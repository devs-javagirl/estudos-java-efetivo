package Cap6;

public class OperationEnumTest {

  public static void main(String[] args) {
    double x = 4.5;
    double y = 6.5;

    for (OperationEnum op: OperationEnum.values()) {
      System.out.printf("%f %s %f = %f%n",
          x, op, y, op.apply(x, y));
    }
  }
}
