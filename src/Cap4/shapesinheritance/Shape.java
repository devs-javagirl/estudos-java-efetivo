package Cap4.shapesinheritance;

// Classe abstrata para representar uma forma geométrica
public abstract class Shape {
    private final String tag;

    // Construtor
    public Shape(String tag) {
        this.tag = tag;
    }

    // Método para obter a tag da forma
    public String getTag() {
        return tag;
    }

    // Método abstrato para calcular a área da forma
    public abstract double calculateArea();

    // Método abstrato para calcular o perímetro da forma
    public abstract double calculatePerimeter();
}
