package Cap4.shapesinheritance;

// Classe concreta para representar um círculo
public class Circle extends Shape {
    private final double radius;

    // Construtor
    public Circle(String tag, double radius) {
        super(tag);
        this.radius = radius;
    }

    // Implementação do método para calcular a área do círculo
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Implementação do método para calcular o perímetro do círculo
    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

