package Cap8;

import java.util.Objects;

public class Item_49_ValidParameters {

    private static void calculateSum (long[] a, int offset, int length) {
        long result = 0;
        StringBuilder operation = new StringBuilder();

        // Para que as assertions abaixo sejam lançadas
        // Configurar na execução do IntelliJ, modify options, VM options
        // adicionar o parâmetro -ea ou -enableassertions

        assert a != null: "O array não pode ser nulo";
        assert offset >= 0 && offset <= a.length: "Offset inválido";
        assert length >= 0 && length <= a.length - offset: "Length inválido";

        for (int i = offset; i <=  length; i++) {
            result = result + a[i];
            operation.append(a[i]);
            operation.append(" + ");
        }

        operation.append(" = ");
        operation.append(result);
        System.out.println(operation);
    }


    private static int mod(int x, int y) {
        if (y <= 0) {
            throw new IllegalArgumentException("Divisor deve ser positivo.");
        }
        return x % y;
    }

    private static void validateParameter(Integer parameter){
        parameter = Objects.requireNonNull(parameter, "Parâmetro 'parameter' não pode ser nulo");
        System.out.println("Parâmetro válido " + parameter);

    }

    public static void main(String[] args) {
        long[] numbers = {1l, 4l, 2l, 5l};
        int offset = 7;
        int length = 2;

        calculateSum(numbers, offset, length);

        // Lança exceção Exception in thread "main" java.lang.IllegalArgumentException: Divisor deve ser positivo.
        mod(10, -12);

        // Lança exceção Exception in thread "main" java.lang.NullPointerException: Parâmetro 'parameter' não pode ser nulo
        validateParameter(null);




    }
}
