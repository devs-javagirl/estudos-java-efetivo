package AnonimousClass;


// Uso da classe anônima para implementar a interface
public class AnonymousClassExample1 {
    public static void main(String[] args) {
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("Hello, World!");
            }
        };

        greeting.sayHello(); // Output: Hello, World!
    }
}


