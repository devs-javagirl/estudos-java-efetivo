package Cap7;

import java.util.Optional;

public class ExemploOrElseThrow {
    public static Optional<Integer> buscarIdade(String nome) {
        if (nome.equals("Jo�o")) {
            return Optional.of(30);
        }
        return Optional.empty();  // Retorna Optional vazio se o nome n�o for "Jo�o"
    }

    public static void main(String[] args) {
        Optional<Integer> idade = buscarIdade("Jo�o");

        // Lan�a uma exce��o se o valor n�o estiver presente
        int valorIdade = idade.orElseThrow(() -> new IllegalArgumentException("Idade n�o encontrada!"));
        System.out.println("Idade: " + valorIdade);
    }
}
