package Cap3.comparable.phone;

import java.util.TreeSet;

public class SortPhoneStaticComparable {

  public static void main(String[] args) {
    PhoneStaticComparable phoneStaticComparable1 = new PhoneStaticComparable(Short.parseShort("51"),
            Short.parseShort("21"), 984631991L);
    PhoneStaticComparable phoneStaticComparable2 = new PhoneStaticComparable(Short.parseShort("55"),
            Short.parseShort("34"), 982392930L);
    PhoneStaticComparable phoneStaticComparable3 = new PhoneStaticComparable(Short.parseShort("55"),
            Short.parseShort("11"), 984631991L);

    TreeSet<PhoneStaticComparable> phones = new TreeSet<>();
    phones.add(phoneStaticComparable1);
    phones.add(phoneStaticComparable2);
    phones.add(phoneStaticComparable3);

    System.out.println("Telefones ordenados por Static Comparable: " + phones);
  }


}
