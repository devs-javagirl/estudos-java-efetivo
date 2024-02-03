package Cap3.comparable.phone;

import static java.util.Comparator.comparingInt;

import java.util.Comparator;

public class PhoneStaticComparable implements Comparable<PhoneStaticComparable>{
  private final Short areaCode;
  private final Short prefix;
  private final Long lineNumber;

  public PhoneStaticComparable(Short areaCode, Short prefix, Long lineNumber) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNumber = lineNumber;
  }

  @Override
  public String toString() {
    return "PhoneStaticComparable{" +
        "areaCode: " + areaCode +
        ", prefix: " + prefix +
        ", lineNumber: " + lineNumber +
        '}';
  }

  private static final Comparator<PhoneStaticComparable> COMPARATOR =
      comparingInt((PhoneStaticComparable phoneStaticComparable) -> phoneStaticComparable.areaCode)
          .thenComparing(phoneStaticComparable -> phoneStaticComparable.prefix)
          .thenComparing(phoneStaticComparable -> phoneStaticComparable.lineNumber);

  @Override
  public int compareTo(PhoneStaticComparable phoneStaticComparable) {
    return COMPARATOR.compare(this, phoneStaticComparable);
  }
}
