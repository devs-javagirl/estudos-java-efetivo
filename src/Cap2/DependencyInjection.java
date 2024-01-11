package Cap2;

import java.util.regex.Pattern;

public class DependencyInjection {

    // Classe Engine
    public static class Engine {
        public void start() {
            System.out.println("Engine started");
        }
    }

    // Classe Car com injeção de dependência via construtor
    public static class Car {
        private Engine engine;

        public Car(Engine engine) {
            this.engine = engine;
        }

        public void startCar() {
            engine.start();
            System.out.println("Car is running");
        }
    }

}
