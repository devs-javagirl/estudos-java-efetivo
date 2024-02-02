package Cap3.comparable;

public class Usuario1 implements Comparable {

    private String name;

    private String email;

    private String nascimento;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public Usuario1(String name, String email, String nascimento) {
        this.name = name;
        this.email = email;
        this.nascimento = nascimento;
    }

    @Override
    public int compareTo(Object o) {
        Usuario1 usuario = (Usuario1) o;
        int resultado = this.nascimento.compareTo(usuario.nascimento);
        return resultado;
    }

    @Override
    public String toString() {
        return "\nUsuario1{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nascimento=" + nascimento +
                '}';
    }
}
