package Cap12;

import java.io.*;

class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String senha; // Senha não protegida!

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{nome='" + nome + "', senha='" + senha + "'}";
    }
}

public class FalhaSeguranca {
    public static void main(String[] args) {
        //Usuario usuario = new Usuario("admin", "1234");

        /*
        // Serializar usuário
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("usuario.ser"))) {
            out.writeObject(usuario);
        } catch (IOException e) {
            e.printStackTrace();
        }

         */

        // Modificar o arquivo manualmente e desserializar (Simulando um ataque)
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("usuario.ser"))) {
            Usuario usuarioHackeado = (Usuario) in.readObject();
            System.out.println("Usuário comprometido: " + usuarioHackeado);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
