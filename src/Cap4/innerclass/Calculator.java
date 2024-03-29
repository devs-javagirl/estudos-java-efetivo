package Cap4.innerclass;

public class Calculator {
    // Classe aninhada estática para representar as operações suportadas pela calculadora
    public static class Operation {
        public static final Operation ADD = new Operation("ADD");
        public static final Operation SUBTRACT = new Operation("SUBTRACT");
        public static final Operation MULTIPLY = new Operation("MULTIPLY");
        public static final Operation DIVIDE = new Operation("DIVIDE");

        private final String operationName;

        // Construtor privado para evitar instanciação externa
        private Operation(String operationName) {
            this.operationName = operationName;
        }

        // Método para obter o nome da operação
        public String getOperationName() {
            return operationName;
        }
    }

    // Método da calculadora que realiza uma operação
    public static double performOperation(double num1, double num2, Operation operation) {
        switch (operation.getOperationName()) {
            case "ADD":
                return num1 + num2;
            case "SUBTRACT":
                return num1 - num2;
            case "MULTIPLY":
                return num1 * num2;
            case "DIVIDE":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    // Exemplo de uso da calculadora
    public static void main(String[] args) {
        double num1 = 10;
        double num2 = 5;

        // Realizando algumas operações utilizando a classe aninhada estática
        System.out.println("Addition: " + performOperation(num1, num2, Operation.ADD));
        System.out.println("Subtraction: " + performOperation(num1, num2, Operation.SUBTRACT));
        System.out.println("Multiplication: " + performOperation(num1, num2, Operation.MULTIPLY));
        System.out.println("Division: " + performOperation(num1, num2, Operation.DIVIDE));
    }
}

/**
 * Neste exemplo:
 *
 * A classe Calculator possui uma classe aninhada estática chamada Operation, que define quatro operações matemáticas suportadas pela calculadora: adição, subtração, multiplicação e divisão.
 * Cada operação é representada por uma instância estática da classe Operation, criada como campos públicos estáticos.
 * O método performOperation() realiza uma operação matemática com base nos números fornecidos e na operação especificada.
 * No método main, exemplificamos o uso da calculadora realizando várias operações com números diferentes.
 * Este exemplo demonstra como uma classe aninhada estática pode ser útil para definir constantes relacionadas a uma classe envolvente, promovendo a organização e a legibilidade do código.
 */

