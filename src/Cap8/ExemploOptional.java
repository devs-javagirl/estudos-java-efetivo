package Cap8;


import java.util.Optional;

public class ExemploOptional {
    public static Optional<String> encontrarNome(String[] nomes, String nomeBuscado) {
        for (String nome : nomes) {
            if (nome.equalsIgnoreCase(nomeBuscado)) {
                return Optional.of(nome);
            }
        }
        return Optional.empty();  // Retorna Optional vazio se n�o encontrar o nome
    }

    public static void main(String[] args) {
        String[] nomes = {"Jo�o", "Maria", "Ana"};
        Optional<String> nomeEncontrado = encontrarNome(nomes, "Joana");

        nomeEncontrado.ifPresent(nome -> System.out.println("Nome encontrado: " + nome));
        System.out.println(nomeEncontrado.orElse("Nome n�o encontrado"));
    }
}
