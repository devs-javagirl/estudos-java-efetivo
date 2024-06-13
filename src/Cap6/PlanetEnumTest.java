package Cap6;

public class PlanetEnumTest {

  public static void main(String[] args) {
    double earthWeight = 30.0;
    double mass = earthWeight / PlanetEnum.EARTH.getSurfaceGravity();
    for (PlanetEnum p : PlanetEnum.values()) {
      System.out.printf("Weight on %s is %f%n",
          p, p.getSurfaceWeight(mass));
    }
  }

}
