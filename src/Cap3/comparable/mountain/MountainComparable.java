package Cap3.comparable.mountain;

import java.util.Objects;

public class MountainComparable implements Comparable<MountainComparable>{
  private String name;
  private int height;

  public MountainComparable(String name, int height) {
    this.name = name;
    this.height = height;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  @Override
  public String toString() {
    return name + " " + height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MountainComparable mountain = (MountainComparable) o;
    return name.equalsIgnoreCase(mountain.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public int compareTo(MountainComparable mountain) {
    return Integer.compare(height, mountain.height);

  }
}
