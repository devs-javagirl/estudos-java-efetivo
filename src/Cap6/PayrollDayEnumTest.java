package Cap6;

public class PayrollDayEnumTest {

  public static void main(String[] args) {
    int minsWorked = 500;
    int payRate = 5;

    System.out.println(PayrollDayEnum.MONDAY.pay(minsWorked, payRate));
    System.out.println(PayrollDayEnum.SATURDAY.pay(minsWorked, payRate));

  }

}
