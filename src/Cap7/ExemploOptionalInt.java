package Cap7;

import java.util.OptionalInt;

public class ExemploOptionalInt {
    public static OptionalInt buscarIdade(String nome) {
        if (nome.equals("João")) {
            return OptionalInt.of(30);
        }
        return OptionalInt.empty();  // Retorna OptionalInt vazio se o nome não for "João"
    }

    public static void main(String[] args) {
        OptionalInt idade = buscarIdade("Maria");

        if (idade.isPresent()) {
            System.out.println("Idade encontrada: " + idade.getAsInt());
        } else {
            System.out.println("Idade não encontrada");
        }
    }
}
