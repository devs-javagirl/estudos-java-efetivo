package Cap3.comparable.phone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPhoneComparator {

  public static void main(String[] args) {
    PhoneComparator phoneComparator1 = new PhoneComparator(Short.parseShort("51"),
        Short.parseShort("21"), 984631991L);
    PhoneComparator phoneComparator2 = new PhoneComparator(Short.parseShort("55"),
        Short.parseShort("34"), 982392930L);
    PhoneComparator phoneComparator3 = new PhoneComparator(Short.parseShort("55"),
        Short.parseShort("11"), 984631991L);
    PhoneComparator phoneComparator4 = new PhoneComparator(Short.parseShort("40"),
        Short.parseShort("10"), 972430493L);

    List<PhoneComparator> phones = new ArrayList<>();
    phones.add(phoneComparator1);
    phones.add(phoneComparator2);
    phones.add(phoneComparator3);
    phones.add(phoneComparator4);

    Collections.sort(phones, phoneComparator1);
    System.out.println("Telefones ordenados por Comparator: " + phones);

  }

}
