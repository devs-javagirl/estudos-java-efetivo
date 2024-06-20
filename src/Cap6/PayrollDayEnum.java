package Cap6;

public enum PayrollDayEnum {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY,
  SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);

  private final PayType payType;

  PayrollDayEnum(PayType payType) {
    this.payType = payType;
  }

  PayrollDayEnum() {
    this(PayType.WEEKDAY); //Padrão
  }

  int pay(int minutesWorked, int payRate){
    return payType.pay(minutesWorked, payRate);

  }
  private enum PayType {
    WEEKDAY {
      int overtimePay(int minsWorked, int payRate) {
        return minsWorked <= MINS_PER_SHIFT ? 0:
            ((minsWorked - MINS_PER_SHIFT) * payRate) / 2;
      }
    },
    WEEKEND {
      int overtimePay(int minsWorked, int payRate) {
        return (minsWorked * payRate) / 2;
      }
    };

    abstract int overtimePay(int mins, int payRate);
    private static final int MINS_PER_SHIFT = 8 * 60;

    int pay(int minsWorked, int payRate) {
      int basePay = minsWorked * payRate;
      return basePay + overtimePay(minsWorked, payRate);
    }
  }
}
