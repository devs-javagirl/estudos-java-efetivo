import Cap2.*;

import java.util.ArrayList;
import java.util.List;


public class MainCap2 {
    public static void main(String[] args) {

        System.out.println("Hello and welcome Devas!");

        /** ITEM 2  */
        Stack stack = new Stack();
        stack.push(new String("Um"));
        stack.push(new String("Dois"));
        stack.push(new String("Tres"));
        System.out.println(stack.pop().toString());
        System.out.println(stack.pop().toString());
        System.out.println(stack.pop().toString());

        /** ITEM 5 */
        DependencyInjection.Engine carEngine = new DependencyInjection.Engine(); // Crie uma instância de Engine
        DependencyInjection.Car myCar = new DependencyInjection.Car(carEngine); // Injete a dependência (Engine) no construtor de Car
        myCar.startCar(); // Inicialize o carro

        /** ITEM 6 */
        Person1 person1 = Person1.createPerson("Alice", 30);

        Person2 person2 = new Person2.Builder("Alice", "Johnson")
                .age(30)
                .address("123 Main St")
                .build();


        /** ITEM 7 */
        List<String> lista = new ArrayList<>();
        lista.add("Objeto 1");
        lista.add("Objeto 2");

        String objetoRemovido = lista.remove(0);
        objetoRemovido = null;


        /** ITEM 8 Fechamento de Recursos com Cleaner */
        new Room(10).close();

        try(Room myRoom = new Room(7)) {
            System.out.println("goodbye");
        }

        /** ITEM 9 Fechamento de Recursos com Try-With-Resources */
    }
}
