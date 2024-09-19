package Cap7;

import java.util.Optional;

public class ExemploOrElseThrow {
    public static Optional<Integer> buscarIdade(String nome) {
        if (nome.equals("João")) {
            return Optional.of(30);
        }
        return Optional.empty();  // Retorna Optional vazio se o nome não for "João"
    }

    public static void main(String[] args) {
        Optional<Integer> idade = buscarIdade("João");

        // Lança uma exceção se o valor não estiver presente
        int valorIdade = idade.orElseThrow(() -> new IllegalArgumentException("Idade não encontrada!"));
        System.out.println("Idade: " + valorIdade);
    }
}
