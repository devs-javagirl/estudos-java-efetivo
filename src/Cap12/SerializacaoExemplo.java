package Cap12;

import java.io.*;

// Classe serializável
class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L; // UID para manter compatibilidade
    private String nome;
    private int idade;

    private String email; // Novo campo adicionado


    public Pessoa(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + ", email='" + email + "'}";
    }
}

public class SerializacaoExemplo {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 30, "teste@gmail.com");

        // Serializar objeto
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pessoa.ser"))) {
            out.writeObject(pessoa);
            System.out.println("Objeto serializado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Desserializar objeto
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pessoa.ser"))) {
            Pessoa pessoaLida = (Pessoa) in.readObject();
            System.out.println("Objeto desserializado: " + pessoaLida);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
