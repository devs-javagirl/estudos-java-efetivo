package Cap3.comparable.phone;

import java.util.TreeSet;

public class SortPhoneComparable {

  public static void main(String[] args) {
    PhoneComparable phone1 = new PhoneComparable(
        Short.parseShort("51"),
        Short.parseShort("21"), 984631991L);
    PhoneComparable phone2 = new PhoneComparable(
        Short.parseShort("55"),
        Short.parseShort("34"), 982392930L);
    PhoneComparable phone3 = new PhoneComparable(
        Short.parseShort("55"),
        Short.parseShort("11"), 984631991L);

    TreeSet<PhoneComparable> phones = new TreeSet<>();
    phones.add(phone1);
    phones.add(phone2);
    phones.add(phone3);

    System.out.println("Telefones ordenados por Comparable: " + phones);

  }

}
