package Cap3.comparable.mountain;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class SortMountainsComparator {

  LinkedList<Mountain> mountains = new LinkedList<>();

  class NameCompare implements Comparator<Mountain> {

    @Override
    public int compare(Mountain one, Mountain two) {
      return one.getName().compareTo(two.getName());
    }
  }
  static class HeightCompare implements Comparator<Mountain> {

    @Override
    public int compare(Mountain one, Mountain two) {
      return Integer.compare(one.getHeight(), two.getHeight());
    }
  }

  public static void main(String[] args) {
    new SortMountainsComparator().go();
  }

  public void go () {
    mountains.add(new Mountain("Longs", 14255));
    mountains.add(new Mountain("lONGS", 13001));
    mountains.add(new Mountain("Elbert", 14433));
    mountains.add(new Mountain("Maroon", 14156));
    mountains.add(new Mountain("Castle", 14265));

    System.out.println("as entered: \n" + mountains);

    NameCompare nameCompare = new NameCompare();
    Collections.sort(mountains, nameCompare);
    System.out.println("by name: \n" + mountains);

    HeightCompare heightCompare = new HeightCompare();
    mountains.sort(heightCompare);
    System.out.println("by height: \n" + mountains);

    Mountain mountain1 = new Mountain("Longs", 14255);
    Mountain mountain2 = new Mountain("lONGS", 14405);

    System.out.println(String.format(
        "mountain1 (%s) equals mountain2 (%s)-> result %s",
        mountain1,
        mountain2,
        mountain1.equals(mountain2)));

  }
}
