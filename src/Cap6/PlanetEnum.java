package Cap6;

public enum PlanetEnum {
  MERCURY(3.30, 2.43),
  VENUS(4.86, 6.052),
  EARTH(5.97, 6.37),
  MARS(6.41, 3.39),
  JUPITER(1.89, 7.14),
  SATURN(5.68, 6.02),
  URANUS(8.68, 2.55),
  NEPTUNE(1.02, 2.47);

  private final double mass;
  private final double radius;
  private final double surfaceGravity;

  private static final double G = 6.67;

  PlanetEnum(double mass, double radius) {
    this.mass = mass;
    this.radius = radius;
    surfaceGravity = G * mass / (radius * radius);
  }

  public double mass(){
    return mass;
  }

  public double radius() {
    return radius;
  }

  public double getSurfaceGravity() {
    return surfaceGravity;
  }
  public double getSurfaceWeight(double mass) {
    return mass * surfaceGravity;
  }

}

