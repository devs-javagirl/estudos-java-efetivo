package Cap4;

public class UsuarioSistema {

    // Atributos privados para encapsular os dados do usuário
    private final String nomeUsuario;
    private String senha;
    private boolean autenticado;

    // Construtor da classe
    public UsuarioSistema(String nomeUsuario, String senha) {
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.autenticado = false; // Inicialmente o usuário não está autenticado
    }

    // Método público para autenticar o usuário
    public void autenticar(String senha) {
        if (this.senha.equals(senha)) {
            this.autenticado = true;
            System.out.println("Usuário autenticado com sucesso!");
        } else {
            System.out.println("Senha incorreta. Autenticação falhou.");
        }
    }

    // Método público para verificar se o usuário está autenticado
    public boolean estaAutenticado() {
        return this.autenticado;
    }

    // Método público para obter o nome do usuário
    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    // Método privado para alterar a senha do usuário
    private void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso.");
    }

    // Método público para permitir que o usuário altere sua própria senha (após autenticação)
    public void alterarSenhaUsuario(String senhaAtual, String novaSenha) {
        if (estaAutenticado() && this.senha.equals(senhaAtual)) {
            alterarSenha(novaSenha);
        } else {
            System.out.println("Não foi possível alterar a senha. Autenticação necessária ou senha atual incorreta.");
        }
    }
}

