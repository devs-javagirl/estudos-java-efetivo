package Cap6;

public class OperationEnumTest {

  public static void main(String[] args) {
    double x = 2;
    double y = 4;

    for (OperationEnum op: OperationEnum.values()) {
      System.out.printf("%f %s %f = %f%n",
          x, op, y, op.apply(x, y));
      ;
    }

    System.out.println(OperationEnum.valueOf("PLUS"));

    System.out.println(OperationEnum.fromString("-").orElse(OperationEnum.PLUS).name());
  }
}
