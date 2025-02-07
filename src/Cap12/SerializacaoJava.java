package Cap12;

import java.io.*;

// Classe serializável
class Pessoa2 implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private int idade;

    public Pessoa2(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + nome + "', idade=" + idade + "}";
    }
}

public class SerializacaoJava {
    public static void main(String[] args) {
        Pessoa2 pessoa = new Pessoa2("João", 30);

        // Serializar em arquivo
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pessoa.ser"))) {
            out.writeObject(pessoa);
            System.out.println("Objeto serializado: " + pessoa);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Desserializar do arquivo
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pessoa.ser"))) {
            Pessoa pessoaLida = (Pessoa) in.readObject();
            System.out.println("Objeto desserializado: " + pessoaLida);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
