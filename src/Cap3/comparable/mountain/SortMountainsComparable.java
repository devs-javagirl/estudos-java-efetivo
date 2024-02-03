package Cap3.comparable.mountain;

import java.util.Collections;
import java.util.LinkedList;

public class SortMountainsComparable {

  LinkedList<MountainComparable> mountains = new LinkedList<>();

  public static void main(String[] args) {
    new SortMountainsComparable().go();
  }

  public void go () {
    mountains.add(new MountainComparable("Longs", 14255));
    mountains.add(new MountainComparable("Elbert", 14433));
    mountains.add(new MountainComparable("Maroon", 14156));
    mountains.add(new MountainComparable("Castle", 14265));

    System.out.println("as entered: \n" + mountains);

    Collections.sort(mountains);
    System.out.println("by height: \n" + mountains);

  }
}
