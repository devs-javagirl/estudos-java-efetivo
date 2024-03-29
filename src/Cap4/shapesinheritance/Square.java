package Cap4.shapesinheritance;

// Classe concreta para representar um quadrado
public class Square extends Shape {
    private final double side;

    // Construtor
    public Square(String tag, double side) {
        super(tag);
        this.side = side;
    }

    // Implementação do método para calcular a área do quadrado
    @Override
    public double calculateArea() {
        return side * side;
    }

    // Implementação do método para calcular o perímetro do quadrado
    @Override
    public double calculatePerimeter() {
        return 4 * side;
    }
}
