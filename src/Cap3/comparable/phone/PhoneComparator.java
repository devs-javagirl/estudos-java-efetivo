package Cap3.comparable.phone;

import java.util.Comparator;

public class PhoneComparator implements Comparator<PhoneComparator> {
  private final Short areaCode;
  private final Short prefix;
  private final Long lineNumber;

  public PhoneComparator(Short areaCode, Short prefix, Long lineNumber) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNumber = lineNumber;
  }

  @Override
  public String toString() {
    return "PhoneComparator{" +
        "areaCode: " + areaCode +
        ", prefix: " + prefix +
        ", lineNumber: " + lineNumber +
        '}';
  }

  @Override
  public int compare(PhoneComparator phone1, PhoneComparator phone2) {
    int result = Short.compare(phone1.areaCode, phone2.areaCode);
    if (result == 0) {
      result = Short.compare(phone1.prefix, phone2.prefix);
      if (result == 0) {
        result = Long.compare(phone1.lineNumber, phone2.lineNumber);
      }
    }
    return result;

  }

}
