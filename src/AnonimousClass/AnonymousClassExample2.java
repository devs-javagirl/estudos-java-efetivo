package AnonimousClass;

// Uso da classe anônima para estender a classe
public class AnonymousClassExample2 {
    public static void main(String[] args) {
        Animal myAnimal = new Animal() {
            @Override
            public void makeSound() {
                System.out.println("Woof!");
            }
        };

        myAnimal.makeSound(); // Output: Woof!
    }
}
