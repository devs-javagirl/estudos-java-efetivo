package Cap12;

import java.io.*;

class UsuarioSeguro implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private transient String senha; // Agora a senha não será serializada

    public UsuarioSeguro(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(encrypt(senha)); // Salva senha criptografada
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        senha = decrypt((String) in.readObject()); // Recupera senha descriptografada
    }

    private String encrypt(String senha) {
        return senha == null ? null : new StringBuilder(senha).reverse().toString(); // Simples inversão
    }

    private String decrypt(String senhaCriptografada) {
        return senhaCriptografada == null ? null : new StringBuilder(senhaCriptografada).reverse().toString();
    }

    @Override
    public String toString() {
        return "UsuarioSeguro{nome='" + nome + "', senha='" + senha + "'}";
    }
}

public class SegurancaCorrigida {
    public static void main(String[] args) {
        UsuarioSeguro usuario = new UsuarioSeguro("admin", "1234");

        // Serializar
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuarioSeguro.ser"))) {
            out.writeObject(usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Desserializar
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuarioSeguro.ser"))) {
            UsuarioSeguro usuarioLido = (UsuarioSeguro) in.readObject();
            System.out.println("Usuário seguro: " + usuarioLido);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
