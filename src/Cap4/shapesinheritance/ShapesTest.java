package Cap4.shapesinheritance;

public class ShapesTest {
    public static void main(String[] args) {
        Circle circle = new Circle("circle", 5);
        Square square = new Square("square", 4);

        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        System.out.println("Square Area: " + square.calculateArea());
        System.out.println("Square Perimeter: " + square.calculatePerimeter());
    }
}
