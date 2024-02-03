package Cap3.comparable.phone;

public class PhoneComparable implements Comparable<PhoneComparable>{
  private final Short areaCode;
  private final Short prefix;
  private final Long lineNumber;

  public PhoneComparable(Short areaCode, Short prefix, Long lineNumber) {
    this.areaCode = areaCode;
    this.prefix = prefix;
    this.lineNumber = lineNumber;
  }

  @Override
  public String toString() {
    return "PhoneComparable{" +
        "areaCode: " + areaCode +
        ", prefix: " + prefix +
        ", lineNumber: " + lineNumber +
        '}';
  }

  @Override
  public int compareTo(PhoneComparable phoneComparable) {
    int result = Short.compare(areaCode, phoneComparable.areaCode);
    if(result == 0) {
      result = Short.compare(prefix, phoneComparable.prefix);
      if (result == 0) {
        result = Long.compare(lineNumber, phoneComparable.lineNumber);
      }
    }
    return result;
  }


}
