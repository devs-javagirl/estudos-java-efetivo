package Cap12;

import java.io.*;

class Pessoa1 implements Serializable {

    private String nome;
    private int idade;
    private transient String email; // Novo campo adicionado

    public Pessoa1(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + ", email='" + email + "'}";
    }
}

public class SerializacaoProblema {
    public static void main(String[] args) {
        // Tentativa de desserializar um objeto criado antes da adição do campo 'email'
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pessoa.ser"))) {
            Pessoa pessoaLida = (Pessoa) in.readObject();
            System.out.println("Objeto desserializado: " + pessoaLida);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
